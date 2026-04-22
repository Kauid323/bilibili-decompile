package tv.danmaku.biliplayerv2.service.interact.biz.chronos;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.AdDanmakuEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive.NotifyCommercialEvent;
import tv.danmaku.biliplayerv2.service.interact.biz.model.AdDanmakuBean;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AdDanmakuDelegate.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001e\u001a\u00020\u0012J[\u0010\u001f\u001a\u00020\u00122S\u0010 \u001aO\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eJ\u0016\u0010!\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J&\u0010\"\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J-\u0010#\u001a\u00020\u00122#\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014H\u0016JY\u0010$\u001a\u00020\u00122O\u0010 \u001aK\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eH\u0016J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'J-\u0010(\u001a\u00020\u00122#\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014H\u0016J\u000e\u0010)\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cJ(\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R[\u0010\r\u001aO\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000RW\u0010\u0016\u001aK\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/AdDanmakuDelegate;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/IAdDanmakuDelegate;", "<init>", "()V", "TAG", "", "avid", "", "Ljava/lang/Long;", "cid", "danmakus", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/AdDanmakuBean;", "exposureRequestHandler", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "", "readyHandler", "Lkotlin/Function1;", "adDanmaku", "eventHandler", "", "event", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/AdDanmakuEvent$Extra;", "extra", "commercialEventHandler", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyCommercialEvent$Request;", "req", "release", "setExposureRequestHandler", "handler", "configExposureRequest", "feedData2Chronos", "setReadyHandler", "setEventHandler", "onEvent", "param", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/AdDanmakuEvent$Request;", "setCommercialEventHandler", "onNotifyCommercialEvent", "find", "id", "isTarget", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AdDanmakuDelegate implements IAdDanmakuDelegate {
    private Long avid;
    private Long cid;
    private Function1<? super NotifyCommercialEvent.Request, Unit> commercialEventHandler;
    private Function3<? super AdDanmakuBean, ? super Integer, ? super AdDanmakuEvent.Extra, Unit> eventHandler;
    private Function3<? super List<? extends AdDanmakuBean>, ? super Long, ? super Long, Unit> exposureRequestHandler;
    private Function1<? super AdDanmakuBean, Unit> readyHandler;
    private final String TAG = "AdDanmakuDelegate";
    private List<AdDanmakuBean> danmakus = new ArrayList();

    public final void release() {
        this.avid = null;
        this.cid = null;
        this.danmakus.clear();
        this.exposureRequestHandler = null;
        this.readyHandler = null;
        this.eventHandler = null;
        this.commercialEventHandler = null;
    }

    public final void setExposureRequestHandler(Function3<? super List<? extends AdDanmakuBean>, ? super Long, ? super Long, Unit> function3) {
        this.exposureRequestHandler = function3;
    }

    public final void configExposureRequest(long avid, long cid) {
        if (isTarget(avid, cid)) {
            for (AdDanmakuBean dm : this.danmakus) {
                Function1<? super AdDanmakuBean, Unit> function1 = this.readyHandler;
                if (function1 != null) {
                    function1.invoke(dm);
                }
            }
            Function3<? super List<? extends AdDanmakuBean>, ? super Long, ? super Long, Unit> function3 = this.exposureRequestHandler;
            if (function3 != null) {
                function3.invoke(this.danmakus, Long.valueOf(avid), Long.valueOf(cid));
                return;
            }
            return;
        }
        this.danmakus.clear();
        this.avid = Long.valueOf(avid);
        this.cid = Long.valueOf(cid);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.IAdDanmakuDelegate
    public void feedData2Chronos(List<? extends AdDanmakuBean> list, long avid, long cid) {
        List<AdDanmakuBean> danmakus = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(danmakus, "danmakus");
        boolean target = isTarget(avid, cid);
        if (target) {
            for (AdDanmakuBean dm : danmakus) {
                if (!this.danmakus.contains(dm)) {
                    Function1<? super AdDanmakuBean, Unit> function1 = this.readyHandler;
                    if (function1 != null) {
                        function1.invoke(dm);
                    }
                    this.danmakus.add(dm);
                }
            }
            Function3<? super List<? extends AdDanmakuBean>, ? super Long, ? super Long, Unit> function3 = this.exposureRequestHandler;
            if (function3 != null) {
                function3.invoke(danmakus, Long.valueOf(avid), Long.valueOf(cid));
                return;
            }
            return;
        }
        this.danmakus.clear();
        this.avid = Long.valueOf(avid);
        this.cid = Long.valueOf(cid);
        for (AdDanmakuBean dm2 : danmakus) {
            this.danmakus.add(dm2);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.IAdDanmakuDelegate
    public void setReadyHandler(Function1<? super AdDanmakuBean, Unit> function1) {
        this.readyHandler = function1;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.IAdDanmakuDelegate
    public void setEventHandler(Function3<? super AdDanmakuBean, ? super Integer, ? super AdDanmakuEvent.Extra, Unit> function3) {
        this.eventHandler = function3;
    }

    public final void onEvent(AdDanmakuEvent.Request param) {
        Function3<? super AdDanmakuBean, ? super Integer, ? super AdDanmakuEvent.Extra, Unit> function3;
        Intrinsics.checkNotNullParameter(param, "param");
        AdDanmakuBean that = find(param.getDanmakuId(), param.getWorkId(), param.getVideoId());
        if (that != null && (function3 = this.eventHandler) != null) {
            Integer event = param.getEvent();
            Intrinsics.checkNotNull(event);
            function3.invoke(that, event, param.getExtra());
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.IAdDanmakuDelegate
    public void setCommercialEventHandler(Function1<? super NotifyCommercialEvent.Request, Unit> function1) {
        this.commercialEventHandler = function1;
    }

    public final void onNotifyCommercialEvent(NotifyCommercialEvent.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        Function1<? super NotifyCommercialEvent.Request, Unit> function1 = this.commercialEventHandler;
        if (function1 != null) {
            function1.invoke(req);
        }
    }

    private final AdDanmakuBean find(String id, String avid, String cid) {
        Object obj;
        if (id == null || avid == null || cid == null) {
            return null;
        }
        try {
            if (!isTarget(Long.parseLong(avid), Long.parseLong(cid))) {
                return null;
            }
            Iterator<T> it = this.danmakus.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                AdDanmakuBean it2 = (AdDanmakuBean) obj;
                if (Intrinsics.areEqual(String.valueOf(it2.hashCode()), id)) {
                    break;
                }
            }
            return (AdDanmakuBean) obj;
        } catch (Exception e) {
            BLog.e(this.TAG, e.getMessage());
            return null;
        }
    }

    private final boolean isTarget(long avid, long cid) {
        Long l;
        Long l2 = this.avid;
        return l2 != null && l2.longValue() == avid && (l = this.cid) != null && l.longValue() == cid;
    }
}