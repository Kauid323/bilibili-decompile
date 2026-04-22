package io.ktor.util.reflect;

import com.bilibili.studio.editor.asr.core.config.AsrDefaultConfig;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

/* compiled from: TypeInfoJvm.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\b\u001a\u00020\u00072\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001d\u0010\r\u001a\u00020\f*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\r\u0010\u000e\"\u001b\u0010\u0002\u001a\u00020\u0000*\u00020\u00078F¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0017\u001a\u00060\u0000j\u0002`\u0001*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014*\u001a\b\u0007\u0010\u001b\"\u00020\u00002\u00020\u0000B\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¨\u0006\u001c"}, d2 = {"Ljava/lang/reflect/Type;", "Lio/ktor/util/reflect/Type;", "reifiedType", "Lkotlin/reflect/KClass;", "kClass", "Lkotlin/reflect/KType;", "kType", "Lio/ktor/util/reflect/TypeInfo;", "typeInfoImpl", "(Ljava/lang/reflect/Type;Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)Lio/ktor/util/reflect/TypeInfo;", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "type", AsrDefaultConfig.SUBTITLE_TYPE_DEFAULT, "instanceOf", "(Ljava/lang/Object;Lkotlin/reflect/KClass;)Z", "getReifiedType", "(Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/reflect/Type;", "getReifiedType$annotations", "(Lio/ktor/util/reflect/TypeInfo;)V", "getPlatformType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "getPlatformType$annotations", "(Lkotlin/reflect/KType;)V", "platformType", "Lkotlin/Deprecated;", "message", "Not used anymore in common code as it was needed only for JVM target.", "Type", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TypeInfoJvmKt {
    @Deprecated(message = "Not used anymore in common code as it was needed only for JVM target.")
    public static /* synthetic */ void Type$annotations() {
    }

    @Deprecated(message = "Use KType.javaType instead.", replaceWith = @ReplaceWith(expression = "this.javaType", imports = {"kotlin.reflect.javaType"}))
    public static /* synthetic */ void getPlatformType$annotations(KType kType) {
    }

    public static /* synthetic */ void getReifiedType$annotations(TypeInfo typeInfo) {
    }

    public static final Type getReifiedType(TypeInfo $this$reifiedType) {
        Type javaType;
        Intrinsics.checkNotNullParameter($this$reifiedType, "<this>");
        KType kotlinType = $this$reifiedType.getKotlinType();
        return (kotlinType == null || (javaType = TypesJVMKt.getJavaType(kotlinType)) == null) ? JvmClassMappingKt.getJavaClass($this$reifiedType.getType()) : javaType;
    }

    @Deprecated(message = "Use TypeInfo constructor instead.", replaceWith = @ReplaceWith(expression = "TypeInfo(kClass, kType)", imports = {}))
    public static final TypeInfo typeInfoImpl(Type reifiedType, KClass<?> kClass, KType kType) {
        Intrinsics.checkNotNullParameter(reifiedType, "reifiedType");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new TypeInfo(kClass, kType);
    }

    public static final boolean instanceOf(Object $this$instanceOf, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter($this$instanceOf, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "type");
        return JvmClassMappingKt.getJavaClass(kClass).isInstance($this$instanceOf);
    }

    public static final Type getPlatformType(KType $this$platformType) {
        Intrinsics.checkNotNullParameter($this$platformType, "<this>");
        return TypesJVMKt.getJavaType($this$platformType);
    }
}