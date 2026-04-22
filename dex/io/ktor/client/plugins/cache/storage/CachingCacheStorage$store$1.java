package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCacheStorage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {37, 38}, m = "store", n = {"this", "url"}, s = {"L$0", "L$1"})
public final class CachingCacheStorage$store$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachingCacheStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachingCacheStorage$store$1(CachingCacheStorage cachingCacheStorage, Continuation<? super CachingCacheStorage$store$1> continuation) {
        super(continuation);
        this.this$0 = cachingCacheStorage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.store(null, null, (Continuation) this);
    }
}