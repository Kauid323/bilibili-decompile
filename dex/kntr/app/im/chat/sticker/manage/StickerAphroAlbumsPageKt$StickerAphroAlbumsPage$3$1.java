package kntr.app.im.chat.sticker.manage;

import androidx.activity.OnBackPressedDispatcher;
import kntr.app.im.chat.sticker.model.StickerManagerData;
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
@DebugMetadata(c = "kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$3$1", f = "StickerAphroAlbumsPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnBackPressedDispatcher $backHandler;
    final /* synthetic */ StickerManagerData $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$3$1(StickerManagerData stickerManagerData, OnBackPressedDispatcher onBackPressedDispatcher, Continuation<? super StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$3$1> continuation) {
        super(2, continuation);
        this.$state = stickerManagerData;
        this.$backHandler = onBackPressedDispatcher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$3$1(this.$state, this.$backHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$state.getSaved()) {
                    this.$backHandler.onBackPressed();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}