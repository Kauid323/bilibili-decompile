package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    private final MemoizedFunctionToNullable<FqName, T> cache;
    private final Map<FqName, T> states;
    private final LockBasedStorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> states) {
        Intrinsics.checkNotNullParameter(states, "states");
        this.states = states;
        this.storageManager = new LockBasedStorageManager("Java nullability annotation states");
        MemoizedFunctionToNullable<FqName, T> createMemoizedFunctionWithNullableValues = this.storageManager.createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl$$Lambda$0
            private final NullabilityAnnotationStatesImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Object cache$lambda$0;
                cache$lambda$0 = NullabilityAnnotationStatesImpl.cache$lambda$0(this.arg$0, (FqName) obj);
                return cache$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunctionWithNullableValues, "createMemoizedFunctionWithNullableValues(...)");
        this.cache = createMemoizedFunctionWithNullableValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object cache$lambda$0(NullabilityAnnotationStatesImpl this$0, FqName it) {
        Intrinsics.checkNotNull(it);
        return FqNamesUtilKt.findValueForMostSpecificFqname(it, this$0.states);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public T get(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.cache.invoke(fqName);
    }
}