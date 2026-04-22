package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: DescriptorRenderer.kt */
public abstract class DescriptorRenderer {
    public static final Companion Companion = new Companion(null);
    public static final DescriptorRenderer WITHOUT_MODIFIERS = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$0
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit WITHOUT_MODIFIERS$lambda$0;
            WITHOUT_MODIFIERS$lambda$0 = DescriptorRenderer.WITHOUT_MODIFIERS$lambda$0((DescriptorRendererOptions) obj);
            return WITHOUT_MODIFIERS$lambda$0;
        }
    });
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$1
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit COMPACT_WITH_MODIFIERS$lambda$0;
            COMPACT_WITH_MODIFIERS$lambda$0 = DescriptorRenderer.COMPACT_WITH_MODIFIERS$lambda$0((DescriptorRendererOptions) obj);
            return COMPACT_WITH_MODIFIERS$lambda$0;
        }
    });
    public static final DescriptorRenderer COMPACT = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$2
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit COMPACT$lambda$0;
            COMPACT$lambda$0 = DescriptorRenderer.COMPACT$lambda$0((DescriptorRendererOptions) obj);
            return COMPACT$lambda$0;
        }
    });
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$3
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit COMPACT_WITHOUT_SUPERTYPES$lambda$0;
            COMPACT_WITHOUT_SUPERTYPES$lambda$0 = DescriptorRenderer.COMPACT_WITHOUT_SUPERTYPES$lambda$0((DescriptorRendererOptions) obj);
            return COMPACT_WITHOUT_SUPERTYPES$lambda$0;
        }
    });
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$4
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit COMPACT_WITH_SHORT_TYPES$lambda$0;
            COMPACT_WITH_SHORT_TYPES$lambda$0 = DescriptorRenderer.COMPACT_WITH_SHORT_TYPES$lambda$0((DescriptorRendererOptions) obj);
            return COMPACT_WITH_SHORT_TYPES$lambda$0;
        }
    });
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$5
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$0;
            ONLY_NAMES_WITH_SHORT_TYPES$lambda$0 = DescriptorRenderer.ONLY_NAMES_WITH_SHORT_TYPES$lambda$0((DescriptorRendererOptions) obj);
            return ONLY_NAMES_WITH_SHORT_TYPES$lambda$0;
        }
    });
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$6
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit FQ_NAMES_IN_TYPES$lambda$0;
            FQ_NAMES_IN_TYPES$lambda$0 = DescriptorRenderer.FQ_NAMES_IN_TYPES$lambda$0((DescriptorRendererOptions) obj);
            return FQ_NAMES_IN_TYPES$lambda$0;
        }
    });
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$7
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$0;
            FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$0 = DescriptorRenderer.FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$0((DescriptorRendererOptions) obj);
            return FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$0;
        }
    });
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$8
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit SHORT_NAMES_IN_TYPES$lambda$0;
            SHORT_NAMES_IN_TYPES$lambda$0 = DescriptorRenderer.SHORT_NAMES_IN_TYPES$lambda$0((DescriptorRendererOptions) obj);
            return SHORT_NAMES_IN_TYPES$lambda$0;
        }
    });
    public static final DescriptorRenderer DEBUG_TEXT = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$9
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit DEBUG_TEXT$lambda$0;
            DEBUG_TEXT$lambda$0 = DescriptorRenderer.DEBUG_TEXT$lambda$0((DescriptorRendererOptions) obj);
            return DEBUG_TEXT$lambda$0;
        }
    });
    public static final DescriptorRenderer HTML = Companion.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$10
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Unit HTML$lambda$0;
            HTML$lambda$0 = DescriptorRenderer.HTML$lambda$0((DescriptorRendererOptions) obj);
            return HTML$lambda$0;
        }
    });

    public abstract String render(DeclarationDescriptor declarationDescriptor);

    public abstract String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns);

    public abstract String renderFqName(FqNameUnsafe fqNameUnsafe);

    public abstract String renderName(Name name, boolean z);

    public abstract String renderType(KotlinType kotlinType);

    public abstract String renderTypeProjection(TypeProjection typeProjection);

    public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
        Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl options = ((DescriptorRendererImpl) this).getOptions().copy();
        changeOptions.invoke(options);
        options.lock();
        return new DescriptorRendererImpl(options);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface ValueParametersHandler {
        void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendAfterValueParameters(int i, StringBuilder sb);

        void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendBeforeValueParameters(int i, StringBuilder sb);

        /* compiled from: DescriptorRenderer.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT INSTANCE = new DEFAULT();

            private DEFAULT() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int parameterCount, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int parameterCount, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(ValueParameterDescriptor parameter, int parameterIndex, int parameterCount, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(parameter, "parameter");
                Intrinsics.checkNotNullParameter(builder, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(ValueParameterDescriptor parameter, int parameterIndex, int parameterCount, StringBuilder builder) {
                Intrinsics.checkNotNullParameter(parameter, "parameter");
                Intrinsics.checkNotNullParameter(builder, "builder");
                if (parameterIndex != parameterCount - 1) {
                    builder.append(", ");
                }
            }
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {

        /* compiled from: DescriptorRenderer.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassKind.values().length];
                try {
                    iArr[ClassKind.CLASS.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[ClassKind.INTERFACE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[ClassKind.OBJECT.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DescriptorRenderer withOptions(Function1<? super DescriptorRendererOptions, Unit> changeOptions) {
            Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
            DescriptorRendererOptionsImpl options = new DescriptorRendererOptionsImpl();
            changeOptions.invoke(options);
            options.lock();
            return new DescriptorRendererImpl(options);
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters classifier) {
            Intrinsics.checkNotNullParameter(classifier, "classifier");
            if (classifier instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifier instanceof ClassDescriptor) {
                if (((ClassDescriptor) classifier).isCompanionObject()) {
                    return "companion object";
                }
                switch (WhenMappings.$EnumSwitchMapping$0[((ClassDescriptor) classifier).getKind().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            throw new AssertionError("Unexpected classifier: " + classifier);
        }
    }

    public static final Unit WITHOUT_MODIFIERS$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    public static final Unit COMPACT_WITH_MODIFIERS$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        return Unit.INSTANCE;
    }

    public static final Unit COMPACT$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    public static final Unit COMPACT_WITHOUT_SUPERTYPES$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(SetsKt.emptySet());
        withOptions.setWithoutSuperTypes(true);
        return Unit.INSTANCE;
    }

    public static final Unit COMPACT_WITH_SHORT_TYPES$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(SetsKt.emptySet());
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    public static final Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(SetsKt.emptySet());
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setWithoutTypeParameters(true);
        withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
        withOptions.setReceiverAfterName(true);
        withOptions.setRenderCompanionObjectName(true);
        withOptions.setWithoutSuperTypes(true);
        withOptions.setStartFromName(true);
        return Unit.INSTANCE;
    }

    public static final Unit FQ_NAMES_IN_TYPES$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return Unit.INSTANCE;
    }

    public static final Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    public static final Unit SHORT_NAMES_IN_TYPES$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return Unit.INSTANCE;
    }

    public static final Unit DEBUG_TEXT$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setDebugMode(true);
        withOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }

    public static final Unit HTML$lambda$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setTextFormat(RenderingFormat.HTML);
        withOptions.setModifiers(DescriptorRendererModifier.ALL);
        return Unit.INSTANCE;
    }
}