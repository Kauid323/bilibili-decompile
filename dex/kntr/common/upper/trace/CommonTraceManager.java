package kntr.common.upper.trace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.upper.trace.config.AppKey;
import kntr.common.upper.trace.config.ProjectKey;
import kntr.common.upper.trace.config.TraceGlobal;
import kntr.common.upper.trace.service.TraceEventGraph;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CommonTraceManager.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011H\u0016JD\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011H\u0016JZ\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016JP\u0010!\u001a\u00020\"2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0011H\u0016J(\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J,\u0010%\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010 \u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0002J$\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bj\u0002`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkntr/common/upper/trace/CommonTraceManager;", "Lkntr/common/upper/trace/ITraceManager;", "eventID", "", "<init>", "(Ljava/lang/String;)V", "traceMap", "Ljava/util/LinkedHashMap;", "Lkntr/common/upper/trace/TraceEventChain;", "Lkotlin/collections/LinkedHashMap;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "setUid", AppKey.UID, "addGlobalExtendsInfo", "params", "", "", "start", "projectType", "projectID", "eventTraceName", "eventKey", "eventLog", "eventExtra", "process", "eventLevel", "Lkntr/common/upper/trace/EventLevel;", "eventTraceID", "newTrace", "", "removeTrace", "end", "", "totalTraces", "currentTrace", "createTrace", "valuesToString", "Companion", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommonTraceManager implements ITraceManager {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, CommonTraceManager> managers = new LinkedHashMap();
    private final String eventID;
    private final ReentrantLock lock;
    private final LinkedHashMap<String, TraceEventChain> traceMap;

    public /* synthetic */ CommonTraceManager(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private CommonTraceManager(String eventID) {
        this.eventID = eventID;
        this.traceMap = new LinkedHashMap<>();
        this.lock = new ReentrantLock();
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public /* bridge */ /* synthetic */ ITraceManager addGlobalExtendsInfo(Map params) {
        return addGlobalExtendsInfo((Map<String, ? extends Object>) params);
    }

    /* compiled from: CommonTraceManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/common/upper/trace/CommonTraceManager$Companion;", "", "<init>", "()V", "managers", "", "", "Lkntr/common/upper/trace/CommonTraceManager;", "INSTANCE", "eventID", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CommonTraceManager INSTANCE(String eventID) {
            Intrinsics.checkNotNullParameter(eventID, "eventID");
            CommonTraceManager commonTraceManager = (CommonTraceManager) CommonTraceManager.managers.get(eventID);
            if (commonTraceManager == null) {
                CommonTraceManager it = new CommonTraceManager(eventID, null);
                CommonTraceManager.managers.put(eventID, it);
                return it;
            }
            return commonTraceManager;
        }
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public CommonTraceManager setUid(String uid) {
        Intrinsics.checkNotNullParameter(uid, AppKey.UID);
        TraceGlobal.INSTANCE.setUid(uid);
        return this;
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public CommonTraceManager addGlobalExtendsInfo(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        CommonTraceManager $this$addGlobalExtendsInfo_u24lambda_u240 = this;
        TraceGlobal.INSTANCE.getExtendParams().putAll($this$addGlobalExtendsInfo_u24lambda_u240.valuesToString(map));
        return this;
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public String start(String projectType, String projectID, String eventTraceName, String eventKey, String eventLog, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(projectType, "projectType");
        Intrinsics.checkNotNullParameter(projectID, "projectID");
        Intrinsics.checkNotNullParameter(eventTraceName, "eventTraceName");
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        Intrinsics.checkNotNullParameter(map, "eventExtra");
        this.lock.lock();
        TraceEventChain current = createTrace$default(this, projectID, projectType, eventTraceName, null, 8, null);
        current.start(eventKey, eventLog, valuesToString(map));
        this.lock.unlock();
        return current.getEventTraceID();
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public String process(String eventTraceName, String eventKey, String eventLog, EventLevel eventLevel, String eventTraceID, Map<String, ? extends Object> map, boolean newTrace, boolean removeTrace) {
        TraceEventChain current;
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        Intrinsics.checkNotNullParameter(eventLevel, "eventLevel");
        Intrinsics.checkNotNullParameter(map, "eventExtra");
        this.lock.lock();
        Map extra = valuesToString(map);
        if (newTrace) {
            String str = extra.get(ProjectKey.PROJECT_ID);
            if (str == null) {
                str = "";
            }
            String str2 = extra.get(ProjectKey.PROJECT_TYPE);
            if (str2 == null) {
                str2 = "";
            }
            current = createTrace(str, str2, eventTraceName != null ? eventTraceName : "", eventTraceID);
        } else {
            current = currentTrace(eventTraceName, eventTraceID, eventKey);
        }
        if (current == null || current.process(eventKey, eventLog, extra, eventLevel) == null) {
            CommonTraceManager $this$process_u24lambda_u240 = this;
            TraceUtilsKt.traceW(KLog_androidKt.getKLog(), "[" + eventTraceName + "][" + eventKey + "] cannot be found");
            TraceUtilsKt.traceDetail(KLog_androidKt.getKLog(), "Current cache: " + $this$process_u24lambda_u240.totalTraces().keySet());
            Unit unit = Unit.INSTANCE;
        }
        if (current != null && removeTrace) {
            removeTrace(current.getEventTraceName(), current.getEventTraceID());
        }
        this.lock.unlock();
        if (current != null) {
            return current.getEventTraceID();
        }
        return null;
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public void end(String eventTraceName, String eventKey, String eventLog, EventLevel eventLevel, String eventTraceID, Map<String, ? extends Object> map, boolean removeTrace) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        Intrinsics.checkNotNullParameter(eventLevel, "eventLevel");
        Intrinsics.checkNotNullParameter(map, "eventExtra");
        this.lock.lock();
        TraceEventChain current = currentTrace(eventTraceName, eventTraceID, eventKey);
        if (current == null || current.end(eventKey, eventLog, valuesToString(map), eventLevel) == null) {
            CommonTraceManager $this$end_u24lambda_u240 = this;
            TraceUtilsKt.traceW(KLog_androidKt.getKLog(), "[" + eventTraceName + "][" + eventKey + "] cannot be found");
            TraceUtilsKt.traceDetail(KLog_androidKt.getKLog(), "Current cache: " + $this$end_u24lambda_u240.totalTraces().keySet());
            Unit unit = Unit.INSTANCE;
        }
        if (current != null && removeTrace) {
            removeTrace(current.getEventTraceName(), current.getEventTraceID());
        }
        this.lock.unlock();
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public Map<String, TraceEventChain> totalTraces() {
        return this.traceMap;
    }

    @Override // kntr.common.upper.trace.ITraceManager
    public TraceEventChain currentTrace(String eventTraceName, String eventTraceID, String eventKey) {
        TraceEventChain traceEventChain;
        Object element$iv;
        Map.Entry it;
        Object maxElem$iv;
        String str = eventTraceName;
        this.lock.lock();
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            String str3 = eventTraceID;
            if (!(str3 == null || str3.length() == 0)) {
                traceEventChain = this.traceMap.get(str + ":" + eventTraceID);
                TraceEventChain trace = traceEventChain;
                this.lock.unlock();
                return trace;
            }
        }
        String str4 = str;
        if (!(str4 == null || str4.length() == 0)) {
            Iterable entrySet = this.traceMap.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
            Iterable $this$filter$iv = entrySet;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Object key = ((Map.Entry) element$iv$iv).getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                Iterable $this$filter$iv2 = $this$filter$iv;
                if (StringsKt.contains$default((CharSequence) key, str, false, 2, (Object) null)) {
                    destination$iv$iv.add(element$iv$iv);
                }
                str = eventTraceName;
                $this$filter$iv = $this$filter$iv2;
            }
            Iterable $this$maxByOrNull$iv = (List) destination$iv$iv;
            Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
            if (iterator$iv.hasNext()) {
                maxElem$iv = iterator$iv.next();
                if (iterator$iv.hasNext()) {
                    TraceEvent lastEvent = ((TraceEventChain) ((Map.Entry) maxElem$iv).getValue()).lastEvent();
                    long maxValue$iv = lastEvent != null ? lastEvent.getEventTime() : 0L;
                    do {
                        Object e$iv = iterator$iv.next();
                        TraceEvent lastEvent2 = ((TraceEventChain) ((Map.Entry) e$iv).getValue()).lastEvent();
                        long v$iv = lastEvent2 != null ? lastEvent2.getEventTime() : 0L;
                        if (maxValue$iv < v$iv) {
                            maxElem$iv = e$iv;
                            maxValue$iv = v$iv;
                        }
                    } while (iterator$iv.hasNext());
                }
            } else {
                maxElem$iv = null;
            }
            Map.Entry entry = (Map.Entry) maxElem$iv;
            traceEventChain = entry != null ? (TraceEventChain) entry.getValue() : null;
        } else {
            String str5 = eventKey;
            if (!(str5 == null || str5.length() == 0)) {
                Iterable entrySet2 = this.traceMap.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet2, "<get-entries>(...)");
                Iterable $this$sortedBy$iv = entrySet2;
                List $this$lastOrNull$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.common.upper.trace.CommonTraceManager$currentTrace$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Map.Entry it2 = (Map.Entry) t;
                        TraceEvent lastEvent3 = ((TraceEventChain) it2.getValue()).lastEvent();
                        Long valueOf = Long.valueOf(lastEvent3 != null ? lastEvent3.getEventTime() : 0L);
                        Map.Entry it3 = (Map.Entry) t2;
                        TraceEvent lastEvent4 = ((TraceEventChain) it3.getValue()).lastEvent();
                        return ComparisonsKt.compareValues(valueOf, Long.valueOf(lastEvent4 != null ? lastEvent4.getEventTime() : 0L));
                    }
                });
                ListIterator iterator$iv2 = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
                while (true) {
                    if (iterator$iv2.hasPrevious()) {
                        element$iv = iterator$iv2.previous();
                        Map.Entry it2 = (Map.Entry) element$iv;
                        Object key2 = it2.getKey();
                        Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                        String traceName = (String) CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) key2, new String[]{":"}, false, 0, 6, (Object) null));
                        TraceEvent lastEvent3 = ((TraceEventChain) it2.getValue()).lastEvent();
                        String current = (lastEvent3 == null || (current = lastEvent3.getEventKey()) == null) ? "" : "";
                        String str6 = traceName;
                        if ((str6 == null || str6.length() == 0) || !TraceEventGraph.INSTANCE.enableNextStrict$trace_core_debug(traceName, current, eventKey)) {
                            it = null;
                            continue;
                        } else {
                            it = 1;
                            continue;
                        }
                        if (it != null) {
                            break;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                Map.Entry entry2 = (Map.Entry) element$iv;
                traceEventChain = entry2 != null ? (TraceEventChain) entry2.getValue() : null;
            } else {
                traceEventChain = null;
            }
        }
        TraceEventChain trace2 = traceEventChain;
        this.lock.unlock();
        return trace2;
    }

    static /* synthetic */ TraceEventChain createTrace$default(CommonTraceManager commonTraceManager, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = null;
        }
        return commonTraceManager.createTrace(str, str2, str3, str4);
    }

    private final TraceEventChain createTrace(String projectID, String projectType, String eventTraceName, String eventTraceID) {
        String traceID = eventTraceID == null ? TraceUtils.INSTANCE.newTraceID() : eventTraceID;
        TraceEventChain current = new TraceEventChain(traceID, eventTraceName, this.eventID, TraceGlobal.INSTANCE.getAppTraceID(), projectID, projectType);
        String chainKey = eventTraceName + ":" + current.getEventTraceID();
        this.traceMap.put(chainKey, current);
        return current;
    }

    static /* synthetic */ void removeTrace$default(CommonTraceManager commonTraceManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        commonTraceManager.removeTrace(str, str2);
    }

    private final void removeTrace(String eventTraceName, String eventTraceID) {
        String str = eventTraceID;
        if (str == null || str.length() == 0) {
            Map $this$filter$iv = this.traceMap;
            Map destination$iv$iv = new LinkedHashMap();
            for (Map.Entry element$iv$iv : $this$filter$iv.entrySet()) {
                Map $this$filter$iv2 = $this$filter$iv;
                if (!StringsKt.contains$default(element$iv$iv.getKey(), eventTraceName, false, 2, (Object) null)) {
                    $this$filter$iv = $this$filter$iv2;
                } else {
                    destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                    $this$filter$iv = $this$filter$iv2;
                }
            }
            for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
                this.traceMap.remove(element$iv.getKey());
            }
            return;
        }
        String chainKey = eventTraceName + ":" + eventTraceID;
        this.traceMap.remove(chainKey);
    }

    private final Map<String, String> valuesToString(Map<String, ? extends Object> map) {
        Object m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterable $this$associateByTo$iv$iv$iv = map.entrySet();
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                destination$iv$iv.put(it$iv$iv.getKey(), ((Map.Entry) element$iv$iv$iv).getValue().toString());
            }
            m2636constructorimpl = Result.m2636constructorimpl(destination$iv$iv);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        Map map2 = m2636constructorimpl;
        if (it != null) {
            TraceUtilsKt.traceW(KLog_androidKt.getKLog(), "Map trans failed: " + it.getMessage());
            map2 = MapsKt.emptyMap();
        }
        return (Map) map2;
    }
}