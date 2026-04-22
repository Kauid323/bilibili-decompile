package kntr.app.ad.domain.click;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: Clicker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/domain/click/IButtonClickListener;", RoomRecommendViewModel.EMPTY_CURSOR, "onButtonStart", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/IClickContext;", "onButtonAnswered", "onButtonLost", "onCardStart", "onCardAnswered", "onCardLost", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IButtonClickListener {
    void onButtonAnswered(IClickContext iClickContext);

    void onButtonLost(IClickContext iClickContext);

    void onButtonStart(IClickContext iClickContext);

    void onCardAnswered(IClickContext iClickContext);

    void onCardLost(IClickContext iClickContext);

    void onCardStart(IClickContext iClickContext);
}