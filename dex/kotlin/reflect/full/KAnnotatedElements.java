package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;

/* compiled from: KAnnotatedElements.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"findAnnotation", "T", "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "hasAnnotation", "", "findAnnotations", "", "klass", "Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KAnnotatedElements {
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(KAnnotatedElement $this$findAnnotation) {
        Object element$iv;
        Intrinsics.checkNotNullParameter($this$findAnnotation, "<this>");
        Iterable $this$firstOrNull$iv = $this$findAnnotation.getAnnotations();
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Annotation it2 = (Annotation) element$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it2 instanceof Annotation) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) element$iv;
    }

    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(KAnnotatedElement $this$hasAnnotation) {
        Object element$iv$iv;
        Intrinsics.checkNotNullParameter($this$hasAnnotation, "<this>");
        Iterable $this$firstOrNull$iv$iv = $this$hasAnnotation.getAnnotations();
        Iterator<T> it = $this$firstOrNull$iv$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv$iv = it.next();
                Annotation it$iv = (Annotation) element$iv$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it$iv instanceof Annotation) {
                    break;
                }
            } else {
                element$iv$iv = null;
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return ((Annotation) element$iv$iv) != null;
    }

    public static final /* synthetic */ <T extends Annotation> List<T> findAnnotations(KAnnotatedElement $this$findAnnotations) {
        Intrinsics.checkNotNullParameter($this$findAnnotations, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return findAnnotations($this$findAnnotations, Reflection.getOrCreateKotlinClass(Annotation.class));
    }

    public static final <T extends Annotation> List<T> findAnnotations(KAnnotatedElement $this$findAnnotations, KClass<T> klass) {
        Object element$iv;
        Intrinsics.checkNotNullParameter($this$findAnnotations, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        List filtered = CollectionsKt.filterIsInstance($this$findAnnotations.getAnnotations(), JvmClassMappingKt.getJavaClass((KClass) klass));
        if (filtered.isEmpty()) {
            Class containerClass = Java8RepeatableContainerLoader.INSTANCE.loadRepeatableContainer(JvmClassMappingKt.getJavaClass((KClass) klass));
            if (containerClass != null) {
                Iterable $this$firstOrNull$iv = $this$findAnnotations.getAnnotations();
                Iterator<T> it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        Annotation it2 = (Annotation) element$iv;
                        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it2)), containerClass)) {
                            break;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                Annotation container = (Annotation) element$iv;
                if (container != null) {
                    Method valueMethod = container.getClass().getMethod("value", new Class[0]);
                    Object invoke = valueMethod.invoke(container, new Object[0]);
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
                    return ArraysKt.asList((Annotation[]) invoke);
                }
            }
            return CollectionsKt.emptyList();
        }
        return filtered;
    }
}