package tv.danmaku.bili.ui.garb.core;

import android.text.TextUtils;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.okdownloader.DownloadListener;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.quick.LoginQualityMonitor;

/* compiled from: GarbResourceDownloader.kt */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J0\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"tv/danmaku/bili/ui/garb/core/GarbResourceDownloaderKt$downloadByBiliDownloader$1", "Lcom/bilibili/lib/okdownloader/DownloadListener;", "onFinish", "", "taskId", "", "filePath", "fileName", "onError", "errorCodes", "", "", "totalSize", "", "loadedSize", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbResourceDownloaderKt$downloadByBiliDownloader$1 implements DownloadListener {
    final /* synthetic */ GarbDownloadListener $listener;

    public /* synthetic */ void onCancel(String str) {
        DownloadListener.-CC.$default$onCancel(this, str);
    }

    public /* synthetic */ void onCheck(String str) {
        DownloadListener.-CC.$default$onCheck(this, str);
    }

    public /* synthetic */ void onLoading(String str, long j, long j2, long j3, int i) {
        DownloadListener.-CC.$default$onLoading(this, str, j, j2, j3, i);
    }

    public /* synthetic */ void onPause(String str, long j, long j2) {
        DownloadListener.-CC.$default$onPause(this, str, j, j2);
    }

    public /* synthetic */ void onRetry(String str, int i) {
        DownloadListener.-CC.$default$onRetry(this, str, i);
    }

    public /* synthetic */ void onStart(String str) {
        DownloadListener.-CC.$default$onStart(this, str);
    }

    public /* synthetic */ void onWait(String str) {
        DownloadListener.-CC.$default$onWait(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GarbResourceDownloaderKt$downloadByBiliDownloader$1(GarbDownloadListener $listener) {
        this.$listener = $listener;
    }

    public void onFinish(String taskId, String filePath, String fileName) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        DownloadListener.-CC.$default$onFinish(this, taskId, filePath, fileName);
        if (!TextUtils.isEmpty(fileName) && !TextUtils.isEmpty(filePath)) {
            BLog.i("GarbResDownloader", "download success");
            GarbDownloadListener garbDownloadListener = this.$listener;
            if (garbDownloadListener != null) {
                garbDownloadListener.onSuccess(new File(filePath, fileName));
            }
            Neurons.trackT(false, "main.garb-res.download.state", MapsKt.mapOf(new Pair[]{TuplesKt.to(AuthResultCbHelper.ARGS_STATE, "0"), TuplesKt.to("type", "2")}), 1, new Function0() { // from class: tv.danmaku.bili.ui.garb.core.GarbResourceDownloaderKt$downloadByBiliDownloader$1$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean onFinish$lambda$0;
                    onFinish$lambda$0 = GarbResourceDownloaderKt$downloadByBiliDownloader$1.onFinish$lambda$0();
                    return Boolean.valueOf(onFinish$lambda$0);
                }
            });
            return;
        }
        GarbDownloadListener garbDownloadListener2 = this.$listener;
        if (garbDownloadListener2 != null) {
            garbDownloadListener2.onFailure(-1, "");
        }
        Neurons.trackT(false, "main.garb-res.download.state", MapsKt.mapOf(new Pair[]{TuplesKt.to(AuthResultCbHelper.ARGS_STATE, "1"), TuplesKt.to("type", "2"), TuplesKt.to("err_code", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR)}), 1, new Function0() { // from class: tv.danmaku.bili.ui.garb.core.GarbResourceDownloaderKt$downloadByBiliDownloader$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean onFinish$lambda$1;
                onFinish$lambda$1 = GarbResourceDownloaderKt$downloadByBiliDownloader$1.onFinish$lambda$1();
                return Boolean.valueOf(onFinish$lambda$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onFinish$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onFinish$lambda$1() {
        return true;
    }

    public void onError(String taskId, List<Integer> list, long totalSize, long loadedSize) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        DownloadListener.-CC.$default$onError(this, taskId, list, totalSize, loadedSize);
        int errCode = list != null ? list.get(0).intValue() : -1;
        GarbDownloadListener garbDownloadListener = this.$listener;
        if (garbDownloadListener != null) {
            garbDownloadListener.onFailure(errCode, "");
        }
        BLog.e("GarbResDownloader", "download error " + errCode);
        Neurons.trackT(false, "main.garb-res.download.state", MapsKt.mapOf(new Pair[]{TuplesKt.to(AuthResultCbHelper.ARGS_STATE, "1"), TuplesKt.to("type", "2"), TuplesKt.to("err_code", String.valueOf(errCode))}), 1, new Function0() { // from class: tv.danmaku.bili.ui.garb.core.GarbResourceDownloaderKt$downloadByBiliDownloader$1$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean onError$lambda$2;
                onError$lambda$2 = GarbResourceDownloaderKt$downloadByBiliDownloader$1.onError$lambda$2();
                return Boolean.valueOf(onError$lambda$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onError$lambda$2() {
        return true;
    }
}