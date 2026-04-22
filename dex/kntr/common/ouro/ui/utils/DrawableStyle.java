package kntr.common.ouro.ui.utils;

import androidx.compose.ui.unit.DpSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.drawable.OuroDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAnnotatedString.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ(\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u000eHÖ\u0001R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/ui/utils/DrawableStyle;", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "drawable", "Lkntr/common/ouro/core/model/node/drawable/OuroDrawable;", "displaySize", "Landroidx/compose/ui/unit/DpSize;", "<init>", "(Lkntr/common/ouro/core/model/node/drawable/OuroDrawable;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDrawable", "()Lkntr/common/ouro/core/model/node/drawable/OuroDrawable;", "getDisplaySize-MYxV2XQ", "()J", "J", "key", "", "getKey", "()Ljava/lang/String;", "component1", "component2", "component2-MYxV2XQ", "copy", "copy-6HolHcs", "(Lkntr/common/ouro/core/model/node/drawable/OuroDrawable;J)Lkntr/common/ouro/ui/utils/DrawableStyle;", "equals", "", "other", "", "hashCode", "", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DrawableStyle implements OuroCustomStyle {
    public static final int $stable = 8;
    private final long displaySize;
    private final OuroDrawable<?> drawable;

    public /* synthetic */ DrawableStyle(OuroDrawable ouroDrawable, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroDrawable, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-6HolHcs$default  reason: not valid java name */
    public static /* synthetic */ DrawableStyle m2122copy6HolHcs$default(DrawableStyle drawableStyle, OuroDrawable ouroDrawable, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroDrawable = drawableStyle.drawable;
        }
        if ((i & 2) != 0) {
            j = drawableStyle.displaySize;
        }
        return drawableStyle.m2124copy6HolHcs(ouroDrawable, j);
    }

    public final OuroDrawable<?> component1() {
        return this.drawable;
    }

    /* renamed from: component2-MYxV2XQ  reason: not valid java name */
    public final long m2123component2MYxV2XQ() {
        return this.displaySize;
    }

    /* renamed from: copy-6HolHcs  reason: not valid java name */
    public final DrawableStyle m2124copy6HolHcs(OuroDrawable<?> ouroDrawable, long j) {
        Intrinsics.checkNotNullParameter(ouroDrawable, "drawable");
        return new DrawableStyle(ouroDrawable, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawableStyle) {
            DrawableStyle drawableStyle = (DrawableStyle) obj;
            return Intrinsics.areEqual(this.drawable, drawableStyle.drawable) && DpSize.equals-impl0(this.displaySize, drawableStyle.displaySize);
        }
        return false;
    }

    public int hashCode() {
        return (this.drawable.hashCode() * 31) + DpSize.hashCode-impl(this.displaySize);
    }

    public String toString() {
        OuroDrawable<?> ouroDrawable = this.drawable;
        return "DrawableStyle(drawable=" + ouroDrawable + ", displaySize=" + DpSize.toString-impl(this.displaySize) + ")";
    }

    private DrawableStyle(OuroDrawable<?> ouroDrawable, long displaySize) {
        Intrinsics.checkNotNullParameter(ouroDrawable, "drawable");
        this.drawable = ouroDrawable;
        this.displaySize = displaySize;
    }

    public final OuroDrawable<?> getDrawable() {
        return this.drawable;
    }

    /* renamed from: getDisplaySize-MYxV2XQ  reason: not valid java name */
    public final long m2125getDisplaySizeMYxV2XQ() {
        return this.displaySize;
    }

    @Override // kntr.common.ouro.ui.utils.OuroCustomStyle
    public String getKey() {
        return "OuroDrawableStyle";
    }
}