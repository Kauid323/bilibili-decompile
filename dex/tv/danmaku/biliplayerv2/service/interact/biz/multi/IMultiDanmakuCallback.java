package tv.danmaku.biliplayerv2.service.interact.biz.multi;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.ChronosScene;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetVideoSize;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.GetWorkInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IMultiDanmakuCallback.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/multi/IMultiDanmakuCallback;", "", "getWorkInfo", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetWorkInfo$Response;", "getVideoSize", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/GetVideoSize$Response;", "getScene", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/ChronosScene;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMultiDanmakuCallback {
    ChronosScene getScene();

    GetVideoSize.Response getVideoSize();

    GetWorkInfo.Response getWorkInfo();

    /* compiled from: IMultiDanmakuCallback.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.multi.IMultiDanmakuCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static GetVideoSize.Response $default$getVideoSize(IMultiDanmakuCallback _this) {
            return null;
        }
    }
}