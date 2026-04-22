package kntr.app.ad.domain.click.internal.action.results;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadResult.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "InputError", "UnSupported", "AuthFailed", "InternalError", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$AuthFailed;", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$InputError;", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$InternalError;", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$UnSupported;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DownloadFailureReason {
    public /* synthetic */ DownloadFailureReason(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: DownloadResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$InputError;", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason;", "msg", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InputError extends DownloadFailureReason {
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

    private DownloadFailureReason() {
    }

    /* compiled from: DownloadResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$UnSupported;", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class UnSupported extends DownloadFailureReason {
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
            return 740170895;
        }

        public String toString() {
            return "UnSupported";
        }

        private UnSupported() {
            super(null);
        }
    }

    /* compiled from: DownloadResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$AuthFailed;", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AuthFailed extends DownloadFailureReason {
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
            return 1423863371;
        }

        public String toString() {
            return "AuthFailed";
        }

        private AuthFailed() {
            super(null);
        }
    }

    /* compiled from: DownloadResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason$InternalError;", "Lkntr/app/ad/domain/click/internal/action/results/DownloadFailureReason;", "msg", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class InternalError extends DownloadFailureReason {
        private final String msg;

        public InternalError() {
            this(null, 1, null);
        }

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

        public /* synthetic */ InternalError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getMsg() {
            return this.msg;
        }
    }
}