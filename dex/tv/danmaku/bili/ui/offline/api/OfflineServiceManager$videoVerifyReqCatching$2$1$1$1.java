package tv.danmaku.bili.ui.offline.api;

import com.bapis.bilibili.app.viewunite.v1.CachePlayAv;
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
import tv.danmaku.bili.ui.offline.api.OfflineServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineServiceManager.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Ltv/danmaku/bili/ui/offline/api/OfflineServiceManager$VideoVerifyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.api.OfflineServiceManager$videoVerifyReqCatching$2$1$1$1", f = "OfflineServiceManager.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineServiceManager$videoVerifyReqCatching$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends OfflineServiceManager.VideoVerifyResult>>, Object> {
    final /* synthetic */ List<CachePlayAv> $cachePlayAvs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineServiceManager$videoVerifyReqCatching$2$1$1$1(List<CachePlayAv> list, Continuation<? super OfflineServiceManager$videoVerifyReqCatching$2$1$1$1> continuation) {
        super(2, continuation);
        this.$cachePlayAvs = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineServiceManager$videoVerifyReqCatching$2$1$1$1(this.$cachePlayAvs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<OfflineServiceManager.VideoVerifyResult>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object tryAddVideoVerifyResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                tryAddVideoVerifyResult = OfflineServiceManager.INSTANCE.tryAddVideoVerifyResult(this.$cachePlayAvs, (Continuation) this);
                if (tryAddVideoVerifyResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return tryAddVideoVerifyResult;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}