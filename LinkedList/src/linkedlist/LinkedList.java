package linkedlist;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addMultiple(int... data) {
        for (int value : data) {
            add(value);
        }
    }

    public void appendMultiple(int... data) {
        for (int value : data) {
            append(value);
        }
    }

    private void append(int data) 
		return ;
	}

    public void insertAfter(int previousData, int newData) {
        Node newNode = new Node(newData);
        Node temp = head;

        while (temp != null) {
            if (temp.data == previousData) {
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == tail) {
                    tail = newNode; 
                }
                break;
            }
            temp = temp.next;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = null;
        }
    }

    public void popLast() {
        if (head != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
        }
    }

    public Node search(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return temp;
            }
            temp = temp.next;
        }

        return null; 
    }

    public void insertAfterNode(Node previousNode, int newData) {
        if (previousNode != null) {
            Node newNode = new Node(newData);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
            if (previousNode == tail) {
                tail = newNode; 
            }
        }
    }

    public void delete(int data) {
        if (head == null) {
            return; 
        }

        if (head.data == data) {
            pop();
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;

        if (temp == tail) {
            tail = prev; 
        }
    }

    public void addSorted(int data) {
        Node newNode = new Node(data);

        if (head == null || data < head.data) {
            newNode.next = head;
            head = newNode;
            if (head.next == null) {
                tail = newNode;
            }
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && data > temp.data) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = newNode;
        newNode.next = temp;

        if (temp == null) {
            tail = newNode; 
        }
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addMultiple(56, 30, 70);
        System.out.print("UC 1: ");
        linkedList.display();

        linkedList.add(70);
        linkedList.add(30);
        linkedList.add(56);
        System.out.print("UC 2: ");
        linkedList.display();

        linkedList = new LinkedList();
        linkedList.appendMultiple(56, 30, 70);
        System.out.print("UC 3: ");
        linkedList.display();

        linkedList.insertAfter(56, 30);
        System.out.print("UC 4: ");
        linkedList.display();

        linkedList.pop();
        System.out.print("UC 5: ");
        linkedList.display();

        linkedList.popLast();
        System.out.print("UC 6: ");
        linkedList.display();

        Node searchResult = linkedList.search(30);
        if (searchResult != null) {
            System.out.println("UC 7: Node found with value 30");
        } else {
            System.out.println("UC 7: Node not found with value 30");
        }

        linkedList.insertAfterNode(searchResult, 40);
        System.out.print("UC 8: ");
        linkedList.display();

        linkedList.delete(40);
        System.out.print("UC 9: ");
        linkedList.display();

        LinkedList orderedList = new LinkedList();
        orderedList.addSorted(56);
        orderedList.addSorted(30);
        orderedList.addSorted(40);
        orderedList.addSorted(70);
        System.out.print("UC 10: ");
        orderedList.display();
    }
}
