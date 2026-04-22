package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: GetVideoSize.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetVideoSize;", "", "<init>", "()V", "Request", "Response", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GetVideoSize {

    /* compiled from: GetVideoSize.kt */
    @RequestDefine(method = "GetVideoSize")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetVideoSize$Request;", "", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
    }

    /* compiled from: GetVideoSize.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001d"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetVideoSize$Response;", "", "<init>", "()V", "origin", "", "getOrigin", "()[F", "setOrigin", "([F)V", "size", "", "getSize", "()[I", "setSize", "([I)V", "translation", "getTranslation", "setTranslation", "rotation", "", "getRotation", "()Ljava/lang/Float;", "setRotation", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "scale", "getScale", "setScale", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response {
        @JSONField(name = "origin")
        private float[] origin;
        @JSONField(name = "rotation")
        private Float rotation;
        @JSONField(name = "scale")
        private float[] scale;
        @JSONField(name = "size")
        private int[] size;
        @JSONField(name = "translation")
        private float[] translation;

        public final float[] getOrigin() {
            return this.origin;
        }

        public final void setOrigin(float[] fArr) {
            this.origin = fArr;
        }

        public final int[] getSize() {
            return this.size;
        }

        public final void setSize(int[] iArr) {
            this.size = iArr;
        }

        public final float[] getTranslation() {
            return this.translation;
        }

        public final void setTranslation(float[] fArr) {
            this.translation = fArr;
        }

        public final Float getRotation() {
            return this.rotation;
        }

        public final void setRotation(Float f) {
            this.rotation = f;
        }

        public final float[] getScale() {
            return this.scale;
        }

        public final void setScale(float[] fArr) {
            this.scale = fArr;
        }
    }
}