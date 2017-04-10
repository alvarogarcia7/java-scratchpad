package com.example.scratchpad.circularlist.test;

public class DomainObject {
    private final int value;

    public DomainObject(int value) {
        this.value = value;
    }

    @Override
    public boolean equals (final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final DomainObject that = (DomainObject) o;

        return value == that.value;

    }

    @Override
    public int hashCode () {
        return value;
    }

    @Override
    public String toString () {
        final StringBuffer sb = new StringBuffer("{");
        sb.append(value);
        sb.append('}');
        return sb.toString();
    }
}
