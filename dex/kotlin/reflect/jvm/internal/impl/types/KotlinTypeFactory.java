package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: KotlinTypeFactory.kt */
public final class KotlinTypeFactory {
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1
        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<unused var>");
            return null;
        }
    };

    @JvmStatic
    public static final SimpleType simpleType(TypeAttributes attributes, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean z) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return simpleType$default(attributes, constructor, arguments, z, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    private KotlinTypeFactory() {
    }

    private final MemberScope computeMemberScope(TypeConstructor constructor, List<? extends TypeProjection> list, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor descriptor = constructor.mo1171getDeclarationDescriptor();
        if (descriptor instanceof TypeParameterDescriptor) {
            return ((TypeParameterDescriptor) descriptor).getDefaultType().getMemberScope();
        }
        if (descriptor instanceof ClassDescriptor) {
            KotlinTypeRefiner refinerToUse = kotlinTypeRefiner == null ? DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(descriptor)) : kotlinTypeRefiner;
            if (list.isEmpty()) {
                return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) descriptor, refinerToUse);
            }
            return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) descriptor, TypeConstructorSubstitution.Companion.create(constructor, list), refinerToUse);
        } else if (descriptor instanceof TypeAliasDescriptor) {
            ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE;
            String name = ((TypeAliasDescriptor) descriptor).getName().toString();
            Intrinsics.checkNotNullExpressionValue(name, "toString(...)");
            return ErrorUtils.createErrorScope(errorScopeKind, true, name);
        } else if (constructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) constructor).createScopeForKotlinType();
        } else {
            throw new IllegalStateException("Unsupported classifier: " + descriptor + " for constructor: " + constructor);
        }
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List list, boolean z, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        if ((i & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(typeAttributes, typeConstructor, list, z, kotlinTypeRefiner);
    }

    @JvmStatic
    public static final SimpleType simpleType(TypeAttributes attributes, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean nullable, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (attributes.isEmpty() && arguments.isEmpty() && !nullable && constructor.mo1171getDeclarationDescriptor() != null) {
            ClassifierDescriptor mo1171getDeclarationDescriptor = constructor.mo1171getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo1171getDeclarationDescriptor);
            SimpleType defaultType = mo1171getDeclarationDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            return defaultType;
        }
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, arguments, nullable, INSTANCE.computeMemberScope(constructor, arguments, kotlinTypeRefiner), new Function1(constructor, arguments, attributes, nullable) { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$0
            private final TypeConstructor arg$0;
            private final List arg$1;
            private final TypeAttributes arg$2;
            private final boolean arg$3;

            {
                this.arg$0 = constructor;
                this.arg$1 = arguments;
                this.arg$2 = attributes;
                this.arg$3 = nullable;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType simpleType$lambda$0;
                simpleType$lambda$0 = KotlinTypeFactory.simpleType$lambda$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, (KotlinTypeRefiner) obj);
                return simpleType$lambda$0;
            }
        });
    }

    public static final SimpleType simpleType$lambda$0(TypeConstructor $constructor, List $arguments, TypeAttributes $attributes, boolean $nullable, KotlinTypeRefiner refiner) {
        Intrinsics.checkNotNullParameter(refiner, "refiner");
        ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructor = INSTANCE.refineConstructor($constructor, refiner, $arguments);
        if (expandedTypeOrRefinedConstructor == null) {
            return null;
        }
        SimpleType it = expandedTypeOrRefinedConstructor.getExpandedType();
        if (it != null) {
            return it;
        }
        TypeConstructor refinedConstructor = expandedTypeOrRefinedConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return simpleType($attributes, refinedConstructor, $arguments, $nullable, refiner);
    }

    @JvmStatic
    public static final SimpleType computeExpandedType(TypeAliasDescriptor $this$computeExpandedType, List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter($this$computeExpandedType, "<this>");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, $this$computeExpandedType, arguments), TypeAttributes.Companion.getEmpty());
    }

    private final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor constructor, KotlinTypeRefiner kotlinTypeRefiner, List<? extends TypeProjection> list) {
        ClassifierDescriptor it;
        ClassifierDescriptor basicDescriptor = constructor.mo1171getDeclarationDescriptor();
        if (basicDescriptor == null || (it = kotlinTypeRefiner.refineDescriptor(basicDescriptor)) == null) {
            return null;
        }
        if (it instanceof TypeAliasDescriptor) {
            return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) it, list), null);
        }
        TypeConstructor refinedConstructor = it.getTypeConstructor().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refinedConstructor, "refine(...)");
        return new ExpandedTypeOrRefinedConstructor(null, refinedConstructor);
    }

    /* compiled from: KotlinTypeFactory.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ExpandedTypeOrRefinedConstructor {
        private final SimpleType expandedType;
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(SimpleType expandedType, TypeConstructor refinedConstructor) {
            this.expandedType = expandedType;
            this.refinedConstructor = refinedConstructor;
        }

        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes attributes, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean nullable, MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        SimpleTypeImpl it = new SimpleTypeImpl(constructor, arguments, nullable, memberScope, new Function1(constructor, arguments, attributes, nullable, memberScope) { // from class: kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory$$Lambda$1
            private final TypeConstructor arg$0;
            private final List arg$1;
            private final TypeAttributes arg$2;
            private final boolean arg$3;
            private final MemberScope arg$4;

            {
                this.arg$0 = constructor;
                this.arg$1 = arguments;
                this.arg$2 = attributes;
                this.arg$3 = nullable;
                this.arg$4 = memberScope;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType simpleTypeWithNonTrivialMemberScope$lambda$0;
                simpleTypeWithNonTrivialMemberScope$lambda$0 = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope$lambda$0(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, (KotlinTypeRefiner) obj);
                return simpleTypeWithNonTrivialMemberScope$lambda$0;
            }
        });
        if (attributes.isEmpty()) {
            return it;
        }
        return new SimpleTypeWithAttributes(it, attributes);
    }

    public static final SimpleType simpleTypeWithNonTrivialMemberScope$lambda$0(TypeConstructor $constructor, List $arguments, TypeAttributes $attributes, boolean $nullable, MemberScope $memberScope, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        ExpandedTypeOrRefinedConstructor expandedTypeOrRefinedConstructor = INSTANCE.refineConstructor($constructor, kotlinTypeRefiner, $arguments);
        if (expandedTypeOrRefinedConstructor == null) {
            return null;
        }
        SimpleType it = expandedTypeOrRefinedConstructor.getExpandedType();
        if (it != null) {
            return it;
        }
        TypeConstructor refinedConstructor = expandedTypeOrRefinedConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return simpleTypeWithNonTrivialMemberScope($attributes, refinedConstructor, $arguments, $nullable, $memberScope);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes attributes, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean nullable, MemberScope memberScope, Function1<? super KotlinTypeRefiner, ? extends SimpleType> refinedTypeFactory) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(refinedTypeFactory, "refinedTypeFactory");
        SimpleTypeImpl it = new SimpleTypeImpl(constructor, arguments, nullable, memberScope, refinedTypeFactory);
        if (attributes.isEmpty()) {
            return it;
        }
        return new SimpleTypeWithAttributes(it, attributes);
    }

    @JvmStatic
    public static final SimpleType simpleNotNullType(TypeAttributes attributes, ClassDescriptor descriptor, List<? extends TypeProjection> arguments) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        TypeConstructor typeConstructor = descriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        return simpleType$default(attributes, typeConstructor, (List) arguments, false, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType simpleType, TypeAttributes typeAttributes, TypeConstructor typeConstructor, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        if ((i & 4) != 0) {
            typeConstructor = simpleType.getConstructor();
        }
        if ((i & 8) != 0) {
            list = simpleType.getArguments();
        }
        if ((i & 16) != 0) {
            z = simpleType.isMarkedNullable();
        }
        return simpleType(simpleType, typeAttributes, typeConstructor, list, z);
    }

    @JvmStatic
    public static final SimpleType simpleType(SimpleType baseType, TypeAttributes annotations, TypeConstructor constructor, List<? extends TypeProjection> arguments, boolean nullable) {
        Intrinsics.checkNotNullParameter(baseType, "baseType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        return simpleType$default(annotations, constructor, arguments, nullable, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @JvmStatic
    public static final UnwrappedType flexibleType(SimpleType lowerBound, SimpleType upperBound) {
        Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        Intrinsics.checkNotNullParameter(upperBound, "upperBound");
        return Intrinsics.areEqual(lowerBound, upperBound) ? lowerBound : new FlexibleTypeImpl(lowerBound, upperBound);
    }

    @JvmStatic
    public static final SimpleType integerLiteralType(TypeAttributes attributes, IntegerLiteralTypeConstructor constructor, boolean nullable) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        return simpleTypeWithNonTrivialMemberScope(attributes, constructor, CollectionsKt.emptyList(), nullable, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }
}