package io.grpc;

import io.grpc.ServiceProviders;
import java.util.List;

public final class InternalServiceProviders {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface PriorityAccessor<T> extends ServiceProviders.PriorityAccessor<T> {
    }

    private InternalServiceProviders() {
    }

    public static <T> T load(Class<T> klass, Iterable<Class<?>> hardcoded, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        return (T) ServiceProviders.load(klass, hardcoded, classLoader, priorityAccessor);
    }

    public static <T> List<T> loadAll(Class<T> klass, Iterable<Class<?>> hardCodedClasses, ClassLoader classLoader, PriorityAccessor<T> priorityAccessor) {
        return ServiceProviders.loadAll(klass, hardCodedClasses, classLoader, priorityAccessor);
    }

    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> klass, ClassLoader cl) {
        return ServiceProviders.getCandidatesViaServiceLoader(klass, cl);
    }

    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> klass, Iterable<Class<?>> hardcoded) {
        return ServiceProviders.getCandidatesViaHardCoded(klass, hardcoded);
    }

    public static boolean isAndroid(ClassLoader cl) {
        return ServiceProviders.isAndroid(cl);
    }
}