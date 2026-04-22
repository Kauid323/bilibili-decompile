package tv.danmaku.bili.update.applet;

import android.app.Activity;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.updateapi.ButtonClickListener;
import com.bilibili.app.updateapi.UpdateCallback;
import com.bilibili.app.updateapi.applet.DialogOptions;
import com.bilibili.app.updateapi.service.AppletUpdateService;
import java.util.concurrent.Callable;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.api.updater.AppletUpdater;
import tv.danmaku.bili.update.internal.exception.LatestVersionException;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AppletUpdateServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/update/applet/AppletUpdateServiceImpl;", "Lcom/bilibili/app/updateapi/service/AppletUpdateService;", "<init>", "()V", "checkUpdate", "", "activity", "Landroid/app/Activity;", "dialogOptions", "Lcom/bilibili/app/updateapi/applet/DialogOptions;", "callback", "Lcom/bilibili/app/updateapi/ButtonClickListener;", "updateCallback", "Lcom/bilibili/app/updateapi/UpdateCallback;", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AppletUpdateServiceImpl implements AppletUpdateService {
    public void checkUpdate(final Activity activity, DialogOptions dialogOptions, ButtonClickListener callback, final UpdateCallback updateCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        final AppletUpdater appletUpdater = new AppletUpdater(activity, dialogOptions, callback);
        Task callInBackground = Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.update.applet.AppletUpdateServiceImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BiliUpgradeInfo checkUpdate$lambda$0;
                checkUpdate$lambda$0 = AppletUpdateServiceImpl.checkUpdate$lambda$0(updateCallback, activity);
                return checkUpdate$lambda$0;
            }
        });
        Continuation continuation = new Continuation() { // from class: tv.danmaku.bili.update.applet.AppletUpdateServiceImpl$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Void checkUpdate$lambda$1;
                checkUpdate$lambda$1 = AppletUpdateServiceImpl.checkUpdate$lambda$1(updateCallback, appletUpdater, task);
                return checkUpdate$lambda$1;
            }
        };
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type bolts.Continuation<tv.danmaku.bili.update.model.BiliUpgradeInfo?, java.lang.Void?>");
        callInBackground.continueWith(continuation, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliUpgradeInfo checkUpdate$lambda$0(UpdateCallback $updateCallback, Activity $activity) {
        if ($updateCallback != null) {
            $updateCallback.onStart();
        }
        return RuntimeHelper.getUpdaterOptions().getRemoteUpgradeInfoSupplier().get($activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void checkUpdate$lambda$1(UpdateCallback $updateCallback, AppletUpdater $appletUpdater, Task task) {
        BiliUpgradeInfo result;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isFaulted()) {
            Exception e = task.getError();
            if (e != null) {
                if (e instanceof LatestVersionException) {
                    if ($updateCallback != null) {
                        $updateCallback.onComplete();
                        return null;
                    }
                    return null;
                }
                if ($updateCallback != null) {
                    $updateCallback.onError(e.getMessage());
                }
                $appletUpdater.onError(e.getMessage());
                return null;
            }
            return null;
        } else if (task.isCompleted() && !task.isCancelled() && (result = (BiliUpgradeInfo) task.getResult()) != null) {
            if (RuntimeHelper.versionCode() < result.versionCode()) {
                if ($updateCallback != null) {
                    $updateCallback.onNext();
                }
                $appletUpdater.onUpdate(result, true);
                return null;
            } else if ($updateCallback != null) {
                $updateCallback.onComplete();
                return null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}