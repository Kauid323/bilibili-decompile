package tv.danmaku.bili.ui.main2.basic.dialog.publish;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.moduleservice.upper.UperLogInterface;
import com.bilibili.moduleservice.upper.UpperCenterPlusBubbleService;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.basic.TabHostGarbProviderKt;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: PublishBubblePopupWindow.kt */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0010\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubblePopupWindow;", "Landroid/widget/PopupWindow;", "item", "Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;", "anchor", "Landroid/view/View;", "originTabUrl", "", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Lcom/bilibili/moduleservice/upper/UpperCenterPlusBubbleService$BubbleInfo;Landroid/view/View;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "mDismissRunnable", "Ljava/lang/Runnable;", "removeShowingPopupItemRunnable", "mLifecycleListener", "tv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubblePopupWindow$mLifecycleListener$1", "Ltv/danmaku/bili/ui/main2/basic/dialog/publish/PublishBubblePopupWindow$mLifecycleListener$1;", "bottomNavigationHeight", "", "h", "w", ReportEvent.EVENT_TYPE_SHOW, "", "dismiss", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PublishBubblePopupWindow extends PopupWindow {
    public static final int $stable = 8;
    private final View anchor;
    private final int bottomNavigationHeight;
    private final int h;
    private final UpperCenterPlusBubbleService.BubbleInfo item;
    private final Runnable mDismissRunnable;
    private final PublishBubblePopupWindow$mLifecycleListener$1 mLifecycleListener;
    private final String originTabUrl;
    private final Runnable removeShowingPopupItemRunnable;
    private final int w;

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v6, types: [tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindow$mLifecycleListener$1] */
    public PublishBubblePopupWindow(UpperCenterPlusBubbleService.BubbleInfo item, View anchor, String originTabUrl, Drawable drawable) {
        super(anchor.getContext());
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.item = item;
        this.anchor = anchor;
        this.originTabUrl = originTabUrl;
        this.mDismissRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindow$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PublishBubblePopupWindow.this.dismiss();
            }
        };
        this.removeShowingPopupItemRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindow$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PublishBubblePopupWindowKt.access$setShowingPopupItem$p(null);
            }
        };
        this.mLifecycleListener = new LifecycleEventObserver() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindow$mLifecycleListener$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_PAUSE) {
                    PublishBubblePopupWindow.this.dismiss();
                    source.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            }
        };
        this.bottomNavigationHeight = ListExtentionsKt.toPx(48);
        this.h = ListExtentionsKt.toPx(70);
        this.w = (int) (this.h * (drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()));
        setContentView(LayoutInflater.from(this.anchor.getContext()).inflate(R.layout.bili_app_home_publish_popup_item, (ViewGroup) null, false));
        View findViewById = getContentView().findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ImageView image = (ImageView) findViewById;
        image.setImageDrawable(drawable);
        setWidth(this.w);
        setHeight(this.h);
        image.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindow$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishBubblePopupWindow._init_$lambda$0(PublishBubblePopupWindow.this, view);
            }
        });
        setAnimationStyle(R.style.PublishGuidePopup);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(final PublishBubblePopupWindow this$0, final View it) {
        String url;
        this$0.dismiss();
        if (PublishBubblePopupWindowKt.getShowingPopupItem() != null) {
            if (this$0.item.getRouteUrl().length() > 0) {
                url = this$0.item.getRouteUrl();
                RouteRequest request = new RouteRequest.Builder(url).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindow$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return PublishBubblePopupWindow.lambda$0$0(it, this$0, (MutableBundleLike) obj);
                    }
                }).build();
                BLRouter.routeTo$default(request, (Context) null, 2, (Object) null);
            }
        }
        url = this$0.originTabUrl;
        if (url == null) {
            url = "";
        }
        RouteRequest request2 = new RouteRequest.Builder(url).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.publish.PublishBubblePopupWindow$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return PublishBubblePopupWindow.lambda$0$0(it, this$0, (MutableBundleLike) obj);
            }
        }).build();
        BLRouter.routeTo$default(request2, (Context) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002d, code lost:
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit lambda$0$0(View $it, PublishBubblePopupWindow this$0, MutableBundleLike $this$extras) {
        String str;
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("center_plus_type", "1");
        UperLogInterface uperLogInterface = (UperLogInterface) BLRouter.get$default(BLRouter.INSTANCE, UperLogInterface.class, (String) null, 2, (Object) null);
        if (uperLogInterface != null) {
            Context context = $it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            str = uperLogInterface.generateTrackId(context, this$0.item.getUrl());
        }
        str = "";
        $this$extras.put("track_id", str);
        if (PublishBubblePopupWindowKt.getShowingPopupItem() != null) {
            $this$extras.put("strategy_id", this$0.item.getStrategyId());
            $this$extras.put("resource_id", this$0.item.getResourceId());
        }
        return Unit.INSTANCE;
    }

    public final void show() {
        long showTime;
        long showTime2;
        long removeTime;
        long showTime3;
        PublishBubblePopupWindowKt.showingPopupItem = this.item;
        BLog.i(TabHostGarbProviderKt.TAG, "show PublishBubblePopupWindow");
        showAsDropDown(this.anchor, (this.anchor.getWidth() - this.w) / 2, -(this.h + this.bottomNavigationHeight));
        Runnable runnable = this.mDismissRunnable;
        showTime = PublishBubblePopupWindowKt.getShowTime();
        HandlerThreads.postDelayed(0, runnable, showTime);
        PublishBubbleDialogKt.recordShowHistory(this.item.getId());
        Neurons.reportExposure$default(false, "main.homepage.bottombar-bubble.0.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("bubble_id", this.item.getId()), TuplesKt.to("text_id", this.item.getTitleId()), TuplesKt.to("text_content", this.item.getTitle() + "_" + this.item.getSubtitle()), TuplesKt.to("strategy_id", this.item.getStrategyId()), TuplesKt.to("resource_id", this.item.getResourceId()), TuplesKt.to("resource_result_type", this.item.getResourceType())}), (List) null, 8, (Object) null);
        UpperCenterPlusBubbleService upperCenterPlusBubbleService = (UpperCenterPlusBubbleService) BLRouter.get$default(BLRouter.INSTANCE, UpperCenterPlusBubbleService.class, (String) null, 2, (Object) null);
        if (upperCenterPlusBubbleService != null) {
            removeTime = upperCenterPlusBubbleService.bubbleAvailableDuration-UwyO8pc();
        } else {
            Duration.Companion companion = Duration.Companion;
            showTime2 = PublishBubblePopupWindowKt.getShowTime();
            removeTime = DurationKt.toDuration(showTime2, DurationUnit.MILLISECONDS);
        }
        Runnable runnable2 = this.removeShowingPopupItemRunnable;
        Duration duration = Duration.box-impl(removeTime);
        Duration.Companion companion2 = Duration.Companion;
        showTime3 = PublishBubblePopupWindowKt.getShowTime();
        HandlerThreads.postDelayed(0, runnable2, Duration.toLong-impl(RangesKt.coerceAtMost(duration, Duration.box-impl(DurationKt.toDuration(showTime3, DurationUnit.MILLISECONDS))).unbox-impl(), DurationUnit.MILLISECONDS));
        UpperCenterPlusBubbleService upperCenterPlusBubbleService2 = (UpperCenterPlusBubbleService) BLRouter.get$default(BLRouter.INSTANCE, UpperCenterPlusBubbleService.class, (String) null, 2, (Object) null);
        if (upperCenterPlusBubbleService2 != null) {
            upperCenterPlusBubbleService2.bubbleExposure(this.item);
        }
        Context context = this.anchor.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Lifecycle lifecycle = ListExtentionsKt.lifecycle(context);
        if (lifecycle != null) {
            lifecycle.addObserver(this.mLifecycleListener);
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(this);
        PublishBubbleDialogKt.showNextDialog();
        Context context = this.anchor.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Lifecycle lifecycle = ListExtentionsKt.lifecycle(context);
        if (lifecycle != null) {
            lifecycle.removeObserver(this.mLifecycleListener);
        }
        HandlerThreads.remove(0, this.mDismissRunnable);
    }
}