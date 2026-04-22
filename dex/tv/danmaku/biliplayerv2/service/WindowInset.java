package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IActivityStateService.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/WindowInset;", "", "leftPadding", "", "topPadding", "rightPadding", "bottomPadding", "<init>", "(IIII)V", "getLeftPadding", "()I", "setLeftPadding", "(I)V", "getTopPadding", "setTopPadding", "getRightPadding", "setRightPadding", "getBottomPadding", "setBottomPadding", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WindowInset {
    private int bottomPadding;
    private int leftPadding;
    private int rightPadding;
    private int topPadding;

    public WindowInset() {
        this(0, 0, 0, 0, 15, null);
    }

    public WindowInset(int leftPadding, int topPadding, int rightPadding, int bottomPadding) {
        this.leftPadding = leftPadding;
        this.topPadding = topPadding;
        this.rightPadding = rightPadding;
        this.bottomPadding = bottomPadding;
    }

    public /* synthetic */ WindowInset(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public final int getLeftPadding() {
        return this.leftPadding;
    }

    public final void setLeftPadding(int i) {
        this.leftPadding = i;
    }

    public final int getTopPadding() {
        return this.topPadding;
    }

    public final void setTopPadding(int i) {
        this.topPadding = i;
    }

    public final int getRightPadding() {
        return this.rightPadding;
    }

    public final void setRightPadding(int i) {
        this.rightPadding = i;
    }

    public final int getBottomPadding() {
        return this.bottomPadding;
    }

    public final void setBottomPadding(int i) {
        this.bottomPadding = i;
    }
}