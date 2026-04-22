package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerControlBarChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlayerControlBarChange;", "", "<init>", "()V", "Request", "Response", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerControlBarChange {

    /* compiled from: PlayerControlBarChange.kt */
    @RequestDefine(method = "OnPlayerControlBarChanged")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlayerControlBarChange$Request;", "", "<init>", "()V", "display", "", "getDisplay", "()Ljava/lang/Boolean;", "setDisplay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "tinyProgress", "getTinyProgress", "setTinyProgress", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "display")
        private Boolean display;
        @JSONField(name = "tiny_progress")
        private Boolean tinyProgress;

        public final Boolean getDisplay() {
            return this.display;
        }

        public final void setDisplay(Boolean bool) {
            this.display = bool;
        }

        public final Boolean getTinyProgress() {
            return this.tinyProgress;
        }

        public final void setTinyProgress(Boolean bool) {
            this.tinyProgress = bool;
        }
    }

    /* compiled from: PlayerControlBarChange.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlayerControlBarChange$Response;", "", "<init>", "()V", "tinyProgress", "", "getTinyProgress", "()Ljava/lang/Boolean;", "setTinyProgress", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response {
        @JSONField(name = "tiny_progress")
        private Boolean tinyProgress;

        public final Boolean getTinyProgress() {
            return this.tinyProgress;
        }

        public final void setTinyProgress(Boolean bool) {
            this.tinyProgress = bool;
        }
    }
}