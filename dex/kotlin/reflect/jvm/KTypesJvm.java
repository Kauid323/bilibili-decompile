package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;

/* compiled from: KTypesJvm.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "getJvmErasure", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KTypesJvm {
    public static /* synthetic */ void getJvmErasure$annotations(KType kType) {
    }

    public static final KClass<?> getJvmErasure(KType $this$jvmErasure) {
        KClass<?> jvmErasure;
        Intrinsics.checkNotNullParameter($this$jvmErasure, "<this>");
        KClassifier classifier = $this$jvmErasure.getClassifier();
        if (classifier == null || (jvmErasure = getJvmErasure(classifier)) == null) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + $this$jvmErasure);
        }
        return jvmErasure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final KClass<?> getJvmErasure(KClassifier $this$jvmErasure) {
        KClassImpl klass;
        KClass<?> jvmErasure;
        boolean z;
        Intrinsics.checkNotNullParameter($this$jvmErasure, "<this>");
        if ($this$jvmErasure instanceof KClass) {
            return (KClass) $this$jvmErasure;
        }
        if ($this$jvmErasure instanceof KTypeParameter) {
            List bounds = ((KTypeParameter) $this$jvmErasure).getUpperBounds();
            List $this$firstOrNull$iv = bounds;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                KType it2 = (KType) element$iv;
                KClassifier classifier = it2.getClassifier();
                klass = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
                if (klass == null || klass.getClassKind$kotlin_reflection() == ClassKind.INTERFACE || klass.getClassKind$kotlin_reflection() == ClassKind.ANNOTATION_CLASS) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    klass = element$iv;
                    break;
                }
            }
            KType kType = (KType) klass;
            if (kType == null) {
                kType = (KType) CollectionsKt.firstOrNull((List<? extends Object>) bounds);
            }
            KType representativeBound = kType;
            return (representativeBound == null || (jvmErasure = getJvmErasure(representativeBound)) == null) ? Reflection.getOrCreateKotlinClass(Object.class) : jvmErasure;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + $this$jvmErasure);
    }
}