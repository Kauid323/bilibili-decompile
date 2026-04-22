package tv.danmaku.bili.fullscreen.stat;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginWay.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/ThirdParty;", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "NetCodeLogin", "Ltv/danmaku/bili/fullscreen/stat/ThirdParty$NetCodeLogin;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ThirdParty extends LoginWay {

    /* compiled from: LoginWay.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/fullscreen/stat/ThirdParty$NetCodeLogin;", "Ltv/danmaku/bili/fullscreen/stat/ThirdParty;", "<init>", "()V", "succeedMethod", "", "getSucceedMethod", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class NetCodeLogin implements ThirdParty {
        public static final int $stable = 0;
        public static final NetCodeLogin INSTANCE = new NetCodeLogin();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NetCodeLogin) {
                NetCodeLogin netCodeLogin = (NetCodeLogin) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -702466456;
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onGeeCaptcha() {
            return LoginWay.CC.$default$onGeeCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onImageCaptcha() {
            return LoginWay.CC.$default$onImageCaptcha(this);
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public /* synthetic */ LoginWay onRegister() {
            return LoginWay.CC.$default$onRegister(this);
        }

        public String toString() {
            return "NetCodeLogin";
        }

        private NetCodeLogin() {
        }

        @Override // tv.danmaku.bili.fullscreen.stat.LoginWay
        public String getSucceedMethod() {
            return "35";
        }
    }
}