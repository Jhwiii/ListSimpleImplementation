package co.edu.uptc.structures;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleList <T> implements List<T> {

    private Node head;

    public SimpleList(){
        head = null;
    }
    
    @Override//1
    public int size() {
       int sizeOfList = 0;
        if(!isEmpty()){
            Node aux = head;
            while(aux != null){
            sizeOfList += 1;
            aux = aux.getNext();
        }
        
    }
    return sizeOfList;
        
    }

    @Override//2
    public boolean isEmpty() {
        return head == null;
    }

    @Override//3
    public boolean contains(Object o) {
        boolean thereIsElement= false;

        if(!isEmpty()){
            Node aux = head;
            while(aux != null){
            if(aux.getData().equals(o))
            thereIsElement = true;
           aux = aux.getNext();
        }
    }
    
    return thereIsElement;
}

    @Override//4
    public Iterator iterator() {
        Iterator<T> iterator= new Iterator<T>(){
            Node aux=head;
            @Override
            public boolean hasNext() {
                return aux != null;} 
            @Override
            public T next() {
                T  nextObject = (T) aux.getData();
                aux = aux.getNext();
                return nextObject;}
        };
        return iterator;
    }

    @Override//5
    public Object[] toArray() {
        Object[] arrayObjects = new Object[size()];
        int index = 0;
 
        if(!isEmpty()){
         Node aux = head;
         while(aux != null){
        arrayObjects[index] = aux.getData();
        index++;
        aux = aux.getNext();
     } 
 }
  return arrayObjects;
    }

    @Override//6
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override//7
    public boolean add(Object e) {
        boolean objectAdded = false;
        if(isEmpty()){
            head = new Node(e);
            objectAdded = true;}else{
            Node aux = head;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(new Node(e));
            objectAdded = true;}
        return objectAdded;
    }
  
    @Override//8
    public boolean remove(Object o) {
        boolean removed = false;
        if(isEmpty()){
            return removed;
        }if(head.getData().equals(o)){
            head = head.getNext();
            removed = true;
        }else{
            removed = removeFromBody(o);
        }
           return removed;
   }

     private boolean removeFromBody(Object o) {
            Node aux = head;
        
        while (aux.getNext() != null) {
            if (aux.getNext().getData().equals(o)) {
                aux.setNext(aux.getNext().getNext()); 
                return true; 
            }
                aux = aux.getNext();
       }
            return false; 
    }

    @Override//9
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override//10
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override//11
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override//12
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override//13
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override//14
    public void clear() {
       head = null;
    }

    @Override//15
    public T get(int index) {
        int counter = 0;
        T toReturn = null;
        if(index <0 )
        return null;
        Node aux = head;
        while (aux != null) {
            if (counter == index) 
            toReturn = (T) aux.getData();
            aux = aux.getNext();
            counter++;
        }
      return toReturn;
    }

    @Override//16
    public Object set(int index, Object element) {
        Node aux=head;
        T delete=null;
        if(0 == index) {
            delete=(T) head.getData();
            head.setData(element);}else{
        for (int inde = 0; aux != null; inde++) {
            if (inde == index) {
                delete=(T) aux.getData();
                aux.setData(element);}
            aux=aux.getNext();
        } } 
        return delete;
    }

    @Override//17
    public void add(int index, Object element) {
        Node aux=head;
        Node aux2=aux;
        if(0 == index) {
            head=new Node(element);  
            head.setNext(aux);}else{
            for (int inde = 0; aux != null; inde++) {
                if (inde == index) {
                    aux2.setNext(new Node(element));
                    aux2.getNext().setNext(aux);} 
                aux2=aux;
                aux=aux.getNext();
            }
        }
    }

    @Override//18
    public T remove(int index) {
        Node aux=head;
        Node aux2= new Node<T>();
        T delete=null;
        if(0 == index) {
            delete=(T) aux.getData();
            aux=aux.getNext();
            head=aux;}else{
        for (int inde = 0; aux != null; inde++) {
            if (inde == index) {
                aux2.setNext(aux.getNext());
                delete=(T) aux.getData();}
                aux2=aux;
                aux=aux.getNext();}}
        return delete;
    }

    @Override//19
    public int indexOf(Object o) {
        Node aux = head;
        int index=-1;
        int x=0;
        for(int i=0; aux != null && x==0; i++){
            if(aux.getData().equals(o)){
                index=i;
                x=1;
            }
            aux = aux.getNext();
        }
        return index;
    }

    @Override//20
    public int lastIndexOf(Object o) {
        Node aux = head;
        int index=-1;
        for(int i=0; aux != null; i++){
            if(aux.getData().equals(o)){
                index=i;
            }
            aux = aux.getNext();
        }
        return index;
    }

    @Override//21
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override//22
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override//23
    public List subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

}
