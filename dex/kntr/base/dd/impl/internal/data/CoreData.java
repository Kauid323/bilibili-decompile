package kntr.base.dd.impl.internal.data;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kntr.base.dd.impl.internal.common.UtilsKt;
import kntr.base.dd.impl.internal.data.DataCenter;
import kntr.base.dd.impl.internal.model.DDModel;
import kntr.base.dd.impl.internal.model.DDModelKt;
import kntr.base.dd.impl.internal.model.DDNode;
import kntr.base.dd.impl.internal.model.DDProp;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: CoreData.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\"\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020&2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010,\u001a\u0004\u0018\u00010\u00162\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130.H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130.H\u0016J\u0014\u00100\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0014H\u0016J\u001e\u00105\u001a\u00020&2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u001e\u00107\u001a\u00020&2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0010\u00108\u001a\u00020&2\u0006\u00102\u001a\u000203H\u0016J,\u00109\u001a\u00020&2\u0006\u00102\u001a\u0002032\u0006\u0010:\u001a\u00020\u00192\b\b\u0002\u0010;\u001a\u00020\u00192\b\b\u0002\u0010<\u001a\u00020\u0019H\u0002J\u0014\u0010=\u001a\u00020&2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u000203H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006@"}, d2 = {"Lkntr/base/dd/impl/internal/data/CoreData;", "Lkntr/base/dd/impl/internal/data/ICoreData;", "type", "Lkntr/base/dd/impl/internal/data/CoreDataType;", "sp", "Lkntr/base/config/SharedPreferences;", "flow", "Lkntr/base/dd/impl/internal/data/DateCenterFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "presetData", "Lkntr/base/dd/impl/internal/data/DataCenter$PresetData;", "<init>", "(Lkntr/base/dd/impl/internal/data/CoreDataType;Lkntr/base/config/SharedPreferences;Lkntr/base/dd/impl/internal/data/DateCenterFlow;Lkotlinx/coroutines/CoroutineScope;Lkntr/base/dd/impl/internal/data/DataCenter$PresetData;)V", "_version", "Lkotlinx/atomicfu/AtomicLong;", "nodes", "Lkotlinx/atomicfu/AtomicRef;", "", "", "Lkntr/base/dd/impl/internal/model/DDNode;", "props", "Lkntr/base/dd/impl/internal/model/DDProp;", "tracks", "isMock", "", "updateLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "kDataCacheKey", "kVersionCacheKey", "saveCnt", "kSaveCacheKey", "processName", "getCacheVersion", "", "()Ljava/lang/Long;", "loadModels", "", AppKey.VERSION, "getVersion", "()J", "node", "key", "prop", "nodeKeys", "", "propKeys", "track", "updateWithModel", "model", "Lkntr/base/dd/impl/internal/model/DDModel;", "updateWithNode", "updateNodeValues", "values", "updatePropValues", "fallbackWithModel", "update", "isSave", "isInit", "isFallback", "save", "observeMultiProcessData", "createCurrentModel", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CoreData implements ICoreData {
    private final AtomicLong _version;
    private final DateCenterFlow flow;
    private final boolean isMock;
    private final String kDataCacheKey;
    private final String kSaveCacheKey;
    private final String kVersionCacheKey;
    private final AtomicRef<Map<String, DDNode>> nodes;
    private final String processName;
    private final AtomicRef<Map<String, DDProp>> props;
    private final AtomicLong saveCnt;
    private final CoroutineScope scope;
    private final SharedPreferences sp;
    private final AtomicRef<Map<String, DDNode>> tracks;
    private final CoreDataType type;
    private final ReentrantLock updateLock;

    public CoreData(CoreDataType type, SharedPreferences sp, DateCenterFlow flow, CoroutineScope scope, DataCenter.PresetData presetData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sp, "sp");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(presetData, "presetData");
        this.type = type;
        this.sp = sp;
        this.flow = flow;
        this.scope = scope;
        this._version = AtomicFU.atomic(0L);
        this.nodes = AtomicFU.atomic(MapsKt.emptyMap());
        this.props = AtomicFU.atomic(MapsKt.emptyMap());
        this.tracks = AtomicFU.atomic(MapsKt.emptyMap());
        this.isMock = this.type == CoreDataType.MOCK;
        this.updateLock = new ReentrantLock();
        this.kDataCacheKey = this.type.getRawValue() + "_data";
        this.kVersionCacheKey = this.type.getRawValue() + "_version";
        this.saveCnt = AtomicFU.atomic(0L);
        this.kSaveCacheKey = this.type.getRawValue() + "_save_cnt";
        this.processName = DDConst.INSTANCE.getProcessName();
        long st = UtilsKt.currentTimestamp();
        loadModels(presetData);
        DDConst.INSTANCE.logI("CoreData<" + this.type.getRawValue() + "> init cost " + (UtilsKt.currentTimestamp() - st) + " ms.");
        observeMultiProcessData();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CoreData(CoreDataType coreDataType, SharedPreferences sharedPreferences, DateCenterFlow dateCenterFlow, CoroutineScope coroutineScope, DataCenter.PresetData presetData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coreDataType, sharedPreferences, dateCenterFlow, coroutineScope, r5);
        DataCenter.PresetData presetData2;
        if ((i & 16) == 0) {
            presetData2 = presetData;
        } else {
            presetData2 = new DataCenter.PresetData(null, null, 3, null);
        }
    }

    private final Long getCacheVersion() {
        Long longOrNull;
        String string$default = SharedPreferences.getString$default(this.sp, this.kVersionCacheKey, null, 2, null);
        if (string$default == null || (longOrNull = StringsKt.toLongOrNull(string$default)) == null) {
            return null;
        }
        longOrNull.longValue();
        String string$default2 = SharedPreferences.getString$default(this.sp, this.kDataCacheKey, null, 2, null);
        if (string$default2 == null || StringsKt.isBlank(string$default2)) {
            return null;
        }
        return longOrNull;
    }

    private final void loadModels(DataCenter.PresetData presetData) {
        Pair pair;
        Long longOrNull;
        String version = presetData.getVersion();
        long presetVersion = (version == null || (longOrNull = StringsKt.toLongOrNull(version)) == null) ? 0L : longOrNull.longValue();
        Long cacheVersion = getCacheVersion();
        long cacheVersion2 = cacheVersion != null ? cacheVersion.longValue() : 0L;
        DDModel dDModel = null;
        if (presetVersion > cacheVersion2 && presetData.getData() != null) {
            DDConst.INSTANCE.logI("use preset data init, version = " + presetVersion + ".");
            pair = TuplesKt.to(presetData.getData(), true);
        } else {
            DDConst.INSTANCE.logI("use cache data init, version = " + cacheVersion2 + ".");
            pair = TuplesKt.to(SharedPreferences.getString$default(this.sp, this.kDataCacheKey, null, 2, null), false);
        }
        Pair p = pair;
        if (p.getFirst() == null && this.type == CoreDataType.PROD) {
            DDConst.logE$default(DDConst.INSTANCE, "CoreData load empty local config.", null, 2, null);
        }
        Utils.Companion companion = Utils.Companion;
        String string$iv = (String) p.getFirst();
        if (string$iv != null) {
            try {
                Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                json$iv.getSerializersModule();
                dDModel = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(DDModel.Companion.serializer()), string$iv);
            } catch (Exception e$iv) {
                DDConst dDConst = DDConst.INSTANCE;
                String message = e$iv.getMessage();
                if (message == null) {
                    message = "undefined";
                }
                DDConst.logE$default(dDConst, "decodeFromString error ," + message, null, 2, null);
            }
        }
        DDModel m = dDModel;
        if (m != null) {
            update$default(this, m, ((Boolean) p.getSecond()).booleanValue(), true, false, 8, null);
        }
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public long getVersion() {
        return this._version.getValue();
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public DDNode node(String key) {
        if (key != null) {
            return (DDNode) ((Map) this.nodes.getValue()).get(key);
        }
        return null;
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public DDProp prop(String key) {
        if (key != null) {
            return (DDProp) ((Map) this.props.getValue()).get(key);
        }
        return null;
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public Set<String> nodeKeys() {
        return CollectionsKt.toSet(((Map) this.nodes.getValue()).keySet());
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public Set<String> propKeys() {
        return CollectionsKt.toSet(((Map) this.props.getValue()).keySet());
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public DDNode track(String key) {
        if (key != null) {
            return (DDNode) ((Map) this.tracks.getValue()).get(key);
        }
        return null;
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public void updateWithModel(DDModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        update$default(this, model, true, false, false, 12, null);
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public void updateWithNode(DDNode node) {
        Object cur$iv;
        Intrinsics.checkNotNullParameter(node, "node");
        ReentrantLock $this$with$iv = this.updateLock;
        $this$with$iv.lock();
        try {
            String name = node.getName();
            if (name != null) {
                Map newNodes = MapsKt.toMutableMap((Map) this.nodes.getValue());
                newNodes.put(name, node);
                AtomicRef $this$update$iv = this.nodes;
                do {
                    cur$iv = $this$update$iv.getValue();
                    Map map = (Map) cur$iv;
                } while (!$this$update$iv.compareAndSet(cur$iv, newNodes));
                this.flow.didUpdatedNodes(SetsKt.setOf(name));
                save$default(this, null, 1, null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$with$iv.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
        r7.remove(r15);
     */
    @Override // kntr.base.dd.impl.internal.data.ICoreData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateNodeValues(Map<String, String> map) {
        Object cur$iv;
        Long version;
        Intrinsics.checkNotNullParameter(map, "values");
        ReentrantLock $this$with$iv = this.updateLock;
        $this$with$iv.lock();
        try {
            long currentV = getVersion();
            Map oldNodes = MapsKt.toMutableMap((Map) this.nodes.getValue());
            Set updatedKeys = new LinkedHashSet();
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry element$iv = it.next();
                String k = element$iv.getKey();
                String v = element$iv.getValue();
                String str = v;
                if (str != null && !StringsKt.isBlank(str)) {
                    z = false;
                }
                DDNode dDNode = (DDNode) oldNodes.get(k);
                long ver = ((dDNode == null || (version = dDNode.getVersion()) == null) ? currentV : version.longValue()) + 1;
                String et = String.valueOf(UtilsKt.currentTimestamp() + 86400000);
                oldNodes.put(k, new DDNode(k, (String) null, (DDNode) null, (DDNode) null, v, (String) null, (String) null, (String) null, Long.valueOf(ver), et, 238, (DefaultConstructorMarker) null));
                updatedKeys.add(k);
            }
            AtomicRef $this$update$iv = this.nodes;
            do {
                cur$iv = $this$update$iv.getValue();
                Map map2 = (Map) cur$iv;
            } while (!$this$update$iv.compareAndSet(cur$iv, oldNodes));
            this.flow.didUpdatedNodes(updatedKeys);
            save$default(this, null, 1, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$with$iv.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[Catch: all -> 0x009f, TryCatch #0 {all -> 0x009f, blocks: (B:3:0x0012, B:4:0x0030, B:6:0x0037, B:8:0x0052, B:14:0x005e, B:20:0x0081, B:15:0x0062, B:19:0x006a, B:21:0x0087), top: B:27:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[Catch: all -> 0x009f, TryCatch #0 {all -> 0x009f, blocks: (B:3:0x0012, B:4:0x0030, B:6:0x0037, B:8:0x0052, B:14:0x005e, B:20:0x0081, B:15:0x0062, B:19:0x006a, B:21:0x0087), top: B:27:0x0012 }] */
    @Override // kntr.base.dd.impl.internal.data.ICoreData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updatePropValues(Map<String, String> map) {
        boolean z;
        Intrinsics.checkNotNullParameter(map, "values");
        ReentrantLock $this$with$iv = this.updateLock;
        $this$with$iv.lock();
        try {
            Map oldProps = MapsKt.toMutableMap((Map) this.props.getValue());
            Set updatedNames = new LinkedHashSet();
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                int i = 1;
                if (it.hasNext()) {
                    Map.Entry element$iv = it.next();
                    String k = element$iv.getKey();
                    String v = element$iv.getValue();
                    String str = v;
                    if (str != null && !StringsKt.isBlank(str)) {
                        z = false;
                        if (!z) {
                            oldProps.remove(k);
                        } else {
                            if (!this.isMock) {
                                i = 2;
                            }
                            oldProps.put(k, new DDProp(k, v, (Boolean) null, (Double) null, Integer.valueOf(i), 12, (DefaultConstructorMarker) null));
                        }
                        updatedNames.add(k);
                    }
                    z = true;
                    if (!z) {
                    }
                    updatedNames.add(k);
                } else {
                    this.props.setValue(oldProps);
                    this.flow.didUpdatedProps(updatedNames);
                    save$default(this, null, 1, null);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
        } finally {
            $this$with$iv.unlock();
        }
    }

    @Override // kntr.base.dd.impl.internal.data.ICoreData
    public void fallbackWithModel(DDModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        update$default(this, model, true, false, true, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void update$default(CoreData coreData, DDModel dDModel, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = false;
        }
        coreData.update(dDModel, z, z2, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x015a, code lost:
        if (r28 != r26) goto L143;
     */
    /* JADX WARN: Incorrect condition in loop: B:101:0x02b2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void update(DDModel model, boolean isSave, boolean isInit, boolean isFallback) {
        Pair pair;
        boolean z;
        Long version;
        String str;
        Pair pair2;
        String str2;
        boolean isEqual;
        Map newNodes;
        LinkedHashMap destination$iv$iv;
        Map newNodes2;
        String str3;
        ReentrantLock $this$with$iv = this.updateLock;
        boolean z2 = false;
        $this$with$iv.lock();
        boolean z3 = false;
        try {
            long ver = this._version.getValue();
            if (!isFallback) {
                try {
                    if (model.getVersion() <= ver && !this.isMock) {
                        DDConst.INSTANCE.logI("current version<" + this.type.getRawValue() + ", " + model.getVersion() + "> need not update.");
                        $this$with$iv.unlock();
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    $this$with$iv.unlock();
                    throw th;
                }
            }
            String str4 = "";
            if (!isInit || isFallback) {
                Iterable $this$diffWith$iv = model.getList();
                if ($this$diffWith$iv == null) {
                    $this$diffWith$iv = CollectionsKt.emptyList();
                }
                Map oldMap$iv = (Map) this.nodes.getValue();
                Map newMap$iv = new LinkedHashMap();
                Set oldKeys$iv = CollectionsKt.toMutableSet(oldMap$iv.keySet());
                Set updatedKeys$iv = new LinkedHashSet();
                Iterable $this$forEach$iv$iv = $this$diffWith$iv;
                for (Object element$iv$iv : $this$forEach$iv$iv) {
                    boolean z4 = z3;
                    DDNode it = (DDNode) element$iv$iv;
                    String key$iv = it.getName();
                    if (key$iv != null) {
                        z = z2;
                        try {
                            newMap$iv.put(key$iv, element$iv$iv);
                            if (oldKeys$iv.contains(key$iv)) {
                                oldKeys$iv.remove(key$iv);
                                DDNode newNode = (DDNode) element$iv$iv;
                                DDNode oldNode = (DDNode) oldMap$iv.get(key$iv);
                                long oldV = (oldNode == null || (version = oldNode.getVersion()) == null) ? 0L : version.longValue();
                                Long version2 = newNode.getVersion();
                                long newV = version2 != null ? version2.longValue() : 0L;
                                boolean z5 = true;
                                if (!isFallback) {
                                    if (newV > oldV) {
                                    }
                                    z5 = false;
                                }
                                if (z5) {
                                    updatedKeys$iv.add(key$iv);
                                }
                            } else {
                                updatedKeys$iv.add(key$iv);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            $this$with$iv.unlock();
                            throw th;
                        }
                    } else {
                        z = z2;
                    }
                    z3 = z4;
                    z2 = z;
                }
                updatedKeys$iv.addAll(oldKeys$iv);
                pair = TuplesKt.to(newMap$iv, updatedKeys$iv);
            } else {
                Iterable list = model.getList();
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                Iterable $this$associateBy$iv = list;
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
                for (Object element$iv$iv2 : $this$associateBy$iv) {
                    DDNode it2 = (DDNode) element$iv$iv2;
                    String name = it2.getName();
                    destination$iv$iv2.put(name == null ? "" : name, element$iv$iv2);
                }
                pair = TuplesKt.to(destination$iv$iv2, SetsKt.emptySet());
            }
            Map newNodes3 = (Map) pair.component1();
            Set updatedNodeKeys = (Set) pair.component2();
            if (!isInit || isFallback) {
                Iterable $this$diffWith$iv2 = model.getProps();
                if ($this$diffWith$iv2 == null) {
                    $this$diffWith$iv2 = CollectionsKt.emptyList();
                }
                Map oldMap$iv2 = (Map) this.props.getValue();
                Map newMap$iv2 = new LinkedHashMap();
                Set oldKeys$iv2 = CollectionsKt.toMutableSet(oldMap$iv2.keySet());
                Set updatedKeys$iv2 = new LinkedHashSet();
                Iterable $this$forEach$iv$iv2 = $this$diffWith$iv2;
                for (Object element$iv$iv3 : $this$forEach$iv$iv2) {
                    long ver2 = ver;
                    DDProp it3 = (DDProp) element$iv$iv3;
                    String key$iv2 = it3.getName();
                    if (key$iv2 != null) {
                        newMap$iv2.put(key$iv2, element$iv$iv3);
                        if (oldKeys$iv2.contains(key$iv2)) {
                            oldKeys$iv2.remove(key$iv2);
                            DDProp old = (DDProp) oldMap$iv2.get(key$iv2);
                            str2 = str4;
                            isEqual = CoreDataKt.isEqual((DDProp) element$iv$iv3, old);
                            if (!isEqual) {
                                updatedKeys$iv2.add(key$iv2);
                            }
                        } else {
                            str2 = str4;
                            updatedKeys$iv2.add(key$iv2);
                        }
                    } else {
                        str2 = str4;
                    }
                    str4 = str2;
                    ver = ver2;
                }
                str = str4;
                updatedKeys$iv2.addAll(oldKeys$iv2);
                pair2 = TuplesKt.to(newMap$iv2, updatedKeys$iv2);
            } else {
                Iterable props = model.getProps();
                if (props == null) {
                    props = CollectionsKt.emptyList();
                }
                Iterable $this$associateBy$iv2 = props;
                int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv2, 10)), 16);
                Map destination$iv$iv3 = new LinkedHashMap(capacity$iv2);
                for (Object element$iv$iv4 : $this$associateBy$iv2) {
                    DDProp it4 = (DDProp) element$iv$iv4;
                    String name2 = it4.getName();
                    destination$iv$iv3.put(name2 == null ? "" : name2, element$iv$iv4);
                }
                pair2 = TuplesKt.to(destination$iv$iv3, SetsKt.emptySet());
                str = "";
            }
            Map newProps = (Map) pair2.component1();
            Set updatedPropNames = (Set) pair2.component2();
            AtomicLong $this$update$iv = this._version;
            while (!$this$update$iv.compareAndSet(cur$iv, upd$iv)) {
            }
            AtomicRef $this$update$iv2 = this.nodes;
            while (true) {
                Object cur$iv = $this$update$iv2.getValue();
                Map map = (Map) cur$iv;
                if ($this$update$iv2.compareAndSet(cur$iv, newNodes3)) {
                    break;
                }
            }
            AtomicRef $this$update$iv3 = this.props;
            while (true) {
                Object cur$iv2 = $this$update$iv3.getValue();
                Map map2 = (Map) cur$iv2;
                if ($this$update$iv3.compareAndSet(cur$iv2, newProps)) {
                    break;
                }
            }
            AtomicRef $this$update$iv4 = this.tracks;
            while (true) {
                Object cur$iv3 = $this$update$iv4.getValue();
                Map map3 = (Map) cur$iv3;
                Iterable tracks = model.getTracks();
                if (tracks != null) {
                    Iterable $this$associateBy$iv3 = tracks;
                    int capacity$iv3 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv3, 10)), 16);
                    destination$iv$iv = new LinkedHashMap(capacity$iv3);
                    for (Object element$iv$iv5 : $this$associateBy$iv3) {
                        DDNode it5 = (DDNode) element$iv$iv5;
                        String name3 = it5.getName();
                        if (name3 == null) {
                            newNodes2 = newNodes3;
                            str3 = str;
                        } else {
                            newNodes2 = newNodes3;
                            str3 = name3;
                        }
                        destination$iv$iv.put(str3, element$iv$iv5);
                        newNodes3 = newNodes2;
                    }
                    newNodes = newNodes3;
                } else {
                    newNodes = newNodes3;
                    destination$iv$iv = MapsKt.emptyMap();
                }
                Object upd$iv = destination$iv$iv;
                if ($this$update$iv4.compareAndSet(cur$iv3, upd$iv)) {
                    break;
                }
                newNodes3 = newNodes;
            }
            if (!isInit || isFallback) {
                if (!this.isMock) {
                    this.flow.didUpdatedVersion(new IDeviceDecision.Version(this.type == CoreDataType.TEST ? IDeviceDecision.Version.Env.Test : IDeviceDecision.Version.Env.Prod, String.valueOf(model.getVersion())));
                }
                this.flow.didUpdatedNodes(updatedNodeKeys);
                this.flow.didUpdatedProps(updatedPropNames);
            }
            if (isSave) {
                save(model);
            }
            Unit unit = Unit.INSTANCE;
            $this$with$iv.unlock();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static /* synthetic */ void save$default(CoreData coreData, DDModel dDModel, int i, Object obj) {
        if ((i & 1) != 0) {
            dDModel = null;
        }
        coreData.save(dDModel);
    }

    private final void save(DDModel model) {
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new CoreData$save$1(this, model, null), 3, (Object) null);
    }

    private final void observeMultiProcessData() {
        if (StringsKt.isBlank(this.processName)) {
            return;
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new CoreData$observeMultiProcessData$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DDModel createCurrentModel() {
        return DDModelKt.createDDModel("", this._version.getValue(), CollectionsKt.toList(((Map) this.nodes.getValue()).values()), CollectionsKt.toList(((Map) this.props.getValue()).values()), CollectionsKt.toList(((Map) this.tracks.getValue()).values()));
    }
}