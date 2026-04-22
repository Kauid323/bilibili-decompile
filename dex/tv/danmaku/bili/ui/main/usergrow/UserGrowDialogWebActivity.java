package tv.danmaku.bili.ui.main.usergrow;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import com.bilibili.app.comm.IJsBridgeBehavior;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.app.comm.bhwebview.api.interfaces.SslError;
import com.bilibili.app.comm.bhwebview.api.interfaces.SslErrorHandler;
import com.bilibili.app.comm.bhwebview.api.interfaces.WebResourceError;
import com.bilibili.app.comm.bhwebview.api.interfaces.WebResourceRequest;
import com.bilibili.app.comm.bhwebview.api.interfaces.WebResourceResponse;
import com.bilibili.app.comm.restrict.lessonsmode.core.JsBridgeLessonsModeFactory;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.app.provider.IUiHideNavigationBehavior;
import com.bilibili.app.provider.IUiSetStatusBarModeBehavior;
import com.bilibili.app.provider.IUiSetStatusBarVisibilityBehavior;
import com.bilibili.app.provider.IUiSetTitleBehavior;
import com.bilibili.app.provider.IUiShowNavigationBehavior;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.biliweb.AbstractWebActivity;
import com.bilibili.lib.biliweb.BiliWebViewConfigHolderV2;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.foundation.Foundation;
import com.bilibili.lib.jsbridge.special.PvInfo;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.helper.NotchCompat;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.lib.ui.webview2.WebSuicide;
import com.bilibili.pvtracker.PageViewTracker;
import com.bilibili.teenagersmode.jsbridge.JsBridgeCallHandlerTeenagers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: UserGrowDialogWebActivity.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u001c\u0010\u0016\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J.\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010'\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\u0012\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u00102\u001a\u00020\u0013H\u0014J\b\u00103\u001a\u00020\u0013H\u0014J\u0010\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\u0013H\u0016J\b\u00107\u001a\u00020\u0013H\u0014J\b\u00108\u001a\u00020\u0013H\u0014J\b\u00109\u001a\u00020\u000fH\u0016J\b\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\u0013H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u0013H\u0014J\b\u0010@\u001a\u00020\u0013H\u0014J\b\u0010A\u001a\u00020\u0013H\u0016J\b\u0010B\u001a\u00020\u0013H\u0014J\b\u0010C\u001a\u00020\u0013H\u0016J\u0012\u0010D\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010E\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00182\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020H\u0018\u00010\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowDialogWebActivity;", "Lcom/bilibili/lib/biliweb/AbstractWebActivity;", "Lcom/bilibili/pvtracker/PageViewTracker$OnSwitchToBackgroundListener;", "<init>", "()V", "mCurPvInfo", "Lcom/bilibili/lib/jsbridge/special/PvInfo;", "mHasStartReport", "", "mLoadType", "", "mIvClose", "Landroid/widget/ImageView;", "mTrackEnable", "mTrackData", "", "mCloseWay", "errorFinish", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "track", InnerPushReceiverKt.KEY_EXTRA, "", "onAttachedToWindow", "onPageFinished", "view", "Lcom/bilibili/app/comm/bh/BiliWebView;", "url", "onReceivedError", "webView", "webResourceRequest", "Lcom/bilibili/app/comm/bhwebview/api/interfaces/WebResourceRequest;", "webResourceError", "Lcom/bilibili/app/comm/bhwebview/api/interfaces/WebResourceError;", "errorCode", "description", "failingUrl", "onReceivedSslError", "sslErrorHandler", "Lcom/bilibili/app/comm/bhwebview/api/interfaces/SslErrorHandler;", "sslError", "Lcom/bilibili/app/comm/bhwebview/api/interfaces/SslError;", "onReceivedHttpError", "webResourceResponse", "Lcom/bilibili/app/comm/bhwebview/api/interfaces/WebResourceResponse;", "onBackPressed", "onReceivePvCallback", "pvInfo", "onResume", "onPause", "finishWithWay", "way", "finish", "tintSystemBar", "initWebUrl", "getWebUrl", "getBiliWebViewID", "getContentViewID", "initContentView", "initProgressBar", "Landroid/widget/ProgressBar;", "initWebConfigHolder", "initBuildInJsBridge", "hideNavigation", "onDestroy", "switchToBackground", "doStartReport", "doEndReport", "convertToExtraMap", "paramsMap", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserGrowDialogWebActivity extends AbstractWebActivity implements PageViewTracker.OnSwitchToBackgroundListener {
    private static final int CLOSE_WAY_ERROR = 2;
    private static final int CLOSE_WAY_H5 = 1;
    private static final int CLOSE_WAY_MANUAL = 0;
    private static final String HTTPS_SCHEMA = "https://";
    private static final String HTTP_SCHEMA = "http://";
    private static final int LOAD_TYPE_BACK = 1;
    private static final int LOAD_TYPE_ENTER = 0;
    private static final String TAG = "UserGrowDialogWebActivity";
    private PvInfo mCurPvInfo;
    private boolean mHasStartReport;
    private ImageView mIvClose;
    private int mLoadType;
    private boolean mTrackEnable;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private String mTrackData = "";
    private int mCloseWay = 1;
    private final boolean errorFinish = DeviceDecision.INSTANCE.getBoolean("dd.webview.user_grow_dialog_error_finish_enable", false);

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: UserGrowDialogWebActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowDialogWebActivity$Companion;", "", "<init>", "()V", "TAG", "", "LOAD_TYPE_ENTER", "", "LOAD_TYPE_BACK", "HTTP_SCHEMA", "HTTPS_SCHEMA", "CLOSE_WAY_MANUAL", "CLOSE_WAY_H5", "CLOSE_WAY_ERROR", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        WebSuicide.enter(TAG);
        getWindow().addFlags(MisakaHelper.MAX_REPORT_SIZE);
        super.onCreate(savedInstanceState);
        this.mTrackEnable = BundleUtil.getBoolean(getIntent().getExtras(), UserGrowManager.KEY_TRACK_ENABLE, new boolean[0]);
        Bundle extras = getIntent().getExtras();
        this.mTrackData = (extras == null || (r0 = extras.getString(UserGrowManager.KEY_TRACK_DATA)) == null) ? "" : "";
        View innerView = getWebView().getInnerView();
        if (innerView != null) {
            innerView.setBackgroundColor(ContextCompat.getColor((Context) this, R.color.user_grow_background_trans));
        }
        UserGrowSpHelper.Companion.setDialogShowing((Context) this, true);
        PageViewTracker.getInstance().registerSwitchToBackgroundListener(this);
        this.mIvClose = (ImageView) findViewById(R.id.close);
        ImageView imageView = this.mIvClose;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowDialogWebActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserGrowDialogWebActivity.onCreate$lambda$0(UserGrowDialogWebActivity.this, view);
                }
            });
        }
        if (this.mTrackEnable) {
            Neurons.reportExposure$default(false, "growth.recommended.window.middle.show", MapsKt.mapOf(TuplesKt.to("report_data", this.mTrackData)), (List) null, 8, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(UserGrowDialogWebActivity this$0, View it) {
        this$0.finishWithWay(0);
        this$0.track(MapsKt.mapOf(TuplesKt.to("reason", "1")));
    }

    private final void track(Map<String, String> map) {
        if (this.mTrackEnable) {
            Neurons.trackT$default(false, "main.7days.window.close", map, 0, new Function0() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowDialogWebActivity$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean track$lambda$0;
                    track$lambda$0 = UserGrowDialogWebActivity.track$lambda$0();
                    return Boolean.valueOf(track$lambda$0);
                }
            }, 8, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean track$lambda$0() {
        return true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (NotchCompat.hasDisplayCutout(getWindow())) {
            NotchCompat.immersiveDisplayCutout(getWindow());
        }
    }

    public void onPageFinished(BiliWebView view, String url) {
        super.onPageFinished(view, url);
        ImageView imageView = this.mIvClose;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void onReceivedError(BiliWebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Uri url;
        Uri url2;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        BLog.e(TAG, "page finished cause receive error 1:" + (webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null) + ", url:" + ((webResourceRequest == null || (url2 = webResourceRequest.getUrl()) == null) ? null : url2.toString()));
        if (this.errorFinish) {
            finishWithWay(2);
        } else {
            if (Intrinsics.areEqual((webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString(), getUrl())) {
                finishWithWay(2);
            }
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("reason", "2");
        pairArr[1] = TuplesKt.to("ext", "receive error " + (webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null));
        track(MapsKt.mapOf(pairArr));
    }

    public void onReceivedError(BiliWebView webView, int errorCode, String description, String failingUrl) {
        super.onReceivedError(webView, errorCode, description, failingUrl);
        BLog.e(TAG, "page finished cause receive error 2:" + errorCode + ", url:" + failingUrl);
        if (this.errorFinish) {
            finishWithWay(2);
        } else if (Intrinsics.areEqual(failingUrl, getUrl())) {
            finishWithWay(2);
        }
        track(MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "2"), TuplesKt.to("ext", "receive error " + errorCode)}));
    }

    public void onReceivedSslError(BiliWebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        BLog.e(TAG, "page finished cause receive ssl error, url:" + (sslError != null ? sslError.getUrl() : null));
        if (this.errorFinish) {
            finishWithWay(2);
        } else {
            if (Intrinsics.areEqual(sslError != null ? sslError.getUrl() : null, getUrl())) {
                finishWithWay(2);
            }
        }
        track(MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "2"), TuplesKt.to("ext", "receive ssl error")}));
    }

    public void onReceivedHttpError(BiliWebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Uri url;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        BLog.e(TAG, "page finished cause receive http error:" + (webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null));
        if (this.errorFinish) {
            finishWithWay(2);
        } else {
            if (Intrinsics.areEqual((webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString(), getUrl())) {
                finishWithWay(2);
            }
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("reason", "2");
        pairArr[1] = TuplesKt.to("ext", "receive http error " + (webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null));
        track(MapsKt.mapOf(pairArr));
    }

    public void onBackPressed() {
        this.mCloseWay = 0;
        super.onBackPressed();
    }

    public void onReceivePvCallback(PvInfo pvInfo) {
        this.mCurPvInfo = pvInfo;
        doStartReport(pvInfo);
    }

    protected void onResume() {
        super.onResume();
        doStartReport(this.mCurPvInfo);
    }

    protected void onPause() {
        super.onPause();
        doEndReport(this.mCurPvInfo);
        this.mLoadType = 1;
    }

    private final void finishWithWay(int way) {
        this.mCloseWay = way;
        finish();
    }

    public void finish() {
        super.finish();
        if (this.mTrackEnable) {
            Neurons.reportClick(false, "growth.recommended.window.middle.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", this.mTrackData), TuplesKt.to("way", String.valueOf(this.mCloseWay))}));
        }
    }

    protected void tintSystemBar() {
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() | MisakaHelper.MAX_REPORT_SIZE | BR.hallEnterHotText;
        getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
        getWindow().setStatusBarColor(0);
    }

    protected void initWebUrl() {
        super.initWebUrl();
        Uri uri = getIntent().getData();
        if (uri != null) {
            return;
        }
        String decoded = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(decoded)) {
            getIntent().setData(Uri.parse(decoded));
        }
    }

    public String getWebUrl() {
        Uri data = getIntent().getData();
        String url = (data == null || (url = data.toString()) == null) ? "" : "";
        if (TextUtils.isEmpty(url) || (!StringsKt.startsWith(url, HTTP_SCHEMA, true) && !StringsKt.startsWith(url, HTTPS_SCHEMA, true))) {
            finish();
        }
        return url;
    }

    public int getBiliWebViewID() {
        return R.id.webview;
    }

    public int getContentViewID() {
        return R.id.content;
    }

    public void initContentView() {
        setContentView(R.layout.bili_app_activity_user_grow_dialog);
    }

    public ProgressBar initProgressBar() {
        return null;
    }

    protected void initWebConfigHolder() {
        setWebViewConfigHolder(new BiliWebViewConfigHolderV2(getWebView(), getProgress()));
        BiliWebViewConfigHolderV2 $this$initWebConfigHolder_u24lambda_u240 = getWebViewConfigHolder();
        $this$initWebConfigHolder_u24lambda_u240.configBiliWebSettings(Uri.parse(getUrl()), Foundation.Companion.instance().getApps().getVersionCode(), false);
        $this$initWebConfigHolder_u24lambda_u240.configBiliWebCookie();
    }

    protected void initBuildInJsBridge() {
        super.initBuildInJsBridge();
        getWebView().registerUiHideNavigationBehavior(new IUiHideNavigationBehavior() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowDialogWebActivity$initBuildInJsBridge$1
            public /* synthetic */ void release() {
                IJsBridgeBehavior.-CC.$default$release(this);
            }

            public void hideNavigation() {
                UserGrowDialogWebActivity.this.hideNavigation();
            }

            public boolean isDestroyed() {
                return UserGrowDialogWebActivity.this.isFinishing();
            }
        });
        getWebView().registerUiShowNavigationBehavior(new IUiShowNavigationBehavior() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowDialogWebActivity$initBuildInJsBridge$2
            public /* synthetic */ void release() {
                IJsBridgeBehavior.-CC.$default$release(this);
            }

            public void showNavigation() {
                UserGrowDialogWebActivity.this.showNavigation();
            }

            public boolean isDestroyed() {
                return UserGrowDialogWebActivity.this.isFinishing();
            }
        });
        getWebView().registerUiSetStatusBarVisibilityBehavior(new IUiSetStatusBarVisibilityBehavior() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowDialogWebActivity$initBuildInJsBridge$3
            public /* synthetic */ void release() {
                IJsBridgeBehavior.-CC.$default$release(this);
            }

            public void setStatusBarVisibility(boolean isVisible) {
                UserGrowDialogWebActivity.this.setStatusBarVisibility(isVisible);
            }

            public boolean isDestroyed() {
                return UserGrowDialogWebActivity.this.isFinishing();
            }
        });
        getWebView().registerUiSetStatusBarModeBehavior(new IUiSetStatusBarModeBehavior() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowDialogWebActivity$initBuildInJsBridge$4
            public /* synthetic */ void release() {
                IJsBridgeBehavior.-CC.$default$release(this);
            }

            public void setStatusBarMode(int mode) {
                switch (mode) {
                    case 0:
                        StatusBarCompat.setStatusBarDarkMode((Activity) UserGrowDialogWebActivity.this);
                        return;
                    case 1:
                        StatusBarCompat.setStatusBarLightMode((Activity) UserGrowDialogWebActivity.this);
                        return;
                    default:
                        return;
                }
            }

            public boolean isDestroyed() {
                return UserGrowDialogWebActivity.this.isFinishing();
            }
        });
        getWebView().registerUiSetTitleBehavior(new IUiSetTitleBehavior() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowDialogWebActivity$initBuildInJsBridge$5
            public /* synthetic */ void release() {
                IJsBridgeBehavior.-CC.$default$release(this);
            }

            public void setTitle(String title) {
                Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
                if (UserGrowDialogWebActivity.this.getSupportActionBar() != null) {
                    ActionBar supportActionBar = UserGrowDialogWebActivity.this.getSupportActionBar();
                    Intrinsics.checkNotNull(supportActionBar);
                    supportActionBar.setTitle(title);
                }
            }

            public boolean isDestroyed() {
                return UserGrowDialogWebActivity.this.isFinishing();
            }
        });
        registerBuiltInJsBridge("teenagers", (JsBridgeCallHandlerFactoryV2) new JsBridgeCallHandlerTeenagers.JsBridgeCallHandlerTeenagersFactory((Activity) this));
        registerBuiltInJsBridge("lessons", (JsBridgeCallHandlerFactoryV2) new JsBridgeLessonsModeFactory());
    }

    public void hideNavigation() {
        super.hideNavigation();
        ImageView imageView = this.mIvClose;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    protected void onDestroy() {
        BLog.d(TAG, "call onDestroy");
        super.onDestroy();
        WebSuicide.leave(TAG);
        UserGrowSpHelper.Companion.setDialogShowing((Context) this, false);
        setResult(-1);
        PageViewTracker.getInstance().unregisterSwitchToBackgroundListener(this);
        MainDialogManager.notifyDialogDismiss((Context) this);
    }

    public void switchToBackground() {
        this.mLoadType = 0;
    }

    private final void doStartReport(PvInfo pvInfo) {
        if (this.mHasStartReport || pvInfo == null) {
            return;
        }
        Map paramMap = convertToExtraMap(pvInfo.getParamsMap());
        PageViewTracker.startInH5(pvInfo.getEventId(), this.mLoadType, System.currentTimeMillis(), paramMap);
        this.mHasStartReport = true;
    }

    private final void doEndReport(PvInfo pvInfo) {
        if (pvInfo == null) {
            return;
        }
        Map paramMap = convertToExtraMap(pvInfo.getParamsMap());
        PageViewTracker.endInH5(pvInfo.getEventId(), this.mLoadType, System.currentTimeMillis(), paramMap);
        this.mHasStartReport = false;
    }

    private final Map<String, String> convertToExtraMap(Map<String, ? extends Object> map) {
        HashMap extraMap = new HashMap();
        if (map == null) {
            return extraMap;
        }
        for (String key : map.keySet()) {
            extraMap.put(key, String.valueOf(map.get(key)));
        }
        return extraMap;
    }
}