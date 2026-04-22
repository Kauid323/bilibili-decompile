package kntr.app.tribee.invite.viewmodel;

import kntr.app.tribee.invite.state.TribeeInviteState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: TribeeInviteViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/ITribeeInviteViewModel;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$annotations", "()V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lkntr/app/tribee/invite/state/TribeeInviteState;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiActionFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "getUiActionFlow$annotations", "getUiActionFlow", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", "", "action", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ITribeeInviteViewModel extends AutoCloseable {

    /* compiled from: TribeeInviteViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getScope$annotations() {
        }

        public static /* synthetic */ void getState$annotations() {
        }

        public static /* synthetic */ void getUiActionFlow$annotations() {
        }
    }

    void dispatch(TribeeInviteStateAction tribeeInviteStateAction);

    CoroutineScope getScope();

    StateFlow<TribeeInviteState> getState();

    Flow<TribeeInviteUIAction> getUiActionFlow();
}