package Lecture06.repository;


import static Lecture06.Converter.*;
import Lecture06.Person;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDao implements Dao {

    Connection connection = ConnectionManager.getConnection();
    QueryRunner run = new QueryRunner();

    @Override
    public void addPersonToDB(Person person) {
        try {
            run.update(connection,
                    "INSERT INTO `devnotebookapp`.`persons`(`name`, `age`, `email`) VALUES (?, ?, ?)",
            person.getName(), person.getAge(), person.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The person " + person.getName() + " was added to the DB.");
    }

    @Override
    public ArrayList<Person> findPersonByName(String name) {
        try {
            return run.query(connection, "SELECT * FROM persons WHERE name = ?", new UsersRowMapper(), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public ArrayList<Person> findPersonByAge(String age) {
        try {
            return run.query(connection, "SELECT * FROM persons WHERE age = ?", new UsersRowMapper(),
                    convertFromStringToInt(age));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Person> findPersonByEmail(String email) {
        try {
            return run.query(connection, "SELECT * FROM persons WHERE email = ?", new UsersRowMapper(), email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
