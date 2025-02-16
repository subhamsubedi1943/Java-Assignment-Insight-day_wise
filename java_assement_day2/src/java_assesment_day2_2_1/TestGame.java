package java_assesment_day2_2_1;

//Parent class Game
abstract class Game {
 public abstract void displayInfo();
}

//Cricket class
class Cricket extends Game {
 @Override
 public void displayInfo() {
     System.out.println("Cricket: A bat-and-ball game played between two teams of eleven players.");
 }
}

//Football class
class Football extends Game {
 @Override
 public void displayInfo() {
     System.out.println("Football: A team sport where players try to score goals by kicking a ball into the opposing team's net.");
 }
}

//Tennis class
class Tennis extends Game {
 @Override
 public void displayInfo() {
     System.out.println("Tennis: A racket sport where two or four players hit a ball over a net.");
 }
}

//TestGame class
public class TestGame {
 public static void main(String[] args) {
     Game[] games = new Game[5];
     games[0] = new Cricket();
     games[1] = new Football();
     games[2] = new Tennis();
     games[3] = new Cricket();
     games[4] = new Football();

     for (Game game : games) {
         game.displayInfo(); // Polymorphic behavior
     }
 }
}

