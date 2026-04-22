package tv.danmaku.bili.ui.intent;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.gripper.api.ad.biz.GAdBizKt;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.homepage.UserProtocolDialogService;
import com.bilibili.lib.biliid.utils.Md5Utils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.util.SamplesKt;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.lib.performance.BootOpt;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.RouteConstKt;
import com.bilibili.lib.ui.Target;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.opd.app.bizcommon.hybridruntime.web.FlutterWebModCheckerKt;
import com.bilibili.pegasus.AutoJumpType;
import com.bilibili.pegasus.PegasusVisibleService;
import com.bilibili.pegasus.PegasusVisibleServiceKt;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.report.ReferrerUtil;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.report.startup.StartupApm;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.report.startup.v3.BootTracerV2;
import tv.danmaku.bili.ui.GarbUtils;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.intent.api.DynamicShareAPIService;
import tv.danmaku.bili.ui.main.InterceptUserProtocolActivity;
import tv.danmaku.bili.ui.main.deeplink.RedirectDeeplinkHelper;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.splash.LaunchInitialization;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.mod.SplashModHelper;
import tv.danmaku.bili.ui.video.main.H5AwakenTrackingHelper;
import tv.danmaku.bili.ui.video.main.StartUpUtil;
import tv.danmaku.bili.ui.video.main.UtilKt;

/* compiled from: IntentHandlerActivity.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001eH\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0014H\u0014J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ltv/danmaku/bili/ui/intent/IntentHandlerActivity;", "Landroid/app/Activity;", "Lcom/bilibili/base/util/DelayTaskController$IInterceptDialogHost;", "<init>", "()V", "isForeground", "", "shouldShowDialog", "notifyDismiss", "deeplinkUrl", "", "hasReport", "originUrl", "aiUrl", "target", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/intent/Phase;", "routerResponse", "Lcom/bilibili/lib/blrouter/RouteResponse;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "init", "finish", "addBackground", "tryStartActivity", "origin", "Landroid/content/Intent;", "hitOpenType", "addFromParam", "Landroid/net/Uri;", AudioIntentHelper.ARGS_URI, "checkPermission", "buildAuthUrl", "originIntent", "onDestroy", "isThirdFollowingPublish", "intent", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class IntentHandlerActivity extends android_app_Activity implements DelayTaskController.IInterceptDialogHost {
    public static final String KEY_FORCE_BACKGROUND = "KEY_FORCE_BACKGROUND";
    public static final String PARAMETER_DIRECT_BACK = "direct_back";
    public static final int SHARE_UNAUTHORIZED = 3;
    public static final String TAG = "Awake-IntentHandlerActivity";
    private String deeplinkUrl;
    private boolean hasReport;
    private boolean isForeground;
    private boolean notifyDismiss;
    private boolean shouldShowDialog;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private String originUrl = "";
    private String aiUrl = "";
    private Pair<String, ? extends Phase> target = new Pair<>("", Phase.NO_OP);
    private RouteResponse routerResponse = new RouteResponse(RouteResponse.Code.ERROR, new RouteRequest.Builder("error").build(), (String) null, (Object) null, (RouteRequest) null, (RouteResponse) null, (RouteResponse) null, 0, (int) BR.guideBarPaddingTop, (DefaultConstructorMarker) null);

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: IntentHandlerActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/intent/IntentHandlerActivity$Companion;", "", "<init>", "()V", IntentHandlerActivity.KEY_FORCE_BACKGROUND, "", "TAG", "PARAMETER_DIRECT_BACK", "SHARE_UNAUTHORIZED", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        this.isForeground = isForeground();
        super.onCreate(savedInstanceState);
        ReferrerUtil.INSTANCE.initReferrer((Activity) this);
        UtilKt.deepLinkTrack("IntentHandlerActivity onCreate");
        UtilKt.reportAwakeRef((Activity) this);
        BootOpt.resetAwakeReportFlag(BiliContext.topActivity() != null);
        BootTracerV2.INSTANCE.setLaunchOption(1);
        getWindow().setStatusBarColor(0);
        if (DelayTaskController.shouldBlock()) {
            UserProtocolHelper.showIntercept = true;
            UserProtocolBlockDialogEntrepot.INSTANCE.reset();
            addBackground();
            BLog.i(TAG, "privacy dialog block.");
            UserProtocolBlockDialogEntrepot.INSTANCE.triggerInit();
            UserProtocolHelper.showBlockDialog((Activity) this, new UserProtocolDialogListener() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$onCreate$1
                public void onAgree() {
                    IntentHandlerActivity.this.notifyDismiss = true;
                    UtilKt.deepLinkTrack("IntentHandlerActivity UserProtocolHelper onClick");
                    IntentHandlerActivity.this.init();
                }

                public void onCancel(boolean isFirstStep) {
                    UserProtocolDialogService service = (UserProtocolDialogService) BLRouter.INSTANCE.get(UserProtocolDialogService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
                    if (service != null && isFirstStep && service.hitVisitMode()) {
                        BLRouter.routeTo(new RouteRequest.Builder("bilibili://main/fake-main-page").overridePendingTransition(0, 0).build(), (Context) IntentHandlerActivity.this);
                    }
                }
            }, UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT);
            if (getIntent() != null && getIntent().getData() != null) {
                String url = String.valueOf(getIntent().getData());
                if (H5AwakenTrackingHelper.checkDeeplinkFormat(url)) {
                    this.deeplinkUrl = url;
                    UtilKt.deepLinkTrack("IntentHandlerActivity write onSaveInstanceState deeplinkUrl = " + this.deeplinkUrl);
                }
            }
            BootTracer.setFirstLaunch();
            BootTracer.setHasPrivacy();
            return;
        }
        UtilKt.deepLinkTrack("IntentHandlerActivity has agree user protocol");
        init();
    }

    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        String it = this.deeplinkUrl;
        if (it != null) {
            UtilKt.deepLinkTrack("IntentHandlerActivity onSaveInstanceState put url = " + it);
            outState.putString("deeplink_url_sp", it);
        }
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init() {
        Uri data;
        String dataString = getIntent().getDataString();
        if (dataString == null) {
            dataString = "";
        }
        this.originUrl = dataString;
        if (SplashModHelper.checkX86So((Context) this) && !SplashModHelper.isModLoaded()) {
            RouteRequest request = new RouteRequest.Builder("bilibili://root").build();
            this.target = new Pair<>("bilibili://root", Phase.X86);
            this.routerResponse = BLRouter.routeTo(request, (Context) this);
            UtilKt.deepLinkTrack("IntentHandlerActivity hit x86 or mod");
            BLog.i(TAG, "hit x86 or mod. route to main page.");
            finish();
            return;
        }
        this.shouldShowDialog = UserProtocolHelper.shouldShowDialog((Activity) this);
        UserProtocolHelper.showIntercept = this.shouldShowDialog;
        LaunchInitialization launchInitialization = LaunchInitialization.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        LaunchInitialization.initAndWait$default(launchInitialization, applicationContext, (Boolean) null, new Function0() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit init$lambda$0;
                init$lambda$0 = IntentHandlerActivity.init$lambda$0(IntentHandlerActivity.this);
                return init$lambda$0;
            }
        }, 2, (Object) null);
        StartupApm.setLaunchOption(1);
        Intent intent = getIntent();
        ClipboardChecker.setFromScheme(true, (intent == null || (data = intent.getData()) == null) ? null : data.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$0(final IntentHandlerActivity this$0) {
        Uri uri = this$0.getIntent().getData();
        boolean hitSpmid = RedirectDeeplinkHelper.hitSpmid(uri);
        final boolean hitOpenType = RedirectDeeplinkHelper.hitOpenType(uri);
        if (!this$0.shouldShowDialog && uri != null && RedirectDeeplinkHelper.INSTANCE.directDeeplinkEnable() && (hitSpmid || hitOpenType)) {
            this$0.addBackground();
            BLog.i(TAG, "will fetch redirect deeplink. origin url = " + this$0.getIntent().getDataString());
            RedirectDeeplinkHelper.fetchRedirectDeeplink(this$0.getIntent().getDataString(), new Function1() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit init$lambda$0$0;
                    init$lambda$0$0 = IntentHandlerActivity.init$lambda$0$0(IntentHandlerActivity.this, hitOpenType, (String) obj);
                    return init$lambda$0$0;
                }
            });
        } else {
            UtilKt.deepLinkTrack("IntentHandlerActivity can't fetchRedirectDeeplink shouldShowDialog = " + this$0.shouldShowDialog);
            BLog.i(TAG, "can't fetch redirect deeplink. origin url = " + this$0.getIntent().getDataString());
            Intent intent = this$0.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            this$0.tryStartActivity(intent, hitOpenType);
            this$0.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit init$lambda$0$0(IntentHandlerActivity this$0, boolean $hitOpenType, String it) {
        String result;
        if (it != null) {
            result = FlutterWebModCheckerKt.isNotNullAndNotEmpty(it) ? it : null;
        }
        result = this$0.getIntent().getDataString();
        if (result == null) {
            result = "";
        }
        this$0.aiUrl = result;
        this$0.target = new Pair<>(result, Phase.AI);
        RedirectDeeplinkHelper redirectDeeplinkHelper = RedirectDeeplinkHelper.INSTANCE;
        String dataString = this$0.getIntent().getDataString();
        redirectDeeplinkHelper.setOriginUrl(dataString != null ? dataString : "");
        this$0.getIntent().setData(Uri.parse(result));
        BLog.i(TAG, "fetch done. final url = " + result);
        Intent intent = this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        this$0.tryStartActivity(intent, $hitOpenType);
        this$0.finish();
        return Unit.INSTANCE;
    }

    public void finish() {
        if (!this.hasReport) {
            ReporterKt.doAwakeReport(this.originUrl, this.aiUrl, this.target, this.routerResponse.getCode().name());
            this.hasReport = true;
        }
        super.finish();
    }

    private final void addBackground() {
        final Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.layerlist_splash);
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 2;
            window.setNavigationBarColor(0);
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$addBackground$1$1
                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowAttached() {
                        window.setFlags(MisakaHelper.MAX_REPORT_SIZE, MisakaHelper.MAX_REPORT_SIZE);
                        if (NotchCompat.hasDisplayCutout(window)) {
                            NotchCompat.immersiveDisplayCutout(window);
                        }
                        window.getDecorView().getViewTreeObserver().removeOnWindowAttachListener(this);
                    }

                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowDetached() {
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void tryStartActivity(final Intent origin, boolean hitOpenType) {
        boolean isVideoDetail;
        boolean isVideo;
        Uri $this$tryStartActivity_u24lambda_u247_u240;
        Iterable runningTasks;
        Boolean bool;
        Iterable split$default;
        boolean z;
        if ((origin.getFlags() & 1048576) != 0) {
            BLog.i(TAG, "tryStartActivity match: FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY, route to main page.");
            RouteRequest request = new RouteRequest.Builder("bilibili://root").build();
            this.target = new Pair<>("bilibili://root", Phase.FROM_HISTORY);
            this.routerResponse = BLRouter.routeTo(request, (Context) this);
            return;
        }
        final Ref.ObjectRef uri = new Ref.ObjectRef();
        uri.element = origin.getData();
        if (uri.element == null) {
            Bundle bundle = origin.getExtras();
            String uriString = bundle != null ? bundle.getString(AudioIntentHelper.ARGS_URI) : null;
            if (uriString != null) {
                uri.element = Uri.parse(uriString);
            }
        }
        if (uri.element == null) {
            BLog.i(TAG, "tryStartActivity can't find intent.data, wtf.");
            return;
        }
        this.target = new Pair<>(((Uri) uri.element).toString(), Phase.FROM_URI);
        boolean z2 = false;
        if (hitOpenType && ConfigManager.Companion.ab2().getWithDefault("ff_splash_external_pullup_enable", false) && StartUpUtil.INSTANCE.getColdStartForAwaken()) {
            H5AwakenTrackingHelper.fromPullActiveUser = true;
            RouteRequest req = new RouteRequest.Builder("bilibili://root").extras(new Function1() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit tryStartActivity$lambda$0;
                    tryStartActivity$lambda$0 = IntentHandlerActivity.tryStartActivity$lambda$0(uri, (MutableBundleLike) obj);
                    return tryStartActivity$lambda$0;
                }
            }).build();
            this.target = new Pair<>("bilibili://root", Phase.FROM_LAHUO);
            this.routerResponse = BLRouter.routeTo(req, (Context) this);
            RouteResponse routeResponse = this.routerResponse;
            if (routeResponse != null && routeResponse.isSuccess()) {
                BLog.i(TAG, "tryStartActivity match: splash experiment, route to main page and may jump");
                return;
            }
            BLog.e(TAG, "splash pullup fail! url = " + uri.element);
        }
        if (Intrinsics.areEqual("blank", ((Uri) uri.element).getHost())) {
            String cmMark = ((Uri) uri.element).getQueryParameter("cm_mark");
            if (!TextUtils.isEmpty(cmMark)) {
                GAdBizKt.getGAdBiz().callback(((Uri) uri.element).toString());
            }
            if (this.isForeground) {
                return;
            }
            RouteRequest request2 = new RouteRequest.Builder("bilibili://root").build();
            this.target = new Pair<>("bilibili://root", Phase.BLANK);
            BLog.i(TAG, "tryStartActivity match: blank host, route to main page");
            this.routerResponse = BLRouter.routeTo(request2, (Context) this);
            return;
        }
        if (this.shouldShowDialog) {
            RouteRequest request3 = new RouteRequest.Builder(InterceptUserProtocolActivity.URI_BILIBILI_INTERCEPT_USER_PROTOCOL).extras(new Function1() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit tryStartActivity$lambda$1;
                    tryStartActivity$lambda$1 = IntentHandlerActivity.tryStartActivity$lambda$1(uri, this, (MutableBundleLike) obj);
                    return tryStartActivity$lambda$1;
                }
            }).build();
            this.target = new Pair<>(InterceptUserProtocolActivity.URI_BILIBILI_INTERCEPT_USER_PROTOCOL, Phase.USER_PROTOCOL);
            BLog.i(TAG, "tryStartActivity match: show user interceptor dialog, route to " + uri.element);
            this.routerResponse = BLRouter.routeTo(request3, (Context) this);
        } else if (isThirdFollowingPublish((Uri) uri.element, origin)) {
            Log.i("bundle.debug", "third party");
            uri.element = addFromParam(origin, (Uri) uri.element);
            boolean hasPermission = checkPermission(origin);
            RouteRequest.Builder $this$tryStartActivity_u24lambda_u242 = new RouteRequest.Builder((Uri) uri.element);
            Bundle extras = origin.getExtras();
            String string = extras != null ? extras.getString("share_return_url") : null;
            if (!(string == null || StringsKt.isBlank(string))) {
                $this$tryStartActivity_u24lambda_u242.prev(new RouteRequest.Builder("bilibili://root").flags(302022656).build());
            }
            RouteRequest req2 = $this$tryStartActivity_u24lambda_u242.extras(new Function1() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit tryStartActivity$lambda$3;
                    tryStartActivity$lambda$3 = IntentHandlerActivity.tryStartActivity$lambda$3(origin, (MutableBundleLike) obj);
                    return tryStartActivity$lambda$3;
                }
            }).clipData(origin.getClipData()).flags(33554433).build();
            this.target = new Pair<>(((Uri) uri.element).toString(), Phase.THIRD_FOLLOW_PUBLISH);
            if (hasPermission) {
                BLog.i(TAG, "tryStartActivity match: third following publish. route to " + uri.element);
                this.routerResponse = BLRouter.routeTo(req2, (Context) this);
            } else {
                setResult(3);
                this.routerResponse = new RouteResponse(RouteResponse.Code.ERROR, req2, (String) null, (Object) null, (RouteRequest) null, (RouteResponse) null, (RouteResponse) null, 0, (int) BR.guideBarPaddingTop, (DefaultConstructorMarker) null);
            }
        } else if (Intrinsics.areEqual("1", ((Uri) uri.element).getQueryParameter(PARAMETER_DIRECT_BACK))) {
            Neurons.trackCustom$default("main.intentHandler.directBack", 0, 0, 0, 0, 0, (String) null, MapsKt.mapOf(TuplesKt.to("url", ((Uri) uri.element).toString())), new Function0() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$$ExternalSyntheticLambda6
                public final Object invoke() {
                    boolean tryStartActivity$lambda$4;
                    tryStartActivity$lambda$4 = IntentHandlerActivity.tryStartActivity$lambda$4();
                    return Boolean.valueOf(tryStartActivity$lambda$4);
                }
            }, (int) BR.countdownTotal, (Object) null);
            RouteRequest req3 = new RouteRequest.Builder((Uri) uri.element).flags(268468224).build();
            BLog.i(TAG, "tryStartActivity match: direct back. route to " + uri.element);
            this.target = new Pair<>(((Uri) uri.element).toString(), Phase.DIRECT_BACK);
            this.routerResponse = BLRouter.routeTo(req3, (Context) this);
        } else if (this.isForeground) {
            BLog.i(TAG, "tryStartActivity match: foreground. route to " + uri.element);
            this.target = new Pair<>(((Uri) uri.element).toString(), Phase.FOREGROUND);
            this.routerResponse = BLRouter.routeTo(new RouteRequest.Builder((Uri) uri.element).build(), (Context) this);
        } else {
            boolean mainActivityExist = false;
            Target it = RouteConstKt.findRoute(BLRouter.INSTANCE, new RouteRequest.Builder((Uri) uri.element).build());
            if (it != null) {
                String str = (String) ConfigManager.Companion.config().get("intent_handler_no_root_activities", "com.bilibili.ship.theseus.detail.UnitedBizDetailsActivity,com.bilibili.video.story.StoryVideoActivity");
                if (str == null || (split$default = StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    bool = null;
                } else {
                    Iterable $this$any$iv = split$default;
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator it2 = $this$any$iv.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            Object element$iv = it2.next();
                            String className = (String) element$iv;
                            if (Intrinsics.areEqual(className, it.getClazz().getName())) {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                }
                if (bool != null) {
                    isVideoDetail = bool.booleanValue();
                    isVideo = isVideoDetail;
                    if (!isVideo) {
                        Object systemService = getSystemService(AudioIntentHelper.FROM_ACTIVITY);
                        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
                        if (activityManager == null || (runningTasks = activityManager.getRunningTasks(100)) == null) {
                            z2 = false;
                        } else {
                            Iterable $this$any$iv2 = runningTasks;
                            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                                Iterator<T> it3 = $this$any$iv2.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        z2 = false;
                                        break;
                                    }
                                    Object element$iv2 = it3.next();
                                    ActivityManager.RunningTaskInfo task = (ActivityManager.RunningTaskInfo) element$iv2;
                                    ComponentName componentName = task.baseActivity;
                                    boolean mainActivityExist2 = mainActivityExist;
                                    if (Intrinsics.areEqual(componentName != null ? componentName.getClassName() : null, MainActivityV2.class.getName())) {
                                        z2 = true;
                                        break;
                                    }
                                    mainActivityExist = mainActivityExist2;
                                }
                            }
                        }
                        mainActivityExist = z2;
                    }
                    RouteRequest.Builder $this$tryStartActivity_u24lambda_u247 = new RouteRequest.Builder((Uri) uri.element);
                    $this$tryStartActivity_u24lambda_u247_u240 = Uri.parse("bilibili://root");
                    if ((Intrinsics.areEqual(((Uri) uri.element).getScheme(), $this$tryStartActivity_u24lambda_u247_u240.getScheme()) || !Intrinsics.areEqual(((Uri) uri.element).getHost(), $this$tryStartActivity_u24lambda_u247_u240.getHost()) || !Intrinsics.areEqual(((Uri) uri.element).getPath(), $this$tryStartActivity_u24lambda_u247_u240.getPath())) && (!isVideoDetail || !mainActivityExist)) {
                        Intrinsics.checkNotNull($this$tryStartActivity_u24lambda_u247_u240);
                        $this$tryStartActivity_u24lambda_u247.prev(RouteRequestKt.toRouteRequest($this$tryStartActivity_u24lambda_u247_u240));
                    }
                    RouteRequest request4 = $this$tryStartActivity_u24lambda_u247.build();
                    BLog.i(TAG, "tryStartActivity match: else branch. route to " + uri.element);
                    this.target = new Pair<>(((Uri) uri.element).toString(), Phase.NORMAL);
                    this.routerResponse = BLRouter.routeTo(request4, (Context) this);
                }
            }
            isVideoDetail = false;
            isVideo = isVideoDetail;
            if (!isVideo) {
            }
            RouteRequest.Builder $this$tryStartActivity_u24lambda_u2472 = new RouteRequest.Builder((Uri) uri.element);
            $this$tryStartActivity_u24lambda_u247_u240 = Uri.parse("bilibili://root");
            if (Intrinsics.areEqual(((Uri) uri.element).getScheme(), $this$tryStartActivity_u24lambda_u247_u240.getScheme())) {
            }
            Intrinsics.checkNotNull($this$tryStartActivity_u24lambda_u247_u240);
            $this$tryStartActivity_u24lambda_u2472.prev(RouteRequestKt.toRouteRequest($this$tryStartActivity_u24lambda_u247_u240));
            RouteRequest request42 = $this$tryStartActivity_u24lambda_u2472.build();
            BLog.i(TAG, "tryStartActivity match: else branch. route to " + uri.element);
            this.target = new Pair<>(((Uri) uri.element).toString(), Phase.NORMAL);
            this.routerResponse = BLRouter.routeTo(request42, (Context) this);
        }
        RouteResponse routeResponse2 = this.routerResponse;
        if (routeResponse2 != null && routeResponse2.isSuccess()) {
            PegasusVisibleService pegasusVisibleService = PegasusVisibleServiceKt.getPegasusVisibleService();
            if (pegasusVisibleService != null) {
                pegasusVisibleService.onAutoJump(AutoJumpType.DEEPLINK, ((Uri) uri.element).toString());
            }
            GarbUtils.resetThemeWithFirstBoot((Context) this);
        } else if (isThirdFollowingPublish((Uri) uri.element, origin)) {
            ToastHelper.showToastShort((Context) this, "校验失败,请检查相关配置");
            this.target = new Pair<>("", Phase.ERROR_IN_FOLLOW);
            BLog.i(TAG, "校验失败,请检查相关配置");
        } else {
            this.target = new Pair<>("bilibili://root", Phase.ERROR);
            this.routerResponse = BLRouter.routeTo(new RouteRequest.Builder("bilibili://root").build(), (Context) this);
            BLog.i(TAG, "awake url parse error, url = " + uri.element + ", intent = " + origin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryStartActivity$lambda$0(Ref.ObjectRef $uri, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("deeplink_splash_scheme", String.valueOf($uri.element));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryStartActivity$lambda$1(Ref.ObjectRef $uri, IntentHandlerActivity this$0, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String uri = ((Uri) $uri.element).toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        $this$extras.put(InterceptUserProtocolActivity.KEY_TARGET_URI, uri);
        $this$extras.put(InterceptUserProtocolActivity.KEY_NEED_PRE_ACTIVITY, String.valueOf(!this$0.isForeground));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryStartActivity$lambda$3(Intent $origin, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        Bundle value = $origin.getExtras();
        if (value == null) {
            value = new Bundle();
        }
        String packageName = $origin.getStringExtra("share_biz_package");
        value.putString("share_from", "create.sdk." + packageName);
        $this$extras.put("key_bundle_extra", value);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean tryStartActivity$lambda$4() {
        return SamplesKt.sample(10);
    }

    private final Uri addFromParam(Intent origin, Uri uri) {
        String packageName = origin.getStringExtra("share_biz_package");
        String str = packageName;
        if (str == null || StringsKt.isBlank(str)) {
            return uri;
        }
        Uri build = uri.buildUpon().appendQueryParameter("share_from", "create.sdk." + packageName).build();
        if (build == null) {
            build = uri;
        }
        Uri result = build;
        return result;
    }

    private final boolean checkPermission(Intent origin) {
        final Ref.ObjectRef body = new Ref.ObjectRef();
        body.element = "";
        final String authUrl = buildAuthUrl(origin);
        HandlerThreads.runOnBlocking(2, new Runnable() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                IntentHandlerActivity.checkPermission$lambda$0(authUrl, body);
            }
        });
        boolean z = false;
        try {
            GeneralResponse result = (GeneralResponse) JSON.parseObject((String) body.element, new TypeReference<GeneralResponse<DynamicShareAPIService.CheckResult>>() { // from class: tv.danmaku.bili.ui.intent.IntentHandlerActivity$checkPermission$result$1
            }, new Feature[0]);
            Boolean checkPackage = ((DynamicShareAPIService.CheckResult) result.data).getCheckPackage();
            if (checkPackage != null) {
                z = checkPackage.booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean hasPermission = z;
        BLog.i(TAG, "Third party hasPermission" + hasPermission);
        return hasPermission;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermission$lambda$0(String $authUrl, Ref.ObjectRef $body) {
        OkHttpClient client = OkHttpClientWrapper.get();
        Request.Builder requestBuilder = new Request.Builder().url($authUrl);
        Intrinsics.checkNotNullExpressionValue(requestBuilder, "url(...)");
        Response response = client.newCall(requestBuilder.build()).execute();
        ResponseBody body = response.body();
        $body.element = (body == null || (r3 = body.string()) == null) ? "" : "";
    }

    private final String buildAuthUrl(Intent originIntent) {
        String clientId = originIntent.getStringExtra("share_biz_client_id");
        String clientSecret = originIntent.getStringExtra("share_biz_client_secret");
        String packageName = originIntent.getStringExtra("share_biz_package");
        long ts = System.currentTimeMillis() / 1000;
        String sign = Md5Utils.encoderByMd5("client_id=" + clientId + "&package=" + packageName + "&ts=" + ts + clientSecret);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(AppConfig.SCHEME_HTTP).authority("api.bilibili.com").appendPath("x").appendPath("account-oauth2").appendPath("v1").appendPath("app").appendPath("check").appendQueryParameter("client_id", clientId).appendQueryParameter("ts", String.valueOf(ts)).appendQueryParameter("sign", sign).appendQueryParameter("package", packageName);
        String uri = builder.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    private final boolean isForeground() {
        if (!getIntent().getBooleanExtra(KEY_FORCE_BACKGROUND, true)) {
            return false;
        }
        return BiliContext.isForeground();
    }

    protected void onDestroy() {
        if (!this.hasReport) {
            ReporterKt.doAwakeReport(this.originUrl, this.aiUrl, this.target, this.routerResponse.getCode().name());
            this.hasReport = true;
        }
        super.onDestroy();
        if (this.notifyDismiss) {
            UserProtocolHelper.onInterceptDialogDismiss();
        }
    }

    private final boolean isThirdFollowingPublish(Uri uri, Intent intent) {
        boolean isThirdParty = intent.getBooleanExtra("share_biz_third_party", false);
        return Intrinsics.areEqual(uri.getScheme(), "bilibili") && Intrinsics.areEqual(uri.getHost(), "following") && Intrinsics.areEqual(uri.getPath(), "/publish") && isThirdParty;
    }
}