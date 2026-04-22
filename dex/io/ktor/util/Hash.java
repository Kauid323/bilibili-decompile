package io.ktor.util;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Hash.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004\"\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/Hash;", "", "<init>", "()V", "", "objects", "", "combine", "([Ljava/lang/Object;)I", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Hash {
    public static final Hash INSTANCE = new Hash();

    private Hash() {
    }

    public final int combine(Object... objects) {
        Intrinsics.checkNotNullParameter(objects, "objects");
        return ArraysKt.toList(objects).hashCode();
    }
}