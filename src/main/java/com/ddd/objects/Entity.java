package com.ddd.objects;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public abstract class Entity<T> {
    private T _id;

    protected Entity() {
    }

    protected Entity(T id) {
        _id = requireNonNull(id, "id cannot be null");
    }

    public T getId() {
        return _id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Entity<T> that = (Entity<T>) obj;

        return Objects.equals(this._id, that._id);
    }
}
