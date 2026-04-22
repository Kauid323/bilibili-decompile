package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ClassName.kt */
public final class ClassNameKt {
    public static final boolean isLocalClassName(String $this$isLocalClassName) {
        Intrinsics.checkNotNullParameter($this$isLocalClassName, "<this>");
        return StringsKt.startsWith$default($this$isLocalClassName, ".", false, 2, (Object) null);
    }
}