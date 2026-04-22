package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
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
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Collection;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.ServiceDescFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceDescComponent.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"ServiceDescComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ServiceDescItem", "data", "Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor$ServiceDesc;", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor$ServiceDesc;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "scaleModel", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "showDetail", "", "rotationDegree"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ServiceDescComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceDescComponent$lambda$0(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceDescComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceDescComponent$lambda$1(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceDescComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceDescComponent$lambda$4(ContentModule contentModule, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceDescComponent(contentModule, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceDescItem$lambda$6(ServiceDescFloor.ServiceDesc serviceDesc, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ServiceDescItem(serviceDesc, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ServiceDescComponent(final ContentModule module, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(1214734759);
        ComposerKt.sourceInformation($composer3, "C(ServiceDescComponent)N(module,pageViewModel,modifier)47@2035L16,59@2427L907,50@2090L1244:ServiceDescComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(pageViewModel) ? 32 : 16;
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
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1214734759, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ServiceDescComponent (ServiceDescComponent.kt:40)");
            }
            if (module instanceof ContentModule.ServiceDescModule) {
                ServiceDescFloor floorData = ((ContentModule.ServiceDescModule) module).getData();
                final List descList = floorData.getDescVOList();
                List list = descList;
                if (!(list == null || list.isEmpty())) {
                    State scaleModel$delegate = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer3, 0, 1);
                    final float scale = ServiceDescComponent$lambda$2(scaleModel$delegate).getScale();
                    $composer2 = $composer3;
                    PaddingCardKt.PaddingCard(modifier3, PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 7, (Object) null), PaddingKt.PaddingValues-YgX7TsA(ProvideUiScaleKt.dpScaled(12, scale), ProvideUiScaleKt.dpScaled(16, scale)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(12, scale)), ComposableLambdaKt.rememberComposableLambda(1940361964, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit ServiceDescComponent$lambda$3;
                            ServiceDescComponent$lambda$3 = ServiceDescComponentKt.ServiceDescComponent$lambda$3(descList, scale, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return ServiceDescComponent$lambda$3;
                        }
                    }, $composer3, 54), $composer3, (($dirty2 >> 6) & 14) | 24576, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier4 = modifier3;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ServiceDescComponent$lambda$1;
                                ServiceDescComponent$lambda$1 = ServiceDescComponentKt.ServiceDescComponent$lambda$1(ContentModule.this, pageViewModel, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return ServiceDescComponent$lambda$1;
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
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ServiceDescComponent$lambda$0;
                            ServiceDescComponent$lambda$0 = ServiceDescComponentKt.ServiceDescComponent$lambda$0(ContentModule.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ServiceDescComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ServiceDescComponent$lambda$4;
                    ServiceDescComponent$lambda$4 = ServiceDescComponentKt.ServiceDescComponent$lambda$4(ContentModule.this, pageViewModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServiceDescComponent$lambda$4;
                }
            });
        }
    }

    private static final UiScaleModel ServiceDescComponent$lambda$2(State<UiScaleModel> state) {
        Object thisObj$iv = state.getValue();
        return (UiScaleModel) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceDescComponent$lambda$3(List $descList, float $scale, BoxScope $this$PaddingCard, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter($this$PaddingCard, "$this$PaddingCard");
        ComposerKt.sourceInformation($composer, "C60@2437L891:ServiceDescComponent.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1940361964, $changed, -1, "kntr.app.mall.product.details.page.ui.components.ServiceDescComponent.<anonymous> (ServiceDescComponent.kt:60)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            Composer $composer$iv$iv = $composer;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Composer $composer$iv$iv$iv = $composer$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv.startReusableNode();
            if ($composer$iv$iv$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer$iv$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 414003921, "C:ServiceDescComponent.kt#o90vz8");
            $composer3.startReplaceGroup(983186569);
            ComposerKt.sourceInformation($composer3, "*66@2618L165");
            List $this$forEachIndexed$iv = $descList;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ServiceDescFloor.ServiceDesc serviceDesc = (ServiceDescFloor.ServiceDesc) item$iv;
                int index = index$iv;
                Composer $composer4 = $composer3;
                Composer $composer$iv$iv2 = $composer$iv$iv;
                Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                ServiceDescItem(serviceDesc, $scale, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer4, 384, 0);
                if (index != $descList.size() - 1) {
                    $composer2 = $composer4;
                    $composer2.startReplaceGroup(807841366);
                    ComposerKt.sourceInformation($composer2, "73@2855L54,79@3170L6,74@2930L281,81@3232L54");
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, $scale)), $composer2, 0);
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(0.5d, $scale)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_light-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, $scale)), $composer2, 0);
                } else {
                    $composer2 = $composer4;
                    $composer2.startReplaceGroup(805015437);
                }
                $composer2.endReplaceGroup();
                $composer3 = $composer2;
                index$iv = index$iv2;
                $composer$iv$iv = $composer$iv$iv2;
                horizontalAlignment$iv = horizontalAlignment$iv2;
                $composer$iv$iv$iv = $composer$iv$iv$iv2;
            }
            Composer $composer5 = $composer3;
            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv;
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x040a, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ServiceDescItem(final ServiceDescFloor.ServiceDesc data, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Iterable $this$forEach$iv;
        boolean z;
        Iterable $this$forEach$iv2;
        boolean z2;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer3 = $composer.startRestartGroup(-370720203);
        ComposerKt.sourceInformation($composer3, "C(ServiceDescItem)N(data,scale,modifier)94@3516L25,94@3499L42,98@3634L111,105@3846L64,102@3750L2220:ServiceDescComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(data) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(scale) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if (!$composer3.shouldExecute(($dirty3 & 147) != 146, $dirty3 & 1)) {
            $dirty = $dirty3;
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
                ComposerKt.traceEventStart(-370720203, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.ServiceDescItem (ServiceDescComponent.kt:93)");
            }
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart($composer3, 220175534, "CC(remember):ServiceDescComponent.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        MutableState ServiceDescItem$lambda$0$0;
                        ServiceDescItem$lambda$0$0 = ServiceDescComponentKt.ServiceDescItem$lambda$0$0();
                        return ServiceDescItem$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final MutableState showDetail$delegate = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) it$iv, $composer3, 48);
            List<ServiceDescFloor.ServiceDesc.Content> contents = data.getContents();
            boolean canExpand = !(contents == null || contents.isEmpty());
            final State rotationDegree$delegate = AnimateAsStateKt.animateFloatAsState(ServiceDescItem$lambda$1(showDetail$delegate) ? 0.0f : -180.0f, (AnimationSpec) null, 0.0f, "IconRotation", (Function1) null, $composer3, 3072, 22);
            ComposerKt.sourceInformationMarkerStart($composer3, 220186133, "CC(remember):ServiceDescComponent.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(showDetail$delegate);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit ServiceDescItem$lambda$4$0;
                        ServiceDescItem$lambda$4$0 = ServiceDescComponentKt.ServiceDescItem$lambda$4$0(showDetail$delegate);
                        return ServiceDescItem$lambda$4$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier4, canExpand, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            modifier3 = modifier4;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $dirty = $dirty3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2142460220, "C109@3928L884:ServiceDescComponent.kt#o90vz8");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1078972783, "C116@4208L6,117@4256L9,114@4127L172:ServiceDescComponent.kt#o90vz8");
            String title = data.getTitle();
            TextKt.Text-Nvy7gAk(title == null ? "" : title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), scale), $composer3, 0, 0, 131066);
            if (canExpand) {
                $composer3.startReplaceGroup(-1078762759);
                ComposerKt.sourceInformation($composer3, "122@4395L23,124@4504L6,128@4679L90,121@4346L442");
                Painter arrow_collapse_line_800 = BiliIconfont.INSTANCE.getArrow_collapse_line_800($composer3, 6);
                long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
                Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(12, scale));
                ComposerKt.sourceInformationMarkerStart($composer3, -311883159, "CC(remember):ServiceDescComponent.kt#9igjgp");
                boolean invalid$iv2 = $composer3.changed(rotationDegree$delegate);
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv3 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit ServiceDescItem$lambda$5$0$0$0;
                        ServiceDescItem$lambda$5$0$0$0 = ServiceDescComponentKt.ServiceDescItem$lambda$5$0$0$0(rotationDegree$delegate, (GraphicsLayerScope) obj);
                        return ServiceDescItem$lambda$5$0$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(arrow_collapse_line_800, (String) null, GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) it$iv3), j, $composer3, Painter.$stable | 48, 0);
            } else {
                $composer3.startReplaceGroup(-1083088685);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ServiceDescItem$lambda$1(showDetail$delegate) && canExpand) {
                $composer3.startReplaceGroup(-2141573218);
                ComposerKt.sourceInformation($composer3, "136@4865L1089");
                Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(7, scale), 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -924122781, "C:ServiceDescComponent.kt#o90vz8");
                $composer3.startReplaceGroup(385832018);
                ComposerKt.sourceInformation($composer3, "");
                Iterable $this$forEach$iv3 = data.getContents();
                boolean z3 = false;
                for (Object element$iv : $this$forEach$iv3) {
                    ServiceDescFloor.ServiceDesc.Content content = (ServiceDescFloor.ServiceDesc.Content) element$iv;
                    String subTitle = content.getSubTitle();
                    Iterable desc = content.getDesc();
                    String str = subTitle;
                    if (!(str == null || str.length() == 0)) {
                        $this$forEach$iv = $this$forEach$iv3;
                        $composer3.startReplaceGroup(216193857);
                        ComposerKt.sourceInformation($composer3, "143@5287L6,144@5347L9,141@5190L211");
                        BiliTheme biliTheme = BiliTheme.INSTANCE;
                        z = z3;
                        int $i$f$forEach = BiliTheme.$stable;
                        TextKt.Text-Nvy7gAk(subTitle, (Modifier) null, biliTheme.getColors($composer3, $i$f$forEach).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), scale), $composer3, 0, 0, 131066);
                    } else {
                        $this$forEach$iv = $this$forEach$iv3;
                        z = z3;
                        $composer3.startReplaceGroup(211062148);
                    }
                    $composer3.endReplaceGroup();
                    List<String> list = (Collection) desc;
                    if (!(list == null || list.isEmpty())) {
                        $composer3.startReplaceGroup(216504353);
                        ComposerKt.sourceInformation($composer3, "");
                        Iterable $this$forEach$iv4 = desc;
                        boolean z4 = false;
                        for (Object element$iv2 : $this$forEach$iv4) {
                            String text = (String) element$iv2;
                            if (text.length() > 0) {
                                $this$forEach$iv2 = $this$forEach$iv4;
                                $composer3.startReplaceGroup(1628516563);
                                ComposerKt.sourceInformation($composer3, "152@5714L6,153@5782L9,150@5605L239");
                                BiliTheme biliTheme2 = BiliTheme.INSTANCE;
                                z2 = z4;
                                int $i$f$forEach2 = BiliTheme.$stable;
                                TextKt.Text-Nvy7gAk(text, (Modifier) null, biliTheme2.getColors($composer3, $i$f$forEach2).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), scale), $composer3, 0, 0, 131066);
                            } else {
                                $this$forEach$iv2 = $this$forEach$iv4;
                                z2 = z4;
                                $composer3.startReplaceGroup(1622979746);
                            }
                            $composer3.endReplaceGroup();
                            $this$forEach$iv4 = $this$forEach$iv2;
                            z4 = z2;
                        }
                    } else {
                        $composer3.startReplaceGroup(211062148);
                    }
                    $composer3.endReplaceGroup();
                    $this$forEach$iv3 = $this$forEach$iv;
                    z3 = z;
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer3.startReplaceGroup(-2146420905);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.ServiceDescComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ServiceDescItem$lambda$6;
                    ServiceDescItem$lambda$6 = ServiceDescComponentKt.ServiceDescItem$lambda$6(ServiceDescFloor.ServiceDesc.this, scale, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ServiceDescItem$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ServiceDescItem$lambda$0$0() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final boolean ServiceDescItem$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void ServiceDescItem$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final float ServiceDescItem$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceDescItem$lambda$4$0(MutableState $showDetail$delegate) {
        ServiceDescItem$lambda$2($showDetail$delegate, !ServiceDescItem$lambda$1($showDetail$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ServiceDescItem$lambda$5$0$0$0(State $rotationDegree$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setRotationZ(ServiceDescItem$lambda$3($rotationDegree$delegate));
        return Unit.INSTANCE;
    }
}