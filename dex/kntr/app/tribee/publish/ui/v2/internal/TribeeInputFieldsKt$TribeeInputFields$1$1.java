package kntr.app.tribee.publish.ui.v2.internal;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInputFields.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt$TribeeInputFields$1$1", f = "TribeeInputFields.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeInputFieldsKt$TribeeInputFields$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $contentFocused$delegate;
    final /* synthetic */ State<Function1<InputFieldFocus, Unit>> $handleFocusChanged$delegate;
    final /* synthetic */ MutableState<Boolean> $titleFocused$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInputFieldsKt$TribeeInputFields$1$1(State<? extends Function1<? super InputFieldFocus, Unit>> state, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super TribeeInputFieldsKt$TribeeInputFields$1$1> continuation) {
        super(2, continuation);
        this.$handleFocusChanged$delegate = state;
        this.$titleFocused$delegate = mutableState;
        this.$contentFocused$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeInputFieldsKt$TribeeInputFields$1$1(this.$handleFocusChanged$delegate, this.$titleFocused$delegate, this.$contentFocused$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function1 TribeeInputFields$lambda$0;
        boolean TribeeInputFields$lambda$2;
        boolean TribeeInputFields$lambda$5;
        InputFieldFocus inputFieldFocus;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeInputFields$lambda$0 = TribeeInputFieldsKt.TribeeInputFields$lambda$0(this.$handleFocusChanged$delegate);
                TribeeInputFields$lambda$2 = TribeeInputFieldsKt.TribeeInputFields$lambda$2(this.$titleFocused$delegate);
                if (TribeeInputFields$lambda$2) {
                    inputFieldFocus = InputFieldFocus.TITLE;
                } else {
                    TribeeInputFields$lambda$5 = TribeeInputFieldsKt.TribeeInputFields$lambda$5(this.$contentFocused$delegate);
                    inputFieldFocus = TribeeInputFields$lambda$5 ? InputFieldFocus.CONTENT : InputFieldFocus.NONE;
                }
                TribeeInputFields$lambda$0.invoke(inputFieldFocus);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}