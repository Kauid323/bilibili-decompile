package video.biz.offline.base.infra.download.tasks;

import java.util.List;
import java.util.concurrent.CancellationException;
import kntr.base.KDownloader.KDownloader.IDownloader;
import kntr.base.KDownloader.KDownloader.KDownloader;
import kntr.base.reachability.KReachabilityKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.download.tasks.ITask;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.ConfigImpl_androidKt;
import video.biz.offline.base.infra.utils.DownloadLog;
import video.biz.offline.base.model.error.BandwidthError;
import video.biz.offline.base.model.error.DownloadException;
import video.biz.offline.base.model.error.InfraDownloaderError;
import video.interfacee.bridge.freeBandwidth.BandwidthResult;
import video.interfacee.bridge.freeBandwidth.KFreeBandwidthKt;

/* compiled from: MediaTask.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u00020\u0003H\u0016J\u0013\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u000107H\u0096\u0002J\b\u00108\u001a\u00020.H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lvideo/biz/offline/base/infra/download/tasks/MediaTask;", "Lvideo/biz/offline/base/infra/download/tasks/ITask;", "url", "", "backupUrls", "", "fullPath", "type", "Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "md5", "size", "", "key", "from", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lvideo/biz/offline/base/infra/download/tasks/TaskType;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getFullPath", "getType", "()Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "getMd5", "getSize", "()J", "getKey", "setKey", "(Ljava/lang/String;)V", "downloadSize", "getDownloadSize", "setDownloadSize", "(J)V", "delegate", "Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "getDelegate", "()Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "setDelegate", "(Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;)V", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "task", "Lkntr/base/KDownloader/KDownloader/IDownloader$Task;", "backupIdx", "", "Ljava/lang/Integer;", "executeUrl", "start", "", "pause", "toString", "equals", "other", "", "hashCode", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaTask implements ITask {
    public static final int $stable = 8;
    private Integer backupIdx;
    private final List<String> backupUrls;
    private boolean complete;
    private ITaskStateChange delegate;
    private long downloadSize;
    private String executeUrl;
    private String from;
    private final String fullPath;
    private String key;
    private final String md5;
    private final long size;
    private IDownloader.Task task;
    private final TaskType type;
    private final String url;

    public MediaTask(String url, List<String> list, String fullPath, TaskType type, String md5, long size, String key, String from) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(list, "backupUrls");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(from, "from");
        this.url = url;
        this.backupUrls = list;
        this.fullPath = fullPath;
        this.type = type;
        this.md5 = md5;
        this.size = size;
        this.key = key;
        this.from = from;
        this.executeUrl = getUrl();
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public /* bridge */ boolean isMedia() {
        return ITask.CC.$default$isMedia(this);
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public String getUrl() {
        return this.url;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public String getFullPath() {
        return this.fullPath;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public TaskType getType() {
        return this.type;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public String getMd5() {
        return this.md5;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public long getSize() {
        return this.size;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public String getKey() {
        return this.key;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public long getDownloadSize() {
        return this.downloadSize;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void setDownloadSize(long j) {
        this.downloadSize = j;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public ITaskStateChange getDelegate() {
        return this.delegate;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void setDelegate(ITaskStateChange iTaskStateChange) {
        this.delegate = iTaskStateChange;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public boolean getComplete() {
        return this.complete;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void setComplete(boolean z) {
        this.complete = z;
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void start() throws DownloadException, CancellationException {
        String url;
        IDownloader.DownloadListener downloadListener = new IDownloader.DownloadListener() { // from class: video.biz.offline.base.infra.download.tasks.MediaTask$start$listener$1
            public /* bridge */ void onCancel() {
                IDownloader.DownloadListener.-CC.$default$onCancel(this);
            }

            public /* bridge */ void onPause() {
                IDownloader.DownloadListener.-CC.$default$onPause(this);
            }

            public void onLoading(IDownloader.Info.Loading info) {
                Intrinsics.checkNotNullParameter(info, "info");
                MediaTask.this.setDownloadSize(info.getLoadedSize());
                ITaskStateChange delegate = MediaTask.this.getDelegate();
                if (delegate != null) {
                    delegate.onLoading(MediaTask.this);
                }
            }

            public void onFinish(IDownloader.Info.Success result) {
                Intrinsics.checkNotNullParameter(result, "result");
                MediaTask.this.setDownloadSize(MediaTask.this.getSize());
                MediaTask.this.setComplete(true);
                ITaskStateChange delegate = MediaTask.this.getDelegate();
                if (delegate != null) {
                    delegate.onFinish(MediaTask.this);
                }
            }

            public void onError(IDownloader.Info.Error result) {
                Integer num;
                Integer num2;
                List list;
                Integer currentIdx;
                Intrinsics.checkNotNullParameter(result, "result");
                Integer num3 = (Integer) CollectionsKt.firstOrNull(result.getErrorCodes());
                int infraErrorCode = num3 != null ? num3.intValue() : 2233;
                InfraDownloaderError infraError = new InfraDownloaderError(Math.abs(infraErrorCode));
                new DownloadLog(MediaTask.this.getKey()).fail("单个task下载失败 infra errorCodes = " + result.getErrorCodes() + " " + MediaTask.this, result.getThrowable());
                DownloadLog downloadLog = new DownloadLog(MediaTask.this.getKey());
                List<Integer> retryErrorCodes = ConfigImpl_androidKt.getRetryErrorCodes();
                num = MediaTask.this.backupIdx;
                downloadLog.info(StringsKt.trimIndent("\n                        check code can backup error code: " + infraErrorCode + " retryCodes: [" + retryErrorCodes + "] backupIdx:[" + num + "]\n                        "));
                if (ConfigImpl_androidKt.getRetryErrorCodes().contains(Integer.valueOf(infraErrorCode))) {
                    num2 = MediaTask.this.backupIdx;
                    int intValue = num2 != null ? num2.intValue() : 0;
                    list = MediaTask.this.backupUrls;
                    if (intValue < list.size()) {
                        currentIdx = MediaTask.this.backupIdx;
                        MediaTask.this.backupIdx = Integer.valueOf(currentIdx != null ? currentIdx.intValue() + 1 : 0);
                        MediaTask.this.start();
                        return;
                    }
                }
                DownloadException error = new DownloadException(infraError.getErrorCode(), result.getThrowable().getMessage());
                ITaskStateChange delegate = MediaTask.this.getDelegate();
                if (delegate != null) {
                    delegate.onError(MediaTask.this, error);
                }
            }
        };
        if (this.backupIdx != null) {
            List<String> list = this.backupUrls;
            Integer num = this.backupIdx;
            url = (String) CollectionsKt.getOrNull(list, num != null ? num.intValue() : 0);
            if (url == null) {
                url = getUrl();
            }
            new DownloadLog(getKey()).startDownload("download true url useBackup index: [" + this.backupIdx + "] [" + url + "] [" + this.backupUrls + "]");
        } else {
            new DownloadLog(getKey()).startDownload("download true url base url [" + getUrl() + "] [" + this.backupUrls + "]");
            url = getUrl();
        }
        this.executeUrl = url;
        DownloadLog downloadLog = new DownloadLog(getKey());
        boolean enableDownloadWithWWAN = Config.Companion.getEnableDownloadWithWWAN();
        downloadLog.info(StringsKt.trimIndent("\n            start download check network  enableWWAN: [" + enableDownloadWithWWAN + "] BandwidthState: [" + KFreeBandwidthKt.getKFreeBandwidth().isFreeBandwidthActive() + "] NetState: [" + KReachabilityKt.getKReachability().getCurrentState() + "]\n            "));
        if (KFreeBandwidthKt.getKFreeBandwidth().isFreeBandwidthActive() && KReachabilityKt.getKReachability().isReachableViaWWAN() && !Config.Companion.getEnableDownloadWithWWAN()) {
            if (MediaTaskKt.access$getThirdPartFrom(this.from)) {
                DownloadException error = new DownloadException(new BandwidthError(1001).getErrorCode(), "from is not third part [" + this.from + "]");
                ITaskStateChange delegate = getDelegate();
                if (delegate != null) {
                    delegate.onError(this, error);
                    return;
                }
                return;
            }
            BandwidthResult result = KFreeBandwidthKt.getKFreeBandwidth().transformUrl(this.executeUrl, true, "GET");
            if (result.getSuccess()) {
                String url2 = result.getUrl();
                if (url2 == null) {
                    new DownloadLog(getKey()).error("download with freeBandwidth url is null");
                    BandwidthError infraError = new BandwidthError(result.getErrorCode());
                    DownloadException error2 = new DownloadException(infraError.getErrorCode(), "download with freeBandwidth url is null");
                    ITaskStateChange delegate2 = getDelegate();
                    if (delegate2 != null) {
                        delegate2.onError(this, error2);
                        return;
                    }
                    return;
                }
                new DownloadLog(getKey()).startDownload("download true url freeBandwidth [" + this + "] " + url2);
                this.executeUrl = url2;
            } else {
                new DownloadLog(getKey()).error("download true url freeBandwidth error [" + this + "] " + result.getErrorCode());
                BandwidthError infraError2 = new BandwidthError(result.getErrorCode());
                DownloadException error3 = new DownloadException(infraError2.getErrorCode(), "download with freeBandwidth error");
                ITaskStateChange delegate3 = getDelegate();
                if (delegate3 != null) {
                    delegate3.onError(this, error3);
                    return;
                }
                return;
            }
        }
        this.task = new KDownloader().create(this.executeUrl, getFullPath(), ITaskKt.DOWNLOAD_TAG).addListener(downloadListener).md5(getMd5()).build();
        IDownloader.Task task = this.task;
        if (task != null) {
            task.enqueue();
        }
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void pause() {
        setDelegate(null);
        KDownloader kDownloader = new KDownloader();
        IDownloader.Task task = this.task;
        kDownloader.pause(TaskUtil_androidKt.getTaskId(task != null ? task.getTaskId() : null, getUrl()));
    }

    public String toString() {
        TaskType type = getType();
        String str = this.executeUrl;
        List<String> list = this.backupUrls;
        String fullPath = getFullPath();
        String md5 = getMd5();
        return type + " Task(executeUrl: '" + str + "', backups=" + list + "  fullPath='" + fullPath + "', md5='" + md5 + "', size=" + getSize() + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        MediaTask mediaTask = (MediaTask) other;
        if (Intrinsics.areEqual(getUrl(), ((MediaTask) other).getUrl()) && Intrinsics.areEqual(getFullPath(), ((MediaTask) other).getFullPath()) && getType() == ((MediaTask) other).getType() && Intrinsics.areEqual(getMd5(), ((MediaTask) other).getMd5()) && getSize() == ((MediaTask) other).getSize()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(getClass()).hashCode();
    }
}