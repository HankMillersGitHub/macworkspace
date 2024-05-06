package _01_dataStruc;

import org.junit.Test;

import java.util.Objects;

public class DataStruc {
    @Test
    public void test() {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node("this is first node", 1001);
        linkedList.setNode(node1);
        linkedList.setPre(null);
        linkedList.setNext(null);
    }
}

class LinkedList {
    private Node node;
    private Node next;
    private Node pre;

    public Object getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public LinkedList() {
    }

    public LinkedList(Node node, Node next, Node pre) {
        this.node = node;
        this.next = next;
        this.pre = pre;
    }
}

class Node {
    private String data;
    private int id;

    public Node(String data, int id) {
        this.data = data;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, id);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}