package kntr.app.tribee.steam.page.share;

import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ui.ShareMenuViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSteamShare.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.steam.page.share.TribeeSteamShareKt$TribeeSteamShare$6$1", f = "TribeeSteamShare.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSteamShareKt$TribeeSteamShare$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ State<ShareMenuViewState> $shareVMState$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSteamShareKt$TribeeSteamShare$6$1(Function0<Unit> function0, State<ShareMenuViewState> state, Continuation<? super TribeeSteamShareKt$TribeeSteamShare$6$1> continuation) {
        super(2, continuation);
        this.$onDismiss = function0;
        this.$shareVMState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSteamShareKt$TribeeSteamShare$6$1(this.$onDismiss, this.$shareVMState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ShareMenuViewState TribeeSteamShare$lambda$5;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeSteamShare$lambda$5 = TribeeSteamShareKt.TribeeSteamShare$lambda$5(this.$shareVMState$delegate);
                if (TribeeSteamShare$lambda$5.getSelectedChannel() != null) {
                    this.$onDismiss.invoke();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}