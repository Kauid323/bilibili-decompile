package kntr.common.upper.trace;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: ITraceManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u001e\u0010\u0005\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007H&JH\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0007H&Jh\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H&J\\\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0014H&J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0007H&J.\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lkntr/common/upper/trace/ITraceManager;", "", "setUid", AppKey.UID, "", "addGlobalExtendsInfo", "params", "", "start", "projectType", "projectID", "eventTraceName", "eventKey", "eventLog", "eventExtra", "process", "eventLevel", "Lkntr/common/upper/trace/EventLevel;", "eventTraceID", "newTrace", "", "removeTrace", "end", "", "totalTraces", "Lkntr/common/upper/trace/TraceEventChain;", "currentTrace", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ITraceManager {
    ITraceManager addGlobalExtendsInfo(Map<String, ? extends Object> map);

    TraceEventChain currentTrace(String str, String str2, String str3);

    void end(String str, String str2, String str3, EventLevel eventLevel, String str4, Map<String, ? extends Object> map, boolean z);

    String process(String str, String str2, String str3, EventLevel eventLevel, String str4, Map<String, ? extends Object> map, boolean z, boolean z2);

    ITraceManager setUid(String str);

    String start(String str, String str2, String str3, String str4, String str5, Map<String, ? extends Object> map);

    Map<String, TraceEventChain> totalTraces();

    /* compiled from: ITraceManager.kt */
    /* renamed from: kntr.common.upper.trace.ITraceManager$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ITraceManager addGlobalExtendsInfo$default(ITraceManager iTraceManager, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = MapsKt.emptyMap();
                }
                return iTraceManager.addGlobalExtendsInfo(map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addGlobalExtendsInfo");
        }

        public static /* synthetic */ String start$default(ITraceManager iTraceManager, String str, String str2, String str3, String str4, String str5, Map map, int i, Object obj) {
            String str6;
            Map map2;
            if (obj == null) {
                if ((i & 16) == 0) {
                    str6 = str5;
                } else {
                    str6 = "";
                }
                if ((i & 32) == 0) {
                    map2 = map;
                } else {
                    map2 = MapsKt.emptyMap();
                }
                return iTraceManager.start(str, str2, str3, str4, str6, map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }

        public static /* synthetic */ String process$default(ITraceManager iTraceManager, String str, String str2, String str3, EventLevel eventLevel, String str4, Map map, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                String str5 = (i & 1) != 0 ? null : str;
                String str6 = (i & 4) != 0 ? "" : str3;
                EventLevel eventLevel2 = (i & 8) != 0 ? EventLevel.INFO : eventLevel;
                String str7 = (i & 16) != 0 ? null : str4;
                Map emptyMap = (i & 32) != 0 ? MapsKt.emptyMap() : map;
                boolean z3 = (i & 64) != 0 ? false : z;
                return iTraceManager.process(str5, str2, str6, eventLevel2, str7, emptyMap, z3, (i & 128) != 0 ? z3 : z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: process");
        }

        public static /* synthetic */ void end$default(ITraceManager iTraceManager, String str, String str2, String str3, EventLevel eventLevel, String str4, Map map, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: end");
            }
            iTraceManager.end((i & 1) != 0 ? null : str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? EventLevel.INFO : eventLevel, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? MapsKt.emptyMap() : map, (i & 64) != 0 ? true : z);
        }

        public static /* synthetic */ TraceEventChain currentTrace$default(ITraceManager iTraceManager, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return iTraceManager.currentTrace(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: currentTrace");
        }
    }

    /* compiled from: ITraceManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}