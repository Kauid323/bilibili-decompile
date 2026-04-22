package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroComposeTextField.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1", f = "OuroComposeTextField.kt", i = {0, 0, 1, 1}, l = {226, 228}, m = "interceptStartInputMethod", n = {"req", "handler", "req", "handler"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1(OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1 ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1, Continuation<? super OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1> continuation) {
        super(continuation);
        this.this$0 = ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.interceptStartInputMethod(null, null, (Continuation) this);
    }
}