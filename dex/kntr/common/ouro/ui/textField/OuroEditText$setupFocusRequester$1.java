package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroEditText.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class OuroEditText$setupFocusRequester$1 extends FunctionReferenceImpl implements Function2<Boolean, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroEditText$setupFocusRequester$1(Object obj) {
        super(2, obj, OuroEditText.class, "freeFocusImpl", "freeFocusImpl(ZZ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean p0, boolean p1) {
        ((OuroEditText) this.receiver).freeFocusImpl(p0, p1);
    }
}