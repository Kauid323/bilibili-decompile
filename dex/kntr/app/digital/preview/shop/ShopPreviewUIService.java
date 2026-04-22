package kntr.app.digital.preview.shop;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.button.DigitalButtonsService;
import kntr.app.digital.preview.card.DigitalCardDetailInfoUIService;
import kntr.app.digital.preview.card.DigitalCardListUIService;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.web.FeaturePanelService;
import kntr.app.digital.preview.topmenu.DigitalTopBarUIService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: ShopPreviewUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "cardListService", "Lkntr/app/digital/preview/card/DigitalCardListUIService;", "topBarUIService", "Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "cardDetailInfoUIService", "Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;", "buttonsService", "Lkntr/app/digital/preview/button/DigitalButtonsService;", "featurePanelService", "Lkntr/app/digital/preview/card/web/FeaturePanelService;", "<init>", "(Lkntr/app/digital/preview/card/DigitalCardListUIService;Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;Lkntr/app/digital/preview/card/DigitalCardStateService;Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;Lkntr/app/digital/preview/button/DigitalButtonsService;Lkntr/app/digital/preview/card/web/FeaturePanelService;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShopPreviewUIService {
    public static final int $stable = 8;
    private final DigitalButtonsService buttonsService;
    private final DigitalCardDetailInfoUIService cardDetailInfoUIService;
    private final DigitalCardListUIService cardListService;
    private final DigitalCardStateService cardStateService;
    private final FeaturePanelService featurePanelService;
    private final DigitalTopBarUIService topBarUIService;

    @Inject
    public ShopPreviewUIService(DigitalCardListUIService cardListService, DigitalTopBarUIService topBarUIService, DigitalCardStateService cardStateService, DigitalCardDetailInfoUIService cardDetailInfoUIService, DigitalButtonsService buttonsService, FeaturePanelService featurePanelService) {
        Intrinsics.checkNotNullParameter(cardListService, "cardListService");
        Intrinsics.checkNotNullParameter(topBarUIService, "topBarUIService");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        Intrinsics.checkNotNullParameter(cardDetailInfoUIService, "cardDetailInfoUIService");
        Intrinsics.checkNotNullParameter(buttonsService, "buttonsService");
        Intrinsics.checkNotNullParameter(featurePanelService, "featurePanelService");
        this.cardListService = cardListService;
        this.topBarUIService = topBarUIService;
        this.cardStateService = cardStateService;
        this.cardDetailInfoUIService = cardDetailInfoUIService;
        this.buttonsService = buttonsService;
        this.featurePanelService = featurePanelService;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.preview.shop.ShopPreviewUIService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = ShopPreviewUIService.komponent$lambda$0(ShopPreviewUIService.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final ShopPreviewUIService this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, this$0) { // from class: kntr.app.digital.preview.shop.ShopPreviewUIService$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;
            final /* synthetic */ ShopPreviewUIService this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.this$0 = this$0;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Function0 factory$iv$iv$iv2;
                DigitalTopBarUIService digitalTopBarUIService;
                Function0 factory$iv$iv$iv3;
                DigitalCardDetailInfoUIService digitalCardDetailInfoUIService;
                DigitalCardDetailInfoUIService digitalCardDetailInfoUIService2;
                DigitalCardListUIService digitalCardListUIService;
                DigitalCardDetailInfoUIService digitalCardDetailInfoUIService3;
                FeaturePanelService featurePanelService;
                DigitalCardStateService digitalCardStateService;
                DigitalCardStateService digitalCardStateService2;
                Composer $composer2;
                DigitalButtonsService digitalButtonsService;
                DigitalButtonsService digitalButtonsService2;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                $composer.startReplaceGroup(1031768751);
                ComposerKt.sourceInformation($composer, "CN(it)*46@2021L4714:ShopPreviewUIService.kt#v8fyoc");
                int $changed$iv = $changed & 14 & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier);
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
                int i2 = (($changed$iv >> 6) & 112) | 6;
                BoxScope $this$komponent_u24lambda_u240_u240_u240 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -418543635, "C48@2100L46,47@2055L425,56@2505L3783:ShopPreviewUIService.kt#v8fyoc");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_top_highlight(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(222)), (Alignment) null, ContentScale.Companion.getFillWidth(), 0.0f, (ColorFilter) null, $composer, Painter.$stable | 25008, 104);
                Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv2 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 570480476, "C62@2781L41,64@2868L248,73@3246L776,71@3146L2427,117@5623L190:ShopPreviewUIService.kt#v8fyoc");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), $composer, 6);
                digitalTopBarUIService = this.this$0.topBarUIService;
                digitalTopBarUIService.Content(PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), Dp.constructor-impl(12), 0.0f, 2, (Object) null), $composer, 6, 0);
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, -951416554, "CC(remember):ShopPreviewUIService.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this.this$0);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final ShopPreviewUIService shopPreviewUIService = this.this$0;
                    Object value$iv = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: kntr.app.digital.preview.shop.ShopPreviewUIService$komponent$1$1$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                            return m1002invoke3p2s80s((MeasureScope) p1, (Measurable) p2, ((Constraints) p3).unbox-impl());
                        }

                        /* renamed from: invoke-3p2s80s  reason: not valid java name */
                        public final MeasureResult m1002invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long j2) {
                            DigitalCardStateService digitalCardStateService3;
                            Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                            Intrinsics.checkNotNullParameter(measurable, "measurable");
                            int width = Constraints.getMaxWidth-impl(j2);
                            digitalCardStateService3 = ShopPreviewUIService.this.cardStateService;
                            digitalCardStateService3.m931setMaxWidth0680j_4($this$layout.toDp-u2uoSUM(Constraints.getMaxWidth-impl(j2)));
                            int height = MathKt.roundToInt(((width - ($this$layout.toPx-0680j_4(Dp.constructor-impl(58)) * 2)) * 1.5f) + $this$layout.toPx-0680j_4(Dp.constructor-impl(117)) + $this$layout.toPx-0680j_4(Dp.constructor-impl(49)));
                            final Placeable placeable = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j2, 0, 0, height, height, 3, (Object) null));
                            return MeasureScope.-CC.layout$default($this$layout, width, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: kntr.app.digital.preview.shop.ShopPreviewUIService$komponent$1$1$1$1$1$1.1
                                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                    invoke((Placeable.PlacementScope) p1);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope $this$layout2) {
                                    Intrinsics.checkNotNullParameter($this$layout2, "$this$layout");
                                    Placeable.PlacementScope.place$default($this$layout2, placeable, 0, 0, 0.0f, 4, (Object) null);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv2 = LayoutModifierKt.layout(modifier2, (Function3) it$iv);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                BoxScope $this$komponent_u24lambda_u240_u240_u240_u240_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -756411252, "C85@4112L332,93@4502L326,101@4878L206,107@5142L401:ShopPreviewUIService.kt#v8fyoc");
                digitalCardDetailInfoUIService = this.this$0.cardDetailInfoUIService;
                digitalCardDetailInfoUIService.BaseUI(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs($this$komponent_u24lambda_u240_u240_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl(139)), Dp.constructor-impl(291)), $composer, 0, 0);
                digitalCardDetailInfoUIService2 = this.this$0.cardDetailInfoUIService;
                digitalCardDetailInfoUIService2.DescContent(ZIndexModifierKt.zIndex(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs($this$komponent_u24lambda_u240_u240_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl(139)), Dp.constructor-impl(291)), 1.0f), $composer, 0, 0);
                digitalCardListUIService = this.this$0.cardListService;
                digitalCardListUIService.Content(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(49), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), $composer, 6, 0);
                digitalCardDetailInfoUIService3 = this.this$0.cardDetailInfoUIService;
                digitalCardDetailInfoUIService3.NoticeContent(ZIndexModifierKt.zIndex(PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default($this$komponent_u24lambda_u240_u240_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(11), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(58), 0.0f, 2, (Object) null), 1.0f), $composer, 0, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                featurePanelService = this.this$0.featurePanelService;
                featurePanelService.Content(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(10), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), $composer, 6, 0);
                digitalCardStateService = this.this$0.cardStateService;
                if (digitalCardStateService.getCurrentCardItem().getBasic().getFeaturePanelShowing()) {
                    $composer.startReplaceGroup(567612820);
                } else {
                    $composer.startReplaceGroup(573485522);
                    ComposerKt.sourceInformation($composer, "124@5957L275");
                    digitalButtonsService2 = this.this$0.buttonsService;
                    digitalButtonsService2.Content(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(44), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), $composer, 6, 0);
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                digitalCardStateService2 = this.this$0.cardStateService;
                if (digitalCardStateService2.getCurrentCardItem().getBasic().getFeaturePanelShowing()) {
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(-414389233);
                    ComposerKt.sourceInformation($composer2, "134@6423L264");
                    digitalButtonsService = this.this$0.buttonsService;
                    digitalButtonsService.Content(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default($this$komponent_u24lambda_u240_u240_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), $composer2, 0, 0);
                } else {
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(-420727586);
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }
}