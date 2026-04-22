package kntr.common.ouro.ui.textField;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroEditText.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroEditText$setupKeyboardCallback$1$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ Function1<Boolean, Unit> $onKeyboardShow;
    final /* synthetic */ OuroEditText this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public OuroEditText$setupKeyboardCallback$1$1(Function1<? super Boolean, Unit> function1, OuroEditText ouroEditText) {
        this.$onKeyboardShow = function1;
        this.this$0 = ouroEditText;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
        boolean isImeActive;
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Function1<Boolean, Unit> function1 = this.$onKeyboardShow;
        isImeActive = this.this$0.isImeActive(insets);
        function1.invoke(Boolean.valueOf(isImeActive));
        return insets;
    }
}