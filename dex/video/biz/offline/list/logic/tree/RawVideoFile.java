package video.biz.offline.list.logic.tree;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.tree.VideoFile;

/* compiled from: RawVideoFile.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\f\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001e"}, d2 = {"Lvideo/biz/offline/list/logic/tree/RawVideoFile;", "Lvideo/biz/offline/list/logic/tree/VideoFile;", "file", "Ljava/io/File;", "childPath", "", "<init>", "(Ljava/io/File;Ljava/lang/String;)V", "mFile", "fileInputStream", "Ljava/io/FileInputStream;", "getFileInputStream", "()Ljava/io/FileInputStream;", "getFileOutputStream", "Ljava/io/FileOutputStream;", "append", "", "listFiles", "", "isDirectory", "()Z", "parentFile", "getParentFile", "()Lvideo/biz/offline/list/logic/tree/VideoFile;", "name", "getName", "()Ljava/lang/String;", "absolutePath", "getAbsolutePath", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RawVideoFile extends VideoFile {
    private static final String TAG = "RawVideoFile";
    private final File mFile;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public RawVideoFile(File file, String childPath) {
        File file2;
        Intrinsics.checkNotNullParameter(file, "file");
        if (TextUtils.isEmpty(childPath)) {
            file2 = file;
        } else {
            file2 = new File(file, childPath == null ? "" : childPath);
        }
        this.mFile = file2;
    }

    @Override // video.biz.offline.list.logic.tree.VideoFile
    public FileInputStream getFileInputStream() {
        return new FileInputStream(this.mFile);
    }

    @Override // video.biz.offline.list.logic.tree.VideoFile
    public FileOutputStream getFileOutputStream(boolean append) {
        return new FileOutputStream(this.mFile, append);
    }

    @Override // video.biz.offline.list.logic.tree.VideoFile
    public List<VideoFile> listFiles() {
        File[] files = this.mFile.listFiles();
        boolean z = true;
        if (files != null) {
            if (!(files.length == 0)) {
                z = false;
            }
        }
        if (z) {
            return null;
        }
        ArrayList results = new ArrayList();
        for (File file : files) {
            VideoFile.Companion companion = VideoFile.Companion;
            Intrinsics.checkNotNullExpressionValue(file, "get(...)");
            results.add(companion.fromFile(file));
        }
        return results;
    }

    @Override // video.biz.offline.list.logic.tree.VideoFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    @Override // video.biz.offline.list.logic.tree.VideoFile
    public VideoFile getParentFile() {
        File file = this.mFile.getParentFile();
        if (file == null) {
            return null;
        }
        return VideoFile.Companion.fromFile(file);
    }

    @Override // video.biz.offline.list.logic.tree.VideoFile
    public String getName() {
        return this.mFile.getName();
    }

    @Override // video.biz.offline.list.logic.tree.VideoFile
    public String getAbsolutePath() {
        String uri = Uri.fromFile(this.mFile).toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    /* compiled from: RawVideoFile.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lvideo/biz/offline/list/logic/tree/RawVideoFile$Companion;", "", "<init>", "()V", "TAG", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}