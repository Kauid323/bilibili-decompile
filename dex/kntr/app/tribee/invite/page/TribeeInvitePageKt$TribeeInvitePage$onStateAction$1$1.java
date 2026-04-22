package kntr.app.tribee.invite.page;

import kntr.app.tribee.invite.viewmodel.TribeeInviteStateAction;
import kntr.app.tribee.invite.viewmodel.TribeeInviteViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInvitePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final /* synthetic */ class TribeeInvitePageKt$TribeeInvitePage$onStateAction$1$1 extends FunctionReferenceImpl implements Function1<TribeeInviteStateAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeInvitePageKt$TribeeInvitePage$onStateAction$1$1(Object obj) {
        super(1, obj, TribeeInviteViewModel.class, "dispatch", "dispatch(Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TribeeInviteStateAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TribeeInviteStateAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((TribeeInviteViewModel) this.receiver).dispatch(p0);
    }
}