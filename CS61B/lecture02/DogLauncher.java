public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(20);
        Dog d2  = new Dog(200);

        Dog bigger = Dog.maxDog(d, d2);

        bigger.makeNoise();

        d.makeNoise();
    }    
}
