package kntr.app.game.base.event;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KntrGameStatusEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkntr/app/game/base/event/KntrGameStatusEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(I)V", "getGameBaseId", "()I", "KntrGameFollowEvent", "KntrGameBookEvent", "KntrGamePayEvent", "KntrGameBookPayEvent", "KntrGameBookVersionEvent", "Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameBookEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameBookPayEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameBookVersionEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameFollowEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGamePayEvent;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class KntrGameStatusEvent {
    public static final int $stable = 0;
    private final int gameBaseId;

    public /* synthetic */ KntrGameStatusEvent(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private KntrGameStatusEvent(int gameBaseId) {
        this.gameBaseId = gameBaseId;
    }

    public int getGameBaseId() {
        return this.gameBaseId;
    }

    /* compiled from: KntrGameStatusEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameFollowEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "isFollowed", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IZ)V", "getGameBaseId", "()I", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class KntrGameFollowEvent extends KntrGameStatusEvent {
        public static final int $stable = 0;
        private final int gameBaseId;
        private final boolean isFollowed;

        public static /* synthetic */ KntrGameFollowEvent copy$default(KntrGameFollowEvent kntrGameFollowEvent, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = kntrGameFollowEvent.gameBaseId;
            }
            if ((i2 & 2) != 0) {
                z = kntrGameFollowEvent.isFollowed;
            }
            return kntrGameFollowEvent.copy(i, z);
        }

        public final int component1() {
            return this.gameBaseId;
        }

        public final boolean component2() {
            return this.isFollowed;
        }

        public final KntrGameFollowEvent copy(int i, boolean z) {
            return new KntrGameFollowEvent(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KntrGameFollowEvent) {
                KntrGameFollowEvent kntrGameFollowEvent = (KntrGameFollowEvent) obj;
                return this.gameBaseId == kntrGameFollowEvent.gameBaseId && this.isFollowed == kntrGameFollowEvent.isFollowed;
            }
            return false;
        }

        public int hashCode() {
            return (this.gameBaseId * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFollowed);
        }

        public String toString() {
            int i = this.gameBaseId;
            return "KntrGameFollowEvent(gameBaseId=" + i + ", isFollowed=" + this.isFollowed + ")";
        }

        public KntrGameFollowEvent(int gameBaseId, boolean isFollowed) {
            super(gameBaseId, null);
            this.gameBaseId = gameBaseId;
            this.isFollowed = isFollowed;
        }

        public /* synthetic */ KntrGameFollowEvent(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z);
        }

        @Override // kntr.app.game.base.event.KntrGameStatusEvent
        public int getGameBaseId() {
            return this.gameBaseId;
        }

        public final boolean isFollowed() {
            return this.isFollowed;
        }
    }

    /* compiled from: KntrGameStatusEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameBookEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "isBooked", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IZ)V", "getGameBaseId", "()I", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class KntrGameBookEvent extends KntrGameStatusEvent {
        public static final int $stable = 0;
        private final int gameBaseId;
        private final boolean isBooked;

        public static /* synthetic */ KntrGameBookEvent copy$default(KntrGameBookEvent kntrGameBookEvent, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = kntrGameBookEvent.gameBaseId;
            }
            if ((i2 & 2) != 0) {
                z = kntrGameBookEvent.isBooked;
            }
            return kntrGameBookEvent.copy(i, z);
        }

        public final int component1() {
            return this.gameBaseId;
        }

        public final boolean component2() {
            return this.isBooked;
        }

        public final KntrGameBookEvent copy(int i, boolean z) {
            return new KntrGameBookEvent(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KntrGameBookEvent) {
                KntrGameBookEvent kntrGameBookEvent = (KntrGameBookEvent) obj;
                return this.gameBaseId == kntrGameBookEvent.gameBaseId && this.isBooked == kntrGameBookEvent.isBooked;
            }
            return false;
        }

        public int hashCode() {
            return (this.gameBaseId * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isBooked);
        }

        public String toString() {
            int i = this.gameBaseId;
            return "KntrGameBookEvent(gameBaseId=" + i + ", isBooked=" + this.isBooked + ")";
        }

        public KntrGameBookEvent(int gameBaseId, boolean isBooked) {
            super(gameBaseId, null);
            this.gameBaseId = gameBaseId;
            this.isBooked = isBooked;
        }

        public /* synthetic */ KntrGameBookEvent(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z);
        }

        @Override // kntr.app.game.base.event.KntrGameStatusEvent
        public int getGameBaseId() {
            return this.gameBaseId;
        }

        public final boolean isBooked() {
            return this.isBooked;
        }
    }

    /* compiled from: KntrGameStatusEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGamePayEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "downloadLink1", RoomRecommendViewModel.EMPTY_CURSOR, "downloadLink2", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getGameBaseId", "()I", "getDownloadLink1", "()Ljava/lang/String;", "getDownloadLink2", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class KntrGamePayEvent extends KntrGameStatusEvent {
        public static final int $stable = 0;
        private final String downloadLink1;
        private final String downloadLink2;
        private final int gameBaseId;

        public static /* synthetic */ KntrGamePayEvent copy$default(KntrGamePayEvent kntrGamePayEvent, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = kntrGamePayEvent.gameBaseId;
            }
            if ((i2 & 2) != 0) {
                str = kntrGamePayEvent.downloadLink1;
            }
            if ((i2 & 4) != 0) {
                str2 = kntrGamePayEvent.downloadLink2;
            }
            return kntrGamePayEvent.copy(i, str, str2);
        }

        public final int component1() {
            return this.gameBaseId;
        }

        public final String component2() {
            return this.downloadLink1;
        }

        public final String component3() {
            return this.downloadLink2;
        }

        public final KntrGamePayEvent copy(int i, String str, String str2) {
            return new KntrGamePayEvent(i, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KntrGamePayEvent) {
                KntrGamePayEvent kntrGamePayEvent = (KntrGamePayEvent) obj;
                return this.gameBaseId == kntrGamePayEvent.gameBaseId && Intrinsics.areEqual(this.downloadLink1, kntrGamePayEvent.downloadLink1) && Intrinsics.areEqual(this.downloadLink2, kntrGamePayEvent.downloadLink2);
            }
            return false;
        }

        public int hashCode() {
            return (((this.gameBaseId * 31) + (this.downloadLink1 == null ? 0 : this.downloadLink1.hashCode())) * 31) + (this.downloadLink2 != null ? this.downloadLink2.hashCode() : 0);
        }

        public String toString() {
            int i = this.gameBaseId;
            String str = this.downloadLink1;
            return "KntrGamePayEvent(gameBaseId=" + i + ", downloadLink1=" + str + ", downloadLink2=" + this.downloadLink2 + ")";
        }

        public KntrGamePayEvent(int gameBaseId, String downloadLink1, String downloadLink2) {
            super(gameBaseId, null);
            this.gameBaseId = gameBaseId;
            this.downloadLink1 = downloadLink1;
            this.downloadLink2 = downloadLink2;
        }

        public /* synthetic */ KntrGamePayEvent(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
        }

        @Override // kntr.app.game.base.event.KntrGameStatusEvent
        public int getGameBaseId() {
            return this.gameBaseId;
        }

        public final String getDownloadLink1() {
            return this.downloadLink1;
        }

        public final String getDownloadLink2() {
            return this.downloadLink2;
        }
    }

    /* compiled from: KntrGameStatusEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameBookPayEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "isBooked", RoomRecommendViewModel.EMPTY_CURSOR, "downloadLink1", RoomRecommendViewModel.EMPTY_CURSOR, "downloadLink2", "<init>", "(IZLjava/lang/String;Ljava/lang/String;)V", "getGameBaseId", "()I", "()Z", "getDownloadLink1", "()Ljava/lang/String;", "getDownloadLink2", "component1", "component2", "component3", "component4", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class KntrGameBookPayEvent extends KntrGameStatusEvent {
        public static final int $stable = 0;
        private final String downloadLink1;
        private final String downloadLink2;
        private final int gameBaseId;
        private final boolean isBooked;

        public static /* synthetic */ KntrGameBookPayEvent copy$default(KntrGameBookPayEvent kntrGameBookPayEvent, int i, boolean z, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = kntrGameBookPayEvent.gameBaseId;
            }
            if ((i2 & 2) != 0) {
                z = kntrGameBookPayEvent.isBooked;
            }
            if ((i2 & 4) != 0) {
                str = kntrGameBookPayEvent.downloadLink1;
            }
            if ((i2 & 8) != 0) {
                str2 = kntrGameBookPayEvent.downloadLink2;
            }
            return kntrGameBookPayEvent.copy(i, z, str, str2);
        }

        public final int component1() {
            return this.gameBaseId;
        }

        public final boolean component2() {
            return this.isBooked;
        }

        public final String component3() {
            return this.downloadLink1;
        }

        public final String component4() {
            return this.downloadLink2;
        }

        public final KntrGameBookPayEvent copy(int i, boolean z, String str, String str2) {
            return new KntrGameBookPayEvent(i, z, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KntrGameBookPayEvent) {
                KntrGameBookPayEvent kntrGameBookPayEvent = (KntrGameBookPayEvent) obj;
                return this.gameBaseId == kntrGameBookPayEvent.gameBaseId && this.isBooked == kntrGameBookPayEvent.isBooked && Intrinsics.areEqual(this.downloadLink1, kntrGameBookPayEvent.downloadLink1) && Intrinsics.areEqual(this.downloadLink2, kntrGameBookPayEvent.downloadLink2);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.gameBaseId * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isBooked)) * 31) + (this.downloadLink1 == null ? 0 : this.downloadLink1.hashCode())) * 31) + (this.downloadLink2 != null ? this.downloadLink2.hashCode() : 0);
        }

        public String toString() {
            int i = this.gameBaseId;
            boolean z = this.isBooked;
            String str = this.downloadLink1;
            return "KntrGameBookPayEvent(gameBaseId=" + i + ", isBooked=" + z + ", downloadLink1=" + str + ", downloadLink2=" + this.downloadLink2 + ")";
        }

        public KntrGameBookPayEvent(int gameBaseId, boolean isBooked, String downloadLink1, String downloadLink2) {
            super(gameBaseId, null);
            this.gameBaseId = gameBaseId;
            this.isBooked = isBooked;
            this.downloadLink1 = downloadLink1;
            this.downloadLink2 = downloadLink2;
        }

        public /* synthetic */ KntrGameBookPayEvent(int i, boolean z, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2);
        }

        @Override // kntr.app.game.base.event.KntrGameStatusEvent
        public int getGameBaseId() {
            return this.gameBaseId;
        }

        public final boolean isBooked() {
            return this.isBooked;
        }

        public final String getDownloadLink1() {
            return this.downloadLink1;
        }

        public final String getDownloadLink2() {
            return this.downloadLink2;
        }
    }

    /* compiled from: KntrGameStatusEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/game/base/event/KntrGameStatusEvent$KntrGameBookVersionEvent;", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "isBooked", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(IZ)V", "getGameBaseId", "()I", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class KntrGameBookVersionEvent extends KntrGameStatusEvent {
        public static final int $stable = 0;
        private final int gameBaseId;
        private final boolean isBooked;

        public static /* synthetic */ KntrGameBookVersionEvent copy$default(KntrGameBookVersionEvent kntrGameBookVersionEvent, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = kntrGameBookVersionEvent.gameBaseId;
            }
            if ((i2 & 2) != 0) {
                z = kntrGameBookVersionEvent.isBooked;
            }
            return kntrGameBookVersionEvent.copy(i, z);
        }

        public final int component1() {
            return this.gameBaseId;
        }

        public final boolean component2() {
            return this.isBooked;
        }

        public final KntrGameBookVersionEvent copy(int i, boolean z) {
            return new KntrGameBookVersionEvent(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KntrGameBookVersionEvent) {
                KntrGameBookVersionEvent kntrGameBookVersionEvent = (KntrGameBookVersionEvent) obj;
                return this.gameBaseId == kntrGameBookVersionEvent.gameBaseId && this.isBooked == kntrGameBookVersionEvent.isBooked;
            }
            return false;
        }

        public int hashCode() {
            return (this.gameBaseId * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isBooked);
        }

        public String toString() {
            int i = this.gameBaseId;
            return "KntrGameBookVersionEvent(gameBaseId=" + i + ", isBooked=" + this.isBooked + ")";
        }

        public KntrGameBookVersionEvent(int gameBaseId, boolean isBooked) {
            super(gameBaseId, null);
            this.gameBaseId = gameBaseId;
            this.isBooked = isBooked;
        }

        public /* synthetic */ KntrGameBookVersionEvent(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z);
        }

        @Override // kntr.app.game.base.event.KntrGameStatusEvent
        public int getGameBaseId() {
            return this.gameBaseId;
        }

        public final boolean isBooked() {
            return this.isBooked;
        }
    }
}