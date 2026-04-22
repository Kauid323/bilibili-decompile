package tv.danmaku.bili.ui.videospace;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.IWindowInsetObserver;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NormalPlayerInsetControllerWidget.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/bili/ui/videospace/NormalPlayerInsetControllerWidget$mWindowInsetObserver$1", "Ltv/danmaku/biliplayerv2/service/IWindowInsetObserver;", "onWindowInsetChanged", "", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalPlayerInsetControllerWidget$mWindowInsetObserver$1 implements IWindowInsetObserver {
    final /* synthetic */ NormalPlayerInsetControllerWidget this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NormalPlayerInsetControllerWidget$mWindowInsetObserver$1(NormalPlayerInsetControllerWidget $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.IWindowInsetObserver
    public void onWindowInsetChanged(WindowInset windowInset) {
        int left;
        int top;
        int right;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(windowInset, "windowInset");
        int bottom = 0;
        if (windowInset.getLeftPadding() > 0) {
            int leftPadding = windowInset.getLeftPadding();
            i7 = this.this$0.mContentLeftPadding;
            if (leftPadding > i7) {
                int leftPadding2 = windowInset.getLeftPadding();
                i8 = this.this$0.mContentLeftPadding;
                left = leftPadding2 - i8;
            } else {
                left = windowInset.getLeftPadding();
            }
        } else {
            left = 0;
        }
        if (windowInset.getTopPadding() > 0) {
            int topPadding = windowInset.getTopPadding();
            i5 = this.this$0.mContentTopPadding;
            if (topPadding > i5) {
                int topPadding2 = windowInset.getTopPadding();
                i6 = this.this$0.mContentTopPadding;
                top = topPadding2 - i6;
            } else {
                top = windowInset.getTopPadding();
            }
        } else {
            top = 0;
        }
        if (windowInset.getRightPadding() > 0) {
            int rightPadding = windowInset.getRightPadding();
            i3 = this.this$0.mContentRightPadding;
            if (rightPadding > i3) {
                int rightPadding2 = windowInset.getRightPadding();
                i4 = this.this$0.mContentRightPadding;
                right = rightPadding2 - i4;
            } else {
                right = windowInset.getRightPadding();
            }
        } else {
            right = 0;
        }
        if (windowInset.getBottomPadding() > 0) {
            int bottomPadding = windowInset.getBottomPadding();
            i = this.this$0.mContentBottomPadding;
            if (bottomPadding > i) {
                int bottomPadding2 = windowInset.getBottomPadding();
                i2 = this.this$0.mContentBottomPadding;
                bottom = bottomPadding2 - i2;
            } else {
                bottom = windowInset.getBottomPadding();
            }
        }
        this.this$0.setPadding(left, top, right, bottom);
    }
}