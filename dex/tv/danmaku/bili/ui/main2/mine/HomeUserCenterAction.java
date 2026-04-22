package tv.danmaku.bili.ui.main2.mine;

import BottomSheetItemData$;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.ui.garb.Garb;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.api.AccountMine;

/* compiled from: HomeUserCenterViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction;", "", "Update", "ClearForLogStatusChanged", "Init", "OnSkinChanged", "PageVisibilityChange", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$ClearForLogStatusChanged;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$Init;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$OnSkinChanged;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$PageVisibilityChange;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$Update;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface HomeUserCenterAction {

    /* compiled from: HomeUserCenterViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$Update;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction;", "accountMine", "Ltv/danmaku/bili/ui/main2/api/AccountMine;", "fromCache", "", "<init>", "(Ltv/danmaku/bili/ui/main2/api/AccountMine;Z)V", "getAccountMine", "()Ltv/danmaku/bili/ui/main2/api/AccountMine;", "getFromCache", "()Z", "toString", "", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Update implements HomeUserCenterAction {
        public static final int $stable = 8;
        private final AccountMine accountMine;
        private final boolean fromCache;

        public static /* synthetic */ Update copy$default(Update update, AccountMine accountMine, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                accountMine = update.accountMine;
            }
            if ((i & 2) != 0) {
                z = update.fromCache;
            }
            return update.copy(accountMine, z);
        }

        public final AccountMine component1() {
            return this.accountMine;
        }

        public final boolean component2() {
            return this.fromCache;
        }

        public final Update copy(AccountMine accountMine, boolean z) {
            return new Update(accountMine, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Update) {
                Update update = (Update) obj;
                return Intrinsics.areEqual(this.accountMine, update.accountMine) && this.fromCache == update.fromCache;
            }
            return false;
        }

        public int hashCode() {
            return ((this.accountMine == null ? 0 : this.accountMine.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fromCache);
        }

        public Update(AccountMine accountMine, boolean fromCache) {
            this.accountMine = accountMine;
            this.fromCache = fromCache;
        }

        public /* synthetic */ Update(AccountMine accountMine, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(accountMine, (i & 2) != 0 ? false : z);
        }

        public final AccountMine getAccountMine() {
            return this.accountMine;
        }

        public final boolean getFromCache() {
            return this.fromCache;
        }

        public String toString() {
            AccountMine accountMine = this.accountMine;
            return "Update(accountMine=" + (accountMine != null ? Integer.valueOf(accountMine.hashCode()) : null) + ", fromCache=" + this.fromCache + ")";
        }
    }

    /* compiled from: HomeUserCenterViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$ClearForLogStatusChanged;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction;", "topic", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "<init>", "(Lcom/bilibili/lib/accounts/subscribe/Topic;)V", "getTopic", "()Lcom/bilibili/lib/accounts/subscribe/Topic;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ClearForLogStatusChanged implements HomeUserCenterAction {
        public static final int $stable = 0;
        private final Topic topic;

        public static /* synthetic */ ClearForLogStatusChanged copy$default(ClearForLogStatusChanged clearForLogStatusChanged, Topic topic, int i, Object obj) {
            if ((i & 1) != 0) {
                topic = clearForLogStatusChanged.topic;
            }
            return clearForLogStatusChanged.copy(topic);
        }

        public final Topic component1() {
            return this.topic;
        }

        public final ClearForLogStatusChanged copy(Topic topic) {
            Intrinsics.checkNotNullParameter(topic, "topic");
            return new ClearForLogStatusChanged(topic);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClearForLogStatusChanged) && this.topic == ((ClearForLogStatusChanged) obj).topic;
        }

        public int hashCode() {
            return this.topic.hashCode();
        }

        public String toString() {
            return "ClearForLogStatusChanged(topic=" + this.topic + ")";
        }

        public ClearForLogStatusChanged(Topic topic) {
            Intrinsics.checkNotNullParameter(topic, "topic");
            this.topic = topic;
        }

        public final Topic getTopic() {
            return this.topic;
        }
    }

    /* compiled from: HomeUserCenterViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$Init;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Init implements HomeUserCenterAction {
        public static final int $stable = 0;
        public static final Init INSTANCE = new Init();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Init) {
                Init init = (Init) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 952743102;
        }

        public String toString() {
            return "Init";
        }

        private Init() {
        }
    }

    /* compiled from: HomeUserCenterViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$OnSkinChanged;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction;", "garb", "Lcom/bilibili/lib/ui/garb/Garb;", "<init>", "(Lcom/bilibili/lib/ui/garb/Garb;)V", "getGarb", "()Lcom/bilibili/lib/ui/garb/Garb;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OnSkinChanged implements HomeUserCenterAction {
        public static final int $stable = 8;
        private final Garb garb;

        public static /* synthetic */ OnSkinChanged copy$default(OnSkinChanged onSkinChanged, Garb garb, int i, Object obj) {
            if ((i & 1) != 0) {
                garb = onSkinChanged.garb;
            }
            return onSkinChanged.copy(garb);
        }

        public final Garb component1() {
            return this.garb;
        }

        public final OnSkinChanged copy(Garb garb) {
            Intrinsics.checkNotNullParameter(garb, "garb");
            return new OnSkinChanged(garb);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSkinChanged) && Intrinsics.areEqual(this.garb, ((OnSkinChanged) obj).garb);
        }

        public int hashCode() {
            return this.garb.hashCode();
        }

        public String toString() {
            return "OnSkinChanged(garb=" + this.garb + ")";
        }

        public OnSkinChanged(Garb garb) {
            Intrinsics.checkNotNullParameter(garb, "garb");
            this.garb = garb;
        }

        public final Garb getGarb() {
            return this.garb;
        }
    }

    /* compiled from: HomeUserCenterViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction$PageVisibilityChange;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAction;", "visible", "", "<init>", "(Z)V", "getVisible", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PageVisibilityChange implements HomeUserCenterAction {
        public static final int $stable = 0;
        private final boolean visible;

        public static /* synthetic */ PageVisibilityChange copy$default(PageVisibilityChange pageVisibilityChange, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = pageVisibilityChange.visible;
            }
            return pageVisibilityChange.copy(z);
        }

        public final boolean component1() {
            return this.visible;
        }

        public final PageVisibilityChange copy(boolean z) {
            return new PageVisibilityChange(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PageVisibilityChange) && this.visible == ((PageVisibilityChange) obj).visible;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.visible);
        }

        public String toString() {
            return "PageVisibilityChange(visible=" + this.visible + ")";
        }

        public PageVisibilityChange(boolean visible) {
            this.visible = visible;
        }

        public final boolean getVisible() {
            return this.visible;
        }
    }
}