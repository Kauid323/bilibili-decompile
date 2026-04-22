package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AuthV2ViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.AuthV2ViewModel$checkField$1", f = "AuthV2ViewModel.kt", i = {0}, l = {BR.currentEpisodeListIsReversed}, m = "invokeSuspend", n = {"content"}, s = {"L$0"}, v = 1)
public final class AuthV2ViewModel$checkField$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FieldCheckAction $action;
    Object L$0;
    int label;
    final /* synthetic */ AuthV2ViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV2ViewModel$checkField$1(AuthV2ViewModel authV2ViewModel, FieldCheckAction fieldCheckAction, Continuation<? super AuthV2ViewModel$checkField$1> continuation) {
        super(2, continuation);
        this.this$0 = authV2ViewModel;
        this.$action = fieldCheckAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV2ViewModel$checkField$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object prevValue$iv;
        Object nextValue$iv;
        Object $result2;
        Content content;
        Object $result3;
        boolean toBlock;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv2;
        ContentCheckStatus contentCheckStatus;
        Object nextValue$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Content content2 = ((AuthState) this.this$0.getState().getValue()).getContent(this.$action.getField());
                if (content2.getCheckStatus() == ContentCheckStatus.NotChecked) {
                    MutableStateFlow $this$update$iv2 = this.this$0._state;
                    do {
                        prevValue$iv = $this$update$iv2.getValue();
                        AuthState it = (AuthState) prevValue$iv;
                        nextValue$iv = it.updateContent(Content.copy$default(content2, null, null, ContentCheckStatus.Checking, 3, null));
                    } while (!$this$update$iv2.compareAndSet(prevValue$iv, nextValue$iv));
                    this.L$0 = content2;
                    this.label = 1;
                    Object checkContentBlocked = this.this$0.checkContentBlocked(this.$action.getContent(), (Continuation) this);
                    if (checkContentBlocked == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    content = content2;
                    $result3 = checkContentBlocked;
                    toBlock = ((Boolean) $result3).booleanValue();
                    $this$update$iv = this.this$0._state;
                    do {
                        prevValue$iv2 = $this$update$iv.getValue();
                        AuthState authState = (AuthState) prevValue$iv2;
                        if (!toBlock) {
                            contentCheckStatus = ContentCheckStatus.CheckedFailed;
                        } else {
                            contentCheckStatus = ContentCheckStatus.CheckedPass;
                        }
                        nextValue$iv2 = authState.updateContent(Content.copy$default(content, null, null, contentCheckStatus, 3, null));
                    } while (!$this$update$iv.compareAndSet(prevValue$iv2, nextValue$iv2));
                    break;
                }
                break;
            case 1:
                $result3 = $result;
                ResultKt.throwOnFailure($result3);
                $result2 = $result3;
                content = (Content) this.L$0;
                toBlock = ((Boolean) $result3).booleanValue();
                $this$update$iv = this.this$0._state;
                do {
                    prevValue$iv2 = $this$update$iv.getValue();
                    AuthState authState2 = (AuthState) prevValue$iv2;
                    if (!toBlock) {
                    }
                    nextValue$iv2 = authState2.updateContent(Content.copy$default(content, null, null, contentCheckStatus, 3, null));
                } while (!$this$update$iv.compareAndSet(prevValue$iv2, nextValue$iv2));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}