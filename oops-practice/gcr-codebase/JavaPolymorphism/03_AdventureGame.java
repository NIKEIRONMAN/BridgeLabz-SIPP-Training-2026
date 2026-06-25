abstract class GameCharacter{String characterName;GameCharacter(String n){characterName=n;}abstract void performAttack();}
class Warrior extends GameCharacter{Warrior(String n){super(n);}void performAttack(){System.out.println(characterName+" attacks with sword");}}
class Mage extends GameCharacter{Mage(String n){super(n);}void performAttack(){System.out.println(characterName+" casts spell");}}
class Archer extends GameCharacter{Archer(String n){super(n);}void performAttack(){System.out.println(characterName+" shoots arrow");}}
public class Main3{
static void startBattle(GameCharacter[] c){int w=0,m=0,a=0;for(GameCharacter x:c){x.performAttack();if(x instanceof Warrior)w++;else if(x instanceof Mage)m++;else if(x instanceof Archer)a++;}System.out.println("Warriors="+w+" Mages="+m+" Archers="+a);}
public static void main(String[]args){startBattle(new GameCharacter[]{new Warrior("Thor"),new Mage("Merlin"),new Archer("Robin"),new Warrior("Leo")});}}