interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 6 && code.length() <= 12;
    }
}

class ShoppingCart implements CouponValidator {
    @Override
    public boolean validateCoupon(String code) {
        return CouponValidator.isLengthValid(code) && code.matches("[A-Z0-9]+");
    }
}

public class CouponValidatorSystem {
    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "WELCOME2026", "abc123", "DEAL", "FESTIVE50"};
        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            boolean valid = cart.validateCoupon(coupon);
            System.out.println(coupon + " -> " + (valid ? "Valid" : "Invalid"));
        }
    }
}
