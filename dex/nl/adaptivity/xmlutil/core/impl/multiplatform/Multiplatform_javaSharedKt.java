package nl.adaptivity.xmlutil.core.impl.multiplatform;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: multiplatform.javaShared.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b*\n\u0010\u0005\"\u00020\u00062\u00020\u0006¨\u0006\f"}, d2 = {"name", "", "Lkotlin/reflect/KClass;", "getName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "URI", "Ljava/net/URI;", "maybeAnnotations", "", "", "getMaybeAnnotations", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Multiplatform_javaSharedKt {
    public static final String getName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String name = JvmClassMappingKt.getJavaClass((KClass) kClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    public static final List<Annotation> getMaybeAnnotations(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Annotation[] annotations = JvmClassMappingKt.getJavaClass((KClass) kClass).getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
        return ArraysKt.toList(annotations);
    }
}