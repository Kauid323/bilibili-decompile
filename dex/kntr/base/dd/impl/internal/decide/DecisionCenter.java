package kntr.base.dd.impl.internal.decide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.impl.internal.common.AtomicMutableMap;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.UtilsKt;
import kntr.base.dd.impl.internal.data.CoreDataType;
import kntr.base.dd.impl.internal.data.ICoreData;
import kntr.base.dd.impl.internal.data.IDataCenter;
import kntr.base.dd.impl.internal.decide.DecisionMaker;
import kntr.base.dd.impl.internal.model.DDNode;
import kntr.base.dd.impl.internal.property.IPropertyCenter;
import kntr.base.utils.CoroutineExKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: DecisionCenter.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002()B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001d2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0016\u0010$\u001a\u00020\u001f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0%H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DecisionCenter;", "Lkntr/base/dd/impl/internal/decide/IDecisionCenter;", "dataCenter", "Lkntr/base/dd/impl/internal/data/IDataCenter;", "propertyCenter", "Lkntr/base/dd/impl/internal/property/IPropertyCenter;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/base/dd/impl/internal/data/IDataCenter;Lkntr/base/dd/impl/internal/property/IPropertyCenter;Lkotlinx/coroutines/CoroutineScope;)V", "_keys", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "cacheResult", "Lkntr/base/dd/impl/internal/common/AtomicMutableMap;", "Lkntr/base/dd/impl/internal/decide/DecisionCenter$CacheData;", "trackCache", "", "keys", "Lkotlinx/coroutines/flow/Flow;", "getKeys", "()Lkotlinx/coroutines/flow/Flow;", "decide", "Lkntr/base/dd/impl/internal/decide/IDDResult;", "key", "context", "Lkntr/base/dd/IDeviceDecision$Context;", "keyTrackable", "get", "Lkntr/base/dd/impl/internal/decide/DecisionCenter$Result;", "trackResult", "", "result", "mockValueForKey", "observeKeysUpdate", "observePropsUpdate", "didKeysUpdated", "", "didPropUpdated", "name", "Result", "CacheData", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DecisionCenter implements IDecisionCenter {
    private final MutableSharedFlow<String> _keys;
    private final AtomicMutableMap<String, CacheData> cacheResult;
    private final IDataCenter dataCenter;
    private final CoroutineScope ioScope;
    private final IPropertyCenter propertyCenter;
    private final AtomicMutableMap<String, Boolean> trackCache;

    public DecisionCenter(IDataCenter dataCenter, IPropertyCenter propertyCenter, CoroutineScope ioScope) {
        Intrinsics.checkNotNullParameter(dataCenter, "dataCenter");
        Intrinsics.checkNotNullParameter(propertyCenter, "propertyCenter");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        this.dataCenter = dataCenter;
        this.propertyCenter = propertyCenter;
        this.ioScope = ioScope;
        this._keys = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);
        this.cacheResult = new AtomicMutableMap<>();
        this.trackCache = new AtomicMutableMap<>();
        observeKeysUpdate();
        observePropsUpdate();
    }

    public /* synthetic */ DecisionCenter(IDataCenter iDataCenter, IPropertyCenter iPropertyCenter, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iDataCenter, iPropertyCenter, (i & 4) != 0 ? CoroutineExKt.createIOScope() : coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecisionCenter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DecisionCenter$Result;", "Lkntr/base/dd/impl/internal/decide/IDDResult;", "hit", "", "value", "", "trackable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Z)V", "getHit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getValue", "()Ljava/lang/String;", "getTrackable", "()Z", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Result implements IDDResult {
        private final Boolean hit;
        private final boolean trackable;
        private final String value;

        public Result() {
            this(null, null, false, 7, null);
        }

        public Result(Boolean hit, String value, boolean trackable) {
            this.hit = hit;
            this.value = value;
            this.trackable = trackable;
        }

        public /* synthetic */ Result(Boolean bool, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
        }

        @Override // kntr.base.dd.impl.internal.decide.IDDResult
        public Boolean getHit() {
            return this.hit;
        }

        @Override // kntr.base.dd.impl.internal.decide.IDDResult
        public String getValue() {
            return this.value;
        }

        public final boolean getTrackable() {
            return this.trackable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecisionCenter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkntr/base/dd/impl/internal/decide/DecisionCenter$CacheData;", "", "result", "Lkntr/base/dd/impl/internal/decide/DecisionCenter$Result;", "usedProps", "", "", "<init>", "(Lkntr/base/dd/impl/internal/decide/DecisionCenter$Result;Ljava/util/Set;)V", "getResult", "()Lkntr/base/dd/impl/internal/decide/DecisionCenter$Result;", "getUsedProps", "()Ljava/util/Set;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CacheData {
        private final Result result;
        private final Set<String> usedProps;

        public CacheData(Result result, Set<String> set) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(set, "usedProps");
            this.result = result;
            this.usedProps = set;
        }

        public /* synthetic */ CacheData(Result result, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(result, (i & 2) != 0 ? SetsKt.emptySet() : set);
        }

        public final Result getResult() {
            return this.result;
        }

        public final Set<String> getUsedProps() {
            return this.usedProps;
        }
    }

    @Override // kntr.base.dd.impl.internal.decide.IDecisionCenter
    public Flow<String> getKeys() {
        return FlowKt.asSharedFlow(this._keys);
    }

    @Override // kntr.base.dd.impl.internal.decide.IDecisionCenter
    public IDDResult decide(String key, IDeviceDecision.Context context) {
        Intrinsics.checkNotNullParameter(key, "key");
        String it = mockValueForKey(key);
        if (it != null) {
            return new DDResult(true, it);
        }
        Result it2 = get(key, context);
        trackResult(key, it2, context);
        return it2;
    }

    private final boolean keyTrackable(String key) {
        Double doubleOrNull;
        Boolean bool = this.trackCache.get(key);
        if (bool != null) {
            boolean it = bool.booleanValue();
            return it;
        }
        DDNode track = this.dataCenter.currentData().track(key);
        boolean hit = false;
        if (track != null) {
            DecisionMaker.Result res = new DecisionMaker(this.propertyCenter, false, 2, null).decide(track);
            if (res.getHit()) {
                String value = res.getValue();
                if (UtilsKt.randomHitsProbability$default((value == null || (doubleOrNull = StringsKt.toDoubleOrNull(value)) == null) ? 0.0d : doubleOrNull.doubleValue(), 0.0d, 2, null)) {
                    hit = true;
                }
            }
            if (res.getCanCache()) {
                this.trackCache.put(key, Boolean.valueOf(hit));
            }
        }
        return hit;
    }

    static /* synthetic */ Result get$default(DecisionCenter decisionCenter, String str, IDeviceDecision.Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            context = null;
        }
        return decisionCenter.get(str, context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r14.disableCache() == true) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Result get(String key, IDeviceDecision.Context context) {
        boolean z;
        CacheData it;
        if (context != null) {
            z = true;
        }
        z = false;
        if (!z && (it = this.cacheResult.get(key)) != null) {
            return it.getResult();
        }
        DDNode node = this.dataCenter.currentData().node(key);
        if (node == null) {
            Result it2 = new Result(null, null, false, 7, null);
            this.cacheResult.put(key, new CacheData(it2, null, 2, null));
            return it2;
        }
        try {
            DecisionMaker decider = new DecisionMaker(this.propertyCenter, false, 2, null);
            DecisionMaker.Result res = decider.decide(node);
            Result it3 = new Result(Boolean.valueOf(res.getHit()), res.getValue(), keyTrackable(key));
            if (res.getCanCache()) {
                this.cacheResult.put(key, new CacheData(it3, decider.getUsedProps()));
            }
            return it3;
        } catch (Exception e) {
            DDConst dDConst = DDConst.INSTANCE;
            String message = e.getMessage();
            if (message == null) {
                message = "unknown error!";
            }
            DDConst.logE$default(dDConst, "decide " + key + " error, " + message, null, 2, null);
            return new Result(null, null, false, 7, null);
        }
    }

    static /* synthetic */ void trackResult$default(DecisionCenter decisionCenter, String str, Result result, IDeviceDecision.Context context, int i, Object obj) {
        if ((i & 4) != 0) {
            context = null;
        }
        decisionCenter.trackResult(str, result, context);
    }

    private final void trackResult(String key, Result result, IDeviceDecision.Context context) {
        Object value$iv;
        String str;
        if (result.getTrackable()) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("name", key);
            String value = result.getValue();
            if (value == null) {
                value = "";
            }
            pairArr[1] = TuplesKt.to("value", value);
            Map params = MapsKt.mutableMapOf(pairArr);
            if (context != null && (value$iv = context.trackParams(result.getValue())) != null) {
                Utils.Companion companion = Utils.Companion;
                try {
                    StringFormat $this$encodeToString$iv$iv = (Json) Json.Default;
                    $this$encodeToString$iv$iv.getSerializersModule();
                    str = $this$encodeToString$iv$iv.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), value$iv);
                } catch (Exception e$iv) {
                    DDConst dDConst = DDConst.INSTANCE;
                    String message = e$iv.getMessage();
                    if (message == null) {
                        message = "undefined";
                    }
                    DDConst.logE$default(dDConst, "encodeToString error ," + message, null, 2, null);
                    str = null;
                }
                if (str != null) {
                    String it = str;
                    params.put("extra", it);
                }
            }
            DDConst.INSTANCE.trackT("public.dd.result", params);
        }
    }

    private final String mockValueForKey(String key) {
        ICoreData mockData = this.dataCenter.dataWithType(CoreDataType.MOCK);
        DDNode node = mockData.node(key);
        if (node != null) {
            String value = node.getValue();
            String expiredTime = node.getExpiredTime();
            Long expiredTime2 = expiredTime != null ? StringsKt.toLongOrNull(expiredTime) : null;
            if (value != null && expiredTime2 != null && expiredTime2.longValue() > UtilsKt.currentTimestamp()) {
                return value;
            }
            BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new DecisionCenter$mockValueForKey$1$1(mockData, key, null), 3, (Object) null);
        }
        return null;
    }

    private final void observeKeysUpdate() {
        BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new DecisionCenter$observeKeysUpdate$1(this, null), 3, (Object) null);
    }

    private final void observePropsUpdate() {
        BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new DecisionCenter$observePropsUpdate$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void didKeysUpdated(Set<String> set) {
        Result it;
        try {
            Set<String> $this$forEach$iv = set;
            for (Object element$iv : $this$forEach$iv) {
                String key = (String) element$iv;
                this.trackCache.remove(key);
                CacheData cacheData = this.cacheResult.get(key);
                boolean z = true;
                if (cacheData != null && (it = cacheData.getResult()) != null) {
                    this.cacheResult.remove(key);
                    Result newV = get$default(this, key, null, 2, null);
                    if (Intrinsics.areEqual(it.getHit(), newV.getHit()) && Intrinsics.areEqual(it.getValue(), newV.getValue())) {
                        z = false;
                    }
                }
                boolean updated = z;
                if (updated) {
                    BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new DecisionCenter$didKeysUpdated$1$1(this, key, null), 3, (Object) null);
                }
            }
        } catch (Exception e) {
            DDConst.INSTANCE.logE("didKeysUpdated(" + set.size() + "): unexpected error", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void didPropUpdated(String name) {
        Set<String> usedProps;
        try {
            Iterable $this$filter$iv = this.cacheResult.getKeys();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String key = (String) element$iv$iv;
                CacheData cacheData = this.cacheResult.get(key);
                if ((cacheData == null || (usedProps = cacheData.getUsedProps()) == null) ? false : usedProps.contains(name)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            didKeysUpdated(CollectionsKt.toSet((List) destination$iv$iv));
        } catch (Exception e) {
            DDConst.INSTANCE.logE("didPropUpdated(" + name + "): unexpected error", e);
        }
    }
}