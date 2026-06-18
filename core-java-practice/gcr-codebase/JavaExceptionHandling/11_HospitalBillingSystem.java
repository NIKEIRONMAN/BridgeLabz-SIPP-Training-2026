public class HospitalBillingSystem{
    public static void main(String[] args){
        try{
            int[] patients={100,200};
            String s="abc";
            System.out.println(10/0);
            System.out.println(patients[5]);
            Integer.parseInt(s);
        }catch(ArithmeticException e){
            System.out.println("Bill cannot be calculated: zero items.");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid patient index.");
        }catch(NumberFormatException e){
            System.out.println("Invalid numeric input.");
        }
    }
}