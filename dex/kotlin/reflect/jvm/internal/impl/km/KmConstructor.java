package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmConstructor {
    private final List<KmAnnotation> annotations;
    private final List<KmConstructorExtension> extensions;
    private int flags;
    private final List<KmValueParameter> valueParameters;
    private final List<KmVersionRequirement> versionRequirements;

    public KmConstructor(int flags) {
        this.flags = flags;
        this.valueParameters = new ArrayList();
        this.versionRequirements = new ArrayList(0);
        this.annotations = new ArrayList(0);
        Iterable $this$map$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MetadataExtensions p0 = (MetadataExtensions) item$iv$iv;
            destination$iv$iv.add(p0.createConstructorExtension());
        }
        this.extensions = (List) destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public KmConstructor() {
        this(0);
    }

    public final List<KmValueParameter> getValueParameters() {
        return this.valueParameters;
    }

    public final List<KmVersionRequirement> getVersionRequirements() {
        return this.versionRequirements;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmConstructorExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}