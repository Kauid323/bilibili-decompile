package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.MutableState;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AtmospherePriceFloorComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$CountDownComponent$1$1", f = "AtmospherePriceFloorComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {324}, m = "invokeSuspend", n = {"formatCountDownText", "status", "validStatus", "diffSeconds", "countDownStartTime", "currentTimeMillis", "timePassed", "remainingSeconds"}, s = {"L$0", "I$0", "I$1", "J$0", "J$1", "J$2", "J$3", "J$4"}, v = 1)
public final class AtmospherePriceFloorComponentKt$CountDownComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $countDownText$delegate;
    final /* synthetic */ Long $endTime;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ Long $serverTime;
    final /* synthetic */ Long $startTime;
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    long J$4;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtmospherePriceFloorComponentKt$CountDownComponent$1$1(Long l, Long l2, Long l3, PageViewModel pageViewModel, MutableState<String> mutableState, Continuation<? super AtmospherePriceFloorComponentKt$CountDownComponent$1$1> continuation) {
        super(2, continuation);
        this.$startTime = l;
        this.$serverTime = l2;
        this.$endTime = l3;
        this.$pageViewModel = pageViewModel;
        this.$countDownText$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AtmospherePriceFloorComponentKt$CountDownComponent$1$1(this.$startTime, this.$serverTime, this.$endTime, this.$pageViewModel, this.$countDownText$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x013c -> B:68:0x0142). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int status;
        int status2;
        long diffSeconds;
        Function1 formatCountDownText;
        long diffSeconds2;
        long countDownStartTime;
        AtmospherePriceFloorComponentKt$CountDownComponent$1$1 atmospherePriceFloorComponentKt$CountDownComponent$1$1;
        int status3;
        Object obj;
        Object $result2;
        Object $result3;
        boolean validStatus;
        Function1 formatCountDownText2;
        AtmospherePriceFloorComponentKt$CountDownComponent$1$1 atmospherePriceFloorComponentKt$CountDownComponent$1$12 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (atmospherePriceFloorComponentKt$CountDownComponent$1$12.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                atmospherePriceFloorComponentKt$CountDownComponent$1$12.$countDownText$delegate.setValue("");
                status = 0;
                if (atmospherePriceFloorComponentKt$CountDownComponent$1$12.$startTime != null && atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime != null && atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime.longValue() < atmospherePriceFloorComponentKt$CountDownComponent$1$12.$startTime.longValue()) {
                    status2 = 0;
                } else if (atmospherePriceFloorComponentKt$CountDownComponent$1$12.$endTime != null && atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime != null && atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime.longValue() > atmospherePriceFloorComponentKt$CountDownComponent$1$12.$endTime.longValue()) {
                    status2 = 2;
                } else if (atmospherePriceFloorComponentKt$CountDownComponent$1$12.$endTime != null && atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime != null && atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime.longValue() < atmospherePriceFloorComponentKt$CountDownComponent$1$12.$endTime.longValue()) {
                    status2 = 1;
                } else {
                    status2 = -1;
                }
                if (status2 == 0 || status2 == 1) {
                    status = 1;
                }
                if (status == 0) {
                    return Unit.INSTANCE;
                }
                if (status2 == 0) {
                    Long l = atmospherePriceFloorComponentKt$CountDownComponent$1$12.$startTime;
                    long longValue = l != null ? l.longValue() : 0L;
                    Long l2 = atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime;
                    diffSeconds = longValue - (l2 != null ? l2.longValue() : 0L);
                } else {
                    Long l3 = atmospherePriceFloorComponentKt$CountDownComponent$1$12.$endTime;
                    long longValue2 = l3 != null ? l3.longValue() : 0L;
                    Long l4 = atmospherePriceFloorComponentKt$CountDownComponent$1$12.$serverTime;
                    diffSeconds = longValue2 - (l4 != null ? l4.longValue() : 0L);
                }
                if (diffSeconds <= 0) {
                    atmospherePriceFloorComponentKt$CountDownComponent$1$12.$pageViewModel.reloadProductDetails$product_details_page_debug();
                    return Unit.INSTANCE;
                }
                final MutableState<String> mutableState = atmospherePriceFloorComponentKt$CountDownComponent$1$12.$countDownText$delegate;
                formatCountDownText = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$CountDownComponent$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = AtmospherePriceFloorComponentKt$CountDownComponent$1$1.invokeSuspend$lambda$0(mutableState, ((Long) obj2).longValue());
                        return invokeSuspend$lambda$0;
                    }
                };
                diffSeconds2 = diffSeconds;
                countDownStartTime = DateFormatKt.getCurrentTimeMillis();
                atmospherePriceFloorComponentKt$CountDownComponent$1$1 = atmospherePriceFloorComponentKt$CountDownComponent$1$12;
                status3 = status2;
                obj = coroutine_suspended;
                $result2 = $result;
                break;
                break;
            case 1:
                long j = atmospherePriceFloorComponentKt$CountDownComponent$1$12.J$4;
                long j2 = atmospherePriceFloorComponentKt$CountDownComponent$1$12.J$3;
                long j3 = atmospherePriceFloorComponentKt$CountDownComponent$1$12.J$2;
                countDownStartTime = atmospherePriceFloorComponentKt$CountDownComponent$1$12.J$1;
                diffSeconds2 = atmospherePriceFloorComponentKt$CountDownComponent$1$12.J$0;
                int i = atmospherePriceFloorComponentKt$CountDownComponent$1$12.I$1;
                int status4 = atmospherePriceFloorComponentKt$CountDownComponent$1$12.I$0;
                Function1 formatCountDownText3 = (Function1) atmospherePriceFloorComponentKt$CountDownComponent$1$12.L$0;
                ResultKt.throwOnFailure($result);
                $result3 = $result;
                obj = coroutine_suspended;
                validStatus = true;
                formatCountDownText2 = formatCountDownText3;
                status3 = status4;
                status = i;
                atmospherePriceFloorComponentKt$CountDownComponent$1$1 = atmospherePriceFloorComponentKt$CountDownComponent$1$12;
                formatCountDownText = formatCountDownText2;
                $result2 = $result3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long currentTimeMillis = DateFormatKt.getCurrentTimeMillis();
        long timePassed = currentTimeMillis - countDownStartTime;
        int i2 = status;
        long remainingSeconds = diffSeconds2 - (timePassed / 1000);
        if (remainingSeconds > 0) {
            atmospherePriceFloorComponentKt$CountDownComponent$1$1.$pageViewModel.reloadProductDetails$product_details_page_debug();
            return Unit.INSTANCE;
        }
        formatCountDownText.invoke(Boxing.boxLong(remainingSeconds));
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.L$0 = formatCountDownText;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.I$0 = status3;
        $result3 = $result2;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.I$1 = i2;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.J$0 = diffSeconds2;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.J$1 = countDownStartTime;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.J$2 = currentTimeMillis;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.J$3 = timePassed;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.J$4 = remainingSeconds;
        validStatus = true;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1.label = 1;
        if (DelayKt.delay(500L, (Continuation) atmospherePriceFloorComponentKt$CountDownComponent$1$1) == obj) {
            return obj;
        }
        status = i2;
        atmospherePriceFloorComponentKt$CountDownComponent$1$12 = atmospherePriceFloorComponentKt$CountDownComponent$1$1;
        formatCountDownText2 = formatCountDownText;
        atmospherePriceFloorComponentKt$CountDownComponent$1$1 = atmospherePriceFloorComponentKt$CountDownComponent$1$12;
        formatCountDownText = formatCountDownText2;
        $result2 = $result3;
        long currentTimeMillis2 = DateFormatKt.getCurrentTimeMillis();
        long timePassed2 = currentTimeMillis2 - countDownStartTime;
        int i22 = status;
        long remainingSeconds2 = diffSeconds2 - (timePassed2 / 1000);
        if (remainingSeconds2 > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MutableState $countDownText$delegate, long remainingSeconds) {
        String str;
        long days = remainingSeconds / 86400;
        long j = 3600;
        long hours = remainingSeconds / j;
        long j2 = 60;
        long minutes = (remainingSeconds % j) / j2;
        long seconds = remainingSeconds % j2;
        String hoursMinutesSeconds = (hours > 9 ? Long.valueOf(hours) : "0" + hours) + ":" + (minutes > 9 ? Long.valueOf(minutes) : "0" + minutes) + ":" + (seconds > 9 ? Long.valueOf(seconds) : "0" + seconds);
        if (days > 7) {
            str = days + "天";
        } else if (days >= 3) {
            str = days + "天" + hoursMinutesSeconds;
        } else {
            str = hoursMinutesSeconds;
        }
        $countDownText$delegate.setValue(str);
        return Unit.INSTANCE;
    }
}