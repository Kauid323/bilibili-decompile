package kntr.app.game.steam.chart;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarChart.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J:\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lkntr/app/game/steam/chart/BarData;", RoomRecommendViewModel.EMPTY_CURSOR, "label", RoomRecommendViewModel.EMPTY_CURSOR, "value", RoomRecommendViewModel.EMPTY_CURSOR, "color", "Landroidx/compose/ui/graphics/Color;", "gradient", "Landroidx/compose/ui/graphics/Brush;", "<init>", "(Ljava/lang/String;FJLandroidx/compose/ui/graphics/Brush;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLabel", "()Ljava/lang/String;", "getValue", "()F", "getColor-0d7_KjU", "()J", "J", "getGradient", "()Landroidx/compose/ui/graphics/Brush;", "component1", "component2", "component3", "component3-0d7_KjU", "component4", "copy", "copy-9LQNqLg", "(Ljava/lang/String;FJLandroidx/compose/ui/graphics/Brush;)Lkntr/app/game/steam/chart/BarData;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BarData {
    public static final int $stable = 0;
    private final long color;
    private final Brush gradient;
    private final String label;
    private final float value;

    public /* synthetic */ BarData(String str, float f, long j2, Brush brush, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, j2, brush);
    }

    /* renamed from: copy-9LQNqLg$default  reason: not valid java name */
    public static /* synthetic */ BarData m1343copy9LQNqLg$default(BarData barData, String str, float f, long j2, Brush brush, int i, Object obj) {
        if ((i & 1) != 0) {
            str = barData.label;
        }
        if ((i & 2) != 0) {
            f = barData.value;
        }
        float f2 = f;
        if ((i & 4) != 0) {
            j2 = barData.color;
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            brush = barData.gradient;
        }
        return barData.m1345copy9LQNqLg(str, f2, j3, brush);
    }

    public final String component1() {
        return this.label;
    }

    public final float component2() {
        return this.value;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m1344component30d7_KjU() {
        return this.color;
    }

    public final Brush component4() {
        return this.gradient;
    }

    /* renamed from: copy-9LQNqLg  reason: not valid java name */
    public final BarData m1345copy9LQNqLg(String str, float f, long j2, Brush brush) {
        Intrinsics.checkNotNullParameter(str, "label");
        return new BarData(str, f, j2, brush, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BarData) {
            BarData barData = (BarData) obj;
            return Intrinsics.areEqual(this.label, barData.label) && Float.compare(this.value, barData.value) == 0 && Color.equals-impl0(this.color, barData.color) && Intrinsics.areEqual(this.gradient, barData.gradient);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.label.hashCode() * 31) + Float.floatToIntBits(this.value)) * 31) + Color.hashCode-impl(this.color)) * 31) + (this.gradient == null ? 0 : this.gradient.hashCode());
    }

    public String toString() {
        String str = this.label;
        float f = this.value;
        String str2 = Color.toString-impl(this.color);
        return "BarData(label=" + str + ", value=" + f + ", color=" + str2 + ", gradient=" + this.gradient + ")";
    }

    private BarData(String label, float value, long color, Brush gradient) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.value = value;
        this.color = color;
        this.gradient = gradient;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BarData(String str, float f, long j2, Brush brush, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, r5, r7, null);
        long j3;
        Brush brush2;
        if ((i & 4) == 0) {
            j3 = j2;
        } else {
            j3 = Color.Companion.getWhite-0d7_KjU();
        }
        if ((i & 8) == 0) {
            brush2 = brush;
        } else {
            brush2 = Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0.0f, 0.0f, 0, 14, (Object) null);
        }
    }

    public final String getLabel() {
        return this.label;
    }

    public final float getValue() {
        return this.value;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m1346getColor0d7_KjU() {
        return this.color;
    }

    public final Brush getGradient() {
        return this.gradient;
    }
}