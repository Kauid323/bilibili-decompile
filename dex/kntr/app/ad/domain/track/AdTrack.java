package kntr.app.ad.domain.track;

import java.util.Map;
import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: AdTrack.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/ad/domain/track/AdTrack;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "track", RoomRecommendViewModel.EMPTY_CURSOR, "event", "Lkntr/app/ad/domain/track/AdTrackEvent;", "commonParams", "Lkntr/app/ad/domain/track/IAdTrackCommonParams;", "extraMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "track_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdTrack {
    public static final AdTrack INSTANCE = new AdTrack();

    private AdTrack() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(AdTrack adTrack, AdTrackEvent adTrackEvent, IAdTrackCommonParams iAdTrackCommonParams, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        adTrack.track(adTrackEvent, iAdTrackCommonParams, map);
    }

    public final void track(final AdTrackEvent event, IAdTrackCommonParams commonParams, Map<String, String> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(commonParams, "commonParams");
        Intrinsics.checkNotNullParameter(map, "extraMap");
        Map extra = MapsKt.plus(IAdTrackCommonParamsKt.asMap(commonParams), IAdTrackCommonParamsKt.filter(map));
        ILogger adLog = Logger_androidKt.getAdLog();
        String name = event.name();
        String str = map.get("code");
        adLog.d("AdTrack", "event: " + name + ", code:" + ((Object) str) + ", sampler: " + event.getSampler());
        if (AdTrackSamplerKt.getTrack_toggle()) {
            try {
                Result.Companion companion = Result.Companion;
                AdTrack adTrack = this;
                KNeuron.INSTANCE.trackT(false, event.getValue(), extra, new Function0() { // from class: kntr.app.ad.domain.track.AdTrack$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean track$lambda$0$0;
                        track$lambda$0$0 = AdTrack.track$lambda$0$0(AdTrackEvent.this);
                        return Boolean.valueOf(track$lambda$0$0);
                    }
                });
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable it = Result.exceptionOrNull-impl(obj);
            if (it != null) {
                Logger_androidKt.getAdLog().e("AdTrack", "fire: " + event + ", error: " + it);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean track$lambda$0$0(AdTrackEvent $event) {
        return Random.Default.nextInt(0, 100) < $event.getSampler();
    }
}