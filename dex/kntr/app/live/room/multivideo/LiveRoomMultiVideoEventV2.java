package kntr.app.live.room.multivideo;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiVideoStoreV2.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Start", "Update", "Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2$Start;", "Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2$Update;", "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomMultiVideoEventV2 {
    public /* synthetic */ LiveRoomMultiVideoEventV2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: MultiVideoStoreV2.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2$Start;", "Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2;", "delay", RoomRecommendViewModel.EMPTY_CURSOR, "roomId", "anchorId", "bizSessionId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JJJLjava/lang/String;)V", "getDelay", "()J", "getRoomId", "getAnchorId", "getBizSessionId", "()Ljava/lang/String;", "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Start extends LiveRoomMultiVideoEventV2 {
        private final long anchorId;
        private final String bizSessionId;
        private final long delay;
        private final long roomId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Start(long delay, long roomId, long anchorId, String bizSessionId) {
            super(null);
            Intrinsics.checkNotNullParameter(bizSessionId, "bizSessionId");
            this.delay = delay;
            this.roomId = roomId;
            this.anchorId = anchorId;
            this.bizSessionId = bizSessionId;
        }

        public final long getDelay() {
            return this.delay;
        }

        public final long getRoomId() {
            return this.roomId;
        }

        public final long getAnchorId() {
            return this.anchorId;
        }

        public final String getBizSessionId() {
            return this.bizSessionId;
        }
    }

    private LiveRoomMultiVideoEventV2() {
    }

    /* compiled from: MultiVideoStoreV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2$Update;", "Lkntr/app/live/room/multivideo/LiveRoomMultiVideoEventV2;", "delay", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getDelay", "()J", "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Update extends LiveRoomMultiVideoEventV2 {
        private final long delay;

        public Update(long delay) {
            super(null);
            this.delay = delay;
        }

        public final long getDelay() {
            return this.delay;
        }
    }
}