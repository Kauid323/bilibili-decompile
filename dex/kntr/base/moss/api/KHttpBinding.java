package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossHttpRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/base/moss/api/KHttpBinding;", "", "field", "", "valuePattern", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getField", "()Ljava/lang/String;", "getValuePattern", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KHttpBinding {
    private final String field;
    private final String valuePattern;

    public static /* synthetic */ KHttpBinding copy$default(KHttpBinding kHttpBinding, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kHttpBinding.field;
        }
        if ((i & 2) != 0) {
            str2 = kHttpBinding.valuePattern;
        }
        return kHttpBinding.copy(str, str2);
    }

    public final String component1() {
        return this.field;
    }

    public final String component2() {
        return this.valuePattern;
    }

    public final KHttpBinding copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "field");
        return new KHttpBinding(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KHttpBinding) {
            KHttpBinding kHttpBinding = (KHttpBinding) obj;
            return Intrinsics.areEqual(this.field, kHttpBinding.field) && Intrinsics.areEqual(this.valuePattern, kHttpBinding.valuePattern);
        }
        return false;
    }

    public int hashCode() {
        return (this.field.hashCode() * 31) + (this.valuePattern == null ? 0 : this.valuePattern.hashCode());
    }

    public String toString() {
        String str = this.field;
        return "KHttpBinding(field=" + str + ", valuePattern=" + this.valuePattern + ")";
    }

    public KHttpBinding(String field, String valuePattern) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.field = field;
        this.valuePattern = valuePattern;
    }

    public final String getField() {
        return this.field;
    }

    public final String getValuePattern() {
        return this.valuePattern;
    }
}