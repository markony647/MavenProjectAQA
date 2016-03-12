package Lecture06;


import Lecture06.repository.Dao;
import Lecture06.repository.PersonDao;

import java.util.ArrayList;

public class PersonsContainer implements Dao {

    PersonDao personDao = new PersonDao();


    public void addPersonToDB(Person person){
        personDao.addPersonToDB(person);
    }


    public void printResult(ArrayList<Person> resultSet) {
        if(resultSet.isEmpty()) {
            System.out.println("Nothing was found");
        } else {
        int i = 1;
        for(Person p : resultSet) {
            System.out.println("Search results:\n" + i + ". Person  is " + p.getName() + " " + p.getAge() +
                    " years old (email: " + p.getEmail() + ").");
            i++;
            }
        }
    }


    public ArrayList<Person> searchPersonByUserQuery(String searchQuery) {

        if(Validator.isCharactersOnly(searchQuery)) {
            return findPersonByName(searchQuery);
        } else if(Validator.isNumeric(searchQuery)) {
            return findPersonByAge(searchQuery);
        } else if(Validator.isValidEmail(searchQuery)) {
            return findPersonByEmail(searchQuery);
        } else {
            System.out.println("Enter please correct query parameter");
        }
        return null;
    }


    @Override
    public ArrayList<Person> findPersonByName(String searchQuery) {
        return personDao.findPersonByName(searchQuery);
    }


    @Override
    public ArrayList<Person> findPersonByAge(String searchQuery) {
       return personDao.findPersonByAge(searchQuery);

    }

    @Override
    public ArrayList<Person> findPersonByEmail(String email) {
        return personDao.findPersonByEmail(email);
    }

}
