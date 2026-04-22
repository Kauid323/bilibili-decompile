package kntr.base.primer;

import com.bapis.bilibili.app.coldstart.v1.KColdStartBizResp;
import com.bilibili.lib.gripper.api.SuspendProducer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.KAccountStore;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.GNetPublicHeader;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.GNetPublicParamList;
import kntr.base.net.Param;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: GPrimer.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001Bs\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkntr/base/primer/GPrimerServer;", "Lkntr/base/primer/GPrimer;", "suspendGetPublicParam", "", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/GNetPublicParam;", "suspendGetPublicParamList", "Lkntr/base/net/GNetPublicParamList;", "suspendGetCommonHeader", "Lkntr/base/net/GNetPublicHeader;", "suspendGetBizParams", "Lkntr/base/primer/GPrimerBizParams;", "suspendGetBizParamsList", "Lkntr/base/primer/GPrimerBizParamsList;", "accountStore", "Lkntr/base/account/KAccountStore;", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Lkntr/base/account/KAccountStore;)V", "kPrimer", "Lkntr/base/primer/KPrimer;", "setup", "", "getPrams", "Lkntr/base/primer/PrimerParam;", "hit", "Lcom/bapis/bilibili/app/coldstart/v1/KColdStartBizResp;", "host", "", "path", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isHit", "", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GPrimerServer implements GPrimer {
    private final KAccountStore accountStore;
    private KPrimer kPrimer;
    private final Set<SuspendProducer<GPrimerBizParams>> suspendGetBizParams;
    private final Set<SuspendProducer<GPrimerBizParamsList>> suspendGetBizParamsList;
    private final Set<SuspendProducer<GNetPublicHeader>> suspendGetCommonHeader;
    private final Set<SuspendProducer<GNetPublicParam>> suspendGetPublicParam;
    private final Set<SuspendProducer<GNetPublicParamList>> suspendGetPublicParamList;

    public GPrimerServer(Set<? extends SuspendProducer<GNetPublicParam>> set, Set<? extends SuspendProducer<GNetPublicParamList>> set2, Set<? extends SuspendProducer<GNetPublicHeader>> set3, Set<? extends SuspendProducer<GPrimerBizParams>> set4, Set<? extends SuspendProducer<GPrimerBizParamsList>> set5, KAccountStore accountStore) {
        Intrinsics.checkNotNullParameter(set, "suspendGetPublicParam");
        Intrinsics.checkNotNullParameter(set2, "suspendGetPublicParamList");
        Intrinsics.checkNotNullParameter(set3, "suspendGetCommonHeader");
        Intrinsics.checkNotNullParameter(set4, "suspendGetBizParams");
        Intrinsics.checkNotNullParameter(set5, "suspendGetBizParamsList");
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        this.suspendGetPublicParam = set;
        this.suspendGetPublicParamList = set2;
        this.suspendGetCommonHeader = set3;
        this.suspendGetBizParams = set4;
        this.suspendGetBizParamsList = set5;
        this.accountStore = accountStore;
        this.kPrimer = KPrimer.Companion.getShared();
    }

    @Override // kntr.base.primer.GPrimer
    public void setup() {
        this.kPrimer.launch(getPrams(), this.accountStore);
    }

    private final PrimerParam getPrams() {
        Iterable $this$map$iv = this.suspendGetPublicParamList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SuspendProducer it = (SuspendProducer) item$iv$iv;
            destination$iv$iv.add((GNetPublicParamList) it.get());
        }
        Iterable $this$flatMap$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            GNetPublicParamList it2 = (GNetPublicParamList) element$iv$iv;
            Iterable list$iv$iv = it2.list();
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
        }
        Collection collection = (List) destination$iv$iv2;
        Iterable $this$map$iv2 = this.suspendGetPublicParam;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            SuspendProducer it3 = (SuspendProducer) item$iv$iv2;
            destination$iv$iv3.add((GNetPublicParam) it3.get());
        }
        Iterable $this$filter$iv = (List) destination$iv$iv3;
        Collection destination$iv$iv4 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv) {
            GNetPublicParam it4 = (GNetPublicParam) element$iv$iv2;
            if ((it4 != null ? it4.param() : null) != null) {
                destination$iv$iv4.add(element$iv$iv2);
            }
        }
        Iterable $this$associate$iv = CollectionsKt.plus(collection, (List) destination$iv$iv4);
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv5 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv3 : $this$associate$iv) {
            GNetPublicParam it5 = (GNetPublicParam) element$iv$iv3;
            Intrinsics.checkNotNull(it5);
            Param param = it5.param();
            Intrinsics.checkNotNull(param);
            String key = param.getKey();
            Param param2 = it5.param();
            Intrinsics.checkNotNull(param2);
            Pair pair = TuplesKt.to(key, param2.getValue());
            destination$iv$iv5.put(pair.getFirst(), pair.getSecond());
        }
        Iterable $this$map$iv3 = this.suspendGetCommonHeader;
        Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            SuspendProducer it6 = (SuspendProducer) item$iv$iv3;
            destination$iv$iv6.add((GNetPublicHeader) it6.get());
        }
        Iterable $this$flatMap$iv2 = (List) destination$iv$iv6;
        Collection destination$iv$iv7 = new ArrayList();
        for (Object element$iv$iv4 : $this$flatMap$iv2) {
            GNetPublicHeader it7 = (GNetPublicHeader) element$iv$iv4;
            Iterable list$iv$iv2 = it7.header();
            CollectionsKt.addAll(destination$iv$iv7, list$iv$iv2);
        }
        Iterable $this$associate$iv2 = (List) destination$iv$iv7;
        int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv2, 10)), 16);
        Map destination$iv$iv8 = new LinkedHashMap(capacity$iv2);
        for (Object element$iv$iv5 : $this$associate$iv2) {
            Param it8 = (Param) element$iv$iv5;
            Pair pair2 = TuplesKt.to(it8.getKey(), it8.getValue());
            destination$iv$iv8.put(pair2.getFirst(), pair2.getSecond());
        }
        Instant start = Clock.System.INSTANCE.now();
        Iterable $this$map$iv4 = this.suspendGetBizParams;
        Collection destination$iv$iv9 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
        for (Object item$iv$iv4 : $this$map$iv4) {
            SuspendProducer it9 = (SuspendProducer) item$iv$iv4;
            destination$iv$iv9.add((GPrimerBizParams) it9.get());
        }
        Iterable $this$map$iv5 = (List) destination$iv$iv9;
        Collection destination$iv$iv10 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
        for (Object item$iv$iv5 : $this$map$iv5) {
            GPrimerBizParams it10 = (GPrimerBizParams) item$iv$iv5;
            destination$iv$iv10.add(it10.param());
        }
        Collection collection2 = (List) destination$iv$iv10;
        Iterable $this$map$iv6 = this.suspendGetBizParamsList;
        Collection destination$iv$iv11 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
        for (Object item$iv$iv6 : $this$map$iv6) {
            SuspendProducer it11 = (SuspendProducer) item$iv$iv6;
            destination$iv$iv11.add((GPrimerBizParamsList) it11.get());
        }
        Iterable $this$flatMap$iv3 = (List) destination$iv$iv11;
        Collection destination$iv$iv12 = new ArrayList();
        for (Object element$iv$iv6 : $this$flatMap$iv3) {
            GPrimerBizParamsList it12 = (GPrimerBizParamsList) element$iv$iv6;
            Iterable list$iv$iv3 = it12.params();
            CollectionsKt.addAll(destination$iv$iv12, list$iv$iv3);
        }
        List bizParams = CollectionsKt.plus(collection2, (List) destination$iv$iv12);
        KLog_androidKt.getKLog().i("Primer", "bizParams cost: " + Duration.toString-impl(Clock.System.INSTANCE.now().minus-5sfh64U(start)));
        return new PrimerParam(new PrimerCommonParams(destination$iv$iv8, destination$iv$iv5), bizParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // kntr.base.primer.GPrimer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object hit(String host, String path, Continuation<? super KColdStartBizResp> continuation) {
        GPrimerServer$hit$1 gPrimerServer$hit$1;
        Object firstOrNull;
        byte[] it;
        if (continuation instanceof GPrimerServer$hit$1) {
            gPrimerServer$hit$1 = (GPrimerServer$hit$1) continuation;
            if ((gPrimerServer$hit$1.label & Integer.MIN_VALUE) != 0) {
                gPrimerServer$hit$1.label -= Integer.MIN_VALUE;
                Object $result = gPrimerServer$hit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (gPrimerServer$hit$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!this.kPrimer.shouldHandle(host + path)) {
                            return null;
                        }
                        Flow<byte[]> handle = this.kPrimer.handle(host + path);
                        gPrimerServer$hit$1.L$0 = SpillingKt.nullOutSpilledVariable(host);
                        gPrimerServer$hit$1.L$1 = SpillingKt.nullOutSpilledVariable(path);
                        gPrimerServer$hit$1.label = 1;
                        firstOrNull = FlowKt.firstOrNull(handle, gPrimerServer$hit$1);
                        if (firstOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        String str = (String) gPrimerServer$hit$1.L$1;
                        String str2 = (String) gPrimerServer$hit$1.L$0;
                        ResultKt.throwOnFailure($result);
                        firstOrNull = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (byte[]) firstOrNull;
                if (it == null) {
                    BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
                    $this$decodeFromByteArray$iv.getSerializersModule();
                    return (KColdStartBizResp) $this$decodeFromByteArray$iv.decodeFromByteArray(KColdStartBizResp.Companion.serializer(), it);
                }
                return null;
            }
        }
        gPrimerServer$hit$1 = new GPrimerServer$hit$1(this, continuation);
        Object $result2 = gPrimerServer$hit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (gPrimerServer$hit$1.label) {
        }
        it = (byte[]) firstOrNull;
        if (it == null) {
        }
    }

    @Override // kntr.base.primer.GPrimer
    public boolean isHit(String host, String path) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        return this.kPrimer.shouldHandle(host + path);
    }
}