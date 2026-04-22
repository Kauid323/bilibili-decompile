package io.ktor.client.plugins.cache.storage;

import com.tencent.smtt.sdk.TbsListener;
import io.grpc.internal.GrpcUtil;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2", f = "FileCacheStorage.kt", i = {0, 0, 1, 1, 1}, l = {TbsListener.ErrorCode.APK_PATH_ERROR, 103}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
public final class FileCacheStorage$writeCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ List<CachedResponseData> $caches;
    final /* synthetic */ String $urlHex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$writeCache$2(FileCacheStorage fileCacheStorage, String str, List<CachedResponseData> list, Continuation<? super FileCacheStorage$writeCache$2> continuation) {
        super(2, continuation);
        this.this$0 = fileCacheStorage;
        this.$urlHex = str;
        this.$caches = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fileCacheStorage$writeCache$2 = new FileCacheStorage$writeCache$2(this.this$0, this.$urlHex, this.$caches, continuation);
        fileCacheStorage$writeCache$2.L$0 = obj;
        return fileCacheStorage$writeCache$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3 A[Catch: Exception -> 0x0181, all -> 0x01b3, TryCatch #2 {all -> 0x01b3, blocks: (B:66:0x0182, B:17:0x0097, B:19:0x009f, B:21:0x00b3, B:23:0x00be, B:22:0x00b6), top: B:73:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6 A[Catch: Exception -> 0x0181, all -> 0x01b3, TryCatch #2 {all -> 0x01b3, blocks: (B:66:0x0182, B:17:0x0097, B:19:0x009f, B:21:0x00b3, B:23:0x00be, B:22:0x00b6), top: B:73:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ConcurrentMap concurrentMap;
        FileCacheStorage fileCacheStorage;
        String str;
        List<CachedResponseData> list;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Object $result2;
        CoroutineScope $this$coroutineScope;
        boolean z;
        File file;
        Closeable $this$use$iv;
        Closeable $this$use$iv2;
        Object $result3;
        boolean z2;
        Object owner$iv2;
        boolean z3;
        Long l;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope2 = (CoroutineScope) this.L$0;
                    concurrentMap = this.this$0.mutexes;
                    Mutex $this$withLock_u24default$iv2 = (Mutex) concurrentMap.computeIfAbsent(this.$urlHex, new Function0() { // from class: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Mutex invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = FileCacheStorage$writeCache$2.invokeSuspend$lambda$0();
                            return invokeSuspend$lambda$0;
                        }
                    });
                    fileCacheStorage = this.this$0;
                    str = this.$urlHex;
                    list = this.$caches;
                    this.L$0 = $this$coroutineScope2;
                    this.L$1 = $this$withLock_u24default$iv2;
                    this.L$2 = fileCacheStorage;
                    this.L$3 = str;
                    this.L$4 = list;
                    this.label = 1;
                    if ($this$withLock_u24default$iv2.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                    owner$iv = null;
                    $result2 = $result;
                    $this$coroutineScope = $this$coroutineScope2;
                    z = false;
                    boolean z4 = false;
                    ByteReadChannel byteChannel = new ByteChannel(false, 1, (DefaultConstructorMarker) null);
                    try {
                        file = fileCacheStorage.directory;
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
                        $this$use$iv = !(fileOutputStream instanceof BufferedOutputStream) ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE);
                        try {
                            BufferedOutputStream output = (BufferedOutputStream) $this$use$iv;
                            BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FileCacheStorage$writeCache$2$1$1$1(byteChannel, list, fileCacheStorage, null), 3, (Object) null);
                            ByteReadChannel byteReadChannel = byteChannel;
                            BufferedOutputStream bufferedOutputStream = output;
                            this.L$0 = $this$withLock_u24default$iv;
                            this.L$1 = $this$use$iv;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.I$0 = 0;
                            this.label = 2;
                        } catch (Throwable th) {
                            th = th;
                            $this$use$iv2 = $this$use$iv;
                        }
                        try {
                            $result3 = WritingKt.copyTo$default(byteReadChannel, bufferedOutputStream, 0L, this, 2, (Object) null);
                        } catch (Throwable th2) {
                            th = th2;
                            $this$use$iv2 = $this$use$iv;
                            Throwable cause$iv = th;
                            if ($this$use$iv2 != null) {
                            }
                            throw cause$iv;
                        }
                    } catch (Exception e2) {
                        cause = e2;
                        HttpCacheKt.getLOGGER().trace("Exception during saving a cache to a file: " + ExceptionsKt.stackTraceToString(cause));
                        l = Unit.INSTANCE;
                        owner$iv2 = owner$iv;
                        $this$withLock_u24default$iv.unlock(owner$iv2);
                        return l;
                    }
                    if ($result3 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = z;
                    owner$iv2 = owner$iv;
                    $this$use$iv2 = $this$use$iv;
                    z3 = false;
                    try {
                        l = Boxing.boxLong(((Number) $result3).longValue());
                        if ($this$use$iv2 != null) {
                            try {
                                $this$use$iv2.close();
                            } catch (Exception e3) {
                                cause = e3;
                                z = z2;
                                z4 = z3;
                                owner$iv = owner$iv2;
                                HttpCacheKt.getLOGGER().trace("Exception during saving a cache to a file: " + ExceptionsKt.stackTraceToString(cause));
                                l = Unit.INSTANCE;
                                owner$iv2 = owner$iv;
                                $this$withLock_u24default$iv.unlock(owner$iv2);
                                return l;
                            } catch (Throwable th3) {
                                th = th3;
                                Object owner$iv3 = owner$iv2;
                                $this$withLock_u24default$iv.unlock(owner$iv3);
                                throw th;
                            }
                        }
                        $this$withLock_u24default$iv.unlock(owner$iv2);
                        return l;
                    } catch (Throwable th4) {
                        th = th4;
                        Throwable cause$iv2 = th;
                        if ($this$use$iv2 != null) {
                            try {
                                $this$use$iv2.close();
                            }
                        }
                        throw cause$iv2;
                    }
                case 1:
                    list = (List) this.L$4;
                    str = (String) this.L$3;
                    fileCacheStorage = (FileCacheStorage) this.L$2;
                    ResultKt.throwOnFailure($result);
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) this.L$1;
                    $result2 = $result;
                    $this$coroutineScope = (CoroutineScope) this.L$0;
                    z = false;
                    boolean z42 = false;
                    ByteReadChannel byteChannel2 = new ByteChannel(false, 1, (DefaultConstructorMarker) null);
                    file = fileCacheStorage.directory;
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str));
                    $this$use$iv = !(fileOutputStream2 instanceof BufferedOutputStream) ? (BufferedOutputStream) fileOutputStream2 : new BufferedOutputStream(fileOutputStream2, GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE);
                    BufferedOutputStream output2 = (BufferedOutputStream) $this$use$iv;
                    BuildersKt.launch$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FileCacheStorage$writeCache$2$1$1$1(byteChannel2, list, fileCacheStorage, null), 3, (Object) null);
                    ByteReadChannel byteReadChannel2 = byteChannel2;
                    BufferedOutputStream bufferedOutputStream2 = output2;
                    this.L$0 = $this$withLock_u24default$iv;
                    this.L$1 = $this$use$iv;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.I$0 = 0;
                    this.label = 2;
                    $result3 = WritingKt.copyTo$default(byteReadChannel2, bufferedOutputStream2, 0L, this, 2, (Object) null);
                    if ($result3 != coroutine_suspended) {
                    }
                    break;
                case 2:
                    $result3 = $result;
                    z2 = false;
                    z3 = false;
                    int i2 = this.I$0;
                    $this$use$iv2 = (Closeable) this.L$1;
                    owner$iv2 = null;
                    Mutex $this$withLock_u24default$iv3 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result3);
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                        $result2 = $result3;
                        l = Boxing.boxLong(((Number) $result3).longValue());
                        if ($this$use$iv2 != null) {
                        }
                        $this$withLock_u24default$iv.unlock(owner$iv2);
                        return l;
                    } catch (Throwable th5) {
                        th = th5;
                        Throwable cause$iv22 = th;
                        if ($this$use$iv2 != null) {
                        }
                        throw cause$iv22;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex invokeSuspend$lambda$0() {
        return MutexKt.Mutex$default(false, 1, (Object) null);
    }
}