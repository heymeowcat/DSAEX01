/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author heymeowcat
 */
public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int count;

    public LinkedList() {
        Node<T> newLiked = new Node<T>();
        this.first = newLiked;
        this.last = this.first;
    }

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(T obj) {
            this.data = obj;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }

    //add
    public void add(T data) {
        Node<T> newData = new Node<T>(data);
        if (this.first.getData() == null) {
            this.first = newData;
            this.last = this.first;
        } else {
            this.last.setNext(newData);
            this.last = newData;
        }
        count++;
    }

    //remove
    public void remove(T data) {
        Node<T> current = first;
        if (this.first.getData().equals(data)) {
            if (this.first.getNext() == null) {
                Node<T> newNode = new Node<T>();
                this.first.setData(null);
                this.first = newNode;
                this.last = this.first;
            } else {
                this.first.setData(null);
                this.first = this.first.getNext();
            }
        } else {
            boolean wasDeleted = false;
            while (!wasDeleted) {
                Node<T> currentNext = current.getNext();
                if (currentNext.getData().equals(data)) {
                    currentNext.setData(null);
                    current.setNext(currentNext.getNext());
                    currentNext = null;
                    wasDeleted = true;
                    count--;
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    //count
    public int getCount() {
        return count;
    }

}
