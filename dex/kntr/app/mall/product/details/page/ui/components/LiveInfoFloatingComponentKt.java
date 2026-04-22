package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LiveInfoFloatingComponent.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\f\u0010\b\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"LiveInfoFloatingComponent", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "liveInfoResponse", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LiveInfoFloatingComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LiveInfoFloatingComponent$lambda$1(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LiveInfoFloatingComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LiveInfoFloatingComponent$lambda$10(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LiveInfoFloatingComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LiveInfoFloatingComponent$lambda$2(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LiveInfoFloatingComponent(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x026c, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x03b1, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0576  */
    /* JADX WARN: Type inference failed for: r1v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LiveInfoFloatingComponent(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final int i2;
        Composer $composer2;
        final int i3;
        final PageViewModelWrapper pageViewModelWrapper2;
        Composer $composer3;
        final int i4;
        final int i5;
        final PageViewModelWrapper pageViewModelWrapper3;
        Composer $composer4;
        Modifier modifier3;
        PageViewModel pageViewModel;
        float floatHeight;
        float scale;
        boolean invalid$iv;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer5 = $composer.startRestartGroup(1090890631);
        ComposerKt.sourceInformation($composer5, "C(LiveInfoFloatingComponent)N(pageViewModelWrapper,modifier)51@2378L16,57@2573L16,58@2617L17,59@2666L7,60@2727L16,62@2811L10,62@2822L17,65@2920L12,67@2990L17,74@3211L195,82@3431L176,89@3633L24,94@3732L65,95@3834L1954,141@6186L6,142@6225L82,91@3663L3281:LiveInfoFloatingComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer5.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer5.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            final Modifier modifier4 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1090890631, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponent (LiveInfoFloatingComponent.kt:49)");
            }
            PageViewModel pageViewModel2 = pageViewModelWrapper.getViewModel();
            State liveInfoResponse$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getLiveApiResponse(), (CoroutineContext) null, $composer5, 0, 1);
            LiveInfoApiService.LiveInfoResponse LiveInfoFloatingComponent$lambda$0 = LiveInfoFloatingComponent$lambda$0(liveInfoResponse$delegate);
            if (LiveInfoFloatingComponent$lambda$0 != null) {
                final LiveInfoApiService.LiveInfoData liveInfo = LiveInfoFloatingComponent$lambda$0.getData();
                if (liveInfo != null) {
                    String title = liveInfo.getTitle();
                    if (title == null || title.length() == 0) {
                        $composer4 = $composer5;
                        modifier3 = modifier4;
                    } else {
                        String jumpUrl = liveInfo.getJumpUrl();
                        if (jumpUrl == null || jumpUrl.length() == 0) {
                            $composer4 = $composer5;
                            modifier3 = modifier4;
                        } else {
                            float screenWidth = ScreenKt.getScreenWidth($composer5, 0);
                            float screenHeight = ScreenKt.getScreenHeight($composer5, 0);
                            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer5.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            Density density = (Density) consume;
                            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel2.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer5, 0, 1);
                            float scale2 = LiveInfoFloatingComponent$lambda$3(scaleModel$delegate).getScale();
                            float topPadding = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer5, 6), $composer5, 0).calculateTopPadding-D9Ej5fM();
                            float bottomPadding = WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer5, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer5, 0).calculateBottomPadding-D9Ej5fM();
                            float floatWidth = ProvideUiScaleKt.dpScaled(40, scale2);
                            float floatRightPadding = ProvideUiScaleKt.dpScaled(16, scale2);
                            float floatHeight2 = ProvideUiScaleKt.dpScaled(70, scale2);
                            ComposerKt.sourceInformationMarkerStart($composer5, 373911018, "CC(remember):LiveInfoFloatingComponent.kt#9igjgp");
                            Object value$iv = $composer5.rememberedValue();
                            if (value$iv == Composer.Companion.getEmpty()) {
                                pageViewModel = pageViewModel2;
                                value$iv = AnimatableKt.Animatable$default((density.toPx-0680j_4(screenWidth) - density.toPx-0680j_4(floatWidth)) - density.toPx-0680j_4(floatRightPadding), 0.0f, 2, (Object) null);
                                $composer5.updateRememberedValue(value$iv);
                            } else {
                                pageViewModel = pageViewModel2;
                            }
                            final Animatable animX = (Animatable) value$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerStart($composer5, 373918039, "CC(remember):LiveInfoFloatingComponent.kt#9igjgp");
                            Object value$iv2 = $composer5.rememberedValue();
                            if (value$iv2 == Composer.Companion.getEmpty()) {
                                floatHeight = floatHeight2;
                                scale = scale2;
                                value$iv2 = AnimatableKt.Animatable$default(density.toPx-0680j_4(topPadding) + density.toPx-0680j_4(ProvideUiScaleKt.dpScaled(128, scale2)), 0.0f, 2, (Object) null);
                                $composer5.updateRememberedValue(value$iv2);
                            } else {
                                floatHeight = floatHeight2;
                                scale = scale2;
                            }
                            final Animatable animY = (Animatable) value$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart($composer5, 683736516, "CC(remember):Effects.kt#9igjgp");
                            Object it$iv$iv = $composer5.rememberedValue();
                            if (it$iv$iv == Composer.Companion.getEmpty()) {
                                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5);
                                $composer5.updateRememberedValue(value$iv$iv);
                                it$iv$iv = value$iv$iv;
                            }
                            CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerStart($composer5, 373927560, "CC(remember):LiveInfoFloatingComponent.kt#9igjgp");
                            boolean invalid$iv2 = $composer5.changedInstance(animX) | $composer5.changedInstance(animY);
                            Object it$iv = $composer5.rememberedValue();
                            if (invalid$iv2) {
                            }
                            Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj) {
                                    IntOffset LiveInfoFloatingComponent$lambda$6$0;
                                    LiveInfoFloatingComponent$lambda$6$0 = LiveInfoFloatingComponentKt.LiveInfoFloatingComponent$lambda$6$0(animX, animY, (Density) obj);
                                    return LiveInfoFloatingComponent$lambda$6$0;
                                }
                            };
                            $composer5.updateRememberedValue(value$iv3);
                            it$iv = value$iv3;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            Modifier offset = OffsetKt.offset(modifier4, (Function1) it$iv);
                            Unit unit = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer5, 373932713, "CC(remember):LiveInfoFloatingComponent.kt#9igjgp");
                            Modifier modifier5 = modifier4;
                            float scale3 = scale;
                            boolean invalid$iv3 = $composer5.changedInstance(coroutineScope) | $composer5.changed(density) | $composer5.changed(screenWidth) | $composer5.changedInstance(animX) | $composer5.changed(floatRightPadding) | $composer5.changed(floatWidth) | $composer5.changedInstance(animY) | $composer5.changed(topPadding) | $composer5.changed(screenHeight) | $composer5.changed(bottomPadding) | $composer5.changed(scale3);
                            Object it$iv2 = $composer5.rememberedValue();
                            if (!invalid$iv3 && it$iv2 != Composer.Companion.getEmpty()) {
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                Modifier modifier6 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(SuspendingPointerInputFilterKt.pointerInput(offset, unit, (PointerInputEventHandler) it$iv2), floatWidth), floatHeight), ProvideUiScaleKt.dpScaled(4, scale3), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale3)), false, 0L, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 8, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale3))), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
                                ComposerKt.sourceInformationMarkerStart($composer5, 374007353, "CC(remember):LiveInfoFloatingComponent.kt#9igjgp");
                                final PageViewModel pageViewModel3 = pageViewModel;
                                invalid$iv = $composer5.changedInstance(pageViewModel3) | $composer5.changedInstance(liveInfo);
                                Object value$iv4 = $composer5.rememberedValue();
                                if (invalid$iv) {
                                }
                                value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$$ExternalSyntheticLambda3
                                    public final Object invoke() {
                                        Unit LiveInfoFloatingComponent$lambda$8$0;
                                        LiveInfoFloatingComponent$lambda$8$0 = LiveInfoFloatingComponentKt.LiveInfoFloatingComponent$lambda$8$0(PageViewModel.this, liveInfo);
                                        return LiveInfoFloatingComponent$lambda$8$0;
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv4);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv4, 15, (Object) null);
                                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                                ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                int $changed$iv$iv = (48 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                                CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    factory$iv$iv$iv = factory$iv$iv$iv3;
                                    $composer5.useNode();
                                } else {
                                    factory$iv$iv$iv = factory$iv$iv$iv3;
                                    $composer5.createNode(factory$iv$iv$iv);
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                                int i7 = ($changed$iv$iv$iv >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                int i8 = ((48 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -825585058, "C147@6370L568:LiveInfoFloatingComponent.kt#o90vz8");
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                                ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                Modifier modifier$iv2 = Modifier.Companion;
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                int $changed$iv$iv2 = (384 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                                CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                $composer2 = $composer5;
                                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                    $composer5.useNode();
                                } else {
                                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                    $composer5.createNode(factory$iv$iv$iv2);
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                                int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                int i10 = ((384 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -2008990821, "C148@6443L303,156@6838L6,157@6886L9,154@6759L169:LiveInfoFloatingComponent.kt#o90vz8");
                                ImageRequest imageRequest = new ImageRequest("https://i0.hdslb.com/bfs/activity-plat/static/20230803/1c9bd3627fb62252ee34106aca33f38f/AGSXx0rh3h.gif");
                                Unit unit2 = Unit.INSTANCE;
                                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(22, scale3)), ProvideUiScaleKt.dpScaled(20, scale3)), null, null, null, null, null, null, null, $composer5, 0, 508);
                                TextKt.Text-Nvy7gAk(liveInfo.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), scale3), $composer5, 0, 0, 131066);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                pageViewModelWrapper2 = pageViewModelWrapper;
                                i2 = $changed;
                                i3 = i;
                                modifier2 = modifier5;
                            }
                            Object value$iv5 = (PointerInputEventHandler) new LiveInfoFloatingComponentKt$LiveInfoFloatingComponent$3$1(coroutineScope, density, animX, floatRightPadding, floatWidth, screenWidth, animY, topPadding, screenHeight, bottomPadding, scale3);
                            $composer5.updateRememberedValue(value$iv5);
                            it$iv2 = value$iv5;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            Modifier modifier62 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(SuspendingPointerInputFilterKt.pointerInput(offset, unit, (PointerInputEventHandler) it$iv2), floatWidth), floatHeight), ProvideUiScaleKt.dpScaled(4, scale3), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale3)), false, 0L, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 8, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(8, scale3))), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer5, 374007353, "CC(remember):LiveInfoFloatingComponent.kt#9igjgp");
                            final PageViewModel pageViewModel32 = pageViewModel;
                            invalid$iv = $composer5.changedInstance(pageViewModel32) | $composer5.changedInstance(liveInfo);
                            Object value$iv42 = $composer5.rememberedValue();
                            if (invalid$iv) {
                            }
                            value$iv42 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$$ExternalSyntheticLambda3
                                public final Object invoke() {
                                    Unit LiveInfoFloatingComponent$lambda$8$0;
                                    LiveInfoFloatingComponent$lambda$8$0 = LiveInfoFloatingComponentKt.LiveInfoFloatingComponent$lambda$8$0(PageViewModel.this, liveInfo);
                                    return LiveInfoFloatingComponent$lambda$8$0;
                                }
                            };
                            $composer5.updateRememberedValue(value$iv42);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier62, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv42, 15, (Object) null);
                            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                            int $changed$iv$iv3 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                            Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer5.getApplier() instanceof Applier)) {
                            }
                            $composer5.startReusableNode();
                            if ($composer5.getInserting()) {
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                            int i72 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                            int i82 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer5, -825585058, "C147@6370L568:LiveInfoFloatingComponent.kt#o90vz8");
                            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                            ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Modifier modifier$iv22 = Modifier.Companion;
                            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv22 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                            CompositionLocalMap localMap$iv$iv22 = $composer5.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer5, modifier$iv22);
                            Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                            $composer2 = $composer5;
                            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer5.getApplier() instanceof Applier)) {
                            }
                            $composer5.startReusableNode();
                            if ($composer5.getInserting()) {
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer5);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                            int i92 = ($changed$iv$iv$iv22 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                            int i102 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer5, -2008990821, "C148@6443L303,156@6838L6,157@6886L9,154@6759L169:LiveInfoFloatingComponent.kt#o90vz8");
                            ImageRequest imageRequest2 = new ImageRequest("https://i0.hdslb.com/bfs/activity-plat/static/20230803/1c9bd3627fb62252ee34106aca33f38f/AGSXx0rh3h.gif");
                            Unit unit22 = Unit.INSTANCE;
                            BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(22, scale3)), ProvideUiScaleKt.dpScaled(20, scale3)), null, null, null, null, null, null, null, $composer5, 0, 508);
                            TextKt.Text-Nvy7gAk(liveInfo.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), scale3), $composer5, 0, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            $composer5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            $composer5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            pageViewModelWrapper2 = pageViewModelWrapper;
                            i2 = $changed;
                            i3 = i;
                            modifier2 = modifier5;
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier7 = modifier3;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LiveInfoFloatingComponent$lambda$2;
                                LiveInfoFloatingComponent$lambda$2 = LiveInfoFloatingComponentKt.LiveInfoFloatingComponent$lambda$2(PageViewModelWrapper.this, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return LiveInfoFloatingComponent$lambda$2;
                            }
                        });
                        return;
                    }
                    return;
                }
                $composer3 = $composer5;
                i4 = $changed;
                i5 = i;
                pageViewModelWrapper3 = pageViewModelWrapper;
            } else {
                $composer3 = $composer5;
                i4 = $changed;
                i5 = i;
                pageViewModelWrapper3 = pageViewModelWrapper;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
            if (endRestartGroup2 != null) {
                endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit LiveInfoFloatingComponent$lambda$1;
                        LiveInfoFloatingComponent$lambda$1 = LiveInfoFloatingComponentKt.LiveInfoFloatingComponent$lambda$1(PageViewModelWrapper.this, modifier4, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                        return LiveInfoFloatingComponent$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        i2 = $changed;
        $composer2 = $composer5;
        i3 = i;
        pageViewModelWrapper2 = pageViewModelWrapper;
        $composer2.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LiveInfoFloatingComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit LiveInfoFloatingComponent$lambda$10;
                    LiveInfoFloatingComponent$lambda$10 = LiveInfoFloatingComponentKt.LiveInfoFloatingComponent$lambda$10(PageViewModelWrapper.this, modifier2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return LiveInfoFloatingComponent$lambda$10;
                }
            });
        }
    }

    private static final LiveInfoApiService.LiveInfoResponse LiveInfoFloatingComponent$lambda$0(State<LiveInfoApiService.LiveInfoResponse> state) {
        Object thisObj$iv = state.getValue();
        return (LiveInfoApiService.LiveInfoResponse) thisObj$iv;
    }

    private static final UiScaleModel LiveInfoFloatingComponent$lambda$3(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset LiveInfoFloatingComponent$lambda$6$0(Animatable $animX, Animatable $animY, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int x$iv = MathKt.roundToInt(((Number) $animX.getValue()).floatValue());
        int y$iv = MathKt.roundToInt(((Number) $animY.getValue()).floatValue());
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LiveInfoFloatingComponent$lambda$8$0(PageViewModel $pageViewModel, LiveInfoApiService.LiveInfoData $liveInfo) {
        $pageViewModel.handleLiveInfoJump$product_details_page_debug($liveInfo);
        return Unit.INSTANCE;
    }
}