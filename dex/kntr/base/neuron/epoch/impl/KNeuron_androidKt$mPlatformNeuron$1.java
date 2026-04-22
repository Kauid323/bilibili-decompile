package kntr.base.neuron.epoch.impl;

import com.bilibili.gripper.api.neuron.GNeurons;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.neuron.epoch.impl.NeuronBaseEvent;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: KNeuron.android.kt */
@Metadata(d1 = {"\u0000Y\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016J,\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012H\u0016J,\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012H\u0016J¼\u0001\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012H\u0016J4\u0010+\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0.H\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"kntr/base/neuron/epoch/impl/KNeuron_androidKt$mPlatformNeuron$1", "Lkntr/base/neuron/IPlatformNeuron;", "neuron", "Lcom/bilibili/gripper/api/neuron/GNeurons;", "getNeuron", "()Lcom/bilibili/gripper/api/neuron/GNeurons;", "allowEventIds", "", "", "eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/base/neuron/IPlatformNeuron$Event;", "trackT", "", "force", "", "eventId", "extra", "", "sampler", "Lkotlin/Function0;", "reportClick", "reportExposure", "reportPlayer", "playFromSpmid", "seasonId", "type", "", "subType", "epId", "progress", WatchLaterReporterKt.KEY_AVID, "cid", "networkType", "danmaku", "status", "playMethod", "playType", "playerSessionId", "speed", "playerClarity", "isAutoplay", "videoFormat", "reportIjk", "logId", "events", "Lkotlinx/coroutines/flow/Flow;", "handleEvent", "event", "Lcom/bilibili/gripper/api/neuron/GNeurons$GEvent;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KNeuron_androidKt$mPlatformNeuron$1 implements IPlatformNeuron {
    private final Set<String> allowEventIds;
    private final MutableSharedFlow<IPlatformNeuron.Event> eventFlow;
    private final GNeurons neuron;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KNeuron_androidKt$mPlatformNeuron$1() {
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GNeurons.class, (String) null, 2, (Object) null);
        Intrinsics.checkNotNull(suspendProducer);
        this.neuron = (GNeurons) suspendProducer.get();
        this.allowEventIds = KNeuron_androidKt.getSetValue$default(KConfig.INSTANCE, "neuron.kt_observer_allow_event_ids", SetsKt.setOf(new String[]{"infra.net", "infra.webimage", "player.player.clarity-type.0.player"}), null, 4, null);
        this.eventFlow = SharedFlowKt.MutableSharedFlow$default(0, 16, (BufferOverflow) null, 4, (Object) null);
        if (!KConfig.INSTANCE.ff("neuron.kt_observer_enable", true)) {
            return;
        }
        this.neuron.addObserver(new Function1() { // from class: kntr.base.neuron.epoch.impl.KNeuron_androidKt$mPlatformNeuron$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = KNeuron_androidKt$mPlatformNeuron$1._init_$lambda$0(KNeuron_androidKt$mPlatformNeuron$1.this, (GNeurons.GEvent) obj);
                return _init_$lambda$0;
            }
        });
    }

    public final GNeurons getNeuron() {
        return this.neuron;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(KNeuron_androidKt$mPlatformNeuron$1 this$0, GNeurons.GEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.handleEvent(it);
        return Unit.INSTANCE;
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void trackT(boolean force, String eventId, Map<String, String> map, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Intrinsics.checkNotNullParameter(function0, "sampler");
        this.neuron.trackT(force, eventId, map, 1, function0);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportClick(boolean force, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.neuron.reportClick(force, eventId, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportExposure(boolean force, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.neuron.reportExposure(force, eventId, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportPlayer(boolean force, String eventId, String playFromSpmid, String seasonId, int type, int subType, String epId, String progress, String avid, String cid, int networkType, int danmaku, int status, int playMethod, int playType, String playerSessionId, String speed, String playerClarity, int isAutoplay, int videoFormat, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(playFromSpmid, "playFromSpmid");
        Intrinsics.checkNotNullParameter(seasonId, "seasonId");
        Intrinsics.checkNotNullParameter(epId, "epId");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(avid, WatchLaterReporterKt.KEY_AVID);
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(playerSessionId, "playerSessionId");
        Intrinsics.checkNotNullParameter(speed, "speed");
        Intrinsics.checkNotNullParameter(playerClarity, "playerClarity");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.neuron.reportPlayer(force, eventId, playFromSpmid, seasonId, type, subType, epId, progress, avid, cid, networkType, danmaku, status, playMethod, playType, playerSessionId, speed, playerClarity, isAutoplay, videoFormat, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public void reportIjk(boolean force, String logId, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(logId, "logId");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        this.neuron.reportIjk(force, logId, eventId, map);
    }

    @Override // kntr.base.neuron.IPlatformNeuron
    public Flow<IPlatformNeuron.Event> events() {
        return FlowKt.asSharedFlow(this.eventFlow);
    }

    private final void handleEvent(GNeurons.GEvent event) {
        if (this.allowEventIds.contains(event.getEventId()) || this.allowEventIds.contains("*")) {
            NeuronBaseEvent.Player kEvent = event instanceof GNeurons.GEvent.PlayerEvent ? new NeuronBaseEvent.Player((GNeurons.GEvent.PlayerEvent) event) : new NeuronBaseEvent(event);
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new KNeuron_androidKt$mPlatformNeuron$1$handleEvent$1(this, kEvent, null), 3, (Object) null);
        }
    }
}