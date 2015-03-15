package com.gmaur.hamcrestmatcher.primes;

import org.junit.Test;

import static com.gmaur.hamcrestmatcher.primes.PrimeMatcher.prime;
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

	@Test
	public void detect_any_2n_greater_than_2_as_non_prime () {
		for(int i = 2 ; i<100; i++) {
			assertThat(2 * i, is(not(prime())));
		}
	}

	@Test
	public void detect_any_3n_greater_than_3_as_non_prime () {
		for(int i =  2; i<100; i++) {
			assertThat(3 * i, is(not(prime())));
		}
	}

	@Test
	public void detect_negative_primes () {
		assertThat(-5, is(prime()));
	}


}
