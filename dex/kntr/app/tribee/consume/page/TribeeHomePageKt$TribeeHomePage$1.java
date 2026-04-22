package kntr.app.tribee.consume.page;

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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomePage$1", f = "TribeeHomePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomePageKt$TribeeHomePage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromSpmid;
    final /* synthetic */ Ref.ObjectRef<Long> $homeId;
    final /* synthetic */ PvEventTrigger $pvTrigger;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomePageKt$TribeeHomePage$1(PvEventTrigger pvEventTrigger, Ref.ObjectRef<Long> objectRef, String str, Continuation<? super TribeeHomePageKt$TribeeHomePage$1> continuation) {
        super(2, continuation);
        this.$pvTrigger = pvEventTrigger;
        this.$homeId = objectRef;
        this.$fromSpmid = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeHomePageKt$TribeeHomePage$1(this.$pvTrigger, this.$homeId, this.$fromSpmid, continuation);
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
                pairArr[0] = TuplesKt.to("tribee_id", String.valueOf(((Number) this.$homeId.element).longValue()));
                String str = this.$fromSpmid;
                if (str == null) {
                    str = "";
                }
                pairArr[1] = TuplesKt.to("from_spmid", str);
                PvEventTriggerKt.updateExtra(pvEventTrigger, pairArr);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}