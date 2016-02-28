package Lecture06;

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
                  if (Validator.isValidPerson(name, rawAge)) {
                      int age = Converter.convertFromStringToInt(rawAge);
                      Person person = new Person(name, age);
                      personsContainer.addPersonToArray(person);
                      userChoise = inputReader.askAndReadUserChoise();
                  } else {
                      System.out.println("Please, enter correct name and age. The Person with name " + name + " and age "
                              + rawAge + " can't be added.");
                  }
                  break;

              case "2":
                  String searchQuery = inputReader.readSearchQueryFromConsole();
                  personsContainer.searchPersonByUserQuery(searchQuery);
                  userChoise = inputReader.askAndReadUserChoise();
                  break;

              default:
                  System.out.println("Enter please correct search query (name or age allowed).");
                  userChoise = inputReader.askAndReadUserChoise();
                  break;
          }

       }

        personsContainer.printArray();
        System.out.println("Exit");
    }
}



