package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.bili.videopage.common.callback.ShareIconObserverKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OGVTimelineMaterialChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVTimelineMaterialChange;", "", "<init>", "()V", "Request", "Material", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OGVTimelineMaterialChange {

    /* compiled from: OGVTimelineMaterialChange.kt */
    @RequestDefine(method = "OnOgvTimelineMaterialChanged")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVTimelineMaterialChange$Request;", "", "<init>", "()V", "workId", "", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "videoId", "getVideoId", "setVideoId", "epId", "getEpId", "setEpId", "material", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVTimelineMaterialChange$Material;", "getMaterial", "()Ljava/util/List;", "setMaterial", "(Ljava/util/List;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "ep_id")
        private String epId;
        @JSONField(name = "materials")
        private List<Material> material;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;
        @JSONField(name = "work_id")
        private String workId;

        public final String getWorkId() {
            return this.workId;
        }

        public final void setWorkId(String str) {
            this.workId = str;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }

        public final String getEpId() {
            return this.epId;
        }

        public final void setEpId(String str) {
            this.epId = str;
        }

        public final List<Material> getMaterial() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.material);
        }

        public final void setMaterial(List<Material> list) {
            this.material = list;
        }
    }

    /* compiled from: OGVTimelineMaterialChange.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R \u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OGVTimelineMaterialChange$Material;", "", "<init>", "()V", "begin", "", "getBegin", "()Ljava/lang/Long;", "setBegin", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", ShareIconObserverKt.SHARE_FROM_END, "getEnd", "setEnd", "type", "getType", "setType", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "targetWorkId", "getTargetWorkId", "setTargetWorkId", "targetVideoId", "getTargetVideoId", "setTargetVideoId", "targetEpId", "getTargetEpId", "setTargetEpId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Material {
        @JSONField(name = "begin")
        private Long begin;
        @JSONField(name = ShareIconObserverKt.SHARE_FROM_END)
        private Long end;
        @JSONField(name = "target_ep_id")
        private String targetEpId;
        @JSONField(name = "target_video_id")
        private String targetVideoId;
        @JSONField(name = "target_work_id")
        private String targetWorkId;
        @JSONField(name = "type")
        private Long type;
        @JSONField(name = "url")
        private String url;

        public final Long getBegin() {
            return this.begin;
        }

        public final void setBegin(Long l) {
            this.begin = l;
        }

        public final Long getEnd() {
            return this.end;
        }

        public final void setEnd(Long l) {
            this.end = l;
        }

        public final Long getType() {
            return this.type;
        }

        public final void setType(Long l) {
            this.type = l;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final String getTargetWorkId() {
            return this.targetWorkId;
        }

        public final void setTargetWorkId(String str) {
            this.targetWorkId = str;
        }

        public final String getTargetVideoId() {
            return this.targetVideoId;
        }

        public final void setTargetVideoId(String str) {
            this.targetVideoId = str;
        }

        public final String getTargetEpId() {
            return this.targetEpId;
        }

        public final void setTargetEpId(String str) {
            this.targetEpId = str;
        }
    }
}