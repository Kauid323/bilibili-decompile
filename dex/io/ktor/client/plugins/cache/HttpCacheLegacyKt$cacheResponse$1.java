package io.ktor.client.plugins.cache;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCacheLegacy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheLegacyKt", f = "HttpCacheLegacy.kt", i = {}, l = {TbsListener.ErrorCode.NONEEDTODOWN_ERROR}, m = "cacheResponse", n = {}, s = {})
public final class HttpCacheLegacyKt$cacheResponse$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCacheLegacyKt$cacheResponse$1(Continuation<? super HttpCacheLegacyKt$cacheResponse$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object cacheResponse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        cacheResponse = HttpCacheLegacyKt.cacheResponse(null, null, (Continuation) this);
        return cacheResponse;
    }
}