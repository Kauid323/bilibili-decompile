package kntr.app.tribee.consume.page;

import androidx.compose.runtime.State;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$3$1", f = "TribeeHomePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomePageKt$TribeeHomeContent$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fakeCardResultKey;
    final /* synthetic */ String $insertFakeCardToast;
    final /* synthetic */ State<Function0<Unit>> $latestOnHasUsedFakeCardResultKeyHandler$delegate;
    final /* synthetic */ State<Function1<TribeeHomeStateAction, Unit>> $latestOnStateAction$delegate;
    final /* synthetic */ State<Function1<TribeeHomeUIAction, Unit>> $latestOnUIAction$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomePageKt$TribeeHomeContent$3$1(String str, String str2, State<? extends Function1<? super TribeeHomeStateAction, Unit>> state, State<? extends Function1<? super TribeeHomeUIAction, Unit>> state2, State<? extends Function0<Unit>> state3, Continuation<? super TribeeHomePageKt$TribeeHomeContent$3$1> continuation) {
        super(2, continuation);
        this.$fakeCardResultKey = str;
        this.$insertFakeCardToast = str2;
        this.$latestOnStateAction$delegate = state;
        this.$latestOnUIAction$delegate = state2;
        this.$latestOnHasUsedFakeCardResultKeyHandler$delegate = state3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeHomePageKt$TribeeHomeContent$3$1(this.$fakeCardResultKey, this.$insertFakeCardToast, this.$latestOnStateAction$delegate, this.$latestOnUIAction$delegate, this.$latestOnHasUsedFakeCardResultKeyHandler$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function1 TribeeHomeContent$lambda$3;
        Function0 TribeeHomeContent$lambda$2;
        Function1 TribeeHomeContent$lambda$4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = this.$fakeCardResultKey;
                boolean z = false;
                if (!(str == null || str.length() == 0)) {
                    TribeeHomeContent$lambda$3 = TribeeHomePageKt.TribeeHomeContent$lambda$3(this.$latestOnStateAction$delegate);
                    TribeeHomeContent$lambda$3.invoke(new TribeeHomeStateAction.AwaitPublishResult(this.$fakeCardResultKey));
                    String str2 = this.$insertFakeCardToast;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        TribeeHomeContent$lambda$4 = TribeeHomePageKt.TribeeHomeContent$lambda$4(this.$latestOnUIAction$delegate);
                        TribeeHomeContent$lambda$4.invoke(new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create(this.$insertFakeCardToast)));
                    }
                    TribeeHomeContent$lambda$2 = TribeeHomePageKt.TribeeHomeContent$lambda$2(this.$latestOnHasUsedFakeCardResultKeyHandler$delegate);
                    TribeeHomeContent$lambda$2.invoke();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}