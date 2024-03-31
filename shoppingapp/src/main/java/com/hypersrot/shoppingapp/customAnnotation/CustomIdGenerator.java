package com.hypersrot.shoppingapp.customAnnotation;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.Random;
>>>>>>> 58a629aba6cce99d2583d13359768c7b3bb7d53f
import java.util.concurrent.atomic.AtomicLong;

public class CustomIdGenerator implements IdentifierGenerator {
    private static final AtomicLong counter = new AtomicLong(0);

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        long id = counter.incrementAndGet();
        return "tran" + String.format("%09d", id);
    }
}
