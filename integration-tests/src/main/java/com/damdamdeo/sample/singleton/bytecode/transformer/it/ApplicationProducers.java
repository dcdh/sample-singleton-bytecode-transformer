package com.damdamdeo.sample.singleton.bytecode.transformer.it;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

public class ApplicationProducers {
    // Working but want to avoid definition
    /*
    @Produces
    @Singleton
    public SayHelloCommandHandler sayHelloCommandHandler() {
        return new SayHelloCommandHandler();
    }*/
}
