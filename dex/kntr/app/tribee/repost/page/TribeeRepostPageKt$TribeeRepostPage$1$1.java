package kntr.app.tribee.repost.page;

import kntr.app.tribee.repost.track.TribeeRepostTrackKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvEventTriggerKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeRepostPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.page.TribeeRepostPageKt$TribeeRepostPage$1$1", f = "TribeeRepostPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeeRepostPageKt$TribeeRepostPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $originDynamicId;
    final /* synthetic */ PvEventTrigger $pvTrigger;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeRepostPageKt$TribeeRepostPage$1$1(PvEventTrigger pvEventTrigger, String str, Continuation<? super TribeeRepostPageKt$TribeeRepostPage$1$1> continuation) {
        super(2, continuation);
        this.$pvTrigger = pvEventTrigger;
        this.$originDynamicId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeRepostPageKt$TribeeRepostPage$1$1(this.$pvTrigger, this.$originDynamicId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PvEventTrigger pvEventTrigger = this.$pvTrigger;
                Pair[] pairArr = new Pair[2];
                String str = this.$originDynamicId;
                if (str == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("dynamic_id", str);
                pairArr[1] = TuplesKt.to("spmid", TribeeRepostTrackKt.TRIBEE_REPOST_PAGE_SPMID);
                PvEventTriggerKt.updateExtra(pvEventTrigger, pairArr);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}