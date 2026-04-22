package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserver;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.ControlContainerObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: DetailsShareAnimView.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0002\u0017\u001e\u0018\u00002\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0014J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\rR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006$"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/DetailsShareAnimView;", "Ltv/danmaku/bili/videopage/common/widget/view/ShareAnimView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mExtClickListener", "Ltv/danmaku/bili/videopage/common/widget/view/DetailsShareAnimView$ShareViewStateCallback;", "mShareChannel", "", "mGuideWay", "mDefaultReport", "", "mStrategyStartTime", "", "mStrategy", "mControlContainerObserver", "tv/danmaku/bili/videopage/common/widget/view/DetailsShareAnimView$mControlContainerObserver$1", "Ltv/danmaku/bili/videopage/common/widget/view/DetailsShareAnimView$mControlContainerObserver$1;", "onShareClicked", "", "reportShareClick", "reportShareShow", "mShareIconListener", "tv/danmaku/bili/videopage/common/widget/view/DetailsShareAnimView$mShareIconListener$1", "Ltv/danmaku/bili/videopage/common/widget/view/DetailsShareAnimView$mShareIconListener$1;", "onAttachedToWindow", "setViewStateCallback", "listener", "ShareViewStateCallback", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DetailsShareAnimView extends ShareAnimView {
    private final DetailsShareAnimView$mControlContainerObserver$1 mControlContainerObserver;
    private boolean mDefaultReport;
    private ShareViewStateCallback mExtClickListener;
    private String mGuideWay;
    private String mShareChannel;
    private final DetailsShareAnimView$mShareIconListener$1 mShareIconListener;
    private int mStrategy;
    private long mStrategyStartTime;

    /* compiled from: DetailsShareAnimView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/DetailsShareAnimView$ShareViewStateCallback;", "", "onShareViewClick", "", "channel", "", "strategy", "", "time", "onShareViewShow", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ShareViewStateCallback {
        void onShareViewClick(String str, int i, String str2);

        void onShareViewShow(String str, int i, String str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DetailsShareAnimView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DetailsShareAnimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v3, types: [tv.danmaku.bili.videopage.common.widget.view.DetailsShareAnimView$mControlContainerObserver$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [tv.danmaku.bili.videopage.common.widget.view.DetailsShareAnimView$mShareIconListener$1] */
    public DetailsShareAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mShareChannel = "default";
        this.mGuideWay = "0";
        this.mControlContainerObserver = new ControlContainerObserver() { // from class: tv.danmaku.bili.videopage.common.widget.view.DetailsShareAnimView$mControlContainerObserver$1
            @Override // tv.danmaku.biliplayerv2.service.ControlContainerObserver
            public void onControlContainerChanged(ControlContainerType state, ScreenModeType screenType) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(screenType, "screenType");
                if (screenType == ScreenModeType.LANDSCAPE_FULLSCREEN || screenType == ScreenModeType.VERTICAL_FULLSCREEN) {
                    DetailsShareAnimView.this.tryStopKeepAnim();
                } else {
                    DetailsShareAnimView.this.tryStartKeepAnim();
                }
            }
        };
        this.mShareIconListener = new ShareIconObserver() { // from class: tv.danmaku.bili.videopage.common.widget.view.DetailsShareAnimView$mShareIconListener$1
            @Override // tv.danmaku.bili.videopage.common.callback.ShareIconObserver
            public void onShareIconChanged(String channel, String picture, int startTime, int displayTime, String from, int strategy) {
                Intrinsics.checkNotNullParameter(from, "from");
                if (TextUtils.equals(from, "all") || TextUtils.equals(from, "half")) {
                    DetailsShareAnimView.this.mShareChannel = channel == null ? "default" : channel;
                    DetailsShareAnimView.this.mGuideWay = String.valueOf(startTime);
                    if (strategy > 1) {
                        DetailsShareAnimView.this.mStrategyStartTime = SystemClock.elapsedRealtime();
                    }
                    DetailsShareAnimView.this.mStrategy = strategy;
                    DetailsShareAnimView.this.shareIconChanged(channel, picture, displayTime);
                    DetailsShareAnimView.this.reportShareShow();
                }
            }

            @Override // tv.danmaku.bili.videopage.common.callback.ShareIconObserver
            public void onResetShareIcon() {
                DetailsShareAnimView.this.resetChannelIcon();
            }
        };
    }

    @Override // tv.danmaku.bili.videopage.common.widget.view.ShareAnimView
    public void onShareClicked() {
        reportShareClick();
    }

    private final void reportShareClick() {
        if (this.mStrategy > 1) {
            this.mGuideWay = String.valueOf((SystemClock.elapsedRealtime() - this.mStrategyStartTime) / ((long) IjkMediaCodecInfo.RANK_MAX));
        }
        ShareViewStateCallback shareViewStateCallback = this.mExtClickListener;
        if (shareViewStateCallback != null) {
            shareViewStateCallback.onShareViewClick(this.mShareChannel, this.mStrategy, this.mGuideWay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportShareShow() {
        if (TextUtils.equals(this.mShareChannel, "default") && this.mDefaultReport) {
            return;
        }
        this.mDefaultReport = true;
        if (this.mStrategy > 1) {
            this.mGuideWay = "0";
        }
        ShareViewStateCallback shareViewStateCallback = this.mExtClickListener;
        if (shareViewStateCallback != null) {
            shareViewStateCallback.onShareViewShow(this.mShareChannel, this.mStrategy, this.mGuideWay);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.videopage.common.widget.view.ShareAnimView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        reportShareShow();
    }

    public final void setViewStateCallback(ShareViewStateCallback listener) {
        this.mExtClickListener = listener;
    }
}