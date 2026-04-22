package kntr.common.ouro.ui.utils;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OuroAnnotatedString.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\fJ$\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lkntr/common/ouro/ui/utils/BackgroundStyle;", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "height", "Landroidx/compose/ui/unit/Dp;", "<init>", "(JFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getHeight-D9Ej5fM", "()F", "F", "key", "", "getKey", "()Ljava/lang/String;", "component1", "component1-0d7_KjU", "component2", "component2-D9Ej5fM", "copy", "copy-l07J4OM", "(JF)Lkntr/common/ouro/ui/utils/BackgroundStyle;", "equals", "", "other", "", "hashCode", "", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BackgroundStyle implements OuroCustomStyle {
    public static final int $stable = 0;
    private final long color;
    private final float height;

    public /* synthetic */ BackgroundStyle(long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f);
    }

    /* renamed from: copy-l07J4OM$default  reason: not valid java name */
    public static /* synthetic */ BackgroundStyle m2110copyl07J4OM$default(BackgroundStyle backgroundStyle, long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = backgroundStyle.color;
        }
        if ((i & 2) != 0) {
            f = backgroundStyle.height;
        }
        return backgroundStyle.m2113copyl07J4OM(j, f);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m2111component10d7_KjU() {
        return this.color;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m2112component2D9Ej5fM() {
        return this.height;
    }

    /* renamed from: copy-l07J4OM  reason: not valid java name */
    public final BackgroundStyle m2113copyl07J4OM(long j, float f) {
        return new BackgroundStyle(j, f, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackgroundStyle) {
            BackgroundStyle backgroundStyle = (BackgroundStyle) obj;
            return Color.equals-impl0(this.color, backgroundStyle.color) && Dp.equals-impl0(this.height, backgroundStyle.height);
        }
        return false;
    }

    public int hashCode() {
        return (Color.hashCode-impl(this.color) * 31) + Dp.hashCode-impl(this.height);
    }

    public String toString() {
        String str = Color.toString-impl(this.color);
        return "BackgroundStyle(color=" + str + ", height=" + Dp.toString-impl(this.height) + ")";
    }

    private BackgroundStyle(long color, float height) {
        this.color = color;
        this.height = height;
    }

    public /* synthetic */ BackgroundStyle(long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? Dp.constructor-impl(12) : f, null);
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m2114getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m2115getHeightD9Ej5fM() {
        return this.height;
    }

    @Override // kntr.common.ouro.ui.utils.OuroCustomStyle
    public String getKey() {
        return "OuroBackgroundStyle";
    }
}