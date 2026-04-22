package tv.danmaku.bili.ui.favorites.state;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.viewmodel.IUserAction;

/* compiled from: FavoritesAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUserAction;", "StartBatchManage", "QuitBatchManage", "ShowFolderTab", "ShowFavTab", "ForceRefresh", "GetTabData", "SwitchLayoutType", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$ForceRefresh;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$GetTabData;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$QuitBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$ShowFavTab;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$ShowFolderTab;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$StartBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$SwitchLayoutType;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FavoritesPageAction extends IUserAction {

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$StartBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StartBatchManage implements FavoritesPageAction {
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
            return 2142682846;
        }

        public String toString() {
            return "StartBatchManage";
        }

        private StartBatchManage() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$QuitBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class QuitBatchManage implements FavoritesPageAction {
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
            return 1580428271;
        }

        public String toString() {
            return "QuitBatchManage";
        }

        private QuitBatchManage() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$ShowFolderTab;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowFolderTab implements FavoritesPageAction {
        public static final int $stable = 0;
        public static final ShowFolderTab INSTANCE = new ShowFolderTab();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowFolderTab) {
                ShowFolderTab showFolderTab = (ShowFolderTab) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2146869769;
        }

        public String toString() {
            return "ShowFolderTab";
        }

        private ShowFolderTab() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$ShowFavTab;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "type", "", "<init>", "(I)V", "getType", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ShowFavTab implements FavoritesPageAction {
        public static final int $stable = 0;
        private final int type;

        public static /* synthetic */ ShowFavTab copy$default(ShowFavTab showFavTab, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = showFavTab.type;
            }
            return showFavTab.copy(i);
        }

        public final int component1() {
            return this.type;
        }

        public final ShowFavTab copy(int i) {
            return new ShowFavTab(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowFavTab) && this.type == ((ShowFavTab) obj).type;
        }

        public int hashCode() {
            return this.type;
        }

        public String toString() {
            return "ShowFavTab(type=" + this.type + ")";
        }

        public ShowFavTab(int type) {
            this.type = type;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$ForceRefresh;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ForceRefresh implements FavoritesPageAction {
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
            return -1383470767;
        }

        public String toString() {
            return "ForceRefresh";
        }

        private ForceRefresh() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$GetTabData;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "defaultTabId", "", "<init>", "(I)V", "getDefaultTabId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GetTabData implements FavoritesPageAction {
        public static final int $stable = 0;
        private final int defaultTabId;

        public static /* synthetic */ GetTabData copy$default(GetTabData getTabData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = getTabData.defaultTabId;
            }
            return getTabData.copy(i);
        }

        public final int component1() {
            return this.defaultTabId;
        }

        public final GetTabData copy(int i) {
            return new GetTabData(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetTabData) && this.defaultTabId == ((GetTabData) obj).defaultTabId;
        }

        public int hashCode() {
            return this.defaultTabId;
        }

        public String toString() {
            return "GetTabData(defaultTabId=" + this.defaultTabId + ")";
        }

        public GetTabData(int defaultTabId) {
            this.defaultTabId = defaultTabId;
        }

        public final int getDefaultTabId() {
            return this.defaultTabId;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction$SwitchLayoutType;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesPageAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SwitchLayoutType implements FavoritesPageAction {
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
            return -1439630535;
        }

        public String toString() {
            return "SwitchLayoutType";
        }

        private SwitchLayoutType() {
        }
    }
}