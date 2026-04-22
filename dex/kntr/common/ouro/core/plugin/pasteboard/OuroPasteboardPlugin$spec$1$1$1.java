package kntr.common.ouro.core.plugin.pasteboard;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroPasteboardPlugin.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Lkntr/common/ouro/core/plugin/pasteboard/OuroCopyAction;", "state", "Lkntr/common/ouro/core/OuroState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$spec$1$1$1", f = "OuroPasteboardPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroPasteboardPlugin$spec$1$1$1 extends SuspendLambda implements Function3<OuroCopyAction, OuroState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OuroPasteboardPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroPasteboardPlugin$spec$1$1$1(OuroPasteboardPlugin ouroPasteboardPlugin, Continuation<? super OuroPasteboardPlugin$spec$1$1$1> continuation) {
        super(3, continuation);
        this.this$0 = ouroPasteboardPlugin;
    }

    public final Object invoke(OuroCopyAction ouroCopyAction, OuroState ouroState, Continuation<? super Unit> continuation) {
        OuroPasteboardPlugin$spec$1$1$1 ouroPasteboardPlugin$spec$1$1$1 = new OuroPasteboardPlugin$spec$1$1$1(this.this$0, continuation);
        ouroPasteboardPlugin$spec$1$1$1.L$0 = ouroCopyAction;
        ouroPasteboardPlugin$spec$1$1$1.L$1 = ouroState;
        return ouroPasteboardPlugin$spec$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OuroCopyAction action = (OuroCopyAction) this.L$0;
        OuroState state = (OuroState) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.handleCopyAction(action, state);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}