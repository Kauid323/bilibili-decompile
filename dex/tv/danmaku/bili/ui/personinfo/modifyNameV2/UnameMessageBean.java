package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UnameMessageBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/UnameMessageBean;", "", "allow", "", "realNameOrTel", "uMsg", "", "confirmMessage", "conditionMessage", "bindTel", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllow", "()Z", "setAllow", "(Z)V", "getRealNameOrTel", "setRealNameOrTel", "getUMsg", "()Ljava/lang/String;", "setUMsg", "(Ljava/lang/String;)V", "getConfirmMessage", "setConfirmMessage", "getConditionMessage", "setConditionMessage", "getBindTel", "setBindTel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UnameMessageBean {
    public static final int $stable = 8;
    private boolean allow;
    private String bindTel;
    private String conditionMessage;
    private String confirmMessage;
    private boolean realNameOrTel;
    private String uMsg;

    public UnameMessageBean() {
        this(false, false, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UnameMessageBean copy$default(UnameMessageBean unameMessageBean, boolean z, boolean z2, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = unameMessageBean.allow;
        }
        if ((i & 2) != 0) {
            z2 = unameMessageBean.realNameOrTel;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            str = unameMessageBean.uMsg;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = unameMessageBean.confirmMessage;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = unameMessageBean.conditionMessage;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = unameMessageBean.bindTel;
        }
        return unameMessageBean.copy(z, z3, str5, str6, str7, str4);
    }

    public final boolean component1() {
        return this.allow;
    }

    public final boolean component2() {
        return this.realNameOrTel;
    }

    public final String component3() {
        return this.uMsg;
    }

    public final String component4() {
        return this.confirmMessage;
    }

    public final String component5() {
        return this.conditionMessage;
    }

    public final String component6() {
        return this.bindTel;
    }

    public final UnameMessageBean copy(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "uMsg");
        Intrinsics.checkNotNullParameter(str2, "confirmMessage");
        Intrinsics.checkNotNullParameter(str3, "conditionMessage");
        Intrinsics.checkNotNullParameter(str4, "bindTel");
        return new UnameMessageBean(z, z2, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnameMessageBean) {
            UnameMessageBean unameMessageBean = (UnameMessageBean) obj;
            return this.allow == unameMessageBean.allow && this.realNameOrTel == unameMessageBean.realNameOrTel && Intrinsics.areEqual(this.uMsg, unameMessageBean.uMsg) && Intrinsics.areEqual(this.confirmMessage, unameMessageBean.confirmMessage) && Intrinsics.areEqual(this.conditionMessage, unameMessageBean.conditionMessage) && Intrinsics.areEqual(this.bindTel, unameMessageBean.bindTel);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.allow) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.realNameOrTel)) * 31) + this.uMsg.hashCode()) * 31) + this.confirmMessage.hashCode()) * 31) + this.conditionMessage.hashCode()) * 31) + this.bindTel.hashCode();
    }

    public String toString() {
        boolean z = this.allow;
        boolean z2 = this.realNameOrTel;
        String str = this.uMsg;
        String str2 = this.confirmMessage;
        String str3 = this.conditionMessage;
        return "UnameMessageBean(allow=" + z + ", realNameOrTel=" + z2 + ", uMsg=" + str + ", confirmMessage=" + str2 + ", conditionMessage=" + str3 + ", bindTel=" + this.bindTel + ")";
    }

    public UnameMessageBean(boolean allow, boolean realNameOrTel, String uMsg, String confirmMessage, String conditionMessage, String bindTel) {
        Intrinsics.checkNotNullParameter(uMsg, "uMsg");
        Intrinsics.checkNotNullParameter(confirmMessage, "confirmMessage");
        Intrinsics.checkNotNullParameter(conditionMessage, "conditionMessage");
        Intrinsics.checkNotNullParameter(bindTel, "bindTel");
        this.allow = allow;
        this.realNameOrTel = realNameOrTel;
        this.uMsg = uMsg;
        this.confirmMessage = confirmMessage;
        this.conditionMessage = conditionMessage;
        this.bindTel = bindTel;
    }

    public /* synthetic */ UnameMessageBean(boolean z, boolean z2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) == 0 ? str4 : "");
    }

    public final boolean getAllow() {
        return this.allow;
    }

    public final void setAllow(boolean z) {
        this.allow = z;
    }

    public final boolean getRealNameOrTel() {
        return this.realNameOrTel;
    }

    public final void setRealNameOrTel(boolean z) {
        this.realNameOrTel = z;
    }

    public final String getUMsg() {
        return this.uMsg;
    }

    public final void setUMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uMsg = str;
    }

    public final String getConfirmMessage() {
        return this.confirmMessage;
    }

    public final void setConfirmMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.confirmMessage = str;
    }

    public final String getConditionMessage() {
        return this.conditionMessage;
    }

    public final void setConditionMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.conditionMessage = str;
    }

    public final String getBindTel() {
        return this.bindTel;
    }

    public final void setBindTel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bindTel = str;
    }
}