package kntr.app.digital.preview.wallpaper;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImage_androidKt;
import kntr.base.imageloader.Image;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageSource;
import kntr.base.imageloader.StaticImage;
import kntr.base.log.KLog_androidKt;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SetLockscreenWallpaper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.wallpaper.SetLockscreenWallpaper$invoke$2", f = "SetLockscreenWallpaper.kt", i = {1, 1, 1}, l = {38, 63}, m = "invokeSuspend", n = {"imageSource", "bitmap", "result"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class SetLockscreenWallpaper$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $loadingDialogJob;
    final /* synthetic */ String $wallpaperUrl;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SetLockscreenWallpaper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetLockscreenWallpaper$invoke$2(String str, Job job, SetLockscreenWallpaper setLockscreenWallpaper, Continuation<? super SetLockscreenWallpaper$invoke$2> continuation) {
        super(2, continuation);
        this.$wallpaperUrl = str;
        this.$loadingDialogJob = job;
        this.this$0 = setLockscreenWallpaper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SetLockscreenWallpaper$invoke$2(this.$wallpaperUrl, this.$loadingDialogJob, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object loadImage$default;
        ImageBitmap bitmap;
        Toaster toaster;
        DismissRequest dismissRequest;
        Image imageSource;
        Toaster toaster2;
        Toaster toaster3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String $this$asRequest$iv = this.$wallpaperUrl;
                ImageRequest $this$invokeSuspend_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
                $this$invokeSuspend_u24lambda_u240.useOrigin(true);
                this.label = 1;
                loadImage$default = BiliImage_androidKt.loadImage$default($this$invokeSuspend_u24lambda_u240.build(), (Lifecycle) null, (Continuation) this, 2, (Object) null);
                if (loadImage$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Image imageSource2 = ((ImageSource) loadImage$default).getSource();
                Job.DefaultImpls.cancel$default(this.$loadingDialogJob, (CancellationException) null, 1, (Object) null);
                bitmap = !(imageSource2 instanceof StaticImage) ? ((StaticImage) imageSource2).getBitmap() : null;
                if (bitmap != null) {
                    toaster3 = this.this$0.toaster;
                    Toaster.-CC.showToast$default(toaster3, "设置失败，请重试", (ToastDuration) null, 2, (Object) null);
                    KLog_androidKt.getKLog().d("wallpaper", "wallpaper setting failed, drawable is null");
                    return Unit.INSTANCE;
                }
                Object result = WallpaperSetting_androidKt.getSetWallpaper().m1056invokegIAlus(bitmap, true);
                if (Result.isSuccess-impl(result)) {
                    toaster2 = this.this$0.toaster;
                    Toaster.-CC.showToast$default(toaster2, "设置成功", (ToastDuration) null, 2, (Object) null);
                } else {
                    toaster = this.this$0.toaster;
                    Toaster.-CC.showToast$default(toaster, "设置失败，请重试", (ToastDuration) null, 2, (Object) null);
                }
                dismissRequest = this.this$0.dismissRequest;
                dismissRequest.invoke();
                try {
                    this.L$0 = imageSource2;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(bitmap);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    this.label = 2;
                    if (DelayKt.awaitCancellation((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    imageSource = imageSource2;
                    throw new KotlinNothingValueException();
                } catch (Throwable th) {
                    th = th;
                    imageSource = imageSource2;
                    if (imageSource != null) {
                    }
                    throw th;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                loadImage$default = $result;
                Image imageSource22 = ((ImageSource) loadImage$default).getSource();
                Job.DefaultImpls.cancel$default(this.$loadingDialogJob, (CancellationException) null, 1, (Object) null);
                if (!(imageSource22 instanceof StaticImage)) {
                }
                if (bitmap != null) {
                }
                break;
            case 2:
                Object obj = this.L$2;
                ImageBitmap imageBitmap = (ImageBitmap) this.L$1;
                imageSource = (Image) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    throw new KotlinNothingValueException();
                } catch (Throwable th2) {
                    th = th2;
                    if (imageSource != null) {
                        imageSource.close();
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}