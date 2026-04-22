package kntr.common.photonic.aphro.core.assets;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroAssetsStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lkntr/common/photonic/Asset;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$allAssets$4", f = "AphroAssetsStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AphroAssetsStateMachine$initLoad$2$1$allAssets$4 extends SuspendLambda implements Function2<List<? extends Asset>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $count;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AphroAssetsStateMachine$initLoad$2$1$allAssets$4(Ref.IntRef intRef, Continuation<? super AphroAssetsStateMachine$initLoad$2$1$allAssets$4> continuation) {
        super(2, continuation);
        this.$count = intRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> aphroAssetsStateMachine$initLoad$2$1$allAssets$4 = new AphroAssetsStateMachine$initLoad$2$1$allAssets$4(this.$count, continuation);
        aphroAssetsStateMachine$initLoad$2$1$allAssets$4.L$0 = obj;
        return aphroAssetsStateMachine$initLoad$2$1$allAssets$4;
    }

    public final Object invoke(List<? extends Asset> list, Continuation<? super Unit> continuation) {
        return create(list, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List it = (List) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$count.element = it.size();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}