package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
public final class BuiltinSpecialPropertiesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final FqName child(FqName $this$child, String name) {
        Name identifier = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return $this$child.child(identifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FqName childSafe(FqNameUnsafe $this$childSafe, String name) {
        Name identifier = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return $this$childSafe.child(identifier).toSafe();
    }
}