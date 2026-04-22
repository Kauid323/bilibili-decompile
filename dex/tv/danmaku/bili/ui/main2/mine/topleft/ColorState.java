package tv.danmaku.bili.ui.main2.mine.topleft;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: ActivityAnswer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/topleft/ColorState;", "", "back", "Landroidx/compose/ui/graphics/Color;", "front", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBack-0d7_KjU", "()J", "J", "getFront-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "copy", "copy--OWjLjI", "(JJ)Ltv/danmaku/bili/ui/main2/mine/topleft/ColorState;", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ColorState {
    public static final int $stable = 0;
    private final long back;
    private final long front;

    public /* synthetic */ ColorState(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: copy--OWjLjI$default  reason: not valid java name */
    public static /* synthetic */ ColorState m2110copyOWjLjI$default(ColorState colorState, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = colorState.back;
        }
        if ((i & 2) != 0) {
            j2 = colorState.front;
        }
        return colorState.m2113copyOWjLjI(j, j2);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m2111component10d7_KjU() {
        return this.back;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m2112component20d7_KjU() {
        return this.front;
    }

    /* renamed from: copy--OWjLjI  reason: not valid java name */
    public final ColorState m2113copyOWjLjI(long j, long j2) {
        return new ColorState(j, j2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ColorState) {
            ColorState colorState = (ColorState) obj;
            return Color.equals-impl0(this.back, colorState.back) && Color.equals-impl0(this.front, colorState.front);
        }
        return false;
    }

    public int hashCode() {
        return (Color.hashCode-impl(this.back) * 31) + Color.hashCode-impl(this.front);
    }

    public String toString() {
        String str = Color.toString-impl(this.back);
        return "ColorState(back=" + str + ", front=" + Color.toString-impl(this.front) + ")";
    }

    private ColorState(long back, long front) {
        this.back = back;
        this.front = front;
    }

    /* renamed from: getBack-0d7_KjU  reason: not valid java name */
    public final long m2114getBack0d7_KjU() {
        return this.back;
    }

    /* renamed from: getFront-0d7_KjU  reason: not valid java name */
    public final long m2115getFront0d7_KjU() {
        return this.front;
    }
}