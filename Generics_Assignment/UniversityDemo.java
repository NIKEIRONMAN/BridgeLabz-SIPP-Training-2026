import java.util.*;
abstract class CourseType{}
class ExamCourse extends CourseType{}
class AssignmentCourse extends CourseType{}
class ResearchCourse extends CourseType{}
class Course<T extends CourseType>{
    String name; T type;
    Course(String n,T t){name=n;type=t;}
    public String toString(){return name;}
}
public class UniversityDemo{
    static void show(List<? extends Course<?>> list){
        for(Course<?> c:list) System.out.println(c);
    }
}