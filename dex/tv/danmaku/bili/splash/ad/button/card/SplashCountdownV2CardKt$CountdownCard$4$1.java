package tv.danmaku.bili.splash.ad.button.card;

import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashCountdownV2Card.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.button.card.SplashCountdownV2CardKt$CountdownCard$4$1", f = "SplashCountdownV2Card.kt", i = {}, l = {BR.descName}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashCountdownV2CardKt$CountdownCard$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $activityStartTime;
    final /* synthetic */ MutableState<Boolean> $disposed$delegate;
    final /* synthetic */ MutableState<Boolean> $playAlpha$delegate;
    final /* synthetic */ MutableLongState $timeLeft$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashCountdownV2CardKt$CountdownCard$4$1(long j, MutableLongState mutableLongState, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super SplashCountdownV2CardKt$CountdownCard$4$1> continuation) {
        super(2, continuation);
        this.$activityStartTime = j;
        this.$timeLeft$delegate = mutableLongState;
        this.$disposed$delegate = mutableState;
        this.$playAlpha$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashCountdownV2CardKt$CountdownCard$4$1(this.$activityStartTime, this.$timeLeft$delegate, this.$disposed$delegate, this.$playAlpha$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:15:0x003d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        SplashCountdownV2CardKt$CountdownCard$4$1 splashCountdownV2CardKt$CountdownCard$4$1;
        long CountdownCard_wBJOh4Y$lambda$1;
        boolean CountdownCard_wBJOh4Y$lambda$10;
        long CountdownCard_wBJOh4Y$lambda$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                splashCountdownV2CardKt$CountdownCard$4$1 = this;
                CountdownCard_wBJOh4Y$lambda$1 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$1(splashCountdownV2CardKt$CountdownCard$4$1.$timeLeft$delegate);
                if (CountdownCard_wBJOh4Y$lambda$1 > 0) {
                    CountdownCard_wBJOh4Y$lambda$10 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$10(splashCountdownV2CardKt$CountdownCard$4$1.$disposed$delegate);
                    if (!CountdownCard_wBJOh4Y$lambda$10) {
                        splashCountdownV2CardKt$CountdownCard$4$1.label = 1;
                        if (DelayKt.delay(200L, (Continuation) splashCountdownV2CardKt$CountdownCard$4$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        splashCountdownV2CardKt$CountdownCard$4$1.$timeLeft$delegate.setLongValue(RangesKt.coerceAtLeast(splashCountdownV2CardKt$CountdownCard$4$1.$activityStartTime - (System.currentTimeMillis() / 1000), 0L));
                        CountdownCard_wBJOh4Y$lambda$12 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$1(splashCountdownV2CardKt$CountdownCard$4$1.$timeLeft$delegate);
                        if (CountdownCard_wBJOh4Y$lambda$12 <= 0) {
                            SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$5(splashCountdownV2CardKt$CountdownCard$4$1.$playAlpha$delegate, true);
                            return Unit.INSTANCE;
                        }
                        CountdownCard_wBJOh4Y$lambda$1 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$1(splashCountdownV2CardKt$CountdownCard$4$1.$timeLeft$delegate);
                        if (CountdownCard_wBJOh4Y$lambda$1 > 0) {
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                splashCountdownV2CardKt$CountdownCard$4$1 = this;
                splashCountdownV2CardKt$CountdownCard$4$1.$timeLeft$delegate.setLongValue(RangesKt.coerceAtLeast(splashCountdownV2CardKt$CountdownCard$4$1.$activityStartTime - (System.currentTimeMillis() / 1000), 0L));
                CountdownCard_wBJOh4Y$lambda$12 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$1(splashCountdownV2CardKt$CountdownCard$4$1.$timeLeft$delegate);
                if (CountdownCard_wBJOh4Y$lambda$12 <= 0) {
                }
                CountdownCard_wBJOh4Y$lambda$1 = SplashCountdownV2CardKt.CountdownCard_wBJOh4Y$lambda$1(splashCountdownV2CardKt$CountdownCard$4$1.$timeLeft$delegate);
                if (CountdownCard_wBJOh4Y$lambda$1 > 0) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}