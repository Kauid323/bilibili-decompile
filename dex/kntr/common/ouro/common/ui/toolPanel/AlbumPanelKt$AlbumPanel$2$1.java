package kntr.common.ouro.common.ui.toolPanel;

import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageAction;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlbumPanel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$AlbumPanel$2$1", f = "AlbumPanel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AlbumPanelKt$AlbumPanel$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<OuroAction, Unit>> $handleOnAction$delegate;
    final /* synthetic */ State<Function0<Unit>> $handleOnDismiss$delegate;
    final /* synthetic */ AphroState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumPanelKt$AlbumPanel$2$1(AphroState aphroState, State<? extends Function1<? super OuroAction, Unit>> state, State<? extends Function0<Unit>> state2, Continuation<? super AlbumPanelKt$AlbumPanel$2$1> continuation) {
        super(2, continuation);
        this.$state = aphroState;
        this.$handleOnAction$delegate = state;
        this.$handleOnDismiss$delegate = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumPanelKt$AlbumPanel$2$1(this.$state, this.$handleOnAction$delegate, this.$handleOnDismiss$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function1 AlbumPanel$lambda$1;
        Function0 AlbumPanel$lambda$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((AphroState.AphroContent) this.$state).getConfirmed()) {
                    AlbumPanel$lambda$1 = AlbumPanelKt.AlbumPanel$lambda$1(this.$handleOnAction$delegate);
                    AlbumPanel$lambda$1.invoke(new OuroLocalImageAction.InsertBlockImage(((AphroState.AphroContent) this.$state).getCurrentSelected(), ((AphroState.AphroContent) this.$state).getUseOriginImage(), false, 4, null));
                    AlbumPanel$lambda$2 = AlbumPanelKt.AlbumPanel$lambda$2(this.$handleOnDismiss$delegate);
                    AlbumPanel$lambda$2.invoke();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}