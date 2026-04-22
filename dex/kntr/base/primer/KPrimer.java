package kntr.base.primer;

import com.bapis.bilibili.app.coldstart.v1.KColdStartBizReq;
import com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp;
import com.bapis.bilibili.app.coldstart.v1.KColdStartMoss;
import com.bapis.bilibili.app.coldstart.v1.KGetColdStartDataReq;
import com.bapis.bilibili.app.coldstart.v1.KGetColdStartDataResp;
import com.bapis.bilibili.app.coldstart.v1.KHttpCommon;
import com.bapis.bilibili.app.coldstart.v1.KHttpGetBizReq;
import com.google.protobuf.KAny;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kntr.base.primer.BlockScene;
import kntr.base.primer.HitType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: KPrimer.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u000fH\u0002J\u001e\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u000fH\u0002J\u0018\u00103\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007H\u0007J\u0018\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b062\u0006\u0010.\u001a\u00020\u0007H\u0007R\"\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020$0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lkntr/base/primer/KPrimer;", "", "<init>", "()V", "_map", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "", "", "map", "Lkotlinx/coroutines/flow/SharedFlow;", "getMap$annotations", "getMap", "()Lkotlinx/coroutines/flow/SharedFlow;", "keys", "", "getKeys$primer_debug", "()Ljava/util/List;", "keys$delegate", "Lkotlin/Lazy;", "onceHitKeys", "getOnceHitKeys$primer_debug", "onceHitKeys$delegate", "expiredTime", "Lkotlinx/datetime/Instant;", "getExpiredTime$primer_debug", "()Lkotlinx/datetime/Instant;", "expired", "", "getExpired$primer_debug", "()Z", "onceHitLocalList", "", "hitMap", "Lkotlinx/atomicfu/AtomicRef;", "", "", "blockList", "accountStore", "Lkntr/base/account/KAccountStore;", "fetchPopularPreview", "", "param", "Lkntr/base/primer/PrimerParam;", "(Lkntr/base/primer/PrimerParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterBlockReq", "bizKey", "params", "Lkntr/base/primer/PrimerBizParams;", "buildReq", "Lcom/bapis/bilibili/app/coldstart/v1/KColdStartBizReq;", "launch", "shouldHandle", "handle", "Lkotlinx/coroutines/flow/Flow;", "Companion", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KPrimer {
    public static final Companion Companion = new Companion(null);
    private static final KPrimer shared = new KPrimer();
    private KAccountStore accountStore;
    private final List<String> blockList;
    private final Instant expiredTime;
    private final AtomicRef<Map<String, Integer>> hitMap;
    private final List<String> onceHitLocalList;
    private final MutableSharedFlow<Map<String, byte[]>> _map = SharedFlowKt.MutableSharedFlow$default(1, 0, (BufferOverflow) null, 6, (Object) null);
    private final SharedFlow<Map<String, byte[]>> map = FlowKt.asSharedFlow(this._map);
    private final Lazy keys$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.primer.KPrimer$$ExternalSyntheticLambda0
        public final Object invoke() {
            List keys_delegate$lambda$0;
            keys_delegate$lambda$0 = KPrimer.keys_delegate$lambda$0();
            return keys_delegate$lambda$0;
        }
    });
    private final Lazy onceHitKeys$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.primer.KPrimer$$ExternalSyntheticLambda1
        public final Object invoke() {
            List onceHitKeys_delegate$lambda$0;
            onceHitKeys_delegate$lambda$0 = KPrimer.onceHitKeys_delegate$lambda$0();
            return onceHitKeys_delegate$lambda$0;
        }
    });

    public static /* synthetic */ void getMap$annotations() {
    }

    /* compiled from: KPrimer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkntr/base/primer/KPrimer$Companion;", "", "<init>", "()V", "shared", "Lkntr/base/primer/KPrimer;", "getShared$annotations", "getShared", "()Lkntr/base/primer/KPrimer;", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getShared$annotations() {
        }

        private Companion() {
        }

        public final KPrimer getShared() {
            return KPrimer.shared;
        }
    }

    public KPrimer() {
        Long longOrNull;
        Instant now = Clock.System.INSTANCE.now();
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "dd.primer.preload.expire", null, 2, null);
        long offsetMs = (config$default == null || (longOrNull = StringsKt.toLongOrNull(config$default)) == null) ? 0L : longOrNull.longValue();
        this.expiredTime = now.plus-LRDsOJo(DurationKt.toDuration(offsetMs, DurationUnit.MILLISECONDS));
        this.onceHitLocalList = new ArrayList();
        this.hitMap = AtomicFU.atomic(new LinkedHashMap());
        this.blockList = new ArrayList();
    }

    public final SharedFlow<Map<String, byte[]>> getMap() {
        return this.map;
    }

    public final List<String> getKeys$primer_debug() {
        return (List) this.keys$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List keys_delegate$lambda$0() {
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "dd.primer.preload.keys", null, 2, null);
        if (config$default == null) {
            config$default = "app.bilibili.com/x/resource/ip,grpc.biliapi.net/bilibili.app.wall.v1.Wall/RuleInfo";
        }
        Iterable $this$map$iv = StringsKt.split$default(config$default, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it).toString());
        }
        return CollectionsKt.toList((List) destination$iv$iv);
    }

    public final List<String> getOnceHitKeys$primer_debug() {
        return (List) this.onceHitKeys$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List onceHitKeys_delegate$lambda$0() {
        String config$default = IPlatformConfig.CC.config$default(KConfig.INSTANCE, "dd.primer.preload.keys.once.hit", null, 2, null);
        if (config$default == null) {
            config$default = "";
        }
        Iterable $this$map$iv = StringsKt.split$default(config$default, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it).toString());
        }
        return CollectionsKt.toList((List) destination$iv$iv);
    }

    public final Instant getExpiredTime$primer_debug() {
        return this.expiredTime;
    }

    public final boolean getExpired$primer_debug() {
        return Clock.System.INSTANCE.now().compareTo(this.expiredTime) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|79|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b2 A[Catch: all -> 0x0254, TRY_LEAVE, TryCatch #2 {all -> 0x0254, blocks: (B:42:0x017a, B:43:0x01ac, B:45:0x01b2), top: B:73:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0249 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchPopularPreview(PrimerParam param, Continuation<? super Unit> continuation) {
        KPrimer$fetchPopularPreview$1 kPrimer$fetchPopularPreview$1;
        KPrimer$fetchPopularPreview$1 kPrimer$fetchPopularPreview$12;
        PrimerParam param2;
        Object m2636constructorimpl;
        Throwable e;
        KPrimer $this$fetchPopularPreview_u24lambda_u240;
        List items;
        PrimerCommonParams commonParams;
        KHttpCommon commonReq;
        KGetColdStartDataReq req;
        Object coldStartDeferredData;
        KPrimer $this$fetchPopularPreview_u24lambda_u2402;
        PrimerCommonParams commonParams2;
        int i;
        List items2;
        Map destination$iv$iv;
        MutableSharedFlow<Map<String, byte[]>> mutableSharedFlow;
        if (continuation instanceof KPrimer$fetchPopularPreview$1) {
            kPrimer$fetchPopularPreview$1 = (KPrimer$fetchPopularPreview$1) continuation;
            if ((kPrimer$fetchPopularPreview$1.label & Integer.MIN_VALUE) != 0) {
                kPrimer$fetchPopularPreview$1.label -= Integer.MIN_VALUE;
                kPrimer$fetchPopularPreview$12 = kPrimer$fetchPopularPreview$1;
                Object $result = kPrimer$fetchPopularPreview$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kPrimer$fetchPopularPreview$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Result.Companion companion = Result.Companion;
                            $this$fetchPopularPreview_u24lambda_u240 = this;
                            Iterable $this$filterNot$iv = $this$fetchPopularPreview_u24lambda_u240.getKeys$primer_debug();
                            Collection destination$iv$iv2 = new ArrayList();
                            for (Object element$iv$iv : $this$filterNot$iv) {
                                try {
                                    String it = (String) element$iv$iv;
                                    if (!$this$fetchPopularPreview_u24lambda_u240.filterBlockReq(it, param.getBiz())) {
                                        destination$iv$iv2.add(element$iv$iv);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    param2 = param;
                                    Result.Companion companion2 = Result.Companion;
                                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                    PrimerParam param3 = param2;
                                    e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                                    if (e != null) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            Iterable $this$map$iv = (List) destination$iv$iv2;
                            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                String it2 = (String) item$iv$iv;
                                Iterable $this$map$iv2 = $this$map$iv;
                                destination$iv$iv3.add($this$fetchPopularPreview_u24lambda_u240.buildReq(it2, param.getBiz()));
                                $this$map$iv = $this$map$iv2;
                            }
                            items = (List) destination$iv$iv3;
                            commonParams = param.getCommon();
                            commonReq = new KHttpCommon(commonParams.getHeaders(), commonParams.getParams());
                            req = new KGetColdStartDataReq(items, commonReq);
                            KLog_androidKt.getKLog().i("Primer", "Start to fetch");
                            KColdStartMoss kColdStartMoss = new KColdStartMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            kPrimer$fetchPopularPreview$12.L$0 = SpillingKt.nullOutSpilledVariable(param);
                            kPrimer$fetchPopularPreview$12.L$1 = $this$fetchPopularPreview_u24lambda_u240;
                            kPrimer$fetchPopularPreview$12.L$2 = SpillingKt.nullOutSpilledVariable(commonParams);
                            kPrimer$fetchPopularPreview$12.L$3 = SpillingKt.nullOutSpilledVariable(commonReq);
                            kPrimer$fetchPopularPreview$12.L$4 = SpillingKt.nullOutSpilledVariable(req);
                            kPrimer$fetchPopularPreview$12.L$5 = SpillingKt.nullOutSpilledVariable(items);
                            kPrimer$fetchPopularPreview$12.I$0 = 0;
                            kPrimer$fetchPopularPreview$12.label = 1;
                            coldStartDeferredData = kColdStartMoss.getColdStartDeferredData(req, kPrimer$fetchPopularPreview$12);
                        } catch (Throwable th2) {
                            th = th2;
                            param2 = param;
                        }
                        if (coldStartDeferredData == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        param2 = param;
                        $this$fetchPopularPreview_u24lambda_u2402 = $this$fetchPopularPreview_u24lambda_u240;
                        commonParams2 = commonParams;
                        i = 0;
                        items2 = items;
                        try {
                            KGetColdStartDataResp result = (KGetColdStartDataResp) coldStartDeferredData;
                            KLog_androidKt.getKLog().i("Primer", "Fetch Finished");
                            Iterable<KColdStartBizResp> $this$associate$iv = result.getRespList();
                            boolean z = false;
                            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                            destination$iv$iv = new LinkedHashMap(capacity$iv);
                            for (KColdStartBizResp resp : $this$associate$iv) {
                                String key = resp.getBizKey();
                                BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
                                $this$encodeToByteArray$iv.getSerializersModule();
                                Iterable $this$associate$iv2 = $this$associate$iv;
                                Object $result2 = $result;
                                boolean z2 = z;
                                try {
                                    Pair pair = TuplesKt.to(key, $this$encodeToByteArray$iv.encodeToByteArray(KColdStartBizResp.Companion.serializer(), resp));
                                    destination$iv$iv.put(pair.getFirst(), pair.getSecond());
                                    z = z2;
                                    $result = $result2;
                                    $this$associate$iv = $this$associate$iv2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    Result.Companion companion22 = Result.Companion;
                                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                    PrimerParam param32 = param2;
                                    e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                                    if (e != null) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            mutableSharedFlow = $this$fetchPopularPreview_u24lambda_u2402._map;
                            kPrimer$fetchPopularPreview$12.L$0 = SpillingKt.nullOutSpilledVariable(param2);
                            kPrimer$fetchPopularPreview$12.L$1 = SpillingKt.nullOutSpilledVariable($this$fetchPopularPreview_u24lambda_u2402);
                            kPrimer$fetchPopularPreview$12.L$2 = SpillingKt.nullOutSpilledVariable(commonParams2);
                            kPrimer$fetchPopularPreview$12.L$3 = SpillingKt.nullOutSpilledVariable(commonReq);
                            kPrimer$fetchPopularPreview$12.L$4 = SpillingKt.nullOutSpilledVariable(req);
                            kPrimer$fetchPopularPreview$12.L$5 = SpillingKt.nullOutSpilledVariable(result);
                            kPrimer$fetchPopularPreview$12.L$6 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            kPrimer$fetchPopularPreview$12.L$7 = SpillingKt.nullOutSpilledVariable(items2);
                            kPrimer$fetchPopularPreview$12.I$0 = i;
                            kPrimer$fetchPopularPreview$12.label = 2;
                        } catch (Throwable th4) {
                            th = th4;
                            Result.Companion companion222 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            PrimerParam param322 = param2;
                            e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (e != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (mutableSharedFlow.emit(destination$iv$iv, kPrimer$fetchPopularPreview$12) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                        PrimerParam param3222 = param2;
                        e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (e != null) {
                            MutableSharedFlow<Map<String, byte[]>> mutableSharedFlow2 = this._map;
                            Map emptyMap = MapsKt.emptyMap();
                            kPrimer$fetchPopularPreview$12.L$0 = SpillingKt.nullOutSpilledVariable(param3222);
                            kPrimer$fetchPopularPreview$12.L$1 = m2636constructorimpl;
                            kPrimer$fetchPopularPreview$12.L$2 = SpillingKt.nullOutSpilledVariable(e);
                            kPrimer$fetchPopularPreview$12.L$3 = null;
                            kPrimer$fetchPopularPreview$12.L$4 = null;
                            kPrimer$fetchPopularPreview$12.L$5 = null;
                            kPrimer$fetchPopularPreview$12.L$6 = null;
                            kPrimer$fetchPopularPreview$12.L$7 = null;
                            kPrimer$fetchPopularPreview$12.I$0 = 0;
                            kPrimer$fetchPopularPreview$12.label = 3;
                            if (mutableSharedFlow2.emit(emptyMap, kPrimer$fetchPopularPreview$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        i = kPrimer$fetchPopularPreview$12.I$0;
                        List items3 = (List) kPrimer$fetchPopularPreview$12.L$5;
                        req = (KGetColdStartDataReq) kPrimer$fetchPopularPreview$12.L$4;
                        KHttpCommon commonReq2 = (KHttpCommon) kPrimer$fetchPopularPreview$12.L$3;
                        commonParams2 = (PrimerCommonParams) kPrimer$fetchPopularPreview$12.L$2;
                        $this$fetchPopularPreview_u24lambda_u2402 = (KPrimer) kPrimer$fetchPopularPreview$12.L$1;
                        param2 = (PrimerParam) kPrimer$fetchPopularPreview$12.L$0;
                        ResultKt.throwOnFailure($result);
                        items2 = items3;
                        commonReq = commonReq2;
                        coldStartDeferredData = $result;
                        KGetColdStartDataResp result2 = (KGetColdStartDataResp) coldStartDeferredData;
                        KLog_androidKt.getKLog().i("Primer", "Fetch Finished");
                        Iterable<KColdStartBizResp> $this$associate$iv3 = result2.getRespList();
                        boolean z3 = false;
                        int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv3, 10)), 16);
                        destination$iv$iv = new LinkedHashMap(capacity$iv2);
                        while (r19.hasNext()) {
                        }
                        mutableSharedFlow = $this$fetchPopularPreview_u24lambda_u2402._map;
                        kPrimer$fetchPopularPreview$12.L$0 = SpillingKt.nullOutSpilledVariable(param2);
                        kPrimer$fetchPopularPreview$12.L$1 = SpillingKt.nullOutSpilledVariable($this$fetchPopularPreview_u24lambda_u2402);
                        kPrimer$fetchPopularPreview$12.L$2 = SpillingKt.nullOutSpilledVariable(commonParams2);
                        kPrimer$fetchPopularPreview$12.L$3 = SpillingKt.nullOutSpilledVariable(commonReq);
                        kPrimer$fetchPopularPreview$12.L$4 = SpillingKt.nullOutSpilledVariable(req);
                        kPrimer$fetchPopularPreview$12.L$5 = SpillingKt.nullOutSpilledVariable(result2);
                        kPrimer$fetchPopularPreview$12.L$6 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        kPrimer$fetchPopularPreview$12.L$7 = SpillingKt.nullOutSpilledVariable(items2);
                        kPrimer$fetchPopularPreview$12.I$0 = i;
                        kPrimer$fetchPopularPreview$12.label = 2;
                        if (mutableSharedFlow.emit(destination$iv$iv, kPrimer$fetchPopularPreview$12) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i2 = kPrimer$fetchPopularPreview$12.I$0;
                        List list = (List) kPrimer$fetchPopularPreview$12.L$7;
                        Map map = (Map) kPrimer$fetchPopularPreview$12.L$6;
                        KGetColdStartDataResp kGetColdStartDataResp = (KGetColdStartDataResp) kPrimer$fetchPopularPreview$12.L$5;
                        KGetColdStartDataReq kGetColdStartDataReq = (KGetColdStartDataReq) kPrimer$fetchPopularPreview$12.L$4;
                        KHttpCommon kHttpCommon = (KHttpCommon) kPrimer$fetchPopularPreview$12.L$3;
                        PrimerCommonParams primerCommonParams = (PrimerCommonParams) kPrimer$fetchPopularPreview$12.L$2;
                        KPrimer kPrimer = (KPrimer) kPrimer$fetchPopularPreview$12.L$1;
                        param2 = (PrimerParam) kPrimer$fetchPopularPreview$12.L$0;
                        ResultKt.throwOnFailure($result);
                        m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                        PrimerParam param32222 = param2;
                        e = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (e != null) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        int i3 = kPrimer$fetchPopularPreview$12.I$0;
                        Throwable th5 = (Throwable) kPrimer$fetchPopularPreview$12.L$2;
                        Object obj = kPrimer$fetchPopularPreview$12.L$1;
                        PrimerParam primerParam = (PrimerParam) kPrimer$fetchPopularPreview$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        kPrimer$fetchPopularPreview$1 = new KPrimer$fetchPopularPreview$1(this, continuation);
        kPrimer$fetchPopularPreview$12 = kPrimer$fetchPopularPreview$1;
        Object $result3 = kPrimer$fetchPopularPreview$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kPrimer$fetchPopularPreview$12.label) {
        }
    }

    private final boolean filterBlockReq(String bizKey, List<PrimerBizParams> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((PrimerBizParams) obj).getPath().getPath(), bizKey)) {
                break;
            }
        }
        PrimerBizParams param = (PrimerBizParams) obj;
        if (param == null) {
            return false;
        }
        Iterable $this$forEach$iv = param.getBlockScene();
        for (Object element$iv : $this$forEach$iv) {
            BlockScene it2 = (BlockScene) element$iv;
            if (Intrinsics.areEqual(it2, BlockScene.Block.INSTANCE)) {
                KLog_androidKt.getKLog().i("Primer", bizKey + " is blocked");
                this.blockList.add(bizKey);
                return true;
            } else if (Intrinsics.areEqual(it2, BlockScene.UnLogin.INSTANCE)) {
                KAccountStore kAccountStore = this.accountStore;
                if (kAccountStore == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountStore");
                    kAccountStore = null;
                }
                if (kAccountStore.getState().getValue() instanceof AccountState.Idle) {
                    KLog_androidKt.getKLog().i("Primer", bizKey + " is blocked because of not login");
                    return true;
                }
            }
        }
        return false;
    }

    private final KColdStartBizReq buildReq(String bizKey, List<PrimerBizParams> list) {
        Object obj;
        boolean z;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            PrimerBizParams it2 = (PrimerBizParams) obj;
            if (Intrinsics.areEqual(it2.getPath().getPath(), bizKey)) {
                break;
            }
        }
        PrimerBizParams param = (PrimerBizParams) obj;
        if (param == null) {
            return new KColdStartBizReq(bizKey, (KAny) null, 2, (DefaultConstructorMarker) null);
        }
        try {
            if (Intrinsics.areEqual(param.getHitType(), HitType.Once.INSTANCE)) {
                this.onceHitLocalList.add(bizKey);
            }
            if (param.getParams().isEmpty()) {
                String type = param.getType();
                if (type != null && type.length() != 0) {
                    z = false;
                    if (!z && param.getByteArray() != null) {
                        KAny request = new KAny(param.getType(), param.getByteArray());
                        return new KColdStartBizReq(bizKey, request);
                    }
                    return new KColdStartBizReq(bizKey, (KAny) null, 2, (DefaultConstructorMarker) null);
                }
                z = true;
                if (!z) {
                    KAny request2 = new KAny(param.getType(), param.getByteArray());
                    return new KColdStartBizReq(bizKey, request2);
                }
                return new KColdStartBizReq(bizKey, (KAny) null, 2, (DefaultConstructorMarker) null);
            }
            KHttpGetBizReq req = new KHttpGetBizReq(param.getHeaders(), param.getParams());
            BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
            $this$encodeToByteArray$iv.getSerializersModule();
            KAny request3 = new KAny("type.googleapis.com/bilibili.app.coldstart.v1.HttpGetBizReq", $this$encodeToByteArray$iv.encodeToByteArray(KHttpGetBizReq.Companion.serializer(), req));
            return new KColdStartBizReq(bizKey, request3);
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("Primer", "Build req error: " + bizKey + ", message: " + e.getMessage());
            return new KColdStartBizReq(bizKey, (KAny) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public final void launch(PrimerParam param, KAccountStore accountStore) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new KPrimer$launch$1(param, this, accountStore, null), 3, (Object) null);
    }

    public final boolean shouldHandle(String bizKey) {
        Intrinsics.checkNotNullParameter(bizKey, "bizKey");
        if ((this.onceHitLocalList.contains(bizKey) || getOnceHitKeys$primer_debug().contains(bizKey)) && ((Map) this.hitMap.getValue()).get(bizKey) != null) {
            KLog_androidKt.getKLog().i("Primer", bizKey + " exceeds hit count");
            return false;
        } else if (!this.blockList.contains(bizKey)) {
            return !getExpired$primer_debug() && getKeys$primer_debug().contains(bizKey);
        } else {
            KLog_androidKt.getKLog().i("Primer", bizKey + " is blocked by biz");
            return false;
        }
    }

    public final Flow<byte[]> handle(String bizKey) {
        Intrinsics.checkNotNullParameter(bizKey, "bizKey");
        return FlowKt.flow(new KPrimer$handle$1(bizKey, this, null));
    }
}