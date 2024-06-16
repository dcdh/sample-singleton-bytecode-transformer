package com.damdamdeo.sample.singleton.bytecode.transformer.deployment;

import com.damdamdeo.sample.singleton.bytecode.transformer.runtime.CommandHandler;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.ApplicationIndexBuildItem;
import io.quarkus.deployment.builditem.BytecodeTransformerBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.jboss.jandex.DotName;

class SampleSingletonBytecodeTransformerProcessor {

    private static final String FEATURE = "sample-singleton-bytecode-transformer";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    void registerCommandHandlersAsSingletonBean(final ApplicationIndexBuildItem applicationIndexBuildItem,
                                                final BuildProducer<BytecodeTransformerBuildItem> bytecodeTransformerBuildItemProducer) {
        applicationIndexBuildItem.getIndex()
                .getAllKnownImplementors(DotName.createSimple(CommandHandler.class))
                .forEach(classInfo ->
                        bytecodeTransformerBuildItemProducer.produce(
                                new BytecodeTransformerBuildItem.Builder()
                                        .setClassToTransform(classInfo.name().toString())
                                        .setVisitorFunction((s, classVisitor) -> // NOT CALLED :/
                                                new AddSingletonAnnotationClassVisitor(classVisitor))
                                        .setCacheable(true)
                                        .build()
                        )
                );
    }

}
