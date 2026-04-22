package kntr.app.im.chat.ui.widget;

import java.util.List;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
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
/* compiled from: ChatBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.widget.ChatBottomSheetKt$PictureContent$5$6$1$1", f = "ChatBottomSheet.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatBottomSheetKt$PictureContent$5$6$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ AphroAssetsState.AphroContent $assetsState;
    final /* synthetic */ int $index;
    final /* synthetic */ List<PreviewableAsset> $totalDataSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBottomSheetKt$PictureContent$5$6$1$1(ChatActionHandler chatActionHandler, List<? extends PreviewableAsset> list, int i, AphroAssetsState.AphroContent aphroContent, Continuation<? super ChatBottomSheetKt$PictureContent$5$6$1$1> continuation) {
        super(2, continuation);
        this.$actionHandler = chatActionHandler;
        this.$totalDataSource = list;
        this.$index = i;
        this.$assetsState = aphroContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBottomSheetKt$PictureContent$5$6$1$1(this.$actionHandler, this.$totalDataSource, this.$index, this.$assetsState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ChatActionHandler chatActionHandler = this.$actionHandler;
                List<PreviewableAsset> list = this.$totalDataSource;
                int i = this.$index;
                AlbumInfo albumInfo = this.$assetsState.getAlbumInfo();
                String id = albumInfo != null ? albumInfo.getId() : null;
                this.label = 1;
                if (chatActionHandler.invoke(new ChatAction.BottomSheetImagePreviewClicked(list, i, id), (Continuation) this) == coroutine_suspended) {
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