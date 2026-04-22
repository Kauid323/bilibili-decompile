package kntr.app.tribee.publish.internal;

import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeTitle.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.internal.TribeeTitleKt$TribeeTitle$2$1$titleCompose$1$inputTransformation$1$1$2", f = "TribeeTitle.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeTitleKt$TribeeTitle$2$1$titleCompose$1$inputTransformation$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    final /* synthetic */ String $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeTitleKt$TribeeTitle$2$1$titleCompose$1$inputTransformation$1$1$2(Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, String str, Continuation<? super TribeeTitleKt$TribeeTitle$2$1$titleCompose$1$inputTransformation$1$1$2> continuation) {
        super(2, continuation);
        this.$onAction = function2;
        this.$result = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeTitleKt$TribeeTitle$2$1$titleCompose$1$inputTransformation$1$1$2(this.$onAction, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2 = this.$onAction;
                TribeePublishAction.TitleChanged titleChanged = new TribeePublishAction.TitleChanged(this.$result);
                this.label = 1;
                if (function2.invoke(titleChanged, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}