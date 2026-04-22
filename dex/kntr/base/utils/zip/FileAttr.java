package kntr.base.utils.zip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lkntr/base/utils/zip/FileAttr;", "", "path", "Lkotlinx/io/files/Path;", "exists", "", "isDirectory", "<init>", "(Lkotlinx/io/files/Path;ZZ)V", "getPath", "()Lkotlinx/io/files/Path;", "getExists", "()Z", "fileName", "", "getFileName", "()Ljava/lang/String;", "parent", "children", "", "zip_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FileAttr {
    private final boolean exists;
    private final String fileName;
    private final boolean isDirectory;
    private final Path path;

    public FileAttr(Path path, boolean exists, boolean isDirectory) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.exists = exists;
        this.isDirectory = isDirectory;
        this.fileName = this.path.getName();
    }

    public /* synthetic */ FileAttr(Path path, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }

    public final Path getPath() {
        return this.path;
    }

    public final boolean getExists() {
        return this.exists;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final FileAttr parent() {
        Path it = this.path.getParent();
        if (it != null) {
            return UtilsKt.getFileAttr(FileSystemJvmKt.SystemFileSystem, it);
        }
        return null;
    }

    public final List<FileAttr> children() {
        if (!this.exists || !this.isDirectory) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = FileSystemJvmKt.SystemFileSystem.list(this.path);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Path it = (Path) item$iv$iv;
            destination$iv$iv.add(UtilsKt.getFileAttr(FileSystemJvmKt.SystemFileSystem, it));
        }
        return (List) destination$iv$iv;
    }
}