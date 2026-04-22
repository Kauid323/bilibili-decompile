package kntr.app.tribee.consume.page;

import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: TribeeDetailCompose.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeDetailComposeKt$TribeeDynList$2$1", f = "TribeeDetailCompose.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeeDetailComposeKt$TribeeDynList$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ KTribeeCategory $category;
    final /* synthetic */ Function1<TribeeHomeStateAction, Unit> $onStateAction;
    final /* synthetic */ long $selectedCategoryId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeDetailComposeKt$TribeeDynList$2$1(KTribeeCategory kTribeeCategory, long j, Function1<? super TribeeHomeStateAction, Unit> function1, Continuation<? super TribeeDetailComposeKt$TribeeDynList$2$1> continuation) {
        super(1, continuation);
        this.$category = kTribeeCategory;
        this.$selectedCategoryId = j;
        this.$onStateAction = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TribeeDetailComposeKt$TribeeDynList$2$1(this.$category, this.$selectedCategoryId, this.$onStateAction, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$category.getId() == this.$selectedCategoryId) {
                    this.$onStateAction.invoke(new TribeeHomeStateAction.LoadMore(this.$selectedCategoryId));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}