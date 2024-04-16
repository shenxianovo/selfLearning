public interface List61B<Item> {

    public void addLast(Item x);


    public Item getLast();


    public Item removeLast();

    public Item get(int i);

    public int size();

    // Add the default , the function can have body now.
    default public void print() {
        for (int i = 0; i < size(); ++i) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}