package com.core.utils;

import java.util.Optional;
import java.util.function.Function;

public class Result<T> {
	private Optional<T> _value;
	private Optional<String> _error;

	private Result(T value, String error) {
		this._value = Optional.ofNullable(value);
		this._error = Optional.ofNullable(error);
	}

	public static <U> Result<U> ok(U value) {
		return new Result<>(value, null);
	}

	public static <U> Result<U> error(String error) {
		return new Result<>(null, error);
	}

	public boolean isError() {
		return _error.isPresent();
	}

	public T getValue() {
		return _value.get();
	}

	public String getError() {
		return _error.get();
	}

	public <U> Result<U> flatMap(Function<T, Result<U>> mapper) {
		if (isError()) {
			return Result.error(getError());
		}

		return mapper.apply(getValue());
	}
}
