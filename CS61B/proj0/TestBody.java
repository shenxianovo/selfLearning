public class TestBody {
    public static void main(String[] args) {
        Body[] b = new Body[4];
        b[0] = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        b[1] = new Body(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");
        b[2] = new Body(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        b[3] = new Body(6.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        for (int i = 0; i < b.length; ++i) {
            double f1 = b[i].calcNetForceExertedByX(b) * b[i].calcNetForceExertedByY(b);
            System.out.println("force" + i + " " + f1);
        }

    }
}
