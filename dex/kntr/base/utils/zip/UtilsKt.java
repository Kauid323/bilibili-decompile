package kntr.base.utils.zip;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0000\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0000\u001a(\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0000¨\u0006\f"}, d2 = {"getFileAttr", "Lkntr/base/utils/zip/FileAttr;", "Lkotlinx/io/files/FileSystem;", "path", "", "Lkotlinx/io/files/Path;", "delete", "", "recursive", "", "force", "file", "zip_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilsKt {
    public static final FileAttr getFileAttr(FileSystem $this$getFileAttr, String path) {
        Intrinsics.checkNotNullParameter($this$getFileAttr, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return getFileAttr($this$getFileAttr, PathsJvmKt.Path(path));
    }

    public static final FileAttr getFileAttr(FileSystem $this$getFileAttr, Path path) {
        Intrinsics.checkNotNullParameter($this$getFileAttr, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata meta = $this$getFileAttr.metadataOrNull(path);
        boolean z = true;
        boolean z2 = meta != null;
        if (meta == null || !meta.isDirectory()) {
            z = false;
        }
        return new FileAttr(path, z2, z);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        delete(fileSystem, path, z, z2);
    }

    public static final void delete(FileSystem $this$delete, Path path, boolean recursive, boolean force) {
        Intrinsics.checkNotNullParameter($this$delete, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        delete($this$delete, getFileAttr($this$delete, path), recursive, force);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, FileAttr fileAttr, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        delete(fileSystem, fileAttr, z, z2);
    }

    public static final void delete(FileSystem $this$delete, FileAttr file, boolean recursive, boolean force) {
        Intrinsics.checkNotNullParameter($this$delete, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.getExists()) {
            if (recursive && file.isDirectory()) {
                Iterable $this$forEach$iv = file.children();
                for (Object element$iv : $this$forEach$iv) {
                    FileAttr it = (FileAttr) element$iv;
                    delete($this$delete, it, recursive, force);
                }
            }
            $this$delete.delete(file.getPath(), force);
        }
    }
}