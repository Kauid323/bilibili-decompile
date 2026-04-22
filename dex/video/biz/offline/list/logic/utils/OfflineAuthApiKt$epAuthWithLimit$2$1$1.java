package video.biz.offline.list.logic.utils;

import com.bilibili.ktor.KApiResponse;
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
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.EpAuthResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineAuthApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/ktor/KApiResponse;", "Lvideo/biz/offline/list/logic/model/EpAuthResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.OfflineAuthApiKt$epAuthWithLimit$2$1$1", f = "OfflineAuthApi.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineAuthApiKt$epAuthWithLimit$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KApiResponse<? extends EpAuthResult>>, Object> {
    final /* synthetic */ List<EpisodeParam> $batch;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineAuthApiKt$epAuthWithLimit$2$1$1(List<EpisodeParam> list, Continuation<? super OfflineAuthApiKt$epAuthWithLimit$2$1$1> continuation) {
        super(2, continuation);
        this.$batch = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineAuthApiKt$epAuthWithLimit$2$1$1(this.$batch, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KApiResponse<EpAuthResult>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object epAuth = OfflineAuthApiKt.epAuth(this.$batch, (Continuation) this);
                if (epAuth == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return epAuth;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}