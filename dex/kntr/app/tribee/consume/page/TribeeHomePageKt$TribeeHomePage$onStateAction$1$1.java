package kntr.app.tribee.consume.page;

import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class TribeeHomePageKt$TribeeHomePage$onStateAction$1$1 extends FunctionReferenceImpl implements Function1<TribeeHomeStateAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeHomePageKt$TribeeHomePage$onStateAction$1$1(Object obj) {
        super(1, obj, TribeeHomeViewModel.class, "dispatch", "dispatch(Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TribeeHomeStateAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TribeeHomeStateAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((TribeeHomeViewModel) this.receiver).dispatch(p0);
    }
}