package tbdp.resources;

import org.apache.log4j.Logger;
import tbdp.common.Result;
import tbdp.common.result.EmployResult;
import tbdp.model.Employee;
import tbdp.model.Employees;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by xbkaishui on 17/2/13.
 */
@Path("/employees") public class EmployResource {
    private static final Logger logger = Logger.getLogger(EmployResource.class);
    static Employees list = new Employees();

    static {
        list.setEmployeeList(new ArrayList<Employee>());

        list.getEmployeeList().add(new Employee(1, "Lokesh Gupta"));
        list.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey"));
        list.getEmployeeList().add(new Employee(3, "David Kameron"));
    }

    @GET @Produces(MediaType.APPLICATION_JSON) public Employees getAllEmployees() {
        return list;
    }

    @GET @Path("{id}") public Employee get(@PathParam("id") String id) {
        return new Employee(Integer.valueOf(id), "emp" + id);
    }

    @GET @Path("/rs") @Produces(MediaType.APPLICATION_JSON) public Result rs() {
        logger.info("result");
        return new Result();
    }

    @GET @Path("/rss") @Produces(MediaType.APPLICATION_JSON) public EmployResult rss() {
        EmployResult result = new EmployResult();
        String id = "11";
        result.setEmployee((new Employee(Integer.valueOf(id), "emp" + id)));
        logger.info(result);
        return result;
    }

    @GET @Path("/exp") public Employee exp() {
        throw new RuntimeException("xxx");
    }

    @PUT @Produces(MediaType.APPLICATION_JSON) public Result addEmp(Employee e) {
        try {
            System.out.println(e);
            list.getEmployeeList().add(e);
            return new Result();
        } catch (Exception exp) {
            exp.printStackTrace();
            return new Result().setSuccess(false);
        }
    }
}
