package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DeviceInfoChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DeviceInfoChange;", "", "<init>", "()V", "Request", "SafeArea", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DeviceInfoChange {

    /* compiled from: DeviceInfoChange.kt */
    @RequestDefine(method = "OnDeviceInfoChanged")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DeviceInfoChange$Request;", "", "<init>", "()V", "safeArea", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DeviceInfoChange$SafeArea;", "getSafeArea", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DeviceInfoChange$SafeArea;", "setSafeArea", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DeviceInfoChange$SafeArea;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "safe_area")
        private SafeArea safeArea;

        public final SafeArea getSafeArea() {
            return this.safeArea;
        }

        public final void setSafeArea(SafeArea safeArea) {
            this.safeArea = safeArea;
        }
    }

    /* compiled from: DeviceInfoChange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DeviceInfoChange$SafeArea;", "", "<init>", "()V", "top", "", "getTop", "()Ljava/lang/Float;", "setTop", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "left", "getLeft", "setLeft", "bottom", "getBottom", "setBottom", "right", "getRight", "setRight", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SafeArea {
        @JSONField(name = "bottom")
        private Float bottom;
        @JSONField(name = "left")
        private Float left;
        @JSONField(name = "right")
        private Float right;
        @JSONField(name = "top")
        private Float top;

        public final Float getTop() {
            return this.top;
        }

        public final void setTop(Float f) {
            this.top = f;
        }

        public final Float getLeft() {
            return this.left;
        }

        public final void setLeft(Float f) {
            this.left = f;
        }

        public final Float getBottom() {
            return this.bottom;
        }

        public final void setBottom(Float f) {
            this.bottom = f;
        }

        public final Float getRight() {
            return this.right;
        }

        public final void setRight(Float f) {
            this.right = f;
        }
    }
}