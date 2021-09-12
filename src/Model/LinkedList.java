/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heymeowcat
 */
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int count;
    private String isEmpty;

    //add
    public void add(T data) {
        Node<T> newData = new Node<T>(data);
        if (this.head == null) {
            head = newData;
            tail = newData;
        } else {
            tail.n = newData;
            tail = newData;
        }
        count++;
    }

    //get
    public Node get(int position) {
        Node c = head;
        for (int x = 1; x < position; x++) {
            c = c.n;
        }
        return c;
    }

    //remove
    public void remove(int position) {

        // If linked list is empty
        if (head == null) {
            return;
        }

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = temp.n;   // Change head
            count--;
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.n;
        }

        // If position is more than number of nodes
        if (temp == null || temp.n == null) {
            return;
        }

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.n.n;

        temp.n = next;  // Unlink the deleted node from list

        count--;
    }

    //count
    public int getCount() {
        return count;
    }

    //isEmpty
    public String isEmpty() {
        if (head == null) {
            isEmpty = "Yes";
        } else {
            isEmpty = "No";
        }
        return isEmpty;
    }

    //view
    public void view(DefaultTableModel model) {
        model.setRowCount(0);
        Node<Users> c = (Node<Users>) head;
        while (c != null) {
            int assignid = c.data.getId();
            String assignname = c.data.getName();
            int assignage = c.data.getAge();
            int assignphone = c.data.getContactNo();
            String assignemail = c.data.getEmail();

            Object[] row = {assignid, assignname, assignage, assignphone, assignemail};

            model.addRow(row);

            c = c.n;
        }
    }

}
