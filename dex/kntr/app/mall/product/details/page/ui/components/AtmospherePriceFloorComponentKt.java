package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.mall.product.details.page.api.model.ActAtmosphereVO;
import kntr.app.mall.product.details.page.api.model.AtmospherePriceFloor;
import kntr.app.mall.product.details.page.api.model.LabelObject;
import kntr.app.mall.product.details.page.api.model.PriceModel;
import kntr.app.mall.product.details.page.api.model.PriceVO;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.mall.product.details.page.vm.PageViewModelWrapper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AtmospherePriceFloorComponent.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0016\u001a'\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u008e\u0002"}, d2 = {"AtmospherePriceFloorComponent", "", "module", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "pageViewModelWrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/product/details/page/vm/ContentModule;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AtmosphereComponent", "atmosphereVO", "Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;", "pageViewModel", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "(Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LabelComponent", "data", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "scale", "", "(Lkntr/app/mall/product/details/page/api/model/LabelObject;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "CountDownComponent", "(Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PriceFloorComponent", "priceVO", "Lkntr/app/mall/product/details/page/api/model/PriceVO;", "(Lkntr/app/mall/product/details/page/api/model/PriceVO;Lkntr/app/mall/product/details/page/vm/PageViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "countDownText", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AtmospherePriceFloorComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AtmosphereComponent$lambda$1(ActAtmosphereVO actAtmosphereVO, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AtmosphereComponent(actAtmosphereVO, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AtmospherePriceFloorComponent$lambda$0(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AtmospherePriceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AtmospherePriceFloorComponent$lambda$1(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AtmospherePriceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AtmospherePriceFloorComponent$lambda$3(ContentModule contentModule, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AtmospherePriceFloorComponent(contentModule, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CountDownComponent$lambda$5(ActAtmosphereVO actAtmosphereVO, PageViewModelWrapper pageViewModelWrapper, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CountDownComponent(actAtmosphereVO, pageViewModelWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelComponent$lambda$0(LabelObject labelObject, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        LabelComponent(labelObject, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelComponent$lambda$3(LabelObject labelObject, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        LabelComponent(labelObject, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceFloorComponent$lambda$0(PriceVO priceVO, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PriceFloorComponent(priceVO, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceFloorComponent$lambda$2(PriceVO priceVO, PageViewModel pageViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PriceFloorComponent(priceVO, pageViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AtmospherePriceFloorComponent(final ContentModule module, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(pageViewModelWrapper, "pageViewModelWrapper");
        Composer $composer2 = $composer.startRestartGroup(-600937952);
        ComposerKt.sourceInformation($composer2, "C(AtmospherePriceFloorComponent)N(module,pageViewModelWrapper,modifier)68@2895L1272:AtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(module) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(pageViewModelWrapper) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-600937952, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponent (AtmospherePriceFloorComponent.kt:59)");
            }
            if (module instanceof ContentModule.AtmospherePriceModule) {
                PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
                AtmospherePriceFloor floorData = ((ContentModule.AtmospherePriceModule) module).getData();
                ActAtmosphereVO atmosphereVO = floorData.getActAtmosphereVO();
                PriceVO priceVO = floorData.getPriceVO();
                if (priceVO != null) {
                    Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i4 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$AtmospherePriceFloorComponent_u24lambda_u242 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -645922103, "C97@3899L6,98@3961L6,83@3292L869:AtmospherePriceFloorComponent.kt#o90vz8");
                    if (atmosphereVO == null) {
                        $composer2.startReplaceGroup(-645935869);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(-645935868);
                        ComposerKt.sourceInformation($composer2, "*74@3021L252");
                        AtmosphereComponent(atmosphereVO, pageViewModel, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), $composer2, 384, 0);
                        $composer2.endReplaceGroup();
                    }
                    PriceFloorComponent(priceVO, pageViewModel, BackgroundKt.background$default($this$AtmospherePriceFloorComponent_u24lambda_u242.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, atmosphereVO != null ? Dp.constructor-impl(34) : Dp.constructor-impl(0), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(38)), Alignment.Companion.getBottomCenter()), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU()), Color.box-impl(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg3-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null), 0.0f, 4, (Object) null), $composer2, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier4 = modifier3;
                        endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj, Object obj2) {
                                Unit AtmospherePriceFloorComponent$lambda$1;
                                AtmospherePriceFloorComponent$lambda$1 = AtmospherePriceFloorComponentKt.AtmospherePriceFloorComponent$lambda$1(ContentModule.this, pageViewModelWrapper, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                return AtmospherePriceFloorComponent$lambda$1;
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
                ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AtmospherePriceFloorComponent$lambda$0;
                            AtmospherePriceFloorComponent$lambda$0 = AtmospherePriceFloorComponentKt.AtmospherePriceFloorComponent$lambda$0(ContentModule.this, pageViewModelWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return AtmospherePriceFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit AtmospherePriceFloorComponent$lambda$3;
                    AtmospherePriceFloorComponent$lambda$3 = AtmospherePriceFloorComponentKt.AtmospherePriceFloorComponent$lambda$3(ContentModule.this, pageViewModelWrapper, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AtmospherePriceFloorComponent$lambda$3;
                }
            });
        }
    }

    public static final void AtmosphereComponent(final ActAtmosphereVO atmosphereVO, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv2;
        Composer $composer2;
        Composer $composer$iv$iv;
        Composer $composer$iv3;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(atmosphereVO, "atmosphereVO");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer4 = $composer.startRestartGroup(-501218264);
        ComposerKt.sourceInformation($composer4, "C(AtmosphereComponent)N(atmosphereVO,pageViewModel,modifier)113@4329L1636:AtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(atmosphereVO) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(pageViewModel) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-501218264, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.AtmosphereComponent (AtmospherePriceFloorComponent.kt:112)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1976207371, "C122@4567L1392:AtmospherePriceFloorComponent.kt#o90vz8");
            String it = atmosphereVO.getAtmosphereImg();
            if (it == null) {
                $composer4.startReplaceGroup(-1976223896);
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(-1976223895);
                ComposerKt.sourceInformation($composer4, "*117@4425L123");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(it);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), Modifier.Companion, null, null, null, null, null, null, null, $composer4, 48, 508);
                Unit unit2 = Unit.INSTANCE;
                $composer4.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(34));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            modifier3 = modifier4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((390 >> 6) & 112) | 6;
            RowScope $this$AtmosphereComponent_u24lambda_u240_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1397590928, "C139@5159L790:AtmospherePriceFloorComponent.kt#o90vz8");
            String it2 = atmosphereVO.getActLabel();
            if (it2 == null) {
                $composer4.startReplaceGroup(1397588136);
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(1397588137);
                ComposerKt.sourceInformation($composer4, "*130@4821L254,137@5092L40");
                String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(it2);
                ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                Unit unit4 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(18)), null, null, null, null, null, null, null, $composer4, 48, 508);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer4, 6);
                Unit unit5 = Unit.INSTANCE;
                $composer4.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
            }
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$AtmosphereComponent_u24lambda_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 0.0f, Dp.constructor-impl(20), 0.0f, 11, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 537373779, "C147@5465L77:AtmospherePriceFloorComponent.kt#o90vz8");
            LabelComponent(atmosphereVO.getLeftLabel(), null, 0.0f, $composer4, 0, 6);
            if (!Intrinsics.areEqual(atmosphereVO.getShowCountDown(), true)) {
                $composer$iv = $composer4;
                $composer$iv$iv$iv = $composer4;
                $composer$iv2 = $composer4;
                $composer2 = $composer4;
                $composer$iv$iv = $composer4;
                $composer$iv3 = $composer4;
                $composer3 = $composer4;
                $composer3.startReplaceGroup(537704362);
                ComposerKt.sourceInformation($composer3, "156@5831L86");
                LabelComponent(atmosphereVO.getRightLabel(), null, 0.0f, $composer3, 0, 6);
                $composer3.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(537498460);
                ComposerKt.sourceInformation($composer4, "151@5621L164");
                $composer$iv = $composer4;
                $composer$iv$iv$iv = $composer4;
                $composer2 = $composer4;
                $composer$iv$iv = $composer4;
                $composer$iv3 = $composer4;
                $composer$iv2 = $composer4;
                CountDownComponent(atmosphereVO, pageViewModel.getWrapper$product_details_page_debug(), null, $composer4, $dirty2 & 14, 4);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AtmosphereComponent$lambda$1;
                    AtmosphereComponent$lambda$1 = AtmospherePriceFloorComponentKt.AtmosphereComponent$lambda$1(ActAtmosphereVO.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AtmosphereComponent$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x049f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LabelComponent(final LabelObject data, Modifier modifier, float scale, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float scale2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        float scale3;
        float scale4;
        Modifier modifier5;
        int $dirty;
        Composer $composer3;
        Modifier modifier6;
        Composer $composer4;
        Modifier modifier7;
        String str;
        Composer $composer5;
        Modifier modifier8;
        Modifier modifier9;
        Function0 factory$iv$iv$iv;
        Composer $composer6 = $composer.startRestartGroup(1240804977);
        ComposerKt.sourceInformation($composer6, "C(LabelComponent)N(data,modifier,scale):AtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer6.changed(data) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer6.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            scale2 = scale;
        } else if (($changed & 384) == 0) {
            scale2 = scale;
            $dirty2 |= $composer6.changed(scale2) ? 256 : 128;
        } else {
            scale2 = scale;
        }
        int $dirty3 = $dirty2;
        if ($composer6.shouldExecute(($dirty3 & 147) != 146, $dirty3 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                scale3 = scale2;
            } else {
                scale3 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1240804977, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.LabelComponent (AtmospherePriceFloorComponent.kt:170)");
            }
            if (data == null) {
                $composer6.startReplaceGroup(-1962315144);
                ComposerKt.sourceInformation($composer6, "172@6135L130");
                BoxKt.Box(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(modifier4, Dp.constructor-impl(0)), Dp.constructor-impl(0)), $composer6, 0);
                $composer6.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer6.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier10 = modifier4;
                    final float f = scale3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2) {
                            Unit LabelComponent$lambda$0;
                            LabelComponent$lambda$0 = AtmospherePriceFloorComponentKt.LabelComponent$lambda$0(LabelObject.this, modifier10, f, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return LabelComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            $composer6.startReplaceGroup(-1968389935);
            $composer6.endReplaceGroup();
            Integer tagType = data.getTagType();
            if (tagType == null) {
                scale4 = scale3;
                modifier5 = modifier4;
                $dirty = $dirty3;
                $composer3 = $composer6;
            } else if (tagType.intValue() != 2) {
                scale4 = scale3;
                modifier5 = modifier4;
                $dirty = $dirty3;
                $composer3 = $composer6;
            } else {
                $composer6.startReplaceGroup(-1962000308);
                ComposerKt.sourceInformation($composer6, "183@6412L10");
                if (data.getBgImg$product_details_page_debug($composer6, $dirty3 & 14) == null) {
                    $composer6.startReplaceGroup(-1962000309);
                    $composer6.endReplaceGroup();
                    scale4 = scale3;
                    modifier6 = modifier4;
                    $composer4 = $composer6;
                } else {
                    $composer6.startReplaceGroup(-1962000308);
                    ComposerKt.sourceInformation($composer6, "*187@6625L10,186@6560L367");
                    Double backImgWidth = data.getBackImgWidth();
                    double imgWidth = backImgWidth != null ? backImgWidth.doubleValue() : 0.0d;
                    Double backImgHeight = data.getBackImgHeight();
                    double imgHeight = backImgHeight != null ? backImgHeight.doubleValue() : 0.0d;
                    String bgImg$product_details_page_debug = data.getBgImg$product_details_page_debug($composer6, $dirty3 & 14);
                    Intrinsics.checkNotNull(bgImg$product_details_page_debug);
                    String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(bgImg$product_details_page_debug);
                    scale4 = scale3;
                    modifier6 = modifier4;
                    $composer4 = $composer6;
                    BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(modifier4, ProvideUiScaleKt.dpScaled(imgWidth, scale3)), ProvideUiScaleKt.dpScaled(imgHeight, scale3)), ProvideUiScaleKt.dpScaled(4, scale3), 0.0f, 2, (Object) null), null, null, null, null, null, null, null, $composer4, 0, 508);
                    $composer4.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                }
                $composer4.endReplaceGroup();
                modifier7 = modifier6;
                $composer2 = $composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                scale2 = scale4;
            }
            if (tagType == null) {
                modifier7 = modifier5;
                str = "";
                $composer5 = $composer3;
            } else if (tagType.intValue() != 3) {
                modifier7 = modifier5;
                str = "";
                $composer5 = $composer3;
            } else {
                Composer $composer7 = $composer3;
                $composer7.startReplaceGroup(-1961433163);
                ComposerKt.sourceInformation($composer7, "208@7412L16,217@7949L12,198@6980L1444");
                Modifier.Companion companion = Modifier.Companion;
                if (data.getCornerRadius() != null) {
                    modifier8 = ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(data.getCornerRadius().intValue(), scale4)));
                } else {
                    modifier8 = Modifier.Companion;
                }
                Modifier then = companion.then(modifier8);
                if (data.getBorderWidth$product_details_page_debug($composer7, $dirty & 14) > 0.0f) {
                    $composer7.startReplaceGroup(-1961002232);
                    ComposerKt.sourceInformation($composer7, "210@7534L16,211@7617L16");
                    Modifier modifier11 = Modifier.Companion;
                    float dpScaled = ProvideUiScaleKt.dpScaled(data.getBorderWidth$product_details_page_debug($composer7, $dirty & 14), scale4);
                    Color m305getBorderColor6MYuD4A$product_details_page_debug = data.m305getBorderColor6MYuD4A$product_details_page_debug($composer7, $dirty & 14);
                    long j = m305getBorderColor6MYuD4A$product_details_page_debug != null ? m305getBorderColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getTransparent-0d7_KjU();
                    Integer cornerRadius = data.getCornerRadius();
                    modifier9 = BorderKt.border-xT4_qwU(modifier11, dpScaled, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(cornerRadius != null ? ProvideUiScaleKt.dpScaled(cornerRadius.intValue(), scale4) : Dp.constructor-impl(0)));
                    $composer7.endReplaceGroup();
                } else {
                    $composer7.startReplaceGroup(-1960616375);
                    $composer7.endReplaceGroup();
                    modifier9 = Modifier.Companion;
                }
                Modifier then2 = then.then(modifier9);
                Color m304getBgColor6MYuD4A$product_details_page_debug = data.m304getBgColor6MYuD4A$product_details_page_debug($composer7, $dirty & 14);
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(then2, m304getBgColor6MYuD4A$product_details_page_debug != null ? m304getBgColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null), ProvideUiScaleKt.dpScaled(4, scale4), 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                modifier7 = modifier5;
                ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
                CompositionLocalMap localMap$iv$iv = $composer7.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer7, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer7.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer7.startReusableNode();
                if ($composer7.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer7.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer7.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer7);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer7, -2109581640, "C224@8253L15,225@8323L9,221@8135L275:AtmospherePriceFloorComponent.kt#o90vz8");
                String title = data.getTitle();
                String str2 = title == null ? "" : title;
                Color m306getTitleColor6MYuD4A$product_details_page_debug = data.m306getTitleColor6MYuD4A$product_details_page_debug($composer7, $dirty & 14);
                TextKt.Text-Nvy7gAk(str2, Modifier.Companion, m306getTitleColor6MYuD4A$product_details_page_debug != null ? m306getTitleColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer7, BiliTheme.$stable).getT12(), scale4), $composer7, 48, 24576, 114680);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                $composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                $composer7.endReplaceGroup();
                $composer2 = $composer7;
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier7;
                scale2 = scale4;
            }
            if (tagType != null && tagType.intValue() == 4) {
                $composer5.startReplaceGroup(-1960007194);
                $composer5.endReplaceGroup();
                $composer2 = $composer5;
            } else {
                $composer5.startReplaceGroup(-1959937413);
                ComposerKt.sourceInformation($composer5, "239@8619L15,240@8685L9,236@8513L214");
                String title2 = data.getTitle();
                String str3 = title2 == null ? str : title2;
                Color m306getTitleColor6MYuD4A$product_details_page_debug2 = data.m306getTitleColor6MYuD4A$product_details_page_debug($composer5, $dirty & 14);
                $composer2 = $composer5;
                TextKt.Text-Nvy7gAk(str3, (Modifier) null, m306getTitleColor6MYuD4A$product_details_page_debug2 != null ? m306getTitleColor6MYuD4A$product_details_page_debug2.unbox-impl() : Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), scale4), $composer2, 0, 24576, 114682);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier7;
            scale2 = scale4;
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier12 = modifier3;
            final float f2 = scale2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit LabelComponent$lambda$3;
                    LabelComponent$lambda$3 = AtmospherePriceFloorComponentKt.LabelComponent$lambda$3(LabelObject.this, modifier12, f2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LabelComponent$lambda$3;
                }
            });
        }
    }

    private static final void CountDownComponent(final ActAtmosphereVO atmosphereVO, final PageViewModelWrapper pageViewModelWrapper, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        Object value$iv;
        Function0 factory$iv$iv$iv;
        Color m306getTitleColor6MYuD4A$product_details_page_debug;
        Composer $composer2 = $composer.startRestartGroup(-2098583112);
        ComposerKt.sourceInformation($composer2, "C(CountDownComponent)N(atmosphereVO,pageViewModelWrapper,modifier)256@9130L31,258@9214L2375,258@9167L2422,327@11595L1710:AtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(atmosphereVO) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(pageViewModelWrapper) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if (!$composer2.shouldExecute(($dirty3 & 147) != 146, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2098583112, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.CountDownComponent (AtmospherePriceFloorComponent.kt:251)");
            }
            PageViewModel pageViewModel = pageViewModelWrapper.getViewModel();
            Long serverTime = atmosphereVO.getServerTime();
            Long startTime = atmosphereVO.getAtmosStartTime();
            Long endTime = atmosphereVO.getAtmosEndTime();
            ComposerKt.sourceInformationMarkerStart($composer2, 1896270135, "CC(remember):AtmospherePriceFloorComponent.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState countDownText$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1896275167, "CC(remember):AtmospherePriceFloorComponent.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(startTime) | $composer2.changed(serverTime) | $composer2.changed(endTime) | $composer2.changedInstance(pageViewModel);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new AtmospherePriceFloorComponentKt$CountDownComponent$1$1(startTime, serverTime, endTime, pageViewModel, countDownText$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(startTime, endTime, serverTime, (Function2) it$iv2, $composer2, 0);
            int $changed$iv = ($dirty3 >> 6) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            $dirty = $dirty3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$CountDownComponent_u24lambda_u244 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1934478407, "C331@11725L495,345@12229L39,346@12277L470,360@12756L39,361@12804L495:AtmospherePriceFloorComponent.kt#o90vz8");
            LabelObject rightLabel = atmosphereVO.getRightLabel();
            if (rightLabel == null) {
                $composer2.startReplaceGroup(-1934488546);
                $composer2.endReplaceGroup();
                m306getTitleColor6MYuD4A$product_details_page_debug = null;
            } else {
                $composer2.startReplaceGroup(-755139517);
                ComposerKt.sourceInformation($composer2, "330@11686L15");
                m306getTitleColor6MYuD4A$product_details_page_debug = rightLabel.m306getTitleColor6MYuD4A$product_details_page_debug($composer2, 0);
                $composer2.endReplaceGroup();
            }
            long textColor = m306getTitleColor6MYuD4A$product_details_page_debug != null ? m306getTitleColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getWhite-0d7_KjU();
            String countDownPrefix = atmosphereVO.getCountDownPrefix();
            TextKt.Text-Nvy7gAk(countDownPrefix == null ? "" : countDownPrefix, $this$CountDownComponent_u24lambda_u244.alignByBaseline(Modifier.Companion), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), $composer2, 0, 24576, 114680);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
            TextKt.Text-Nvy7gAk(CountDownComponent$lambda$1(countDownText$delegate), $this$CountDownComponent_u24lambda_u244.alignByBaseline(Modifier.Companion), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), $composer2, 0, 24576, 114680);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
            String countDownSuffix = atmosphereVO.getCountDownSuffix();
            TextKt.Text-Nvy7gAk(countDownSuffix == null ? "" : countDownSuffix, $this$CountDownComponent_u24lambda_u244.alignByBaseline(Modifier.Companion), textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), "tnum", 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646041, (DefaultConstructorMarker) null), $composer2, 0, 24576, 114680);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit CountDownComponent$lambda$5;
                    CountDownComponent$lambda$5 = AtmospherePriceFloorComponentKt.CountDownComponent$lambda$5(ActAtmosphereVO.this, pageViewModelWrapper, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CountDownComponent$lambda$5;
                }
            });
        }
    }

    private static final String CountDownComponent$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0735, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PriceFloorComponent(final PriceVO priceVO, final PageViewModel pageViewModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        RowScope $this$PriceFloorComponent_u24lambda_u241;
        Composer $composer$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(priceVO, "priceVO");
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        Composer $composer3 = $composer.startRestartGroup(1926952180);
        ComposerKt.sourceInformation($composer3, "C(PriceFloorComponent)N(priceVO,pageViewModel,modifier)385@13500L5579:AtmospherePriceFloorComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(priceVO) ? 4 : 2;
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
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1926952180, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.PriceFloorComponent (AtmospherePriceFloorComponent.kt:383)");
            }
            PriceModel priceTag = priceVO.getPriceTag();
            if (priceTag != null) {
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(modifier3, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(30)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i4 = ((0 >> 6) & 112) | 6;
                RowScope $this$PriceFloorComponent_u24lambda_u2412 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -534311043, "C:AtmospherePriceFloorComponent.kt#o90vz8");
                String it = priceTag.getFirstPricePrefix();
                if (it == null) {
                    $composer3.startReplaceGroup(-534442888);
                    $composer3.endReplaceGroup();
                    $composer$iv$iv = $composer3;
                    $this$PriceFloorComponent_u24lambda_u241 = $this$PriceFloorComponent_u24lambda_u2412;
                } else {
                    $composer3.startReplaceGroup(-534442887);
                    ComposerKt.sourceInformation($composer3, "*396@13819L9,397@13869L6,394@13752L221");
                    $this$PriceFloorComponent_u24lambda_u241 = $this$PriceFloorComponent_u24lambda_u2412;
                    $composer$iv$iv = $composer3;
                    TextKt.Text-Nvy7gAk(it, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), $composer3, 0, 0, 131064);
                    Unit unit = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                String it2 = priceTag.getFirstPriceSymbol();
                if (it2 == null) {
                    $composer3.startReplaceGroup(-534160168);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-534160167);
                    ComposerKt.sourceInformation($composer3, "*404@14104L9,405@14154L6,402@14037L221");
                    TextKt.Text-Nvy7gAk(it2, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), $composer3, 0, 0, 131064);
                    Unit unit3 = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    Unit unit4 = Unit.INSTANCE;
                }
                String it3 = priceTag.getFirstPrice();
                if (it3 == null) {
                    $composer3.startReplaceGroup(-533878130);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-533878129);
                    ComposerKt.sourceInformation($composer3, "*418@14603L6,410@14316L391");
                    TextKt.Text-Nvy7gAk(it3, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $composer3, 0, 12582912, 131064);
                    Unit unit5 = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    Unit unit6 = Unit.INSTANCE;
                }
                String it4 = priceTag.getFirstPriceSuffix();
                if (it4 == null) {
                    $composer3.startReplaceGroup(-533432040);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-533432039);
                    ComposerKt.sourceInformation($composer3, "*425@14838L9,426@14888L6,423@14771L221");
                    TextKt.Text-Nvy7gAk(it4, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), $composer3, 0, 0, 131064);
                    Unit unit7 = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    Unit unit8 = Unit.INSTANCE;
                }
                if (priceTag.getPrice() == null && priceTag.getPricePrefix() == null && priceTag.getPriceSuffix() == null && priceTag.getPriceSymbol() == null) {
                    $composer3.startReplaceGroup(-548075726);
                } else {
                    $composer3.startReplaceGroup(-532975316);
                    ComposerKt.sourceInformation($composer3, "436@15195L39");
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer3, 6);
                    String it5 = priceTag.getPricePrefix();
                    if (it5 == null) {
                        $composer3.startReplaceGroup(-532919486);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-532919485);
                        ComposerKt.sourceInformation($composer3, "*440@15366L6,441@15418L9,438@15291L235");
                        TextKt.Text-Nvy7gAk(it5, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131064);
                        Unit unit9 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit10 = Unit.INSTANCE;
                    }
                    String it6 = priceTag.getPriceSymbol();
                    if (it6 == null) {
                        $composer3.startReplaceGroup(-532615934);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-532615933);
                        ComposerKt.sourceInformation($composer3, "*448@15672L6,449@15724L9,446@15597L235");
                        TextKt.Text-Nvy7gAk(it6, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131064);
                        Unit unit11 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit12 = Unit.INSTANCE;
                    }
                    String it7 = priceTag.getPrice();
                    if (it7 == null) {
                        $composer3.startReplaceGroup(-532318334);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-532318333);
                        ComposerKt.sourceInformation($composer3, "*456@15972L6,457@16024L9,454@15897L235");
                        TextKt.Text-Nvy7gAk(it7, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131064);
                        Unit unit13 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit14 = Unit.INSTANCE;
                    }
                    String it8 = priceTag.getPriceSuffix();
                    if (it8 == null) {
                        $composer3.startReplaceGroup(-532014627);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-532014626);
                        ComposerKt.sourceInformation($composer3, "*464@16278L6,465@16330L9,462@16203L240");
                        TextKt.Text-Nvy7gAk(it8, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10_cozy(), $composer3, 0, 0, 131064);
                        Unit unit15 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit16 = Unit.INSTANCE;
                    }
                }
                $composer3.endReplaceGroup();
                if (priceTag.getNetPrice() == null && priceTag.getNetPricePrefix() == null && priceTag.getNetPriceSuffix() == null && priceTag.getNetPriceSymbol() == null) {
                    $composer3.startReplaceGroup(-548075726);
                    $composer3.endReplaceGroup();
                    $composer2 = $composer3;
                } else {
                    $composer3.startReplaceGroup(-531475133);
                    ComposerKt.sourceInformation($composer3, "476@16672L40,482@16925L6,484@17031L106,477@16725L2338");
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer3, 6);
                    Modifier modifier4 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), RoundedCornerShapeKt.RoundedCornerShape(50)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -1956797382, "CC(remember):AtmospherePriceFloorComponent.kt#9igjgp");
                    boolean invalid$iv = $composer3.changedInstance(pageViewModel);
                    Object it$iv = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit PriceFloorComponent$lambda$1$8$0;
                            PriceFloorComponent$lambda$1$8$0 = AtmospherePriceFloorComponentKt.PriceFloorComponent$lambda$1$8$0(PageViewModel.this);
                            return PriceFloorComponent$lambda$1$8$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv2 = (0 << 3) & 112;
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
                    $composer2 = $composer3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i6 = ((0 >> 6) & 112) | 6;
                    RowScope $this$PriceFloorComponent_u24lambda_u241_u249 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 732866771, "C527@18746L28,526@18697L352:AtmospherePriceFloorComponent.kt#o90vz8");
                    String it9 = priceTag.getNetPricePrefix();
                    if (it9 == null) {
                        $composer3.startReplaceGroup(732842279);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(732842280);
                        ComposerKt.sourceInformation($composer3, "*491@17305L9,489@17222L244");
                        TextKt.Text-Nvy7gAk(it9, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241_u249.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 384, 0, 131064);
                        Unit unit17 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit18 = Unit.INSTANCE;
                    }
                    String it10 = priceTag.getNetPriceSymbol();
                    if (it10 == null) {
                        $composer3.startReplaceGroup(733169639);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(733169640);
                        ComposerKt.sourceInformation($composer3, "*499@17635L9,497@17552L244");
                        TextKt.Text-Nvy7gAk(it10, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241_u249.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 384, 0, 131064);
                        Unit unit19 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit20 = Unit.INSTANCE;
                    }
                    String it11 = priceTag.getNetPrice();
                    if (it11 == null) {
                        $composer3.startReplaceGroup(733497588);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(733497589);
                        ComposerKt.sourceInformation($composer3, "*505@17876L455");
                        TextKt.Text-Nvy7gAk(it11, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241_u249.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), $composer3, 384, 12582912, 131064);
                        Unit unit21 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit22 = Unit.INSTANCE;
                    }
                    String it12 = priceTag.getNetPriceSuffix();
                    if (it12 == null) {
                        $composer3.startReplaceGroup(734027719);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(734027720);
                        ComposerKt.sourceInformation($composer3, "*520@18500L9,518@18417L244");
                        TextKt.Text-Nvy7gAk(it12, OffsetKt.offset-VpY3zN4$default($this$PriceFloorComponent_u24lambda_u241_u249.alignByBaseline(Modifier.Companion), 0.0f, Dp.constructor-impl(3), 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 384, 0, 131064);
                        Unit unit23 = Unit.INSTANCE;
                        $composer3.endReplaceGroup();
                        Unit unit24 = Unit.INSTANCE;
                    }
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(3), Dp.constructor-impl(9), 0.0f, 0.0f, 12, (Object) null), Dp.constructor-impl(12)), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3504, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
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
                    final Modifier modifier5 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PriceFloorComponent$lambda$0;
                            PriceFloorComponent$lambda$0 = AtmospherePriceFloorComponentKt.PriceFloorComponent$lambda$0(PriceVO.this, pageViewModel, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return PriceFloorComponent$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.AtmospherePriceFloorComponentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriceFloorComponent$lambda$2;
                    PriceFloorComponent$lambda$2 = AtmospherePriceFloorComponentKt.PriceFloorComponent$lambda$2(PriceVO.this, pageViewModel, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PriceFloorComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceFloorComponent$lambda$1$8$0(PageViewModel $pageViewModel) {
        $pageViewModel.updateActivityCouponSheetState$product_details_page_debug(true);
        return Unit.INSTANCE;
    }
}