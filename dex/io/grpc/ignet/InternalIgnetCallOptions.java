package io.grpc.ignet;

import io.grpc.CallOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class InternalIgnetCallOptions {
    public static final CallOptions.Key<Collection<Object>> IGNET_ANNOTATIONS_KEY = CallOptions.Key.create("ignet-annotations");

    private InternalIgnetCallOptions() {
    }

    public static CallOptions withAnnotation(CallOptions callOptions, Object annotation) {
        return withAnnotationIn(callOptions, annotation);
    }

    static CallOptions withAnnotationIn(CallOptions callOptions, Object annotation) {
        ArrayList<Object> newAnnotations;
        Collection<Object> existingAnnotations = (Collection) callOptions.getOption(IGNET_ANNOTATIONS_KEY);
        if (existingAnnotations == null) {
            newAnnotations = new ArrayList<>();
        } else {
            newAnnotations = new ArrayList<>(existingAnnotations);
        }
        newAnnotations.add(annotation);
        return callOptions.withOption(IGNET_ANNOTATIONS_KEY, Collections.unmodifiableList(newAnnotations));
    }

    public static Collection<Object> getAnnotations(CallOptions callOptions) {
        Collection<Object> annotations = (Collection) callOptions.getOption(IGNET_ANNOTATIONS_KEY);
        if (annotations == null) {
            return Collections.emptyList();
        }
        return annotations;
    }
}