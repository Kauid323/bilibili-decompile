package kntr.app.ad.domain.click.internal.action;

import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: ActionDispatcher.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/ActionDispatcher;", RoomRecommendViewModel.EMPTY_CURSOR, "onActionResult", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "action", "Lkntr/app/ad/domain/click/internal/action/ActionResult;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ActionDispatcher {
    void onActionResult(ClickContext clickContext, ActionResult actionResult);
}