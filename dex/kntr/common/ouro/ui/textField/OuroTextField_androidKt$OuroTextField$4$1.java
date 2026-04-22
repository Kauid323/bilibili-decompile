package kntr.common.ouro.ui.textField;

import android.view.View;
import androidx.compose.ui.unit.Density;
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
/* compiled from: OuroTextField.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.textField.OuroTextField_androidKt$OuroTextField$4$1", f = "OuroTextField.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroTextField_androidKt$OuroTextField$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $bottomPadding;
    final /* synthetic */ Density $density;
    final /* synthetic */ OuroEditText $editText;
    final /* synthetic */ float $topPadding;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroTextField_androidKt$OuroTextField$4$1(OuroEditText ouroEditText, Density density, float f, float f2, Continuation<? super OuroTextField_androidKt$OuroTextField$4$1> continuation) {
        super(2, continuation);
        this.$editText = ouroEditText;
        this.$density = density;
        this.$topPadding = f;
        this.$bottomPadding = f2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroTextField_androidKt$OuroTextField$4$1(this.$editText, this.$density, this.$topPadding, this.$bottomPadding, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$editText == null) {
                    return Unit.INSTANCE;
                }
                View $this$updatePadding_u24default$iv = (View) this.$editText;
                Density $this$invokeSuspend_u24lambda_u240 = this.$density;
                int top$iv = $this$invokeSuspend_u24lambda_u240.roundToPx-0680j_4(this.$topPadding);
                Density $this$invokeSuspend_u24lambda_u241 = this.$density;
                int bottom$iv = $this$invokeSuspend_u24lambda_u241.roundToPx-0680j_4(this.$bottomPadding);
                int left$iv = $this$updatePadding_u24default$iv.getPaddingLeft();
                int right$iv = $this$updatePadding_u24default$iv.getPaddingRight();
                $this$updatePadding_u24default$iv.setPadding(left$iv, top$iv, right$iv, bottom$iv);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}