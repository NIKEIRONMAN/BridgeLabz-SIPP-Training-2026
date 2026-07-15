interface LuggageScanner {
    void scanLuggage(String passengerName);

    default void displaySecurityGuidelines() {
        System.out.println("Luggage guideline: avoid prohibited items and keep baggage accessible.");
    }
}

interface PassportVerifier {
    void verifyPassport(String passengerName, String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport guideline: carry a valid passport before boarding.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z][0-9]{7}");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    @Override
    public void scanLuggage(String passengerName) {
        System.out.println(passengerName + " luggage scan completed.");
    }

    @Override
    public void verifyPassport(String passengerName, String passportNo) {
        boolean valid = PassportVerifier.isPassportNumberValid(passportNo);
        System.out.println(passengerName + " passport " + passportNo + " -> " + (valid ? "valid" : "invalid"));
    }

    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }
}

public class AirportSecurityManagementSystem {
    public static void main(String[] args) {
        String[] passengerNames = {"Aarav", "Meera", "Kabir"};
        String[] passportNumbers = {"A1234567", "B7654321", "1234ABCD"};
        boolean[] luggageChecked = {true, true, false};

        AirportSecuritySystem securitySystem = new AirportSecuritySystem();
        securitySystem.displaySecurityGuidelines();

        for (int i = 0; i < passengerNames.length; i++) {
            securitySystem.scanLuggage(passengerNames[i]);
            securitySystem.verifyPassport(passengerNames[i], passportNumbers[i]);

            boolean canBoard = luggageChecked[i] && PassportVerifier.isPassportNumberValid(passportNumbers[i]);
            System.out.println(passengerNames[i] + " can board: " + (canBoard ? "Yes" : "No"));
        }
    }
}
