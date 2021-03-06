package Lecture06;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new InputReader();
        PersonsContainer personsContainer = new PersonsContainer();

       String userChoise = inputReader.askAndReadUserChoise();

        while (!userChoise.equals("3")){
          switch (userChoise) {
              case "1":
                  String name = inputReader.readNameFromConsole();
                  String rawAge = inputReader.readAgeFromConsole();
                  String email = inputReader.readEmailFromConsole();
                  if (Validator.isValidPerson(name, rawAge, email)) {
                      int age = Converter.convertFromStringToInt(rawAge);
                      Person person = new Person(name, age, email);
                      personsContainer.addPersonToDB(person);
                      userChoise = inputReader.askAndReadUserChoise();

                  } else {
                      System.out.println("Please, enter correct name, age and email. The Person with name " + name + ", age "
                              + rawAge + " and email " + email + " can't be added.");
                  }
                  break;

              case "2":
                  String searchQuery = inputReader.readSearchQueryFromConsole();
                  ArrayList<Person> foundPersons = personsContainer.searchPersonByUserQuery(searchQuery);
                  personsContainer.printResult(foundPersons);
                  userChoise = inputReader.askAndReadUserChoise();
                  break;

              default:
                  System.out.println("Enter please correct search query (name, age or email allowed).");
                  userChoise = inputReader.askAndReadUserChoise();
                  break;
          }

       }

        System.out.println("Exit");
    }
}



