package kntr.base.dd.impl.internal.file;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.CoreKt;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.Path;

/* compiled from: DDFileSystem.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\n"}, d2 = {"deletePath", "", "Lkotlinx/io/files/FileSystem;", "path", "Lkotlinx/io/files/Path;", "mustExist", "", "deleteRecursivelySafe", "readString", "", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDFileSystemKt {
    public static /* synthetic */ void deletePath$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        deletePath(fileSystem, path, z);
    }

    public static final void deletePath(FileSystem $this$deletePath, Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter($this$deletePath, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        $this$deletePath.delete(path, mustExist);
    }

    public static final boolean deleteRecursivelySafe(FileSystem $this$deleteRecursivelySafe, Path path) {
        Intrinsics.checkNotNullParameter($this$deleteRecursivelySafe, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            FileMetadata meta = $this$deleteRecursivelySafe.metadataOrNull(path);
            if (meta == null) {
                return false;
            }
            if (meta.isDirectory()) {
                Iterable $this$forEach$iv = $this$deleteRecursivelySafe.list(path);
                for (Object element$iv : $this$forEach$iv) {
                    Path it = (Path) element$iv;
                    deleteRecursivelySafe($this$deleteRecursivelySafe, it);
                }
            }
            deletePath($this$deleteRecursivelySafe, path, false);
            return true;
        } catch (Exception e) {
            DDConst.logE$default(DDConst.INSTANCE, "deleteRecursivelySafe(" + path + ") has exception " + e + ".", null, 2, null);
            return false;
        }
    }

    public static final String readString(FileSystem $this$readString, Path path) {
        Intrinsics.checkNotNullParameter($this$readString, "<this>");
        String str = null;
        if (path == null) {
            return null;
        }
        Source source = CoreKt.buffered($this$readString.source(path));
        try {
            try {
                str = Utf8Kt.readString(source);
            } catch (Exception e) {
                DDConst.logE$default(DDConst.INSTANCE, "readString(" + path + ") has exception " + e + ".", null, 2, null);
            }
            return str;
        } finally {
            source.close();
        }
    }
}