package tv.danmaku.bili.splash.ad.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bilibili.app.comm.baseres.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.utils.ImageUtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashSlideUnlockView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.widget.SplashSlideUnlockView$showLogo$1", f = "SplashSlideUnlockView.kt", i = {}, l = {BR.followLottieAnimationVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SplashSlideUnlockView$showLogo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    int label;
    final /* synthetic */ SplashSlideUnlockView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashSlideUnlockView$showLogo$1(String str, SplashSlideUnlockView splashSlideUnlockView, Continuation<? super SplashSlideUnlockView$showLogo$1> continuation) {
        super(2, continuation);
        this.$filePath = str;
        this.this$0 = splashSlideUnlockView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashSlideUnlockView$showLogo$1(this.$filePath, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int i;
        int i2;
        ImageView imageView;
        ImageView imageView2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String valueOf = String.valueOf(this.$filePath);
                i = this.this$0.btnSize;
                i2 = this.this$0.btnSize;
                this.label = 1;
                Object decodeBitmap = ImageUtilsKt.decodeBitmap(valueOf, i, i2, (Continuation) this);
                if (decodeBitmap != coroutine_suspended) {
                    $result = decodeBitmap;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Bitmap bm = (Bitmap) $result;
        if (bm == null) {
            imageView2 = this.this$0.slideBtn;
            imageView2.setImageResource(R.drawable.bili_default_image_tv);
        } else {
            imageView = this.this$0.slideBtn;
            imageView.setImageBitmap(bm);
        }
        return Unit.INSTANCE;
    }
}