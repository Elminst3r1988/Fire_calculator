public class Validation {
    public static boolean yearCheck(int year) {
        validateInput(year);
        return true;
    }
    private static void validateInput(int year) throws InvalidInputException {
        if (year < 2002 || year > 2021){
            throw new InvalidInputException("Input is out of range");
        }
    }


}
