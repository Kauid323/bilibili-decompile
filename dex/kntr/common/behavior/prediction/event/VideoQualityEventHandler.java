package kntr.common.behavior.prediction.event;

import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kntr.common.behavior.prediction.IBehaviorData;
import kntr.common.behavior.prediction.impl.DateUtilsModel;
import kntr.common.behavior.prediction.impl.UtilsKt;
import kntr.common.behavior.prediction.model.VideoQualityDeviceSwitchInfo;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VideoQualityEventHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkntr/common/behavior/prediction/event/VideoQualityEventHandler;", "Lkntr/common/behavior/prediction/event/IBPNeuronEventHandler;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "handle", "Lkntr/common/behavior/prediction/IBehaviorData;", "event", "Lkntr/base/neuron/IPlatformNeuron$Event;", "(Lkntr/base/neuron/IPlatformNeuron$Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RecentBehaviorData", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityEventHandler implements IBPNeuronEventHandler {
    private final String name;

    public VideoQualityEventHandler() {
        this(null, 1, null);
    }

    public VideoQualityEventHandler(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public /* synthetic */ VideoQualityEventHandler(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "video-quality-event" : str);
    }

    @Override // kntr.common.behavior.prediction.event.IBPNeuronEventHandler
    public String getName() {
        return this.name;
    }

    @Override // kntr.common.behavior.prediction.event.IBPNeuronEventHandler
    public Object handle(IPlatformNeuron.Event event, Continuation<? super IBehaviorData> continuation) {
        if (Intrinsics.areEqual(event.getEventId(), "player.player.clarity-type.0.player")) {
            Map map = event.getExtends();
            UtilsKt.logV(getName(), "start detail event { ctime: " + event.getCtime() + ", extends: " + map + " }.");
            if (event instanceof IPlatformNeuron.Event.Player) {
                DateUtilsModel tm = new DateUtilsModel(event.getCtime());
                int isAuto = VideoQualityEventHandlerKt.getIntValue$default(map, "is_auto", 0, 2, null);
                int fromIsAuto = VideoQualityEventHandlerKt.getIntValue$default(map, "from_is_auto", 0, 2, null);
                long ctime = event.getCtime();
                int networkType = ((IPlatformNeuron.Event.Player) event).getNetworkType();
                int holidayType = tm.getHolidayType();
                int vacationType = tm.getVacationType();
                Integer intOrNull = StringsKt.toIntOrNull(((IPlatformNeuron.Event.Player) event).getPlayerClarity());
                int intValue = intOrNull != null ? intOrNull.intValue() : -1;
                return new RecentBehaviorData(CollectionsKt.listOf(new VideoQualityDeviceSwitchInfo(ctime, networkType, fromIsAuto != 0 ? VideoQualityEventHandlerKt.getIntValue$default(map, "from_qn", 0, 2, null) : 0, isAuto == 0 ? 0 : VideoQualityEventHandlerKt.getIntValue$default(map, "qn", 0, 2, null), intValue, holidayType, vacationType)));
            }
            UtilsKt.logE(getName(), "player.player.clarity-type.0.player is not PlayerEvent.");
        }
        return null;
    }

    /* compiled from: VideoQualityEventHandler.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/common/behavior/prediction/event/VideoQualityEventHandler$RecentBehaviorData;", "Lkntr/common/behavior/prediction/IBehaviorData;", "recentSwitches", "", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo;", "<init>", "(Ljava/util/List;)V", "getRecentSwitches", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RecentBehaviorData implements IBehaviorData {
        private final List<VideoQualityDeviceSwitchInfo> recentSwitches;

        public RecentBehaviorData() {
            this(null, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RecentBehaviorData copy$default(RecentBehaviorData recentBehaviorData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = recentBehaviorData.recentSwitches;
            }
            return recentBehaviorData.copy(list);
        }

        public final List<VideoQualityDeviceSwitchInfo> component1() {
            return this.recentSwitches;
        }

        public final RecentBehaviorData copy(List<VideoQualityDeviceSwitchInfo> list) {
            Intrinsics.checkNotNullParameter(list, "recentSwitches");
            return new RecentBehaviorData(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RecentBehaviorData) && Intrinsics.areEqual(this.recentSwitches, ((RecentBehaviorData) obj).recentSwitches);
        }

        public int hashCode() {
            return this.recentSwitches.hashCode();
        }

        public String toString() {
            return "RecentBehaviorData(recentSwitches=" + this.recentSwitches + ")";
        }

        public RecentBehaviorData(List<VideoQualityDeviceSwitchInfo> list) {
            Intrinsics.checkNotNullParameter(list, "recentSwitches");
            this.recentSwitches = list;
        }

        public /* synthetic */ RecentBehaviorData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<VideoQualityDeviceSwitchInfo> getRecentSwitches() {
            return this.recentSwitches;
        }
    }
}