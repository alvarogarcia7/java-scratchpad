package com.gmaur.hamcrestmatcher.primes;

import org.junit.Test;

import static com.gmaur.hamcrestmatcher.primes.PrimeSmallerThan4.prime;
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

	@Test
	public void detect_5_as_prime () {
		assertThat(5, is(prime()));
	}


}
