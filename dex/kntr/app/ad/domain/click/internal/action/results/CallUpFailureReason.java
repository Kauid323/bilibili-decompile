package kntr.app.ad.domain.click.internal.action.results;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallUpResult.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "InputError", "UnSupported", "AuthFailed", "NotInstalled", "UserCancelled", "InternalError", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$AuthFailed;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$InputError;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$InternalError;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$NotInstalled;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$UnSupported;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$UserCancelled;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CallUpFailureReason {
    public /* synthetic */ CallUpFailureReason(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: CallUpResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$InputError;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason;", "msg", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InputError extends CallUpFailureReason {
        private final String msg;

        public static /* synthetic */ InputError copy$default(InputError inputError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputError.msg;
            }
            return inputError.copy(str);
        }

        public final String component1() {
            return this.msg;
        }

        public final InputError copy(String str) {
            return new InputError(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InputError) && Intrinsics.areEqual(this.msg, ((InputError) obj).msg);
        }

        public int hashCode() {
            if (this.msg == null) {
                return 0;
            }
            return this.msg.hashCode();
        }

        public String toString() {
            return "InputError(msg=" + this.msg + ")";
        }

        public InputError(String msg) {
            super(null);
            this.msg = msg;
        }

        public final String getMsg() {
            return this.msg;
        }
    }

    private CallUpFailureReason() {
    }

    /* compiled from: CallUpResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$UnSupported;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class UnSupported extends CallUpFailureReason {
        public static final UnSupported INSTANCE = new UnSupported();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UnSupported) {
                UnSupported unSupported = (UnSupported) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1223840482;
        }

        public String toString() {
            return "UnSupported";
        }

        private UnSupported() {
            super(null);
        }
    }

    /* compiled from: CallUpResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$AuthFailed;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AuthFailed extends CallUpFailureReason {
        public static final AuthFailed INSTANCE = new AuthFailed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AuthFailed) {
                AuthFailed authFailed = (AuthFailed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -24965156;
        }

        public String toString() {
            return "AuthFailed";
        }

        private AuthFailed() {
            super(null);
        }
    }

    /* compiled from: CallUpResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$NotInstalled;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NotInstalled extends CallUpFailureReason {
        public static final NotInstalled INSTANCE = new NotInstalled();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotInstalled) {
                NotInstalled notInstalled = (NotInstalled) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1642799102;
        }

        public String toString() {
            return "NotInstalled";
        }

        private NotInstalled() {
            super(null);
        }
    }

    /* compiled from: CallUpResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$UserCancelled;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class UserCancelled extends CallUpFailureReason {
        public static final UserCancelled INSTANCE = new UserCancelled();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UserCancelled) {
                UserCancelled userCancelled = (UserCancelled) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1988050575;
        }

        public String toString() {
            return "UserCancelled";
        }

        private UserCancelled() {
            super(null);
        }
    }

    /* compiled from: CallUpResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason$InternalError;", "Lkntr/app/ad/domain/click/internal/action/results/CallUpFailureReason;", "msg", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InternalError extends CallUpFailureReason {
        private final String msg;

        public static /* synthetic */ InternalError copy$default(InternalError internalError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internalError.msg;
            }
            return internalError.copy(str);
        }

        public final String component1() {
            return this.msg;
        }

        public final InternalError copy(String str) {
            return new InternalError(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InternalError) && Intrinsics.areEqual(this.msg, ((InternalError) obj).msg);
        }

        public int hashCode() {
            if (this.msg == null) {
                return 0;
            }
            return this.msg.hashCode();
        }

        public String toString() {
            return "InternalError(msg=" + this.msg + ")";
        }

        public InternalError(String msg) {
            super(null);
            this.msg = msg;
        }

        public final String getMsg() {
            return this.msg;
        }
    }
}