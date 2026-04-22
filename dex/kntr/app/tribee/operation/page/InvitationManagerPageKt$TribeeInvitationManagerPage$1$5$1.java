package kntr.app.tribee.operation.page;

import kntr.app.tribee.operation.viewmodel.TribeeOperationStateAction;
import kntr.app.tribee.operation.viewmodel.TribeeOperationViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvitationManagerPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class InvitationManagerPageKt$TribeeInvitationManagerPage$1$5$1 extends FunctionReferenceImpl implements Function1<TribeeOperationStateAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationManagerPageKt$TribeeInvitationManagerPage$1$5$1(Object obj) {
        super(1, obj, TribeeOperationViewModel.class, "dispatch", "dispatch(Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TribeeOperationStateAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TribeeOperationStateAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((TribeeOperationViewModel) this.receiver).dispatch(p0);
    }
}