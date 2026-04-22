package tv.danmaku.bili.ui.offline.api;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import com.bapis.bilibili.app.viewunite.v1.CachePlayAv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import tv.danmaku.bili.ui.offline.api.OfflineServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineServiceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Ltv/danmaku/bili/ui/offline/api/OfflineServiceManager$VideoVerifyResult;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.api.OfflineServiceManager$videoVerifyReqCatching$2", f = "OfflineServiceManager.kt", i = {}, l = {DynModuleType.module_manga_collection_VALUE, 50}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineServiceManager$videoVerifyReqCatching$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends OfflineServiceManager.VideoVerifyResult>>, Object> {
    final /* synthetic */ List<Long> $avList;
    final /* synthetic */ int $limit;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineServiceManager$videoVerifyReqCatching$2(int i, List<Long> list, Continuation<? super OfflineServiceManager$videoVerifyReqCatching$2> continuation) {
        super(1, continuation);
        this.$limit = i;
        this.$avList = list;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OfflineServiceManager$videoVerifyReqCatching$2(this.$limit, this.$avList, continuation);
    }

    public final Object invoke(Continuation<? super List<OfflineServiceManager.VideoVerifyResult>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$limit > 0) {
                    List reqAvList = CollectionsKt.chunked(this.$avList, this.$limit, new Function1() { // from class: tv.danmaku.bili.ui.offline.api.OfflineServiceManager$videoVerifyReqCatching$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            List invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = OfflineServiceManager$videoVerifyReqCatching$2.invokeSuspend$lambda$0((List) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                    this.label = 1;
                    Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(reqAvList, null), (Continuation) this);
                    if (coroutineScope == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = coroutineScope;
                    this.label = 2;
                    $result = AwaitKt.awaitAll((Collection) $result, (Continuation) this);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return CollectionsKt.filterNotNull(CollectionsKt.flatten((Iterable) $result));
                }
                throw new IllegalArgumentException("limit must positive");
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                $result = AwaitKt.awaitAll((Collection) $result, (Continuation) this);
                if ($result == coroutine_suspended) {
                }
                return CollectionsKt.filterNotNull(CollectionsKt.flatten((Iterable) $result));
            case 2:
                ResultKt.throwOnFailure($result);
                return CollectionsKt.filterNotNull(CollectionsKt.flatten((Iterable) $result));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$0(List batch) {
        List $this$map$iv = batch;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            long id = ((Number) item$iv$iv).longValue();
            destination$iv$iv.add(CachePlayAv.newBuilder().setAid(id).build());
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OfflineServiceManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/Deferred;", "Ltv/danmaku/bili/ui/offline/api/OfflineServiceManager$VideoVerifyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.offline.api.OfflineServiceManager$videoVerifyReqCatching$2$1", f = "OfflineServiceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.offline.api.OfflineServiceManager$videoVerifyReqCatching$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Deferred<? extends List<? extends OfflineServiceManager.VideoVerifyResult>>>>, Object> {
        final /* synthetic */ List<List<CachePlayAv>> $reqAvList;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends List<CachePlayAv>> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$reqAvList = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$reqAvList, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Deferred<? extends List<OfflineServiceManager.VideoVerifyResult>>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    Iterable $this$map$iv = this.$reqAvList;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        List cachePlayAvs = (List) item$iv$iv;
                        destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new OfflineServiceManager$videoVerifyReqCatching$2$1$1$1(cachePlayAvs, null), 3, (Object) null));
                    }
                    return (List) destination$iv$iv;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}