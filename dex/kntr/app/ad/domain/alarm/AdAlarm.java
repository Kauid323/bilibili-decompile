package kntr.app.ad.domain.alarm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: AdAlarm.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/ad/domain/alarm/AdAlarm;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "fire", RoomRecommendViewModel.EMPTY_CURSOR, "event", "Lkntr/app/ad/domain/alarm/AdAlarmEvent;", "commonParams", "Lkntr/app/ad/domain/alarm/IAdAlarmCommonParams;", "extraMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "alarm_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdAlarm {
    public static final AdAlarm INSTANCE = new AdAlarm();

    private AdAlarm() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fire$default(AdAlarm adAlarm, AdAlarmEvent adAlarmEvent, IAdAlarmCommonParams iAdAlarmCommonParams, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        adAlarm.fire(adAlarmEvent, iAdAlarmCommonParams, map);
    }

    public final void fire(final AdAlarmEvent event, IAdAlarmCommonParams commonParams, Map<String, String> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(commonParams, "commonParams");
        Intrinsics.checkNotNullParameter(map, "extraMap");
        Map extra = MapsKt.plus(IAdAlarmCommonParamsKt.asMap(commonParams), map);
        Logger_androidKt.getAdLog().w("AdAlarm", "event: " + event);
        if (AdAlarmSamplerKt.getAlarm_toggle()) {
            try {
                Result.Companion companion = Result.Companion;
                AdAlarm $this$fire_u24lambda_u240 = this;
                KNeuron kNeuron = KNeuron.INSTANCE;
                String value = event.getValue();
                Map linkedHashMap = new LinkedHashMap();
                Iterator it = extra.entrySet().iterator();
                while (true) {
                    AdAlarm $this$fire_u24lambda_u2402 = $this$fire_u24lambda_u240;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry element$iv$iv = (Map.Entry) it.next();
                    if (element$iv$iv.getValue() != null) {
                        linkedHashMap.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                        $this$fire_u24lambda_u240 = $this$fire_u24lambda_u2402;
                    } else {
                        $this$fire_u24lambda_u240 = $this$fire_u24lambda_u2402;
                    }
                }
                Map $this$mapValues$iv = linkedHashMap;
                Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
                Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
                for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                    Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                    Object key = it$iv$iv.getKey();
                    Object value2 = ((Map.Entry) element$iv$iv$iv).getValue();
                    Intrinsics.checkNotNull(value2);
                    destination$iv$iv.put(key, (String) value2);
                    $this$mapValues$iv = $this$mapValues$iv;
                }
                kNeuron.trackT(true, value, destination$iv$iv, new Function0() { // from class: kntr.app.ad.domain.alarm.AdAlarm$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean fire$lambda$0$2;
                        fire$lambda$0$2 = AdAlarm.fire$lambda$0$2(AdAlarmEvent.this);
                        return Boolean.valueOf(fire$lambda$0$2);
                    }
                });
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable it2 = Result.exceptionOrNull-impl(obj);
            if (it2 != null) {
                Logger_androidKt.getAdLog().e("AdAlarm", "fire: " + event + ", error: " + it2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean fire$lambda$0$2(AdAlarmEvent $event) {
        return Random.Default.nextInt(0, 100) < $event.getSampler();
    }
}