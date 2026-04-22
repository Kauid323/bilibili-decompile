package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;

/* compiled from: Nodes.kt */
public final class KmType {
    private KmType abbreviatedType;
    private final List<KmTypeProjection> arguments;
    public KmClassifier classifier;
    private final List<KmTypeExtension> extensions;
    private int flags;
    private KmFlexibleTypeUpperBound flexibleTypeUpperBound;
    private KmType outerType;

    public KmType(int flags) {
        this.flags = flags;
        this.arguments = new ArrayList(0);
        Iterable $this$map$iv = MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MetadataExtensions p0 = (MetadataExtensions) item$iv$iv;
            destination$iv$iv.add(p0.createTypeExtension());
        }
        this.extensions = (List) destination$iv$iv;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public KmType() {
        this(0);
    }

    public final KmClassifier getClassifier() {
        KmClassifier kmClassifier = this.classifier;
        if (kmClassifier != null) {
            return kmClassifier;
        }
        Intrinsics.throwUninitializedPropertyAccessException("classifier");
        return null;
    }

    public final void setClassifier(KmClassifier kmClassifier) {
        Intrinsics.checkNotNullParameter(kmClassifier, "<set-?>");
        this.classifier = kmClassifier;
    }

    public final List<KmTypeProjection> getArguments() {
        return this.arguments;
    }

    public final KmType getAbbreviatedType() {
        return this.abbreviatedType;
    }

    public final void setAbbreviatedType(KmType kmType) {
        this.abbreviatedType = kmType;
    }

    public final KmType getOuterType() {
        return this.outerType;
    }

    public final void setOuterType(KmType kmType) {
        this.outerType = kmType;
    }

    public final KmFlexibleTypeUpperBound getFlexibleTypeUpperBound() {
        return this.flexibleTypeUpperBound;
    }

    public final void setFlexibleTypeUpperBound(KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound) {
        this.flexibleTypeUpperBound = kmFlexibleTypeUpperBound;
    }

    public final List<KmTypeExtension> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type kotlin.metadata.KmType");
            KmType kmType = (KmType) other;
            return this.flags == ((KmType) other).flags && Intrinsics.areEqual(getClassifier(), ((KmType) other).getClassifier()) && Intrinsics.areEqual(this.arguments, ((KmType) other).arguments) && Intrinsics.areEqual(this.outerType, ((KmType) other).outerType) && Intrinsics.areEqual(this.abbreviatedType, ((KmType) other).abbreviatedType) && Intrinsics.areEqual(this.flexibleTypeUpperBound, ((KmType) other).flexibleTypeUpperBound) && Intrinsics.areEqual(this.extensions, ((KmType) other).extensions);
        }
        return false;
    }

    public int hashCode() {
        int result = this.flags;
        return (((result * 31) + getClassifier().hashCode()) * 31) + this.arguments.hashCode();
    }
}