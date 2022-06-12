package masterCodingInterview.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList
{
    private int length;
    private Node head;
    private Node tail;

    public MyLinkedList(int value)
    {
        head = new Node();
        head.value = value;
        head.next = null;
        tail = head;
        ++length;
    }

    public void append(int value)
    {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = tail;
        tail.next = newNode;
        tail = newNode;
        tail.next = null;
        ++length;
    }

    public void prepend(int value)
    {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = head;
        head = newNode;
        ++length;
    }

    public void insert(int index, int value)
    {
        if (index <= 0)
            prepend(value);
        if (index >= length)
            append(value);

        Node currentNode = head.next;
        Node prevNode = head;
        int currentIndex = 1;
        while (currentNode != null)
        {
            if (index == currentIndex)
            {
                Node newNode = new Node();
                newNode.value = value;
                newNode.next = currentNode;
                prevNode.next = newNode;
                ++length;
                break;
            }
            else
            {
                prevNode = currentNode;
                currentNode = currentNode.next;
                currentIndex++;
            }
        }
    }

    public void deleteElement(int value)
    {
        Node currentNode = head;
        Node previousNode = null;

        while (currentNode != null)
        {
            if (currentNode.value == value)
            {
                if (previousNode == null)
                {
                    head = head.next;
                }
                else if (currentNode.next == null)
                {
                    previousNode.next = null;
                    tail = previousNode;
                }
                else
                {
                    previousNode.next = currentNode.next;
                }
                --length;
                break;
            }
            else
            {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
    }

    public void printList()
    {
        List<Integer> list = new ArrayList<>();
        Node currentNode = head;
        while (currentNode != null)
        {
            list.add(currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println(list);
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "length=" + length +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}

class Node
{
    int value;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
