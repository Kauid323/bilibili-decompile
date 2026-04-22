package kntr.app.im.chat.ui.neuron;

import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.neuron.IPlatformNeuronKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatReporter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J&\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00052\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011J&\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00052\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011J\u001e\u0010\u0017\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011J&\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00052\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011J&\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00052\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011J&\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00052\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lkntr/app/im/chat/ui/neuron/ChatReporter;", RoomRecommendViewModel.EMPTY_CURSOR, "reportService", "Lkntr/base/neuron/IPlatformNeuron;", "pageEventCore", RoomRecommendViewModel.EMPTY_CURSOR, "pageEventParamMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "<init>", "(Lkntr/base/neuron/IPlatformNeuron;Ljava/lang/String;Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "getPageEventCore", "()Ljava/lang/String;", "getPageEventParamMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "appendParam", RoomRecommendViewModel.EMPTY_CURSOR, "param", RoomRecommendViewModel.EMPTY_CURSOR, "getPvReportEvent", "reportMsgShow", "msgType", "cardEventMap", "reportMsgClick", "reportMsgAvatarClick", "reportMsgPopupMenu", "menuType", "reportModuleShow", "eventId", "moduleEventMap", "reportModuleClick", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatReporter {
    public static final int $stable = 0;
    private final String pageEventCore;
    private final SnapshotStateMap<String, String> pageEventParamMap;
    private final IPlatformNeuron reportService;

    public ChatReporter(IPlatformNeuron reportService, String pageEventCore, SnapshotStateMap<String, String> snapshotStateMap) {
        Intrinsics.checkNotNullParameter(reportService, "reportService");
        Intrinsics.checkNotNullParameter(pageEventCore, "pageEventCore");
        Intrinsics.checkNotNullParameter(snapshotStateMap, "pageEventParamMap");
        this.reportService = reportService;
        this.pageEventCore = pageEventCore;
        this.pageEventParamMap = snapshotStateMap;
    }

    public /* synthetic */ ChatReporter(IPlatformNeuron iPlatformNeuron, String str, SnapshotStateMap snapshotStateMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPlatformNeuron, (i & 2) != 0 ? "chat-single" : str, (i & 4) != 0 ? new SnapshotStateMap() : snapshotStateMap);
    }

    public final String getPageEventCore() {
        return this.pageEventCore;
    }

    public final SnapshotStateMap<String, String> getPageEventParamMap() {
        return this.pageEventParamMap;
    }

    public final void appendParam(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        this.pageEventParamMap.putAll(map);
    }

    public final String getPvReportEvent() {
        return "im." + this.pageEventCore + ".0.0.pv";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportMsgShow$default(ChatReporter chatReporter, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        chatReporter.reportMsgShow(str, map);
    }

    public final void reportMsgShow(String msgType, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(map, "cardEventMap");
        String event = "im." + this.pageEventCore + "." + msgType + ".0.show";
        reportModuleShow(event, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportMsgClick$default(ChatReporter chatReporter, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        chatReporter.reportMsgClick(str, map);
    }

    public final void reportMsgClick(String msgType, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(map, "cardEventMap");
        String event = "im." + this.pageEventCore + "." + msgType + ".0.click";
        reportModuleClick(event, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportMsgAvatarClick$default(ChatReporter chatReporter, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        chatReporter.reportMsgAvatarClick(map);
    }

    public final void reportMsgAvatarClick(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "cardEventMap");
        String event = "im." + this.pageEventCore + ".msg-avatar.0.click";
        reportModuleClick(event, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportMsgPopupMenu$default(ChatReporter chatReporter, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        chatReporter.reportMsgPopupMenu(str, map);
    }

    public final void reportMsgPopupMenu(String menuType, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(menuType, "menuType");
        Intrinsics.checkNotNullParameter(map, "cardEventMap");
        String event = "im." + this.pageEventCore + ".msg.long-press.click";
        reportModuleClick(event, MapsKt.plus(MapsKt.mapOf(TuplesKt.to("type", menuType)), map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportModuleShow$default(ChatReporter chatReporter, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        chatReporter.reportModuleShow(str, map);
    }

    public final void reportModuleShow(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "moduleEventMap");
        IPlatformNeuronKt.reportExposure(this.reportService, false, eventId, MapsKt.plus(this.pageEventParamMap, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportModuleClick$default(ChatReporter chatReporter, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        chatReporter.reportModuleClick(str, map);
    }

    public final void reportModuleClick(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "moduleEventMap");
        IPlatformNeuronKt.reportClick(this.reportService, false, eventId, MapsKt.plus(this.pageEventParamMap, map));
    }
}