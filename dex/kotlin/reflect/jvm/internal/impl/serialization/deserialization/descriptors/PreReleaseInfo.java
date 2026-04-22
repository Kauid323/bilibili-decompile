package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import BottomSheetItemData$;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeserializedContainerSource.kt */
public final class PreReleaseInfo {
    public static final Companion Companion = new Companion(null);
    private static final PreReleaseInfo DEFAULT_VISIBLE = new PreReleaseInfo(false, null, 2, null);
    private final boolean isInvisible;
    private final List<String> poisoningFeatures;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreReleaseInfo) {
            PreReleaseInfo preReleaseInfo = (PreReleaseInfo) obj;
            return this.isInvisible == preReleaseInfo.isInvisible && Intrinsics.areEqual(this.poisoningFeatures, preReleaseInfo.poisoningFeatures);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isInvisible) * 31) + this.poisoningFeatures.hashCode();
    }

    public String toString() {
        return "PreReleaseInfo(isInvisible=" + this.isInvisible + ", poisoningFeatures=" + this.poisoningFeatures + ')';
    }

    /* compiled from: DeserializedContainerSource.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PreReleaseInfo(boolean isInvisible, List<String> poisoningFeatures) {
        Intrinsics.checkNotNullParameter(poisoningFeatures, "poisoningFeatures");
        this.isInvisible = isInvisible;
        this.poisoningFeatures = poisoningFeatures;
    }

    public /* synthetic */ PreReleaseInfo(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}