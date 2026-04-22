package tv.danmaku.android.log.adapters;

import java.io.File;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DiskController.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"deleteRecursively", "", "Ljava/io/File;", "excludes", "", "blog_android_release"}, k = 2, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DiskControllerKt {
    public static final /* synthetic */ void access$deleteRecursively(File $receiver, Collection excludes) {
        deleteRecursively($receiver, excludes);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
}