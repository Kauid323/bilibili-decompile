package tv.danmaku.bili.ui.main2.basic.story;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.core.widget.PopupWindowCompat;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.homepage.HomeVideoShortCutService;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: StoryEntranceClickGuidance.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/story/StoryEntranceClickGuidance;", "Landroid/widget/PopupWindow;", "titleStrRes", "", "<init>", "(I)V", "mDismissRunnable", "Ljava/lang/Runnable;", "initView", "", "anchor", "Landroid/view/View;", ReportEvent.EVENT_TYPE_SHOW, "dismiss", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StoryEntranceClickGuidance extends PopupWindow {
    public static final int $stable = 8;
    private final Runnable mDismissRunnable;
    private final int titleStrRes;

    public StoryEntranceClickGuidance() {
        this(0, 1, null);
    }

    public StoryEntranceClickGuidance(int titleStrRes) {
        this.titleStrRes = titleStrRes;
        this.mDismissRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.story.StoryEntranceClickGuidance$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StoryEntranceClickGuidance.this.dismiss();
            }
        };
    }

    public /* synthetic */ StoryEntranceClickGuidance(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    private final void initView(View anchor) {
        setContentView(LayoutInflater.from(anchor.getContext()).inflate(R.layout.bili_app_home_story_entrance_guide, (ViewGroup) null));
        setWidth(-2);
        setHeight(-2);
        setOutsideTouchable(true);
        setSoftInputMode(2);
        setBackgroundDrawable(new ColorDrawable());
        View findViewById = getContentView().findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView title = (TextView) findViewById;
        if (this.titleStrRes == 0) {
            HomeVideoShortCutService homeVideoShortCutService = (HomeVideoShortCutService) BLRouter.get$default(BLRouter.INSTANCE, HomeVideoShortCutService.class, (String) null, 2, (Object) null);
            if (Intrinsics.areEqual(homeVideoShortCutService != null ? homeVideoShortCutService.getCurrentTab() : null, "PAGER_STORY")) {
                title.setText(bili.resource.homepage.R.string.homepage_global_string_39);
                return;
            } else {
                title.setText(bili.resource.homepage.R.string.homepage_global_string_58);
                return;
            }
        }
        title.setText(this.titleStrRes);
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

    public final void show(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setAnimationStyle(R.style.HomeStoryEntranceGuidePopup);
        initView(anchor);
        PopupWindowCompat.showAsDropDown(this, anchor, ListExtentionsKt.toPx(-4), ListExtentionsKt.toPx(-6), 8388611);
        SharedPreferences sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(anchor.getContext());
        if (this.titleStrRes == 0) {
            int showTimes = sp.getInt("SP_HOME_STORY_ENTRANCE_SHOW_TIMES", 0);
            sp.edit().putInt("SP_HOME_STORY_ENTRANCE_SHOW_TIMES", showTimes + 1).apply();
            StoryEntranceClickGuidanceKt.access$setGuidanceShown$p(true);
        } else {
            sp.edit().putBoolean("SP_HOME_STORY_INDEPENDENT_GUIDANCE_SHOW", true).apply();
        }
        HandlerThreads.getHandler(0).postDelayed(this.mDismissRunnable, 3000L);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(this);
        HandlerThreads.getHandler(0).removeCallbacks(this.mDismissRunnable);
    }
}