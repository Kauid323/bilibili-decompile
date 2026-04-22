package kntr.app.live.room.interactiongame;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RoomInteractionGameGuideStore.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "DidPopOutGuideView", "DidClickActionButton", "Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent$DidClickActionButton;", "Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent$DidPopOutGuideView;", "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomInteractionGuideEvent {
    public /* synthetic */ LiveRoomInteractionGuideEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: RoomInteractionGameGuideStore.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent$DidPopOutGuideView;", "Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent;", "<init>", "()V", "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DidPopOutGuideView extends LiveRoomInteractionGuideEvent {
        public static final DidPopOutGuideView INSTANCE = new DidPopOutGuideView();

        private DidPopOutGuideView() {
            super(null);
        }
    }

    private LiveRoomInteractionGuideEvent() {
    }

    /* compiled from: RoomInteractionGameGuideStore.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent$DidClickActionButton;", "Lkntr/app/live/room/interactiongame/LiveRoomInteractionGuideEvent;", "<init>", "()V", "interactiongame_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DidClickActionButton extends LiveRoomInteractionGuideEvent {
        public static final DidClickActionButton INSTANCE = new DidClickActionButton();

        private DidClickActionButton() {
            super(null);
        }
    }
}