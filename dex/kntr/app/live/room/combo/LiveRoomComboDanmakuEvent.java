package kntr.app.live.room.combo;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComboDanmakuStore.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "CardShow", "CardClick", "SendComboMsg", "UpdateBySocket", "CancelByOther", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CancelByOther;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CardClick;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CardShow;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$SendComboMsg;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$UpdateBySocket;", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomComboDanmakuEvent {
    public /* synthetic */ LiveRoomComboDanmakuEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LiveRoomComboDanmakuEvent() {
    }

    /* compiled from: ComboDanmakuStore.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CardShow;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;", "count", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getCount", "()J", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardShow extends LiveRoomComboDanmakuEvent {
        private final long count;

        public static /* synthetic */ CardShow copy$default(CardShow cardShow, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = cardShow.count;
            }
            return cardShow.copy(j2);
        }

        public final long component1() {
            return this.count;
        }

        public final CardShow copy(long j2) {
            return new CardShow(j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardShow) && this.count == ((CardShow) obj).count;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.count);
        }

        public String toString() {
            return "CardShow(count=" + this.count + ")";
        }

        public CardShow(long count) {
            super(null);
            this.count = count;
        }

        public final long getCount() {
            return this.count;
        }
    }

    /* compiled from: ComboDanmakuStore.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CardClick;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;", "<init>", "()V", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardClick extends LiveRoomComboDanmakuEvent {
        public static final CardClick INSTANCE = new CardClick();

        private CardClick() {
            super(null);
        }
    }

    /* compiled from: ComboDanmakuStore.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$SendComboMsg;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;", "msg", RoomRecommendViewModel.EMPTY_CURSOR, "rnd", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;J)V", "getMsg", "()Ljava/lang/String;", "getRnd", "()J", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SendComboMsg extends LiveRoomComboDanmakuEvent {
        private final String msg;
        private final long rnd;

        public static /* synthetic */ SendComboMsg copy$default(SendComboMsg sendComboMsg, String str, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sendComboMsg.msg;
            }
            if ((i & 2) != 0) {
                j2 = sendComboMsg.rnd;
            }
            return sendComboMsg.copy(str, j2);
        }

        public final String component1() {
            return this.msg;
        }

        public final long component2() {
            return this.rnd;
        }

        public final SendComboMsg copy(String str, long j2) {
            Intrinsics.checkNotNullParameter(str, "msg");
            return new SendComboMsg(str, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SendComboMsg) {
                SendComboMsg sendComboMsg = (SendComboMsg) obj;
                return Intrinsics.areEqual(this.msg, sendComboMsg.msg) && this.rnd == sendComboMsg.rnd;
            }
            return false;
        }

        public int hashCode() {
            return (this.msg.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.rnd);
        }

        public String toString() {
            String str = this.msg;
            return "SendComboMsg(msg=" + str + ", rnd=" + this.rnd + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendComboMsg(String msg, long rnd) {
            super(null);
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.msg = msg;
            this.rnd = rnd;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final long getRnd() {
            return this.rnd;
        }
    }

    /* compiled from: ComboDanmakuStore.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$UpdateBySocket;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;", "msg", RoomRecommendViewModel.EMPTY_CURSOR, "mergeInterval", RoomRecommendViewModel.EMPTY_CURSOR, "count", "leftDuration", "<init>", "(Ljava/lang/String;JJJ)V", "getMsg", "()Ljava/lang/String;", "getMergeInterval", "()J", "getCount", "getLeftDuration", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class UpdateBySocket extends LiveRoomComboDanmakuEvent {
        private final long count;
        private final long leftDuration;
        private final long mergeInterval;
        private final String msg;

        public static /* synthetic */ UpdateBySocket copy$default(UpdateBySocket updateBySocket, String str, long j2, long j3, long j4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateBySocket.msg;
            }
            if ((i & 2) != 0) {
                j2 = updateBySocket.mergeInterval;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = updateBySocket.count;
            }
            long j6 = j3;
            if ((i & 8) != 0) {
                j4 = updateBySocket.leftDuration;
            }
            return updateBySocket.copy(str, j5, j6, j4);
        }

        public final String component1() {
            return this.msg;
        }

        public final long component2() {
            return this.mergeInterval;
        }

        public final long component3() {
            return this.count;
        }

        public final long component4() {
            return this.leftDuration;
        }

        public final UpdateBySocket copy(String str, long j2, long j3, long j4) {
            Intrinsics.checkNotNullParameter(str, "msg");
            return new UpdateBySocket(str, j2, j3, j4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpdateBySocket) {
                UpdateBySocket updateBySocket = (UpdateBySocket) obj;
                return Intrinsics.areEqual(this.msg, updateBySocket.msg) && this.mergeInterval == updateBySocket.mergeInterval && this.count == updateBySocket.count && this.leftDuration == updateBySocket.leftDuration;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.msg.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mergeInterval)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.count)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.leftDuration);
        }

        public String toString() {
            String str = this.msg;
            long j2 = this.mergeInterval;
            long j3 = this.count;
            return "UpdateBySocket(msg=" + str + ", mergeInterval=" + j2 + ", count=" + j3 + ", leftDuration=" + this.leftDuration + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateBySocket(String msg, long mergeInterval, long count, long leftDuration) {
            super(null);
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.msg = msg;
            this.mergeInterval = mergeInterval;
            this.count = count;
            this.leftDuration = leftDuration;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final long getMergeInterval() {
            return this.mergeInterval;
        }

        public final long getCount() {
            return this.count;
        }

        public final long getLeftDuration() {
            return this.leftDuration;
        }
    }

    /* compiled from: ComboDanmakuStore.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent$CancelByOther;", "Lkntr/app/live/room/combo/LiveRoomComboDanmakuEvent;", "<init>", "()V", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CancelByOther extends LiveRoomComboDanmakuEvent {
        public static final CancelByOther INSTANCE = new CancelByOther();

        private CancelByOther() {
            super(null);
        }
    }
}