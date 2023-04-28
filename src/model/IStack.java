package model;
import Exception.StackException;

public interface IStack <T> {

        public boolean isEmpty();

        public T top() throws StackException;

        public void push(T obj);

        public void pop() throws StackException;
}
