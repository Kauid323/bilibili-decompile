package tv.danmaku.bili.ui.main2.basic.dialog.top;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageBubble;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: TopTabBubblePopWindow.kt */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u000f\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubblePopWindow;", "Landroid/widget/PopupWindow;", "anchor", "Landroid/view/View;", "drawable", "Landroid/graphics/drawable/Drawable;", "item", "Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;", "<init>", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;)V", "getItem", "()Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageBubble;", "mDismissRunnable", "Ljava/lang/Runnable;", "mLifecycleListener", "tv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubblePopWindow$mLifecycleListener$1", "Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubblePopWindow$mLifecycleListener$1;", "imageHeight", "", "imageWidth", ReportEvent.EVENT_TYPE_SHOW, "", "hasEnoughSpace", "", "dismiss", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopTabBubblePopWindow extends PopupWindow {
    public static final int $stable = 8;
    private final View anchor;
    private final int imageHeight;
    private final int imageWidth;
    private final SecondaryPageBubble item;
    private final Runnable mDismissRunnable;
    private final TopTabBubblePopWindow$mLifecycleListener$1 mLifecycleListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v5, types: [tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubblePopWindow$mLifecycleListener$1] */
    public TopTabBubblePopWindow(View anchor, Drawable drawable, SecondaryPageBubble item) {
        super(anchor.getContext());
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(item, "item");
        this.anchor = anchor;
        this.item = item;
        this.mDismissRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubblePopWindow$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TopTabBubblePopWindow.this.dismiss();
            }
        };
        this.mLifecycleListener = new LifecycleEventObserver() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubblePopWindow$mLifecycleListener$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_PAUSE) {
                    TopTabBubblePopWindow.this.dismiss();
                    source.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            }
        };
        this.imageHeight = ListExtentionsKt.toPx(70);
        this.imageWidth = (int) (this.imageHeight * (drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()));
        setContentView(LayoutInflater.from(this.anchor.getContext()).inflate(R.layout.bili_app_home_publish_popup_item, (ViewGroup) null, false));
        View findViewById = getContentView().findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ImageView image = (ImageView) findViewById;
        image.setImageDrawable(drawable);
        setWidth(this.imageWidth);
        setHeight(this.imageHeight);
        image.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabBubblePopWindow$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopTabBubblePopWindow._init_$lambda$0(TopTabBubblePopWindow.this, view);
            }
        });
        setAnimationStyle(R.style.TopTabGuidePopup);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
    }

    public final SecondaryPageBubble getItem() {
        return this.item;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(TopTabBubblePopWindow this$0, View it) {
        this$0.dismiss();
        BLRouter.routeTo$default(RouteRequestKt.toRouteRequest(this$0.item.getUrl()), (Context) null, 2, (Object) null);
        Neurons.reportClick(false, "main.homepage.top-tabbar.popup.click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to(BaseFavoritesFragment.TAB, this$0.item.getTitle()), TuplesKt.to("popup_type", "2")}));
    }

    public final void show() {
        BLog.i("TopTabBubblePopWindow", "show TopTabBubblePopWindow");
        if (!ListExtentionsKt.checkIsVisible$default(this.anchor, "TopTabBubblePopWindow", false, 4, (Object) null)) {
            dismiss();
        } else if (!hasEnoughSpace()) {
            BLog.i("TopTabBubblePopWindow", "image has not enough space to show");
            dismiss();
        } else {
            PopupWindowCompat.showAsDropDown(this, this.anchor, (this.anchor.getWidth() - this.imageWidth) / 2, 0, 80);
            Context context = this.anchor.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Lifecycle lifecycle = ListExtentionsKt.lifecycle(context);
            if (lifecycle != null) {
                lifecycle.addObserver(this.mLifecycleListener);
            }
            Neurons.reportExposure$default(false, "main.homepage.top-tabbar.popup.show", MapsKt.mapOf(new Pair[]{TuplesKt.to(BaseFavoritesFragment.TAB, this.item.getTitle()), TuplesKt.to("popup_type", "2")}), (List) null, 8, (Object) null);
            HandlerThreads.postDelayed(0, this.mDismissRunnable, TopTabBubbleDialogWrapperKt.getMTopTabBubbleConfig().getDialogShowTimeMillis());
            TopTabBubbleDialogWrapperKt.saveItemShowHistory(this.item);
            TopTabBubbleDialogWrapperKt.saveShowTimesInSevenDays();
        }
    }

    private final boolean hasEnoughSpace() {
        Rect rect = new Rect();
        this.anchor.getGlobalVisibleRect(rect);
        int anchorMid = (rect.left + rect.right) >> 1;
        int imageMid = this.imageWidth >> 1;
        return anchorMid > imageMid && anchorMid + imageMid < this.anchor.getRootView().getWidth();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(this);
        TopTabBubbleMainDialogKt.showNextDialog();
    }
}