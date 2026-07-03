import java.util.*;
interface Category{}
class BookCategory implements Category{}
class ClothingCategory implements Category{}
class GadgetCategory implements Category{}
class Product<T extends Category>{
    String name; double price; T category;
    Product(String n,double p,T c){name=n;price=p;category=c;}
    public String toString(){return name+" "+price;}
}
public class MarketplaceDemo{
    public static <T extends Product<?>> void applyDiscount(T p,double percent){
        p.price-=p.price*percent/100.0;
    }
    public static void main(String[] args){
        Product<BookCategory> b=new Product<>("Java",500,new BookCategory());
        applyDiscount(b,10);
        System.out.println(b);
    }
}