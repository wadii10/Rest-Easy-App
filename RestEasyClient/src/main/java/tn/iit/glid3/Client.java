package tn.iit.glid3;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import tn.iit.glid3.model.Employee;
import tn.iit.glid3.model.GenericResponse;

public class Client {
    public static void main(String[] args) {
        ResteasyClient client = new ResteasyClientBuilderImpl().build();
        //GET example
        ResteasyWebTarget getDummy = client.target("http://localhost:8081/RestEasyApp/rws/employee/1/getDummyEmployee");
        Response getDummyResponse = getDummy.request().get();
        String value = getDummyResponse.readEntity(String.class);
        System.out.println(value);
        getDummyResponse.close();
        //POST example
        ResteasyWebTarget add = client.target("http://localhost:8081/RestEasyApp/rws/employee/add");
        Employee emp = new Employee();
        emp.setId(50);emp.setName("Rick");emp.setSalary(1000);
        Response addResponse = add.request().post(Entity.entity(emp, MediaType.APPLICATION_JSON));
        System.out.println(addResponse.readEntity(GenericResponse.class));
        System.out.println("HTTP Response Code:"+addResponse.getStatus());
        addResponse.close();
        addResponse = add.request().post(Entity.entity(emp, MediaType.APPLICATION_JSON));
        System.out.println(addResponse.readEntity(GenericResponse.class));
        System.out.println("HTTP Response Code:"+addResponse.getStatus());
        addResponse.close();
//DELETE example
        ResteasyWebTarget delete =
                client.target("http://localhost:8081/RestEasyApp/rws/employee/50/delete");
        Response deleteResponse = delete.request().delete();
        System.out.println(deleteResponse.readEntity(GenericResponse.class));
        System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
        deleteResponse.close();

        deleteResponse = delete.request().delete();
        System.out.println(deleteResponse.readEntity(GenericResponse.class));
        System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
        deleteResponse.close();
    }

}
