public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {

        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;

        double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        return r;
    }
    public double calcForceExertedBy(Body b) {

        double f = G * this.mass * b.mass / Math.pow(calcDistance(b), 2);
        // if you simply use dis*dis, you'll get a WEIRD VALUE!!!!!!!!!
        
        return f;
    }
    public double calcForceExertedByX(Body b) {

        double dx = b.xxPos - this.xxPos;
        double fx = calcForceExertedBy(b) * dx / calcDistance(b);

        return fx;
    }
    public double calcForceExertedByY(Body b) {

        double dy = b.yyPos - this.yyPos;
        double fy = calcForceExertedBy(b) * dy / calcDistance(b);

        return fy;
    }
    public double calcNetForceExertedByX(Body[] b) {

        double fnx = 0;
        for (int i = 0; i < b.length; ++i) {
            if (this.equals(b[i])) {
                continue;
            } else {
                fnx += calcForceExertedByX(b[i]);
            }
        }

        return fnx;
    }
    public double calcNetForceExertedByY(Body[] b) {

        double fny = 0;
        for (int i = 0; i < b.length; ++i) {
            if (this.equals(b[i])) {
                continue;
            } else {
                fny += calcForceExertedByY(b[i]);
            }
        }
        
        return fny;
    }

    public void update(double dt,double fx,double fy) {

        double ax = fx / this.mass;
        double ay = fy / this.mass;

        this.xxVel += ax * dt;
        this.yyVel += ay * dt;

        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;

        return;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName, 20, 20);
    }


}