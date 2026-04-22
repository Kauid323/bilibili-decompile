package kntr.app.mall.product.details.page.ui.components;

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
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.IpBrandFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageActionHandler;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IpBrandFloorComponent.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001aE\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"IpBrandFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IpBrandItem", "item", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpBrandInfo;", "onItem", "Lkotlin/Function1;", "scale", "", "useClearBg", "", "(Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpBrandInfo;Lkotlin/jvm/functions/Function1;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IpBrandFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IpBrandFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        IpBrandFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IpBrandFloorComponent$lambda$1(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        IpBrandFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IpBrandFloorComponent$lambda$4(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        IpBrandFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IpBrandItem$lambda$2(IpBrandFloor.IpBrandInfo ipBrandInfo, Function1 function1, float f, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        IpBrandItem(ipBrandInfo, function1, f, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x03ea, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IpBrandFloorComponent(final ContentModule module, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Iterable $this$forEachIndexed$iv;
        boolean z;
        List ipRightList;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer3 = $composer.startRestartGroup(739972608);
        ComposerKt.sourceInformation($composer3, "C(IpBrandFloorComponent)N(module,pageViewModelWrapper,modifier)52@2326L16,54@2402L25,55@2432L3493:IpBrandFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModelWrapper) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(739972608, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponent (IpBrandFloorComponent.kt:44)");
            }
            if (module instanceof ContentModule.IpBrandModule) {
                IpBrandFloor floorData = ((ContentModule.IpBrandModule) module).getData();
                List ipBrandInfoList = floorData.getIpBrandInfoList();
                if (ipBrandInfoList != null) {
                    final List ipRightList2 = floorData.getIpRightList();
                    if (ipRightList2 == null) {
                        ipRightList2 = CollectionsKt.emptyList();
                    }
                    final PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
                    State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                    float scale = IpBrandFloorComponent$lambda$2(scaleModel$delegate).getScale();
                    CollectorHolder collectorHolder = ExposerKt.rememberCollectorHolder($composer3, 0);
                    int $changed$iv = ($dirty2 >> 6) & 14;
                    Modifier modifier$iv = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = ($changed$iv << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    modifier3 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv3;
                        $composer3.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv3;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                    $composer2 = $composer3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i4 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -2080763600, "C58@2482L3437:IpBrandFloorComponent.kt#o90vz8");
                    Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    int $changed$iv$iv2 = (438 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer3.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    boolean z2 = false;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i6 = ((438 >> 6) & 112) | 6;
                    RowScope $this$IpBrandFloorComponent_u24lambda_u243_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -32272126, "C:IpBrandFloorComponent.kt#o90vz8");
                    boolean useClearBg = ipBrandInfoList.size() < 2;
                    $composer3.startReplaceGroup(1522981787);
                    ComposerKt.sourceInformation($composer3, "*95@4184L1612,90@3892L1904,72@3026L731,70@2951L2944");
                    List $this$forEachIndexed$iv2 = ipBrandInfoList;
                    boolean z3 = false;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv2) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        List ipBrandInfoList2 = ipBrandInfoList;
                        final IpBrandFloor.IpBrandInfo info = (IpBrandFloor.IpBrandInfo) item$iv;
                        int index = index$iv;
                        if (index != 0) {
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            $composer3.startReplaceGroup(-1734133011);
                            ComposerKt.sourceInformation($composer3, "68@2874L42");
                            z = z3;
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), $composer3, 0);
                        } else {
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            z = z3;
                            $composer3.startReplaceGroup(-1736965729);
                        }
                        $composer3.endReplaceGroup();
                        Modifier weight$default = RowScope.-CC.weight$default($this$IpBrandFloorComponent_u24lambda_u243_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        boolean z4 = z2;
                        String str = "ip_brand_" + info.getTitle();
                        ComposerKt.sourceInformationMarkerStart($composer3, -471537617, "CC(remember):IpBrandFloorComponent.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(info) | $composer3.changedInstance(pageViewModel) | $composer3.changedInstance(ipRightList2);
                        Modifier materialized$iv$iv3 = materialized$iv$iv2;
                        Object it$iv = $composer3.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponentKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit IpBrandFloorComponent$lambda$3$0$0$0$0;
                                IpBrandFloorComponent$lambda$3$0$0$0$0 = IpBrandFloorComponentKt.IpBrandFloorComponent$lambda$3$0$0$0$0(IpBrandFloor.IpBrandInfo.this, pageViewModel, ipRightList2);
                                return IpBrandFloorComponent$lambda$3$0$0$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier reportOnExposure = ExposerKt.reportOnExposure(weight$default, str, collectorHolder, null, false, 0.5f, 0, 500L, (Function0) it$iv, $composer3, 12779520, 44);
                        ComposerKt.sourceInformationMarkerStart($composer3, -471575554, "CC(remember):IpBrandFloorComponent.kt#9igjgp");
                        boolean invalid$iv2 = $composer3.changedInstance(pageViewModel) | $composer3.changed(info);
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                            ipRightList = ipRightList2;
                        } else {
                            ipRightList = ipRightList2;
                            if (it$iv2 != Composer.Companion.getEmpty()) {
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                IpBrandItem(info, (Function1) it$iv2, scale, reportOnExposure, useClearBg, $composer3, 0, 0);
                                ipBrandInfoList = ipBrandInfoList2;
                                ipRightList2 = ipRightList;
                                z2 = z4;
                                materialized$iv$iv2 = materialized$iv$iv3;
                                index$iv = index$iv2;
                                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                z3 = z;
                            }
                        }
                        Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponentKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj) {
                                Unit IpBrandFloorComponent$lambda$3$0$0$1$0;
                                IpBrandFloorComponent$lambda$3$0$0$1$0 = IpBrandFloorComponentKt.IpBrandFloorComponent$lambda$3$0$0$1$0(PageViewModel.this, info, (IpBrandFloor.IpBrandInfo) obj);
                                return IpBrandFloorComponent$lambda$3$0$0$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        IpBrandItem(info, (Function1) it$iv2, scale, reportOnExposure, useClearBg, $composer3, 0, 0);
                        ipBrandInfoList = ipBrandInfoList2;
                        ipRightList2 = ipRightList;
                        z2 = z4;
                        materialized$iv$iv2 = materialized$iv$iv3;
                        index$iv = index$iv2;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        z3 = z;
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier5 = modifier4;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponentKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj, Object obj2) {
                                Unit IpBrandFloorComponent$lambda$1;
                                IpBrandFloorComponent$lambda$1 = IpBrandFloorComponentKt.IpBrandFloorComponent$lambda$1(ContentModule.this, pageViewModelWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return IpBrandFloorComponent$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer3.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier6 = modifier4;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponentKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit IpBrandFloorComponent$lambda$0;
                            IpBrandFloorComponent$lambda$0 = IpBrandFloorComponentKt.IpBrandFloorComponent$lambda$0(ContentModule.this, pageViewModelWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return IpBrandFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit IpBrandFloorComponent$lambda$4;
                    IpBrandFloorComponent$lambda$4 = IpBrandFloorComponentKt.IpBrandFloorComponent$lambda$4(ContentModule.this, pageViewModelWrapper, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return IpBrandFloorComponent$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel IpBrandFloorComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IpBrandFloorComponent$lambda$3$0$0$1$0(PageViewModel $pageViewModel, IpBrandFloor.IpBrandInfo $info, IpBrandFloor.IpBrandInfo item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String jumpUrl = item.getNaJumpUrl();
        $pageViewModel.handleJumpUrl$product_details_page_debug(jumpUrl);
        Integer type = $info.getType();
        if (type != null && type.intValue() == 0) {
            PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_IP_0_CLICK, null, true, false, 10, null);
        } else {
            Integer type2 = $info.getType();
            if (type2 != null && type2.intValue() == 1) {
                PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_BRAND_0_CLICK, null, true, false, 10, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IpBrandFloorComponent$lambda$3$0$0$0$0(IpBrandFloor.IpBrandInfo $info, PageViewModel $pageViewModel, List $ipRightList) {
        Object obj;
        Integer type = $info.getType();
        if (type == null) {
            return Unit.INSTANCE;
        }
        int type2 = type.intValue();
        switch (type2) {
            case 0:
                String itemsId = $pageViewModel.getItemsId$product_details_page_debug();
                Iterator it = $ipRightList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        IpBrandFloor.IpRightInfo it2 = (IpBrandFloor.IpRightInfo) obj;
                        if (Intrinsics.areEqual(it2.getTitle(), $info.getTitle())) {
                        }
                    } else {
                        obj = null;
                    }
                }
                IpBrandFloor.IpRightInfo ipRightInfo = (IpBrandFloor.IpRightInfo) obj;
                String ipRightId = ipRightInfo != null ? ipRightInfo.getIpRightId() : null;
                PageActionHandler actionHandler$product_details_page_debug = $pageViewModel.getActionHandler$product_details_page_debug();
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to("itemsId", itemsId == null ? "" : itemsId);
                pairArr[1] = TuplesKt.to("id", ipRightId != null ? ipRightId : "");
                PageActionHandler.trackEvent$product_details_page_debug$default(actionHandler$product_details_page_debug, TrackConsts.MALL_MALL_DETAIL_IP_0_SHOW, MapsKt.mapOf(pairArr), false, false, 8, null);
                break;
            case 1:
                PageActionHandler.trackEvent$product_details_page_debug$default($pageViewModel.getActionHandler$product_details_page_debug(), TrackConsts.MALL_MALL_DETAIL_BRAND_0_SHOW, null, false, false, 10, null);
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0a20  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void IpBrandItem(final IpBrandFloor.IpBrandInfo item, final Function1<? super IpBrandFloor.IpBrandInfo, Unit> function1, final float scale, Modifier modifier, boolean useClearBg, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean useClearBg2;
        Composer $composer2;
        Modifier modifier3;
        boolean useClearBg3;
        Modifier modifier4;
        long j;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer$iv;
        Composer $composer3;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv;
        double d;
        Function0 factory$iv$iv$iv5;
        Composer $composer4 = $composer.startRestartGroup(-1058030018);
        ComposerKt.sourceInformation($composer4, "C(IpBrandItem)N(item,onItem,scale,modifier,useClearBg)157@6694L52,145@6262L4227:IpBrandFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(scale) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            useClearBg2 = useClearBg;
        } else if (($changed & 24576) == 0) {
            useClearBg2 = useClearBg;
            $dirty |= $composer4.changed(useClearBg2) ? 16384 : 8192;
        } else {
            useClearBg2 = useClearBg;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            useClearBg3 = useClearBg2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                useClearBg2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1058030018, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.IpBrandItem (IpBrandFloorComponent.kt:140)");
            }
            String imgUrl = item.getImg();
            String text = item.getTitle();
            String score = item.getScore();
            String scorePrefix = item.getScorePrefix();
            Modifier clip = ClipKt.clip(SizeKt.height-3ABfNKs(modifier4, ProvideUiScaleKt.dpScaled(40, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(6, scale)));
            if (useClearBg2) {
                $composer4.startReplaceGroup(993276891);
                $composer4.endReplaceGroup();
                j = Color.Companion.getTransparent-0d7_KjU();
            } else {
                $composer4.startReplaceGroup(993355352);
                ComposerKt.sourceInformation($composer4, "155@6628L6");
                j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg2-0d7_KjU();
                $composer4.endReplaceGroup();
            }
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(clip, j, (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1140425746, "CC(remember):IpBrandFloorComponent.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit IpBrandItem$lambda$0$0;
                        IpBrandItem$lambda$0$0 = IpBrandFloorComponentKt.IpBrandItem$lambda$0$0(function1, item);
                        return IpBrandItem$lambda$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            useClearBg3 = useClearBg2;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
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
            ComposerKt.sourceInformationMarkerStart($composer4, -436440924, "C161@6764L3719:IpBrandFloorComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
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
            RowScope $this$IpBrandItem_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1057928159, "C167@6939L41,168@6993L390,179@7396L41,180@7450L2662,242@10125L41,244@10224L28,245@10287L6,243@10179L240,249@10432L41:IpBrandFloorComponent.kt#o90vz8");
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer4, 0);
            Modifier modifier$iv3 = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(32, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, scale)));
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1371800818, "C174@7206L163:IpBrandFloorComponent.kt#o90vz8");
            String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(imgUrl == null ? "" : imgUrl);
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer4, 48, 508);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer4, 0);
            Modifier modifier$iv4 = RowScope.-CC.weight$default($this$IpBrandItem_u24lambda_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv4 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Column = $changed$iv$iv4 << 6;
            int $changed$iv$iv$iv4 = ($i$f$Column & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer4.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i11 = ((48 >> 6) & 112) | 6;
            $composer4.startReplaceGroup(1331527839);
            ComposerKt.sourceInformation($composer4, "C186@7683L6,187@7735L9,184@7596L273:IpBrandFloorComponent.kt#o90vz8");
            String str = text == null ? "" : text;
            BiliTheme biliTheme = BiliTheme.INSTANCE;
            int compositeKeyHash$iv$iv5 = BiliTheme.$stable;
            TextKt.Text-Nvy7gAk(str, (Modifier) null, biliTheme.getColors($composer4, compositeKeyHash$iv$iv5).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), scale), $composer4, 0, 24960, 110586);
            String str2 = score;
            if (str2 == null || str2.length() == 0) {
                $composer$iv = $composer4;
                $composer3 = $composer4;
                $composer$iv$iv$iv = $composer4;
                $composer$iv$iv = $composer4;
                $composer4.startReplaceGroup(1323914052);
            } else {
                $composer4.startReplaceGroup(1331833436);
                ComposerKt.sourceInformation($composer4, "204@8338L1742");
                try {
                    d = Double.parseDouble(score);
                } catch (Exception e) {
                    d = 0.0d;
                }
                double scoreDouble = d;
                if (scoreDouble > 0.0d) {
                    int scoreValue = (int) scoreDouble;
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier modifier$iv5 = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                    $composer3 = $composer4;
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv5 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    $composer$iv = $composer4;
                    $composer$iv$iv = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer4.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                    $composer$iv$iv$iv = $composer4;
                    MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv5;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i13 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1748070857, "C:IpBrandFloorComponent.kt#o90vz8");
                    String str3 = scorePrefix;
                    if (!(str3 == null || str3.length() == 0)) {
                        $composer4.startReplaceGroup(1748093455);
                        ComposerKt.sourceInformation($composer4, "211@8681L9,212@8760L6,208@8527L276");
                        TextKt.Text-Nvy7gAk(scorePrefix, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10(), scale), $composer4, 0, 24576, 114682);
                    } else {
                        $composer4.startReplaceGroup(1739625123);
                    }
                    $composer4.endReplaceGroup();
                    $composer4.startReplaceGroup(-359240064);
                    ComposerKt.sourceInformation($composer4, "*218@8998L22,220@9130L6,217@8937L470");
                    int i14 = 0;
                    while (i14 < scoreValue) {
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getStar_favorite_fill_200($composer4, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(1, scale), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(10, scale)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
                        i14++;
                        measurePolicy$iv$iv = measurePolicy$iv$iv;
                    }
                    $composer4.endReplaceGroup();
                    if (scoreDouble > scoreValue) {
                        $composer4.startReplaceGroup(1749124267);
                        ComposerKt.sourceInformation($composer4, "230@9621L24,232@9755L6,229@9560L472");
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getStar_grade_half_fill_900($composer4, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(2, scale), 0.0f, 11, (Object) null), ProvideUiScaleKt.dpScaled(10, scale)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
                    } else {
                        $composer4.startReplaceGroup(1739625123);
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                } else {
                    $composer4.endReplaceGroup();
                    $composer4.endReplaceGroup();
                    $composer$iv = $composer4;
                    $composer3 = $composer4;
                    $composer$iv$iv$iv = $composer4;
                    $composer$iv$iv = $composer4;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    Composer $composer5 = $composer3;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer5, 0);
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer5, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText3-0d7_KjU(), $composer5, Painter.$stable | 48, 0);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer5, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
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
                }
            }
            $composer4.endReplaceGroup();
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            Composer $composer52 = $composer3;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer52, 0);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer52, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale)), BiliTheme.INSTANCE.getColors($composer52, BiliTheme.$stable).getText3-0d7_KjU(), $composer52, Painter.$stable | 48, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(4, scale)), $composer52, 0);
            ComposerKt.sourceInformationMarkerEnd($composer52);
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
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z = useClearBg3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.IpBrandFloorComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IpBrandItem$lambda$2;
                    IpBrandItem$lambda$2 = IpBrandFloorComponentKt.IpBrandItem$lambda$2(IpBrandFloor.IpBrandInfo.this, function1, scale, modifier6, z, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return IpBrandItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IpBrandItem$lambda$0$0(Function1 $onItem, IpBrandFloor.IpBrandInfo $item) {
        $onItem.invoke($item);
        return Unit.INSTANCE;
    }
}