package kntr.base.imageloader.cache.disk;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.cache.disk.DiskCache;
import kntr.base.imageloader.cache.disk.DiskLruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.Path;

/* compiled from: RealDiskCache.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 !2\u00020\u0001:\u0003\u001f !B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000b¨\u0006\""}, d2 = {"Lkntr/base/imageloader/cache/disk/RealDiskCache;", "Lkntr/base/imageloader/cache/disk/DiskCache;", "maxByteSize", "", "directory", "Lkotlinx/io/files/Path;", "fileSystem", "Lkotlinx/io/files/FileSystem;", "<init>", "(JLkotlinx/io/files/Path;Lkotlinx/io/files/FileSystem;)V", "getMaxByteSize", "()J", "getDirectory", "()Lkotlinx/io/files/Path;", "getFileSystem", "()Lkotlinx/io/files/FileSystem;", "cache", "Lkntr/base/imageloader/cache/disk/DiskLruCache;", "size", "getSize", "openSnapshot", "Lkntr/base/imageloader/cache/disk/DiskCache$Snapshot;", "key", "", "openEditor", "Lkntr/base/imageloader/cache/disk/DiskCache$Editor;", "remove", "", "clear", "", "shutdown", "RealSnapshot", "RealEditor", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RealDiskCache implements DiskCache {
    private static final int ENTRY_DATA = 0;
    private final DiskLruCache cache;
    private final Path directory;
    private final FileSystem fileSystem;
    private final long maxByteSize;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public RealDiskCache(long maxByteSize, Path directory, FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.maxByteSize = maxByteSize;
        this.directory = directory;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(getFileSystem(), getDirectory(), getMaxByteSize(), 3, 1);
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public long getMaxByteSize() {
        return this.maxByteSize;
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public Path getDirectory() {
        return this.directory;
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public long getSize() {
        return this.cache.size();
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public DiskCache.Snapshot openSnapshot(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        DiskLruCache.Snapshot p0 = this.cache.get(key);
        return p0 != null ? new RealSnapshot(p0) : null;
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public DiskCache.Editor openEditor(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        DiskLruCache.Editor p0 = this.cache.edit(key);
        return p0 != null ? new RealEditor(p0) : null;
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public boolean remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cache.remove(key);
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public void clear() {
        this.cache.evictAll();
    }

    @Override // kntr.base.imageloader.cache.disk.DiskCache
    public void shutdown() {
        try {
            this.cache.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RealDiskCache.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkntr/base/imageloader/cache/disk/RealDiskCache$RealSnapshot;", "Lkntr/base/imageloader/cache/disk/DiskCache$Snapshot;", "snapshot", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Snapshot;", "Lkntr/base/imageloader/cache/disk/DiskLruCache;", "<init>", "(Lkntr/base/imageloader/cache/disk/DiskLruCache$Snapshot;)V", "data", "Lkotlinx/io/files/Path;", "getData", "()Lkotlinx/io/files/Path;", "close", "", "closeAndOpenEditor", "Lkntr/base/imageloader/cache/disk/RealDiskCache$RealEditor;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RealSnapshot implements DiskCache.Snapshot {
        private final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.snapshot = snapshot;
        }

        @Override // kntr.base.imageloader.cache.disk.DiskCache.Snapshot
        public Path getData() {
            return this.snapshot.file(0);
        }

        @Override // kntr.base.imageloader.cache.disk.DiskCache.Snapshot, java.lang.AutoCloseable
        public void close() {
            this.snapshot.close();
        }

        @Override // kntr.base.imageloader.cache.disk.DiskCache.Snapshot
        public RealEditor closeAndOpenEditor() {
            DiskLruCache.Editor p0 = this.snapshot.closeAndEdit();
            if (p0 != null) {
                return new RealEditor(p0);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RealDiskCache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lkntr/base/imageloader/cache/disk/RealDiskCache$RealEditor;", "Lkntr/base/imageloader/cache/disk/DiskCache$Editor;", "editor", "Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;", "Lkntr/base/imageloader/cache/disk/DiskLruCache;", "<init>", "(Lkntr/base/imageloader/cache/disk/DiskLruCache$Editor;)V", "data", "Lkotlinx/io/files/Path;", "getData", "()Lkotlinx/io/files/Path;", "commit", "", "commitAndOpenSnapshot", "Lkntr/base/imageloader/cache/disk/RealDiskCache$RealSnapshot;", "abort", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RealEditor implements DiskCache.Editor {
        private final DiskLruCache.Editor editor;

        public RealEditor(DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.editor = editor;
        }

        @Override // kntr.base.imageloader.cache.disk.DiskCache.Editor
        public Path getData() {
            return this.editor.file(0);
        }

        @Override // kntr.base.imageloader.cache.disk.DiskCache.Editor
        public void commit() {
            this.editor.commit();
        }

        @Override // kntr.base.imageloader.cache.disk.DiskCache.Editor
        public RealSnapshot commitAndOpenSnapshot() {
            DiskLruCache.Snapshot p0 = this.editor.commitAndGet();
            if (p0 != null) {
                return new RealSnapshot(p0);
            }
            return null;
        }

        @Override // kntr.base.imageloader.cache.disk.DiskCache.Editor
        public void abort() {
            this.editor.abort();
        }
    }

    /* compiled from: RealDiskCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/base/imageloader/cache/disk/RealDiskCache$Companion;", "", "<init>", "()V", "ENTRY_DATA", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}