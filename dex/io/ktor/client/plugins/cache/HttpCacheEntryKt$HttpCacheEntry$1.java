package io.ktor.client.plugins.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCacheEntry.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheEntryKt", f = "HttpCacheEntry.kt", i = {0, 0}, l = {18}, m = "HttpCacheEntry", n = {"response", "isShared"}, s = {"L$0", "Z$0"})
public final class HttpCacheEntryKt$HttpCacheEntry$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCacheEntryKt$HttpCacheEntry$1(Continuation<? super HttpCacheEntryKt$HttpCacheEntry$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCacheEntryKt.HttpCacheEntry(false, null, (Continuation) this);
    }
}