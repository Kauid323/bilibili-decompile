package kntr.app.ad.domain.click.internal.callup;

import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: CallUpCallbacks.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/click/internal/callup/CallUpCallback;", RoomRecommendViewModel.EMPTY_CURSOR, "onShowSystemAlert", RoomRecommendViewModel.EMPTY_CURSOR, "onResult", "result", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "onStayDuration", "duration", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CallUpCallback {
    void onResult(CallUpResult callUpResult);

    void onShowSystemAlert();

    void onStayDuration(long j2);
}