public class Dog {
    public Dog(int w) {
        weightInPounds = w;
    }

    public int weightInPounds;

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("bark bark");
        } else if (weightInPounds > 100) {
            System.out.println("woooooooo");
        } else {
            System.out.println("awawaawaw");
        }
    }

    public static Dog maxDog(Dog d, Dog d2) {
        if(d.weightInPounds > d2.weightInPounds) {
            return d;
        } else {
            return d2;
        }
    }
}
