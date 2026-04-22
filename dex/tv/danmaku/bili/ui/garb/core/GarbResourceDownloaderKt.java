package tv.danmaku.bili.ui.garb.core;

import android.content.Context;
import com.bilibili.lib.okdownloader.BiliDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: GarbResourceDownloader.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000\u001a<\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "EVENT_ID", "download", "", "context", "Landroid/content/Context;", "url", "md5", FileChooserActivity.PATH, "fileName", "listener", "Ltv/danmaku/bili/ui/garb/core/GarbDownloadListener;", "downloadByBiliDownloader", "theme_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbResourceDownloaderKt {
    private static final String EVENT_ID = "main.garb-res.download.state";
    private static final String TAG = "GarbResDownloader";

    public static final void download(Context context, String url, String md5, String path, String fileName, GarbDownloadListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String str = url;
        if (str == null || str.length() == 0) {
            return;
        }
        downloadByBiliDownloader(context, url, md5, path, fileName, listener);
    }

    private static final void downloadByBiliDownloader(Context context, String url, String md5, String path, String fileName, GarbDownloadListener listener) {
        BiliDownloader.Companion.get(context).create(url, "garb").md5(md5).into(path).fileName(fileName).addListener(new GarbResourceDownloaderKt$downloadByBiliDownloader$1(listener)).build().enqueue();
    }
}