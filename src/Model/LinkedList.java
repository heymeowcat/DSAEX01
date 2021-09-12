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

    //head and tail of singly linked list
    private Node<T> head;
    private Node<T> tail;
    
    private int count;
    private String isEmpty;

    //add
    public void add(T data) {
        //Create a new node with passed data
        Node<T> newData = new Node<T>(data);
        
        //check if list is empty
        if (this.head == null) {
            //if list is empty; head and tail will assign new node
            head = newData;
            tail = newData;
        } else {
            //else add as last element
            tail.next = newData;
            tail = newData;
        }
   
        count++;
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
            //assigns null if temp pointer is empty
            head = temp.next;  
           
            count--;
            return;
        }

        // find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null) {
            return;
        }

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node tn = temp.next.next;

        // Unlink the deleted node from list
        temp.next = tn;  

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
        //remove all rows from table
        model.setRowCount(0);
        //current will point to head
        Node<Users> current = (Node<Users>) head;
        while (current != null) {
           
            int assignid = current.data.getId();
            String assignname = current.data.getName();
            int assignage = current.data.getAge();
            int assignphone = current.data.getContactNo();
            String assignemail = current.data.getEmail();
         
            Object[] row = {assignid, assignname, assignage, assignphone, assignemail};
            //adding data to table
            model.addRow(row);
            //assigning next pointer to current
            current = current.next;
        }
    }

}
