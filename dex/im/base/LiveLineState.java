package im.base;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveBadge.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lim/base/LiveLineState;", "", "parentPhase", "Landroidx/compose/runtime/State;", "", "index", "phaseDiff", "frameCount", "<init>", "(Landroidx/compose/runtime/State;III)V", "unitCount", "lineWidthInUnit", "lineStartInUnit", "lineBaseHeightInUnit", "lineBottomInUnit", "a", "", "k", "b", "getCurrentHeight", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/geometry/Size;", "getCurrentHeight-uvyYCjk", "(J)F", "getCurrentRect", "Landroidx/compose/ui/geometry/Rect;", "getCurrentRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LiveLineState {
    private final float a;
    private final float b;
    private final int frameCount;
    private final int index;
    private final float k;
    private final int lineBaseHeightInUnit;
    private final int lineBottomInUnit;
    private final int lineStartInUnit;
    private final int lineWidthInUnit;
    private final State<Integer> parentPhase;
    private final int phaseDiff;
    private final int unitCount;

    public LiveLineState(State<Integer> state, int index, int phaseDiff, int frameCount) {
        Intrinsics.checkNotNullParameter(state, "parentPhase");
        this.parentPhase = state;
        this.index = index;
        this.phaseDiff = phaseDiff;
        this.frameCount = frameCount;
        if (!(this.phaseDiff >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.unitCount = 36;
        this.lineWidthInUnit = 6;
        this.lineStartInUnit = 3;
        this.lineBaseHeightInUnit = 12;
        this.lineBottomInUnit = 3;
        this.a = 0.13333002f;
        this.k = -0.14814445f;
        this.b = 1 - (19 * this.k);
    }

    public /* synthetic */ LiveLineState(State state, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, i2, i3, (i5 & 8) != 0 ? 20 : i4);
    }

    /* renamed from: getCurrentHeight-uvyYCjk */
    public final float m3098getCurrentHeightuvyYCjk(long j) {
        float f2;
        float unitSize = Size.getMinDimension-impl(j) / this.unitCount;
        int intValue = ((Number) this.parentPhase.getValue()).intValue() + this.phaseDiff;
        int i2 = this.frameCount;
        int i3 = intValue % i2;
        int currentPhase = i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
        if (currentPhase < 10) {
            f2 = (this.a * currentPhase) + 1;
        } else {
            f2 = currentPhase == 10 ? 2.3333f : (this.k * currentPhase) + this.b;
        }
        return f2 * this.lineBaseHeightInUnit * unitSize;
    }

    /* renamed from: getCurrentRect-uvyYCjk */
    public final Rect m3099getCurrentRectuvyYCjk(long j) {
        float f2;
        float unitSize = Size.getMinDimension-impl(j) / this.unitCount;
        float unitSize$iv = Size.getMinDimension-impl(j) / this.unitCount;
        int intValue = ((Number) this.parentPhase.getValue()).intValue() + this.phaseDiff;
        int i2 = this.frameCount;
        int i3 = intValue % i2;
        int currentPhase$iv = i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
        if (currentPhase$iv < 10) {
            f2 = (this.a * currentPhase$iv) + 1;
        } else {
            f2 = currentPhase$iv == 10 ? 2.3333f : (this.k * currentPhase$iv) + this.b;
        }
        float currentHeight = f2 * this.lineBaseHeightInUnit * unitSize$iv;
        float left = ((this.lineWidthInUnit * 2 * this.index) + this.lineStartInUnit) * unitSize;
        float width = this.lineWidthInUnit * unitSize;
        int bits$iv$iv$iv = (int) (j & 4294967295L);
        float bottom = Float.intBitsToFloat(bits$iv$iv$iv) - this.lineBottomInUnit;
        float top = bottom - currentHeight;
        long v1$iv$iv = Float.floatToRawIntBits(left);
        long v2$iv$iv = Float.floatToRawIntBits(top);
        long v2$iv$iv2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        long v1$iv$iv2 = Float.floatToRawIntBits(width);
        long v2$iv$iv3 = Float.floatToRawIntBits(currentHeight);
        return RectKt.Rect-tz77jQw(v2$iv$iv2, Size.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv3)));
    }
}