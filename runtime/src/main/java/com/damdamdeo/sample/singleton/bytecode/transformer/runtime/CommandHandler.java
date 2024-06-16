package com.damdamdeo.sample.singleton.bytecode.transformer.runtime;

public interface CommandHandler<O> {
    O handle(Command command);
}
