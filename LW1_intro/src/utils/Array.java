package utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
public class Array<T> implements List<T>
{

    public ArrayList<T> array;

    public Array()
    {
        array = new ArrayList<T>();
    }

    @Override
    public void add(T item)
    {
        array.add(item);
    }

    @Override
    public T get(int index)
    {
        return array.get(index);
    }

    @Override
    public boolean remove(T item)
    {
        return array.remove(item);
    }

    @Override
    public boolean Remove(Object o)
    {

        return false;
    }

    @Override
    public T set(int index, T element) {
        return null;
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
                return currentIndex < array.size() && array.get(currentIndex) != null;
            }

            @Override
            public T next()
            {
                return array.get(currentIndex++);
            }
        };
    }
}
