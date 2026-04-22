package kntr.base.neuron.epoch.impl;

import com.bilibili.gripper.api.neuron.GNeurons;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KNeuron.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkntr/base/neuron/epoch/impl/NeuronBaseEvent;", "Lkntr/base/neuron/IPlatformNeuron$Event;", "event", "Lcom/bilibili/gripper/api/neuron/GNeurons$GEvent;", "<init>", "(Lcom/bilibili/gripper/api/neuron/GNeurons$GEvent;)V", "getEvent", "()Lcom/bilibili/gripper/api/neuron/GNeurons$GEvent;", "ctime", "", "getCtime", "()J", "eventId", "", "getEventId", "()Ljava/lang/String;", "extends", "", "getExtends", "()Ljava/util/Map;", "Player", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
class NeuronBaseEvent implements IPlatformNeuron.Event {
    private final GNeurons.GEvent event;

    public NeuronBaseEvent(GNeurons.GEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    /* renamed from: getEvent */
    public GNeurons.GEvent mo1775getEvent() {
        return this.event;
    }

    @Override // kntr.base.neuron.IPlatformNeuron.Event
    public long getCtime() {
        return mo1775getEvent().getCtime();
    }

    @Override // kntr.base.neuron.IPlatformNeuron.Event
    public String getEventId() {
        return mo1775getEvent().getEventId();
    }

    @Override // kntr.base.neuron.IPlatformNeuron.Event
    public Map<String, String> getExtends() {
        return mo1775getEvent().getExtends();
    }

    /* compiled from: KNeuron.android.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0012R\u0014\u0010!\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0012R\u0014\u0010%\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0012R\u0014\u0010'\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\fR\u0014\u0010)\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\fR\u0014\u0010+\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\fR\u0014\u0010-\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0012R\u0014\u0010.\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0012¨\u00060"}, d2 = {"Lkntr/base/neuron/epoch/impl/NeuronBaseEvent$Player;", "Lkntr/base/neuron/epoch/impl/NeuronBaseEvent;", "Lkntr/base/neuron/IPlatformNeuron$Event$Player;", "event", "Lcom/bilibili/gripper/api/neuron/GNeurons$GEvent$PlayerEvent;", "<init>", "(Lcom/bilibili/gripper/api/neuron/GNeurons$GEvent$PlayerEvent;)V", "getEvent", "()Lcom/bilibili/gripper/api/neuron/GNeurons$GEvent$PlayerEvent;", "playFromSpmid", "", "getPlayFromSpmid", "()Ljava/lang/String;", "seasonId", "getSeasonId", "type", "", "getType", "()I", "subType", "getSubType", "epId", "getEpId", "progress", "getProgress", WatchLaterReporterKt.KEY_AVID, "getAvid", "cid", "getCid", "networkType", "getNetworkType", "danmaku", "getDanmaku", "status", "getStatus", "playMethod", "getPlayMethod", "playType", "getPlayType", "playerSessionId", "getPlayerSessionId", "speed", "getSpeed", "playerClarity", "getPlayerClarity", "isAutoplay", "videoFormat", "getVideoFormat", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Player extends NeuronBaseEvent implements IPlatformNeuron.Event.Player {
        private final GNeurons.GEvent.PlayerEvent event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Player(GNeurons.GEvent.PlayerEvent event) {
            super((GNeurons.GEvent) event);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        @Override // kntr.base.neuron.epoch.impl.NeuronBaseEvent
        /* renamed from: getEvent */
        public GNeurons.GEvent.PlayerEvent mo1775getEvent() {
            return this.event;
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getPlayFromSpmid() {
            return mo1775getEvent().getPlayFromSpmid();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getSeasonId() {
            return mo1775getEvent().getSeasonId();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getType() {
            return mo1775getEvent().getType();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getSubType() {
            return mo1775getEvent().getSubType();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getEpId() {
            return mo1775getEvent().getEpId();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getProgress() {
            return mo1775getEvent().getProgress();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getAvid() {
            return mo1775getEvent().getAvid();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getCid() {
            return mo1775getEvent().getCid();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getNetworkType() {
            return mo1775getEvent().getNetworkType();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getDanmaku() {
            return mo1775getEvent().getDanmaku();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getStatus() {
            return mo1775getEvent().getStatus();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getPlayMethod() {
            return mo1775getEvent().getPlayMethod();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getPlayType() {
            return mo1775getEvent().getPlayType();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getPlayerSessionId() {
            return mo1775getEvent().getPlayerSessionId();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getSpeed() {
            return mo1775getEvent().getSpeed();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public String getPlayerClarity() {
            return mo1775getEvent().getPlayerClarity();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int isAutoplay() {
            return mo1775getEvent().isAutoplay();
        }

        @Override // kntr.base.neuron.IPlatformNeuron.Event.Player
        public int getVideoFormat() {
            return mo1775getEvent().getVideoFormat();
        }
    }
}