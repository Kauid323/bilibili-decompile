package kntr.base.neuron;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IPlatformNeuron.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001'J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH&J.\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&J.\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&J¼\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&J6\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H&¨\u0006(À\u0006\u0003"}, d2 = {"Lkntr/base/neuron/IPlatformNeuron;", "", "trackT", "", "force", "", "eventId", "", "extra", "", "sampler", "Lkotlin/Function0;", "reportClick", "reportExposure", "reportPlayer", "playFromSpmid", "seasonId", "type", "", "subType", "epId", "progress", WatchLaterReporterKt.KEY_AVID, "cid", "networkType", "danmaku", "status", "playMethod", "playType", "playerSessionId", "speed", "playerClarity", "isAutoplay", "videoFormat", "reportIjk", "logId", "events", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/neuron/IPlatformNeuron$Event;", "Event", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPlatformNeuron {

    /* compiled from: IPlatformNeuron.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u000e\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/base/neuron/IPlatformNeuron$Event;", "", "ctime", "", "getCtime", "()J", "eventId", "", "getEventId", "()Ljava/lang/String;", "extends", "", "getExtends", "()Ljava/util/Map;", "Player", "Ijk", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Event {

        /* compiled from: IPlatformNeuron.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/base/neuron/IPlatformNeuron$Event$Ijk;", "Lkntr/base/neuron/IPlatformNeuron$Event;", "logId", "", "getLogId", "()Ljava/lang/String;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public interface Ijk extends Event {
            String getLogId();
        }

        /* compiled from: IPlatformNeuron.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0012\u0010\u0018\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0012\u0010\u001a\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000bR\u0012\u0010\u001c\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000bR\u0012\u0010\u001e\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000bR\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0012\u0010&\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000bR\u0012\u0010'\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000b¨\u0006)À\u0006\u0003"}, d2 = {"Lkntr/base/neuron/IPlatformNeuron$Event$Player;", "Lkntr/base/neuron/IPlatformNeuron$Event;", "playFromSpmid", "", "getPlayFromSpmid", "()Ljava/lang/String;", "seasonId", "getSeasonId", "type", "", "getType", "()I", "subType", "getSubType", "epId", "getEpId", "progress", "getProgress", WatchLaterReporterKt.KEY_AVID, "getAvid", "cid", "getCid", "networkType", "getNetworkType", "danmaku", "getDanmaku", "status", "getStatus", "playMethod", "getPlayMethod", "playType", "getPlayType", "playerSessionId", "getPlayerSessionId", "speed", "getSpeed", "playerClarity", "getPlayerClarity", "isAutoplay", "videoFormat", "getVideoFormat", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public interface Player extends Event {
            String getAvid();

            String getCid();

            int getDanmaku();

            String getEpId();

            int getNetworkType();

            String getPlayFromSpmid();

            int getPlayMethod();

            int getPlayType();

            String getPlayerClarity();

            String getPlayerSessionId();

            String getProgress();

            String getSeasonId();

            String getSpeed();

            int getStatus();

            int getSubType();

            int getType();

            int getVideoFormat();

            int isAutoplay();
        }

        long getCtime();

        String getEventId();

        Map<String, String> getExtends();
    }

    Flow<Event> events();

    void reportClick(boolean z, String str, Map<String, String> map);

    void reportExposure(boolean z, String str, Map<String, String> map);

    void reportIjk(boolean z, String str, String str2, Map<String, String> map);

    void reportPlayer(boolean z, String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7, int i3, int i4, int i5, int i6, int i7, String str8, String str9, String str10, int i8, int i9, Map<String, String> map);

    void trackT(boolean z, String str, Map<String, String> map, Function0<Boolean> function0);

    /* compiled from: IPlatformNeuron.kt */
    /* renamed from: kntr.base.neuron.IPlatformNeuron$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportClick$default(IPlatformNeuron iPlatformNeuron, boolean z, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            iPlatformNeuron.reportClick(z, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportExposure$default(IPlatformNeuron iPlatformNeuron, boolean z, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportExposure");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            iPlatformNeuron.reportExposure(z, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportIjk$default(IPlatformNeuron iPlatformNeuron, boolean z, String str, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportIjk");
            }
            if ((i & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            iPlatformNeuron.reportIjk(z, str, str2, map);
        }
    }

    /* compiled from: IPlatformNeuron.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}