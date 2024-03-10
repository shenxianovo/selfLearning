public class Person {

    public String name;
    public int age;

    public Person() {
        name = null;
        age = 0;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person miku = new Person("HatsuneMiku", 16);
        Person uta = new Person();
        
        System.out.println("Name: " + miku.name + " Age: " + miku.age); //val
        System.out.println(miku); // adress Person@53d8d10a
        
        System.out.println(uta); // adress Person@e9e54c2
        
        uta = miku;
        System.out.println("Name: " + uta.name + " Age: " + uta.age); //val
        System.out.println(uta);// adress Person@53d8d10a
    } 
}