/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.spr.stream.api;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;
import akka.stream.javadsl.Source;

import static com.lightbend.lagom.javadsl.api.Service.*;

/**
 * The stream interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the HelloStream service.
 */
public interface StreamService extends Service {

    ServiceCall<Source<String, NotUsed>, Source<String, NotUsed>> stream();

    @Override
    default Descriptor descriptor() {
        return named("stream").withCalls(namedCall("stream", this::stream))
                .withAutoAcl(true);
    }
}
