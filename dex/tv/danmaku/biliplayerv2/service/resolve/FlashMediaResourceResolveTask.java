package tv.danmaku.biliplayerv2.service.resolve;

import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resolver2.interceptor.DefaultFlashMediaResourceResolveInterceptorV2;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.biliplayerv2.profiler.ProfilerTags;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FlashMediaResourceResolveTask.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/FlashMediaResourceResolveTask;", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask;", "mResolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "mFlashJsonStr", "", "<init>", "(Lcom/bilibili/lib/media/resolver2/IResolveParams;Ljava/lang/String;)V", "mErrorInfo", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ErrorInfo;", "mMediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "mHistoryReader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "description", "getDescription", "()Ljava/lang/String;", "isAsynchronous", "", "()Z", "getError", "getResult", "setHistoryProgressReader", "", "reader", "run", SplashCustomReporterKt.STATE_CANCEL, "setBackupTaskProperty", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FlashMediaResourceResolveTask extends AbsMediaResourceResolveTask {
    private AbsMediaResourceResolveTask.ErrorInfo mErrorInfo;
    private final String mFlashJsonStr;
    private AbsMediaResourceResolveTask.IHistoryProgressReader mHistoryReader;
    private MediaResource mMediaResource;
    private final IResolveParams mResolveParams;

    public FlashMediaResourceResolveTask(IResolveParams mResolveParams, String mFlashJsonStr) {
        Intrinsics.checkNotNullParameter(mResolveParams, "mResolveParams");
        this.mResolveParams = mResolveParams;
        this.mFlashJsonStr = mFlashJsonStr;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public String getDescription() {
        return "FlashMediaResourceResolveTask";
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public boolean isAsynchronous() {
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public AbsMediaResourceResolveTask.ErrorInfo getError() {
        return this.mErrorInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public MediaResource getResult() {
        MediaResource mediaResource = this.mMediaResource;
        return mediaResource == null ? getBackupResult() : mediaResource;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask
    public void setHistoryProgressReader(AbsMediaResourceResolveTask.IHistoryProgressReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.mHistoryReader = reader;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public void run() {
        doProfile(ProfilerTags.START_RESOLVE_PLAY_URL, null);
        dispatchTaskStart();
        this.mMediaResource = DefaultFlashMediaResourceResolveInterceptorV2.Companion.resolve(this.mFlashJsonStr, this.mResolveParams.getFrom());
        if (this.mMediaResource != null) {
            MediaResource mediaResource = this.mMediaResource;
            Intrinsics.checkNotNull(mediaResource);
            if (mediaResource.isPlayable()) {
                MediaResource mediaResource2 = this.mMediaResource;
                if (mediaResource2 != null) {
                    AbsMediaResourceResolveTask.IHistoryProgressReader iHistoryProgressReader = this.mHistoryReader;
                    mediaResource2.startPosition = iHistoryProgressReader != null ? iHistoryProgressReader.read(this.mMediaResource) : 0;
                }
                MediaResource mediaResource3 = this.mMediaResource;
                if (mediaResource3 != null) {
                    AbsMediaResourceResolveTask.IHistoryProgressReader iHistoryProgressReader2 = this.mHistoryReader;
                    mediaResource3.isForceStartAccurateSeek = iHistoryProgressReader2 != null ? iHistoryProgressReader2.isForceAccurateSeek() : false;
                }
                doProfile(ProfilerTags.END_RESOLVE_PLAY_URL, null);
                dispatchTaskSucceed();
                return;
            }
        }
        if (hasBackupTask()) {
            dispatchToBackupTask();
            return;
        }
        AbsMediaResourceResolveTask.ErrorInfo $this$run_u24lambda_u240 = new AbsMediaResourceResolveTask.ErrorInfo();
        $this$run_u24lambda_u240.setHint(this.mMediaResource == null ? "MediaResource is null" : "MediaResource is not playable");
        $this$run_u24lambda_u240.setActionType(AbsMediaResourceResolveTask.ActionType.RELOAD);
        this.mErrorInfo = $this$run_u24lambda_u240;
        dispatchTaskError();
        doProfile(ProfilerTags.END_RESOLVE_PLAY_URL, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public void cancel() {
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public void setBackupTaskProperty() {
        AbsMediaResourceResolveTask.IHistoryProgressReader it;
        super.setBackupTaskProperty();
        Task task = getBackupTask();
        if ((task instanceof AbsMediaResourceResolveTask) && (it = this.mHistoryReader) != null) {
            ((AbsMediaResourceResolveTask) task).setHistoryProgressReader(it);
        }
    }
}