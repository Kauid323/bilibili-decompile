package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MergeAtmospherePriceFloorComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1", f = "MergeAtmospherePriceFloorComponent.kt", i = {0, 0, 0, 0, 0, 0}, l = {901}, m = "invokeSuspend", n = {"currentTimeMillis", "remainingMillis", "remainingSeconds", "hours", "minutes", "seconds"}, s = {"J$0", "J$1", "J$2", "J$3", "J$4", "J$5"}, v = 1)
public final class MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $countDownText$delegate;
    final /* synthetic */ State<Function0<Unit>> $currentOnCountdownEnd$delegate;
    final /* synthetic */ Long $leftTimeSeconds;
    final /* synthetic */ long $targetEndTime;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    long J$4;
    long J$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1(Long l, long j, MutableState<String> mutableState, State<? extends Function0<Unit>> state, Continuation<? super MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1> continuation) {
        super(2, continuation);
        this.$leftTimeSeconds = l;
        this.$targetEndTime = j;
        this.$countDownText$delegate = mutableState;
        this.$currentOnCountdownEnd$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1(this.$leftTimeSeconds, this.$targetEndTime, this.$countDownText$delegate, this.$currentOnCountdownEnd$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0116 -> B:33:0x0122). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1 mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1;
        Object obj;
        Object $result2;
        Object obj2;
        Object obj3;
        long hours;
        Object obj4;
        Function0 rememberCountdown$lambda$4;
        MergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1 mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.$leftTimeSeconds != null && mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.$leftTimeSeconds.longValue() > 0) {
                    mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12;
                    obj = coroutine_suspended;
                    $result2 = $result;
                    break;
                } else {
                    this.$countDownText$delegate.setValue("");
                    return Unit.INSTANCE;
                }
                break;
            case 1:
                long j = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.J$5;
                long j2 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.J$4;
                long j3 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.J$3;
                long j4 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.J$2;
                long j5 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.J$1;
                long j6 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12.J$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                $result2 = $result;
                mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long currentTimeMillis = DateFormatKt.getCurrentTimeMillis();
        long remainingMillis = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.$targetEndTime - currentTimeMillis;
        long remainingSeconds = remainingMillis / 1000;
        if (remainingSeconds > 0) {
            rememberCountdown$lambda$4 = MergeAtmospherePriceFloorComponentKt.rememberCountdown$lambda$4(mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.$currentOnCountdownEnd$delegate);
            rememberCountdown$lambda$4.invoke();
            return Unit.INSTANCE;
        }
        long j7 = 3600;
        long hours2 = remainingSeconds / j7;
        Object $result3 = $result2;
        long j8 = 60;
        long minutes = (remainingSeconds % j7) / j8;
        long seconds = remainingSeconds % j8;
        MutableState<String> mutableState = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.$countDownText$delegate;
        if (hours2 > 9) {
            obj2 = obj;
            obj3 = Boxing.boxLong(hours2);
        } else {
            obj2 = obj;
            obj3 = "0" + hours2;
        }
        if (minutes > 9) {
            hours = hours2;
            obj4 = Boxing.boxLong(minutes);
        } else {
            hours = hours2;
            obj4 = "0" + minutes;
        }
        mutableState.setValue(obj3 + ":" + obj4 + ":" + (seconds > 9 ? Boxing.boxLong(seconds) : "0" + seconds));
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.J$0 = currentTimeMillis;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.J$1 = remainingMillis;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.J$2 = remainingSeconds;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.J$3 = hours;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.J$4 = minutes;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.J$5 = seconds;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.label = 1;
        Object obj5 = obj2;
        if (DelayKt.delay(500L, (Continuation) mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1) == obj5) {
            return obj5;
        }
        obj = obj5;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1;
        $result2 = $result3;
        mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$12;
        long currentTimeMillis2 = DateFormatKt.getCurrentTimeMillis();
        long remainingMillis2 = mergeAtmospherePriceFloorComponentKt$rememberCountdown$2$1.$targetEndTime - currentTimeMillis2;
        long remainingSeconds2 = remainingMillis2 / 1000;
        if (remainingSeconds2 > 0) {
        }
    }
}