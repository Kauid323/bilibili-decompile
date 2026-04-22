package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: NameResolverUtil.kt */
public final class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver $this$getClassId, int index) {
        Intrinsics.checkNotNullParameter($this$getClassId, "<this>");
        return ClassId.Companion.fromString($this$getClassId.getQualifiedClassName(index), $this$getClassId.isLocalClassName(index));
    }

    public static final Name getName(NameResolver $this$getName, int index) {
        Intrinsics.checkNotNullParameter($this$getName, "<this>");
        Name guessByFirstCharacter = Name.guessByFirstCharacter($this$getName.getString(index));
        Intrinsics.checkNotNullExpressionValue(guessByFirstCharacter, "guessByFirstCharacter(...)");
        return guessByFirstCharacter;
    }
}