package com.gmaur.scratchpad.hamcrestmatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static com.gmaur.scratchpad.hamcrestmatcher.HamcrestMatchersShould.PrimeSmallerThan4.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by alvaro on 01/03/15.
 */
public class HamcrestMatchersShould {

	@Test
	public void detect_2_as_prime () {
		assertThat(2, is(prime()));
	}

	@Test
	public void detect_3_as_prime () {
		assertThat(3, is(prime()));
	}

	@Test
	public void not_detect_1_as_prime () {
		assertThat(1, is(not(prime())));
	}

	@Test
	public void not_detect_0_as_prime () {
		assertThat(0, is(not(prime())));
	}

	public static class PrimeSmallerThan4 extends TypeSafeMatcher<Integer> {

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


}
