package Lecture06;

public class Validator {

    public static boolean isCharactersOnly(String name) {

        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNumeric(String age) {
        try {
            Converter.convertFromStringToInt(age);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isCorrectAgeRange(String ageValue){
        return (Converter.convertFromStringToInt(ageValue) > 4 && Converter.convertFromStringToInt(ageValue) < 100);
    }


    public static boolean isValidPerson(String name, String age) {
        return ((isCharactersOnly(name) && isNumeric(age)) && (isCorrectAgeRange(age)));
    }

}