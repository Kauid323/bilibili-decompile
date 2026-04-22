package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FeatureListChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/FeatureListChange;", "", "<init>", "()V", "Request", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FeatureListChange {

    /* compiled from: FeatureListChange.kt */
    @RequestDefine(method = "OnFeatureListsChanged")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006\u0011"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/FeatureListChange$Request;", "", "<init>", "()V", "chapterGuide", "", "getChapterGuide", "()Ljava/lang/Boolean;", "setChapterGuide", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "forcedChapterGuide", "getForcedChapterGuide", "setForcedChapterGuide", "eyesProtectionMode", "getEyesProtectionMode", "setEyesProtectionMode", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "chapter_guide")
        private Boolean chapterGuide;
        @JSONField(name = "teenager_eyes_shield")
        private Boolean eyesProtectionMode;
        @JSONField(name = "forced_chapter_guide")
        private Boolean forcedChapterGuide;

        public final Boolean getChapterGuide() {
            return this.chapterGuide;
        }

        public final void setChapterGuide(Boolean bool) {
            this.chapterGuide = bool;
        }

        public final Boolean getForcedChapterGuide() {
            return this.forcedChapterGuide;
        }

        public final void setForcedChapterGuide(Boolean bool) {
            this.forcedChapterGuide = bool;
        }

        public final Boolean getEyesProtectionMode() {
            return this.eyesProtectionMode;
        }

        public final void setEyesProtectionMode(Boolean bool) {
            this.eyesProtectionMode = bool;
        }
    }
}