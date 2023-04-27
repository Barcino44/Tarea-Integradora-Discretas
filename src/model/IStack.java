package model;

public interface IStack <T> {

        public boolean isEmpty();

        public T top();

        public void push(T obj);

        public T pop();
}
