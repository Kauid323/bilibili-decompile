package tv.danmaku.bili.ui.garb.nft.util;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;

/* compiled from: DLCConstUtil.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0002¨\u0006\u000e"}, d2 = {"isAvatarInvalid", "", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "isHeaderInvalid", "isAvatarValid", "isHeaderValid", "hasAvatarImgUrl", "hasHeaderImgUrl", "hasUseImgUrl", "hasUseToast", "isLimitedHeader", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "isLimitedAvatar", "forbiddenUse", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCConstUtilKt {
    public static final boolean isAvatarInvalid(CardRightShow $this$isAvatarInvalid) {
        Intrinsics.checkNotNullParameter($this$isAvatarInvalid, "<this>");
        return $this$isAvatarInvalid.isHeadPic() == 0;
    }

    public static final boolean isHeaderInvalid(CardRightShow $this$isHeaderInvalid) {
        Intrinsics.checkNotNullParameter($this$isHeaderInvalid, "<this>");
        return $this$isHeaderInvalid.isBannerBg() == 0;
    }

    public static final boolean isAvatarValid(CardRightShow $this$isAvatarValid) {
        Intrinsics.checkNotNullParameter($this$isAvatarValid, "<this>");
        return $this$isAvatarValid.isHeadPic() == 1;
    }

    public static final boolean isHeaderValid(CardRightShow $this$isHeaderValid) {
        Intrinsics.checkNotNullParameter($this$isHeaderValid, "<this>");
        return $this$isHeaderValid.isBannerBg() == 1;
    }

    public static final boolean hasAvatarImgUrl(CardRightShow $this$hasAvatarImgUrl) {
        Intrinsics.checkNotNullParameter($this$hasAvatarImgUrl, "<this>");
        return !TextUtils.isEmpty($this$hasAvatarImgUrl.getHeadTagUrl());
    }

    public static final boolean hasHeaderImgUrl(CardRightShow $this$hasHeaderImgUrl) {
        Intrinsics.checkNotNullParameter($this$hasHeaderImgUrl, "<this>");
        return !TextUtils.isEmpty($this$hasHeaderImgUrl.getBannerTagUrl());
    }

    public static final boolean hasUseImgUrl(CardRightShow $this$hasUseImgUrl) {
        Intrinsics.checkNotNullParameter($this$hasUseImgUrl, "<this>");
        return !TextUtils.isEmpty($this$hasUseImgUrl.getUseTagUrl());
    }

    public static final boolean hasUseToast(CardRightShow $this$hasUseToast) {
        Intrinsics.checkNotNullParameter($this$hasUseToast, "<this>");
        return !TextUtils.isEmpty($this$hasUseToast.getUseToast());
    }

    public static final boolean isLimitedHeader(CardRight $this$isLimitedHeader) {
        Intrinsics.checkNotNullParameter($this$isLimitedHeader, "<this>");
        return $this$isLimitedHeader.getBannerBgExpire() > 0;
    }

    public static final boolean isLimitedAvatar(CardRight $this$isLimitedAvatar) {
        Intrinsics.checkNotNullParameter($this$isLimitedAvatar, "<this>");
        return $this$isLimitedAvatar.getHeadPicExpire() > 0;
    }

    public static final boolean forbiddenUse(CardRightShow $this$forbiddenUse) {
        Intrinsics.checkNotNullParameter($this$forbiddenUse, "<this>");
        return isAvatarInvalid($this$forbiddenUse) && isHeaderInvalid($this$forbiddenUse);
    }
}