package im.session.bottomsheet;

import im.session.common.IMSessionPageState;
import im.session.model.IMThreeDotItem;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMPageBottomSheetMenu.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.bottomsheet.IMPageBottomSheetMenuKt$IMPageBottomSheetMenuItem$1$1$1", f = "IMPageBottomSheetMenu.kt", i = {}, l = {74, 75}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMPageBottomSheetMenuKt$IMPageBottomSheetMenuItem$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMThreeDotItem $item;
    final /* synthetic */ IMSessionPageState $pageState;
    final /* synthetic */ BottomSheetScope $this_IMPageBottomSheetMenuItem;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMPageBottomSheetMenuKt$IMPageBottomSheetMenuItem$1$1$1(IMThreeDotItem iMThreeDotItem, IMSessionPageState iMSessionPageState, BottomSheetScope bottomSheetScope, Continuation<? super IMPageBottomSheetMenuKt$IMPageBottomSheetMenuItem$1$1$1> continuation) {
        super(2, continuation);
        this.$item = iMThreeDotItem;
        this.$pageState = iMSessionPageState;
        this.$this_IMPageBottomSheetMenuItem = bottomSheetScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMPageBottomSheetMenuKt$IMPageBottomSheetMenuItem$1$1$1(this.$item, this.$pageState, this.$this_IMPageBottomSheetMenuItem, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (IMBottomSheetActionKt.onBottomSheetAction(this.$item, this.$pageState, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (this.$this_IMPageBottomSheetMenuItem.dismiss((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (this.$this_IMPageBottomSheetMenuItem.dismiss((Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}