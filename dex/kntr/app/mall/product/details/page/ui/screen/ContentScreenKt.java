package kntr.app.mall.product.details.page.ui.screen;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.compose.LifecycleExtKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import com.bilibili.framework.simpleplayer.SimplePlayerView_androidKt;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.ui.components.ActivityCouponSheetComponentKt;
import kntr.app.mall.product.details.page.ui.components.BenefitDetailSheetComponentKt;
import kntr.app.mall.product.details.page.ui.components.BottomSheetKt;
import kntr.app.mall.product.details.page.ui.components.CouponPopupComponentKt;
import kntr.app.mall.product.details.page.ui.components.HeaderBannerSectionKt;
import kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt;
import kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt;
import kntr.app.mall.product.details.page.ui.components.SkuSwitchSheetComponentKt;
import kntr.app.mall.product.details.page.ui.container.BottomContainerKt;
import kntr.app.mall.product.details.page.ui.container.ScrollContainerKt;
import kntr.app.mall.product.details.page.ui.container.TopContainerKt;
import kntr.app.mall.product.details.page.ui.floatingLayer.CouponReserveResultDialogKt;
import kntr.app.mall.product.details.page.ui.floatingLayer.LikedCollectionFloatingLayerKt;
import kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt;
import kntr.app.mall.product.details.page.ui.floatingLayer.RetainPopupDialogKt;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.ImageBottomSheetState;
import kntr.app.mall.product.details.page.vm.ImagePreviewState;
import kntr.app.mall.product.details.page.vm.ModuleViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.mall.product.details.page.vm.VideoPlayerViewModel;
import kntr.app.mall.product.details.page.vm.VideoPlayerViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.pagecontroller.OnBackPressedCallback_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ContentScreen.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u008a\u0084\u0002"}, d2 = {"ContentScreen", "", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "contentModules", "", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "firstVisibleItemIndex", "", "shouldShowHeaderPreview", "", "scrollOffset", "", "showActivityCouponSheet", "imagePreviewState", "Lkntr/app/mall/product/details/page/vm/ImagePreviewState;", "showSkuSwitchSheet", "showBenefitSheet", "showCouponReserveDialogResult", "isRetainPopupVisible", "imageBottomSheetState", "Lkntr/app/mall/product/details/page/vm/ImageBottomSheetState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ContentScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$16(PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ContentScreen(pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x068e, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0da2, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0e5f, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0eff, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0653, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r1v103 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContentScreen(final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        final PageViewModel pageViewModel2;
        LazyStaggeredGridState listState;
        OnBackPressedDispatcher backHandler;
        Modifier modifier3;
        LazyStaggeredGridState listState2;
        ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1 upSaySimplePlayer;
        float maxScrollOffset;
        State scaleModel$delegate;
        ?? r1;
        String str;
        ContentScreenKt$ContentScreen$simplePlayer$1$1 simplePlayer;
        Composer $composer3;
        ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1 upSaySimplePlayer2;
        final LazyStaggeredGridState listState3;
        final float maxScrollOffset2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function2 movableUpSayVideoView;
        Function2 movableVideoPlayerView;
        VideoPlayerViewModel videoViewModel;
        OnBackPressedDispatcher backHandler2;
        Object obj;
        Composer $composer$iv;
        Composer $composer4;
        Modifier modifier4;
        State isRetainPopupVisible$delegate;
        int i2;
        BasicInfoFloor data;
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer5 = $composer.startRestartGroup(1721160808);
        ComposerKt.sourceInformation($composer5, "C(ContentScreen)N(pageViewModel,modifier)83@4612L16,84@4684L16,85@4752L7,86@4780L32,88@4865L7,92@4984L46,92@4974L56,95@5078L16,96@5111L24,97@5182L16,98@5245L16,99@5322L16,100@5384L7,100@5402L21,102@5455L747,121@6308L16,122@6346L24,123@6427L16,124@6500L16,125@6587L16,127@6640L777,147@7511L122,155@7729L386,167@8156L396,179@8631L16,182@8705L992,210@9756L901,235@10697L301,250@11136L12,252@11206L17,258@11333L16,254@11229L13090:ContentScreen.kt#dsyj5e");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changedInstance(pageViewModel) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer5.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer5.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier5 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1721160808, $dirty2, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen (ContentScreen.kt:82)");
            }
            State scaleModel$delegate2 = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer5, 0, 1);
            State contentModules$delegate = SnapshotStateKt.collectAsState(pageViewModel.getContentModules$product_details_page_debug(), (CoroutineContext) null, $composer5, 0, 1);
            OnBackPressedDispatcher backHandler3 = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer5, LocalOnBackPressedDispatcher.$stable);
            final LazyStaggeredGridState listState4 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, $composer5, 0, 3);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer5.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Density $this$ContentScreen_u24lambda_u242 = (Density) consume;
            float $this$dp$iv = Dp.constructor-impl(150.0f);
            float maxScrollOffset3 = $this$ContentScreen_u24lambda_u242.toPx-0680j_4($this$dp$iv);
            ComposerKt.sourceInformationMarkerStart($composer5, 473144118, "CC(remember):ContentScreen.kt#9igjgp");
            Object it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2) {
                        VideoPlayerViewModel ContentScreen$lambda$3$0;
                        ContentScreen$lambda$3$0 = ContentScreenKt.ContentScreen$lambda$3$0((CreationExtras) obj2);
                        return ContentScreen$lambda$3$0;
                    }
                };
                $composer5.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 initializer$iv = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer5, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer5, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VideoPlayerViewModel.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(VideoPlayerViewModel.class), initializer$iv);
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer5, ((384 << 3) & 112) | ((384 << 3) & 896), 0);
            $composer5.endReplaceableGroup();
            final VideoPlayerViewModel videoViewModel2 = (VideoPlayerViewModel) viewModel;
            final State urlState = SnapshotStateKt.collectAsState(pageViewModel.getVideoUrlState(), (CoroutineContext) null, $composer5, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer5, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer5.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5);
                $composer5.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final State mutedState = SnapshotStateKt.collectAsState(videoViewModel2.getMutedFlow(), (CoroutineContext) null, $composer5, 0, 1);
            final State pauseState = SnapshotStateKt.collectAsState(videoViewModel2.getPauseFlow(), (CoroutineContext) null, $composer5, 0, 1);
            final State pauseByOtherState = SnapshotStateKt.collectAsState(videoViewModel2.getPauseByOtherFlow(), (CoroutineContext) null, $composer5, 0, 1);
            CompositionLocal this_$iv2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer5.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final State lifecycleState = LifecycleExtKt.currentStateAsState(((LifecycleOwner) consume2).getLifecycle(), $composer5, 0);
            ComposerKt.sourceInformationMarkerStart($composer5, 473159891, "CC(remember):ContentScreen.kt#9igjgp");
            Object it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new SimplePlayer(scope) { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$ContentScreen$simplePlayer$1$1
                    public String getUrl() {
                        String str2 = (String) urlState.getValue();
                        return str2 == null ? "" : str2;
                    }

                    public float getVolume() {
                        return ((Boolean) mutedState.getValue()).booleanValue() ? 0.0f : 1.0f;
                    }

                    public boolean getLoop() {
                        return true;
                    }

                    public boolean getIntendToPlay() {
                        return (((Boolean) pauseState.getValue()).booleanValue() || ((Boolean) pauseByOtherState.getValue()).booleanValue() || ((Lifecycle.State) lifecycleState.getValue()).compareTo(Lifecycle.State.RESUMED) < 0) ? false : true;
                    }

                    /* renamed from: firstFrameRendered-LRDsOJo  reason: not valid java name */
                    public void m629firstFrameRenderedLRDsOJo(long j) {
                        super.firstFrameRendered-LRDsOJo(j);
                        videoViewModel2.m647firstFrameRenderedLRDsOJo$product_details_page_debug(j);
                    }
                };
                $composer5.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final ContentScreenKt$ContentScreen$simplePlayer$1$1 simplePlayer2 = (ContentScreenKt$ContentScreen$simplePlayer$1$1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            videoViewModel2.setSimplePlayer(simplePlayer2);
            final State upSayUrlState = SnapshotStateKt.collectAsState(pageViewModel.getUpSayVideoUrlState(), (CoroutineContext) null, $composer5, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer5, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv2 = $composer5.rememberedValue();
            if (value$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5);
                $composer5.updateRememberedValue(value$iv$iv2);
            }
            final CoroutineScope upSayScope = (CoroutineScope) value$iv$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final State upSayMutedState = SnapshotStateKt.collectAsState(videoViewModel2.getUpSayMutedFlow(), (CoroutineContext) null, $composer5, 0, 1);
            final State upSayPauseState = SnapshotStateKt.collectAsState(videoViewModel2.getUpSayPauseFlow(), (CoroutineContext) null, $composer5, 0, 1);
            final State upSayPauseByOtherState = SnapshotStateKt.collectAsState(videoViewModel2.getUpSayPauseByOtherFlow(), (CoroutineContext) null, $composer5, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer5, 473197841, "CC(remember):ContentScreen.kt#9igjgp");
            Object it$iv3 = $composer5.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new SimplePlayer(upSayScope) { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1
                    public String getUrl() {
                        String str2 = (String) upSayUrlState.getValue();
                        return str2 == null ? "" : str2;
                    }

                    public float getVolume() {
                        return ((Boolean) upSayMutedState.getValue()).booleanValue() ? 0.0f : 1.0f;
                    }

                    public boolean getLoop() {
                        return true;
                    }

                    public boolean getIntendToPlay() {
                        return (((Boolean) upSayPauseState.getValue()).booleanValue() || ((Boolean) upSayPauseByOtherState.getValue()).booleanValue() || ((Lifecycle.State) lifecycleState.getValue()).compareTo(Lifecycle.State.RESUMED) < 0) ? false : true;
                    }

                    /* renamed from: firstFrameRendered-LRDsOJo  reason: not valid java name */
                    public void m630firstFrameRenderedLRDsOJo(long j) {
                        super.firstFrameRendered-LRDsOJo(j);
                        videoViewModel2.m648upSayFirstFrameRenderedLRDsOJo$product_details_page_debug(j);
                    }
                };
                $composer5.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1 upSaySimplePlayer3 = (ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            videoViewModel2.setUpSayPlayer(upSaySimplePlayer3);
            ComposerKt.sourceInformationMarkerStart($composer5, 473225058, "CC(remember):ContentScreen.kt#9igjgp");
            boolean invalid$iv = $composer5.changed(listState4);
            Object it$iv4 = $composer5.rememberedValue();
            if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        int firstVisibleItemIndex;
                        firstVisibleItemIndex = listState4.getFirstVisibleItemIndex();
                        return Integer.valueOf(firstVisibleItemIndex);
                    }
                });
                $composer5.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final State firstVisibleItemIndex$delegate = (State) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 473232298, "CC(remember):ContentScreen.kt#9igjgp");
            Object it$iv5 = $composer5.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = MovableContentKt.movableContentOf(ComposableLambdaKt.composableLambdaInstance(812337871, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ContentScreen$lambda$8$0;
                        ContentScreen$lambda$8$0 = ContentScreenKt.ContentScreen$lambda$8$0(ContentScreenKt$ContentScreen$simplePlayer$1$1.this, (Composer) obj2, ((Integer) obj3).intValue());
                        return ContentScreen$lambda$8$0;
                    }
                }));
                $composer5.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final Function2 movableVideoPlayerView2 = (Function2) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 473245972, "CC(remember):ContentScreen.kt#9igjgp");
            Object it$iv6 = $composer5.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                listState = listState4;
                Object value$iv6 = MovableContentKt.movableContentOf(ComposableLambdaKt.composableLambdaInstance(945294, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ContentScreen$lambda$9$0;
                        ContentScreen$lambda$9$0 = ContentScreenKt.ContentScreen$lambda$9$0(ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1.this, (Composer) obj2, ((Integer) obj3).intValue());
                        return ContentScreen$lambda$9$0;
                    }
                }));
                $composer5.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            } else {
                listState = listState4;
            }
            final Function2 movableUpSayVideoView2 = (Function2) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            final LazyStaggeredGridState listState5 = listState;
            final State shouldShowHeaderPreview$delegate = SnapshotStateKt.collectAsState(pageViewModel.getShowHeaderFullScreenPreview(), (CoroutineContext) null, $composer5, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer5, 473264136, "CC(remember):ContentScreen.kt#9igjgp");
            Object value$iv7 = $composer5.rememberedValue();
            if (value$iv7 == Composer.Companion.getEmpty()) {
                backHandler = backHandler3;
                scaleModel$delegate = scaleModel$delegate2;
                upSaySimplePlayer = upSaySimplePlayer3;
                maxScrollOffset = maxScrollOffset3;
                modifier3 = modifier5;
                listState2 = listState5;
                Function2 function2 = new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ContentScreen$lambda$11$0;
                        ContentScreen$lambda$11$0 = ContentScreenKt.ContentScreen$lambda$11$0(PageViewModel.this, videoViewModel2, movableVideoPlayerView2, movableUpSayVideoView2, listState5, shouldShowHeaderPreview$delegate, firstVisibleItemIndex$delegate, (Composer) obj2, ((Integer) obj3).intValue());
                        return ContentScreen$lambda$11$0;
                    }
                };
                r1 = 1;
                value$iv7 = (Function2) ComposableLambdaKt.composableLambdaInstance(-1905190084, true, function2);
                $composer5.updateRememberedValue(value$iv7);
            } else {
                backHandler = backHandler3;
                modifier3 = modifier5;
                listState2 = listState5;
                upSaySimplePlayer = upSaySimplePlayer3;
                maxScrollOffset = maxScrollOffset3;
                scaleModel$delegate = scaleModel$delegate2;
                r1 = 1;
            }
            Function2 normalHeaderBannerSection = (Function2) value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 473297677, "CC(remember):ContentScreen.kt#9igjgp");
            Object it$iv7 = $composer5.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                str = "CC(remember):ContentScreen.kt#9igjgp";
                upSaySimplePlayer2 = upSaySimplePlayer;
                simplePlayer = simplePlayer2;
                $composer3 = $composer5;
                final LazyStaggeredGridState lazyStaggeredGridState = listState2;
                Object value$iv8 = (Function2) ComposableLambdaKt.composableLambdaInstance(-1019725815, (boolean) r1, new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit ContentScreen$lambda$12$0;
                        ContentScreen$lambda$12$0 = ContentScreenKt.ContentScreen$lambda$12$0(PageViewModel.this, videoViewModel2, movableVideoPlayerView2, movableUpSayVideoView2, lazyStaggeredGridState, shouldShowHeaderPreview$delegate, (Composer) obj2, ((Integer) obj3).intValue());
                        return ContentScreen$lambda$12$0;
                    }
                });
                $composer5.updateRememberedValue(value$iv8);
                it$iv7 = value$iv8;
            } else {
                str = "CC(remember):ContentScreen.kt#9igjgp";
                simplePlayer = simplePlayer2;
                $composer3 = $composer5;
                upSaySimplePlayer2 = upSaySimplePlayer;
            }
            Function2 previewHeaderBannerSection = (Function2) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Composer $composer6 = $composer3;
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart($composer6, 473327189, str2);
            Object it$iv8 = $composer6.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                listState3 = listState2;
                maxScrollOffset2 = maxScrollOffset;
                Object value$iv9 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        float ContentScreen$lambda$13$0;
                        ContentScreen$lambda$13$0 = ContentScreenKt.ContentScreen$lambda$13$0(listState3, maxScrollOffset2);
                        return Float.valueOf(ContentScreen$lambda$13$0);
                    }
                });
                $composer6.updateRememberedValue(value$iv9);
                it$iv8 = value$iv9;
            } else {
                listState3 = listState2;
                maxScrollOffset2 = maxScrollOffset;
            }
            State scrollOffset$delegate = (State) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            int $this$dp$iv2 = Integer.parseInt(pageViewModel.getStatusBarHeight());
            float topInsets = Dp.constructor-impl($this$dp$iv2);
            PaddingValues bottomInsets = WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer6, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer6, 0);
            Modifier modifier6 = modifier3;
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier6, 0.0f, (int) r1, (Object) null), ThemesKt.getPageBgColor($composer6, 0), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer6.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$ContentScreen_u24lambda_u2415 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, 1801003857, "C266@11770L16,263@11480L60,267@11818L139,261@11401L746,278@12185L289,291@12552L21,295@12747L29,289@12504L529,304@13059L378,315@13465L382,326@13894L48,363@15636L306,373@16052L16,375@16112L183,387@16553L83,398@17095L75,385@16462L708,403@17262L16,405@17326L170,420@17957L379,416@17741L595,432@18420L16,434@18481L173,446@18904L73,457@19436L70,444@18818L688,462@19595L16,476@20221L16,478@20292L189,490@20784L89,488@20676L266,497@20990L328,507@21435L16,510@21571L16,515@21722L876,511@21596L1002,535@22691L77,533@22607L223,541@22909L16,544@23038L68,551@23310L904,542@22934L1280,577@24224L89:ContentScreen.kt#dsyj5e");
            List<ContentModule> ContentScreen$lambda$1 = ContentScreen$lambda$1(contentModules$delegate);
            float f = Dp.constructor-impl(bottomInsets.calculateBottomPadding-D9Ej5fM() + ProvideUiScaleKt.dpScaled(60, ContentScreen$lambda$0(scaleModel$delegate).getScale()));
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(pageViewModel.getLoadingState(), (CoroutineContext) null, $composer6, 0, 1).getValue()).booleanValue();
            PageViewModelWrapper wrapper$product_details_page_debug = pageViewModel.getWrapper$product_details_page_debug();
            VideoPlayerViewModelWrapper wrapper = videoViewModel2.getWrapper();
            ComposerKt.sourceInformationMarkerStart($composer6, -496102754, str2);
            boolean invalid$iv2 = $composer6.changedInstance(pageViewModel);
            Object value$iv10 = $composer6.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv10 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj2) {
                    ModuleViewModel ContentScreen$lambda$15$0$0;
                    ContentScreen$lambda$15$0$0 = ContentScreenKt.ContentScreen$lambda$15$0$0(PageViewModel.this, (FloorType) obj2);
                    return ContentScreen$lambda$15$0$0;
                }
            };
            $composer6.updateRememberedValue(value$iv10);
            Function1 function1 = value$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerStart($composer6, -496091859, str2);
            boolean invalid$iv3 = $composer6.changedInstance(pageViewModel);
            Object it$iv9 = $composer6.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv11 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda16
                public final Object invoke() {
                    Unit ContentScreen$lambda$15$1$0;
                    ContentScreen$lambda$15$1$0 = ContentScreenKt.ContentScreen$lambda$15$1$0(PageViewModel.this);
                    return ContentScreen$lambda$15$1$0;
                }
            };
            $composer6.updateRememberedValue(value$iv11);
            it$iv9 = value$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ScrollContainerKt.m580ScrollContainerdsL6K2w(listState3, function1, f, booleanValue, (Function0) it$iv9, wrapper$product_details_page_debug, wrapper, normalHeaderBannerSection, ContentScreen$lambda$1, $composer6, 12582912, 0);
            TopContainerKt.m586TopContainerEUb7tLY(ContentScreen$lambda$14(scrollOffset$delegate), topInsets, listState3, pageViewModel.getWrapper$product_details_page_debug(), $this$ContentScreen_u24lambda_u2415.align(Modifier.Companion, Alignment.Companion.getTopStart()), $composer6, 0, 0);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default($this$ContentScreen_u24lambda_u2415.align(BackgroundKt.background-bw27NRU$default(ThemesKt.isCurrentThemeLight($composer6, 0) ? BorderKt.border-xT4_qwU$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(0.5d, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ColorKt.Color(4293125607L), (Shape) null, 4, (Object) null) : Modifier.Companion, ThemesKt.getPageBottomOperationColor($composer6, 0), (Shape) null, 2, (Object) null), Alignment.Companion.getBottomCenter()), 0.0f, 0.0f, 0.0f, bottomInsets.calculateBottomPadding-D9Ej5fM(), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer6.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -1991469429, "C299@12931L92:ContentScreen.kt#dsyj5e");
            BottomContainerKt.BottomContainer(pageViewModel.getWrapper$product_details_page_debug(), null, $composer6, 0, 2);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            LotteryDashFloatingLayerKt.LotteryDashFloatingLayer(pageViewModel.getWrapper$product_details_page_debug(), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default($this$ContentScreen_u24lambda_u2415.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), ProvideUiScaleKt.dpScaled(8, ContentScreen$lambda$0(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, bottomInsets.calculateBottomPadding-D9Ej5fM(), 7, (Object) null), $composer6, 0, 0);
            LikedCollectionFloatingLayerKt.LikedCollectionFloatingLayer(pageViewModel.getWrapper$product_details_page_debug(), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default($this$ContentScreen_u24lambda_u2415.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getBottomCenter()), ProvideUiScaleKt.dpScaled(8, ContentScreen$lambda$0(scaleModel$delegate).getScale()), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, bottomInsets.calculateBottomPadding-D9Ej5fM(), 7, (Object) null), $composer6, 0, 0);
            LiveInfoFloatingComponentKt.LiveInfoFloatingComponent(pageViewModel.getWrapper$product_details_page_debug(), null, $composer6, 0, 2);
            if (ContentScreen$lambda$10(shouldShowHeaderPreview$delegate) || ContentScreen$lambda$7(firstVisibleItemIndex$delegate) <= 0) {
                pageViewModel2 = pageViewModel;
                movableUpSayVideoView = movableUpSayVideoView2;
                movableVideoPlayerView = movableVideoPlayerView2;
                videoViewModel = videoViewModel2;
                $composer2 = $composer6;
                $composer6.startReplaceGroup(1789292800);
            } else {
                $composer6.startReplaceGroup(1803242273);
                ComposerKt.sourceInformation($composer6, "338@14510L44,339@14586L27,340@14645L27,329@14025L769,354@15307L44,355@15383L32,356@15447L32,345@14808L792");
                String str3 = (String) urlState.getValue();
                float f2 = bottomInsets.calculateBottomPadding-D9Ej5fM();
                boolean booleanValue2 = ((Boolean) mutedState.getValue()).booleanValue();
                boolean booleanValue3 = ((Boolean) pauseState.getValue()).booleanValue();
                boolean booleanValue4 = ((Boolean) pauseByOtherState.getValue()).booleanValue();
                Lifecycle.State state = (Lifecycle.State) lifecycleState.getValue();
                ContentScreenKt$ContentScreen$simplePlayer$1$1 contentScreenKt$ContentScreen$simplePlayer$1$1 = simplePlayer;
                ComposerKt.sourceInformationMarkerStart($composer6, -496005810, str2);
                pageViewModel2 = pageViewModel;
                $composer2 = $composer6;
                boolean invalid$iv4 = $composer2.changedInstance(pageViewModel2);
                Object it$iv10 = $composer6.rememberedValue();
                if (invalid$iv4 || it$iv10 == Composer.Companion.getEmpty()) {
                    Object value$iv12 = (KFunction) new ContentScreenKt$ContentScreen$1$4$1(pageViewModel2);
                    $composer6.updateRememberedValue(value$iv12);
                    it$iv10 = value$iv12;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Function1 function12 = (KFunction) it$iv10;
                ComposerKt.sourceInformationMarkerStart($composer6, -496003395, str2);
                videoViewModel = videoViewModel2;
                boolean invalid$iv5 = $composer6.changedInstance(videoViewModel);
                Object it$iv11 = $composer6.rememberedValue();
                if (invalid$iv5 || it$iv11 == Composer.Companion.getEmpty()) {
                    Object value$iv13 = (KFunction) new ContentScreenKt$ContentScreen$1$5$1(videoViewModel);
                    $composer6.updateRememberedValue(value$iv13);
                    it$iv11 = value$iv13;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Function0 function0 = (KFunction) it$iv11;
                ComposerKt.sourceInformationMarkerStart($composer6, -496001507, str2);
                boolean invalid$iv6 = $composer6.changedInstance(videoViewModel);
                Object it$iv12 = $composer6.rememberedValue();
                if (invalid$iv6 || it$iv12 == Composer.Companion.getEmpty()) {
                    Object value$iv14 = (KFunction) new ContentScreenKt$ContentScreen$1$6$1(videoViewModel);
                    $composer6.updateRememberedValue(value$iv14);
                    it$iv12 = value$iv14;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                movableVideoPlayerView = movableVideoPlayerView2;
                MiniVideoFloatingComponentKt.m511MiniVideoFloatingComponenthqqSWsU(str3, topInsets, f2, booleanValue2, booleanValue3, booleanValue4, state, contentScreenKt$ContentScreen$simplePlayer$1$1, function12, function0, (KFunction) it$iv12, movableVideoPlayerView, ContentScreen$lambda$0(scaleModel$delegate).getScale(), null, $composer6, 12582912, 48, 8192);
                String str4 = (String) upSayUrlState.getValue();
                float f3 = bottomInsets.calculateBottomPadding-D9Ej5fM();
                boolean booleanValue5 = ((Boolean) upSayMutedState.getValue()).booleanValue();
                boolean booleanValue6 = ((Boolean) upSayPauseState.getValue()).booleanValue();
                boolean booleanValue7 = ((Boolean) upSayPauseByOtherState.getValue()).booleanValue();
                Lifecycle.State state2 = (Lifecycle.State) lifecycleState.getValue();
                ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1 contentScreenKt$ContentScreen$upSaySimplePlayer$1$1 = upSaySimplePlayer2;
                ComposerKt.sourceInformationMarkerStart($composer6, -495980306, str2);
                boolean invalid$iv7 = $composer2.changedInstance(pageViewModel2);
                Object it$iv13 = $composer6.rememberedValue();
                if (invalid$iv7 || it$iv13 == Composer.Companion.getEmpty()) {
                    Object value$iv15 = (KFunction) new ContentScreenKt$ContentScreen$1$7$1(pageViewModel2);
                    $composer6.updateRememberedValue(value$iv15);
                    it$iv13 = value$iv15;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Function1 function13 = (KFunction) it$iv13;
                ComposerKt.sourceInformationMarkerStart($composer6, -495977886, str2);
                boolean invalid$iv8 = $composer6.changedInstance(videoViewModel);
                Object it$iv14 = $composer6.rememberedValue();
                if (invalid$iv8 || it$iv14 == Composer.Companion.getEmpty()) {
                    Object value$iv16 = (KFunction) new ContentScreenKt$ContentScreen$1$8$1(videoViewModel);
                    $composer6.updateRememberedValue(value$iv16);
                    it$iv14 = value$iv16;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Function0 function02 = (KFunction) it$iv14;
                ComposerKt.sourceInformationMarkerStart($composer6, -495975838, str2);
                boolean invalid$iv9 = $composer6.changedInstance(videoViewModel);
                Object it$iv15 = $composer6.rememberedValue();
                if (invalid$iv9 || it$iv15 == Composer.Companion.getEmpty()) {
                    Object value$iv17 = (KFunction) new ContentScreenKt$ContentScreen$1$9$1(videoViewModel);
                    $composer6.updateRememberedValue(value$iv17);
                    it$iv15 = value$iv17;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                movableUpSayVideoView = movableUpSayVideoView2;
                MiniVideoFloatingComponentKt.m511MiniVideoFloatingComponenthqqSWsU(str4, topInsets, f3, booleanValue5, booleanValue6, booleanValue7, state2, contentScreenKt$ContentScreen$upSaySimplePlayer$1$1, function13, function02, (KFunction) it$iv15, movableUpSayVideoView, ContentScreen$lambda$0(scaleModel$delegate).getScale(), null, $composer6, 12582912, 48, 8192);
            }
            $composer6.endReplaceGroup();
            FullScreenHeaderPreviewKt.FullScreenHeaderPreview(pageViewModel.getWrapper$product_details_page_debug(), videoViewModel.getWrapper(), previewHeaderBannerSection, PaddingKt.padding(Modifier.Companion, bottomInsets), $composer6, 384, 0);
            State showActivityCouponSheet$delegate = SnapshotStateKt.collectAsState(pageViewModel.getShowActivityCouponSheet(), (CoroutineContext) null, $composer6, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer6, -495954407, str2);
            Object it$iv16 = $composer6.rememberedValue();
            if (it$iv16 == Composer.Companion.getEmpty()) {
                Object value$iv18 = OnBackPressedCallback_androidKt.OnBackPressedCallback(true, new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj2) {
                        Unit ContentScreen$lambda$15$10$0;
                        ContentScreen$lambda$15$10$0 = ContentScreenKt.ContentScreen$lambda$15$10$0(PageViewModel.this, (OnBackPressedCallback) obj2);
                        return ContentScreen$lambda$15$10$0;
                    }
                });
                $composer6.updateRememberedValue(value$iv18);
                it$iv16 = value$iv18;
            }
            OnBackPressedCallback activityCallback = (OnBackPressedCallback) it$iv16;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ContentScreen$lambda$15$9(showActivityCouponSheet$delegate)) {
                backHandler2 = backHandler;
                backHandler2.addCallback(activityCallback);
            } else {
                backHandler2 = backHandler;
                activityCallback.remove();
            }
            boolean ContentScreen$lambda$15$9 = ContentScreen$lambda$15$9(showActivityCouponSheet$delegate);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(ProvideUiScaleKt.dpScaled(16, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(24, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(16, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(16, ContentScreen$lambda$0(scaleModel$delegate).getScale()));
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(ProvideUiScaleKt.dpScaled(12, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(12, ContentScreen$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 12, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, -495940395, str2);
            boolean invalid$iv10 = $composer2.changedInstance(pageViewModel2);
            Object it$iv17 = $composer6.rememberedValue();
            if (invalid$iv10 || it$iv17 == Composer.Companion.getEmpty()) {
                Object value$iv19 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda20
                    public final Object invoke() {
                        Unit ContentScreen$lambda$15$11$0;
                        ContentScreen$lambda$15$11$0 = ContentScreenKt.ContentScreen$lambda$15$11$0(PageViewModel.this);
                        return ContentScreen$lambda$15$11$0;
                    }
                };
                $composer6.updateRememberedValue(value$iv19);
                it$iv17 = value$iv19;
            }
            ComposerKt.sourceInformationMarkerEnd($composer6);
            BottomSheetKt.m416CustomizedBottomSheetFU0evQE((Function0) it$iv17, ContentScreen$lambda$15$9, 0L, shape, paddingValues, ComposableLambdaKt.rememberComposableLambda(-386346378, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit ContentScreen$lambda$15$12;
                    ContentScreen$lambda$15$12 = ContentScreenKt.ContentScreen$lambda$15$12(PageViewModel.this, (BoxScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return ContentScreen$lambda$15$12;
                }
            }, $composer6, 54), $composer6, 196608, 4);
            final State imagePreviewState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getImagePreviewState$product_details_page_debug(), (CoroutineContext) null, $composer6, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer6, -495915572, str2);
            Object it$iv18 = $composer6.rememberedValue();
            if (it$iv18 == Composer.Companion.getEmpty()) {
                Object value$iv20 = OnBackPressedCallback_androidKt.OnBackPressedCallback(true, new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj2) {
                        Unit ContentScreen$lambda$15$14$0;
                        ContentScreen$lambda$15$14$0 = ContentScreenKt.ContentScreen$lambda$15$14$0(PageViewModel.this, (OnBackPressedCallback) obj2);
                        return ContentScreen$lambda$15$14$0;
                    }
                });
                $composer6.updateRememberedValue(value$iv20);
                it$iv18 = value$iv20;
            }
            OnBackPressedCallback imagePreviewCallback = (OnBackPressedCallback) it$iv18;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ImagePreviewState ContentScreen$lambda$15$13 = ContentScreen$lambda$15$13(imagePreviewState$delegate);
            List<String> imageUrls = ContentScreen$lambda$15$13 != null ? ContentScreen$lambda$15$13.getImageUrls() : null;
            boolean showImagePreview = !(imageUrls == null || imageUrls.isEmpty());
            if (showImagePreview) {
                backHandler2.addCallback(imagePreviewCallback);
            } else {
                imagePreviewCallback.remove();
            }
            AnimatedVisibilityKt.AnimatedVisibility(showImagePreview, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(1081948618, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit ContentScreen$lambda$15$15;
                    ContentScreen$lambda$15$15 = ContentScreenKt.ContentScreen$lambda$15$15(PageViewModel.this, imagePreviewState$delegate, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return ContentScreen$lambda$15$15;
                }
            }, $composer6, 54), $composer6, 200064, 18);
            State showSkuSwitchSheet$delegate = SnapshotStateKt.collectAsState(pageViewModel.getShowSkuSwitch(), (CoroutineContext) null, $composer6, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer6, -495878609, str2);
            Object it$iv19 = $composer6.rememberedValue();
            if (it$iv19 == Composer.Companion.getEmpty()) {
                Object value$iv21 = OnBackPressedCallback_androidKt.OnBackPressedCallback(true, new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda24
                    public final Object invoke(Object obj2) {
                        Unit ContentScreen$lambda$15$17$0;
                        ContentScreen$lambda$15$17$0 = ContentScreenKt.ContentScreen$lambda$15$17$0(PageViewModel.this, (OnBackPressedCallback) obj2);
                        return ContentScreen$lambda$15$17$0;
                    }
                });
                $composer6.updateRememberedValue(value$iv21);
                it$iv19 = value$iv21;
            }
            OnBackPressedCallback skuSwitchCallback = (OnBackPressedCallback) it$iv19;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ContentScreen$lambda$15$16(showSkuSwitchSheet$delegate)) {
                backHandler2.addCallback(skuSwitchCallback);
            } else {
                skuSwitchCallback.remove();
            }
            boolean ContentScreen$lambda$15$16 = ContentScreen$lambda$15$16(showSkuSwitchSheet$delegate);
            PaddingValues paddingValues2 = PaddingKt.PaddingValues-a9UjIt4(ProvideUiScaleKt.dpScaled(16, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(24, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(16, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(16, ContentScreen$lambda$0(scaleModel$delegate).getScale()));
            Shape shape2 = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(ProvideUiScaleKt.dpScaled(12, ContentScreen$lambda$0(scaleModel$delegate).getScale()), ProvideUiScaleKt.dpScaled(12, ContentScreen$lambda$0(scaleModel$delegate).getScale()), 0.0f, 0.0f, 12, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, -495865173, str2);
            boolean invalid$iv11 = $composer2.changedInstance(pageViewModel2);
            Object it$iv20 = $composer6.rememberedValue();
            if (invalid$iv11) {
            }
            Object value$iv22 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda25
                public final Object invoke() {
                    Unit ContentScreen$lambda$15$18$0;
                    ContentScreen$lambda$15$18$0 = ContentScreenKt.ContentScreen$lambda$15$18$0(PageViewModel.this);
                    return ContentScreen$lambda$15$18$0;
                }
            };
            $composer6.updateRememberedValue(value$iv22);
            it$iv20 = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            BottomSheetKt.m416CustomizedBottomSheetFU0evQE((Function0) it$iv20, ContentScreen$lambda$15$16, 0L, shape2, paddingValues2, ComposableLambdaKt.rememberComposableLambda(-671616353, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit ContentScreen$lambda$15$19;
                    ContentScreen$lambda$15$19 = ContentScreenKt.ContentScreen$lambda$15$19(PageViewModel.this, (BoxScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return ContentScreen$lambda$15$19;
                }
            }, $composer6, 54), $composer6, 196608, 4);
            State showBenefitSheet$delegate = SnapshotStateKt.collectAsState(pageViewModel.getShowBenefitBottomSheet(), (CoroutineContext) null, $composer6, 0, 1);
            Iterator it = ContentScreen$lambda$1(contentModules$delegate).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ContentModule it2 = (ContentModule) obj;
                if (it2 instanceof ContentModule.BasicInfoModule) {
                    break;
                }
            }
            ContentModule.BasicInfoModule basicInfoModule = obj instanceof ContentModule.BasicInfoModule ? (ContentModule.BasicInfoModule) obj : null;
            BasicInfoFloor.ItemsBenefitsInfo benefitInfo = (basicInfoModule == null || (data = basicInfoModule.getData()) == null) ? null : data.getItemsBenefitsInfo();
            if (benefitInfo == null) {
                $composer6.startReplaceGroup(1808931609);
                $composer6.endReplaceGroup();
            } else {
                $composer6.startReplaceGroup(1808931610);
                ComposerKt.sourceInformation($composer6, "*468@19960L85,465@19819L283");
                boolean ContentScreen$lambda$15$20 = ContentScreen$lambda$15$20(showBenefitSheet$delegate);
                ComposerKt.sourceInformationMarkerStart($composer6, -105269230, str2);
                boolean invalid$iv12 = $composer2.changedInstance(pageViewModel2);
                Object it$iv21 = $composer6.rememberedValue();
                if (invalid$iv12) {
                }
                Object value$iv23 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit ContentScreen$lambda$15$22$0$0;
                        ContentScreen$lambda$15$22$0$0 = ContentScreenKt.ContentScreen$lambda$15$22$0$0(PageViewModel.this);
                        return ContentScreen$lambda$15$22$0$0;
                    }
                };
                $composer6.updateRememberedValue(value$iv23);
                it$iv21 = value$iv23;
                ComposerKt.sourceInformationMarkerEnd($composer6);
                BenefitDetailSheetComponentKt.BenefitDetailSheetComponent(benefitInfo, ContentScreen$lambda$15$20, (Function0) it$iv21, ContentScreen$lambda$0(scaleModel$delegate).getScale(), $composer6, 0);
                Unit unit = Unit.INSTANCE;
                $composer6.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            State showCouponReserveDialogResult$delegate = SnapshotStateKt.collectAsState(pageViewModel.getShowCouponReserveResultDialog(), (CoroutineContext) null, $composer6, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer6, -495820641, str2);
            Object it$iv22 = $composer6.rememberedValue();
            if (it$iv22 == Composer.Companion.getEmpty()) {
                Object value$iv24 = OnBackPressedCallback_androidKt.OnBackPressedCallback(true, new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        Unit ContentScreen$lambda$15$24$0;
                        ContentScreen$lambda$15$24$0 = ContentScreenKt.ContentScreen$lambda$15$24$0(PageViewModel.this, (OnBackPressedCallback) obj2);
                        return ContentScreen$lambda$15$24$0;
                    }
                });
                $composer6.updateRememberedValue(value$iv24);
                it$iv22 = value$iv24;
            }
            OnBackPressedCallback couponReserveResultCallback = (OnBackPressedCallback) it$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ContentScreen$lambda$15$23(showCouponReserveDialogResult$delegate)) {
                backHandler2.addCallback(couponReserveResultCallback);
            } else {
                couponReserveResultCallback.remove();
            }
            boolean ContentScreen$lambda$15$23 = ContentScreen$lambda$15$23(showCouponReserveDialogResult$delegate);
            ComposerKt.sourceInformationMarkerStart($composer6, -495804997, str2);
            boolean invalid$iv13 = $composer2.changedInstance(pageViewModel2);
            Object it$iv23 = $composer6.rememberedValue();
            if (invalid$iv13) {
            }
            Object value$iv25 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit ContentScreen$lambda$15$25$0;
                    ContentScreen$lambda$15$25$0 = ContentScreenKt.ContentScreen$lambda$15$25$0(PageViewModel.this);
                    return ContentScreen$lambda$15$25$0;
                }
            };
            $composer6.updateRememberedValue(value$iv25);
            it$iv23 = value$iv25;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            CouponReserveResultDialogKt.CouponReserveResultDialog(ContentScreen$lambda$15$23, (Function0) it$iv23, pageViewModel.getWrapper$product_details_page_debug(), $composer6, 0);
            ComposerKt.sourceInformationMarkerStart($composer6, -495798166, str2);
            Object it$iv24 = $composer6.rememberedValue();
            if (it$iv24 == Composer.Companion.getEmpty()) {
                Object value$iv26 = OnBackPressedCallback_androidKt.OnBackPressedCallback(true, new Function1() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj2) {
                        Unit ContentScreen$lambda$15$26$0;
                        ContentScreen$lambda$15$26$0 = ContentScreenKt.ContentScreen$lambda$15$26$0(PageViewModel.this, (OnBackPressedCallback) obj2);
                        return ContentScreen$lambda$15$26$0;
                    }
                });
                $composer6.updateRememberedValue(value$iv26);
                it$iv24 = value$iv26;
            }
            OnBackPressedCallback retainPopupCallback = (OnBackPressedCallback) it$iv24;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) SnapshotStateKt.collectAsState(pageViewModel.getProductDetailsResponse(), (CoroutineContext) null, $composer6, 0, 1).getValue();
            ProductDetailsResponse.ProductDetailsData productDetailsData = productDetailsResponse != null ? productDetailsResponse.getData() : null;
            State isRetainPopupVisible$delegate2 = SnapshotStateKt.collectAsState(pageViewModel.getRetainPopupVisibleFlow(), (CoroutineContext) null, $composer6, 0, 1);
            Boolean valueOf = Boolean.valueOf(ContentScreen$lambda$15$27(isRetainPopupVisible$delegate2));
            Object value = lifecycleState.getValue();
            ComposerKt.sourceInformationMarkerStart($composer6, -495774194, str2);
            boolean invalid$iv14 = $composer2.changedInstance(productDetailsData) | $composer2.changed(isRetainPopupVisible$delegate2) | $composer2.changedInstance(retainPopupCallback) | $composer2.changedInstance(pageViewModel2) | $composer2.changedInstance(backHandler2);
            Object value$iv27 = $composer6.rememberedValue();
            if (invalid$iv14 || value$iv27 == Composer.Companion.getEmpty()) {
                $composer$iv = $composer6;
                $composer4 = $composer6;
                modifier4 = modifier6;
                pageViewModel2 = pageViewModel;
                isRetainPopupVisible$delegate = isRetainPopupVisible$delegate2;
                i2 = 54;
                value$iv27 = new ContentScreenKt$ContentScreen$1$17$1(productDetailsData, retainPopupCallback, pageViewModel, backHandler2, isRetainPopupVisible$delegate2, null);
                $composer6.updateRememberedValue(value$iv27);
            } else {
                isRetainPopupVisible$delegate = isRetainPopupVisible$delegate2;
                modifier4 = modifier6;
                $composer$iv = $composer6;
                i2 = 54;
                $composer4 = $composer6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(productDetailsData, valueOf, value, (Function2) value$iv27, $composer4, 0);
            boolean ContentScreen$lambda$15$27 = ContentScreen$lambda$15$27(isRetainPopupVisible$delegate);
            Composer $composer7 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer7, -495743985, str2);
            boolean invalid$iv15 = $composer2.changedInstance(pageViewModel2);
            Object it$iv25 = $composer7.rememberedValue();
            if (invalid$iv15 || it$iv25 == Composer.Companion.getEmpty()) {
                Object value$iv28 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit ContentScreen$lambda$15$29$0;
                        ContentScreen$lambda$15$29$0 = ContentScreenKt.ContentScreen$lambda$15$29$0(PageViewModel.this);
                        return ContentScreen$lambda$15$29$0;
                    }
                };
                $composer7.updateRememberedValue(value$iv28);
                it$iv25 = value$iv28;
            }
            ComposerKt.sourceInformationMarkerEnd($composer7);
            RetainPopupDialogKt.RetainPopupDialog(ContentScreen$lambda$15$27, (Function0) it$iv25, pageViewModel.getWrapper$product_details_page_debug(), null, $composer7, 0, 8);
            final State imageBottomSheetState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getImageBottomSheetStateFlow$product_details_page_debug(), (CoroutineContext) null, $composer7, 0, 1);
            ImageBottomSheetState ContentScreen$lambda$15$30 = ContentScreen$lambda$15$30(imageBottomSheetState$delegate);
            boolean z = ContentScreen$lambda$15$30 != null && ContentScreen$lambda$15$30.getShow();
            long j = Color.Companion.getTransparent-0d7_KjU();
            Shape rectangleShape = RectangleShapeKt.getRectangleShape();
            PaddingValues paddingValues3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
            ComposerKt.sourceInformationMarkerStart($composer7, -495732890, str2);
            boolean invalid$iv16 = $composer2.changedInstance(pageViewModel2);
            Object it$iv26 = $composer7.rememberedValue();
            if (invalid$iv16 || it$iv26 == Composer.Companion.getEmpty()) {
                Object value$iv29 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit ContentScreen$lambda$15$31$0;
                        ContentScreen$lambda$15$31$0 = ContentScreenKt.ContentScreen$lambda$15$31$0(PageViewModel.this);
                        return ContentScreen$lambda$15$31$0;
                    }
                };
                $composer7.updateRememberedValue(value$iv29);
                it$iv26 = value$iv29;
            }
            ComposerKt.sourceInformationMarkerEnd($composer7);
            final State scaleModel$delegate3 = scaleModel$delegate;
            BottomSheetKt.m417WrapContentBottomSheethYmLsZ8((Function0) it$iv26, z, paddingValues3, j, rectangleShape, false, ComposableLambdaKt.rememberComposableLambda(-2027548710, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit ContentScreen$lambda$15$32;
                    ContentScreen$lambda$15$32 = ContentScreenKt.ContentScreen$lambda$15$32(imageBottomSheetState$delegate, pageViewModel2, scaleModel$delegate3, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return ContentScreen$lambda$15$32;
                }
            }, $composer7, i2), $composer7, 1797504, 0);
            CouponPopupComponentKt.CouponPopupComponent(pageViewModel.getWrapper$product_details_page_debug(), null, $composer7, 0, 2);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer5;
            pageViewModel2 = pageViewModel;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ContentScreen$lambda$16;
                    ContentScreen$lambda$16 = ContentScreenKt.ContentScreen$lambda$16(PageViewModel.this, modifier2, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return ContentScreen$lambda$16;
                }
            });
        }
    }

    private static final UiScaleModel ContentScreen$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final List<ContentModule> ContentScreen$lambda$1(State<? extends List<? extends ContentModule>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlayerViewModel ContentScreen$lambda$3$0(CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new VideoPlayerViewModel();
    }

    private static final int ContentScreen$lambda$7(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$8$0(ContentScreenKt$ContentScreen$simplePlayer$1$1 $simplePlayer, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C157@7801L290:ContentScreen.kt#dsyj5e");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(812337871, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:157)");
            }
            SimplePlayerView_androidKt.SimplePlayerView-nJ1p8Q0($simplePlayer, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter(), ContentScale.Companion.getFit(), 0L, true, $composer, 200118, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$9$0(ContentScreenKt$ContentScreen$upSaySimplePlayer$1$1 $upSaySimplePlayer, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C169@8233L295:ContentScreen.kt#dsyj5e");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945294, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:169)");
            }
            SimplePlayerView_androidKt.SimplePlayerView-nJ1p8Q0($upSaySimplePlayer, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter(), ContentScale.Companion.getFit(), 0L, true, $composer, 200118, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean ContentScreen$lambda$10(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$11$0(PageViewModel $pageViewModel, VideoPlayerViewModel $videoViewModel, Function2 $movableVideoPlayerView, Function2 $movableUpSayVideoView, LazyStaggeredGridState $listState, State $shouldShowHeaderPreview$delegate, State $firstVisibleItemIndex$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C186@8856L817:ContentScreen.kt#dsyj5e");
        boolean z = false;
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1905190084, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:184)");
            }
            if (!ContentScreen$lambda$10($shouldShowHeaderPreview$delegate) && ContentScreen$lambda$7($firstVisibleItemIndex$delegate) == 0) {
                z = true;
            }
            boolean shouldShowVideoView = z;
            int $this$dp$iv = Integer.parseInt($pageViewModel.getStatusBarHeight());
            HeaderBannerSectionKt.m475HeaderBannerSectiongSuKmCU(Dp.constructor-impl($this$dp$iv), $pageViewModel.getWrapper$product_details_page_debug(), $videoViewModel.getWrapper(), $listState, shouldShowVideoView ? $movableVideoPlayerView : ComposableSingletons$ContentScreenKt.INSTANCE.m610getLambda$518286978$product_details_page_debug(), shouldShowVideoView ? $movableUpSayVideoView : ComposableSingletons$ContentScreenKt.INSTANCE.getLambda$1659233134$product_details_page_debug(), null, false, $composer, 12582912, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$12$0(PageViewModel $pageViewModel, VideoPlayerViewModel $videoViewModel, Function2 $movableVideoPlayerView, Function2 $movableUpSayVideoView, LazyStaggeredGridState $listState, State $shouldShowHeaderPreview$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C212@9809L824:ContentScreen.kt#dsyj5e");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1019725815, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:212)");
            }
            int $this$dp$iv = Integer.parseInt($pageViewModel.getStatusBarHeight());
            HeaderBannerSectionKt.m475HeaderBannerSectiongSuKmCU(Dp.constructor-impl($this$dp$iv), $pageViewModel.getWrapper$product_details_page_debug(), $videoViewModel.getWrapper(), $listState, ContentScreen$lambda$10($shouldShowHeaderPreview$delegate) ? $movableVideoPlayerView : ComposableSingletons$ContentScreenKt.INSTANCE.m611getLambda$975402489$product_details_page_debug(), ContentScreen$lambda$10($shouldShowHeaderPreview$delegate) ? $movableUpSayVideoView : ComposableSingletons$ContentScreenKt.INSTANCE.getLambda$2103211543$product_details_page_debug(), null, true, $composer, 12582912, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final float ContentScreen$lambda$14(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ContentScreen$lambda$13$0(LazyStaggeredGridState $listState, float $maxScrollOffset) {
        int firstVisibleItemIndex = $listState.getFirstVisibleItemIndex();
        if (firstVisibleItemIndex == 0) {
            return $listState.getFirstVisibleItemScrollOffset();
        }
        return $maxScrollOffset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModuleViewModel ContentScreen$lambda$15$0$0(PageViewModel $pageViewModel, FloorType floorType) {
        Intrinsics.checkNotNullParameter(floorType, "floorType");
        return $pageViewModel.getModuleViewModel$product_details_page_debug(floorType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$1$0(PageViewModel $pageViewModel) {
        $pageViewModel.reloadProductDetails$product_details_page_debug();
        $pageViewModel.clearFeedBlast$product_details_page_debug();
        return Unit.INSTANCE;
    }

    private static final boolean ContentScreen$lambda$15$9(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$10$0(PageViewModel $pageViewModel, OnBackPressedCallback $this$OnBackPressedCallback) {
        Intrinsics.checkNotNullParameter($this$OnBackPressedCallback, "$this$OnBackPressedCallback");
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$11$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$12(PageViewModel $pageViewModel, BoxScope $this$CustomizedBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$CustomizedBottomSheet, "$this$CustomizedBottomSheet");
        ComposerKt.sourceInformation($composer, "C399@17109L51:ContentScreen.kt#dsyj5e");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-386346378, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:399)");
            }
            ActivityCouponSheetComponentKt.ActivityCouponSheetComponent($pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final ImagePreviewState ContentScreen$lambda$15$13(State<ImagePreviewState> state) {
        Object thisObj$iv = state.getValue();
        return (ImagePreviewState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$14$0(PageViewModel $pageViewModel, OnBackPressedCallback $this$OnBackPressedCallback) {
        Intrinsics.checkNotNullParameter($this$OnBackPressedCallback, "$this$OnBackPressedCallback");
        PageViewModel.updateImagePreview$product_details_page_debug$default($pageViewModel, null, 0, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$15(final PageViewModel $pageViewModel, State $imagePreviewState$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        List<String> emptyList;
        List<Pair<Float, Float>> emptyList2;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C425@18233L78,421@17971L355:ContentScreen.kt#dsyj5e");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1081948618, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:421)");
        }
        ImagePreviewState ContentScreen$lambda$15$13 = ContentScreen$lambda$15$13($imagePreviewState$delegate);
        if (ContentScreen$lambda$15$13 == null || (emptyList = ContentScreen$lambda$15$13.getImageUrls()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<String> list = emptyList;
        ImagePreviewState ContentScreen$lambda$15$132 = ContentScreen$lambda$15$13($imagePreviewState$delegate);
        int index = ContentScreen$lambda$15$132 != null ? ContentScreen$lambda$15$132.getIndex() : 0;
        ImagePreviewState ContentScreen$lambda$15$133 = ContentScreen$lambda$15$13($imagePreviewState$delegate);
        if (ContentScreen$lambda$15$133 == null || (emptyList2 = ContentScreen$lambda$15$133.getImageSizes()) == null) {
            emptyList2 = CollectionsKt.emptyList();
        }
        List<Pair<Float, Float>> list2 = emptyList2;
        ComposerKt.sourceInformationMarkerStart($composer, 370545176, "CC(remember):ContentScreen.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($pageViewModel);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda18
                public final Object invoke() {
                    Unit ContentScreen$lambda$15$15$0$0;
                    ContentScreen$lambda$15$15$0$0 = ContentScreenKt.ContentScreen$lambda$15$15$0$0(PageViewModel.this);
                    return ContentScreen$lambda$15$15$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        FullScreenPreviewKt.FullScreenImagePreview(list, (Function0) it$iv, null, index, list2, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$15$0$0(PageViewModel $pageViewModel) {
        PageViewModel.updateImagePreview$product_details_page_debug$default($pageViewModel, null, 0, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final boolean ContentScreen$lambda$15$16(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$17$0(PageViewModel $pageViewModel, OnBackPressedCallback $this$OnBackPressedCallback) {
        Intrinsics.checkNotNullParameter($this$OnBackPressedCallback, "$this$OnBackPressedCallback");
        $pageViewModel.updateSkuSwitchState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$18$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateSkuSwitchState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$19(PageViewModel $pageViewModel, BoxScope $this$CustomizedBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$CustomizedBottomSheet, "$this$CustomizedBottomSheet");
        ComposerKt.sourceInformation($composer, "C458@19450L46:ContentScreen.kt#dsyj5e");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-671616353, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:458)");
            }
            SkuSwitchSheetComponentKt.SkuSwitchSheetComponent($pageViewModel.getWrapper$product_details_page_debug(), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean ContentScreen$lambda$15$20(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$22$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.toggleBenefitBottomSheet$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    private static final boolean ContentScreen$lambda$15$23(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$24$0(PageViewModel $pageViewModel, OnBackPressedCallback $this$OnBackPressedCallback) {
        Intrinsics.checkNotNullParameter($this$OnBackPressedCallback, "$this$OnBackPressedCallback");
        $pageViewModel.updateCouponReserveResultDialogState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$25$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateCouponReserveResultDialogState$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$26$0(PageViewModel $pageViewModel, OnBackPressedCallback $this$OnBackPressedCallback) {
        Intrinsics.checkNotNullParameter($this$OnBackPressedCallback, "$this$OnBackPressedCallback");
        long currentTS = DateFormatKt.getCurrentTimeMillis();
        $pageViewModel.getSp().setString("retainPopupTimestamp", String.valueOf(currentTS));
        $pageViewModel.updateRetainPopupVisible$product_details_page_debug(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ContentScreen$lambda$15$27(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$29$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateRetainPopupVisible$product_details_page_debug(false);
        return Unit.INSTANCE;
    }

    private static final ImageBottomSheetState ContentScreen$lambda$15$30(State<ImageBottomSheetState> state) {
        Object thisObj$iv = state.getValue();
        return (ImageBottomSheetState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$31$0(PageViewModel $pageViewModel) {
        $pageViewModel.hideImageBottomSheet$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x01df, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ContentScreen$lambda$15$32(State $imageBottomSheetState$delegate, final PageViewModel $pageViewModel, State $scaleModel$delegate, ColumnScope $this$WrapContentBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$WrapContentBottomSheet, "$this$WrapContentBottomSheet");
        ComposerKt.sourceInformation($composer, "C:ContentScreen.kt#dsyj5e");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2027548710, $changed, -1, "kntr.app.mall.product.details.page.ui.screen.ContentScreen.<anonymous>.<anonymous> (ContentScreen.kt:552)");
            }
            ImageBottomSheetState it = ContentScreen$lambda$15$30($imageBottomSheetState$delegate);
            if (it == null) {
                $composer.startReplaceGroup(1716494606);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1716494607);
                ComposerKt.sourceInformation($composer, "*553@23369L821");
                Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
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
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i2 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -886977127, "C556@23459L321,569@24041L108,564@23802L370:ContentScreen.kt#dsyj5e");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(it.getImageUrl());
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (float) (it.getImageWidth() / it.getImageHeight()), false, 2, (Object) null), null, null, null, null, null, null, null, $composer, 0, 508);
                Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(26, ContentScreen$lambda$0($scaleModel$delegate).getScale()));
                ComposerKt.sourceInformationMarkerStart($composer, -582783475, "CC(remember):ContentScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($pageViewModel);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.screen.ContentScreenKt$$ExternalSyntheticLambda17
                    public final Object invoke() {
                        Unit ContentScreen$lambda$15$32$0$0$0$0;
                        ContentScreen$lambda$15$32$0$0$0$0 = ContentScreenKt.ContentScreen$lambda$15$32$0$0$0$0(PageViewModel.this);
                        return ContentScreen$lambda$15$32$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                BoxKt.Box(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentScreen$lambda$15$32$0$0$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.hideImageBottomSheet$product_details_page_debug();
        return Unit.INSTANCE;
    }
}