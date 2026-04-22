package video.biz.offline.list.logic.statemachine;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.NeuronKt;
import video.biz.offline.base.infra.utils.OfflineNeuron;
import video.biz.offline.base.infra.utils.OfflineTrackType;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineHomePageStateMachine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineHomePageStateMachine$loadData$2", f = "OfflineHomePageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineHomePageStateMachine$loadData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ List<OfflineVideoEntity> $videos;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomePageStateMachine$loadData$2(long j, List<OfflineVideoEntity> list, Continuation<? super OfflineHomePageStateMachine$loadData$2> continuation) {
        super(2, continuation);
        this.$duration = j;
        this.$videos = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineHomePageStateMachine$loadData$2(this.$duration, this.$videos, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OfflineNeuron.Companion.trackT$default(OfflineNeuron.Companion, OfflineTrackType.LISTLOADINGCOST, MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, String.valueOf(this.$duration)), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(this.$videos.size()))}), null, 4, null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}