import java.util.*;
abstract class JobRole{}
class SoftwareEngineer extends JobRole{}
class DataScientist extends JobRole{}
class ProductManager extends JobRole{}
class Resume<T extends JobRole>{
    String candidate;
    T role;
    Resume(String c,T r){candidate=c;role=r;}
}
public class ResumeScreeningDemo{
    static void process(List<? extends JobRole> roles){
        System.out.println("Roles: "+roles.size());
    }
}