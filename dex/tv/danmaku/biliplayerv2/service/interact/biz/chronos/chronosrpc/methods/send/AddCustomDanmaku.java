package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AddCustomDanmaku.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000 \u00102\u00020\u0001:\r\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku;", "", "<init>", "()V", "Request", "CustomDanmaku", "AdDanmakuExtra", "AdFloatViewExtra", "AdFloatViewPermanentExtra", "AdFloatViewAnswerExtra", "AdFloatViewGotExtra", "AdFloatViewCommerceExtra", "AdFloatViewCommonExtra", "LiveExtra", "NormalExtra", "InteractExtra", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AddCustomDanmaku {
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_AD = 101;
    public static final int TYPE_LIVE = 103;
    public static final int TYPE_LIVE_DANMU_V2 = 108;
    public static final int TYPE_NORMAL = 104;
    public static final int TYPE_REAL_TIME_INTERACT = 106;
    public static final int TYPE_REAL_TIME_NORMAL = 105;
    public static final int TYPE_REPLY = 102;
    public static final int TYPE_THUMB_UP = 100;

    /* compiled from: AddCustomDanmaku.kt */
    @RequestDefine(method = "AddCustomDanmakus")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$Request;", "", "<init>", "()V", "videoId", "", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "workId", "getWorkId", "setWorkId", "dms", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$CustomDanmaku;", "getDms", "()[Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$CustomDanmaku;", "setDms", "([Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$CustomDanmaku;)V", "[Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$CustomDanmaku;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "dms")
        private CustomDanmaku[] dms;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;
        @JSONField(name = "work_id")
        private String workId;

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }

        public final String getWorkId() {
            return this.workId;
        }

        public final void setWorkId(String str) {
            this.workId = str;
        }

        public final CustomDanmaku[] getDms() {
            return this.dms;
        }

        public final void setDms(CustomDanmaku[] customDanmakuArr) {
            this.dms = customDanmakuArr;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$CustomDanmaku;", "", "<init>", "()V", "danmakuId", "", "getDanmakuId", "()Ljava/lang/String;", "setDanmakuId", "(Ljava/lang/String;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CustomDanmaku {
        @JSONField(name = "danmaku_id")
        private String danmakuId;
        @JSONField(name = "extra")
        private Object extra;
        @JSONField(name = "type")
        private Integer type;

        public final String getDanmakuId() {
            return this.danmakuId;
        }

        public final void setDanmakuId(String str) {
            this.danmakuId = str;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public final Object getExtra() {
            return this.extra;
        }

        public final void setExtra(Object obj) {
            this.extra = obj;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R \u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R \u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\"\u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00061"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$AdDanmakuExtra;", "", "<init>", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "adLogo", "getAdLogo", "setAdLogo", "adTag", "getAdTag", "setAdTag", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "desc", "getDesc", "setDesc", "bgColor", "getBgColor", "setBgColor", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "yLocation", "", "getYLocation", "()Ljava/lang/Float;", "setYLocation", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdDanmakuExtra {
        @JSONField(name = "adver_logo")
        private String adLogo;
        @JSONField(name = "ad_tag")
        private String adTag;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "bg_color")
        private String bgColor;
        @JSONField(name = "card_type")
        private Integer cardType;
        @JSONField(name = RankRouter.BundleKey.VIDEO_DETAIL_COVER)
        private String cover;
        @JSONField(name = "desc")
        private String desc;
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        private String title;
        @JSONField(name = "y_location")
        private Float yLocation;

        public final Integer getCardType() {
            return this.cardType;
        }

        public final void setCardType(Integer num) {
            this.cardType = num;
        }

        public final String getCover() {
            return this.cover;
        }

        public final void setCover(String str) {
            this.cover = str;
        }

        public final String getAdLogo() {
            return this.adLogo;
        }

        public final void setAdLogo(String str) {
            this.adLogo = str;
        }

        public final String getAdTag() {
            return this.adTag;
        }

        public final void setAdTag(String str) {
            this.adTag = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final void setBgColor(String str) {
            this.bgColor = str;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final Float getYLocation() {
            return this.yLocation;
        }

        public final void setYLocation(Float f) {
            this.yLocation = f;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R \u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R \u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R \u0010$\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010¨\u0006'"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$AdFloatViewExtra;", "", "<init>", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "bgColor", "getBgColor", "setBgColor", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "imageUrl", "getImageUrl", "setImageUrl", "adNotes", "getAdNotes", "setAdNotes", "buttonText", "getButtonText", "setButtonText", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewExtra {
        @JSONField(name = "ad_notes")
        private String adNotes;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "bg_color")
        private String bgColor;
        @JSONField(name = "button_text")
        private String buttonText;
        @JSONField(name = "card_type")
        private Integer cardType;
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = "image_url")
        private String imageUrl;
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        private String title;

        public final Integer getCardType() {
            return this.cardType;
        }

        public final void setCardType(Integer num) {
            this.cardType = num;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final void setBgColor(String str) {
            this.bgColor = str;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final String getAdNotes() {
            return this.adNotes;
        }

        public final void setAdNotes(String str) {
            this.adNotes = str;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final void setButtonText(String str) {
            this.buttonText = str;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010!\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\"\u0010$\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\"\u0010'\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001c¨\u0006*"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$AdFloatViewPermanentExtra;", "", "<init>", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "bgColor", "getBgColor", "setBgColor", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "foldTime", "getFoldTime", "setFoldTime", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewPermanentExtra {
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "bg_color")
        private String bgColor;
        @JSONField(name = "card_type")
        private Integer cardType;
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = "fold_time")
        private Long foldTime;
        @JSONField(name = "height")
        private Long height;
        @JSONField(name = "image_url")
        private String imageUrl;
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        private String title;
        @JSONField(name = "width")
        private Long width;

        public final Integer getCardType() {
            return this.cardType;
        }

        public final void setCardType(Integer num) {
            this.cardType = num;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final String getBgColor() {
            return this.bgColor;
        }

        public final void setBgColor(String str) {
            this.bgColor = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final Long getFoldTime() {
            return this.foldTime;
        }

        public final void setFoldTime(Long l) {
            this.foldTime = l;
        }

        public final Long getWidth() {
            return this.width;
        }

        public final void setWidth(Long l) {
            this.width = l;
        }

        public final Long getHeight() {
            return this.height;
        }

        public final void setHeight(Long l) {
            this.height = l;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b'\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R(\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR \u0010*\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R \u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R \u00100\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010R \u00103\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R \u00106\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R \u00109\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000e\"\u0004\b;\u0010\u0010R \u0010<\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R \u0010?\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010\u0010R \u0010B\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010¨\u0006E"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$AdFloatViewAnswerExtra;", "", "<init>", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ballId", "", "getBallId", "()Ljava/lang/String;", "setBallId", "(Ljava/lang/String;)V", "questionImageUrl", "getQuestionImageUrl", "setQuestionImageUrl", ChronosDanmakuSender.KEY_VOTE_QUESTION, "getQuestion", "setQuestion", "selections", "", "getSelections", "()Ljava/util/List;", "setSelections", "(Ljava/util/List;)V", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "state", "getState", "setState", "failedNotes", "getFailedNotes", "setFailedNotes", "succeedNotes", "getSucceedNotes", "setSucceedNotes", "succeedBtnText", "getSucceedBtnText", "setSucceedBtnText", "succeedImageUrl", "getSucceedImageUrl", "setSucceedImageUrl", "gotNotes", "getGotNotes", "setGotNotes", "gotBtnText", "getGotBtnText", "setGotBtnText", "gotImageUrl", "getGotImageUrl", "setGotImageUrl", "adTagImageUrl", "getAdTagImageUrl", "setAdTagImageUrl", "adTagText", "getAdTagText", "setAdTagText", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewAnswerExtra {
        @JSONField(name = "ad_tag_image_url")
        private String adTagImageUrl;
        @JSONField(name = "ad_tag_text")
        private String adTagText;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "ball_id")
        private String ballId;
        @JSONField(name = "card_type")
        private Integer cardType;
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = "failed_notes")
        private String failedNotes;
        @JSONField(name = "got_btn_text")
        private String gotBtnText;
        @JSONField(name = "got_image_url")
        private String gotImageUrl;
        @JSONField(name = "got_notes")
        private String gotNotes;
        @JSONField(name = ChronosDanmakuSender.KEY_VOTE_QUESTION)
        private String question;
        @JSONField(name = "question_image_url")
        private String questionImageUrl;
        @JSONField(name = "selections")
        private List<String> selections;
        @JSONField(name = "state")
        private Integer state;
        @JSONField(name = "succeed_btn_text")
        private String succeedBtnText;
        @JSONField(name = "succeed_image_url")
        private String succeedImageUrl;
        @JSONField(name = "succeed_notes")
        private String succeedNotes;

        public final Integer getCardType() {
            return this.cardType;
        }

        public final void setCardType(Integer num) {
            this.cardType = num;
        }

        public final String getBallId() {
            return this.ballId;
        }

        public final void setBallId(String str) {
            this.ballId = str;
        }

        public final String getQuestionImageUrl() {
            return this.questionImageUrl;
        }

        public final void setQuestionImageUrl(String str) {
            this.questionImageUrl = str;
        }

        public final String getQuestion() {
            return this.question;
        }

        public final void setQuestion(String str) {
            this.question = str;
        }

        public final List<String> getSelections() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.selections);
        }

        public final void setSelections(List<String> list) {
            this.selections = list;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final Integer getState() {
            return this.state;
        }

        public final void setState(Integer num) {
            this.state = num;
        }

        public final String getFailedNotes() {
            return this.failedNotes;
        }

        public final void setFailedNotes(String str) {
            this.failedNotes = str;
        }

        public final String getSucceedNotes() {
            return this.succeedNotes;
        }

        public final void setSucceedNotes(String str) {
            this.succeedNotes = str;
        }

        public final String getSucceedBtnText() {
            return this.succeedBtnText;
        }

        public final void setSucceedBtnText(String str) {
            this.succeedBtnText = str;
        }

        public final String getSucceedImageUrl() {
            return this.succeedImageUrl;
        }

        public final void setSucceedImageUrl(String str) {
            this.succeedImageUrl = str;
        }

        public final String getGotNotes() {
            return this.gotNotes;
        }

        public final void setGotNotes(String str) {
            this.gotNotes = str;
        }

        public final String getGotBtnText() {
            return this.gotBtnText;
        }

        public final void setGotBtnText(String str) {
            this.gotBtnText = str;
        }

        public final String getGotImageUrl() {
            return this.gotImageUrl;
        }

        public final void setGotImageUrl(String str) {
            this.gotImageUrl = str;
        }

        public final String getAdTagImageUrl() {
            return this.adTagImageUrl;
        }

        public final void setAdTagImageUrl(String str) {
            this.adTagImageUrl = str;
        }

        public final String getAdTagText() {
            return this.adTagText;
        }

        public final void setAdTagText(String str) {
            this.adTagText = str;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b$\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R \u0010*\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R \u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R \u00100\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010R \u00103\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R \u00106\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R \u00109\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000e\"\u0004\b;\u0010\u0010R \u0010<\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010¨\u0006?"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$AdFloatViewGotExtra;", "", "<init>", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ballId", "", "getBallId", "()Ljava/lang/String;", "setBallId", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "notes", "getNotes", "setNotes", "btnText", "getBtnText", "setBtnText", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "state", "getState", "setState", "succeedNotes", "getSucceedNotes", "setSucceedNotes", "succeedBtnText", "getSucceedBtnText", "setSucceedBtnText", "succeedImageUrl", "getSucceedImageUrl", "setSucceedImageUrl", "gotNotes", "getGotNotes", "setGotNotes", "gotBtnText", "getGotBtnText", "setGotBtnText", "gotImageUrl", "getGotImageUrl", "setGotImageUrl", "adTagImageUrl", "getAdTagImageUrl", "setAdTagImageUrl", "adTagText", "getAdTagText", "setAdTagText", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewGotExtra {
        @JSONField(name = "ad_tag_image_url")
        private String adTagImageUrl;
        @JSONField(name = "ad_tag_text")
        private String adTagText;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "ball_id")
        private String ballId;
        @JSONField(name = "btn_text")
        private String btnText;
        @JSONField(name = "card_type")
        private Integer cardType;
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = "got_btn_text")
        private String gotBtnText;
        @JSONField(name = "got_image_url")
        private String gotImageUrl;
        @JSONField(name = "got_notes")
        private String gotNotes;
        @JSONField(name = "image_url")
        private String imageUrl;
        @JSONField(name = "notes")
        private String notes;
        @JSONField(name = "state")
        private Integer state;
        @JSONField(name = "succeed_btn_text")
        private String succeedBtnText;
        @JSONField(name = "succeed_image_url")
        private String succeedImageUrl;
        @JSONField(name = "succeed_notes")
        private String succeedNotes;

        public final Integer getCardType() {
            return this.cardType;
        }

        public final void setCardType(Integer num) {
            this.cardType = num;
        }

        public final String getBallId() {
            return this.ballId;
        }

        public final void setBallId(String str) {
            this.ballId = str;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final String getNotes() {
            return this.notes;
        }

        public final void setNotes(String str) {
            this.notes = str;
        }

        public final String getBtnText() {
            return this.btnText;
        }

        public final void setBtnText(String str) {
            this.btnText = str;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final Integer getState() {
            return this.state;
        }

        public final void setState(Integer num) {
            this.state = num;
        }

        public final String getSucceedNotes() {
            return this.succeedNotes;
        }

        public final void setSucceedNotes(String str) {
            this.succeedNotes = str;
        }

        public final String getSucceedBtnText() {
            return this.succeedBtnText;
        }

        public final void setSucceedBtnText(String str) {
            this.succeedBtnText = str;
        }

        public final String getSucceedImageUrl() {
            return this.succeedImageUrl;
        }

        public final void setSucceedImageUrl(String str) {
            this.succeedImageUrl = str;
        }

        public final String getGotNotes() {
            return this.gotNotes;
        }

        public final void setGotNotes(String str) {
            this.gotNotes = str;
        }

        public final String getGotBtnText() {
            return this.gotBtnText;
        }

        public final void setGotBtnText(String str) {
            this.gotBtnText = str;
        }

        public final String getGotImageUrl() {
            return this.gotImageUrl;
        }

        public final void setGotImageUrl(String str) {
            this.gotImageUrl = str;
        }

        public final String getAdTagImageUrl() {
            return this.adTagImageUrl;
        }

        public final void setAdTagImageUrl(String str) {
            this.adTagImageUrl = str;
        }

        public final String getAdTagText() {
            return this.adTagText;
        }

        public final void setAdTagText(String str) {
            this.adTagText = str;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R \u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R \u0010'\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R \u0010*\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R \u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R \u00100\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010R \u00103\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010R \u00106\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010¨\u00069"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$AdFloatViewCommerceExtra;", "", "<init>", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageWidth", "getImageWidth", "setImageWidth", "imageHeight", "getImageHeight", "setImageHeight", "adNotes", "getAdNotes", "setAdNotes", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "buttonText", "getButtonText", "setButtonText", "priceDesc", "getPriceDesc", "setPriceDesc", "priceSymbol", "getPriceSymbol", "setPriceSymbol", "curPrice", "getCurPrice", "setCurPrice", "oriPrice", "getOriPrice", "setOriPrice", "desc", "getDesc", "setDesc", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewCommerceExtra {
        @JSONField(name = "ad_notes")
        private String adNotes;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "button_text")
        private String buttonText;
        @JSONField(name = "card_type")
        private Integer cardType;
        @JSONField(name = "cur_price")
        private String curPrice;
        @JSONField(name = "desc")
        private String desc;
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = "image_height")
        private Integer imageHeight;
        @JSONField(name = "image_url")
        private String imageUrl;
        @JSONField(name = "image_width")
        private Integer imageWidth;
        @JSONField(name = "ori_price")
        private String oriPrice;
        @JSONField(name = "price_desc")
        private String priceDesc;
        @JSONField(name = "price_symbol")
        private String priceSymbol;
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        private String title;

        public final Integer getCardType() {
            return this.cardType;
        }

        public final void setCardType(Integer num) {
            this.cardType = num;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final Integer getImageWidth() {
            return this.imageWidth;
        }

        public final void setImageWidth(Integer num) {
            this.imageWidth = num;
        }

        public final Integer getImageHeight() {
            return this.imageHeight;
        }

        public final void setImageHeight(Integer num) {
            this.imageHeight = num;
        }

        public final String getAdNotes() {
            return this.adNotes;
        }

        public final void setAdNotes(String str) {
            this.adNotes = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final void setButtonText(String str) {
            this.buttonText = str;
        }

        public final String getPriceDesc() {
            return this.priceDesc;
        }

        public final void setPriceDesc(String str) {
            this.priceDesc = str;
        }

        public final String getPriceSymbol() {
            return this.priceSymbol;
        }

        public final void setPriceSymbol(String str) {
            this.priceSymbol = str;
        }

        public final String getCurPrice() {
            return this.curPrice;
        }

        public final void setCurPrice(String str) {
            this.curPrice = str;
        }

        public final String getOriPrice() {
            return this.oriPrice;
        }

        public final void setOriPrice(String str) {
            this.oriPrice = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R \u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R \u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R \u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\"\u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(¨\u0006-"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$AdFloatViewCommonExtra;", "", "<init>", "()V", "cardType", "", "getCardType", "()Ljava/lang/Integer;", "setCardType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageWidth", "getImageWidth", "setImageWidth", "imageHeight", "getImageHeight", "setImageHeight", "adNotes", "getAdNotes", "setAdNotes", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "desc", "getDesc", "setDesc", "buttonText", "getButtonText", "setButtonText", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AdFloatViewCommonExtra {
        @JSONField(name = "ad_notes")
        private String adNotes;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "button_text")
        private String buttonText;
        @JSONField(name = "card_type")
        private Integer cardType;
        @JSONField(name = "desc")
        private String desc;
        @JSONField(name = "duration")
        private Long duration;
        @JSONField(name = "image_height")
        private Integer imageHeight;
        @JSONField(name = "image_url")
        private String imageUrl;
        @JSONField(name = "image_width")
        private Integer imageWidth;
        @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
        private String title;

        public final Integer getCardType() {
            return this.cardType;
        }

        public final void setCardType(Integer num) {
            this.cardType = num;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final Integer getImageWidth() {
            return this.imageWidth;
        }

        public final void setImageWidth(Integer num) {
            this.imageWidth = num;
        }

        public final Integer getImageHeight() {
            return this.imageHeight;
        }

        public final void setImageHeight(Integer num) {
            this.imageHeight = num;
        }

        public final String getAdNotes() {
            return this.adNotes;
        }

        public final void setAdNotes(String str) {
            this.adNotes = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final void setButtonText(String str) {
            this.buttonText = str;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final void setDuration(Long l) {
            this.duration = l;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\"\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\"\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\"\u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\"\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\t¨\u0006-"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$LiveExtra;", "", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "userHash", "", "getUserHash", "()Ljava/lang/String;", "setUserHash", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "color", "getColor", "setColor", "sendFromMe", "", "getSendFromMe", "()Ljava/lang/Boolean;", "setSendFromMe", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "playerMode", "getPlayerMode", "setPlayerMode", "fontSize", "getFontSize", "setFontSize", "dmType", "getDmType", "setDmType", "bulgeDisplay", "getBulgeDisplay", "setBulgeDisplay", "recommendScore", "getRecommendScore", "setRecommendScore", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class LiveExtra {
        @JSONField(name = "bulge_display")
        private Integer bulgeDisplay;
        @JSONField(name = "color")
        private String color;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = "dm_type")
        private Integer dmType;
        @JSONField(name = "font_size")
        private Integer fontSize;
        @JSONField(name = "mode")
        private Integer mode;
        @JSONField(name = "player_mode")
        private Integer playerMode;
        @JSONField(name = "recommend_score")
        private Integer recommendScore;
        @JSONField(name = "send_from_me")
        private Boolean sendFromMe;
        @JSONField(name = "user_hash")
        private String userHash;

        public final Integer getMode() {
            return this.mode;
        }

        public final void setMode(Integer num) {
            this.mode = num;
        }

        public final String getUserHash() {
            return this.userHash;
        }

        public final void setUserHash(String str) {
            this.userHash = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final String getColor() {
            return this.color;
        }

        public final void setColor(String str) {
            this.color = str;
        }

        public final Boolean getSendFromMe() {
            return this.sendFromMe;
        }

        public final void setSendFromMe(Boolean bool) {
            this.sendFromMe = bool;
        }

        public final Integer getPlayerMode() {
            return this.playerMode;
        }

        public final void setPlayerMode(Integer num) {
            this.playerMode = num;
        }

        public final Integer getFontSize() {
            return this.fontSize;
        }

        public final void setFontSize(Integer num) {
            this.fontSize = num;
        }

        public final Integer getDmType() {
            return this.dmType;
        }

        public final void setDmType(Integer num) {
            this.dmType = num;
        }

        public final Integer getBulgeDisplay() {
            return this.bulgeDisplay;
        }

        public final void setBulgeDisplay(Integer num) {
            this.bulgeDisplay = num;
        }

        public final Integer getRecommendScore() {
            return this.recommendScore;
        }

        public final void setRecommendScore(Integer num) {
            this.recommendScore = num;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\"\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\"\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\"\u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR \u00100\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001d¨\u00063"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$NormalExtra;", "", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "fontSize", "getFontSize", "setFontSize", "color", "getColor", "setColor", "userHash", "", "getUserHash", "()Ljava/lang/String;", "setUserHash", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "ctime", "getCtime", "setCtime", "weight", "getWeight", "setWeight", "action", "getAction", "setAction", "pool", "getPool", "setPool", "attr", "getAttr", "setAttr", "animation", "getAnimation", "setAnimation", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NormalExtra {
        @JSONField(name = "action")
        private String action;
        @JSONField(name = "animation")
        private String animation;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "attr")
        private Integer attr;
        @JSONField(name = "color")
        private Integer color;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = "ctime")
        private Long ctime;
        @JSONField(name = "font_size")
        private Integer fontSize;
        @JSONField(name = "mode")
        private Integer mode;
        @JSONField(name = "pool")
        private Integer pool;
        @JSONField(name = "user_hash")
        private String userHash;
        @JSONField(name = "weight")
        private Integer weight;

        public final Integer getMode() {
            return this.mode;
        }

        public final void setMode(Integer num) {
            this.mode = num;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Integer getFontSize() {
            return this.fontSize;
        }

        public final void setFontSize(Integer num) {
            this.fontSize = num;
        }

        public final Integer getColor() {
            return this.color;
        }

        public final void setColor(Integer num) {
            this.color = num;
        }

        public final String getUserHash() {
            return this.userHash;
        }

        public final void setUserHash(String str) {
            this.userHash = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final Long getCtime() {
            return this.ctime;
        }

        public final void setCtime(Long l) {
            this.ctime = l;
        }

        public final Integer getWeight() {
            return this.weight;
        }

        public final void setWeight(Integer num) {
            this.weight = num;
        }

        public final String getAction() {
            return this.action;
        }

        public final void setAction(String str) {
            this.action = str;
        }

        public final Integer getPool() {
            return this.pool;
        }

        public final void setPool(Integer num) {
            this.pool = num;
        }

        public final Integer getAttr() {
            return this.attr;
        }

        public final void setAttr(Integer num) {
            this.attr = num;
        }

        public final String getAnimation() {
            return this.animation;
        }

        public final void setAnimation(String str) {
            this.animation = str;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\"\u0010'\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"R \u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\t¨\u0006-"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$InteractExtra;", "", "<init>", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "ctime", "", "getCtime", "()Ljava/lang/Long;", "setCtime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mtime", "getMtime", "setMtime", "appearanceTime", "getAppearanceTime", "setAppearanceTime", "videoId", "getVideoId", "setVideoId", "userId", "getUserId", "setUserId", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "command", "getCommand", "setCommand", "state", "getState", "setState", "extra", "getExtra", "setExtra", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class InteractExtra {
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "command")
        private String command;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = "ctime")
        private Long ctime;
        @JSONField(name = "extra")
        private String extra;
        @JSONField(name = "mtime")
        private Long mtime;
        @JSONField(name = "state")
        private Integer state;
        @JSONField(name = "type")
        private Integer type;
        @JSONField(name = "user_id")
        private String userId;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final Long getCtime() {
            return this.ctime;
        }

        public final void setCtime(Long l) {
            this.ctime = l;
        }

        public final Long getMtime() {
            return this.mtime;
        }

        public final void setMtime(Long l) {
            this.mtime = l;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final void setUserId(String str) {
            this.userId = str;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public final String getCommand() {
            return this.command;
        }

        public final void setCommand(String str) {
            this.command = str;
        }

        public final Integer getState() {
            return this.state;
        }

        public final void setState(Integer num) {
            this.state = num;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final void setExtra(String str) {
            this.extra = str;
        }
    }

    /* compiled from: AddCustomDanmaku.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/AddCustomDanmaku$Companion;", "", "<init>", "()V", "TYPE_THUMB_UP", "", "TYPE_AD", "TYPE_REPLY", "TYPE_LIVE", "TYPE_NORMAL", "TYPE_REAL_TIME_NORMAL", "TYPE_REAL_TIME_INTERACT", "TYPE_LIVE_DANMU_V2", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}