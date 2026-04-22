package tv.danmaku.bili.ui.garb.digital.base.data;

import com.bili.digital.common.CardNumberGradientColor;
import com.bilibili.app.authorspace.api.BiliNftImage;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.common.gyroscope.model.NftGyroAttribute;
import com.bilibili.digital.card.page.card.cardmodule.web.WebCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.NftCardDetailIdModel;
import tv.danmaku.bili.ui.garb.NftCardDetailModel;
import tv.danmaku.bili.ui.garb.api.Animation;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplay;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplayFrame;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplayMark;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardItem;
import tv.danmaku.bili.ui.garb.api.BiliDrawCard;
import tv.danmaku.bili.ui.garb.api.BiliDrawCardKt;
import tv.danmaku.bili.ui.garb.api.CardInfo;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.CardTypeInfo;
import tv.danmaku.bili.ui.garb.api.Content;
import tv.danmaku.bili.ui.garb.api.DigitalCardDetail;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardRewardModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCPlayModel;
import tv.danmaku.bili.ui.garb.nft.model.DLCTagModel;
import tv.danmaku.bili.ui.garb.nft.model.DigitalCardDetailIdModel;
import tv.danmaku.bili.ui.garb.nft.model.DigitalCardDetailModel;

/* compiled from: DigitalCardDetailRenderData.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\b\u0017\u0018\u00002\u00020\u0001BÃ\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u00102\u001a\u00020\u0017\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104¢\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u00107\u001a\u000208\u0012\b\u00109\u001a\u0004\u0018\u00010:¢\u0006\u0004\b5\u0010;B\u0011\b\u0016\u0012\u0006\u0010<\u001a\u00020=¢\u0006\u0004\b5\u0010>B\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020@¢\u0006\u0004\b5\u0010AB\u001b\b\u0016\u0012\u0006\u0010B\u001a\u00020C\u0012\b\u0010D\u001a\u0004\u0018\u00010E¢\u0006\u0004\b5\u0010FB)\b\u0016\u0012\b\u0010G\u001a\u0004\u0018\u00010H\u0012\b\u0010I\u001a\u0004\u0018\u00010J\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L¢\u0006\u0004\b5\u0010MB\u0013\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010H¢\u0006\u0004\b5\u0010OR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bT\u0010SR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0011\u0010\u0018\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010[\"\u0004\b_\u0010]R\u001a\u0010\u001d\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010X\"\u0004\ba\u0010bR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010e\u001a\u0004\bc\u0010dR\u0013\u0010!\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0013\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bl\u0010gR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0013\u0010,\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bq\u0010gR\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\br\u0010[R\u0013\u0010.\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bs\u0010gR\u0013\u0010/\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bt\u0010gR\u0013\u00100\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bu\u0010gR\u0013\u00101\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bv\u0010gR\u0011\u00102\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b2\u0010XR\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010|R\u001b\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b~\u0010g\"\u0005\b\u007f\u0010\u0080\u0001R\u0012\u0010\u0007\u001a\u00020\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010gR\u0012\u0010\n\u001a\u00020\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010gR\u001e\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001d\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0087\u0001\u0010g\"\u0006\b\u0088\u0001\u0010\u0080\u0001R\u001d\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0089\u0001\u0010g\"\u0006\b\u008a\u0001\u0010\u0080\u0001R\u0012\u0010\u000f\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010SR\u0012\u0010\u001f\u001a\u00020\u0017¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010XR\u0012\u0010&\u001a\u00020\u0010¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010SR\u001d\u0010\u008e\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010X\"\u0005\b\u0090\u0001\u0010b¨\u0006\u0091\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/base/data/DigitalCardDetailRenderData;", "", "cardTypeId", "", "cardId", "totalCount", "", "index", "topNumberGradientColor", "Lcom/bili/digital/common/CardNumberGradientColor;", ChannelRoutes.CHANNEL_NAME, "ratio", "", "imgUrl", "hashCode", "status", "", "width", "height", "exchangeStatus", "type", "Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;", "needRequest", "", "hasGained", "videoList", "", "gyroscope", "Lcom/bilibili/app/common/gyroscope/model/NftGyroAttribute;", "silence", "overtime", "showExchanged", "activityId", "extName", "cardRightShow", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "cardRight", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "materialType", "subtitlesUrl", "play", "Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", AppConfig.HOST_TAG, "Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "imgDownloadUrl", "videoDownloadUrls", "leftTopTagImg", "frameImg", "rewardTag", "rewardTip", "isHighLight", "cardLockStatus", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bili/digital/common/CardNumberGradientColor;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IILjava/lang/Integer;Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;ZZLjava/util/List;Ljava/util/List;ZLjava/lang/Boolean;Ljava/lang/Boolean;JLjava/lang/String;Ltv/danmaku/bili/ui/garb/api/CardRightShow;Ltv/danmaku/bili/ui/garb/api/CardRight;Ljava/lang/Integer;Ljava/lang/String;Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLtv/danmaku/bili/ui/garb/api/CardLockStatus;)V", "cardDetail", "Ltv/danmaku/bili/ui/garb/NftCardDetailModel;", "card", "Ltv/danmaku/bili/ui/garb/NftCardDetailIdModel;", "(Ltv/danmaku/bili/ui/garb/NftCardDetailModel;Ltv/danmaku/bili/ui/garb/NftCardDetailIdModel;)V", "drawCard", "Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;", "(Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;)V", "digitalDetail", "Ltv/danmaku/bili/ui/garb/api/DigitalCardDetail;", "(Ltv/danmaku/bili/ui/garb/api/DigitalCardDetail;)V", "detailModel", "Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailModel;", "idDetailModel", "Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailIdModel;", "(Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailModel;Ltv/danmaku/bili/ui/garb/nft/model/DigitalCardDetailIdModel;)V", "data", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;", "cardItem", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;", "display", "Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;", "(Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;Ltv/danmaku/bili/ui/garb/api/BiliDLCCardItem;Ltv/danmaku/bili/ui/garb/api/BiliDLCCardDisplay;)V", "rewardModel", "(Ltv/danmaku/bili/ui/garb/nft/model/DLCCardRewardModel;)V", "getTopNumberGradientColor", "()Lcom/bili/digital/common/CardNumberGradientColor;", "getWidth", "()I", "getHeight", "getType", "()Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;", "getNeedRequest", "()Z", "getHasGained", "getVideoList", "()Ljava/util/List;", "setVideoList", "(Ljava/util/List;)V", "getGyroscope", "setGyroscope", "getSilence", "setSilence", "(Z)V", "getOvertime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtName", "()Ljava/lang/String;", "getCardRightShow", "()Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "getCardRight", "()Ltv/danmaku/bili/ui/garb/api/CardRight;", "getSubtitlesUrl", "getPlay", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", "getTag", "()Ltv/danmaku/bili/ui/garb/nft/model/DLCTagModel;", "getImgDownloadUrl", "getVideoDownloadUrls", "getLeftTopTagImg", "getFrameImg", "getRewardTag", "getRewardTip", "getCardLockStatus", "()Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "setCardLockStatus", "(Ltv/danmaku/bili/ui/garb/api/CardLockStatus;)V", "getCardTypeId", "()J", "getCardId", "getTotalCount", "setTotalCount", "(Ljava/lang/String;)V", "getIndex", "getName", "getRatio", "()F", "setRatio", "(F)V", "getImgUrl", "setImgUrl", "getHashCode", "setHashCode", "getStatus", "getShowExchanged", "getMaterialType", "hideVideo", "getHideVideo", "setHideVideo", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class DigitalCardDetailRenderData {
    public static final int $stable = 8;
    private final long cardId;
    private CardLockStatus cardLockStatus;
    private final CardRight cardRight;
    private final CardRightShow cardRightShow;
    private final long cardTypeId;
    private final String extName;
    private final String frameImg;
    private List<NftGyroAttribute> gyroscope;
    private final boolean hasGained;
    private String hashCode;
    private final int height;
    private boolean hideVideo;
    private final String imgDownloadUrl;
    private String imgUrl;
    private final String index;
    private final boolean isHighLight;
    private final String leftTopTagImg;
    private final int materialType;
    private final String name;
    private final boolean needRequest;
    private final Boolean overtime;
    private final DLCPlayModel play;
    private float ratio;
    private final String rewardTag;
    private final String rewardTip;
    private final boolean showExchanged;
    private boolean silence;
    private final int status;
    private final String subtitlesUrl;
    private final DLCTagModel tag;
    private final CardNumberGradientColor topNumberGradientColor;
    private String totalCount;
    private final NftType type;
    private final List<String> videoDownloadUrls;
    private List<String> videoList;
    private final int width;

    public DigitalCardDetailRenderData(Long cardTypeId, Long cardId, String totalCount, String index, CardNumberGradientColor topNumberGradientColor, String name, Float ratio, String imgUrl, String hashCode, Integer status, int width, int height, Integer exchangeStatus, NftType type, boolean needRequest, boolean hasGained, List<String> list, List<NftGyroAttribute> list2, boolean silence, Boolean overtime, Boolean showExchanged, long activityId, String extName, CardRightShow cardRightShow, CardRight cardRight, Integer materialType, String subtitlesUrl, DLCPlayModel play, DLCTagModel tag, String imgDownloadUrl, List<String> list3, String leftTopTagImg, String frameImg, String rewardTag, String rewardTip, boolean isHighLight, CardLockStatus cardLockStatus) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.topNumberGradientColor = topNumberGradientColor;
        this.width = width;
        this.height = height;
        this.type = type;
        this.needRequest = needRequest;
        this.hasGained = hasGained;
        this.videoList = list;
        this.gyroscope = list2;
        this.silence = silence;
        this.overtime = overtime;
        this.extName = extName;
        this.cardRightShow = cardRightShow;
        this.cardRight = cardRight;
        this.subtitlesUrl = subtitlesUrl;
        this.play = play;
        this.tag = tag;
        this.imgDownloadUrl = imgDownloadUrl;
        this.videoDownloadUrls = list3;
        this.leftTopTagImg = leftTopTagImg;
        this.frameImg = frameImg;
        this.rewardTag = rewardTag;
        this.rewardTip = rewardTip;
        this.isHighLight = isHighLight;
        this.cardLockStatus = cardLockStatus;
        this.cardTypeId = cardTypeId != null ? cardTypeId.longValue() : 0L;
        this.cardId = cardId != null ? cardId.longValue() : 0L;
        this.totalCount = totalCount == null ? "" : totalCount;
        this.index = index == null ? "" : index;
        this.name = name == null ? "" : name;
        this.ratio = ratio != null ? ratio.floatValue() : 0.0f;
        this.imgUrl = imgUrl == null ? "" : imgUrl;
        this.hashCode = hashCode != null ? hashCode : "";
        this.status = status != null ? status.intValue() : 0;
        this.showExchanged = showExchanged != null ? showExchanged.booleanValue() : false;
        this.materialType = materialType != null ? materialType.intValue() : 1;
    }

    public /* synthetic */ DigitalCardDetailRenderData(Long l, Long l2, String str, String str2, CardNumberGradientColor cardNumberGradientColor, String str3, Float f, String str4, String str5, Integer num, int i, int i2, Integer num2, NftType nftType, boolean z, boolean z2, List list, List list2, boolean z3, Boolean bool, Boolean bool2, long j, String str6, CardRightShow cardRightShow, CardRight cardRight, Integer num3, String str7, DLCPlayModel dLCPlayModel, DLCTagModel dLCTagModel, String str8, List list3, String str9, String str10, String str11, String str12, boolean z4, CardLockStatus cardLockStatus, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : l, (i3 & 2) != 0 ? 0L : l2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : cardNumberGradientColor, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? Float.valueOf(0.0f) : f, (i3 & BR.cover) != 0 ? null : str4, (i3 & BR.hallEnterHotText) != 0 ? null : str5, (i3 & BR.roleType) != 0 ? null : num, (i3 & MisakaHelper.MAX_REPORT_SIZE) != 0 ? 0 : i, (i3 & 2048) != 0 ? 0 : i2, (i3 & 4096) != 0 ? null : num2, (i3 & 8192) != 0 ? NftType.IMAGE : nftType, (i3 & RingBuffer.CONSUME_SIZE) != 0 ? false : z, (32768 & i3) != 0 ? false : z2, (65536 & i3) != 0 ? null : list, (131072 & i3) != 0 ? null : list2, (262144 & i3) != 0 ? false : z3, (524288 & i3) != 0 ? false : bool, (1048576 & i3) != 0 ? false : bool2, (2097152 & i3) != 0 ? 0L : j, (4194304 & i3) != 0 ? null : str6, (8388608 & i3) != 0 ? null : cardRightShow, (16777216 & i3) != 0 ? null : cardRight, (33554432 & i3) != 0 ? 1 : num3, (67108864 & i3) != 0 ? null : str7, (134217728 & i3) != 0 ? null : dLCPlayModel, (268435456 & i3) != 0 ? null : dLCTagModel, (536870912 & i3) != 0 ? null : str8, (1073741824 & i3) != 0 ? null : list3, (i3 & Integer.MIN_VALUE) != 0 ? null : str9, (i4 & 1) != 0 ? null : str10, (i4 & 2) != 0 ? null : str11, (i4 & 4) != 0 ? null : str12, z4, (i4 & 16) != 0 ? null : cardLockStatus);
    }

    public final CardNumberGradientColor getTopNumberGradientColor() {
        return this.topNumberGradientColor;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final NftType getType() {
        return this.type;
    }

    public final boolean getNeedRequest() {
        return this.needRequest;
    }

    public final boolean getHasGained() {
        return this.hasGained;
    }

    public final List<String> getVideoList() {
        return this.videoList;
    }

    public final void setVideoList(List<String> list) {
        this.videoList = list;
    }

    public final List<NftGyroAttribute> getGyroscope() {
        return this.gyroscope;
    }

    public final void setGyroscope(List<NftGyroAttribute> list) {
        this.gyroscope = list;
    }

    public final boolean getSilence() {
        return this.silence;
    }

    public final void setSilence(boolean z) {
        this.silence = z;
    }

    public final Boolean getOvertime() {
        return this.overtime;
    }

    public final String getExtName() {
        return this.extName;
    }

    public final CardRightShow getCardRightShow() {
        return this.cardRightShow;
    }

    public final CardRight getCardRight() {
        return this.cardRight;
    }

    public final String getSubtitlesUrl() {
        return this.subtitlesUrl;
    }

    public final DLCPlayModel getPlay() {
        return this.play;
    }

    public final DLCTagModel getTag() {
        return this.tag;
    }

    public final String getImgDownloadUrl() {
        return this.imgDownloadUrl;
    }

    public final List<String> getVideoDownloadUrls() {
        return this.videoDownloadUrls;
    }

    public final String getLeftTopTagImg() {
        return this.leftTopTagImg;
    }

    public final String getFrameImg() {
        return this.frameImg;
    }

    public final String getRewardTag() {
        return this.rewardTag;
    }

    public final String getRewardTip() {
        return this.rewardTip;
    }

    public final boolean isHighLight() {
        return this.isHighLight;
    }

    public final CardLockStatus getCardLockStatus() {
        return this.cardLockStatus;
    }

    public final void setCardLockStatus(CardLockStatus cardLockStatus) {
        this.cardLockStatus = cardLockStatus;
    }

    public final long getCardTypeId() {
        return this.cardTypeId;
    }

    public final long getCardId() {
        return this.cardId;
    }

    public final String getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalCount = str;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }

    public final float getRatio() {
        return this.ratio;
    }

    public final void setRatio(float f) {
        this.ratio = f;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final void setImgUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imgUrl = str;
    }

    public final String getHashCode() {
        return this.hashCode;
    }

    public final void setHashCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hashCode = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean getShowExchanged() {
        return this.showExchanged;
    }

    public final int getMaterialType() {
        return this.materialType;
    }

    public final boolean getHideVideo() {
        return this.hideVideo;
    }

    public final void setHideVideo(boolean z) {
        this.hideVideo = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DigitalCardDetailRenderData(NftCardDetailModel cardDetail, NftCardDetailIdModel card) {
        this(Long.valueOf(cardDetail.getCardTypeId()), card != null ? Long.valueOf(card.getCardId()) : null, cardDetail.getTotalCntShow(), card != null ? card.getCardNo() : null, null, cardDetail.getCardName(), Float.valueOf(cardDetail.getRealChance() / 100.0f), cardDetail.getCardImg(), card != null ? card.getHashCode() : null, card != null ? Integer.valueOf(card.getStatus()) : null, 0, 0, card != null ? Integer.valueOf(card.getExchangeStatus()) : null, NftType.Companion.getType(cardDetail.getCardType()), cardDetail.getNeedRequest() == 1, card != null, cardDetail.getVideoList(), null, cardDetail.getSilence() == 1, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, card != null, null, -521200, 23, null);
        Intrinsics.checkNotNullParameter(cardDetail, "cardDetail");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailRenderData(BiliDrawCard drawCard) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, 1, 0, 0, 0, r17, r18, true, r20, r21, r22, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, true, null, -521216, 23, null);
        boolean z;
        boolean z2;
        Content content;
        Animation animation;
        Content content2;
        BiliNftImage image;
        Content content3;
        Animation animation2;
        Intrinsics.checkNotNullParameter(drawCard, "drawCard");
        CardTypeInfo cardTypeInfo = drawCard.getCardTypeInfo();
        List list = null;
        Long valueOf = cardTypeInfo != null ? Long.valueOf(cardTypeInfo.getId()) : null;
        CardInfo cardInfo = drawCard.getCardInfo();
        Long valueOf2 = cardInfo != null ? Long.valueOf(cardInfo.getId()) : null;
        String totalCountShow = drawCard.getTotalCountShow();
        CardInfo cardInfo2 = drawCard.getCardInfo();
        String cardNo = cardInfo2 != null ? cardInfo2.getCardNo() : null;
        CardNumberGradientColor cardNumberGradientColor = drawCard.getCardInfo().getCardNumberGradientColor();
        CardTypeInfo cardTypeInfo2 = drawCard.getCardTypeInfo();
        String name = cardTypeInfo2 != null ? cardTypeInfo2.getName() : null;
        Float valueOf3 = Float.valueOf(drawCard.getCardChance());
        String imgUrlWithType = BiliDrawCardKt.getImgUrlWithType(drawCard);
        String str = imgUrlWithType == null ? "" : imgUrlWithType;
        CardInfo cardInfo3 = drawCard.getCardInfo();
        String hashCode = cardInfo3 != null ? cardInfo3.getHashCode() : null;
        NftType.Companion companion = NftType.Companion;
        CardTypeInfo cardTypeInfo3 = drawCard.getCardTypeInfo();
        NftType type = companion.getType(cardTypeInfo3 != null ? cardTypeInfo3.getMaterialType() : NftType.IMAGE.getType());
        if (drawCard.getNeedRequest() == 1) {
            z = true;
        } else {
            z = false;
        }
        CardTypeInfo cardTypeInfo4 = drawCard.getCardTypeInfo();
        List<String> animationVideoUrls = (cardTypeInfo4 == null || (content3 = cardTypeInfo4.getContent()) == null || (animation2 = content3.getAnimation()) == null) ? null : animation2.getAnimationVideoUrls();
        CardTypeInfo cardTypeInfo5 = drawCard.getCardTypeInfo();
        if (cardTypeInfo5 != null && (content2 = cardTypeInfo5.getContent()) != null && (image = content2.getImage()) != null) {
            list = image.getGyroscope();
        }
        List list2 = list;
        CardTypeInfo cardTypeInfo6 = drawCard.getCardTypeInfo();
        if (cardTypeInfo6 != null && (content = cardTypeInfo6.getContent()) != null && (animation = content.getAnimation()) != null && animation.getMute()) {
            z2 = true;
        } else {
            z2 = false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailRenderData(DigitalCardDetail digitalDetail) {
        this(Long.valueOf(r2), Long.valueOf(r4), r10, r11, null, r13, Float.valueOf(r0), r7 == null ? "" : r7, null, 1, digitalDetail.getWidth(), digitalDetail.getHeight(), 0, NftType.Companion.getType(digitalDetail.getCardType()), digitalDetail.getNeedRequest() == 1, true, digitalDetail.getVideoList(), null, digitalDetail.getSilence() == 1, Boolean.valueOf(digitalDetail.getOvertime() == 1), null, 0L, null, null, null, null, digitalDetail.getSubtitlesUrl(), digitalDetail.getPlay(), digitalDetail.getTag(), null, null, null, null, null, null, true, null, -470679280, 23, null);
        Intrinsics.checkNotNullParameter(digitalDetail, "digitalDetail");
        long cardTypeId = digitalDetail.getCardTypeId();
        long cardId = digitalDetail.getCardId();
        String cardNoShow = digitalDetail.getCardNoShow();
        String str = cardNoShow == null ? "" : cardNoShow;
        String totalCntShow = digitalDetail.getTotalCntShow();
        String cardName = digitalDetail.getCardName();
        String realChance = digitalDetail.getRealChance();
        float parseFloat = (realChance != null ? Float.parseFloat(realChance) : 0.0f) / 100.0f;
        String cardImg = digitalDetail.getCardImg();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailRenderData(DigitalCardDetailModel detailModel, DigitalCardDetailIdModel idDetailModel) {
        this(r5, r6, r7, r8, r9, r10, Float.valueOf(r2), r12, r13, r14, r15, r16, r17, r18, r19, r20, r3, null, r23, null, null, 0L, r28, r29, r30, null, r32, r33, r34, r35, r36, r37, r38, detailModel.getRewardTag(), null, r0 != null ? r0.booleanValue() : idDetailModel != null, r42, 37224448, 4, null);
        Intrinsics.checkNotNullParameter(detailModel, "detailModel");
        Long valueOf = Long.valueOf(detailModel.getCardTypeId());
        Long valueOf2 = idDetailModel != null ? Long.valueOf(idDetailModel.getCardId()) : null;
        String totalCntShow = detailModel.getTotalCntShow();
        String cardNo = idDetailModel != null ? idDetailModel.getCardNo() : null;
        CardNumberGradientColor cardNumberGradientColor = idDetailModel != null ? idDetailModel.getCardNumberGradientColor() : null;
        String cardName = detailModel.getCardName();
        float realChance = detailModel.getRealChance() / 100.0f;
        String cardImg = detailModel.getCardImg();
        String hashCode = idDetailModel != null ? idDetailModel.getHashCode() : null;
        Integer valueOf3 = idDetailModel != null ? Integer.valueOf(idDetailModel.getStatus()) : null;
        Integer valueOf4 = idDetailModel != null ? Integer.valueOf(idDetailModel.getExchangeStatus()) : null;
        NftType type = NftType.Companion.getType(detailModel.getCardType());
        boolean z = detailModel.getNeedRequest() == 1;
        boolean z2 = idDetailModel != null;
        ArrayList<String> videoList = detailModel.getVideoList();
        boolean z3 = detailModel.getSilence() == 1;
        String cardExtText = detailModel.getCardExtText();
        CardRight cardRight = idDetailModel != null ? idDetailModel.getCardRight() : null;
        CardRightShow cardRightShow = idDetailModel != null ? idDetailModel.getCardRightShow() : null;
        String subtitlesUrl = detailModel.getSubtitlesUrl();
        DLCPlayModel play = detailModel.getPlay();
        DLCTagModel tag = detailModel.getTag();
        String cardImgDownload = detailModel.getCardImgDownload();
        List<String> videoDownloadList = detailModel.getVideoDownloadList();
        CardLockStatus cardLockStatus = idDetailModel != null ? idDetailModel.getCardLockStatus() : null;
        int width = detailModel.getWidth();
        int height = detailModel.getHeight();
        String leftTopTagImg = detailModel.getLeftTopTagImg();
        String frameImg = detailModel.getFrameImg();
        Boolean isHighlight = detailModel.isHighlight();
    }

    public /* synthetic */ DigitalCardDetailRenderData(DLCCardRewardModel dLCCardRewardModel, BiliDLCCardItem biliDLCCardItem, BiliDLCCardDisplay biliDLCCardDisplay, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dLCCardRewardModel, biliDLCCardItem, (i & 4) != 0 ? null : biliDLCCardDisplay);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailRenderData(DLCCardRewardModel data, BiliDLCCardItem cardItem, BiliDLCCardDisplay display) {
        this(Long.valueOf(r2), Long.valueOf(r4), r11, r12, r13, r14, Float.valueOf(r8), r16, r17, 0, (cardItem == null || (r0 = cardItem.getCardTypeInfo()) == null) ? 0 : r0.getWidth(), (cardItem == null || (r0 = cardItem.getCardTypeInfo()) == null) ? 0 : r0.getHeight(), 1, r22, false, r24, r25, r26, r27, null, null, r30, r32, r33, r34, null, r36, r37, r38, null, null, r41, (display == null || (r0 = display.getFrame()) == null) ? null : r0.getImg(), null, null, r45, (cardItem == null || (r0 = cardItem.getCardInfo()) == null) ? null : r0.getCardLockStatus(), 1645740032, 6, null);
        String str;
        CardInfo cardInfo;
        CardTypeInfo cardTypeInfo;
        CardTypeInfo cardTypeInfo2;
        BiliDLCCardDisplayFrame frame;
        CardInfo cardInfo2;
        WebCard webCard;
        String smeltTag;
        BiliDLCCardDisplayMark cornerMark;
        CardTypeInfo cardTypeInfo3;
        Content content;
        Animation animation;
        CardInfo cardInfo3;
        CardInfo cardInfo4;
        CardInfo cardInfo5;
        CardTypeInfo cardTypeInfo4;
        Content content2;
        Animation animation2;
        String activityId;
        CardTypeInfo cardTypeInfo5;
        Content content3;
        BiliNftImage image;
        CardTypeInfo cardTypeInfo6;
        Content content4;
        Animation animation3;
        CardTypeInfo cardTypeInfo7;
        CardInfo cardInfo6;
        CardTypeInfo cardTypeInfo8;
        String overviewImage;
        CardTypeInfo cardTypeInfo9;
        String name;
        CardInfo cardInfo7;
        CardInfo cardInfo8;
        String cardNo;
        String cardTypeCntShow;
        CardInfo cardInfo9;
        CardTypeInfo cardTypeInfo10;
        long j = 0;
        long id = (cardItem == null || (cardTypeInfo10 = cardItem.getCardTypeInfo()) == null) ? 0L : cardTypeInfo10.getId();
        long id2 = (cardItem == null || (cardInfo9 = cardItem.getCardInfo()) == null) ? 0L : cardInfo9.getId();
        String str2 = (cardItem == null || (cardTypeCntShow = cardItem.getCardTypeCntShow()) == null) ? "" : cardTypeCntShow;
        String str3 = (cardItem == null || (cardInfo8 = cardItem.getCardInfo()) == null || (cardNo = cardInfo8.getCardNo()) == null) ? "" : cardNo;
        CardNumberGradientColor cardNumberGradientColor = (cardItem == null || (cardInfo7 = cardItem.getCardInfo()) == null) ? null : cardInfo7.getCardNumberGradientColor();
        String str4 = (cardItem == null || (cardTypeInfo9 = cardItem.getCardTypeInfo()) == null || (name = cardTypeInfo9.getName()) == null) ? "" : name;
        float cardChance = cardItem != null ? cardItem.getCardChance() : 0.0f;
        String str5 = (cardItem == null || (cardTypeInfo8 = cardItem.getCardTypeInfo()) == null || (overviewImage = cardTypeInfo8.getOverviewImage()) == null) ? "" : overviewImage;
        String hashCode = (cardItem == null || (cardInfo6 = cardItem.getCardInfo()) == null) ? null : cardInfo6.getHashCode();
        NftType type = NftType.Companion.getType((cardItem == null || (cardTypeInfo7 = cardItem.getCardTypeInfo()) == null) ? NftType.IMAGE.getType() : cardTypeInfo7.getMaterialType());
        boolean z = data == null || data.getGained() == 1;
        List<String> animationVideoUrls = (cardItem == null || (cardTypeInfo6 = cardItem.getCardTypeInfo()) == null || (content4 = cardTypeInfo6.getContent()) == null || (animation3 = content4.getAnimation()) == null) ? null : animation3.getAnimationVideoUrls();
        List gyroscope = (cardItem == null || (cardTypeInfo5 = cardItem.getCardTypeInfo()) == null || (content3 = cardTypeInfo5.getContent()) == null || (image = content3.getImage()) == null) ? null : image.getGyroscope();
        if (data != null && (activityId = data.getActivityId()) != null) {
            j = Long.parseLong(activityId);
        }
        long j2 = j;
        boolean z2 = (cardItem == null || (cardTypeInfo4 = cardItem.getCardTypeInfo()) == null || (content2 = cardTypeInfo4.getContent()) == null || (animation2 = content2.getAnimation()) == null || !animation2.getMute()) ? false : true;
        String cardExtText = (cardItem == null || (cardInfo5 = cardItem.getCardInfo()) == null) ? null : cardInfo5.getCardExtText();
        CardRight cardRight = (cardItem == null || (cardInfo4 = cardItem.getCardInfo()) == null) ? null : cardInfo4.getCardRight();
        CardRightShow cardRightShow = (cardItem == null || (cardInfo3 = cardItem.getCardInfo()) == null) ? null : cardInfo3.getCardRightShow();
        String subtitlesUrl = (cardItem == null || (cardTypeInfo3 = cardItem.getCardTypeInfo()) == null || (content = cardTypeInfo3.getContent()) == null || (animation = content.getAnimation()) == null) ? null : animation.getSubtitlesUrl();
        DLCPlayModel play = cardItem != null ? cardItem.getPlay() : null;
        DLCTagModel tag = cardItem != null ? cardItem.getTag() : null;
        boolean z3 = data == null || data.getGained() == 1;
        if (cardItem == null || (cardInfo2 = cardItem.getCardInfo()) == null || (webCard = cardInfo2.getWebCard()) == null || (smeltTag = webCard.getSmeltTag()) == null) {
            str = null;
        } else {
            String str6 = smeltTag;
            str = StringsKt.isBlank(str6) ? (display == null || (cornerMark = display.getCornerMark()) == null) ? null : cornerMark.getImg() : str6;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DigitalCardDetailRenderData(DLCCardRewardModel rewardModel) {
        this(Long.valueOf(r2), Long.valueOf(r0), "", "", null, r12, Float.valueOf(0.0f), r14, "", 0, 0, 0, 1, r20, false, r22, r23, r24, r25, null, null, 0L, null, r31, r32, Integer.valueOf(r6), r34, r35, r36, null, null, null, null, r41, r42, r43, null, -529003504, 17, null);
        NftType type;
        List<String> videoList;
        boolean z;
        boolean z2;
        Boolean isHighlight;
        BiliDLCCardItem cardItem;
        BiliDLCCardItem cardItem2;
        BiliDLCCardItem cardItem3;
        CardTypeInfo cardTypeInfo;
        Content content;
        Animation animation;
        BiliDLCCardItem cardItem4;
        CardInfo cardInfo;
        BiliDLCCardItem cardItem5;
        CardInfo cardInfo2;
        BiliDLCCardItem cardItem6;
        CardTypeInfo cardTypeInfo2;
        Content content2;
        BiliNftImage image;
        String redeemItemImage;
        String redeemItemName;
        BiliDLCCardItem cardItem7;
        CardInfo cardInfo3;
        BiliDLCCardItem cardItem8;
        CardTypeInfo cardTypeInfo3;
        long j = 0;
        long id = (rewardModel == null || (cardItem8 = rewardModel.getCardItem()) == null || (cardTypeInfo3 = cardItem8.getCardTypeInfo()) == null) ? 0L : cardTypeInfo3.getId();
        if (rewardModel != null && (cardItem7 = rewardModel.getCardItem()) != null && (cardInfo3 = cardItem7.getCardInfo()) != null) {
            j = cardInfo3.getId();
        }
        String str = (rewardModel == null || (redeemItemName = rewardModel.getRedeemItemName()) == null) ? "" : redeemItemName;
        String str2 = (rewardModel == null || (redeemItemImage = rewardModel.getRedeemItemImage()) == null) ? "" : redeemItemImage;
        if (rewardModel != null && rewardModel.getRedeemItemType() == 1) {
            type = NftType.Companion.getType(rewardModel.getCardItem().getCardTypeInfo().getMaterialType());
        } else {
            type = NftType.Companion.getType(rewardModel != null ? rewardModel.getMaterialType() : NftType.IMAGE.getType());
        }
        boolean z3 = rewardModel != null && rewardModel.getGained() == 1;
        if (rewardModel != null && rewardModel.getRedeemItemType() == 1) {
            videoList = rewardModel.getCardItem().getCardTypeInfo().getContent().getAnimation().getAnimationVideoUrls();
        } else {
            videoList = rewardModel != null ? rewardModel.getVideoList() : null;
        }
        List gyroscope = (rewardModel == null || (cardItem6 = rewardModel.getCardItem()) == null || (cardTypeInfo2 = cardItem6.getCardTypeInfo()) == null || (content2 = cardTypeInfo2.getContent()) == null || (image = content2.getImage()) == null) ? null : image.getGyroscope();
        if (rewardModel != null && rewardModel.getRedeemItemType() == 1) {
            z = rewardModel.getCardItem().getCardTypeInfo().getContent().getAnimation().getMute();
        } else {
            z = rewardModel != null && rewardModel.isMute();
        }
        int redeemItemType = rewardModel != null ? rewardModel.getRedeemItemType() : 1;
        CardRight cardRight = (rewardModel == null || (cardItem5 = rewardModel.getCardItem()) == null || (cardInfo2 = cardItem5.getCardInfo()) == null) ? null : cardInfo2.getCardRight();
        CardRightShow cardRightShow = (rewardModel == null || (cardItem4 = rewardModel.getCardItem()) == null || (cardInfo = cardItem4.getCardInfo()) == null) ? null : cardInfo.getCardRightShow();
        String subtitlesUrl = (rewardModel == null || (cardItem3 = rewardModel.getCardItem()) == null || (cardTypeInfo = cardItem3.getCardTypeInfo()) == null || (content = cardTypeInfo.getContent()) == null || (animation = content.getAnimation()) == null) ? null : animation.getSubtitlesUrl();
        DLCPlayModel play = (rewardModel == null || (cardItem2 = rewardModel.getCardItem()) == null) ? null : cardItem2.getPlay();
        DLCTagModel tag = (rewardModel == null || (cardItem = rewardModel.getCardItem()) == null) ? null : cardItem.getTag();
        String rewardTag = rewardModel != null ? rewardModel.getRewardTag() : null;
        String rewardTip = rewardModel != null ? rewardModel.getRewardTip() : null;
        if (rewardModel == null || (isHighlight = rewardModel.isHighlight()) == null) {
            z2 = rewardModel != null && rewardModel.getGained() == 1;
        } else {
            z2 = isHighlight.booleanValue();
        }
    }
}