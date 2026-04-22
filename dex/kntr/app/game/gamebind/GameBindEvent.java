package kntr.app.game.gamebind;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GameBindEventStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/app/game/gamebind/GameBindEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Bind", "Unbind", "Changed", "Lkntr/app/game/gamebind/GameBindEvent$Bind;", "Lkntr/app/game/gamebind/GameBindEvent$Changed;", "Lkntr/app/game/gamebind/GameBindEvent$Unbind;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class GameBindEvent {
    public /* synthetic */ GameBindEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: GameBindEventStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/GameBindEvent$Bind;", "Lkntr/app/game/gamebind/GameBindEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Bind extends GameBindEvent {
        public static final Bind INSTANCE = new Bind();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Bind) {
                Bind bind = (Bind) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -802280963;
        }

        public String toString() {
            return "Bind";
        }

        private Bind() {
            super(null);
        }
    }

    private GameBindEvent() {
    }

    /* compiled from: GameBindEventStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/GameBindEvent$Unbind;", "Lkntr/app/game/gamebind/GameBindEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Unbind extends GameBindEvent {
        public static final Unbind INSTANCE = new Unbind();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unbind) {
                Unbind unbind = (Unbind) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1644637162;
        }

        public String toString() {
            return "Unbind";
        }

        private Unbind() {
            super(null);
        }
    }

    /* compiled from: GameBindEventStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/GameBindEvent$Changed;", "Lkntr/app/game/gamebind/GameBindEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Changed extends GameBindEvent {
        public static final Changed INSTANCE = new Changed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Changed) {
                Changed changed = (Changed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1588102388;
        }

        public String toString() {
            return "Changed";
        }

        private Changed() {
            super(null);
        }
    }
}