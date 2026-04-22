package video.biz.offline.base.infra.download.tasks;

import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.download.tasks.ITask;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.error.DownloadException;

/* compiled from: CoverTask.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lvideo/biz/offline/base/infra/download/tasks/CoverTask;", "Lvideo/biz/offline/base/infra/download/tasks/ITask;", "url", "", "fullPath", "type", "Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "md5", "size", "", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lvideo/biz/offline/base/infra/download/tasks/TaskType;Ljava/lang/String;JLjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getFullPath", "getType", "()Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "getMd5", "getSize", "()J", "getKey", "setKey", "(Ljava/lang/String;)V", "downloadSize", "getDownloadSize", "setDownloadSize", "(J)V", "delegate", "Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "getDelegate", "()Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "setDelegate", "(Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;)V", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "client", "Lio/ktor/client/HttpClient;", "start", "", "downloadCover", "pause", "toString", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CoverTask implements ITask {
    public static final int $stable = 8;
    private final HttpClient client;
    private boolean complete;
    private ITaskStateChange delegate;
    private long downloadSize;
    private final String fullPath;
    private String key;
    private final String md5;
    private final long size;
    private final TaskType type;
    private final String url;

    public CoverTask(String url, String fullPath, TaskType type, String md5, long size, String key) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(key, "key");
        this.url = url;
        this.fullPath = fullPath;
        this.type = type;
        this.md5 = md5;
        this.size = size;
        this.key = key;
        this.client = KtorClientKt.getKtorHttpClient();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CoverTask(String str, String str2, TaskType taskType, String str3, long j, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, taskType, r5, r6, str4);
        String str5;
        long j2;
        if ((i & 8) == 0) {
            str5 = str3;
        } else {
            str5 = "";
        }
        if ((i & 16) == 0) {
            j2 = j;
        } else {
            j2 = 0;
        }
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
        downloadCover();
    }

    private final void downloadCover() {
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new CoverTask$downloadCover$1(this, null), 3, (Object) null);
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void pause() {
        setDelegate(null);
        CoroutineScopeKt.cancel$default(this.client, (CancellationException) null, 1, (Object) null);
    }

    public String toString() {
        TaskType type = getType();
        String url = getUrl();
        return type + " Task(url=" + url + ", fullPath=" + getFullPath() + ")";
    }
}