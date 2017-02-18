package tbdp.es.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.ElasticSearchDruidDataSourceFactory;
import com.ibatis.common.resources.Resources;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class EsSqlClient {

    private static final EsSqlClient client = new EsSqlClient();
    private DruidDataSource dataSource;
    private Properties properties;

    private EsSqlClient() {
        initClient();
    }

    private void initClient() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            this.properties = properties;

            String index = properties.getProperty("es_index");
            String baseUrl = properties.getProperty("es_url");
            String url = String.format("jdbc:elasticsearch://%s/%s", baseUrl, index);
            Properties esProperties = new Properties();
            esProperties.put("url", url);
            dataSource = (DruidDataSource) ElasticSearchDruidDataSourceFactory
                .createDataSource(esProperties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EsSqlClient instance() {
        return client;
    }

    public ResultSet query(String sql) throws Exception {
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        List<String> result = new ArrayList<String>();
        return resultSet;
    }


    public List<Map<String, String>> query(String sql, String... columns) throws Exception {
        ResultSet resultSet = query(sql);
        List<Map<String, String>> dataResult = new LinkedList<>();
        while (resultSet.next()) {
            Map<String, String> dataMap = new HashMap<>();
            for (String column : columns) {
                dataMap.put(column, resultSet.getString(column));
            }
            dataResult.add(dataMap);
        }
        return dataResult;
    }
}
