public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println("argsSum: " + args.length);
        for (int i = 0; i < args.length; ++i) {
            System.out.println(args[i]);
        }
    }
}
