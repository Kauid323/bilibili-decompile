package kntr.base.imageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import com.ashampoo.kim.Kim;
import com.ashampoo.kim.format.ImageMetadata;
import com.ashampoo.kim.input.AndroidInputStreamByteReader;
import com.bilibili.lib.image2.bean.BiliAnimatable;
import com.bilibili.lib.image2.bean.BiliAnimatedDrawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.google.accompanist.drawablepainter.DrawablePainter;
import java.io.File;
import java.io.FileInputStream;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000\u001aJ\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000\u001a*\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00122\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000\u001a*\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018¨\u0006\u0019"}, d2 = {"createLottieSource", "Lkntr/base/imageloader/ImageSource;", "drawable", "Lcom/bilibili/lib/image2/bean/BiliAnimatedDrawable;", "enableAnimate", "", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "align", "Landroidx/compose/ui/Alignment;", "error", "Lkntr/base/imageloader/ImageException;", "onClose", "Lkotlin/Function0;", "", "createAnimateSource", "autoPlay", "createBitmapSource", "Landroid/graphics/drawable/BitmapDrawable;", "Lcom/facebook/drawee/drawable/OrientedDrawable;", "findExifInfo", "", "", "tag", "Lkntr/base/imageloader/ExifTag;", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilKt {

    /* compiled from: Util.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExifTag.values().length];
            try {
                iArr[ExifTag.UserComment.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ ImageSource createLottieSource$default(BiliAnimatedDrawable biliAnimatedDrawable, boolean z, ContentScale contentScale, Alignment alignment, ImageException imageException, Function0 function0, int i, Object obj) {
        ImageException imageException2;
        if ((i & 16) == 0) {
            imageException2 = imageException;
        } else {
            imageException2 = null;
        }
        return createLottieSource(biliAnimatedDrawable, z, contentScale, alignment, imageException2, function0);
    }

    public static final ImageSource createLottieSource(final BiliAnimatedDrawable drawable, boolean enableAnimate, final ContentScale contentScale, final Alignment align, ImageException error, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        if (enableAnimate) {
            return new ImageSource(error, new AnimateImage() { // from class: kntr.base.imageloader.UtilKt$createLottieSource$1
                @Override // kntr.base.imageloader.AnimateImage
                public AnimateImageInfo getImageInfo() {
                    float width$iv = drawable.getIntrinsicWidth();
                    float height$iv = drawable.getIntrinsicHeight();
                    long v1$iv$iv = Float.floatToRawIntBits(width$iv);
                    long v2$iv$iv = Float.floatToRawIntBits(height$iv);
                    return new AnimateImageInfo(androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), drawable.getFrameCount(), 0L, 4, null);
                }

                @Override // kntr.base.imageloader.AnimateImage
                public Painter getPainter() {
                    return new LottiePainter(drawable, contentScale, align);
                }

                @Override // kntr.base.imageloader.AnimateImage
                public void setAnimationListener(final AnimationListener listener) {
                    Intrinsics.checkNotNullParameter(listener, "listener");
                    drawable.setAnimationListener(new com.bilibili.lib.image2.bean.AnimationListener() { // from class: kntr.base.imageloader.UtilKt$createLottieSource$1$setAnimationListener$1
                        public void onAnimationStart(BiliAnimatable animatable) {
                            AnimationListener.this.onStart();
                        }

                        public void onAnimationStop(BiliAnimatable animatable) {
                            AnimationListener.this.onStop();
                        }

                        public void onAnimationLastFrame(BiliAnimatable animatable) {
                            AnimationListener.this.onLastFrame();
                        }
                    });
                    final BiliAnimatedDrawable biliAnimatedDrawable = drawable;
                    listener.onReady(new AnimateController() { // from class: kntr.base.imageloader.UtilKt$createLottieSource$1$setAnimationListener$2
                        @Override // kntr.base.imageloader.AnimateController
                        public void start() {
                            biliAnimatedDrawable.start();
                        }

                        @Override // kntr.base.imageloader.AnimateController
                        public void stop() {
                            biliAnimatedDrawable.stop();
                        }

                        @Override // kntr.base.imageloader.AnimateController
                        public void jumpToFrame(int index) {
                            biliAnimatedDrawable.jumpToFrame(index);
                        }
                    });
                }

                @Override // kntr.base.imageloader.AnimateImage
                public ImageBitmap getFrame(int index) {
                    throw new Exception("Not yet implemented, don't use it!");
                }

                @Override // kntr.base.imageloader.AnimateImage
                public int getFrameCount() {
                    throw new Exception("Not yet implemented, don't use it!");
                }

                @Override // kntr.base.imageloader.AnimateImage
                /* renamed from: getFrameDuration-5sfh64U */
                public long mo1409getFrameDuration5sfh64U(int index) {
                    throw new Exception("Not yet implemented, don't use it!");
                }

                @Override // kntr.base.imageloader.Image
                public void close() {
                    function0.invoke();
                }
            });
        }
        return new ImageSource(error, new StaticImage() { // from class: kntr.base.imageloader.UtilKt$createLottieSource$2
            @Override // kntr.base.imageloader.StaticImage
            public StaticImageInfo getImageInfo() {
                float width$iv = drawable.getIntrinsicWidth();
                float height$iv = drawable.getIntrinsicHeight();
                long v1$iv$iv = Float.floatToRawIntBits(width$iv);
                long v2$iv$iv = Float.floatToRawIntBits(height$iv);
                return new StaticImageInfo(androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), 0L, 2, null);
            }

            @Override // kntr.base.imageloader.StaticImage
            public ImageBitmap getBitmap() {
                Drawable preDrawable = drawable.getPreviewDrawable();
                BitmapDrawable it = preDrawable instanceof BitmapDrawable ? (BitmapDrawable) preDrawable : null;
                if (it != null && it.getBitmap() != null) {
                    Bitmap bitmap = it.getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                    return AndroidImageBitmap_androidKt.asImageBitmap(bitmap);
                }
                return ImageBitmapKt.ImageBitmap-x__-hDU$default(1, 1, 0, false, (ColorSpace) null, 28, (Object) null);
            }

            @Override // kntr.base.imageloader.Image
            public void close() {
                function0.invoke();
            }
        });
    }

    public static /* synthetic */ ImageSource createAnimateSource$default(BiliAnimatedDrawable biliAnimatedDrawable, boolean z, ContentScale contentScale, Alignment alignment, boolean z2, ImageException imageException, Function0 function0, int i, Object obj) {
        ImageException imageException2;
        if ((i & 32) == 0) {
            imageException2 = imageException;
        } else {
            imageException2 = null;
        }
        return createAnimateSource(biliAnimatedDrawable, z, contentScale, alignment, z2, imageException2, function0);
    }

    public static final ImageSource createAnimateSource(final BiliAnimatedDrawable drawable, boolean enableAnimate, final ContentScale contentScale, final Alignment align, final boolean autoPlay, ImageException error, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        final boolean enableNewPainter = IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "dd.infra.image.kntr-new-drawable-painter-enable", false, 2, null);
        if (enableAnimate) {
            ImageSource imageSource = new ImageSource(error, new AnimateImage() { // from class: kntr.base.imageloader.UtilKt$createAnimateSource$1
                @Override // kntr.base.imageloader.AnimateImage
                public AnimateImageInfo getImageInfo() {
                    float width$iv = drawable.getIntrinsicWidth();
                    float height$iv = drawable.getIntrinsicHeight();
                    long v1$iv$iv = Float.floatToRawIntBits(width$iv);
                    long v2$iv$iv = Float.floatToRawIntBits(height$iv);
                    return new AnimateImageInfo(androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), drawable.getFrameCount(), 0L, 4, null);
                }

                @Override // kntr.base.imageloader.AnimateImage
                public Painter getPainter() {
                    if (enableNewPainter) {
                        KLog_androidKt.getKLog().i(ApiKt.TAG, "use FixedDrawablePainter");
                        return new FixedDrawablePainter(drawable, contentScale, align, autoPlay);
                    }
                    KLog_androidKt.getKLog().i(ApiKt.TAG, "use DrawablePainter");
                    return new DrawablePainter(drawable);
                }

                @Override // kntr.base.imageloader.AnimateImage
                public void setAnimationListener(final AnimationListener listener) {
                    Intrinsics.checkNotNullParameter(listener, "listener");
                    drawable.setAnimationListener(new com.bilibili.lib.image2.bean.AnimationListener() { // from class: kntr.base.imageloader.UtilKt$createAnimateSource$1$setAnimationListener$1
                        public void onAnimationStart(BiliAnimatable animatable) {
                            AnimationListener.this.onStart();
                        }

                        public void onAnimationStop(BiliAnimatable animatable) {
                            AnimationListener.this.onStop();
                        }

                        public void onAnimationLastFrame(BiliAnimatable animatable) {
                            AnimationListener.this.onLastFrame();
                        }
                    });
                    final BiliAnimatedDrawable biliAnimatedDrawable = drawable;
                    listener.onReady(new AnimateController() { // from class: kntr.base.imageloader.UtilKt$createAnimateSource$1$setAnimationListener$2
                        @Override // kntr.base.imageloader.AnimateController
                        public void start() {
                            biliAnimatedDrawable.start();
                        }

                        @Override // kntr.base.imageloader.AnimateController
                        public void stop() {
                            biliAnimatedDrawable.stop();
                        }

                        @Override // kntr.base.imageloader.AnimateController
                        public void jumpToFrame(int index) {
                            biliAnimatedDrawable.jumpToFrame(index);
                        }
                    });
                }

                @Override // kntr.base.imageloader.AnimateImage
                public ImageBitmap getFrame(int index) {
                    throw new Exception("Not yet implemented, don't use it!");
                }

                @Override // kntr.base.imageloader.AnimateImage
                public int getFrameCount() {
                    throw new Exception("Not yet implemented, don't use it!");
                }

                @Override // kntr.base.imageloader.AnimateImage
                /* renamed from: getFrameDuration-5sfh64U */
                public long mo1409getFrameDuration5sfh64U(int index) {
                    throw new Exception("Not yet implemented, don't use it!");
                }

                @Override // kntr.base.imageloader.Image
                public void close() {
                    function0.invoke();
                }
            });
            if (enableNewPainter) {
                return imageSource;
            }
            if (autoPlay) {
                drawable.start();
                return imageSource;
            }
            drawable.stop();
            return imageSource;
        }
        return new ImageSource(error, new StaticImage() { // from class: kntr.base.imageloader.UtilKt$createAnimateSource$3
            @Override // kntr.base.imageloader.StaticImage
            public StaticImageInfo getImageInfo() {
                float width$iv = drawable.getIntrinsicWidth();
                float height$iv = drawable.getIntrinsicHeight();
                long v1$iv$iv = Float.floatToRawIntBits(width$iv);
                long v2$iv$iv = Float.floatToRawIntBits(height$iv);
                return new StaticImageInfo(androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), 0L, 2, null);
            }

            @Override // kntr.base.imageloader.StaticImage
            public ImageBitmap getBitmap() {
                Drawable preDrawable = drawable.getPreviewDrawable();
                BitmapDrawable it = preDrawable instanceof BitmapDrawable ? (BitmapDrawable) preDrawable : null;
                if (it != null && it.getBitmap() != null) {
                    Bitmap bitmap = it.getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                    return AndroidImageBitmap_androidKt.asImageBitmap(bitmap);
                }
                return ImageBitmapKt.ImageBitmap-x__-hDU$default(1, 1, 0, false, (ColorSpace) null, 28, (Object) null);
            }

            @Override // kntr.base.imageloader.Image
            public void close() {
                function0.invoke();
            }
        });
    }

    public static /* synthetic */ ImageSource createBitmapSource$default(BitmapDrawable bitmapDrawable, ImageException imageException, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            imageException = null;
        }
        return createBitmapSource(bitmapDrawable, imageException, function0);
    }

    public static final ImageSource createBitmapSource(final BitmapDrawable drawable, ImageException error, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        return new ImageSource(error, new StaticImage() { // from class: kntr.base.imageloader.UtilKt$createBitmapSource$1
            @Override // kntr.base.imageloader.StaticImage
            public StaticImageInfo getImageInfo() {
                float width$iv = drawable.getIntrinsicWidth();
                float height$iv = drawable.getIntrinsicHeight();
                long v1$iv$iv = Float.floatToRawIntBits(width$iv);
                long v2$iv$iv = Float.floatToRawIntBits(height$iv);
                return new StaticImageInfo(androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), 0L, 2, null);
            }

            @Override // kntr.base.imageloader.StaticImage
            public ImageBitmap getBitmap() {
                Bitmap bitmap = drawable.getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                return AndroidImageBitmap_androidKt.asImageBitmap(bitmap);
            }

            @Override // kntr.base.imageloader.Image
            public void close() {
                function0.invoke();
            }
        });
    }

    public static /* synthetic */ ImageSource createBitmapSource$default(OrientedDrawable orientedDrawable, ImageException imageException, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            imageException = null;
        }
        return createBitmapSource(orientedDrawable, imageException, function0);
    }

    public static final ImageSource createBitmapSource(final OrientedDrawable drawable, ImageException error, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        return new ImageSource(error, new StaticImage() { // from class: kntr.base.imageloader.UtilKt$createBitmapSource$2
            @Override // kntr.base.imageloader.StaticImage
            public StaticImageInfo getImageInfo() {
                float width$iv = drawable.getIntrinsicWidth();
                float height$iv = drawable.getIntrinsicHeight();
                long v1$iv$iv = Float.floatToRawIntBits(width$iv);
                long v2$iv$iv = Float.floatToRawIntBits(height$iv);
                return new StaticImageInfo(androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv)), 0L, 2, null);
            }

            @Override // kntr.base.imageloader.StaticImage
            public ImageBitmap getBitmap() {
                Drawable current = drawable.getCurrent();
                Intrinsics.checkNotNull(current, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                Bitmap bitmap = ((BitmapDrawable) current).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                return AndroidImageBitmap_androidKt.asImageBitmap(bitmap);
            }

            @Override // kntr.base.imageloader.Image
            public void close() {
                function0.invoke();
            }
        });
    }

    public static final String findExifInfo(byte[] $this$findExifInfo, ExifTag tag) {
        String findStringValue;
        Intrinsics.checkNotNullParameter($this$findExifInfo, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        ImageMetadata meta = Kim.readMetadata($this$findExifInfo);
        if (WhenMappings.$EnumSwitchMapping$0[tag.ordinal()] == 1) {
            return (meta == null || (findStringValue = meta.findStringValue(com.ashampoo.kim.format.tiff.constant.ExifTag.INSTANCE.getEXIF_TAG_USER_COMMENT())) == null) ? "" : findStringValue;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String findExifInfo(String $this$findExifInfo, ExifTag tag) {
        Intrinsics.checkNotNullParameter($this$findExifInfo, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        File file = new File($this$findExifInfo);
        if (file.exists()) {
            try {
                Result.Companion companion = Result.Companion;
                FileInputStream fileInputStream = new FileInputStream(new File($this$findExifInfo));
                FileInputStream inputStream = fileInputStream;
                ImageMetadata meta = Kim.readMetadata(new AndroidInputStreamByteReader(inputStream, file.length()));
                if (WhenMappings.$EnumSwitchMapping$0[tag.ordinal()] != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                String str = (meta == null || (str = meta.findStringValue(com.ashampoo.kim.format.tiff.constant.ExifTag.INSTANCE.getEXIF_TAG_USER_COMMENT())) == null) ? "" : "";
                CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                return str;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Object m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                if (it != null) {
                    KLog_androidKt.getKLog().e(ApiKt.TAG, "findExifInfo error: " + it.getMessage());
                }
                Result.m2635boximpl(m2636constructorimpl);
            }
        } else {
            KLog_androidKt.getKLog().e(ApiKt.TAG, "findExifInfo file not exist: " + $this$findExifInfo);
        }
        return "";
    }
}