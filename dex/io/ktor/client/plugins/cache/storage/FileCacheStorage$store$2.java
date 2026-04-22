package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2", f = "FileCacheStorage.kt", i = {0}, l = {72, 73}, m = "invokeSuspend", n = {"urlHex"}, s = {"L$0"})
final class FileCacheStorage$store$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CachedResponseData $data;
    final /* synthetic */ Url $url;
    Object L$0;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$store$2(FileCacheStorage fileCacheStorage, Url url, CachedResponseData cachedResponseData, Continuation<? super FileCacheStorage$store$2> continuation) {
        super(2, continuation);
        this.this$0 = fileCacheStorage;
        this.$url = url;
        this.$data = cachedResponseData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileCacheStorage$store$2(this.this$0, this.$url, this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String urlHex;
        Object readCache;
        Object $result2;
        String urlHex2;
        Object writeCache;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                urlHex = this.this$0.key(this.$url);
                this.L$0 = urlHex;
                this.label = 1;
                readCache = this.this$0.readCache(urlHex, (Continuation) this);
                if (readCache == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = readCache;
                urlHex2 = urlHex;
                Iterable $this$filterNotTo$iv$iv = (Iterable) $result;
                CachedResponseData cachedResponseData = this.$data;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNotTo$iv$iv) {
                    CachedResponseData it = (CachedResponseData) element$iv$iv;
                    if (!Intrinsics.areEqual(it.getVaryKeys(), cachedResponseData.getVaryKeys())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                List caches = CollectionsKt.plus((List) destination$iv$iv, this.$data);
                this.L$0 = null;
                this.label = 2;
                writeCache = this.this$0.writeCache(urlHex2, caches, (Continuation) this);
                return writeCache != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                urlHex2 = (String) this.L$0;
                $result2 = $result;
                Iterable $this$filterNotTo$iv$iv2 = (Iterable) $result;
                CachedResponseData cachedResponseData2 = this.$data;
                Collection destination$iv$iv2 = new ArrayList();
                while (r7.hasNext()) {
                }
                List caches2 = CollectionsKt.plus((List) destination$iv$iv2, this.$data);
                this.L$0 = null;
                this.label = 2;
                writeCache = this.this$0.writeCache(urlHex2, caches2, (Continuation) this);
                if (writeCache != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}