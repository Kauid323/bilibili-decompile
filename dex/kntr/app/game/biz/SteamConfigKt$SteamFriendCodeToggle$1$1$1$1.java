package kntr.app.game.biz;

import androidx.compose.runtime.MutableState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SteamConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.biz.SteamConfigKt$SteamFriendCodeToggle$1$1$1$1", f = "SteamConfig.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SteamConfigKt$SteamFriendCodeToggle$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $localToggleState$delegate;
    final /* synthetic */ boolean $newState;
    final /* synthetic */ Function2<Boolean, Continuation<? super Boolean>, Object> $onToggleChange;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SteamConfigKt$SteamFriendCodeToggle$1$1$1$1(Function2<? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> function2, boolean z, MutableState<Boolean> mutableState, Continuation<? super SteamConfigKt$SteamFriendCodeToggle$1$1$1$1> continuation) {
        super(2, continuation);
        this.$onToggleChange = function2;
        this.$newState = z;
        this.$localToggleState$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SteamConfigKt$SteamFriendCodeToggle$1$1$1$1(this.$onToggleChange, this.$newState, this.$localToggleState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<Boolean, Continuation<? super Boolean>, Object> function2 = this.$onToggleChange;
                Boolean boxBoolean = Boxing.boxBoolean(this.$newState);
                this.label = 1;
                invoke = function2.invoke(boxBoolean, this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                invoke = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean success = ((Boolean) invoke).booleanValue();
        if (!success) {
            SteamConfigKt.SteamFriendCodeToggle$lambda$2(this.$localToggleState$delegate, true ^ this.$newState);
        }
        return Unit.INSTANCE;
    }
}