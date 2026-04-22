package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: Translation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.localization.Translation$_alwaysTranslateFlow$1$2", f = "Translation.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class Translation$_alwaysTranslateFlow$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableStateFlow<Boolean> $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Translation$_alwaysTranslateFlow$1$2(MutableStateFlow<Boolean> mutableStateFlow, Continuation<? super Translation$_alwaysTranslateFlow$1$2> continuation) {
        super(2, continuation);
        this.$this_apply = mutableStateFlow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Translation$_alwaysTranslateFlow$1$2(this.$this_apply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StateFlow<Locale> localeFlow = Localization.INSTANCE.getLocaleFlow();
                final MutableStateFlow<Boolean> mutableStateFlow = this.$this_apply;
                this.label = 1;
                if (localeFlow.collect(new FlowCollector() { // from class: kntr.base.localization.Translation$_alwaysTranslateFlow$1$2.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Locale) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Locale it, Continuation<? super Unit> continuation) {
                        mutableStateFlow.setValue(Boxing.boxBoolean(TranslationKt.allowAlwaysTranslate$default(false, it, 1, null)));
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}