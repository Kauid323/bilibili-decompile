package kntr.common.ouro.core.plugin.atMention;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroTextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAtMentionState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/core/plugin/atMention/Keyword;", "", "text", "", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/model/OuroTextRange;)V", "getText", "()Ljava/lang/String;", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Keyword {
    private final OuroTextRange range;
    private final String text;

    public static /* synthetic */ Keyword copy$default(Keyword keyword, String str, OuroTextRange ouroTextRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keyword.text;
        }
        if ((i & 2) != 0) {
            ouroTextRange = keyword.range;
        }
        return keyword.copy(str, ouroTextRange);
    }

    public final String component1() {
        return this.text;
    }

    public final OuroTextRange component2() {
        return this.range;
    }

    public final Keyword copy(String str, OuroTextRange ouroTextRange) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(ouroTextRange, "range");
        return new Keyword(str, ouroTextRange);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Keyword) {
            Keyword keyword = (Keyword) obj;
            return Intrinsics.areEqual(this.text, keyword.text) && Intrinsics.areEqual(this.range, keyword.range);
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.range.hashCode();
    }

    public String toString() {
        String str = this.text;
        return "Keyword(text=" + str + ", range=" + this.range + ")";
    }

    public Keyword(String text, OuroTextRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        this.text = text;
        this.range = range;
    }

    public final String getText() {
        return this.text;
    }

    public final OuroTextRange getRange() {
        return this.range;
    }
}