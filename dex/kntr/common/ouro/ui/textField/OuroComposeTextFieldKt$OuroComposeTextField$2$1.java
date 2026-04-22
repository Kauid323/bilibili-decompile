package kntr.common.ouro.ui.textField;

import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroComposeTextField.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$2$1", f = "OuroComposeTextField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroComposeTextFieldKt$OuroComposeTextField$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<OuroState> $ouroState$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroComposeTextFieldKt$OuroComposeTextField$2$1(MutableState<OuroState> mutableState, Continuation<? super OuroComposeTextFieldKt$OuroComposeTextField$2$1> continuation) {
        super(2, continuation);
        this.$ouroState$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroComposeTextFieldKt$OuroComposeTextField$2$1(this.$ouroState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OuroState OuroComposeTextField$lambda$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OuroComposeTextField$lambda$1 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$1(this.$ouroState$delegate);
                Iterable allElements = OuroComposeTextField$lambda$1.getStorage().getAllSelectables();
                System.out.println((Object) "OuroTextField -----------allElements-----------");
                Iterable $this$forEachIndexed$iv = allElements;
                int idx = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv = idx + 1;
                    if (idx < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    OuroNode.Selectable element = (OuroNode.Selectable) item$iv;
                    System.out.println((Object) ("OuroTextField element [" + idx + "]: " + element));
                    idx = index$iv;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}