public class Validation {
    public static boolean yearCheck(String year) {
        int check = Integer.parseInt(year);
        validateInput(check);

        return true;
    }

    private static void validateInput(int year) throws InvalidInputException {
        if (year < 2002 || year > 2021){
            throw new InvalidInputException("Input is out of range");
        }
    }


}
