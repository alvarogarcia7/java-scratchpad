package com.example.scratchpad.circularlist.test;

import org.junit.Test;

public class CircularListShould {
    @Test
    public void contain_no_element_by_default () {
        final CircularList<DomainObject> circularList = new CircularList<DomainObject>();
        org.hamcrest.MatcherAssert.assertThat(circularList.next(), null);
    }
}
