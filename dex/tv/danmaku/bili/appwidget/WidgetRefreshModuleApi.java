package tv.danmaku.bili.appwidget;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.blrouter.ModuleApi;
import com.bilibili.lib.blrouter.ModuleDescriptor;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.teenagersmode.TeenagersMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.HotListAppWidget;
import tv.danmaku.bili.appwidget.hotlist.HotListAppWidgetUpdaterKt;
import tv.danmaku.bili.appwidget.hotlist.StateNoticeKt;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;
import tv.danmaku.bili.appwidget.hotword.work.BiliWidgetWorkManager;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidget;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidgetKt;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidgetUpdaterKt;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.proc.ActivityCallBack;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: WidgetRefreshModuleApi.kt */
@ModuleDescriptor(desc = "桌面 widget 启动刷新", name = "app_widget_refresh")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/appwidget/WidgetRefreshModuleApi;", "Lcom/bilibili/lib/blrouter/ModuleApi;", "<init>", "()V", "hotWordRunnable", "Ljava/lang/Runnable;", "hotListRunnable", "upCardRunnable", "oppoHotListRunnable", "passportObserver", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "onPostCreate", "", "sendWidgetBroadcast", "context", "Landroid/content/Context;", "action", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WidgetRefreshModuleApi extends ModuleApi {
    public static final int $stable = 8;
    private final Runnable hotWordRunnable = new Runnable() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            WidgetRefreshModuleApi.hotWordRunnable$lambda$0();
        }
    };
    private final Runnable hotListRunnable = new Runnable() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            WidgetRefreshModuleApi.hotListRunnable$lambda$0();
        }
    };
    private final Runnable upCardRunnable = new Runnable() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            WidgetRefreshModuleApi.upCardRunnable$lambda$0();
        }
    };
    private final Runnable oppoHotListRunnable = new Runnable() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            WidgetRefreshModuleApi.oppoHotListRunnable$lambda$0();
        }
    };
    private final PassportObserver passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$$ExternalSyntheticLambda4
        public final void onChange(Topic topic) {
            WidgetRefreshModuleApi.passportObserver$lambda$0(topic);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hotWordRunnable$lambda$0() {
        try {
            boolean hasWidget = BiliWidgetWorkManager.Companion.update(BiliContext.application());
            Pair[] pairArr = new Pair[1];
            pairArr[0] = new Pair(AuthResultCbHelper.ARGS_STATE, hasWidget ? "1" : "0");
            Neurons.report$default(false, 4, "app.widgets.state.sys", MapsKt.hashMapOf(pairArr), (String) null, 0, 48, (Object) null);
        } catch (Exception e) {
            BLog.e("WidgetRefreshModuleApi exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hotListRunnable$lambda$0() {
        Pair[] pairArr = new Pair[1];
        pairArr[0] = new Pair(AuthResultCbHelper.ARGS_STATE, HotListAppWidget.Companion.hasHotListWidget(BiliContext.application()) ? "1" : "0");
        Neurons.report$default(false, 4, "app.widgets.state_new.sys", MapsKt.hashMapOf(pairArr), (String) null, 0, 48, (Object) null);
        Application it = BiliContext.application();
        if (it != null && HotListAppWidget.Companion.hasHotListWidget(it)) {
            SpUtilKt.resetHotListPageNo(it);
            HotListAppWidgetUpdaterKt.update(it, "tv.danmaku.bili.action.appwidget.LAUNCH_APP");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upCardRunnable$lambda$0() {
        Pair[] pairArr = new Pair[1];
        pairArr[0] = new Pair(AuthResultCbHelper.ARGS_STATE, UpCardAppWidget.Companion.hasUpCardWidget(BiliContext.application()) ? "1" : "0");
        Neurons.report$default(false, 4, "app.widgets.state_new.sys", MapsKt.hashMapOf(pairArr), (String) null, 0, 48, (Object) null);
        Application it = BiliContext.application();
        if (it != null && UpCardAppWidget.Companion.hasUpCardWidget(it)) {
            SpUtilKt.resetHotListPageNo(it);
            UpCardAppWidgetUpdaterKt.update(it, "tv.danmaku.bili.action.appwidget.LAUNCH_APP");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oppoHotListRunnable$lambda$0() {
        Application it = BiliContext.application();
        if (it != null) {
            Pair[] pairArr = new Pair[1];
            pairArr[0] = new Pair(AuthResultCbHelper.ARGS_STATE, SpUtilKt.isOpHotListExists(it) ? "1" : "0");
            Neurons.report$default(false, 4, "app.plug-in-card.state_new.sys", MapsKt.hashMapOf(pairArr), (String) null, 0, 48, (Object) null);
            if (SpUtilKt.isOpHotListExists(it)) {
                StateNoticeKt.getUSER_DATA_INSTANCE().tryUpdate(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void passportObserver$lambda$0(Topic topic) {
        Application it;
        Intrinsics.checkNotNullParameter(topic, "topic");
        if ((topic == Topic.SIGN_IN || topic == Topic.SIGN_OUT) && (it = BiliContext.application()) != null) {
            Intent $this$passportObserver_u24lambda_u240_u240_u240 = new Intent(UpCardAppWidgetKt.APP_WIDGET_LOGIN_CHANGE_MODE_UPDATE);
            $this$passportObserver_u24lambda_u240_u240_u240.setComponent(new ComponentName(it, UpCardAppWidget.class.getName()));
            it.sendBroadcast($this$passportObserver_u24lambda_u240_u240_u240);
        }
    }

    public void onPostCreate() {
        super.onPostCreate();
        if (!BiliContext.isMainProcess() || DelayTaskController.shouldBlock()) {
            return;
        }
        BLog.i("WidgetRefreshModuleApi", "start post update ");
        HandlerThreads.postDelayed(2, this.hotWordRunnable, 3000L);
        HandlerThreads.postDelayed(2, this.hotListRunnable, 3000L);
        HandlerThreads.postDelayed(2, this.upCardRunnable, 3000L);
        HandlerThreads.postDelayed(2, this.oppoHotListRunnable, 0L);
        Application it = BiliContext.application();
        if (it != null) {
            SpUtilKt.recodeRestrictedLessonsMode(it, RestrictedMode.isLocalEnable(RestrictedType.LESSONS));
            SpUtilKt.recodeRestrictedTeenagerMode(it, RestrictedMode.isLocalEnable(RestrictedType.TEENAGERS));
            BiliAccounts.get(it).subscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        }
        RestrictedMode.registerLessonsChangeListener$default((String) null, new RestrictedMode.OnStateChangeListener() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$onPostCreate$2
            public void onChanged(boolean isEnable) {
                Application context = BiliContext.application();
                if (context == null) {
                    return;
                }
                BLog.i("WidgetRefreshModuleApi", "update LessonsMode");
                SpUtilKt.recodeRestrictedLessonsMode(context, isEnable);
                WidgetRefreshModuleApi.this.sendWidgetBroadcast(context, "tv.danmaku.bili.action.appwidget.RESTRICTED_MODE");
                StateNoticeKt.getUSER_DATA_INSTANCE().updateMode();
            }
        }, 1, (Object) null);
        RestrictedMode.registerTeenagersChangeListener$default((String) null, new TeenagersMode.OnTeenagersModeChangeListener() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$onPostCreate$3
            public /* synthetic */ void onStateChange(boolean z, boolean z2, boolean z3) {
                TeenagersMode.OnTeenagersModeChangeListener.-CC.$default$onStateChange(this, z, z2, z3);
            }

            public void onStateChange(boolean isEnable, boolean isBizEnable) {
                Application context = BiliContext.application();
                if (context == null) {
                    return;
                }
                BLog.i("WidgetRefreshModuleApi", "update TeenagerMode");
                SpUtilKt.recodeRestrictedTeenagerMode(context, isEnable);
                WidgetRefreshModuleApi.this.sendWidgetBroadcast(context, "tv.danmaku.bili.action.appwidget.RESTRICTED_MODE");
                StateNoticeKt.getUSER_DATA_INSTANCE().updateMode();
            }

            public void onTeenagerModePageShow(boolean isShow) {
            }
        }, 1, (Object) null);
        ActivityCallBack.addIPCActivityStateCallback(new ActivityCallBack.IPCActivityStateCallback() { // from class: tv.danmaku.bili.appwidget.WidgetRefreshModuleApi$onPostCreate$4
            @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
            public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
                Application it2 = BiliContext.application();
                if (it2 != null && HotListAppWidget.Companion.hasHotListWidget(it2) && lastVisibleCount == 0) {
                    StateNoticeKt.getUSER_DATA_INSTANCE().tryUpdate(false);
                }
            }

            @Override // tv.danmaku.bili.proc.ActivityCallBack.IPCActivityStateCallback
            public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendWidgetBroadcast(Context context, String action) {
        Intent $this$sendWidgetBroadcast_u24lambda_u240 = new Intent(action);
        $this$sendWidgetBroadcast_u24lambda_u240.setComponent(new ComponentName(context, HotListAppWidget.class.getName()));
        context.sendBroadcast($this$sendWidgetBroadcast_u24lambda_u240);
    }
}