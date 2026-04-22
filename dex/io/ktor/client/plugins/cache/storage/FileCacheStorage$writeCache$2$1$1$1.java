package io.ktor.client.plugins.cache.storage;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$1$1$1", f = "FileCacheStorage.kt", i = {}, l = {97, 99}, m = "invokeSuspend", n = {}, s = {})
final class FileCacheStorage$writeCache$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CachedResponseData> $caches;
    final /* synthetic */ ByteChannel $channel;
    Object L$0;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$writeCache$2$1$1$1(ByteChannel byteChannel, List<CachedResponseData> list, FileCacheStorage fileCacheStorage, Continuation<? super FileCacheStorage$writeCache$2$1$1$1> continuation) {
        super(2, continuation);
        this.$channel = byteChannel;
        this.$caches = list;
        this.this$0 = fileCacheStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileCacheStorage$writeCache$2$1$1$1(this.$channel, this.$caches, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Iterator<CachedResponseData> it;
        FileCacheStorage$writeCache$2$1$1$1 fileCacheStorage$writeCache$2$1$1$1;
        Object writeCache;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (ByteWriteChannelOperationsKt.writeInt(this.$channel, this.$caches.size(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = this.$caches.iterator();
                fileCacheStorage$writeCache$2$1$1$1 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                it = this.$caches.iterator();
                fileCacheStorage$writeCache$2$1$1$1 = this;
                break;
            case 2:
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure($result);
                fileCacheStorage$writeCache$2$1$1$1 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            CachedResponseData cache = it.next();
            fileCacheStorage$writeCache$2$1$1$1.L$0 = it;
            fileCacheStorage$writeCache$2$1$1$1.label = 2;
            writeCache = fileCacheStorage$writeCache$2$1$1$1.this$0.writeCache(fileCacheStorage$writeCache$2$1$1$1.$channel, cache, (Continuation) fileCacheStorage$writeCache$2$1$1$1);
            if (writeCache == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        fileCacheStorage$writeCache$2$1$1$1.$channel.close();
        return Unit.INSTANCE;
    }
}