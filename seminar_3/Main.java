import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.add("data1");
        list.add("data2");

        list.add(1, "data2_1");


        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }

    }
}