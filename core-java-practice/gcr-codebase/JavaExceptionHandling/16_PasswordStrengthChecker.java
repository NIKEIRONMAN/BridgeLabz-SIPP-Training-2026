public class PasswordStrengthChecker{
    static void checkPassword(String p){
        try{
            if(p==null) throw new NullPointerException();
            if(p.isEmpty()) throw new IllegalArgumentException("Password is empty");
            if(p.length()<8) throw new IllegalArgumentException("Minimum length 8");
            if(!Character.isUpperCase(p.charAt(0))) throw new IllegalArgumentException("First character must be uppercase");
            if(!Character.isDigit(p.charAt(p.length()-1))) throw new IllegalArgumentException("Last character must be digit");
            if(!p.matches(".*[@#$%&*].*")) throw new IllegalArgumentException("Special character missing");
            System.out.println("Strong password");
        }catch(NullPointerException e){
            System.out.println("Password cannot be null");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        checkPassword("Password@1");
    }
}