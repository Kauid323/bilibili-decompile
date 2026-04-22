package kntr.base.imageloader.cache.disk;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* compiled from: DiskCache.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskCache;", "", "size", "", "getSize", "()J", "maxByteSize", "getMaxByteSize", "directory", "Lkotlinx/io/files/Path;", "getDirectory", "()Lkotlinx/io/files/Path;", "fileSystem", "Lkotlinx/io/files/FileSystem;", "getFileSystem", "()Lkotlinx/io/files/FileSystem;", "openSnapshot", "Lkntr/base/imageloader/cache/disk/DiskCache$Snapshot;", "key", "", "openEditor", "Lkntr/base/imageloader/cache/disk/DiskCache$Editor;", "remove", "", "clear", "", "shutdown", "Snapshot", "Editor", "Builder", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface DiskCache {

    /* compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskCache$Editor;", "", "data", "Lkotlinx/io/files/Path;", "getData", "()Lkotlinx/io/files/Path;", "commit", "", "commitAndOpenSnapshot", "Lkntr/base/imageloader/cache/disk/DiskCache$Snapshot;", "abort", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Editor {
        void abort();

        void commit();

        Snapshot commitAndOpenSnapshot();

        Path getData();
    }

    /* compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskCache$Snapshot;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "data", "Lkotlinx/io/files/Path;", "getData", "()Lkotlinx/io/files/Path;", "close", "", "closeAndOpenEditor", "Lkntr/base/imageloader/cache/disk/DiskCache$Editor;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Snapshot extends AutoCloseable {
        @Override // java.lang.AutoCloseable
        void close();

        Editor closeAndOpenEditor();

        Path getData();
    }

    void clear();

    Path getDirectory();

    FileSystem getFileSystem();

    long getMaxByteSize();

    long getSize();

    Editor openEditor(String str);

    Snapshot openSnapshot(String str);

    boolean remove(String str);

    void shutdown();

    /* compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0006\u0010\u0014\u001a\u00020\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskCache$Builder;", "", "<init>", "()V", "directory", "Lkotlinx/io/files/Path;", "fileSystem", "Lkotlinx/io/files/FileSystem;", "minimumMaxSizeBytes", "", "maximumMaxSizeBytes", "maxSizeBytes", "", "cleanupCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "size", "context", "cleanupDispatcher", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "build", "Lkntr/base/imageloader/cache/disk/DiskCache;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Builder {
        public static final int $stable = 8;
        private Path directory;
        private long maxSizeBytes;
        private FileSystem fileSystem = FileSystemJvmKt.SystemFileSystem;
        private int minimumMaxSizeBytes = 10485760;
        private int maximumMaxSizeBytes = 262144000;
        private CoroutineContext cleanupCoroutineContext = EmptyCoroutineContext.INSTANCE;

        public final Builder directory(Path directory) {
            Intrinsics.checkNotNullParameter(directory, "directory");
            Builder $this$directory_u24lambda_u240 = this;
            $this$directory_u24lambda_u240.directory = directory;
            return this;
        }

        public final Builder fileSystem(FileSystem fileSystem) {
            Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
            Builder $this$fileSystem_u24lambda_u240 = this;
            $this$fileSystem_u24lambda_u240.fileSystem = fileSystem;
            return this;
        }

        public final Builder minimumMaxSizeBytes(int size) {
            Builder $this$minimumMaxSizeBytes_u24lambda_u240 = this;
            if (size > 0) {
                $this$minimumMaxSizeBytes_u24lambda_u240.minimumMaxSizeBytes = size;
                return this;
            }
            throw new IllegalArgumentException("size must be > 0.".toString());
        }

        public final Builder maximumMaxSizeBytes(int size) {
            Builder $this$maximumMaxSizeBytes_u24lambda_u240 = this;
            if (size > 0) {
                $this$maximumMaxSizeBytes_u24lambda_u240.maximumMaxSizeBytes = size;
                return this;
            }
            throw new IllegalArgumentException("size must be > 0.".toString());
        }

        public final Builder maxSizeBytes(long size) {
            Builder $this$maxSizeBytes_u24lambda_u240 = this;
            if (size > 0) {
                $this$maxSizeBytes_u24lambda_u240.maxSizeBytes = size;
                return this;
            }
            throw new IllegalArgumentException("size must be > 0.".toString());
        }

        public final Builder cleanupCoroutineContext(CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Builder $this$cleanupCoroutineContext_u24lambda_u240 = this;
            $this$cleanupCoroutineContext_u24lambda_u240.cleanupCoroutineContext = context;
            return this;
        }

        @Deprecated(message = "Replaced by cleanupCoroutineContext.", replaceWith = @ReplaceWith(expression = "cleanupCoroutineContext(dispatcher)", imports = {}))
        public final Builder cleanupDispatcher(CoroutineDispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            return cleanupCoroutineContext((CoroutineContext) dispatcher);
        }

        public final DiskCache build() {
            Path directory = this.directory;
            if (directory != null) {
                return new RealDiskCache(this.maxSizeBytes, directory, this.fileSystem);
            }
            throw new IllegalStateException("directory == null".toString());
        }
    }
}