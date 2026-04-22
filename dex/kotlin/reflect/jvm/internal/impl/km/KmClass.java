package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmClass implements KmDeclarationContainer {
    private String companionObject;
    private final List<KmClassExtension> extensions;
    private int flags;
    private String inlineClassUnderlyingPropertyName;
    private KmType inlineClassUnderlyingType;
    public String name;
    private final List<KmTypeParameter> typeParameters = new ArrayList(0);
    private final List<KmType> supertypes = new ArrayList(1);
    private final List<KmFunction> functions = new ArrayList();
    private final List<KmProperty> properties = new ArrayList();
    private final List<KmTypeAlias> typeAliases = new ArrayList(0);
    private final List<KmConstructor> constructors = new ArrayList(1);
    private final List<String> nestedClasses = new ArrayList(0);
    private final List<String> enumEntries = new ArrayList(0);
    private final List<KmEnumEntry> kmEnumEntries = new ArrayList(0);
    private final List<String> sealedSubclasses = new ArrayList(0);
    private final List<KmAnnotation> annotations = new ArrayList(0);
    private final List<KmType> contextReceiverTypes = new ArrayList(0);
    private final List<KmVersionRequirement> versionRequirements = new ArrayList(0);

    public KmClass() {
        Iterable $this$map$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MetadataExtensions p0 = (MetadataExtensions) item$iv$iv;
            destination$iv$iv.add(p0.createClassExtension());
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
        String str = this.name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final List<KmType> getSupertypes() {
        return this.supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmFunction> getFunctions() {
        return this.functions;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmProperty> getProperties() {
        return this.properties;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer
    public List<KmTypeAlias> getTypeAliases() {
        return this.typeAliases;
    }

    public final List<KmConstructor> getConstructors() {
        return this.constructors;
    }

    public final void setCompanionObject(String str) {
        this.companionObject = str;
    }

    public final List<String> getNestedClasses() {
        return this.nestedClasses;
    }

    public final List<String> getEnumEntries() {
        return this.enumEntries;
    }

    public final List<KmEnumEntry> getKmEnumEntries() {
        return this.kmEnumEntries;
    }

    public final List<String> getSealedSubclasses() {
        return this.sealedSubclasses;
    }

    public final void setInlineClassUnderlyingPropertyName(String str) {
        this.inlineClassUnderlyingPropertyName = str;
    }

    public final KmType getInlineClassUnderlyingType() {
        return this.inlineClassUnderlyingType;
    }

    public final void setInlineClassUnderlyingType(KmType kmType) {
        this.inlineClassUnderlyingType = kmType;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmType> getContextReceiverTypes() {
        return this.contextReceiverTypes;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final List<KmClassExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}