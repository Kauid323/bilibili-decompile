package tv.danmaku.bili.appwidget.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bapis.bilibili.app.show.mixture.v1.GuideTip;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply;
import com.bilibili.app.comm.list.common.utils.NavigationBarCompatKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.util.HandlerThreads;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.appwidget.guide.utils.ReportHelperKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.biliplayerv2.NewPlayerUtilsKt;

/* compiled from: UPCardWidgetGuideDialog.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J*\u0010\u0015\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016H\u0016J\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/UPCardWidgetGuideDialog;", "Ltv/danmaku/bili/appwidget/guide/IWidgetGuideDialog;", "onConfirm", "Lkotlin/Function0;", "", "onCancel", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "popupWindow", "Landroid/widget/PopupWindow;", "configurationChangeListener", "Landroidx/core/util/Consumer;", "Landroid/content/res/Configuration;", "showDialog", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "reply", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;", "hideDialog", "setAction", "Lkotlin/Function1;", "", "initPopupWindow", "outsideTouchable", "initView", "tip", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideTip;", "dismiss", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UPCardWidgetGuideDialog implements IWidgetGuideDialog {
    private static final long SHOW_TIME = 30000;
    private static final String TAG = "UPCardWidgetGuideDialog";
    private Consumer<Configuration> configurationChangeListener;
    private final Function0<Unit> onCancel;
    private final Function0<Unit> onConfirm;
    private PopupWindow popupWindow;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UPCardWidgetGuideDialog(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        Intrinsics.checkNotNullParameter(function02, "onCancel");
        this.onConfirm = function0;
        this.onCancel = function02;
        this.configurationChangeListener = new Consumer() { // from class: tv.danmaku.bili.appwidget.guide.UPCardWidgetGuideDialog$$ExternalSyntheticLambda0
            public final void accept(Object obj) {
                UPCardWidgetGuideDialog.configurationChangeListener$lambda$0(UPCardWidgetGuideDialog.this, (Configuration) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configurationChangeListener$lambda$0(UPCardWidgetGuideDialog this$0, Configuration it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BLog.i(TAG, "dismiss cause configuration change");
        this$0.dismiss();
    }

    @Override // tv.danmaku.bili.appwidget.guide.IWidgetGuideDialog
    public void showDialog(final FragmentActivity activity, final GuideScene scene, WidgetGuideReply reply) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(reply, "reply");
        if (this.popupWindow != null) {
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWindow);
            }
            this.popupWindow = null;
        }
        String spmid = AutoAddWidgetSceneExtKt.spmid(scene);
        int offset = AutoAddWidgetSceneExtKt.offset(scene);
        this.popupWindow = initPopupWindow(activity, AutoAddWidgetSceneExtKt.outsideTouchable(scene));
        GuideTip tip = reply.getTip();
        Intrinsics.checkNotNullExpressionValue(tip, "getTip(...)");
        initView(tip);
        final Runnable dismissTask = new Runnable() { // from class: tv.danmaku.bili.appwidget.guide.UPCardWidgetGuideDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                UPCardWidgetGuideDialog.this.dismiss();
            }
        };
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: tv.danmaku.bili.appwidget.guide.UPCardWidgetGuideDialog$$ExternalSyntheticLambda4
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                UPCardWidgetGuideDialog.showDialog$lambda$1(UPCardWidgetGuideDialog.this, lifecycleOwner, event);
            }
        };
        activity.getLifecycle().addObserver(lifecycleObserver);
        activity.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: tv.danmaku.bili.appwidget.guide.UPCardWidgetGuideDialog$showDialog$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_STOP) {
                    activity.getLifecycle().removeObserver(lifecycleObserver);
                    activity.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            }
        });
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: tv.danmaku.bili.appwidget.guide.UPCardWidgetGuideDialog$$ExternalSyntheticLambda5
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    UPCardWidgetGuideDialog.showDialog$lambda$2(activity, this, scene, dismissTask, lifecycleObserver);
                }
            });
        }
        try {
            PopupWindow popupWindow3 = this.popupWindow;
            if (popupWindow3 != null) {
                popupWindow3.showAtLocation(activity.findViewById(16908290), 80, 0, NewPlayerUtilsKt.toPx(offset) + NavigationBarCompatKt.getNavigationHeight((Activity) activity));
            }
        } catch (Exception e) {
            BLog.e(TAG, "showDialog error: " + e);
        }
        activity.addOnConfigurationChangedListener(this.configurationChangeListener);
        if (AutoAddWidgetSceneExtKt.autoDismiss(scene)) {
            HandlerThreads.postDelayed(0, dismissTask, (long) SHOW_TIME);
        }
        ReportHelperKt.reportGuideBannerShow(spmid, AutoAddWidgetSceneExtKt.type(scene), AutoAddWidgetSceneExtKt.contentId(scene));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$1(UPCardWidgetGuideDialog this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_STOP) {
            this$0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$2(FragmentActivity $activity, UPCardWidgetGuideDialog this$0, GuideScene $scene, Runnable $dismissTask, LifecycleEventObserver $observer) {
        $activity.removeOnConfigurationChangedListener(this$0.configurationChangeListener);
        if (AutoAddWidgetSceneExtKt.autoDismiss($scene)) {
            HandlerThreads.remove(0, $dismissTask);
        }
        $activity.getLifecycle().removeObserver((LifecycleObserver) $observer);
        this$0.popupWindow = null;
    }

    @Override // tv.danmaku.bili.appwidget.guide.IWidgetGuideDialog
    public void hideDialog() {
        dismiss();
    }

    @Override // tv.danmaku.bili.appwidget.guide.IWidgetGuideDialog
    public void setAction(Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        Intrinsics.checkNotNullParameter(function1, "onCancel");
    }

    static /* synthetic */ PopupWindow initPopupWindow$default(UPCardWidgetGuideDialog uPCardWidgetGuideDialog, FragmentActivity fragmentActivity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return uPCardWidgetGuideDialog.initPopupWindow(fragmentActivity, z);
    }

    private final PopupWindow initPopupWindow(FragmentActivity activity, boolean outsideTouchable) {
        View contentView = LayoutInflater.from((Context) activity).inflate(R.layout.bili_app_add_widget_guide_toast, (ViewGroup) null);
        PopupWindow $this$initPopupWindow_u24lambda_u240 = new PopupWindow(contentView, ScreenUtil.getScreenWidth((Context) activity) - NewPlayerUtilsKt.toPx(16), -2);
        $this$initPopupWindow_u24lambda_u240.setOutsideTouchable(outsideTouchable);
        $this$initPopupWindow_u24lambda_u240.setAnimationStyle(R.style.AddWidgetGuideToastAnimation);
        return $this$initPopupWindow_u24lambda_u240;
    }

    private final void initView(GuideTip tip) {
        View contentView;
        String titleText;
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null || (contentView = popupWindow.getContentView()) == null) {
            return;
        }
        TintTextView findViewById = contentView.findViewById(R.id.title);
        TintTextView findViewById2 = contentView.findViewById(R.id.sub_title);
        String title = tip.getTitle();
        if (title == null || StringsKt.isBlank(title)) {
            titleText = contentView.getContext().getString(bili.resource.homepage.R.string.homepage_global_string_213);
        } else {
            titleText = tip.getTitle();
        }
        ListExtentionsKt.setText((TextView) findViewById, titleText);
        ListExtentionsKt.setText((TextView) findViewById2, tip.getSubtitle());
        TintButton cancelBtn = contentView.findViewById(R.id.btn_cancel);
        TintTextView addBtn = contentView.findViewById(R.id.btn_add);
        cancelBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.appwidget.guide.UPCardWidgetGuideDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UPCardWidgetGuideDialog.initView$lambda$0(UPCardWidgetGuideDialog.this, view);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.appwidget.guide.UPCardWidgetGuideDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UPCardWidgetGuideDialog.initView$lambda$1(UPCardWidgetGuideDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(UPCardWidgetGuideDialog this$0, View it) {
        this$0.onCancel.invoke();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UPCardWidgetGuideDialog this$0, View it) {
        this$0.onConfirm.invoke();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        PopupWindow popupWindow = this.popupWindow;
        boolean z = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z = true;
        }
        if (z) {
            PopupWindow popupWindow2 = this.popupWindow;
            if (popupWindow2 != null) {
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(popupWindow2);
            }
            PopupWindow popupWindow3 = this.popupWindow;
            if (popupWindow3 != null) {
                popupWindow3.setOnDismissListener(null);
            }
        }
        this.popupWindow = null;
    }

    /* compiled from: UPCardWidgetGuideDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/UPCardWidgetGuideDialog$Companion;", "", "<init>", "()V", "TAG", "", "SHOW_TIME", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}