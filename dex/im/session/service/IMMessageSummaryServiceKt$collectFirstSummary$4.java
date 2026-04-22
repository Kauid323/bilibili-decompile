package im.session.service;

import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessageSummaryService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lim/session/model/IMSessionCard;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMMessageSummaryServiceKt$collectFirstSummary$4", f = "IMMessageSummaryService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {268}, m = "invokeSuspend", n = {"$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "session", "$i$f$map", "$i$f$mapTo", "$i$a$-map-IMMessageSummaryServiceKt$collectFirstSummary$4$1"}, s = {"L$0", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
public final class IMMessageSummaryServiceKt$collectFirstSummary$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends IMSessionCard>>, Object> {
    final /* synthetic */ List<IMSessionCard> $sessions;
    final /* synthetic */ IMSummaryCacheService $this_collectFirstSummary;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMMessageSummaryServiceKt$collectFirstSummary$4(List<IMSessionCard> list, IMSummaryCacheService iMSummaryCacheService, Continuation<? super IMMessageSummaryServiceKt$collectFirstSummary$4> continuation) {
        super(2, continuation);
        this.$sessions = list;
        this.$this_collectFirstSummary = iMSummaryCacheService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMMessageSummaryServiceKt$collectFirstSummary$4(this.$sessions, this.$this_collectFirstSummary, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<IMSessionCard>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x015c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x00d9 -> B:14:0x00ed). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int $i$f$mapTo;
        Collection destination$iv$iv;
        Iterator it;
        Iterable $this$map$iv;
        IMSummaryCacheService iMSummaryCacheService;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo2;
        IMMessageSummaryServiceKt$collectFirstSummary$4 iMMessageSummaryServiceKt$collectFirstSummary$4;
        Object obj;
        Object $result2;
        Object observe$session_debug;
        Iterator it2;
        IMSessionCard session;
        Iterable $this$mapTo$iv$iv2;
        IMSummaryCacheService iMSummaryCacheService2;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        IMMessageSummaryServiceKt$collectFirstSummary$4 iMMessageSummaryServiceKt$collectFirstSummary$42;
        Collection collection;
        int $i$f$map;
        int $i$f$map2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv3 = this.$sessions;
                IMSummaryCacheService iMSummaryCacheService3 = this.$this_collectFirstSummary;
                $i$f$mapTo = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                it = $this$map$iv3.iterator();
                $this$map$iv = $this$map$iv3;
                iMSummaryCacheService = iMSummaryCacheService3;
                $this$mapTo$iv$iv = $this$map$iv3;
                $i$f$mapTo2 = 0;
                iMMessageSummaryServiceKt$collectFirstSummary$4 = this;
                obj = coroutine_suspended;
                $result2 = $result;
                break;
            case 1:
                int i2 = this.I$2;
                int $i$f$mapTo3 = this.I$1;
                int $i$f$map3 = this.I$0;
                Object obj3 = this.L$5;
                destination$iv$iv2 = (Collection) this.L$3;
                Iterable $this$mapTo$iv$iv3 = (Iterable) this.L$2;
                ResultKt.throwOnFailure($result);
                it2 = (Iterator) this.L$4;
                $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                iMSummaryCacheService2 = (IMSummaryCacheService) this.L$1;
                $this$map$iv2 = (Iterable) this.L$0;
                iMMessageSummaryServiceKt$collectFirstSummary$42 = this;
                session = (IMSessionCard) this.L$6;
                observe$session_debug = $result;
                collection = (Collection) this.L$7;
                $i$f$map = $i$f$map3;
                $i$f$map2 = $i$f$mapTo3;
                obj2 = coroutine_suspended;
                $result2 = observe$session_debug;
                Summary summary = (Summary) ((StateFlow) observe$session_debug).getValue();
                IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "session get summary " + IMSessionCardKt.getStringId(session.getId()) + ", " + (summary == null ? summary.getContent() : null));
                collection.add(IMSessionCard.copy$default(session, null, null, null, null, null, false, 0L, false, null, null, null, summary, 2047, null));
                obj = obj2;
                $i$f$mapTo2 = $i$f$map2;
                $i$f$mapTo = $i$f$map;
                iMMessageSummaryServiceKt$collectFirstSummary$4 = iMMessageSummaryServiceKt$collectFirstSummary$42;
                destination$iv$iv = destination$iv$iv2;
                it = it2;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                iMSummaryCacheService = iMSummaryCacheService2;
                $this$map$iv = $this$map$iv2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object item$iv$iv = it.next();
            IMSessionCard session2 = (IMSessionCard) item$iv$iv;
            Object $result3 = $result2;
            Object obj4 = obj;
            IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "session observe summary " + IMSessionCardKt.getStringId(session2.getId()));
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$0 = SpillingKt.nullOutSpilledVariable($this$map$iv);
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$1 = iMSummaryCacheService;
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$2 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$3 = destination$iv$iv;
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$4 = it;
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$5 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$6 = session2;
            iMMessageSummaryServiceKt$collectFirstSummary$4.L$7 = destination$iv$iv;
            iMMessageSummaryServiceKt$collectFirstSummary$4.I$0 = $i$f$mapTo;
            iMMessageSummaryServiceKt$collectFirstSummary$4.I$1 = $i$f$mapTo2;
            iMMessageSummaryServiceKt$collectFirstSummary$4.I$2 = 0;
            iMMessageSummaryServiceKt$collectFirstSummary$4.label = 1;
            observe$session_debug = iMSummaryCacheService.observe$session_debug(session2, iMMessageSummaryServiceKt$collectFirstSummary$4);
            if (observe$session_debug == obj4) {
                return obj4;
            }
            it2 = it;
            session = session2;
            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
            iMSummaryCacheService2 = iMSummaryCacheService;
            $this$map$iv2 = $this$map$iv;
            destination$iv$iv2 = destination$iv$iv;
            iMMessageSummaryServiceKt$collectFirstSummary$42 = iMMessageSummaryServiceKt$collectFirstSummary$4;
            collection = destination$iv$iv2;
            $i$f$map = $i$f$mapTo;
            $i$f$map2 = $i$f$mapTo2;
            obj2 = obj4;
            $result2 = $result3;
            Summary summary2 = (Summary) ((StateFlow) observe$session_debug).getValue();
            IMLog.Companion.d(LogTagKt.getSummaryLogTag(), "session get summary " + IMSessionCardKt.getStringId(session.getId()) + ", " + (summary2 == null ? summary2.getContent() : null));
            collection.add(IMSessionCard.copy$default(session, null, null, null, null, null, false, 0L, false, null, null, null, summary2, 2047, null));
            obj = obj2;
            $i$f$mapTo2 = $i$f$map2;
            $i$f$mapTo = $i$f$map;
            iMMessageSummaryServiceKt$collectFirstSummary$4 = iMMessageSummaryServiceKt$collectFirstSummary$42;
            destination$iv$iv = destination$iv$iv2;
            it = it2;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
            iMSummaryCacheService = iMSummaryCacheService2;
            $this$map$iv = $this$map$iv2;
            if (!it.hasNext()) {
                return (List) destination$iv$iv;
            }
        }
    }
}