package kntr.app.tribee.repost.page;

import kntr.app.tribee.repost.action.TribeeRepostStateAction;
import kntr.app.tribee.repost.viewmodel.TribeeRepostViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeRepostPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final /* synthetic */ class TribeeRepostPageKt$TribeeRepostPage$onStateAction$1$1 extends FunctionReferenceImpl implements Function1<TribeeRepostStateAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeRepostPageKt$TribeeRepostPage$onStateAction$1$1(Object obj) {
        super(1, obj, TribeeRepostViewModel.class, "dispatch", "dispatch(Lkntr/app/tribee/repost/action/TribeeRepostStateAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TribeeRepostStateAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TribeeRepostStateAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((TribeeRepostViewModel) this.receiver).dispatch(p0);
    }
}