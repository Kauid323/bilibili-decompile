package tv.danmaku.gifplayer;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Resources.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/gifplayer/FileResources;", "Ltv/danmaku/gifplayer/Resources;", "mFile", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getPlayUrl", "", "type", "", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FileResources implements Resources {
    private final File mFile;

    public FileResources(File mFile) {
        Intrinsics.checkNotNullParameter(mFile, "mFile");
        this.mFile = mFile;
    }

    @Override // tv.danmaku.gifplayer.Resources
    public String getPlayUrl() {
        String absolutePath = this.mFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    @Override // tv.danmaku.gifplayer.Resources
    public int type() {
        return 1;
    }
}