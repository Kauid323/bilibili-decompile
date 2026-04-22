package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthV2ViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.AuthV2ViewModel$nameWith$1", f = "AuthV2ViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AuthV2ViewModel$nameWith$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ AuthV2ViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV2ViewModel$nameWith$1(String str, AuthV2ViewModel authV2ViewModel, Continuation<? super AuthV2ViewModel$nameWith$1> continuation) {
        super(2, continuation);
        this.$name = str;
        this.this$0 = authV2ViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV2ViewModel$nameWith$1(this.$name, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object prevValue$iv;
        Object nextValue$iv;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (!Intrinsics.areEqual(this.$name, ((AuthState) this.this$0.getState().getValue()).getName().getContent())) {
                    MutableStateFlow $this$update$iv = this.this$0._state;
                    String str = this.$name;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                        AuthState it = (AuthState) prevValue$iv;
                        nextValue$iv = AuthState.copy$default(it, null, null, null, new Content(ContentField.Name, str, null, 4, null), null, null, false, 119, null);
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}