package com.gmaur.hamcrestmatcher.primes;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
* Created by alvaro on 15/03/15.
*/
public class PrimeSmallerThan4 extends TypeSafeMatcher<Integer> {

	@Override
	protected boolean matchesSafely(Integer item) {
		return item == 2 || item == 3;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("a prime");
	}

	@Override
	protected void describeMismatchSafely (final Integer item, final Description mismatchDescription) {
		mismatchDescription.appendText(item+" is the product of two prime factors");
	}

	public static <T> Matcher<Integer> prime () {
		return new PrimeSmallerThan4();
	}
}
