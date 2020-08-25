import com.alibaba.fastjson.JSON;

import java.util.concurrent.ConcurrentHashMap;

public class TestMain { /**
 * 用于存所有的连接服务的客户端，这个对象存储是安全的
 */
private static ConcurrentHashMap<String, Student> webSocketSet = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Student student = Student.getStudent();
        student.name = "张三";
        webSocketSet.put("1", student);

        Student students = Student.getStudent();
        students.name = "李四";
        webSocketSet.put("2", students);

        System.out.println(JSON.toJSON(webSocketSet));
    }
}

/**
 * 提供一个单例类
 */
class Student {

    public String name;

    private Student() {
    }

    private static final Student student = new Student();

    public static Student getStudent() {
        return student;

    }

}
