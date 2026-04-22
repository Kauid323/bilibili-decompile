package tv.danmaku.bili.change;

import BottomSheetItemData$;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: AccountSwitchPage.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JK\u0010!\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006'"}, d2 = {"Ltv/danmaku/bili/change/AccountSwitchPage;", "", "accountList", "", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "editMode", "", "maxAccount", "", "currentUserIndex", "loadingDialog", "accountLoadState", "Ltv/danmaku/bili/change/AccountLoadState;", "<init>", "(Ljava/util/List;ZIIZLtv/danmaku/bili/change/AccountLoadState;)V", "getAccountList", "()Ljava/util/List;", "getEditMode", "()Z", "getMaxAccount", "()I", "getCurrentUserIndex", "getLoadingDialog", "getAccountLoadState", "()Ltv/danmaku/bili/change/AccountLoadState;", "showAddButton", "getShowAddButton", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountSwitchPage {
    public static final int $stable = 8;
    private final List<SimpleAccountItem> accountList;
    private final AccountLoadState accountLoadState;
    private final int currentUserIndex;
    private final boolean editMode;
    private final boolean loadingDialog;
    private final int maxAccount;
    private final boolean showAddButton;

    public AccountSwitchPage() {
        this(null, false, 0, 0, false, null, 63, null);
    }

    public static /* synthetic */ AccountSwitchPage copy$default(AccountSwitchPage accountSwitchPage, List list, boolean z, int i, int i2, boolean z2, AccountLoadState accountLoadState, int i3, Object obj) {
        List<SimpleAccountItem> list2 = list;
        if ((i3 & 1) != 0) {
            list2 = accountSwitchPage.accountList;
        }
        if ((i3 & 2) != 0) {
            z = accountSwitchPage.editMode;
        }
        boolean z3 = z;
        if ((i3 & 4) != 0) {
            i = accountSwitchPage.maxAccount;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = accountSwitchPage.currentUserIndex;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            z2 = accountSwitchPage.loadingDialog;
        }
        boolean z4 = z2;
        if ((i3 & 32) != 0) {
            accountLoadState = accountSwitchPage.accountLoadState;
        }
        return accountSwitchPage.copy(list2, z3, i4, i5, z4, accountLoadState);
    }

    public final List<SimpleAccountItem> component1() {
        return this.accountList;
    }

    public final boolean component2() {
        return this.editMode;
    }

    public final int component3() {
        return this.maxAccount;
    }

    public final int component4() {
        return this.currentUserIndex;
    }

    public final boolean component5() {
        return this.loadingDialog;
    }

    public final AccountLoadState component6() {
        return this.accountLoadState;
    }

    public final AccountSwitchPage copy(List<SimpleAccountItem> list, boolean z, int i, int i2, boolean z2, AccountLoadState accountLoadState) {
        Intrinsics.checkNotNullParameter(list, "accountList");
        Intrinsics.checkNotNullParameter(accountLoadState, "accountLoadState");
        return new AccountSwitchPage(list, z, i, i2, z2, accountLoadState);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountSwitchPage) {
            AccountSwitchPage accountSwitchPage = (AccountSwitchPage) obj;
            return Intrinsics.areEqual(this.accountList, accountSwitchPage.accountList) && this.editMode == accountSwitchPage.editMode && this.maxAccount == accountSwitchPage.maxAccount && this.currentUserIndex == accountSwitchPage.currentUserIndex && this.loadingDialog == accountSwitchPage.loadingDialog && this.accountLoadState == accountSwitchPage.accountLoadState;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.accountList.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.editMode)) * 31) + this.maxAccount) * 31) + this.currentUserIndex) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loadingDialog)) * 31) + this.accountLoadState.hashCode();
    }

    public String toString() {
        List<SimpleAccountItem> list = this.accountList;
        boolean z = this.editMode;
        int i = this.maxAccount;
        int i2 = this.currentUserIndex;
        boolean z2 = this.loadingDialog;
        return "AccountSwitchPage(accountList=" + list + ", editMode=" + z + ", maxAccount=" + i + ", currentUserIndex=" + i2 + ", loadingDialog=" + z2 + ", accountLoadState=" + this.accountLoadState + ")";
    }

    public AccountSwitchPage(List<SimpleAccountItem> list, boolean editMode, int maxAccount, int currentUserIndex, boolean loadingDialog, AccountLoadState accountLoadState) {
        Intrinsics.checkNotNullParameter(list, "accountList");
        Intrinsics.checkNotNullParameter(accountLoadState, "accountLoadState");
        this.accountList = list;
        this.editMode = editMode;
        this.maxAccount = maxAccount;
        this.currentUserIndex = currentUserIndex;
        this.loadingDialog = loadingDialog;
        this.accountLoadState = accountLoadState;
        this.showAddButton = this.accountList.size() < this.maxAccount;
    }

    public /* synthetic */ AccountSwitchPage(List list, boolean z, int i, int i2, boolean z2, AccountLoadState accountLoadState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? 5 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) == 0 ? z2 : false, (i3 & 32) != 0 ? AccountLoadState.LOADING : accountLoadState);
    }

    public final List<SimpleAccountItem> getAccountList() {
        return this.accountList;
    }

    public final boolean getEditMode() {
        return this.editMode;
    }

    public final int getMaxAccount() {
        return this.maxAccount;
    }

    public final int getCurrentUserIndex() {
        return this.currentUserIndex;
    }

    public final boolean getLoadingDialog() {
        return this.loadingDialog;
    }

    public final AccountLoadState getAccountLoadState() {
        return this.accountLoadState;
    }

    public final boolean getShowAddButton() {
        return this.showAddButton;
    }
}