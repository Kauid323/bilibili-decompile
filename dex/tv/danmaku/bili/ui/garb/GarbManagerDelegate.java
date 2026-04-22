package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.list.common.feed.PegasusStyle;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.app.theme.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.ServicesProvider;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.moduleservice.main.ThemeService;
import com.bilibili.okretro.BiliApiDataCallback;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper;
import tv.danmaku.bili.ui.garb.model.GarbApiHelper;
import tv.danmaku.bili.ui.garb.model.GarbData;
import tv.danmaku.bili.ui.garb.ui.GarbOpDialog;
import tv.danmaku.bili.ui.theme.BiliTheme;

/* compiled from: GarbManagerDelegate.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J,\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\rJ\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010$\u001a\u00020%H\u0002J$\u0010*\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\rH\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020(H\u0002J\u0018\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020(H\u0002J\u0018\u00100\u001a\u00020\r2\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020(H\u0002J\u000e\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020(J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020(H\u0002J\u0018\u00104\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00102\u001a\u00020(H\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u00102\u001a\u00020(H\u0007J\u0010\u00105\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000bH\u0007J\u0010\u00106\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0018H\u0007J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u0007H\u0007J\b\u0010;\u001a\u00020\u000fH\u0007J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u0007H\u0007J\u0012\u0010>\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020\u0018H\u0007J\u0010\u0010?\u001a\u00020\u000b2\u0006\u00102\u001a\u00020(H\u0007J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\rH\u0007J\u0010\u0010B\u001a\u00020\u000b2\u0006\u00102\u001a\u00020(H\u0002J\u0012\u0010C\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010\u0018H\u0003J\u0010\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0007H\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Ltv/danmaku/bili/ui/garb/GarbManagerDelegate;", "Lcom/bilibili/lib/ui/garb/GarbManager$Delegate;", "<init>", "()V", "getLoadEquipFile", "Ljava/io/File;", "getCurBottomTabHeight", "", "context", "Landroid/content/Context;", "sGarb", "Lcom/bilibili/lib/ui/garb/Garb;", "sIsOtherDialogShowing", "", "init", "", "fetchGarbForLogin", "getCurGarb", "getGarbWithNightMode", "fetchGarb", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "isPure", ChannelRoutes.CHANNEL_NAME, "", "obtainDefault", "obtainNight", "isFreeTheme", "registerOnGarbChangeListener", "notifyGarbChange", "garb", "isSync", "isFromMainProcess", "shouldReport", "getActionName", "checkPureGarbExpired", "data", "Ltv/danmaku/bili/ui/garb/model/GarbData;", "applyGarb", "checkUpdate", "Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;", "findApplyGarb", "onGarbChange", "shouldApplyOpGarb", "opGarb", "shouldApplyForceOpGarbWithLog", "curId", "", "shouldApplyForceOpGarb", "isResValid", "garbDetail", "shouldShowOpDialog", "showOpDialog", "setCurGarb", "getPureThemeId", "setColorGarb", "colorName", "setIndexCardStyle", "style", "clearMemoryLastGarb", "syncColorGarb", "themeId", "saveColorGarb", "saveGarb", "setOtherDialogShowing", "isShowing", "mapping", "parseColor", "colorStr", "getColorNameById", "id", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbManagerDelegate implements GarbManager.Delegate {
    public static final GarbManagerDelegate INSTANCE = new GarbManagerDelegate();
    private static volatile Garb sGarb;
    private static boolean sIsOtherDialogShowing;

    /* compiled from: GarbManagerDelegate.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Topic.values().length];
            try {
                iArr[Topic.SIGN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Topic.SIGN_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private GarbManagerDelegate() {
    }

    public File getLoadEquipFile() {
        return LoadEquipStorageHelper.INSTANCE.getEquipFile();
    }

    public int getCurBottomTabHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Garb garb = GarbManager.getCurGarb();
        if (garb.isPure()) {
            return context.getResources().getDimensionPixelOffset(R.dimen.bottom_navigation_height);
        }
        return context.getResources().getDimensionPixelOffset(R.dimen.bottom_navigation_height_with_bg);
    }

    public void init(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        sGarb = GarbStorageHelper.readGarbWrapper$default(GarbStorageHelper.INSTANCE, context, false, 2, null);
        Garb it = sGarb;
        if (it != null) {
            if (it.isPure() && BiliTheme.getCurrentTheme(context) != INSTANCE.getPureThemeId(it.getColorName())) {
                BiliTheme.setCurrentTheme(context, INSTANCE.getPureThemeId(it.getColorName()), false);
                if (!ConfigManager.Companion.isHitFF("key_switch_clear_op_config_on_fetch_garb")) {
                    return;
                }
            } else if (!it.isPure() && MultipleThemeUtils.isNightTheme(context)) {
                GarbStorageHelper.INSTANCE.saveLastGarb(it);
                sGarb = INSTANCE.obtainNight();
                BLog.i(GarbManagerDelegateKt.TAG, "init and set garb " + it.getId());
            }
        }
        BiliAccounts.get(context).subscribe(new PassportObserver() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$$ExternalSyntheticLambda0
            public final void onChange(Topic topic) {
                GarbManagerDelegate.init$lambda$1(context, topic);
            }
        }, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        registerOnGarbChangeListener(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(final Context $context, Topic it) {
        switch (it == null ? -1 : WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
            case 1:
                if (BiliContext.isMainProcess()) {
                    GarbStorageHelper.INSTANCE.clearLastGarb($context, new GarbStorageHelper.IClearLastGarbListener() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$init$2$1
                        @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.IClearLastGarbListener
                        public void onClear() {
                            BLog.i(GarbManagerDelegateKt.TAG, "garb 登录拉取装扮");
                            GarbManagerDelegate.INSTANCE.fetchGarbForLogin($context);
                        }
                    });
                    return;
                }
                return;
            case 2:
                BLog.i(GarbManagerDelegateKt.TAG, "garb 退出登录卸载装扮");
                LoadEquipStorageHelper.INSTANCE.unsnatchLoadEquip();
                if (!BiliContext.isMainProcess()) {
                    return;
                }
                Garb lastGarb = GarbStorageHelper.INSTANCE.readLastGarbWrapper($context);
                Garb curGarb = GarbStorageHelper.readGarbWrapper$default(GarbStorageHelper.INSTANCE, $context, false, 2, null);
                if (curGarb.isOp()) {
                    setCurGarb(curGarb);
                    return;
                } else if (lastGarb == null) {
                    BiliTheme.switchDefaultTheme($context);
                    return;
                } else if (lastGarb.isOp()) {
                    setCurGarb(lastGarb);
                    return;
                } else if (!lastGarb.isPink()) {
                    GarbStorageHelper.INSTANCE.clearLastGarb($context, new GarbStorageHelper.IClearLastGarbListener() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$init$2$2
                        @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.IClearLastGarbListener
                        public void onClear() {
                            BiliTheme.switchDefaultTheme($context);
                        }
                    });
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchGarbForLogin(final Context context) {
        BLog.i(GarbManagerDelegateKt.TAG, "garb fetch garb on login");
        String accessKey = BiliAccounts.get(context).getAccessKey();
        if (accessKey == null) {
            accessKey = "";
        }
        GarbApiHelper.INSTANCE.fetchGarb(accessKey, isFreeTheme(context), new BiliApiDataCallback<GarbData>() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$fetchGarbForLogin$1
            public void onDataSuccess(GarbData data) {
                GarbData.GarbDetail applyGarb;
                BLog.i(GarbManagerDelegateKt.TAG, "garb fetch garb success on login");
                if (data != null) {
                    final Context context2 = context;
                    GarbData.GarbDetail opGarb = data.getOpGarb();
                    boolean z = true;
                    if (opGarb != null) {
                        opGarb.setOp(true);
                    }
                    Garb curGarb = GarbManagerDelegate.INSTANCE.getGarbWithNightMode(context2);
                    if (data.getOpGarb() == null && !curGarb.isOp()) {
                        GarbStorageHelper.clearOpGarb$default(GarbStorageHelper.INSTANCE, context2, false, 2, null);
                    }
                    applyGarb = GarbManagerDelegate.INSTANCE.findApplyGarb(data);
                    if (applyGarb != null) {
                        BLog.i(GarbManagerDelegateKt.TAG, "garb applyGarb: " + applyGarb + " isResValid: " + GarbManagerDelegate.INSTANCE.isResValid(applyGarb));
                        if (applyGarb.getId() == curGarb.getId()) {
                            if (!GarbManagerDelegate.INSTANCE.isResValid(applyGarb)) {
                                GarbStorageHelper.INSTANCE.download(applyGarb, null);
                            }
                            GarbStorageHelper.INSTANCE.saveGarb(curGarb, applyGarb.isOp());
                            BLog.i(GarbManagerDelegateKt.TAG, "garb on login save garb success 1 " + applyGarb.getId());
                            return;
                        } else if (GarbManagerDelegate.INSTANCE.isResValid(applyGarb)) {
                            Activity topActivity = BiliContext.topActivitiy();
                            if (topActivity instanceof IDrawerHost) {
                                GarbManagerDelegate.setCurGarb(applyGarb);
                            } else {
                                GarbStorageHelper.INSTANCE.saveGarbChanged(context2, GarbManagerDelegate.saveGarb(applyGarb));
                                BLog.i(GarbManagerDelegateKt.TAG, "garb on login save garb success 2 " + applyGarb.getId());
                            }
                        } else {
                            BLog.i(GarbManagerDelegateKt.TAG, "garb download 2");
                            GarbStorageHelper.INSTANCE.download(applyGarb, null);
                        }
                    } else {
                        Garb lastGarb = GarbStorageHelper.INSTANCE.readLastGarbWrapper(context2);
                        if (lastGarb == null || !lastGarb.isOp()) {
                            z = false;
                        }
                        if (z && ConfigManager.Companion.isHitFF("key_switch_clear_op_config_on_fetch_garb")) {
                            GarbStorageHelper.clearOpGarb$default(GarbStorageHelper.INSTANCE, context2, false, 2, null);
                        }
                        if (lastGarb != null && !lastGarb.isPure()) {
                            BLog.i(GarbManagerDelegateKt.TAG, "garb clearLastGarb");
                            GarbStorageHelper.INSTANCE.clearLastGarb(context2, new GarbStorageHelper.IClearLastGarbListener() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$fetchGarbForLogin$1$onDataSuccess$1$1
                                @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.IClearLastGarbListener
                                public void onClear() {
                                    GarbManagerDelegate.setColorGarb(GarbManagerDelegate.getColorNameById(BiliTheme.getCurrentTheme(context2)));
                                }
                            });
                        } else {
                            GarbManagerDelegate.setColorGarb(GarbManagerDelegate.getColorNameById(BiliTheme.getCurrentTheme(context2)));
                        }
                        BLog.i(GarbManagerDelegateKt.TAG, "garb set color garb on login --- current theme is " + GarbManagerDelegate.getColorNameById(BiliTheme.getCurrentTheme(context2)));
                    }
                    LoadEquipStorageHelper.INSTANCE.acceptGrab(data, null);
                    BLog.i(GarbManagerDelegateKt.TAG, "garb fetch garb with : \n " + data);
                }
            }

            public void onError(Throwable t) {
                BLog.e(GarbManagerDelegateKt.TAG, "garb fetch garb error on login", t);
            }
        });
    }

    public Garb getCurGarb() {
        if (sGarb == null) {
            sGarb = Garb.Companion.obtainDefault();
        }
        Garb garb = sGarb;
        Intrinsics.checkNotNull(garb);
        return garb;
    }

    public Garb getGarbWithNightMode(Context context) {
        Garb lastGarb;
        Intrinsics.checkNotNullParameter(context, "context");
        Garb garb = GarbManager.getCurGarb();
        if (garb.isNight() && (lastGarb = GarbStorageHelper.INSTANCE.readLastGarbWrapper(context)) != null && !lastGarb.isPure()) {
            return lastGarb;
        }
        return garb;
    }

    public void fetchGarb(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        String accessKey = BiliAccounts.get(activity).getAccessKey();
        if (accessKey == null) {
            accessKey = "";
        }
        GarbApiHelper.INSTANCE.fetchGarb(accessKey, isFreeTheme(activity), new BiliApiDataCallback<GarbData>() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$fetchGarb$1
            public void onDataSuccess(GarbData data) {
                if (data == null) {
                    return;
                }
                GarbData.GarbDetail opGarb = data.getOpGarb();
                if (opGarb != null) {
                    opGarb.setOp(true);
                }
                GarbManagerDelegate.INSTANCE.applyGarb(activity, data);
                GarbManagerDelegate.INSTANCE.checkPureGarbExpired(activity, data);
                LoadEquipStorageHelper.INSTANCE.acceptGrab(data, null);
                BLog.i(GarbManagerDelegateKt.TAG, "garb fetch garb with : \n " + data);
            }

            public void onError(Throwable t) {
                BLog.e(GarbManagerDelegateKt.TAG, "garb fetch garb error on start up", t);
            }

            public boolean isCancel() {
                return activity.isFinishing();
            }
        });
    }

    public boolean isPure(String name) {
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        return GarbManagerDelegateKt.access$getCOLOR_MAP$p().containsKey(name);
    }

    public Garb obtainDefault() {
        Context application = BiliContext.application();
        if (application == null) {
            return Garb.Companion.obtainDefault();
        }
        Context context = application;
        Garb garb = new Garb();
        int themeId = BiliTheme.getCurrentTheme(context);
        garb.setId(themeId);
        garb.setColorName(getColorNameById(themeId));
        return garb;
    }

    public final Garb obtainNight() {
        Garb garb = new Garb();
        garb.setId(1);
        garb.setColorName(getColorNameById(1));
        return garb;
    }

    private final boolean isFreeTheme(Context context) {
        Garb garb = getGarbWithNightMode(context);
        if (garb.isOp()) {
            return true;
        }
        return garb.isPure() && !MultipleThemeUtils.isExtraTheme(context);
    }

    private final void registerOnGarbChangeListener(Context context) {
        ContextCompat.registerReceiver(context.getApplicationContext(), new BroadcastReceiver() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$registerOnGarbChangeListener$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra(GarbManagerDelegateKt.BUNDLE_BROADCAST_DATA_TYPE, 0)) : null;
                if (valueOf != null && valueOf.intValue() == 1) {
                    String data = intent.getStringExtra(GarbManagerDelegateKt.BUNDLE_GARB_DATA_KEY);
                    boolean isFromMainProcess = intent.getBooleanExtra(GarbManagerDelegateKt.BUNDLE_THEME_CHANGE_SYNC_FROM_MAIN_PROCESS, false);
                    boolean isSync = intent.getBooleanExtra(GarbManagerDelegateKt.BUNDLE_THEME_CHANGE_SYNC_GARB_KEY, false);
                    boolean shouldReport = intent.getBooleanExtra(GarbManagerDelegateKt.BUNDLE_THEME_CHANGE_SHOULD_REPORT, false);
                    if (TextUtils.isEmpty(data) || isFromMainProcess) {
                        return;
                    }
                    try {
                        Garb garb = (Garb) JSONObject.parseObject(data, Garb.class);
                        if (garb != null) {
                            GarbManagerDelegate.INSTANCE.onGarbChange(garb, isSync, shouldReport);
                        }
                    } catch (Exception e) {
                        BLog.e(GarbManagerDelegateKt.TAG, "garb parse garb error when garb change");
                    }
                } else if (valueOf != null && valueOf.intValue() == 2) {
                    Integer valueOf2 = Integer.valueOf(intent.getIntExtra(GarbManagerDelegateKt.BUNDLE_INDEX_CARD_STYLE, 0));
                    int it = valueOf2.intValue();
                    Integer num = it > 0 ? valueOf2 : null;
                    if (num != null) {
                        int it2 = num.intValue();
                        PegasusStyle.INSTANCE.setStyle(it2);
                        if (ProcessUtils.isWebProcess()) {
                            ToastHelper.showToastShort(context2, com.bilibili.app.comm.list.common.R.string.pegasus_switch_column_style_success);
                        }
                    }
                } else if (valueOf != null && valueOf.intValue() == 3) {
                    GarbStorageHelper.INSTANCE.setMLastGarb(null);
                }
            }
        }, new IntentFilter(getActionName(context)), 4);
    }

    public static /* synthetic */ void notifyGarbChange$default(GarbManagerDelegate garbManagerDelegate, Garb garb, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        garbManagerDelegate.notifyGarbChange(garb, z, z2, z3);
    }

    public final void notifyGarbChange(Garb garb, boolean isSync, boolean isFromMainProcess, boolean shouldReport) {
        Intrinsics.checkNotNullParameter(garb, "garb");
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent(getActionName(context));
            intent.setPackage(context.getPackageName());
            intent.putExtra(GarbManagerDelegateKt.BUNDLE_BROADCAST_DATA_TYPE, 1);
            intent.putExtra(GarbManagerDelegateKt.BUNDLE_GARB_DATA_KEY, JSONObject.toJSONString(garb));
            intent.putExtra(GarbManagerDelegateKt.BUNDLE_THEME_CHANGE_SYNC_GARB_KEY, isSync);
            intent.putExtra(GarbManagerDelegateKt.BUNDLE_THEME_CHANGE_SHOULD_REPORT, shouldReport);
            intent.putExtra(GarbManagerDelegateKt.BUNDLE_THEME_CHANGE_SYNC_FROM_MAIN_PROCESS, isFromMainProcess);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            BLog.e(GarbManagerDelegateKt.TAG, "garb send broadcast error!");
        }
    }

    private final String getActionName(Context context) {
        return context.getPackageName() + ".garb.GARB_CHANGE";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkPureGarbExpired(final Context context, GarbData data) {
        List it = data.getPureGarb();
        if (it == null || it.isEmpty()) {
            return;
        }
        final long garbId = INSTANCE.getCurGarb().getId();
        for (final GarbData.PureGarbDetail garbDetail : it) {
            if (!garbDetail.isFree() && garbId == garbDetail.getId() && garbDetail.getStatus() == 4) {
                ServerClock.currentTimeMillis().continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$$ExternalSyntheticLambda3
                    public final Object then(Task task) {
                        Unit checkPureGarbExpired$lambda$0$0;
                        checkPureGarbExpired$lambda$0$0 = GarbManagerDelegate.checkPureGarbExpired$lambda$0$0(GarbData.PureGarbDetail.this, context, garbId, task);
                        return checkPureGarbExpired$lambda$0$0;
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkPureGarbExpired$lambda$0$0(GarbData.PureGarbDetail $garbDetail, Context $context, long $garbId, Task time) {
        Object result = time.getResult();
        Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
        if (BiliTheme.isThemeExpired(((Number) result).longValue(), $garbDetail.getDueTime())) {
            Garb lastGarb = GarbStorageHelper.INSTANCE.readLastGarbWrapper($context);
            boolean z = false;
            if (lastGarb != null && lastGarb.getId() == $garbId) {
                z = true;
            }
            if (z) {
                GarbStorageHelper.INSTANCE.clearLastGarb($context, null);
            }
            BLog.i(GarbManagerDelegateKt.TAG, "garb expired " + $garbId);
            ThemeService themeService = (ThemeService) ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(ThemeService.class), (String) null, 1, (Object) null);
            if (themeService != null) {
                themeService.callThemeExpired($context);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyGarb(final Activity activity, GarbData data) {
        Garb curGarb = getGarbWithNightMode(activity);
        boolean z = false;
        if (data.getOpGarb() == null && !curGarb.isOp()) {
            GarbStorageHelper.clearOpGarb$default(GarbStorageHelper.INSTANCE, activity, false, 2, null);
        }
        GarbData.GarbDetail applyGarb = findApplyGarb(data);
        boolean z2 = true;
        if (applyGarb != null) {
            BLog.i(GarbManagerDelegateKt.TAG, "garb applyGarb: id=" + applyGarb.getId());
            if (curGarb.getId() == applyGarb.getId()) {
                BLog.i(GarbManagerDelegateKt.TAG, "garb applyGarb & checkUpdate " + applyGarb.getId());
                checkUpdate(activity, applyGarb);
                return;
            } else if (applyGarb.isOp()) {
                if (applyGarb.isForce()) {
                    if (isResValid(applyGarb)) {
                        setCurGarb(applyGarb);
                        return;
                    }
                    BLog.i(GarbManagerDelegateKt.TAG, "garb applyGarb download 2");
                    GarbStorageHelper.INSTANCE.download(applyGarb, null);
                    return;
                }
                GarbData.OpConf conf = applyGarb.getConf();
                if (conf != null && conf.getHideDialog()) {
                    z = true;
                }
                if (!z) {
                    showOpDialog(activity, applyGarb);
                    return;
                }
                return;
            } else if (isResValid(applyGarb)) {
                setCurGarb(applyGarb);
                return;
            } else {
                BLog.i(GarbManagerDelegateKt.TAG, "garb applyGarb download 3");
                GarbStorageHelper.INSTANCE.download(applyGarb, null);
                return;
            }
        }
        Garb lastGarb = GarbStorageHelper.INSTANCE.readLastGarbWrapper(activity);
        if (lastGarb == null || !lastGarb.isOp()) {
            z2 = false;
        }
        if (z2 && ConfigManager.Companion.isHitFF("key_switch_clear_op_config_on_fetch_garb")) {
            GarbStorageHelper.clearOpGarb$default(GarbStorageHelper.INSTANCE, activity, false, 2, null);
        }
        if (lastGarb != null && !lastGarb.isPure()) {
            GarbStorageHelper.INSTANCE.clearLastGarb(activity, new GarbStorageHelper.IClearLastGarbListener() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$applyGarb$1
                @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.IClearLastGarbListener
                public void onClear() {
                    GarbManagerDelegate.setColorGarb(GarbManagerDelegate.getColorNameById(BiliTheme.getCurrentTheme(activity)));
                }
            });
        } else {
            setColorGarb(getColorNameById(BiliTheme.getCurrentTheme(activity)));
        }
        BLog.i(GarbManagerDelegateKt.TAG, "garb set color garb on fetch --- current theme is " + getColorNameById(BiliTheme.getCurrentTheme(activity)));
    }

    private final void checkUpdate(final Activity activity, final GarbData.GarbDetail applyGarb) {
        final Garb curGarb = getGarbWithNightMode(activity);
        if (applyGarb.getVer() == curGarb.getVer()) {
            saveGarb(applyGarb);
        } else {
            GarbStorageHelper.INSTANCE.download(applyGarb, new GarbStorageHelper.Listener() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$checkUpdate$1
                @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
                public void onDownloadError(String errMsg) {
                    BiliTheme.switchDefaultTheme(activity);
                    GarbStorageHelper.INSTANCE.clearGarbRes(activity, curGarb);
                }

                @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
                public void onDownloadSuccess() {
                    GarbManagerDelegate.setCurGarb(applyGarb);
                    GarbStorageHelper.INSTANCE.cleanOldAsset(activity, applyGarb);
                    ToastHelper.showToastShort(activity, bili.resource.homepage.R.string.homepage_global_string_354);
                }

                @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
                public boolean isCanceled() {
                    return activity.isFinishing();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GarbData.GarbDetail findApplyGarb(GarbData data) {
        if (data.getOpGarb() != null) {
            GarbData.GarbDetail opGarb = data.getOpGarb();
            Intrinsics.checkNotNull(opGarb);
            if (shouldApplyOpGarb(opGarb)) {
                return data.getOpGarb();
            }
        }
        if (data.getUserGarb() != null) {
            return data.getUserGarb();
        }
        return null;
    }

    static /* synthetic */ void onGarbChange$default(GarbManagerDelegate garbManagerDelegate, Garb garb, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        garbManagerDelegate.onGarbChange(garb, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGarbChange(Garb garb, boolean isSync, boolean shouldReport) {
        sGarb = garb;
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        boolean isMainProcess = BiliContext.isMainProcess();
        if (garb.isPure()) {
            if (!isSync) {
                if (isMainProcess) {
                    BiliTheme.setCurrentTheme(BiliContext.application(), getPureThemeId(garb.getColorName()), false);
                }
                ThemeWatcher.getInstance().onChanged();
            }
        } else if (!isSync) {
            boolean isCurBlack = MultipleThemeUtils.isNightTheme(context);
            boolean notifyPureTheme = false;
            if (isCurBlack) {
                GarbStorageHelper.INSTANCE.saveLastGarb(garb);
                sGarb = obtainNight();
                notifyPureTheme = false;
            } else if (isMainProcess) {
                BiliTheme.setCurrentTheme(BiliContext.application(), 8, false);
                notifyPureTheme = true;
            }
            if (notifyPureTheme) {
                ThemeWatcher.getInstance().onChanged();
            }
        }
        Garb $this$onGarbChange_u24lambda_u240 = sGarb;
        if ($this$onGarbChange_u24lambda_u240 != null) {
            if (isMainProcess) {
                BLog.i(GarbManagerDelegateKt.TAG, "garb onchaged garb is " + $this$onGarbChange_u24lambda_u240.getId() + " -- current is night mode ==  " + (context.getResources().getConfiguration().uiMode == 32));
                if (shouldReport) {
                    long reportId = INSTANCE.getGarbWithNightMode(context).getId();
                    Neurons.report$default(false, 4, "main.startup.globaltheme-get.sys", MapsKt.mapOf(new Pair[]{TuplesKt.to("entity", "globaltheme"), TuplesKt.to("entity_id", String.valueOf(reportId))}), (String) null, 0, 48, (Object) null);
                }
            }
            if ($this$onGarbChange_u24lambda_u240.isPrimaryOnly()) {
                boolean isNight = MultipleThemeUtils.isNightTheme(context);
                garb.setFontColor(INSTANCE.parseColor(isNight ? "#A2A7AE" : "#61666D"));
                garb.setSecondaryPageColor(INSTANCE.parseColor(isNight ? "#17181A" : "#FFFFFF"));
                garb.setDarkMode(!isNight);
            }
            GarbWatcher.INSTANCE.onChanged($this$onGarbChange_u24lambda_u240);
        }
    }

    private final boolean shouldApplyOpGarb(GarbData.GarbDetail opGarb) {
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        Garb curGarb = getGarbWithNightMode(context);
        return shouldApplyForceOpGarbWithLog(curGarb.getId(), opGarb) || curGarb.getId() == opGarb.getId() || shouldShowOpDialog(opGarb);
    }

    private final boolean shouldApplyForceOpGarbWithLog(long curId, GarbData.GarbDetail opGarb) {
        boolean $this$shouldApplyForceOpGarbWithLog_u24lambda_u240 = shouldApplyForceOpGarb(curId, opGarb);
        BLog.i(GarbManagerDelegateKt.TAG, "shouldApplyForceOpGarb = " + $this$shouldApplyForceOpGarbWithLog_u24lambda_u240);
        return $this$shouldApplyForceOpGarbWithLog_u24lambda_u240;
    }

    private final boolean shouldApplyForceOpGarb(long curId, GarbData.GarbDetail opGarb) {
        Application it;
        if (opGarb.isForce()) {
            return !opGarb.changeable() || (it = BiliContext.application()) == null || curId == opGarb.getId() || GarbStorageHelper.INSTANCE.getLastOpGarb(it) != opGarb.getId();
        }
        return false;
    }

    public final boolean isResValid(GarbData.GarbDetail garbDetail) {
        Intrinsics.checkNotNullParameter(garbDetail, "garbDetail");
        return GarbStorageHelper.INSTANCE.isResValid(garbDetail);
    }

    private final boolean shouldShowOpDialog(GarbData.GarbDetail garb) {
        return (garb.isForce() || GarbStorageHelper.INSTANCE.getShowDialogGarbId() == garb.getId()) ? false : true;
    }

    private final void showOpDialog(final Activity activity, GarbData.GarbDetail garbDetail) {
        if (activity.isFinishing() || sIsOtherDialogShowing) {
            sIsOtherDialogShowing = false;
        } else if (EnvironmentManager.getInstance().isFirstStart()) {
        } else {
            final GarbOpDialog dialog = new GarbOpDialog(activity, garbDetail);
            MainDialogManager.DialogManagerInfo garbDialogInfo = new MainDialogManager.DialogManagerInfo("garb", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$$ExternalSyntheticLambda1
                public final void onShow() {
                    GarbOpDialog.this.show();
                }
            }, 2060);
            MainDialogManager.addDialog(garbDialogInfo, activity);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.garb.GarbManagerDelegate$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GarbManagerDelegate.showOpDialog$lambda$1(activity, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOpDialog$lambda$1(Activity $activity, DialogInterface it) {
        MainDialogManager.showNextDialog("garb", false, $activity);
    }

    @JvmStatic
    public static final void setCurGarb(GarbData.GarbDetail garbDetail) {
        Intrinsics.checkNotNullParameter(garbDetail, "garbDetail");
        Garb garb = INSTANCE.mapping(garbDetail);
        setCurGarb(garb);
    }

    @JvmStatic
    public static final void setCurGarb(Garb garb) {
        Intrinsics.checkNotNullParameter(garb, "garb");
        sGarb = garb;
        Application it = BiliContext.application();
        if (it != null) {
            if (!garb.isOp()) {
                GarbStorageHelper.INSTANCE.clearOpGarb(it, garb.isNight());
            } else {
                GarbStorageHelper.INSTANCE.saveLastOpGarb(it, garb.getId());
            }
        }
        GarbStorageHelper.INSTANCE.saveGarb(garb, garb.isOp());
        if (BiliContext.isMainProcess()) {
            onGarbChange$default(INSTANCE, garb, false, true, 2, null);
        }
        notifyGarbChange$default(INSTANCE, garb, BiliContext.isMainProcess(), false, false, 4, null);
    }

    public final int getPureThemeId(String name) {
        Integer num = (Integer) GarbManagerDelegateKt.access$getCOLOR_MAP$p().get(name);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @JvmStatic
    public static final void setColorGarb(String colorName) {
        Intrinsics.checkNotNullParameter(colorName, "colorName");
        Application context = BiliContext.application();
        if (context == null || !GarbManagerDelegateKt.access$getCOLOR_MAP$p().containsKey(colorName)) {
            return;
        }
        Integer num = (Integer) GarbManagerDelegateKt.access$getCOLOR_MAP$p().get(colorName);
        long garbId = num != null ? num.intValue() : 8L;
        Garb garb = new Garb();
        garb.setId(garbId);
        garb.setColorName(colorName);
        sGarb = garb;
        GarbStorageHelper.INSTANCE.clearOpGarb(context, garb.isNight());
        GarbStorageHelper.INSTANCE.saveGarb(garb, false);
        notifyGarbChange$default(INSTANCE, garb, garbId == INSTANCE.getGarbWithNightMode(context).getId(), false, false, 12, null);
    }

    @JvmStatic
    public static final void setIndexCardStyle(int style) {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        try {
            Intent $this$setIndexCardStyle_u24lambda_u240 = new Intent(INSTANCE.getActionName(context));
            $this$setIndexCardStyle_u24lambda_u240.putExtra(GarbManagerDelegateKt.BUNDLE_BROADCAST_DATA_TYPE, 2);
            $this$setIndexCardStyle_u24lambda_u240.putExtra(GarbManagerDelegateKt.BUNDLE_INDEX_CARD_STYLE, style);
            context.sendBroadcast($this$setIndexCardStyle_u24lambda_u240);
        } catch (Exception e) {
            BLog.e(GarbManagerDelegateKt.TAG, "send broadcast error!");
        }
    }

    @JvmStatic
    public static final void clearMemoryLastGarb() {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        GarbStorageHelper.INSTANCE.setMLastGarb(null);
        try {
            Intent $this$clearMemoryLastGarb_u24lambda_u240 = new Intent(INSTANCE.getActionName(context));
            $this$clearMemoryLastGarb_u24lambda_u240.putExtra(GarbManagerDelegateKt.BUNDLE_BROADCAST_DATA_TYPE, 3);
            context.sendBroadcast($this$clearMemoryLastGarb_u24lambda_u240);
        } catch (Exception e) {
            BLog.e(GarbManagerDelegateKt.TAG, "garb send broadcast error!");
        }
    }

    @JvmStatic
    public static final void syncColorGarb(int themeId) {
        if (!GarbManagerDelegateKt.access$getCOLOR_MAP$p().containsValue(Integer.valueOf(themeId))) {
            return;
        }
        long garbId = themeId;
        Garb garb = new Garb();
        garb.setId(garbId);
        garb.setColorName(getColorNameById(themeId));
        sGarb = garb;
        Application it = BiliContext.application();
        if (it != null) {
            GarbStorageHelper.INSTANCE.clearOpGarb(it, garb.isNight());
        }
        GarbStorageHelper.INSTANCE.saveGarb(garb, false);
        notifyGarbChange$default(INSTANCE, garb, true, false, false, 12, null);
    }

    @JvmStatic
    public static final Garb saveColorGarb(String colorName) {
        Intrinsics.checkNotNullParameter(colorName, "colorName");
        if (!GarbManagerDelegateKt.access$getCOLOR_MAP$p().containsKey(colorName)) {
            return null;
        }
        Integer num = (Integer) GarbManagerDelegateKt.access$getCOLOR_MAP$p().get(colorName);
        long garbId = num != null ? num.intValue() : 8L;
        Garb garb = new Garb();
        garb.setId(garbId);
        garb.setColorName(colorName);
        Application it = BiliContext.application();
        if (it != null) {
            GarbStorageHelper.INSTANCE.clearOpGarb(it, garb.isNight());
        }
        GarbStorageHelper.INSTANCE.saveGarb(garb, false);
        return garb;
    }

    @JvmStatic
    public static final Garb saveGarb(GarbData.GarbDetail garbDetail) {
        Intrinsics.checkNotNullParameter(garbDetail, "garbDetail");
        Garb garb = INSTANCE.mapping(garbDetail);
        Application it = BiliContext.application();
        if (it != null) {
            if (!garbDetail.isOp()) {
                GarbStorageHelper.INSTANCE.clearOpGarb(it, garb.isNight());
            } else {
                GarbStorageHelper.INSTANCE.saveLastOpGarb(it, garbDetail.getId());
            }
        }
        GarbStorageHelper.INSTANCE.saveGarb(garb, garbDetail.isOp());
        return garb;
    }

    @JvmStatic
    public static final void setOtherDialogShowing(boolean isShowing) {
        sIsOtherDialogShowing = isShowing;
    }

    private final Garb mapping(GarbData.GarbDetail garbDetail) {
        Garb garb = new Garb();
        garb.setId(garbDetail.getId());
        garb.setName(garbDetail.getName());
        garb.setVer(garbDetail.getVer());
        garb.setLoadAllFile(true);
        GarbData.ColorDetail $this$mapping_u24lambda_u240 = garbDetail.getColorData();
        if ($this$mapping_u24lambda_u240 != null) {
            if (!garbDetail.primaryPageOnly()) {
                garb.setFontColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getPrimaryColor()));
                garb.setSecondaryPageColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getSecondaryColor()));
                garb.setDarkMode($this$mapping_u24lambda_u240.isDarkMode());
            } else {
                Application $this$mapping_u24lambda_u240_u240 = BiliContext.application();
                if ($this$mapping_u24lambda_u240_u240 != null) {
                    boolean isNight = MultipleThemeUtils.isNightTheme($this$mapping_u24lambda_u240_u240);
                    garb.setFontColor(INSTANCE.parseColor(isNight ? "#A2A7AE" : "#61666D"));
                    garb.setSecondaryPageColor(INSTANCE.parseColor(isNight ? "#17181A" : "#FFFFFF"));
                    garb.setDarkMode(!isNight);
                }
            }
            garb.setMainFontColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getPrimaryColor()));
            garb.setMainDarkMode($this$mapping_u24lambda_u240.isDarkMode());
            garb.setSideBgColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getSideBgColor()));
            garb.setSideLineColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getSideLineColor()));
            garb.setTailColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getTailColor()));
            garb.setTailSelectedColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getTailSelectedColor()));
            garb.setBtnBgStartColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getBtnBgStartColor()));
            garb.setBtnBgEndColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getBtnBgEndColor()));
            garb.setBtnIconColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getBtnIconColor()));
            garb.setHasAnimate($this$mapping_u24lambda_u240.getHasAnimate());
            garb.setAnimateLoop($this$mapping_u24lambda_u240.isAnimateLoop());
            garb.setMineAnimateLoop($this$mapping_u24lambda_u240.isMyselfAnimateLoop());
            garb.setTailColorModel($this$mapping_u24lambda_u240.isTailColorModel());
            garb.setTailIconColor(INSTANCE.parseColor($this$mapping_u24lambda_u240.getTailIconColor()));
            garb.setTailIconColorNight(INSTANCE.parseColor($this$mapping_u24lambda_u240.getTailIconColorNight()));
            garb.setTailIconColorSelected(INSTANCE.parseColor($this$mapping_u24lambda_u240.getTailIconColorSelected()));
            garb.setTailIconColorSelectedNight(INSTANCE.parseColor($this$mapping_u24lambda_u240.getTailIconColorSelectedNight()));
        }
        Map assets = GarbStorageHelper.INSTANCE.listAssetFilePath(garbDetail);
        garb.setHeadBgPath(mapping$getFromAsset(assets, "head_bg"));
        garb.setHeadTabBgPath(mapping$getFromAsset(assets, "head_tab_bg"));
        garb.setSideBgPath(mapping$getFromAsset(assets, "side_bg"));
        garb.setSideBottomBgPath(mapping$getFromAsset(assets, "side_bg_bottom"));
        garb.setTailBgPath(mapping$getFromAsset(assets, "tail_bg"));
        garb.setHeadMineBgPath(mapping$getFromAsset(assets, "head_myself_bg"));
        garb.setHeadMineSquaredBgPath(mapping$getFromAsset(assets, "head_myself_squared_bg"));
        garb.setHeadMineBgAnimatorPath(mapping$getFromAsset(assets, "head_myself_mp4_bg"));
        garb.setBtnIconPath(mapping$getFromAsset(assets, "tail_icon_pub_btn_bg"));
        garb.setBtnIconSelectedPath(mapping$getFromAsset(assets, "tail_icon_selected_pub_btn_bg"));
        garb.setTailIconPath(CollectionsKt.arrayListOf(new String[]{mapping$getFromAsset(assets, "tail_icon_main"), mapping$getFromAsset(assets, "tail_icon_channel"), mapping$getFromAsset(assets, "tail_icon_dynamic"), mapping$getFromAsset(assets, "tail_icon_shop"), mapping$getFromAsset(assets, "tail_icon_myself")}));
        garb.setTailIconSelectedPath(CollectionsKt.arrayListOf(new String[]{mapping$getFromAsset(assets, "tail_icon_selected_main"), mapping$getFromAsset(assets, "tail_icon_selected_channel"), mapping$getFromAsset(assets, "tail_icon_selected_dynamic"), mapping$getFromAsset(assets, "tail_icon_selected_shop"), mapping$getFromAsset(assets, "tail_icon_selected_myself")}));
        garb.setForce(garbDetail.isForce());
        garb.setChangeable(garbDetail.changeable());
        garb.setPrimaryOnly(garbDetail.primaryPageOnly());
        garb.setOp(garbDetail.isOp());
        return garb;
    }

    private static final String mapping$getFromAsset(Map<String, String> map, String key) {
        String str;
        return (map == null || (str = map.get(key)) == null) ? "" : str;
    }

    private final int parseColor(String colorStr) {
        if (TextUtils.isEmpty(colorStr)) {
            return 0;
        }
        try {
            return Color.parseColor(colorStr);
        } catch (Exception e) {
            return 0;
        }
    }

    @JvmStatic
    public static final String getColorNameById(int id) {
        Iterable $this$forEach$iv = GarbManagerDelegateKt.access$getCOLOR_MAP$p().entrySet();
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            if (((Number) it.getValue()).intValue() == id) {
                return (String) it.getKey();
            }
        }
        return GarbManagerDelegateKt.THEME_WHITE;
    }
}