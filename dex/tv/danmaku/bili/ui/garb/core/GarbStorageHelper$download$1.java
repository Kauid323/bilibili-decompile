package tv.danmaku.bili.ui.garb.core;

import android.app.Application;
import bolts.Continuation;
import bolts.Task;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.GarbManagerDelegateKt;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.garb.model.GarbData;

/* compiled from: GarbStorageHelper.kt */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"tv/danmaku/bili/ui/garb/core/GarbStorageHelper$download$1", "Ltv/danmaku/bili/ui/garb/core/GarbDownloadListener;", "onSuccess", "", "file", "Ljava/io/File;", "onFailure", "errCode", "", "errMsg", "", "isCanceled", "", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbStorageHelper$download$1 implements GarbDownloadListener {
    final /* synthetic */ Application $context;
    final /* synthetic */ GarbData.GarbDetail $garb;
    final /* synthetic */ GarbStorageHelper.Listener $listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GarbStorageHelper$download$1(Application $context, GarbData.GarbDetail $garb, GarbStorageHelper.Listener $listener) {
        this.$context = $context;
        this.$garb = $garb;
        this.$listener = $listener;
    }

    @Override // tv.danmaku.bili.ui.garb.core.GarbDownloadListener
    public void onSuccess(final File file) {
        final Application application = this.$context;
        final GarbData.GarbDetail garbDetail = this.$garb;
        Task callInBackground = Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.garb.core.GarbStorageHelper$download$1$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean onSuccess$lambda$0;
                onSuccess$lambda$0 = GarbStorageHelper$download$1.onSuccess$lambda$0(application, garbDetail, file);
                return onSuccess$lambda$0;
            }
        });
        final GarbStorageHelper.Listener listener = this.$listener;
        callInBackground.onSuccess(new Continuation() { // from class: tv.danmaku.bili.ui.garb.core.GarbStorageHelper$download$1$$ExternalSyntheticLambda1
            public final Object then(Task task) {
                Unit onSuccess$lambda$1;
                onSuccess$lambda$1 = GarbStorageHelper$download$1.onSuccess$lambda$1(GarbStorageHelper.Listener.this, task);
                return onSuccess$lambda$1;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean onSuccess$lambda$0(Application $context, GarbData.GarbDetail $garb, File $file) {
        String buildZipDirName;
        boolean unzip;
        buildZipDirName = GarbStorageHelper.INSTANCE.buildZipDirName($context, $garb);
        File zipDir = new File(buildZipDirName);
        unzip = GarbStorageHelper.INSTANCE.unzip($file, zipDir);
        return Boolean.valueOf(unzip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$1(GarbStorageHelper.Listener $listener, Task it) {
        if (it.isCompleted() && ((Boolean) it.getResult()).booleanValue()) {
            if ($listener != null) {
                $listener.onDownloadSuccess();
            }
            BLog.i(GarbManagerDelegateKt.TAG, "garb asset download & unzip success");
        } else if ($listener != null) {
            $listener.onDownloadError("unzip fail");
        }
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.bili.ui.garb.core.GarbDownloadListener
    public void onFailure(int errCode, String errMsg) {
        BLog.i(GarbManagerDelegateKt.TAG, "garb asset download or unzip fail, errorCode: " + errCode + ", errorMsg: " + errMsg);
        GarbStorageHelper.Listener listener = this.$listener;
        if (listener != null) {
            listener.onDownloadError(errMsg);
        }
    }

    @Override // tv.danmaku.bili.ui.garb.core.GarbDownloadListener
    public boolean isCanceled() {
        GarbStorageHelper.Listener listener = this.$listener;
        if (listener != null) {
            return listener.isCanceled();
        }
        return false;
    }
}