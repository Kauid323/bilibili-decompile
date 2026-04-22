package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CrowdfundingAtmosFloorComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1", f = "CrowdfundingAtmosFloorComponent.kt", i = {0, 0, 0, 0, 0}, l = {248}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "elapsedMs", "remainingMs", "remainingSec", "toNextTick"}, s = {"L$0", "J$0", "J$1", "J$2", "J$3"}, v = 1)
public final class CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnEnd;
    final /* synthetic */ MutableLongState $days$delegate;
    final /* synthetic */ MutableState<Boolean> $ended$delegate;
    final /* synthetic */ MutableLongState $hours$delegate;
    final /* synthetic */ long $initialRemainingMs;
    final /* synthetic */ MutableLongState $minutes$delegate;
    final /* synthetic */ MutableLongState $seconds$delegate;
    final /* synthetic */ long $startMark;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1(long j, State<? extends Function0<Unit>> state, long j2, MutableLongState mutableLongState, MutableLongState mutableLongState2, MutableLongState mutableLongState3, MutableState<Boolean> mutableState, MutableLongState mutableLongState4, Continuation<? super CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1> continuation) {
        super(2, continuation);
        this.$initialRemainingMs = j;
        this.$currentOnEnd = state;
        this.$startMark = j2;
        this.$hours$delegate = mutableLongState;
        this.$minutes$delegate = mutableLongState2;
        this.$seconds$delegate = mutableLongState3;
        this.$ended$delegate = mutableState;
        this.$days$delegate = mutableLongState4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1 = new CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1(this.$initialRemainingMs, this.$currentOnEnd, this.$startMark, this.$hours$delegate, this.$minutes$delegate, this.$seconds$delegate, this.$ended$delegate, this.$days$delegate, continuation);
        crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.L$0 = obj;
        return crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0118  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x010c -> B:30:0x0110). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1 crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1;
        Object obj;
        CoroutineScope $this$LaunchedEffect;
        Object $result2;
        boolean CountDownComponent$lambda$18;
        long CountDownComponent$lambda$6;
        boolean z;
        boolean CountDownComponent$lambda$182;
        CrowdfundingAtmosFloorComponentKt$CountDownComponent$3$1 crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12 = this;
        CoroutineScope $this$LaunchedEffect2 = (CoroutineScope) crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        long j = 0;
        switch (crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.$initialRemainingMs > 0) {
                    crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12;
                    obj = coroutine_suspended;
                    $this$LaunchedEffect = $this$LaunchedEffect2;
                    $result2 = $result;
                    break;
                } else {
                    crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.$hours$delegate.setLongValue(0L);
                    crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.$minutes$delegate.setLongValue(0L);
                    crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.$seconds$delegate.setLongValue(0L);
                    CountDownComponent$lambda$18 = CrowdfundingAtmosFloorComponentKt.CountDownComponent$lambda$18(crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.$ended$delegate);
                    if (!CountDownComponent$lambda$18) {
                        CrowdfundingAtmosFloorComponentKt.CountDownComponent$lambda$19(crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.$ended$delegate, true);
                        ((Function0) crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.$currentOnEnd.getValue()).invoke();
                    }
                    return Unit.INSTANCE;
                }
            case 1:
                long j2 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.J$3;
                long j3 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.J$2;
                long j4 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.J$1;
                long j5 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12.J$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                $this$LaunchedEffect = $this$LaunchedEffect2;
                $result2 = $result;
                z = true;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12;
                z2 = z;
                j = 0;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!CoroutineScopeKt.isActive($this$LaunchedEffect)) {
            long elapsedMs = Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$startMark));
            long remainingMs = Math.max(j, crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$initialRemainingMs - elapsedMs);
            if (remainingMs > j) {
                long remainingSec = remainingMs / 1000;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$days$delegate.setLongValue(remainingSec / 86400);
                MutableLongState mutableLongState = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$hours$delegate;
                long j6 = 3600;
                CountDownComponent$lambda$6 = CrowdfundingAtmosFloorComponentKt.CountDownComponent$lambda$6(crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$days$delegate);
                Object $result3 = $result2;
                mutableLongState.setLongValue((remainingSec / j6) - (CountDownComponent$lambda$6 * 24));
                long elapsedMs2 = 60;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$minutes$delegate.setLongValue((remainingSec % j6) / elapsedMs2);
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$seconds$delegate.setLongValue(remainingSec % elapsedMs2);
                long toNextTick = remainingMs % 1000;
                long j7 = toNextTick > 0 ? toNextTick : 1000L;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.L$0 = $this$LaunchedEffect;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.J$0 = elapsedMs;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.J$1 = remainingMs;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.J$2 = remainingSec;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.J$3 = toNextTick;
                z = true;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.label = 1;
                if (DelayKt.delay(j7, (Continuation) crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1) == obj) {
                    return obj;
                }
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1;
                $result2 = $result3;
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1 = crowdfundingAtmosFloorComponentKt$CountDownComponent$3$12;
                z2 = z;
                j = 0;
                if (!CoroutineScopeKt.isActive($this$LaunchedEffect)) {
                }
            } else {
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$hours$delegate.setLongValue(j);
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$minutes$delegate.setLongValue(j);
                crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$seconds$delegate.setLongValue(j);
                CountDownComponent$lambda$182 = CrowdfundingAtmosFloorComponentKt.CountDownComponent$lambda$18(crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$ended$delegate);
                if (!CountDownComponent$lambda$182) {
                    CrowdfundingAtmosFloorComponentKt.CountDownComponent$lambda$19(crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$ended$delegate, z2);
                    ((Function0) crowdfundingAtmosFloorComponentKt$CountDownComponent$3$1.$currentOnEnd.getValue()).invoke();
                }
            }
        }
        return Unit.INSTANCE;
    }
}