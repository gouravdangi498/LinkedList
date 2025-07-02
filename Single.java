public class Single {
    Node head;
    Node tail;
    int size;

    public Single() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void insertFirst(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        System.out.println("Element added ");
        size += 1;
    }

    public void insertLast(int data) {
        if (tail == null) {
            insertFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        System.out.println("Element added ");
        size++;
    }

    public void insertSpecific(int data, int index) {
        if (index > size) {
            System.out.println("Index value is large ");
            return;
        }
        if (index == 0) {
            insertFirst(data);
            return;
        }
        if (index == size) {
            insertLast(data);
            return;
        }
        // Node newNode=new Node(data);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // newNode.next=temp.next;
        Node newNode = new Node(data, temp.next);
        temp.next = newNode;
        System.out.println("Element added ");
        size++;
    }

    /*Insert using recursion  */
    
    public int deleteFirst() {
        if (head == null) {
            System.out.println("Least is empty :");
            return 0;
        }
        int value = head.data;
        head = head.next;
        System.out.print("Element remove :");
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if (size <= 1) {
            deleteFirst();
        }
        // Node current = head;
        // while (current.next != tail) {
        // current = current.next;
        // }

        // int value = tail.data;
        // current.next = null;
        // tail = current;
        // System.out.print("Element remove :");
        // size--;
        // return value;

        Node secondLast = getNode(size - 2);
        int value = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return value;
    }

    public int deleteSpecific(int index) {
        if (index == 0) {
            System.out.println("List is already null ");
            return 0;
        }
        if (index == 1) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node pre = getNode(index - 1);
        int value = pre.next.data;
        pre.next = pre.next.next;
        size--;
        return value;

    }

    public Node fiNode(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "-> ");
            current = current.next;
        }
        System.out.print("Null");
        System.out.println();
    }

    // method for getting any node
    public Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        System.out.print("Size is :");
        return size;
    }

    public static void main(String[] args) {
        Single ds = new Single();
        ds.insertFirst(1);
        ds.insertFirst(2);
        ds.insertFirst(3);
        ds.insertLast(5);
        ds.insertFirst(4);
        ds.insertSpecific(67, 5);
        ds.display();
        int x = ds.deleteFirst();
        System.out.println(x);
        ds.display();
        int y = ds.deleteLast();
        System.out.println(y);
        ds.display();
        // Node me = ds.getNode(3);
        // System.out.println(me);
        // System.out.println(me.data);
        // System.out.println(me.next);
        // Node z=ds.fiNode(5);
        // System.out.println(z);
        // System.out.println(z.data);

    }
}