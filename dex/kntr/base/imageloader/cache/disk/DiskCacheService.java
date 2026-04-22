package kntr.base.imageloader.cache.disk;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageOptions;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.cache.CachePolicy;
import kntr.base.imageloader.cache.disk.DiskCache;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.CoreKt;
import kotlinx.io.RawSink;
import kotlinx.io.RawSource;
import kotlinx.io.Sink;
import kotlinx.io.SourcesKt;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* compiled from: DiskCacheService.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkntr/base/imageloader/cache/disk/DiskCacheService;", "", "diskCache", "Lkntr/base/imageloader/cache/disk/DiskCache;", "<init>", "(Lkntr/base/imageloader/cache/disk/DiskCache;)V", "shouldUseDiskCache", "", "request", "Lkntr/base/imageloader/ImmutableImageRequest;", "operation", "", "newCacheKey", "shouldCache", "url", "getDiskCacheData", "", "setDiskCacheData", "data", "clearDiskCache", "", "getDiskCacheSize", "", "getDiskCacheMaxSize", "shutdown", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DiskCacheService {
    public static final int $stable = 8;
    private final DiskCache diskCache;

    public DiskCacheService(DiskCache diskCache) {
        Intrinsics.checkNotNullParameter(diskCache, "diskCache");
        this.diskCache = diskCache;
    }

    private final boolean shouldUseDiskCache(ImmutableImageRequest request, String operation) {
        boolean policyEnabled;
        BiliImageOptions options = request.getOptions$imageloader_debug();
        if (Intrinsics.areEqual(operation, "read")) {
            policyEnabled = options.getDiskCachePolicy().getReadEnabled();
        } else if (Intrinsics.areEqual(operation, "write")) {
            policyEnabled = options.getDiskCachePolicy().getWriteEnabled();
        } else {
            policyEnabled = options.getDiskCachePolicy() != CachePolicy.DISABLED;
        }
        if (policyEnabled) {
            return shouldCache(request.takeImageUrl());
        }
        return false;
    }

    public final String newCacheKey(ImmutableImageRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!shouldUseDiskCache(request, "")) {
            return null;
        }
        return String.valueOf(request.takeImageUrl().hashCode());
    }

    private final boolean shouldCache(String url) {
        return StringsKt.startsWith(url, "http://", true) || StringsKt.startsWith(url, "https://", true);
    }

    public final byte[] getDiskCacheData(ImmutableImageRequest request) {
        String key;
        DiskCache.Snapshot snapshot;
        byte[] data;
        Intrinsics.checkNotNullParameter(request, "request");
        if (!shouldUseDiskCache(request, "read") || (key = newCacheKey(request)) == null || (snapshot = this.diskCache.openSnapshot(key)) == null) {
            return null;
        }
        try {
            DiskCache.Snapshot snapshot2 = snapshot;
            DiskCache.Snapshot snap = snapshot2;
            Path dataPath = snap.getData();
            if (FileSystemJvmKt.SystemFileSystem.exists(dataPath)) {
                RawSource rawSource = (AutoCloseable) FileSystemJvmKt.SystemFileSystem.source(dataPath);
                RawSource source = rawSource;
                byte[] readByteArray = SourcesKt.readByteArray(CoreKt.buffered(source));
                AutoCloseableKt.closeFinally(rawSource, (Throwable) null);
                data = readByteArray;
                KLog_androidKt.getKLog().i("DiskCacheService", "getDiskCacheData: key=" + key + " hit=true, size=" + data.length);
            } else {
                KLog_androidKt.getKLog().i("DiskCacheService", "getDiskCacheData: key=" + key + " hit=false, data file not exists");
                data = null;
            }
            AutoCloseableKt.closeFinally(snapshot2, (Throwable) null);
            return data;
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("DiskCacheService", "Failed to read disk cache: " + key, e);
            return null;
        }
    }

    public final boolean setDiskCacheData(ImmutableImageRequest request, byte[] data) {
        String key;
        Sink bufferedSink;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(data, "data");
        if (shouldUseDiskCache(request, "write") && (key = newCacheKey(request)) != null) {
            DiskCache.Editor openEditor = this.diskCache.openEditor(key);
            if (openEditor != null) {
                try {
                    RawSink rawSink = (AutoCloseable) FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, openEditor.getData(), false, 2, (Object) null);
                    RawSink sink = rawSink;
                    Sink sink2 = (AutoCloseable) CoreKt.buffered(sink);
                    try {
                        bufferedSink = sink2;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        Sink.-CC.write$default(bufferedSink, data, 0, 0, 6, (Object) null);
                        bufferedSink.flush();
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(sink2, (Throwable) null);
                        Unit unit2 = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(rawSink, (Throwable) null);
                        openEditor.commit();
                        KLog_androidKt.getKLog().i("DiskCacheService", "setDiskCacheData: key=" + key + ", size=" + data.length);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Exception e) {
                    KLog_androidKt.getKLog().e("DiskCacheService", "Failed to write disk cache: " + key, e);
                    openEditor.abort();
                    return false;
                }
            }
            KLog_androidKt.getKLog().w("DiskCacheService", "Failed to open editor for key: " + key);
            return false;
        }
        return false;
    }

    public final void clearDiskCache() {
        try {
            this.diskCache.clear();
            KLog_androidKt.getKLog().i("DiskCacheService", "Disk cache cleared");
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("DiskCacheService", "Failed to clear disk cache", e);
        }
    }

    public final long getDiskCacheSize() {
        return this.diskCache.getSize();
    }

    public final long getDiskCacheMaxSize() {
        return this.diskCache.getMaxByteSize();
    }

    public final void shutdown() {
        try {
            this.diskCache.shutdown();
        } catch (Exception e) {
            KLog_androidKt.getKLog().w("DiskCacheService", "Failed to shutdown disk cache: " + e.getMessage());
        }
    }
}