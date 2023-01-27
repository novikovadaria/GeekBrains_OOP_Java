import java.util.Iterator;

public class DoublyLinkedList implements Iterable{

    private Element head;
    private Element tail;
    private int count = 0;

    @Override
    public Iterator iterator() {
        return new Iterator<Object>() {
            Element element0 = new Element("0");
            {
                element0.setNext(head);
            }
            Element currentElement = element0;

            @Override
            public boolean hasNext() {
                return currentElement.getNext() != null;
            }

            @Override
            public Object next() {
                currentElement = currentElement.getNext();
                return currentElement.getData();
            }
        };
    }

    public int size() {
        return count;
    }

    private Element getElement(int index){
        if (index >= count){
            throw new IndexOutOfBoundsException();
        }

        Element result = head;
        for (int i = 1; i <= index; i++){
            result = result.getNext();
        }
        return result;
    }

    public Object get(int index){

        Element element = getElement(index);

        return element.getData();
    }

    public void remove(int index){

        Element currentElement = getElement(index);
        Element nextElement = currentElement.getNext();
        Element previousElement = currentElement.getPrevious();

        if (index == 0){
            head = nextElement;
            if (tail == currentElement){
                tail = null;
            }
        }

        if (index == count - 1){
            tail = previousElement;
            if (head == currentElement){
                head = null;
            }
        }

        count--;

        if (nextElement != null){
            nextElement.setPrevious(previousElement);
        }

        if (previousElement != null){
            previousElement.setNext(nextElement);
        }

    }

    public void add(int index, Object data){
        if (count == index){
            add(data);
            return;
        }
        count++;

        Element currentElement = new Element(data);

        if (index == 0){
            head = currentElement;
        }

        Element nextElement = getElement(index);
        Element previousElement = nextElement.getPrevious();

        currentElement.setNext(nextElement);
        currentElement.setPrevious(previousElement);

        if (previousElement != null) {
            previousElement.setNext(currentElement);
        }

    }

    public void add(Object data){
        count++;
        Element element = new Element(data);
        if (head == null){
            head = element;
            tail = element;
            return;
        } else if (tail == null) {
            tail = element;
            return;
        }

        tail.setNext(element);
        element.setPrevious(tail);
        tail = element;
    }

}