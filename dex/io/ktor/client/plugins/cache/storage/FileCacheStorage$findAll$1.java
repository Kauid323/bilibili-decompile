package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCacheStorage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {}, l = {77}, m = "findAll", n = {}, s = {})
public final class FileCacheStorage$findAll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$findAll$1(FileCacheStorage fileCacheStorage, Continuation<? super FileCacheStorage$findAll$1> continuation) {
        super(continuation);
        this.this$0 = fileCacheStorage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.findAll(null, (Continuation) this);
    }
}