package io.grpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ServiceProviders {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface PriorityAccessor<T> {
        int getPriority(T t);

        boolean isAvailable(T t);
    }

    private ServiceProviders() {
    }

    public static <T> T load(Class<T> klass, Iterable<Class<?>> hardcoded, ClassLoader cl, PriorityAccessor<T> priorityAccessor) {
        List<T> candidates = loadAll(klass, hardcoded, cl, priorityAccessor);
        if (candidates.isEmpty()) {
            return null;
        }
        return candidates.get(0);
    }

    public static <T> List<T> loadAll(Class<T> klass, Iterable<Class<?>> hardcoded, ClassLoader cl, final PriorityAccessor<T> priorityAccessor) {
        Iterable<T> candidates;
        if (isAndroid(cl)) {
            candidates = getCandidatesViaHardCoded(klass, hardcoded);
        } else {
            candidates = getCandidatesViaServiceLoader(klass, cl);
        }
        List<T> list = new ArrayList<>();
        for (T current : candidates) {
            if (priorityAccessor.isAvailable(current)) {
                list.add(current);
            }
        }
        Collections.sort(list, Collections.reverseOrder(new Comparator<T>() { // from class: io.grpc.ServiceProviders.1
            @Override // java.util.Comparator
            public int compare(T f1, T f2) {
                int pd = PriorityAccessor.this.getPriority(f1) - PriorityAccessor.this.getPriority(f2);
                if (pd != 0) {
                    return pd;
                }
                return f1.getClass().getName().compareTo(f2.getClass().getName());
            }
        }));
        return Collections.unmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAndroid(ClassLoader cl) {
        try {
            Class.forName("android.app.Application", false, cl);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> klass, ClassLoader cl) {
        Iterable<T> i2 = ServiceLoader.load(klass, cl);
        if (!i2.iterator().hasNext()) {
            return ServiceLoader.load(klass);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> klass, Iterable<Class<?>> hardcoded) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> candidate : hardcoded) {
            arrayList.add(create(klass, candidate));
        }
        return arrayList;
    }

    static <T> T create(Class<T> klass, Class<?> rawClass) {
        try {
            return (T) rawClass.asSubclass(klass).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable t) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", rawClass.getName(), t), t);
        }
    }
}