package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SwitchMultiView.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/SwitchMultiView;", "", "<init>", "()V", "Request", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SwitchMultiView {

    /* compiled from: SwitchMultiView.kt */
    @RequestDefine(method = "SwitchMultiView")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/SwitchMultiView$Request;", "", "<init>", "()V", "epId", "", "getEpId", "()J", "setEpId", "(J)V", "clickType", "", "getClickType", "()I", "setClickType", "(I)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = WatchLaterReporterKt.KEY_CLICK_TYPE)
        private int clickType;
        @JSONField(name = "ep_id")
        private long epId;

        public final long getEpId() {
            return this.epId;
        }

        public final void setEpId(long j) {
            this.epId = j;
        }

        public final int getClickType() {
            return this.clickType;
        }

        public final void setClickType(int i) {
            this.clickType = i;
        }
    }
}