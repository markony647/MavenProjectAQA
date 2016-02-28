package Lecture06;


import java.util.ArrayList;

public class PersonsContainer implements Searchable {

    ArrayList<Person>arrayOfPersons = new ArrayList<>();


    public void addPersonToArray(Person person){
        System.out.println("The person " + person.getName() + " was added to the storage.");
        arrayOfPersons.add(person);

    }


    public void printArray() {
        int i = 1;
        for(Person p : arrayOfPersons){
            System.out.println(i + ". Person  is " + p.getName() + " " + p.getAge() + " years old.");
            i++;
        }
    }

    public void searchPersonByUserQuery(String searchQuery) {

        if(Validator.isCharactersOnly(searchQuery)) {
            findPersonByName(searchQuery);
        } else if(Validator.isNumeric(searchQuery)) {
            findPersonByAge(searchQuery);
        } else {
            System.out.println("Enter please correct query parameter");
        }
    }


    @Override
    public void findPersonByName(String searchQuery) {

        ArrayList<Person> arrayOfFoundPersons = new ArrayList<>();

        searchQuery = searchQuery.toLowerCase();

        System.out.println("SEARCH RESULTS:\n");

            for (Person p : arrayOfPersons) {
                if (p.getName().toLowerCase().equals(searchQuery)) {
                    arrayOfFoundPersons.add(p);
                    System.out.println(searchQuery.toUpperCase() + " found. He/she is " + p.getAge() + " years old.\n");
                }
             }
        if(arrayOfFoundPersons.isEmpty()) {
            System.out.println("Nothing were found....");

        }

    }


    @Override
    public void findPersonByAge(String searchQuery) {

        ArrayList<Person> arrayOfFoundPersons = new ArrayList<>();

        int age = Converter.convertFromStringToInt(searchQuery);
        System.out.println("SEARCH RESULTS:\n");

            for (Person p : arrayOfPersons) {
                if (p.getAge() == age) {
                    arrayOfFoundPersons.add(p);
                    System.out.println(p.getName().toUpperCase() + " found (" + p.getAge() +
                            " years old).\n");
                }
            }
        if(arrayOfFoundPersons.isEmpty()) {
            System.out.println("Nothing were found....");

            }
        }
    }
