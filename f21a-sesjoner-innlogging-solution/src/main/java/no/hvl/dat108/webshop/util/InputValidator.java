package no.hvl.dat108.webshop.util;

public class InputValidator {

    public static final String EXACTLY_EIGHT_NUMBERS = "[0-9]{8}";
    /**
     * 
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     * 
     * Et gyldig brukernavn består av nøyaktig 8 siffer.
     */
    public static boolean isValidUsername(String username) {
    	return username != null && username.matches("^"+EXACTLY_EIGHT_NUMBERS+"$");
    }
}






