package kntr.app.tribee.operation.viewmodel;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSendInviteCodeOptionsResp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeOperationStateAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "", "UpdateTribee", "UpdateType", "UpdateCount", "Submit", "RefreshPage", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$RefreshPage;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$Submit;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$UpdateCount;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$UpdateTribee;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$UpdateType;", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeOperationStateAction {

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$UpdateTribee;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "selectedItem", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;)V", "getSelectedItem", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpdateTribee implements TribeeOperationStateAction {
        public static final int $stable = 8;
        private final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedItem;

        public static /* synthetic */ UpdateTribee copy$default(UpdateTribee updateTribee, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSelectItem = updateTribee.selectedItem;
            }
            return updateTribee.copy(kTribeeSelectItem);
        }

        public final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem component1() {
            return this.selectedItem;
        }

        public final UpdateTribee copy(KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem) {
            Intrinsics.checkNotNullParameter(kTribeeSelectItem, "selectedItem");
            return new UpdateTribee(kTribeeSelectItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateTribee) && Intrinsics.areEqual(this.selectedItem, ((UpdateTribee) obj).selectedItem);
        }

        public int hashCode() {
            return this.selectedItem.hashCode();
        }

        public String toString() {
            return "UpdateTribee(selectedItem=" + this.selectedItem + ")";
        }

        public UpdateTribee(KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedItem) {
            Intrinsics.checkNotNullParameter(selectedItem, "selectedItem");
            this.selectedItem = selectedItem;
        }

        public final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem getSelectedItem() {
            return this.selectedItem;
        }
    }

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$UpdateType;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "sendType", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteTypeItem;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteTypeItem;)V", "getSendType", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteTypeItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpdateType implements TribeeOperationStateAction {
        public static final int $stable = 8;
        private final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem sendType;

        public static /* synthetic */ UpdateType copy$default(UpdateType updateType, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem kInviteTypeItem, int i, Object obj) {
            if ((i & 1) != 0) {
                kInviteTypeItem = updateType.sendType;
            }
            return updateType.copy(kInviteTypeItem);
        }

        public final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem component1() {
            return this.sendType;
        }

        public final UpdateType copy(KTribeeSendInviteCodeOptionsResp.KInviteTypeItem kInviteTypeItem) {
            Intrinsics.checkNotNullParameter(kInviteTypeItem, "sendType");
            return new UpdateType(kInviteTypeItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateType) && Intrinsics.areEqual(this.sendType, ((UpdateType) obj).sendType);
        }

        public int hashCode() {
            return this.sendType.hashCode();
        }

        public String toString() {
            return "UpdateType(sendType=" + this.sendType + ")";
        }

        public UpdateType(KTribeeSendInviteCodeOptionsResp.KInviteTypeItem sendType) {
            Intrinsics.checkNotNullParameter(sendType, "sendType");
            this.sendType = sendType;
        }

        public final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem getSendType() {
            return this.sendType;
        }
    }

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$UpdateCount;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "sendCount", "", "<init>", "(J)V", "getSendCount", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UpdateCount implements TribeeOperationStateAction {
        public static final int $stable = 0;
        private final long sendCount;

        public static /* synthetic */ UpdateCount copy$default(UpdateCount updateCount, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = updateCount.sendCount;
            }
            return updateCount.copy(j);
        }

        public final long component1() {
            return this.sendCount;
        }

        public final UpdateCount copy(long j) {
            return new UpdateCount(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateCount) && this.sendCount == ((UpdateCount) obj).sendCount;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sendCount);
        }

        public String toString() {
            return "UpdateCount(sendCount=" + this.sendCount + ")";
        }

        public UpdateCount(long sendCount) {
            this.sendCount = sendCount;
        }

        public final long getSendCount() {
            return this.sendCount;
        }
    }

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$Submit;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Submit implements TribeeOperationStateAction {
        public static final int $stable = 0;
        public static final Submit INSTANCE = new Submit();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Submit) {
                Submit submit = (Submit) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1459830369;
        }

        public String toString() {
            return "Submit";
        }

        private Submit() {
        }
    }

    /* compiled from: TribeeOperationStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction$RefreshPage;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RefreshPage implements TribeeOperationStateAction {
        public static final int $stable = 0;
        public static final RefreshPage INSTANCE = new RefreshPage();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RefreshPage) {
                RefreshPage refreshPage = (RefreshPage) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1268315295;
        }

        public String toString() {
            return "RefreshPage";
        }

        private RefreshPage() {
        }
    }
}