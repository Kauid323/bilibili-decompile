package io.ktor.client.plugins.cache.storage;

import im.setting.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCacheStorage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.HttpCacheStorageKt", f = "HttpCacheStorage.kt", i = {0, 0, 0, 0, 0, 1}, l = {119, 131}, m = "store", n = {"$this$store", "response", "varyKeys", "url", "isShared", UtilsKt.DATA_KEY}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0"})
public final class HttpCacheStorageKt$store$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCacheStorageKt$store$3(Continuation<? super HttpCacheStorageKt$store$3> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCacheStorageKt.store((CacheStorage) null, (HttpResponse) null, (Map<String, String>) null, false, (Continuation<? super CachedResponseData>) this);
    }
}