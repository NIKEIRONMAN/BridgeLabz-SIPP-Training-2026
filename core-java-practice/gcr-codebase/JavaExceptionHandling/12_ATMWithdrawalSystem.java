class InsufficientBalanceExceptionATM extends Exception{
    double balance,requested;
    InsufficientBalanceExceptionATM(double b,double r){
        super("Insufficient balance");
        balance=b; requested=r;
    }
}
public class ATMWithdrawalSystem{
    public static void main(String[] args){
        double balance=5000,request=8000;
        try{
            if(request>balance) throw new InsufficientBalanceExceptionATM(balance,request);
        }catch(InsufficientBalanceExceptionATM e){
            System.out.println(e.getMessage()+" Balance="+e.balance+" Requested="+e.requested);
        }
    }
}