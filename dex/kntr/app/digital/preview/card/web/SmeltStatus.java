package kntr.app.digital.preview.card.web;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: SmeltCardContent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/card/web/SmeltStatus;", RoomRecommendViewModel.EMPTY_CURSOR, "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "loadState", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JZ)V", "getCardId", "()J", "getLoadState", "()Z", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmeltStatus {
    public static final int $stable = 0;
    private final long cardId;
    private final boolean loadState;

    public SmeltStatus(long cardId, boolean loadState) {
        this.cardId = cardId;
        this.loadState = loadState;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final boolean getLoadState() {
        return this.loadState;
    }
}