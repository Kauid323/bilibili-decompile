package kntr.common.ouro.ui.textField;

import android.view.View;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroEditText.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroEditText$setupKeyboardCallback$1$2 implements View.OnFocusChangeListener {
    final /* synthetic */ Function1<Boolean, Unit> $onKeyboardShow;
    final /* synthetic */ OuroEditText this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public OuroEditText$setupKeyboardCallback$1$2(Function1<? super Boolean, Unit> function1, OuroEditText ouroEditText) {
        this.$onKeyboardShow = function1;
        this.this$0 = ouroEditText;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean hasFocus) {
        if (!hasFocus) {
            this.$onKeyboardShow.invoke(false);
        } else {
            this.$onKeyboardShow.invoke(Boolean.valueOf(OuroEditText.isImeActive$default(this.this$0, null, 1, null)));
        }
    }
}