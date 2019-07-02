package com.core.ddd.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.core.ddd.ValueObject;
import com.core.utils.Result;

/**
 * Tests for {@link ValueObject} class
 *
 */
public class ValueObjectTest {

	/**
	 * This tests that create results in success with a valid age
	 */
	@Test
	public void test_create_with_valid_age() {
		// arrange

		// act
		final Result<Age> result = Age.Create(10);

		// assert
		assertFalse(result.isError());
	}

	/**
	 * This tests that create fails with an invalid age
	 */
	@Test
	public void test_create_with_invalid_age() {
		// arrange

		// act
		final Result<Age> result = Age.Create(-10);

		// assert
		assertTrue(result.isError());
	}

	/**
	 * This tests that two age objects with same value are equal
	 */
	@Test
	public void test_equals_same_value() {
		// arrange
		final Age age1 = Age.Create(10).getValue();
		final Age age2 = Age.Create(10).getValue();

		// act

		// assert
		assertTrue(age1.equals(age2));
	}

	/**
	 * This tests that two age objects with different values are equal
	 */
	@Test
	public void test_equals_different_values() {
		// arrange
		final Age age1 = Age.Create(10).getValue();
		final Age age2 = Age.Create(11).getValue();

		// act

		// assert
		assertFalse(age1.equals(age2));
	}

	/**
	 * This tests that two age objects with same value have same hashcode
	 */
	@Test
	public void test_hashcode() {
		// arrange
		final Map<Age, String> ageNameMap = new HashMap<>();
		ageNameMap.put(new Age(12), "Anne");
		ageNameMap.put(new Age(15), "Brian");

		final Age lookupAge = new Age(12);

		// act
		final String name = ageNameMap.get(lookupAge);

		// assert
		assertTrue(name.equals("Anne"));
	}

	/**
	 * Dummy value object to exercise ValueObject methods
	 *
	 */
	private static class Age extends ValueObject {
		private static final long serialVersionUID = 1L;

		private int _value;
		private static final int MAX_AGE = 100;

		private Age(int value) {
			_value = value;
		}

		public static Result<Age> Create(int value) {

			if (value < 0)
				return Result.error("age cannot be negative");

			if (value > MAX_AGE)
				return Result.error("age cannot be more than -" + MAX_AGE);

			return Result.ok(new Age(value));
		}
	}
}
