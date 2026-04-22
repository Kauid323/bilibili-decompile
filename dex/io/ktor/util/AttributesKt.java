package io.ktor.util;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: Attributes.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b*V\b\u0007\u0010\u0016\u001a\u0004\b\u0000\u0010\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0004B6\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u001c\b\u000f\u0012\u0018\b\u000bB\u0014\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0005\u0012\u0006\b\u0012\u0012\u0002\b\f\u0012\n\b\u0013\u0012\u0006\b\n0\u00148\u0015¨\u0006\u0017"}, d2 = {"", "T", "", "name", "Lio/ktor/util/AttributeKey;", "AttributeKey", "(Ljava/lang/String;)Lio/ktor/util/AttributeKey;", "Lio/ktor/util/Attributes;", "other", "", "putAll", "(Lio/ktor/util/Attributes;Lio/ktor/util/Attributes;)V", "Lkotlin/Deprecated;", CrashHianalyticsData.MESSAGE, "Please use `AttributeKey` class instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "imports", "level", "Lkotlin/DeprecationLevel;", "ERROR", "EquatableAttributeKey", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AttributesKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use `AttributeKey` class instead", replaceWith = @ReplaceWith(expression = "AttributeKey", imports = {}))
    public static /* synthetic */ void EquatableAttributeKey$annotations() {
    }

    public static final /* synthetic */ <T> AttributeKey<T> AttributeKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            Intrinsics.reifiedOperationMarker(6, "T");
        } catch (Throwable th) {
        }
        return new AttributeKey<>(name, new TypeInfo(orCreateKotlinClass, (KType) null));
    }

    public static final void putAll(Attributes $this$putAll, Attributes other) {
        Intrinsics.checkNotNullParameter($this$putAll, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterable $this$forEach$iv = other.getAllKeys();
        for (Object element$iv : $this$forEach$iv) {
            AttributeKey it = (AttributeKey) element$iv;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            $this$putAll.put(it, other.get(it));
        }
    }
}