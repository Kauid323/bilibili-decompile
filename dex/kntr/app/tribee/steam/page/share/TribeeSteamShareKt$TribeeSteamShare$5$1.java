package kntr.app.tribee.steam.page.share;

import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ui.ShareMenuEffect;
import kntr.common.share.common.ui.ShareMenuVM;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamShare.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.page.share.TribeeSteamShareKt$TribeeSteamShare$5$1", f = "TribeeSteamShare.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSteamShareKt$TribeeSteamShare$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<TribeeSteamUIAction, Unit> $onUIAction;
    final /* synthetic */ ShareMenuVM $shareVM;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeSteamShareKt$TribeeSteamShare$5$1(ShareMenuVM shareMenuVM, Function1<? super TribeeSteamUIAction, Unit> function1, Continuation<? super TribeeSteamShareKt$TribeeSteamShare$5$1> continuation) {
        super(2, continuation);
        this.$shareVM = shareMenuVM;
        this.$onUIAction = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSteamShareKt$TribeeSteamShare$5$1(this.$shareVM, this.$onUIAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<ShareMenuEffect> effect = this.$shareVM.getEffect();
                final Function1<TribeeSteamUIAction, Unit> function1 = this.$onUIAction;
                this.label = 1;
                if (effect.collect(new FlowCollector() { // from class: kntr.app.tribee.steam.page.share.TribeeSteamShareKt$TribeeSteamShare$5$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((ShareMenuEffect) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(ShareMenuEffect it, Continuation<? super Unit> continuation) {
                        if (!(it instanceof ShareMenuEffect.ShowToast)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        String message = ((ShareMenuEffect.ShowToast) it).getMessage();
                        if (StringsKt.isBlank(message)) {
                            message = null;
                        }
                        if (message != null) {
                            function1.invoke(new TribeeSteamUIAction.ToastTips(TribeeToast.Companion.create(message), null, 2, null));
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}