package tv.danmaku.bili.ui.main2.mine.modularvip;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.IGenericProperties;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.filechooser.FileUtils;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum;
import tv.danmaku.bili.ui.main2.mine.widgets.GradientAlphaBitmapTransformation;

/* compiled from: MineVipModuleManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0013\u0014\u0015\u0016\u0017\u0018B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0006\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", "", "<init>", "()V", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getPositionType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "value", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "model", "getModel", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "onUpdate", "", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTint", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPageInvisible", "Background", "Logo", "Icon", "Title", "Subtitle", "Button", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Background;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Button;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Icon;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Logo;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Subtitle;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Title;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class MineVipModuleEnum {
    public static final int $stable = 8;
    private MineVipModel model;

    public /* synthetic */ MineVipModuleEnum(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract PositionType getPositionType();

    public abstract Object onTint(Continuation<? super Unit> continuation);

    public Object onUpdate(MineVipModel mineVipModel, Continuation<? super Unit> continuation) {
        return onUpdate$suspendImpl(this, mineVipModel, continuation);
    }

    private MineVipModuleEnum() {
    }

    protected final MineVipModel getModel() {
        return this.model;
    }

    static /* synthetic */ Object onUpdate$suspendImpl(MineVipModuleEnum $this, MineVipModel model, Continuation<? super Unit> continuation) {
        $this.model = model;
        return Unit.INSTANCE;
    }

    public void onPageInvisible() {
    }

    /* compiled from: MineVipModuleManager.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Background;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Lcom/bilibili/lib/image2/view/BiliImageView;", "shadow", "Landroid/view/View;", "<init>", "(Lcom/bilibili/lib/image2/view/BiliImageView;Landroid/view/View;)V", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getPositionType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "sectionModel", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipBackgroundModel;", "getSectionModel", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipBackgroundModel;", "onTint", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdate", "model", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayUrl", "url", "", "colorLayer", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "(Ljava/lang/String;Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayPureColor", "colorResource", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Background extends MineVipModuleEnum {
        public static final float BITMAP_ALPHA_END_VALUE = 0.4f;
        public static final float BITMAP_ALPHA_FROM_VALUE = 0.0f;
        public static final float CORNER = 8.0f;
        private final BiliImageView background;
        private final View shadow;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Background(BiliImageView background, View shadow) {
            super(null);
            Intrinsics.checkNotNullParameter(background, BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND);
            Intrinsics.checkNotNullParameter(shadow, "shadow");
            this.background = background;
            this.shadow = shadow;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public PositionType getPositionType() {
            return PositionType.BACKGROUND;
        }

        private final MineVipBackgroundModel getSectionModel() {
            MineVipModel model = getModel();
            if (model != null) {
                return model.getBackground();
            }
            return null;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public Object onTint(Continuation<? super Unit> continuation) {
            ColorResource fallbackBackgroundColor;
            View $this$onTint_u24lambda_u240 = this.shadow;
            $this$onTint_u24lambda_u240.setBackground(ResourcesCompat.getDrawable($this$onTint_u24lambda_u240.getContext().getResources(), R.drawable.ic_mine_vip_entrance_shadow, $this$onTint_u24lambda_u240.getContext().getTheme()));
            MineVipBackgroundModel sectionModel = getSectionModel();
            String image = sectionModel != null ? sectionModel.getImage() : null;
            MineVipBackgroundModel sectionModel2 = getSectionModel();
            ColorResource layer = sectionModel2 != null ? sectionModel2.getLayerColorResource() : null;
            boolean z = false;
            if (image != null && (!StringsKt.isBlank(image))) {
                z = true;
            }
            if (z && layer != null) {
                Object displayUrl = displayUrl(image, layer, continuation);
                return displayUrl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? displayUrl : Unit.INSTANCE;
            }
            MineVipBackgroundModel sectionModel3 = getSectionModel();
            if (sectionModel3 == null || (fallbackBackgroundColor = sectionModel3.getLayerColorResource()) == null) {
                fallbackBackgroundColor = MineVipModelKt.getFallbackBackgroundColor();
            }
            displayPureColor(fallbackBackgroundColor);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object onUpdate(MineVipModel model, Continuation<? super Unit> continuation) {
            MineVipModuleEnum$Background$onUpdate$1 mineVipModuleEnum$Background$onUpdate$1;
            Background background;
            MineVipBackgroundModel $this$onUpdate_u24lambda_u241;
            boolean z;
            if (continuation instanceof MineVipModuleEnum$Background$onUpdate$1) {
                mineVipModuleEnum$Background$onUpdate$1 = (MineVipModuleEnum$Background$onUpdate$1) continuation;
                if ((mineVipModuleEnum$Background$onUpdate$1.label & Integer.MIN_VALUE) != 0) {
                    mineVipModuleEnum$Background$onUpdate$1.label -= Integer.MIN_VALUE;
                    Object $result = mineVipModuleEnum$Background$onUpdate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (mineVipModuleEnum$Background$onUpdate$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            mineVipModuleEnum$Background$onUpdate$1.label = 1;
                            if (super.onUpdate(model, mineVipModuleEnum$Background$onUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            background = this;
                            break;
                        case 1:
                            background = this;
                            ResultKt.throwOnFailure($result);
                            break;
                        case 2:
                            z = false;
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    View $this$onUpdate_u24lambda_u240 = background.shadow;
                    $this$onUpdate_u24lambda_u240.setBackground(ResourcesCompat.getDrawable($this$onUpdate_u24lambda_u240.getContext().getResources(), R.drawable.ic_mine_vip_entrance_shadow, $this$onUpdate_u24lambda_u240.getContext().getTheme()));
                    $this$onUpdate_u24lambda_u241 = background.getSectionModel();
                    if ($this$onUpdate_u24lambda_u241 != null) {
                        throw new Exception("background model is null");
                    }
                    if (!StringsKt.isBlank($this$onUpdate_u24lambda_u241.getImage())) {
                        String image = $this$onUpdate_u24lambda_u241.getImage();
                        ColorResource layerColorResource = $this$onUpdate_u24lambda_u241.getLayerColorResource();
                        mineVipModuleEnum$Background$onUpdate$1.label = 2;
                        if (background.displayUrl(image, layerColorResource, mineVipModuleEnum$Background$onUpdate$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z = false;
                        return Unit.INSTANCE;
                    }
                    background.displayPureColor($this$onUpdate_u24lambda_u241.getLayerColorResource());
                    return Unit.INSTANCE;
                }
            }
            mineVipModuleEnum$Background$onUpdate$1 = new MineVipModuleEnum$Background$onUpdate$1(this, continuation);
            Object $result2 = mineVipModuleEnum$Background$onUpdate$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (mineVipModuleEnum$Background$onUpdate$1.label) {
            }
            View $this$onUpdate_u24lambda_u2402 = background.shadow;
            $this$onUpdate_u24lambda_u2402.setBackground(ResourcesCompat.getDrawable($this$onUpdate_u24lambda_u2402.getContext().getResources(), R.drawable.ic_mine_vip_entrance_shadow, $this$onUpdate_u24lambda_u2402.getContext().getTheme()));
            $this$onUpdate_u24lambda_u241 = background.getSectionModel();
            if ($this$onUpdate_u24lambda_u241 != null) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object displayUrl(String url, ColorResource colorLayer, Continuation<? super Unit> continuation) {
            CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuation it = cancellableContinuationImpl;
            BiliImageView $this$displayUrl_u24lambda_u240_u240 = MineVipModuleManagerKt.reset(this.background);
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = $this$displayUrl_u24lambda_u240_u240.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder url2 = biliImageLoader.with(context).url(url);
            ScaleType scaleType = ScaleType.FIT_END;
            Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_END");
            ImageRequestBuilder bitmapTransformation = url2.actualImageScaleType(scaleType).bitmapTransformation(new GradientAlphaBitmapTransformation(url, 0.0f, 0.4f));
            GradientDrawable $this$displayUrl_u24lambda_u240_u240_u240 = new GradientDrawable();
            $this$displayUrl_u24lambda_u240_u240_u240.setColor(ColorStateList.valueOf($this$displayUrl_u24lambda_u240_u240.getResources().getColor(com.bilibili.lib.theme.R.color.Bg1)));
            Context context2 = $this$displayUrl_u24lambda_u240_u240.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            $this$displayUrl_u24lambda_u240_u240_u240.setColorFilter(new PorterDuffColorFilter(colorLayer.getColorInt(context2), PorterDuff.Mode.SRC_ATOP));
            $this$displayUrl_u24lambda_u240_u240_u240.setCornerRadius(ListExtentionsKt.toPx(8.0f));
            bitmapTransformation.backgroundImageDrawable($this$displayUrl_u24lambda_u240_u240_u240).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Background$displayUrl$2$1$2
                public /* synthetic */ void onImageLoading(Uri uri) {
                    ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                }

                public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                }

                public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                }

                public void onImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                    MineVipExtentionsKt.resumeIfActive(it, Unit.INSTANCE);
                }

                public void onImageLoadFailed(Throwable err) {
                    ImageLoadingListener.-CC.$default$onImageLoadFailed(this, err);
                    MineVipExtentionsKt.resumeExceptionIfActive(it, new Exception("image load failed with (" + (err != null ? err.getMessage() : null) + "). on " + this.getPositionType().name() + FileUtils.HIDDEN_PREFIX));
                }
            }).into($this$displayUrl_u24lambda_u240_u240);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }

        private final void displayPureColor(ColorResource colorResource) {
            IGenericProperties genericProperties = MineVipModuleManagerKt.reset(this.background).getGenericProperties();
            Context context = this.background.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            PaintDrawable $this$displayPureColor_u24lambda_u240 = new PaintDrawable(colorResource.getColorInt(context));
            $this$displayPureColor_u24lambda_u240.setCornerRadius(ListExtentionsKt.toPx(8.0f));
            genericProperties.setBackground($this$displayPureColor_u24lambda_u240);
        }

        /* compiled from: MineVipModuleManager.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Background$Companion;", "", "<init>", "()V", "CORNER", "", "BITMAP_ALPHA_FROM_VALUE", "BITMAP_ALPHA_END_VALUE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: MineVipModuleManager.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Logo;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", "imageView", "Lcom/bilibili/lib/image2/view/BiliImageView;", "<init>", "(Lcom/bilibili/lib/image2/view/BiliImageView;)V", "sectionModel", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipLogoModel;", "getSectionModel", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipLogoModel;", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getPositionType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "onTint", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDefault", "onUpdate", "model", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayUrl", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Logo extends MineVipModuleEnum {
        public static final int $stable = 8;
        private final BiliImageView imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Logo(BiliImageView imageView) {
            super(null);
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            this.imageView = imageView;
        }

        private final MineVipLogoModel getSectionModel() {
            MineVipModel model = getModel();
            if (model != null) {
                return model.getLogo();
            }
            return null;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public PositionType getPositionType() {
            return PositionType.LOGO;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public Object onTint(Continuation<? super Unit> continuation) {
            String image;
            ImageResource imageResource;
            MineVipLogoModel sectionModel = getSectionModel();
            if (sectionModel == null || (imageResource = sectionModel.getImageResource()) == null) {
                image = null;
            } else {
                Context context = this.imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                image = imageResource.getResource(context);
            }
            String str = image;
            if (str == null || StringsKt.isBlank(str)) {
                toDefault();
                return Unit.INSTANCE;
            }
            Object displayUrl = displayUrl(image, continuation);
            return displayUrl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? displayUrl : Unit.INSTANCE;
        }

        private final void toDefault() {
            MineVipModuleManagerKt.reset(this.imageView);
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = this.imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder url = biliImageLoader.with(context).url(BiliImageLoaderHelper.resourceToUri$default((String) null, R.drawable.ic_vip_section_v2_logo, 1, (Object) null));
            ScaleType scaleType = ScaleType.FIT_CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
            url.actualImageScaleType(scaleType).into(this.imageView);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object onUpdate(MineVipModel model, Continuation<? super Unit> continuation) {
            MineVipModuleEnum$Logo$onUpdate$1 mineVipModuleEnum$Logo$onUpdate$1;
            Logo logo;
            MineVipLogoModel sectionModel;
            String image;
            String str;
            ImageResource imageResource;
            if (continuation instanceof MineVipModuleEnum$Logo$onUpdate$1) {
                mineVipModuleEnum$Logo$onUpdate$1 = (MineVipModuleEnum$Logo$onUpdate$1) continuation;
                if ((mineVipModuleEnum$Logo$onUpdate$1.label & Integer.MIN_VALUE) != 0) {
                    mineVipModuleEnum$Logo$onUpdate$1.label -= Integer.MIN_VALUE;
                    Object $result = mineVipModuleEnum$Logo$onUpdate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    boolean z = true;
                    switch (mineVipModuleEnum$Logo$onUpdate$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            mineVipModuleEnum$Logo$onUpdate$1.label = 1;
                            if (super.onUpdate(model, mineVipModuleEnum$Logo$onUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            logo = this;
                            sectionModel = logo.getSectionModel();
                            if (sectionModel != null || (imageResource = sectionModel.getImageResource()) == null) {
                                image = null;
                            } else {
                                Context context = logo.imageView.getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                                image = imageResource.getResource(context);
                            }
                            str = image;
                            if (str != null && !StringsKt.isBlank(str)) {
                                z = false;
                            }
                            if (!z) {
                                logo.toDefault();
                                return Unit.INSTANCE;
                            }
                            mineVipModuleEnum$Logo$onUpdate$1.label = 2;
                            if (logo.displayUrl(image, mineVipModuleEnum$Logo$onUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            logo = this;
                            ResultKt.throwOnFailure($result);
                            sectionModel = logo.getSectionModel();
                            if (sectionModel != null) {
                                break;
                            }
                            image = null;
                            str = image;
                            if (str != null) {
                                z = false;
                                break;
                            }
                            if (!z) {
                            }
                            break;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            mineVipModuleEnum$Logo$onUpdate$1 = new MineVipModuleEnum$Logo$onUpdate$1(this, continuation);
            Object $result2 = mineVipModuleEnum$Logo$onUpdate$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z2 = true;
            switch (mineVipModuleEnum$Logo$onUpdate$1.label) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object displayUrl(String url, Continuation<? super Unit> continuation) {
            CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuation it = cancellableContinuationImpl;
            MineVipModuleManagerKt.reset(this.imageView);
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = this.imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder $this$displayUrl_u24lambda_u240_u240 = biliImageLoader.with(context);
            $this$displayUrl_u24lambda_u240_u240.url(url);
            ScaleType scaleType = ScaleType.FIT_CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
            $this$displayUrl_u24lambda_u240_u240.actualImageScaleType(scaleType);
            ImageRequestBuilder.failureImageResId$default($this$displayUrl_u24lambda_u240_u240, R.drawable.ic_vip_section_v2_logo, (ScaleType) null, 2, (Object) null);
            $this$displayUrl_u24lambda_u240_u240.imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Logo$displayUrl$2$1$1
                public /* synthetic */ void onImageLoading(Uri uri) {
                    ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                }

                public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                }

                public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                }

                public void onImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                    MineVipExtentionsKt.resumeIfActive(it, Unit.INSTANCE);
                }

                public void onImageLoadFailed(Throwable err) {
                    ImageLoadingListener.-CC.$default$onImageLoadFailed(this, err);
                    BLog.e(MineVipModuleManagerKt.TAG, "logo image load failed with (" + (err != null ? err.getMessage() : null) + ").");
                    MineVipExtentionsKt.resumeIfActive(it, Unit.INSTANCE);
                }
            });
            $this$displayUrl_u24lambda_u240_u240.into(this.imageView);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
    }

    /* compiled from: MineVipModuleManager.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Icon;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", "svgaImageView", "Lcom/opensource/svgaplayer/SVGAImageView;", "staticImageView", "Lcom/bilibili/lib/image2/view/BiliImageView;", "spaceView", "Landroid/view/View;", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;Lcom/bilibili/lib/image2/view/BiliImageView;Landroid/view/View;)V", "sectionModel", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconModel;", "getSectionModel", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonIconModel;", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getPositionType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "spaceAnimator", "Landroid/animation/Animator;", "toDefault", "", "onPageInvisible", "onTint", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endAnimator", "recreateSpaceAnimator", "onUpdate", "model", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdateSvgaImage", "image", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdateStaticImage", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Icon extends MineVipModuleEnum {
        public static final int $stable = 8;
        private Animator spaceAnimator;
        private final View spaceView;
        private final BiliImageView staticImageView;
        private final SVGAImageView svgaImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Icon(SVGAImageView svgaImageView, BiliImageView staticImageView, View spaceView) {
            super(null);
            Intrinsics.checkNotNullParameter(svgaImageView, "svgaImageView");
            Intrinsics.checkNotNullParameter(staticImageView, "staticImageView");
            Intrinsics.checkNotNullParameter(spaceView, "spaceView");
            this.svgaImageView = svgaImageView;
            this.staticImageView = staticImageView;
            this.spaceView = spaceView;
        }

        private final MineVipButtonIconModel getSectionModel() {
            MineVipModel model = getModel();
            if (model != null) {
                return model.getButtonIcon();
            }
            return null;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public PositionType getPositionType() {
            return PositionType.ICON;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void toDefault() {
            Animator animator = this.spaceAnimator;
            if (animator != null) {
                animator.cancel();
            }
            this.spaceAnimator = null;
            View $this$updateLayoutParams$iv = this.spaceView;
            ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
            if (params$iv$iv == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            params$iv$iv.width = 0;
            $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
            this.svgaImageView.stopAnimation(true);
            ListExtentionsKt.gone(this.svgaImageView);
            ListExtentionsKt.gone(this.staticImageView);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public void onPageInvisible() {
            endAnimator();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public Object onTint(Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        private final void endAnimator() {
            Animator animator;
            if (this.spaceAnimator != null) {
                Animator animator2 = this.spaceAnimator;
                boolean z = false;
                if (animator2 != null && animator2.isStarted()) {
                    z = true;
                }
                if (!z || (animator = this.spaceAnimator) == null) {
                    return;
                }
                animator.end();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Animator recreateSpaceAnimator() {
            endAnimator();
            ValueAnimator animator = ValueAnimator.ofInt(0, ListExtentionsKt.toPx(22));
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MineVipModuleEnum.Icon.recreateSpaceAnimator$lambda$0$0(MineVipModuleEnum.Icon.this, valueAnimator);
                }
            });
            Intrinsics.checkNotNull(animator);
            ValueAnimator $this$doOnCancel$iv = animator;
            $this$doOnCancel$iv.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$recreateSpaceAnimator$lambda$0$$inlined$doOnCancel$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator2) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    View $this$updateLayoutParams$iv;
                    $this$updateLayoutParams$iv = MineVipModuleEnum.Icon.this.spaceView;
                    ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
                    if (params$iv$iv == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    params$iv$iv.width = 0;
                    $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                }
            });
            this.spaceAnimator = animator;
            Intrinsics.checkNotNull(animator);
            return animator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void recreateSpaceAnimator$lambda$0$0(Icon this$0, ValueAnimator it) {
            int i;
            Intrinsics.checkNotNullParameter(it, "it");
            View $this$updateLayoutParams$iv = this$0.spaceView;
            ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
            if (params$iv$iv != null) {
                Object $this$asTo$iv = it.getAnimatedValue();
                if ($this$asTo$iv != null) {
                    if (!($this$asTo$iv instanceof Integer)) {
                        $this$asTo$iv = null;
                    }
                    Integer num = (Integer) $this$asTo$iv;
                    if (num != null) {
                        i = num.intValue();
                        params$iv$iv.width = i;
                        $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
                        return;
                    }
                }
                i = 0;
                params$iv$iv.width = i;
                $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00b7  */
        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object onUpdate(MineVipModel model, Continuation<? super Unit> continuation) {
            MineVipModuleEnum$Icon$onUpdate$1 mineVipModuleEnum$Icon$onUpdate$1;
            Icon icon;
            MineVipButtonIconModel it;
            String svgaImage;
            MineVipButtonIconModel it2;
            if (continuation instanceof MineVipModuleEnum$Icon$onUpdate$1) {
                mineVipModuleEnum$Icon$onUpdate$1 = (MineVipModuleEnum$Icon$onUpdate$1) continuation;
                if ((mineVipModuleEnum$Icon$onUpdate$1.label & Integer.MIN_VALUE) != 0) {
                    mineVipModuleEnum$Icon$onUpdate$1.label -= Integer.MIN_VALUE;
                    Object $result = mineVipModuleEnum$Icon$onUpdate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    boolean z = true;
                    switch (mineVipModuleEnum$Icon$onUpdate$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            mineVipModuleEnum$Icon$onUpdate$1.label = 1;
                            if (super.onUpdate(model, mineVipModuleEnum$Icon$onUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            icon = this;
                            it = icon.getSectionModel();
                            String staticImage = null;
                            if (it != null) {
                                if (((it.getType() == MineVipButtonIconType.DYNAMIC || it.getType() == MineVipButtonIconType.BIRTHDAY) ? 1 : null) == null) {
                                    it = null;
                                }
                                if (it != null) {
                                    svgaImage = it.getUrl();
                                    it2 = icon.getSectionModel();
                                    if (it2 != null) {
                                        if ((it2.getType() == MineVipButtonIconType.STATIC ? 1 : null) == null) {
                                            it2 = null;
                                        }
                                        if (it2 != null) {
                                            staticImage = it2.getUrl();
                                        }
                                    }
                                    icon.toDefault();
                                    if (svgaImage == null && (StringsKt.isBlank(svgaImage) ^ true)) {
                                        mineVipModuleEnum$Icon$onUpdate$1.label = 2;
                                        if (icon.onUpdateSvgaImage(svgaImage, mineVipModuleEnum$Icon$onUpdate$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (staticImage == null || !(!StringsKt.isBlank(staticImage))) {
                                            z = false;
                                        }
                                        if (z) {
                                            mineVipModuleEnum$Icon$onUpdate$1.label = 3;
                                            if (icon.onUpdateStaticImage(staticImage, mineVipModuleEnum$Icon$onUpdate$1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            svgaImage = null;
                            it2 = icon.getSectionModel();
                            if (it2 != null) {
                            }
                            icon.toDefault();
                            if (svgaImage == null && (StringsKt.isBlank(svgaImage) ^ true)) {
                            }
                            return Unit.INSTANCE;
                        case 1:
                            icon = this;
                            ResultKt.throwOnFailure($result);
                            it = icon.getSectionModel();
                            String staticImage2 = null;
                            if (it != null) {
                            }
                            svgaImage = null;
                            it2 = icon.getSectionModel();
                            if (it2 != null) {
                            }
                            icon.toDefault();
                            if (svgaImage == null && (StringsKt.isBlank(svgaImage) ^ true)) {
                            }
                            return Unit.INSTANCE;
                        case 2:
                        case 3:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            mineVipModuleEnum$Icon$onUpdate$1 = new MineVipModuleEnum$Icon$onUpdate$1(this, continuation);
            Object $result2 = mineVipModuleEnum$Icon$onUpdate$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z2 = true;
            switch (mineVipModuleEnum$Icon$onUpdate$1.label) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object onUpdateSvgaImage(final String image, Continuation<? super Unit> continuation) {
            CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuation coroutine = cancellableContinuationImpl;
            Context context = this.svgaImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new SVGAParser(context).parse(new URL(image), new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$onUpdateSvgaImage$2$1
                public void onComplete(final SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    if (coroutine.isActive()) {
                        ListExtentionsKt.visible(this.svgaImageView);
                        Animator $this$onComplete_u24lambda_u240 = this.recreateSpaceAnimator();
                        final MineVipModuleEnum.Icon icon = this;
                        final CancellableContinuation<Unit> cancellableContinuation = coroutine;
                        $this$onComplete_u24lambda_u240.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$onUpdateSvgaImage$2$1$onComplete$lambda$0$$inlined$doOnEnd$1
                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                final SVGAImageView $this$onComplete_u24lambda_u240_u240_u240 = MineVipModuleEnum.Icon.this.svgaImageView;
                                final SVGAVideoEntity sVGAVideoEntity = videoItem;
                                $this$onComplete_u24lambda_u240_u240_u240.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$onUpdateSvgaImage$2$1$onComplete$1$1$1$1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        $this$onComplete_u24lambda_u240_u240_u240.setVideoItem(sVGAVideoEntity);
                                        $this$onComplete_u24lambda_u240_u240_u240.stepToFrame(0, true);
                                    }
                                });
                                MineVipExtentionsKt.resumeIfActive(cancellableContinuation, Unit.INSTANCE);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                            }
                        });
                        $this$onComplete_u24lambda_u240.start();
                    }
                }

                public void onError() {
                    CancellableContinuation<Unit> cancellableContinuation = coroutine;
                    String str = image;
                    MineVipExtentionsKt.resumeExceptionIfActive(cancellableContinuation, new Exception("image(" + str + ") load error. on " + this.getPositionType().name() + FileUtils.HIDDEN_PREFIX));
                }

                public void onCacheExist() {
                }
            });
            coroutine.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$onUpdateSvgaImage$2$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((Throwable) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable it) {
                    MineVipModuleEnum.Icon.this.toDefault();
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object onUpdateStaticImage(final String image, Continuation<? super Unit> continuation) {
            CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuation coroutine = cancellableContinuationImpl;
            ListExtentionsKt.visible(this.staticImageView);
            Animator $this$onUpdateStaticImage_u24lambda_u240_u240 = recreateSpaceAnimator();
            $this$onUpdateStaticImage_u24lambda_u240_u240.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$onUpdateStaticImage$lambda$0$0$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BiliImageView biliImageView = MineVipModuleEnum.Icon.this.staticImageView;
                    String str = image;
                    final CancellableContinuation cancellableContinuation = coroutine;
                    final String str2 = image;
                    final MineVipModuleEnum.Icon icon = MineVipModuleEnum.Icon.this;
                    ImageExtentionKt.displayImage$default(biliImageView, str, (ThumbnailUrlTransformStrategy) null, new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$onUpdateStaticImage$2$1$1$1
                        public /* synthetic */ void onImageLoading(Uri uri) {
                            ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                        }

                        public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                            ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                        }

                        public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                            ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                        }

                        public void onImageSet(ImageInfo imageInfo) {
                            ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                            MineVipExtentionsKt.resumeIfActive(cancellableContinuation, Unit.INSTANCE);
                        }

                        public void onImageLoadFailed(Throwable err) {
                            ImageLoadingListener.-CC.$default$onImageLoadFailed(this, err);
                            CancellableContinuation<Unit> cancellableContinuation2 = cancellableContinuation;
                            String str3 = str2;
                            MineVipExtentionsKt.resumeExceptionIfActive(cancellableContinuation2, new Exception("image(" + str3 + ") load failed with (" + (err != null ? err.getMessage() : null) + "). on " + icon.getPositionType().name() + FileUtils.HIDDEN_PREFIX));
                        }
                    }, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1018, (Object) null);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            $this$onUpdateStaticImage_u24lambda_u240_u240.start();
            coroutine.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Icon$onUpdateStaticImage$2$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((Throwable) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable it) {
                    MineVipModuleEnum.Icon.this.toDefault();
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
    }

    /* compiled from: MineVipModuleManager.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Title;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", "textView", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/TextView;)V", "sectionModel", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipTitleModel;", "getSectionModel", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipTitleModel;", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getPositionType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "onTint", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdate", "model", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyStyle", GarbJsBridgeCallHandlerKt.PURE_THEME, "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "applyText", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Title extends MineVipModuleEnum {
        public static final int $stable = 8;
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Title(TextView textView) {
            super(null);
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.textView = textView;
        }

        private final MineVipTitleModel getSectionModel() {
            MineVipModel model = getModel();
            if (model != null) {
                return model.getTitle();
            }
            return null;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public PositionType getPositionType() {
            return PositionType.TITLE;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public Object onTint(Continuation<? super Unit> continuation) {
            ColorResource fallbackTitleColor;
            MineVipTitleModel sectionModel = getSectionModel();
            if (sectionModel == null || (fallbackTitleColor = sectionModel.getColorResource()) == null) {
                fallbackTitleColor = MineVipModelKt.getFallbackTitleColor();
            }
            applyStyle(fallbackTitleColor);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object onUpdate(MineVipModel model, Continuation<? super Unit> continuation) {
            MineVipModuleEnum$Title$onUpdate$1 mineVipModuleEnum$Title$onUpdate$1;
            Title title;
            MineVipTitleModel sectionModel;
            ColorResource colorResource;
            if (continuation instanceof MineVipModuleEnum$Title$onUpdate$1) {
                mineVipModuleEnum$Title$onUpdate$1 = (MineVipModuleEnum$Title$onUpdate$1) continuation;
                if ((mineVipModuleEnum$Title$onUpdate$1.label & Integer.MIN_VALUE) != 0) {
                    mineVipModuleEnum$Title$onUpdate$1.label -= Integer.MIN_VALUE;
                    Object $result = mineVipModuleEnum$Title$onUpdate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (mineVipModuleEnum$Title$onUpdate$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            mineVipModuleEnum$Title$onUpdate$1.label = 1;
                            if (super.onUpdate(model, mineVipModuleEnum$Title$onUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            title = this;
                            break;
                        case 1:
                            title = this;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sectionModel = title.getSectionModel();
                    if (sectionModel == null && (colorResource = sectionModel.getColorResource()) != null) {
                        title.applyStyle(colorResource);
                        title.applyText();
                        return Unit.INSTANCE;
                    }
                    throw new Exception("title color has exception. on " + title.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
                }
            }
            mineVipModuleEnum$Title$onUpdate$1 = new MineVipModuleEnum$Title$onUpdate$1(this, continuation);
            Object $result2 = mineVipModuleEnum$Title$onUpdate$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (mineVipModuleEnum$Title$onUpdate$1.label) {
            }
            sectionModel = title.getSectionModel();
            if (sectionModel == null) {
            }
            throw new Exception("title color has exception. on " + title.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
        }

        private final void applyStyle(final ColorResource color) {
            final TextView $this$applyStyle_u24lambda_u240 = this.textView;
            Context context = this.textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            final int textColor = color.getColorInt(context);
            $this$applyStyle_u24lambda_u240.setTypeface(Typeface.DEFAULT_BOLD);
            final TextView $this$doOnPreDraw$iv = $this$applyStyle_u24lambda_u240;
            OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum$Title$applyStyle$lambda$0$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    View view = $this$doOnPreDraw$iv;
                    if (((int) color.getColorInLight()) == $this$applyStyle_u24lambda_u240.getResources().getColor(com.bilibili.lib.theme.R.color.Pi5_u)) {
                        $this$applyStyle_u24lambda_u240.getPaint().setShader(new LinearGradient(0.0f, 0.0f, $this$applyStyle_u24lambda_u240.getMeasuredWidth(), 0.0f, new int[]{textColor, textColor, $this$applyStyle_u24lambda_u240.getResources().getColor(com.bilibili.lib.theme.R.color.Re4_u)}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                    } else {
                        $this$applyStyle_u24lambda_u240.getPaint().setShader(null);
                    }
                }
            });
            $this$applyStyle_u24lambda_u240.setTextColor(textColor);
        }

        private final void applyText() {
            String string;
            String title;
            TextView $this$applyText_u24lambda_u240 = this.textView;
            MineVipTitleModel sectionModel = getSectionModel();
            if ((sectionModel == null || (title = sectionModel.getTitle()) == null || !(StringsKt.isBlank(title) ^ true)) ? false : true) {
                MineVipTitleModel sectionModel2 = getSectionModel();
                string = sectionModel2 != null ? sectionModel2.getTitle() : null;
            } else {
                MineVipModel model = getModel();
                if (model != null ? Intrinsics.areEqual(model.isVip(), true) : false) {
                    string = $this$applyText_u24lambda_u240.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_105);
                } else {
                    MineVipModel model2 = getModel();
                    string = model2 != null ? Intrinsics.areEqual(model2.isVip(), false) : false ? $this$applyText_u24lambda_u240.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_630) : $this$applyText_u24lambda_u240.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_105);
                }
            }
            $this$applyText_u24lambda_u240.setText(string);
        }
    }

    /* compiled from: MineVipModuleManager.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Subtitle;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", "textView", "Landroid/widget/TextView;", "arrowImage", "Landroid/widget/ImageView;", "<init>", "(Landroid/widget/TextView;Landroid/widget/ImageView;)V", "sectionModel", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipSubtitleModel;", "getSectionModel", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipSubtitleModel;", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getPositionType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "onTint", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdate", "model", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyTextColor", "colorResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "applyImageColor", "applyText", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Subtitle extends MineVipModuleEnum {
        public static final int $stable = 8;
        private final ImageView arrowImage;
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Subtitle(TextView textView, ImageView arrowImage) {
            super(null);
            Intrinsics.checkNotNullParameter(textView, "textView");
            Intrinsics.checkNotNullParameter(arrowImage, "arrowImage");
            this.textView = textView;
            this.arrowImage = arrowImage;
        }

        private final MineVipSubtitleModel getSectionModel() {
            MineVipModel model = getModel();
            if (model != null) {
                return model.getSubtitle();
            }
            return null;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public PositionType getPositionType() {
            return PositionType.SUBTITLE;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public Object onTint(Continuation<? super Unit> continuation) {
            ColorResource fallbackSubtitleColor;
            ColorResource fallbackSubtitleColor2;
            MineVipSubtitleModel sectionModel = getSectionModel();
            if (sectionModel == null || (fallbackSubtitleColor = sectionModel.getColorResource()) == null) {
                fallbackSubtitleColor = MineVipModelKt.getFallbackSubtitleColor();
            }
            applyTextColor(fallbackSubtitleColor);
            MineVipSubtitleModel sectionModel2 = getSectionModel();
            if (sectionModel2 == null || (fallbackSubtitleColor2 = sectionModel2.getColorResource()) == null) {
                fallbackSubtitleColor2 = MineVipModelKt.getFallbackSubtitleColor();
            }
            applyImageColor(fallbackSubtitleColor2);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object onUpdate(MineVipModel model, Continuation<? super Unit> continuation) {
            MineVipModuleEnum$Subtitle$onUpdate$1 mineVipModuleEnum$Subtitle$onUpdate$1;
            Subtitle subtitle;
            MineVipSubtitleModel sectionModel;
            ColorResource colorResource;
            if (continuation instanceof MineVipModuleEnum$Subtitle$onUpdate$1) {
                mineVipModuleEnum$Subtitle$onUpdate$1 = (MineVipModuleEnum$Subtitle$onUpdate$1) continuation;
                if ((mineVipModuleEnum$Subtitle$onUpdate$1.label & Integer.MIN_VALUE) != 0) {
                    mineVipModuleEnum$Subtitle$onUpdate$1.label -= Integer.MIN_VALUE;
                    Object $result = mineVipModuleEnum$Subtitle$onUpdate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (mineVipModuleEnum$Subtitle$onUpdate$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            mineVipModuleEnum$Subtitle$onUpdate$1.label = 1;
                            if (super.onUpdate(model, mineVipModuleEnum$Subtitle$onUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            subtitle = this;
                            break;
                        case 1:
                            subtitle = this;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    subtitle.applyText();
                    sectionModel = subtitle.getSectionModel();
                    if (sectionModel != null || (colorResource = sectionModel.getColorResource()) == null) {
                        throw new Exception("subtitle color has exception. on " + subtitle.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
                    }
                    subtitle.applyTextColor(colorResource);
                    subtitle.applyImageColor(colorResource);
                    return Unit.INSTANCE;
                }
            }
            mineVipModuleEnum$Subtitle$onUpdate$1 = new MineVipModuleEnum$Subtitle$onUpdate$1(this, continuation);
            Object $result2 = mineVipModuleEnum$Subtitle$onUpdate$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (mineVipModuleEnum$Subtitle$onUpdate$1.label) {
            }
            subtitle.applyText();
            sectionModel = subtitle.getSectionModel();
            if (sectionModel != null) {
            }
            throw new Exception("subtitle color has exception. on " + subtitle.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
        }

        private final void applyTextColor(ColorResource colorResource) {
            TextView textView = this.textView;
            Context context = this.textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setTextColor(colorResource.getColorInt(context));
        }

        private final void applyImageColor(ColorResource colorResource) {
            Context context = this.arrowImage.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int color = colorResource.getColorInt(context);
            this.arrowImage.setColorFilter((-16777216) | color);
            ImageView imageView = this.arrowImage;
            int $this$alpha$iv = (color >> 24) & BR.hallCover;
            imageView.setAlpha($this$alpha$iv / 255.0f);
        }

        private final void applyText() {
            String string;
            String subtitle;
            TextView $this$applyText_u24lambda_u240 = this.textView;
            MineVipSubtitleModel sectionModel = getSectionModel();
            if ((sectionModel == null || (subtitle = sectionModel.getSubtitle()) == null || !(StringsKt.isBlank(subtitle) ^ true)) ? false : true) {
                MineVipSubtitleModel sectionModel2 = getSectionModel();
                string = sectionModel2 != null ? sectionModel2.getSubtitle() : null;
            } else {
                MineVipModel model = getModel();
                if (model != null ? Intrinsics.areEqual(model.isVip(), true) : false) {
                    string = $this$applyText_u24lambda_u240.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_33);
                } else {
                    MineVipModel model2 = getModel();
                    string = model2 != null ? Intrinsics.areEqual(model2.isVip(), false) : false ? $this$applyText_u24lambda_u240.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_55) : $this$applyText_u24lambda_u240.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_55);
                }
            }
            $this$applyText_u24lambda_u240.setText(string);
        }
    }

    /* compiled from: MineVipModuleManager.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum$Button;", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleEnum;", "buttonLayout", "Landroid/widget/LinearLayout;", "buttonText", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/LinearLayout;Landroid/widget/TextView;)V", "sectionModel", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonModel;", "getSectionModel", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipButtonModel;", "positionType", "Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "getPositionType", "()Ltv/danmaku/bili/ui/main2/mine/modularvip/PositionType;", "onTint", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdate", "model", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;", "(Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyButtonText", "", "applyButtonTextColor", "colorResource", "Ltv/danmaku/bili/ui/main2/mine/modularvip/ColorResource;", "applyBackground", "textColorResource", "backgroundColorResource", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Button extends MineVipModuleEnum {
        public static final int $stable = 8;
        private final LinearLayout buttonLayout;
        private final TextView buttonText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Button(LinearLayout buttonLayout, TextView buttonText) {
            super(null);
            Intrinsics.checkNotNullParameter(buttonLayout, "buttonLayout");
            Intrinsics.checkNotNullParameter(buttonText, "buttonText");
            this.buttonLayout = buttonLayout;
            this.buttonText = buttonText;
        }

        private final MineVipButtonModel getSectionModel() {
            MineVipModel model = getModel();
            if (model != null) {
                return model.getButton();
            }
            return null;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public PositionType getPositionType() {
            return PositionType.BUTTON;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        public Object onTint(Continuation<? super Unit> continuation) {
            ColorResource fallbackButtonTextColor;
            ColorResource fallbackButtonTextColor2;
            ColorResource fallbackButtonSolidColor;
            MineVipButtonModel sectionModel = getSectionModel();
            if (sectionModel == null || (fallbackButtonTextColor = sectionModel.getButtonTextColorResource()) == null) {
                fallbackButtonTextColor = MineVipModelKt.getFallbackButtonTextColor();
            }
            applyButtonTextColor(fallbackButtonTextColor);
            MineVipButtonModel sectionModel2 = getSectionModel();
            if (sectionModel2 == null || (fallbackButtonTextColor2 = sectionModel2.getButtonTextColorResource()) == null) {
                fallbackButtonTextColor2 = MineVipModelKt.getFallbackButtonTextColor();
            }
            MineVipButtonModel sectionModel3 = getSectionModel();
            if (sectionModel3 == null || (fallbackButtonSolidColor = sectionModel3.getBackgroundColorResource()) == null) {
                fallbackButtonSolidColor = MineVipModelKt.getFallbackButtonSolidColor();
            }
            applyBackground(fallbackButtonTextColor2, fallbackButtonSolidColor);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        @Override // tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleEnum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object onUpdate(MineVipModel model, Continuation<? super Unit> continuation) {
            MineVipModuleEnum$Button$onUpdate$1 mineVipModuleEnum$Button$onUpdate$1;
            Button button;
            MineVipButtonModel sectionModel;
            ColorResource buttonTextColorResource;
            ColorResource backgroundColorResource;
            ColorResource buttonTextColorResource2;
            if (continuation instanceof MineVipModuleEnum$Button$onUpdate$1) {
                mineVipModuleEnum$Button$onUpdate$1 = (MineVipModuleEnum$Button$onUpdate$1) continuation;
                if ((mineVipModuleEnum$Button$onUpdate$1.label & Integer.MIN_VALUE) != 0) {
                    mineVipModuleEnum$Button$onUpdate$1.label -= Integer.MIN_VALUE;
                    Object $result = mineVipModuleEnum$Button$onUpdate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (mineVipModuleEnum$Button$onUpdate$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            mineVipModuleEnum$Button$onUpdate$1.label = 1;
                            if (super.onUpdate(model, mineVipModuleEnum$Button$onUpdate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            button = this;
                            break;
                        case 1:
                            button = this;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    button.applyButtonText();
                    sectionModel = button.getSectionModel();
                    if (sectionModel != null || (buttonTextColorResource = sectionModel.getButtonTextColorResource()) == null) {
                        throw new Exception("button text color has exception. on " + button.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
                    }
                    MineVipButtonModel sectionModel2 = button.getSectionModel();
                    if (sectionModel2 != null && (backgroundColorResource = sectionModel2.getBackgroundColorResource()) != null) {
                        button.applyBackground(buttonTextColorResource, backgroundColorResource);
                        MineVipButtonModel sectionModel3 = button.getSectionModel();
                        if (sectionModel3 != null && (buttonTextColorResource2 = sectionModel3.getButtonTextColorResource()) != null) {
                            button.applyButtonTextColor(buttonTextColorResource2);
                            return Unit.INSTANCE;
                        }
                        throw new Exception("button text color has exception. on " + button.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
                    }
                    throw new Exception("button background color has exception. on " + button.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
                }
            }
            mineVipModuleEnum$Button$onUpdate$1 = new MineVipModuleEnum$Button$onUpdate$1(this, continuation);
            Object $result2 = mineVipModuleEnum$Button$onUpdate$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (mineVipModuleEnum$Button$onUpdate$1.label) {
            }
            button.applyButtonText();
            sectionModel = button.getSectionModel();
            if (sectionModel != null) {
            }
            throw new Exception("button text color has exception. on " + button.getPositionType().name() + FileUtils.HIDDEN_PREFIX);
        }

        private final boolean applyButtonText() {
            String string;
            String str;
            String buttonText;
            String takeIfNotBlank;
            TextView $this$applyButtonText_u24lambda_u240 = this.buttonText;
            $this$applyButtonText_u24lambda_u240.setTypeface(Typeface.DEFAULT_BOLD);
            MineVipButtonModel sectionModel = getSectionModel();
            if (sectionModel == null || (buttonText = sectionModel.getButtonText()) == null || (takeIfNotBlank = ListExtentionsKt.takeIfNotBlank(buttonText)) == null) {
                MineVipModel model = getModel();
                if (model != null ? Intrinsics.areEqual(model.isVip(), true) : false) {
                    string = $this$applyButtonText_u24lambda_u240.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_16);
                } else {
                    string = $this$applyButtonText_u24lambda_u240.getResources().getString(bili.resource.homepage.R.string.homepage_global_string_63);
                }
                Intrinsics.checkNotNullExpressionValue(string, "run(...)");
                str = string;
            } else {
                str = takeIfNotBlank;
            }
            $this$applyButtonText_u24lambda_u240.setText(str);
            return true;
        }

        private final void applyButtonTextColor(ColorResource colorResource) {
            TextView textView = this.buttonText;
            Context context = this.buttonText.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setTextColor(colorResource.getColorInt(context));
        }

        private final void applyBackground(ColorResource textColorResource, ColorResource backgroundColorResource) {
            int paintColor;
            MineVipButtonModel sectionModel = getSectionModel();
            boolean isStroke = (sectionModel != null ? sectionModel.getStyle() : null) == MineVipButtonStyle.STROKE;
            if (isStroke) {
                Context context = this.buttonLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                paintColor = textColorResource.getColorInt(context);
            } else {
                Context context2 = this.buttonLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                paintColor = backgroundColorResource.getColorInt(context2);
            }
            LinearLayout $this$applyBackground_u24lambda_u240 = this.buttonLayout;
            PaintDrawable $this$applyBackground_u24lambda_u240_u240 = new PaintDrawable();
            $this$applyBackground_u24lambda_u240_u240.setCornerRadius(ListExtentionsKt.toPx(100));
            Paint $this$applyBackground_u24lambda_u240_u240_u240 = $this$applyBackground_u24lambda_u240_u240.getPaint();
            $this$applyBackground_u24lambda_u240_u240_u240.setColor(paintColor);
            if (isStroke) {
                $this$applyBackground_u24lambda_u240_u240_u240.setStyle(Paint.Style.STROKE);
                $this$applyBackground_u24lambda_u240_u240_u240.setStrokeWidth(ListExtentionsKt.toPx(1));
            } else {
                $this$applyBackground_u24lambda_u240_u240_u240.setStyle(Paint.Style.FILL);
            }
            $this$applyBackground_u24lambda_u240.setBackground($this$applyBackground_u24lambda_u240_u240);
        }
    }
}