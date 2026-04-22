package kntr.app.ad.ui.inspector.ui.main.ad.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: AdDetailViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdDetailViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "getInspectorInfoByIdFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "adId", RoomRecommendViewModel.EMPTY_CURSOR, "getLatestReportForAdFlow", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdDetailViewModel {
    public static final int $stable = 0;

    public final Flow<InspectorInfo> getInspectorInfoByIdFlow(String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        try {
            return StateManager.INSTANCE.getInspectorInfoFlow(adId);
        } catch (Exception e) {
            return FlowKt.flowOf((Object) null);
        }
    }

    public final Flow<ReportJobData> getLatestReportForAdFlow(final String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        try {
            final Flow $this$map$iv = StateManager.INSTANCE.getReportJobDataListFlow();
            return FlowKt.distinctUntilChanged(new Flow<ReportJobData>() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.viewmodel.AdDetailViewModel$getLatestReportForAdFlow$$inlined$map$1

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: kntr.app.ad.ui.inspector.ui.main.ad.viewmodel.AdDetailViewModel$getLatestReportForAdFlow$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ String $adId$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.main.ad.viewmodel.AdDetailViewModel$getLatestReportForAdFlow$$inlined$map$1$2", f = "AdDetailViewModel.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    /* renamed from: kntr.app.ad.ui.inspector.ui.main.ad.viewmodel.AdDetailViewModel$getLatestReportForAdFlow$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, String str) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$adId$inlined = str;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation $completion) {
                        Continuation $continuation;
                        Object maxElem$iv;
                        if ($completion instanceof AnonymousClass1) {
                            $continuation = (AnonymousClass1) $completion;
                            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                $continuation.label -= Integer.MIN_VALUE;
                                Object $result = $continuation.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                        AnonymousClass1 anonymousClass1 = $continuation;
                                        Continuation $completion2 = $continuation;
                                        Iterable reportJobs = (List) value;
                                        Iterable $this$filter$iv = reportJobs;
                                        Collection destination$iv$iv = new ArrayList();
                                        for (T t : $this$filter$iv) {
                                            ReportJobData it = (ReportJobData) t;
                                            Object $result2 = $result;
                                            Continuation $completion3 = $completion2;
                                            if (Intrinsics.areEqual(it.getAdId(), this.$adId$inlined)) {
                                                destination$iv$iv.add(t);
                                            }
                                            $result = $result2;
                                            $completion2 = $completion3;
                                        }
                                        Iterable $this$maxByOrNull$iv = (List) destination$iv$iv;
                                        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
                                        if (iterator$iv.hasNext()) {
                                            maxElem$iv = iterator$iv.next();
                                            if (iterator$iv.hasNext()) {
                                                ReportJobData it2 = (ReportJobData) maxElem$iv;
                                                long maxValue$iv = it2.getTimestamp();
                                                do {
                                                    Object e$iv = iterator$iv.next();
                                                    ReportJobData it3 = (ReportJobData) e$iv;
                                                    long v$iv = it3.getTimestamp();
                                                    if (maxValue$iv < v$iv) {
                                                        maxElem$iv = e$iv;
                                                        maxValue$iv = v$iv;
                                                    }
                                                } while (iterator$iv.hasNext());
                                            }
                                        } else {
                                            maxElem$iv = null;
                                        }
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                        $continuation.I$0 = 0;
                                        $continuation.label = 1;
                                        if ($this$map_u24lambda_u245.emit(maxElem$iv, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        int i = $continuation.I$0;
                                        FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                        Object obj = $continuation.L$2;
                                        AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                        Object obj2 = $continuation.L$0;
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        $continuation = new AnonymousClass1($completion);
                        Object $result3 = $continuation.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect = $this$map$iv.collect(new AnonymousClass2(collector, adId), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }
            });
        } catch (Exception e) {
            return FlowKt.flowOf((Object) null);
        }
    }
}