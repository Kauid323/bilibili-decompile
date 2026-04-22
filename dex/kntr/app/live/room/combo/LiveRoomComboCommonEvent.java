package kntr.app.live.room.combo;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComboCommonStore.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboCommonEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "CardShow", "CardClick", "UpdateBySocket", "CancelByOther", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CancelByOther;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CardClick;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CardShow;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$UpdateBySocket;", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomComboCommonEvent {
    public /* synthetic */ LiveRoomComboCommonEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LiveRoomComboCommonEvent() {
    }

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CardShow;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent;", "count", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getCount", "()J", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardShow extends LiveRoomComboCommonEvent {
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

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CardClick;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent;", "needAdd", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Z)V", "getNeedAdd", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardClick extends LiveRoomComboCommonEvent {
        private final boolean needAdd;

        public static /* synthetic */ CardClick copy$default(CardClick cardClick, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = cardClick.needAdd;
            }
            return cardClick.copy(z);
        }

        public final boolean component1() {
            return this.needAdd;
        }

        public final CardClick copy(boolean z) {
            return new CardClick(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardClick) && this.needAdd == ((CardClick) obj).needAdd;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.needAdd);
        }

        public String toString() {
            return "CardClick(needAdd=" + this.needAdd + ")";
        }

        public CardClick(boolean needAdd) {
            super(null);
            this.needAdd = needAdd;
        }

        public final boolean getNeedAdd() {
            return this.needAdd;
        }
    }

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$UpdateBySocket;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent;", "count", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "getCount", "()J", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class UpdateBySocket extends LiveRoomComboCommonEvent {
        private final long count;

        public static /* synthetic */ UpdateBySocket copy$default(UpdateBySocket updateBySocket, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = updateBySocket.count;
            }
            return updateBySocket.copy(j2);
        }

        public final long component1() {
            return this.count;
        }

        public final UpdateBySocket copy(long j2) {
            return new UpdateBySocket(j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateBySocket) && this.count == ((UpdateBySocket) obj).count;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.count);
        }

        public String toString() {
            return "UpdateBySocket(count=" + this.count + ")";
        }

        public UpdateBySocket(long count) {
            super(null);
            this.count = count;
        }

        public final long getCount() {
            return this.count;
        }
    }

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboCommonEvent$CancelByOther;", "Lkntr/app/live/room/combo/LiveRoomComboCommonEvent;", "<init>", "()V", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CancelByOther extends LiveRoomComboCommonEvent {
        public static final CancelByOther INSTANCE = new CancelByOther();

        private CancelByOther() {
            super(null);
        }
    }
}