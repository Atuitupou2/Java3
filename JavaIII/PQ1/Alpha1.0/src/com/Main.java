package com;

public class Main
{
    //Creates the doubly link list structure
    public static class DoublyLinkedList
    {
        public class Node
        {
            //Once a node is created the information is entered into the node
            Country country = new Country();
            Country.City city = country.new City();

            Node next;
            Node prev;

        }

        //Sets the node head and tail to null to prepare the head and tail to connect
        //to the new head and tail
        Node head = null;
        Node tail = null;

        public void addNode()
        {
            Node newNode = new Node();
            //If the head after the new node has been created or the first node than
            //resign the head and tail
            if(head == null)
            {
                head = tail = newNode;
                head.prev = null;
                tail.next = null;
            }
            else
            {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
            }
        }
        //Prints information of country and city
        public void printNodes()
        {
            //Checks if the list is empty and prevents printing null values
            Node current = head;
            if(head == null)
            {
                System.out.println("Doubly linked list is empty");
                return;
            }
            //Otherwise print the linked list
            System.out.println("Linked list is as follows: ");
            while(current != null)
            {
                System.out.println("Country is: " + current.country.name);
                System.out.println("City is: " + current.city.name);

                System.out.println();
                current = current.next;
            }
        }
    }

    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addNode();
        list.addNode();
        list.addNode();
        list.addNode();
        list.printNodes();
    }
}
