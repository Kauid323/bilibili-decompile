package tv.danmaku.bili.wauth;

import android.content.Intent;
import android.os.SystemClock;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.extra.ActivityResult;
import com.bilibili.lib.blrouter.extra.BLRouterStartActivityForResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WAuthInvoker.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/wauth/WAuthInvoker;", "", "<init>", "()V", "TAG", "", "REAL_NAME_WAUTH_URL", "auth", "Ltv/danmaku/bili/wauth/WAuthResult;", "activity", "Landroidx/activity/ComponentActivity;", "requestKey", "(Landroidx/activity/ComponentActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResult", "intent", "Landroid/content/Intent;", "routerForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/bilibili/lib/blrouter/RouteRequest;", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "callback", "Landroidx/activity/result/ActivityResultCallback;", "Lcom/bilibili/lib/blrouter/extra/ActivityResult;", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WAuthInvoker {
    private final String TAG = "WAuthInvoker";
    private final String REAL_NAME_WAUTH_URL = "bilibili://user_center/auth/wauth";

    public static /* synthetic */ Object auth$default(WAuthInvoker wAuthInvoker, ComponentActivity componentActivity, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "WAuthInvoker-" + SystemClock.elapsedRealtimeNanos();
        }
        return wAuthInvoker.auth(componentActivity, str, continuation);
    }

    public final Object auth(ComponentActivity activity, String requestKey, Continuation<? super WAuthResult> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        RouteRequest request = new RouteRequest.Builder(this.REAL_NAME_WAUTH_URL).build();
        routerForResult(activity, requestKey, request, new ActivityResultCallback() { // from class: tv.danmaku.bili.wauth.WAuthInvoker$auth$2$1
            public final void onActivityResult(ActivityResult result) {
                WAuthResult handleResult;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.getResultCode() == 0) {
                    Result.Companion companion = Result.Companion;
                    it.resumeWith(Result.constructor-impl(new WAuthResult(false, null, null, null, "1", null, 46, null)));
                } else if (result.getResultCode() == -1) {
                    Result.Companion companion2 = Result.Companion;
                    handleResult = this.handleResult(result.getData());
                    it.resumeWith(Result.constructor-impl(handleResult));
                } else {
                    Result.Companion companion3 = Result.Companion;
                    it.resumeWith(Result.constructor-impl(new WAuthResult(false, null, null, null, "-1", null, 46, null)));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WAuthResult handleResult(Intent intent) {
        String detail;
        if (intent == null) {
            return new WAuthResult(false, null, null, null, "-1", null, 46, null);
        }
        String code = intent.getStringExtra("code");
        if (code == null) {
            code = "";
        }
        if (Intrinsics.areEqual(code, "0")) {
            String stringExtra = intent.getStringExtra("bizSeq");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String bizSeq = stringExtra;
            if (bizSeq.length() > 0) {
                String stringExtra2 = intent.getStringExtra("idCardAuthData");
                String str = stringExtra2 == null ? "" : stringExtra2;
                String stringExtra3 = intent.getStringExtra("certPwdData");
                return new WAuthResult(true, bizSeq, str, stringExtra3 == null ? "" : stringExtra3, null, null, 48, null);
            }
            String stringExtra4 = intent.getStringExtra("detail");
            detail = stringExtra4 != null ? stringExtra4 : "";
            BLog.e(this.TAG, "wauth failed, code = " + code + ", detail = " + detail);
            return new WAuthResult(false, null, null, null, code, detail, 14, null);
        }
        String stringExtra5 = intent.getStringExtra("detail");
        detail = stringExtra5 != null ? stringExtra5 : "";
        BLog.e(this.TAG, "wauth failed, code = " + code + ", detail = " + detail);
        return new WAuthResult(false, null, null, null, code, detail, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityResultLauncher<RouteRequest> routerForResult(final ComponentActivity $this$routerForResult, String requestKey, RouteRequest request, final ActivityResultCallback<ActivityResult> activityResultCallback) {
        ActivityResultLauncher launcher = $this$routerForResult.getActivityResultRegistry().register(requestKey, BLRouterStartActivityForResult.INSTANCE, new ActivityResultCallback() { // from class: tv.danmaku.bili.wauth.WAuthInvoker$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                WAuthInvoker.routerForResult$lambda$0($this$routerForResult, activityResultCallback, (ActivityResult) obj);
            }
        });
        launcher.launch(request);
        return launcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void routerForResult$lambda$0(ComponentActivity $this_routerForResult, ActivityResultCallback $callback, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!$this_routerForResult.isFinishing() && !$this_routerForResult.isDestroyed()) {
            $callback.onActivityResult(it);
        }
    }
}