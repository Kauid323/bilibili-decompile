package kntr.base.account.adapter;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: AccountStateNotifier.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/base/account/adapter/AccountStateNotifier;", "", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/account/adapter/AccountAdapterEvent;", "getEventFlow$annotations", "()V", "getEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentState", "Lkntr/base/account/AccountState;", "getCurrentState", "()Lkntr/base/account/AccountState;", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AccountStateNotifier {

    /* compiled from: AccountStateNotifier.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getEventFlow$annotations() {
        }
    }

    AccountState getCurrentState();

    Flow<AccountAdapterEvent> getEventFlow();
}