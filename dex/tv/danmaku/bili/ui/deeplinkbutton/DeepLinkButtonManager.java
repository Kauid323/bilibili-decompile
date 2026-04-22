package tv.danmaku.bili.ui.deeplinkbutton;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.ipc.IPCAppStateManager;
import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.okretro.BiliApiDataCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonView;
import tv.danmaku.bili.ui.deeplinkbutton.api.DeepLinkButtonApiManager;
import tv.danmaku.bili.ui.deeplinkbutton.api.DeepLinkButtonInfo;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;

/* compiled from: DeepLinkButtonManager.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000bH\u0003J$\u0010\"\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010&\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/DeepLinkButtonManager;", "", "<init>", "()V", "mDisplayHeight", "", "mStatusBarHeight", "views", "", "Ltv/danmaku/bili/ui/deeplinkbutton/DeepLinkButtonView;", "isLand", "", "EXTRA_FRAGMENT_ARGS", "", "distanceY", "mBtnCallBack", "Landroid/app/Application$ActivityLifecycleCallbacks;", "shouldShow", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "analyzingData", "targetUrl", "initialize", "", "context", "Landroid/content/Context;", "attach", "app", "Landroid/app/Application;", "detach", "showButtonView", "buttonInfo", "Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonInfo;", "fromApi", "dismiss", "clearInfo", "clickView", "clearDeepLinkInfo", "deepLinkButtonInfo", "getDeepLinkButtonInfo", "()Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonInfo;", "updateDeepLinkButtonInfo", "TAG", "SP_KEY_DEEP_LINK_INFO", "KEY_BTN_CHANNEL", "DeepLinkButtonCallBack", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DeepLinkButtonManager {
    private static final String EXTRA_FRAGMENT_ARGS = "fragment_args";
    private static final String KEY_BTN_CHANNEL = "btn_channel";
    private static final String SP_KEY_DEEP_LINK_INFO = "deep_link_info";
    private static final String TAG = "DeepLinkButtonManager";
    private static int distanceY;
    private static boolean isLand;
    private static int mDisplayHeight;
    private static int mStatusBarHeight;
    public static final DeepLinkButtonManager INSTANCE = new DeepLinkButtonManager();
    private static final Map<Integer, DeepLinkButtonView> views = new HashMap();
    private static final Application.ActivityLifecycleCallbacks mBtnCallBack = new Application.ActivityLifecycleCallbacks() { // from class: tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonManager$mBtnCallBack$1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            boolean shouldShow;
            Intent intent;
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            if (!(activity instanceof IntentHandlerActivity)) {
                shouldShow = DeepLinkButtonManager.INSTANCE.shouldShow(activity);
                if (shouldShow && savedInstanceState == null && (intent = activity.getIntent()) != null) {
                    Uri data = intent.getData();
                    if (data != null) {
                        DeepLinkButtonManager deepLinkButtonManager = DeepLinkButtonManager.INSTANCE;
                        String uri = data.toString();
                        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                        deepLinkButtonManager.analyzingData(uri, activity);
                        return;
                    }
                    Bundle bundle = intent.getBundleExtra("fragment_args");
                    if (bundle != null) {
                        DeepLinkButtonManager deepLinkButtonManager2 = DeepLinkButtonManager.INSTANCE;
                        String string = bundle.getString("blrouter.pureurl");
                        if (string == null) {
                            string = "";
                        }
                        deepLinkButtonManager2.analyzingData(string, activity);
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
            r0 = tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonManager.INSTANCE.getDeepLinkButtonInfo();
         */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onActivityStarted(Activity activity) {
            boolean shouldShow;
            DeepLinkButtonInfo deepLinkButtonInfo;
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            if (!(activity instanceof IntentHandlerActivity)) {
                shouldShow = DeepLinkButtonManager.INSTANCE.shouldShow(activity);
                if (shouldShow && deepLinkButtonInfo != null && deepLinkButtonInfo.isPagesPassed()) {
                    DeepLinkButtonManager.INSTANCE.showButtonView(activity, deepLinkButtonInfo, false);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Map map;
            int i;
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            try {
                map = DeepLinkButtonManager.views;
                DeepLinkButtonView view = (DeepLinkButtonView) map.get(Integer.valueOf(activity.hashCode()));
                if (view != null && view.getWindowToken() != null) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
                    i = DeepLinkButtonManager.distanceY;
                    ((WindowManager.LayoutParams) layoutParams).y = i;
                    view.setAlpha(1.0f);
                    Object systemService = activity.getSystemService("window");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                    WindowManager windowManager = (WindowManager) systemService;
                    windowManager.updateViewLayout(view, view.getLayoutParams());
                }
            } catch (Exception e) {
                BLog.e("DeepLinkButtonManager", "onActivityResumed", e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Map map;
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            map = DeepLinkButtonManager.views;
            DeepLinkButtonView deepLinkButtonView = (DeepLinkButtonView) map.get(Integer.valueOf(activity.hashCode()));
            if (deepLinkButtonView != null) {
                deepLinkButtonView.setAlpha(0.0f);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            DeepLinkButtonManager.dismiss$default(DeepLinkButtonManager.INSTANCE, activity, false, null, 4, null);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            DeepLinkButtonManager.dismiss$default(DeepLinkButtonManager.INSTANCE, activity, false, null, 4, null);
        }
    };
    public static final int $stable = 8;

    private DeepLinkButtonManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldShow(Activity activity) {
        DeepLinkButtonView view = views.get(Integer.valueOf(activity.hashCode()));
        if (view != null && view.getWindowToken() != null) {
            BLog.i(TAG, "is showing");
            return false;
        } else if (Build.VERSION.SDK_INT >= 24 && (activity.isInMultiWindowMode() || activity.isInPictureInPictureMode())) {
            BLog.i(TAG, "activity is InMultiWindowMode or InPictureInPictureMode");
            return false;
        } else {
            boolean isConfigOn = TextUtils.equals((CharSequence) ConfigManager.Companion.config().get("deeplink.show_back_icon", "1"), "1");
            if (!isConfigOn) {
                BLog.i(TAG, "is config on=" + isConfigOn);
            }
            return isConfigOn;
        }
    }

    public final boolean analyzingData(String targetUrl, Activity activity) {
        Intrinsics.checkNotNullParameter(targetUrl, "targetUrl");
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        BLog.i(TAG, "url is= " + targetUrl);
        if (TextUtils.isEmpty(targetUrl)) {
            return false;
        }
        Uri uri = Uri.parse(targetUrl);
        try {
            String channelContent = uri.getQueryParameter(KEY_BTN_CHANNEL);
            if (TextUtils.isEmpty(channelContent)) {
                BLog.i(TAG, "channel Content is empty");
                return false;
            }
            DeepLinkButtonApiManager.getDeepLinkButtonInfo(targetUrl, new DeepLinkButtonCallBack(activity));
            return true;
        } catch (Exception e) {
            BLog.i(TAG, "uri is not illegal");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeepLinkButtonManager.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/DeepLinkButtonManager$DeepLinkButtonCallBack;", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonInfo;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mActivityWeakReference", "Ljava/lang/ref/WeakReference;", "isCancel", "", "onDataSuccess", "", "data", "onError", "t", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DeepLinkButtonCallBack extends BiliApiDataCallback<DeepLinkButtonInfo> {
        private final WeakReference<Activity> mActivityWeakReference;

        public DeepLinkButtonCallBack(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            this.mActivityWeakReference = new WeakReference<>(activity);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean isCancel() {
            boolean isCancel;
            if (this.mActivityWeakReference.get() != null) {
                Activity activity = this.mActivityWeakReference.get();
                Intrinsics.checkNotNull(activity);
                if (!activity.isFinishing()) {
                    isCancel = false;
                    if (isCancel) {
                        BLog.i(DeepLinkButtonManager.TAG, "get info cancel");
                    }
                    return isCancel;
                }
            }
            isCancel = true;
            if (isCancel) {
            }
            return isCancel;
        }

        public void onDataSuccess(DeepLinkButtonInfo data) {
            if (data == null) {
                return;
            }
            BLog.i(DeepLinkButtonManager.TAG, "get info success is " + data);
            DeepLinkButtonManager.INSTANCE.updateDeepLinkButtonInfo(data);
            DeepLinkButtonManager deepLinkButtonManager = DeepLinkButtonManager.INSTANCE;
            Activity activity = this.mActivityWeakReference.get();
            Intrinsics.checkNotNull(activity);
            deepLinkButtonManager.showButtonView(activity, data, true);
        }

        public void onError(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            BLog.e(DeepLinkButtonManager.TAG, "get info from api error", t);
        }
    }

    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application app = (Application) applicationContext;
        attach(app);
    }

    private final void attach(Application app) {
        detach(app);
        app.registerActivityLifecycleCallbacks(mBtnCallBack);
        IPCAppStateManager.getInstance().addIPCActivityStateCallback(new IPCAppStateManager.GlobalVisibilityChangeCallback() { // from class: tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonManager$attach$1
            public void onBackground() {
                Map map;
                DeepLinkButtonManager.INSTANCE.clearDeepLinkInfo();
                map = DeepLinkButtonManager.views;
                map.clear();
            }

            public void onForeground() {
            }
        });
    }

    private final void detach(Application app) {
        app.unregisterActivityLifecycleCallbacks(mBtnCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showButtonView(final Activity activity, final DeepLinkButtonInfo buttonInfo, final boolean fromApi) {
        if (activity.isFinishing() || TextUtils.isEmpty(buttonInfo.getBackUrl()) || !shouldShow(activity)) {
            return;
        }
        dismiss$default(this, activity, false, null, 4, null);
        mDisplayHeight = WindowManagerHelper.getDisplayHeight(activity);
        mStatusBarHeight = StatusBarCompat.getStatusBarHeight(activity);
        final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        mLayoutParams.flags = 65832;
        mLayoutParams.gravity = 8388659;
        mLayoutParams.type = 1003;
        mLayoutParams.x = 0;
        int orientation = activity.getResources().getConfiguration().orientation;
        if (orientation == 2) {
            isLand = true;
            if (buttonInfo.getViewLandDistanceY() == 0) {
                buttonInfo.setViewLandDistanceY(mDisplayHeight / 2);
                mLayoutParams.y = buttonInfo.getViewLandDistanceY();
            } else {
                mLayoutParams.y = buttonInfo.getViewLandDistanceY();
            }
        } else {
            isLand = false;
            if (buttonInfo.getViewPortDistanceY() != 0) {
                mLayoutParams.y = buttonInfo.getViewPortDistanceY();
            } else {
                buttonInfo.setViewPortDistanceY(mDisplayHeight - DisplayUtils.dp2Px(120));
                mLayoutParams.y = buttonInfo.getViewPortDistanceY();
            }
        }
        distanceY = mLayoutParams.y;
        Object systemService = activity.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        final WindowManager windowManager = (WindowManager) systemService;
        final DeepLinkButtonView mButtonView = new DeepLinkButtonView(activity, null, 0, 6, null);
        mButtonView.setDeepLinkButtonInfo(buttonInfo, new DeepLinkButtonView.IDeepLinkViewListen() { // from class: tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonManager$showButtonView$1
            @Override // tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonView.IDeepLinkViewListen
            public void onClickJump(String backUrl) {
                Intrinsics.checkNotNullParameter(backUrl, "backUrl");
                DeepLinkButtonReport.reportButtonBackClick(DeepLinkButtonInfo.this.getBtnChannel());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(backUrl));
                intent.setFlags(268435456);
                try {
                    activity.startActivity(intent);
                } catch (Exception e) {
                    BLog.e("DeepLinkButtonManager", "start third activity", e);
                }
                DeepLinkButtonManager.INSTANCE.dismiss(activity, true, mButtonView);
            }

            @Override // tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonView.IDeepLinkViewListen
            public void onClickClose() {
                DeepLinkButtonReport.reportButtonCloseClick(DeepLinkButtonInfo.this.getBtnChannel());
                DeepLinkButtonManager.INSTANCE.dismiss(activity, true, mButtonView);
            }

            @Override // tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonView.IDeepLinkViewListen
            public void onTouchEvent(int dy) {
                int i;
                int i2;
                int i3;
                boolean z;
                int i4;
                try {
                    WindowManager.LayoutParams it = mLayoutParams;
                    WindowManager windowManager2 = windowManager;
                    DeepLinkButtonView deepLinkButtonView = mButtonView;
                    DeepLinkButtonInfo deepLinkButtonInfo = DeepLinkButtonInfo.this;
                    it.y += dy;
                    int i5 = it.y;
                    i = DeepLinkButtonManager.mStatusBarHeight;
                    if (i5 < i) {
                        i4 = DeepLinkButtonManager.mStatusBarHeight;
                        it.y = i4;
                    } else {
                        int i6 = it.y;
                        i2 = DeepLinkButtonManager.mDisplayHeight;
                        if (i6 > i2) {
                            i3 = DeepLinkButtonManager.mDisplayHeight;
                            it.y = i3;
                        }
                    }
                    DeepLinkButtonManager deepLinkButtonManager = DeepLinkButtonManager.INSTANCE;
                    DeepLinkButtonManager.distanceY = it.y;
                    windowManager2.updateViewLayout(deepLinkButtonView, it);
                    z = DeepLinkButtonManager.isLand;
                    if (z) {
                        deepLinkButtonInfo.setViewLandDistanceY(it.y);
                    } else {
                        deepLinkButtonInfo.setViewPortDistanceY(it.y);
                    }
                } catch (Exception e) {
                    BLog.e("DeepLinkButtonManager", "on move", e);
                }
            }

            @Override // tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonView.IDeepLinkViewListen
            public void onDistanceChange() {
                DeepLinkButtonManager.INSTANCE.updateDeepLinkButtonInfo(DeepLinkButtonInfo.this);
            }

            @Override // tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonView.IDeepLinkViewListen
            public void onPortLandChange(int orientation2) {
                int i;
                int i2;
                DeepLinkButtonManager deepLinkButtonManager = DeepLinkButtonManager.INSTANCE;
                DeepLinkButtonManager.mDisplayHeight = WindowManagerHelper.getDisplayHeight(activity);
                switch (orientation2) {
                    case 1:
                        DeepLinkButtonManager deepLinkButtonManager2 = DeepLinkButtonManager.INSTANCE;
                        DeepLinkButtonManager.isLand = false;
                        DeepLinkButtonInfo deepLinkButtonInfo = DeepLinkButtonInfo.this;
                        i = DeepLinkButtonManager.mDisplayHeight;
                        deepLinkButtonInfo.setViewPortDistanceY(i - DisplayUtils.dp2Px(120));
                        mLayoutParams.y = DeepLinkButtonInfo.this.getViewPortDistanceY();
                        DeepLinkButtonInfo.this.setViewLandDistanceY(0);
                        break;
                    case 2:
                        DeepLinkButtonManager deepLinkButtonManager3 = DeepLinkButtonManager.INSTANCE;
                        DeepLinkButtonManager.isLand = true;
                        DeepLinkButtonInfo deepLinkButtonInfo2 = DeepLinkButtonInfo.this;
                        i2 = DeepLinkButtonManager.mDisplayHeight;
                        deepLinkButtonInfo2.setViewLandDistanceY(i2 / 2);
                        mLayoutParams.y = DeepLinkButtonInfo.this.getViewLandDistanceY();
                        DeepLinkButtonInfo.this.setViewPortDistanceY(0);
                        break;
                }
                DeepLinkButtonManager deepLinkButtonManager4 = DeepLinkButtonManager.INSTANCE;
                DeepLinkButtonManager.distanceY = mLayoutParams.y;
                DeepLinkButtonManager.INSTANCE.updateDeepLinkButtonInfo(DeepLinkButtonInfo.this);
                try {
                    windowManager.updateViewLayout(mButtonView, mLayoutParams);
                } catch (Exception e) {
                    BLog.e("DeepLinkButtonManager", "onPortLandChange", e);
                }
            }
        });
        View contentView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(contentView, "getDecorView(...)");
        contentView.post(new Runnable() { // from class: tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeepLinkButtonManager.showButtonView$lambda$0(windowManager, mButtonView, mLayoutParams, activity, fromApi, buttonInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showButtonView$lambda$0(WindowManager $windowManager, DeepLinkButtonView $mButtonView, WindowManager.LayoutParams $mLayoutParams, Activity $activity, boolean $fromApi, DeepLinkButtonInfo $buttonInfo) {
        try {
            $windowManager.addView($mButtonView, $mLayoutParams);
            views.put(Integer.valueOf($activity.hashCode()), $mButtonView);
            BLog.i(TAG, "addView view " + $activity);
            if ($fromApi) {
                DeepLinkButtonReport.reportButtonShow($buttonInfo.getBtnChannel());
            }
        } catch (Exception e) {
            BLog.e(TAG, "add view" + $activity.getComponentName(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void dismiss$default(DeepLinkButtonManager deepLinkButtonManager, Activity activity, boolean z, DeepLinkButtonView deepLinkButtonView, int i, Object obj) {
        if ((i & 4) != 0) {
            deepLinkButtonView = null;
        }
        deepLinkButtonManager.dismiss(activity, z, deepLinkButtonView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss(Activity activity, boolean clearInfo, DeepLinkButtonView clickView) {
        try {
            Object systemService = activity.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager mWindowManager = (WindowManager) systemService;
            if (clickView != null) {
                mWindowManager.removeViewImmediate(clickView);
                BLog.i(TAG, "remove view from click " + clickView);
            }
            DeepLinkButtonView view = views.get(Integer.valueOf(activity.hashCode()));
            if (view != null && view.getWindowToken() != null) {
                mWindowManager.removeViewImmediate(view);
                BLog.i(TAG, "remove view from activity " + activity);
            }
            views.remove(Integer.valueOf(activity.hashCode()));
        } catch (Exception e) {
            BLog.e(TAG, "dismiss", e);
        }
        if (clearInfo) {
            clearDeepLinkInfo();
            views.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearDeepLinkInfo() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference == null || (edit = bLKVSharedPreference.edit()) == null || (putString = edit.putString(SP_KEY_DEEP_LINK_INFO, "")) == null) {
            return;
        }
        putString.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeepLinkButtonInfo getDeepLinkButtonInfo() {
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        String spString = bLKVSharedPreference != null ? bLKVSharedPreference.getString(SP_KEY_DEEP_LINK_INFO, "") : null;
        if (TextUtils.isEmpty(spString)) {
            return null;
        }
        try {
            DeepLinkButtonInfo deepLinkButtonInfo = (DeepLinkButtonInfo) JSONObject.parseObject(spString, DeepLinkButtonInfo.class);
            return deepLinkButtonInfo;
        } catch (Exception e) {
            BLog.e(TAG, "get info error", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDeepLinkButtonInfo(DeepLinkButtonInfo deepLinkButtonInfo) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        String updateInfo = JSONObject.toJSONString(deepLinkButtonInfo);
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
        if (bLKVSharedPreference == null || (edit = bLKVSharedPreference.edit()) == null || (putString = edit.putString(SP_KEY_DEEP_LINK_INFO, updateInfo)) == null) {
            return;
        }
        putString.apply();
    }
}