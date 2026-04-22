package video.biz.offline.base.infra.download.tasks;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.error.DownloadException;

/* compiled from: ITask.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020'H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001dX¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001f¨\u0006*À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/infra/download/tasks/ITask;", "", "url", "", "getUrl", "()Ljava/lang/String;", "fullPath", "getFullPath", "type", "Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "getType", "()Lvideo/biz/offline/base/infra/download/tasks/TaskType;", "md5", "getMd5", "size", "", "getSize", "()J", "downloadSize", "getDownloadSize", "setDownloadSize", "(J)V", "delegate", "Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "getDelegate", "()Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;", "setDelegate", "(Lvideo/biz/offline/base/infra/download/tasks/ITaskStateChange;)V", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "start", "", "pause", "isMedia", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ITask {
    boolean getComplete();

    ITaskStateChange getDelegate();

    long getDownloadSize();

    String getFullPath();

    String getKey();

    String getMd5();

    long getSize();

    TaskType getType();

    String getUrl();

    boolean isMedia();

    void pause();

    void setComplete(boolean z);

    void setDelegate(ITaskStateChange iTaskStateChange);

    void setDownloadSize(long j);

    void setKey(String str);

    void start() throws DownloadException, CancellationException;

    /* compiled from: ITask.kt */
    /* renamed from: video.biz.offline.base.infra.download.tasks.ITask$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$isMedia(ITask _this) {
            return _this.getType() == TaskType.VIDEO || _this.getType() == TaskType.AUDIO;
        }
    }

    /* compiled from: ITask.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isMedia(ITask $this) {
            return CC.$default$isMedia($this);
        }
    }
}