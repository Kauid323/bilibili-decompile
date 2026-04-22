package tv.danmaku.bili.fullscreen.service;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Ltv/danmaku/bili/fullscreen/service/EulaDisplayInfo;", "", "loginType", "", ReportEvent.EVENT_TYPE_SHOW, "", "isPhoneLogin", "ispCode", "Ltv/danmaku/bili/fullscreen/service/IspCode;", "triggerType", "Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "<init>", "(Ljava/lang/String;ZZLtv/danmaku/bili/fullscreen/service/IspCode;Ltv/danmaku/bili/normal/ui/EulaTriggerType;)V", "getLoginType", "()Ljava/lang/String;", "getShow", "()Z", "getIspCode", "()Ltv/danmaku/bili/fullscreen/service/IspCode;", "getTriggerType", "()Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class EulaDisplayInfo {
    public static final int $stable = 0;
    private final boolean isPhoneLogin;
    private final IspCode ispCode;
    private final String loginType;
    private final boolean show;
    private final EulaTriggerType triggerType;

    public static /* synthetic */ EulaDisplayInfo copy$default(EulaDisplayInfo eulaDisplayInfo, String str, boolean z, boolean z2, IspCode ispCode, EulaTriggerType eulaTriggerType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eulaDisplayInfo.loginType;
        }
        if ((i & 2) != 0) {
            z = eulaDisplayInfo.show;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = eulaDisplayInfo.isPhoneLogin;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            ispCode = eulaDisplayInfo.ispCode;
        }
        IspCode ispCode2 = ispCode;
        if ((i & 16) != 0) {
            eulaTriggerType = eulaDisplayInfo.triggerType;
        }
        return eulaDisplayInfo.copy(str, z3, z4, ispCode2, eulaTriggerType);
    }

    public final String component1() {
        return this.loginType;
    }

    public final boolean component2() {
        return this.show;
    }

    public final boolean component3() {
        return this.isPhoneLogin;
    }

    public final IspCode component4() {
        return this.ispCode;
    }

    public final EulaTriggerType component5() {
        return this.triggerType;
    }

    public final EulaDisplayInfo copy(String str, boolean z, boolean z2, IspCode ispCode, EulaTriggerType eulaTriggerType) {
        Intrinsics.checkNotNullParameter(str, "loginType");
        Intrinsics.checkNotNullParameter(ispCode, "ispCode");
        Intrinsics.checkNotNullParameter(eulaTriggerType, "triggerType");
        return new EulaDisplayInfo(str, z, z2, ispCode, eulaTriggerType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EulaDisplayInfo) {
            EulaDisplayInfo eulaDisplayInfo = (EulaDisplayInfo) obj;
            return Intrinsics.areEqual(this.loginType, eulaDisplayInfo.loginType) && this.show == eulaDisplayInfo.show && this.isPhoneLogin == eulaDisplayInfo.isPhoneLogin && this.ispCode == eulaDisplayInfo.ispCode && this.triggerType == eulaDisplayInfo.triggerType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.loginType.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.show)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isPhoneLogin)) * 31) + this.ispCode.hashCode()) * 31) + this.triggerType.hashCode();
    }

    public String toString() {
        String str = this.loginType;
        boolean z = this.show;
        boolean z2 = this.isPhoneLogin;
        IspCode ispCode = this.ispCode;
        return "EulaDisplayInfo(loginType=" + str + ", show=" + z + ", isPhoneLogin=" + z2 + ", ispCode=" + ispCode + ", triggerType=" + this.triggerType + ")";
    }

    public EulaDisplayInfo(String loginType, boolean show, boolean isPhoneLogin, IspCode ispCode, EulaTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(ispCode, "ispCode");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        this.loginType = loginType;
        this.show = show;
        this.isPhoneLogin = isPhoneLogin;
        this.ispCode = ispCode;
        this.triggerType = triggerType;
    }

    public /* synthetic */ EulaDisplayInfo(String str, boolean z, boolean z2, IspCode ispCode, EulaTriggerType eulaTriggerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? IspCode.Unknown : ispCode, (i & 16) != 0 ? EulaTriggerType.Submit : eulaTriggerType);
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final boolean isPhoneLogin() {
        return this.isPhoneLogin;
    }

    public final IspCode getIspCode() {
        return this.ispCode;
    }

    public final EulaTriggerType getTriggerType() {
        return this.triggerType;
    }
}