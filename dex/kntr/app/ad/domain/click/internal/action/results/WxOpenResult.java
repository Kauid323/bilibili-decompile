package kntr.app.ad.domain.click.internal.action.results;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WxOpenResult.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Success", "Failure", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult$Failure;", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult$Success;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class WxOpenResult {
    public /* synthetic */ WxOpenResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: WxOpenResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult$Success;", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Success extends WxOpenResult {
        public static final Success INSTANCE = new Success();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -15589957;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
            super(null);
        }
    }

    private WxOpenResult() {
    }

    /* compiled from: WxOpenResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult$Failure;", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;", "reason", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenFailureReason;", "<init>", "(Lkntr/app/ad/domain/click/internal/action/results/WxOpenFailureReason;)V", "getReason", "()Lkntr/app/ad/domain/click/internal/action/results/WxOpenFailureReason;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Failure extends WxOpenResult {
        private final WxOpenFailureReason reason;

        public static /* synthetic */ Failure copy$default(Failure failure, WxOpenFailureReason wxOpenFailureReason, int i, Object obj) {
            if ((i & 1) != 0) {
                wxOpenFailureReason = failure.reason;
            }
            return failure.copy(wxOpenFailureReason);
        }

        public final WxOpenFailureReason component1() {
            return this.reason;
        }

        public final Failure copy(WxOpenFailureReason wxOpenFailureReason) {
            Intrinsics.checkNotNullParameter(wxOpenFailureReason, "reason");
            return new Failure(wxOpenFailureReason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual(this.reason, ((Failure) obj).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Failure(reason=" + this.reason + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(WxOpenFailureReason reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final WxOpenFailureReason getReason() {
            return this.reason;
        }
    }
}