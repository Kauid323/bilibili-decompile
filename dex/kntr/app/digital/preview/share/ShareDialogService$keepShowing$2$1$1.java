package kntr.app.digital.preview.share;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.share.common.ui.ShareMenuEffect;
import kntr.common.share.common.ui.ShareMenuVM;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareDialogService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.share.ShareDialogService$keepShowing$2$1$1", f = "ShareDialogService.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ShareDialogService$keepShowing$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShareMenuVM $viewModel;
    int label;
    final /* synthetic */ ShareDialogService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogService$keepShowing$2$1$1(ShareMenuVM shareMenuVM, ShareDialogService shareDialogService, Continuation<? super ShareDialogService$keepShowing$2$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = shareMenuVM;
        this.this$0 = shareDialogService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareDialogService$keepShowing$2$1$1(this.$viewModel, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow effect = this.$viewModel.getEffect();
                final ShareDialogService shareDialogService = this.this$0;
                this.label = 1;
                if (effect.collect(new FlowCollector() { // from class: kntr.app.digital.preview.share.ShareDialogService$keepShowing$2$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((ShareMenuEffect) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(ShareMenuEffect effect2, Continuation<? super Unit> continuation) {
                        Toaster toaster;
                        if (!(effect2 instanceof ShareMenuEffect.ShowToast)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        String it = ((ShareMenuEffect.ShowToast) effect2).getMessage();
                        if (StringsKt.isBlank(it)) {
                            it = null;
                        }
                        if (it != null) {
                            toaster = ShareDialogService.this.toaster;
                            Toaster.-CC.showToast$default(toaster, it, (ToastDuration) null, 2, (Object) null);
                        }
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