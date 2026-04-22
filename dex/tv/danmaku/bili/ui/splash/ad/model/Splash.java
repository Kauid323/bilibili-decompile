package tv.danmaku.bili.ui.splash.ad.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.adcommon.data.AdReportInfo;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.IClickInfo;
import com.bilibili.adcommon.data.model.FeedExtra;
import com.bilibili.app.comm.realtime.RealTime;
import j$.util.Objects;
import java.util.List;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;

public class Splash {
    public static final int CARD_TYPE_BANNER = 152;
    public static final int CARD_TYPE_FULL_IMAGE = 14;
    public static final int CARD_TYPE_HALF_IMAGE = 15;
    public static final int CARD_TYPE_STORY = 109;
    public static final int CARD_TYPE_VIDEO_FULLSCREEN = 39;
    public static final int CARD_TYPE_VIDEO_PORT = 16;
    public static final String NETWORK_MOBILE = "mobile";
    public static final String NETWORK_WIFI = "wifi";
    public static final double SKIP_BUTTON_HEIGHT_RATIO_MAX = 0.056d;
    public static final double SKIP_BUTTON_HEIGHT_RATIO_MIN = 0.035d;
    private static final int SPLASH_CLICK_AREA = 1;
    private static final int SPLASH_ENCRYPTED = 1;
    private static final int SPLASH_TYPE_BD = 1;
    private static final int SPLASH_TYPE_TOP_VIEW = 4;
    @JSONField(name = "ad_cb")
    public String adCb;
    @JSONField(name = PerformanceConstants.EXTRA_KEY_SCHEMA)
    public String appLink;
    @JSONField(name = "schema_package_name")
    public String appPkg;
    @JSONField(name = "schema_title")
    public String appTip;
    @JSONField(name = "enable_background_download")
    public boolean backDownloadEnable;
    @JSONField(name = "begin_time")
    public long beginTime;
    @JSONField(deserialize = false, serialize = false)
    public String bindBanner;
    @JSONField(name = "card_type")
    public int cardType;
    @JSONField(name = "click_url")
    public String clickUrl;
    @JSONField(name = "cm_mark")
    public int cmMark;
    @JSONField(name = "duration")
    public int duration;
    @JSONField(name = "encryption")
    public int encryption;
    @JSONField(name = ChronosDanmakuSender.KEY_CMTIME_END)
    public long endTime;
    @JSONField(name = "extra")
    public JSONObject extra;
    @JSONField(name = "id")
    public long id;
    @JSONField(name = "hash")
    public String imageHash;
    @JSONField(name = "thumb")
    public String imageUrl;
    @JSONField(name = "index")
    public long index;
    @JSONField(name = "interact_distance")
    public int interactDistance;
    @JSONField(name = "interact_type")
    public int interactType;
    @JSONField(name = "interact_url")
    public String interactUrl;
    @JSONField(name = "client_ip")
    public String ip;
    @JSONField(name = "is_ad")
    public boolean isAd;
    @JSONField(name = "is_ad_loc")
    public boolean isAdLoc;
    @JSONField(deserialize = false, serialize = false)
    public boolean isHotSplash;
    public boolean isLocalExposed;
    @JSONField(name = "uri_title")
    public String jumpTip;
    @JSONField(name = "uri")
    public String jumpUrl;
    @JSONField(name = ChronosDanmakuSender.KEY_MARK_DANMAKU)
    public String keyword;
    public long lastExposeTime;
    @JSONField(name = "live_booking_trigger_type")
    public List<Integer> liveBookingTriggerType;
    public int localExposeCount;
    @JSONField(name = "logo_hash")
    public String logoHash;
    @JSONField(name = "logo_url")
    public String logoUrl;
    @JSONField(name = "mark_with_skip_style")
    public int markWithSkipStyle;
    @JSONField(name = "middle_page_info")
    public SplashMiddlePageInfo middlePageInfo;
    public String networkType;
    public String originImageUrl;
    public String originVideoUrl;
    @JSONField(name = "peak_download")
    public SplashPeakInfo peakInfo;
    @JSONField(name = "enable_pre_download")
    public boolean preLoadEnable;
    @JSONField(deserialize = false, serialize = false)
    public Bitmap realTimeSplashBitmap;
    @JSONField(name = "request_id")
    public String requestId;
    @JSONField(name = "resource_id")
    public long resourceId;
    @JSONField(name = "second_page")
    public SplashSecondPageInfo secondPage;
    @JSONField(name = "second_show_style")
    public int secondPageShowStyle;
    @JSONField(name = "show_url")
    public String showUrl;
    @JSONField(name = "skip")
    public int skip;
    @JSONField(name = "skip_button_height")
    public double skipButtonHeightRatio;
    @JSONField(name = "source")
    public int source;
    @JSONField(name = "splash_creative_id")
    public long splashCreativeId;
    @JSONField(name = "guide_button_list")
    public List<SplashGuideButton> splashGuideButton;
    @JSONField(deserialize = false, serialize = false)
    public String splashRequestId;
    @JSONField(name = "story_info")
    public SplashVideoInfo splashStoryInfo;
    @JSONField(name = "splash_type")
    public int splashType;
    @JSONField(name = "type")
    public int type;
    @JSONField(name = "user_cancel_jump_url")
    public String userCancelJumpUrl;
    @JSONField(name = "video_hash")
    public String videoHash;
    @JSONField(name = "video_height")
    public int videoHeight;
    @JSONField(name = "video_url")
    public String videoUrl;
    @JSONField(name = "video_width")
    public int videoWidth;
    @JSONField(name = "top_view_type")
    public int topViewType = 0;
    @JSONField(name = "top_view_loc")
    public int topViewLoc = 0;
    @JSONField(name = "egg")
    public SplashEgg splashEgg = null;
    @JSONField(name = "splash_enable_double_jump")
    public boolean enableDoubleJump = false;
    @JSONField(name = "user_cancel_jump_type")
    public int cancelJumpType = 0;
    @JSONField(name = "live_booking_id")
    public long liveBookingId = 0;
    @JSONField(deserialize = false, serialize = false)
    private final IAdInfo adInfo = new IAdInfo() { // from class: tv.danmaku.bili.ui.splash.ad.model.Splash.1
        private FeedExtra adExtra;

        private FeedExtra getAdExtra() {
            if (this.adExtra == null) {
                try {
                    this.adExtra = (FeedExtra) JSON.parseObject(Splash.this.extra.toJSONString(), FeedExtra.class);
                } catch (Exception e) {
                }
            }
            return this.adExtra;
        }

        public IClickInfo getClickInfo() {
            return getAdExtra();
        }

        public IAdReportInfo getReportInfo() {
            return new AdReportInfo.Builder(Splash.this.isAdLoc).isAd(Splash.this.isAd).adcb(Splash.this.adCb).srcId(Splash.this.source).adIndex(Splash.this.index).ip(Splash.this.ip).serverType(Splash.this.serverType).resourceId(Splash.this.resourceId).id(Splash.this.id).cardIndex(Splash.this.cardIndex).cardType((String) null).cmMark(Splash.this.cmMark).requestId(Splash.this.requestId).creativeId(Splash.this.id).creativeType(0L).extra(getAdExtra()).build();
        }
    };
    @JSONField(name = "card_index")
    public long cardIndex = -1;
    @JSONField(name = "server_type")
    public long serverType = -1;
    @JSONField(name = "interact_angle")
    public int interactAngle = 0;
    @JSONField(name = "element_animation")
    public SplashElementAnimation elementAnimation = null;
    @JSONField(name = "danmukus")
    public List<SplashDanmaku> danmukus = null;
    @JSONField(name = "support_called_up")
    public boolean supportCalledUp = false;
    @JSONField(deserialize = false, serialize = false)
    public boolean isFromCalledUp = false;
    @JSONField(deserialize = false, serialize = false)
    public boolean isEggVideoPlayed = false;
    public boolean isRealTimeSplash = false;
    @JSONField(deserialize = false, serialize = false)
    public String imageFrom = "local";
    @JSONField(deserialize = false, serialize = false)
    public String videoFrom = "local";
    @JSONField(deserialize = false, serialize = false)
    public long localSplashImageSize = 0;
    @JSONField(deserialize = false, serialize = false)
    public long localSplashVideoSize = 0;
    @JSONField(deserialize = false, serialize = false)
    public int originRealTimeShowIndex = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
    @JSONField(deserialize = false, serialize = false)
    public boolean fromRealShow = false;

    @JSONField(deserialize = false, serialize = false)
    public IAdInfo getAdInfo() {
        return this.adInfo;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isEncrypted() {
        return this.encryption == 1;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isSplashTypeSupport() {
        return this.type == 1 || this.type == 4;
    }

    public boolean needPrepare() {
        return SplashConfigKt.getSplashPrepareEnable() && isVideo() && !this.isHotSplash;
    }

    public boolean isInteractSupport() {
        return this.interactType == 1;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isCardTypeSupport() {
        return this.cardType == 14 || this.cardType == 15 || this.cardType == 16 || this.cardType == 39 || this.cardType == 109 || this.cardType == 152;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isVideo() {
        return this.cardType == 16 || this.cardType == 39 || this.cardType == 109 || this.cardType == 152;
    }

    public boolean isMiddlePageSplash() {
        return this.middlePageInfo != null && this.secondPageShowStyle == 2;
    }

    public boolean isSkipDefault() {
        return this.markWithSkipStyle == 0;
    }

    public boolean isSkipSizeExp() {
        return this.markWithSkipStyle == 1;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isFullscreen() {
        return this.cardType == 14 || this.cardType == 39 || this.cardType == 109;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isValid() {
        if (isEncrypted()) {
            long realTime = RealTime.getCredibleTime();
            if (realTime <= 0 && RealTime.needForceSyncTime()) {
                realTime = RealTime.forceUpdateSync();
            }
            return realTime >= this.beginTime && realTime <= this.endTime;
        }
        long currentTime = System.currentTimeMillis() / 1000;
        return currentTime >= this.beginTime && currentTime <= this.endTime;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isTopView() {
        return this.type == 4;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean hasTopViewLinkedCard() {
        return isTopView() && this.topViewLoc == 1;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isSearchLinkage() {
        return !TextUtils.isEmpty(this.keyword);
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean hasTopViewResInfo() {
        if (this.extra != null) {
            String picUrl = this.extra.getString("topview_pic_url");
            String videoUrl = this.extra.getString("topview_video_url");
            return (TextUtils.isEmpty(picUrl) && TextUtils.isEmpty(videoUrl)) ? false : true;
        }
        return false;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isSplashClickable() {
        if (this.extra == null) {
            return false;
        }
        try {
            return this.extra.getIntValue("click_area") == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean hasSecondPageEggVideo() {
        return (!isSecondPageEggVideo() || this.secondPage == null || this.secondPage.getSecondVideoUrl().isEmpty() || this.secondPage.getSecondVideoHash().isEmpty()) ? false : true;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isSecondPageEggVideo() {
        return this.secondPage != null && this.secondPageShowStyle == 3;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Splash) {
            Splash splash = (Splash) o;
            if (this.id != splash.id) {
                return false;
            }
            return Objects.equals(this.imageHash, splash.imageHash) && Objects.equals(this.videoHash, splash.videoHash);
        }
        return false;
    }

    public String toString() {
        return "Splash{id=" + this.id + ", type=" + this.type + ", cardType=" + this.cardType + ", duration=" + this.duration + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", imageUrl='" + this.imageUrl + "', videoUrl='" + this.videoUrl + "', interactType=" + this.interactType + ", isRealTimeSplash=" + this.isRealTimeSplash + ", isHotSplash=" + this.isHotSplash + '}';
    }

    public int hashCode() {
        long result = this.id;
        return (int) ((31 * ((result * 31) + (this.imageHash != null ? this.imageHash.hashCode() : 0))) + (this.videoHash != null ? this.videoHash.hashCode() : 0));
    }
}