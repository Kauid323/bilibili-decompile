package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Caching.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014J-\u0010\b\u001a\u00028\u00002\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00072\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lkotlinx/serialization/internal/ClassValueReferences;", "T", "Ljava/lang/ClassValue;", "Lkotlinx/serialization/internal/MutableSoftReference;", "()V", "computeValue", "type", "Ljava/lang/Class;", "getOrSet", "key", "factory", "Lkotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassValueReferences<T> extends ClassValue<MutableSoftReference<T>> {
    public /* bridge */ /* synthetic */ Object computeValue(Class p0) {
        return m1527computeValue((Class<?>) p0);
    }

    /* renamed from: computeValue  reason: collision with other method in class */
    protected MutableSoftReference<T> m1527computeValue(Class<?> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new MutableSoftReference<>();
    }

    public final T getOrSet(Class<?> key, final Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Object obj = get(key);
        Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
        MutableSoftReference ref = (MutableSoftReference) obj;
        T t = ref.reference.get();
        if (t != null) {
            return t;
        }
        return (T) ref.getOrSetWithLock((Function0) ((Function0<T>) new Function0<T>() { // from class: kotlinx.serialization.internal.ClassValueReferences$getOrSet$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return factory.invoke();
            }
        }));
    }
}