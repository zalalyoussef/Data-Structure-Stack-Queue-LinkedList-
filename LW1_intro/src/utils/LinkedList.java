package utils;



import java.util.Iterator;

/*
Implement all interface methods based on a linked list.
Do not use the java class LinkedList <E>, try to write all the logic yourself.
Additional methods and variables can be developed as needed.
*/
public class LinkedList<T extends Comparable<T>> implements List<T>
{


    int Count;

    public static class NodeStudent<T> {
        private T Data;
        private NodeStudent<T> Next;
        private NodeStudent<T> Previous;

        private NodeStudent(T data) {

        }

        private NodeStudent(T data, NodeStudent<T> N_Address, NodeStudent<T> P_Address) {
            this.Data = data;
            this.Next = N_Address;
            this.Previous = P_Address;
        }

    }

    public NodeStudent<T> head;
    public NodeStudent<T> tail;


    public LinkedList() {
        this.head = null;
        this.tail = null;

    }

    @Override
    public void add(T item) {
        NodeStudent<T> p = new NodeStudent<T>(item, null, tail);
        if (tail != null)
            tail.Next = p;
        else
            head = p;
        tail = p;
        Count++;
    }

    @Override
    public T get(int index) {
        NodeStudent<T> current;
        int i = 0;

        for (NodeStudent<T> dd = head; dd != null; dd = dd.Next) {
            if (i == index) {
                current = dd;
                return current.Data;
            }
            i++;
        }
        assert (false);
        return null;
    }

    @Override
    public boolean remove(T item)
    {
        NodeStudent<T> r = head;
        boolean found = false;

        while (r != null) {
            if (r.Data.equals(item)) {
                found = true;
                if (r == head)
                    head = head.Next;
                if (r == tail)
                    tail = tail.Previous;
                if (r.Previous != null)
                    r.Previous.Next = r.Next;
                if (r.Next != null)
                    r.Next.Previous = r.Previous;
                Count--;
            }
            r = r.Next;
        }
        return found;
    }

   @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            int currentIndex = 0;

            @Override
            public boolean hasNext()
            {
               return currentIndex < Count && get(currentIndex) != null;
            }

            @Override
            public T next()
            {
                 return get(currentIndex++);
            }
        };
    }

    public boolean isEmpty()
    {
        if(head == null)
            return true;
        else
            return false;
    }

    //Specified Task
    @Override
    public boolean Remove(Object o)
    {
        NodeStudent<T> r = head;
        boolean found = false;

        while (r != null) {
            if (r.Data.equals(o) && found!=true) {
                found = true;
                if (r == head)
                    head = head.Next;
                if (r == tail)
                    tail = tail.Previous;
                if (r.Previous != null)
                    r.Previous.Next = r.Next;
                if (r.Next != null)
                    r.Next.Previous = r.Previous;
                Count--;
            }
            r = r.Next;
        }
        return found;
    }

    @Override
    public T set(int index,T element)
    {
        NodeStudent<T> r = head;
        while (r != null)
        {
            if (r.Data.equals(get(index)))
            {
                r.Data=element;
            }
            r=r.Next;
        }
        return element;
    }
    public void Sort()
    {
        for ( NodeStudent<T> s1 = head; s1 != null; s1 = s1.Next)
        {
             NodeStudent<T> maxv = s1;
            for ( NodeStudent<T> s2 = s1; s2 != null; s2 = s2.Next)
                if (s2.Data.compareTo(maxv.Data) < 0)
                    maxv = s2;
            T temp = s1.Data;
            s1.Data = maxv.Data;
            maxv.Data = temp;
        }
    }
}


