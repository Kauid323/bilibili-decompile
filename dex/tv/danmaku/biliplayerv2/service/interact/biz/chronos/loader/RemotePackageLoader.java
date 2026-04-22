package tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader;

import bolts.CancellationToken;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.bilibili.common.chronoscommon.ChronosPackageManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.PackageResult;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.Chronos;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RemotePackageLoader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/RemotePackageLoader;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/IChronosPackageLoader;", "<init>", "()V", "getLoadTask", "Lbolts/Task;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/PackageResult;", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "ct", "Lbolts/CancellationToken;", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RemotePackageLoader implements IChronosPackageLoader {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ReleasePackageLoader";

    /* compiled from: RemotePackageLoader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/RemotePackageLoader$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader.IChronosPackageLoader
    public Task<PackageResult> getLoadTask(final ViewProgressDetail viewProgressDetail, CancellationToken ct) {
        Intrinsics.checkNotNullParameter(ct, "ct");
        final TaskCompletionSource tcs = new TaskCompletionSource();
        Task.BACKGROUND_EXECUTOR.execute(new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader.RemotePackageLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RemotePackageLoader.getLoadTask$lambda$0(ViewProgressDetail.this, tcs);
            }
        });
        Task<PackageResult> task = tcs.getTask();
        Intrinsics.checkNotNullExpressionValue(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLoadTask$lambda$0(ViewProgressDetail $viewProgressDetail, TaskCompletionSource $tcs) {
        PackageResult result = new PackageResult();
        result.setViewProgressDetail($viewProgressDetail);
        Chronos chronos = $viewProgressDetail != null ? $viewProgressDetail.getChronos() : null;
        if (chronos == null) {
            $tcs.setResult(result);
            return;
        }
        String md5 = chronos.getMd5();
        String file = chronos.getFile();
        String url = (file == null || (url = StringsKt.replace$default(file, "http://", "https://", false, 4, (Object) null)) == null) ? "" : "";
        String sign = chronos.getSign();
        result.setChronosPackage(ChronosPackageManager.INSTANCE.obtain(url, md5, sign, ChronosPackageManager.Service.DFM));
        $tcs.setResult(result);
    }
}