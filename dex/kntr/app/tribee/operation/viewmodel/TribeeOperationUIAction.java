package kntr.app.tribee.operation.viewmodel;

import kntr.app.tribee.operation.common.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeOperationStateAction.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "", "OpenTribeeListBottomSheet", "ToastTips", "Finish", "Back", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$Back;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$Finish;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$OpenTribeeListBottomSheet;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$ToastTips;", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeOperationUIAction {

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$OpenTribeeListBottomSheet;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class OpenTribeeListBottomSheet implements TribeeOperationUIAction {
        public static final int $stable = 0;
        public static final OpenTribeeListBottomSheet INSTANCE = new OpenTribeeListBottomSheet();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OpenTribeeListBottomSheet) {
                OpenTribeeListBottomSheet openTribeeListBottomSheet = (OpenTribeeListBottomSheet) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -502499437;
        }

        public String toString() {
            return "OpenTribeeListBottomSheet";
        }

        private OpenTribeeListBottomSheet() {
        }
    }

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$ToastTips;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "tribeeToast", "Lkntr/app/tribee/operation/common/TribeeToast;", "<init>", "(Lkntr/app/tribee/operation/common/TribeeToast;)V", "getTribeeToast", "()Lkntr/app/tribee/operation/common/TribeeToast;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToastTips implements TribeeOperationUIAction {
        public static final int $stable = 0;
        private final TribeeToast tribeeToast;

        public static /* synthetic */ ToastTips copy$default(ToastTips toastTips, TribeeToast tribeeToast, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeToast = toastTips.tribeeToast;
            }
            return toastTips.copy(tribeeToast);
        }

        public final TribeeToast component1() {
            return this.tribeeToast;
        }

        public final ToastTips copy(TribeeToast tribeeToast) {
            return new ToastTips(tribeeToast);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToastTips) && Intrinsics.areEqual(this.tribeeToast, ((ToastTips) obj).tribeeToast);
        }

        public int hashCode() {
            if (this.tribeeToast == null) {
                return 0;
            }
            return this.tribeeToast.hashCode();
        }

        public String toString() {
            return "ToastTips(tribeeToast=" + this.tribeeToast + ")";
        }

        public ToastTips(TribeeToast tribeeToast) {
            this.tribeeToast = tribeeToast;
        }

        public final TribeeToast getTribeeToast() {
            return this.tribeeToast;
        }
    }

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$Finish;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "resultTips", "", "<init>", "(Ljava/lang/String;)V", "getResultTips", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Finish implements TribeeOperationUIAction {
        public static final int $stable = 0;
        private final String resultTips;

        public static /* synthetic */ Finish copy$default(Finish finish, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = finish.resultTips;
            }
            return finish.copy(str);
        }

        public final String component1() {
            return this.resultTips;
        }

        public final Finish copy(String str) {
            Intrinsics.checkNotNullParameter(str, "resultTips");
            return new Finish(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Finish) && Intrinsics.areEqual(this.resultTips, ((Finish) obj).resultTips);
        }

        public int hashCode() {
            return this.resultTips.hashCode();
        }

        public String toString() {
            return "Finish(resultTips=" + this.resultTips + ")";
        }

        public Finish(String resultTips) {
            Intrinsics.checkNotNullParameter(resultTips, "resultTips");
            this.resultTips = resultTips;
        }

        public final String getResultTips() {
            return this.resultTips;
        }
    }

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction$Back;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Back implements TribeeOperationUIAction {
        public static final int $stable = 0;
        public static final Back INSTANCE = new Back();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Back) {
                Back back = (Back) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1884876567;
        }

        public String toString() {
            return "Back";
        }

        private Back() {
        }
    }
}