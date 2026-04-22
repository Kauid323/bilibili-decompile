package kntr.app.game.base.event;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import kntr.app.game.base.event.KntrGameStatusEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KntrGameStatusEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0005"}, d2 = {"updateGameStatus", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "event", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KntrGameStatusEventKt {
    public static final void updateGameStatus(KBiligame $this$updateGameStatus, KntrGameStatusEvent event) {
        Intrinsics.checkNotNullParameter($this$updateGameStatus, "<this>");
        if (event != null && $this$updateGameStatus.getGameBaseId() == event.getGameBaseId()) {
            if (event instanceof KntrGameStatusEvent.KntrGameFollowEvent) {
                $this$updateGameStatus.setFollowed(((KntrGameStatusEvent.KntrGameFollowEvent) event).isFollowed());
            } else if (event instanceof KntrGameStatusEvent.KntrGameBookEvent) {
                $this$updateGameStatus.setBooked(((KntrGameStatusEvent.KntrGameBookEvent) event).isBooked());
            } else if (event instanceof KntrGameStatusEvent.KntrGamePayEvent) {
                $this$updateGameStatus.setDownloadLink(((KntrGameStatusEvent.KntrGamePayEvent) event).getDownloadLink1());
                $this$updateGameStatus.setDownloadLink2(((KntrGameStatusEvent.KntrGamePayEvent) event).getDownloadLink2());
                $this$updateGameStatus.setPurchased(true);
            } else if (event instanceof KntrGameStatusEvent.KntrGameBookPayEvent) {
                $this$updateGameStatus.setPurchased(true);
            } else if (!(event instanceof KntrGameStatusEvent.KntrGameBookVersionEvent)) {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}