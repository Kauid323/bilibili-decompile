package kntr.app.tribee.publish;

import androidx.compose.runtime.MutableState;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextAction;
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
/* compiled from: TribeePublishPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishPageKt$TribeePublishPage$2$1$7$1$1", f = "TribeePublishPage.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishPageKt$TribeePublishPage$2$1$7$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TribeePublishContent $content;
    final /* synthetic */ MutableState<Boolean> $needFocusTitle$delegate;
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    final /* synthetic */ MutableState<Boolean> $showSettingPanel$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeePublishPageKt$TribeePublishPage$2$1$7$1$1(TribeePublishContent tribeePublishContent, Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super TribeePublishPageKt$TribeePublishPage$2$1$7$1$1> continuation) {
        super(2, continuation);
        this.$content = tribeePublishContent;
        this.$onAction = function2;
        this.$showSettingPanel$delegate = mutableState;
        this.$needFocusTitle$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishPageKt$TribeePublishPage$2$1$7$1$1(this.$content, this.$onAction, this.$showSettingPanel$delegate, this.$needFocusTitle$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeePublishPageKt.TribeePublishPage$lambda$5(this.$showSettingPanel$delegate, false);
                if (this.$content.getContent().getCurrentFocus() == -1) {
                    TribeePublishPageKt.TribeePublishPage$lambda$7$0$3(this.$needFocusTitle$delegate, true);
                    break;
                } else {
                    Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2 = this.$onAction;
                    TribeePublishAction.ContentAction contentAction = new TribeePublishAction.ContentAction(RichTextAction.RetryFocusOn.INSTANCE);
                    this.label = 1;
                    if (function2.invoke(contentAction, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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