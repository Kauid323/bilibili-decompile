package video.biz.offline.base.model.model;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthCode.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0007H\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0002H\u0007\"\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"forbiddenAuthCodeArray", "", "Lvideo/biz/offline/base/model/model/AuthCode;", "getForbiddenAuthCodeArray", "()[Lvideo/biz/offline/base/model/model/AuthCode;", "[Lvideo/biz/offline/base/model/model/AuthCode;", "toAuthCode", "", "isOgvVip", "", "model_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthCodeKt {
    private static final AuthCode[] forbiddenAuthCodeArray = {AuthCode.EpOffline, AuthCode.EpFreeQnVip, AuthCode.EpVip, AuthCode.EpPayOrVip, AuthCode.EpPayOrVipFirst, AuthCode.EpPay, AuthCode.EpPayFirst, AuthCode.EpPayPack, AuthCode.EpTicketWhite};

    public static final AuthCode[] getForbiddenAuthCodeArray() {
        return forbiddenAuthCodeArray;
    }

    public static final AuthCode toAuthCode(int $this$toAuthCode) {
        return AuthCode.Companion.enumOf($this$toAuthCode);
    }

    public static final boolean isOgvVip(AuthCode $this$isOgvVip) {
        Intrinsics.checkNotNullParameter($this$isOgvVip, "<this>");
        return ArraysKt.contains(forbiddenAuthCodeArray, $this$isOgvVip);
    }
}