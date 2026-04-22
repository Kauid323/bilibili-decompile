package kotlinx.serialization.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Caching.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B'\u0012\u001e\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR,\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR*\u0010\u0011\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/internal/ConcurrentHashMapCache;", "T", "Lkotlinx/serialization/internal/SerializerCache;", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "compute", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "key", "get", "(Lkotlin/reflect/KClass;)Lkotlinx/serialization/KSerializer;", "Lkotlin/jvm/functions/Function1;", "j$/util/concurrent/ConcurrentHashMap", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/CacheEntry;", "cache", "Lj$/util/concurrent/ConcurrentHashMap;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentHashMapCache<T> implements SerializerCache<T> {
    private final ConcurrentHashMap<Class<?>, CacheEntry<T>> cache;
    private final Function1<KClass<?>, KSerializer<T>> compute;

    /* JADX WARN: Multi-variable type inference failed */
    public ConcurrentHashMapCache(Function1<? super KClass<?>, ? extends KSerializer<T>> compute) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer<T> get(KClass<Object> key) {
        Object putIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentMap $this$getOrPut$iv = this.cache;
        Class javaClass = JvmClassMappingKt.getJavaClass((KClass) key);
        Object default$iv = $this$getOrPut$iv.get(javaClass);
        if (default$iv == null && (putIfAbsent = $this$getOrPut$iv.putIfAbsent(javaClass, (default$iv = new CacheEntry(this.compute.invoke(key))))) != null) {
            default$iv = putIfAbsent;
        }
        return ((CacheEntry) default$iv).serializer;
    }
}