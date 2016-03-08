package Lecture06.repository;


import Lecture06.Person;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDao implements Dao {

    Connection connection = ConnectionManager.getConnection();
    QueryRunner run = new QueryRunner();

    @Override
    public void add(Person person) {
        try {
            run.update(connection,
                    "INSERT INTO `devnotebookapp`.`persons`(`name`, `age`, `email`) VALUES (?, ?, ?)",
            person.getName(), person.getAge(), person.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The person " + person.getName() + " was added to the storage.");
    }

//    @Override
//    public ArrayList<Person> findPersonByName(String name) {
//        try {
//            return run.query(connection,
//                    "SELECT * FROM persons WHERE name = ?", new UsersRowMapper() );
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public ArrayList<Person> findPersonByName(String name) {
        return null;
    }




    @Override
    public ArrayList<Person> findPersonByAge(String age) {
        return null;
    }

    @Override
    public ArrayList<Person> findPersonByEmail(String email) {
        return null;
    }
}
