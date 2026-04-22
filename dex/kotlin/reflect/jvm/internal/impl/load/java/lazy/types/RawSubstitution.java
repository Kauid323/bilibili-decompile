package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: RawSubstitution.kt */
public final class RawSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion(null);
    private static final JavaTypeAttributes lowerTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    private static final JavaTypeAttributes upperTypeAttr = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public RawSubstitution() {
        this(null, 1, null);
    }

    public RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser) {
        this.projectionComputer = new RawProjectionComputer();
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser == null ? new TypeParameterUpperBoundEraser(this.projectionComputer, null, 2, null) : typeParameterUpperBoundEraser;
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeParameterUpperBoundEraser);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public TypeProjectionImpl mo1176get(KotlinType key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new TypeProjectionImpl(eraseType$default(this, key, null, 2, null));
    }

    static /* synthetic */ KotlinType eraseType$default(RawSubstitution rawSubstitution, KotlinType kotlinType, JavaTypeAttributes javaTypeAttributes, int i, Object obj) {
        if ((i & 2) != 0) {
            javaTypeAttributes = new JavaTypeAttributes(TypeUsage.COMMON, null, false, false, null, null, 62, null);
        }
        return rawSubstitution.eraseType(kotlinType, javaTypeAttributes);
    }

    private final KotlinType eraseType(KotlinType type, JavaTypeAttributes attr) {
        ClassifierDescriptor declaration = type.getConstructor().mo1171getDeclarationDescriptor();
        if (declaration instanceof TypeParameterDescriptor) {
            return eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((TypeParameterDescriptor) declaration, attr.markIsRaw(true)), attr);
        }
        if (declaration instanceof ClassDescriptor) {
            ClassifierDescriptor declarationForUpper = FlexibleTypesKt.upperIfFlexible(type).getConstructor().mo1171getDeclarationDescriptor();
            if (declarationForUpper instanceof ClassDescriptor) {
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(type), (ClassDescriptor) declaration, lowerTypeAttr);
                SimpleType lower = (SimpleType) eraseInflexibleBasedOnClassDescriptor.component1();
                boolean isRawL = ((Boolean) eraseInflexibleBasedOnClassDescriptor.component2()).booleanValue();
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(type), (ClassDescriptor) declarationForUpper, upperTypeAttr);
                SimpleType upper = (SimpleType) eraseInflexibleBasedOnClassDescriptor2.component1();
                boolean isRawU = ((Boolean) eraseInflexibleBasedOnClassDescriptor2.component2()).booleanValue();
                return (isRawL || isRawU) ? new RawTypeImpl(lower, upper) : KotlinTypeFactory.flexibleType(lower, upper);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationForUpper + "\" while for lower it's \"" + declaration + '\"').toString());
        }
        throw new IllegalStateException(("Unexpected declaration kind: " + declaration).toString());
    }

    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(final SimpleType type, final ClassDescriptor declaration, final JavaTypeAttributes attr) {
        if (type.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(type, false);
        }
        if (KotlinBuiltIns.isArray(type)) {
            TypeProjection componentTypeProjection = type.getArguments().get(0);
            Variance projectionKind = componentTypeProjection.getProjectionKind();
            KotlinType type2 = componentTypeProjection.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            List arguments = CollectionsKt.listOf(new TypeProjectionImpl(projectionKind, eraseType(type2, attr)));
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(type.getAttributes(), type.getConstructor(), arguments, type.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null), false);
        } else if (KotlinTypeKt.isError(type)) {
            return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, type.getConstructor().toString()), false);
        } else {
            MemberScope memberScope = declaration.getMemberScope(this);
            Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
            TypeAttributes attributes = type.getAttributes();
            TypeConstructor typeConstructor = declaration.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
            Iterable parameters = declaration.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            Iterable $this$map$iv = parameters;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                TypeParameterDescriptor parameter = (TypeParameterDescriptor) item$iv$iv;
                Intrinsics.checkNotNull(parameter);
                destination$iv$iv.add(ErasureProjectionComputer.computeProjection$default(this.projectionComputer, parameter, attr, this.typeParameterUpperBoundEraser, null, 8, null));
            }
            return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(attributes, typeConstructor, (List) destination$iv$iv, type.isMarkedNullable(), memberScope, new Function1(declaration, this, type, attr) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$$Lambda$0
                private final ClassDescriptor arg$0;
                private final RawSubstitution arg$1;
                private final SimpleType arg$2;
                private final JavaTypeAttributes arg$3;

                {
                    this.arg$0 = declaration;
                    this.arg$1 = this;
                    this.arg$2 = type;
                    this.arg$3 = attr;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    SimpleType eraseInflexibleBasedOnClassDescriptor$lambda$1;
                    eraseInflexibleBasedOnClassDescriptor$lambda$1 = RawSubstitution.eraseInflexibleBasedOnClassDescriptor$lambda$1(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (KotlinTypeRefiner) obj);
                    return eraseInflexibleBasedOnClassDescriptor$lambda$1;
                }
            }), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType eraseInflexibleBasedOnClassDescriptor$lambda$1(ClassDescriptor $declaration, RawSubstitution this$0, SimpleType $type, JavaTypeAttributes $attr, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassDescriptor refinedClassDescriptor;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ClassId classId = DescriptorUtilsKt.getClassId($declaration);
        if (classId == null || (refinedClassDescriptor = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) == null || Intrinsics.areEqual(refinedClassDescriptor, $declaration)) {
            return null;
        }
        return (SimpleType) this$0.eraseInflexibleBasedOnClassDescriptor($type, refinedClassDescriptor, $attr).getFirst();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    /* compiled from: RawSubstitution.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}