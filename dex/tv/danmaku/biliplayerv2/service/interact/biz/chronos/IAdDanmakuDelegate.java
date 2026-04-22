package tv.danmaku.biliplayerv2.service.interact.biz.chronos;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.AdDanmakuEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyCommercialEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.model.AdDanmakuBean;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AdDanmakuDelegate.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J-\u0010\n\u001a\u00020\u00032#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&JY\u0010\u0010\u001a\u00020\u00032O\u0010\u000b\u001aK\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011H&J-\u0010\u0016\u001a\u00020\u00032#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/IAdDanmakuDelegate;", "", "feedData2Chronos", "", "danmakus", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "avid", "", "cid", "setReadyHandler", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "adDanmaku", "setEventHandler", "Lkotlin/Function3;", "", "event", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/AdDanmakuEvent$Extra;", "extra", "setCommercialEventHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyCommercialEvent$Request;", "req", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IAdDanmakuDelegate {
    void feedData2Chronos(List<? extends AdDanmakuBean> list, long j, long j2);

    void setCommercialEventHandler(Function1<? super NotifyCommercialEvent.Request, Unit> function1);

    void setEventHandler(Function3<? super AdDanmakuBean, ? super Integer, ? super AdDanmakuEvent.Extra, Unit> function3);

    void setReadyHandler(Function1<? super AdDanmakuBean, Unit> function1);
}