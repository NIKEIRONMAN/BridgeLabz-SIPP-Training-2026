abstract class Vehicle{String vehicleNumber,ownerName;Vehicle(String v,String o){vehicleNumber=v;ownerName=o;}abstract int calculateToll();}
class Car extends Vehicle{Car(String v,String o){super(v,o);}int calculateToll(){return 100;}}
class Bus extends Vehicle{Bus(String v,String o){super(v,o);}int calculateToll(){return 250;}}
class Truck extends Vehicle{Truck(String v,String o){super(v,o);}int calculateToll(){return 400;}}
public class Main5{
static void calculateTotalRevenue(Vehicle[] a){int sum=0,max=-1,c=0,b=0,t=0;Vehicle high=null;for(Vehicle v:a){int x=v.calculateToll();sum+=x;if(x>max){max=x;high=v;}if(v instanceof Car)c++;else if(v instanceof Bus)b++;else t++;}System.out.println(sum);System.out.println(high.vehicleNumber);System.out.println(c+" "+b+" "+t);}
static void searchVehicle(Vehicle[] a,String n){for(Vehicle v:a)if(v.vehicleNumber.equals(n))System.out.println(v.ownerName);}
public static void main(String[]args){Vehicle[] a={new Car("C1","A"),new Bus("B1","B"),new Truck("T1","C")};calculateTotalRevenue(a);searchVehicle(a,"B1");}}