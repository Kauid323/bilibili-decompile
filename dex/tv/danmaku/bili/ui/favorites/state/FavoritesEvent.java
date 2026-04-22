package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.viewmodel.IUIEvent;

/* compiled from: FavoritesEvent.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\u0082\u0001\u000b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUIEvent;", "ShowDeleteDialog", "CopyTo", "MoveTo", "ScrollToTop", "ShowDeletedToast", "DirectlyBatchManage", "ClearInvalidVideoResult", "ShowClearAllInvalidVideoDialog", "ShowInvalidCardDialog", "RouteTo", "NotifySwitchTranslate", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ClearInvalidVideoResult;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$CopyTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$DirectlyBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$MoveTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$NotifySwitchTranslate;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$RouteTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ScrollToTop;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowClearAllInvalidVideoDialog;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowDeleteDialog;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowDeletedToast;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowInvalidCardDialog;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FavoritesEvent extends IUIEvent {

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowDeleteDialog;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowDeleteDialog implements FavoritesEvent {
        public static final int $stable = 0;
        public static final ShowDeleteDialog INSTANCE = new ShowDeleteDialog();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowDeleteDialog) {
                ShowDeleteDialog showDeleteDialog = (ShowDeleteDialog) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 383061580;
        }

        public String toString() {
            return "ShowDeleteDialog";
        }

        private ShowDeleteDialog() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$CopyTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CopyTo implements FavoritesEvent {
        public static final int $stable = 0;
        public static final CopyTo INSTANCE = new CopyTo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CopyTo) {
                CopyTo copyTo = (CopyTo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1262763092;
        }

        public String toString() {
            return "CopyTo";
        }

        private CopyTo() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$MoveTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class MoveTo implements FavoritesEvent {
        public static final int $stable = 0;
        public static final MoveTo INSTANCE = new MoveTo();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MoveTo) {
                MoveTo moveTo = (MoveTo) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -976312056;
        }

        public String toString() {
            return "MoveTo";
        }

        private MoveTo() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ScrollToTop;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ScrollToTop implements FavoritesEvent {
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
            return -662102863;
        }

        public String toString() {
            return "ScrollToTop";
        }

        private ScrollToTop() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowDeletedToast;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "success", "", "<init>", "(Z)V", "getSuccess", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowDeletedToast implements FavoritesEvent {
        public static final int $stable = 0;
        private final boolean success;

        public static /* synthetic */ ShowDeletedToast copy$default(ShowDeletedToast showDeletedToast, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = showDeletedToast.success;
            }
            return showDeletedToast.copy(z);
        }

        public final boolean component1() {
            return this.success;
        }

        public final ShowDeletedToast copy(boolean z) {
            return new ShowDeletedToast(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowDeletedToast) && this.success == ((ShowDeletedToast) obj).success;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success);
        }

        public String toString() {
            return "ShowDeletedToast(success=" + this.success + ")";
        }

        public ShowDeletedToast(boolean success) {
            this.success = success;
        }

        public final boolean getSuccess() {
            return this.success;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$DirectlyBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DirectlyBatchManage implements FavoritesEvent {
        public static final int $stable = 0;
        public static final DirectlyBatchManage INSTANCE = new DirectlyBatchManage();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DirectlyBatchManage) {
                DirectlyBatchManage directlyBatchManage = (DirectlyBatchManage) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1018189517;
        }

        public String toString() {
            return "DirectlyBatchManage";
        }

        private DirectlyBatchManage() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ClearInvalidVideoResult;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "success", "", "<init>", "(Z)V", "getSuccess", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClearInvalidVideoResult implements FavoritesEvent {
        public static final int $stable = 0;
        private final boolean success;

        public static /* synthetic */ ClearInvalidVideoResult copy$default(ClearInvalidVideoResult clearInvalidVideoResult, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = clearInvalidVideoResult.success;
            }
            return clearInvalidVideoResult.copy(z);
        }

        public final boolean component1() {
            return this.success;
        }

        public final ClearInvalidVideoResult copy(boolean z) {
            return new ClearInvalidVideoResult(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClearInvalidVideoResult) && this.success == ((ClearInvalidVideoResult) obj).success;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success);
        }

        public String toString() {
            return "ClearInvalidVideoResult(success=" + this.success + ")";
        }

        public ClearInvalidVideoResult(boolean success) {
            this.success = success;
        }

        public final boolean getSuccess() {
            return this.success;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowClearAllInvalidVideoDialog;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;)V", "getItem", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowClearAllInvalidVideoDialog implements FavoritesEvent {
        public static final int $stable = 8;
        private final FavoritesMediasItem item;

        public static /* synthetic */ ShowClearAllInvalidVideoDialog copy$default(ShowClearAllInvalidVideoDialog showClearAllInvalidVideoDialog, FavoritesMediasItem favoritesMediasItem, int i, Object obj) {
            if ((i & 1) != 0) {
                favoritesMediasItem = showClearAllInvalidVideoDialog.item;
            }
            return showClearAllInvalidVideoDialog.copy(favoritesMediasItem);
        }

        public final FavoritesMediasItem component1() {
            return this.item;
        }

        public final ShowClearAllInvalidVideoDialog copy(FavoritesMediasItem favoritesMediasItem) {
            Intrinsics.checkNotNullParameter(favoritesMediasItem, "item");
            return new ShowClearAllInvalidVideoDialog(favoritesMediasItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowClearAllInvalidVideoDialog) && Intrinsics.areEqual(this.item, ((ShowClearAllInvalidVideoDialog) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ShowClearAllInvalidVideoDialog(item=" + this.item + ")";
        }

        public ShowClearAllInvalidVideoDialog(FavoritesMediasItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final FavoritesMediasItem getItem() {
            return this.item;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$ShowInvalidCardDialog;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;)V", "getItem", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowInvalidCardDialog implements FavoritesEvent {
        public static final int $stable = 8;
        private final FavoritesMediasItem item;

        public static /* synthetic */ ShowInvalidCardDialog copy$default(ShowInvalidCardDialog showInvalidCardDialog, FavoritesMediasItem favoritesMediasItem, int i, Object obj) {
            if ((i & 1) != 0) {
                favoritesMediasItem = showInvalidCardDialog.item;
            }
            return showInvalidCardDialog.copy(favoritesMediasItem);
        }

        public final FavoritesMediasItem component1() {
            return this.item;
        }

        public final ShowInvalidCardDialog copy(FavoritesMediasItem favoritesMediasItem) {
            Intrinsics.checkNotNullParameter(favoritesMediasItem, "item");
            return new ShowInvalidCardDialog(favoritesMediasItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowInvalidCardDialog) && Intrinsics.areEqual(this.item, ((ShowInvalidCardDialog) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ShowInvalidCardDialog(item=" + this.item + ")";
        }

        public ShowInvalidCardDialog(FavoritesMediasItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final FavoritesMediasItem getItem() {
            return this.item;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$RouteTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "link", "", "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class RouteTo implements FavoritesEvent {
        public static final int $stable = 0;
        private final String link;

        public static /* synthetic */ RouteTo copy$default(RouteTo routeTo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = routeTo.link;
            }
            return routeTo.copy(str);
        }

        public final String component1() {
            return this.link;
        }

        public final RouteTo copy(String str) {
            return new RouteTo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RouteTo) && Intrinsics.areEqual(this.link, ((RouteTo) obj).link);
        }

        public int hashCode() {
            if (this.link == null) {
                return 0;
            }
            return this.link.hashCode();
        }

        public String toString() {
            return "RouteTo(link=" + this.link + ")";
        }

        public RouteTo(String link) {
            this.link = link;
        }

        public final String getLink() {
            return this.link;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent$NotifySwitchTranslate;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesEvent;", "position", "", "<init>", "(I)V", "getPosition", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NotifySwitchTranslate implements FavoritesEvent {
        public static final int $stable = 0;
        private final int position;

        public static /* synthetic */ NotifySwitchTranslate copy$default(NotifySwitchTranslate notifySwitchTranslate, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = notifySwitchTranslate.position;
            }
            return notifySwitchTranslate.copy(i);
        }

        public final int component1() {
            return this.position;
        }

        public final NotifySwitchTranslate copy(int i) {
            return new NotifySwitchTranslate(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotifySwitchTranslate) && this.position == ((NotifySwitchTranslate) obj).position;
        }

        public int hashCode() {
            return this.position;
        }

        public String toString() {
            return "NotifySwitchTranslate(position=" + this.position + ")";
        }

        public NotifySwitchTranslate(int position) {
            this.position = position;
        }

        public final int getPosition() {
            return this.position;
        }
    }
}