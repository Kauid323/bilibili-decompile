package video.biz.offline.base.infra.download.tasks;

import com.bapis.bilibili.community.service.dm.v1.KDmSegMobileReply;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import kotlinx.serialization.protobuf.ProtoBuf;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.download.tasks.ITask;
import video.biz.offline.base.infra.utils.DownloadLog;
import video.biz.offline.base.infra.utils.OfflineScopeKt;
import video.biz.offline.base.model.error.DownloadException;

/* compiled from: PBDanmakuTask.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020+H\u0016J\b\u00104\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00065"}, d2 = {"Lvideo/biz/offline/base/infra/download/tasks/PBDanmakuTask;", "Lvideo/biz/offline/base/infra/download/tasks/ITask;", "url", "", "fullPath", "type", "Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "md5", "size", "", "key", "extended", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lvideo/biz/offline/base/infra/download/tasks/TaskType;Ljava/lang/String;JLjava/lang/String;Ljava/util/Map;)V", "getUrl", "()Ljava/lang/String;", "getFullPath", "getType", "()Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "getMd5", "getSize", "()J", "getKey", "setKey", "(Ljava/lang/String;)V", "downloadSize", "getDownloadSize", "setDownloadSize", "(J)V", "delegate", "Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "getDelegate", "()Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "setDelegate", "(Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;)V", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "start", "", "downloadDanmaku", "save2File", "res", "Lcom/bapis/bilibili/community/service/dm/v1/KDmSegMobileReply;", "updateDanmakuCount", "count", "", "pause", "toString", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PBDanmakuTask implements ITask {
    public static final int $stable = 8;
    private boolean complete;
    private ITaskStateChange delegate;
    private long downloadSize;
    private Map<String, String> extended;
    private final String fullPath;
    private String key;
    private final String md5;
    private final long size;
    private final TaskType type;
    private final String url;

    public PBDanmakuTask(String url, String fullPath, TaskType type, String md5, long size, String key, Map<String, String> map) {
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
        this.extended = map;
    }

    public /* synthetic */ PBDanmakuTask(String str, String str2, TaskType taskType, String str3, long j, String str4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, (i & 4) != 0 ? TaskType.DANMAKU : taskType, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? 0L : j, str4, map);
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
        downloadDanmaku();
    }

    private final void downloadDanmaku() {
        BuildersKt.launch$default(OfflineScopeKt.getDownloadScope(), (CoroutineContext) null, (CoroutineStart) null, new PBDanmakuTask$downloadDanmaku$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void save2File(KDmSegMobileReply res) {
        Path parent = PathsJvmKt.Path(getFullPath()).getParent();
        if (parent != null && !FileSystemJvmKt.SystemFileSystem.exists(parent)) {
            FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, parent, false, 2, (Object) null);
        }
        Path filePath = PathsJvmKt.Path(getFullPath());
        Sink sink = CoreKt.buffered(FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, filePath, false, 2, (Object) null));
        try {
            try {
                byte[] data = ProtoBuf.Default.encodeToByteArray(KDmSegMobileReply.Companion.serializer(), res);
                Sink.-CC.write$default(sink, data, 0, 0, 6, (Object) null);
                sink.flush();
            } catch (Exception e) {
                new DownloadLog(getKey()).error("DanmakuTask " + this + " save to file error: " + e);
            }
        } finally {
            sink.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDanmakuCount(int count) {
        if (count > 0) {
            new DownloadLog(getKey()).info("update PBDanmakuTask count: " + count);
            ITaskStateChange delegate = getDelegate();
            if (delegate != null) {
                delegate.danmakuUpdate(count);
            }
        }
    }

    @Override // video.biz.offline.base.infra.download.tasks.ITask
    public void pause() {
        setDelegate(null);
    }

    public String toString() {
        TaskType type = getType();
        String fullPath = getFullPath();
        return type + " PBDanmakuTask Task(fullPath='" + fullPath + "', extended=" + this.extended + ")";
    }
}