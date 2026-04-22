package kntr.common.ouro.core.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinkUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/core/utils/MatchString;", "", "rawText", "", "type", "Lkntr/common/ouro/core/utils/MatchStringType;", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/utils/MatchStringType;)V", "getRawText", "()Ljava/lang/String;", "getType", "()Lkntr/common/ouro/core/utils/MatchStringType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MatchString {
    private final String rawText;
    private final MatchStringType type;

    public static /* synthetic */ MatchString copy$default(MatchString matchString, String str, MatchStringType matchStringType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchString.rawText;
        }
        if ((i & 2) != 0) {
            matchStringType = matchString.type;
        }
        return matchString.copy(str, matchStringType);
    }

    public final String component1() {
        return this.rawText;
    }

    public final MatchStringType component2() {
        return this.type;
    }

    public final MatchString copy(String str, MatchStringType matchStringType) {
        Intrinsics.checkNotNullParameter(str, "rawText");
        Intrinsics.checkNotNullParameter(matchStringType, "type");
        return new MatchString(str, matchStringType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MatchString) {
            MatchString matchString = (MatchString) obj;
            return Intrinsics.areEqual(this.rawText, matchString.rawText) && this.type == matchString.type;
        }
        return false;
    }

    public int hashCode() {
        return (this.rawText.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        String str = this.rawText;
        return "MatchString(rawText=" + str + ", type=" + this.type + ")";
    }

    public MatchString(String rawText, MatchStringType type) {
        Intrinsics.checkNotNullParameter(rawText, "rawText");
        Intrinsics.checkNotNullParameter(type, "type");
        this.rawText = rawText;
        this.type = type;
    }

    public final String getRawText() {
        return this.rawText;
    }

    public final MatchStringType getType() {
        return this.type;
    }
}