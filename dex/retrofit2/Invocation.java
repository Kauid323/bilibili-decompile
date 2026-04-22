package retrofit2;

import j$.util.Objects;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    public static Invocation of(Method method, List<?> arguments) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(arguments, "arguments == null");
        return new Invocation(method, new ArrayList(arguments));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Invocation(Method method, List<?> arguments) {
        this.method = method;
        this.arguments = Collections.unmodifiableList(arguments);
    }

    public Method method() {
        return this.method;
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments);
    }
}