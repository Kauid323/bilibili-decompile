package io.ktor.client.plugins.cache;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCacheLegacy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheLegacyKt", f = "HttpCacheLegacy.kt", i = {0}, l = {62, TraceLevel.ALL, 72}, m = "interceptReceiveLegacy", n = {"$this$interceptReceiveLegacy"}, s = {"L$0"})
public final class HttpCacheLegacyKt$interceptReceiveLegacy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCacheLegacyKt$interceptReceiveLegacy$1(Continuation<? super HttpCacheLegacyKt$interceptReceiveLegacy$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCacheLegacyKt.interceptReceiveLegacy(null, null, null, null, (Continuation) this);
    }
}