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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerAphroAlbumsPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$StickerAlbumsSelectPage$1$1$1$1", f = "StickerAphroAlbumsPage.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerAphroAlbumsPageKt$StickerAlbumsSelectPage$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StickerAction $it;
    final /* synthetic */ StickerManagerViewModel $stickerViewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAphroAlbumsPageKt$StickerAlbumsSelectPage$1$1$1$1(StickerManagerViewModel stickerManagerViewModel, StickerAction stickerAction, Continuation<? super StickerAphroAlbumsPageKt$StickerAlbumsSelectPage$1$1$1$1> continuation) {
        super(2, continuation);
        this.$stickerViewModel = stickerManagerViewModel;
        this.$it = stickerAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerAphroAlbumsPageKt$StickerAlbumsSelectPage$1$1$1$1(this.$stickerViewModel, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$stickerViewModel.dispatch(this.$it, (Continuation) this) == coroutine_suspended) {
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