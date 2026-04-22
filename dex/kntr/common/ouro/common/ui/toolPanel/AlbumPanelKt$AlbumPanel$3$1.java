package kntr.common.ouro.common.ui.toolPanel;

import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataNotifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlbumPanel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$AlbumPanel$3$1", f = "AlbumPanel.kt", i = {0, 0}, l = {112}, m = "invokeSuspend", n = {"key", "$i$a$-let-AlbumPanelKt$AlbumPanel$3$1$1"}, s = {"L$0", "I$0"}, v = 1)
public final class AlbumPanelKt$AlbumPanel$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AphroViewModel $aphroViewModel;
    final /* synthetic */ MutableState<String> $selectResultMatchKey$delegate;
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumPanelKt$AlbumPanel$3$1(MutableState<String> mutableState, AphroViewModel aphroViewModel, Continuation<? super AlbumPanelKt$AlbumPanel$3$1> continuation) {
        super(2, continuation);
        this.$selectResultMatchKey$delegate = mutableState;
        this.$aphroViewModel = aphroViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumPanelKt$AlbumPanel$3$1(this.$selectResultMatchKey$delegate, this.$aphroViewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String key;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                key = AlbumPanelKt.AlbumPanel$lambda$8(this.$selectResultMatchKey$delegate);
                if (key != null) {
                    AphroViewModel aphroViewModel = this.$aphroViewModel;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(key);
                    this.I$0 = 0;
                    this.label = 1;
                    if (FlowKt.receiveAsFlow(ImagePreviewDataNotifier.INSTANCE.getPreviewSelectResultChannel(key)).collect(new AlbumPanelKt$AlbumPanel$3$1$1$1(aphroViewModel), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i = this.I$0;
                String str = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}