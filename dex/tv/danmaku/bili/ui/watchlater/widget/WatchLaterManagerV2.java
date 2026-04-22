package tv.danmaku.bili.ui.watchlater.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import bili.resource.playerbaseres.R;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.comm.list.common.router.LoginScopeKt;
import com.bilibili.app.comm.list.common.utils.BiliCallLifeCycleObserverKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.okretro.BiliApiDataCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.watchlater.api.WatchLaterApiMangerKt;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterAddToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: WatchLaterManagerV2.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010JF\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u0010J2\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\\\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002J,\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/widget/WatchLaterManagerV2;", "", "<init>", "()V", "TAG", "", "routeRequest", "Lcom/bilibili/lib/blrouter/RouteRequest;", "addWatchLater", "", "fragment", "Landroidx/fragment/app/Fragment;", "avId", "from", "spmid", "offset", "", "style", "activity", "Landroid/app/Activity;", "popupWindow", "", "batchAddWatchLater", "resources", "addWatchLaterReal", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isBatchOperation", "addToWatchLater", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterAddToast;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestBatchAddWatchLater", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMainActivity", "onBatchAddWatchLaterFailure", "error", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterManagerV2 {
    public static final int $stable;
    public static final WatchLaterManagerV2 INSTANCE = new WatchLaterManagerV2();
    private static final String TAG = "WatchLaterManagerV2";
    private static final RouteRequest routeRequest;

    private WatchLaterManagerV2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit routeRequest$lambda$0(MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("key_prompt_scene", "player.ugc-video-detail.relatedvideo.watchlater.click");
        return Unit.INSTANCE;
    }

    static {
        Uri parse = Uri.parse("activity://main/login");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        routeRequest = new RouteRequest.Builder(parse).extras(new Function1() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit routeRequest$lambda$0;
                routeRequest$lambda$0 = WatchLaterManagerV2.routeRequest$lambda$0((MutableBundleLike) obj);
                return routeRequest$lambda$0;
            }
        }).flags(268435456).build();
        $stable = 8;
    }

    public static /* synthetic */ void addWatchLater$default(WatchLaterManagerV2 watchLaterManagerV2, Fragment fragment, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        int i4;
        int i5;
        if ((i3 & 16) == 0) {
            i4 = i;
        } else {
            i4 = 0;
        }
        if ((i3 & 32) == 0) {
            i5 = i2;
        } else {
            i5 = 0;
        }
        watchLaterManagerV2.addWatchLater(fragment, str, str2, str3, i4, i5);
    }

    public final void addWatchLater(final Fragment fragment, final String avId, final String from, final String spmid, final int offset, final int style) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(avId, "avId");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        LoginScopeKt.loginRequire$default(false, fragment.getLifecycle(), routeRequest, 0L, new Function0() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit addWatchLater$lambda$0;
                addWatchLater$lambda$0 = WatchLaterManagerV2.addWatchLater$lambda$0(avId, fragment, from, spmid, offset, style);
                return addWatchLater$lambda$0;
            }
        }, 9, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addWatchLater$lambda$0(String $avId, Fragment $fragment, String $from, String $spmid, int $offset, int $style) {
        addWatchLaterReal$default(INSTANCE, $avId, $fragment.getActivity(), $from, $spmid, (LifecycleOwner) $fragment, $offset, false, false, $style, 192, null);
        return Unit.INSTANCE;
    }

    public final void addWatchLater(final Activity activity, final String avId, final String from, final String spmid, final int offset, final boolean popupWindow, final int style) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(avId, "avId");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        LoginScopeKt.loginRequire$default(false, ListExtentionsKt.lifecycle(activity), routeRequest, 0L, new Function0() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit addWatchLater$lambda$1;
                addWatchLater$lambda$1 = WatchLaterManagerV2.addWatchLater$lambda$1(avId, activity, from, spmid, offset, popupWindow, style);
                return addWatchLater$lambda$1;
            }
        }, 9, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addWatchLater$lambda$1(String $avId, Activity $activity, String $from, String $spmid, int $offset, boolean $popupWindow, int $style) {
        addWatchLaterReal$default(INSTANCE, $avId, $activity, $from, $spmid, BiliCallLifeCycleObserverKt.getLifecycleOwner($activity), $offset, $popupWindow, false, $style, 128, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void batchAddWatchLater$default(WatchLaterManagerV2 watchLaterManagerV2, Activity activity, String str, String str2, int i, int i2, int i3, Object obj) {
        int i4;
        int i5;
        if ((i3 & 8) == 0) {
            i4 = i;
        } else {
            i4 = 0;
        }
        if ((i3 & 16) == 0) {
            i5 = i2;
        } else {
            i5 = 0;
        }
        watchLaterManagerV2.batchAddWatchLater(activity, str, str2, i4, i5);
    }

    public final void batchAddWatchLater(final Activity activity, final String resources, final String spmid, final int offset, final int style) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        LoginScopeKt.loginRequire$default(false, ListExtentionsKt.lifecycle(activity), routeRequest, 0L, new Function0() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit batchAddWatchLater$lambda$0;
                batchAddWatchLater$lambda$0 = WatchLaterManagerV2.batchAddWatchLater$lambda$0(resources, activity, spmid, offset, style);
                return batchAddWatchLater$lambda$0;
            }
        }, 9, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit batchAddWatchLater$lambda$0(String $resources, Activity $activity, String $spmid, int $offset, int $style) {
        addWatchLaterReal$default(INSTANCE, $resources, $activity, null, $spmid, BiliCallLifeCycleObserverKt.getLifecycleOwner($activity), $offset, false, true, $style, 64, null);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void addWatchLaterReal$default(WatchLaterManagerV2 watchLaterManagerV2, String str, Activity activity, String str2, String str3, LifecycleOwner lifecycleOwner, int i, boolean z, boolean z2, int i2, int i3, Object obj) {
        watchLaterManagerV2.addWatchLaterReal(str, activity, str2, str3, lifecycleOwner, i, (i3 & 64) != 0 ? true : z, (i3 & 128) != 0 ? false : z2, (i3 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0 : i2);
    }

    private final void addWatchLaterReal(String resources, Activity activity, String from, String spmid, LifecycleOwner lifecycleOwner, int offset, boolean popupWindow, boolean isBatchOperation, int style) {
        CoroutineScope lifecycleScope;
        WeakReference lifecycleOwnerRef = new WeakReference(lifecycleOwner);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new WatchLaterManagerV2$addWatchLaterReal$1(isBatchOperation, resources, from, spmid, lifecycleOwnerRef, popupWindow, activity, offset, lifecycleOwner, style, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object addToWatchLater(String avId, String from, String spmid, Continuation<? super WatchLaterAddToast> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        WatchLaterApiMangerKt.addToWatchLaterV2(avId, from, spmid, new BiliApiDataCallback<WatchLaterAddToast>() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2$addToWatchLater$2$1
            public void onDataSuccess(WatchLaterAddToast data) {
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(data));
            }

            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestBatchAddWatchLater(String resources, String spmid, Continuation<? super WatchLaterAddToast> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        WatchLaterApiMangerKt.batchAddToWatchLater(resources, spmid, new BiliApiDataCallback<WatchLaterAddToast>() { // from class: tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2$requestBatchAddWatchLater$2$1
            public void onDataSuccess(WatchLaterAddToast data) {
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(data));
            }

            public void onError(Throwable t) {
                Intrinsics.checkNotNullParameter(t, "t");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(ResultKt.createFailure(t)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMainActivity(Activity activity) {
        if (activity == null) {
            return false;
        }
        PackageManager packageManager = activity.getApplication().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        Intent intent = packageManager.getLaunchIntentForPackage(activity.getPackageName());
        if (intent == null) {
            return false;
        }
        ComponentName launchComponentName = intent.getComponent();
        ComponentName componentName = activity.getComponentName();
        Intrinsics.checkNotNullExpressionValue(componentName, "getComponentName(...)");
        return launchComponentName != null && Intrinsics.areEqual(componentName.toString(), launchComponentName.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBatchAddWatchLaterFailure(Activity activity, Throwable error) {
        String string;
        if (error instanceof BiliApiException) {
            String $this$ifNullOrBlank$iv = error.getMessage();
            String str = $this$ifNullOrBlank$iv;
            if (str == null || StringsKt.isBlank(str)) {
                string = activity.getString(R.string.playerbaseres_global_string_1189);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            } else {
                string = $this$ifNullOrBlank$iv;
            }
        } else {
            string = activity.getString(R.string.playerbaseres_global_string_1189);
            Intrinsics.checkNotNull(string);
        }
        String errorMsg = string;
        ToastHelper.showToast(activity, errorMsg, 0, 17);
    }
}