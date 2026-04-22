package tv.danmaku.bili.ui.splash.brand.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutKt;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import androidx.constraintlayout.compose.VerticalAnchorable;
import androidx.fragment.app.Fragment;
import com.bilibili.adcommon.utils.ext.ViewExtKt;
import com.bilibili.compose.image.BiliImageKt;
import com.bilibili.compose.image.BiliImageState;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.homepage.MainImageExtension;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.DecodedImageAcquireRequestBuilder;
import com.bilibili.lib.image2.bean.BaseImageDataSubscriber;
import com.bilibili.lib.image2.bean.DecodedImageHolder;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.StaticBitmapImageHolder;
import com.bilibili.lib.performance.EntryPointKt;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.R;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfo;
import tv.danmaku.bili.ui.splash.brand.model.BrandShowInfoKt;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.model.SplashImageCache;
import tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter;
import tv.danmaku.bili.ui.splash.common.search.QueryItem;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: BaseBrandSplashFragment.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\rH\u0004J&\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bJ/\u0010\u001f\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180!H\u0007¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010$\u001a\u00020\u0018H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/ui/BaseBrandSplashFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "mSplashContainer", "Landroid/view/View;", "getMSplashContainer", "()Landroid/view/View;", "setMSplashContainer", "(Landroid/view/View;)V", "mBitmap", "Landroid/graphics/Bitmap;", "composeEnable", "", "isSplashContainerInitialized", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "doOnCreateComposeView", "onViewCreated", "", "view", "doOnAndroidViewCreated", "brandInfo", "Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "setBitmapResource", "res", "BrandSplashScreen", "onSearchWordClick", "Lkotlin/Function0;", "(Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;Landroid/graphics/Bitmap;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "doAfterViewCreate", "exit", "Companion", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class BaseBrandSplashFragment extends BaseFragment {
    public static final String ARG_BRAND_INFO = "arg_brand_info";
    public static final String TAG = "BaseBrandSplashFragment";
    private boolean composeEnable;
    private Bitmap mBitmap;
    protected View mSplashContainer;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrandSplashScreen$lambda$0(BaseBrandSplashFragment baseBrandSplashFragment, BrandShowInfo brandShowInfo, Bitmap bitmap, Function0 function0, int i, Composer composer, int i2) {
        baseBrandSplashFragment.BrandSplashScreen(brandShowInfo, bitmap, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrandSplashScreen$lambda$3(BaseBrandSplashFragment baseBrandSplashFragment, BrandShowInfo brandShowInfo, Bitmap bitmap, Function0 function0, int i, Composer composer, int i2) {
        baseBrandSplashFragment.BrandSplashScreen(brandShowInfo, bitmap, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View getMSplashContainer() {
        View view2 = this.mSplashContainer;
        if (view2 != null) {
            return view2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSplashContainer");
        return null;
    }

    protected final void setMSplashContainer(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<set-?>");
        this.mSplashContainer = view2;
    }

    /* compiled from: BaseBrandSplashFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/ui/BaseBrandSplashFragment$Companion;", "", "<init>", "()V", "ARG_BRAND_INFO", "", "TAG", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isSplashContainerInitialized() {
        return this.mSplashContainer != null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        boolean it = EntryPointKt.getBrandSplashOptEnable();
        this.composeEnable = it;
        if (it) {
            return doOnCreateComposeView();
        }
        return inflater.inflate(R.layout.bili_app_layout_brand_splash_fragment, container, false);
    }

    private final View doOnCreateComposeView() {
        Bundle arguments;
        Bundle arguments2 = getArguments();
        Bundle bundle = arguments2 != null ? arguments2.getBundle("KEY_DEFAULT_EXTRA_BUNDLE") : null;
        if (bundle != null && (arguments = getArguments()) != null) {
            arguments.putAll(bundle);
        }
        Bundle arguments3 = getArguments();
        final BrandShowInfo brandInfo = arguments3 != null ? (BrandShowInfo) arguments3.getParcelable(ARG_BRAND_INFO) : null;
        if (brandInfo == null || BrandShowInfoKt.getBitmap(brandInfo) == null) {
            exit();
            return new View(requireContext());
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        final View composeView = new ComposeView(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-2034695063, true, new Function2() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit doOnCreateComposeView$lambda$0$0;
                doOnCreateComposeView$lambda$0$0 = BaseBrandSplashFragment.doOnCreateComposeView$lambda$0$0(BaseBrandSplashFragment.this, brandInfo, composeView, (Composer) obj, ((Integer) obj2).intValue());
                return doOnCreateComposeView$lambda$0$0;
            }
        }));
        Unit unit = Unit.INSTANCE;
        setMSplashContainer(composeView);
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    public static final Unit doOnCreateComposeView$lambda$0$0(BaseBrandSplashFragment this$0, final BrandShowInfo $brandInfo, final ComposeView $this_apply, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C111@4543L408,108@4398L571:BaseBrandSplashFragment.kt#9u3ybd");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2034695063, $changed, -1, "tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment.doOnCreateComposeView.<anonymous>.<anonymous> (BaseBrandSplashFragment.kt:108)");
            }
            Bitmap bitmap = BrandShowInfoKt.getBitmap($brandInfo);
            ComposerKt.sourceInformationMarkerStart($composer, -1131830239, "CC(remember):BaseBrandSplashFragment.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($brandInfo) | $composer.changedInstance($this_apply);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit doOnCreateComposeView$lambda$0$0$0$0;
                        doOnCreateComposeView$lambda$0$0$0$0 = BaseBrandSplashFragment.doOnCreateComposeView$lambda$0$0$0$0(BrandShowInfo.this, $this_apply);
                        return doOnCreateComposeView$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            this$0.BrandSplashScreen($brandInfo, bitmap, it$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doOnCreateComposeView$lambda$0$0$0$0(BrandShowInfo $brandInfo, ComposeView $this_apply) {
        HashMap param = new HashMap();
        HashMap hashMap = param;
        QueryItem queryItem = $brandInfo.getQueryItem();
        hashMap.put("flash_screen_query_id", String.valueOf(queryItem != null ? Long.valueOf(queryItem.getId()) : null));
        param.put("open_screen_mode", "3");
        param.put("is_login", BiliAccounts.get($this_apply.getContext()).isLogin() ? "1" : "0");
        BrandSplashReporter.reportSplashSearchWordClick(param);
        return Unit.INSTANCE;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Bundle arguments;
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        BLog.i(TAG, "onViewCreated");
        Bundle arguments2 = getArguments();
        Bundle bundle = arguments2 != null ? arguments2.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE) : null;
        if (bundle != null && (arguments = getArguments()) != null) {
            arguments.putAll(bundle);
        }
        Bundle arguments3 = getArguments();
        BrandShowInfo brandInfo = arguments3 != null ? (BrandShowInfo) arguments3.getParcelable(ARG_BRAND_INFO) : null;
        if (!this.composeEnable) {
            doOnAndroidViewCreated(view2, brandInfo);
        }
        doAfterViewCreate(brandInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doOnAndroidViewCreated(View view2, final BrandShowInfo brandInfo) {
        ImageView splashView;
        final int defaultLogoRes;
        view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BaseBrandSplashFragment.doOnAndroidViewCreated$lambda$0(view3);
            }
        });
        View findViewById = view2.findViewById(R.id.splash_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setMSplashContainer(findViewById);
        if (brandInfo == null || getContext() == null) {
            exit();
            return;
        }
        Bitmap brandBm = this.mBitmap != null ? this.mBitmap : BrandShowInfoKt.getBitmap(brandInfo);
        if (brandBm == null) {
            exit();
            return;
        }
        ViewGroup logoViewContainer = (ViewGroup) view2.findViewById(R.id.brand_logo_container);
        ViewGroup.LayoutParams lp = logoViewContainer.getLayoutParams();
        lp.height = getResources().getDisplayMetrics().heightPixels / 8;
        logoViewContainer.setLayoutParams(lp);
        View findViewById2 = view2.findViewById(R.id.brand_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        final ImageView logoView = (ImageView) findViewById2;
        if (Intrinsics.areEqual(brandInfo.getMode(), BrandSplashKt.MODE_FULL)) {
            View findViewById3 = view2.findViewById(R.id.full_brand_splash);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            splashView = (ImageView) findViewById3;
            defaultLogoRes = R.drawable.ic_logo_full_brand_default;
        } else {
            View findViewById4 = view2.findViewById(R.id.brand_splash);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            splashView = (ImageView) findViewById4;
            defaultLogoRes = R.drawable.ic_logo_default;
        }
        int defaultLogoRes2 = R.id.brand_search_container;
        ViewGroup searchContainer = (ViewGroup) view2.findViewById(defaultLogoRes2);
        TintTextView searchWord = view2.findViewById(R.id.brand_search_word);
        if (brandInfo.isDefault()) {
            QueryItem queryItem = brandInfo.getQueryItem();
            String query = queryItem != null ? queryItem.getQuery() : null;
            if (!(query == null || StringsKt.isBlank(query))) {
                ViewExtKt.visible(searchContainer);
                QueryItem queryItem2 = brandInfo.getQueryItem();
                searchWord.setText(queryItem2 != null ? queryItem2.getQuery() : null);
                if (searchContainer != null) {
                    searchContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            BaseBrandSplashFragment.doOnAndroidViewCreated$lambda$1(BrandShowInfo.this, this, view3);
                        }
                    });
                }
                logoView.setImageResource(defaultLogoRes);
                splashView.setVisibility(0);
                if (brandInfo.getShowLogo()) {
                    logoView.setVisibility(8);
                } else {
                    logoView.setVisibility(0);
                }
                splashView.setImageBitmap(brandBm);
                if (TextUtils.isEmpty(brandInfo.getLogoUrl())) {
                    DecodedImageAcquireRequestBuilder thumbnailUrlTransformStrategy = BiliImageLoader.INSTANCE.acquire((Fragment) this).with(360, 180).asDecodedImage().thumbnailUrlTransformStrategy(MainImageExtension.getThumbnailUrlTransformStrategy(0, 0, false));
                    String logoUrl = brandInfo.getLogoUrl();
                    Intrinsics.checkNotNull(logoUrl);
                    thumbnailUrlTransformStrategy.url(logoUrl).submit().subscribe(new BaseImageDataSubscriber<DecodedImageHolder<?>>() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$doOnAndroidViewCreated$3
                        protected void onNewResultImpl(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                            boolean activityDie;
                            if (imageDataSource != null && imageDataSource.getResult() != null) {
                                Object result = imageDataSource.getResult();
                                Intrinsics.checkNotNull(result);
                                StaticBitmapImageHolder staticBitmapImageHolder = (DecodedImageHolder) result;
                                if (staticBitmapImageHolder instanceof StaticBitmapImageHolder) {
                                    Bitmap bitmap = staticBitmapImageHolder.get();
                                    activityDie = BaseBrandSplashFragment.this.activityDie();
                                    if (activityDie) {
                                        return;
                                    }
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        logoView.setImageResource(defaultLogoRes);
                                    } else {
                                        logoView.setImageBitmap(bitmap);
                                    }
                                }
                            }
                        }

                        protected void onFailureImpl(ImageDataSource<DecodedImageHolder<?>> imageDataSource) {
                            logoView.setImageResource(defaultLogoRes);
                        }
                    });
                    return;
                }
                return;
            }
        }
        ViewExtKt.gone(searchContainer);
        if (searchContainer != null) {
        }
        logoView.setImageResource(defaultLogoRes);
        splashView.setVisibility(0);
        if (brandInfo.getShowLogo()) {
        }
        splashView.setImageBitmap(brandBm);
        if (TextUtils.isEmpty(brandInfo.getLogoUrl())) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnAndroidViewCreated$lambda$0(View it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnAndroidViewCreated$lambda$1(BrandShowInfo $brandInfo, BaseBrandSplashFragment this$0, View it) {
        HashMap param = new HashMap();
        HashMap hashMap = param;
        QueryItem queryItem = $brandInfo.getQueryItem();
        hashMap.put("flash_screen_query_id", String.valueOf(queryItem != null ? Long.valueOf(queryItem.getId()) : null));
        param.put("open_screen_mode", "3");
        param.put("is_login", BiliAccounts.get(this$0.getContext()).isLogin() ? "1" : "0");
        BrandSplashReporter.reportSplashSearchWordClick(param);
    }

    public final void setBitmapResource(Bitmap res) {
        this.mBitmap = res;
    }

    public final void BrandSplashScreen(final BrandShowInfo brandInfo, final Bitmap mBitmap, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(function0, "onSearchWordClick");
        Composer $composer4 = $composer.startRestartGroup(-317134882);
        ComposerKt.sourceInformation($composer4, "C(BrandSplashScreen)N(brandInfo,mBitmap,onSearchWordClick)261@10277L7,265@10395L6226,265@10385L6236:BaseBrandSplashFragment.kt#9u3ybd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(brandInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(mBitmap) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changedInstance(this) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        final boolean showSearch = false;
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-317134882, $dirty2, -1, "tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment.BrandSplashScreen (BaseBrandSplashFragment.kt:245)");
            }
            if (brandInfo == null) {
                $composer3 = $composer4;
            } else if (mBitmap == null && BrandShowInfoKt.getBitmap(brandInfo) == null) {
                $composer3 = $composer4;
            } else {
                final Bitmap brandBm = mBitmap == null ? BrandShowInfoKt.getBitmap(brandInfo) : mBitmap;
                final int defaultLogoRes = Intrinsics.areEqual(brandInfo.getMode(), BrandSplashKt.MODE_FULL) ? R.drawable.ic_logo_full_brand_default : R.drawable.ic_logo_default;
                if (brandInfo.isDefault()) {
                    QueryItem queryItem = brandInfo.getQueryItem();
                    String query = queryItem != null ? queryItem.getQuery() : null;
                    if (!(query == null || StringsKt.isBlank(query))) {
                        showSearch = true;
                    }
                }
                $composer4.startReplaceGroup(176078930);
                ComposerKt.sourceInformation($composer4, "*262@10320L7");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer4.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density $this$BrandSplashScreen_u24lambda_u241 = (Density) consume;
                CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer4.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                int $this$dp$iv = ((Configuration) consume2).screenHeightDp;
                final int logoContainerHeightPx = (int) ($this$BrandSplashScreen_u24lambda_u241.toPx-0680j_4(Dp.constructor-impl($this$dp$iv)) / 8);
                $composer4.endReplaceGroup();
                $composer2 = $composer4;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1266762458, true, new Function2() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2) {
                        Unit BrandSplashScreen$lambda$2;
                        BrandSplashScreen$lambda$2 = BaseBrandSplashFragment.BrandSplashScreen$lambda$2(BrandShowInfo.this, brandBm, showSearch, function0, logoContainerHeightPx, defaultLogoRes, (Composer) obj, ((Integer) obj2).intValue());
                        return BrandSplashScreen$lambda$2;
                    }
                }, $composer4, 54), $composer4, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            exit();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        Unit BrandSplashScreen$lambda$0;
                        BrandSplashScreen$lambda$0 = BaseBrandSplashFragment.BrandSplashScreen$lambda$0(BaseBrandSplashFragment.this, brandInfo, mBitmap, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                        return BrandSplashScreen$lambda$0;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer4;
        $composer2.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit BrandSplashScreen$lambda$3;
                    BrandSplashScreen$lambda$3 = BaseBrandSplashFragment.BrandSplashScreen$lambda$3(BaseBrandSplashFragment.this, brandInfo, mBitmap, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BrandSplashScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrandSplashScreen$lambda$2(final BrandShowInfo $brandInfo, Bitmap $brandBm, boolean $showSearch, final Function0 $onSearchWordClick, int $logoContainerHeightPx, final int $defaultLogoRes, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String str;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        Function0 factory$iv$iv$iv2;
        String str2;
        String str3;
        BoxScope $this$BrandSplashScreen_u24lambda_u242_u241;
        Object value$iv$iv$iv;
        Object value$iv$iv$iv2;
        Object value$iv$iv$iv3;
        Function0 factory$iv$iv$iv3;
        ComposerKt.sourceInformation($composer, "C270@10550L41,273@10693L14,266@10409L6202:BaseBrandSplashFragment.kt#9u3ybd");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1266762458, $changed, -1, "tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment.BrandSplashScreen.<anonymous> (BaseBrandSplashFragment.kt:266)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), ColorResources_androidKt.colorResource(17170443, $composer, 6), RectangleShapeKt.getRectangleShape());
            ComposerKt.sourceInformationMarkerStart($composer, -1882967820, "CC(remember):BaseBrandSplashFragment.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$BrandSplashScreen_u24lambda_u242_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1997499947, "C:BaseBrandSplashFragment.kt#9u3ybd");
            if (Intrinsics.areEqual($brandInfo.getMode(), BrandSplashKt.MODE_FULL)) {
                $composer.startReplaceGroup(-1997606154);
                ComposerKt.sourceInformation($composer, "");
                if ($brandBm == null) {
                    $composer.startReplaceGroup(-1997606155);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-1997606154);
                    ComposerKt.sourceInformation($composer, "*278@10897L268");
                    ImageKt.Image-5h-nEew(AndroidImageBitmap_androidKt.asImageBitmap($brandBm), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment) null, ContentScale.Companion.getCrop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, 0, $composer, 25008, 232);
                    Unit unit = Unit.INSTANCE;
                    $composer.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                $composer.endReplaceGroup();
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv$iv = $composer;
                $composer$iv2 = $composer;
                str = "";
                $composer$iv$iv = $composer;
                str2 = "CC(remember):BaseBrandSplashFragment.kt#9igjgp";
                $composer$iv = $composer;
            } else {
                $composer.startReplaceGroup(-1997221258);
                ComposerKt.sourceInformation($composer, "");
                if ($brandBm == null) {
                    $composer.startReplaceGroup(-1997221259);
                    $composer.endReplaceGroup();
                    str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv$iv$iv = $composer;
                    $composer$iv2 = $composer;
                    str = "";
                    $composer$iv$iv = $composer;
                    str2 = "CC(remember):BaseBrandSplashFragment.kt#9igjgp";
                    $composer$iv = $composer;
                } else {
                    $composer.startReplaceGroup(-1997221258);
                    ComposerKt.sourceInformation($composer, "*287@11272L684");
                    str = "";
                    Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(20));
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    $composer$iv = $composer;
                    ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv2 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                    $composer$iv$iv = $composer;
                    $composer$iv$iv$iv = $composer;
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    $composer$iv2 = $composer;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv5;
                        $composer.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv5;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                    str2 = "CC(remember):BaseBrandSplashFragment.kt#9igjgp";
                    str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i4 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1775158260, "C293@11541L389:BaseBrandSplashFragment.kt#9u3ybd");
                    ImageKt.Image-5h-nEew(AndroidImageBitmap_androidKt.asImageBitmap($brandBm), (String) null, SizeKt.fillMaxHeight(SizeKt.fillMaxWidth(Modifier.Companion, 0.9f), 0.9f), (Alignment) null, ContentScale.Companion.getInside(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, 0, $composer, 25008, 232);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Unit unit3 = Unit.INSTANCE;
                    $composer.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                }
                $composer.endReplaceGroup();
            }
            if ($brandInfo.getShowLogo()) {
                $composer.startReplaceGroup(-1996392628);
                ComposerKt.sourceInformation($composer, "309@12189L7,307@12086L1122");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density $this$BrandSplashScreen_u24lambda_u242_u241_u242 = (Density) consume;
                $this$BrandSplashScreen_u24lambda_u242_u241 = $this$BrandSplashScreen_u24lambda_u242_u2412;
                Modifier modifier$iv3 = $this$BrandSplashScreen_u24lambda_u242_u241.align(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, $this$BrandSplashScreen_u24lambda_u242_u241_u242.toDp-u2uoSUM($logoContainerHeightPx)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Alignment.Companion.getBottomCenter());
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Box = $changed$iv$iv3 << 6;
                int $changed$iv$iv$iv3 = ($i$f$Box & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str3);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i6 = ((0 >> 6) & 112) | 6;
                BoxScope $this$BrandSplashScreen_u24lambda_u242_u241_u243 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 1586875965, "C321@12735L364,314@12384L802:BaseBrandSplashFragment.kt#9u3ybd");
                String logoUrl = $brandInfo.getLogoUrl();
                BiliImageKt.BiliImage(logoUrl == null ? str : logoUrl, $this$BrandSplashScreen_u24lambda_u242_u241_u243.align(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(120)), Dp.constructor-impl(60)), Alignment.Companion.getBottomCenter()), (String) null, false, 0, (String) null, false, ComposableLambdaKt.rememberComposableLambda(-841517213, true, new Function3() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit BrandSplashScreen$lambda$2$1$3$0;
                        BrandSplashScreen$lambda$2$1$3$0 = BaseBrandSplashFragment.BrandSplashScreen$lambda$2$1$3$0($defaultLogoRes, (BiliImageState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return BrandSplashScreen$lambda$2$1$3$0;
                    }
                }, $composer, 54), (Alignment) null, ContentScale.Companion.getFit(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer, 817889280, 0, 3452);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                $this$BrandSplashScreen_u24lambda_u242_u241 = $this$BrandSplashScreen_u24lambda_u242_u2412;
                $composer.startReplaceGroup(-2008397130);
            }
            $composer.endReplaceGroup();
            if ($showSearch) {
                $composer.startReplaceGroup(-1995114746);
                ComposerKt.sourceInformation($composer, "339@13494L7,340@13569L83,336@13307L3272");
                Modifier align = $this$BrandSplashScreen_u24lambda_u242_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
                CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                int $this$dp$iv = ((Configuration) consume2).screenHeightDp;
                Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(align, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(Dp.constructor-impl($this$dp$iv) * 0.15f), 7, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 212741983, str2);
                boolean invalid$iv = $composer.changed($onSearchWordClick);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit BrandSplashScreen$lambda$2$1$4$0;
                            BrandSplashScreen$lambda$2$1$4$0 = BaseBrandSplashFragment.BrandSplashScreen$lambda$2$1$4$0($onSearchWordClick);
                            return BrandSplashScreen$lambda$2$1$4$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv4 = BackgroundKt.background-bw27NRU(ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Color.Companion.getTransparent-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20)));
                $composer.startReplaceableGroup(-270267587);
                ComposerKt.sourceInformation($composer, "C(ConstraintLayout)P(1,2)");
                $composer.startReplaceableGroup(-3687241);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv$iv = $composer.rememberedValue();
                if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                    value$iv$iv$iv = new Measurer();
                    $composer.updateRememberedValue(value$iv$iv$iv);
                } else {
                    value$iv$iv$iv = it$iv$iv$iv;
                }
                $composer.endReplaceableGroup();
                final Measurer measurer$iv = (Measurer) value$iv$iv$iv;
                $composer.startReplaceableGroup(-3687241);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv$iv2 = $composer.rememberedValue();
                if (it$iv$iv$iv2 == Composer.Companion.getEmpty()) {
                    value$iv$iv$iv2 = new ConstraintLayoutScope();
                    $composer.updateRememberedValue(value$iv$iv$iv2);
                } else {
                    value$iv$iv$iv2 = it$iv$iv$iv2;
                }
                $composer.endReplaceableGroup();
                final ConstraintLayoutScope scope$iv = (ConstraintLayoutScope) value$iv$iv$iv2;
                $composer.startReplaceableGroup(-3687241);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv$iv3 = $composer.rememberedValue();
                if (it$iv$iv$iv3 == Composer.Companion.getEmpty()) {
                    value$iv$iv$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer.updateRememberedValue(value$iv$iv$iv3);
                } else {
                    value$iv$iv$iv3 = it$iv$iv$iv3;
                }
                $composer.endReplaceableGroup();
                MutableState remeasureRequesterState$iv = (MutableState) value$iv$iv$iv3;
                Pair rememberConstraintLayoutMeasurePolicy = ConstraintLayoutKt.rememberConstraintLayoutMeasurePolicy((int) IjkMediaPlayer.FFP_BUFFERING_END_REASON_ENOUGH_SIZE, scope$iv, remeasureRequesterState$iv, measurer$iv, $composer, ((0 >> 3) & 14) | 4544);
                MeasurePolicy measurePolicy$iv4 = (MeasurePolicy) rememberConstraintLayoutMeasurePolicy.component1();
                final Function0 onHelpersChanged$iv = (Function0) rememberConstraintLayoutMeasurePolicy.component2();
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier$iv4, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$BrandSplashScreen$lambda$2$1$$inlined$ConstraintLayout$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((SemanticsPropertyReceiver) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
                        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
                        ToolingUtilsKt.setDesignInfoProvider($this$semantics, measurer$iv);
                    }
                }, 1, (Object) null), ComposableLambdaKt.composableLambda($composer, -819894182, true, new Function2<Composer, Integer, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$BrandSplashScreen$lambda$2$1$$inlined$ConstraintLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        if ((($changed2 & 11) ^ 2) != 0 || !$composer2.getSkipping()) {
                            int previousHelpersHashCode = scope$iv.getHelpersHashCode();
                            scope$iv.reset();
                            ConstraintLayoutScope $this$BrandSplashScreen_u24lambda_u242_u241_u245 = scope$iv;
                            int i7 = ((r2 >> 3) & 112) | 8;
                            $composer2.startReplaceGroup(1077863819);
                            ComposerKt.sourceInformation($composer2, "C355@14254L10,357@14379L56,360@14575L322,351@14021L957,372@15153L218,380@15556L61,370@15039L710,388@15852L54,391@16071L234,398@16474L56,387@15807L750:BaseBrandSplashFragment.kt#9u3ybd");
                            ConstraintLayoutScope.ConstrainedLayoutReferences createRefs = $this$BrandSplashScreen_u24lambda_u242_u241_u245.createRefs();
                            ConstrainedLayoutReference searchWordRef = createRefs.component1();
                            final ConstrainedLayoutReference searchBtnBgRef = createRefs.component2();
                            ConstrainedLayoutReference searchIconRef = createRefs.component3();
                            QueryItem queryItem = $brandInfo.getQueryItem();
                            String query = queryItem != null ? queryItem.getQuery() : null;
                            if (query == null) {
                                query = "";
                            }
                            String str4 = query;
                            int i8 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBody1(), ColorResources_androidKt.colorResource(com.bilibili.lib.theme.R.color.Text1, $composer2, 0), 0L, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777210, (Object) null);
                            Modifier modifier3 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart($composer2, -519400170, "CC(remember):BaseBrandSplashFragment.kt#9igjgp");
                            boolean invalid$iv2 = $composer2.changed(searchBtnBgRef);
                            Object it$iv3 = $composer2.rememberedValue();
                            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                                Object value$iv3 = (Function1) new Function1<ConstrainScope, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$BrandSplashScreen$2$2$6$1$1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        invoke((ConstrainScope) p1);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ConstrainScope $this$constrainAs) {
                                        Intrinsics.checkNotNullParameter($this$constrainAs, "$this$constrainAs");
                                        VerticalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getStart(), $this$constrainAs.getParent().getStart(), Dp.constructor-impl(24), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 4, (Object) null);
                                        VerticalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getEnd(), searchBtnBgRef.getStart(), Dp.constructor-impl(8), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 4, (Object) null);
                                        HorizontalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getTop(), $this$constrainAs.getParent().getTop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null);
                                        HorizontalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getBottom(), $this$constrainAs.getParent().getBottom(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null);
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv3);
                                it$iv3 = value$iv3;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            TextKt.Text--4IGK_g(str4, SizeKt.widthIn-VpY3zN4$default($this$BrandSplashScreen_u24lambda_u242_u241_u245.constrainAs(modifier3, searchWordRef, (Function1) it$iv3), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(140), 1, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i8, false, 1, 0, (Function1) null, textStyle, $composer2, 0, 3120, 55292);
                            Modifier modifier4 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart($composer2, -519381778, "CC(remember):BaseBrandSplashFragment.kt#9igjgp");
                            Object it$iv4 = $composer2.rememberedValue();
                            if (it$iv4 == Composer.Companion.getEmpty()) {
                                Object value$iv4 = (Function1) new Function1<ConstrainScope, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$BrandSplashScreen$2$2$6$2$1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        invoke((ConstrainScope) p1);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ConstrainScope $this$constrainAs) {
                                        Intrinsics.checkNotNullParameter($this$constrainAs, "$this$constrainAs");
                                        VerticalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getEnd(), $this$constrainAs.getParent().getEnd(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null);
                                        HorizontalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getTop(), $this$constrainAs.getParent().getTop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null);
                                        HorizontalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getBottom(), $this$constrainAs.getParent().getBottom(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null);
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv4);
                                it$iv4 = value$iv4;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs($this$BrandSplashScreen_u24lambda_u242_u241_u245.constrainAs(modifier4, searchBtnBgRef, (Function1) it$iv4), Dp.constructor-impl(50)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), ColorResources_androidKt.colorResource(com.bilibili.lib.theme.R.color.Brand_pink, $composer2, 0), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20))), $composer2, 0);
                            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_vector_search_icon, $composer2, 0);
                            Modifier modifier5 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart($composer2, -519352386, "CC(remember):BaseBrandSplashFragment.kt#9igjgp");
                            Object it$iv5 = $composer2.rememberedValue();
                            if (it$iv5 == Composer.Companion.getEmpty()) {
                                Object value$iv5 = (Function1) new Function1<ConstrainScope, Unit>() { // from class: tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment$BrandSplashScreen$2$2$6$3$1
                                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                        invoke((ConstrainScope) p1);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ConstrainScope $this$constrainAs) {
                                        Intrinsics.checkNotNullParameter($this$constrainAs, "$this$constrainAs");
                                        VerticalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getEnd(), $this$constrainAs.getParent().getEnd(), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 4, (Object) null);
                                        HorizontalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getTop(), $this$constrainAs.getParent().getTop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null);
                                        HorizontalAnchorable.DefaultImpls.linkTo-VpY3zN4$default($this$constrainAs.getBottom(), $this$constrainAs.getParent().getBottom(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 6, (Object) null);
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv5);
                                it$iv5 = value$iv5;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ImageKt.Image(painterResource, (String) null, BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs($this$BrandSplashScreen_u24lambda_u242_u241_u245.constrainAs(modifier5, searchIconRef, (Function1) it$iv5), Dp.constructor-impl(26)), Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null), (Alignment) null, (ContentScale) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, ColorResources_androidKt.colorResource(com.bilibili.lib.theme.R.color.Wh0_u, $composer2, 0), 0, 2, (Object) null), $composer2, Painter.$stable | 48, 56);
                            $composer2.endReplaceGroup();
                            if (scope$iv.getHelpersHashCode() != previousHelpersHashCode) {
                                onHelpersChanged$iv.invoke();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }), measurePolicy$iv4, $composer, 48, 0);
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceGroup(-2008397130);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrandSplashScreen$lambda$2$1$3$0(int $defaultLogoRes, BiliImageState it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)323@12822L36,322@12769L300:BaseBrandSplashFragment.kt#9u3ybd");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-841517213, $changed, -1, "tv.danmaku.bili.ui.splash.brand.ui.BaseBrandSplashFragment.BrandSplashScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BaseBrandSplashFragment.kt:322)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource($defaultLogoRes, $composer, 0), "Icon", SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (Alignment) null, (ContentScale) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrandSplashScreen$lambda$2$1$4$0(Function0 $onSearchWordClick) {
        $onSearchWordClick.invoke();
        return Unit.INSTANCE;
    }

    public void doAfterViewCreate(BrandShowInfo brandInfo) {
    }

    public void exit() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mBitmap = null;
        SplashImageCache.INSTANCE.clear();
    }
}