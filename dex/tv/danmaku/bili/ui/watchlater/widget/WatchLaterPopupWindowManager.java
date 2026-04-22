package tv.danmaku.bili.ui.watchlater.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterAddToast;
import tv.danmaku.bili.ui.watchlater.utils.ReportHelperKt;
import tv.danmaku.biliplayerv2.utils.NavigationHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterPopupWindowManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/widget/WatchLaterPopupWindowManager;", "", "<init>", "()V", "SHOW_TIME", "", "popupWindow", "Landroid/widget/PopupWindow;", "showToast", "", "activity", "Landroid/app/Activity;", "toast", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterAddToast;", "resources", "", "spmid", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "offset", "", "style", "generatePopupWindow", "handleUI", "dismissToast", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterPopupWindowManager {
    private static final long SHOW_TIME = 4000;
    private static PopupWindow popupWindow;
    public static final WatchLaterPopupWindowManager INSTANCE = new WatchLaterPopupWindowManager();
    public static final int $stable = 8;

    private WatchLaterPopupWindowManager() {
    }

    public static /* synthetic */ void showToast$default(WatchLaterPopupWindowManager watchLaterPopupWindowManager, Activity activity, WatchLaterAddToast watchLaterAddToast, String str, String str2, LifecycleOwner lifecycleOwner, int i, int i2, int i3, Object obj) {
        int i4;
        int i5;
        if ((i3 & 32) == 0) {
            i4 = i;
        } else {
            i4 = 60;
        }
        if ((i3 & 64) == 0) {
            i5 = i2;
        } else {
            i5 = 0;
        }
        watchLaterPopupWindowManager.showToast(activity, watchLaterAddToast, str, str2, lifecycleOwner, i4, i5);
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

    public final void showToast(final Activity activity, final WatchLaterAddToast toast, final String resources, final String spmid, final LifecycleOwner lifecycleOwner, int offset, int style) {
        View contentView;
        View findViewById;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(toast, "toast");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        if (popupWindow != null) {
            PopupWindow popupWindow2 = popupWindow;
            if (popupWindow2 != null) {
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWindow2);
            }
            popupWindow = null;
        }
        if (activity == null) {
            return;
        }
        popupWindow = generatePopupWindow(activity, style);
        handleUI(toast, activity, style);
        PopupWindow popupWindow3 = popupWindow;
        if (popupWindow3 != null) {
            popupWindow3.showAtLocation(activity.findViewById(16908290), 80, 0, ListExtentionsKt.toPx(offset - 4) + NavigationHelper.INSTANCE.getNavigationHeight(activity));
        }
        final Runnable dismissTask = new Runnable() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterPopupWindowManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WatchLaterPopupWindowManager.showToast$lambda$0();
            }
        };
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterPopupWindowManager$$ExternalSyntheticLambda2
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                WatchLaterPopupWindowManager.showToast$lambda$1(lifecycleOwner2, event);
            }
        };
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(lifecycleObserver);
        }
        PopupWindow popupWindow4 = popupWindow;
        if (popupWindow4 != null) {
            popupWindow4.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterPopupWindowManager$$ExternalSyntheticLambda3
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    WatchLaterPopupWindowManager.showToast$lambda$2(dismissTask, lifecycleOwner, lifecycleObserver);
                }
            });
        }
        HandlerThreads.postDelayed(0, dismissTask, 4000L);
        ReportHelperKt.reportWatchLaterToastShow(toast.getToast(), resources, spmid);
        PopupWindow popupWindow5 = popupWindow;
        if (popupWindow5 == null || (contentView = popupWindow5.getContentView()) == null || (findViewById = contentView.findViewById(R.id.container)) == null) {
            return;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterPopupWindowManager$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WatchLaterPopupWindowManager.showToast$lambda$3(WatchLaterAddToast.this, activity, resources, spmid, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$0() {
        INSTANCE.dismissToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$1(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_PAUSE) {
            INSTANCE.dismissToast();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$2(Runnable $dismissTask, LifecycleOwner $lifecycleOwner, LifecycleEventObserver $observer) {
        Lifecycle lifecycle;
        HandlerThreads.remove(0, $dismissTask);
        if ($lifecycleOwner != null && (lifecycle = $lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver((LifecycleObserver) $observer);
        }
        popupWindow = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$3(WatchLaterAddToast $toast, Activity $activity, String $resources, String $spmid, View it) {
        String appJumpLink = $toast.getAppJumpLink();
        if (appJumpLink == null) {
            appJumpLink = "";
        }
        BLRouter.routeTo(new RouteRequest.Builder(appJumpLink).build(), $activity);
        ReportHelperKt.reportWatchLaterToastClick($toast.getToast(), $resources, $spmid);
        INSTANCE.dismissToast();
    }

    private final PopupWindow generatePopupWindow(Activity activity, int style) {
        View contentView = LayoutInflater.from(activity).inflate(style == 1 ? R.layout.bili_app_watch_later_toast_v2 : R.layout.bili_app_watch_later_toast, (ViewGroup) null);
        PopupWindow $this$generatePopupWindow_u24lambda_u240 = new PopupWindow(contentView, ScreenUtil.getScreenWidth(activity) - ListExtentionsKt.toPx(16), -2);
        $this$generatePopupWindow_u24lambda_u240.setOutsideTouchable(true);
        $this$generatePopupWindow_u24lambda_u240.setAnimationStyle(R.style.WatchLaterToastAnimation);
        return $this$generatePopupWindow_u24lambda_u240;
    }

    private final void handleUI(WatchLaterAddToast toast, Activity activity, int style) {
        View contentView;
        PopupWindow popupWindow2 = popupWindow;
        if (popupWindow2 == null || (contentView = popupWindow2.getContentView()) == null) {
            return;
        }
        TintTextView findViewById = contentView.findViewById(R.id.text_left);
        final TintTextView findViewById2 = contentView.findViewById(R.id.text_right);
        TintImageView icon = contentView.findViewById(R.id.icon);
        final ViewGroup container = (ViewGroup) contentView.findViewById(R.id.container);
        if (style != 1) {
            Drawable it = KtxKt.getAppCompatDrawable(activity, toast.getIconType() == 1 ? com.bilibili.iconfont.R.drawable.ref_checkmark_circle_fill_500 : com.bilibili.iconfont.R.drawable.ref_warning_report_circle_fill_500);
            if (it != null) {
                icon.setImageDrawable(it);
                icon.setImageTintList(toast.getIconType() == 1 ? com.bilibili.lib.theme.R.color.Brand_pink : com.bilibili.lib.theme.R.color.Graph_medium);
            }
        } else {
            Drawable it2 = KtxKt.getAppCompatDrawable(activity, com.bilibili.iconfont.R.drawable.ref_arrow_play_next_line_500);
            if (it2 != null) {
                icon.setImageDrawable(it2);
            }
        }
        ListExtentionsKt.setText((TextView) findViewById, toast.getToast());
        ListExtentionsKt.setText((TextView) findViewById2, toast.getJumpText());
        container.post(new Runnable() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterPopupWindowManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WatchLaterPopupWindowManager.handleUI$lambda$2(findViewById2, container);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUI$lambda$2(TintTextView $textRight, ViewGroup $container) {
        Rect $this$handleUI_u24lambda_u242_u240 = new Rect();
        $textRight.getHitRect($this$handleUI_u24lambda_u242_u240);
        $this$handleUI_u24lambda_u242_u240.right += ListExtentionsKt.toPx(4);
        $this$handleUI_u24lambda_u242_u240.left -= ListExtentionsKt.toPx(4);
        $this$handleUI_u24lambda_u242_u240.top -= ListExtentionsKt.toPx(10);
        $this$handleUI_u24lambda_u242_u240.bottom += ListExtentionsKt.toPx(10);
        $container.setTouchDelegate(new TouchDelegate($this$handleUI_u24lambda_u242_u240, (View) $textRight));
    }

    private final void dismissToast() {
        PopupWindow popupWindow2 = popupWindow;
        if (popupWindow2 != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWindow2);
        }
    }
}