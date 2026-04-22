package io.ktor.util;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* compiled from: Attributes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/util/AttributeKey;", "", "T", "", "name", "Lio/ktor/util/reflect/TypeInfo;", "type", "<init>", "(Ljava/lang/String;Lio/ktor/util/reflect/TypeInfo;)V", "toString", "()Ljava/lang/String;", "component1", "component2", "()Lio/ktor/util/reflect/TypeInfo;", "copy", "(Ljava/lang/String;Lio/ktor/util/reflect/TypeInfo;)Lio/ktor/util/AttributeKey;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getName", "Lio/ktor/util/reflect/TypeInfo;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AttributeKey<T> {
    private final String name;
    private final TypeInfo type;

    private final TypeInfo component2() {
        return this.type;
    }

    public static /* synthetic */ AttributeKey copy$default(AttributeKey attributeKey, String str, TypeInfo typeInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attributeKey.name;
        }
        if ((i & 2) != 0) {
            typeInfo = attributeKey.type;
        }
        return attributeKey.copy(str, typeInfo);
    }

    public final String component1() {
        return this.name;
    }

    public final AttributeKey<T> copy(String str, TypeInfo typeInfo) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(typeInfo, "type");
        return new AttributeKey<>(str, typeInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AttributeKey) {
            AttributeKey attributeKey = (AttributeKey) obj;
            return Intrinsics.areEqual(this.name, attributeKey.name) && Intrinsics.areEqual(this.type, attributeKey.type);
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.type.hashCode();
    }

    public AttributeKey(String name, TypeInfo type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
        if (StringsKt.isBlank(this.name)) {
            throw new IllegalArgumentException("Name can't be blank".toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AttributeKey(String str, TypeInfo typeInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, typeInfo);
        KType kType;
        if ((i & 2) != 0) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            try {
                kType = Reflection.typeOf(Object.class);
            } catch (Throwable th) {
                kType = null;
            }
            typeInfo = new TypeInfo(orCreateKotlinClass, kType);
        }
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AttributeKey(String name) {
        this(name, null, 2, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public String toString() {
        return "AttributeKey: " + this.name;
    }
}