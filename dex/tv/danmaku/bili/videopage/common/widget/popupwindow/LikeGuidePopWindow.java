package tv.danmaku.bili.videopage.common.widget.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.util.HashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public class LikeGuidePopWindow extends PopupWindow {
    private Context mContext;
    private Runnable mTimeRunnable;
    private String mType;
    private SVGAImageView svgaImageView;

    public LikeGuidePopWindow(Context context) {
        super(context);
        this.mTimeRunnable = new Runnable() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeGuidePopWindow.1
            @Override // java.lang.Runnable
            public void run() {
                LikeGuidePopWindow.this.mType = "0";
                if (LikeGuidePopWindow.this.mContext != null) {
                    LikeGuidePopWindow.this.dismiss();
                }
            }
        };
        this.mType = "2";
        this.mContext = context;
        this.svgaImageView = new SVGAImageView(context);
        this.svgaImageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeGuidePopWindow$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LikeGuidePopWindow.this.m1974lambda$new$0$tvdanmakubilivideopagecommonwidgetpopupwindowLikeGuidePopWindow(view2);
            }
        });
        setContentView(this.svgaImageView);
        setWidth(dp2px(this.mContext, 252.0f));
        setHeight(dp2px(this.mContext, 96.0f));
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setClippingEnabled(false);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$tv-danmaku-bili-videopage-common-widget-popupwindow-LikeGuidePopWindow  reason: not valid java name */
    public /* synthetic */ void m1974lambda$new$0$tvdanmakubilivideopagecommonwidgetpopupwindowLikeGuidePopWindow(View v) {
        this.mType = "1";
        dismiss();
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
        super.dismiss();
    }

    private int dp2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }

    public void show(View anchor) {
        HandlerThreads.postDelayed(0, this.mTimeRunnable, (long) PlayerToastConfig.DURATION_5);
        startAnimator();
        showAsDropDown(anchor, -dp2px(this.mContext, 39.0f), (-anchor.getMeasuredHeight()) - dp2px(this.mContext, 99.0f));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        HandlerThreads.remove(0, this.mTimeRunnable);
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(this);
        report();
    }

    private void report() {
        Map<String, String> params = new HashMap<>();
        params.put("type", this.mType);
        params.put("page", "1");
        Neurons.reportExposure(false, EventId.player_neuron_nulogin_tip_show, params);
    }

    private void startAnimator() {
        String resource;
        SVGAParser parser = new SVGAParser(this.mContext);
        if (MultipleThemeUtils.isNightTheme(this.mContext)) {
            resource = "bili_player_guide_tip_dark.svga";
        } else {
            resource = "bili_player_guide_tip_normal.svga";
        }
        parser.parse(resource, new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeGuidePopWindow.2
            public void onComplete(SVGAVideoEntity videoItem) {
                LikeGuidePopWindow.this.svgaImageView.setVideoItem(videoItem);
                LikeGuidePopWindow.this.svgaImageView.setLoops(1);
                LikeGuidePopWindow.this.svgaImageView.setCallback(new SVGACallback() { // from class: tv.danmaku.bili.videopage.common.widget.popupwindow.LikeGuidePopWindow.2.1
                    public void onPreStart() {
                    }

                    public void onPause() {
                    }

                    public void onFinished() {
                    }

                    public void onRepeat() {
                    }

                    public void onStep(int i, double v) {
                    }
                });
                LikeGuidePopWindow.this.svgaImageView.setClearsAfterStop(false);
                LikeGuidePopWindow.this.svgaImageView.stepToFrame(0, true);
            }

            public void onError() {
            }

            public void onCacheExist() {
            }
        });
    }
}