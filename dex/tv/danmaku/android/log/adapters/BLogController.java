package tv.danmaku.android.log.adapters;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DiskController.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0005H&J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/android/log/adapters/BLogController;", "", "addExtraDir", "", "dir", "Ljava/io/File;", "cleanExpiredFiles", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "getCurLogDir", "queryLogFiles", "", "time", "", "(Ljava/lang/Long;)[Ljava/io/File;", "zippingLogFiles", "attaches", "", "(Ljava/lang/Long;Ljava/util/List;)Ljava/io/File;", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public interface BLogController {
    void addExtraDir(File file);

    void cleanExpiredFiles();

    void clear();

    File getCurLogDir();

    File[] queryLogFiles(Long l);

    File zippingLogFiles(Long l, List<File> list);

    /* compiled from: DiskController.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ File[] queryLogFiles$default(BLogController bLogController, Long l, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    l = null;
                }
                return bLogController.queryLogFiles(l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryLogFiles");
        }
    }
}