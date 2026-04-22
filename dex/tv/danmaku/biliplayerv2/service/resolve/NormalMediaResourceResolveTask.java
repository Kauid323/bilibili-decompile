package tv.danmaku.biliplayerv2.service.resolve;

import android.content.Context;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.ServicesProvider;
import com.bilibili.lib.media.resolver.exception.ResolveHttpException;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resolver2.MediaResolveClientV2;
import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.neuron.util.SamplesKt;
import com.bilibili.moduleservice.videodownload.VideoDownloadService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.biliplayerv2.profiler.ProfilerTags;
import tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NormalMediaResourceResolveTask.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\"\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` 2\b\u0010!\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/NormalMediaResourceResolveTask;", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask;", "isStartTask", "", "mContext", "Landroid/content/Context;", "isLocalOnly", "mResolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "mDownloadParams", "Ltv/danmaku/biliplayerv2/service/resolve/DownloadParams;", "<init>", "(ZLandroid/content/Context;ZLcom/bilibili/lib/media/resolver2/IResolveParams;Ltv/danmaku/biliplayerv2/service/resolve/DownloadParams;)V", "mErrorInfo", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ErrorInfo;", "mMediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "mHistoryReader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "description", "", "getDescription", "()Ljava/lang/String;", "getError", "getResult", "setHistoryProgressReader", "", "reader", "run", "onTaskError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "hint", "buildMediaResolveClientV2", "Lcom/bilibili/lib/media/resolver2/MediaResolveClientV2;", "resolveFromDownload", SplashCustomReporterKt.STATE_CANCEL, "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalMediaResourceResolveTask extends AbsMediaResourceResolveTask {
    private final boolean isLocalOnly;
    private final boolean isStartTask;
    private final Context mContext;
    private final DownloadParams mDownloadParams;
    private AbsMediaResourceResolveTask.ErrorInfo mErrorInfo;
    private AbsMediaResourceResolveTask.IHistoryProgressReader mHistoryReader;
    private MediaResource mMediaResource;
    private final IResolveParams mResolveParams;

    public NormalMediaResourceResolveTask(boolean isStartTask, Context mContext, boolean isLocalOnly, IResolveParams mResolveParams, DownloadParams mDownloadParams) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mResolveParams, "mResolveParams");
        this.isStartTask = isStartTask;
        this.mContext = mContext;
        this.isLocalOnly = isLocalOnly;
        this.mResolveParams = mResolveParams;
        this.mDownloadParams = mDownloadParams;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public String getDescription() {
        return "NormalMediaResourceResolveTask";
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r0.isPlayable() == true) goto L11;
     */
    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        PlayIndex playIndex;
        if (this.isStartTask) {
            doProfile(ProfilerTags.START_RESOLVE_PLAY_URL, null);
            dispatchTaskStart();
        }
        if (this.mDownloadParams != null) {
            resolveFromDownload();
        }
        MediaResource mediaResource = this.mMediaResource;
        if (mediaResource != null) {
            z = true;
        }
        z = false;
        if (z) {
            if (this.isLocalOnly) {
                Neurons.trackCustom$default("offline.resolve.error", 0, 0, 0, 0, 0, (String) null, (Map) null, new Function0() { // from class: tv.danmaku.biliplayerv2.service.resolve.NormalMediaResourceResolveTask$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean run$lambda$0;
                        run$lambda$0 = NormalMediaResourceResolveTask.run$lambda$0();
                        return Boolean.valueOf(run$lambda$0);
                    }
                }, 252, (Object) null);
            }
            MediaResource mediaResource2 = this.mMediaResource;
            if (mediaResource2 != null && (playIndex = mediaResource2.getPlayIndex()) != null) {
                playIndex.mFrom = "downloaded";
            }
            MediaResource mediaResource3 = this.mMediaResource;
            if (mediaResource3 != null) {
                AbsMediaResourceResolveTask.IHistoryProgressReader iHistoryProgressReader = this.mHistoryReader;
                mediaResource3.startPosition = iHistoryProgressReader != null ? iHistoryProgressReader.read(this.mMediaResource) : 0;
            }
            MediaResource mediaResource4 = this.mMediaResource;
            if (mediaResource4 != null) {
                AbsMediaResourceResolveTask.IHistoryProgressReader iHistoryProgressReader2 = this.mHistoryReader;
                mediaResource4.isForceStartAccurateSeek = iHistoryProgressReader2 != null ? iHistoryProgressReader2.isForceAccurateSeek() : false;
            }
            dispatchTaskSucceed();
            doProfile(ProfilerTags.END_RESOLVE_PLAY_URL, null);
            return;
        }
        try {
            this.mMediaResource = buildMediaResolveClientV2().resolve(this.mContext, this.mResolveParams);
            MediaResource mediaResource5 = this.mMediaResource;
            if (mediaResource5 != null) {
                if (mediaResource5.isPlayable()) {
                    AbsMediaResourceResolveTask.IHistoryProgressReader iHistoryProgressReader3 = this.mHistoryReader;
                    mediaResource5.startPosition = iHistoryProgressReader3 != null ? iHistoryProgressReader3.read(this.mMediaResource) : 0;
                    AbsMediaResourceResolveTask.IHistoryProgressReader iHistoryProgressReader4 = this.mHistoryReader;
                    mediaResource5.isForceStartAccurateSeek = iHistoryProgressReader4 != null ? iHistoryProgressReader4.isForceAccurateSeek() : false;
                } else if (mediaResource5.sourceFrom() == 3) {
                    onTaskError(null, "MediaResource downloaded is not playable");
                    return;
                }
                dispatchTaskSucceed();
                doProfile(ProfilerTags.END_RESOLVE_PLAY_URL, null);
                return;
            }
            onTaskError(null, "MediaResource is null");
        } catch (ResolveHttpException e) {
            onTaskError((Exception) e, e.getErrorMessage());
        } catch (Exception e2) {
            onTaskError(e2, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean run$lambda$0() {
        return SamplesKt.sample(100);
    }

    private final void onTaskError(Exception e, String hint) {
        ExtraInfo extraInfo;
        ExtraInfo.DownloadedResolveErrLimit downloadedResolveErrLimit;
        if (this.mMediaResource == null) {
            this.mErrorInfo = new AbsMediaResourceResolveTask.ErrorInfo();
            AbsMediaResourceResolveTask.ErrorInfo errorInfo = this.mErrorInfo;
            if (errorInfo != null) {
                errorInfo.setHint(hint == null ? "" : hint);
            }
            AbsMediaResourceResolveTask.ErrorInfo errorInfo2 = this.mErrorInfo;
            if (errorInfo2 != null) {
                errorInfo2.setActionType(AbsMediaResourceResolveTask.ActionType.RELOAD);
            }
            AbsMediaResourceResolveTask.ErrorInfo errorInfo3 = this.mErrorInfo;
            if (errorInfo3 != null) {
                errorInfo3.setException(e);
            }
        } else {
            MediaResource mediaResource = this.mMediaResource;
            this.mErrorInfo = (mediaResource == null || (extraInfo = mediaResource.getExtraInfo()) == null || (downloadedResolveErrLimit = extraInfo.getDownloadedResolveErrLimit()) == null) ? null : CommonResolveTasksKt.toErrInfo(downloadedResolveErrLimit);
        }
        dispatchTaskError();
        doProfile(ProfilerTags.END_RESOLVE_PLAY_URL, null);
    }

    private final MediaResolveClientV2 buildMediaResolveClientV2() {
        return new MediaResolveClientV2.Builder().build();
    }

    private final void resolveFromDownload() {
        if (this.mDownloadParams == null) {
            return;
        }
        VideoDownloadService videoDownloadService = (VideoDownloadService) ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(VideoDownloadService.class), (String) null, 1, (Object) null);
        Object resolveMedia = videoDownloadService != null ? videoDownloadService.resolveMedia(this.mContext, Long.valueOf(this.mDownloadParams.getAvid()), Long.valueOf(this.mDownloadParams.getCid()), Integer.valueOf(this.mDownloadParams.getPage()), Long.valueOf(this.mDownloadParams.getEpisodeId()), this.mDownloadParams.getSeasonId(), this.mDownloadParams.getFrom(), this.mDownloadParams.getLink()) : null;
        this.mMediaResource = resolveMedia instanceof MediaResource ? (MediaResource) resolveMedia : null;
    }

    @Override // tv.danmaku.biliplayerv2.service.resolve.Task
    public void cancel() {
    }
}