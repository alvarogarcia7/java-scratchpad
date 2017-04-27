package com.example.scratchpad.circularlist.test;

import com.example.scratchpad.circularlist.CircularList;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

public class CircularListShould {

    private CircularList<DomainObject> circularList;

    @Before
    public void setUp () throws Exception {
        circularList = new CircularList<>();
    }

    @Test
    public void contain_no_element_by_default () {
        assertThatNextIs(is(nullValue()));
    }

    @Test
    public void with_one_element_the_returned_element_is_always_the_same () {
        final DomainObject value = value(1);

        add(value);

        assertThatNextIs(sameInstance(value));
        assertThatNextIs(sameInstance(value));
    }

    @Test
    public void with_two_elements_the_list_circles () {
        final DomainObject value1 = value(1);
        final DomainObject value2 = value(2);

        add(value1);
        add(value2);

        assertThatNextIs(sameInstance(value1));
        assertThatNextIs(sameInstance(value2));
        assertThatNextIs(sameInstance(value1));
    }

    @Test
    public void with_multiple_elements_the_list_circles () {
        final DomainObject value1 = value(1);
        final DomainObject value2 = value(2);
        final DomainObject value3 = value(3);
        final DomainObject value4 = value(4);

        add(value1);
        add(value2);
        add(value3);
        add(value4);

        assertThatNextIs(sameInstance(value1));
        assertThatNextIs(sameInstance(value2));
        assertThatNextIs(sameInstance(value3));
        assertThatNextIs(sameInstance(value4));
        assertThatNextIs(sameInstance(value1));
    }

    @Test
    public void adding_is_always_at_the_end () {
        final DomainObject value1 = value(1);
        final DomainObject value2 = value(2);
        final DomainObject value3 = value(3);
        final DomainObject value4 = value(4);
        final DomainObject value5 = value(5);

        add(value1);
        assertThatNextIs(sameInstance(value1));
        assertThatNextIs(sameInstance(value1));
        assertThatNextIs(sameInstance(value1));
        add(value2);
        assertThatNextIs(sameInstance(value1));
        assertThatNextIs(sameInstance(value2));
        assertThatNextIs(sameInstance(value1));
        add(value3);
        assertThatNextIs(sameInstance(value2));
        assertThatNextIs(sameInstance(value3));
        add(value4);
        assertThatNextIs(sameInstance(value1));
        assertThatNextIs(sameInstance(value2));
        assertThatNextIs(sameInstance(value3));
        assertThatNextIs(sameInstance(value4));
        assertThatNextIs(sameInstance(value1));
        add(value5);
        assertThatNextIs(sameInstance(value2));
    }

    private DomainObject value (final int representation) {
        return new DomainObject(representation);
    }

    private void assertThatNextIs (final Matcher<Object> matcher) {
        assertThat(this.circularList.next(), matcher);
    }

    private void add (final DomainObject value1) {
        circularList = circularList.add(value1);
    }
}
