package tv.danmaku.bili.ui.garb.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import com.bilibili.lib.image2.ImageMeasureBuilder;
import com.bilibili.lib.image2.bean.BitmapConfig;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.DecodedImageHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageDataSubscriber;
import com.bilibili.lib.image2.bean.StaticBitmapImageHolder;
import com.bilibili.lib.image2.bean.bitmapTransform.NativeBlurBitmapTransform;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;

/* compiled from: CollectionImageColorHelper.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0010J2\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\n\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0002J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J*\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\b\b\u0000\u0010 *\u00020\u0001*\b\u0012\u0004\u0012\u0002H 0!H\u0086@¢\u0006\u0004\b\"\u0010#J#\u0010$\u001a\u00020%\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0&2\u0006\u0010'\u001a\u0002H ¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020%*\u0006\u0012\u0002\b\u00030&2\u0006\u0010*\u001a\u00020+¨\u0006,"}, d2 = {"Ltv/danmaku/bili/ui/garb/utils/CollectionImageColorHelper;", "", "<init>", "()V", "getColorFromSource", "", "imageMeasureBuilder", "Lcom/bilibili/lib/image2/ImageMeasureBuilder;", "url", "", "defaultColor", "hsbConverter", "Lkotlin/Pair;", "", "width", "height", "(Lcom/bilibili/lib/image2/ImageMeasureBuilder;Ljava/lang/String;ILkotlin/Pair;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getColorFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/Pair;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hsbCovert", "hsb", "", "getHsbColorFromBitmap", "source", "applyThreshold", "", "rect", "Landroid/graphics/Rect;", "await", "Lkotlin/Result;", "T", "Lcom/bilibili/lib/image2/bean/ImageDataSource;", "await-gIAlu-s", "(Lcom/bilibili/lib/image2/bean/ImageDataSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeSafely", "", "Lkotlinx/coroutines/CancellableContinuation;", "value", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeWithExceptionSafely", "exception", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionImageColorHelper {
    public static final int $stable = 0;
    public static final CollectionImageColorHelper INSTANCE = new CollectionImageColorHelper();

    private CollectionImageColorHelper() {
    }

    public static /* synthetic */ Object getColorFromSource$default(CollectionImageColorHelper collectionImageColorHelper, ImageMeasureBuilder imageMeasureBuilder, String str, int i, Pair pair, int i2, int i3, Continuation continuation, int i4, Object obj) {
        int i5;
        int i6;
        if ((i4 & 16) == 0) {
            i5 = i2;
        } else {
            i5 = 60;
        }
        if ((i4 & 32) == 0) {
            i6 = i3;
        } else {
            i6 = 60;
        }
        return collectionImageColorHelper.getColorFromSource(imageMeasureBuilder, str, i, pair, i5, i6, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getColorFromSource(ImageMeasureBuilder imageMeasureBuilder, final String url, int defaultColor, Pair<Float, Float> pair, int width, int height, Continuation<? super Integer> continuation) {
        CollectionImageColorHelper$getColorFromSource$1 collectionImageColorHelper$getColorFromSource$1;
        int defaultColor2;
        Pair hsbConverter;
        Object obj;
        CollectionImageColorHelper collectionImageColorHelper;
        Bitmap bitmap;
        if (continuation instanceof CollectionImageColorHelper$getColorFromSource$1) {
            collectionImageColorHelper$getColorFromSource$1 = (CollectionImageColorHelper$getColorFromSource$1) continuation;
            if ((collectionImageColorHelper$getColorFromSource$1.label & Integer.MIN_VALUE) != 0) {
                collectionImageColorHelper$getColorFromSource$1.label -= Integer.MIN_VALUE;
                Object $result = collectionImageColorHelper$getColorFromSource$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (collectionImageColorHelper$getColorFromSource$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String str = url;
                        if (str == null || StringsKt.isBlank(str)) {
                            return Boxing.boxInt(defaultColor);
                        }
                        int legalWidth = width;
                        int legalHeight = height;
                        if (width <= 0 || height <= 0) {
                            legalWidth = 60;
                            legalHeight = 60;
                        }
                        ImageDataSource submit = imageMeasureBuilder.with(legalWidth, legalHeight).asDecodedImage().url(url).bitmapTransformation(new BitmapTransformation() { // from class: tv.danmaku.bili.ui.garb.utils.CollectionImageColorHelper$getColorFromSource$bitmap$1
                            public /* synthetic */ BitmapConfig generateDestBitmapConfig(Bitmap bitmap2) {
                                return BitmapTransformation.-CC.$default$generateDestBitmapConfig(this, bitmap2);
                            }

                            public void transform(Bitmap bitmap2) {
                                if (bitmap2 != null) {
                                    new NativeBlurBitmapTransform(4, 4, (BitmapTransformation) null).transform(bitmap2);
                                }
                            }

                            public String getCacheKey() {
                                return "blur_url_" + url;
                            }
                        }).submit();
                        collectionImageColorHelper$getColorFromSource$1.L$0 = pair;
                        collectionImageColorHelper$getColorFromSource$1.I$0 = defaultColor;
                        collectionImageColorHelper$getColorFromSource$1.label = 1;
                        Object m1783awaitgIAlus = m1783awaitgIAlus(submit, collectionImageColorHelper$getColorFromSource$1);
                        if (m1783awaitgIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        defaultColor2 = defaultColor;
                        hsbConverter = pair;
                        obj = m1783awaitgIAlus;
                        collectionImageColorHelper = this;
                        break;
                        break;
                    case 1:
                        collectionImageColorHelper = this;
                        defaultColor2 = collectionImageColorHelper$getColorFromSource$1.I$0;
                        hsbConverter = (Pair) collectionImageColorHelper$getColorFromSource$1.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).unbox-impl();
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                StaticBitmapImageHolder staticBitmapImageHolder = (DecodedImageHolder) obj;
                StaticBitmapImageHolder staticBitmapImageHolder2 = !(staticBitmapImageHolder instanceof StaticBitmapImageHolder) ? staticBitmapImageHolder : null;
                bitmap = staticBitmapImageHolder2 == null ? staticBitmapImageHolder2.get() : null;
                if (bitmap == null) {
                    collectionImageColorHelper$getColorFromSource$1.L$0 = null;
                    collectionImageColorHelper$getColorFromSource$1.label = 2;
                    Object colorFromBitmap = collectionImageColorHelper.getColorFromBitmap(bitmap, hsbConverter, defaultColor2, collectionImageColorHelper$getColorFromSource$1);
                    if (colorFromBitmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return colorFromBitmap;
                }
                return Boxing.boxInt(defaultColor2);
            }
        }
        collectionImageColorHelper$getColorFromSource$1 = new CollectionImageColorHelper$getColorFromSource$1(this, continuation);
        Object $result2 = collectionImageColorHelper$getColorFromSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (collectionImageColorHelper$getColorFromSource$1.label) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        StaticBitmapImageHolder staticBitmapImageHolder3 = (DecodedImageHolder) obj;
        if (!(staticBitmapImageHolder3 instanceof StaticBitmapImageHolder)) {
        }
        if (staticBitmapImageHolder2 == null) {
        }
        if (bitmap == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getColorFromBitmap(Bitmap bitmap, Pair<Float, Float> pair, int defaultColor, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CollectionImageColorHelper$getColorFromBitmap$2(defaultColor, bitmap, pair, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int hsbCovert(float[] hsb, Pair<Float, Float> pair) {
        hsb[1] = ((Number) pair.getFirst()).floatValue();
        hsb[2] = ((Number) pair.getSecond()).floatValue();
        return Color.HSVToColor(hsb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] getHsbColorFromBitmap(Bitmap source, boolean applyThreshold, Rect rect) {
        int[] colorBins = new int[36];
        int maxBin = -1;
        float[] sumHue = new float[36];
        float[] sumSat = new float[36];
        float[] sumVal = new float[36];
        float[] hsv = new float[3];
        int i = 0;
        int row = Math.max(0, rect.top);
        int i2 = 1;
        int maxRow = Math.min(rect.bottom, source.getHeight() - 1);
        while (row <= maxRow) {
            int col = Math.max(i, rect.left);
            int maxCol = Math.min(rect.right, source.getWidth() - i2);
            while (col <= maxCol) {
                int c = source.getPixel(col, row);
                Color.colorToHSV(c, hsv);
                if (applyThreshold) {
                    if (hsv[i2] < 0.4f) {
                        hsv[i2] = 0.4f;
                    } else if (hsv[i2] > 0.7d) {
                        hsv[1] = 0.7f;
                    }
                    if (hsv[2] < 0.4f) {
                        hsv[2] = 0.4f;
                    } else if (hsv[2] > 0.7d) {
                        hsv[2] = 0.7f;
                    }
                }
                int bin = (int) Math.floor(hsv[0] / 10.0f);
                sumHue[bin] = sumHue[bin] + hsv[0];
                sumSat[bin] = sumSat[bin] + hsv[1];
                sumVal[bin] = sumVal[bin] + hsv[2];
                colorBins[bin] = colorBins[bin] + 1;
                if (maxBin < 0 || colorBins[bin] > colorBins[maxBin]) {
                    maxBin = bin;
                }
                col++;
                i2 = 1;
            }
            row++;
            i = 0;
            i2 = 1;
        }
        if (maxBin < 0) {
            return null;
        }
        hsv[0] = sumHue[maxBin] / colorBins[maxBin];
        hsv[1] = sumSat[maxBin] / colorBins[maxBin];
        hsv[2] = sumVal[maxBin] / colorBins[maxBin];
        return hsv;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* renamed from: await-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object m1783awaitgIAlus(final ImageDataSource<T> imageDataSource, Continuation<? super Result<? extends T>> continuation) {
        Continuation $continuation;
        Object obj;
        if (continuation instanceof CollectionImageColorHelper$await$1) {
            $continuation = (CollectionImageColorHelper$await$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $continuation.L$0 = imageDataSource;
                        $continuation.label = 1;
                        Continuation uCont$iv = $continuation;
                        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        final CancellableContinuation continuation2 = cancellableContinuationImpl;
                        imageDataSource.subscribe(new ImageDataSubscriber<T>() { // from class: tv.danmaku.bili.ui.garb.utils.CollectionImageColorHelper$await$2$1
                            public /* synthetic */ void onProgressUpdate(ImageDataSource imageDataSource2) {
                                ImageDataSubscriber.-CC.$default$onProgressUpdate(this, imageDataSource2);
                            }

                            public void onResult(ImageDataSource<T> imageDataSource2) {
                                Object result = imageDataSource2 != null ? imageDataSource2.getResult() : null;
                                if (result == null) {
                                    CollectionImageColorHelper collectionImageColorHelper = CollectionImageColorHelper.INSTANCE;
                                    CancellableContinuation<? super T> cancellableContinuation = continuation2;
                                    Result.Companion companion = Result.Companion;
                                    collectionImageColorHelper.resumeSafely(cancellableContinuation, Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new NullPointerException("Null result!")))));
                                    return;
                                }
                                CollectionImageColorHelper collectionImageColorHelper2 = CollectionImageColorHelper.INSTANCE;
                                CancellableContinuation<? super T> cancellableContinuation2 = continuation2;
                                Result.Companion companion2 = Result.Companion;
                                collectionImageColorHelper2.resumeSafely(cancellableContinuation2, Result.box-impl(Result.constructor-impl(result)));
                            }

                            public void onFailure(ImageDataSource<T> imageDataSource2) {
                                RuntimeException it;
                                if (imageDataSource2 == null || (it = imageDataSource2.getFailureCause()) == null) {
                                    it = new RuntimeException("Unknown error.");
                                }
                                CancellableContinuation<? super T> cancellableContinuation = continuation2;
                                CollectionImageColorHelper collectionImageColorHelper = CollectionImageColorHelper.INSTANCE;
                                Result.Companion companion = Result.Companion;
                                collectionImageColorHelper.resumeSafely(cancellableContinuation, Result.box-impl(Result.constructor-impl(ResultKt.createFailure(it))));
                            }

                            public void onCancellation(ImageDataSource<T> imageDataSource2) {
                                if (continuation2.isActive()) {
                                    CollectionImageColorHelper.INSTANCE.resumeWithExceptionSafely(continuation2, new CancellationException());
                                }
                            }
                        });
                        continuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.ui.garb.utils.CollectionImageColorHelper$await$2$2
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                imageDataSource.close();
                            }
                        });
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($continuation);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = result;
                        break;
                    case 1:
                        ImageDataSource imageDataSource2 = (ImageDataSource) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) obj).unbox-impl();
            }
        }
        $continuation = new CollectionImageColorHelper$await$1(this, continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
        return ((Result) obj).unbox-impl();
    }

    public final <T> void resumeSafely(CancellableContinuation<? super T> cancellableContinuation, T t) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        if (cancellableContinuation.isCompleted()) {
            return;
        }
        Result.Companion companion = Result.Companion;
        ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(t));
    }

    public final void resumeWithExceptionSafely(CancellableContinuation<?> cancellableContinuation, Throwable exception) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (cancellableContinuation.isCompleted()) {
            return;
        }
        Result.Companion companion = Result.Companion;
        ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(ResultKt.createFailure(exception)));
    }
}