package io.ktor.client.plugins.cache.storage;

import com.xiaomi.mipush.sdk.Constants;
import faceverify.q;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileCacheStorage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", i = {0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14}, l = {159, 160, 160, 161, 162, 165, 166, 169, 170, 171, 172, 175, 176, 180, 182}, m = "readCache", n = {"channel", "channel", "url", "channel", "url", "channel", "url", "status", "channel", "url", "status", Constants.VERSION, "channel", "url", "status", Constants.VERSION, "headers", "headersCount", "j", "channel", "url", "status", Constants.VERSION, "headers", q.KEY_RES_9_KEY, "headersCount", "j", "channel", "url", "status", Constants.VERSION, "headers", "channel", "url", "status", Constants.VERSION, "headers", "requestTime", "channel", "url", "status", Constants.VERSION, "headers", "requestTime", "responseTime", "channel", "url", "status", Constants.VERSION, "headers", "requestTime", "responseTime", "expirationTime", "channel", "url", "status", Constants.VERSION, "headers", "requestTime", "responseTime", "expirationTime", "$this$readCache_u24lambda_u245", "varyKeysCount", "j", "channel", "url", "status", Constants.VERSION, "headers", "requestTime", "responseTime", "expirationTime", "$this$readCache_u24lambda_u245", q.KEY_RES_9_KEY, "varyKeysCount", "j", "channel", "url", "status", Constants.VERSION, "headers", "requestTime", "responseTime", "expirationTime", "varyKeys", "url", "status", Constants.VERSION, "headers", "requestTime", "responseTime", "expirationTime", "varyKeys", "body"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
public final class FileCacheStorage$readCache$3 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$readCache$3(FileCacheStorage fileCacheStorage, Continuation<? super FileCacheStorage$readCache$3> continuation) {
        super(continuation);
        this.this$0 = fileCacheStorage;
    }

    public final Object invokeSuspend(Object obj) {
        Object readCache;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readCache = this.this$0.readCache((ByteReadChannel) null, (Continuation) this);
        return readCache;
    }
}