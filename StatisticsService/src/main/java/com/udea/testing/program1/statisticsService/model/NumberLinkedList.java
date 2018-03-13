package com.udea.testing.program1.statisticsService.model;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.3
 */
public class NumberLinkedList {

    private Node first;
    private Node last;
    private Integer size;

    public NumberLinkedList(Double[] x, Double[] y) {
        first = null;
        last = null;
        size = 0;
        for (int i = 0; i < x.length; i++){
            this.insert(x[i], y[i]);
            size = size + 1;
        }
    }

    public NumberLinkedList(Node first, Node last) {
        this.first = first;
        this.last = last;
        this.size = size;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst() {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast() {
        this.last = last;
    }

    public Integer getSize() {
        if (size == 0 || null == size) {
            calculateSize();
        }
        return size;
    }

    public Boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public void insert(Double valueX, Double valueY) {
        Node node = new Node(valueX, valueY, null);
        if (first == null) {
            first = node;
            last = first;
            return;
        }
        last.setLink(node);
        last = node;
    }

    public void clearList() {
        first = null;
        last = null;
    }

    private void calculateSize() {
        Node node = first;
        while (node != null) {
            this.size = this.size + 1;
            node = node.getLink();
        }
    }
}