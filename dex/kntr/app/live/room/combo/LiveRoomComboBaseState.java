package kntr.app.live.room.combo;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComboCommonStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboBaseState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Idle", "CardShowing", "CardDismiss", "Lkntr/app/live/room/combo/LiveRoomComboBaseState$CardDismiss;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState$CardShowing;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState$Idle;", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomComboBaseState {
    public /* synthetic */ LiveRoomComboBaseState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboBaseState$Idle;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState;", "<init>", "()V", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Idle extends LiveRoomComboBaseState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    private LiveRoomComboBaseState() {
    }

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboBaseState$CardShowing;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState;", "progress", RoomRecommendViewModel.EMPTY_CURSOR, "count", RoomRecommendViewModel.EMPTY_CURSOR, "from", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(FJI)V", "getProgress$annotations", "()V", "getProgress", "()F", "getCount", "()J", "getFrom", "()I", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardShowing extends LiveRoomComboBaseState {
        private final long count;
        private final int from;
        private final float progress;

        public static /* synthetic */ CardShowing copy$default(CardShowing cardShowing, float f, long j2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f = cardShowing.progress;
            }
            if ((i2 & 2) != 0) {
                j2 = cardShowing.count;
            }
            if ((i2 & 4) != 0) {
                i = cardShowing.from;
            }
            return cardShowing.copy(f, j2, i);
        }

        public static /* synthetic */ void getProgress$annotations() {
        }

        public final float component1() {
            return this.progress;
        }

        public final long component2() {
            return this.count;
        }

        public final int component3() {
            return this.from;
        }

        public final CardShowing copy(float f, long j2, int i) {
            return new CardShowing(f, j2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CardShowing) {
                CardShowing cardShowing = (CardShowing) obj;
                return Float.compare(this.progress, cardShowing.progress) == 0 && this.count == cardShowing.count && this.from == cardShowing.from;
            }
            return false;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.progress) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.count)) * 31) + this.from;
        }

        public String toString() {
            float f = this.progress;
            long j2 = this.count;
            return "CardShowing(progress=" + f + ", count=" + j2 + ", from=" + this.from + ")";
        }

        public CardShowing(float progress, long count, int from) {
            super(null);
            this.progress = progress;
            this.count = count;
            this.from = from;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final long getCount() {
            return this.count;
        }

        public final int getFrom() {
            return this.from;
        }
    }

    /* compiled from: ComboCommonStore.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboBaseState$CardDismiss;", "Lkntr/app/live/room/combo/LiveRoomComboBaseState;", "reason", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(I)V", "getReason$annotations", "()V", "getReason", "()I", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardDismiss extends LiveRoomComboBaseState {
        public static final Companion Companion = new Companion(null);
        public static final int DISMISS_BY_CARD_TIME = 1;
        public static final int DISMISS_BY_SERVER_TIME = 2;
        public static final int DISMISS_BY_SOCKET = 3;
        private final int reason;

        public static /* synthetic */ CardDismiss copy$default(CardDismiss cardDismiss, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cardDismiss.reason;
            }
            return cardDismiss.copy(i);
        }

        public static /* synthetic */ void getReason$annotations() {
        }

        public final int component1() {
            return this.reason;
        }

        public final CardDismiss copy(int i) {
            return new CardDismiss(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardDismiss) && this.reason == ((CardDismiss) obj).reason;
        }

        public int hashCode() {
            return this.reason;
        }

        public String toString() {
            return "CardDismiss(reason=" + this.reason + ")";
        }

        public CardDismiss(int reason) {
            super(null);
            this.reason = reason;
        }

        public final int getReason() {
            return this.reason;
        }

        /* compiled from: ComboCommonStore.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkntr/app/live/room/combo/LiveRoomComboBaseState$CardDismiss$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "DISMISS_BY_CARD_TIME", RoomRecommendViewModel.EMPTY_CURSOR, "DISMISS_BY_SERVER_TIME", "DISMISS_BY_SOCKET", "combo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}