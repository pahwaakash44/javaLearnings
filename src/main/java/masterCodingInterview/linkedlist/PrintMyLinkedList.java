package masterCodingInterview.linkedlist;

public class PrintMyLinkedList
{
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);
        myLinkedList.append(12);
        myLinkedList.append(13);
        myLinkedList.prepend(9);
        System.out.println("list without insert");
        myLinkedList.printList();
//        System.out.println(myLinkedList);

        myLinkedList.insert(2, 11);
        System.out.println("list after insert");
        myLinkedList.printList();
//        System.out.println(myLinkedList);

        myLinkedList.insert(10, 14);
        System.out.println("list after insert");
        myLinkedList.printList();
//        System.out.println(myLinkedList);

        myLinkedList.insert(0, 8);
        System.out.println("list after insert");
        myLinkedList.printList();
//        System.out.println(myLinkedList);

        myLinkedList.deleteElement(11);
        System.out.println("list after delete");
        myLinkedList.printList();

        myLinkedList.deleteElement(14);
        System.out.println("list after delete");
        myLinkedList.printList();

        myLinkedList.deleteElement(8);
        System.out.println("list after delete");
        myLinkedList.printList();
        System.out.println(myLinkedList);
    }
}
