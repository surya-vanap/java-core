package com.ddd.events;

public interface IDomainEventHandler<T extends IDomainEvent> {
    void Handle(T domainEvent);
}
