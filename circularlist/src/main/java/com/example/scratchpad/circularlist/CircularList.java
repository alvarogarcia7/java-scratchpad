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

    public CircularList<D> add (D value) {
        final Node newNode = new Node(value);
        if (!last.isPresent()) {
            setAsOnlyValue(newNode);
        } else {
            appendAndLink(newNode);
        }
        System.out.println(this.toString());
        return this;
    }

    private void appendAndLink (final Node newNode) {
        newNode.next = last.get().next;
        last.get().next = newNode;
        last = Optional.of(newNode);
    }

    private void setAsOnlyValue (final Node newNode) {
        newNode.next = newNode;
        last = Optional.of(newNode);
        current = last;
    }

    public D next (){
        final Node previous = current.get();
        current = Optional.of(previous.next);
        return previous.value;
    }

    @Override
    public String toString () {
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

    public static <D> CircularList<D> empty_ () {
        return new EmptyCircularList<>();
    }

    private static class EmptyCircularList<D> extends CircularList<D> {
        @Override
        public CircularList<D> add (final D value) {
            final CircularList<D> circularList = new CircularList<>();
            return circularList.add(value);
        }

        @Override
        public D next () {
            return null;
        }

        @Override
        public String toString () {
            return "empty";
        }
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
