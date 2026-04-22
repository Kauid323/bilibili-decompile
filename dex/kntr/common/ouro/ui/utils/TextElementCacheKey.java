package kntr.common.ouro.ui.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpannableStringBuilderUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÂ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/ui/utils/TextElementCacheKey;", "", "key", "Lkntr/common/ouro/core/model/node/OuroNode;", "foregroundColorAlpha", "", "backgroundColorAlpha", "<init>", "(Lkntr/common/ouro/core/model/node/OuroNode;FF)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TextElementCacheKey {
    private final float backgroundColorAlpha;
    private final float foregroundColorAlpha;
    private final OuroNode key;

    private final OuroNode component1() {
        return this.key;
    }

    private final float component2() {
        return this.foregroundColorAlpha;
    }

    private final float component3() {
        return this.backgroundColorAlpha;
    }

    public static /* synthetic */ TextElementCacheKey copy$default(TextElementCacheKey textElementCacheKey, OuroNode ouroNode, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroNode = textElementCacheKey.key;
        }
        if ((i & 2) != 0) {
            f = textElementCacheKey.foregroundColorAlpha;
        }
        if ((i & 4) != 0) {
            f2 = textElementCacheKey.backgroundColorAlpha;
        }
        return textElementCacheKey.copy(ouroNode, f, f2);
    }

    public final TextElementCacheKey copy(OuroNode ouroNode, float f, float f2) {
        Intrinsics.checkNotNullParameter(ouroNode, "key");
        return new TextElementCacheKey(ouroNode, f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextElementCacheKey) {
            TextElementCacheKey textElementCacheKey = (TextElementCacheKey) obj;
            return Intrinsics.areEqual(this.key, textElementCacheKey.key) && Float.compare(this.foregroundColorAlpha, textElementCacheKey.foregroundColorAlpha) == 0 && Float.compare(this.backgroundColorAlpha, textElementCacheKey.backgroundColorAlpha) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + Float.floatToIntBits(this.foregroundColorAlpha)) * 31) + Float.floatToIntBits(this.backgroundColorAlpha);
    }

    public String toString() {
        OuroNode ouroNode = this.key;
        float f = this.foregroundColorAlpha;
        return "TextElementCacheKey(key=" + ouroNode + ", foregroundColorAlpha=" + f + ", backgroundColorAlpha=" + this.backgroundColorAlpha + ")";
    }

    public TextElementCacheKey(OuroNode key, float foregroundColorAlpha, float backgroundColorAlpha) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.foregroundColorAlpha = foregroundColorAlpha;
        this.backgroundColorAlpha = backgroundColorAlpha;
    }
}