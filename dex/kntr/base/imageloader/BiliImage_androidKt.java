package kntr.base.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.image2.BiliImageGlobalConfigHolder;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.DrawableAcquireRequestBuilder;
import com.bilibili.lib.image2.ImageMeasureBuilder;
import com.bilibili.lib.image2.ImageRequiredTypeBuilder;
import com.bilibili.lib.image2.bean.DrawableHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.Arrays;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BiliImage.android.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\u00020\r¢\u0006\u0002\u0010\u000e\u001a \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u000b*\u00020\r2\u0006\u0010\u0010\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0011\u001a \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000b*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015\u001a \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u000b*\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015\u001a\u000e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a8\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u000b*\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u0017\u001a\u00020\u00142\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010 \u001a\u000e\u0010!\u001a\u0004\u0018\u00010\f*\u00020\"H\u0002\u001a\f\u0010#\u001a\u00020\u0001*\u00020\rH\u0002¨\u0006$"}, d2 = {"disableAvif", "", "canUseAnimationPainter", "loadImage", "Lkntr/base/imageloader/ImageSource;", "request", "Lkntr/base/imageloader/ImmutableImageRequest;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lkntr/base/imageloader/ImmutableImageRequest;Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseImageFormat", "Lkotlin/Result;", "Lkntr/base/imageloader/SupportImageType;", "", "([B)Ljava/lang/Object;", "transformImageType", "imageType", "([BLkntr/base/imageloader/SupportImageType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sampleImage", "inSampleSize", "", "([BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compressImage", "quality", "inMemoryCache", "rotateBitmapByExif", "Landroid/graphics/Bitmap;", "options", "Landroid/graphics/BitmapFactory$Options;", "compress", "targetFormat", "Landroid/graphics/Bitmap$CompressFormat;", "(Landroid/graphics/Bitmap;Landroid/graphics/BitmapFactory$Options;ILandroid/graphics/Bitmap$CompressFormat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mimeToSupportImageType", "", "checkAnimWebp", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliImage_androidKt {

    /* compiled from: BiliImage.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SupportImageType.values().length];
            try {
                iArr[SupportImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SupportImageType.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SupportImageType.JPG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean disableAvif() {
        return (BiliImageGlobalConfigHolder.INSTANCE.getEnableAvif() && !BiliImageGlobalConfigHolder.INSTANCE.getDegradeAvif() && BiliImageGlobalConfigHolder.INSTANCE.getAllowAvifDecode()) ? false : true;
    }

    public static final boolean canUseAnimationPainter() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object loadImage(ImmutableImageRequest request, Lifecycle lifecycle, Continuation<? super ImageSource> continuation) {
        Continuation $continuation;
        ImmutableImageRequest request2;
        ImageRequiredTypeBuilder useRaw;
        String str;
        Lifecycle lifecycle2;
        Ref.ObjectRef error;
        if (continuation instanceof BiliImage_androidKt$loadImage$1) {
            $continuation = (BiliImage_androidKt$loadImage$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Ref.ObjectRef error2 = new Ref.ObjectRef();
                        request2 = request;
                        $continuation.L$0 = request2;
                        $continuation.L$1 = lifecycle;
                        $continuation.L$2 = error2;
                        $continuation.I$0 = 0;
                        $continuation.label = 1;
                        Continuation uCont$iv = $continuation;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        final CancellableContinuation coroutine = cancellableContinuationImpl;
                        ImageMeasureBuilder scope = BiliImageLoader.INSTANCE.acquire(FoundationAlias.getFapp(), lifecycle == null ? new GlobalLifeCycle() : lifecycle);
                        if (request.getOptions$imageloader_debug().getUseRaw()) {
                            useRaw = scope.useRaw();
                        } else if (request.isNet()) {
                            useRaw = scope.useRaw();
                        } else if (request.getOptions$imageloader_debug().getResizeOption() != null) {
                            useRaw = scope.with(request.getProtocol$imageloader_debug().m1427getWidthuhUG8m8$imageloader_debug(), request.getProtocol$imageloader_debug().m1422getHeightuhUG8m8$imageloader_debug());
                        } else {
                            useRaw = scope.useRaw();
                        }
                        DrawableAcquireRequestBuilder $this$loadImage_u24lambda_u240_u241 = useRaw.asDrawable().enableAnimatable(request.getOptions$imageloader_debug().m1436getAnimateLoopCountv08qk(), Boxing.boxBoolean(true));
                        ResizeOption option = request.getOptions$imageloader_debug().getResizeOption();
                        if (option != null) {
                            if (Intrinsics.areEqual(option, ResizeOption.Companion.getAUTO())) {
                                $this$loadImage_u24lambda_u240_u241.resizeOption(new com.bilibili.lib.image2.bean.ResizeOption(request.getProtocol$imageloader_debug().m1427getWidthuhUG8m8$imageloader_debug(), request.getProtocol$imageloader_debug().m1422getHeightuhUG8m8$imageloader_debug()));
                            } else {
                                $this$loadImage_u24lambda_u240_u241.resizeOption(new com.bilibili.lib.image2.bean.ResizeOption(option.m1563getWidthuhUG8m8(), option.m1562getHeightuhUG8m8()));
                            }
                        }
                        String url = request.takeImageUrl();
                        if (StringsKt.startsWith$default(url, "file:///android_asset/", false, 2, (Object) null)) {
                            str = StringsKt.replace$default(url, "file:///android_asset/", "asset://android_asset/", false, 4, (Object) null);
                        } else {
                            str = url;
                        }
                        final ImageDataSource dataSource = $this$loadImage_u24lambda_u240_u241.url(str).submit();
                        dataSource.subscribe(new ImageDataSubscriber<DrawableHolder>() { // from class: kntr.base.imageloader.BiliImage_androidKt$loadImage$originSource$1$1
                            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource) {
                                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource);
                            }

                            public void onResult(ImageDataSource<DrawableHolder> imageDataSource) {
                                Result.Companion companion = Result.Companion;
                                coroutine.resumeWith(Result.m2636constructorimpl(imageDataSource));
                            }

                            public void onFailure(ImageDataSource<DrawableHolder> imageDataSource) {
                                error2.element = new ImageException("require image failed", imageDataSource != null ? imageDataSource.getFailureCause() : null);
                                Result.Companion companion = Result.Companion;
                                coroutine.resumeWith(Result.m2636constructorimpl(imageDataSource));
                            }

                            public void onCancellation(ImageDataSource<DrawableHolder> imageDataSource) {
                                error2.element = new ImageException("require image cancel", imageDataSource != null ? imageDataSource.getFailureCause() : null);
                                Result.Companion companion = Result.Companion;
                                coroutine.resumeWith(Result.m2636constructorimpl(imageDataSource));
                            }
                        });
                        coroutine.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kntr.base.imageloader.BiliImage_androidKt$loadImage$originSource$1$2
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                dataSource.close();
                                KLog_androidKt.getKLog().d(ApiKt.TAG, "close image dataSource");
                            }
                        });
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($continuation);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = result;
                        lifecycle2 = lifecycle;
                        error = error2;
                        ImageDataSource originSource = (ImageDataSource) $result;
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(lifecycle2);
                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(error);
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable(originSource);
                        $continuation.label = 2;
                        $result = BuildersKt.withContext(Dispatchers.getDefault(), new BiliImage_androidKt$loadImage$2(originSource, error, request2, null), $continuation);
                        return $result != coroutine_suspended ? coroutine_suspended : $result;
                    case 1:
                        int i = $continuation.I$0;
                        error = (Ref.ObjectRef) $continuation.L$2;
                        lifecycle2 = (Lifecycle) $continuation.L$1;
                        request2 = (ImmutableImageRequest) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        ImageDataSource originSource2 = (ImageDataSource) $result;
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(lifecycle2);
                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(error);
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable(originSource2);
                        $continuation.label = 2;
                        $result = BuildersKt.withContext(Dispatchers.getDefault(), new BiliImage_androidKt$loadImage$2(originSource2, error, request2, null), $continuation);
                        if ($result != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        ImageDataSource imageDataSource = (ImageDataSource) $continuation.L$3;
                        Ref.ObjectRef objectRef = (Ref.ObjectRef) $continuation.L$2;
                        Lifecycle lifecycle3 = (Lifecycle) $continuation.L$1;
                        ImmutableImageRequest immutableImageRequest = (ImmutableImageRequest) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        $continuation = new BiliImage_androidKt$loadImage$1(continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
    }

    public static /* synthetic */ Object loadImage$default(ImmutableImageRequest immutableImageRequest, Lifecycle lifecycle, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            lifecycle = null;
        }
        return loadImage(immutableImageRequest, lifecycle, continuation);
    }

    public static final Object parseImageFormat(byte[] $this$parseImageFormat) {
        Intrinsics.checkNotNullParameter($this$parseImageFormat, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray($this$parseImageFormat, 0, $this$parseImageFormat.length, options);
            String it = options.outMimeType;
            if (it != null) {
                SupportImageType imageType = mimeToSupportImageType(it);
                if (imageType == SupportImageType.WEBP && checkAnimWebp($this$parseImageFormat)) {
                    Result.Companion companion2 = Result.Companion;
                    return Result.m2636constructorimpl(SupportImageType.WEBP_ANIM);
                } else if (imageType == null) {
                    Result.Companion companion3 = Result.Companion;
                    return Result.m2636constructorimpl(ResultKt.createFailure(new Exception("mimeToSupportImageType not support")));
                } else {
                    Result.Companion companion4 = Result.Companion;
                    return Result.m2636constructorimpl(imageType);
                }
            }
            Result.Companion companion5 = Result.Companion;
            return Result.m2636constructorimpl(ResultKt.createFailure(new Exception("outMimeType not support")));
        } catch (Throwable th) {
            Result.Companion companion6 = Result.Companion;
            return Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object transformImageType(byte[] $this$transformImageType, SupportImageType imageType, Continuation<? super Result<byte[]>> continuation) {
        BiliImage_androidKt$transformImageType$1 biliImage_androidKt$transformImageType$1;
        Bitmap.CompressFormat targetFormat;
        if (continuation instanceof BiliImage_androidKt$transformImageType$1) {
            biliImage_androidKt$transformImageType$1 = (BiliImage_androidKt$transformImageType$1) continuation;
            if ((biliImage_androidKt$transformImageType$1.label & Integer.MIN_VALUE) != 0) {
                biliImage_androidKt$transformImageType$1.label -= Integer.MIN_VALUE;
                Object $result = biliImage_androidKt$transformImageType$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (biliImage_androidKt$transformImageType$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BitmapFactory.Options $this$transformImageType_u24lambda_u240 = new BitmapFactory.Options();
                        $this$transformImageType_u24lambda_u240.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        switch (WhenMappings.$EnumSwitchMapping$0[imageType.ordinal()]) {
                            case 1:
                                targetFormat = Bitmap.CompressFormat.WEBP;
                                break;
                            case 2:
                                targetFormat = Bitmap.CompressFormat.PNG;
                                break;
                            case 3:
                                targetFormat = Bitmap.CompressFormat.JPEG;
                                break;
                            default:
                                Result.Companion companion = Result.Companion;
                                return Result.m2636constructorimpl(ResultKt.createFailure(new Exception("not support")));
                        }
                        Bitmap rotateBitmapByExif = rotateBitmapByExif($this$transformImageType, $this$transformImageType_u24lambda_u240);
                        biliImage_androidKt$transformImageType$1.L$0 = SpillingKt.nullOutSpilledVariable($this$transformImageType);
                        biliImage_androidKt$transformImageType$1.L$1 = SpillingKt.nullOutSpilledVariable(imageType);
                        biliImage_androidKt$transformImageType$1.L$2 = SpillingKt.nullOutSpilledVariable($this$transformImageType_u24lambda_u240);
                        biliImage_androidKt$transformImageType$1.L$3 = SpillingKt.nullOutSpilledVariable(targetFormat);
                        biliImage_androidKt$transformImageType$1.label = 1;
                        Object compress$default = compress$default(rotateBitmapByExif, $this$transformImageType_u24lambda_u240, 0, targetFormat, biliImage_androidKt$transformImageType$1, 2, null);
                        return compress$default == coroutine_suspended ? coroutine_suspended : compress$default;
                    case 1:
                        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) biliImage_androidKt$transformImageType$1.L$3;
                        BitmapFactory.Options options = (BitmapFactory.Options) biliImage_androidKt$transformImageType$1.L$2;
                        SupportImageType supportImageType = (SupportImageType) biliImage_androidKt$transformImageType$1.L$1;
                        byte[] bArr = (byte[]) biliImage_androidKt$transformImageType$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).m2645unboximpl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        biliImage_androidKt$transformImageType$1 = new BiliImage_androidKt$transformImageType$1(continuation);
        Object $result2 = biliImage_androidKt$transformImageType$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (biliImage_androidKt$transformImageType$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object sampleImage(byte[] $this$sampleImage, int inSampleSize, Continuation<? super Result<byte[]>> continuation) {
        BiliImage_androidKt$sampleImage$1 biliImage_androidKt$sampleImage$1;
        Object m2636constructorimpl;
        Object compress$default;
        BitmapFactory.Options options;
        Ref.ObjectRef bitmap;
        if (continuation instanceof BiliImage_androidKt$sampleImage$1) {
            biliImage_androidKt$sampleImage$1 = (BiliImage_androidKt$sampleImage$1) continuation;
            if ((biliImage_androidKt$sampleImage$1.label & Integer.MIN_VALUE) != 0) {
                biliImage_androidKt$sampleImage$1.label -= Integer.MIN_VALUE;
                Object $result = biliImage_androidKt$sampleImage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (biliImage_androidKt$sampleImage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BitmapFactory.Options $this$sampleImage_u24lambda_u240 = new BitmapFactory.Options();
                        $this$sampleImage_u24lambda_u240.inSampleSize = inSampleSize;
                        Ref.ObjectRef bitmap2 = new Ref.ObjectRef();
                        try {
                            Result.Companion companion = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(rotateBitmapByExif($this$sampleImage, $this$sampleImage_u24lambda_u240));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                        }
                        if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            bitmap2.element = (Bitmap) m2636constructorimpl;
                        }
                        Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                        if (it != null) {
                            Result.Companion companion3 = Result.Companion;
                            return Result.m2636constructorimpl(ResultKt.createFailure(it));
                        }
                        Bitmap bitmap3 = (Bitmap) bitmap2.element;
                        if (bitmap3 == null) {
                            Result.Companion companion4 = Result.Companion;
                            return Result.m2636constructorimpl(ResultKt.createFailure(new Exception("sample image failed")));
                        }
                        biliImage_androidKt$sampleImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$sampleImage);
                        biliImage_androidKt$sampleImage$1.L$1 = SpillingKt.nullOutSpilledVariable($this$sampleImage_u24lambda_u240);
                        biliImage_androidKt$sampleImage$1.L$2 = SpillingKt.nullOutSpilledVariable(bitmap2);
                        biliImage_androidKt$sampleImage$1.I$0 = inSampleSize;
                        biliImage_androidKt$sampleImage$1.label = 1;
                        compress$default = compress$default(bitmap3, $this$sampleImage_u24lambda_u240, 0, null, biliImage_androidKt$sampleImage$1, 6, null);
                        if (compress$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        options = $this$sampleImage_u24lambda_u240;
                        bitmap = bitmap2;
                        break;
                    case 1:
                        int inSampleSize2 = biliImage_androidKt$sampleImage$1.I$0;
                        bitmap = (Ref.ObjectRef) biliImage_androidKt$sampleImage$1.L$2;
                        options = (BitmapFactory.Options) biliImage_androidKt$sampleImage$1.L$1;
                        byte[] bArr = (byte[]) biliImage_androidKt$sampleImage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        compress$default = ((Result) $result).m2645unboximpl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return compress$default;
            }
        }
        biliImage_androidKt$sampleImage$1 = new BiliImage_androidKt$sampleImage$1(continuation);
        Object $result2 = biliImage_androidKt$sampleImage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (biliImage_androidKt$sampleImage$1.label) {
        }
        return compress$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object compressImage(byte[] $this$compressImage, int quality, Continuation<? super Result<byte[]>> continuation) {
        BiliImage_androidKt$compressImage$1 biliImage_androidKt$compressImage$1;
        if (continuation instanceof BiliImage_androidKt$compressImage$1) {
            biliImage_androidKt$compressImage$1 = (BiliImage_androidKt$compressImage$1) continuation;
            if ((biliImage_androidKt$compressImage$1.label & Integer.MIN_VALUE) != 0) {
                biliImage_androidKt$compressImage$1.label -= Integer.MIN_VALUE;
                Object $result = biliImage_androidKt$compressImage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (biliImage_androidKt$compressImage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BitmapFactory.Options $this$compressImage_u24lambda_u240 = new BitmapFactory.Options();
                        $this$compressImage_u24lambda_u240.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        Bitmap bitmap = rotateBitmapByExif($this$compressImage, $this$compressImage_u24lambda_u240);
                        biliImage_androidKt$compressImage$1.L$0 = SpillingKt.nullOutSpilledVariable($this$compressImage);
                        biliImage_androidKt$compressImage$1.L$1 = SpillingKt.nullOutSpilledVariable($this$compressImage_u24lambda_u240);
                        biliImage_androidKt$compressImage$1.L$2 = SpillingKt.nullOutSpilledVariable(bitmap);
                        biliImage_androidKt$compressImage$1.I$0 = quality;
                        biliImage_androidKt$compressImage$1.label = 1;
                        Object compress$default = compress$default(bitmap, $this$compressImage_u24lambda_u240, quality, null, biliImage_androidKt$compressImage$1, 4, null);
                        return compress$default == coroutine_suspended ? coroutine_suspended : compress$default;
                    case 1:
                        int quality2 = biliImage_androidKt$compressImage$1.I$0;
                        Bitmap bitmap2 = (Bitmap) biliImage_androidKt$compressImage$1.L$2;
                        BitmapFactory.Options options = (BitmapFactory.Options) biliImage_androidKt$compressImage$1.L$1;
                        byte[] bArr = (byte[]) biliImage_androidKt$compressImage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return ((Result) $result).m2645unboximpl();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        biliImage_androidKt$compressImage$1 = new BiliImage_androidKt$compressImage$1(continuation);
        Object $result2 = biliImage_androidKt$compressImage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (biliImage_androidKt$compressImage$1.label) {
        }
    }

    public static final boolean inMemoryCache(ImmutableImageRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return BiliImageLoaderHelper.isInBitmapMemoryCache(request.takeImageUrl());
    }

    private static final Bitmap rotateBitmapByExif(byte[] $this$rotateBitmapByExif, BitmapFactory.Options options) {
        try {
            Result.Companion companion = Result.Companion;
            ExifInterface exif = new ExifInterface(new ByteArrayInputStream($this$rotateBitmapByExif));
            int orientation = exif.getAttributeInt("Orientation", 0);
            Bitmap originalBitmap = BitmapFactory.decodeByteArray($this$rotateBitmapByExif, 0, $this$rotateBitmapByExif.length, options);
            Matrix matrix = new Matrix();
            switch (orientation) {
                case 2:
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    break;
                case 4:
                    matrix.postScale(1.0f, -1.0f);
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    break;
                case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                    matrix.postRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 8:
                    matrix.postRotate(270.0f);
                    break;
            }
            Bitmap rotatedBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth(), originalBitmap.getHeight(), matrix, true);
            Intrinsics.checkNotNullExpressionValue(rotatedBitmap, "createBitmap(...)");
            if (rotatedBitmap != originalBitmap) {
                originalBitmap.recycle();
            }
            return rotatedBitmap;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable it = Result.m2639exceptionOrNullimpl(Result.m2636constructorimpl(ResultKt.createFailure(th)));
            if (it != null) {
                KLog_androidKt.getKLog().e(ApiKt.TAG, "rotateBitmapByExif failed: " + it.getMessage());
                return null;
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object compress(Bitmap $this$compress, BitmapFactory.Options options, int quality, Bitmap.CompressFormat targetFormat, Continuation<? super Result<byte[]>> continuation) {
        BiliImage_androidKt$compress$1 biliImage_androidKt$compress$1;
        BiliImage_androidKt$compress$1 biliImage_androidKt$compress$12;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        BitmapFactory.Options options2;
        Bitmap.CompressFormat compressFormat;
        Object withContext;
        BitmapFactory.Options options3;
        if (continuation instanceof BiliImage_androidKt$compress$1) {
            biliImage_androidKt$compress$1 = (BiliImage_androidKt$compress$1) continuation;
            if ((biliImage_androidKt$compress$1.label & Integer.MIN_VALUE) != 0) {
                biliImage_androidKt$compress$1.label -= Integer.MIN_VALUE;
                biliImage_androidKt$compress$12 = biliImage_androidKt$compress$1;
                Object $result = biliImage_androidKt$compress$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (biliImage_androidKt$compress$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if ($this$compress == null) {
                            Result.Companion companion = Result.Companion;
                            return Result.m2636constructorimpl(ResultKt.createFailure(new NullPointerException("bitmap is null")));
                        }
                        try {
                            Result.Companion companion2 = Result.Companion;
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                ByteArrayOutputStream it = byteArrayOutputStream;
                                if (targetFormat == null) {
                                    options2 = options;
                                    try {
                                        String str = options2.outMimeType;
                                        if (str != null) {
                                            switch (str.hashCode()) {
                                                case -1487394660:
                                                    if (!str.equals("image/jpeg")) {
                                                        break;
                                                    } else {
                                                        compressFormat = Bitmap.CompressFormat.JPEG;
                                                        break;
                                                    }
                                                case -1487018032:
                                                    if (str.equals("image/webp")) {
                                                        compressFormat = Bitmap.CompressFormat.WEBP;
                                                        break;
                                                    }
                                                    break;
                                                case -879258763:
                                                    if (!str.equals("image/png")) {
                                                        break;
                                                    } else {
                                                        compressFormat = Bitmap.CompressFormat.PNG;
                                                        break;
                                                    }
                                            }
                                        }
                                        Result.Companion companion3 = Result.Companion;
                                        Object m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(new Exception("not support")));
                                        try {
                                            CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                                            return m2636constructorimpl;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            Result.Companion companion4 = Result.Companion;
                                            return Result.m2636constructorimpl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        th = th;
                                        try {
                                            throw th;
                                        } catch (Throwable th4) {
                                            try {
                                                CloseableKt.closeFinally(byteArrayOutputStream, th);
                                                throw th4;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                Result.Companion companion42 = Result.Companion;
                                                return Result.m2636constructorimpl(ResultKt.createFailure(th));
                                            }
                                        }
                                    }
                                }
                                options2 = options;
                                compressFormat = targetFormat;
                                try {
                                    CoroutineContext io = Dispatchers.getIO();
                                    BiliImage_androidKt$compress$2$1$1 biliImage_androidKt$compress$2$1$1 = new BiliImage_androidKt$compress$2$1$1($this$compress, compressFormat, quality, it, null);
                                    biliImage_androidKt$compress$12.L$0 = SpillingKt.nullOutSpilledVariable($this$compress);
                                    biliImage_androidKt$compress$12.L$1 = SpillingKt.nullOutSpilledVariable(options);
                                    biliImage_androidKt$compress$12.L$2 = SpillingKt.nullOutSpilledVariable(targetFormat);
                                    biliImage_androidKt$compress$12.L$3 = SpillingKt.nullOutSpilledVariable($this$compress);
                                    biliImage_androidKt$compress$12.L$4 = byteArrayOutputStream;
                                    biliImage_androidKt$compress$12.L$5 = SpillingKt.nullOutSpilledVariable(it);
                                    biliImage_androidKt$compress$12.L$6 = SpillingKt.nullOutSpilledVariable(compressFormat);
                                    try {
                                        biliImage_androidKt$compress$12.I$0 = quality;
                                        biliImage_androidKt$compress$12.I$1 = 0;
                                        biliImage_androidKt$compress$12.I$2 = 0;
                                        biliImage_androidKt$compress$12.label = 1;
                                        withContext = BuildersKt.withContext(io, biliImage_androidKt$compress$2$1$1, biliImage_androidKt$compress$12);
                                        if (withContext == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        options3 = options2;
                                        try {
                                            Object m2645unboximpl = ((Result) withContext).m2645unboximpl();
                                            try {
                                                CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                                                return m2645unboximpl;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                Result.Companion companion422 = Result.Companion;
                                                return Result.m2636constructorimpl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            throw th;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        th = th;
                                        throw th;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    th = th;
                                    throw th;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                        }
                        break;
                    case 1:
                        int i = biliImage_androidKt$compress$12.I$2;
                        int i2 = biliImage_androidKt$compress$12.I$1;
                        int i3 = biliImage_androidKt$compress$12.I$0;
                        Bitmap.CompressFormat compressFormat2 = (Bitmap.CompressFormat) biliImage_androidKt$compress$12.L$6;
                        ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) biliImage_androidKt$compress$12.L$5;
                        byteArrayOutputStream = (Closeable) biliImage_androidKt$compress$12.L$4;
                        Bitmap bitmap = (Bitmap) biliImage_androidKt$compress$12.L$3;
                        Bitmap.CompressFormat compressFormat3 = (Bitmap.CompressFormat) biliImage_androidKt$compress$12.L$2;
                        options3 = (BitmapFactory.Options) biliImage_androidKt$compress$12.L$1;
                        Bitmap bitmap2 = (Bitmap) biliImage_androidKt$compress$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            withContext = $result;
                            Object m2645unboximpl2 = ((Result) withContext).m2645unboximpl();
                            CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                            return m2645unboximpl2;
                        } catch (Throwable th12) {
                            th = th12;
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        biliImage_androidKt$compress$1 = new BiliImage_androidKt$compress$1(continuation);
        biliImage_androidKt$compress$12 = biliImage_androidKt$compress$1;
        Object $result2 = biliImage_androidKt$compress$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (biliImage_androidKt$compress$12.label) {
        }
    }

    static /* synthetic */ Object compress$default(Bitmap bitmap, BitmapFactory.Options options, int i, Bitmap.CompressFormat compressFormat, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            compressFormat = null;
        }
        return compress(bitmap, options, i, compressFormat, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x001a, code lost:
        if (r1.equals("image/jpg") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x003a, code lost:
        if (r1.equals("image/jpeg") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return kntr.base.imageloader.SupportImageType.JPG;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final SupportImageType mimeToSupportImageType(String $this$mimeToSupportImageType) {
        switch ($this$mimeToSupportImageType.hashCode()) {
            case -1487656890:
                if ($this$mimeToSupportImageType.equals("image/avif")) {
                    return SupportImageType.AVIF;
                }
                return null;
            case -1487394660:
                break;
            case -1487018032:
                if ($this$mimeToSupportImageType.equals("image/webp")) {
                    return SupportImageType.WEBP;
                }
                return null;
            case -879267568:
                if ($this$mimeToSupportImageType.equals("image/gif")) {
                    return SupportImageType.GIF;
                }
                return null;
            case -879264467:
                break;
            case -879258763:
                if ($this$mimeToSupportImageType.equals("image/png")) {
                    return SupportImageType.PNG;
                }
                return null;
            default:
                return null;
        }
    }

    private static final boolean checkAnimWebp(byte[] $this$checkAnimWebp) {
        try {
            Result.Companion companion = Result.Companion;
            byte[] copyOfRange = ArraysKt.copyOfRange($this$checkAnimWebp, 0, 4);
            byte[] bytes = "RIFF".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (Arrays.equals(copyOfRange, bytes)) {
                byte[] copyOfRange2 = ArraysKt.copyOfRange($this$checkAnimWebp, 8, 12);
                byte[] bytes2 = "WEBP".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                if (Arrays.equals(copyOfRange2, bytes2)) {
                    byte[] copyOfRange3 = ArraysKt.copyOfRange($this$checkAnimWebp, 12, 12 + 4);
                    byte[] bytes3 = "VP8X".getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                    if (Arrays.equals(copyOfRange3, bytes3)) {
                        int flags = $this$checkAnimWebp[12 + 8] & UByte.MAX_VALUE;
                        return (flags & 2) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m2636constructorimpl(ResultKt.createFailure(th));
            return false;
        }
    }
}