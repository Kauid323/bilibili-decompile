package kntr.app.im.chat.sticker.manage;

import androidx.compose.runtime.State;
import kntr.app.im.chat.sticker.model.StickerAction;
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
/* compiled from: StickerManagerPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.manage.StickerManagerPageKt$StickerManagerPage$5$3$1$1", f = "StickerManagerPage.kt", i = {}, l = {291, 294}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerManagerPageKt$StickerManagerPage$5$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function2<StickerAction, Continuation<? super Unit>, Object>> $dispatchAction;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerPageKt$StickerManagerPage$5$3$1$1(State<? extends Function2<? super StickerAction, ? super Continuation<? super Unit>, ? extends Object>> state, Continuation<? super StickerManagerPageKt$StickerManagerPage$5$3$1$1> continuation) {
        super(2, continuation);
        this.$dispatchAction = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagerPageKt$StickerManagerPage$5$3$1$1(this.$dispatchAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        StickerAction.DeleteSelectedStickers deleteSelectedStickers;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StickerAction.ShowConfirmDeleteDialog showConfirmDeleteDialog = new StickerAction.ShowConfirmDeleteDialog(false);
                this.label = 1;
                if (((Function2) this.$dispatchAction.getValue()).invoke(showConfirmDeleteDialog, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deleteSelectedStickers = StickerAction.DeleteSelectedStickers.INSTANCE;
                this.label = 2;
                if (((Function2) this.$dispatchAction.getValue()).invoke(deleteSelectedStickers, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                deleteSelectedStickers = StickerAction.DeleteSelectedStickers.INSTANCE;
                this.label = 2;
                if (((Function2) this.$dispatchAction.getValue()).invoke(deleteSelectedStickers, this) == coroutine_suspended) {
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