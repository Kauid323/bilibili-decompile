package video.biz.offline.base.infra.download;

import com.bapis.bilibili.app.playerunite.v1.KPlayViewUniteReply;
import com.bapis.bilibili.app.playerunite.v1.KPlayViewUniteReq;
import com.bapis.bilibili.app.playerunite.v1.KPlayerMoss;
import com.bapis.bilibili.playershared.KCodeType;
import com.bapis.bilibili.playershared.KDashItem;
import com.bapis.bilibili.playershared.KDashVideo;
import com.bapis.bilibili.playershared.KDimension;
import com.bapis.bilibili.playershared.KDrmTechType;
import com.bapis.bilibili.playershared.KFragment;
import com.bapis.bilibili.playershared.KPlayArc;
import com.bapis.bilibili.playershared.KPlayCtrl;
import com.bapis.bilibili.playershared.KProductionType;
import com.bapis.bilibili.playershared.KQnPolicy;
import com.bapis.bilibili.playershared.KResponseUrl;
import com.bapis.bilibili.playershared.KStream;
import com.bapis.bilibili.playershared.KStreamInfo;
import com.bapis.bilibili.playershared.KVideoVod;
import com.bapis.bilibili.playershared.KVodInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.PathsJvmKt;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.base.files.Files;
import video.base.log.LogKt;
import video.base.utils.DateKt;
import video.biz.offline.base.infra.download.tasks.CoverTask;
import video.biz.offline.base.infra.download.tasks.ITask;
import video.biz.offline.base.infra.download.tasks.ITaskStateChange;
import video.biz.offline.base.infra.download.tasks.MediaTask;
import video.biz.offline.base.infra.download.tasks.PBDanmakuTask;
import video.biz.offline.base.infra.download.tasks.TaskType;
import video.biz.offline.base.infra.download.tasks.XMLDanmakuTask;
import video.biz.offline.base.infra.storage.IStorageInfoKt;
import video.biz.offline.base.infra.storage.StorageInfoImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.DiskFileImpl_androidKt;
import video.biz.offline.base.infra.storage.diskfile.FileType;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.DownloadLog;
import video.biz.offline.base.infra.utils.ExtensionKt;
import video.biz.offline.base.infra.utils.OfflineNeuron;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.infra.utils.OfflineUserInfo;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;
import video.biz.offline.base.model.error.DownloadException;
import video.biz.offline.base.model.error.OfflineError;
import video.biz.offline.base.model.ext.OfflineConfigKt;
import video.biz.offline.base.model.model.ResolveParam;
import video.biz.offline.base.model.model.StorageInfoModel;
import video.biz.offline.base.model.model.VideoPlayInfo;
import video.interfacee.bridge.dolbyReporrt.KDolbyReportKt;

/* compiled from: TaskGroup.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u000e\u0010%\u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020!2\u0006\u0010*\u001a\u00020\nH\u0016J\u0018\u0010,\u001a\u00020!2\b\b\u0002\u0010-\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020!2\b\b\u0002\u0010-\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010.J\u0018\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J\u0018\u00104\u001a\u00020!2\u0006\u0010*\u001a\u00020\n2\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020!2\u0006\u0010*\u001a\u00020\n2\u0006\u00105\u001a\u000206H\u0002J\u001a\u00108\u001a\u00020!2\n\u00105\u001a\u000609j\u0002`:H\u0082@¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\u001bH\u0016J\u0016\u0010>\u001a\n\u0018\u000109j\u0004\u0018\u0001`:H\u0082@¢\u0006\u0002\u0010\"J\u0016\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020AH\u0082@¢\u0006\u0002\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u0001062\u0006\u0010D\u001a\u00020\u0000H\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J \u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u001bH\u0002J\u0012\u0010N\u001a\u0004\u0018\u0001062\u0006\u0010K\u001a\u00020LH\u0002J\u0016\u0010O\u001a\u00020!2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0PH\u0002J\b\u0010Q\u001a\u00020\nH\u0002J\b\u0010R\u001a\u00020\nH\u0002J\b\u0010S\u001a\u00020\nH\u0002J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\n0P2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010U\u001a\u00020!2\u0006\u0010K\u001a\u00020LH\u0002J\u001a\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010X\u001a\u00020!H\u0002J\b\u0010Y\u001a\u00020!H\u0002J\u0013\u0010Z\u001a\u00020\u00182\b\u0010[\u001a\u0004\u0018\u00010\\H\u0096\u0002J\b\u0010]\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lvideo/biz/offline/base/infra/download/TaskGroup;", "Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "video", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "progressCallback", "Lvideo/biz/offline/base/infra/download/DownloadProgressCallback;", "delegate", "Lvideo/biz/offline/base/infra/download/IGroupStateChange;", "tasks", "", "Lvideo/biz/offline/base/infra/download/tasks/ITask;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lvideo/biz/offline/base/infra/download/DownloadProgressCallback;Lvideo/biz/offline/base/infra/download/IGroupStateChange;Ljava/util/List;)V", "getVideo", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getTasks", "()Ljava/util/List;", "setTasks", "(Ljava/util/List;)V", "key", "", "getKey", "()Ljava/lang/String;", "isActive", "", "isDolby", "retryCount", "", "canRetry", "getCanRetry", "()Z", "progressLogCache", "startDownload", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SplashCustomReporterKt.STATE_CANCEL, "updateDanmaku", "resolveTasks", "startTasks", "startNext", "increaseRetry", "onLoading", "task", "onFinish", "updateState", "complete", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStateDeprecated", "progressLogIfNeed", "current", "", "total", "onError", "error", "Lvideo/biz/offline/base/model/error/DownloadException;", "deleteErrorFileIfNeed", "retryIfNeed", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "danmakuUpdate", "count", "resolvePlayView", "updateVideoState", "state", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkVipState", "group", "resolvePlayViewReq", "Lcom/bapis/bilibili/app/playerunite/v1/KPlayViewUniteReq;", "param", "Lvideo/biz/offline/base/model/model/ResolveParam;", "playViewDidResolved", "entity", "res", "Lcom/bapis/bilibili/app/playerunite/v1/KPlayViewUniteReply;", IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, "configGroupTasks", "updateTasks", "", "resolveCoverTask", "resolveOldDanmakuTask", "resolveNewDanmakuTask", "resolveMediaTasks", "updateVideoInfo", "fetchRealSteam", "Lcom/bapis/bilibili/playershared/KStream;", "updateVideoMedia", "reportDolbyIfNeed", "equals", "other", "", "hashCode", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TaskGroup implements ITaskStateChange {
    public static final int $stable = 8;
    private IGroupStateChange delegate;
    private boolean isActive;
    private boolean isDolby;
    private DownloadProgressCallback progressCallback;
    private final List<Integer> progressLogCache;
    private int retryCount;
    private List<ITask> tasks;

    /* renamed from: video  reason: collision with root package name */
    private final OfflineVideoEntity f28video;

    /* compiled from: TaskGroup.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.BizType.values().length];
            try {
                iArr[OfflineVideoEntity.BizType.UGC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.BizType.OGV.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflineVideoEntity.BizType.PUGV.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TaskGroup(OfflineVideoEntity video2, DownloadProgressCallback progressCallback, IGroupStateChange delegate, List<ITask> list) {
        Intrinsics.checkNotNullParameter(video2, "video");
        Intrinsics.checkNotNullParameter(list, "tasks");
        this.f28video = video2;
        this.progressCallback = progressCallback;
        this.delegate = delegate;
        this.tasks = list;
        this.isActive = true;
        this.progressLogCache = new ArrayList();
    }

    public /* synthetic */ TaskGroup(OfflineVideoEntity offlineVideoEntity, DownloadProgressCallback downloadProgressCallback, IGroupStateChange iGroupStateChange, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offlineVideoEntity, downloadProgressCallback, iGroupStateChange, (i & 8) != 0 ? new ArrayList() : arrayList);
    }

    public final OfflineVideoEntity getVideo() {
        return this.f28video;
    }

    public final List<ITask> getTasks() {
        return this.tasks;
    }

    public final void setTasks(List<ITask> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tasks = list;
    }

    public final String getKey() {
        return this.f28video.getKey();
    }

    private final boolean getCanRetry() {
        return this.retryCount < 3;
    }

    public final Object startDownload(Continuation<? super Unit> continuation) throws DownloadException, CancellationException {
        new DownloadLog(getKey()).info("TaskGroup start download, isActive: " + this.isActive + " retryCount: " + this.retryCount);
        OfflineNeuron.Companion.taskGroupStartTrack();
        Object resolveTasks = resolveTasks(continuation);
        return resolveTasks == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? resolveTasks : Unit.INSTANCE;
    }

    public final void cancel() {
        this.progressCallback = null;
        this.delegate = null;
        this.isActive = false;
        Iterable $this$forEach$iv = this.tasks;
        for (Object element$iv : $this$forEach$iv) {
            ITask it = (ITask) element$iv;
            it.pause();
        }
    }

    public final void updateDanmaku() {
        this.tasks.clear();
        ITask old = resolveOldDanmakuTask();
        this.tasks.add(old);
        this.tasks.add(resolveNewDanmakuTask());
        Iterable $this$map$iv = this.tasks;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ITask it = (ITask) item$iv$iv;
            it.start();
            destination$iv$iv.add(Unit.INSTANCE);
        }
        ArrayList arrayList = (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveTasks(Continuation<? super Unit> continuation) {
        TaskGroup$resolveTasks$1 taskGroup$resolveTasks$1;
        Object resolvePlayView;
        if (continuation instanceof TaskGroup$resolveTasks$1) {
            taskGroup$resolveTasks$1 = (TaskGroup$resolveTasks$1) continuation;
            if ((taskGroup$resolveTasks$1.label & Integer.MIN_VALUE) != 0) {
                taskGroup$resolveTasks$1.label -= Integer.MIN_VALUE;
                Object $result = taskGroup$resolveTasks$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (taskGroup$resolveTasks$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!this.isActive) {
                            new DownloadLog(getKey()).info("task group is not active start job");
                            return Unit.INSTANCE;
                        }
                        taskGroup$resolveTasks$1.label = 1;
                        if (updateVideoState(OfflineVideoEntity.State.RESOLVING.INSTANCE, taskGroup$resolveTasks$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        taskGroup$resolveTasks$1.label = 2;
                        resolvePlayView = resolvePlayView(taskGroup$resolveTasks$1);
                        if (resolvePlayView == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Exception error = (Exception) resolvePlayView;
                        if (!this.isActive) {
                            new DownloadLog(getKey()).info("TaskGroup is not active resolve tasks");
                            return Unit.INSTANCE;
                        } else if (error != null) {
                            taskGroup$resolveTasks$1.L$0 = SpillingKt.nullOutSpilledVariable(error);
                            taskGroup$resolveTasks$1.label = 4;
                            return retryIfNeed(error, taskGroup$resolveTasks$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        } else {
                            taskGroup$resolveTasks$1.L$0 = SpillingKt.nullOutSpilledVariable(error);
                            taskGroup$resolveTasks$1.label = 3;
                            if (updateVideoState(new OfflineVideoEntity.State.DOWNLOADING(this.f28video.getDownloadedSize(), this.f28video.getTotalSize()), taskGroup$resolveTasks$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            startTasks();
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        taskGroup$resolveTasks$1.label = 2;
                        resolvePlayView = resolvePlayView(taskGroup$resolveTasks$1);
                        if (resolvePlayView == coroutine_suspended) {
                        }
                        Exception error2 = (Exception) resolvePlayView;
                        if (!this.isActive) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        resolvePlayView = $result;
                        Exception error22 = (Exception) resolvePlayView;
                        if (!this.isActive) {
                        }
                        break;
                    case 3:
                        Exception exc = (Exception) taskGroup$resolveTasks$1.L$0;
                        ResultKt.throwOnFailure($result);
                        startTasks();
                    case 4:
                        Exception exc2 = (Exception) taskGroup$resolveTasks$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        taskGroup$resolveTasks$1 = new TaskGroup$resolveTasks$1(this, continuation);
        Object $result2 = taskGroup$resolveTasks$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (taskGroup$resolveTasks$1.label) {
        }
    }

    private final void startTasks() {
        FileMetadata metadataOrNull;
        OfflineNeuron.Companion.downloadStartTrackT();
        Iterable $this$filter$iv = this.tasks;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ITask it = (ITask) element$iv$iv;
            if (it.isMedia()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List mediaTask = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        Iterator it2 = mediaTask.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object element$iv$iv2 = it2.next();
            ITask task = (ITask) element$iv$iv2;
            boolean z2 = false;
            if (FileSystemJvmKt.SystemFileSystem.exists(PathsJvmKt.Path(task.getFullPath())) && (metadataOrNull = FileSystemJvmKt.SystemFileSystem.metadataOrNull(PathsJvmKt.Path(task.getFullPath()))) != null) {
                long it3 = metadataOrNull.getSize();
                z2 = (it3 != task.getSize() || task.getSize() <= 0) ? false : false;
            }
            if (z2) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        List downloadedMedias = (List) destination$iv$iv2;
        List $this$forEach$iv = downloadedMedias;
        for (Object element$iv : $this$forEach$iv) {
            ITask it4 = (ITask) element$iv;
            it4.setDownloadSize(it4.getSize());
            it4.setComplete(true);
            new DownloadLog(getKey()).taskComplete("pre check did complete " + it4);
        }
        if (!downloadedMedias.isEmpty()) {
            Iterable $this$filter$iv2 = this.tasks;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv2) {
                ITask it5 = (ITask) element$iv$iv3;
                if (!it5.isMedia()) {
                    destination$iv$iv3.add(element$iv$iv3);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv3;
            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ITask it6 = (ITask) item$iv$iv;
                it6.setComplete(true);
                destination$iv$iv4.add(Unit.INSTANCE);
            }
            ArrayList arrayList = (List) destination$iv$iv4;
        }
        if (downloadedMedias.size() == mediaTask.size()) {
            BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new TaskGroup$startTasks$4(this, null), 3, (Object) null);
            return;
        }
        reportDolbyIfNeed();
        startNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startNext() {
        Object element$iv;
        if (!this.isActive) {
            return;
        }
        Iterable $this$firstOrNull$iv = this.tasks;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                if (!((ITask) element$iv).getComplete()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        ITask it2 = (ITask) element$iv;
        if (it2 != null) {
            new DownloadLog(getKey()).startDownload(String.valueOf(it2));
            it2.start();
        }
    }

    private final void increaseRetry() {
        this.retryCount++;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITaskStateChange
    public void onLoading(ITask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new TaskGroup$onLoading$1(this, null), 3, (Object) null);
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITaskStateChange
    public void onFinish(ITask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        new DownloadLog(getKey()).taskComplete(String.valueOf(task));
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new TaskGroup$onFinish$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object updateState$default(TaskGroup taskGroup, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return taskGroup.updateState(z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateState(boolean complete, Continuation<? super Unit> continuation) {
        if (!TaskGroupKt.access$isComplete(this.f28video) && this.isActive) {
            Iterable $this$filter$iv = this.tasks;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                ITask it = (ITask) element$iv$iv;
                if (it.isMedia()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable medias = (List) destination$iv$iv;
            Iterable $this$filter$iv2 = medias;
            Collection destination$iv$iv2 = new ArrayList();
            Iterator it2 = $this$filter$iv2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv$iv2 = it2.next();
                ITask it3 = (ITask) element$iv$iv2;
                if (it3.getType() == TaskType.AUDIO) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            long audioDownloadSize = 0;
            for (ITask it4 : (List) destination$iv$iv2) {
                audioDownloadSize += it4.getDownloadSize();
            }
            Iterable $this$filter$iv3 = medias;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv3) {
                ITask it5 = (ITask) element$iv$iv3;
                if (it5.getType() == TaskType.VIDEO) {
                    destination$iv$iv3.add(element$iv$iv3);
                }
            }
            long j = 0;
            for (ITask it6 : (List) destination$iv$iv3) {
                j += it6.getDownloadSize();
            }
            long videoDownloadSize = j;
            long downloadedSize = audioDownloadSize + videoDownloadSize;
            this.f28video.setSectionsDownloadedList(CollectionsKt.toMutableList(CollectionsKt.listOf(new Long[]{Boxing.boxLong(videoDownloadSize), Boxing.boxLong(audioDownloadSize)})));
            this.f28video.setUpdateTime(DateKt.getCurrentTimeMillis());
            boolean forceUpdate = false;
            if (complete) {
                new DownloadLog(getKey()).allComplete();
                this.f28video.setState(OfflineVideoEntity.State.COMPLETED.INSTANCE);
                forceUpdate = true;
                this.isActive = false;
            } else {
                progressLogIfNeed(downloadedSize, this.f28video.getTotalSize());
                this.f28video.setState(new OfflineVideoEntity.State.DOWNLOADING(downloadedSize, this.f28video.getTotalSize()));
            }
            DownloadProgressCallback downloadProgressCallback = this.progressCallback;
            if (downloadProgressCallback != null) {
                Object updateVideo = downloadProgressCallback.updateVideo(CollectionsKt.listOf(this.f28video), forceUpdate, continuation);
                return updateVideo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateVideo : Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object updateStateDeprecated$default(TaskGroup taskGroup, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return taskGroup.updateStateDeprecated(z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateStateDeprecated(boolean complete, Continuation<? super Unit> continuation) {
        boolean z;
        ITask it;
        if (TaskGroupKt.access$isComplete(this.f28video)) {
            return Unit.INSTANCE;
        }
        Iterable $this$filter$iv = this.tasks;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((ITask) element$iv$iv).isMedia()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable medias = (List) destination$iv$iv;
        Iterable $this$filter$iv2 = medias;
        Collection destination$iv$iv2 = new ArrayList();
        Iterator it2 = $this$filter$iv2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object element$iv$iv2 = it2.next();
            if (((ITask) element$iv$iv2).getType() == TaskType.AUDIO) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        long audioDownloadSize = 0;
        for (ITask it3 : (List) destination$iv$iv2) {
            audioDownloadSize += it3.getDownloadSize();
        }
        Iterable $this$filter$iv3 = medias;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv3 : $this$filter$iv3) {
            if (((ITask) element$iv$iv3).getType() == TaskType.VIDEO) {
                destination$iv$iv3.add(element$iv$iv3);
            }
        }
        long j = 0;
        for (ITask it4 : (List) destination$iv$iv3) {
            j += it4.getDownloadSize();
        }
        long videoDownloadSize = j;
        long downloadedSize = audioDownloadSize + videoDownloadSize;
        this.f28video.setSectionsDownloadedList(CollectionsKt.toMutableList(CollectionsKt.listOf(new Long[]{Boxing.boxLong(videoDownloadSize), Boxing.boxLong(audioDownloadSize)})));
        this.f28video.setUpdateTime(DateKt.getCurrentTimeMillis());
        Iterable $this$all$iv = medias;
        if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
            Iterator it5 = $this$all$iv.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object element$iv = it5.next();
                ITask it6 = (ITask) element$iv;
                if (it6.getDownloadSize() == it6.getSize()) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it == null) {
                    z = false;
                    break;
                }
            }
        }
        boolean isDownloaded = z;
        boolean forceUpdate = false;
        if (isDownloaded && (complete || downloadedSize == this.f28video.getTotalSize())) {
            new DownloadLog(getKey()).allComplete();
            this.f28video.setState(OfflineVideoEntity.State.COMPLETED.INSTANCE);
            forceUpdate = true;
            this.isActive = false;
        } else {
            progressLogIfNeed(downloadedSize, this.f28video.getTotalSize());
            this.f28video.setState(new OfflineVideoEntity.State.DOWNLOADING(downloadedSize, this.f28video.getTotalSize()));
        }
        DownloadProgressCallback downloadProgressCallback = this.progressCallback;
        if (downloadProgressCallback != null) {
            Object updateVideo = downloadProgressCallback.updateVideo(CollectionsKt.listOf(this.f28video), forceUpdate, continuation);
            return updateVideo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateVideo : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void progressLogIfNeed(long current, long total) {
        int progress = (int) ((100 * current) / total);
        Integer num = (Integer) CollectionsKt.lastOrNull(this.progressLogCache);
        int last = num != null ? num.intValue() : 10;
        if (progress > last) {
            new DownloadLog(getKey()).progress(current, total);
            this.progressLogCache.add(Integer.valueOf(Math.min(progress + 10, 100)));
        }
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITaskStateChange
    public void onError(ITask task, DownloadException error) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(error, "error");
        OfflineNeuron.Companion.downloadErrorTrackT(error, getKey());
        new DownloadLog(getKey()).fail(String.valueOf(task), error);
        if (!this.isActive) {
            new DownloadLog(getKey()).info("task group is not active error");
            return;
        }
        deleteErrorFileIfNeed(task, error);
        Iterable $this$map$iv = this.tasks;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ITask it = (ITask) item$iv$iv;
            it.pause();
            destination$iv$iv.add(Unit.INSTANCE);
        }
        ArrayList arrayList = (List) destination$iv$iv;
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new TaskGroup$onError$2(this, error, null), 3, (Object) null);
    }

    private final void deleteErrorFileIfNeed(ITask task, DownloadException error) {
        int errorCode = OfflineError.INSTANCE.getErrorNumber(error.getCode());
        List deleteFileCodes = CollectionsKt.listOf(new Integer[]{100010, 416});
        new DownloadLog(getKey()).info("deleteErrorFile " + errorCode);
        if (deleteFileCodes.contains(Integer.valueOf(errorCode))) {
            new DownloadLog(getKey()).info("deleteErrorFile [" + errorCode + "] [" + task.getFullPath() + "]");
            Files.Companion.recursivelyDelete(PathsJvmKt.Path(task.getFullPath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object retryIfNeed(Exception error, Continuation<? super Unit> continuation) {
        new DownloadLog(getKey()).fail("retry if need", error);
        int errorCode = error instanceof DownloadException ? ((DownloadException) error).getCode() : DownloadErrorType.UNKNOWN.getErrorCode();
        this.f28video.setErrorCode(errorCode);
        this.f28video.setState(new OfflineVideoEntity.State.ERROR(errorCode));
        int subErrorCode = OfflineError.INSTANCE.getErrorNumber(errorCode);
        if (getCanRetry()) {
            increaseRetry();
            new DownloadLog(getKey()).retry(this.retryCount);
            Object resolveTasks = resolveTasks(continuation);
            return resolveTasks == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? resolveTasks : Unit.INSTANCE;
        }
        new DownloadLog(getKey()).info("task error can't retry code: " + subErrorCode + " retryCount: " + this.retryCount);
        this.isActive = false;
        OfflineNeuron.Companion.taskGroupErrorTrackT(error, getKey());
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new TaskGroup$retryIfNeed$2(this, error, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITaskStateChange
    public void danmakuUpdate(int count) {
        if (this.f28video.getDanmakuCount() > count) {
            return;
        }
        this.f28video.setDanmakuCount(count);
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new TaskGroup$danmakuUpdate$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097 A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a6, blocks: (B:13:0x0039, B:24:0x0088, B:28:0x0097, B:16:0x0042, B:20:0x004c), top: B:33:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolvePlayView(Continuation<? super Exception> continuation) {
        TaskGroup$resolvePlayView$1 taskGroup$resolvePlayView$1;
        Object playViewUnite;
        DownloadException taskError;
        try {
            if (continuation instanceof TaskGroup$resolvePlayView$1) {
                taskGroup$resolvePlayView$1 = (TaskGroup$resolvePlayView$1) continuation;
                if ((taskGroup$resolvePlayView$1.label & Integer.MIN_VALUE) != 0) {
                    taskGroup$resolvePlayView$1.label -= Integer.MIN_VALUE;
                    Object $result = taskGroup$resolvePlayView$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (taskGroup$resolvePlayView$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            DownloadException vipCheck = checkVipState(this);
                            if (vipCheck == null) {
                                ResolveParam downloadParam = TaskGroupKt.access$getDownloadParam(this.f28video);
                                new DownloadLog(getKey()).resolvePlayView(downloadParam.toString());
                                KPlayViewUniteReq req = resolvePlayViewReq(downloadParam);
                                KPlayerMoss kPlayerMoss = new KPlayerMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                                taskGroup$resolvePlayView$1.L$0 = SpillingKt.nullOutSpilledVariable(vipCheck);
                                taskGroup$resolvePlayView$1.L$1 = SpillingKt.nullOutSpilledVariable(downloadParam);
                                taskGroup$resolvePlayView$1.L$2 = SpillingKt.nullOutSpilledVariable(req);
                                taskGroup$resolvePlayView$1.label = 1;
                                playViewUnite = kPlayerMoss.playViewUnite(req, taskGroup$resolvePlayView$1);
                                if (playViewUnite != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            } else {
                                return vipCheck;
                            }
                        case 1:
                            KPlayViewUniteReq kPlayViewUniteReq = (KPlayViewUniteReq) taskGroup$resolvePlayView$1.L$2;
                            ResolveParam resolveParam = (ResolveParam) taskGroup$resolvePlayView$1.L$1;
                            DownloadException downloadException = (DownloadException) taskGroup$resolvePlayView$1.L$0;
                            ResultKt.throwOnFailure($result);
                            playViewUnite = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    KPlayViewUniteReply res = (KPlayViewUniteReply) playViewUnite;
                    updateVideoInfo(res);
                    taskError = configGroupTasks(res);
                    if (taskError == null) {
                        return taskError;
                    }
                    updateVideoMedia();
                    playViewDidResolved(this.f28video, res, this.f28video.getRealVideoQuality());
                    return null;
                }
            }
            switch (taskGroup$resolvePlayView$1.label) {
            }
            KPlayViewUniteReply res2 = (KPlayViewUniteReply) playViewUnite;
            updateVideoInfo(res2);
            taskError = configGroupTasks(res2);
            if (taskError == null) {
            }
        } catch (Exception e) {
            new DownloadLog(getKey()).fail("playView 请求错误", e);
            DownloadException error = new DownloadException(DownloadErrorType.PLAYVIEW_ERROR.getErrorCode(), DownloadErrorType.PLAYVIEW_ERROR.getTrackMsg());
            return error;
        }
        taskGroup$resolvePlayView$1 = new TaskGroup$resolvePlayView$1(this, continuation);
        Object $result2 = taskGroup$resolvePlayView$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateVideoState(OfflineVideoEntity.State state, Continuation<? super Unit> continuation) {
        Object updateVideo;
        this.f28video.setState(state);
        DownloadProgressCallback downloadProgressCallback = this.progressCallback;
        return (downloadProgressCallback == null || (updateVideo = downloadProgressCallback.updateVideo(CollectionsKt.listOf(this.f28video), true, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : updateVideo;
    }

    private final DownloadException checkVipState(TaskGroup group) {
        boolean canLoadVip = false;
        OfflineUserInfo it = Config.Companion.getUserInfo();
        if (it != null) {
            int qn = TaskGroupKt.access$getDownloadParam(group.f28video).getPlayerInfo().getQn();
            int audioType = group.f28video.getVideoInfo().getAudioType();
            LogKt.getVBLog().info("check vip user info: " + it + " qn: [" + qn + "], audioType: [" + audioType + "]");
            boolean isVip = it.isVip();
            boolean z = true;
            boolean isUP = it.getMid() == group.f28video.getAuthorMid();
            if (!isVip && !isUP) {
                z = false;
            }
            canLoadVip = z;
        }
        DownloadException vipError = new DownloadException(DownloadErrorType.NOT_VIP_DOWNLOAD_VIP_VIDEO.getErrorCode(), DownloadErrorType.NOT_VIP_DOWNLOAD_VIP_VIDEO.getTrackMsg());
        if (!TaskGroupKt.access$getDownloadVipMedia(group.f28video) || canLoadVip) {
            return null;
        }
        return vipError;
    }

    private final KPlayViewUniteReq resolvePlayViewReq(ResolveParam param) {
        KCodeType codecType = KCodeType.Companion.fromValue(param.getPlayerInfo().getCodecType());
        KQnPolicy qnPolicy = KQnPolicy.Companion.fromValue(0);
        KVideoVod vod = new KVideoVod(param.getVideoInfo().getAid(), param.getVideoInfo().getCid(), param.getPlayerInfo().getQn(), param.getPlayerInfo().getFnver(), param.getPlayerInfo().getFnval(), 2, 2, param.getPlayerInfo().getFourk(), codecType, param.getPlayerInfo().getVoiceBalance(), param.getPlayerInfo().getNeedTrial(), qnPolicy, 0L, 0L, (String) null, (KProductionType) null, 61440, (DefaultConstructorMarker) null);
        KPlayCtrl playCtrl = KPlayCtrl.Companion.fromValue(1);
        Map extraContent = MapsKt.mapOf(new Pair[]{TuplesKt.to("ep_id", String.valueOf(param.getVideoInfo().getEpisodeId())), TuplesKt.to("season_id", String.valueOf(param.getVideoInfo().getSeasonId()))});
        return new KPlayViewUniteReq(vod, "", "", extraContent, "", "", (KFragment) null, param.getVideoInfo().getFromScene(), playCtrl);
    }

    private final void playViewDidResolved(OfflineVideoEntity entity, KPlayViewUniteReply res, int qn) {
        DownloadProgressCallback downloadProgressCallback = this.progressCallback;
        if (downloadProgressCallback != null) {
            KVodInfo vodInfo = res.getVodInfo();
            downloadProgressCallback.playViewDidResolved(entity, vodInfo != null ? ExtensionKt.transform(vodInfo) : null, qn);
        }
    }

    private final DownloadException configGroupTasks(KPlayViewUniteReply res) {
        List tasks = new ArrayList();
        ITask it = resolveCoverTask();
        tasks.add(it);
        ITask it2 = resolveOldDanmakuTask();
        tasks.add(it2);
        ITask it3 = resolveNewDanmakuTask();
        tasks.add(it3);
        List<ITask> mediaTasks = resolveMediaTasks(res);
        if (mediaTasks.isEmpty()) {
            return new DownloadException(DownloadErrorType.ADDRESS_EMPTY.getErrorCode(), DownloadErrorType.ADDRESS_EMPTY.getTrackMsg());
        }
        long totalSize = 0;
        for (ITask it4 : mediaTasks) {
            totalSize += it4.getSize();
        }
        if (!StorageInfoImpl_androidKt.pathInPrimaryStorage(this.f28video.getStoragePath()) && totalSize > IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            return new DownloadException(DownloadErrorType.TOO_LARGE.getErrorCode(), DownloadErrorType.TOO_LARGE.getTrackMsg());
        }
        StorageInfoModel storage = IStorageInfoKt.currentStorageInfo(StorageInfoImpl_androidKt.getStorageInfoList(false));
        LogKt.getVBLog().info("TaskGroup check storage: " + storage + ", totalSize: " + totalSize);
        if (totalSize > (storage != null ? storage.getAvailableSpace() : 0L) - 10485760) {
            return new DownloadException(DownloadErrorType.STORAGE_SPACE_FULL.getErrorCode(), DownloadErrorType.STORAGE_SPACE_FULL.getTrackMsg());
        }
        tasks.addAll(mediaTasks);
        updateTasks(tasks);
        new DownloadLog(getKey()).configTasks(tasks.size());
        return null;
    }

    private final void updateTasks(List<? extends ITask> list) {
        this.tasks.clear();
        this.tasks.addAll(list);
        Iterable $this$forEach$iv = this.tasks;
        for (Object element$iv : $this$forEach$iv) {
            ITask it = (ITask) element$iv;
            it.setDelegate(this);
        }
    }

    private final ITask resolveCoverTask() {
        return new CoverTask(TaskGroupKt.access$getDownloadParam(this.f28video).getVideoInfo().getCover(), DiskFileImpl_androidKt.filePath(this.f28video, FileType.Cover.INSTANCE), TaskType.COVER, null, 0L, getKey(), 24, null);
    }

    private final ITask resolveOldDanmakuTask() {
        return new XMLDanmakuTask("https://api.bilibili.com/x/v1/dm/list.so?oid=" + this.f28video.getCid(), DiskFileImpl_androidKt.filePath(this.f28video, new FileType.Danmaku(false)), TaskType.DANMAKU, null, 0L, getKey(), 24, null);
    }

    private final ITask resolveNewDanmakuTask() {
        return new PBDanmakuTask(null, DiskFileImpl_androidKt.filePath(this.f28video, new FileType.Danmaku(true)), null, null, 0L, getKey(), MapsKt.mapOf(new Pair[]{TuplesKt.to("oid", String.valueOf(this.f28video.getCid())), TuplesKt.to("pid", String.valueOf(this.f28video.getAid()))}), 29, null);
    }

    private final List<ITask> resolveMediaTasks(KPlayViewUniteReply res) {
        KStream.KDashVideo content;
        KDashItem audio;
        KStreamInfo streamInfo;
        KStreamInfo streamInfo2;
        KStreamInfo streamInfo3;
        int qn = Math.max(this.f28video.getVideoInfo().getQn(), 16);
        KStream stream = fetchRealSteam(qn, res);
        if (!((stream == null || (streamInfo3 = stream.getStreamInfo()) == null || streamInfo3.getQuality() != qn) ? false : true)) {
            new DownloadLog(getKey()).info("下载清晰度降级:  请求清晰度:" + qn + ", 实际清晰度:" + ((stream == null || (streamInfo2 = stream.getStreamInfo()) == null) ? null : Integer.valueOf(streamInfo2.getQuality())) + " ");
        }
        boolean audioDolby = this.f28video.getVideoInfo().getAudioType() > 0;
        boolean videoDolby = (stream == null || (streamInfo = stream.getStreamInfo()) == null || streamInfo.getQuality() != 126) ? false : true;
        this.isDolby = audioDolby || videoDolby;
        List tasks = new ArrayList();
        if (stream != null && (content = stream.getContent()) != null) {
            this.f28video.getSectionsContentTime().clear();
            if (content instanceof KStream.KDashVideo) {
                List sectionsContentTime = new ArrayList();
                KVodInfo vodInfo = res.getVodInfo();
                if (vodInfo != null && (audio = ExtensionKt.audioRes(vodInfo, audioDolby)) != null) {
                    MediaTask dashAudioTask = new MediaTask(audio.getBaseUrl(), audio.getBackupUrl(), DiskFileImpl_androidKt.filePath(this.f28video, new FileType.Audio(true, 1)), TaskType.AUDIO, audio.getMd5(), audio.getSize(), getKey(), this.f28video.getFrom());
                    tasks.add(dashAudioTask);
                    KVodInfo vodInfo2 = res.getVodInfo();
                    if (vodInfo2 != null) {
                        Long valueOf = Long.valueOf(vodInfo2.getTimelength());
                        long it = valueOf.longValue();
                        if (!(it > 0)) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            long it2 = valueOf.longValue();
                            sectionsContentTime.add(Long.valueOf(it2));
                        }
                    }
                }
                MediaTask dashVideoTask = new MediaTask(content.getValue().getBaseUrl(), content.getValue().getBackupUrl(), DiskFileImpl_androidKt.filePath(this.f28video, new FileType.Video(true, 0)), TaskType.VIDEO, content.getValue().getMd5(), content.getValue().getSize(), getKey(), this.f28video.getFrom());
                tasks.add(dashVideoTask);
                KVodInfo vodInfo3 = res.getVodInfo();
                if (vodInfo3 != null) {
                    Long valueOf2 = Long.valueOf(vodInfo3.getTimelength());
                    long it3 = valueOf2.longValue();
                    if (!(it3 > 0)) {
                        valueOf2 = null;
                    }
                    if (valueOf2 != null) {
                        long it4 = valueOf2.longValue();
                        sectionsContentTime.add(Long.valueOf(it4));
                    }
                }
                this.f28video.setSectionsContentTime(CollectionsKt.toMutableList(CollectionsKt.reversed(sectionsContentTime)));
            } else if (content instanceof KStream.KSegmentVideo) {
                Iterable $this$mapIndexed$iv = ((KStream.KSegmentVideo) content).getValue().getSegment();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                int index$iv$iv = 0;
                for (Object item$iv$iv : $this$mapIndexed$iv) {
                    int index$iv$iv2 = index$iv$iv + 1;
                    if (index$iv$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    KResponseUrl segment = (KResponseUrl) item$iv$iv;
                    this.f28video.getSectionsContentTime().add(Long.valueOf(segment.getLength()));
                    destination$iv$iv.add(new MediaTask(segment.getUrl(), segment.getBackupUrl(), DiskFileImpl_androidKt.filePath(this.f28video, new FileType.Video(false, index$iv$iv)), TaskType.VIDEO, segment.getMd5(), segment.getSize(), getKey(), this.f28video.getFrom()));
                    index$iv$iv = index$iv$iv2;
                    qn = qn;
                    stream = stream;
                }
                List segmentTask = (List) destination$iv$iv;
                tasks.addAll(segmentTask);
            }
        }
        return tasks;
    }

    private final void updateVideoInfo(KPlayViewUniteReply res) {
        KDashItem audio;
        OfflineVideoEntity.MediaType mediaType;
        int quality;
        KStreamInfo streamInfo;
        KDashVideo value;
        String bilidrmUri;
        KDrmTechType drmTechType;
        KDashVideo value2;
        KDashVideo value3;
        KStreamInfo streamInfo2;
        KStreamInfo streamInfo3;
        KStreamInfo streamInfo4;
        KDimension dimension;
        KDimension dimension2;
        KDimension dimension3;
        int qn = Math.max(this.f28video.getVideoInfo().getQn(), 16);
        KStream stream = fetchRealSteam(qn, res);
        KVodInfo vodInfo = res.getVodInfo();
        int i = 0;
        if (vodInfo != null) {
            audio = ExtensionKt.audioRes(vodInfo, this.f28video.getVideoInfo().getAudioType() > 0);
        } else {
            audio = null;
        }
        OfflineVideoEntity offlineVideoEntity = this.f28video;
        KPlayArc playArc = res.getPlayArc();
        long j = 0;
        offlineVideoEntity.setWidth((playArc == null || (dimension3 = playArc.getDimension()) == null) ? 0L : dimension3.getWidth());
        OfflineVideoEntity offlineVideoEntity2 = this.f28video;
        KPlayArc playArc2 = res.getPlayArc();
        offlineVideoEntity2.setHeight((playArc2 == null || (dimension2 = playArc2.getDimension()) == null) ? 0L : dimension2.getHeight());
        OfflineVideoEntity offlineVideoEntity3 = this.f28video;
        KPlayArc playArc3 = res.getPlayArc();
        offlineVideoEntity3.setRotate((playArc3 == null || (dimension = playArc3.getDimension()) == null) ? 0L : dimension.getRotate());
        OfflineVideoEntity offlineVideoEntity4 = this.f28video;
        Duration.Companion companion = Duration.Companion;
        KVodInfo vodInfo2 = res.getVodInfo();
        offlineVideoEntity4.m2774setDurationLRDsOJo(DurationKt.toDuration(vodInfo2 != null ? vodInfo2.getTimelength() : 0L, DurationUnit.MILLISECONDS));
        this.f28video.setRealVideoQuality((stream == null || (streamInfo4 = stream.getStreamInfo()) == null) ? qn : streamInfo4.getQuality());
        this.f28video.setPreferredVideoQuality(qn);
        String str = "";
        this.f28video.setQualityDisplay((stream == null || (streamInfo3 = stream.getStreamInfo()) == null || (r9 = streamInfo3.getDisplayDesc()) == null) ? "" : "");
        this.f28video.setQualityName((stream == null || (streamInfo2 = stream.getStreamInfo()) == null || (r9 = streamInfo2.getNewDescription()) == null) ? "" : "");
        OfflineVideoEntity offlineVideoEntity5 = this.f28video;
        KStream.IContent content = stream != null ? stream.getContent() : null;
        if (content instanceof KStream.KDashVideo) {
            mediaType = OfflineVideoEntity.MediaType.DASH;
        } else {
            mediaType = content instanceof KStream.KSegmentVideo ? OfflineVideoEntity.MediaType.FLV : OfflineVideoEntity.MediaType.DASH;
        }
        offlineVideoEntity5.setMediaType(mediaType);
        OfflineVideoEntity offlineVideoEntity6 = this.f28video;
        KVodInfo vodInfo3 = res.getVodInfo();
        int quality2 = vodInfo3 != null ? vodInfo3.getQuality() : 0;
        OfflineVideoEntity.MediaType mediaType2 = this.f28video.getMediaType();
        KVodInfo vodInfo4 = res.getVodInfo();
        offlineVideoEntity6.setQnPath(DiskFileImpl_androidKt.qnPath(quality2, mediaType2, (vodInfo4 == null || (r11 = vodInfo4.getFormat()) == null) ? "" : ""));
        VideoPlayInfo videoInfo = this.f28video.getVideoInfo();
        KVodInfo vodInfo5 = res.getVodInfo();
        videoInfo.setVideoId(vodInfo5 != null ? vodInfo5.getQuality() : qn);
        this.f28video.getVideoInfo().setAudioId(audio != null ? audio.getId() : 0);
        VideoPlayInfo videoInfo2 = this.f28video.getVideoInfo();
        KStream.IContent content2 = stream != null ? stream.getContent() : null;
        KStream.KDashVideo kDashVideo = content2 instanceof KStream.KDashVideo ? (KStream.KDashVideo) content2 : null;
        videoInfo2.setVideoMd5((kDashVideo == null || (value3 = kDashVideo.getValue()) == null || (r9 = value3.getMd5()) == null) ? "" : "");
        this.f28video.getVideoInfo().setAudioMd5((audio == null || (r9 = audio.getMd5()) == null) ? "" : "");
        VideoPlayInfo videoInfo3 = this.f28video.getVideoInfo();
        KStream.IContent content3 = stream != null ? stream.getContent() : null;
        KStream.KDashVideo kDashVideo2 = content3 instanceof KStream.KDashVideo ? (KStream.KDashVideo) content3 : null;
        videoInfo3.setVideoCodecid((kDashVideo2 == null || (value2 = kDashVideo2.getValue()) == null) ? 0 : value2.getCodecid());
        this.f28video.getVideoInfo().setAudioCodecid(audio != null ? audio.getCodecid() : 0);
        VideoPlayInfo videoInfo4 = this.f28video.getVideoInfo();
        KPlayArc playArc4 = res.getPlayArc();
        if (playArc4 != null && (drmTechType = playArc4.getDrmTechType()) != null) {
            i = drmTechType.getValue();
        }
        videoInfo4.setDashDrmType(i);
        VideoPlayInfo videoInfo5 = this.f28video.getVideoInfo();
        KStream.KDashVideo content4 = stream != null ? stream.getContent() : null;
        KStream.KDashVideo kDashVideo3 = content4 instanceof KStream.KDashVideo ? content4 : null;
        if (kDashVideo3 != null && (value = kDashVideo3.getValue()) != null && (bilidrmUri = value.getBilidrmUri()) != null) {
            str = bilidrmUri;
        }
        videoInfo5.setBiliDrmUri(str);
        this.f28video.getVideoInfo().setPreferredAudioQuality(audio != null ? audio.getId() : qn);
        VideoPlayInfo videoInfo6 = this.f28video.getVideoInfo();
        if (audio != null) {
            quality = audio.getId();
        } else {
            KVodInfo vodInfo6 = res.getVodInfo();
            quality = vodInfo6 != null ? vodInfo6.getQuality() : qn;
        }
        videoInfo6.setRealAudioQuality(quality);
        VideoPlayInfo videoInfo7 = this.f28video.getVideoInfo();
        if (stream != null && (streamInfo = stream.getStreamInfo()) != null) {
            j = streamInfo.getAttribute();
        }
        videoInfo7.setAttribute(j);
        new DownloadLog(getKey()).info("updateVideoInfo: " + this.f28video.getVideoInfo());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final KStream fetchRealSteam(int qn, KPlayViewUniteReply res) {
        Collection destination$iv$iv;
        KStream kStream;
        KStream stream;
        Iterable $this$sortedBy$iv;
        boolean z;
        Object obj;
        KStream it;
        Iterable streamList;
        KStream.IContent content;
        KVodInfo vodInfo = res.getVodInfo();
        KStream stream2 = null;
        if (vodInfo == null || (streamList = vodInfo.getStreamList()) == null) {
            destination$iv$iv = null;
        } else {
            Iterable $this$filter$iv = streamList;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                KStream it2 = (KStream) element$iv$iv;
                KStream.KDashVideo content2 = it2.getContent();
                if (content2 instanceof KStream.KDashVideo) {
                    content = (StringsKt.isBlank(content2.getValue().getBaseUrl()) && content2.getValue().getBackupUrl().isEmpty()) ? null : 1;
                } else if (content2 instanceof KStream.KSegmentVideo) {
                    content = !((KStream.KSegmentVideo) content2).getValue().getSegment().isEmpty() ? 1 : null;
                } else {
                    content = null;
                }
                if (content != null) {
                    destination$iv$iv2.add(element$iv$iv);
                }
            }
            destination$iv$iv = (List) destination$iv$iv2;
        }
        Collection availableList = destination$iv$iv;
        if (availableList != null) {
            Iterable $this$sortedBy$iv2 = CollectionsKt.sortedWith(availableList, new Comparator() { // from class: video.biz.offline.base.infra.download.TaskGroup$fetchRealSteam$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    KStream it3 = (KStream) t;
                    KStreamInfo streamInfo = it3.getStreamInfo();
                    Integer valueOf = Integer.valueOf(-(streamInfo != null ? streamInfo.getQuality() : 0));
                    KStream it4 = (KStream) t2;
                    KStreamInfo streamInfo2 = it4.getStreamInfo();
                    return ComparisonsKt.compareValues(valueOf, Integer.valueOf(-(streamInfo2 != null ? streamInfo2.getQuality() : 0)));
                }
            });
            if ($this$sortedBy$iv2 != null) {
                Iterator it3 = $this$sortedBy$iv2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it3.next();
                    KStream it4 = (KStream) obj;
                    KStreamInfo streamInfo = it4.getStreamInfo();
                    if ((streamInfo != null ? streamInfo.getQuality() : 9999) <= qn) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        break;
                    }
                }
                kStream = (KStream) obj;
                stream = kStream;
                if (stream != null) {
                    if (availableList != null && ($this$sortedBy$iv = CollectionsKt.sortedWith(availableList, new Comparator() { // from class: video.biz.offline.base.infra.download.TaskGroup$fetchRealSteam$$inlined$sortedBy$2
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            KStream it5 = (KStream) t;
                            KStreamInfo streamInfo2 = it5.getStreamInfo();
                            Integer valueOf = Integer.valueOf(streamInfo2 != null ? streamInfo2.getQuality() : 0);
                            KStream it6 = (KStream) t2;
                            KStreamInfo streamInfo3 = it6.getStreamInfo();
                            return ComparisonsKt.compareValues(valueOf, Integer.valueOf(streamInfo3 != null ? streamInfo3.getQuality() : 0));
                        }
                    })) != null) {
                        Iterator it5 = $this$sortedBy$iv.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            Object next = it5.next();
                            KStream it6 = (KStream) next;
                            List<Integer> vipQualities = OfflineConfigKt.getVipQualities();
                            KStreamInfo streamInfo2 = it6.getStreamInfo();
                            boolean isVipQn = vipQualities.contains(Integer.valueOf(streamInfo2 != null ? streamInfo2.getQuality() : 16));
                            OfflineUserInfo userInfo = Config.Companion.getUserInfo();
                            boolean isVip = userInfo != null && userInfo.isVip();
                            if (isVipQn) {
                                z = isVip;
                                continue;
                            } else {
                                z = true;
                                continue;
                            }
                            if (z) {
                                stream2 = next;
                                break;
                            }
                        }
                        stream2 = stream2;
                    }
                    return stream2;
                }
                return stream;
            }
        }
        kStream = null;
        stream = kStream;
        if (stream != null) {
        }
    }

    private final void updateVideoMedia() {
        Iterable $this$filter$iv = this.tasks;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ITask it = (ITask) element$iv$iv;
            if (it.isMedia()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List<ITask> mediaList = (List) destination$iv$iv;
        OfflineVideoEntity offlineVideoEntity = this.f28video;
        List $this$map$iv = mediaList;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ITask it2 = (ITask) item$iv$iv;
            destination$iv$iv2.add(Long.valueOf(it2.getSize()));
        }
        offlineVideoEntity.setSectionsLengthList(CollectionsKt.toMutableList(CollectionsKt.reversed((List) destination$iv$iv2)));
        this.f28video.setSections(mediaList.size());
        OfflineVideoEntity offlineVideoEntity2 = this.f28video;
        long j = 0;
        for (ITask it3 : mediaList) {
            j += it3.getSize();
        }
        offlineVideoEntity2.setTotalSize(j);
    }

    private final void reportDolbyIfNeed() {
        int videoType;
        if (!this.isDolby) {
            return;
        }
        new DownloadLog(getKey()).info("report dolby api");
        switch (WhenMappings.$EnumSwitchMapping$0[this.f28video.getBizType().ordinal()]) {
            case 1:
                videoType = 1;
                break;
            case 2:
                videoType = 2;
                break;
            case 3:
                videoType = 3;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        KDolbyReportKt.getKDolbyReport().report(this.f28video.getAid(), this.f28video.getCid(), videoType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        TaskGroup taskGroup = (TaskGroup) other;
        return Intrinsics.areEqual(getKey(), ((TaskGroup) other).getKey());
    }

    public int hashCode() {
        return getKey().hashCode();
    }
}