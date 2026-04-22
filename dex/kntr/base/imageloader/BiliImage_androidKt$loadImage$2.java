package kntr.base.imageloader;

import android.graphics.drawable.BitmapDrawable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.ContentScale;
import com.bilibili.lib.image2.bean.BiliAnimatedDrawable;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.facebook.drawee.drawable.OrientedDrawable;
import java.util.Locale;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImage.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/base/imageloader/ImageSource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.imageloader.BiliImage_androidKt$loadImage$2", f = "BiliImage.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliImage_androidKt$loadImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageSource>, Object> {
    final /* synthetic */ Ref.ObjectRef<ImageException> $error;
    final /* synthetic */ ImageDataSource<DrawableHolder> $originSource;
    final /* synthetic */ ImmutableImageRequest $request;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliImage_androidKt$loadImage$2(ImageDataSource<DrawableHolder> imageDataSource, Ref.ObjectRef<ImageException> objectRef, ImmutableImageRequest immutableImageRequest, Continuation<? super BiliImage_androidKt$loadImage$2> continuation) {
        super(2, continuation);
        this.$originSource = imageDataSource;
        this.$error = objectRef;
        this.$request = immutableImageRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliImage_androidKt$loadImage$2(this.$originSource, this.$error, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageSource> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DrawableHolder drawableHolder;
        DrawableHolder drawableHolder2;
        Map extraData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ImageDataSource<DrawableHolder> imageDataSource = this.$originSource;
                String str = null;
                Object imageFormat = (imageDataSource == null || (drawableHolder2 = (DrawableHolder) imageDataSource.getResult()) == null || (extraData = drawableHolder2.getExtraData()) == null) ? null : extraData.get("image_format");
                ImageDataSource<DrawableHolder> imageDataSource2 = this.$originSource;
                OrientedDrawable result = (imageDataSource2 == null || (drawableHolder = (DrawableHolder) imageDataSource2.getResult()) == null) ? null : drawableHolder.get();
                if (result instanceof BitmapDrawable) {
                    final ImageDataSource<DrawableHolder> imageDataSource3 = this.$originSource;
                    return UtilKt.createBitmapSource((BitmapDrawable) result, (ImageException) this.$error.element, new Function0() { // from class: kntr.base.imageloader.BiliImage_androidKt$loadImage$2$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = BiliImage_androidKt$loadImage$2.invokeSuspend$lambda$0(imageDataSource3);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } else if (result instanceof OrientedDrawable) {
                    final ImageDataSource<DrawableHolder> imageDataSource4 = this.$originSource;
                    return UtilKt.createBitmapSource(result, (ImageException) this.$error.element, new Function0() { // from class: kntr.base.imageloader.BiliImage_androidKt$loadImage$2$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = BiliImage_androidKt$loadImage$2.invokeSuspend$lambda$1(imageDataSource4);
                            return invokeSuspend$lambda$1;
                        }
                    });
                } else if (result instanceof BiliAnimatedDrawable) {
                    String str2 = imageFormat instanceof String ? (String) imageFormat : null;
                    if (str2 != null) {
                        str = str2.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                    }
                    if (Intrinsics.areEqual(str, SupportImageType.LOTTIE.getSuffix())) {
                        boolean enableAnimate = this.$request.getOptions$imageloader_debug().getEnableAnimate();
                        ContentScale contentScale = this.$request.getOptions$imageloader_debug().getContentScale();
                        Alignment align = this.$request.getOptions$imageloader_debug().getAlign();
                        ImageException imageException = (ImageException) this.$error.element;
                        final ImageDataSource<DrawableHolder> imageDataSource5 = this.$originSource;
                        return UtilKt.createLottieSource(result, enableAnimate, contentScale, align, imageException, new Function0() { // from class: kntr.base.imageloader.BiliImage_androidKt$loadImage$2$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit invokeSuspend$lambda$2;
                                invokeSuspend$lambda$2 = BiliImage_androidKt$loadImage$2.invokeSuspend$lambda$2(imageDataSource5);
                                return invokeSuspend$lambda$2;
                            }
                        });
                    }
                    boolean enableAnimate2 = this.$request.getOptions$imageloader_debug().getEnableAnimate();
                    ContentScale contentScale2 = this.$request.getOptions$imageloader_debug().getContentScale();
                    Alignment align2 = this.$request.getOptions$imageloader_debug().getAlign();
                    boolean autoPlay = this.$request.getOptions$imageloader_debug().getAutoPlay();
                    ImageException imageException2 = (ImageException) this.$error.element;
                    final ImageDataSource<DrawableHolder> imageDataSource6 = this.$originSource;
                    return UtilKt.createAnimateSource(result, enableAnimate2, contentScale2, align2, autoPlay, imageException2, new Function0() { // from class: kntr.base.imageloader.BiliImage_androidKt$loadImage$2$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit invokeSuspend$lambda$3;
                            invokeSuspend$lambda$3 = BiliImage_androidKt$loadImage$2.invokeSuspend$lambda$3(imageDataSource6);
                            return invokeSuspend$lambda$3;
                        }
                    });
                } else {
                    return new ImageSource((ImageException) this.$error.element, null, 2, null);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(ImageDataSource $originSource) {
        $originSource.close();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(ImageDataSource $originSource) {
        $originSource.close();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(ImageDataSource $originSource) {
        $originSource.close();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3(ImageDataSource $originSource) {
        $originSource.close();
        return Unit.INSTANCE;
    }
}