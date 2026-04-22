package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorKt {
    public static final KotlinType createCapturedType(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        return new CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType $this$isCaptured) {
        Intrinsics.checkNotNullParameter($this$isCaptured, "<this>");
        return $this$isCaptured.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution, z);
    }

    public static final TypeSubstitution wrapWithCapturingSubstitution(TypeSubstitution $this$wrapWithCapturingSubstitution, final boolean needApproximation) {
        Intrinsics.checkNotNullParameter($this$wrapWithCapturingSubstitution, "<this>");
        if ($this$wrapWithCapturingSubstitution instanceof IndexedParametersSubstitution) {
            TypeParameterDescriptor[] parameters = ((IndexedParametersSubstitution) $this$wrapWithCapturingSubstitution).getParameters();
            Iterable $this$map$iv = ArraysKt.zip(((IndexedParametersSubstitution) $this$wrapWithCapturingSubstitution).getArguments(), ((IndexedParametersSubstitution) $this$wrapWithCapturingSubstitution).getParameters());
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Pair it = (Pair) item$iv$iv;
                destination$iv$iv.add(createCapturedIfNeeded((TypeProjection) it.getFirst(), (TypeParameterDescriptor) it.getSecond()));
            }
            Collection thisCollection$iv = (List) destination$iv$iv;
            return new IndexedParametersSubstitution(parameters, (TypeProjection[]) thisCollection$iv.toArray(new TypeProjection[0]), needApproximation);
        }
        return new DelegatedTypeSubstitution($this$wrapWithCapturingSubstitution) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2
            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public boolean approximateContravariantCapturedTypes() {
                return needApproximation;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            /* renamed from: get */
            public TypeProjection mo1176get(KotlinType key) {
                TypeProjection createCapturedIfNeeded;
                Intrinsics.checkNotNullParameter(key, "key");
                TypeProjection mo1176get = super.mo1176get(key);
                if (mo1176get != null) {
                    ClassifierDescriptor mo1171getDeclarationDescriptor = key.getConstructor().mo1171getDeclarationDescriptor();
                    createCapturedIfNeeded = CapturedTypeConstructorKt.createCapturedIfNeeded(mo1176get, mo1171getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo1171getDeclarationDescriptor : null);
                    return createCapturedIfNeeded;
                }
                return null;
            }
        };
    }

    public static final TypeProjection createCapturedIfNeeded(TypeProjection $this$createCapturedIfNeeded, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || $this$createCapturedIfNeeded.getProjectionKind() == Variance.INVARIANT) {
            return $this$createCapturedIfNeeded;
        }
        if (typeParameterDescriptor.getVariance() == $this$createCapturedIfNeeded.getProjectionKind()) {
            if ($this$createCapturedIfNeeded.isStarProjection()) {
                StorageManager NO_LOCKS = LockBasedStorageManager.NO_LOCKS;
                Intrinsics.checkNotNullExpressionValue(NO_LOCKS, "NO_LOCKS");
                return new TypeProjectionImpl(new LazyWrappedType(NO_LOCKS, new Function0($this$createCapturedIfNeeded) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$$Lambda$0
                    private final TypeProjection arg$0;

                    {
                        this.arg$0 = $this$createCapturedIfNeeded;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        KotlinType createCapturedIfNeeded$lambda$0;
                        createCapturedIfNeeded$lambda$0 = CapturedTypeConstructorKt.createCapturedIfNeeded$lambda$0(this.arg$0);
                        return createCapturedIfNeeded$lambda$0;
                    }
                }));
            }
            return new TypeProjectionImpl($this$createCapturedIfNeeded.getType());
        }
        return new TypeProjectionImpl(createCapturedType($this$createCapturedIfNeeded));
    }

    public static final KotlinType createCapturedIfNeeded$lambda$0(TypeProjection $this_createCapturedIfNeeded) {
        KotlinType type = $this_createCapturedIfNeeded.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }
}