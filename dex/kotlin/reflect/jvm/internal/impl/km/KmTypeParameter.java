package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmTypeParameter {
    private final List<KmTypeParameterExtension> extensions;
    private int flags;
    private int id;
    private String name;
    private final List<KmType> upperBounds;
    private KmVariance variance;

    public KmTypeParameter(int flags, String name, int id, KmVariance variance) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        this.flags = flags;
        this.name = name;
        this.id = id;
        this.variance = variance;
        this.upperBounds = new ArrayList(1);
        Iterable $this$map$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MetadataExtensions p0 = (MetadataExtensions) item$iv$iv;
            destination$iv$iv.add(p0.createTypeParameterExtension());
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

    public final int getId() {
        return this.id;
    }

    public final KmVariance getVariance() {
        return this.variance;
    }

    public final List<KmType> getUpperBounds() {
        return this.upperBounds;
    }

    public final List<KmTypeParameterExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }
}