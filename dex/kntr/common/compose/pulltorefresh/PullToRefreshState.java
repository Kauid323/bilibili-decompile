package kntr.common.compose.pulltorefresh;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PullToRefreshState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0001\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/common/compose/pulltorefresh/PullToRefreshState;", "", "refreshTriggerDistancePx", "", "getRefreshTriggerDistancePx", "()F", "refreshingOffsetPx", "getRefreshingOffsetPx", "isRefreshing", "", "()Z", "contentOffset", "getContentOffset", "isPullInProgress", "startRefresh", "", "endRefresh", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Lkntr/common/compose/pulltorefresh/PullToRefreshStateImpl;", "compose-pulltorefresh_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface PullToRefreshState {
    void endRefresh();

    float getContentOffset();

    NestedScrollConnection getNestedScrollConnection();

    float getRefreshTriggerDistancePx();

    float getRefreshingOffsetPx();

    boolean isPullInProgress();

    boolean isRefreshing();

    void startRefresh();
}