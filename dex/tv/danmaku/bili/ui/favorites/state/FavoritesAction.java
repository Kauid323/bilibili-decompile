package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import com.bilibili.playset.api.TranslatableData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;
import tv.danmaku.bili.ui.favorites.viewmodel.IUserAction;

/* compiled from: FavoritesAction.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0014\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0082\u0001\u0014\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUserAction;", "Load", "Refresh", "CancelAllChecked", "DeleteItem", "ClearInvalidVideo", "ClearAllInvalidVideo", "DeleteChecked", "ClickDelete", "CopyTo", "MoveTo", "SortItems", "ClickItem", "StartBatchManage", "QuitBatchManage", "DirectlyBatchManage", "CheckItem", "CheckAll", "SortedUpdate", "GotoEmpty", "SwitchTranslate", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CancelAllChecked;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CheckAll;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CheckItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClearAllInvalidVideo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClearInvalidVideo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClickDelete;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClickItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CopyTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$DeleteChecked;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$DeleteItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$DirectlyBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$GotoEmpty;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$Load;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$MoveTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$QuitBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$Refresh;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$SortItems;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$SortedUpdate;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$StartBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$SwitchTranslate;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FavoritesAction extends IUserAction {

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$Load;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "firstLoad", "", "<init>", "(Z)V", "getFirstLoad", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Load implements FavoritesAction {
        public static final int $stable = 0;
        private final boolean firstLoad;

        public static /* synthetic */ Load copy$default(Load load, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = load.firstLoad;
            }
            return load.copy(z);
        }

        public final boolean component1() {
            return this.firstLoad;
        }

        public final Load copy(boolean z) {
            return new Load(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Load) && this.firstLoad == ((Load) obj).firstLoad;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.firstLoad);
        }

        public String toString() {
            return "Load(firstLoad=" + this.firstLoad + ")";
        }

        public Load(boolean firstLoad) {
            this.firstLoad = firstLoad;
        }

        public final boolean getFirstLoad() {
            return this.firstLoad;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$Refresh;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Refresh implements FavoritesAction {
        public static final int $stable = 0;
        public static final Refresh INSTANCE = new Refresh();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Refresh) {
                Refresh refresh = (Refresh) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2029370859;
        }

        public String toString() {
            return "Refresh";
        }

        private Refresh() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CancelAllChecked;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CancelAllChecked implements FavoritesAction {
        public static final int $stable = 0;
        public static final CancelAllChecked INSTANCE = new CancelAllChecked();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CancelAllChecked) {
                CancelAllChecked cancelAllChecked = (CancelAllChecked) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1589970896;
        }

        public String toString() {
            return "CancelAllChecked";
        }

        private CancelAllChecked() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$DeleteItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;)V", "getItem", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DeleteItem implements FavoritesAction {
        public static final int $stable = 8;
        private final FavoritesMediasItem item;

        public static /* synthetic */ DeleteItem copy$default(DeleteItem deleteItem, FavoritesMediasItem favoritesMediasItem, int i, Object obj) {
            if ((i & 1) != 0) {
                favoritesMediasItem = deleteItem.item;
            }
            return deleteItem.copy(favoritesMediasItem);
        }

        public final FavoritesMediasItem component1() {
            return this.item;
        }

        public final DeleteItem copy(FavoritesMediasItem favoritesMediasItem) {
            Intrinsics.checkNotNullParameter(favoritesMediasItem, "item");
            return new DeleteItem(favoritesMediasItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteItem) && Intrinsics.areEqual(this.item, ((DeleteItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "DeleteItem(item=" + this.item + ")";
        }

        public DeleteItem(FavoritesMediasItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final FavoritesMediasItem getItem() {
            return this.item;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClearInvalidVideo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;)V", "getItem", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClearInvalidVideo implements FavoritesAction {
        public static final int $stable = 8;
        private final FavoritesMediasItem item;

        public static /* synthetic */ ClearInvalidVideo copy$default(ClearInvalidVideo clearInvalidVideo, FavoritesMediasItem favoritesMediasItem, int i, Object obj) {
            if ((i & 1) != 0) {
                favoritesMediasItem = clearInvalidVideo.item;
            }
            return clearInvalidVideo.copy(favoritesMediasItem);
        }

        public final FavoritesMediasItem component1() {
            return this.item;
        }

        public final ClearInvalidVideo copy(FavoritesMediasItem favoritesMediasItem) {
            Intrinsics.checkNotNullParameter(favoritesMediasItem, "item");
            return new ClearInvalidVideo(favoritesMediasItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClearInvalidVideo) && Intrinsics.areEqual(this.item, ((ClearInvalidVideo) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClearInvalidVideo(item=" + this.item + ")";
        }

        public ClearInvalidVideo(FavoritesMediasItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final FavoritesMediasItem getItem() {
            return this.item;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClearAllInvalidVideo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;)V", "getItem", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClearAllInvalidVideo implements FavoritesAction {
        public static final int $stable = 8;
        private final FavoritesMediasItem item;

        public static /* synthetic */ ClearAllInvalidVideo copy$default(ClearAllInvalidVideo clearAllInvalidVideo, FavoritesMediasItem favoritesMediasItem, int i, Object obj) {
            if ((i & 1) != 0) {
                favoritesMediasItem = clearAllInvalidVideo.item;
            }
            return clearAllInvalidVideo.copy(favoritesMediasItem);
        }

        public final FavoritesMediasItem component1() {
            return this.item;
        }

        public final ClearAllInvalidVideo copy(FavoritesMediasItem favoritesMediasItem) {
            Intrinsics.checkNotNullParameter(favoritesMediasItem, "item");
            return new ClearAllInvalidVideo(favoritesMediasItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClearAllInvalidVideo) && Intrinsics.areEqual(this.item, ((ClearAllInvalidVideo) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClearAllInvalidVideo(item=" + this.item + ")";
        }

        public ClearAllInvalidVideo(FavoritesMediasItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final FavoritesMediasItem getItem() {
            return this.item;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$DeleteChecked;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DeleteChecked implements FavoritesAction {
        public static final int $stable = 0;
        public static final DeleteChecked INSTANCE = new DeleteChecked();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteChecked) {
                DeleteChecked deleteChecked = (DeleteChecked) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -731587956;
        }

        public String toString() {
            return "DeleteChecked";
        }

        private DeleteChecked() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClickDelete;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClickDelete implements FavoritesAction {
        public static final int $stable = 0;
        public static final ClickDelete INSTANCE = new ClickDelete();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClickDelete) {
                ClickDelete clickDelete = (ClickDelete) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -214952861;
        }

        public String toString() {
            return "ClickDelete";
        }

        private ClickDelete() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CopyTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CopyTo implements FavoritesAction {
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
            return -77339712;
        }

        public String toString() {
            return "CopyTo";
        }

        private CopyTo() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$MoveTo;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class MoveTo implements FavoritesAction {
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
            return 209111324;
        }

        public String toString() {
            return "MoveTo";
        }

        private MoveTo() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$SortItems;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SortItems implements FavoritesAction {
        public static final int $stable = 0;
        public static final SortItems INSTANCE = new SortItems();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SortItems) {
                SortItems sortItems = (SortItems) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 842562514;
        }

        public String toString() {
            return "SortItems";
        }

        private SortItems() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$ClickItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "item", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", FavoritesConstsKt.POS, "", "<init>", "(Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;I)V", "getItem", "()Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "getPos", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClickItem implements FavoritesAction {
        public static final int $stable = 8;
        private final FavoritesMediasItem item;
        private final int pos;

        public static /* synthetic */ ClickItem copy$default(ClickItem clickItem, FavoritesMediasItem favoritesMediasItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                favoritesMediasItem = clickItem.item;
            }
            if ((i2 & 2) != 0) {
                i = clickItem.pos;
            }
            return clickItem.copy(favoritesMediasItem, i);
        }

        public final FavoritesMediasItem component1() {
            return this.item;
        }

        public final int component2() {
            return this.pos;
        }

        public final ClickItem copy(FavoritesMediasItem favoritesMediasItem, int i) {
            Intrinsics.checkNotNullParameter(favoritesMediasItem, "item");
            return new ClickItem(favoritesMediasItem, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ClickItem) {
                ClickItem clickItem = (ClickItem) obj;
                return Intrinsics.areEqual(this.item, clickItem.item) && this.pos == clickItem.pos;
            }
            return false;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.pos;
        }

        public String toString() {
            FavoritesMediasItem favoritesMediasItem = this.item;
            return "ClickItem(item=" + favoritesMediasItem + ", pos=" + this.pos + ")";
        }

        public ClickItem(FavoritesMediasItem item, int pos) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
            this.pos = pos;
        }

        public final FavoritesMediasItem getItem() {
            return this.item;
        }

        public final int getPos() {
            return this.pos;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$StartBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StartBatchManage implements FavoritesAction {
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
            return -1512012179;
        }

        public String toString() {
            return "StartBatchManage";
        }

        private StartBatchManage() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$QuitBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class QuitBatchManage implements FavoritesAction {
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
            return -1862601088;
        }

        public String toString() {
            return "QuitBatchManage";
        }

        private QuitBatchManage() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$DirectlyBatchManage;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class DirectlyBatchManage implements FavoritesAction {
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
            return 1703933753;
        }

        public String toString() {
            return "DirectlyBatchManage";
        }

        private DirectlyBatchManage() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CheckItem;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", FavoritesConstsKt.POS, "", "<init>", "(I)V", "getPos", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CheckItem implements FavoritesAction {
        public static final int $stable = 0;
        private final int pos;

        public static /* synthetic */ CheckItem copy$default(CheckItem checkItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = checkItem.pos;
            }
            return checkItem.copy(i);
        }

        public final int component1() {
            return this.pos;
        }

        public final CheckItem copy(int i) {
            return new CheckItem(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckItem) && this.pos == ((CheckItem) obj).pos;
        }

        public int hashCode() {
            return this.pos;
        }

        public String toString() {
            return "CheckItem(pos=" + this.pos + ")";
        }

        public CheckItem(int pos) {
            this.pos = pos;
        }

        public final int getPos() {
            return this.pos;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$CheckAll;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CheckAll implements FavoritesAction {
        public static final int $stable = 0;
        public static final CheckAll INSTANCE = new CheckAll();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CheckAll) {
                CheckAll checkAll = (CheckAll) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 733795945;
        }

        public String toString() {
            return "CheckAll";
        }

        private CheckAll() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$SortedUpdate;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "list", "", "Ltv/danmaku/bili/ui/favorites/model/FavoritesMediasItem;", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SortedUpdate implements FavoritesAction {
        public static final int $stable = 8;
        private final List<FavoritesMediasItem> list;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SortedUpdate copy$default(SortedUpdate sortedUpdate, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sortedUpdate.list;
            }
            return sortedUpdate.copy(list);
        }

        public final List<FavoritesMediasItem> component1() {
            return this.list;
        }

        public final SortedUpdate copy(List<FavoritesMediasItem> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            return new SortedUpdate(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SortedUpdate) && Intrinsics.areEqual(this.list, ((SortedUpdate) obj).list);
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public String toString() {
            return "SortedUpdate(list=" + this.list + ")";
        }

        public SortedUpdate(List<FavoritesMediasItem> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        public final List<FavoritesMediasItem> getList() {
            return this.list;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$GotoEmpty;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GotoEmpty implements FavoritesAction {
        public static final int $stable = 0;
        public static final GotoEmpty INSTANCE = new GotoEmpty();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GotoEmpty) {
                GotoEmpty gotoEmpty = (GotoEmpty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1609817926;
        }

        public String toString() {
            return "GotoEmpty";
        }

        private GotoEmpty() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavoritesAction$SwitchTranslate;", "Ltv/danmaku/bili/ui/favorites/state/FavoritesAction;", "item", "Lcom/bilibili/playset/api/TranslatableData;", "<init>", "(Lcom/bilibili/playset/api/TranslatableData;)V", "getItem", "()Lcom/bilibili/playset/api/TranslatableData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class SwitchTranslate implements FavoritesAction {
        public static final int $stable = 8;
        private final TranslatableData item;

        public static /* synthetic */ SwitchTranslate copy$default(SwitchTranslate switchTranslate, TranslatableData translatableData, int i, Object obj) {
            if ((i & 1) != 0) {
                translatableData = switchTranslate.item;
            }
            return switchTranslate.copy(translatableData);
        }

        public final TranslatableData component1() {
            return this.item;
        }

        public final SwitchTranslate copy(TranslatableData translatableData) {
            Intrinsics.checkNotNullParameter(translatableData, "item");
            return new SwitchTranslate(translatableData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchTranslate) && Intrinsics.areEqual(this.item, ((SwitchTranslate) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "SwitchTranslate(item=" + this.item + ")";
        }

        public SwitchTranslate(TranslatableData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final TranslatableData getItem() {
            return this.item;
        }
    }
}