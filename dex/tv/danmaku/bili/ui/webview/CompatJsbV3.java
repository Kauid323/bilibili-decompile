package tv.danmaku.bili.ui.webview;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.app.comm.rubick.api.ContainerInfo;
import com.bilibili.app.comm.rubick.api.ContainerStatus;
import com.bilibili.app.comm.rubick.api.ICommonContainer;
import com.bilibili.app.comm.rubick.api.JsbBizException;
import com.bilibili.app.comm.rubick.api.ToastDuration;
import com.bilibili.jsbridge.api.common.Button;
import com.bilibili.jsbridge.api.common.KeyboardStatusResp;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.extra.ActivityResult;
import com.bilibili.lib.jsbridge.common.ContainerStatusWatcher;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: CompatJsbV3.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/webview/CompatJsbV3;", "", "<init>", "()V", "TAG", "", "compat", "", "host", "Ltv/danmaku/bili/ui/webview/MWebActivity;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CompatJsbV3 {
    public static final int $stable = 0;
    public static final CompatJsbV3 INSTANCE = new CompatJsbV3();
    private static final String TAG = "Webview_JSB_MWebActivity";

    private CompatJsbV3() {
    }

    public final void compat(final MWebActivity host) {
        Intrinsics.checkNotNullParameter(host, "host");
        BiliWebView webView = host.mWebView;
        webView.registerPrivacyController(Reflection.getOrCreateKotlinClass(ICommonContainer.class), (ICommonContainer) new ICommonContainer() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1
            public Object setNavigationBarTitle(String title, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$setNavigationBarTitle$2(MWebActivity.this, title, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object setNavigationBarTitleColor(int color, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$setNavigationBarTitleColor$2(MWebActivity.this, color, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object setNavigationBarBackgroundColor(int color, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$setNavigationBarBackgroundColor$2(MWebActivity.this, color, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object setNavigationBarVisibility(boolean show, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$setNavigationBarVisibility$2(MWebActivity.this, show, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object getCurNavigationButton(Continuation<? super List<Button>> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object setNavigationButton(List<Button> list, Continuation<? super Unit> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object updateNavigationButton(Button button, Continuation<? super Unit> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object observeContainerClick(Continuation<? super Flow<String>> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object toast(String message, ToastDuration duration, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$toast$2(MWebActivity.this, message, duration, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object showPageLoading(boolean show, Continuation<? super Unit> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object close(Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$close$2(MWebActivity.this, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object launch(RouteRequest request, Continuation<? super ActivityResult> continuation) {
                ComponentActivity componentActivity = MWebActivity.this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuation continuation2 = cancellableContinuationImpl;
                CompatJsbV3Kt.access$routerForResult(componentActivity, "rq#jsb", request, new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$launch$2$1
                    public final void onActivityResult(ActivityResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (continuation2.isActive()) {
                            Result.Companion companion = Result.Companion;
                            continuation2.resumeWith(Result.constructor-impl(it));
                        }
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            }

            public Object launch(Intent intent, Continuation<? super androidx.activity.result.ActivityResult> continuation) {
                ComponentActivity componentActivity = MWebActivity.this;
                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuation continuation2 = cancellableContinuationImpl;
                CompatJsbV3Kt.access$startForResult(componentActivity, "aq#jsb", intent, new ActivityResultCallback() { // from class: tv.danmaku.bili.ui.webview.CompatJsbV3$compat$commonContainer$1$launch$4$1
                    public final void onActivityResult(androidx.activity.result.ActivityResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (continuation2.isActive()) {
                            Result.Companion companion = Result.Companion;
                            continuation2.resumeWith(Result.constructor-impl(it));
                        }
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            }

            public Object observeContainerStatus(Continuation<? super Flow<? extends ContainerStatus>> continuation) {
                return FlowKt.catch(FlowKt.flowOn(FlowKt.callbackFlow(new CompatJsbV3$compat$commonContainer$1$observeContainerStatus$2(null)), Dispatchers.getMain()), new CompatJsbV3$compat$commonContainer$1$observeContainerStatus$3(null));
            }

            public Object getCurContainerStatus(Continuation<? super ContainerStatus> continuation) {
                if (ContainerStatusWatcher.INSTANCE.getCurrentStatus() == 1) {
                    return ContainerStatus.SHOW;
                }
                return ContainerStatus.HIDE;
            }

            public Object setStatusBarMode(int mode, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$setStatusBarMode$2(MWebActivity.this, mode, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object setStatusBarVisibility(boolean show, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$setStatusBarVisibility$2(MWebActivity.this, show, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object setContainerSize(String height, String width, Continuation<? super Unit> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object switchBizModule(String bizModule, Continuation<? super Unit> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object reload(Uri uri, Map<String, String> map, Continuation<? super Unit> continuation) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CompatJsbV3$compat$commonContainer$1$reload$2(MWebActivity.this, null), continuation);
                return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
            }

            public Object getContainerInfo(Continuation<? super ContainerInfo> continuation) {
                ContainerInfo containerInfo = MWebActivity.this.getContainerInfo();
                Intrinsics.checkNotNullExpressionValue(containerInfo, "getContainerInfo(...)");
                return containerInfo;
            }

            public Object getSupportFragmentManager(Continuation<? super FragmentManager> continuation) {
                return MWebActivity.this.getSupportFragmentManager();
            }

            public Object observeKeyBoardStatus(Continuation<? super Flow<KeyboardStatusResp>> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }

            public Object disableCloseGesture(boolean disable, Continuation<? super Unit> continuation) {
                throw new JsbBizException((int) IjkMediaCodecInfo.RANK_MAX, "old container! [MWebActivity] not implemented this method", (Throwable) null, false, 12, (DefaultConstructorMarker) null);
            }
        });
    }
}