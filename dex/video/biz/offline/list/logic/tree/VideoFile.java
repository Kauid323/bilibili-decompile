package video.biz.offline.list.logic.tree;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoFile.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\rH&R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, d2 = {"Lvideo/biz/offline/list/logic/tree/VideoFile;", "", "<init>", "()V", "fileInputStream", "Ljava/io/FileInputStream;", "getFileInputStream", "()Ljava/io/FileInputStream;", "getFileOutputStream", "Ljava/io/FileOutputStream;", "append", "", "listFiles", "", "isDirectory", "()Z", "parentFile", "getParentFile", "()Lvideo/biz/offline/list/logic/tree/VideoFile;", "name", "", "getName", "()Ljava/lang/String;", "absolutePath", "getAbsolutePath", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class VideoFile {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String TREE_END = "\n";
    public static final String TREE_INTERVAL_VERTICAL = " |     ";
    public static final String TREE_LAST_START = " \\--- ";
    public static final String TREE_START = "+--- ";

    public abstract String getAbsolutePath();

    public abstract FileInputStream getFileInputStream();

    public abstract FileOutputStream getFileOutputStream(boolean z);

    public abstract String getName();

    public abstract VideoFile getParentFile();

    public abstract boolean isDirectory();

    public abstract List<VideoFile> listFiles();

    /* compiled from: VideoFile.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J&\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lvideo/biz/offline/list/logic/tree/VideoFile$Companion;", "", "<init>", "()V", "TREE_START", "", "TREE_LAST_START", "TREE_END", "TREE_INTERVAL_VERTICAL", "fromFile", "Lvideo/biz/offline/list/logic/tree/VideoFile;", "file", "Ljava/io/File;", "fromPath", "context", "Landroid/content/Context;", "path", "parentPath", "childPath", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VideoFile fromFile(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new RawVideoFile(file, null);
        }

        public final VideoFile fromPath(Context context, String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return fromPath(context, path, null);
        }

        private final VideoFile fromPath(Context context, String parentPath, String childPath) {
            if (TextUtils.isEmpty(parentPath) || context == null) {
                return null;
            }
            String path = Uri.parse(parentPath).getPath();
            if (path == null) {
                path = "";
            }
            return new RawVideoFile(new File(path), childPath);
        }
    }
}