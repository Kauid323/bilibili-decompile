package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KFootHoverToast;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeHomeStateAction.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "", "<init>", "()V", "ScrollToTop", "ToastTips", "ToastDialog", "ShowRevisitGuide", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ScrollToTop;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ShowRevisitGuide;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ToastDialog;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ToastTips;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeHomeUIAction {
    public static final int $stable = 0;

    public /* synthetic */ TribeeHomeUIAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ScrollToTop;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ScrollToTop extends TribeeHomeUIAction {
        public static final int $stable = 0;
        public static final ScrollToTop INSTANCE = new ScrollToTop();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ScrollToTop) {
                ScrollToTop scrollToTop = (ScrollToTop) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1444589240;
        }

        public String toString() {
            return "ScrollToTop";
        }

        private ScrollToTop() {
            super(null);
        }
    }

    private TribeeHomeUIAction() {
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ToastTips;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "tribeeToast", "Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "<init>", "(Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;)V", "getTribeeToast", "()Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToastTips extends TribeeHomeUIAction {
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
            super(null);
            this.tribeeToast = tribeeToast;
        }

        public final TribeeToast getTribeeToast() {
            return this.tribeeToast;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ToastDialog;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "dialog", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;)V", "getDialog", "()Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToastDialog extends TribeeHomeUIAction {
        public static final int $stable = 8;
        private final KToastDialog dialog;

        public static /* synthetic */ ToastDialog copy$default(ToastDialog toastDialog, KToastDialog kToastDialog, int i, Object obj) {
            if ((i & 1) != 0) {
                kToastDialog = toastDialog.dialog;
            }
            return toastDialog.copy(kToastDialog);
        }

        public final KToastDialog component1() {
            return this.dialog;
        }

        public final ToastDialog copy(KToastDialog kToastDialog) {
            Intrinsics.checkNotNullParameter(kToastDialog, "dialog");
            return new ToastDialog(kToastDialog);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToastDialog) && Intrinsics.areEqual(this.dialog, ((ToastDialog) obj).dialog);
        }

        public int hashCode() {
            return this.dialog.hashCode();
        }

        public String toString() {
            return "ToastDialog(dialog=" + this.dialog + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToastDialog(KToastDialog dialog) {
            super(null);
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.dialog = dialog;
        }

        public final KToastDialog getDialog() {
            return this.dialog;
        }
    }

    /* compiled from: TribeeHomeStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction$ShowRevisitGuide;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "guide", "Lcom/bapis/bilibili/app/dynamic/v2/KFootHoverToast;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KFootHoverToast;)V", "getGuide", "()Lcom/bapis/bilibili/app/dynamic/v2/KFootHoverToast;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowRevisitGuide extends TribeeHomeUIAction {
        public static final int $stable = 8;
        private final KFootHoverToast guide;

        public static /* synthetic */ ShowRevisitGuide copy$default(ShowRevisitGuide showRevisitGuide, KFootHoverToast kFootHoverToast, int i, Object obj) {
            if ((i & 1) != 0) {
                kFootHoverToast = showRevisitGuide.guide;
            }
            return showRevisitGuide.copy(kFootHoverToast);
        }

        public final KFootHoverToast component1() {
            return this.guide;
        }

        public final ShowRevisitGuide copy(KFootHoverToast kFootHoverToast) {
            Intrinsics.checkNotNullParameter(kFootHoverToast, "guide");
            return new ShowRevisitGuide(kFootHoverToast);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowRevisitGuide) && Intrinsics.areEqual(this.guide, ((ShowRevisitGuide) obj).guide);
        }

        public int hashCode() {
            return this.guide.hashCode();
        }

        public String toString() {
            return "ShowRevisitGuide(guide=" + this.guide + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowRevisitGuide(KFootHoverToast guide) {
            super(null);
            Intrinsics.checkNotNullParameter(guide, "guide");
            this.guide = guide;
        }

        public final KFootHoverToast getGuide() {
            return this.guide;
        }
    }
}