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
		if(item < 2){
			return false;
		}
		for(int i = 2; i<item; i++){
			if(item % i == 0){
				return false;
			}
		}
		return true;
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
