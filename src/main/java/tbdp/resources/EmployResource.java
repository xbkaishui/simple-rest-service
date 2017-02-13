package tbdp.resources;

import tbdp.common.Result;
import tbdp.model.Employee;
import tbdp.model.Employees;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by xbkaishui on 17/2/13.
 */
@Path("/employees") public class EmployResource {
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
        return new Result("xxx");
    }

    @GET @Path("/exp") public Employee exp() {
        throw new RuntimeException("xxx");
    }

    @PUT @Produces(MediaType.APPLICATION_JSON) public Result addEmp(Employee e) {
        try {
            System.out.println(e);
            list.getEmployeeList().add(e);
            return new Result("ok");
        } catch (Exception exp) {
            exp.printStackTrace();
            return new Result("error");
        }
    }
}
