package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: KTypeParameterImpl.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010 \u001a\u0006\u0012\u0002\b\u00030!*\u00020\"H\u0002J\u0010\u0010#\u001a\u0006\u0012\u0002\b\u00030$*\u00020%H\u0002J\u0013\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\fH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "<init>", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "isReified", "", "()Z", "getContainer", "()Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "container$delegate", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KTypeParameterImpl.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(KTypeParameterImpl.class, "container", "getContainer()Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", 0))};
    private final ReflectProperties.LazySoftVal container$delegate;
    private final TypeParameterDescriptor descriptor;
    private final ReflectProperties.LazySoftVal upperBounds$delegate;

    /* compiled from: KTypeParameterImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KTypeParameterImpl(final KTypeParameterOwnerImpl container, TypeParameterDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.upperBounds$delegate = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KTypeParameterImpl$$Lambda$0
            private final KTypeParameterImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List upperBounds_delegate$lambda$0;
                upperBounds_delegate$lambda$0 = KTypeParameterImpl.upperBounds_delegate$lambda$0(this.arg$0);
                return upperBounds_delegate$lambda$0;
            }
        });
        this.container$delegate = ReflectProperties.lazySoft(new Function0(container, this) { // from class: kotlin.reflect.jvm.internal.KTypeParameterImpl$$Lambda$1
            private final KTypeParameterOwnerImpl arg$0;
            private final KTypeParameterImpl arg$1;

            {
                this.arg$0 = container;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KTypeParameterOwnerImpl container_delegate$lambda$0;
                container_delegate$lambda$0 = KTypeParameterImpl.container_delegate$lambda$0(this.arg$0, this.arg$1);
                return container_delegate$lambda$0;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List upperBounds_delegate$lambda$0(KTypeParameterImpl this$0) {
        Iterable upperBounds = this$0.getDescriptor().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        Iterable $this$map$iv = upperBounds;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KotlinType p0 = (KotlinType) item$iv$iv;
            destination$iv$iv.add(new KTypeImpl(p0, null, 2, null));
        }
        return (List) destination$iv$iv;
    }

    @Override // kotlin.reflect.KTypeParameter
    public List<KType> getUpperBounds() {
        T value = this.upperBounds$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (List) value;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        switch (WhenMappings.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()]) {
            case 1:
                return KVariance.INVARIANT;
            case 2:
                return KVariance.IN;
            case 3:
                return KVariance.OUT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return getDescriptor().isReified();
    }

    private final KTypeParameterOwnerImpl getContainer() {
        T value = this.container$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (KTypeParameterOwnerImpl) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KTypeParameterOwnerImpl container_delegate$lambda$0(KTypeParameterOwnerImpl $container, KTypeParameterImpl this$0) {
        KClassImpl kClassImpl;
        Object accept;
        if ($container != null) {
            return $container;
        }
        DeclarationDescriptor declaration = this$0.getDescriptor().getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(declaration, "getContainingDeclaration(...)");
        if (declaration instanceof ClassDescriptor) {
            accept = this$0.toKClassImpl((ClassDescriptor) declaration);
        } else if (declaration instanceof CallableMemberDescriptor) {
            DeclarationDescriptor callableContainer = ((CallableMemberDescriptor) declaration).getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(callableContainer, "getContainingDeclaration(...)");
            if (callableContainer instanceof ClassDescriptor) {
                kClassImpl = this$0.toKClassImpl((ClassDescriptor) callableContainer);
            } else {
                DeserializedMemberDescriptor deserializedMember = declaration instanceof DeserializedMemberDescriptor ? (DeserializedMemberDescriptor) declaration : null;
                if (deserializedMember == null) {
                    throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + declaration);
                }
                KClass kotlinClass = JvmClassMappingKt.getKotlinClass(this$0.getContainerClass(deserializedMember));
                Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                kClassImpl = (KClassImpl) kotlinClass;
            }
            KClassImpl callableContainerClass = kClassImpl;
            accept = declaration.accept(new CreateKCallableVisitor(callableContainerClass), Unit.INSTANCE);
        } else {
            throw new KotlinReflectionInternalError("Unknown type parameter container: " + declaration);
        }
        return (KTypeParameterOwnerImpl) accept;
    }

    private final KClassImpl<?> toKClassImpl(ClassDescriptor $this$toKClassImpl) {
        Class<?> javaClass = UtilKt.toJavaClass($this$toKClassImpl);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? JvmClassMappingKt.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + $this$toKClassImpl.getContainingDeclaration());
    }

    private final Class<?> getContainerClass(DeserializedMemberDescriptor $this$getContainerClass) {
        Class<?> klass;
        DeserializedContainerSource containerSource = $this$getContainerClass.getContainerSource();
        JvmPackagePartSource jvmPackagePartSource = containerSource instanceof JvmPackagePartSource ? (JvmPackagePartSource) containerSource : null;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
        ReflectKotlinClass reflectKotlinClass = knownJvmBinaryClass instanceof ReflectKotlinClass ? knownJvmBinaryClass : null;
        if (reflectKotlinClass == null || (klass = reflectKotlinClass.getKlass()) == null) {
            throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + $this$getContainerClass);
        }
        return klass;
    }

    public boolean equals(Object other) {
        return (other instanceof KTypeParameterImpl) && Intrinsics.areEqual(getContainer(), ((KTypeParameterImpl) other).getContainer()) && Intrinsics.areEqual(getName(), ((KTypeParameterImpl) other).getName());
    }

    public int hashCode() {
        return (getContainer().hashCode() * 31) + getName().hashCode();
    }

    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }
}