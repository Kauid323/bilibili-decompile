package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmValueParameter {
    private KmAnnotationArgument annotationParameterDefaultValue;
    private final List<KmAnnotation> annotations;
    private final List<KmValueParameterExtension> extensions;
    private int flags;
    private String name;
    public KmType type;
    private KmType varargElementType;

    public KmValueParameter(int flags, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.flags = flags;
        this.name = name;
        this.annotations = new ArrayList(0);
        Iterable $this$mapNotNull$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            MetadataExtensions p0 = (MetadataExtensions) element$iv$iv$iv;
            KmValueParameterExtension createValueParameterExtension = p0.createValueParameterExtension();
            if (createValueParameterExtension != null) {
                destination$iv$iv.add(createValueParameterExtension);
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

    public final String getName() {
        return this.name;
    }

    public final KmType getType() {
        KmType kmType = this.type;
        if (kmType != null) {
            return kmType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void setType(KmType kmType) {
        Intrinsics.checkNotNullParameter(kmType, "<set-?>");
        this.type = kmType;
    }

    public final KmType getVarargElementType() {
        return this.varargElementType;
    }

    public final void setVarargElementType(KmType kmType) {
        this.varargElementType = kmType;
    }

    public final KmAnnotationArgument getAnnotationParameterDefaultValue() {
        return this.annotationParameterDefaultValue;
    }

    public final void setAnnotationParameterDefaultValue(KmAnnotationArgument kmAnnotationArgument) {
        this.annotationParameterDefaultValue = kmAnnotationArgument;
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }
}