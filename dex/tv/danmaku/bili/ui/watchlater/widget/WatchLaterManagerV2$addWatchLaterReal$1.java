package tv.danmaku.bili.ui.watchlater.widget;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import bili.resource.playerbaseres.R;
import com.bilibili.droid.ToastHelper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterAddToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2$addWatchLaterReal$1", f = "WatchLaterManagerV2.kt", i = {}, l = {119, 119}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterManagerV2$addWatchLaterReal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $from;
    final /* synthetic */ boolean $isBatchOperation;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ WeakReference<LifecycleOwner> $lifecycleOwnerRef;
    final /* synthetic */ int $offset;
    final /* synthetic */ boolean $popupWindow;
    final /* synthetic */ String $resources;
    final /* synthetic */ String $spmid;
    final /* synthetic */ int $style;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterManagerV2$addWatchLaterReal$1(boolean z, String str, String str2, String str3, WeakReference<LifecycleOwner> weakReference, boolean z2, Activity activity, int i, LifecycleOwner lifecycleOwner, int i2, Continuation<? super WatchLaterManagerV2$addWatchLaterReal$1> continuation) {
        super(2, continuation);
        this.$isBatchOperation = z;
        this.$resources = str;
        this.$from = str2;
        this.$spmid = str3;
        this.$lifecycleOwnerRef = weakReference;
        this.$popupWindow = z2;
        this.$activity = activity;
        this.$offset = i;
        this.$lifecycleOwner = lifecycleOwner;
        this.$style = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterManagerV2$addWatchLaterReal$1(this.$isBatchOperation, this.$resources, this.$from, this.$spmid, this.$lifecycleOwnerRef, this.$popupWindow, this.$activity, this.$offset, this.$lifecycleOwner, this.$style, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:26:0x005c, B:27:0x005e, B:29:0x0067, B:31:0x006a, B:33:0x0074, B:35:0x007a, B:37:0x0080, B:40:0x0086, B:42:0x008c, B:45:0x0091, B:47:0x0095, B:53:0x00a9, B:55:0x00ae, B:57:0x00b5, B:56:0x00b1, B:49:0x0099, B:58:0x00c8, B:60:0x00d3, B:62:0x00db, B:64:0x00e3, B:65:0x00ec, B:18:0x003e), top: B:87:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:26:0x005c, B:27:0x005e, B:29:0x0067, B:31:0x006a, B:33:0x0074, B:35:0x007a, B:37:0x0080, B:40:0x0086, B:42:0x008c, B:45:0x0091, B:47:0x0095, B:53:0x00a9, B:55:0x00ae, B:57:0x00b5, B:56:0x00b1, B:49:0x0099, B:58:0x00c8, B:60:0x00d3, B:62:0x00db, B:64:0x00e3, B:65:0x00ec, B:18:0x003e), top: B:87:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Object requestBatchAddWatchLater;
        Object addToWatchLater;
        WatchLaterAddToast watchLaterAddToast;
        boolean isMainActivity;
        int i;
        Lifecycle lifecycle2;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
            } catch (Throwable th) {
                t = th;
                $result = $result2;
                lifecycleOwner = this.$lifecycleOwnerRef.get();
                if (((lifecycleOwner != null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.RESUMED) {
                    if (!this.$isBatchOperation) {
                        Activity activity = this.$activity;
                        String message = activity != null ? activity.getString(R.string.playerbaseres_global_string_1189) : null;
                        ToastHelper.showToastShort(this.$activity, message);
                    } else if (this.$activity != null) {
                        WatchLaterManagerV2.INSTANCE.onBatchAddWatchLaterFailure(this.$activity, t);
                    }
                }
                return Unit.INSTANCE;
            }
        } catch (Throwable th2) {
            t = th2;
            lifecycleOwner = this.$lifecycleOwnerRef.get();
            if (((lifecycleOwner != null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.RESUMED) {
            }
            return Unit.INSTANCE;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!this.$isBatchOperation) {
                    this.label = 1;
                    addToWatchLater = WatchLaterManagerV2.INSTANCE.addToWatchLater(this.$resources, this.$from, this.$spmid, (Continuation) this);
                    if (addToWatchLater == $result2) {
                        return $result2;
                    }
                    $result = addToWatchLater;
                    watchLaterAddToast = (WatchLaterAddToast) $result;
                    WatchLaterAddToast result = watchLaterAddToast;
                    if (this.$lifecycleOwnerRef.get() != null) {
                        return Unit.INSTANCE;
                    }
                    LifecycleOwner lifecycleOwner2 = this.$lifecycleOwnerRef.get();
                    if (((lifecycleOwner2 == null || (lifecycle2 = lifecycleOwner2.getLifecycle()) == null) ? null : lifecycle2.getCurrentState()) == Lifecycle.State.RESUMED) {
                        if (result != null && result.getShowToast() && this.$popupWindow) {
                            if (this.$offset != 0) {
                                i = this.$offset;
                            } else {
                                isMainActivity = WatchLaterManagerV2.INSTANCE.isMainActivity(this.$activity);
                                i = isMainActivity ? 60 : 12;
                            }
                            int realOffset = i;
                            String avid = !this.$isBatchOperation ? this.$resources : result.getAvids();
                            WatchLaterPopupWindowManager.INSTANCE.showToast(this.$activity, result, avid, this.$spmid, this.$lifecycleOwner, realOffset, this.$style);
                        }
                        BLog.i("WatchLaterManagerV2", "addWatchLaterReal: result is null or showToast is false");
                        if (this.$isBatchOperation) {
                            Activity activity2 = this.$activity;
                            Activity activity3 = this.$activity;
                            ToastHelper.showToast(activity2, activity3 != null ? activity3.getString(R.string.playerbaseres_global_string_517) : null, 0, 17);
                        } else {
                            ToastHelper.showToastShort(this.$activity, R.string.playerbaseres_global_string_517);
                        }
                    }
                    return Unit.INSTANCE;
                }
                this.label = 2;
                requestBatchAddWatchLater = WatchLaterManagerV2.INSTANCE.requestBatchAddWatchLater(this.$resources, this.$spmid, (Continuation) this);
                if (requestBatchAddWatchLater == $result2) {
                    return $result2;
                }
                $result = requestBatchAddWatchLater;
                watchLaterAddToast = (WatchLaterAddToast) $result;
                WatchLaterAddToast result2 = watchLaterAddToast;
                if (this.$lifecycleOwnerRef.get() != null) {
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                watchLaterAddToast = (WatchLaterAddToast) $result;
                WatchLaterAddToast result22 = watchLaterAddToast;
                if (this.$lifecycleOwnerRef.get() != null) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                watchLaterAddToast = (WatchLaterAddToast) $result;
                WatchLaterAddToast result222 = watchLaterAddToast;
                if (this.$lifecycleOwnerRef.get() != null) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}