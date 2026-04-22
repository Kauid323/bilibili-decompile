package io.ktor.serialization.kotlinx.json;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/util/reflect/TypeInfo;", "argumentTypeInfo", "(Lio/ktor/util/reflect/TypeInfo;)Lio/ktor/util/reflect/TypeInfo;", "ktor-serialization-kotlinx-json"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KotlinxSerializationJsonExtensionsKt {
    public static final TypeInfo argumentTypeInfo(TypeInfo $this$argumentTypeInfo) {
        Intrinsics.checkNotNullParameter($this$argumentTypeInfo, "<this>");
        KType kotlinType = $this$argumentTypeInfo.getKotlinType();
        Intrinsics.checkNotNull(kotlinType);
        KType elementType = ((KTypeProjection) kotlinType.getArguments().get(0)).getType();
        Intrinsics.checkNotNull(elementType);
        KClass classifier = elementType.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        return new TypeInfo(classifier, elementType);
    }
}