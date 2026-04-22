package kntr.app.digital.preview.wallpaper;

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
/* compiled from: SetHomeWallpaper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.wallpaper.SetHomeWallpaper$invoke$loadingDialogJob$1", f = "SetHomeWallpaper.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SetHomeWallpaper$invoke$loadingDialogJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SetHomeWallpaper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetHomeWallpaper$invoke$loadingDialogJob$1(SetHomeWallpaper setHomeWallpaper, Continuation<? super SetHomeWallpaper$invoke$loadingDialogJob$1> continuation) {
        super(2, continuation);
        this.this$0 = setHomeWallpaper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SetHomeWallpaper$invoke$loadingDialogJob$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        WallpaperDownloadingDialogService wallpaperDownloadingDialogService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                wallpaperDownloadingDialogService = this.this$0.wallpaperDownloadingDialogService;
                this.label = 1;
                if (wallpaperDownloadingDialogService.keepShowing("图片下载中...", (Continuation) this) == coroutine_suspended) {
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