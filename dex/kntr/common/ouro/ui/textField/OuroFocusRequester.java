package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: OuroNativeTextField.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0006J\u001a\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eR(\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRR\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lkntr/common/ouro/ui/textField/OuroFocusRequester;", "", "<init>", "()V", "_requestFocus", "Lkotlin/Function0;", "", "get_requestFocus$ui_debug$annotations", "get_requestFocus$ui_debug", "()Lkotlin/jvm/functions/Function0;", "set_requestFocus$ui_debug", "(Lkotlin/jvm/functions/Function0;)V", "_freeFocus", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "forced", "keepSelection", "get_freeFocus$ui_debug$annotations", "get_freeFocus$ui_debug", "()Lkotlin/jvm/functions/Function2;", "set_freeFocus$ui_debug", "(Lkotlin/jvm/functions/Function2;)V", "requestFocus", "freeFocus", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroFocusRequester {
    public static final int $stable = 8;
    private Function2<? super Boolean, ? super Boolean, Unit> _freeFocus;
    private Function0<Unit> _requestFocus;

    public static /* synthetic */ void get_freeFocus$ui_debug$annotations() {
    }

    public static /* synthetic */ void get_requestFocus$ui_debug$annotations() {
    }

    public final Function0<Unit> get_requestFocus$ui_debug() {
        return this._requestFocus;
    }

    public final void set_requestFocus$ui_debug(Function0<Unit> function0) {
        this._requestFocus = function0;
    }

    public final Function2<Boolean, Boolean, Unit> get_freeFocus$ui_debug() {
        return this._freeFocus;
    }

    public final void set_freeFocus$ui_debug(Function2<? super Boolean, ? super Boolean, Unit> function2) {
        this._freeFocus = function2;
    }

    public final void requestFocus() {
        Function0<Unit> function0 = this._requestFocus;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void freeFocus$default(OuroFocusRequester ouroFocusRequester, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        ouroFocusRequester.freeFocus(z, z2);
    }

    public final void freeFocus(boolean forced, boolean keepSelection) {
        Function2<? super Boolean, ? super Boolean, Unit> function2 = this._freeFocus;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(forced), Boolean.valueOf(keepSelection));
        }
    }
}