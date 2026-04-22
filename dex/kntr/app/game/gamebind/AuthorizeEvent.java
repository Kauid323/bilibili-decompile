package kntr.app.game.gamebind;

import BottomSheetItemData$;
import kntr.app.game.gamebind.bean.AuthorizeInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameAuthorizeViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Bind", "Close", "CheckBind", "NotifyNoRoleInfo", "Bound", "Lkntr/app/game/gamebind/AuthorizeEvent$Bind;", "Lkntr/app/game/gamebind/AuthorizeEvent$Bound;", "Lkntr/app/game/gamebind/AuthorizeEvent$CheckBind;", "Lkntr/app/game/gamebind/AuthorizeEvent$Close;", "Lkntr/app/game/gamebind/AuthorizeEvent$NotifyNoRoleInfo;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AuthorizeEvent {
    public /* synthetic */ AuthorizeEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeEvent$Bind;", "Lkntr/app/game/gamebind/AuthorizeEvent;", "isAll", RoomRecommendViewModel.EMPTY_CURSOR, "authorizeInfo", "Lkntr/app/game/gamebind/bean/AuthorizeInfo;", "<init>", "(ZLkntr/app/game/gamebind/bean/AuthorizeInfo;)V", "()Z", "getAuthorizeInfo", "()Lkntr/app/game/gamebind/bean/AuthorizeInfo;", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Bind extends AuthorizeEvent {
        private final AuthorizeInfo authorizeInfo;
        private final boolean isAll;

        public Bind() {
            this(false, null, 3, null);
        }

        public static /* synthetic */ Bind copy$default(Bind bind, boolean z, AuthorizeInfo authorizeInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                z = bind.isAll;
            }
            if ((i & 2) != 0) {
                authorizeInfo = bind.authorizeInfo;
            }
            return bind.copy(z, authorizeInfo);
        }

        public final boolean component1() {
            return this.isAll;
        }

        public final AuthorizeInfo component2() {
            return this.authorizeInfo;
        }

        public final Bind copy(boolean z, AuthorizeInfo authorizeInfo) {
            return new Bind(z, authorizeInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Bind) {
                Bind bind = (Bind) obj;
                return this.isAll == bind.isAll && Intrinsics.areEqual(this.authorizeInfo, bind.authorizeInfo);
            }
            return false;
        }

        public int hashCode() {
            return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAll) * 31) + (this.authorizeInfo == null ? 0 : this.authorizeInfo.hashCode());
        }

        public String toString() {
            boolean z = this.isAll;
            return "Bind(isAll=" + z + ", authorizeInfo=" + this.authorizeInfo + ")";
        }

        public Bind(boolean isAll, AuthorizeInfo authorizeInfo) {
            super(null);
            this.isAll = isAll;
            this.authorizeInfo = authorizeInfo;
        }

        public /* synthetic */ Bind(boolean z, AuthorizeInfo authorizeInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : authorizeInfo);
        }

        public final boolean isAll() {
            return this.isAll;
        }

        public final AuthorizeInfo getAuthorizeInfo() {
            return this.authorizeInfo;
        }
    }

    private AuthorizeEvent() {
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeEvent$Close;", "Lkntr/app/game/gamebind/AuthorizeEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Close extends AuthorizeEvent {
        public static final Close INSTANCE = new Close();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Close) {
                Close close = (Close) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1267827528;
        }

        public String toString() {
            return "Close";
        }

        private Close() {
            super(null);
        }
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeEvent$CheckBind;", "Lkntr/app/game/gamebind/AuthorizeEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CheckBind extends AuthorizeEvent {
        public static final CheckBind INSTANCE = new CheckBind();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CheckBind) {
                CheckBind checkBind = (CheckBind) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -543885275;
        }

        public String toString() {
            return "CheckBind";
        }

        private CheckBind() {
            super(null);
        }
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeEvent$NotifyNoRoleInfo;", "Lkntr/app/game/gamebind/AuthorizeEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NotifyNoRoleInfo extends AuthorizeEvent {
        public static final NotifyNoRoleInfo INSTANCE = new NotifyNoRoleInfo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotifyNoRoleInfo) {
                NotifyNoRoleInfo notifyNoRoleInfo = (NotifyNoRoleInfo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1500554382;
        }

        public String toString() {
            return "NotifyNoRoleInfo";
        }

        private NotifyNoRoleInfo() {
            super(null);
        }
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeEvent$Bound;", "Lkntr/app/game/gamebind/AuthorizeEvent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Bound extends AuthorizeEvent {
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
            return -1268656066;
        }

        public String toString() {
            return "Bound";
        }

        private Bound() {
            super(null);
        }
    }
}