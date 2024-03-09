public class NBody {
    public static double readRadius(String file) {

        In in = new In(file);
        int num = in.readInt();

        return in.readDouble();
    }
    public static Body[] readBodies(String file) {
        
        In in = new In(file);
        
        Body bArr[] = new Body[in.readInt()];

        double rad = in.readDouble();

        for (int i = 0; i < bArr.length; ++i) {
            bArr[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());           
        }

        return bArr;
    }
    public static void drawBackground() {
        StdDraw.picture(0, 0, "./images/starfield2.jpg");
        StdDraw.show();
    }


    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bArr = readBodies(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();

        for (double time = 0; time < T; ++dt) {

            double[] xForces = new double[bArr.length];
            double[] yForces = new double[bArr.length];

            for (int i = 0; i < bArr.length; ++i) {
                xForces[i] = bArr[i].calcNetForceExertedByX(bArr);
                yForces[i] = bArr[i].calcNetForceExertedByY(bArr);
            }

            for (int i = 0; i < bArr.length; ++i) {
                bArr[i].update(dt, xForces[i], yForces[i]);
            }

            drawBackground();
            for (int i = 0; i < bArr.length; ++i) {
                bArr[i].draw();
            }
            StdDraw.show();

            StdDraw.pause(10);
        }



        return;
    }
}
