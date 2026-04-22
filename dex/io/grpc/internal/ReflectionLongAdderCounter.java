package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ReflectionLongAdderCounter implements LongCounter {
    private static final Method addMethod;
    private static final Constructor<?> defaultConstructor;
    private static final RuntimeException initializationException;
    private static final Logger logger = Logger.getLogger(ReflectionLongAdderCounter.class.getName());
    private static final Object[] one;
    private static final Method sumMethod;
    private final Object instance;

    static {
        Constructor<?> defaultConstructorLookup = null;
        Method addMethodLookup = null;
        Method sumMethodLookup = null;
        Throwable caught = null;
        try {
            Class<?> klass = Class.forName("java.util.concurrent.atomic.LongAdder");
            addMethodLookup = klass.getMethod("add", Long.TYPE);
            sumMethodLookup = klass.getMethod("sum", new Class[0]);
            Constructor<?>[] constructors = klass.getConstructors();
            int length = constructors.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Constructor<?> ctor = constructors[i2];
                if (ctor.getParameterTypes().length != 0) {
                    i2++;
                } else {
                    defaultConstructorLookup = ctor;
                    break;
                }
            }
        } catch (Throwable e2) {
            logger.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", e2);
            caught = e2;
        }
        if (caught == null && defaultConstructorLookup != null) {
            defaultConstructor = defaultConstructorLookup;
            addMethod = addMethodLookup;
            sumMethod = sumMethodLookup;
            initializationException = null;
        } else {
            defaultConstructor = null;
            addMethod = null;
            sumMethod = null;
            initializationException = new RuntimeException(caught);
        }
        one = new Object[]{1L};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectionLongAdderCounter() {
        if (initializationException != null) {
            throw initializationException;
        }
        try {
            this.instance = defaultConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAvailable() {
        return initializationException == null;
    }

    @Override // io.grpc.internal.LongCounter
    public void add(long delta) {
        try {
            addMethod.invoke(this.instance, delta == 1 ? one : new Object[]{Long.valueOf(delta)});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // io.grpc.internal.LongCounter
    public long value() {
        try {
            return ((Long) sumMethod.invoke(this.instance, new Object[0])).longValue();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException();
        } catch (InvocationTargetException e3) {
            throw new RuntimeException();
        }
    }
}