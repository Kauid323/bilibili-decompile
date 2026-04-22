package kntr.app.im.chat.sticker.manage;

import androidx.compose.runtime.State;
import java.util.List;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerAphroAlbumsPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.manage.StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$2$1", f = "StickerAphroAlbumsPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<StickerAction, Unit>> $onStickerActionEffect$delegate;
    final /* synthetic */ List<Asset> $selectedAssets;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$2$1(List<? extends Asset> list, State<? extends Function1<? super StickerAction, Unit>> state, Continuation<? super StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$2$1> continuation) {
        super(2, continuation);
        this.$selectedAssets = list;
        this.$onStickerActionEffect$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerAphroAlbumsPageKt$StickerAphroAlbumsPage$2$1(this.$selectedAssets, this.$onStickerActionEffect$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function1 StickerAphroAlbumsPage$lambda$4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StickerAphroAlbumsPage$lambda$4 = StickerAphroAlbumsPageKt.StickerAphroAlbumsPage$lambda$4(this.$onStickerActionEffect$delegate);
                List<Asset> list = this.$selectedAssets;
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                StickerAphroAlbumsPage$lambda$4.invoke(new StickerAction.SelectStickerOrUnSelectToSave(list));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}