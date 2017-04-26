package com.example.scratchpad.circularlist.test;

import com.example.scratchpad.circularlist.CircularList;
import org.junit.Before;
import org.junit.Test;

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
        final CircularList<DomainObject> circularList = new CircularList<>();
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), is(nullValue()));
    }

    @Test
    public void with_one_element_the_returned_element_is_always_the_same () {
        final DomainObject value = new DomainObject(1);
        circularList.add(value);
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value));
    }

    @Test
    public void with_two_elements_the_list_circles () {
        final DomainObject value1 = new DomainObject(1);
        final DomainObject value2 = new DomainObject(2);

        circularList.add(value1);
        circularList.add(value2);

        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value2));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
    }

    @Test
    public void with_multiple_elements_the_list_circles () {
        final DomainObject value1 = new DomainObject(1);
        final DomainObject value2 = new DomainObject(2);
        final DomainObject value3 = new DomainObject(3);
        final DomainObject value4 = new DomainObject(4);

        circularList.add(value1);
        circularList.add(value2);
        circularList.add(value3);
        circularList.add(value4);

        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value2));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value3));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value4));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
    }

    @Test
    public void mix_of_add_and_next () {
        final DomainObject value1 = new DomainObject(1);
        final DomainObject value2 = new DomainObject(2);
        final DomainObject value3 = new DomainObject(3);
        final DomainObject value4 = new DomainObject(4);
        final DomainObject value5 = new DomainObject(5);

        circularList.add(value1);
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        circularList.add(value2);
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value2));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        circularList.add(value3);
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value2));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value3));
        circularList.add(value4);
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value2));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value3));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value4));
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value1));
        circularList.add(value5);
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), sameInstance(value2));
    }
}
