package model;
import Exception.StackException;

public class Stack <T> implements IStack<T> {

    private Node<T> first; //Representa el primer elemento de la pila

    @Override
    public boolean isEmpty() {
        if (first == null) {
            return true;
        } else
            return false;
    }

    @Override
    public T top() throws StackException{ //Me retorna el primer elemento de la pila
        if(isEmpty()){
            throw new StackException();
        }
        return first.getValue();
    }


    @Override
    public void push(T obj) {
        Node<T> node = new Node<>(obj); //Añado un nodo que contiene un dato generico a la pila
        node.setNext(first); //El siguiente nodo al nodo entrante es el primero// nodo -> first
        first = node; //El nodo entrante es el primero// first -> Otro nodo random
    }
    @Override
    public void pop() throws StackException{ //Me retorna el primer elemento de la pila
        if(isEmpty()){
            throw new StackException();
        }
        first = first.getNext(); //Cuando reasigno, borro, nada me queda apuntando al nodo que antes era el primero.
    }
}

