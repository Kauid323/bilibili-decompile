package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSubstitutorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: ClassicTypeSystemContext.kt */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {
    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker asRigidType(KotlinTypeMarker kotlinTypeMarker);

    KotlinTypeMarker createFlexibleType(RigidTypeMarker rigidTypeMarker, RigidTypeMarker rigidTypeMarker2);

    KotlinBuiltIns getBuiltIns();

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(RigidTypeMarker rigidTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isStarProjection(TypeArgumentMarker typeArgumentMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    TypeConstructorMarker typeConstructor(RigidTypeMarker rigidTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker withNullability(RigidTypeMarker rigidTypeMarker, boolean z);

    /* compiled from: ClassicTypeSystemContext.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        public static boolean isDenotable(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((TypeConstructor) receiver).isDenotable();
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return receiver instanceof IntegerLiteralTypeConstructor;
        }

        public static TypeParameterMarker getTypeParameter(ClassicTypeSystemContext $this, TypeVariableTypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof NewTypeVariableConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((NewTypeVariableConstructor) receiver).getOriginalTypeParameter();
        }

        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext $this, RigidTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            TypeConstructorMarker typeConstructor = $this.typeConstructor(receiver);
            if (!(typeConstructor instanceof IntegerLiteralTypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((IntegerLiteralTypeConstructor) typeConstructor).getPossibleTypes();
        }

        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext $this, RigidTypeMarker receiver, boolean nullable) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((SimpleType) receiver).makeNullableAsSpecified(nullable);
        }

        public static boolean isError(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return KotlinTypeKt.isError((KotlinType) receiver);
        }

        public static boolean isStubType(ClassicTypeSystemContext $this, RigidTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return TypeUtilsKt.isStubType((KotlinType) receiver);
        }

        public static boolean isStubTypeForBuilderInference(ClassicTypeSystemContext $this, RigidTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) receiver);
        }

        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext $this, CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof NewCapturedType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((NewCapturedType) receiver).getLowerType();
        }

        public static boolean isIntersection(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return receiver instanceof IntersectionTypeConstructor;
        }

        public static boolean identicalArguments(ClassicTypeSystemContext $this, RigidTypeMarker a, RigidTypeMarker b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            if (!(a instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + a + ", " + Reflection.getOrCreateKotlinClass(a.getClass())).toString());
            }
            if (b instanceof SimpleType) {
                return ((SimpleType) a).getArguments() == ((SimpleType) b).getArguments();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + b + ", " + Reflection.getOrCreateKotlinClass(b.getClass())).toString());
        }

        public static SimpleTypeMarker asRigidType(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            UnwrappedType unwrap = ((KotlinType) receiver).unwrap();
            return unwrap instanceof SimpleType ? (SimpleType) unwrap : null;
        }

        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            UnwrappedType unwrap = ((KotlinType) receiver).unwrap();
            return unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
        }

        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext $this, FlexibleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof FlexibleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return receiver instanceof DynamicType ? (DynamicType) receiver : null;
        }

        public static boolean isRawType(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return receiver instanceof RawType;
        }

        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext $this, FlexibleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof FlexibleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((FlexibleType) receiver).getUpperBound();
        }

        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext $this, FlexibleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof FlexibleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((FlexibleType) receiver).getLowerBound();
        }

        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext $this, SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            } else if (receiver instanceof SimpleTypeWithEnhancement) {
                return $this.asCapturedType(((SimpleTypeWithEnhancement) receiver).getOrigin());
            } else {
                return receiver instanceof NewCapturedType ? (NewCapturedType) receiver : null;
            }
        }

        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext $this, RigidTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return receiver instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) receiver : null;
        }

        public static boolean isNotNullTypeParameter(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver instanceof NotNullTypeParameter;
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return (receiver instanceof SimpleType) && ((SimpleType) receiver).isMarkedNullable();
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext $this, RigidTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((SimpleType) receiver).getConstructor();
        }

        public static CapturedTypeConstructorMarker typeConstructor(ClassicTypeSystemContext $this, CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof NewCapturedType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((NewCapturedType) receiver).getConstructor();
        }

        public static TypeArgumentMarker projection(ClassicTypeSystemContext $this, CapturedTypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof NewCapturedTypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((NewCapturedTypeConstructor) receiver).getProjection();
        }

        public static int argumentsCount(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((KotlinType) receiver).getArguments().size();
        }

        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext $this, KotlinTypeMarker receiver, int index) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((KotlinType) receiver).getArguments().get(index);
        }

        public static List<TypeArgumentMarker> getArguments(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((KotlinType) receiver).getArguments();
        }

        public static boolean isStarProjection(ClassicTypeSystemContext $this, TypeArgumentMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeProjection)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((TypeProjection) receiver).isStarProjection();
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext $this, TypeArgumentMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeProjection)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            Variance projectionKind = ((TypeProjection) receiver).getProjectionKind();
            Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
            return TypeSystemContextKt.convertVariance(projectionKind);
        }

        public static KotlinTypeMarker getType(ClassicTypeSystemContext $this, TypeArgumentMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if ($this.isStarProjection(receiver)) {
                return null;
            }
            if (!(receiver instanceof TypeProjection)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((TypeProjection) receiver).getType().unwrap();
        }

        public static int parametersCount(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((TypeConstructor) receiver).getParameters().size();
        }

        public static TypeParameterMarker getParameter(ClassicTypeSystemContext $this, TypeConstructorMarker receiver, int index) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) receiver).getParameters().get(index);
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "get(...)");
            return typeParameterDescriptor;
        }

        public static List<TypeParameterMarker> getParameters(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            List<TypeParameterDescriptor> parameters = ((TypeConstructor) receiver).getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            return parameters;
        }

        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            Collection<KotlinType> mo1172getSupertypes = ((TypeConstructor) receiver).mo1172getSupertypes();
            Intrinsics.checkNotNullExpressionValue(mo1172getSupertypes, "getSupertypes(...)");
            return mo1172getSupertypes;
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext $this, TypeParameterMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeParameterDescriptor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            Variance variance = ((TypeParameterDescriptor) receiver).getVariance();
            Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
            return TypeSystemContextKt.convertVariance(variance);
        }

        public static List<KotlinTypeMarker> getUpperBounds(ClassicTypeSystemContext $this, TypeParameterMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeParameterDescriptor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            List<KotlinType> upperBounds = ((TypeParameterDescriptor) receiver).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            return upperBounds;
        }

        public static TypeConstructorMarker getTypeConstructor(ClassicTypeSystemContext $this, TypeParameterMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeParameterDescriptor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            TypeConstructor typeConstructor = ((TypeParameterDescriptor) receiver).getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
            return typeConstructor;
        }

        public static boolean hasRecursiveBounds(ClassicTypeSystemContext $this, TypeParameterMarker receiver, TypeConstructorMarker selfConstructor) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeParameterDescriptor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
            }
            Object $this$errorMessage$iv = (TypeParameterDescriptor) receiver;
            if (selfConstructor == null ? true : selfConstructor instanceof TypeConstructor) {
                return TypeUtilsKt.hasTypeParameterRecursiveBounds$default((TypeParameterDescriptor) receiver, (TypeConstructor) selfConstructor, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + $this$errorMessage$iv + ", " + Reflection.getOrCreateKotlinClass($this$errorMessage$iv.getClass())).toString());
        }

        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext $this, TypeConstructorMarker c1, TypeConstructorMarker c2) {
            Intrinsics.checkNotNullParameter(c1, "c1");
            Intrinsics.checkNotNullParameter(c2, "c2");
            if (!(c1 instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c1 + ", " + Reflection.getOrCreateKotlinClass(c1.getClass())).toString());
            }
            if (!(c2 instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c2 + ", " + Reflection.getOrCreateKotlinClass(c2.getClass())).toString());
            }
            return Intrinsics.areEqual(c1, c2);
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((TypeConstructor) receiver).mo1171getDeclarationDescriptor() instanceof ClassDescriptor;
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((TypeConstructor) receiver).mo1171getDeclarationDescriptor();
            ClassDescriptor classDescriptor = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
            return (classDescriptor == null || !ModalityUtilsKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
        }

        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext $this, RigidTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return (TypeArgumentListMarker) receiver;
        }

        public static SimpleType captureFromArguments(ClassicTypeSystemContext $this, RigidTypeMarker type, CaptureStatus status) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(status, "status");
            if (!(type instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + type + ", " + Reflection.getOrCreateKotlinClass(type.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return NewCapturedTypeKt.captureFromArguments((SimpleType) type, status);
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) receiver, StandardNames.FqNames.any);
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) receiver, StandardNames.FqNames.nothing);
        }

        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return TypeUtilsKt.asTypeProjection((KotlinType) receiver);
        }

        public static boolean isSingleClassifierType(ClassicTypeSystemContext $this, RigidTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                return (KotlinTypeKt.isError((KotlinType) receiver) || (((SimpleType) receiver).getConstructor().mo1171getDeclarationDescriptor() instanceof TypeAliasDescriptor) || (((SimpleType) receiver).getConstructor().mo1171getDeclarationDescriptor() == null && !(receiver instanceof CapturedType) && !(receiver instanceof NewCapturedType) && !(receiver instanceof DefinitelyNotNullType) && !(((SimpleType) receiver).getConstructor() instanceof IntegerLiteralTypeConstructor) && !isSingleClassifierTypeWithEnhancement($this, (SimpleTypeMarker) receiver))) ? false : true;
            }
            Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
            throw new IllegalArgumentException($this$errorMessage$iv.toString());
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext $this, SimpleTypeMarker $receiver) {
            return ($receiver instanceof SimpleTypeWithEnhancement) && $this.isSingleClassifierType(((SimpleTypeWithEnhancement) $receiver).getOrigin());
        }

        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext $this, Collection<? extends KotlinTypeMarker> types) {
            Intrinsics.checkNotNullParameter(types, "types");
            return IntersectionTypeKt.intersectTypes(types);
        }

        public static KotlinTypeMarker createFlexibleType(ClassicTypeSystemContext $this, RigidTypeMarker lowerBound, RigidTypeMarker upperBound) {
            Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
            Intrinsics.checkNotNullParameter(upperBound, "upperBound");
            if (!(lowerBound instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + $this + ", " + Reflection.getOrCreateKotlinClass($this.getClass())).toString());
            }
            if (!(upperBound instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + $this + ", " + Reflection.getOrCreateKotlinClass($this.getClass())).toString());
            }
            return KotlinTypeFactory.flexibleType((SimpleType) lowerBound, (SimpleType) upperBound);
        }

        public static KotlinTypeMarker withNullability(ClassicTypeSystemContext $this, KotlinTypeMarker receiver, boolean nullable) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof RigidTypeMarker) {
                return $this.withNullability((RigidTypeMarker) receiver, nullable);
            }
            if (receiver instanceof FlexibleTypeMarker) {
                return $this.createFlexibleType($this.withNullability((RigidTypeMarker) $this.lowerBound((FlexibleTypeMarker) receiver), nullable), $this.withNullability((RigidTypeMarker) $this.upperBound((FlexibleTypeMarker) receiver), nullable));
            }
            throw new IllegalStateException("sealed".toString());
        }

        public static TypeCheckerState newTypeCheckerState(ClassicTypeSystemContext $this, boolean errorTypesEqualToAnything, boolean stubTypesEqualToAnything, boolean dnnTypesEqualToFlexible) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(errorTypesEqualToAnything, stubTypesEqualToAnything, $this, null, null, 24, null);
        }

        public static SimpleTypeMarker nullableAnyType(ClassicTypeSystemContext $this) {
            SimpleType nullableAnyType = $this.getBuiltIns().getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "getNullableAnyType(...)");
            return nullableAnyType;
        }

        public static KotlinBuiltIns getBuiltIns(ClassicTypeSystemContext $this) {
            throw new UnsupportedOperationException("Not supported");
        }

        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext $this, KotlinTypeMarker receiver, boolean preserveAttributes) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof UnwrappedType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ClassicTypeSystemContextKt.access$makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) receiver);
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext $this, CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof NewCapturedType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((NewCapturedType) receiver).isProjectionNotNull();
        }

        public static CaptureStatus captureStatus(ClassicTypeSystemContext $this, CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof NewCapturedType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((NewCapturedType) receiver).getCaptureStatus();
        }

        public static boolean isOldCapturedType(ClassicTypeSystemContext $this, CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver instanceof CapturedType;
        }

        public static boolean isNullableType(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return TypeUtils.isNullableType((KotlinType) receiver);
        }

        public static SimpleTypeMarker original(ClassicTypeSystemContext $this, DefinitelyNotNullTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof DefinitelyNotNullType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((DefinitelyNotNullType) receiver).getOriginal();
        }

        public static KotlinTypeMarker safeSubstitute(ClassicTypeSystemContext $this, TypeSubstitutorMarker receiver, KotlinTypeMarker type) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(type, "type");
            if (!(type instanceof UnwrappedType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + type + ", " + Reflection.getOrCreateKotlinClass(type.getClass())).toString());
            }
            if (!(receiver instanceof TypeSubstitutor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
            }
            KotlinType safeSubstitute = ((TypeSubstitutor) receiver).safeSubstitute((KotlinType) type, Variance.INVARIANT);
            Intrinsics.checkNotNullExpressionValue(safeSubstitute, "safeSubstitute(...)");
            return safeSubstitute;
        }

        public static boolean isPrimitiveType(ClassicTypeSystemContext $this, SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return KotlinBuiltIns.isPrimitiveType((KotlinType) receiver);
        }

        public static SimpleTypeMarker arrayType(ClassicTypeSystemContext $this, KotlinTypeMarker componentType) {
            Intrinsics.checkNotNullParameter(componentType, "componentType");
            if (!(componentType instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + $this + ", " + Reflection.getOrCreateKotlinClass($this.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            SimpleType arrayType = $this.getBuiltIns().getArrayType(Variance.INVARIANT, (KotlinType) componentType);
            Intrinsics.checkNotNullExpressionValue(arrayType, "getArrayType(...)");
            return arrayType;
        }

        public static boolean isArrayOrNullableArray(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return KotlinBuiltIns.isArray((KotlinType) receiver);
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext $this, KotlinTypeMarker receiver, FqName fqName) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return ((KotlinType) receiver).getAnnotations().hasAnnotation(fqName);
        }

        public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((TypeConstructor) receiver).mo1171getDeclarationDescriptor();
            return mo1171getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo1171getDeclarationDescriptor : null;
        }

        public static boolean isInlineClass(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((TypeConstructor) receiver).mo1171getDeclarationDescriptor();
            ClassDescriptor classDescriptor = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
            return (classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null) instanceof InlineClassRepresentation;
        }

        public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext $this, TypeParameterMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeParameterDescriptor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) receiver);
        }

        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof KotlinType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) receiver);
        }

        public static TypeSubstitutorMarker typeSubstitutorForUnderlyingType(ClassicTypeSystemContext $this, Map<TypeConstructorMarker, ? extends KotlinTypeMarker> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            Collection destination$iv$iv = new ArrayList(map.size());
            for (Map.Entry item$iv$iv : map.entrySet()) {
                TypeConstructorMarker parameter = item$iv$iv.getKey();
                KotlinTypeMarker argument = item$iv$iv.getValue();
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type org.jetbrains.kotlin.types.TypeConstructor");
                Intrinsics.checkNotNull(argument, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                destination$iv$iv.add(TuplesKt.to((TypeConstructor) parameter, TypeUtilsKt.asTypeProjection((KotlinType) argument)));
            }
            Map it = MapsKt.toMap((List) destination$iv$iv);
            TypeSubstitutor create = TypeSubstitutor.create(it);
            Intrinsics.checkNotNullExpressionValue(create, "let(...)");
            return create;
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((TypeConstructor) receiver).mo1171getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo1171getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) mo1171getDeclarationDescriptor);
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((TypeConstructor) receiver).mo1171getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo1171getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) mo1171getDeclarationDescriptor);
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            DeclarationDescriptor mo1171getDeclarationDescriptor = ((TypeConstructor) receiver).mo1171getDeclarationDescriptor();
            if (mo1171getDeclarationDescriptor != null) {
                DeclarationDescriptor p0 = mo1171getDeclarationDescriptor;
                return KotlinBuiltIns.isUnderKotlinPackage(p0);
            }
            return false;
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext $this, TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeConstructor)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + receiver + ", " + Reflection.getOrCreateKotlinClass(receiver.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((TypeConstructor) receiver).mo1171getDeclarationDescriptor();
            Intrinsics.checkNotNull(mo1171getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) mo1171getDeclarationDescriptor);
        }

        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(final ClassicTypeSystemContext $this, RigidTypeMarker type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (!(type instanceof SimpleType)) {
                Object $this$errorMessage$iv = "ClassicTypeSystemContext couldn't handle: " + type + ", " + Reflection.getOrCreateKotlinClass(type.getClass());
                throw new IllegalArgumentException($this$errorMessage$iv.toString());
            }
            final TypeSubstitutor substitutor = TypeConstructorSubstitution.Companion.create((KotlinType) type).buildSubstitutor();
            return new TypeCheckerState.SupertypesPolicy.DoCustomTransform() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext$substitutionSupertypePolicy$2
                @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
                /* renamed from: transformType */
                public SimpleTypeMarker mo1175transformType(TypeCheckerState state, KotlinTypeMarker type2) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(type2, "type");
                    ClassicTypeSystemContext classicTypeSystemContext = ClassicTypeSystemContext.this;
                    TypeSubstitutor typeSubstitutor = substitutor;
                    RigidTypeMarker lowerBoundIfFlexible = ClassicTypeSystemContext.this.lowerBoundIfFlexible(type2);
                    Intrinsics.checkNotNull(lowerBoundIfFlexible, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                    KotlinType safeSubstitute = typeSubstitutor.safeSubstitute((KotlinType) lowerBoundIfFlexible, Variance.INVARIANT);
                    Intrinsics.checkNotNullExpressionValue(safeSubstitute, "safeSubstitute(...)");
                    SimpleTypeMarker asRigidType = classicTypeSystemContext.asRigidType((KotlinTypeMarker) safeSubstitute);
                    Intrinsics.checkNotNull(asRigidType);
                    return asRigidType;
                }
            };
        }

        public static boolean isTypeVariableType(ClassicTypeSystemContext $this, KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return (receiver instanceof UnwrappedType) && (((UnwrappedType) receiver).getConstructor() instanceof NewTypeVariableConstructor);
        }

        public static boolean isK2(ClassicTypeSystemContext $this) {
            return false;
        }
    }
}