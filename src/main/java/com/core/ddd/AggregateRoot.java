package com.core.ddd;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot<K> extends Entity<K> {

	private List<IDomainEvent> pendingEvents = new ArrayList<>();

	public List<IDomainEvent> getPendingEvents() {
		return Collections.unmodifiableList(pendingEvents);
	}

	protected void register(IDomainEvent event) {
		requireNonNull(event, "event cannot be null");
		pendingEvents.add(event);
	}
}
