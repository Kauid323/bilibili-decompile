package kntr.app.tribee.share;

import com.bapis.bilibili.app.dynamic.v2.KShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeShareConfig;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareBiliContent;
import kntr.common.share.common.ShareIMContent;
import kntr.common.share.common.ShareParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProviderIMShareContent.android.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a&\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b¨\u0006\u0011"}, d2 = {"getConsumeShareIMContent", "Lkntr/common/share/common/ShareIMContent;", "tribeeInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDesc;", "shareParams", "Lkntr/common/share/common/ShareParams;", "shareConfig", "Lcom/bapis/bilibili/app/dynamic/v2/KShareConfig;", "getInviteShareIMContent", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeShareConfig;", "tribeeFaceUrl", "", "tribeeId", "", "getSteamShareIMContent", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeShareConfig;", "link", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProviderIMShareContent_androidKt {
    public static final ShareIMContent getConsumeShareIMContent(KTribeeDesc tribeeInfo, ShareParams shareParams, KShareConfig shareConfig) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        return new ShareIMContent(new ShareBiliContent(tribeeInfo.getTitle(), shareConfig.getSubTitle(), String.valueOf(tribeeInfo.getId()), shareConfig.getTargetUrl(), 23, tribeeInfo.getFaceUrl(), null, null, null, "", null, "小站", 1472, null), null);
    }

    public static final ShareIMContent getInviteShareIMContent(ShareParams shareParams, KTribeeInviteCodeShareConfig shareConfig, String tribeeFaceUrl, long tribeeId) {
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        Intrinsics.checkNotNullParameter(tribeeFaceUrl, "tribeeFaceUrl");
        return new ShareIMContent(new ShareBiliContent(String.valueOf(shareConfig.getMessageTitle()), String.valueOf(shareConfig.getText()), String.valueOf(tribeeId), shareConfig.getJumpUrl(), 23, tribeeFaceUrl, null, null, null, "", null, "小站邀请码", 1472, null), null);
    }

    public static final ShareIMContent getSteamShareIMContent(KTribeeSteamHomeShareConfig shareConfig, long tribeeId, String link) {
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        Intrinsics.checkNotNullParameter(link, "link");
        return new ShareIMContent(new ShareBiliContent(shareConfig.getMessageTitle(), shareConfig.getText(), String.valueOf(tribeeId), link, 23, shareConfig.getLogoUrl(), null, null, null, "", null, "小站游戏数据", 1472, null), null);
    }
}