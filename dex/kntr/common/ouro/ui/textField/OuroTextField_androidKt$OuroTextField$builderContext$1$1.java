package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroTextField.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class OuroTextField_androidKt$OuroTextField$builderContext$1$1 extends FunctionReferenceImpl implements Function1<OuroAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroTextField_androidKt$OuroTextField$builderContext$1$1(Object obj) {
        super(1, obj, OuroStore.class, "dispatch", "dispatch(Lkntr/common/ouro/core/action/OuroAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((OuroAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(OuroAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((OuroStore) this.receiver).dispatch(p0);
    }
}