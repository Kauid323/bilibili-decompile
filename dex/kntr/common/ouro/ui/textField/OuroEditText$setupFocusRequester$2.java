package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroEditText.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class OuroEditText$setupFocusRequester$2 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroEditText$setupFocusRequester$2(Object obj) {
        super(0, obj, OuroEditText.class, "requestFocusImpl", "requestFocusImpl()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2105invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m2105invoke() {
        ((OuroEditText) this.receiver).requestFocusImpl();
    }
}