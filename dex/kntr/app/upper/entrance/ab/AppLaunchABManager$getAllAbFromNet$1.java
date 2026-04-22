package kntr.app.upper.entrance.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.utils.TrackUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.datetime.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppLaunchABManager.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.ab.AppLaunchABManager$getAllAbFromNet$1", f = "AppLaunchABManager.kt", i = {0, 0}, l = {380}, m = "invokeSuspend", n = {"requestAbKeys", "$i$a$-runCatching-AppLaunchABManager$getAllAbFromNet$1$result$1"}, s = {"L$0", "I$0"}, v = 1)
public final class AppLaunchABManager$getAllAbFromNet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ String $abExtra;
    final /* synthetic */ List<AppLaunchAB> $abList;
    final /* synthetic */ String $mid;
    final /* synthetic */ long $startTime;
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLaunchABManager$getAllAbFromNet$1(String str, long j, List<AppLaunchAB> list, String str2, Continuation<? super AppLaunchABManager$getAllAbFromNet$1> continuation) {
        super(2, continuation);
        this.$mid = str;
        this.$startTime = j;
        this.$abList = list;
        this.$abExtra = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppLaunchABManager$getAllAbFromNet$1(this.$mid, this.$startTime, this.$abList, this.$abExtra, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object result;
        Map originKeyMap;
        Object aBData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable iterable = this.$abList;
                    String str = this.$mid;
                    String str2 = this.$abExtra;
                    Result.Companion companion = Result.Companion;
                    Iterable $this$map$iv = iterable;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        AppLaunchAB it = (AppLaunchAB) item$iv$iv;
                        destination$iv$iv.add(AppLaunchABManager.INSTANCE.getDynamicKey$entrance_debug(it));
                    }
                    List requestAbKeys = CollectionsKt.plus((List) destination$iv$iv, AppLaunchABManager.INSTANCE.getEmptyAbKey$entrance_debug());
                    ABService aBService = ABService.INSTANCE;
                    List<String> distinct = CollectionsKt.distinct(requestAbKeys);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(requestAbKeys);
                    this.I$0 = 0;
                    this.label = 1;
                    aBData = aBService.getABData(distinct, str, str2, this);
                    if (aBData != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    List list = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    aBData = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            result = Result.m2636constructorimpl((Map) aBData);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            result = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        Map map = Result.m2639exceptionOrNullimpl(result) == null ? result : MapsKt.emptyMap();
        originKeyMap = AppLaunchABManager.INSTANCE.toOriginKeyAndSaveToCache(map, this.$mid);
        TrackUtils trackUtils = TrackUtils.INSTANCE;
        boolean m2643isSuccessimpl = Result.m2643isSuccessimpl(result);
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds() - this.$startTime;
        Throwable m2639exceptionOrNullimpl = Result.m2639exceptionOrNullimpl(result);
        trackUtils.trackABResult(m2643isSuccessimpl, originKeyMap, map, epochMilliseconds, (m2639exceptionOrNullimpl == null || (r4 = m2639exceptionOrNullimpl.getMessage()) == null) ? "" : "", this.$mid);
        return originKeyMap;
    }
}