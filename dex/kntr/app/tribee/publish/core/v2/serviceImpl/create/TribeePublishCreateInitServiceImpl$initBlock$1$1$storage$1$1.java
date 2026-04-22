package kntr.app.tribee.publish.core.v2.serviceImpl.create;

import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuronKt;
import kntr.base.neuron.KNeuron;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.Path;

/* compiled from: TribeePublishCreateInitServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeePublishCreateInitServiceImpl$initBlock$1$1$storage$1$1", f = "TribeePublishCreateInitServiceImpl.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeePublishCreateInitServiceImpl$initBlock$1$1$storage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Exception $e;
    int label;
    final /* synthetic */ TribeePublishCreateInitServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishCreateInitServiceImpl$initBlock$1$1$storage$1$1(TribeePublishCreateInitServiceImpl tribeePublishCreateInitServiceImpl, Exception exc, Continuation<? super TribeePublishCreateInitServiceImpl$initBlock$1$1$storage$1$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeePublishCreateInitServiceImpl;
        this.$e = exc;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishCreateInitServiceImpl$initBlock$1$1$storage$1$1(this.this$0, this.$e, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeePublishDraftService tribeePublishDraftService;
        TribeeInfo tribeeInfo;
        Object moveBakDraft;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                tribeePublishDraftService = this.this$0.draftService;
                tribeeInfo = this.this$0.tribeeInfo;
                this.label = 1;
                moveBakDraft = tribeePublishDraftService.moveBakDraft(tribeeInfo, (Continuation) this);
                if (moveBakDraft == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                moveBakDraft = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Path path = (Path) moveBakDraft;
        if (path != null) {
            IPlatformNeuronKt.trackT(KNeuron.INSTANCE, true, "tribee.publish_v2.init.exception", MapsKt.mapOf(new Pair[]{TuplesKt.to("path", path.toString()), TuplesKt.to("exception", this.$e.getMessage())}), new Function0() { // from class: kntr.app.tribee.publish.core.v2.serviceImpl.create.TribeePublishCreateInitServiceImpl$initBlock$1$1$storage$1$1$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = TribeePublishCreateInitServiceImpl$initBlock$1$1$storage$1$1.invokeSuspend$lambda$0();
                    return Boolean.valueOf(invokeSuspend$lambda$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0() {
        return true;
    }
}