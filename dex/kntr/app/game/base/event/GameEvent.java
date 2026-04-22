package kntr.app.game.base.event;

import BottomSheetItemData$;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameEvent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/game/base/event/GameEvent;", "Lkntr/app/game/base/event/Event;", "<init>", "()V", "FollowChanged", "BookChanged", "PaymentCompleted", "DownloadStatusChanged", "Lkntr/app/game/base/event/GameEvent$BookChanged;", "Lkntr/app/game/base/event/GameEvent$DownloadStatusChanged;", "Lkntr/app/game/base/event/GameEvent$FollowChanged;", "Lkntr/app/game/base/event/GameEvent$PaymentCompleted;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class GameEvent implements Event {
    public static final int $stable = 0;

    public /* synthetic */ GameEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GameEvent() {
    }

    /* compiled from: GameEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/game/base/event/GameEvent$FollowChanged;", "Lkntr/app/game/base/event/GameEvent;", "gameId", RoomRecommendViewModel.EMPTY_CURSOR, "isFollowed", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IZ)V", "getGameId", "()I", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class FollowChanged extends GameEvent {
        public static final int $stable = 0;
        private final int gameId;
        private final boolean isFollowed;

        public static /* synthetic */ FollowChanged copy$default(FollowChanged followChanged, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = followChanged.gameId;
            }
            if ((i2 & 2) != 0) {
                z = followChanged.isFollowed;
            }
            return followChanged.copy(i, z);
        }

        public final int component1() {
            return this.gameId;
        }

        public final boolean component2() {
            return this.isFollowed;
        }

        public final FollowChanged copy(int i, boolean z) {
            return new FollowChanged(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FollowChanged) {
                FollowChanged followChanged = (FollowChanged) obj;
                return this.gameId == followChanged.gameId && this.isFollowed == followChanged.isFollowed;
            }
            return false;
        }

        public int hashCode() {
            return (this.gameId * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFollowed);
        }

        public String toString() {
            int i = this.gameId;
            return "FollowChanged(gameId=" + i + ", isFollowed=" + this.isFollowed + ")";
        }

        public FollowChanged(int gameId, boolean isFollowed) {
            super(null);
            this.gameId = gameId;
            this.isFollowed = isFollowed;
        }

        public final int getGameId() {
            return this.gameId;
        }

        public final boolean isFollowed() {
            return this.isFollowed;
        }
    }

    /* compiled from: GameEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/game/base/event/GameEvent$BookChanged;", "Lkntr/app/game/base/event/GameEvent;", "gameId", RoomRecommendViewModel.EMPTY_CURSOR, "isBooked", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IZ)V", "getGameId", "()I", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class BookChanged extends GameEvent {
        public static final int $stable = 0;
        private final int gameId;
        private final boolean isBooked;

        public static /* synthetic */ BookChanged copy$default(BookChanged bookChanged, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = bookChanged.gameId;
            }
            if ((i2 & 2) != 0) {
                z = bookChanged.isBooked;
            }
            return bookChanged.copy(i, z);
        }

        public final int component1() {
            return this.gameId;
        }

        public final boolean component2() {
            return this.isBooked;
        }

        public final BookChanged copy(int i, boolean z) {
            return new BookChanged(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BookChanged) {
                BookChanged bookChanged = (BookChanged) obj;
                return this.gameId == bookChanged.gameId && this.isBooked == bookChanged.isBooked;
            }
            return false;
        }

        public int hashCode() {
            return (this.gameId * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isBooked);
        }

        public String toString() {
            int i = this.gameId;
            return "BookChanged(gameId=" + i + ", isBooked=" + this.isBooked + ")";
        }

        public BookChanged(int gameId, boolean isBooked) {
            super(null);
            this.gameId = gameId;
            this.isBooked = isBooked;
        }

        public final int getGameId() {
            return this.gameId;
        }

        public final boolean isBooked() {
            return this.isBooked;
        }
    }

    /* compiled from: GameEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/game/base/event/GameEvent$PaymentCompleted;", "Lkntr/app/game/base/event/GameEvent;", "gameId", RoomRecommendViewModel.EMPTY_CURSOR, "downloadLink", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;)V", "getGameId", "()I", "getDownloadLink", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PaymentCompleted extends GameEvent {
        public static final int $stable = 0;
        private final String downloadLink;
        private final int gameId;

        public static /* synthetic */ PaymentCompleted copy$default(PaymentCompleted paymentCompleted, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = paymentCompleted.gameId;
            }
            if ((i2 & 2) != 0) {
                str = paymentCompleted.downloadLink;
            }
            return paymentCompleted.copy(i, str);
        }

        public final int component1() {
            return this.gameId;
        }

        public final String component2() {
            return this.downloadLink;
        }

        public final PaymentCompleted copy(int i, String str) {
            return new PaymentCompleted(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PaymentCompleted) {
                PaymentCompleted paymentCompleted = (PaymentCompleted) obj;
                return this.gameId == paymentCompleted.gameId && Intrinsics.areEqual(this.downloadLink, paymentCompleted.downloadLink);
            }
            return false;
        }

        public int hashCode() {
            return (this.gameId * 31) + (this.downloadLink == null ? 0 : this.downloadLink.hashCode());
        }

        public String toString() {
            int i = this.gameId;
            return "PaymentCompleted(gameId=" + i + ", downloadLink=" + this.downloadLink + ")";
        }

        public PaymentCompleted(int gameId, String downloadLink) {
            super(null);
            this.gameId = gameId;
            this.downloadLink = downloadLink;
        }

        public final int getGameId() {
            return this.gameId;
        }

        public final String getDownloadLink() {
            return this.downloadLink;
        }
    }

    /* compiled from: GameEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/app/game/base/event/GameEvent$DownloadStatusChanged;", "Lkntr/app/game/base/event/GameEvent;", "gameId", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.STATUS, "Lkntr/app/game/base/event/DownloadStatus;", "progress", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILkntr/app/game/base/event/DownloadStatus;F)V", "getGameId", "()I", "getStatus", "()Lkntr/app/game/base/event/DownloadStatus;", "getProgress", "()F", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DownloadStatusChanged extends GameEvent {
        public static final int $stable = 0;
        private final int gameId;
        private final float progress;
        private final DownloadStatus status;

        public static /* synthetic */ DownloadStatusChanged copy$default(DownloadStatusChanged downloadStatusChanged, int i, DownloadStatus downloadStatus, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = downloadStatusChanged.gameId;
            }
            if ((i2 & 2) != 0) {
                downloadStatus = downloadStatusChanged.status;
            }
            if ((i2 & 4) != 0) {
                f = downloadStatusChanged.progress;
            }
            return downloadStatusChanged.copy(i, downloadStatus, f);
        }

        public final int component1() {
            return this.gameId;
        }

        public final DownloadStatus component2() {
            return this.status;
        }

        public final float component3() {
            return this.progress;
        }

        public final DownloadStatusChanged copy(int i, DownloadStatus downloadStatus, float f) {
            Intrinsics.checkNotNullParameter(downloadStatus, AdAlarmExtraKey.STATUS);
            return new DownloadStatusChanged(i, downloadStatus, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DownloadStatusChanged) {
                DownloadStatusChanged downloadStatusChanged = (DownloadStatusChanged) obj;
                return this.gameId == downloadStatusChanged.gameId && this.status == downloadStatusChanged.status && Float.compare(this.progress, downloadStatusChanged.progress) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((this.gameId * 31) + this.status.hashCode()) * 31) + Float.floatToIntBits(this.progress);
        }

        public String toString() {
            int i = this.gameId;
            DownloadStatus downloadStatus = this.status;
            return "DownloadStatusChanged(gameId=" + i + ", status=" + downloadStatus + ", progress=" + this.progress + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadStatusChanged(int gameId, DownloadStatus status, float progress) {
            super(null);
            Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
            this.gameId = gameId;
            this.status = status;
            this.progress = progress;
            float f = this.progress;
            boolean z = false;
            if (0.0f <= f && f <= 1.0f) {
                z = true;
            }
            if (z) {
                return;
            }
            throw new IllegalArgumentException(("Progress must be between 0.0 and 1.0, got " + this.progress).toString());
        }

        public /* synthetic */ DownloadStatusChanged(int i, DownloadStatus downloadStatus, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, downloadStatus, (i2 & 4) != 0 ? 0.0f : f);
        }

        public final int getGameId() {
            return this.gameId;
        }

        public final DownloadStatus getStatus() {
            return this.status;
        }

        public final float getProgress() {
            return this.progress;
        }
    }
}