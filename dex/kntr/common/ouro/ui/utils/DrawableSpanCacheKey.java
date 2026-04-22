package kntr.common.ouro.ui.utils;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannableStringBuilderUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/ui/utils/DrawableSpanCacheKey;", "", "nodeKey", "Lkntr/common/ouro/core/model/node/OuroNode;", "width", "", "height", "isDarkTheme", "", "paddingHash", "<init>", "(Lkntr/common/ouro/core/model/node/OuroNode;IIZI)V", "getNodeKey", "()Lkntr/common/ouro/core/model/node/OuroNode;", "getWidth", "()I", "getHeight", "()Z", "getPaddingHash", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DrawableSpanCacheKey {
    public static final int $stable = 8;
    private final int height;
    private final boolean isDarkTheme;
    private final OuroNode nodeKey;
    private final int paddingHash;
    private final int width;

    public static /* synthetic */ DrawableSpanCacheKey copy$default(DrawableSpanCacheKey drawableSpanCacheKey, OuroNode ouroNode, int i, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            ouroNode = drawableSpanCacheKey.nodeKey;
        }
        if ((i4 & 2) != 0) {
            i = drawableSpanCacheKey.width;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = drawableSpanCacheKey.height;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            z = drawableSpanCacheKey.isDarkTheme;
        }
        boolean z2 = z;
        if ((i4 & 16) != 0) {
            i3 = drawableSpanCacheKey.paddingHash;
        }
        return drawableSpanCacheKey.copy(ouroNode, i5, i6, z2, i3);
    }

    public final OuroNode component1() {
        return this.nodeKey;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final boolean component4() {
        return this.isDarkTheme;
    }

    public final int component5() {
        return this.paddingHash;
    }

    public final DrawableSpanCacheKey copy(OuroNode ouroNode, int i, int i2, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(ouroNode, "nodeKey");
        return new DrawableSpanCacheKey(ouroNode, i, i2, z, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawableSpanCacheKey) {
            DrawableSpanCacheKey drawableSpanCacheKey = (DrawableSpanCacheKey) obj;
            return Intrinsics.areEqual(this.nodeKey, drawableSpanCacheKey.nodeKey) && this.width == drawableSpanCacheKey.width && this.height == drawableSpanCacheKey.height && this.isDarkTheme == drawableSpanCacheKey.isDarkTheme && this.paddingHash == drawableSpanCacheKey.paddingHash;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.nodeKey.hashCode() * 31) + this.width) * 31) + this.height) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDarkTheme)) * 31) + this.paddingHash;
    }

    public String toString() {
        OuroNode ouroNode = this.nodeKey;
        int i = this.width;
        int i2 = this.height;
        boolean z = this.isDarkTheme;
        return "DrawableSpanCacheKey(nodeKey=" + ouroNode + ", width=" + i + ", height=" + i2 + ", isDarkTheme=" + z + ", paddingHash=" + this.paddingHash + ")";
    }

    public DrawableSpanCacheKey(OuroNode nodeKey, int width, int height, boolean isDarkTheme, int paddingHash) {
        Intrinsics.checkNotNullParameter(nodeKey, "nodeKey");
        this.nodeKey = nodeKey;
        this.width = width;
        this.height = height;
        this.isDarkTheme = isDarkTheme;
        this.paddingHash = paddingHash;
    }

    public final OuroNode getNodeKey() {
        return this.nodeKey;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final boolean isDarkTheme() {
        return this.isDarkTheme;
    }

    public final int getPaddingHash() {
        return this.paddingHash;
    }
}