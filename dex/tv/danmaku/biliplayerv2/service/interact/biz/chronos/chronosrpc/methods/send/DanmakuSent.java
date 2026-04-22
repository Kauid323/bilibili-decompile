package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.biliplayerv2.utils.DanmakuSendHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuSent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuSent;", "", "<init>", "()V", "Request", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuSent {

    /* compiled from: DanmakuSent.kt */
    @RequestDefine(method = "OnDanmakuSent")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\"\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR \u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR \u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\t¨\u00063"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuSent$Request;", "", "<init>", "()V", "danmakuId", "", "getDanmakuId", "()Ljava/lang/String;", "setDanmakuId", "(Ljava/lang/String;)V", "appearanceTime", "", "getAppearanceTime", "()Ljava/lang/Long;", "setAppearanceTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mode", "", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "actions", "getActions", "setActions", "fontSize", "getFontSize", "setFontSize", "fontColor", "getFontColor", "setFontColor", "content", "getContent", "setContent", "userHash", "getUserHash", "setUserHash", "animation", "getAnimation", "setAnimation", "colorful", "Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;", "getColorful", "()Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;", "setColorful", "(Ltv/danmaku/biliplayerv2/utils/DanmakuSendHelper$Colorful;)V", "videoId", "getVideoId", "setVideoId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "actions")
        private String actions;
        @JSONField(name = "animation")
        private String animation;
        @JSONField(name = "appearance_time")
        private Long appearanceTime;
        @JSONField(name = "colorful")
        private DanmakuSendHelper.Colorful colorful;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = "danmaku_id")
        private String danmakuId;
        @JSONField(name = "font_color")
        private Integer fontColor;
        @JSONField(name = "font_size")
        private Integer fontSize;
        @JSONField(name = "mode")
        private Integer mode;
        @JSONField(name = "user_hash")
        private String userHash;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;

        public final String getDanmakuId() {
            return this.danmakuId;
        }

        public final void setDanmakuId(String str) {
            this.danmakuId = str;
        }

        public final Long getAppearanceTime() {
            return this.appearanceTime;
        }

        public final void setAppearanceTime(Long l) {
            this.appearanceTime = l;
        }

        public final Integer getMode() {
            return this.mode;
        }

        public final void setMode(Integer num) {
            this.mode = num;
        }

        public final String getActions() {
            return this.actions;
        }

        public final void setActions(String str) {
            this.actions = str;
        }

        public final Integer getFontSize() {
            return this.fontSize;
        }

        public final void setFontSize(Integer num) {
            this.fontSize = num;
        }

        public final Integer getFontColor() {
            return this.fontColor;
        }

        public final void setFontColor(Integer num) {
            this.fontColor = num;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final String getUserHash() {
            return this.userHash;
        }

        public final void setUserHash(String str) {
            this.userHash = str;
        }

        public final String getAnimation() {
            return this.animation;
        }

        public final void setAnimation(String str) {
            this.animation = str;
        }

        public final DanmakuSendHelper.Colorful getColorful() {
            return this.colorful;
        }

        public final void setColorful(DanmakuSendHelper.Colorful colorful) {
            this.colorful = colorful;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }
    }
}