package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.model.FavoritesFolderItem;
import tv.danmaku.bili.ui.favorites.viewmodel.IUserAction;

/* compiled from: FavoritesAction.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderAction;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUserAction;", "Load", "ToTop", "SwitchLayoutType", "Ltv/danmaku/bili/ui/favorites/state/FolderAction$Load;", "Ltv/danmaku/bili/ui/favorites/state/FolderAction$SwitchLayoutType;", "Ltv/danmaku/bili/ui/favorites/state/FolderAction$ToTop;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FolderAction extends IUserAction {

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderAction$Load;", "Ltv/danmaku/bili/ui/favorites/state/FolderAction;", "isRefresh", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Load implements FolderAction {
        public static final int $stable = 0;
        private final boolean isRefresh;

        public static /* synthetic */ Load copy$default(Load load, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = load.isRefresh;
            }
            return load.copy(z);
        }

        public final boolean component1() {
            return this.isRefresh;
        }

        public final Load copy(boolean z) {
            return new Load(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Load) && this.isRefresh == ((Load) obj).isRefresh;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRefresh);
        }

        public String toString() {
            return "Load(isRefresh=" + this.isRefresh + ")";
        }

        public Load(boolean isRefresh) {
            this.isRefresh = isRefresh;
        }

        public final boolean isRefresh() {
            return this.isRefresh;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderAction$ToTop;", "Ltv/danmaku/bili/ui/favorites/state/FolderAction;", "data", "Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;)V", "getData", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesFolderItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ToTop implements FolderAction {
        public static final int $stable = 8;
        private final FavoritesFolderItem data;

        public static /* synthetic */ ToTop copy$default(ToTop toTop, FavoritesFolderItem favoritesFolderItem, int i, Object obj) {
            if ((i & 1) != 0) {
                favoritesFolderItem = toTop.data;
            }
            return toTop.copy(favoritesFolderItem);
        }

        public final FavoritesFolderItem component1() {
            return this.data;
        }

        public final ToTop copy(FavoritesFolderItem favoritesFolderItem) {
            Intrinsics.checkNotNullParameter(favoritesFolderItem, "data");
            return new ToTop(favoritesFolderItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToTop) && Intrinsics.areEqual(this.data, ((ToTop) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "ToTop(data=" + this.data + ")";
        }

        public ToTop(FavoritesFolderItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final FavoritesFolderItem getData() {
            return this.data;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FolderAction$SwitchLayoutType;", "Ltv/danmaku/bili/ui/favorites/state/FolderAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SwitchLayoutType implements FolderAction {
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
            return -22218669;
        }

        public String toString() {
            return "SwitchLayoutType";
        }

        private SwitchLayoutType() {
        }
    }
}