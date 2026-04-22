package kntr.common.ouro.ui.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: OuroAnnotatedString.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÁ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/ui/utils/QuoteStyle;", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "indent", "", "getIndent", "()F", "alpha", "getAlpha", "equals", "", "other", "", "hashCode", "", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class QuoteStyle implements OuroCustomStyle {
    public static final int $stable = 0;
    public static final QuoteStyle INSTANCE = new QuoteStyle();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuoteStyle) {
            QuoteStyle quoteStyle = (QuoteStyle) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 908746295;
    }

    public String toString() {
        return "QuoteStyle";
    }

    private QuoteStyle() {
    }

    @Override // kntr.common.ouro.ui.utils.OuroCustomStyle
    public String getKey() {
        return "OuroQuoteStyle";
    }

    public final float getIndent() {
        return 22.0f;
    }

    public final float getAlpha() {
        return 0.6f;
    }
}