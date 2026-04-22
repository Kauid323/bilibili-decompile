package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: KTypeImpl.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0001H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\bH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u0001H\u0016J\u0013\u00103\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u000104H\u0096\u0002J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000208H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0016\u0010*\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010 R\u0014\u0010/\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010 R\u0014\u00100\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010 ¨\u00069²\u0006\u0010\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/jvm/internal/AbstractKType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "isAbbreviation", "", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;Z)V", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "convert", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "isMarkedNullable", "()Z", "annotations", "", "getAnnotations", "isSubtypeOf", "other", "makeNullableAsSpecified", "nullable", "makeDefinitelyNotNullAsSpecified", "isDefinitelyNotNull", "abbreviation", "Lkotlin/reflect/KType;", "getAbbreviation", "()Lkotlin/reflect/KType;", "isDefinitelyNotNullType", "isNothingType", "isMutableCollectionType", "lowerBoundIfFlexible", "upperBoundIfFlexible", "equals", "", "hashCode", "", "toString", "", "kotlin-reflection", "parameterizedTypeArguments"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KTypeImpl extends AbstractKType {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), Reflection.property1(new PropertyReference1Impl(KTypeImpl.class, "arguments", "getArguments()Ljava/util/List;", 0))};
    private final ReflectProperties.LazySoftVal arguments$delegate;
    private final ReflectProperties.LazySoftVal classifier$delegate;
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;
    private final boolean isAbbreviation;
    private final KotlinType type;

    /* compiled from: KTypeImpl.kt */
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

    public KTypeImpl(KotlinType type, final Function0<? extends Type> function0, boolean isAbbreviation) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.isAbbreviation = isAbbreviation;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal2 = function0 instanceof ReflectProperties.LazySoftVal ? (ReflectProperties.LazySoftVal) function0 : null;
        if (lazySoftVal2 != null) {
            lazySoftVal = lazySoftVal2;
        } else if (function0 != null) {
            lazySoftVal = ReflectProperties.lazySoft(function0);
        }
        this.computeJavaType = lazySoftVal;
        this.classifier$delegate = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$0
            private final KTypeImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KClassifier classifier_delegate$lambda$0;
                classifier_delegate$lambda$0 = KTypeImpl.classifier_delegate$lambda$0(this.arg$0);
                return classifier_delegate$lambda$0;
            }
        });
        this.arguments$delegate = ReflectProperties.lazySoft(new Function0(this, function0) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$1
            private final KTypeImpl arg$0;
            private final Function0 arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List arguments_delegate$lambda$0;
                arguments_delegate$lambda$0 = KTypeImpl.arguments_delegate$lambda$0(this.arg$0, this.arg$1);
                return arguments_delegate$lambda$0;
            }
        });
    }

    public final KotlinType getType() {
        return this.type;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KTypeImpl(KotlinType type, Function0<? extends Type> function0) {
        this(type, function0, false);
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.computeJavaType;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier classifier_delegate$lambda$0(KTypeImpl this$0) {
        return this$0.convert(this$0.type);
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return (KClassifier) this.classifier$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final KClassifier convert(KotlinType type) {
        KotlinType argument;
        if (this.isAbbreviation) {
            ClassifierDescriptor mo1171getDeclarationDescriptor = type.getConstructor().mo1171getDeclarationDescriptor();
            NotFoundClasses.MockClassDescriptor notFoundClass = mo1171getDeclarationDescriptor instanceof NotFoundClasses.MockClassDescriptor ? (NotFoundClasses.MockClassDescriptor) mo1171getDeclarationDescriptor : null;
            if (notFoundClass != null) {
                return new KTypeAliasImpl(DescriptorUtilsKt.getFqNameSafe(notFoundClass));
            }
        }
        ClassifierDescriptor descriptor = type.getConstructor().mo1171getDeclarationDescriptor();
        if (descriptor instanceof ClassDescriptor) {
            Class jClass = UtilKt.toJavaClass((ClassDescriptor) descriptor);
            if (jClass == null) {
                return null;
            }
            if (KotlinBuiltIns.isArray(type)) {
                TypeProjection typeProjection = (TypeProjection) CollectionsKt.singleOrNull((List<? extends Object>) type.getArguments());
                if (typeProjection == null || (argument = typeProjection.getType()) == null) {
                    return new KClassImpl(jClass);
                }
                KClassifier elementClassifier = convert(TypeUtilsKt.makeNullable(argument));
                if (elementClassifier == null) {
                    throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                }
                return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(elementClassifier))));
            } else if (!TypeUtils.isNullableType(type)) {
                Class primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(jClass);
                if (primitiveByWrapper == null) {
                    primitiveByWrapper = jClass;
                }
                return new KClassImpl(primitiveByWrapper);
            } else {
                return new KClassImpl(jClass);
            }
        } else if (descriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) descriptor);
        } else {
            return null;
        }
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        T value = this.arguments$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (List) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List arguments_delegate$lambda$0(final KTypeImpl this$0, Function0 $computeJavaType) {
        List typeArguments;
        KTypeProjection invariant;
        List typeArguments2 = this$0.type.getArguments();
        if (typeArguments2.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        final Lazy parameterizedTypeArguments$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this$0) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$2
            private final KTypeImpl arg$0;

            {
                this.arg$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List arguments_delegate$lambda$0$0;
                arguments_delegate$lambda$0$0 = KTypeImpl.arguments_delegate$lambda$0$0(this.arg$0);
                return arguments_delegate$lambda$0$0;
            }
        });
        List $this$mapIndexed$iv = typeArguments2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        final int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) item$iv$iv;
            if (typeProjection.isStarProjection()) {
                invariant = KTypeProjection.Companion.getSTAR();
                typeArguments = typeArguments2;
            } else {
                KotlinType type = typeProjection.getType();
                typeArguments = typeArguments2;
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                KTypeImpl type2 = new KTypeImpl(type, $computeJavaType == null ? null : new Function0(this$0, index$iv$iv, parameterizedTypeArguments$delegate) { // from class: kotlin.reflect.jvm.internal.KTypeImpl$$Lambda$3
                    private final KTypeImpl arg$0;
                    private final int arg$1;
                    private final Lazy arg$2;

                    {
                        this.arg$0 = this$0;
                        this.arg$1 = index$iv$iv;
                        this.arg$2 = parameterizedTypeArguments$delegate;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        Type arguments_delegate$lambda$0$2$0;
                        arguments_delegate$lambda$0$2$0 = KTypeImpl.arguments_delegate$lambda$0$2$0(this.arg$0, this.arg$1, this.arg$2);
                        return arguments_delegate$lambda$0$2$0;
                    }
                });
                switch (WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()]) {
                    case 1:
                        invariant = KTypeProjection.Companion.invariant(type2);
                        continue;
                    case 2:
                        invariant = KTypeProjection.Companion.contravariant(type2);
                        continue;
                    case 3:
                        invariant = KTypeProjection.Companion.covariant(type2);
                        continue;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            destination$iv$iv.add(invariant);
            index$iv$iv = index$iv$iv2;
            typeArguments2 = typeArguments;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List arguments_delegate$lambda$0$0(KTypeImpl this$0) {
        Type javaType = this$0.getJavaType();
        Intrinsics.checkNotNull(javaType);
        return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
    }

    private static final List<Type> arguments_delegate$lambda$0$1(Lazy<? extends List<? extends Type>> lazy) {
        return (List) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type arguments_delegate$lambda$0$2$0(KTypeImpl this$0, int $i, Lazy<? extends List<? extends Type>> lazy) {
        Type javaType = this$0.getJavaType();
        if (javaType instanceof Class) {
            Class argument = ((Class) javaType).isArray() ? ((Class) javaType).getComponentType() : Object.class;
            Intrinsics.checkNotNull(argument);
            return argument;
        } else if (javaType instanceof GenericArrayType) {
            if ($i != 0) {
                throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this$0);
            }
            Type argument2 = ((GenericArrayType) javaType).getGenericComponentType();
            Intrinsics.checkNotNull(argument2);
            return argument2;
        } else if (javaType instanceof ParameterizedType) {
            Type argument3 = arguments_delegate$lambda$0$1(lazy).get($i);
            if (!(argument3 instanceof WildcardType)) {
                return argument3;
            }
            Type[] lowerBounds = ((WildcardType) argument3).getLowerBounds();
            Intrinsics.checkNotNullExpressionValue(lowerBounds, "getLowerBounds(...)");
            Type argument4 = (Type) ArraysKt.firstOrNull(lowerBounds);
            if (argument4 == null) {
                Type[] upperBounds = ((WildcardType) argument3).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                argument4 = (Type) ArraysKt.first(upperBounds);
            }
            Intrinsics.checkNotNull(argument4);
            return argument4;
        } else {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this$0);
        }
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isSubtypeOf(AbstractKType other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return TypeUtilsKt.isSubtypeOf(this.type, ((KTypeImpl) other).type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType makeNullableAsSpecified(boolean nullable) {
        if (FlexibleTypesKt.isFlexible(this.type) || isMarkedNullable() != nullable) {
            KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(this.type, nullable);
            Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "makeNullableAsSpecified(...)");
            return new KTypeImpl(makeNullableAsSpecified, this.computeJavaType);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType makeDefinitelyNotNullAsSpecified(boolean isDefinitelyNotNull) {
        SimpleType result;
        SimpleType original;
        if (isDefinitelyNotNull) {
            DefinitelyNotNullType makeDefinitelyNotNull$default = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, this.type.unwrap(), true, false, 4, null);
            result = makeDefinitelyNotNull$default != null ? makeDefinitelyNotNull$default : this.type;
        } else {
            KotlinType kotlinType = this.type;
            DefinitelyNotNullType definitelyNotNullType = kotlinType instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) kotlinType : null;
            result = (definitelyNotNullType == null || (original = definitelyNotNullType.getOriginal()) == null) ? this.type : original;
        }
        return new KTypeImpl(result, this.computeJavaType);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public KType getAbbreviation() {
        SimpleType it = SpecialTypesKt.getAbbreviation(this.type);
        return it != null ? new KTypeImpl(it, this.computeJavaType, true) : null;
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isDefinitelyNotNullType() {
        return SpecialTypesKt.isDefinitelyNotNullType(this.type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isNothingType() {
        return KotlinBuiltIns.isNothingOrNullableNothing(this.type);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public boolean isMutableCollectionType() {
        ClassifierDescriptor mo1171getDeclarationDescriptor = this.type.getConstructor().mo1171getDeclarationDescriptor();
        ClassDescriptor p0 = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
        return p0 != null && JavaToKotlinClassMapper.INSTANCE.isMutable(p0);
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType lowerBoundIfFlexible() {
        UnwrappedType unwrapped = this.type.unwrap();
        if (unwrapped instanceof FlexibleType) {
            return new KTypeImpl(((FlexibleType) unwrapped).getLowerBound(), null, 2, null);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.AbstractKType
    public AbstractKType upperBoundIfFlexible() {
        UnwrappedType unwrapped = this.type.unwrap();
        if (unwrapped instanceof FlexibleType) {
            return new KTypeImpl(((FlexibleType) unwrapped).getUpperBound(), null, 2, null);
        }
        return null;
    }

    public boolean equals(Object other) {
        return (other instanceof KTypeImpl) && Intrinsics.areEqual(this.type, ((KTypeImpl) other).type) && Intrinsics.areEqual(getClassifier(), ((KTypeImpl) other).getClassifier()) && Intrinsics.areEqual(getArguments(), ((KTypeImpl) other).getArguments());
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        KClassifier classifier = getClassifier();
        return ((hashCode + (classifier != null ? classifier.hashCode() : 0)) * 31) + getArguments().hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this);
    }
}