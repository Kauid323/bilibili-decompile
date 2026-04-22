package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectTribeeList.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeListItem$3$1", f = "SelectTribeeList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SelectTribeeListKt$SelectTribeeListItem$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Long, String, Unit> $onItemExposure;
    final /* synthetic */ SelectableTribeeItem $tribeeItem;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectTribeeListKt$SelectTribeeListItem$3$1(Function2<? super Long, ? super String, Unit> function2, SelectableTribeeItem selectableTribeeItem, Continuation<? super SelectTribeeListKt$SelectTribeeListItem$3$1> continuation) {
        super(2, continuation);
        this.$onItemExposure = function2;
        this.$tribeeItem = selectableTribeeItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SelectTribeeListKt$SelectTribeeListItem$3$1(this.$onItemExposure, this.$tribeeItem, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<Long, String, Unit> function2 = this.$onItemExposure;
                if (function2 != null) {
                    function2.invoke(Boxing.boxLong(this.$tribeeItem.getId()), this.$tribeeItem.getName());
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}