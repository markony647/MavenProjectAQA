package Lecture06;

public class Person {

    private String name;
    private int age;
    private String email;


    public Person(String name, int age, String email){
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
