package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.viewmodel.IUIEvent;

/* compiled from: FavoritesEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderEvent;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUIEvent;", "ShowAddTopToast", "ScrollToTop", "UpdateLayoutType", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent$ScrollToTop;", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent$ShowAddTopToast;", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent$UpdateLayoutType;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FolderEvent extends IUIEvent {

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderEvent$ShowAddTopToast;", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;", "success", "", "<init>", "(Z)V", "getSuccess", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowAddTopToast implements FolderEvent {
        public static final int $stable = 0;
        private final boolean success;

        public static /* synthetic */ ShowAddTopToast copy$default(ShowAddTopToast showAddTopToast, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = showAddTopToast.success;
            }
            return showAddTopToast.copy(z);
        }

        public final boolean component1() {
            return this.success;
        }

        public final ShowAddTopToast copy(boolean z) {
            return new ShowAddTopToast(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowAddTopToast) && this.success == ((ShowAddTopToast) obj).success;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.success);
        }

        public String toString() {
            return "ShowAddTopToast(success=" + this.success + ")";
        }

        public ShowAddTopToast(boolean success) {
            this.success = success;
        }

        public final boolean getSuccess() {
            return this.success;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderEvent$ScrollToTop;", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ScrollToTop implements FolderEvent {
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
            return 1743328892;
        }

        public String toString() {
            return "ScrollToTop";
        }

        private ScrollToTop() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderEvent$UpdateLayoutType;", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;", "compact", "", "<init>", "(Z)V", "getCompact", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class UpdateLayoutType implements FolderEvent {
        public static final int $stable = 0;
        private final boolean compact;

        public static /* synthetic */ UpdateLayoutType copy$default(UpdateLayoutType updateLayoutType, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = updateLayoutType.compact;
            }
            return updateLayoutType.copy(z);
        }

        public final boolean component1() {
            return this.compact;
        }

        public final UpdateLayoutType copy(boolean z) {
            return new UpdateLayoutType(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateLayoutType) && this.compact == ((UpdateLayoutType) obj).compact;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.compact);
        }

        public String toString() {
            return "UpdateLayoutType(compact=" + this.compact + ")";
        }

        public UpdateLayoutType(boolean compact) {
            this.compact = compact;
        }

        public final boolean getCompact() {
            return this.compact;
        }
    }
}