package tn.iit.glid3;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import tn.iit.glid3.service.EmployeeServiceImpl;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rws")
public class RestEasyApplication extends Application
{
    private Set<Class> classes = new HashSet<Class>();
    public RestEasyApplication() {
        classes.add(EmployeeServiceImpl.class);
    }
    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
