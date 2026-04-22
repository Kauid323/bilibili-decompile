package kntr.common.ouro.ui.textField;

import android.text.Editable;
import android.text.Spannable;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroTextRange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroTextField.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.textField.OuroTextField_androidKt$OuroTextField$5$1", f = "OuroTextField.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OuroTextField_androidKt$OuroTextField$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Density $density;
    final /* synthetic */ OuroEditText $editText;
    final /* synthetic */ Spannable $spannableString;
    final /* synthetic */ OuroTextRange $toSelection;
    final /* synthetic */ float $visibleBottom;
    final /* synthetic */ MutableState<Dp> $visibleTop$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroTextField_androidKt$OuroTextField$5$1(OuroEditText ouroEditText, Spannable spannable, OuroTextRange ouroTextRange, Density density, float f, MutableState<Dp> mutableState, Continuation<? super OuroTextField_androidKt$OuroTextField$5$1> continuation) {
        super(2, continuation);
        this.$editText = ouroEditText;
        this.$spannableString = spannable;
        this.$toSelection = ouroTextRange;
        this.$density = density;
        this.$visibleBottom = f;
        this.$visibleTop$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroTextField_androidKt$OuroTextField$5$1(this.$editText, this.$spannableString, this.$toSelection, this.$density, this.$visibleBottom, this.$visibleTop$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        float OuroTextField$lambda$8;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$editText == null) {
                    return Unit.INSTANCE;
                }
                this.$editText.beginBatchEdit();
                this.$editText.setTextFromOutside(this.$spannableString);
                if (this.$editText.getText() != null) {
                    OuroEditText ouroEditText = this.$editText;
                    int start = this.$toSelection.getStart();
                    Editable text = this.$editText.getText();
                    int coerceIn = RangesKt.coerceIn(start, 0, text != null ? text.length() : 0);
                    int end = this.$toSelection.getEnd();
                    Editable text2 = this.$editText.getText();
                    ouroEditText.setSelectionFromOutside(coerceIn, RangesKt.coerceIn(end, 0, text2 != null ? text2.length() : 0));
                }
                this.$editText.endBatchEdit();
                Density $this$invokeSuspend_u24lambda_u240 = this.$density;
                OuroEditText ouroEditText2 = this.$editText;
                float f = this.$visibleBottom;
                OuroTextField$lambda$8 = OuroTextField_androidKt.OuroTextField$lambda$8(this.$visibleTop$delegate);
                ouroEditText2.updateDrawableSpansVisibility$ui_debug($this$invokeSuspend_u24lambda_u240.roundToPx-0680j_4(OuroTextField$lambda$8), $this$invokeSuspend_u24lambda_u240.roundToPx-0680j_4(f));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}