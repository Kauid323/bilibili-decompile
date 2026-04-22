package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.BooleanFlagDelegate;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagDelegatesImplKt;
import kotlin.reflect.jvm.internal.impl.km.internal.FlagImpl;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: Nodes.kt */
public final class KmProperty {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(KmProperty.class, "_hasSetter", "get_hasSetter()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KmProperty.class, "_hasGetter", "get_hasGetter()Z", 0))};
    private final BooleanFlagDelegate _hasGetter$delegate;
    private final BooleanFlagDelegate _hasSetter$delegate;
    private final List<KmAnnotation> annotations;
    private final List<KmAnnotation> backingFieldAnnotations;
    private final List<KmValueParameter> contextParameters;
    private final List<KmType> contextReceiverTypes;
    private final List<KmAnnotation> delegateFieldAnnotations;
    private final List<KmAnnotation> extensionReceiverParameterAnnotations;
    private final List<KmPropertyExtension> extensions;
    private int flags;
    private final KmPropertyAccessorAttributes getter;
    private String name;
    private KmType receiverParameterType;
    public KmType returnType;
    private KmPropertyAccessorAttributes setter;
    private KmValueParameter setterParameter;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmProperty(int flags, String name, int getterFlags, int setterFlags) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        Flags.BooleanFlagField HAS_SETTER = Flags.HAS_SETTER;
        Intrinsics.checkNotNullExpressionValue(HAS_SETTER, "HAS_SETTER");
        this._hasSetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_SETTER));
        Flags.BooleanFlagField HAS_GETTER = Flags.HAS_GETTER;
        Intrinsics.checkNotNullExpressionValue(HAS_GETTER, "HAS_GETTER");
        this._hasGetter$delegate = FlagDelegatesImplKt.propertyBooleanFlag(new FlagImpl(HAS_GETTER));
        KmPropertyAccessorAttributes kmPropertyAccessorAttributes = new KmPropertyAccessorAttributes(getterFlags);
        set_hasGetter(true);
        this.getter = kmPropertyAccessorAttributes;
        this.setter = get_hasSetter() ? new KmPropertyAccessorAttributes(setterFlags) : null;
        this.typeParameters = new ArrayList(0);
        this.extensionReceiverParameterAnnotations = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.contextParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        this.annotations = new ArrayList(0);
        this.backingFieldAnnotations = new ArrayList(0);
        this.delegateFieldAnnotations = new ArrayList(0);
        Iterable $this$map$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MetadataExtensions p0 = (MetadataExtensions) item$iv$iv;
            destination$iv$iv.add(p0.createPropertyExtension());
        }
        this.extensions = (List) destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final String getName() {
        return this.name;
    }

    private final boolean get_hasSetter() {
        return this._hasSetter$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void set_hasGetter(boolean z) {
        this._hasGetter$delegate.setValue(this, $$delegatedProperties[1], z);
    }

    public final KmPropertyAccessorAttributes getGetter() {
        return this.getter;
    }

    public final KmPropertyAccessorAttributes getSetter() {
        return this.setter;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final KmType getReceiverParameterType() {
        return this.receiverParameterType;
    }

    public final void setReceiverParameterType(KmType kmType) {
        this.receiverParameterType = kmType;
    }

    public final List<KmAnnotation> getExtensionReceiverParameterAnnotations() {
        return this.extensionReceiverParameterAnnotations;
    }

    public final List<KmValueParameter> getContextParameters() {
        return this.contextParameters;
    }

    public final KmValueParameter getSetterParameter() {
        return this.setterParameter;
    }

    public final void setSetterParameter(KmValueParameter kmValueParameter) {
        this.setterParameter = kmValueParameter;
    }

    public final KmType getReturnType() {
        KmType kmType = this.returnType;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("returnType");
        return null;
    }

    public final void setReturnType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.returnType = kmType;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmAnnotation> getBackingFieldAnnotations() {
        return this.backingFieldAnnotations;
    }

    public final List<KmAnnotation> getDelegateFieldAnnotations() {
        return this.delegateFieldAnnotations;
    }

    public final List<KmPropertyExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}