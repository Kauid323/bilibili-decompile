package tv.danmaku.bili.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.util.SamplesKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.helper.NotchCompat;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.intent.IntentHandlerActivity;
import tv.danmaku.bili.ui.main.deeplink.RedirectDeeplinkHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolDismissObserver;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.video.main.UtilKt;

/* compiled from: InterceptUserProtocolActivity.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0014J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/main/InterceptUserProtocolActivity;", "Landroidx/fragment/app/FragmentActivity;", "Ltv/danmaku/bili/ui/main2/userprotocol/UserProtocolDismissObserver;", "<init>", "()V", "targetUri", "", "needPreActivity", "", "Ljava/lang/Boolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "routeToTarget", "originUri", "Landroid/net/Uri;", AudioIntentHelper.ARGS_URI, "onDismiss", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onAttachedToWindow", "onUserProtocolDismiss", "from", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InterceptUserProtocolActivity extends FragmentActivity implements UserProtocolDismissObserver {
    public static final String KEY_NEED_PRE_ACTIVITY = "need_pre_activity";
    public static final String KEY_TARGET_URI = "target_uri";
    public static final String TAG = "InterceptUserProtocolActivity";
    public static final String URI_BILIBILI_INTERCEPT_USER_PROTOCOL = "bilibili://main/intercept-user-protocol";
    private Boolean needPreActivity = false;
    private String targetUri;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        Uri uri;
        super.onCreate(savedInstanceState);
        UserProtocolHelper.showIntercept = true;
        UserProtocolHelper.UserDialogDismissWatcher.subscribe(this);
        Bundle bundle = getIntent().getExtras();
        UtilKt.deepLinkTrack("InterceptUserProtocolActivity onCreate");
        UtilKt.reportAwakeRef((Activity) this);
        if (bundle != null) {
            this.targetUri = BundleUtil.getString(bundle, KEY_TARGET_URI, new String[0]);
            this.needPreActivity = Boolean.valueOf(BundleUtil.getBoolean(bundle, KEY_NEED_PRE_ACTIVITY, new boolean[]{false}));
            BLog.d(TAG, "target uri =" + this.targetUri + " needPreActivity=" + this.needPreActivity);
        }
        if (TextUtils.isEmpty(this.targetUri)) {
            uri = Uri.parse("bilibili://root");
            Intrinsics.checkNotNull(uri);
        } else {
            uri = Uri.parse(this.targetUri);
            Intrinsics.checkNotNull(uri);
        }
        UserProtocolHelper.showDialog((Activity) this, new InterceptUserProtocolActivity$onCreate$1(uri, this), UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeToTarget(Uri originUri, Uri uri) {
        RedirectDeeplinkHelper.INSTANCE.setOriginUrl((originUri == null || (r1 = originUri.toString()) == null) ? "" : "");
        if (TextUtils.equals(uri.getQueryParameter(IntentHandlerActivity.PARAMETER_DIRECT_BACK), "1")) {
            Neurons.trackCustom$default("main.intentHandler.directBack", 0, 0, 0, 0, 0, (String) null, MapsKt.mapOf(TuplesKt.to("url", uri.toString())), new Function0() { // from class: tv.danmaku.bili.ui.main.InterceptUserProtocolActivity$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean routeToTarget$lambda$0;
                    routeToTarget$lambda$0 = InterceptUserProtocolActivity.routeToTarget$lambda$0();
                    return Boolean.valueOf(routeToTarget$lambda$0);
                }
            }, (int) BR.countdownTotal, (Object) null);
            BLRouter.routeTo(new RouteRequest.Builder(uri).flags(268468224).build(), (Context) this);
        } else if (!AppsFlyerManager.INSTANCE.getJumpPerformed()) {
            AppsFlyerManager.INSTANCE.setJumpPerformed(true);
            RouteRequest.Builder $this$routeToTarget_u24lambda_u241 = new RouteRequest.Builder(uri);
            if (Intrinsics.areEqual(this.needPreActivity, true)) {
                Uri parse = Uri.parse("bilibili://root");
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                $this$routeToTarget_u24lambda_u241.prev(new RouteRequest.Builder(parse).build());
            }
            RouteRequest request = $this$routeToTarget_u24lambda_u241.build();
            BLRouter.routeTo(request, (Context) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean routeToTarget$lambda$0() {
        return SamplesKt.sample(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDismiss() {
        UserProtocolHelper.showIntercept = false;
        UserProtocolHelper.onInterceptDialogDismiss();
    }

    protected void onDestroy() {
        super.onDestroy();
        UserProtocolHelper.UserDialogDismissWatcher.unSubscribe(this);
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            this.targetUri = BundleUtil.getString(bundle, KEY_TARGET_URI, new String[0]);
            this.needPreActivity = Boolean.valueOf(BundleUtil.getBoolean(bundle, KEY_NEED_PRE_ACTIVITY, new boolean[]{false}));
            BLog.d(TAG, "target uri =" + this.targetUri + " needPreActivity=" + this.needPreActivity);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (NotchCompat.hasDisplayCutout(getWindow())) {
            NotchCompat.immersiveDisplayCutout(getWindow());
        }
    }

    /* compiled from: InterceptUserProtocolActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/main/InterceptUserProtocolActivity$Companion;", "", "<init>", "()V", "URI_BILIBILI_INTERCEPT_USER_PROTOCOL", "", "KEY_TARGET_URI", "KEY_NEED_PRE_ACTIVITY", "TAG", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.bili.ui.main2.userprotocol.UserProtocolDismissObserver
    public void onUserProtocolDismiss(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        BLog.d("UserProtocolDialogWatcher", "from" + from);
        if (TextUtils.equals(from, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH)) {
            finish();
        }
    }
}