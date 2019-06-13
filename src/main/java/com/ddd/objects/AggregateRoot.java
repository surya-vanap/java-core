package com.ddd.objects;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ddd.events.IDomainEvent;

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
