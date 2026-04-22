package kntr.app.upcomingEpisode.list.ui;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayingIconPainter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkntr/app/upcomingEpisode/list/ui/Line;", "", "phaseDiff", "", "frameCount", "<init>", "(II)V", "value", "currentPhase", "getCurrentPhase", "()I", "setPhase", "", "phase", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Line {
    private int currentPhase;
    private final int frameCount;
    private final int phaseDiff;

    public Line(int phaseDiff, int frameCount) {
        this.phaseDiff = phaseDiff;
        this.frameCount = frameCount;
    }

    public /* synthetic */ Line(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 20 : i2);
    }

    public final int getCurrentPhase() {
        return this.currentPhase;
    }

    public final void setPhase(int phase) {
        int i = this.frameCount;
        int i2 = (this.phaseDiff + phase) % i;
        this.currentPhase = i2 + (i & (((i2 ^ i) & ((-i2) | i2)) >> 31));
    }
}