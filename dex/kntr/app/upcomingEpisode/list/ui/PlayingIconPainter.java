package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayingIconPainter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0014R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/app/upcomingEpisode/list/ui/PlayingIconPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "phaseProvider", "Landroidx/compose/runtime/State;", "", "color", "Landroidx/compose/ui/graphics/Color;", "isLive", "", "<init>", "(JLandroidx/compose/runtime/State;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIntrinsicSize-NH-jbRc", "()J", "J", "getPhaseProvider", "()Landroidx/compose/runtime/State;", "getColor-0d7_KjU", "()Z", "unitSize", "radius", "", "lines", "", "Lkntr/app/upcomingEpisode/list/ui/Line;", "a", "k", "b", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlayingIconPainter extends Painter {
    public static final int $stable = 8;
    private final float a;
    private final float b;
    private final long color;
    private final long intrinsicSize;
    private final boolean isLive;
    private final float k;
    private final List<Line> lines;
    private final State<Integer> phaseProvider;
    private final float radius;
    private final long unitSize;

    public /* synthetic */ PlayingIconPainter(long j, State state, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, state, j2, z);
    }

    private PlayingIconPainter(long intrinsicSize, State<Integer> state, long color, boolean isLive) {
        Intrinsics.checkNotNullParameter(state, "phaseProvider");
        this.intrinsicSize = intrinsicSize;
        this.phaseProvider = state;
        this.color = color;
        this.isLive = isLive;
        int bits$iv$iv$iv = (int) (m1238getIntrinsicSizeNHjbRc() >> 32);
        float f = 36;
        float width$iv = Float.intBitsToFloat(bits$iv$iv$iv) / f;
        int bits$iv$iv$iv2 = (int) (m1238getIntrinsicSizeNHjbRc() & 4294967295L);
        float height$iv = Float.intBitsToFloat(bits$iv$iv$iv2) / f;
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        this.unitSize = Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv3 = (int) (this.unitSize >> 32);
        this.radius = (6 * Float.intBitsToFloat(bits$iv$iv$iv3)) / 2.0f;
        this.lines = CollectionsKt.listOf(new Line[]{new Line(0, 0, 2, null), new Line(10, 0, 2, null), new Line(15, 0, 2, null)});
        this.a = 0.13333002f;
        this.k = -0.14814445f;
        this.b = 1 - (19 * this.k);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m1238getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    public final State<Integer> getPhaseProvider() {
        return this.phaseProvider;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m1237getColor0d7_KjU() {
        return this.color;
    }

    public final boolean isLive() {
        return this.isLive;
    }

    protected void onDraw(DrawScope $this$onDraw) {
        float currentPhase;
        int phase;
        long v2$iv$iv;
        PlayingIconPainter playingIconPainter = this;
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        int phase2 = ((Number) playingIconPainter.phaseProvider.getValue()).intValue();
        Iterable $this$forEachIndexed$iv = playingIconPainter.lines;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Line line = (Line) item$iv;
            int index = index$iv;
            line.setPhase(phase2);
            int bits$iv$iv$iv = (int) (playingIconPainter.unitSize >> 32);
            float left = ((index * 12) + 3) * Float.intBitsToFloat(bits$iv$iv$iv);
            int bits$iv$iv$iv2 = (int) (playingIconPainter.unitSize >> 32);
            float right = left + (6 * Float.intBitsToFloat(bits$iv$iv$iv2));
            if (line.getCurrentPhase() < 10) {
                currentPhase = (playingIconPainter.a * line.getCurrentPhase()) + 1;
            } else if (line.getCurrentPhase() == 10) {
                currentPhase = 2.3333f;
            } else {
                currentPhase = (playingIconPainter.k * line.getCurrentPhase()) + playingIconPainter.b;
            }
            int bits$iv$iv$iv3 = (int) (playingIconPainter.unitSize & 4294967295L);
            float lineHeight = currentPhase * 12 * Float.intBitsToFloat(bits$iv$iv$iv3);
            int bits$iv$iv$iv4 = (int) (m1238getIntrinsicSizeNHjbRc() & 4294967295L);
            float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv4);
            int bits$iv$iv$iv5 = (int) (playingIconPainter.unitSize & 4294967295L);
            float bottom = intBitsToFloat - (3 * Float.intBitsToFloat(bits$iv$iv$iv5));
            float top = bottom - lineHeight;
            long j = playingIconPainter.color;
            if (!playingIconPainter.isLive) {
                phase = phase2;
                float y$iv = top / 2;
                long v1$iv$iv = Float.floatToRawIntBits(left);
                long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
                v2$iv$iv = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv2 & 4294967295L));
            } else {
                long v1$iv$iv2 = Float.floatToRawIntBits(left);
                phase = phase2;
                long v2$iv$iv3 = Float.floatToRawIntBits(top);
                v2$iv$iv = Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv3 & 4294967295L));
            }
            long j2 = v2$iv$iv;
            float width$iv = right - left;
            long v1$iv$iv3 = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv4 = Float.floatToRawIntBits(lineHeight);
            long j3 = Size.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv4 & 4294967295L));
            float x$iv = playingIconPainter.radius;
            long v1$iv$iv4 = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv5 = Float.floatToRawIntBits(x$iv);
            DrawScope.-CC.drawRoundRect-u-Aw5IA$default($this$onDraw, j, j2, j3, CornerRadius.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv5 & 4294967295L)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
            playingIconPainter = this;
            index$iv = index$iv2;
            phase2 = phase;
        }
    }
}