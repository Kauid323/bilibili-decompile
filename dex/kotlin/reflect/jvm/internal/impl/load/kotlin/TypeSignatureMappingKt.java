package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: typeSignatureMapping.kt */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> jvmTypeFactory, T possiblyPrimitiveType, boolean needBoxedType) {
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "<this>");
        Intrinsics.checkNotNullParameter(possiblyPrimitiveType, "possiblyPrimitiveType");
        return needBoxedType ? jvmTypeFactory.boxType(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext $this$mapBuiltInType, KotlinTypeMarker type, JvmTypeFactory<T> typeFactory, TypeMappingMode mode) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$mapBuiltInType, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(typeFactory, "typeFactory");
        Intrinsics.checkNotNullParameter(mode, "mode");
        TypeConstructorMarker constructor = $this$mapBuiltInType.typeConstructor(type);
        if ($this$mapBuiltInType.isClassTypeConstructor(constructor)) {
            PrimitiveType primitiveType = $this$mapBuiltInType.getPrimitiveType(constructor);
            if (primitiveType != null) {
                Object jvmType = typeFactory.createPrimitiveType(primitiveType);
                boolean isNullableInJava = $this$mapBuiltInType.isNullableType(type) || TypeEnhancementUtilsKt.hasEnhancedNullability($this$mapBuiltInType, type);
                return (T) boxTypeIfNeeded(typeFactory, jvmType, isNullableInJava);
            }
            PrimitiveType arrayElementType = $this$mapBuiltInType.getPrimitiveArrayType(constructor);
            if (arrayElementType != null) {
                return typeFactory.createFromString(AbstractJsonLexerKt.BEGIN_LIST + JvmPrimitiveType.get(arrayElementType).getDesc());
            }
            if ($this$mapBuiltInType.isUnderKotlinPackage(constructor)) {
                FqNameUnsafe p0 = $this$mapBuiltInType.getClassFqNameUnsafe(constructor);
                ClassId classId = p0 != null ? JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(p0) : null;
                if (classId != null) {
                    if (!mode.getKotlinCollectionsToJavaCollections()) {
                        Iterable $this$any$iv = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                            z = false;
                        } else {
                            Iterator<T> it = $this$any$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv = it.next();
                                    JavaToKotlinClassMap.PlatformMutabilityMapping it2 = (JavaToKotlinClassMap.PlatformMutabilityMapping) element$iv;
                                    if (Intrinsics.areEqual(it2.getJavaClass(), classId)) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                        }
                        if (z) {
                            return null;
                        }
                    }
                    String internalNameByClassId = JvmClassName.internalNameByClassId(classId);
                    Intrinsics.checkNotNullExpressionValue(internalNameByClassId, "internalNameByClassId(...)");
                    return typeFactory.createObjectType(internalNameByClassId);
                }
            }
            return null;
        }
        return null;
    }
}