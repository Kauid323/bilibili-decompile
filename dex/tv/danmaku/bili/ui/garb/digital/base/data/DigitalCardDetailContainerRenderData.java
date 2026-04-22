package tv.danmaku.bili.ui.garb.digital.base.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.garb.api.DLCItem;
import tv.danmaku.bili.ui.garb.api.DigitalCardDetail;
import tv.danmaku.bili.ui.garb.nft.model.CollectProgressButton;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardRewardModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCDetailModel;

/* compiled from: DigitalCardDetailContainerRenderData.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\b\u0017\u0018\u00002\u00020\u0001BÕ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020&¢\u0006\u0004\b#\u0010'B\u001d\b\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010(\u0012\b\u0010)\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b#\u0010*B\u0013\b\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010+¢\u0006\u0004\b#\u0010,B\u0013\b\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010-¢\u0006\u0004\b#\u0010.R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00107\"\u0004\bA\u00109R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bB\u00107R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bC\u00107R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bD\u00107R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bE\u00107R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bF\u00107R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bG\u00107R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bH\u00107R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bI\u00107R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bJ\u00107R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\bK\u00100R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bL\u00107R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bM\u00107R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bN\u00107R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\bO\u00100R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00105\u001a\u0004\bP\u00104R\u0011\u0010\u001c\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\bS\u00100R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bT\u00107R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailContainerRenderData;", "", "activityId", "", "activityStatus", "overtime", "", "hCardLightUrl", "", "hCardShadowUrl", "vCardLightUrl", "vCardShadowUrl", "setBgUrl", "activityText", "activityUrl", "activityIcon", "linkText", "linkUrl", "garbSuitUrl", "garbApplyUrl", "holderListUrl", "actHomepageurl", "shareType", "from", "fromId", "fSource", "canDonate", "hasAnimation", "canSaveImage", "pageType", "redeemItemId", "renderData", "Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "rewardBottomButton", "Ltv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;ZLjava/lang/Integer;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;Ltv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;)V", "data", "Ltv/danmaku/bili/ui/garb/api/DigitalCardDetail;", "(Ltv/danmaku/bili/ui/garb/api/DigitalCardDetail;)V", "Ltv/danmaku/bili/ui/garb/nft/model/DLCDetailModel;", "detailData", "(Ltv/danmaku/bili/ui/garb/nft/model/DLCDetailModel;Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;)V", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;", "(Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;)V", "Ltv/danmaku/bili/ui/garb/api/DLCItem;", "(Ltv/danmaku/bili/ui/garb/api/DLCItem;)V", "getActivityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActivityStatus", "getOvertime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHCardLightUrl", "()Ljava/lang/String;", "setHCardLightUrl", "(Ljava/lang/String;)V", "getHCardShadowUrl", "setHCardShadowUrl", "getVCardLightUrl", "setVCardLightUrl", "getVCardShadowUrl", "setVCardShadowUrl", "getSetBgUrl", "setSetBgUrl", "getActivityText", "getActivityUrl", "getActivityIcon", "getLinkText", "getLinkUrl", "getGarbSuitUrl", "getGarbApplyUrl", "getHolderListUrl", "getActHomepageurl", "getShareType", "getFrom", "getFromId", "getFSource", "getCanDonate", "getHasAnimation", "getCanSaveImage", "()Z", "getPageType", "getRedeemItemId", "getRenderData", "()Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "getRewardBottomButton", "()Ltv/danmaku/bili/ui/garb/nft/model/CollectProgressButton;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class DigitalCardDetailContainerRenderData {
    public static final int $stable = 8;
    private final String actHomepageurl;
    private final String activityIcon;
    private final Integer activityId;
    private final Integer activityStatus;
    private final String activityText;
    private final String activityUrl;
    private final Integer canDonate;
    private final boolean canSaveImage;
    private final String fSource;
    private final String from;
    private final String fromId;
    private final String garbApplyUrl;
    private final String garbSuitUrl;
    private String hCardLightUrl;
    private String hCardShadowUrl;
    private final Boolean hasAnimation;
    private final String holderListUrl;
    private final String linkText;
    private final String linkUrl;
    private final Boolean overtime;
    private final Integer pageType;
    private final String redeemItemId;
    private final DigitalCardDetailRenderData renderData;
    private final CollectProgressButton rewardBottomButton;
    private String setBgUrl;
    private final Integer shareType;
    private String vCardLightUrl;
    private String vCardShadowUrl;

    public DigitalCardDetailContainerRenderData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 268435455, null);
    }

    public DigitalCardDetailContainerRenderData(Integer activityId, Integer activityStatus, Boolean overtime, String hCardLightUrl, String hCardShadowUrl, String vCardLightUrl, String vCardShadowUrl, String setBgUrl, String activityText, String activityUrl, String activityIcon, String linkText, String linkUrl, String garbSuitUrl, String garbApplyUrl, String holderListUrl, String actHomepageurl, Integer shareType, String from, String fromId, String fSource, Integer canDonate, Boolean hasAnimation, boolean canSaveImage, Integer pageType, String redeemItemId, DigitalCardDetailRenderData renderData, CollectProgressButton rewardBottomButton) {
        this.activityId = activityId;
        this.activityStatus = activityStatus;
        this.overtime = overtime;
        this.hCardLightUrl = hCardLightUrl;
        this.hCardShadowUrl = hCardShadowUrl;
        this.vCardLightUrl = vCardLightUrl;
        this.vCardShadowUrl = vCardShadowUrl;
        this.setBgUrl = setBgUrl;
        this.activityText = activityText;
        this.activityUrl = activityUrl;
        this.activityIcon = activityIcon;
        this.linkText = linkText;
        this.linkUrl = linkUrl;
        this.garbSuitUrl = garbSuitUrl;
        this.garbApplyUrl = garbApplyUrl;
        this.holderListUrl = holderListUrl;
        this.actHomepageurl = actHomepageurl;
        this.shareType = shareType;
        this.from = from;
        this.fromId = fromId;
        this.fSource = fSource;
        this.canDonate = canDonate;
        this.hasAnimation = hasAnimation;
        this.canSaveImage = canSaveImage;
        this.pageType = pageType;
        this.redeemItemId = redeemItemId;
        this.renderData = renderData;
        this.rewardBottomButton = rewardBottomButton;
    }

    public /* synthetic */ DigitalCardDetailContainerRenderData(Integer num, Integer num2, Boolean bool, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Integer num3, String str15, String str16, String str17, Integer num4, Boolean bool2, boolean z, Integer num5, String str18, DigitalCardDetailRenderData digitalCardDetailRenderData, CollectProgressButton collectProgressButton, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? false : bool, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & BR.cover) != 0 ? null : str5, (i & BR.hallEnterHotText) != 0 ? null : str6, (i & BR.roleType) != 0 ? null : str7, (i & MisakaHelper.MAX_REPORT_SIZE) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? null : str11, (i & RingBuffer.CONSUME_SIZE) != 0 ? null : str12, (i & 32768) != 0 ? null : str13, (i & AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR) != 0 ? null : str14, (i & 131072) != 0 ? 0 : num3, (i & 262144) != 0 ? null : str15, (i & 524288) != 0 ? null : str16, (i & 1048576) != 0 ? null : str17, (i & 2097152) != 0 ? null : num4, (i & 4194304) != 0 ? true : bool2, (i & 8388608) == 0 ? z : true, (i & 16777216) != 0 ? 0 : num5, (i & 33554432) != 0 ? "" : str18, (i & 67108864) != 0 ? null : digitalCardDetailRenderData, (i & 134217728) != 0 ? null : collectProgressButton);
    }

    public final Integer getActivityId() {
        return this.activityId;
    }

    public final Integer getActivityStatus() {
        return this.activityStatus;
    }

    public final Boolean getOvertime() {
        return this.overtime;
    }

    public final String getHCardLightUrl() {
        return this.hCardLightUrl;
    }

    public final void setHCardLightUrl(String str) {
        this.hCardLightUrl = str;
    }

    public final String getHCardShadowUrl() {
        return this.hCardShadowUrl;
    }

    public final void setHCardShadowUrl(String str) {
        this.hCardShadowUrl = str;
    }

    public final String getVCardLightUrl() {
        return this.vCardLightUrl;
    }

    public final void setVCardLightUrl(String str) {
        this.vCardLightUrl = str;
    }

    public final String getVCardShadowUrl() {
        return this.vCardShadowUrl;
    }

    public final void setVCardShadowUrl(String str) {
        this.vCardShadowUrl = str;
    }

    public final String getSetBgUrl() {
        return this.setBgUrl;
    }

    public final void setSetBgUrl(String str) {
        this.setBgUrl = str;
    }

    public final String getActivityText() {
        return this.activityText;
    }

    public final String getActivityUrl() {
        return this.activityUrl;
    }

    public final String getActivityIcon() {
        return this.activityIcon;
    }

    public final String getLinkText() {
        return this.linkText;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final String getGarbSuitUrl() {
        return this.garbSuitUrl;
    }

    public final String getGarbApplyUrl() {
        return this.garbApplyUrl;
    }

    public final String getHolderListUrl() {
        return this.holderListUrl;
    }

    public final String getActHomepageurl() {
        return this.actHomepageurl;
    }

    public final Integer getShareType() {
        return this.shareType;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getFromId() {
        return this.fromId;
    }

    public final String getFSource() {
        return this.fSource;
    }

    public final Integer getCanDonate() {
        return this.canDonate;
    }

    public final Boolean getHasAnimation() {
        return this.hasAnimation;
    }

    public final boolean getCanSaveImage() {
        return this.canSaveImage;
    }

    public final Integer getPageType() {
        return this.pageType;
    }

    public final String getRedeemItemId() {
        return this.redeemItemId;
    }

    public final DigitalCardDetailRenderData getRenderData() {
        return this.renderData;
    }

    public final CollectProgressButton getRewardBottomButton() {
        return this.rewardBottomButton;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailContainerRenderData(DigitalCardDetail data) {
        this(Integer.valueOf(r1), Integer.valueOf(r2), Boolean.valueOf(r4), data.getHCardLightUrl(), data.getHCardShadowUrl(), data.getVCardLightUrl(), data.getVCardShadowUrl(), null, data.getActivityDesc(), data.getActivityLink(), data.getIconUrl(), data.getJumpDesc(), data.getJumpLink(), null, null, null, null, null, null, null, null, null, null, false, null, null, new DigitalCardDetailRenderData(data), null, 201318528, null);
        Intrinsics.checkNotNullParameter(data, "data");
        int actId = data.getActId();
        int status = data.getStatus();
        boolean z = data.getOvertime() == 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailContainerRenderData(DLCDetailModel data, DigitalCardDetailRenderData detailData) {
        this(Integer.valueOf(r1), null, Boolean.valueOf(r3), r10, r11, r12, r13, r14, null, r16, null, null, null, null, null, r22, r23, r24, r25, r26, r27, r28, Boolean.valueOf(!r0), r30, data != null ? Integer.valueOf(data.getPageType()) : null, null, detailData, null, 167796738, null);
        boolean z;
        boolean z2 = false;
        int activityId = data != null ? data.getActivityId() : 0;
        if (data == null || !data.getNotOnSale()) {
            z = false;
        } else {
            z = true;
        }
        String horizontalCardLightUrl = data != null ? data.getHorizontalCardLightUrl() : null;
        String horizontalCardShadowUrl = data != null ? data.getHorizontalCardShadowUrl() : null;
        String verticalCardLightUrl = data != null ? data.getVerticalCardLightUrl() : null;
        String verticalCardShadowUrl = data != null ? data.getVerticalCardShadowUrl() : null;
        String spaceBgSetUrl = data != null ? data.getSpaceBgSetUrl() : null;
        String actHomepageurl = data != null ? data.getActHomepageurl() : null;
        String holderListUrl = data != null ? data.getHolderListUrl() : null;
        String actHomepageurl2 = data != null ? data.getActHomepageurl() : null;
        Integer valueOf = data != null ? Integer.valueOf(data.getShareType()) : null;
        String fromWhere = data != null ? data.getFromWhere() : null;
        String fromId = data != null ? data.getFromId() : null;
        String fSource = data != null ? data.getFSource() : null;
        Integer valueOf2 = data != null ? Integer.valueOf(data.getCanDonate()) : null;
        boolean canSaveImage = data != null ? data.getCanSaveImage() : true;
        if (data != null && data.getHasCardAnimation() == 0) {
            z2 = true;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailContainerRenderData(DLCCardRewardModel data) {
        this(r6, null, false, r9, r10, r16, r17, r20, null, null, null, null, null, r21, r22, null, null, r23, r25, r27, r28, null, Boolean.valueOf(!r0), false, data != null ? Integer.valueOf(data.getPageType()) : null, data != null ? data.getRedeemItemId() : null, new DigitalCardDetailRenderData(data, data != null ? data.getCardItem() : null, null, 4, null), data != null ? data.getCollectProgressButton() : null, 10485762, null);
        String activityId;
        boolean z = false;
        Integer valueOf = Integer.valueOf((data == null || (activityId = data.getActivityId()) == null) ? 0 : Integer.parseInt(activityId));
        String horizontalCardLightUrl = data != null ? data.getHorizontalCardLightUrl() : null;
        String horizontalCardShadowUrl = data != null ? data.getHorizontalCardShadowUrl() : null;
        String verticalCardLightUrl = data != null ? data.getVerticalCardLightUrl() : null;
        String verticalCardShadowUrl = data != null ? data.getVerticalCardShadowUrl() : null;
        String spaceBgSetUrl = data != null ? data.getSpaceBgSetUrl() : null;
        String garbSuitUrl = data != null ? data.getGarbSuitUrl() : null;
        String garbApplyUrl = data != null ? data.getGarbApplyUrl() : null;
        Integer valueOf2 = data != null ? Integer.valueOf(data.getShareType()) : null;
        String fromWhere = data != null ? data.getFromWhere() : null;
        String fromId = data != null ? data.getFromId() : null;
        String fSource = data != null ? data.getFSource() : null;
        if (data != null && data.getHasCardAnimation() == 1) {
            z = true;
        }
    }

    public DigitalCardDetailContainerRenderData(DLCItem data) {
        this(null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, new DigitalCardDetailRenderData(null, data != null ? data.getCardItem() : null, data != null ? data.getDisplay() : null), null, 201318531, null);
    }
}