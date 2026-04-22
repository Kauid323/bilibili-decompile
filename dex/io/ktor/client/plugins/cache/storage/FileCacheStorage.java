package io.ktor.client.plugins.cache.storage;

import faceverify.q;
import im.setting.UtilsKt;
import io.grpc.internal.GrpcUtil;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001aH\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0019\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u001f\u0010 J \u0010\u001d\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u001d\u0010$J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\"\u001a\u00020%H\u0082@¢\u0006\u0004\b\u001f\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lio/ktor/client/plugins/cache/storage/FileCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Ljava/io/File;", "directory", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Ljava/io/File;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", UtilsKt.DATA_KEY, "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", q.KEY_RES_9_KEY, "(Lio/ktor/http/Url;)Ljava/lang/String;", "urlHex", "", "caches", "", "writeCache", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readCache", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteChannel;", "channel", "cache", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/ktor/util/collections/ConcurrentMap;", "Lkotlinx/coroutines/sync/Mutex;", "mutexes", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileCacheStorage implements CacheStorage {
    private final File directory;
    private final CoroutineDispatcher dispatcher;
    private final ConcurrentMap<String, Mutex> mutexes;

    public FileCacheStorage(File directory, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.directory = directory;
        this.dispatcher = dispatcher;
        this.mutexes = new ConcurrentMap<>(0, 1, (DefaultConstructorMarker) null);
        this.directory.mkdirs();
    }

    public /* synthetic */ FileCacheStorage(File file, CoroutineDispatcher coroutineDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData data, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new FileCacheStorage$store$2(this, url, data, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        FileCacheStorage$findAll$1 fileCacheStorage$findAll$1;
        Object readCache;
        if (continuation instanceof FileCacheStorage$findAll$1) {
            fileCacheStorage$findAll$1 = (FileCacheStorage$findAll$1) continuation;
            if ((fileCacheStorage$findAll$1.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$findAll$1.label -= Integer.MIN_VALUE;
                Object $result = fileCacheStorage$findAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fileCacheStorage$findAll$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String key = key(url);
                        fileCacheStorage$findAll$1.label = 1;
                        readCache = readCache(key, (Continuation<? super Set<CachedResponseData>>) fileCacheStorage$findAll$1);
                        if (readCache == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        readCache = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return CollectionsKt.toSet((Iterable) readCache);
            }
        }
        fileCacheStorage$findAll$1 = new FileCacheStorage$findAll$1(this, continuation);
        Object $result2 = fileCacheStorage$findAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fileCacheStorage$findAll$1.label) {
        }
        return CollectionsKt.toSet((Iterable) readCache);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        FileCacheStorage$find$1 fileCacheStorage$find$1;
        Object readCache;
        Map varyKeys;
        if (continuation instanceof FileCacheStorage$find$1) {
            fileCacheStorage$find$1 = (FileCacheStorage$find$1) continuation;
            if ((fileCacheStorage$find$1.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$find$1.label -= Integer.MIN_VALUE;
                Object $result = fileCacheStorage$find$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (fileCacheStorage$find$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String key = key(url);
                        fileCacheStorage$find$1.L$0 = map;
                        fileCacheStorage$find$1.label = 1;
                        readCache = readCache(key, (Continuation<? super Set<CachedResponseData>>) fileCacheStorage$find$1);
                        if (readCache == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        varyKeys = map;
                        break;
                    case 1:
                        varyKeys = (Map) fileCacheStorage$find$1.L$0;
                        ResultKt.throwOnFailure($result);
                        readCache = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Set data = (Set) readCache;
                for (Object obj : data) {
                    CachedResponseData it = (CachedResponseData) obj;
                    Map $this$all$iv = varyKeys;
                    if (!$this$all$iv.isEmpty()) {
                        Iterator<Map.Entry<String, String>> it2 = $this$all$iv.entrySet().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                Map.Entry element$iv = it2.next();
                                String key2 = element$iv.getKey();
                                String value = element$iv.getValue();
                                if (!Intrinsics.areEqual(it.getVaryKeys().get(key2), value)) {
                                    z = false;
                                }
                            } else {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        return obj;
                    }
                    z = true;
                }
                return null;
            }
        }
        fileCacheStorage$find$1 = new FileCacheStorage$find$1(this, continuation);
        Object $result2 = fileCacheStorage$find$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (fileCacheStorage$find$1.label) {
        }
        Set data2 = (Set) readCache;
        while (r5.hasNext()) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String key(Url url) {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(StringsKt.encodeToByteArray(url.toString()));
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return CryptoKt.hex(digest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeCache(String urlHex, List<CachedResponseData> list, Continuation<Object> continuation) {
        return CoroutineScopeKt.coroutineScope(new FileCacheStorage$writeCache$2(this, urlHex, list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0208  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01c6 -> B:144:0x01d7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readCache(String str, Continuation<? super Set<CachedResponseData>> continuation) {
        Continuation<? super CachedResponseData> fileCacheStorage$readCache$1;
        Continuation<? super CachedResponseData> continuation2;
        String urlHex;
        Mutex $this$withLock_u24default$iv;
        Mutex owner$iv;
        FileCacheStorage fileCacheStorage;
        boolean z;
        File file;
        BufferedInputStream bufferedInputStream;
        Closeable $this$use$iv;
        boolean z2;
        ByteReadChannel channel;
        Object readInt;
        FileCacheStorage fileCacheStorage2;
        Closeable $this$use$iv2;
        int i2;
        ByteReadChannel channel2;
        boolean z3;
        Object $this$withLock_u24default$iv2;
        Mutex $this$withLock_u24default$iv3;
        boolean z4;
        boolean z5;
        boolean z6;
        Continuation<? super Set<CachedResponseData>> continuation3;
        boolean z7;
        int requestsCount;
        Mutex $this$withLock_u24default$iv4;
        boolean z8;
        Closeable $this$use$iv3;
        boolean z9;
        Set caches;
        boolean z10;
        int $i$f$use;
        Object $result;
        int i3;
        Mutex mutex;
        Continuation<? super CachedResponseData> continuation4;
        boolean z11;
        Mutex mutex2;
        boolean z12;
        FileCacheStorage fileCacheStorage3;
        int $i$f$withLock;
        boolean closed$iv;
        int i4;
        Continuation<? super Set<CachedResponseData>> continuation5;
        Object obj;
        Set set;
        boolean z13;
        Set set2;
        Mutex mutex3;
        if (continuation instanceof FileCacheStorage$readCache$1) {
            fileCacheStorage$readCache$1 = (FileCacheStorage$readCache$1) continuation;
            if ((fileCacheStorage$readCache$1.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$readCache$1.label -= Integer.MIN_VALUE;
                continuation2 = fileCacheStorage$readCache$1;
                Object $result2 = continuation2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                Mutex owner$iv2 = null;
                switch (continuation2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        urlHex = str;
                        $this$withLock_u24default$iv = (Mutex) this.mutexes.computeIfAbsent(urlHex, new Function0() { // from class: io.ktor.client.plugins.cache.storage.FileCacheStorage$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Mutex readCache$lambda$2;
                                readCache$lambda$2 = FileCacheStorage.readCache$lambda$2();
                                return readCache$lambda$2;
                            }
                        });
                        owner$iv = null;
                        continuation2.L$0 = this;
                        continuation2.L$1 = urlHex;
                        continuation2.L$2 = $this$withLock_u24default$iv;
                        continuation2.label = 1;
                        if ($this$withLock_u24default$iv.lock((Object) null, continuation2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fileCacheStorage = this;
                        z = false;
                        try {
                            file = new File(fileCacheStorage.directory, urlHex);
                            if (file.exists()) {
                                try {
                                    Set emptySet = SetsKt.emptySet();
                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                    return emptySet;
                                } catch (Throwable th) {
                                    th = th;
                                    owner$iv2 = owner$iv;
                                }
                            } else {
                                Mutex $this$withLock_u24default$iv5 = $this$withLock_u24default$iv;
                                Mutex owner$iv3 = owner$iv;
                                try {
                                    try {
                                        FileInputStream fileInputStream = new FileInputStream(file);
                                        if (fileInputStream instanceof BufferedInputStream) {
                                            try {
                                                bufferedInputStream = (BufferedInputStream) fileInputStream;
                                            } catch (Exception e2) {
                                                cause = e2;
                                                try {
                                                    HttpCacheKt.getLOGGER().trace("Exception during cache lookup in a file: " + ExceptionsKt.stackTraceToString(cause));
                                                    Set emptySet2 = SetsKt.emptySet();
                                                    $this$withLock_u24default$iv5.unlock(owner$iv3);
                                                    return emptySet2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    owner$iv2 = owner$iv3;
                                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv5;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                owner$iv2 = owner$iv3;
                                                $this$withLock_u24default$iv = $this$withLock_u24default$iv5;
                                            }
                                        } else {
                                            bufferedInputStream = new BufferedInputStream(fileInputStream, GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE);
                                        }
                                        try {
                                            $this$use$iv = bufferedInputStream;
                                            try {
                                                BufferedInputStream it = (BufferedInputStream) $this$use$iv;
                                                z2 = z;
                                                try {
                                                    channel = ReadingKt.toByteReadChannelWithArrayPool$default(it, (CoroutineContext) null, (ObjectPool) null, 3, (Object) null);
                                                    continuation2.L$0 = fileCacheStorage;
                                                    continuation2.L$1 = $this$withLock_u24default$iv5;
                                                    continuation2.L$2 = $this$use$iv;
                                                    continuation2.L$3 = channel;
                                                    continuation2.I$0 = 0;
                                                    continuation2.label = 2;
                                                    readInt = ByteReadChannelOperationsKt.readInt(channel, continuation2);
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                            }
                                            if (readInt == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            fileCacheStorage2 = fileCacheStorage;
                                            $this$use$iv2 = $this$use$iv;
                                            i2 = 0;
                                            channel2 = channel;
                                            z3 = false;
                                            $this$withLock_u24default$iv2 = $this$withLock_u24default$iv5;
                                            $this$withLock_u24default$iv3 = owner$iv3;
                                            z4 = false;
                                            z5 = false;
                                            z6 = z2;
                                            try {
                                                int requestsCount2 = ((Number) readInt).intValue();
                                                Set caches2 = new LinkedHashSet();
                                                continuation3 = continuation;
                                                z7 = z3;
                                                requestsCount = requestsCount2;
                                                $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                                                z8 = z4;
                                                $this$use$iv3 = $this$use$iv2;
                                                z9 = z6;
                                                caches = caches2;
                                                z10 = z5;
                                                $i$f$use = i2;
                                                $result = $result2;
                                                i3 = 0;
                                                mutex = $this$withLock_u24default$iv3;
                                                continuation4 = continuation2;
                                                if (i3 >= requestsCount) {
                                                    try {
                                                        continuation4.L$0 = fileCacheStorage2;
                                                        continuation4.L$1 = $this$withLock_u24default$iv4;
                                                        continuation4.L$2 = $this$use$iv3;
                                                        continuation4.L$3 = channel2;
                                                        continuation4.L$4 = caches;
                                                        continuation4.L$5 = caches;
                                                        continuation4.I$0 = $i$f$use;
                                                        continuation4.I$1 = requestsCount;
                                                        continuation4.I$2 = i3;
                                                        int requestsCount3 = requestsCount;
                                                        continuation4.label = 3;
                                                        Object readCache = fileCacheStorage2.readCache(channel2, continuation4);
                                                        if (readCache == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        z11 = z10;
                                                        mutex2 = mutex;
                                                        z12 = z9;
                                                        fileCacheStorage3 = fileCacheStorage2;
                                                        $i$f$withLock = requestsCount3;
                                                        closed$iv = z8;
                                                        i4 = i3;
                                                        $result2 = readCache;
                                                        continuation5 = continuation3;
                                                        obj = coroutine_suspended;
                                                        set = caches;
                                                        try {
                                                            set.add($result2);
                                                            i3 = i4 + 1;
                                                            coroutine_suspended = obj;
                                                            continuation3 = continuation5;
                                                            requestsCount = $i$f$withLock;
                                                            z8 = closed$iv;
                                                            z9 = z12;
                                                            fileCacheStorage2 = fileCacheStorage3;
                                                            z10 = z11;
                                                            mutex = mutex2;
                                                            if (i3 >= requestsCount) {
                                                                try {
                                                                    continuation4.L$0 = $this$withLock_u24default$iv4;
                                                                    continuation4.L$1 = $this$use$iv3;
                                                                    continuation4.L$2 = caches;
                                                                    continuation4.L$3 = null;
                                                                    continuation4.L$4 = null;
                                                                    continuation4.L$5 = null;
                                                                    continuation4.I$0 = $i$f$use;
                                                                    continuation4.label = 4;
                                                                    Closeable $this$use$iv4 = $this$use$iv3;
                                                                    Mutex $this$withLock_u24default$iv6 = $this$withLock_u24default$iv4;
                                                                    Set caches3 = caches;
                                                                    try {
                                                                        if (ByteReadChannelOperationsKt.discard$default(channel2, 0L, continuation4, 1, (Object) null) == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                        z13 = z8;
                                                                        set2 = caches3;
                                                                        mutex3 = $this$withLock_u24default$iv6;
                                                                        owner$iv2 = mutex;
                                                                        $this$use$iv = $this$use$iv4;
                                                                        if ($this$use$iv != null) {
                                                                            try {
                                                                                $this$use$iv.close();
                                                                            } catch (Exception e3) {
                                                                                cause = e3;
                                                                                $this$withLock_u24default$iv5 = mutex3;
                                                                                owner$iv3 = owner$iv2;
                                                                                HttpCacheKt.getLOGGER().trace("Exception during cache lookup in a file: " + ExceptionsKt.stackTraceToString(cause));
                                                                                Set emptySet22 = SetsKt.emptySet();
                                                                                $this$withLock_u24default$iv5.unlock(owner$iv3);
                                                                                return emptySet22;
                                                                            } catch (Throwable th6) {
                                                                                th = th6;
                                                                                $this$withLock_u24default$iv = mutex3;
                                                                            }
                                                                        }
                                                                        mutex3.unlock(owner$iv2);
                                                                        return set2;
                                                                    } catch (Throwable th7) {
                                                                        th = th7;
                                                                        $this$use$iv = $this$use$iv4;
                                                                    }
                                                                } catch (Throwable th8) {
                                                                    th = th8;
                                                                    $this$use$iv = $this$use$iv3;
                                                                }
                                                            }
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            $this$use$iv = $this$use$iv3;
                                                        }
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        $this$use$iv = $this$use$iv3;
                                                    }
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                $this$use$iv = $this$use$iv2;
                                            }
                                            Throwable cause$iv = th;
                                            if ($this$use$iv != null) {
                                                try {
                                                    $this$use$iv.close();
                                                }
                                            }
                                            throw cause$iv;
                                        } catch (Throwable th12) {
                                            th = th12;
                                            owner$iv2 = owner$iv3;
                                            $this$withLock_u24default$iv = $this$withLock_u24default$iv5;
                                        }
                                    } catch (Exception e4) {
                                        cause = e4;
                                    }
                                } catch (Throwable th13) {
                                    th = th13;
                                    owner$iv2 = owner$iv3;
                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv5;
                                }
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            owner$iv2 = owner$iv;
                        }
                        $this$withLock_u24default$iv.unlock(owner$iv2);
                        throw th;
                    case 1:
                        z = false;
                        $this$withLock_u24default$iv = (Mutex) continuation2.L$2;
                        urlHex = (String) continuation2.L$1;
                        ResultKt.throwOnFailure($result2);
                        fileCacheStorage = (FileCacheStorage) continuation2.L$0;
                        owner$iv = null;
                        file = new File(fileCacheStorage.directory, urlHex);
                        if (file.exists()) {
                        }
                        $this$withLock_u24default$iv.unlock(owner$iv2);
                        throw th;
                    case 2:
                        z4 = false;
                        z3 = false;
                        int i5 = continuation2.I$0;
                        ByteReadChannel channel3 = (ByteReadChannel) continuation2.L$3;
                        $this$use$iv = (Closeable) continuation2.L$2;
                        $this$withLock_u24default$iv3 = null;
                        $this$withLock_u24default$iv2 = (Mutex) continuation2.L$1;
                        FileCacheStorage fileCacheStorage4 = (FileCacheStorage) continuation2.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            fileCacheStorage2 = fileCacheStorage4;
                            $this$use$iv2 = $this$use$iv;
                            i2 = i5;
                            channel2 = channel3;
                            z5 = false;
                            z6 = false;
                            readInt = $result2;
                            int requestsCount22 = ((Number) readInt).intValue();
                            Set caches22 = new LinkedHashSet();
                            continuation3 = continuation;
                            z7 = z3;
                            requestsCount = requestsCount22;
                            $this$withLock_u24default$iv4 = $this$withLock_u24default$iv2;
                            z8 = z4;
                            $this$use$iv3 = $this$use$iv2;
                            z9 = z6;
                            caches = caches22;
                            z10 = z5;
                            $i$f$use = i2;
                            $result = $result2;
                            i3 = 0;
                            mutex = $this$withLock_u24default$iv3;
                            continuation4 = continuation2;
                            if (i3 >= requestsCount) {
                            }
                        } catch (Throwable th15) {
                            th = th15;
                        }
                        Throwable cause$iv2 = th;
                        if ($this$use$iv != null) {
                        }
                        throw cause$iv2;
                    case 3:
                        i4 = continuation2.I$2;
                        $i$f$withLock = continuation2.I$1;
                        int i6 = continuation2.I$0;
                        Set set3 = (Set) continuation2.L$5;
                        Set caches4 = (Set) continuation2.L$4;
                        ByteReadChannel channel4 = (ByteReadChannel) continuation2.L$3;
                        Closeable $this$use$iv5 = (Closeable) continuation2.L$2;
                        Mutex $this$withLock_u24default$iv7 = (Mutex) continuation2.L$1;
                        FileCacheStorage fileCacheStorage5 = (FileCacheStorage) continuation2.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            z11 = false;
                            mutex2 = null;
                            fileCacheStorage3 = fileCacheStorage5;
                            continuation4 = continuation2;
                            z7 = false;
                            continuation5 = continuation;
                            $result = $result2;
                            $this$withLock_u24default$iv4 = $this$withLock_u24default$iv7;
                            obj = coroutine_suspended;
                            set = set3;
                            z12 = false;
                            channel2 = channel4;
                            $i$f$use = i6;
                            closed$iv = false;
                            $this$use$iv3 = $this$use$iv5;
                            caches = caches4;
                            set.add($result2);
                            i3 = i4 + 1;
                            coroutine_suspended = obj;
                            continuation3 = continuation5;
                            requestsCount = $i$f$withLock;
                            z8 = closed$iv;
                            z9 = z12;
                            fileCacheStorage2 = fileCacheStorage3;
                            z10 = z11;
                            mutex = mutex2;
                            if (i3 >= requestsCount) {
                            }
                        } catch (Throwable th16) {
                            th = th16;
                            $this$use$iv = $this$use$iv5;
                        }
                        Throwable cause$iv22 = th;
                        if ($this$use$iv != null) {
                        }
                        throw cause$iv22;
                    case 4:
                        z13 = false;
                        int i7 = continuation2.I$0;
                        set2 = (Set) continuation2.L$2;
                        $this$use$iv = (Closeable) continuation2.L$1;
                        mutex3 = (Mutex) continuation2.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            if ($this$use$iv != null) {
                            }
                            mutex3.unlock(owner$iv2);
                            return set2;
                        } catch (Throwable th17) {
                            th = th17;
                            break;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileCacheStorage$readCache$1 = new FileCacheStorage$readCache$1(this, continuation);
        continuation2 = fileCacheStorage$readCache$1;
        Object $result22 = continuation2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Mutex owner$iv22 = null;
        switch (continuation2.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex readCache$lambda$2() {
        return MutexKt.Mutex$default(false, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0157 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0181 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0236 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0273 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x028b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x031c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0355 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0237 -> B:44:0x01cf). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x031d -> B:69:0x02b2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeCache(ByteChannel byteChannel, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) {
        FileCacheStorage$writeCache$3 fileCacheStorage$writeCache$3;
        CachedResponseData cache;
        ByteChannel channel;
        int value;
        String str;
        String sb;
        ByteChannel channel2;
        CachedResponseData cache2;
        List headers;
        int size;
        Iterator it;
        String value2;
        Iterator it2;
        CachedResponseData cache3;
        ByteWriteChannel channel3;
        String str2;
        CachedResponseData cache4;
        ByteChannel channel4;
        long timestamp;
        long timestamp2;
        int size2;
        Iterator<Map.Entry<String, String>> it3;
        String value3;
        Iterator<Map.Entry<String, String>> it4;
        CachedResponseData cache5;
        ByteWriteChannel channel5;
        String str3;
        ByteChannel channel6;
        byte[] body;
        if (continuation instanceof FileCacheStorage$writeCache$3) {
            fileCacheStorage$writeCache$3 = (FileCacheStorage$writeCache$3) continuation;
            if ((fileCacheStorage$writeCache$3.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$writeCache$3.label -= Integer.MIN_VALUE;
                Object $result = fileCacheStorage$writeCache$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fileCacheStorage$writeCache$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        cache = cachedResponseData;
                        channel = byteChannel;
                        String sb2 = new StringBuilder().append(cache.getUrl()).append('\n').toString();
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 1;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, sb2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        value = cache.getStatusCode().getValue();
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 2;
                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel, value, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = cache.getStatusCode().getDescription() + '\n';
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 3;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, str, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sb = new StringBuilder().append(cache.getVersion()).append('\n').toString();
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 4;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, sb, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channel2 = channel;
                        cache2 = cache;
                        headers = StringValuesKt.flattenEntries(cache2.getHeaders());
                        size = headers.size();
                        fileCacheStorage$writeCache$3.L$0 = channel2;
                        fileCacheStorage$writeCache$3.L$1 = cache2;
                        fileCacheStorage$writeCache$3.L$2 = headers;
                        fileCacheStorage$writeCache$3.label = 5;
                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel2, size, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = headers.iterator();
                        if (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            String key = (String) pair.component1();
                            value2 = (String) pair.component2();
                            String str4 = key + '\n';
                            fileCacheStorage$writeCache$3.L$0 = channel2;
                            fileCacheStorage$writeCache$3.L$1 = cache2;
                            fileCacheStorage$writeCache$3.L$2 = it;
                            fileCacheStorage$writeCache$3.L$3 = value2;
                            fileCacheStorage$writeCache$3.label = 6;
                            if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel2, str4, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ByteChannel byteChannel2 = channel2;
                            cache3 = cache2;
                            it2 = it;
                            channel3 = byteChannel2;
                            str2 = value2 + '\n';
                            fileCacheStorage$writeCache$3.L$0 = channel3;
                            fileCacheStorage$writeCache$3.L$1 = cache3;
                            fileCacheStorage$writeCache$3.L$2 = it2;
                            fileCacheStorage$writeCache$3.L$3 = null;
                            fileCacheStorage$writeCache$3.label = 7;
                            if (ByteWriteChannelOperationsKt.writeStringUtf8(channel3, str2, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ByteChannel byteChannel3 = channel3;
                            it = it2;
                            cache2 = cache3;
                            channel2 = byteChannel3;
                            if (it.hasNext()) {
                                long timestamp3 = cache2.getRequestTime().getTimestamp();
                                fileCacheStorage$writeCache$3.L$0 = channel2;
                                fileCacheStorage$writeCache$3.L$1 = cache2;
                                fileCacheStorage$writeCache$3.L$2 = null;
                                fileCacheStorage$writeCache$3.label = 8;
                                if (ByteWriteChannelOperationsKt.writeLong((ByteWriteChannel) channel2, timestamp3, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                cache4 = cache2;
                                channel4 = channel2;
                                timestamp = cache4.getResponseTime().getTimestamp();
                                fileCacheStorage$writeCache$3.L$0 = channel4;
                                fileCacheStorage$writeCache$3.L$1 = cache4;
                                fileCacheStorage$writeCache$3.label = 9;
                                if (ByteWriteChannelOperationsKt.writeLong((ByteWriteChannel) channel4, timestamp, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                timestamp2 = cache4.getExpires().getTimestamp();
                                fileCacheStorage$writeCache$3.L$0 = channel4;
                                fileCacheStorage$writeCache$3.L$1 = cache4;
                                fileCacheStorage$writeCache$3.label = 10;
                                if (ByteWriteChannelOperationsKt.writeLong((ByteWriteChannel) channel4, timestamp2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                size2 = cache4.getVaryKeys().size();
                                fileCacheStorage$writeCache$3.L$0 = channel4;
                                fileCacheStorage$writeCache$3.L$1 = cache4;
                                fileCacheStorage$writeCache$3.label = 11;
                                if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel4, size2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                it3 = cache4.getVaryKeys().entrySet().iterator();
                                if (it3.hasNext()) {
                                    Map.Entry<String, String> next = it3.next();
                                    String key2 = next.getKey();
                                    String value4 = next.getValue();
                                    String str5 = key2 + '\n';
                                    fileCacheStorage$writeCache$3.L$0 = channel4;
                                    fileCacheStorage$writeCache$3.L$1 = cache4;
                                    fileCacheStorage$writeCache$3.L$2 = it3;
                                    fileCacheStorage$writeCache$3.L$3 = value4;
                                    fileCacheStorage$writeCache$3.label = 12;
                                    if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel4, str5, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    Iterator<Map.Entry<String, String>> it5 = it3;
                                    cache5 = cache4;
                                    value3 = value4;
                                    channel5 = channel4;
                                    it4 = it5;
                                    str3 = value3 + '\n';
                                    fileCacheStorage$writeCache$3.L$0 = channel5;
                                    fileCacheStorage$writeCache$3.L$1 = cache5;
                                    fileCacheStorage$writeCache$3.L$2 = it4;
                                    fileCacheStorage$writeCache$3.L$3 = null;
                                    fileCacheStorage$writeCache$3.label = 13;
                                    if (ByteWriteChannelOperationsKt.writeStringUtf8(channel5, str3, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    cache4 = cache5;
                                    it3 = it4;
                                    channel4 = channel5;
                                    if (it3.hasNext()) {
                                        int length = cache4.getBody().length;
                                        fileCacheStorage$writeCache$3.L$0 = channel4;
                                        fileCacheStorage$writeCache$3.L$1 = cache4;
                                        fileCacheStorage$writeCache$3.L$2 = null;
                                        fileCacheStorage$writeCache$3.label = 14;
                                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel4, length, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        channel6 = channel4;
                                        body = cache4.getBody();
                                        fileCacheStorage$writeCache$3.L$0 = null;
                                        fileCacheStorage$writeCache$3.L$1 = null;
                                        fileCacheStorage$writeCache$3.label = 15;
                                        if (ByteWriteChannelOperationsKt.writeFully$default((ByteWriteChannel) channel6, body, 0, 0, fileCacheStorage$writeCache$3, 6, (Object) null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                    case 1:
                        cache = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        value = cache.getStatusCode().getValue();
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 2;
                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel, value, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        str = cache.getStatusCode().getDescription() + '\n';
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 3;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, str, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        sb = new StringBuilder().append(cache.getVersion()).append('\n').toString();
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 4;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, sb, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        cache = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        str = cache.getStatusCode().getDescription() + '\n';
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 3;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, str, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        sb = new StringBuilder().append(cache.getVersion()).append('\n').toString();
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 4;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, sb, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        cache = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        sb = new StringBuilder().append(cache.getVersion()).append('\n').toString();
                        fileCacheStorage$writeCache$3.L$0 = channel;
                        fileCacheStorage$writeCache$3.L$1 = cache;
                        fileCacheStorage$writeCache$3.label = 4;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8((ByteWriteChannel) channel, sb, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                        }
                        break;
                    case 4:
                        ResultKt.throwOnFailure($result);
                        channel2 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        cache2 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        headers = StringValuesKt.flattenEntries(cache2.getHeaders());
                        size = headers.size();
                        fileCacheStorage$writeCache$3.L$0 = channel2;
                        fileCacheStorage$writeCache$3.L$1 = cache2;
                        fileCacheStorage$writeCache$3.L$2 = headers;
                        fileCacheStorage$writeCache$3.label = 5;
                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel2, size, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        it = headers.iterator();
                        if (it.hasNext()) {
                        }
                        break;
                    case 5:
                        headers = (List) fileCacheStorage$writeCache$3.L$2;
                        cache2 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel2 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        it = headers.iterator();
                        if (it.hasNext()) {
                        }
                        break;
                    case 6:
                        value2 = (String) fileCacheStorage$writeCache$3.L$3;
                        it2 = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        cache3 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel3 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        str2 = value2 + '\n';
                        fileCacheStorage$writeCache$3.L$0 = channel3;
                        fileCacheStorage$writeCache$3.L$1 = cache3;
                        fileCacheStorage$writeCache$3.L$2 = it2;
                        fileCacheStorage$writeCache$3.L$3 = null;
                        fileCacheStorage$writeCache$3.label = 7;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8(channel3, str2, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                        }
                        break;
                    case 7:
                        cache2 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel2 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        it = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        if (it.hasNext()) {
                        }
                        break;
                    case 8:
                        cache4 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel4 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        timestamp = cache4.getResponseTime().getTimestamp();
                        fileCacheStorage$writeCache$3.L$0 = channel4;
                        fileCacheStorage$writeCache$3.L$1 = cache4;
                        fileCacheStorage$writeCache$3.label = 9;
                        if (ByteWriteChannelOperationsKt.writeLong((ByteWriteChannel) channel4, timestamp, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        timestamp2 = cache4.getExpires().getTimestamp();
                        fileCacheStorage$writeCache$3.L$0 = channel4;
                        fileCacheStorage$writeCache$3.L$1 = cache4;
                        fileCacheStorage$writeCache$3.label = 10;
                        if (ByteWriteChannelOperationsKt.writeLong((ByteWriteChannel) channel4, timestamp2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        size2 = cache4.getVaryKeys().size();
                        fileCacheStorage$writeCache$3.L$0 = channel4;
                        fileCacheStorage$writeCache$3.L$1 = cache4;
                        fileCacheStorage$writeCache$3.label = 11;
                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel4, size2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        it3 = cache4.getVaryKeys().entrySet().iterator();
                        if (it3.hasNext()) {
                        }
                        break;
                    case 9:
                        cache4 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel4 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        timestamp2 = cache4.getExpires().getTimestamp();
                        fileCacheStorage$writeCache$3.L$0 = channel4;
                        fileCacheStorage$writeCache$3.L$1 = cache4;
                        fileCacheStorage$writeCache$3.label = 10;
                        if (ByteWriteChannelOperationsKt.writeLong((ByteWriteChannel) channel4, timestamp2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        size2 = cache4.getVaryKeys().size();
                        fileCacheStorage$writeCache$3.L$0 = channel4;
                        fileCacheStorage$writeCache$3.L$1 = cache4;
                        fileCacheStorage$writeCache$3.label = 11;
                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel4, size2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        it3 = cache4.getVaryKeys().entrySet().iterator();
                        if (it3.hasNext()) {
                        }
                        break;
                    case 10:
                        cache4 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel4 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        size2 = cache4.getVaryKeys().size();
                        fileCacheStorage$writeCache$3.L$0 = channel4;
                        fileCacheStorage$writeCache$3.L$1 = cache4;
                        fileCacheStorage$writeCache$3.label = 11;
                        if (ByteWriteChannelOperationsKt.writeInt((ByteWriteChannel) channel4, size2, fileCacheStorage$writeCache$3) == coroutine_suspended) {
                        }
                        it3 = cache4.getVaryKeys().entrySet().iterator();
                        if (it3.hasNext()) {
                        }
                        break;
                    case 11:
                        cache4 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel4 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        it3 = cache4.getVaryKeys().entrySet().iterator();
                        if (it3.hasNext()) {
                        }
                        break;
                    case 12:
                        value3 = (String) fileCacheStorage$writeCache$3.L$3;
                        it4 = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        cache5 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel5 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        str3 = value3 + '\n';
                        fileCacheStorage$writeCache$3.L$0 = channel5;
                        fileCacheStorage$writeCache$3.L$1 = cache5;
                        fileCacheStorage$writeCache$3.L$2 = it4;
                        fileCacheStorage$writeCache$3.L$3 = null;
                        fileCacheStorage$writeCache$3.label = 13;
                        if (ByteWriteChannelOperationsKt.writeStringUtf8(channel5, str3, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                        }
                        break;
                    case 13:
                        ByteChannel channel7 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure($result);
                        it3 = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        cache4 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        channel4 = channel7;
                        if (it3.hasNext()) {
                        }
                        break;
                    case 14:
                        cache4 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        ResultKt.throwOnFailure($result);
                        channel6 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        body = cache4.getBody();
                        fileCacheStorage$writeCache$3.L$0 = null;
                        fileCacheStorage$writeCache$3.L$1 = null;
                        fileCacheStorage$writeCache$3.label = 15;
                        if (ByteWriteChannelOperationsKt.writeFully$default((ByteWriteChannel) channel6, body, 0, 0, fileCacheStorage$writeCache$3, 6, (Object) null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 15:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileCacheStorage$writeCache$3 = new FileCacheStorage$writeCache$3(this, continuation);
        Object $result2 = fileCacheStorage$writeCache$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fileCacheStorage$writeCache$3.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x030b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0372 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x041f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x04ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x055e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x055f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0373 -> B:54:0x037f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x04af -> B:79:0x04c5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readCache(ByteReadChannel byteReadChannel, Continuation<? super CachedResponseData> continuation) {
        FileCacheStorage$readCache$3 fileCacheStorage$readCache$3;
        ByteReadChannel channel;
        Object readUTF8Line$default;
        String url;
        Object readInt;
        Object readUTF8Line$default2;
        ByteReadChannel channel2;
        int i2;
        Object readUTF8Line$default3;
        HttpStatusCode status;
        HttpProtocolVersion.Companion companion;
        ByteReadChannel channel3;
        String url2;
        HttpProtocolVersion version;
        Object readInt2;
        int j;
        HeadersBuilder headers;
        int headersCount;
        ByteReadChannel channel4;
        String url3;
        HttpStatusCode status2;
        Object $result;
        Object $result2;
        FileCacheStorage$readCache$3 fileCacheStorage$readCache$32;
        HttpProtocolVersion version2;
        Continuation<? super CachedResponseData> continuation2;
        ByteReadChannel channel5;
        String url4;
        HeadersBuilder headers2;
        HttpProtocolVersion version3;
        Object readUTF8Line$default4;
        HeadersBuilder headers3;
        String key;
        int j2;
        ByteReadChannel channel6;
        int headersCount2;
        HttpStatusCode status3;
        Object obj;
        Object $result3;
        FileCacheStorage$readCache$3 fileCacheStorage$readCache$33;
        Continuation<? super CachedResponseData> continuation3;
        HttpProtocolVersion version4;
        ByteReadChannel channel7;
        String url5;
        HttpStatusCode status4;
        GMTDate requestTime;
        Object readLong;
        GMTDate responseTime;
        Object readLong2;
        GMTDate requestTime2;
        ByteReadChannel channel8;
        HttpStatusCode status5;
        HeadersBuilder headers4;
        String url6;
        HttpProtocolVersion version5;
        GMTDate expirationTime;
        Object readInt3;
        int varyKeysCount;
        Map createMapBuilder;
        Map $this$readCache_u24lambda_u245;
        int i3;
        Continuation<? super CachedResponseData> continuation4;
        int j3;
        Object $result4;
        HttpStatusCode status6;
        String url7;
        GMTDate responseTime2;
        int varyKeysCount2;
        Map $this$readCache_u24lambda_u2452;
        HttpProtocolVersion version6;
        Map map;
        HeadersBuilder headers5;
        GMTDate expirationTime2;
        int j4;
        int j5;
        Object $result5;
        GMTDate responseTime3;
        int i4;
        Object readUTF8Line$default5;
        FileCacheStorage$readCache$3 fileCacheStorage$readCache$34;
        Map $this$readCache_u24lambda_u2453;
        String key2;
        Continuation<? super CachedResponseData> continuation5;
        HttpStatusCode status7;
        GMTDate expirationTime3;
        Map map2;
        GMTDate requestTime3;
        HeadersBuilder headers6;
        HttpProtocolVersion version7;
        HttpStatusCode status8;
        String url8;
        GMTDate responseTime4;
        ByteReadChannel channel9;
        Object $result6;
        Map varyKeys;
        FileCacheStorage$readCache$3 fileCacheStorage$readCache$35;
        GMTDate expirationTime4;
        Object obj2;
        byte[] body;
        byte[] body2;
        HttpStatusCode status9;
        HttpProtocolVersion version8;
        Map varyKeys2;
        GMTDate requestTime4;
        String url9;
        GMTDate requestTime5;
        HeadersBuilder headers7;
        GMTDate responseTime5;
        if (continuation instanceof FileCacheStorage$readCache$3) {
            fileCacheStorage$readCache$3 = (FileCacheStorage$readCache$3) continuation;
            if ((fileCacheStorage$readCache$3.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$readCache$3.label -= Integer.MIN_VALUE;
                Object $result7 = fileCacheStorage$readCache$3.result;
                Object $result8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fileCacheStorage$readCache$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result7);
                        channel = byteReadChannel;
                        fileCacheStorage$readCache$3.L$0 = channel;
                        fileCacheStorage$readCache$3.label = 1;
                        readUTF8Line$default = ByteReadChannelOperationsKt.readUTF8Line$default(channel, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default == $result8) {
                            return $result8;
                        }
                        Intrinsics.checkNotNull(readUTF8Line$default);
                        url = (String) readUTF8Line$default;
                        fileCacheStorage$readCache$3.L$0 = channel;
                        fileCacheStorage$readCache$3.L$1 = url;
                        fileCacheStorage$readCache$3.label = 2;
                        readInt = ByteReadChannelOperationsKt.readInt(channel, fileCacheStorage$readCache$3);
                        if (readInt == $result8) {
                            return $result8;
                        }
                        int intValue = ((Number) readInt).intValue();
                        fileCacheStorage$readCache$3.L$0 = channel;
                        fileCacheStorage$readCache$3.L$1 = url;
                        fileCacheStorage$readCache$3.I$0 = intValue;
                        fileCacheStorage$readCache$3.label = 3;
                        readUTF8Line$default2 = ByteReadChannelOperationsKt.readUTF8Line$default(channel, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default2 == $result8) {
                            return $result8;
                        }
                        channel2 = channel;
                        i2 = intValue;
                        Intrinsics.checkNotNull(readUTF8Line$default2);
                        HttpStatusCode status10 = new HttpStatusCode(i2, (String) readUTF8Line$default2);
                        HttpProtocolVersion.Companion companion2 = HttpProtocolVersion.Companion;
                        fileCacheStorage$readCache$3.L$0 = channel2;
                        fileCacheStorage$readCache$3.L$1 = url;
                        fileCacheStorage$readCache$3.L$2 = status10;
                        fileCacheStorage$readCache$3.L$3 = companion2;
                        fileCacheStorage$readCache$3.label = 4;
                        readUTF8Line$default3 = ByteReadChannelOperationsKt.readUTF8Line$default(channel2, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default3 != $result8) {
                            return $result8;
                        }
                        String str = url;
                        status = status10;
                        companion = companion2;
                        channel3 = channel2;
                        url2 = str;
                        Intrinsics.checkNotNull(readUTF8Line$default3);
                        version = companion.parse((CharSequence) readUTF8Line$default3);
                        fileCacheStorage$readCache$3.L$0 = channel3;
                        fileCacheStorage$readCache$3.L$1 = url2;
                        fileCacheStorage$readCache$3.L$2 = status;
                        fileCacheStorage$readCache$3.L$3 = version;
                        fileCacheStorage$readCache$3.label = 5;
                        readInt2 = ByteReadChannelOperationsKt.readInt(channel3, fileCacheStorage$readCache$3);
                        if (readInt2 == $result8) {
                            return $result8;
                        }
                        int headersCount3 = ((Number) readInt2).intValue();
                        HeadersBuilder headers8 = new HeadersBuilder(0, 1, null);
                        j = 0;
                        headers = headers8;
                        headersCount = headersCount3;
                        channel4 = channel3;
                        url3 = url2;
                        status2 = status;
                        $result = $result8;
                        $result2 = $result7;
                        fileCacheStorage$readCache$32 = fileCacheStorage$readCache$3;
                        version2 = version;
                        continuation2 = continuation;
                        if (j < headersCount) {
                            fileCacheStorage$readCache$32.L$0 = channel4;
                            fileCacheStorage$readCache$32.L$1 = url3;
                            fileCacheStorage$readCache$32.L$2 = status2;
                            fileCacheStorage$readCache$32.L$3 = version2;
                            fileCacheStorage$readCache$32.L$4 = headers;
                            fileCacheStorage$readCache$32.L$5 = null;
                            fileCacheStorage$readCache$32.I$0 = headersCount;
                            fileCacheStorage$readCache$32.I$1 = j;
                            fileCacheStorage$readCache$32.label = 6;
                            Object readUTF8Line$default6 = ByteReadChannelOperationsKt.readUTF8Line$default(channel4, 0, fileCacheStorage$readCache$32, 1, (Object) null);
                            if (readUTF8Line$default6 == $result) {
                                return $result;
                            }
                            channel5 = channel4;
                            version3 = version2;
                            fileCacheStorage$readCache$3 = fileCacheStorage$readCache$32;
                            $result7 = readUTF8Line$default6;
                            HeadersBuilder headersBuilder = headers;
                            url4 = url3;
                            headers2 = headersBuilder;
                            Intrinsics.checkNotNull($result7);
                            String key3 = (String) $result7;
                            fileCacheStorage$readCache$3.L$0 = channel5;
                            fileCacheStorage$readCache$3.L$1 = url4;
                            fileCacheStorage$readCache$3.L$2 = status2;
                            fileCacheStorage$readCache$3.L$3 = version3;
                            fileCacheStorage$readCache$3.L$4 = headers2;
                            fileCacheStorage$readCache$3.L$5 = key3;
                            fileCacheStorage$readCache$3.I$0 = headersCount;
                            fileCacheStorage$readCache$3.I$1 = j;
                            fileCacheStorage$readCache$3.label = 7;
                            Continuation<? super CachedResponseData> continuation6 = continuation2;
                            readUTF8Line$default4 = ByteReadChannelOperationsKt.readUTF8Line$default(channel5, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                            if (readUTF8Line$default4 != $result) {
                                return $result;
                            }
                            headers3 = headers2;
                            key = key3;
                            $result7 = readUTF8Line$default4;
                            j2 = j;
                            channel6 = channel5;
                            headersCount2 = headersCount;
                            status3 = status2;
                            obj = $result;
                            $result3 = $result2;
                            fileCacheStorage$readCache$33 = fileCacheStorage$readCache$3;
                            continuation3 = continuation6;
                            Intrinsics.checkNotNull($result7);
                            String value = (String) $result7;
                            headers3.append(key, value);
                            fileCacheStorage$readCache$32 = fileCacheStorage$readCache$33;
                            $result2 = $result3;
                            $result = obj;
                            status2 = status3;
                            url3 = url4;
                            headersCount = headersCount2;
                            headers = headers3;
                            ByteReadChannel byteReadChannel2 = channel6;
                            j = j2 + 1;
                            continuation2 = continuation3;
                            version2 = version3;
                            channel4 = byteReadChannel2;
                            if (j < headersCount) {
                                fileCacheStorage$readCache$32.L$0 = channel4;
                                fileCacheStorage$readCache$32.L$1 = url3;
                                fileCacheStorage$readCache$32.L$2 = status2;
                                fileCacheStorage$readCache$32.L$3 = version2;
                                fileCacheStorage$readCache$32.L$4 = headers;
                                fileCacheStorage$readCache$32.L$5 = null;
                                fileCacheStorage$readCache$32.label = 8;
                                Object readLong3 = ByteReadChannelOperationsKt.readLong(channel4, fileCacheStorage$readCache$32);
                                if (readLong3 == $result) {
                                    return $result;
                                }
                                HttpStatusCode httpStatusCode = status2;
                                version4 = version2;
                                fileCacheStorage$readCache$3 = fileCacheStorage$readCache$32;
                                $result7 = readLong3;
                                channel7 = channel4;
                                url5 = url3;
                                status4 = httpStatusCode;
                                requestTime = DateJvmKt.GMTDate((Long) $result7);
                                fileCacheStorage$readCache$3.L$0 = channel7;
                                fileCacheStorage$readCache$3.L$1 = url5;
                                fileCacheStorage$readCache$3.L$2 = status4;
                                fileCacheStorage$readCache$3.L$3 = version4;
                                fileCacheStorage$readCache$3.L$4 = headers;
                                fileCacheStorage$readCache$3.L$5 = requestTime;
                                fileCacheStorage$readCache$3.label = 9;
                                readLong = ByteReadChannelOperationsKt.readLong(channel7, fileCacheStorage$readCache$3);
                                if (readLong == $result) {
                                    return $result;
                                }
                                responseTime = DateJvmKt.GMTDate((Long) readLong);
                                fileCacheStorage$readCache$3.L$0 = channel7;
                                fileCacheStorage$readCache$3.L$1 = url5;
                                fileCacheStorage$readCache$3.L$2 = status4;
                                fileCacheStorage$readCache$3.L$3 = version4;
                                fileCacheStorage$readCache$3.L$4 = headers;
                                fileCacheStorage$readCache$3.L$5 = requestTime;
                                fileCacheStorage$readCache$3.L$6 = responseTime;
                                fileCacheStorage$readCache$3.label = 10;
                                readLong2 = ByteReadChannelOperationsKt.readLong(channel7, fileCacheStorage$readCache$3);
                                if (readLong2 == $result) {
                                    return $result;
                                }
                                HttpProtocolVersion httpProtocolVersion = version4;
                                requestTime2 = requestTime;
                                $result7 = readLong2;
                                channel8 = channel7;
                                status5 = status4;
                                headers4 = headers;
                                url6 = url5;
                                version5 = httpProtocolVersion;
                                expirationTime = DateJvmKt.GMTDate((Long) $result7);
                                fileCacheStorage$readCache$3.L$0 = channel8;
                                fileCacheStorage$readCache$3.L$1 = url6;
                                fileCacheStorage$readCache$3.L$2 = status5;
                                fileCacheStorage$readCache$3.L$3 = version5;
                                fileCacheStorage$readCache$3.L$4 = headers4;
                                fileCacheStorage$readCache$3.L$5 = requestTime2;
                                fileCacheStorage$readCache$3.L$6 = responseTime;
                                fileCacheStorage$readCache$3.L$7 = expirationTime;
                                fileCacheStorage$readCache$3.label = 11;
                                readInt3 = ByteReadChannelOperationsKt.readInt(channel8, fileCacheStorage$readCache$3);
                                if (readInt3 == $result) {
                                    return $result;
                                }
                                varyKeysCount = ((Number) readInt3).intValue();
                                createMapBuilder = MapsKt.createMapBuilder();
                                $this$readCache_u24lambda_u245 = createMapBuilder;
                                i3 = 0;
                                continuation4 = continuation2;
                                j3 = 0;
                                Object obj3 = $result;
                                $result4 = $result2;
                                $result8 = obj3;
                                if (j3 < varyKeysCount) {
                                    fileCacheStorage$readCache$3.L$0 = channel8;
                                    fileCacheStorage$readCache$3.L$1 = url6;
                                    fileCacheStorage$readCache$3.L$2 = status5;
                                    fileCacheStorage$readCache$3.L$3 = version5;
                                    fileCacheStorage$readCache$3.L$4 = headers4;
                                    fileCacheStorage$readCache$3.L$5 = requestTime2;
                                    fileCacheStorage$readCache$3.L$6 = responseTime;
                                    fileCacheStorage$readCache$3.L$7 = expirationTime;
                                    fileCacheStorage$readCache$3.L$8 = createMapBuilder;
                                    fileCacheStorage$readCache$3.L$9 = $this$readCache_u24lambda_u245;
                                    fileCacheStorage$readCache$3.L$10 = null;
                                    fileCacheStorage$readCache$3.I$0 = varyKeysCount;
                                    fileCacheStorage$readCache$3.I$1 = j3;
                                    int j6 = j3;
                                    fileCacheStorage$readCache$3.label = 12;
                                    $result5 = $result4;
                                    int varyKeysCount3 = varyKeysCount;
                                    Object readUTF8Line$default7 = ByteReadChannelOperationsKt.readUTF8Line$default(channel8, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                                    if (readUTF8Line$default7 == $result8) {
                                        return $result8;
                                    }
                                    expirationTime2 = expirationTime;
                                    responseTime2 = responseTime;
                                    $result7 = readUTF8Line$default7;
                                    map = createMapBuilder;
                                    $this$readCache_u24lambda_u2452 = $this$readCache_u24lambda_u245;
                                    j5 = i3;
                                    status6 = status5;
                                    url7 = url6;
                                    j4 = j6;
                                    varyKeysCount2 = varyKeysCount3;
                                    HttpProtocolVersion httpProtocolVersion2 = version5;
                                    headers5 = headers4;
                                    version6 = httpProtocolVersion2;
                                    Intrinsics.checkNotNull($result7);
                                    String key4 = (String) $result7;
                                    fileCacheStorage$readCache$3.L$0 = channel8;
                                    fileCacheStorage$readCache$3.L$1 = url7;
                                    fileCacheStorage$readCache$3.L$2 = status6;
                                    fileCacheStorage$readCache$3.L$3 = version6;
                                    fileCacheStorage$readCache$3.L$4 = headers5;
                                    fileCacheStorage$readCache$3.L$5 = requestTime2;
                                    fileCacheStorage$readCache$3.L$6 = responseTime2;
                                    fileCacheStorage$readCache$3.L$7 = expirationTime2;
                                    fileCacheStorage$readCache$3.L$8 = map;
                                    fileCacheStorage$readCache$3.L$9 = $this$readCache_u24lambda_u2452;
                                    fileCacheStorage$readCache$3.L$10 = key4;
                                    fileCacheStorage$readCache$3.I$0 = varyKeysCount2;
                                    fileCacheStorage$readCache$3.I$1 = j4;
                                    GMTDate expirationTime5 = expirationTime2;
                                    fileCacheStorage$readCache$3.label = 13;
                                    responseTime3 = responseTime2;
                                    i4 = j5;
                                    readUTF8Line$default5 = ByteReadChannelOperationsKt.readUTF8Line$default(channel8, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                                    if (readUTF8Line$default5 != $result8) {
                                        return $result8;
                                    }
                                    fileCacheStorage$readCache$34 = fileCacheStorage$readCache$3;
                                    $result7 = readUTF8Line$default5;
                                    $this$readCache_u24lambda_u2453 = $this$readCache_u24lambda_u2452;
                                    key2 = key4;
                                    continuation5 = continuation4;
                                    $result4 = $result5;
                                    HeadersBuilder headersBuilder2 = headers5;
                                    version5 = version6;
                                    headers4 = headersBuilder2;
                                    Map map3 = map;
                                    varyKeysCount = varyKeysCount2;
                                    status7 = status6;
                                    expirationTime3 = expirationTime5;
                                    map2 = map3;
                                    Intrinsics.checkNotNull($result7);
                                    String value2 = (String) $result7;
                                    $this$readCache_u24lambda_u2453.put(key2, value2);
                                    int i5 = j4 + 1;
                                    continuation4 = continuation5;
                                    fileCacheStorage$readCache$3 = fileCacheStorage$readCache$34;
                                    status5 = status7;
                                    url6 = url7;
                                    responseTime = responseTime3;
                                    $this$readCache_u24lambda_u245 = $this$readCache_u24lambda_u2453;
                                    j3 = i5;
                                    expirationTime = expirationTime3;
                                    createMapBuilder = map2;
                                    i3 = i4;
                                    if (j3 < varyKeysCount) {
                                        Object $result9 = $result4;
                                        Map varyKeys3 = MapsKt.build(createMapBuilder);
                                        fileCacheStorage$readCache$3.L$0 = channel8;
                                        fileCacheStorage$readCache$3.L$1 = url6;
                                        fileCacheStorage$readCache$3.L$2 = status5;
                                        fileCacheStorage$readCache$3.L$3 = version5;
                                        fileCacheStorage$readCache$3.L$4 = headers4;
                                        fileCacheStorage$readCache$3.L$5 = requestTime2;
                                        fileCacheStorage$readCache$3.L$6 = responseTime;
                                        fileCacheStorage$readCache$3.L$7 = expirationTime;
                                        fileCacheStorage$readCache$3.L$8 = varyKeys3;
                                        fileCacheStorage$readCache$3.L$9 = null;
                                        fileCacheStorage$readCache$3.L$10 = null;
                                        fileCacheStorage$readCache$3.label = 14;
                                        Object readInt4 = ByteReadChannelOperationsKt.readInt(channel8, fileCacheStorage$readCache$3);
                                        if (readInt4 == $result8) {
                                            return $result8;
                                        }
                                        requestTime3 = requestTime2;
                                        headers6 = headers4;
                                        version7 = version5;
                                        status8 = status5;
                                        url8 = url6;
                                        responseTime4 = responseTime;
                                        channel9 = channel8;
                                        $result6 = $result9;
                                        varyKeys = varyKeys3;
                                        fileCacheStorage$readCache$35 = fileCacheStorage$readCache$3;
                                        expirationTime4 = expirationTime;
                                        obj2 = $result8;
                                        $result7 = readInt4;
                                        int bodyCount = ((Number) $result7).intValue();
                                        body = new byte[bodyCount];
                                        fileCacheStorage$readCache$35.L$0 = url8;
                                        fileCacheStorage$readCache$35.L$1 = status8;
                                        fileCacheStorage$readCache$35.L$2 = version7;
                                        fileCacheStorage$readCache$35.L$3 = headers6;
                                        fileCacheStorage$readCache$35.L$4 = requestTime3;
                                        fileCacheStorage$readCache$35.L$5 = responseTime4;
                                        fileCacheStorage$readCache$35.L$6 = expirationTime4;
                                        fileCacheStorage$readCache$35.L$7 = varyKeys;
                                        fileCacheStorage$readCache$35.L$8 = body;
                                        fileCacheStorage$readCache$35.label = 15;
                                        body2 = body;
                                        String url10 = url8;
                                        status9 = status8;
                                        version8 = version7;
                                        if (ByteReadChannelOperationsKt.readFully$default(channel9, body, 0, 0, fileCacheStorage$readCache$35, 6, (Object) null) != obj2) {
                                            return obj2;
                                        }
                                        varyKeys2 = varyKeys;
                                        requestTime4 = requestTime3;
                                        url9 = url10;
                                        requestTime5 = expirationTime4;
                                        headers7 = headers6;
                                        responseTime5 = responseTime4;
                                        return new CachedResponseData(URLUtilsKt.Url(url9), status9, requestTime4, responseTime5, version8, requestTime5, headers7.m3526build(), varyKeys2, body2);
                                    }
                                }
                            }
                        }
                    case 1:
                        channel = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure($result7);
                        readUTF8Line$default = $result7;
                        Intrinsics.checkNotNull(readUTF8Line$default);
                        url = (String) readUTF8Line$default;
                        fileCacheStorage$readCache$3.L$0 = channel;
                        fileCacheStorage$readCache$3.L$1 = url;
                        fileCacheStorage$readCache$3.label = 2;
                        readInt = ByteReadChannelOperationsKt.readInt(channel, fileCacheStorage$readCache$3);
                        if (readInt == $result8) {
                        }
                        int intValue2 = ((Number) readInt).intValue();
                        fileCacheStorage$readCache$3.L$0 = channel;
                        fileCacheStorage$readCache$3.L$1 = url;
                        fileCacheStorage$readCache$3.I$0 = intValue2;
                        fileCacheStorage$readCache$3.label = 3;
                        readUTF8Line$default2 = ByteReadChannelOperationsKt.readUTF8Line$default(channel, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default2 == $result8) {
                        }
                        break;
                    case 2:
                        ByteReadChannel channel10 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure($result7);
                        readInt = $result7;
                        url = (String) fileCacheStorage$readCache$3.L$1;
                        channel = channel10;
                        int intValue22 = ((Number) readInt).intValue();
                        fileCacheStorage$readCache$3.L$0 = channel;
                        fileCacheStorage$readCache$3.L$1 = url;
                        fileCacheStorage$readCache$3.I$0 = intValue22;
                        fileCacheStorage$readCache$3.label = 3;
                        readUTF8Line$default2 = ByteReadChannelOperationsKt.readUTF8Line$default(channel, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default2 == $result8) {
                        }
                        break;
                    case 3:
                        i2 = fileCacheStorage$readCache$3.I$0;
                        url = (String) fileCacheStorage$readCache$3.L$1;
                        channel2 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure($result7);
                        readUTF8Line$default2 = $result7;
                        Intrinsics.checkNotNull(readUTF8Line$default2);
                        HttpStatusCode status102 = new HttpStatusCode(i2, (String) readUTF8Line$default2);
                        HttpProtocolVersion.Companion companion22 = HttpProtocolVersion.Companion;
                        fileCacheStorage$readCache$3.L$0 = channel2;
                        fileCacheStorage$readCache$3.L$1 = url;
                        fileCacheStorage$readCache$3.L$2 = status102;
                        fileCacheStorage$readCache$3.L$3 = companion22;
                        fileCacheStorage$readCache$3.label = 4;
                        readUTF8Line$default3 = ByteReadChannelOperationsKt.readUTF8Line$default(channel2, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default3 != $result8) {
                        }
                        break;
                    case 4:
                        companion = (HttpProtocolVersion.Companion) fileCacheStorage$readCache$3.L$3;
                        status = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        url2 = (String) fileCacheStorage$readCache$3.L$1;
                        channel3 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure($result7);
                        readUTF8Line$default3 = $result7;
                        Intrinsics.checkNotNull(readUTF8Line$default3);
                        version = companion.parse((CharSequence) readUTF8Line$default3);
                        fileCacheStorage$readCache$3.L$0 = channel3;
                        fileCacheStorage$readCache$3.L$1 = url2;
                        fileCacheStorage$readCache$3.L$2 = status;
                        fileCacheStorage$readCache$3.L$3 = version;
                        fileCacheStorage$readCache$3.label = 5;
                        readInt2 = ByteReadChannelOperationsKt.readInt(channel3, fileCacheStorage$readCache$3);
                        if (readInt2 == $result8) {
                        }
                        int headersCount32 = ((Number) readInt2).intValue();
                        HeadersBuilder headers82 = new HeadersBuilder(0, 1, null);
                        j = 0;
                        headers = headers82;
                        headersCount = headersCount32;
                        channel4 = channel3;
                        url3 = url2;
                        status2 = status;
                        $result = $result8;
                        $result2 = $result7;
                        fileCacheStorage$readCache$32 = fileCacheStorage$readCache$3;
                        version2 = version;
                        continuation2 = continuation;
                        if (j < headersCount) {
                        }
                        break;
                    case 5:
                        version = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        status = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        url2 = (String) fileCacheStorage$readCache$3.L$1;
                        channel3 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure($result7);
                        readInt2 = $result7;
                        int headersCount322 = ((Number) readInt2).intValue();
                        HeadersBuilder headers822 = new HeadersBuilder(0, 1, null);
                        j = 0;
                        headers = headers822;
                        headersCount = headersCount322;
                        channel4 = channel3;
                        url3 = url2;
                        status2 = status;
                        $result = $result8;
                        $result2 = $result7;
                        fileCacheStorage$readCache$32 = fileCacheStorage$readCache$3;
                        version2 = version;
                        continuation2 = continuation;
                        if (j < headersCount) {
                        }
                        break;
                    case 6:
                        int j7 = fileCacheStorage$readCache$3.I$1;
                        int headersCount4 = fileCacheStorage$readCache$3.I$0;
                        HeadersBuilder headers9 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        HttpProtocolVersion version9 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        ResultKt.throwOnFailure($result7);
                        j = j7;
                        channel5 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        continuation2 = continuation;
                        url4 = (String) fileCacheStorage$readCache$3.L$1;
                        headersCount = headersCount4;
                        $result = $result8;
                        $result2 = $result7;
                        headers2 = headers9;
                        status2 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        version3 = version9;
                        Intrinsics.checkNotNull($result7);
                        String key32 = (String) $result7;
                        fileCacheStorage$readCache$3.L$0 = channel5;
                        fileCacheStorage$readCache$3.L$1 = url4;
                        fileCacheStorage$readCache$3.L$2 = status2;
                        fileCacheStorage$readCache$3.L$3 = version3;
                        fileCacheStorage$readCache$3.L$4 = headers2;
                        fileCacheStorage$readCache$3.L$5 = key32;
                        fileCacheStorage$readCache$3.I$0 = headersCount;
                        fileCacheStorage$readCache$3.I$1 = j;
                        fileCacheStorage$readCache$3.label = 7;
                        Continuation<? super CachedResponseData> continuation62 = continuation2;
                        readUTF8Line$default4 = ByteReadChannelOperationsKt.readUTF8Line$default(channel5, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default4 != $result) {
                        }
                        break;
                    case 7:
                        j2 = fileCacheStorage$readCache$3.I$1;
                        int headersCount5 = fileCacheStorage$readCache$3.I$0;
                        HeadersBuilder headers10 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        version3 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        status3 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        url4 = (String) fileCacheStorage$readCache$3.L$1;
                        channel6 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure($result7);
                        headersCount2 = headersCount5;
                        headers3 = headers10;
                        $result3 = $result7;
                        key = (String) fileCacheStorage$readCache$3.L$5;
                        obj = $result8;
                        fileCacheStorage$readCache$33 = fileCacheStorage$readCache$3;
                        continuation3 = continuation;
                        Intrinsics.checkNotNull($result7);
                        String value3 = (String) $result7;
                        headers3.append(key, value3);
                        fileCacheStorage$readCache$32 = fileCacheStorage$readCache$33;
                        $result2 = $result3;
                        $result = obj;
                        status2 = status3;
                        url3 = url4;
                        headersCount = headersCount2;
                        headers = headers3;
                        ByteReadChannel byteReadChannel22 = channel6;
                        j = j2 + 1;
                        continuation2 = continuation3;
                        version2 = version3;
                        channel4 = byteReadChannel22;
                        if (j < headersCount) {
                        }
                        break;
                    case 8:
                        HeadersBuilder headers11 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        ResultKt.throwOnFailure($result7);
                        headers = headers11;
                        channel7 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        continuation2 = continuation;
                        url5 = (String) fileCacheStorage$readCache$3.L$1;
                        status4 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        version4 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        $result = $result8;
                        $result2 = $result7;
                        requestTime = DateJvmKt.GMTDate((Long) $result7);
                        fileCacheStorage$readCache$3.L$0 = channel7;
                        fileCacheStorage$readCache$3.L$1 = url5;
                        fileCacheStorage$readCache$3.L$2 = status4;
                        fileCacheStorage$readCache$3.L$3 = version4;
                        fileCacheStorage$readCache$3.L$4 = headers;
                        fileCacheStorage$readCache$3.L$5 = requestTime;
                        fileCacheStorage$readCache$3.label = 9;
                        readLong = ByteReadChannelOperationsKt.readLong(channel7, fileCacheStorage$readCache$3);
                        if (readLong == $result) {
                        }
                        responseTime = DateJvmKt.GMTDate((Long) readLong);
                        fileCacheStorage$readCache$3.L$0 = channel7;
                        fileCacheStorage$readCache$3.L$1 = url5;
                        fileCacheStorage$readCache$3.L$2 = status4;
                        fileCacheStorage$readCache$3.L$3 = version4;
                        fileCacheStorage$readCache$3.L$4 = headers;
                        fileCacheStorage$readCache$3.L$5 = requestTime;
                        fileCacheStorage$readCache$3.L$6 = responseTime;
                        fileCacheStorage$readCache$3.label = 10;
                        readLong2 = ByteReadChannelOperationsKt.readLong(channel7, fileCacheStorage$readCache$3);
                        if (readLong2 == $result) {
                        }
                        break;
                    case 9:
                        HeadersBuilder headers12 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        version4 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        status4 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        url5 = (String) fileCacheStorage$readCache$3.L$1;
                        channel7 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure($result7);
                        readLong = $result7;
                        headers = headers12;
                        requestTime = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        $result = $result8;
                        continuation2 = continuation;
                        $result2 = readLong;
                        responseTime = DateJvmKt.GMTDate((Long) readLong);
                        fileCacheStorage$readCache$3.L$0 = channel7;
                        fileCacheStorage$readCache$3.L$1 = url5;
                        fileCacheStorage$readCache$3.L$2 = status4;
                        fileCacheStorage$readCache$3.L$3 = version4;
                        fileCacheStorage$readCache$3.L$4 = headers;
                        fileCacheStorage$readCache$3.L$5 = requestTime;
                        fileCacheStorage$readCache$3.L$6 = responseTime;
                        fileCacheStorage$readCache$3.label = 10;
                        readLong2 = ByteReadChannelOperationsKt.readLong(channel7, fileCacheStorage$readCache$3);
                        if (readLong2 == $result) {
                        }
                        break;
                    case 10:
                        HeadersBuilder headers13 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        ResultKt.throwOnFailure($result7);
                        responseTime = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        channel8 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        continuation2 = continuation;
                        url6 = (String) fileCacheStorage$readCache$3.L$1;
                        status5 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        version5 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        headers4 = headers13;
                        requestTime2 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        $result = $result8;
                        $result2 = $result7;
                        expirationTime = DateJvmKt.GMTDate((Long) $result7);
                        fileCacheStorage$readCache$3.L$0 = channel8;
                        fileCacheStorage$readCache$3.L$1 = url6;
                        fileCacheStorage$readCache$3.L$2 = status5;
                        fileCacheStorage$readCache$3.L$3 = version5;
                        fileCacheStorage$readCache$3.L$4 = headers4;
                        fileCacheStorage$readCache$3.L$5 = requestTime2;
                        fileCacheStorage$readCache$3.L$6 = responseTime;
                        fileCacheStorage$readCache$3.L$7 = expirationTime;
                        fileCacheStorage$readCache$3.label = 11;
                        readInt3 = ByteReadChannelOperationsKt.readInt(channel8, fileCacheStorage$readCache$3);
                        if (readInt3 == $result) {
                        }
                        varyKeysCount = ((Number) readInt3).intValue();
                        createMapBuilder = MapsKt.createMapBuilder();
                        $this$readCache_u24lambda_u245 = createMapBuilder;
                        i3 = 0;
                        continuation4 = continuation2;
                        j3 = 0;
                        Object obj32 = $result;
                        $result4 = $result2;
                        $result8 = obj32;
                        if (j3 < varyKeysCount) {
                        }
                        break;
                    case 11:
                        requestTime2 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        headers4 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        version5 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        status5 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        url6 = (String) fileCacheStorage$readCache$3.L$1;
                        ResultKt.throwOnFailure($result7);
                        readInt3 = $result7;
                        channel8 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        expirationTime = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        responseTime = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        continuation2 = continuation;
                        $result = $result8;
                        $result2 = readInt3;
                        varyKeysCount = ((Number) readInt3).intValue();
                        createMapBuilder = MapsKt.createMapBuilder();
                        $this$readCache_u24lambda_u245 = createMapBuilder;
                        i3 = 0;
                        continuation4 = continuation2;
                        j3 = 0;
                        Object obj322 = $result;
                        $result4 = $result2;
                        $result8 = obj322;
                        if (j3 < varyKeysCount) {
                        }
                        break;
                    case 12:
                        int j8 = fileCacheStorage$readCache$3.I$1;
                        int varyKeysCount4 = fileCacheStorage$readCache$3.I$0;
                        Map $this$readCache_u24lambda_u2454 = (Map) fileCacheStorage$readCache$3.L$9;
                        HeadersBuilder headers14 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        status6 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        url7 = (String) fileCacheStorage$readCache$3.L$1;
                        ResultKt.throwOnFailure($result7);
                        responseTime2 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        varyKeysCount2 = varyKeysCount4;
                        requestTime2 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        $this$readCache_u24lambda_u2452 = $this$readCache_u24lambda_u2454;
                        version6 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        map = (Map) fileCacheStorage$readCache$3.L$8;
                        headers5 = headers14;
                        channel8 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        expirationTime2 = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        j4 = j8;
                        j5 = 0;
                        continuation4 = continuation;
                        $result5 = $result7;
                        Intrinsics.checkNotNull($result7);
                        String key42 = (String) $result7;
                        fileCacheStorage$readCache$3.L$0 = channel8;
                        fileCacheStorage$readCache$3.L$1 = url7;
                        fileCacheStorage$readCache$3.L$2 = status6;
                        fileCacheStorage$readCache$3.L$3 = version6;
                        fileCacheStorage$readCache$3.L$4 = headers5;
                        fileCacheStorage$readCache$3.L$5 = requestTime2;
                        fileCacheStorage$readCache$3.L$6 = responseTime2;
                        fileCacheStorage$readCache$3.L$7 = expirationTime2;
                        fileCacheStorage$readCache$3.L$8 = map;
                        fileCacheStorage$readCache$3.L$9 = $this$readCache_u24lambda_u2452;
                        fileCacheStorage$readCache$3.L$10 = key42;
                        fileCacheStorage$readCache$3.I$0 = varyKeysCount2;
                        fileCacheStorage$readCache$3.I$1 = j4;
                        GMTDate expirationTime52 = expirationTime2;
                        fileCacheStorage$readCache$3.label = 13;
                        responseTime3 = responseTime2;
                        i4 = j5;
                        readUTF8Line$default5 = ByteReadChannelOperationsKt.readUTF8Line$default(channel8, 0, fileCacheStorage$readCache$3, 1, (Object) null);
                        if (readUTF8Line$default5 != $result8) {
                        }
                        break;
                    case 13:
                        j4 = fileCacheStorage$readCache$3.I$1;
                        int varyKeysCount5 = fileCacheStorage$readCache$3.I$0;
                        key2 = (String) fileCacheStorage$readCache$3.L$10;
                        Map $this$readCache_u24lambda_u2455 = (Map) fileCacheStorage$readCache$3.L$9;
                        expirationTime3 = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        requestTime2 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        HeadersBuilder headers15 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        HttpStatusCode status11 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        String url11 = (String) fileCacheStorage$readCache$3.L$1;
                        ResultKt.throwOnFailure($result7);
                        fileCacheStorage$readCache$34 = fileCacheStorage$readCache$3;
                        i4 = 0;
                        responseTime3 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        url7 = url11;
                        continuation5 = continuation;
                        $result4 = $result7;
                        map2 = (Map) fileCacheStorage$readCache$3.L$8;
                        varyKeysCount = varyKeysCount5;
                        status7 = status11;
                        channel8 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        $this$readCache_u24lambda_u2453 = $this$readCache_u24lambda_u2455;
                        version5 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        headers4 = headers15;
                        Intrinsics.checkNotNull($result7);
                        String value22 = (String) $result7;
                        $this$readCache_u24lambda_u2453.put(key2, value22);
                        int i52 = j4 + 1;
                        continuation4 = continuation5;
                        fileCacheStorage$readCache$3 = fileCacheStorage$readCache$34;
                        status5 = status7;
                        url6 = url7;
                        responseTime = responseTime3;
                        $this$readCache_u24lambda_u245 = $this$readCache_u24lambda_u2453;
                        j3 = i52;
                        expirationTime = expirationTime3;
                        createMapBuilder = map2;
                        i3 = i4;
                        if (j3 < varyKeysCount) {
                        }
                        break;
                    case 14:
                        HeadersBuilder headers16 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        HttpStatusCode status12 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        ResultKt.throwOnFailure($result7);
                        requestTime3 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        headers6 = headers16;
                        channel9 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        fileCacheStorage$readCache$35 = fileCacheStorage$readCache$3;
                        $result6 = $result7;
                        responseTime4 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        version7 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        obj2 = $result8;
                        varyKeys = (Map) fileCacheStorage$readCache$3.L$8;
                        url8 = (String) fileCacheStorage$readCache$3.L$1;
                        expirationTime4 = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        status8 = status12;
                        int bodyCount2 = ((Number) $result7).intValue();
                        body = new byte[bodyCount2];
                        fileCacheStorage$readCache$35.L$0 = url8;
                        fileCacheStorage$readCache$35.L$1 = status8;
                        fileCacheStorage$readCache$35.L$2 = version7;
                        fileCacheStorage$readCache$35.L$3 = headers6;
                        fileCacheStorage$readCache$35.L$4 = requestTime3;
                        fileCacheStorage$readCache$35.L$5 = responseTime4;
                        fileCacheStorage$readCache$35.L$6 = expirationTime4;
                        fileCacheStorage$readCache$35.L$7 = varyKeys;
                        fileCacheStorage$readCache$35.L$8 = body;
                        fileCacheStorage$readCache$35.label = 15;
                        body2 = body;
                        String url102 = url8;
                        status9 = status8;
                        version8 = version7;
                        if (ByteReadChannelOperationsKt.readFully$default(channel9, body, 0, 0, fileCacheStorage$readCache$35, 6, (Object) null) != obj2) {
                        }
                        break;
                    case 15:
                        HeadersBuilder headers17 = (HeadersBuilder) fileCacheStorage$readCache$3.L$3;
                        ResultKt.throwOnFailure($result7);
                        body2 = (byte[]) fileCacheStorage$readCache$3.L$8;
                        varyKeys2 = (Map) fileCacheStorage$readCache$3.L$7;
                        requestTime5 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        responseTime5 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        requestTime4 = (GMTDate) fileCacheStorage$readCache$3.L$4;
                        headers7 = headers17;
                        version8 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$2;
                        status9 = (HttpStatusCode) fileCacheStorage$readCache$3.L$1;
                        url9 = (String) fileCacheStorage$readCache$3.L$0;
                        return new CachedResponseData(URLUtilsKt.Url(url9), status9, requestTime4, responseTime5, version8, requestTime5, headers7.m3526build(), varyKeys2, body2);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileCacheStorage$readCache$3 = new FileCacheStorage$readCache$3(this, continuation);
        Object $result72 = fileCacheStorage$readCache$3.result;
        Object $result82 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fileCacheStorage$readCache$3.label) {
        }
    }
}