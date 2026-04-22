package io.ktor.client.plugins.cache.storage;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCacheStorage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {TbsListener.ErrorCode.APK_PATH_ERROR, TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, TbsListener.ErrorCode.DOWNLOAD_THROWABLE}, m = "readCache", n = {"this", "urlHex", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$use$iv", "channel", "closed$iv", "this", "$this$withLock_u24default$iv", "$this$use$iv", "channel", "caches", "closed$iv", "requestsCount", "i", "$this$withLock_u24default$iv", "$this$use$iv", "caches", "closed$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0"})
public final class FileCacheStorage$readCache$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$readCache$1(FileCacheStorage fileCacheStorage, Continuation<? super FileCacheStorage$readCache$1> continuation) {
        super(continuation);
        this.this$0 = fileCacheStorage;
    }

    public final Object invokeSuspend(Object obj) {
        Object readCache;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readCache = this.this$0.readCache((String) null, (Continuation) this);
        return readCache;
    }
}