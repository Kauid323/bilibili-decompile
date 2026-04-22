package kntr.app.game.gamebind;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameAuthorizeViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeAction;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Nothing", "Close", "GoBindTencent", "NoRoleInfo", "Lkntr/app/game/gamebind/AuthorizeAction$Close;", "Lkntr/app/game/gamebind/AuthorizeAction$GoBindTencent;", "Lkntr/app/game/gamebind/AuthorizeAction$NoRoleInfo;", "Lkntr/app/game/gamebind/AuthorizeAction$Nothing;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AuthorizeAction {
    public /* synthetic */ AuthorizeAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeAction$Nothing;", "Lkntr/app/game/gamebind/AuthorizeAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Nothing extends AuthorizeAction {
        public static final Nothing INSTANCE = new Nothing();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Nothing) {
                Nothing nothing = (Nothing) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -393334719;
        }

        public String toString() {
            return "Nothing";
        }

        private Nothing() {
            super(null);
        }
    }

    private AuthorizeAction() {
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeAction$Close;", "Lkntr/app/game/gamebind/AuthorizeAction;", "toast", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getToast", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Close extends AuthorizeAction {
        private final String toast;

        public Close() {
            this(null, 1, null);
        }

        public static /* synthetic */ Close copy$default(Close close, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = close.toast;
            }
            return close.copy(str);
        }

        public final String component1() {
            return this.toast;
        }

        public final Close copy(String str) {
            return new Close(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Close) && Intrinsics.areEqual(this.toast, ((Close) obj).toast);
        }

        public int hashCode() {
            if (this.toast == null) {
                return 0;
            }
            return this.toast.hashCode();
        }

        public String toString() {
            return "Close(toast=" + this.toast + ")";
        }

        public Close(String toast) {
            super(null);
            this.toast = toast;
        }

        public /* synthetic */ Close(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getToast() {
            return this.toast;
        }
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeAction$GoBindTencent;", "Lkntr/app/game/gamebind/AuthorizeAction;", "tokenLink", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getTokenLink", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class GoBindTencent extends AuthorizeAction {
        private final String tokenLink;

        public static /* synthetic */ GoBindTencent copy$default(GoBindTencent goBindTencent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = goBindTencent.tokenLink;
            }
            return goBindTencent.copy(str);
        }

        public final String component1() {
            return this.tokenLink;
        }

        public final GoBindTencent copy(String str) {
            Intrinsics.checkNotNullParameter(str, "tokenLink");
            return new GoBindTencent(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GoBindTencent) && Intrinsics.areEqual(this.tokenLink, ((GoBindTencent) obj).tokenLink);
        }

        public int hashCode() {
            return this.tokenLink.hashCode();
        }

        public String toString() {
            return "GoBindTencent(tokenLink=" + this.tokenLink + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoBindTencent(String tokenLink) {
            super(null);
            Intrinsics.checkNotNullParameter(tokenLink, "tokenLink");
            this.tokenLink = tokenLink;
        }

        public final String getTokenLink() {
            return this.tokenLink;
        }
    }

    /* compiled from: GameAuthorizeViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/gamebind/AuthorizeAction$NoRoleInfo;", "Lkntr/app/game/gamebind/AuthorizeAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NoRoleInfo extends AuthorizeAction {
        public static final NoRoleInfo INSTANCE = new NoRoleInfo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NoRoleInfo) {
                NoRoleInfo noRoleInfo = (NoRoleInfo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1704510001;
        }

        public String toString() {
            return "NoRoleInfo";
        }

        private NoRoleInfo() {
            super(null);
        }
    }
}