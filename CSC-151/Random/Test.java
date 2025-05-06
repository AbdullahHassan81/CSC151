
import java.io.*;

// By implementing Serializable interface
// we make sure that state of instances of class DogStepTracker
// can be saved in a file.
class DogStepTracker implements Serializable {
    private static final long serialVersionUID = 1L;
    
    int steps;
    String dogName;

    // DogStepTracker class constructor
    public DogStepTracker(int steps, String dogName) {
        this.steps = steps;
        this.dogName = dogName;
    }
}

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DogStepTracker tracker = new DogStepTracker(5000, "Buddy");

        // Serializing 'tracker'
        FileOutputStream fos = new FileOutputStream("dog_tracker.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tracker);

        // De-serializing 'tracker'
        FileInputStream fis = new FileInputStream("dog_tracker.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        DogStepTracker deserializedTracker = (DogStepTracker) ois.readObject(); // down-casting object

        System.out.println("Dog Name: " + deserializedTracker.dogName + ", Steps: " + deserializedTracker.steps);

        // closing streams
        oos.close();
        ois.close();
    }
}


