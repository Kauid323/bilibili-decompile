package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmTypeAlias {
    private final List<KmAnnotation> annotations;
    public KmType expandedType;
    private final List<KmTypeAliasExtension> extensions;
    private int flags;
    private String name;
    private final List<KmTypeParameter> typeParameters;
    public KmType underlyingType;
    private final List<KmVersionRequirement> versionRequirements;

    public KmTypeAlias(int flags, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        this.typeParameters = new ArrayList(0);
        this.annotations = new ArrayList(0);
        this.versionRequirements = new ArrayList(0);
        Iterable $this$mapNotNull$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            MetadataExtensions p0 = (MetadataExtensions) element$iv$iv$iv;
            KmTypeAliasExtension createTypeAliasExtension = p0.createTypeAliasExtension();
            if (createTypeAliasExtension != null) {
                destination$iv$iv.add(createTypeAliasExtension);
            }
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

    public final void setUnderlyingType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.underlyingType = kmType;
    }

    public final void setExpandedType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.expandedType = kmType;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }
}