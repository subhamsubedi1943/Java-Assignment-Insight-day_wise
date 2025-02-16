package java_assesment_day2_2_1;

//Abstract class Instrument
abstract class Instrument {
 public abstract void play();
}

//Piano class
class Piano extends Instrument {
 @Override
 public void play() {
     System.out.println("Piano is playing tan tan tan tan");
 }
}

//Flute class
class Flute extends Instrument {
 @Override
 public void play() {
     System.out.println("Flute is playing toot toot toot toot");
 }
}

//Guitar class
class Guitar extends Instrument {
 @Override
 public void play() {
     System.out.println("Guitar is playing tin tin tin");
 }
}

//Main class to check polymorphism
public class MainInstrument {
 public static void main(String[] args) {
     Instrument[] instruments = new Instrument[10];
     instruments[0] = new Piano();
     instruments[1] = new Flute();
     instruments[2] = new Guitar();
     
     for (Instrument instrument : instruments) {
         if (instrument != null) {
             instrument.play();
             if (instrument instanceof Piano) {
                 System.out.println("This is a Piano.");
             } else if (instrument instanceof Flute) {
                 System.out.println("This is a Flute.");
             } else if (instrument instanceof Guitar) {
                 System.out.println("This is a Guitar.");
             }
         }
     }
 }
}

