package Lecture06.repository;


import Lecture06.Person;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRowMapper implements ResultSetHandler<List<Person>> {

    @Override
    public List<Person> handle(ResultSet rs) throws SQLException {
        ArrayList<Person> personList = new ArrayList<>();
        while (rs.next()) {
            Person p = new Person();
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            p.setEmail(rs.getString("email"));
        }
        return personList;
    }
}
