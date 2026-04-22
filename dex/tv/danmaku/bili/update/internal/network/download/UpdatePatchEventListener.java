package tv.danmaku.bili.update.internal.network.download;

import com.bilibili.lib.bilipatch.PatchEventListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UpdatePatchHelper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J0\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fH\u0016J;\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fH\u0016¨\u0006&"}, d2 = {"Ltv/danmaku/bili/update/internal/network/download/UpdatePatchEventListener;", "Lcom/bilibili/lib/bilipatch/PatchEventListener;", "<init>", "()V", "onDownloadCancel", "", "taskId", "", "onDownloadCheck", "onDownloadError", "errorCodes", "", "", "totalSize", "", "loadedSize", "onDownloadFinish", "dir", "name", "onDownloadLoading", "speed", "progress", "onDownloadRetry", "retryTimes", "onDownloadStart", "onPatchDegrade", "type", "onPatchEnd", "patchType", "code", "rawErrorCode", "patchMd5", "error", "", "(IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V", "onPatchEvent", "msg", "onPatchStart", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class UpdatePatchEventListener implements PatchEventListener {
    public void onDownloadCancel(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        PatchEventListener.DefaultImpls.onDownloadCancel(this, taskId);
    }

    public void onDownloadCheck(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        PatchEventListener.DefaultImpls.onDownloadCheck(this, taskId);
    }

    public void onDownloadError(String taskId, List<Integer> list, long totalSize, long loadedSize) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        PatchEventListener.DefaultImpls.onDownloadError(this, taskId, list, totalSize, loadedSize);
    }

    public void onDownloadFinish(String taskId, String dir, String name) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        PatchEventListener.DefaultImpls.onDownloadFinish(this, taskId, dir, name);
    }

    public void onDownloadLoading(String taskId, long speed, long totalSize, long loadedSize, int progress) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        PatchEventListener.DefaultImpls.onDownloadLoading(this, taskId, speed, totalSize, loadedSize, progress);
    }

    public void onDownloadRetry(String taskId, int retryTimes) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        PatchEventListener.DefaultImpls.onDownloadRetry(this, taskId, retryTimes);
    }

    public void onDownloadStart(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        PatchEventListener.DefaultImpls.onDownloadStart(this, taskId);
    }

    public void onPatchDegrade(int type) {
        PatchEventListener.DefaultImpls.onPatchDegrade(this, type);
    }

    public void onPatchEnd(int patchType, int code, Integer rawErrorCode, String patchMd5, Throwable error) {
        PatchEventListener.DefaultImpls.onPatchEnd(this, patchType, code, rawErrorCode, patchMd5, error);
    }

    public void onPatchEvent(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        PatchEventListener.DefaultImpls.onPatchEvent(this, msg);
    }

    public void onPatchStart(int type) {
        PatchEventListener.DefaultImpls.onPatchStart(this, type);
    }
}