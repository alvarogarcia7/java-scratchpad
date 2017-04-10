package com.example.scratchpad.circularlist;

import java.util.Optional;

import static java.util.Optional.empty;

public class CircularList<D> {

    private Optional<Node<D>> current;
    private Optional<Node<D>> last;

    public CircularList () {
        this.current = empty();
        this.last = empty();
    }

    public void add (D value) {
        final Node newNode = new Node(value);
        if (!last.isPresent()) {
            newNode.next = newNode;
            last = Optional.of(newNode);
            current = last;
        } else {
            newNode.next = last.get().next;
            last.get().next = newNode;
            last = Optional.of(newNode);
        }
        System.out.println(this.toString());
    }

    public D next (){
        if(!current.isPresent()){
            return null;
        }
        final Node<D> previous = current.get();
        current = Optional.of(previous.next);
        return previous.value;
    }

    @Override
    public String toString () {
        if (!current.isPresent()) {
            return "empty";
        }

        final Node<D> initialNode= current.get();
        Node<D> currentNode = initialNode;
        StringBuffer stringBuffer = new StringBuffer();

        while(true){
            stringBuffer.append(currentNode.toString());
            currentNode = currentNode.next;
            if (currentNode != initialNode) {
                stringBuffer.append("=>");
            } else {
                break;
            }

        }
        return stringBuffer.toString();
    }


    private class Node<D> {
        private final D value;
        private Node<D> next;

        public Node (final D value) {
            this.value = value;
        }

        @Override
        public String toString () {
            final StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }
    }
}
