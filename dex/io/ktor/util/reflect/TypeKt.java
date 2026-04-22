package io.ktor.util.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: Type.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\u0081\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "()Lio/ktor/util/reflect/TypeInfo;", "Lkotlin/reflect/KType;", "typeOfOrNull", "()Lkotlin/reflect/KType;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TypeKt {
    public static final /* synthetic */ <T> TypeInfo typeInfo() {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        return new TypeInfo(orCreateKotlinClass, null);
    }

    public static final /* synthetic */ <T> KType typeOfOrNull() {
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        return null;
    }
}