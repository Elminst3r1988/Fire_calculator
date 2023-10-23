public class Validation {
    public static boolean yearCheck(String year) {
        try {
            int check = Integer.parseInt(year);
            if (check > 2001 && check < 2022) {
                return true;
            } else {
                throw new Exception("Wrong input");

            }
        } catch (Exception ex) {
            System.out.println("Wrong input");
            return false;
        }
    }


}
