package com.damdamdeo.sample.singleton.bytecode.transformer.it;

import com.damdamdeo.sample.singleton.bytecode.transformer.runtime.Command;
import com.damdamdeo.sample.singleton.bytecode.transformer.runtime.CommandHandler;
import jakarta.inject.Singleton;

// @Singleton
public class SayHelloCommandHandler implements CommandHandler<String> {
    @Override
    public String handle(final Command command) {
        return "Hello sample-singleton-bytecode-transformer";
    }
}
