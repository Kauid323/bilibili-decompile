package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.homepage.UserProtocolDialogService;
import com.bilibili.lib.biliweb.AbstractWebActivity;
import com.bilibili.lib.biliweb.MWebToolbar;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.jsbridge.legacy.WebProxyV2;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.startup.v2.BootTracer;
import tv.danmaku.bili.ui.intent.Phase;
import tv.danmaku.bili.ui.intent.ReporterKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialogEntrepot;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.ui.video.main.UtilKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InstantEventWebActivity.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0014J\b\u0010\u0017\u001a\u00020\rH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0014J\b\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/webview/InstantEventWebActivity;", "Lcom/bilibili/lib/biliweb/AbstractWebActivity;", "Lcom/bilibili/base/util/DelayTaskController$IInterceptDialogHost;", "<init>", "()V", "originUrl", "", "target", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/intent/Phase;", "hasReport", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initWebActivitySettings", "getWebUrl", "getBiliWebViewID", "", "getContentViewID", "initContentView", "initViewsAndWindowAttributes", "onBackPressed", "initProgressBar", "Landroid/widget/ProgressBar;", "finish", "onDestroy", "routeToMain", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InstantEventWebActivity extends AbstractWebActivity implements DelayTaskController.IInterceptDialogHost {
    public static final String SCHEME = "bilibili://instant_event";
    private static final String TAG = "Awake-InstantEventWebActivity";
    private boolean hasReport;
    private String originUrl = "";
    private Pair<String, ? extends Phase> target = new Pair<>("", Phase.FROM_INSTANT_WEB);
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: InstantEventWebActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/webview/InstantEventWebActivity$Companion;", "", "<init>", "()V", "TAG", "", "SCHEME", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(final Bundle savedInstanceState) {
        boolean shouldBlock = DelayTaskController.shouldBlock();
        if (shouldBlock) {
            BiliTheme.setCurrentTheme((Context) this, 8);
        }
        super.onCreate(savedInstanceState);
        UtilKt.reportAwakeRef((Activity) this);
        String dataString = getIntent().getDataString();
        if (dataString == null) {
            dataString = "";
        }
        this.originUrl = dataString;
        this.target = new Pair<>(this.originUrl, Phase.FROM_INSTANT_WEB);
        if (shouldBlock) {
            UserProtocolBlockDialogEntrepot.INSTANCE.triggerInit();
            UserProtocolHelper.showBlockDialog((Activity) this, new UserProtocolDialogListener() { // from class: tv.danmaku.bili.ui.webview.InstantEventWebActivity$onCreate$1
                public void onAgree() {
                    InstantEventWebActivity.this.setShouldInterceptCustomOverrideUrlLoading(false);
                    BLog.i("Awake-InstantEventWebActivity", "router to web. url = " + InstantEventWebActivity.this.getIntent().getDataString());
                    super/*com.bilibili.lib.biliweb.AbstractWebActivity*/.doOnCreate(savedInstanceState);
                }

                public void onCancel(boolean isFirstStep) {
                    UserProtocolDialogService service = (UserProtocolDialogService) BLRouter.INSTANCE.get(UserProtocolDialogService.class, "default");
                    if (service != null && isFirstStep && service.hitVisitMode()) {
                        BLRouter.routeTo(new RouteRequest.Builder("bilibili://main/fake-main-page").overridePendingTransition(0, 0).build(), (Context) InstantEventWebActivity.this);
                    }
                }
            }, "intercept", true);
            BootTracer.setFirstLaunch();
            BootTracer.setHasPrivacy();
        }
    }

    protected void initWebActivitySettings() {
        super.initWebActivitySettings();
        setEnableToolbar(true);
        getReporter().setEnvironment("noReport");
        setShouldInterceptCustomOverrideUrlLoading(true);
    }

    public String getWebUrl() {
        Uri uri = getIntent().getData();
        if (uri == null) {
            BLog.e(TAG, "empty intent data!");
            finish();
        }
        String valueOf = String.valueOf(uri);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = valueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.startsWith$default(lowerCase, SCHEME, false, 2, (Object) null)) {
            Intrinsics.checkNotNull(uri);
            String url = uri.getQueryParameter("url");
            if (url != null) {
                return url;
            }
        }
        return String.valueOf(uri);
    }

    public int getBiliWebViewID() {
        return R.id.webview;
    }

    public int getContentViewID() {
        return R.id.content_frame;
    }

    public void initContentView() {
        setContentView(R.layout.bili_app_activity_mweb);
    }

    protected void initViewsAndWindowAttributes() {
        super.initViewsAndWindowAttributes();
        if (this.mToolbar instanceof MWebToolbar) {
            MWebToolbar mWebToolbar = this.mToolbar;
            Intrinsics.checkNotNull(mWebToolbar, "null cannot be cast to non-null type com.bilibili.lib.biliweb.MWebToolbar");
            mWebToolbar.setOnMWebClickListener(new MWebToolbar.OnMWebClickListener() { // from class: tv.danmaku.bili.ui.webview.InstantEventWebActivity$$ExternalSyntheticLambda0
                public final void onClickClose() {
                    InstantEventWebActivity.initViewsAndWindowAttributes$lambda$0(InstantEventWebActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewsAndWindowAttributes$lambda$0(InstantEventWebActivity this$0) {
        if (DelayTaskController.shouldBlock() || DelayTaskController.isMainProcInitializing()) {
            this$0.finish();
            ProcessUtils.killOtherProcess((Context) this$0);
            ProcessUtils.suicide();
            return;
        }
        this$0.routeToMain();
        this$0.finish();
    }

    public void onBackPressed() {
        if (DelayTaskController.shouldBlock() || DelayTaskController.isMainProcInitializing()) {
            finish();
            ProcessUtils.killOtherProcess((Context) this);
            ProcessUtils.suicide();
            return;
        }
        if (getWebProxyLegacy() != null) {
            WebProxyV2 webProxyLegacy = getWebProxyLegacy();
            Intrinsics.checkNotNull(webProxyLegacy);
            if (webProxyLegacy.onBackPressed()) {
                return;
            }
        }
        if (getWebView().canGoBack()) {
            getWebView().goBack();
            getWebView().postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.webview.InstantEventWebActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    InstantEventWebActivity.onBackPressed$lambda$0(InstantEventWebActivity.this);
                }
            }, 1000L);
            return;
        }
        routeToMain();
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$0(InstantEventWebActivity this$0) {
        if (this$0.getTransNavigation() || this$0.isDestroyCalled()) {
            return;
        }
        String title = this$0.getWebView().getTitle();
        ActionBar supportActionBar = this$0.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
        }
    }

    public ProgressBar initProgressBar() {
        return (ProgressBar) findViewById(R.id.progress_horizontal);
    }

    public void finish() {
        if (!this.hasReport) {
            ReporterKt.doAwakeReport(this.originUrl, "", this.target, "OK");
            this.hasReport = true;
        }
        super.finish();
    }

    protected void onDestroy() {
        BLog.i(TAG, "onDestroy");
        if (!DelayTaskController.shouldBlock()) {
            BLog.i(TAG, "reportInstantEvent");
            getReporter().reportInstantEvent();
        }
        if (!this.hasReport) {
            ReporterKt.doAwakeReport(this.originUrl, "", this.target, "OK");
            this.hasReport = true;
        }
        super.onDestroy();
    }

    private final void routeToMain() {
        Uri uri = Uri.parse("bilibili://root");
        Intrinsics.checkNotNull(uri);
        RouteRequest request = new RouteRequest.Builder(uri).build();
        BLRouter.routeTo(request, (Context) this);
        BLog.i(TAG, "routeToMain");
    }
}