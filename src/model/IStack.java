package model;
import Exception.StackException;

public interface IStack <T> {

        public boolean isEmpty();

        public T top() throws StackException;

        public void push(T value);

        public T pop() throws StackException;
}
