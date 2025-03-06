import java.io.*;
import java.util.Scanner; //added a Scanner 

// made a mistake of not adding the Scanner in the main class 

// By implementing Serializable interface
// we make sure that state of instances of class DogStepTracker
// can be saved in a file.
class DogStepTracker implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //added dogBreed and owner 
    int steps;
    String dogName;
    String dogBreed;
    String owner;

    //added dogBreed and owner 
    // DogStepTracker class constructor
    public DogStepTracker(int steps, String dogName, String dogBreed, String owner) {
        this.steps = steps;
        this.dogName = dogName;
        this.dogBreed = dogBreed;
        this.owner = owner;
    }
}
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in); 

        int steps =250;
        String dogName = "Ollie";
        String dogBreed = "German Shepard";
        String owner = "John Wick";
        DogStepTracker tracker = new DogStepTracker(steps, dogName, dogBreed, owner);

        // Serializing 'tracker'
        FileOutputStream fos = new FileOutputStream("dog_tracker.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tracker);

        // De-serializing 'tracker'
        FileInputStream fis = new FileInputStream("dog_tracker.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        DogStepTracker deserializedTracker = (DogStepTracker) ois.readObject(); // down-casting object

        //added a scanner and outputted the dog breed and owners name
        System.out.println("Dog Name: " + deserializedTracker.dogName + ", Steps: " + deserializedTracker.steps);
        System.out.println("Dog Breed: " + dogBreed + " ,Dog Owner: " + owner ); //added the output statement 
        owner = in.next();
        dogBreed = in.next();

        // closing streams
        oos.close();
        ois.close();
    }
}


