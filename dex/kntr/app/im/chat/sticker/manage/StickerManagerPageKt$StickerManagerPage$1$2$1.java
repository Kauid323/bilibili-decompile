package kntr.app.im.chat.sticker.manage;

import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.viewModel.StickerManagerViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerPage.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/im/chat/sticker/model/StickerAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerManagerPage$1$2$1", f = "StickerManagerPage.kt", i = {0}, l = {131}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class StickerManagerPageKt$StickerManagerPage$1$2$1 extends SuspendLambda implements Function2<StickerAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ StickerManagerViewModel $stickerViewModel;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerPageKt$StickerManagerPage$1$2$1(StickerManagerViewModel stickerManagerViewModel, Continuation<? super StickerManagerPageKt$StickerManagerPage$1$2$1> continuation) {
        super(2, continuation);
        this.$stickerViewModel = stickerManagerViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stickerManagerPageKt$StickerManagerPage$1$2$1 = new StickerManagerPageKt$StickerManagerPage$1$2$1(this.$stickerViewModel, continuation);
        stickerManagerPageKt$StickerManagerPage$1$2$1.L$0 = obj;
        return stickerManagerPageKt$StickerManagerPage$1$2$1;
    }

    public final Object invoke(StickerAction stickerAction, Continuation<? super Unit> continuation) {
        return create(stickerAction, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        StickerAction it = (StickerAction) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.label = 1;
                if (this.$stickerViewModel.dispatch(it, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}