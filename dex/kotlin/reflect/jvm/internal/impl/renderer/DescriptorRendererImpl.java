package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Marker;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    private final Lazy functionTypeAnnotationsRenderer$delegate;
    private final DescriptorRendererOptionsImpl options;

    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            try {
                iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RenderingFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            try {
                iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderAbbreviatedTypeComments() {
        return this.options.getRenderAbbreviatedTypeComments();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z) {
        this.options.setDebugMode(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z) {
        this.options.setReceiverAfterName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z) {
        this.options.setRenderCompanionObjectName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z) {
        this.options.setStartFromName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.options.setTextFormat(renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z) {
        this.options.setVerbose(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z) {
        this.options.setWithDefinedIn(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z) {
        this.options.setWithoutSuperTypes(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z) {
        this.options.setWithoutTypeParameters(z);
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        if (!this.options.isLocked()) {
            throw new AssertionError("Assertion failed");
        }
        this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$0
            private final DescriptorRendererImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                DescriptorRendererImpl functionTypeAnnotationsRenderer_delegate$lambda$0;
                functionTypeAnnotationsRenderer_delegate$lambda$0 = DescriptorRendererImpl.functionTypeAnnotationsRenderer_delegate$lambda$0(this.arg$0);
                return functionTypeAnnotationsRenderer_delegate$lambda$0;
            }
        });
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DescriptorRendererImpl functionTypeAnnotationsRenderer_delegate$lambda$0(DescriptorRendererImpl this$0) {
        DescriptorRenderer withOptions = this$0.withOptions(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$7
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit functionTypeAnnotationsRenderer_delegate$lambda$0$0;
                functionTypeAnnotationsRenderer_delegate$lambda$0$0 = DescriptorRendererImpl.functionTypeAnnotationsRenderer_delegate$lambda$0$0((DescriptorRendererOptions) obj);
                return functionTypeAnnotationsRenderer_delegate$lambda$0$0;
            }
        });
        Intrinsics.checkNotNull(withOptions, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (DescriptorRendererImpl) withOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit functionTypeAnnotationsRenderer_delegate$lambda$0$0(DescriptorRendererOptions withOptions) {
        Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setExcludedTypeAnnotationClasses(SetsKt.plus((Set) withOptions.getExcludedTypeAnnotationClasses(), (Iterable) CollectionsKt.listOf((Object[]) new FqName[]{StandardNames.FqNames.extensionFunctionType, StandardNames.FqNames.contextFunctionTypeParams})));
        return Unit.INSTANCE;
    }

    private final String renderKeyword(String keyword) {
        switch (WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()]) {
            case 1:
                break;
            default:
                throw new NoWhenBranchMatchedException();
            case 2:
                if (!getBoldOnlyForNamesInHtml()) {
                    return "<b>" + keyword + "</b>";
                }
                break;
        }
        return keyword;
    }

    private final String renderError(String keyword) {
        switch (WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()]) {
            case 1:
                return keyword;
            case 2:
                return "<font color=red><b>" + keyword + "</b></font>";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String escape(String string) {
        return getTextFormat().escape(string);
    }

    private final String lt() {
        return escape("<");
    }

    private final String gt() {
        return escape(">");
    }

    private final String arrow() {
        switch (WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()]) {
            case 1:
                return escape("->");
            case 2:
                return "&rarr;";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public String renderMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        switch (WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()]) {
            case 1:
                return message;
            case 2:
                return "<i>" + message + "</i>";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderName(Name name, boolean rootRenderedElement) {
        Intrinsics.checkNotNullParameter(name, "name");
        String escaped = escape(RenderingUtilsKt.render(name));
        if (getBoldOnlyForNamesInHtml() && getTextFormat() == RenderingFormat.HTML && rootRenderedElement) {
            return "<b>" + escaped + "</b>";
        }
        return escaped;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderName(DeclarationDescriptor descriptor, StringBuilder builder, boolean rootRenderedElement) {
        Name name = descriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        builder.append(renderName(name, rootRenderedElement));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor descriptor, StringBuilder builder) {
        if (getRenderCompanionObjectName()) {
            if (getStartFromName()) {
                builder.append("companion object");
            }
            renderSpaceIfNeeded(builder);
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                builder.append("of ");
                Name name = containingDeclaration.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                builder.append(renderName(name, false));
            }
        }
        if (getVerbose() || !Intrinsics.areEqual(descriptor.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(builder);
            }
            Name name2 = descriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            builder.append(renderName(name2, true));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFqName(FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return renderFqName(fqName.pathSegments());
    }

    private final String renderFqName(List<Name> list) {
        return escape(RenderingUtilsKt.renderFqName(list));
    }

    public String renderClassifierName(ClassifierDescriptor klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (ErrorUtils.isError(klass)) {
            return klass.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(klass, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderType(KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        StringBuilder $this$renderType_u24lambda_u240 = new StringBuilder();
        renderNormalizedType($this$renderType_u24lambda_u240, getTypeNormalizer().invoke(type));
        return $this$renderType_u24lambda_u240.toString();
    }

    private final void renderNormalizedType(StringBuilder $this$renderNormalizedType, KotlinType type) {
        UnwrappedType unwrap = type.unwrap();
        AbbreviatedType abbreviated = unwrap instanceof AbbreviatedType ? (AbbreviatedType) unwrap : null;
        if (abbreviated != null) {
            if (getRenderTypeExpansions()) {
                renderNormalizedTypeAsIs($this$renderNormalizedType, abbreviated.getExpandedType());
                if (getRenderAbbreviatedTypeComments()) {
                    renderAbbreviatedTypeComment($this$renderNormalizedType, abbreviated);
                    return;
                }
                return;
            }
            renderNormalizedTypeAsIs($this$renderNormalizedType, abbreviated.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                renderExpandedTypeComment($this$renderNormalizedType, abbreviated);
                return;
            }
            return;
        }
        renderNormalizedTypeAsIs($this$renderNormalizedType, type);
    }

    private final void renderAbbreviatedTypeComment(StringBuilder $this$renderAbbreviatedTypeComment, AbbreviatedType abbreviated) {
        if (getTextFormat() == RenderingFormat.HTML) {
            $this$renderAbbreviatedTypeComment.append("<font color=\"808080\"><i>");
        }
        $this$renderAbbreviatedTypeComment.append(" /* ");
        $this$renderAbbreviatedTypeComment.append("from: ");
        renderNormalizedTypeAsIs($this$renderAbbreviatedTypeComment, abbreviated.getAbbreviation());
        $this$renderAbbreviatedTypeComment.append(" */");
        if (getTextFormat() == RenderingFormat.HTML) {
            $this$renderAbbreviatedTypeComment.append("</i></font>");
        }
    }

    private final void renderExpandedTypeComment(StringBuilder $this$renderExpandedTypeComment, AbbreviatedType abbreviated) {
        if (getTextFormat() == RenderingFormat.HTML) {
            $this$renderExpandedTypeComment.append("<font color=\"808080\"><i>");
        }
        $this$renderExpandedTypeComment.append(" /* ");
        $this$renderExpandedTypeComment.append("= ");
        renderNormalizedTypeAsIs($this$renderExpandedTypeComment, abbreviated.getExpandedType());
        $this$renderExpandedTypeComment.append(" */");
        if (getTextFormat() == RenderingFormat.HTML) {
            $this$renderExpandedTypeComment.append("</i></font>");
        }
    }

    private final void renderNormalizedTypeAsIs(StringBuilder $this$renderNormalizedTypeAsIs, KotlinType type) {
        if ((type instanceof WrappedType) && getDebugMode() && !((WrappedType) type).isComputed()) {
            $this$renderNormalizedTypeAsIs.append("<Not computed yet>");
            return;
        }
        UnwrappedType unwrappedType = type.unwrap();
        if (!(unwrappedType instanceof FlexibleType)) {
            if (!(unwrappedType instanceof SimpleType)) {
                throw new NoWhenBranchMatchedException();
            }
            renderSimpleType($this$renderNormalizedTypeAsIs, (SimpleType) unwrappedType);
            return;
        }
        $this$renderNormalizedTypeAsIs.append(((FlexibleType) unwrappedType).render(this, this));
    }

    private final void renderSimpleType(StringBuilder $this$renderSimpleType, SimpleType type) {
        if (Intrinsics.areEqual(type, TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) || TypeUtils.isDontCarePlaceholder(type)) {
            $this$renderSimpleType.append("???");
        } else if (ErrorUtils.isUninferredTypeVariable(type)) {
            if (getUninferredTypeParameterAsName()) {
                TypeConstructor constructor = type.getConstructor();
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                $this$renderSimpleType.append(renderError(((ErrorTypeConstructor) constructor).getParam(0)));
                return;
            }
            $this$renderSimpleType.append("???");
        } else if (KotlinTypeKt.isError(type)) {
            renderDefaultType($this$renderSimpleType, type);
        } else if (shouldRenderAsPrettyFunctionType(type)) {
            renderFunctionType($this$renderSimpleType, type);
        } else {
            renderDefaultType($this$renderSimpleType, type);
        }
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType type) {
        Iterable $this$none$iv;
        if (FunctionTypesKt.isBuiltinFunctionalType(type)) {
            Iterable $this$none$iv2 = type.getArguments();
            if (!($this$none$iv2 instanceof Collection) || !((Collection) $this$none$iv2).isEmpty()) {
                Iterator<T> it = $this$none$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        TypeProjection it2 = (TypeProjection) element$iv;
                        if (it2.isStarProjection()) {
                            $this$none$iv = null;
                            break;
                        }
                    } else {
                        $this$none$iv = 1;
                        break;
                    }
                }
            } else {
                $this$none$iv = 1;
            }
            return $this$none$iv != null;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderFlexibleType(String lowerRendered, String upperRendered, final KotlinBuiltIns builtIns) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (RenderingUtilsKt.typeStringsDifferOnlyInNullability(lowerRendered, upperRendered)) {
            if (StringsKt.startsWith$default(upperRendered, "(", false, 2, (Object) null)) {
                return '(' + lowerRendered + ")!";
            }
            return lowerRendered + '!';
        }
        String renderFlexibleMutabilityOrArrayElementVarianceType = RenderingUtilsKt.renderFlexibleMutabilityOrArrayElementVarianceType(lowerRendered, upperRendered, new Function0(this, builtIns) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$1
            private final DescriptorRendererImpl arg$0;
            private final KotlinBuiltIns arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = builtIns;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String renderFlexibleType$lambda$0;
                renderFlexibleType$lambda$0 = DescriptorRendererImpl.renderFlexibleType$lambda$0(this.arg$0, this.arg$1);
                return renderFlexibleType$lambda$0;
            }
        }, new Function0(this, builtIns) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$2
            private final DescriptorRendererImpl arg$0;
            private final KotlinBuiltIns arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = builtIns;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String renderFlexibleType$lambda$1;
                renderFlexibleType$lambda$1 = DescriptorRendererImpl.renderFlexibleType$lambda$1(this.arg$0, this.arg$1);
                return renderFlexibleType$lambda$1;
            }
        }, new DescriptorRendererImpl$renderFlexibleType$3(this));
        if (renderFlexibleMutabilityOrArrayElementVarianceType != null) {
            return renderFlexibleMutabilityOrArrayElementVarianceType;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$0(DescriptorRendererImpl this$0, KotlinBuiltIns $builtIns) {
        ClassifierNamePolicy classifierNamePolicy = this$0.getClassifierNamePolicy();
        ClassDescriptor collection = $builtIns.getCollection();
        Intrinsics.checkNotNullExpressionValue(collection, "getCollection(...)");
        return StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this$0), "Collection", (String) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderFlexibleType$lambda$1(DescriptorRendererImpl this$0, KotlinBuiltIns $builtIns) {
        ClassifierNamePolicy classifierNamePolicy = this$0.getClassifierNamePolicy();
        ClassDescriptor array = $builtIns.getArray();
        Intrinsics.checkNotNullExpressionValue(array, "getArray(...)");
        return StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(array, this$0), "Array", (String) null, 2, (Object) null);
    }

    public String renderTypeArguments(List<? extends TypeProjection> typeArguments) {
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder $this$renderTypeArguments_u24lambda_u240 = new StringBuilder();
        $this$renderTypeArguments_u24lambda_u240.append(lt());
        appendTypeProjections($this$renderTypeArguments_u24lambda_u240, typeArguments);
        $this$renderTypeArguments_u24lambda_u240.append(gt());
        return $this$renderTypeArguments_u24lambda_u240.toString();
    }

    private final void renderDefaultType(StringBuilder $this$renderDefaultType, KotlinType type) {
        renderAnnotations$default(this, $this$renderDefaultType, type, null, 2, null);
        DefinitelyNotNullType definitelyNotNullType = type instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) type : null;
        SimpleType originalTypeOfDefNotNullType = definitelyNotNullType != null ? definitelyNotNullType.getOriginal() : null;
        if (KotlinTypeKt.isError(type)) {
            if (TypeUtilsKt.isUnresolvedType(type) && getPresentableUnresolvedTypes()) {
                $this$renderDefaultType.append(renderError(ErrorUtils.INSTANCE.unresolvedTypeAsItIs(type)));
            } else {
                if ((type instanceof ErrorType) && !getInformativeErrorType()) {
                    $this$renderDefaultType.append(((ErrorType) type).getDebugMessage());
                } else {
                    $this$renderDefaultType.append(type.getConstructor().toString());
                }
                $this$renderDefaultType.append(renderTypeArguments(type.getArguments()));
            }
        } else if (type instanceof StubTypeForBuilderInference) {
            $this$renderDefaultType.append(((StubTypeForBuilderInference) type).getOriginalTypeVariable().toString());
        } else if (originalTypeOfDefNotNullType instanceof StubTypeForBuilderInference) {
            $this$renderDefaultType.append(((StubTypeForBuilderInference) originalTypeOfDefNotNullType).getOriginalTypeVariable().toString());
        } else {
            renderTypeConstructorAndArguments$default(this, $this$renderDefaultType, type, null, 2, null);
            Unit unit = Unit.INSTANCE;
        }
        if (type.isMarkedNullable()) {
            $this$renderDefaultType.append("?");
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(type)) {
            $this$renderDefaultType.append(" & Any");
        }
    }

    static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, KotlinType kotlinType, TypeConstructor typeConstructor, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(sb, kotlinType, typeConstructor);
    }

    private final void renderTypeConstructorAndArguments(StringBuilder $this$renderTypeConstructorAndArguments, KotlinType type, TypeConstructor typeConstructor) {
        PossiblyInnerType possiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(type);
        if (possiblyInnerType == null) {
            $this$renderTypeConstructorAndArguments.append(renderTypeConstructor(typeConstructor));
            $this$renderTypeConstructorAndArguments.append(renderTypeArguments(type.getArguments()));
            return;
        }
        renderPossiblyInnerType($this$renderTypeConstructorAndArguments, possiblyInnerType);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r5.append(renderName(r2, false)) == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renderPossiblyInnerType(StringBuilder $this$renderPossiblyInnerType, PossiblyInnerType possiblyInnerType) {
        PossiblyInnerType it = possiblyInnerType.getOuterType();
        if (it != null) {
            renderPossiblyInnerType($this$renderPossiblyInnerType, it);
            $this$renderPossiblyInnerType.append(FilenameUtils.EXTENSION_SEPARATOR);
            Name name = possiblyInnerType.getClassifierDescriptor().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        }
        TypeConstructor typeConstructor = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
        $this$renderPossiblyInnerType.append(renderTypeConstructor(typeConstructor));
        $this$renderPossiblyInnerType.append(renderTypeArguments(possiblyInnerType.getArguments()));
    }

    public String renderTypeConstructor(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor cd = typeConstructor.mo1171getDeclarationDescriptor();
        if ((cd instanceof TypeParameterDescriptor) || (cd instanceof ClassDescriptor) || (cd instanceof TypeAliasDescriptor)) {
            return renderClassifierName(cd);
        }
        if (cd == null) {
            if (typeConstructor instanceof IntersectionTypeConstructor) {
                return ((IntersectionTypeConstructor) typeConstructor).makeDebugNameForIntersectionType(new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$3
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        Object renderTypeConstructor$lambda$0;
                        renderTypeConstructor$lambda$0 = DescriptorRendererImpl.renderTypeConstructor$lambda$0((KotlinType) obj);
                        return renderTypeConstructor$lambda$0;
                    }
                });
            }
            return typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + cd.getClass()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object renderTypeConstructor$lambda$0(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof StubTypeForBuilderInference ? ((StubTypeForBuilderInference) it).getOriginalTypeVariable() : it;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderTypeProjection(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder $this$renderTypeProjection_u24lambda_u240 = new StringBuilder();
        appendTypeProjections($this$renderTypeProjection_u24lambda_u240, CollectionsKt.listOf(typeProjection));
        return $this$renderTypeProjection_u24lambda_u240.toString();
    }

    private final void appendTypeProjections(StringBuilder $this$appendTypeProjections, List<? extends TypeProjection> list) {
        CollectionsKt.joinTo(list, $this$appendTypeProjections, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) != 0 ? "" : null, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$4
            private final DescriptorRendererImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence appendTypeProjections$lambda$0;
                appendTypeProjections$lambda$0 = DescriptorRendererImpl.appendTypeProjections$lambda$0(this.arg$0, (TypeProjection) obj);
                return appendTypeProjections$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendTypeProjections$lambda$0(DescriptorRendererImpl this$0, TypeProjection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isStarProjection()) {
            return Marker.ANY_MARKER;
        }
        KotlinType type = it.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        String type2 = this$0.renderType(type);
        if (it.getProjectionKind() != Variance.INVARIANT) {
            type2 = it.getProjectionKind() + ' ' + type2;
        }
        return type2;
    }

    private final void renderFunctionType(StringBuilder $this$renderFunctionType, KotlinType type) {
        boolean hasAnnotations;
        KotlinType receiverType;
        Name name;
        List contextReceiversTypes;
        int lengthBefore = $this$renderFunctionType.length();
        DescriptorRendererImpl $this$renderFunctionType_u24lambda_u240 = getFunctionTypeAnnotationsRenderer();
        renderAnnotations$default($this$renderFunctionType_u24lambda_u240, $this$renderFunctionType, type, null, 2, null);
        int i = 1;
        boolean hasAnnotations2 = $this$renderFunctionType.length() != lengthBefore;
        KotlinType receiverType2 = FunctionTypesKt.getReceiverTypeFromFunctionType(type);
        List contextReceiversTypes2 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(type);
        boolean isSuspend = FunctionTypesKt.isSuspendFunctionType(type);
        boolean isNullable = type.isMarkedNullable();
        boolean needParenthesis = isNullable || (hasAnnotations2 && receiverType2 != null);
        if (needParenthesis) {
            if (isSuspend) {
                $this$renderFunctionType.insert(lengthBefore, '(');
            } else {
                if (hasAnnotations2) {
                    if (!CharsKt.isWhitespace(StringsKt.last($this$renderFunctionType))) {
                        throw new AssertionError("Assertion failed");
                    }
                    if ($this$renderFunctionType.charAt(StringsKt.getLastIndex($this$renderFunctionType) - 1) != ')') {
                        $this$renderFunctionType.insert(StringsKt.getLastIndex($this$renderFunctionType), "()");
                    }
                }
                $this$renderFunctionType.append("(");
            }
        }
        renderModifier($this$renderFunctionType, isSuspend, "suspend");
        if (!contextReceiversTypes2.isEmpty()) {
            $this$renderFunctionType.append("context(");
            List withoutLast = contextReceiversTypes2.subList(0, CollectionsKt.getLastIndex(contextReceiversTypes2));
            for (KotlinType contextReceiverType : withoutLast) {
                renderNormalizedType($this$renderFunctionType, contextReceiverType);
                $this$renderFunctionType.append(", ");
            }
            renderNormalizedType($this$renderFunctionType, (KotlinType) CollectionsKt.last((List<? extends Object>) contextReceiversTypes2));
            $this$renderFunctionType.append(") ");
        }
        if (receiverType2 != null) {
            boolean surroundReceiver = (shouldRenderAsPrettyFunctionType(receiverType2) && !receiverType2.isMarkedNullable()) || hasModifiersOrAnnotations(receiverType2) || (receiverType2 instanceof DefinitelyNotNullType);
            if (surroundReceiver) {
                $this$renderFunctionType.append("(");
            }
            renderNormalizedType($this$renderFunctionType, receiverType2);
            if (surroundReceiver) {
                $this$renderFunctionType.append(")");
            }
            $this$renderFunctionType.append(".");
        }
        $this$renderFunctionType.append("(");
        if (FunctionTypesKt.isBuiltinExtensionFunctionalType(type) && type.getArguments().size() <= 1) {
            $this$renderFunctionType.append("???");
        } else {
            List<TypeProjection> parameterTypes = FunctionTypesKt.getValueParameterTypesFromFunctionType(type);
            int i2 = 0;
            for (TypeProjection typeProjection : parameterTypes) {
                int index = i2;
                i2 += i;
                if (index > 0) {
                    $this$renderFunctionType.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    hasAnnotations = hasAnnotations2;
                    KotlinType type2 = typeProjection.getType();
                    receiverType = receiverType2;
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    name = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2);
                } else {
                    hasAnnotations = hasAnnotations2;
                    receiverType = receiverType2;
                    name = null;
                }
                if (name == null) {
                    contextReceiversTypes = contextReceiversTypes2;
                } else {
                    contextReceiversTypes = contextReceiversTypes2;
                    $this$renderFunctionType.append(renderName(name, false));
                    $this$renderFunctionType.append(": ");
                }
                $this$renderFunctionType.append(renderTypeProjection(typeProjection));
                contextReceiversTypes2 = contextReceiversTypes;
                hasAnnotations2 = hasAnnotations;
                receiverType2 = receiverType;
                i = 1;
            }
        }
        $this$renderFunctionType.append(") ").append(arrow()).append(" ");
        renderNormalizedType($this$renderFunctionType, FunctionTypesKt.getReturnTypeFromFunctionType(type));
        if (needParenthesis) {
            $this$renderFunctionType.append(")");
        }
        if (isNullable) {
            $this$renderFunctionType.append("?");
        }
    }

    private final boolean hasModifiersOrAnnotations(KotlinType $this$hasModifiersOrAnnotations) {
        return FunctionTypesKt.isSuspendFunctionType($this$hasModifiersOrAnnotations) || !$this$hasModifiersOrAnnotations.getAnnotations().isEmpty();
    }

    private final void appendDefinedIn(StringBuilder $this$appendDefinedIn, DeclarationDescriptor descriptor) {
        DeclarationDescriptor containingDeclaration;
        String sourceFileName;
        if (!(descriptor instanceof PackageFragmentDescriptor) && !(descriptor instanceof PackageViewDescriptor) && (containingDeclaration = descriptor.getContainingDeclaration()) != null && !(containingDeclaration instanceof ModuleDescriptor)) {
            $this$appendDefinedIn.append(" ").append(renderMessage("defined in")).append(" ");
            FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(...)");
            $this$appendDefinedIn.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
            if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (descriptor instanceof DeclarationDescriptorWithSource) && (sourceFileName = ((DeclarationDescriptorWithSource) descriptor).getSource().getContainingFile().getName()) != null) {
                $this$appendDefinedIn.append(" ").append(renderMessage("in file")).append(" ").append(sourceFileName);
            }
        }
    }

    static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.renderAnnotations(sb, annotated, annotationUseSiteTarget);
    }

    private final void renderAnnotations(StringBuilder $this$renderAnnotations, Annotated annotated, AnnotationUseSiteTarget target) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<FqName> excludedTypeAnnotationClasses = annotated instanceof KotlinType ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1 annotationFilter = getAnnotationFilter();
            for (AnnotationDescriptor annotation : annotated.getAnnotations()) {
                if (!CollectionsKt.contains(excludedTypeAnnotationClasses, annotation.getFqName()) && !isParameterName(annotation) && (annotationFilter == null || annotationFilter.invoke(annotation).booleanValue())) {
                    $this$renderAnnotations.append(renderAnnotation(annotation, target));
                    if (getEachAnnotationOnNewLine()) {
                        $this$renderAnnotations.append('\n');
                    } else {
                        $this$renderAnnotations.append(" ");
                    }
                }
            }
        }
    }

    private final boolean isParameterName(AnnotationDescriptor $this$isParameterName) {
        return Intrinsics.areEqual($this$isParameterName.getFqName(), StandardNames.FqNames.parameterName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String renderAnnotation(AnnotationDescriptor annotation, AnnotationUseSiteTarget target) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        StringBuilder $this$renderAnnotation_u24lambda_u240 = new StringBuilder();
        $this$renderAnnotation_u24lambda_u240.append('@');
        if (target != null) {
            $this$renderAnnotation_u24lambda_u240.append(target.getRenderName() + AbstractJsonLexerKt.COLON);
        }
        KotlinType annotationType = annotation.getType();
        $this$renderAnnotation_u24lambda_u240.append(renderType(annotationType));
        if (getIncludeAnnotationArguments()) {
            List arguments = renderAndSortAnnotationArguments(annotation);
            if (getIncludeEmptyAnnotationArguments() || !arguments.isEmpty()) {
                CollectionsKt.joinTo(arguments, $this$renderAnnotation_u24lambda_u240, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) != 0 ? "" : ")", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
            }
        }
        if (getVerbose() && (KotlinTypeKt.isError(annotationType) || (annotationType.getConstructor().mo1171getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor))) {
            $this$renderAnnotation_u24lambda_u240.append(" /* annotation class not found */");
        }
        return $this$renderAnnotation_u24lambda_u240.toString();
    }

    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor descriptor) {
        ClassConstructorDescriptor mo1161getUnsubstitutedPrimaryConstructor;
        Iterable valueParameters;
        Map allValueArguments = descriptor.getAllValueArguments();
        List parameterDescriptorsWithDefaultValue = null;
        ClassDescriptor classDescriptor = getRenderDefaultAnnotationArguments() ? DescriptorUtilsKt.getAnnotationClass(descriptor) : null;
        if (classDescriptor != null && (mo1161getUnsubstitutedPrimaryConstructor = classDescriptor.mo1161getUnsubstitutedPrimaryConstructor()) != null && (valueParameters = mo1161getUnsubstitutedPrimaryConstructor.getValueParameters()) != null) {
            Iterable $this$filter$iv = valueParameters;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                ValueParameterDescriptor it = (ValueParameterDescriptor) element$iv$iv;
                if (it.declaresDefaultValue()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ValueParameterDescriptor it2 = (ValueParameterDescriptor) item$iv$iv;
                destination$iv$iv2.add(it2.getName());
            }
            parameterDescriptorsWithDefaultValue = (List) destination$iv$iv2;
        }
        if (parameterDescriptorsWithDefaultValue == null) {
            parameterDescriptorsWithDefaultValue = CollectionsKt.emptyList();
        }
        List $this$filter$iv2 = parameterDescriptorsWithDefaultValue;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            Name it3 = (Name) element$iv$iv2;
            if (!allValueArguments.containsKey(it3)) {
                destination$iv$iv3.add(element$iv$iv2);
            }
        }
        Iterable $this$map$iv2 = (List) destination$iv$iv3;
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Name it4 = (Name) item$iv$iv2;
            destination$iv$iv4.add(it4.asString() + " = ...");
        }
        List defaultList = (List) destination$iv$iv4;
        Iterable $this$map$iv3 = allValueArguments.entrySet();
        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            Map.Entry entry = (Map.Entry) item$iv$iv3;
            Name name = (Name) entry.getKey();
            ConstantValue value = (ConstantValue) entry.getValue();
            destination$iv$iv5.add(name.asString() + " = " + (!parameterDescriptorsWithDefaultValue.contains(name) ? renderConstant(value) : "..."));
            allValueArguments = allValueArguments;
        }
        List argumentList = (List) destination$iv$iv5;
        return CollectionsKt.sorted(CollectionsKt.plus((Collection) defaultList, (Iterable) argumentList));
    }

    private final String renderConstant(ConstantValue<?> constantValue) {
        Function1 it = this.options.getPropertyConstantRenderer();
        if (it != null) {
            return it.invoke(constantValue);
        }
        if (constantValue instanceof ArrayValue) {
            Iterable $this$mapNotNull$iv = ((ArrayValue) constantValue).getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                String renderConstant = renderConstant((ConstantValue) element$iv$iv$iv);
                if (renderConstant != null) {
                    destination$iv$iv.add(renderConstant);
                }
            }
            return CollectionsKt.joinToString$default((List) destination$iv$iv, ", ", "{", "}", 0, null, null, 56, null);
        } else if (constantValue instanceof AnnotationValue) {
            return StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, ((AnnotationValue) constantValue).getValue(), null, 2, null), (CharSequence) "@");
        } else {
            if (constantValue instanceof KClassValue) {
                KClassValue.Value classValue = ((KClassValue) constantValue).getValue();
                if (classValue instanceof KClassValue.Value.LocalClass) {
                    return ((KClassValue.Value.LocalClass) classValue).getType() + "::class";
                }
                if (classValue instanceof KClassValue.Value.NormalClass) {
                    String asString = ((KClassValue.Value.NormalClass) classValue).getClassId().asSingleFqName().asString();
                    for (int i = 0; i < ((KClassValue.Value.NormalClass) classValue).getArrayDimensions(); i++) {
                        asString = "kotlin.Array<" + asString + Typography.greater;
                    }
                    return asString + "::class";
                }
                throw new NoWhenBranchMatchedException();
            }
            return constantValue.toString();
        }
    }

    private final boolean renderVisibility(DescriptorVisibility visibility, StringBuilder builder) {
        DescriptorVisibility visibility2 = visibility;
        if (getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            if (getNormalizedVisibilities()) {
                visibility2 = visibility2.normalize();
            }
            if (getRenderDefaultVisibility() || !Intrinsics.areEqual(visibility2, DescriptorVisibilities.DEFAULT_VISIBILITY)) {
                builder.append(renderKeyword(visibility2.getInternalDisplayName())).append(" ");
                return true;
            }
            return false;
        }
        return false;
    }

    private final void renderModality(Modality modality, StringBuilder builder, Modality defaultModality) {
        if (getRenderDefaultModality() || modality != defaultModality) {
            renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(modality.name()));
        }
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor $this$implicitModalityWithoutExtensions) {
        if ($this$implicitModalityWithoutExtensions instanceof ClassDescriptor) {
            return ((ClassDescriptor) $this$implicitModalityWithoutExtensions).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = $this$implicitModalityWithoutExtensions.getContainingDeclaration();
        ClassDescriptor containingClassDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (containingClassDescriptor != null && ($this$implicitModalityWithoutExtensions instanceof CallableMemberDescriptor)) {
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = ((CallableMemberDescriptor) $this$implicitModalityWithoutExtensions).getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            if (overriddenDescriptors.isEmpty() || containingClassDescriptor.getModality() == Modality.FINAL) {
                if (containingClassDescriptor.getKind() != ClassKind.INTERFACE || Intrinsics.areEqual(((CallableMemberDescriptor) $this$implicitModalityWithoutExtensions).getVisibility(), DescriptorVisibilities.PRIVATE)) {
                    return Modality.FINAL;
                }
                return ((CallableMemberDescriptor) $this$implicitModalityWithoutExtensions).getModality() == Modality.ABSTRACT ? Modality.ABSTRACT : Modality.OPEN;
            }
            return Modality.OPEN;
        }
        return Modality.FINAL;
    }

    private final void renderModalityForCallable(CallableMemberDescriptor callable, StringBuilder builder) {
        if (!DescriptorUtils.isTopLevelDeclaration(callable) || callable.getModality() != Modality.FINAL) {
            if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE && callable.getModality() == Modality.OPEN && overridesSomething(callable)) {
                return;
            }
            Modality modality = callable.getModality();
            Intrinsics.checkNotNullExpressionValue(modality, "getModality(...)");
            renderModality(modality, builder, implicitModalityWithoutExtensions(callable));
        }
    }

    private final void renderOverride(CallableMemberDescriptor callableMember, StringBuilder builder) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && overridesSomething(callableMember) && getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            renderModifier(builder, true, "override");
            if (getVerbose()) {
                builder.append("/*").append(callableMember.getOverriddenDescriptors().size()).append("*/ ");
            }
        }
    }

    private final void renderMemberKind(CallableMemberDescriptor callableMember, StringBuilder builder) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMember.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            builder.append("/*").append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(callableMember.getKind().name())).append("*/ ");
        }
    }

    private final void renderModifier(StringBuilder builder, boolean value, String modifier) {
        if (value) {
            builder.append(renderKeyword(modifier));
            builder.append(" ");
        }
    }

    private final void renderMemberModifiers(MemberDescriptor descriptor, StringBuilder builder) {
        renderModifier(builder, descriptor.isExternal(), "external");
        boolean z = true;
        renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.EXPECT) && descriptor.isExpect(), "expect");
        if (!getModifiers().contains(DescriptorRendererModifier.ACTUAL) || !descriptor.isActual()) {
            z = false;
        }
        renderModifier(builder, z, "actual");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renderAdditionalModifiers(FunctionDescriptor functionDescriptor, StringBuilder builder) {
        boolean isOperator;
        Iterable $this$none$iv;
        Iterable $this$none$iv2;
        boolean z = false;
        if (functionDescriptor.isOperator()) {
            Iterable overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            Iterable $this$none$iv3 = overriddenDescriptors;
            if (!((Collection) $this$none$iv3).isEmpty()) {
                Iterator<T> it = $this$none$iv3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        FunctionDescriptor it2 = (FunctionDescriptor) element$iv;
                        if (it2.isOperator()) {
                            $this$none$iv2 = null;
                            break;
                        }
                    } else {
                        $this$none$iv2 = 1;
                        break;
                    }
                }
            } else {
                $this$none$iv2 = 1;
            }
            if ($this$none$iv2 != null || getAlwaysRenderModifiers()) {
                isOperator = true;
                if (functionDescriptor.isInfix()) {
                    Iterable overriddenDescriptors2 = functionDescriptor.getOverriddenDescriptors();
                    Intrinsics.checkNotNullExpressionValue(overriddenDescriptors2, "getOverriddenDescriptors(...)");
                    Iterable $this$none$iv4 = overriddenDescriptors2;
                    if (!((Collection) $this$none$iv4).isEmpty()) {
                        Iterator<T> it3 = $this$none$iv4.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                Object element$iv2 = it3.next();
                                FunctionDescriptor it4 = (FunctionDescriptor) element$iv2;
                                if (it4.isInfix()) {
                                    $this$none$iv = null;
                                    break;
                                }
                            } else {
                                $this$none$iv = 1;
                                break;
                            }
                        }
                    } else {
                        $this$none$iv = 1;
                    }
                    if ($this$none$iv != null || getAlwaysRenderModifiers()) {
                        z = true;
                    }
                }
                boolean isInfix = z;
                renderModifier(builder, functionDescriptor.isTailrec(), "tailrec");
                renderSuspendModifier(functionDescriptor, builder);
                renderModifier(builder, functionDescriptor.isInline(), "inline");
                renderModifier(builder, isInfix, "infix");
                renderModifier(builder, isOperator, "operator");
            }
        }
        isOperator = false;
        if (functionDescriptor.isInfix()) {
        }
        boolean isInfix2 = z;
        renderModifier(builder, functionDescriptor.isTailrec(), "tailrec");
        renderSuspendModifier(functionDescriptor, builder);
        renderModifier(builder, functionDescriptor.isInline(), "inline");
        renderModifier(builder, isInfix2, "infix");
        renderModifier(builder, isOperator, "operator");
    }

    private final void renderSuspendModifier(FunctionDescriptor functionDescriptor, StringBuilder builder) {
        renderModifier(builder, functionDescriptor.isSuspend(), "suspend");
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public String render(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder $this$render_u24lambda_u240 = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(), $this$render_u24lambda_u240);
        if (getWithDefinedIn()) {
            appendDefinedIn($this$render_u24lambda_u240, declarationDescriptor);
        }
        return $this$render_u24lambda_u240.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeParameter(TypeParameterDescriptor typeParameter, StringBuilder builder, boolean topLevel) {
        if (topLevel) {
            builder.append(lt());
        }
        if (getVerbose()) {
            builder.append("/*").append(typeParameter.getIndex()).append("*/ ");
        }
        renderModifier(builder, typeParameter.isReified(), "reified");
        String variance = typeParameter.getVariance().getLabel();
        renderModifier(builder, variance.length() > 0, variance);
        renderAnnotations$default(this, builder, typeParameter, null, 2, null);
        renderName(typeParameter, builder, topLevel);
        int upperBoundsCount = typeParameter.getUpperBounds().size();
        if ((upperBoundsCount > 1 && !topLevel) || upperBoundsCount == 1) {
            KotlinType upperBound = typeParameter.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(upperBound)) {
                StringBuilder append = builder.append(" : ");
                Intrinsics.checkNotNull(upperBound);
                append.append(renderType(upperBound));
            }
        } else if (topLevel) {
            boolean first = true;
            for (KotlinType upperBound2 : typeParameter.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(upperBound2)) {
                    if (first) {
                        builder.append(" : ");
                    } else {
                        builder.append(" & ");
                    }
                    Intrinsics.checkNotNull(upperBound2);
                    builder.append(renderType(upperBound2));
                    first = false;
                }
            }
        }
        if (topLevel) {
            builder.append(gt());
        }
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> list, StringBuilder builder, boolean withSpace) {
        if (!getWithoutTypeParameters() && !list.isEmpty()) {
            builder.append(lt());
            renderTypeParameterList(builder, list);
            builder.append(gt());
            if (withSpace) {
                builder.append(" ");
            }
        }
    }

    private final void renderTypeParameterList(StringBuilder builder, List<? extends TypeParameterDescriptor> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptor = iterator.next();
            renderTypeParameter(typeParameterDescriptor, builder, false);
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderFunction(FunctionDescriptor function, StringBuilder builder) {
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                List<ReceiverParameterDescriptor> contextReceiverParameters = function.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
                renderContextReceivers(contextReceiverParameters, builder);
                renderAnnotations$default(this, builder, function, null, 2, null);
                DescriptorVisibility visibility = function.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, builder);
                renderModalityForCallable(function, builder);
                if (getIncludeAdditionalModifiers()) {
                    renderMemberModifiers(function, builder);
                }
                renderOverride(function, builder);
                if (getIncludeAdditionalModifiers()) {
                    renderAdditionalModifiers(function, builder);
                } else {
                    renderSuspendModifier(function, builder);
                }
                renderMemberKind(function, builder);
                if (getVerbose()) {
                    if (function.isHiddenToOvercomeSignatureClash()) {
                        builder.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (function.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        builder.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            builder.append(renderKeyword("fun")).append(" ");
            List<TypeParameterDescriptor> typeParameters = function.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            renderTypeParameters(typeParameters, builder, true);
            renderReceiver(function, builder);
        }
        renderName(function, builder, true);
        List<ValueParameterDescriptor> valueParameters = function.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        renderValueParameters(valueParameters, function.hasSynthesizedParameterNames(), builder);
        renderReceiverAfterName(function, builder);
        KotlinType returnType = function.getReturnType();
        if (!getWithoutReturnType() && (getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            builder.append(": ").append(returnType == null ? "[NULL]" : renderType(returnType));
        }
        List<TypeParameterDescriptor> typeParameters2 = function.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
        renderWhereSuffix(typeParameters2, builder);
    }

    private final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder builder) {
        ReceiverParameterDescriptor receiver;
        if (getReceiverAfterName() && (receiver = callableDescriptor.getExtensionReceiverParameter()) != null) {
            StringBuilder append = builder.append(" on ");
            KotlinType type = receiver.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            append.append(renderType(type));
        }
    }

    private final String renderForReceiver(KotlinType $this$renderForReceiver) {
        String result = renderType($this$renderForReceiver);
        if ((shouldRenderAsPrettyFunctionType($this$renderForReceiver) && !TypeUtils.isNullableType($this$renderForReceiver)) || ($this$renderForReceiver instanceof DefinitelyNotNullType)) {
            return '(' + result + ')';
        }
        return result;
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> list, StringBuilder builder) {
        if (!list.isEmpty()) {
            builder.append("context(");
            int i = 0;
            for (ReceiverParameterDescriptor contextReceiver : list) {
                int i2 = i;
                i++;
                renderAnnotations(builder, contextReceiver, AnnotationUseSiteTarget.RECEIVER);
                KotlinType type = contextReceiver.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                String typeString = renderForReceiver(type);
                builder.append(typeString);
                if (i2 == CollectionsKt.getLastIndex(list)) {
                    builder.append(") ");
                } else {
                    builder.append(", ");
                }
            }
        }
    }

    private final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder builder) {
        ReceiverParameterDescriptor receiver = callableDescriptor.getExtensionReceiverParameter();
        if (receiver != null) {
            renderAnnotations(builder, receiver, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = receiver.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            String typeString = renderForReceiver(type);
            builder.append(typeString).append(".");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderConstructor(ConstructorDescriptor constructor, StringBuilder builder) {
        boolean visibilityRendered;
        boolean constructorKeywordRendered;
        ClassConstructorDescriptor primaryConstructor;
        List parametersWithoutDefault;
        renderAnnotations$default(this, builder, constructor, null, 2, null);
        if (this.options.getRenderDefaultVisibility() || constructor.getConstructedClass().getModality() != Modality.SEALED) {
            DescriptorVisibility visibility = constructor.getVisibility();
            Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
            if (renderVisibility(visibility, builder)) {
                visibilityRendered = true;
                renderMemberKind(constructor, builder);
                constructorKeywordRendered = (getRenderConstructorKeyword() && constructor.isPrimary() && !visibilityRendered) ? false : true;
                if (constructorKeywordRendered) {
                    builder.append(renderKeyword("constructor"));
                }
                ClassifierDescriptorWithTypeParameters classDescriptor = constructor.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(classDescriptor, "getContainingDeclaration(...)");
                if (getSecondaryConstructorsAsPrimary()) {
                    if (constructorKeywordRendered) {
                        builder.append(" ");
                    }
                    renderName(classDescriptor, builder, true);
                    List<TypeParameterDescriptor> typeParameters = constructor.getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
                    renderTypeParameters(typeParameters, builder, false);
                }
                List<ValueParameterDescriptor> valueParameters = constructor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                renderValueParameters(valueParameters, constructor.hasSynthesizedParameterNames(), builder);
                if (getRenderConstructorDelegation() && !constructor.isPrimary() && (classDescriptor instanceof ClassDescriptor) && (primaryConstructor = ((ClassDescriptor) classDescriptor).mo1161getUnsubstitutedPrimaryConstructor()) != null) {
                    Iterable valueParameters2 = primaryConstructor.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                    Iterable $this$filter$iv = valueParameters2;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        ValueParameterDescriptor it = (ValueParameterDescriptor) element$iv$iv;
                        if (((it.declaresDefaultValue() || it.getVarargElementType() != null) ? null : 1) != null) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    parametersWithoutDefault = (List) destination$iv$iv;
                    if (!parametersWithoutDefault.isEmpty()) {
                        builder.append(" : ").append(renderKeyword("this"));
                        builder.append(CollectionsKt.joinToString$default(parametersWithoutDefault, ", ", "(", ")", 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$5
                            @Override // kotlin.jvm.functions.Function1
                            public Object invoke(Object obj) {
                                CharSequence renderConstructor$lambda$1;
                                renderConstructor$lambda$1 = DescriptorRendererImpl.renderConstructor$lambda$1((ValueParameterDescriptor) obj);
                                return renderConstructor$lambda$1;
                            }
                        }, 24, null));
                    }
                }
                if (!getSecondaryConstructorsAsPrimary()) {
                    List<TypeParameterDescriptor> typeParameters2 = constructor.getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
                    renderWhereSuffix(typeParameters2, builder);
                    return;
                }
                return;
            }
        }
        visibilityRendered = false;
        renderMemberKind(constructor, builder);
        if (getRenderConstructorKeyword()) {
        }
        if (constructorKeywordRendered) {
        }
        ClassifierDescriptorWithTypeParameters classDescriptor2 = constructor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(classDescriptor2, "getContainingDeclaration(...)");
        if (getSecondaryConstructorsAsPrimary()) {
        }
        List<ValueParameterDescriptor> valueParameters3 = constructor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters3, "getValueParameters(...)");
        renderValueParameters(valueParameters3, constructor.hasSynthesizedParameterNames(), builder);
        if (getRenderConstructorDelegation()) {
            Iterable valueParameters22 = primaryConstructor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters22, "getValueParameters(...)");
            Iterable $this$filter$iv2 = valueParameters22;
            Collection destination$iv$iv2 = new ArrayList();
            while (r14.hasNext()) {
            }
            parametersWithoutDefault = (List) destination$iv$iv2;
            if (!parametersWithoutDefault.isEmpty()) {
            }
        }
        if (!getSecondaryConstructorsAsPrimary()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderConstructor$lambda$1(ValueParameterDescriptor it) {
        return "";
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> list, StringBuilder builder) {
        if (getWithoutTypeParameters()) {
            return;
        }
        Collection upperBoundStrings = new ArrayList(0);
        for (TypeParameterDescriptor typeParameter : list) {
            List<KotlinType> upperBounds = typeParameter.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            Iterable $this$mapTo$iv = CollectionsKt.drop(upperBounds, 1);
            Collection destination$iv = upperBoundStrings;
            for (Object item$iv : $this$mapTo$iv) {
                KotlinType it = (KotlinType) item$iv;
                StringBuilder sb = new StringBuilder();
                Name name = typeParameter.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                StringBuilder append = sb.append(renderName(name, false)).append(" : ");
                Intrinsics.checkNotNull(it);
                destination$iv.add(append.append(renderType(it)).toString());
            }
        }
        if (!upperBoundStrings.isEmpty()) {
            builder.append(" ").append(renderKeyword("where")).append(" ");
            CollectionsKt.joinTo(upperBoundStrings, builder, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) != 0 ? "" : null, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        }
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> collection, boolean synthesizedParameterNames, StringBuilder builder) {
        boolean includeNames = shouldRenderParameterNames(synthesizedParameterNames);
        int parameterCount = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(parameterCount, builder);
        int i = 0;
        for (ValueParameterDescriptor parameter : collection) {
            int index = i;
            i++;
            getValueParametersHandler().appendBeforeValueParameter(parameter, index, parameterCount, builder);
            renderValueParameter(parameter, includeNames, builder, false);
            getValueParametersHandler().appendAfterValueParameter(parameter, index, parameterCount, builder);
        }
        getValueParametersHandler().appendAfterValueParameters(parameterCount, builder);
    }

    private final boolean shouldRenderParameterNames(boolean synthesizedParameterNames) {
        switch (WhenMappings.$EnumSwitchMapping$1[getParameterNameRenderingPolicy().ordinal()]) {
            case 1:
                return true;
            case 2:
                return !synthesizedParameterNames;
            case 3:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
        if ((getDebugMode() ? r10.declaresDefaultValue() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10)) != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderValueParameter(ValueParameterDescriptor valueParameter, boolean includeName, StringBuilder builder, boolean topLevel) {
        boolean isPrimaryConstructor;
        if (topLevel) {
            builder.append(renderKeyword("value-parameter")).append(" ");
        }
        if (getVerbose()) {
            builder.append("/*").append(valueParameter.getIndex()).append("*/ ");
        }
        renderAnnotations$default(this, builder, valueParameter, null, 2, null);
        renderModifier(builder, valueParameter.isCrossinline(), "crossinline");
        renderModifier(builder, valueParameter.isNoinline(), "noinline");
        boolean withDefaultValue = true;
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            CallableDescriptor containingDeclaration = valueParameter.getContainingDeclaration();
            ClassConstructorDescriptor classConstructorDescriptor = containingDeclaration instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) containingDeclaration : null;
            if (classConstructorDescriptor != null && classConstructorDescriptor.isPrimary()) {
                isPrimaryConstructor = true;
                if (isPrimaryConstructor) {
                    renderModifier(builder, getActualPropertiesInPrimaryConstructor(), "actual");
                }
                renderVariable(valueParameter, includeName, builder, topLevel, isPrimaryConstructor);
                if (getDefaultParameterValueRenderer() != null) {
                }
                withDefaultValue = false;
                if (!withDefaultValue) {
                    StringBuilder append = new StringBuilder().append(" = ");
                    Function1<ValueParameterDescriptor, String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
                    Intrinsics.checkNotNull(defaultParameterValueRenderer);
                    builder.append(append.append(defaultParameterValueRenderer.invoke(valueParameter)).toString());
                    return;
                }
                return;
            }
        }
        isPrimaryConstructor = false;
        if (isPrimaryConstructor) {
        }
        renderVariable(valueParameter, includeName, builder, topLevel, isPrimaryConstructor);
        if (getDefaultParameterValueRenderer() != null) {
        }
        withDefaultValue = false;
        if (!withDefaultValue) {
        }
    }

    static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.renderValVarPrefix(variableDescriptor, sb, z);
    }

    private final void renderValVarPrefix(VariableDescriptor variable, StringBuilder builder, boolean isInPrimaryConstructor) {
        if (isInPrimaryConstructor || !(variable instanceof ValueParameterDescriptor)) {
            builder.append(renderKeyword(variable.isVar() ? "var" : "val")).append(" ");
        }
    }

    private final void renderVariable(VariableDescriptor variable, boolean includeName, StringBuilder builder, boolean topLevel, boolean isInPrimaryConstructor) {
        KotlinType realType = variable.getType();
        Intrinsics.checkNotNullExpressionValue(realType, "getType(...)");
        ValueParameterDescriptor valueParameterDescriptor = variable instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) variable : null;
        KotlinType varargElementType = valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null;
        KotlinType typeToRender = varargElementType == null ? realType : varargElementType;
        renderModifier(builder, varargElementType != null, "vararg");
        if (isInPrimaryConstructor || (topLevel && !getStartFromName())) {
            renderValVarPrefix(variable, builder, isInPrimaryConstructor);
        }
        if (includeName) {
            renderName(variable, builder, topLevel);
            builder.append(": ");
        }
        builder.append(renderType(typeToRender));
        renderInitializer(variable, builder);
        if (getVerbose() && varargElementType != null) {
            builder.append(" /*").append(renderType(realType)).append("*/");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderProperty(PropertyDescriptor property, StringBuilder builder) {
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                List<ReceiverParameterDescriptor> contextReceiverParameters = property.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
                renderContextReceivers(contextReceiverParameters, builder);
                renderPropertyAnnotations(property, builder);
                DescriptorVisibility visibility = property.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, builder);
                boolean z = false;
                renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.CONST) && property.isConst(), "const");
                renderMemberModifiers(property, builder);
                renderModalityForCallable(property, builder);
                renderOverride(property, builder);
                if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) && property.isLateInit()) {
                    z = true;
                }
                renderModifier(builder, z, "lateinit");
                renderMemberKind(property, builder);
            }
            renderValVarPrefix$default(this, property, builder, false, 4, null);
            List<TypeParameterDescriptor> typeParameters = property.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            renderTypeParameters(typeParameters, builder, true);
            renderReceiver(property, builder);
        }
        renderName(property, builder, true);
        StringBuilder append = builder.append(": ");
        KotlinType type = property.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        append.append(renderType(type));
        renderReceiverAfterName(property, builder);
        renderInitializer(property, builder);
        List<TypeParameterDescriptor> typeParameters2 = property.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
        renderWhereSuffix(typeParameters2, builder);
    }

    private final void renderPropertyAnnotations(PropertyDescriptor property, StringBuilder builder) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            renderAnnotations$default(this, builder, property, null, 2, null);
            FieldDescriptor it = property.getBackingField();
            if (it != null) {
                renderAnnotations(builder, it, AnnotationUseSiteTarget.FIELD);
            }
            FieldDescriptor it2 = property.getDelegateField();
            if (it2 != null) {
                renderAnnotations(builder, it2, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE) {
                PropertyGetterDescriptor it3 = property.getGetter();
                if (it3 != null) {
                    renderAnnotations(builder, it3, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                PropertySetterDescriptor setter = property.getSetter();
                if (setter != null) {
                    renderAnnotations(builder, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                    List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                    ValueParameterDescriptor it4 = (ValueParameterDescriptor) CollectionsKt.single((List<? extends Object>) valueParameters);
                    Intrinsics.checkNotNull(it4);
                    renderAnnotations(builder, it4, AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void renderInitializer(VariableDescriptor variable, StringBuilder builder) {
        ConstantValue constant;
        String renderedConstant;
        if (!getIncludePropertyConstant() || (constant = variable.mo1163getCompileTimeInitializer()) == null || (renderedConstant = renderConstant(constant)) == null) {
            return;
        }
        builder.append(" = ").append(escape(renderedConstant));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeAlias(TypeAliasDescriptor typeAlias, StringBuilder builder) {
        renderAnnotations$default(this, builder, typeAlias, null, 2, null);
        DescriptorVisibility visibility = typeAlias.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        renderVisibility(visibility, builder);
        renderMemberModifiers(typeAlias, builder);
        builder.append(renderKeyword("typealias")).append(" ");
        renderName(typeAlias, builder, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAlias.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        renderTypeParameters(declaredTypeParameters, builder, false);
        renderCapturedTypeParametersIfRequired(typeAlias, builder);
        builder.append(" = ").append(renderType(typeAlias.getUnderlyingType()));
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifier, StringBuilder builder) {
        List typeParameters = classifier.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getDeclaredTypeParameters(...)");
        List typeConstructorParameters = classifier.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(typeConstructorParameters, "getParameters(...)");
        if (getVerbose() && classifier.isInner() && typeConstructorParameters.size() > typeParameters.size()) {
            builder.append(" /*captured type parameters: ");
            renderTypeParameterList(builder, typeConstructorParameters.subList(typeParameters.size(), typeConstructorParameters.size()));
            builder.append("*/");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderClass(ClassDescriptor klass, StringBuilder builder) {
        ClassConstructorDescriptor primaryConstructor;
        boolean isEnumEntry = klass.getKind() == ClassKind.ENUM_ENTRY;
        if (!getStartFromName()) {
            List<ReceiverParameterDescriptor> contextReceivers = klass.getContextReceivers();
            Intrinsics.checkNotNullExpressionValue(contextReceivers, "getContextReceivers(...)");
            renderContextReceivers(contextReceivers, builder);
            renderAnnotations$default(this, builder, klass, null, 2, null);
            if (!isEnumEntry) {
                DescriptorVisibility visibility = klass.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, builder);
            }
            if ((klass.getKind() != ClassKind.INTERFACE || klass.getModality() != Modality.ABSTRACT) && (!klass.getKind().isSingleton() || klass.getModality() != Modality.FINAL)) {
                Modality modality = klass.getModality();
                Intrinsics.checkNotNullExpressionValue(modality, "getModality(...)");
                renderModality(modality, builder, implicitModalityWithoutExtensions(klass));
            }
            renderMemberModifiers(klass, builder);
            renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.INNER) && klass.isInner(), "inner");
            renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.DATA) && klass.isData(), "data");
            renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.INLINE) && klass.isInline(), "inline");
            renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.VALUE) && klass.isValue(), "value");
            renderModifier(builder, getModifiers().contains(DescriptorRendererModifier.FUN) && klass.isFun(), "fun");
            renderClassKindPrefix(klass, builder);
        }
        if (!DescriptorUtils.isCompanionObject(klass)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(builder);
            }
            renderName(klass, builder, true);
        } else {
            renderCompanionObjectName(klass, builder);
        }
        if (isEnumEntry) {
            return;
        }
        List typeParameters = klass.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getDeclaredTypeParameters(...)");
        renderTypeParameters(typeParameters, builder, false);
        renderCapturedTypeParametersIfRequired(klass, builder);
        if (!klass.getKind().isSingleton() && getClassWithPrimaryConstructor() && (primaryConstructor = klass.mo1161getUnsubstitutedPrimaryConstructor()) != null) {
            builder.append(" ");
            renderAnnotations$default(this, builder, primaryConstructor, null, 2, null);
            DescriptorVisibility visibility2 = primaryConstructor.getVisibility();
            Intrinsics.checkNotNullExpressionValue(visibility2, "getVisibility(...)");
            renderVisibility(visibility2, builder);
            builder.append(renderKeyword("constructor"));
            List<ValueParameterDescriptor> valueParameters = primaryConstructor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            renderValueParameters(valueParameters, primaryConstructor.hasSynthesizedParameterNames(), builder);
        }
        renderSuperTypes(klass, builder);
        renderWhereSuffix(typeParameters, builder);
    }

    private final void renderSuperTypes(ClassDescriptor klass, StringBuilder builder) {
        if (getWithoutSuperTypes() || KotlinBuiltIns.isNothing(klass.getDefaultType())) {
            return;
        }
        Collection supertypes = klass.getTypeConstructor().mo1172getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "getSupertypes(...)");
        if (supertypes.isEmpty()) {
            return;
        }
        if (supertypes.size() == 1 && KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next())) {
            return;
        }
        renderSpaceIfNeeded(builder);
        builder.append(": ");
        CollectionsKt.joinTo(supertypes, builder, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) != 0 ? "" : null, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$6
            private final DescriptorRendererImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence renderSuperTypes$lambda$0;
                renderSuperTypes$lambda$0 = DescriptorRendererImpl.renderSuperTypes$lambda$0(this.arg$0, (KotlinType) obj);
                return renderSuperTypes$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence renderSuperTypes$lambda$0(DescriptorRendererImpl this$0, KotlinType it) {
        Intrinsics.checkNotNull(it);
        return this$0.renderType(it);
    }

    private final void renderClassKindPrefix(ClassDescriptor klass, StringBuilder builder) {
        builder.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(klass)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageView(PackageViewDescriptor packageView, StringBuilder builder) {
        renderPackageHeader(packageView.getFqName(), "package", builder);
        if (getDebugMode()) {
            builder.append(" in context of ");
            renderName(packageView.getModule(), builder, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageFragment(PackageFragmentDescriptor fragment, StringBuilder builder) {
        renderPackageHeader(fragment.getFqName(), "package-fragment", builder);
        if (getDebugMode()) {
            builder.append(" in ");
            renderName(fragment.getContainingDeclaration(), builder, false);
        }
    }

    private final void renderPackageHeader(FqName fqName, String fragmentOrView, StringBuilder builder) {
        builder.append(renderKeyword(fragmentOrView));
        String fqNameString = renderFqName(fqName.toUnsafe());
        if (fqNameString.length() > 0) {
            builder.append(" ");
            builder.append(fqNameString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderAccessorModifiers(PropertyAccessorDescriptor descriptor, StringBuilder builder) {
        renderMemberModifiers(descriptor, builder);
    }

    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {

        /* compiled from: DescriptorRendererImpl.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                try {
                    iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public RenderDeclarationDescriptorVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor descriptor, StringBuilder sb) {
            visitClassDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            visitConstructorDescriptor2(constructorDescriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor descriptor, StringBuilder sb) {
            visitFunctionDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor descriptor, StringBuilder sb) {
            visitModuleDeclaration2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor descriptor, StringBuilder sb) {
            visitPackageFragmentDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor descriptor, StringBuilder sb) {
            visitPackageViewDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor descriptor, StringBuilder sb) {
            visitPropertyDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor descriptor, StringBuilder sb) {
            visitPropertyGetterDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor descriptor, StringBuilder sb) {
            visitPropertySetterDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor descriptor, StringBuilder sb) {
            visitReceiverParameterDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor descriptor, StringBuilder sb) {
            visitTypeAliasDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor descriptor, StringBuilder sb) {
            visitTypeParameterDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor descriptor, StringBuilder sb) {
            visitValueParameterDescriptor2(descriptor, sb);
            return Unit.INSTANCE;
        }

        /* renamed from: visitValueParameterDescriptor  reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(ValueParameterDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderValueParameter(descriptor, true, builder, true);
        }

        /* renamed from: visitPropertyDescriptor  reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(PropertyDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderProperty(descriptor, builder);
        }

        /* renamed from: visitPropertyGetterDescriptor  reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(PropertyGetterDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            visitPropertyAccessorDescriptor(descriptor, builder, "getter");
        }

        /* renamed from: visitPropertySetterDescriptor  reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(PropertySetterDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            visitPropertyAccessorDescriptor(descriptor, builder, "setter");
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor descriptor, StringBuilder builder, String kind) {
            switch (WhenMappings.$EnumSwitchMapping$0[DescriptorRendererImpl.this.getPropertyAccessorRenderingPolicy().ordinal()]) {
                case 1:
                    DescriptorRendererImpl.this.renderAccessorModifiers(descriptor, builder);
                    builder.append(kind + " for ");
                    DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                    PropertyDescriptor correspondingProperty = descriptor.getCorrespondingProperty();
                    Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
                    descriptorRendererImpl.renderProperty(correspondingProperty, builder);
                    return;
                case 2:
                    visitFunctionDescriptor2((FunctionDescriptor) descriptor, builder);
                    return;
                case 3:
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        /* renamed from: visitFunctionDescriptor  reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(FunctionDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderFunction(descriptor, builder);
        }

        /* renamed from: visitReceiverParameterDescriptor  reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(ReceiverParameterDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            builder.append(descriptor.getName());
        }

        /* renamed from: visitConstructorDescriptor  reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(ConstructorDescriptor constructorDescriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, builder);
        }

        /* renamed from: visitTypeParameterDescriptor  reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(TypeParameterDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderTypeParameter(descriptor, builder, true);
        }

        /* renamed from: visitPackageFragmentDescriptor  reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(PackageFragmentDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderPackageFragment(descriptor, builder);
        }

        /* renamed from: visitPackageViewDescriptor  reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(PackageViewDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderPackageView(descriptor, builder);
        }

        /* renamed from: visitModuleDeclaration  reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(ModuleDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderName(descriptor, builder, true);
        }

        /* renamed from: visitClassDescriptor  reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(ClassDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderClass(descriptor, builder);
        }

        /* renamed from: visitTypeAliasDescriptor  reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(TypeAliasDescriptor descriptor, StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderTypeAlias(descriptor, builder);
        }
    }

    private final void renderSpaceIfNeeded(StringBuilder builder) {
        int length = builder.length();
        if (length == 0 || builder.charAt(length - 1) != ' ') {
            builder.append(' ');
        }
    }

    private final boolean overridesSomething(CallableMemberDescriptor callable) {
        return !callable.getOverriddenDescriptors().isEmpty();
    }
}