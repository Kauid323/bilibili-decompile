package tv.danmaku.bili.videopage.common.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.common.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ShareGuideBubble.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0003J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000bJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001f\u001a\u00020\rJ\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0011H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/ShareGuideBubble;", "", "<init>", "()V", "mAnimator", "Landroid/animation/AnimatorSet;", "mPopupWindow", "Landroid/widget/PopupWindow;", "mListener", "Ltv/danmaku/bili/videopage/common/widget/ShareGuideBubble$ShareGuideBubbleTouchListener;", "mShareChannel", "", "mShowStartTime", "", "mShowEndTime", "mShowLongestTime", "showInner", "", "anchor", "Landroid/view/View;", "times", "", "msg", "icon", "setShowAnim", "context", "Landroid/content/Context;", "view", "setShareChannel", "channel", "getShareChannel", "getDurationTime", "dismiss", "isShowing", "", "cancelAnimator", "setListener", "listener", "Companion", "ShareGuideBubbleTouchListener", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ShareGuideBubble {
    public static final Companion Companion = new Companion(null);
    private static final long END_TIME = 300;
    private static final long INTERVAL_TIME = 30;
    private static final long ONCE_TIME = 1000;
    private static final long START_TIME = 300;
    private static final long TOLERANCE_TIME = 500;
    private AnimatorSet mAnimator;
    private ShareGuideBubbleTouchListener mListener;
    private PopupWindow mPopupWindow;
    private String mShareChannel;
    private long mShowEndTime;
    private long mShowLongestTime;
    private long mShowStartTime;

    /* compiled from: ShareGuideBubble.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/ShareGuideBubble$ShareGuideBubbleTouchListener;", "", "onTouched", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ShareGuideBubbleTouchListener {
        void onTouched();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInner(View anchor, int times, String msg, String icon) {
        Context context = anchor.getContext();
        View view2 = LayoutInflater.from(context).inflate(R.layout.bili_app_share_guide_bubble_layout, (ViewGroup) null, false);
        PopupWindow popup = new PopupWindow(view2);
        view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.videopage.common.widget.ShareGuideBubble$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ShareGuideBubble.showInner$lambda$0(ShareGuideBubble.this, view3);
            }
        });
        TextView textView = (TextView) view2.findViewById(R.id.message);
        textView.setText(msg);
        BiliImageView iconView = view2.findViewById(R.id.share_icon);
        if (iconView != null) {
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Intrinsics.checkNotNull(context);
            biliImageLoader.with(context).url(icon).into(iconView);
        }
        popup.setWidth(-2);
        popup.setHeight(-2);
        popup.setBackgroundDrawable(new ColorDrawable(0));
        popup.setOutsideTouchable(true);
        this.mPopupWindow = popup;
        popup.getContentView().measure(-2, -2);
        int tranY = (int) (-DpUtils.dp2px(context, 50.0f));
        int[] viewLocation = new int[2];
        anchor.getLocationInWindow(viewLocation);
        int screenX = ScreenUtil.getScreenWidth(context);
        int tranX = (int) (((screenX - viewLocation[0]) - (anchor.getWidth() / 2)) - DpUtils.dp2px(context, 35.0f));
        view2.setPivotX(view2.getMeasuredWidth() - DpUtils.dp2px(context, 15.0f));
        view2.setPivotY(view2.getMeasuredHeight());
        try {
            this.mShowStartTime = System.currentTimeMillis();
            try {
                this.mShowLongestTime = (times * 1000) + 300 + 90 + 300 + 500;
                view2.setVisibility(8);
                view2.setScaleX(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                view2.setScaleY(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
                popup.showAtLocation(anchor, 8388661, tranX, viewLocation[1] + tranY);
                Context context2 = anchor.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                Intrinsics.checkNotNull(view2);
                setShowAnim(context2, view2, times);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInner$lambda$0(ShareGuideBubble this$0, View it) {
        ShareGuideBubbleTouchListener shareGuideBubbleTouchListener = this$0.mListener;
        if (shareGuideBubbleTouchListener != null) {
            shareGuideBubbleTouchListener.onTouched();
        }
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(Object popup) {
        Intrinsics.checkNotNullParameter(popup, "popup");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("PopupWindow.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "PopupWindow.dismiss() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new AppCompatDelegateImpl$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((PopupWindow) popup).dismiss();
    }

    private final void setShowAnim(Context context, View view2, int times) {
        AnimatorSet animatorSet;
        if (times <= 0) {
            return;
        }
        AnimatorSet animatorSet2 = this.mAnimator;
        if ((animatorSet2 != null && animatorSet2.isRunning()) && (animatorSet = this.mAnimator) != null) {
            animatorSet.end();
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        ObjectAnimator startScaleX = ObjectAnimator.ofFloat(view2, "scaleX", DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        startScaleX.setDuration(300L);
        startScaleX.setStartDelay(30L);
        ObjectAnimator startScaleY = ObjectAnimator.ofFloat(view2, "scaleY", DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        startScaleY.setDuration(300L);
        startScaleY.setStartDelay(30L);
        float distance = DpUtils.dp2px(context, 4.0f);
        ObjectAnimator transAnim = ObjectAnimator.ofFloat(view2, "translationY", DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, distance, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        transAnim.setDuration(1000L);
        transAnim.setRepeatCount(times);
        transAnim.setStartDelay(360L);
        ObjectAnimator endScaleX = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        endScaleX.setDuration(300L);
        endScaleX.setStartDelay((times * 1000) + 300 + 90);
        ObjectAnimator endScaleY = ObjectAnimator.ofFloat(view2, "scaleY", 1.0f, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        endScaleY.setDuration(300L);
        endScaleY.setStartDelay((times * 1000) + 300 + 90);
        view2.setVisibility(0);
        animatorSet3.playTogether(startScaleX, startScaleY, transAnim, endScaleX, endScaleY);
        animatorSet3.start();
        this.mAnimator = animatorSet3;
    }

    public final void setShareChannel(String channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mShareChannel = channel;
    }

    public final String getShareChannel() {
        return this.mShareChannel;
    }

    public final long getDurationTime() {
        long interval = this.mShowEndTime - this.mShowStartTime;
        if (interval < 0 || interval > this.mShowLongestTime) {
            return 0L;
        }
        return interval;
    }

    public final void dismiss() {
        this.mShowEndTime = System.currentTimeMillis();
        cancelAnimator();
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWindow);
        }
    }

    public final boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    private final void cancelAnimator() {
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.mAnimator = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setListener(ShareGuideBubbleTouchListener listener) {
        this.mListener = listener;
    }

    /* compiled from: ShareGuideBubble.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/ShareGuideBubble$Companion;", "", "<init>", "()V", "show", "Ltv/danmaku/bili/videopage/common/widget/ShareGuideBubble;", "anchor", "Landroid/view/View;", "times", "", "msg", "", "icon", "listener", "Ltv/danmaku/bili/videopage/common/widget/ShareGuideBubble$ShareGuideBubbleTouchListener;", "START_TIME", "", "END_TIME", "ONCE_TIME", "INTERVAL_TIME", "TOLERANCE_TIME", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShareGuideBubble show(View anchor, int times, String msg, String icon, ShareGuideBubbleTouchListener listener) {
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(listener, "listener");
            ShareGuideBubble bubble = new ShareGuideBubble();
            bubble.showInner(anchor, times, msg, icon);
            bubble.setListener(listener);
            return bubble;
        }
    }
}