package Lecture06.repository;


import Lecture06.Person;

import java.util.ArrayList;

public interface Dao {

    void add(Person person);

    ArrayList<Person> findPersonByName(String name);

    ArrayList<Person> findPersonByAge(String age);

    ArrayList<Person> findPersonByEmail(String email);

}
