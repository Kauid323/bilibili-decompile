package kntr.app.tribee.share;

import com.bapis.bilibili.app.dynamic.v2.KShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeShareConfig;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeShareConfig;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareBiliContent;
import kntr.common.share.common.ShareDynamicContent;
import kntr.common.share.common.ShareParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: ProviderDynamicShareContent.android.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a&\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b¨\u0006\u0011"}, d2 = {"getConsumeShareDynamicContent", "Lkntr/common/share/common/ShareDynamicContent;", "tribeeInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDesc;", "shareParams", "Lkntr/common/share/common/ShareParams;", "shareConfig", "Lcom/bapis/bilibili/app/dynamic/v2/KShareConfig;", "getInviteShareDynamicContent", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeShareConfig;", "tribeeFaceUrl", "", "tribeeId", "", "getSteamShareDynamicContent", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeShareConfig;", "link", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProviderDynamicShareContent_androidKt {
    public static final ShareDynamicContent getConsumeShareDynamicContent(KTribeeDesc tribeeInfo, ShareParams shareParams, KShareConfig shareConfig) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        ShareBiliContent shareBiliContent = new ShareBiliContent(tribeeInfo.getTitle() + "\n" + shareConfig.getSubTitle(), tribeeInfo.getTitle() + "\n" + shareConfig.getSubTitle(), String.valueOf(tribeeInfo.getId()), shareConfig.getTargetUrl(), 2048, tribeeInfo.getFaceUrl(), null, null, null, null, "create.sketch", null, 3008, null);
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "title", tribeeInfo.getTitle());
        JsonElementBuildersKt.put(builder$iv, "desc_text", shareConfig.getSubTitle());
        JsonElementBuildersKt.put(builder$iv, "cover_url", tribeeInfo.getFaceUrl());
        JsonElementBuildersKt.put(builder$iv, "target_url", shareConfig.getTargetUrl());
        JsonElementBuildersKt.put(builder$iv, "biz_id", String.valueOf(tribeeInfo.getId()));
        JsonElementBuildersKt.put(builder$iv, "biz_type", "325");
        Unit unit = Unit.INSTANCE;
        return new ShareDynamicContent(shareBiliContent, false, null, null, builder$iv.build().toString(), null, 46, null);
    }

    public static final ShareDynamicContent getInviteShareDynamicContent(ShareParams shareParams, KTribeeInviteCodeShareConfig shareConfig, String tribeeFaceUrl, long tribeeId) {
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        Intrinsics.checkNotNullParameter(tribeeFaceUrl, "tribeeFaceUrl");
        ShareBiliContent shareBiliContent = new ShareBiliContent(shareConfig.getDynamicTitle() + "\n" + shareConfig.getText(), shareConfig.getDynamicTitle() + "\n" + shareConfig.getText(), String.valueOf(tribeeId), shareConfig.getJumpUrl(), 2048, tribeeFaceUrl, null, null, null, null, "create.sketch", null, 3008, null);
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "biz_type", "325");
        JsonElementBuildersKt.put(builder$iv, "title", shareConfig.getDynamicTitle());
        JsonElementBuildersKt.put(builder$iv, "desc_text", shareConfig.getText());
        JsonElementBuildersKt.put(builder$iv, "cover_url", tribeeFaceUrl);
        JsonElementBuildersKt.put(builder$iv, "target_url", shareConfig.getJumpUrl());
        JsonElementBuildersKt.put(builder$iv, "biz_id", String.valueOf(tribeeId));
        Unit unit = Unit.INSTANCE;
        return new ShareDynamicContent(shareBiliContent, false, null, null, builder$iv.build().toString(), null, 46, null);
    }

    public static final ShareDynamicContent getSteamShareDynamicContent(KTribeeSteamHomeShareConfig shareConfig, long tribeeId, String link) {
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        Intrinsics.checkNotNullParameter(link, "link");
        ShareBiliContent shareBiliContent = new ShareBiliContent(shareConfig.getDynamicTitle(), shareConfig.getText(), String.valueOf(tribeeId), link, 2048, shareConfig.getLogoUrl(), null, null, null, null, "create.sketch", null, 3008, null);
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "biz_type", "325");
        JsonElementBuildersKt.put(builder$iv, "title", shareConfig.getDynamicTitle());
        JsonElementBuildersKt.put(builder$iv, "desc_text", shareConfig.getText());
        JsonElementBuildersKt.put(builder$iv, "cover_url", shareConfig.getLogoUrl());
        JsonElementBuildersKt.put(builder$iv, "target_url", link);
        JsonElementBuildersKt.put(builder$iv, "biz_id", String.valueOf(tribeeId));
        Unit unit = Unit.INSTANCE;
        return new ShareDynamicContent(shareBiliContent, false, null, null, builder$iv.build().toString(), null, 46, null);
    }
}