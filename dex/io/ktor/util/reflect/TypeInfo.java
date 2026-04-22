package io.ktor.util.reflect;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: Type.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0017\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "Lkotlin/reflect/KClass;", "type", "Lkotlin/reflect/KType;", "kotlinType", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)V", "Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "(Lkotlin/reflect/KClass;Ljava/lang/reflect/Type;Lkotlin/reflect/KType;)V", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "hashCode", "()I", "other", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "equals", "(Ljava/lang/Object;)Z", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getKotlinType", "()Lkotlin/reflect/KType;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TypeInfo {
    private final KType kotlinType;
    private final KClass<?> type;

    public TypeInfo(KClass<?> kClass, KType kotlinType) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        this.type = kClass;
        this.kotlinType = kotlinType;
    }

    public /* synthetic */ TypeInfo(KClass kClass, KType kType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? null : kType);
    }

    public final KClass<?> getType() {
        return this.type;
    }

    public final KType getKotlinType() {
        return this.kotlinType;
    }

    public /* synthetic */ TypeInfo(KClass kClass, Type type, KType kType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, type, (i & 4) != 0 ? null : kType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use constructor without reifiedType parameter.", replaceWith = @ReplaceWith(expression = "TypeInfo(type, kotlinType)", imports = {}))
    public TypeInfo(KClass<?> kClass, Type reifiedType, KType kotlinType) {
        this(kClass, kotlinType);
        Intrinsics.checkNotNullParameter(kClass, "type");
        Intrinsics.checkNotNullParameter(reifiedType, "reifiedType");
    }

    public int hashCode() {
        KType kType = this.kotlinType;
        return kType != null ? kType.hashCode() : this.type.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TypeInfo) {
            if (this.kotlinType != null || ((TypeInfo) other).kotlinType != null) {
                return Intrinsics.areEqual(this.kotlinType, ((TypeInfo) other).kotlinType);
            }
            return Intrinsics.areEqual(this.type, ((TypeInfo) other).type);
        }
        return false;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("TypeInfo(");
        KClass<?> kClass = this.kotlinType;
        if (kClass == null) {
            kClass = this.type;
        }
        return append.append((KAnnotatedElement) kClass).append(')').toString();
    }
}