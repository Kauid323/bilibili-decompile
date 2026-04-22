package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.Path;

/* compiled from: FileIO.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"deleteRecursively", "", "Lkotlinx/io/files/FileSystem;", "path", "Lkotlinx/io/files/Path;", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FileIOKt {
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0.isDirectory() == true) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void deleteRecursively(FileSystem $this$deleteRecursively, Path path) {
        Intrinsics.checkNotNullParameter($this$deleteRecursively, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        if ($this$deleteRecursively.exists(path)) {
            FileMetadata metadataOrNull = $this$deleteRecursively.metadataOrNull(path);
            boolean z = metadataOrNull != null;
            if (z) {
                try {
                    Iterable $this$forEach$iv = $this$deleteRecursively.list(path);
                    for (Object element$iv : $this$forEach$iv) {
                        Path childPath = (Path) element$iv;
                        deleteRecursively($this$deleteRecursively, childPath);
                    }
                } catch (Exception e) {
                }
            }
            try {
                $this$deleteRecursively.delete(path, false);
            } catch (Exception e2) {
            }
        }
    }
}