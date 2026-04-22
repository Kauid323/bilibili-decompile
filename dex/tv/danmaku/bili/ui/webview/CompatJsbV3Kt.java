package tv.danmaku.bili.ui.webview;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.extra.ActivityResult;
import com.bilibili.lib.blrouter.extra.BLRouterStartActivityForResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CompatJsbV3.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u001a0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002¨\u0006\u000e"}, d2 = {"routerForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/bilibili/lib/blrouter/RouteRequest;", "Landroidx/activity/ComponentActivity;", "requestKey", "", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "callback", "Landroidx/activity/result/ActivityResultCallback;", "Lcom/bilibili/lib/blrouter/extra/ActivityResult;", "startForResult", "Landroid/content/Intent;", "intent", "Landroidx/activity/result/ActivityResult;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CompatJsbV3Kt {
    public static final /* synthetic */ ActivityResultLauncher access$routerForResult(ComponentActivity $receiver, String requestKey, RouteRequest request, ActivityResultCallback callback) {
        return routerForResult($receiver, requestKey, request, callback);
    }

    public static final /* synthetic */ ActivityResultLauncher access$startForResult(ComponentActivity $receiver, String requestKey, Intent intent, ActivityResultCallback callback) {
        return startForResult($receiver, requestKey, intent, callback);
    }

    public static final ActivityResultLauncher<RouteRequest> routerForResult(final ComponentActivity $this$routerForResult, String requestKey, RouteRequest request, final ActivityResultCallback<ActivityResult> activityResultCallback) {
        ActivityResultLauncher launcher = $this$routerForResult.getActivityResultRegistry().register(requestKey, BLRouterStartActivityForResult.INSTANCE, new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3Kt$$ExternalSyntheticLambda1
            public final void onActivityResult(Object obj) {
                CompatJsbV3Kt.routerForResult$lambda$0($this$routerForResult, activityResultCallback, (ActivityResult) obj);
            }
        });
        launcher.launch(request);
        return launcher;
    }

    public static final void routerForResult$lambda$0(ComponentActivity $this_routerForResult, ActivityResultCallback $callback, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!$this_routerForResult.isFinishing() && !$this_routerForResult.isDestroyed()) {
            $callback.onActivityResult(it);
        }
    }

    public static final ActivityResultLauncher<Intent> startForResult(final ComponentActivity $this$startForResult, String requestKey, Intent intent, final ActivityResultCallback<androidx.activity.result.ActivityResult> activityResultCallback) {
        ActivityResultLauncher launcher = $this$startForResult.getActivityResultRegistry().register(requestKey, new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3Kt$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                CompatJsbV3Kt.startForResult$lambda$0($this$startForResult, activityResultCallback, (androidx.activity.result.ActivityResult) obj);
            }
        });
        launcher.launch(intent);
        return launcher;
    }

    public static final void startForResult$lambda$0(ComponentActivity $this_startForResult, ActivityResultCallback $callback, androidx.activity.result.ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!$this_startForResult.isFinishing() && !$this_startForResult.isDestroyed()) {
            $callback.onActivityResult(result);
        }
    }
}