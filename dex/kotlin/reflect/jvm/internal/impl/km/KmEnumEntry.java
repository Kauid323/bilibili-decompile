package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmEnumEntry {
    private final List<KmAnnotation> annotations;
    private final List<KmEnumEntryExtension> extensions;
    private String name;

    public KmEnumEntry(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.annotations = new ArrayList(0);
        Iterable $this$mapNotNull$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            MetadataExtensions p0 = (MetadataExtensions) element$iv$iv$iv;
            KmEnumEntryExtension createEnumEntryExtension = p0.createEnumEntryExtension();
            if (createEnumEntryExtension != null) {
                destination$iv$iv.add(createEnumEntryExtension);
            }
        }
        this.extensions = (List) destination$iv$iv;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public String toString() {
        return this.name;
    }
}