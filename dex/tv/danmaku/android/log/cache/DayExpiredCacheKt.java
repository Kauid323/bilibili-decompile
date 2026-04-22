package tv.danmaku.android.log.cache;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.internal.UtilKt;
import tv.danmaku.bili.BR;

/* compiled from: DayExpiredCache.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0004H\u0002\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\r\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TAG", "", "deleteRecursively", "", "Ljava/io/File;", "excludes", "", "isBlog", "", "makeBlogFile", "context", "Landroid/content/Context;", "date", "makeCacheFile", "makePreBlogFile", "blog_android_release"}, k = 2, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DayExpiredCacheKt {
    public static final String TAG = "DayExpiredCache";

    public static final File makeCacheFile(File $this$makeCacheFile, Context context) {
        Intrinsics.checkNotNullParameter($this$makeCacheFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new File($this$makeCacheFile, UtilKt.getBlogProcess(context) + ".cache");
    }

    public static final File makeBlogFile(File $this$makeBlogFile, Context context, String date) {
        Intrinsics.checkNotNullParameter($this$makeBlogFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(date, "date");
        return new File($this$makeBlogFile, date + '-' + UtilKt.getBlogProcess(context) + DayExpiredCache.EXT);
    }

    public static final File makePreBlogFile(File $this$makePreBlogFile, Context context, String date) {
        Intrinsics.checkNotNullParameter($this$makePreBlogFile, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(date, "date");
        return new File($this$makePreBlogFile, date + '-' + UtilKt.getBlogProcess(context) + "-pre.blog");
    }

    public static final void deleteRecursively(File $this$deleteRecursively, Collection<? extends File> collection) {
        if (!collection.contains($this$deleteRecursively)) {
            if ($this$deleteRecursively.isDirectory()) {
                File[] listFiles = $this$deleteRecursively.listFiles();
                if (listFiles == null) {
                    return;
                }
                for (File file : listFiles) {
                    Intrinsics.checkNotNull(file);
                    deleteRecursively(file, collection);
                }
                return;
            }
            $this$deleteRecursively.delete();
        }
    }

    public static final boolean isBlog(File $this$isBlog) {
        if ($this$isBlog.isFile()) {
            String name = $this$isBlog.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return StringsKt.endsWith$default(name, DayExpiredCache.EXT, false, 2, (Object) null);
        }
        return false;
    }
}