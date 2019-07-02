package com.core.ddd;

public interface IDomainEventHandler<T extends IDomainEvent> {
    void Handle(T domainEvent);
}
