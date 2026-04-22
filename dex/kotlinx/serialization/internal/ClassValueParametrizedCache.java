package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Caching.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012,\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0002\u0010\nJB\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/internal/ClassValueParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/jvm/functions/Function2;)V", "classValue", "Lkotlinx/serialization/internal/ClassValueReferences;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {
    private final ClassValueReferences<ParametrizedCacheEntry<T>> classValue;
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.classValue = new ClassValueReferences<>();
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* renamed from: get-gIAlu-s  reason: not valid java name */
    public Object mo1526getgIAlus(KClass<Object> key, List<? extends KType> types) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(types, "types");
        ClassValueReferences this_$iv = this.classValue;
        Class key$iv = JvmClassMappingKt.getJavaClass((KClass) key);
        Object obj2 = this_$iv.get(key$iv);
        Intrinsics.checkNotNullExpressionValue(obj2, "get(key)");
        MutableSoftReference ref$iv = (MutableSoftReference) obj2;
        T t = ref$iv.reference.get();
        if (t == null) {
            t = (T) ref$iv.getOrSetWithLock((Function0) ((Function0<T>) new Function0<T>() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1
                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    return (T) new ParametrizedCacheEntry();
                }
            }));
        }
        ParametrizedCacheEntry this_$iv2 = (ParametrizedCacheEntry) t;
        List<? extends KType> $this$map$iv$iv = types;
        Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
        for (Object item$iv$iv$iv : $this$map$iv$iv) {
            KType it$iv = (KType) item$iv$iv$iv;
            destination$iv$iv$iv.add(new KTypeWrapper(it$iv));
        }
        ArrayList arrayList = (List) destination$iv$iv$iv;
        ConcurrentMap $this$getOrPut$iv$iv = ParametrizedCacheEntry.access$getSerializers$p(this_$iv2);
        Object default$iv$iv = $this$getOrPut$iv$iv.get(arrayList);
        if (default$iv$iv == null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(this.compute.invoke(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            default$iv$iv = Result.box-impl(obj);
            Object putIfAbsent = $this$getOrPut$iv$iv.putIfAbsent(arrayList, default$iv$iv);
            if (putIfAbsent != null) {
                default$iv$iv = putIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(default$iv$iv, "serializers.getOrPut(wra… { producer() }\n        }");
        return ((Result) default$iv$iv).unbox-impl();
    }
}