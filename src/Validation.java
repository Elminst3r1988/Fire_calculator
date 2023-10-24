public class Validation {
    public static boolean yearCheck(String year) {
        try {
            int check = Integer.parseInt(year);
            validateInput(check);
        }
        catch (Exception ex) {
            System.out.println("Error." + ex.getMessage());
        }
        return false;
    }

    public static void validateInput(int year) throws InvalidInputException {
        if (year < 2002 || year > 2021){
            throw new InvalidInputException("Input is out of range");
        }
    }


}
