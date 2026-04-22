package kotlin.reflect.jvm.internal.impl.km;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Annotations.kt */
public final class KmAnnotation {
    private final Map<String, KmAnnotationArgument> arguments;
    private final String className;

    /* JADX WARN: Multi-variable type inference failed */
    public KmAnnotation(String className, Map<String, ? extends KmAnnotationArgument> arguments) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.className = className;
        this.arguments = arguments;
    }

    public final Map<String, KmAnnotationArgument> getArguments() {
        return this.arguments;
    }

    public final String getClassName() {
        return this.className;
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof KmAnnotation) && Intrinsics.areEqual(this.className, ((KmAnnotation) other).className) && Intrinsics.areEqual(this.arguments, ((KmAnnotation) other).arguments));
    }

    public int hashCode() {
        return (this.className.hashCode() * 31) + this.arguments.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String k = (String) pair.component1();
        KmAnnotationArgument v = (KmAnnotationArgument) pair.component2();
        return k + " = " + v;
    }

    public String toString() {
        String args = CollectionsKt.joinToString$default(MapsKt.toList(this.arguments), null, null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.km.KmAnnotation$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence string$lambda$0;
                string$lambda$0 = KmAnnotation.toString$lambda$0((Pair) obj);
                return string$lambda$0;
            }
        }, 31, null);
        return '@' + this.className + '(' + args + ')';
    }
}