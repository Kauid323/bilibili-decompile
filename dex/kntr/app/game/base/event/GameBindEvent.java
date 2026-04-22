package kntr.app.game.base.event;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/app/game/base/event/GameBindEvent;", "Lkntr/app/game/base/event/Event;", "<init>", "()V", "Bound", "Unbound", "RoleChanged", "Lkntr/app/game/base/event/GameBindEvent$Bound;", "Lkntr/app/game/base/event/GameBindEvent$RoleChanged;", "Lkntr/app/game/base/event/GameBindEvent$Unbound;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class GameBindEvent implements Event {
    public static final int $stable = 0;

    public /* synthetic */ GameBindEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GameBindEvent() {
    }

    /* compiled from: GameEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/base/event/GameBindEvent$Bound;", "Lkntr/app/game/base/event/GameBindEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Bound extends GameBindEvent {
        public static final int $stable = 0;
        public static final Bound INSTANCE = new Bound();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Bound) {
                Bound bound = (Bound) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2100738484;
        }

        public String toString() {
            return "Bound";
        }

        private Bound() {
            super(null);
        }
    }

    /* compiled from: GameEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/base/event/GameBindEvent$Unbound;", "Lkntr/app/game/base/event/GameBindEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Unbound extends GameBindEvent {
        public static final int $stable = 0;
        public static final Unbound INSTANCE = new Unbound();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unbound) {
                Unbound unbound = (Unbound) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -538479661;
        }

        public String toString() {
            return "Unbound";
        }

        private Unbound() {
            super(null);
        }
    }

    /* compiled from: GameEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/game/base/event/GameBindEvent$RoleChanged;", "Lkntr/app/game/base/event/GameBindEvent;", "roleId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getRoleId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RoleChanged extends GameBindEvent {
        public static final int $stable = 0;
        private final String roleId;

        public static /* synthetic */ RoleChanged copy$default(RoleChanged roleChanged, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = roleChanged.roleId;
            }
            return roleChanged.copy(str);
        }

        public final String component1() {
            return this.roleId;
        }

        public final RoleChanged copy(String str) {
            Intrinsics.checkNotNullParameter(str, "roleId");
            return new RoleChanged(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RoleChanged) && Intrinsics.areEqual(this.roleId, ((RoleChanged) obj).roleId);
        }

        public int hashCode() {
            return this.roleId.hashCode();
        }

        public String toString() {
            return "RoleChanged(roleId=" + this.roleId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleChanged(String roleId) {
            super(null);
            Intrinsics.checkNotNullParameter(roleId, "roleId");
            this.roleId = roleId;
        }

        public final String getRoleId() {
            return this.roleId;
        }
    }
}