package video.biz.offline.list.logic.utils;

import com.bilibili.ktor.KApiResponse;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.EpAuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineAuthApi.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/bilibili/ktor/KApiResponse;", "Lvideo/biz/offline/list/logic/model/EpAuthResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.OfflineAuthApiKt$epAuthWithLimit$2", f = "OfflineAuthApi.kt", i = {0}, l = {118}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
public final class OfflineAuthApiKt$epAuthWithLimit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends KApiResponse<? extends EpAuthResult>>>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ List<EpisodeParam> $offlineList;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineAuthApiKt$epAuthWithLimit$2(List<EpisodeParam> list, int i, Continuation<? super OfflineAuthApiKt$epAuthWithLimit$2> continuation) {
        super(2, continuation);
        this.$offlineList = list;
        this.$limit = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> offlineAuthApiKt$epAuthWithLimit$2 = new OfflineAuthApiKt$epAuthWithLimit$2(this.$offlineList, this.$limit, continuation);
        offlineAuthApiKt$epAuthWithLimit$2.L$0 = obj;
        return offlineAuthApiKt$epAuthWithLimit$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends KApiResponse<EpAuthResult>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = CollectionsKt.chunked(this.$offlineList, this.$limit);
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    List batch = (List) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new OfflineAuthApiKt$epAuthWithLimit$2$1$1(batch, null), 3, (Object) null));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.label = 1;
                Object awaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return awaitAll;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}