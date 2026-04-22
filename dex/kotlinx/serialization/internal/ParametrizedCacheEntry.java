package kotlinx.serialization.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

/* compiled from: Caching.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JN\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\bH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0003¢\u0006\u0004\b\f\u0010\rR7\u0010\u0011\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u000b0\u000f8\u0002X\u0082\u0004ø\u0001\u0003¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0016\n\u0005\b\u009920\u0001\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "T", "", "<init>", "()V", "", "Lkotlin/reflect/KType;", "types", "Lkotlin/Function0;", "Lkotlinx/serialization/KSerializer;", "producer", "Lkotlin/Result;", "computeIfAbsent-gIAlu-s", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "computeIfAbsent", "j$/util/concurrent/ConcurrentHashMap", "Lkotlinx/serialization/internal/KTypeWrapper;", "serializers", "Lj$/util/concurrent/ConcurrentHashMap;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParametrizedCacheEntry<T> {
    private final ConcurrentHashMap<List<KTypeWrapper>, Result<KSerializer<T>>> serializers = new ConcurrentHashMap<>();

    public static final /* synthetic */ ConcurrentHashMap access$getSerializers$p(ParametrizedCacheEntry $this) {
        return $this.serializers;
    }

    /* renamed from: computeIfAbsent-gIAlu-s */
    public final Object m1530computeIfAbsentgIAlus(List<? extends KType> types, Function0<? extends KSerializer<T>> producer) {
        Object obj;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(producer, "producer");
        List<? extends KType> $this$map$iv = types;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KType it = (KType) item$iv$iv;
            destination$iv$iv.add(new KTypeWrapper(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        ConcurrentMap $this$getOrPut$iv = this.serializers;
        Object default$iv = $this$getOrPut$iv.get(arrayList);
        if (default$iv == null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(producer.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            default$iv = Result.box-impl(obj);
            Object putIfAbsent = $this$getOrPut$iv.putIfAbsent(arrayList, default$iv);
            if (putIfAbsent != null) {
                default$iv = putIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(default$iv, "serializers.getOrPut(wra… { producer() }\n        }");
        return ((Result) default$iv).unbox-impl();
    }
}