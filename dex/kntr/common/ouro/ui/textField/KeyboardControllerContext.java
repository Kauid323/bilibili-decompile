package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: OuroNativeTextField.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lkntr/common/ouro/ui/textField/KeyboardControllerContext;", "", "<init>", "()V", "show", "Lkotlin/Function0;", "", "getShow", "()Lkotlin/jvm/functions/Function0;", "setShow", "(Lkotlin/jvm/functions/Function0;)V", "hide", "getHide", "setHide", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KeyboardControllerContext {
    public static final int $stable = 8;
    private Function0<Unit> hide;
    private Function0<Unit> show;

    public final Function0<Unit> getShow() {
        return this.show;
    }

    public final void setShow(Function0<Unit> function0) {
        this.show = function0;
    }

    public final Function0<Unit> getHide() {
        return this.hide;
    }

    public final void setHide(Function0<Unit> function0) {
        this.hide = function0;
    }
}