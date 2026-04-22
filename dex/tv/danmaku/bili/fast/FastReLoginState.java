package tv.danmaku.bili.fast;

import BottomSheetItemData$;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/fast/FastReLoginState;", "", "account", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "loginProcessing", "", "agreementChecked", "showAgreementDialog", "<init>", "(Lcom/bilibili/lib/accounts/model/SimpleAccountItem;ZZZ)V", "getAccount", "()Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "getLoginProcessing", "()Z", "getAgreementChecked", "getShowAgreementDialog", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FastReLoginState {
    public static final int $stable = 8;
    private final SimpleAccountItem account;
    private final boolean agreementChecked;
    private final boolean loginProcessing;
    private final boolean showAgreementDialog;

    public static /* synthetic */ FastReLoginState copy$default(FastReLoginState fastReLoginState, SimpleAccountItem simpleAccountItem, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleAccountItem = fastReLoginState.account;
        }
        if ((i & 2) != 0) {
            z = fastReLoginState.loginProcessing;
        }
        if ((i & 4) != 0) {
            z2 = fastReLoginState.agreementChecked;
        }
        if ((i & 8) != 0) {
            z3 = fastReLoginState.showAgreementDialog;
        }
        return fastReLoginState.copy(simpleAccountItem, z, z2, z3);
    }

    public final SimpleAccountItem component1() {
        return this.account;
    }

    public final boolean component2() {
        return this.loginProcessing;
    }

    public final boolean component3() {
        return this.agreementChecked;
    }

    public final boolean component4() {
        return this.showAgreementDialog;
    }

    public final FastReLoginState copy(SimpleAccountItem simpleAccountItem, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(simpleAccountItem, "account");
        return new FastReLoginState(simpleAccountItem, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FastReLoginState) {
            FastReLoginState fastReLoginState = (FastReLoginState) obj;
            return Intrinsics.areEqual(this.account, fastReLoginState.account) && this.loginProcessing == fastReLoginState.loginProcessing && this.agreementChecked == fastReLoginState.agreementChecked && this.showAgreementDialog == fastReLoginState.showAgreementDialog;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.account.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loginProcessing)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.agreementChecked)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showAgreementDialog);
    }

    public String toString() {
        SimpleAccountItem simpleAccountItem = this.account;
        boolean z = this.loginProcessing;
        boolean z2 = this.agreementChecked;
        return "FastReLoginState(account=" + simpleAccountItem + ", loginProcessing=" + z + ", agreementChecked=" + z2 + ", showAgreementDialog=" + this.showAgreementDialog + ")";
    }

    public FastReLoginState(SimpleAccountItem account, boolean loginProcessing, boolean agreementChecked, boolean showAgreementDialog) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.account = account;
        this.loginProcessing = loginProcessing;
        this.agreementChecked = agreementChecked;
        this.showAgreementDialog = showAgreementDialog;
    }

    public /* synthetic */ FastReLoginState(SimpleAccountItem simpleAccountItem, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleAccountItem, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    public final SimpleAccountItem getAccount() {
        return this.account;
    }

    public final boolean getLoginProcessing() {
        return this.loginProcessing;
    }

    public final boolean getAgreementChecked() {
        return this.agreementChecked;
    }

    public final boolean getShowAgreementDialog() {
        return this.showAgreementDialog;
    }
}