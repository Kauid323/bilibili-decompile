package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.viewmodel.IUIEvent;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: FavoritesEvent.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u0082\u0001\t\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUIEvent;", "ShowAddFolderIcon", "ShowBatchManageIcon", "HideRightIcon", "SetSearchIcon", "ShowCompactIcon", "StartBatchManage", "QuitBatchManage", "ForceRefresh", "SwitchLayoutType", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ForceRefresh;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$HideRightIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$QuitBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$SetSearchIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ShowAddFolderIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ShowBatchManageIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ShowCompactIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$StartBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$SwitchLayoutType;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FavoritesPageEvent extends IUIEvent {

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ShowAddFolderIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowAddFolderIcon implements FavoritesPageEvent {
        public static final int $stable = 0;
        public static final ShowAddFolderIcon INSTANCE = new ShowAddFolderIcon();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowAddFolderIcon) {
                ShowAddFolderIcon showAddFolderIcon = (ShowAddFolderIcon) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 386105760;
        }

        public String toString() {
            return "ShowAddFolderIcon";
        }

        private ShowAddFolderIcon() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ShowBatchManageIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowBatchManageIcon implements FavoritesPageEvent {
        public static final int $stable = 0;
        public static final ShowBatchManageIcon INSTANCE = new ShowBatchManageIcon();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowBatchManageIcon) {
                ShowBatchManageIcon showBatchManageIcon = (ShowBatchManageIcon) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -760890256;
        }

        public String toString() {
            return "ShowBatchManageIcon";
        }

        private ShowBatchManageIcon() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$HideRightIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HideRightIcon implements FavoritesPageEvent {
        public static final int $stable = 0;
        public static final HideRightIcon INSTANCE = new HideRightIcon();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HideRightIcon) {
                HideRightIcon hideRightIcon = (HideRightIcon) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 259680296;
        }

        public String toString() {
            return "HideRightIcon";
        }

        private HideRightIcon() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$SetSearchIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", ReportEvent.EVENT_TYPE_SHOW, "", "<init>", "(Z)V", "getShow", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SetSearchIcon implements FavoritesPageEvent {
        public static final int $stable = 0;
        private final boolean show;

        public static /* synthetic */ SetSearchIcon copy$default(SetSearchIcon setSearchIcon, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = setSearchIcon.show;
            }
            return setSearchIcon.copy(z);
        }

        public final boolean component1() {
            return this.show;
        }

        public final SetSearchIcon copy(boolean z) {
            return new SetSearchIcon(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SetSearchIcon) && this.show == ((SetSearchIcon) obj).show;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.show);
        }

        public String toString() {
            return "SetSearchIcon(show=" + this.show + ")";
        }

        public SetSearchIcon(boolean show) {
            this.show = show;
        }

        public final boolean getShow() {
            return this.show;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ShowCompactIcon;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", ReportEvent.EVENT_TYPE_SHOW, "", "<init>", "(Z)V", "getShow", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowCompactIcon implements FavoritesPageEvent {
        public static final int $stable = 0;
        private final boolean show;

        public static /* synthetic */ ShowCompactIcon copy$default(ShowCompactIcon showCompactIcon, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = showCompactIcon.show;
            }
            return showCompactIcon.copy(z);
        }

        public final boolean component1() {
            return this.show;
        }

        public final ShowCompactIcon copy(boolean z) {
            return new ShowCompactIcon(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowCompactIcon) && this.show == ((ShowCompactIcon) obj).show;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.show);
        }

        public String toString() {
            return "ShowCompactIcon(show=" + this.show + ")";
        }

        public ShowCompactIcon(boolean show) {
            this.show = show;
        }

        public final boolean getShow() {
            return this.show;
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$StartBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StartBatchManage implements FavoritesPageEvent {
        public static final int $stable = 0;
        public static final StartBatchManage INSTANCE = new StartBatchManage();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StartBatchManage) {
                StartBatchManage startBatchManage = (StartBatchManage) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 641393864;
        }

        public String toString() {
            return "StartBatchManage";
        }

        private StartBatchManage() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$QuitBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class QuitBatchManage implements FavoritesPageEvent {
        public static final int $stable = 0;
        public static final QuitBatchManage INSTANCE = new QuitBatchManage();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof QuitBatchManage) {
                QuitBatchManage quitBatchManage = (QuitBatchManage) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 285073605;
        }

        public String toString() {
            return "QuitBatchManage";
        }

        private QuitBatchManage() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$ForceRefresh;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ForceRefresh implements FavoritesPageEvent {
        public static final int $stable = 0;
        public static final ForceRefresh INSTANCE = new ForceRefresh();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ForceRefresh) {
                ForceRefresh forceRefresh = (ForceRefresh) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 118592571;
        }

        public String toString() {
            return "ForceRefresh";
        }

        private ForceRefresh() {
        }
    }

    /* compiled from: FavoritesEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent$SwitchLayoutType;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SwitchLayoutType implements FavoritesPageEvent {
        public static final int $stable = 0;
        public static final SwitchLayoutType INSTANCE = new SwitchLayoutType();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SwitchLayoutType) {
                SwitchLayoutType switchLayoutType = (SwitchLayoutType) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1354047779;
        }

        public String toString() {
            return "SwitchLayoutType";
        }

        private SwitchLayoutType() {
        }
    }
}