                // 此处类似c++模板类型
public class DLList<Item> {
    /* Naked node */
    private class Node {
        private Item item;
        private Node prev;
        private Node next;

        // Default constructor
        public Node() {}
        // Parameterized constructor
        public Node(Item x, Node p, Node n) {
            item = x;
            prev = p;
            next = n;
        }
    }

    private Node sentFront;
    private Node sentBack;
    private int size;

    /* Default constructor */
    public DLList() {
        size = 0;
        sentFront = new Node();
        sentBack = new Node();

        sentFront.next = sentBack; // change this one when adding/removing a node
        sentBack.next = sentFront;
        sentFront.prev = sentBack; 
        sentBack.prev = sentFront; // change this one when adding/removing a node
    }
    /* Parameterized constructor */
    public DLList(Item x) {
        size = 1;
        sentFront = new Node();
        sentBack = new Node();
        Node temp = new Node();
        temp.item = x;

        sentFront.next = temp;
        temp.next = sentBack;
        sentBack.next = sentFront;
        sentBack.prev = temp;
        temp.prev = sentFront;
        sentFront.prev = sentBack;
    }
    /* Add a node next to sentFront */
    public void addFirst(Item x) {
        Node temp = new Node();
        size += 1;
        temp.item = x;

        temp.next = sentFront.next;
        temp.prev = sentFront;
        sentFront.next.prev = temp;
        sentFront.next = temp;
    }

    public static void main(String[] args) {

        DLList<String> L = new DLList<>("Miku");
        L.addFirst("Hatsune");
        L.addFirst("Teto");
        L.addFirst("Kasene");

        return;
    }

}
