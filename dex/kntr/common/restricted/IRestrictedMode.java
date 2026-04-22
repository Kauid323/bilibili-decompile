package kntr.common.restricted;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: KRestrictedMode.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/common/restricted/IRestrictedMode;", "", "stateChange", "Lkotlinx/coroutines/flow/Flow;", "", "getStateChange", "()Lkotlinx/coroutines/flow/Flow;", "checkModeEnabled", "", "mode", "Lkntr/common/restricted/KRestrictedModeType;", "business", "", "getTeenagerAge", "", "restricted-mode_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IRestrictedMode {
    boolean checkModeEnabled(KRestrictedModeType kRestrictedModeType);

    boolean checkModeEnabled(KRestrictedModeType kRestrictedModeType, String str);

    Flow<Unit> getStateChange();

    int getTeenagerAge();
}