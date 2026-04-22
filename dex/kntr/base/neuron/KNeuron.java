package kntr.base.neuron;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: KNeuron.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J-\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0096\u0001J-\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0096\u0001J5\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0096\u0001J½\u0001\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0096\u0001J;\u0010'\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0)H\u0096\u0001¨\u0006*"}, d2 = {"Lkntr/base/neuron/KNeuron;", "Lkntr/base/neuron/IPlatformNeuron;", "<init>", "()V", "simpleTrackT", "", "eventId", "", "extra", "", "events", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/neuron/IPlatformNeuron$Event;", "reportClick", "force", "", "reportExposure", "reportIjk", "logId", "reportPlayer", "playFromSpmid", "seasonId", "type", "", "subType", "epId", "progress", WatchLaterReporterKt.KEY_AVID, "cid", "networkType", "danmaku", "status", "playMethod", "playType", "playerSessionId", "speed", "playerClarity", "isAutoplay", "videoFormat", "trackT", "sampler", "Lkotlin/Function0;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KNeuron implements IPlatformNeuron {
    public static final KNeuron INSTANCE = new KNeuron();
    private final /* synthetic */ IPlatformNeuron $$delegate_0 = KNeuronKt.getMPlatformNeuron();

    @Override // kntr.base.neuron.IPlatformNeuron
    public Flow<IPlatformNeuron.Event> events() {
        return this.$$delegate_0.events();
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportClick(boolean z, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.$$delegate_0.reportClick(z, str, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportExposure(boolean z, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.$$delegate_0.reportExposure(z, str, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportIjk(boolean z, String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "logId");
        Intrinsics.checkNotNullParameter(str2, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.$$delegate_0.reportIjk(z, str, str2, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportPlayer(boolean z, String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7, int i3, int i4, int i5, int i6, int i7, String str8, String str9, String str10, int i8, int i9, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "playFromSpmid");
        Intrinsics.checkNotNullParameter(str3, "seasonId");
        Intrinsics.checkNotNullParameter(str4, "epId");
        Intrinsics.checkNotNullParameter(str5, "progress");
        Intrinsics.checkNotNullParameter(str6, WatchLaterReporterKt.KEY_AVID);
        Intrinsics.checkNotNullParameter(str7, "cid");
        Intrinsics.checkNotNullParameter(str8, "playerSessionId");
        Intrinsics.checkNotNullParameter(str9, "speed");
        Intrinsics.checkNotNullParameter(str10, "playerClarity");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.$$delegate_0.reportPlayer(z, str, str2, str3, i, i2, str4, str5, str6, str7, i3, i4, i5, i6, i7, str8, str9, str10, i8, i9, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void trackT(boolean z, String str, Map<String, String> map, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Intrinsics.checkNotNullParameter(function0, "sampler");
        this.$$delegate_0.trackT(z, str, map, function0);
    }

    private KNeuron() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean simpleTrackT$lambda$0() {
        return true;
    }

    public final void simpleTrackT(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        trackT(false, eventId, map, new Function0() { // from class: kntr.base.neuron.KNeuron$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean simpleTrackT$lambda$0;
                simpleTrackT$lambda$0 = KNeuron.simpleTrackT$lambda$0();
                return Boolean.valueOf(simpleTrackT$lambda$0);
            }
        });
    }
}