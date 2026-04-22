package kntr.app.mall.product.details.page.ui.floatingLayer;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
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
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: LotteryDashFloatingLayer.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"LotteryDashFloatingLayer", "", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "formatMaxBuyTime", "", "maxBuyTime", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatDiffSeconds", "diffSeconds", "calculateDisplayState", "Lkntr/app/mall/product/details/page/ui/floatingLayer/LotteryDashDisplayState;", "activityInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$ActivityInfo;", "userActivityInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData$LotteryDash$UserActivityInfo;", "countDownText", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "displayState"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LotteryDashFloatingLayerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LotteryDashFloatingLayer$lambda$1(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LotteryDashFloatingLayer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LotteryDashFloatingLayer$lambda$11(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LotteryDashFloatingLayer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LotteryDashFloatingLayer$lambda$2(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LotteryDashFloatingLayer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LotteryDashFloatingLayer$lambda$4(PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LotteryDashFloatingLayer(pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0220, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02fc, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LotteryDashFloatingLayer(final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        final int i2;
        final int $dirty;
        final PageViewModelWrapper pageViewModelWrapper2;
        Composer $composer3;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        Function0 factory$iv$iv$iv7;
        LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer4 = $composer.startRestartGroup(1250217502);
        ComposerKt.sourceInformation($composer4, "C(LotteryDashFloatingLayer)N(pageViewModelWrapper,modifier)62@2655L16,63@2726L16,68@2968L34,71@3072L54,80@3542L1552,72@3131L1963,139@5706L281,126@5100L5304:LotteryDashFloatingLayer.kt#j7uxph");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changedInstance(pageViewModelWrapper) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            final Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1250217502, $dirty2, -1, "kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayer (LotteryDashFloatingLayer.kt:60)");
            }
            final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer4, 0, 1);
            State liveInfoState = SnapshotStateKt.collectAsState(pageViewModel.getLiveApiResponse(), (CoroutineContext) null, $composer4, 0, 1);
            LiveInfoApiService.LiveInfoResponse liveInfoResponse = (LiveInfoApiService.LiveInfoResponse) liveInfoState.getValue();
            if (liveInfoResponse != null) {
                final LiveInfoApiService.LiveInfoData liveInfoData = liveInfoResponse.getData();
                if (liveInfoData == null) {
                    $composer3 = $composer4;
                    modifier3 = modifier4;
                } else {
                    LiveInfoApiService.LiveInfoData.LotteryDash lotteryDash = liveInfoData.getLotteryDash();
                    String taskStatus = (lotteryDash == null || (activityInfo = lotteryDash.getActivityInfo()) == null) ? null : activityInfo.getTaskStatus();
                    if (!Intrinsics.areEqual(taskStatus, "going") && !Intrinsics.areEqual(taskStatus, "end")) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LotteryDashFloatingLayer$lambda$2;
                                    LotteryDashFloatingLayer$lambda$2 = LotteryDashFloatingLayerKt.LotteryDashFloatingLayer$lambda$2(PageViewModelWrapper.this, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return LotteryDashFloatingLayer$lambda$2;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    ComposerKt.sourceInformationMarkerStart($composer4, -1131806208, "CC(remember):LotteryDashFloatingLayer.kt#9igjgp");
                    Object it$iv = $composer4.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer4.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    final MutableState shouldHideLotteryDash = (MutableState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (((Boolean) shouldHideLotteryDash.getValue()).booleanValue()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup2 = $composer4.endRestartGroup();
                        if (endRestartGroup2 != null) {
                            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LotteryDashFloatingLayer$lambda$4;
                                    LotteryDashFloatingLayer$lambda$4 = LotteryDashFloatingLayerKt.LotteryDashFloatingLayer$lambda$4(PageViewModelWrapper.this, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return LotteryDashFloatingLayer$lambda$4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    ComposerKt.sourceInformationMarkerStart($composer4, -1131802860, "CC(remember):LotteryDashFloatingLayer.kt#9igjgp");
                    Object it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = SnapshotStateKt.mutableStateOf$default(new LotteryDashDisplayState(null, null, null, null, null, null, 63, null), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer4.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    MutableState displayState$delegate = (MutableState) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    String taskStatus2 = liveInfoData.getLotteryDash().getActivityInfo().getTaskStatus();
                    Boolean isSubmitted = liveInfoData.getLotteryDash().getActivityInfo().isSubmitted();
                    Integer publishTime = liveInfoData.getLotteryDash().getActivityInfo().getPublishTime();
                    LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo = liveInfoData.getLotteryDash().getUserActivityInfo();
                    Boolean isJoined = userActivityInfo != null ? userActivityInfo.isJoined() : null;
                    LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo2 = liveInfoData.getLotteryDash().getUserActivityInfo();
                    Boolean isWinner = userActivityInfo2 != null ? userActivityInfo2.isWinner() : null;
                    LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo3 = liveInfoData.getLotteryDash().getUserActivityInfo();
                    Object[] objArr = {liveInfoData, taskStatus2, isSubmitted, publishTime, isJoined, isWinner, userActivityInfo3 != null ? userActivityInfo3.isCouponReceived() : null};
                    ComposerKt.sourceInformationMarkerStart($composer4, -1131786322, "CC(remember):LotteryDashFloatingLayer.kt#9igjgp");
                    boolean invalid$iv = $composer4.changedInstance(liveInfoData) | $composer4.changedInstance(pageViewModel);
                    LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1 value$iv3 = $composer4.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv3 = new LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1(liveInfoData, pageViewModel, displayState$delegate, null);
                    $composer4.updateRememberedValue(value$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    EffectsKt.LaunchedEffect(objArr, (Function2) value$iv3, $composer4, 0);
                    Modifier modifier5 = BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(modifier4, 0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(68, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), 7, (Object) null), ProvideUiScaleKt.dpScaled(64, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(6, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale())), false, 0L, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 8, (Object) null), Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale())));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1131718345, "CC(remember):LotteryDashFloatingLayer.kt#9igjgp");
                    boolean invalid$iv2 = $composer4.changedInstance(liveInfoData) | $composer4.changedInstance(pageViewModel);
                    Object it$iv3 = $composer4.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit LotteryDashFloatingLayer$lambda$9$0;
                            LotteryDashFloatingLayer$lambda$9$0 = LotteryDashFloatingLayerKt.LotteryDashFloatingLayer$lambda$9$0(LiveInfoApiService.LiveInfoData.this, pageViewModel);
                            return LotteryDashFloatingLayer$lambda$9$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv4);
                    it$iv3 = value$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    Modifier modifier6 = modifier4;
                    $composer2 = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv8;
                        $composer4.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv8;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i5 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 931427170, "C145@6005L4393:LotteryDashFloatingLayer.kt#j7uxph");
                    Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv2 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                    Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv9;
                        $composer4.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv9;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i7 = ((390 >> 6) & 112) | 6;
                    RowScope $this$LotteryDashFloatingLayer_u24lambda_u2410_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -289833699, "C151@6178L53,152@6244L2348,204@8605L1029,233@9804L90,229@9647L741:LotteryDashFloatingLayer.kt#j7uxph");
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(14, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale())), $composer4, 0);
                    Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
                    Modifier modifier$iv3 = RowScope.-CC.weight$default($this$LotteryDashFloatingLayer_u24lambda_u2410_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    Arrangement.Vertical verticalArrangement$iv = center;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                    int $changed$iv$iv3 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv10;
                        $composer4.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv10;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i9 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1366773433, "C156@6390L1466,187@7873L705:LotteryDashFloatingLayer.kt#j7uxph");
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier modifier$iv4 = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv4 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                    Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer4.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i11 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2007354962, "C159@6503L430,168@6954L431,177@7406L432:LotteryDashFloatingLayer.kt#j7uxph");
                    TextKt.Text-Nvy7gAk(LotteryDashFloatingLayer$lambda$6(displayState$delegate).getPreHighlightedText(), (Modifier) null, ColorKt.Color(4279769372L), (TextAutoSize) null, ProvideUiScaleKt.spScaled(15, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(25, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, 1573248, 24960, 239530);
                    TextKt.Text-Nvy7gAk(LotteryDashFloatingLayer$lambda$6(displayState$delegate).getMainHighlightedText(), (Modifier) null, ColorKt.Color(4281955835L), (TextAutoSize) null, ProvideUiScaleKt.spScaled(15, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(25, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, 1573248, 24960, 239530);
                    TextKt.Text-Nvy7gAk(LotteryDashFloatingLayer$lambda$6(displayState$delegate).getAfterHighlightedText(), (Modifier) null, ColorKt.Color(4279769372L), (TextAutoSize) null, ProvideUiScaleKt.spScaled(15, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, ProvideUiScaleKt.spScaled(25, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, 1573248, 24960, 239530);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier modifier$iv5 = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv5 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                    Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv12;
                        $composer4.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv12;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope2 = RowScopeInstance.INSTANCE;
                    int i13 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 235928747, "C188@7899L661:LotteryDashFloatingLayer.kt#j7uxph");
                    TextKt.Text-Nvy7gAk(LotteryDashFloatingLayer$lambda$6(displayState$delegate).getSubText(), (Modifier) null, ColorKt.Color(4284573293L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), $composer4, 384, 24960, 110586);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    Modifier modifier$iv6 = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(90, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(38, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()));
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv6 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                    Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv6 = factory$iv$iv$iv13;
                        $composer4.createNode(factory$iv$iv$iv6);
                    } else {
                        factory$iv$iv$iv6 = factory$iv$iv$iv13;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i14 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i15 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1864108210, "C211@8877L514,222@9408L212:LotteryDashFloatingLayer.kt#j7uxph");
                    String $this$asRequest$iv = HelperKt.customizedImageUrl("//i0.hdslb.com/bfs/kfptfe/floor/52047931b01103930e029bb02bdfbfdb5e8df66c.png");
                    ImageRequest $this$LotteryDashFloatingLayer_u24lambda_u2410_u240_u241_u240 = new ImageRequest($this$asRequest$iv);
                    $this$LotteryDashFloatingLayer_u24lambda_u2410_u240_u241_u240.contentScale(ContentScale.Companion.getFit());
                    BiliImageKt.BiliImage($this$LotteryDashFloatingLayer_u24lambda_u2410_u240_u241_u240.build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(90, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale())), ProvideUiScaleKt.dpScaled(38, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale())), null, null, null, null, null, null, null, $composer4, 0, 508);
                    TextKt.Text-Nvy7gAk(LotteryDashFloatingLayer$lambda$6(displayState$delegate).getButtonText(), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, ProvideUiScaleKt.spScaled(12, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, $composer4, 384, 24576, 245738);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier7 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(28, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()));
                    ComposerKt.sourceInformationMarkerStart($composer4, 267857102, "CC(remember):LotteryDashFloatingLayer.kt#9igjgp");
                    Object it$iv4 = $composer4.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit LotteryDashFloatingLayer$lambda$10$0$2$0;
                                LotteryDashFloatingLayer$lambda$10$0$2$0 = LotteryDashFloatingLayerKt.LotteryDashFloatingLayer$lambda$10$0$2$0(shouldHideLotteryDash);
                                return LotteryDashFloatingLayer$lambda$10$0$2$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier$iv7 = ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null);
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv7 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv7 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer4, modifier$iv7);
                    Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv7 = factory$iv$iv$iv14;
                        $composer4.createNode(factory$iv$iv$iv7);
                    } else {
                        factory$iv$iv$iv7 = factory$iv$iv$iv14;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                    int i16 = ($changed$iv$iv$iv7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i17 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 277580259, "C238@9981L393:LotteryDashFloatingLayer.kt#j7uxph");
                    Modifier modifier8 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(16, LotteryDashFloatingLayer$lambda$0(scaleModel$delegate).getScale()));
                    String $this$asRequest$iv2 = HelperKt.customizedImageUrl("//i0.hdslb.com/bfs/kfptfe/floor/50c4485de5705c66d5c4b0f15ca984bd06d66bc4.png");
                    ImageRequest $this$LotteryDashFloatingLayer_u24lambda_u2410_u240_u243_u240 = new ImageRequest($this$asRequest$iv2);
                    $this$LotteryDashFloatingLayer_u24lambda_u2410_u240_u243_u240.contentScale(ContentScale.Companion.getFit());
                    BiliImageKt.BiliImage($this$LotteryDashFloatingLayer_u24lambda_u2410_u240_u243_u240.build(), modifier8, null, null, null, null, null, null, null, $composer4, 0, 508);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pageViewModelWrapper2 = pageViewModelWrapper;
                    i2 = $changed;
                    $dirty = i;
                    modifier2 = modifier6;
                }
            } else {
                $composer3 = $composer4;
                modifier3 = modifier4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup3 = $composer3.endRestartGroup();
            if (endRestartGroup3 != null) {
                final Modifier modifier9 = modifier3;
                endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit LotteryDashFloatingLayer$lambda$1;
                        LotteryDashFloatingLayer$lambda$1 = LotteryDashFloatingLayerKt.LotteryDashFloatingLayer$lambda$1(PageViewModelWrapper.this, modifier9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                        return LotteryDashFloatingLayer$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer4;
        i2 = $changed;
        $dirty = i;
        pageViewModelWrapper2 = pageViewModelWrapper;
        $composer2.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup4 = $composer2.endRestartGroup();
        if (endRestartGroup4 != null) {
            endRestartGroup4.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LotteryDashFloatingLayer$lambda$11;
                    LotteryDashFloatingLayer$lambda$11 = LotteryDashFloatingLayerKt.LotteryDashFloatingLayer$lambda$11(PageViewModelWrapper.this, modifier2, i2, $dirty, (Composer) obj, ((Integer) obj2).intValue());
                    return LotteryDashFloatingLayer$lambda$11;
                }
            });
        }
    }

    private static final UiScaleModel LotteryDashFloatingLayer$lambda$0(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    private static final LotteryDashDisplayState LotteryDashFloatingLayer$lambda$6(MutableState<LotteryDashDisplayState> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (LotteryDashDisplayState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LotteryDashFloatingLayer$lambda$9$0(LiveInfoApiService.LiveInfoData $liveInfoData, PageViewModel $pageViewModel) {
        String targetUrl = "https://mall.bilibili.com/neul-next/index.html?page=purchase-by-lot_home&taskId=" + $liveInfoData.getLotteryDash().getActivityInfo().getTaskId() + "&noTitleBar=1";
        $pageViewModel.handleJumpUrl$product_details_page_debug(targetUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LotteryDashFloatingLayer$lambda$10$0$2$0(MutableState $shouldHideLotteryDash) {
        $shouldHideLotteryDash.setValue(true);
        return Unit.INSTANCE;
    }

    public static final String formatMaxBuyTime(Integer maxBuyTime) {
        if (maxBuyTime == null) {
            return "未知时间";
        }
        long timeInMilliseconds = maxBuyTime.intValue() * ((long) MediaAttrUtils.TYPE_PAY_SEASON);
        Instant instant = Instant.Companion.fromEpochMilliseconds(timeInMilliseconds);
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        String padStart = StringsKt.padStart(String.valueOf(localDateTime.getMonthNumber()), 2, '0');
        String padStart2 = StringsKt.padStart(String.valueOf(localDateTime.getDayOfMonth()), 2, '0');
        String padStart3 = StringsKt.padStart(String.valueOf(localDateTime.getHour()), 2, '0');
        return padStart + "月" + padStart2 + "日" + padStart3 + ":" + StringsKt.padStart(String.valueOf(localDateTime.getMinute()), 2, '0');
    }

    public static final String formatDiffSeconds(int diffSeconds) {
        int hour = diffSeconds / 3600;
        int minutes = (diffSeconds % 3600) / 60;
        int seconds = diffSeconds % 60;
        Object valueOf = hour > 9 ? Integer.valueOf(hour) : "0" + hour;
        return valueOf + ":" + (minutes > 9 ? Integer.valueOf(minutes) : "0" + minutes) + ":" + (seconds > 9 ? Integer.valueOf(seconds) : "0" + seconds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LotteryDashDisplayState calculateDisplayState(LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo, LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo, String countDownText) {
        Integer totalWinnerCount;
        String str;
        Integer totalWinnerCount2;
        if (Intrinsics.areEqual(activityInfo.getTaskStatus(), "going")) {
            if (!(userActivityInfo != null ? Intrinsics.areEqual(userActivityInfo.isJoined(), true) : false)) {
                Integer joinCnt = activityInfo.getJoinCnt();
                if ((joinCnt != null ? joinCnt.intValue() : 0) > 0) {
                    str = "限量" + (activityInfo.getTotalWinnerCount() != null ? totalWinnerCount2.intValue() : 0) + "件，" + activityInfo.getJoinCnt() + "人正在抽签";
                } else {
                    str = "限量" + (activityInfo.getTotalWinnerCount() != null ? totalWinnerCount.intValue() : 0) + "件";
                }
                return new LotteryDashDisplayState("商品正在", "参与抽签", null, "立即参与", str, null, 36, null);
            }
        }
        if (Intrinsics.areEqual(activityInfo.getTaskStatus(), "going")) {
            return new LotteryDashDisplayState("分享得", "更多抽签码", null, "去分享", "抽签码越多，中签机会越大哦！", null, 36, null);
        }
        if (Intrinsics.areEqual(activityInfo.getTaskStatus(), "end") && !Intrinsics.areEqual(activityInfo.isSubmitted(), true)) {
            return new LotteryDashDisplayState("商品正在", "参与抽签", null, "去查看", countDownText + "后公布抽签结果", null, 36, null);
        }
        if (Intrinsics.areEqual(activityInfo.getTaskStatus(), "end")) {
            if (userActivityInfo != null ? Intrinsics.areEqual(userActivityInfo.isWinner(), true) : false) {
                return new LotteryDashDisplayState("恭喜你", "中签", "啦，获得购买资格！", "查看结果", "请在" + formatMaxBuyTime(activityInfo.getMaxBuyTime()) + "前下单购买", null, 32, null);
            }
        }
        if (Intrinsics.areEqual(activityInfo.getTaskStatus(), "end")) {
            if (userActivityInfo != null ? Intrinsics.areEqual(userActivityInfo.isCouponReceived(), true) : false) {
                return new LotteryDashDisplayState("送你1张", "专属优惠券！", null, "查看结果", "差一点点就中签啦，不要灰心", null, 36, null);
            }
        }
        if (Intrinsics.areEqual(activityInfo.getTaskStatus(), "end")) {
            return new LotteryDashDisplayState("差一点点就中签啦", null, null, "查看结果", "不要灰心，逛逛其他商品吧", null, 38, null);
        }
        return new LotteryDashDisplayState(null, null, null, null, null, null, 63, null);
    }
}