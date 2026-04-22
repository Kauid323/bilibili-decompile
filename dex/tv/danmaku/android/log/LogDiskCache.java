package tv.danmaku.android.log;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: LogDiskCache.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Ltv/danmaku/android/log/LogDiskCache;", "", "asSink", "Ljava/io/OutputStream;", "getAsSink", "()Ljava/io/OutputStream;", "deleteAll", "", "deleteExpiredFiles", "keep", "", "Ljava/io/File;", "logFilesOf", "", "date", "", "(Ljava/lang/Long;)[Ljava/io/File;", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public interface LogDiskCache {
    void deleteAll();

    void deleteExpiredFiles(List<? extends File> list);

    OutputStream getAsSink();

    File[] logFilesOf(Long l);
}