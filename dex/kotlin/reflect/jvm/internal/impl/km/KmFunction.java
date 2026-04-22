package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmFunction {
    private final List<KmAnnotation> annotations;
    private final List<KmValueParameter> contextParameters;
    private final List<KmType> contextReceiverTypes;
    private KmContract contract;
    private final List<KmAnnotation> extensionReceiverParameterAnnotations;
    private final List<KmFunctionExtension> extensions;
    private int flags;
    private String name;
    private KmType receiverParameterType;
    public KmType returnType;
    private final List<KmTypeParameter> typeParameters;
    private final List<KmValueParameter> valueParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmFunction(int flags, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        this.typeParameters = new ArrayList(0);
        this.extensionReceiverParameterAnnotations = new ArrayList(0);
        this.contextReceiverTypes = new ArrayList(0);
        this.valueParameters = new ArrayList();
        this.contextParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        this.annotations = new ArrayList(0);
        Iterable $this$map$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MetadataExtensions p0 = (MetadataExtensions) item$iv$iv;
            destination$iv$iv.add(p0.createFunctionExtension());
        }
        this.extensions = (List) destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final List<KmTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public final void setReceiverParameterType(KmType kmType) {
        this.receiverParameterType = kmType;
    }

    public final List<KmAnnotation> getExtensionReceiverParameterAnnotations() {
        return this.extensionReceiverParameterAnnotations;
    }

    public final List<KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final List<KmValueParameter> getContextParameters() {
        return this.contextParameters;
    }

    public final void setReturnType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.returnType = kmType;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final void setContract(KmContract kmContract) {
        this.contract = kmContract;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmFunctionExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}