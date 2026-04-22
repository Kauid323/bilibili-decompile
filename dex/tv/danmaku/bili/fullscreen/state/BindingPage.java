package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/BindingPage;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "platform", "", "appId", "openId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlatform", "()Ljava/lang/String;", "getAppId", "getOpenId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BindingPage implements NetCodeState {
    public static final int $stable = 0;
    private final String appId;
    private final String openId;
    private final String platform;

    public static /* synthetic */ BindingPage copy$default(BindingPage bindingPage, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bindingPage.platform;
        }
        if ((i & 2) != 0) {
            str2 = bindingPage.appId;
        }
        if ((i & 4) != 0) {
            str3 = bindingPage.openId;
        }
        return bindingPage.copy(str, str2, str3);
    }

    public final String component1() {
        return this.platform;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.openId;
    }

    public final BindingPage copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "platform");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "openId");
        return new BindingPage(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BindingPage) {
            BindingPage bindingPage = (BindingPage) obj;
            return Intrinsics.areEqual(this.platform, bindingPage.platform) && Intrinsics.areEqual(this.appId, bindingPage.appId) && Intrinsics.areEqual(this.openId, bindingPage.openId);
        }
        return false;
    }

    public int hashCode() {
        return (((this.platform.hashCode() * 31) + this.appId.hashCode()) * 31) + this.openId.hashCode();
    }

    public String toString() {
        String str = this.platform;
        String str2 = this.appId;
        return "BindingPage(platform=" + str + ", appId=" + str2 + ", openId=" + this.openId + ")";
    }

    public BindingPage(String platform, String appId, String openId) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(openId, "openId");
        this.platform = platform;
        this.appId = appId;
        this.openId = openId;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getOpenId() {
        return this.openId;
    }
}