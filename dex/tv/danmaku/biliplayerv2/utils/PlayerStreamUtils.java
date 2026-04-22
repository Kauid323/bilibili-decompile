package tv.danmaku.biliplayerv2.utils;

import com.bilibili.commons.io.IOUtils;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import java.io.BufferedInputStream;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: PlayerStreamUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerStreamUtils;", "", "<init>", "()V", "requestUrl", "Lokhttp3/Response;", "url", "", "writeStream2File", "", "inputStream", "Ljava/io/BufferedInputStream;", "filePath", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerStreamUtils {
    public static final PlayerStreamUtils INSTANCE = new PlayerStreamUtils();

    private PlayerStreamUtils() {
    }

    public final Response requestUrl(String url) {
        if (url == null) {
            return null;
        }
        Request request = new Request.Builder().url(url).build();
        return OkHttpClientWrapper.get().newCall(request).execute();
    }

    public final void writeStream2File(BufferedInputStream inputStream, String filePath) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        byte[] bytes = new byte[IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID];
        RandomAccessFile out = new RandomAccessFile(filePath, "rwd");
        while (true) {
            try {
                int count = inputStream.read(bytes);
                if (count > 0) {
                    out.write(bytes, 0, count);
                } else {
                    return;
                }
            } finally {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(out);
            }
        }
    }
}