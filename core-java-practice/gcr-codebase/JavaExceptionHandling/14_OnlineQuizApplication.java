public class OnlineQuizApplication{
    public static void main(String[] args){
        String[] answers={"A","B","C","D"};
        for(int i=0;i<6;i++){
            try{
                if("A".equals(answers[i])) System.out.println("Correct at "+i);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid answer index: "+i);
            }catch(NullPointerException e){
                System.out.println("Null answer at "+i);
            }
        }
    }
}