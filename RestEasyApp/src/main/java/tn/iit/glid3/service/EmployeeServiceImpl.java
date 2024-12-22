package tn.iit.glid3.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tn.iit.glid3.model.Employee;
import tn.iit.glid3.model.GenericResponse;

import java.util.HashMap;
import java.util.Map;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeServiceImpl implements EmployeeService {

    private static Map<Integer, Employee> emps = new HashMap<Integer, Employee>();
    @POST
    @Path("/add")
    @Override
    public Response addEmployee(Employee e) {
        GenericResponse response = new GenericResponse();
        if (emps.get(e.getId()) != null) {
            response.setStatus(false);
            response.setMessage("Employee Already Exists");
            response.setErrorCode("EC-01");
            return

                    Response.status(422).entity(response).build();

        }
        emps.put(e.getId(), e);
        response.setStatus(true);
        response.setMessage("Employee created successfully");
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}/delete")
    @Override
    public Response deleteEmployee(@PathParam("id") int id) {
        GenericResponse response = new GenericResponse();
        response.setMessage("Not Yet Implemented");
        /* code à implémenter */
        return Response.ok(response).build();
    }

    @GET
    @Path("/{id}/get")
    @Override
    public Employee getEmployee(@PathParam("id") int id) {
        /* code à implémenter */
        return null;
    }

    @GET
    @Path("/{id}/getDummyEmployee")
    @Override
    public Employee getDummyEmployee(@PathParam("id") int id) {
        System.out.println("getDummyEmployee !!!");
        Employee e = new Employee();
        e.setSalary(8976.55);
        e.setName("Salah");

        e.setId(id);
        return e;
    }

    @GET
    @Path("/getAll")
    @Override
    public Employee[] getAllEmployees() {
        /* code à implémenter */
        return null;
    }
}
