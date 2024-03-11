// Singly Linked List
public class SLList {
    // Nested class definition (A class inside another class)
    // when you declare it static, which means that it cannot access any of the outer class's stuff
    private static class IntNode {
        public int item;
        public IntNode next;
    
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    
    private IntNode first;
    private int size;
    /* The first item is at sentinal.next */
    private IntNode sentinal;

    /* creat an empty list */
    public SLList() {
        sentinal = new IntNode(39, null);
        size = 0;
    }
    public SLList(int x) {
        sentinal = new IntNode(39, null);
        sentinal.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinal.next = new IntNode(x, sentinal.next);
        size += 1;
    }
    public int getFirst() {
        return sentinal.next.item;
    }
    public void addLast(int x) {

        size += 1;

        // 当list为empty 使用addLast()会出现NullPointerException
        // 你可以加if 但太丑了 而且这是一种特殊情况 你不一定能处理所有特殊情况
        // 所以为了解决这个问题 应该让空链表指向一个不为空的地方
        // 就产生所谓 "Sentinal Node"
        // 
        // if(first == null) {
        //     first = new IntNode(x, null);
        //     return;
        // }

        IntNode p = sentinal;

        /* move p until it reaches the end of the list */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    
    public int size() {
        return size;
    }

    // 要想递归实现，为处理简便，可新建一个私有方法对IntNode进行处理
    // private static int size(IntNode p) {
    //     if (p.next == null) {
    //         return 1;
    //     }
    //     return 1 + size(p.next);
    // } 


    public static void main(String[] args) {

        SLList L = new SLList();
        // L.addFirst(10);
        // L.addFirst(5);
        L.addLast(20);

        System.out.println(L.size());

        return;
    }
}
