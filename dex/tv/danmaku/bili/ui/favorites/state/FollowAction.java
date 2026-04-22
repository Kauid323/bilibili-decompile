package tv.danmaku.bili.ui.favorites.state;

import BottomSheetItemData$;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.viewmodel.IUserAction;

/* compiled from: FavoritesAction.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FollowAction;", "Ltv/danmaku/bili/ui/favorites/viewmodel/IUserAction;", "Load", "Refresh", "Delete", "ClickItem", "Ltv/danmaku/bili/ui/favorites/state/FollowAction$ClickItem;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction$Delete;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction$Load;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction$Refresh;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FollowAction extends IUserAction {

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FollowAction$Load;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction;", "firstLoad", "", "<init>", "(Z)V", "getFirstLoad", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Load implements FollowAction {
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
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FollowAction$Refresh;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Refresh implements FollowAction {
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
            return -550453757;
        }

        public String toString() {
            return "Refresh";
        }

        private Refresh() {
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FollowAction$Delete;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction;", FavoritesConstsKt.POS, "", "<init>", "(I)V", "getPos", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Delete implements FollowAction {
        public static final int $stable = 0;
        private final int pos;

        public static /* synthetic */ Delete copy$default(Delete delete, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = delete.pos;
            }
            return delete.copy(i);
        }

        public final int component1() {
            return this.pos;
        }

        public final Delete copy(int i) {
            return new Delete(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Delete) && this.pos == ((Delete) obj).pos;
        }

        public int hashCode() {
            return this.pos;
        }

        public String toString() {
            return "Delete(pos=" + this.pos + ")";
        }

        public Delete(int pos) {
            this.pos = pos;
        }

        public final int getPos() {
            return this.pos;
        }
    }

    /* compiled from: FavoritesAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FollowAction$ClickItem;", "Ltv/danmaku/bili/ui/favorites/state/FollowAction;", FavoritesConstsKt.POS, "", "<init>", "(I)V", "getPos", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClickItem implements FollowAction {
        public static final int $stable = 0;
        private final int pos;

        public static /* synthetic */ ClickItem copy$default(ClickItem clickItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = clickItem.pos;
            }
            return clickItem.copy(i);
        }

        public final int component1() {
            return this.pos;
        }

        public final ClickItem copy(int i) {
            return new ClickItem(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickItem) && this.pos == ((ClickItem) obj).pos;
        }

        public int hashCode() {
            return this.pos;
        }

        public String toString() {
            return "ClickItem(pos=" + this.pos + ")";
        }

        public ClickItem(int pos) {
            this.pos = pos;
        }

        public final int getPos() {
            return this.pos;
        }
    }
}