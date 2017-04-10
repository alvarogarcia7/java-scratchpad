package com.example.scratchpad.circularlist;

import java.util.Optional;

import static java.util.Optional.empty;

public class CircularList<D> {

    private Optional<Node> current;
    private Optional<Node> last;

    public CircularList () {
        this.current = empty();
        this.last = empty();
    }

    public void add (D value) {
        final Node newNode = new Node(value);
        if (!last.isPresent()) {
            setAsOnlyValue(newNode);
            current = last;
        } else {
            appendAndLink(newNode);
            last = Optional.of(newNode);
        }
        System.out.println(this.toString());
    }

    private void appendAndLink (final Node newNode) {
        newNode.next = last.get().next;
        last.get().next = newNode;
    }

    private void setAsOnlyValue (final Node newNode) {
        newNode.next = newNode;
        last = Optional.of(newNode);
    }

    public D next (){
        if(!current.isPresent()){
            return null;
        }
        final Node previous = current.get();
        current = Optional.of(previous.next);
        return previous.value;
    }

    @Override
    public String toString () {
        if (!current.isPresent()) {
            return "empty";
        }

        final Node initialNode= current.get();
        Node currentNode = initialNode;
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


    private class Node {
        private final D value;
        private Node next;

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
