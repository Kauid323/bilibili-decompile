package video.biz.offline.list.logic.utils;

import com.bapis.bilibili.app.viewunite.v1.KCachePlayAv;
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
import video.biz.offline.list.logic.model.AvAuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineAuthApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lvideo/biz/offline/list/logic/model/AvAuthResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.OfflineAuthApiKt$avAuthWithLimit$2", f = "OfflineAuthApi.kt", i = {0}, l = {56}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
public final class OfflineAuthApiKt$avAuthWithLimit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AvAuthResult>>, Object> {
    final /* synthetic */ List<List<KCachePlayAv>> $reqList;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OfflineAuthApiKt$avAuthWithLimit$2(List<? extends List<KCachePlayAv>> list, Continuation<? super OfflineAuthApiKt$avAuthWithLimit$2> continuation) {
        super(2, continuation);
        this.$reqList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> offlineAuthApiKt$avAuthWithLimit$2 = new OfflineAuthApiKt$avAuthWithLimit$2(this.$reqList, continuation);
        offlineAuthApiKt$avAuthWithLimit$2.L$0 = obj;
        return offlineAuthApiKt$avAuthWithLimit$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<AvAuthResult>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object awaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$reqList;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    List cachePlayAvs = (List) item$iv$iv;
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new OfflineAuthApiKt$avAuthWithLimit$2$1$1(cachePlayAvs, null), 3, (Object) null));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.label = 1;
                awaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                awaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CollectionsKt.flatten((Iterable) awaitAll);
    }
}