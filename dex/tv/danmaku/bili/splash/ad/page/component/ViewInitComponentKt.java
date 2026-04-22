package tv.danmaku.bili.splash.ad.page.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.bilibili.adcommon.data.AdReportInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.utils.GsonKtKt;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.debug.AdDebugPlugin;
import com.bilibili.gripper.api.ad.core.debug.DebugMarkStyle;
import com.bilibili.gripper.api.ad.core.debug.IInspector;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.homepage.MainImageExtension;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.common.model.AdSlot;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.R;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.splash.ad.widget.SplashContainerView;
import tv.danmaku.bili.splash.ad.widget.SplashImageView;

/* compiled from: ViewInitComponent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"initView", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "setLogoHeight", "setGuideline", "showLogoView", "initRootContainerListener", "showADAndWifiLabel", "displayMainImage", "mainImage", "Ltv/danmaku/bili/splash/ad/widget/SplashImageView;", "setAdInspector", "TAG", "", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ViewInitComponentKt {
    private static final String TAG = "[Splash]ViewInitComponent";

    public static final void initView(BaseSplash $this$initView) {
        Intrinsics.checkNotNullParameter($this$initView, "<this>");
        setLogoHeight($this$initView);
        setGuideline($this$initView);
        showLogoView($this$initView);
        $this$initView.showMainMaterial();
        showADAndWifiLabel($this$initView);
        CountdownComponentKt.showSkipButton($this$initView);
        GuideButtonLayerComponentKt.showGuideButton($this$initView);
        DanmakuComponentKt.initDanmakuView($this$initView);
        FullScreenSlideComponentKt.initSplashSlideInteractLayer($this$initView);
        initRootContainerListener($this$initView);
        PrepareComponentKt.prepareSplash($this$initView);
        setAdInspector($this$initView);
    }

    private static final void setLogoHeight(BaseSplash $this$setLogoHeight) {
        ConstraintLayout logoLayout = $this$setLogoHeight.getBinding$adsplash_debug().logoLayout;
        Intrinsics.checkNotNullExpressionValue(logoLayout, "logoLayout");
        logoLayout.setBackgroundColor(ExperimentViewComponentKt.getLogoLayoutBgColor($this$setLogoHeight));
        ViewGroup.LayoutParams lp = logoLayout.getLayoutParams();
        if (lp != null) {
            lp.height = ExperimentViewComponentKt.getBottomLogoHeight($this$setLogoHeight);
        } else {
            lp = null;
        }
        logoLayout.setLayoutParams(lp);
        logoLayout.setClickable(!ExtSplashOrderKt.isFullScreen($this$setLogoHeight.getSplash$adsplash_debug()));
    }

    private static final void setGuideline(BaseSplash $this$setGuideline) {
        ConstraintSet set = new ConstraintSet();
        set.clone($this$setGuideline.getBinding$adsplash_debug().rootContainer);
        set.setGuidelineBegin(R.id.guideline, StatusBarCompat.getStatusBarHeight($this$setGuideline.getContext()) + ListExtentionsKt.toPx(24));
        set.applyTo($this$setGuideline.getBinding$adsplash_debug().rootContainer);
    }

    private static final void showLogoView(BaseSplash $this$showLogoView) {
        String $this$showLogoView_u24lambda_u240;
        String $this$showLogoView_u24lambda_u2402;
        Context context = $this$showLogoView.getContext();
        if (context == null) {
            return;
        }
        BiliImageView logoView = $this$showLogoView.getBinding$adsplash_debug().logo;
        Intrinsics.checkNotNullExpressionValue(logoView, "logo");
        ConstraintLayout.LayoutParams layoutParams = $this$showLogoView.getBinding$adsplash_debug().logo.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.horizontalBias = ExtSplashOrderKt.isFullScreen($this$showLogoView.getSplash$adsplash_debug()) ? 0.0f : 0.5f;
        layoutParams2.height = (int) (ExperimentViewComponentKt.getBottomLogoHeight($this$showLogoView) * (ExtSplashOrderKt.isFullScreen($this$showLogoView.getSplash$adsplash_debug()) ? 0.56d : 0.6d));
        layoutParams2.width = layoutParams2.height * 2;
        $this$showLogoView.getBinding$adsplash_debug().logo.setLayoutParams((ViewGroup.LayoutParams) layoutParams2);
        File logoFile = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash($this$showLogoView.getSplash$adsplash_debug().getLogoHash());
        if (logoFile == null || ($this$showLogoView_u24lambda_u2402 = logoFile.getAbsolutePath()) == null || (BusinessSplashDefine.FILE_URI_PREFIX + $this$showLogoView_u24lambda_u2402) == null) {
            $this$showLogoView_u24lambda_u240 = $this$showLogoView.getSplash$adsplash_debug().getLogoUrl();
        }
        String str = $this$showLogoView_u24lambda_u240;
        if (str == null || StringsKt.isBlank(str)) {
            int logoDrawableId = ExtSplashOrderKt.isFullScreen($this$showLogoView.getSplash$adsplash_debug()) ? R.drawable.ic_logo_full_default : R.drawable.ic_logo_default;
            Drawable $this$showLogoView_u24lambda_u241 = ResourcesCompat.getDrawable(context.getResources(), logoDrawableId, (Resources.Theme) null);
            if ($this$showLogoView_u24lambda_u241 != null) {
                logoView.getGenericProperties().setImage($this$showLogoView_u24lambda_u241);
                return;
            }
            return;
        }
        ImageRequestBuilder.failureImageResId$default(BiliImageLoader.INSTANCE.with(context).url($this$showLogoView_u24lambda_u240).thumbnailUrlTransformStrategy(MainImageExtension.getThumbnailUrlTransformStrategy(0, 0, false)), ExtSplashOrderKt.isFullScreen($this$showLogoView.getSplash$adsplash_debug()) ? R.drawable.ic_logo_full_default : R.drawable.ic_logo_default, (ScaleType) null, 2, (Object) null).into(logoView);
    }

    private static final void initRootContainerListener(final BaseSplash $this$initRootContainerListener) {
        $this$initRootContainerListener.getBinding$adsplash_debug().rootContainer.setOnClickEventListener(new SplashContainerView.OnClickEventListener() { // from class: tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt$initRootContainerListener$1
            @Override // tv.danmaku.bili.splash.ad.widget.SplashContainerView.OnClickEventListener
            public void onClick(final float x, final float y) {
                if (Float.isNaN(x) || Float.isNaN(y)) {
                    return;
                }
                List<SplashGuideButton> splashGuideButton = BaseSplash.this.getSplash$adsplash_debug().getSplashGuideButton();
                final boolean hasButton = !(splashGuideButton == null || splashGuideButton.isEmpty());
                SplashContainerView splashContainerView = BaseSplash.this.getBinding$adsplash_debug().rootContainer;
                Intrinsics.checkNotNullExpressionValue(splashContainerView, "rootContainer");
                final View $this$doOnPreDraw$iv = (View) splashContainerView;
                final BaseSplash baseSplash = BaseSplash.this;
                OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt$initRootContainerListener$1$onClick$$inlined$doOnPreDraw$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        View view = $this$doOnPreDraw$iv;
                        int containerWidth = baseSplash.getBinding$adsplash_debug().rootContainer.getWidth();
                        int containerHeight = baseSplash.getBinding$adsplash_debug().rootContainer.getHeight();
                        if (containerWidth == 0 || containerHeight == 0) {
                            return;
                        }
                        SplashAdHelper.INSTANCE.adSplashClickPositionReport$adsplash_debug(baseSplash.getSplash$adsplash_debug(), containerWidth, containerHeight, x, y, hasButton);
                    }
                });
            }
        });
        $this$initRootContainerListener.getBinding$adsplash_debug().getRoot().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt$initRootContainerListener$attachListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                BaseSplash.this.onDestroyView();
            }
        });
    }

    private static final void showADAndWifiLabel(BaseSplash $this$showADAndWifiLabel) {
        ExperimentViewComponentKt.getAdLabelView($this$showADAndWifiLabel).setVisibility($this$showADAndWifiLabel.getSplash$adsplash_debug().getCmMark() == 1 ? 0 : 8);
        ExperimentViewComponentKt.getAdLabelView($this$showADAndWifiLabel).setText(bili.resource.homepage.R.string.homepage_global_string_385);
    }

    public static final void displayMainImage(BaseSplash $this$displayMainImage, SplashImageView mainImage) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$displayMainImage, "<this>");
        if (mainImage == null) {
            return;
        }
        if ($this$displayMainImage.getSplash$adsplash_debug().isRealTimeSplash() && $this$displayMainImage.getSplash$adsplash_debug().getRuntimeExtra().getRealTimeSplashBitmap() != null) {
            BLog.i(TAG, "show real time splash bmp");
            mainImage.setImageBitmap($this$displayMainImage.getSplash$adsplash_debug().getRuntimeExtra().getRealTimeSplashBitmap());
            return;
        }
        String localImagePath = BusinessSplashResHelperKt.fetchResourceLocalPathByHash($this$displayMainImage.getSplash$adsplash_debug().getImageHash());
        if (localImagePath == null) {
            BLog.e(TAG, "resource fetch failed");
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Bitmap bm = BitmapFactory.decodeFile(localImagePath);
            mainImage.setImageBitmap(bm);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            FileUtils.deleteQuietly(new File(localImagePath));
            CrashReporter.INSTANCE.postCaughtException(it);
            BLog.e(TAG, "load splash error");
        }
    }

    private static final void setAdInspector(final BaseSplash $this$setAdInspector) {
        GAdCoreKt.getGAdDebug().getInspector().addInspectorInfo(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                IInspector.InspectorInfo adInspector$lambda$0;
                adInspector$lambda$0 = ViewInitComponentKt.setAdInspector$lambda$0(BaseSplash.this);
                return adInspector$lambda$0;
            }
        });
        IInspector.IJob job = GAdCoreKt.getGAdDebug().getInspector().getDrawingStage($this$setAdInspector.getSplash$adsplash_debug().getAdCb()).addAsyncJob("卡片渲染");
        job.start();
        Iterable $this$forEach$iv = GAdCoreKt.getGAdDebug().getPlugins();
        Iterator it = $this$forEach$iv.iterator();
        while (true) {
            JsonElement jsonElement = null;
            if (it.hasNext()) {
                Object element$iv = it.next();
                AdDebugPlugin plugin = (AdDebugPlugin) element$iv;
                SplashContainerView root = $this$setAdInspector.getBinding$adsplash_debug().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                View view = (View) root;
                IAdReportInfo build = new AdReportInfo.Builder(true).adcb($this$setAdInspector.getSplash$adsplash_debug().getAdCb()).build();
                String simpleName = $this$setAdInspector.getClass().getSimpleName();
                JsonObject extra = $this$setAdInspector.getSplash$adsplash_debug().getExtra();
                if (extra != null) {
                    jsonElement = extra.get("sales_type");
                }
                AdDebugPlugin.hook$default(plugin, view, build, (Function0) null, new DebugMarkStyle(0, simpleName, "sales_type:" + jsonElement + ",\ncreative_id:" + $this$setAdInspector.getSplash$adsplash_debug().getSplashCreativeId(), 1, (DefaultConstructorMarker) null), AdSlot.SPALSH, 4, (Object) null);
            } else {
                IInspector.IJob.-CC.success$default(job, (String) null, 1, (Object) null);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IInspector.InspectorInfo setAdInspector$lambda$0(final BaseSplash $this_setAdInspector) {
        JsonElement jsonElement;
        AdSlot adSlot = AdSlot.SPALSH;
        String jumpTip = $this_setAdInspector.getSplash$adsplash_debug().getJumpTip();
        String valueOf = String.valueOf($this_setAdInspector.getSplash$adsplash_debug().getSplashCreativeId());
        JsonObject extra = $this_setAdInspector.getSplash$adsplash_debug().getExtra();
        String valueOf2 = String.valueOf(extra != null ? extra.get("sales_type") : null);
        String adCb = $this_setAdInspector.getSplash$adsplash_debug().getAdCb();
        if (adCb == null) {
            adCb = "";
        }
        String str = adCb;
        JsonObject extra2 = $this_setAdInspector.getSplash$adsplash_debug().getExtra();
        IInspector.AdData it = new IInspector.AdData(str, jumpTip, valueOf2, (Integer) null, valueOf, (extra2 == null || (jsonElement = extra2.get("track_id")) == null) ? null : jsonElement.getAsString());
        it.setRawAction(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.ViewInitComponentKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                String adInspector$lambda$0$0$0;
                adInspector$lambda$0$0$0 = ViewInitComponentKt.setAdInspector$lambda$0$0$0(BaseSplash.this);
                return adInspector$lambda$0$0$0;
            }
        });
        return new IInspector.InspectorInfo(adSlot, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setAdInspector$lambda$0$0$0(BaseSplash $this_setAdInspector) {
        return GsonKtKt.getJsonString($this_setAdInspector.getSplash$adsplash_debug());
    }
}