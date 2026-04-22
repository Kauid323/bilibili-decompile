package kntr.common.photonic.aphro.core.assets;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AphroAssetsStateMachine.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lkntr/common/photonic/Asset;", "accumulated", "page"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.assets.AphroAssetsStateMachine$initLoad$2$1$allAssets$2", f = "AphroAssetsStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AphroAssetsStateMachine$initLoad$2$1$allAssets$2 extends SuspendLambda implements Function3<List<? extends Asset>, List<? extends Asset>, Continuation<? super List<? extends Asset>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AphroAssetsStateMachine$initLoad$2$1$allAssets$2(Continuation<? super AphroAssetsStateMachine$initLoad$2$1$allAssets$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<? extends Asset> list, List<? extends Asset> list2, Continuation<? super List<? extends Asset>> continuation) {
        AphroAssetsStateMachine$initLoad$2$1$allAssets$2 aphroAssetsStateMachine$initLoad$2$1$allAssets$2 = new AphroAssetsStateMachine$initLoad$2$1$allAssets$2(continuation);
        aphroAssetsStateMachine$initLoad$2$1$allAssets$2.L$0 = list;
        aphroAssetsStateMachine$initLoad$2$1$allAssets$2.L$1 = list2;
        return aphroAssetsStateMachine$initLoad$2$1$allAssets$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List accumulated = (List) this.L$0;
        List page = (List) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return CollectionsKt.plus(accumulated, page);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}