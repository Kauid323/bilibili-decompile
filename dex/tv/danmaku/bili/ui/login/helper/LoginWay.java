package tv.danmaku.bili.ui.login.helper;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000e\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0086\bø\u0001\u0000J\u001a\u0010\u0011\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0086\bø\u0001\u0000J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/LoginWay;", "", "value", "", "quick", "", "sms", "<init>", "(IZZ)V", "getValue", "()I", "getQuick", "()Z", "getSms", "disableQuickOn", "condition", "Lkotlin/Function0;", "disableSmsOn", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginWay {
    public static final int $stable = 0;
    private final boolean quick;
    private final boolean sms;
    private final int value;

    public static /* synthetic */ LoginWay copy$default(LoginWay loginWay, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = loginWay.value;
        }
        if ((i2 & 2) != 0) {
            z = loginWay.quick;
        }
        if ((i2 & 4) != 0) {
            z2 = loginWay.sms;
        }
        return loginWay.copy(i, z, z2);
    }

    public final int component1() {
        return this.value;
    }

    public final boolean component2() {
        return this.quick;
    }

    public final boolean component3() {
        return this.sms;
    }

    public final LoginWay copy(int i, boolean z, boolean z2) {
        return new LoginWay(i, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LoginWay) {
            LoginWay loginWay = (LoginWay) obj;
            return this.value == loginWay.value && this.quick == loginWay.quick && this.sms == loginWay.sms;
        }
        return false;
    }

    public int hashCode() {
        return (((this.value * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.quick)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.sms);
    }

    public String toString() {
        int i = this.value;
        boolean z = this.quick;
        return "LoginWay(value=" + i + ", quick=" + z + ", sms=" + this.sms + ")";
    }

    public LoginWay(int value, boolean quick, boolean sms) {
        this.value = value;
        this.quick = quick;
        this.sms = sms;
    }

    public /* synthetic */ LoginWay(int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? true : z2);
    }

    public final boolean getQuick() {
        return this.quick;
    }

    public final boolean getSms() {
        return this.sms;
    }

    public final int getValue() {
        return this.value;
    }

    public final LoginWay disableQuickOn(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        return ((Boolean) function0.invoke()).booleanValue() ? copy$default(this, 0, false, false, 5, null) : this;
    }

    public final LoginWay disableSmsOn(Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "condition");
        return ((Boolean) function0.invoke()).booleanValue() ? copy$default(this, 0, false, false, 3, null) : this;
    }
}