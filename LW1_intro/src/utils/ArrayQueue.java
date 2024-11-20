package utils;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>{

    private int front, rear;
    private T[] QArray;

    int max=20;


    public ArrayQueue()
    {
        this.front=this.rear=-1;
        this.QArray= (T[]) new Object[max];
    }
    @Override
    public void Enqueue(T item)
    {
        if (isFull())
        {
            resize();
        }
        if(isEmpty()){
            front++;
        }
        QArray[++rear] = item;
    }
    private void resize() {
        int newSize = QArray.length * 2;
        var tempArray = (T[]) new Object[newSize];

        for (int i = 0; i < QArray.length; i++) {
            tempArray[i] = QArray[i];
        }
        QArray = tempArray;
    }

    @Override
    public T Dequeue()
    {
        if(isEmpty())
            throw new NoSuchElementException();

        var temp = QArray[front];
        if (front==rear)
            front = rear = -1;
        else
            front++;
        return temp;

    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        return QArray[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull()
    {
        return rear == QArray.length-1;
    }
}
