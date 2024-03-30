package com.hypersrot.shoppingapp.customAnnotation;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class CustomIdGenerator implements IdentifierGenerator {
    private static final AtomicLong counter = new AtomicLong(0);

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        long id = counter.incrementAndGet();
        return "tran" + String.format("%09d", id);
    }
}
