package io.ktor.client.plugins.cache.storage;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/io/File;", "directory", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "FileStorage", "(Ljava/io/File;Lkotlinx/coroutines/CoroutineDispatcher;)Lio/ktor/client/plugins/cache/storage/CacheStorage;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FileCacheStorageKt {
    public static /* synthetic */ CacheStorage FileStorage$default(File file, CoroutineDispatcher coroutineDispatcher, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return FileStorage(file, coroutineDispatcher);
    }

    public static final CacheStorage FileStorage(File directory, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return new CachingCacheStorage(new FileCacheStorage(directory, dispatcher));
    }
}