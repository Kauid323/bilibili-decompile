package kntr.common.photonic.aphro.ui.preview;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
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
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: GalleryPreviewHeader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001aM\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\r\u001aC\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"ImagePreviewSelectedBox", "", "selectIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "GalleryPreviewHeader", "onSelect", "Lkotlin/Function0;", "onUnSelect", "onBackPress", "selectedIndex", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ILandroidx/compose/runtime/Composer;II)V", "PreviewTopBar", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GalleryPreviewHeaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryPreviewHeader$lambda$2(Function0 function0, Function0 function02, Modifier modifier, Function0 function03, int i, int i2, int i3, Composer composer, int i4) {
        GalleryPreviewHeader(function0, function02, modifier, function03, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImagePreviewSelectedBox$lambda$1(int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        ImagePreviewSelectedBox(i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBar$lambda$3(int i, Function0 function0, Function0 function02, Function0 function03, int i2, int i3, Composer composer, int i4) {
        PreviewTopBar(i, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private static final void ImagePreviewSelectedBox(final int selectIndex, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        long j;
        Composer $composer2 = $composer.startRestartGroup(-432992332);
        ComposerKt.sourceInformation($composer2, "C(ImagePreviewSelectedBox)N(selectIndex,modifier)43@1680L6,37@1509L972:GalleryPreviewHeader.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(selectIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-432992332, $dirty, -1, "kntr.common.photonic.aphro.ui.preview.ImagePreviewSelectedBox (GalleryPreviewHeader.kt:36)");
            }
            Modifier modifier$iv = ClipKt.clip(BorderKt.border-xT4_qwU(SizeKt.size-3ABfNKs(modifier3, Dp.constructor-impl(22)), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier3;
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1469234848, "C50@1878L368:GalleryPreviewHeader.kt#n54g3c");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            if (selectIndex >= 0) {
                $composer2.startReplaceGroup(-1469128023);
                ComposerKt.sourceInformation($composer2, "54@2038L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer2.endReplaceGroup();
                j = j2;
            } else {
                $composer2.startReplaceGroup(-1469045873);
                $composer2.endReplaceGroup();
                j = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(fillMaxSize$default, j, (Shape) null, 2, (Object) null), $composer2, 0);
            if (selectIndex >= 0) {
                $composer2.startReplaceGroup(-1468838266);
                ComposerKt.sourceInformation($composer2, "65@2384L9,66@2433L6,63@2291L174");
                TextKt.Text-Nvy7gAk(String.valueOf(selectIndex + 1), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 0, 131066);
            } else {
                $composer2.startReplaceGroup(-1471117324);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier$iv$iv;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImagePreviewSelectedBox$lambda$1;
                    ImagePreviewSelectedBox$lambda$1 = GalleryPreviewHeaderKt.ImagePreviewSelectedBox$lambda$1(selectIndex, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImagePreviewSelectedBox$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v21 */
    public static final void GalleryPreviewHeader(final Function0<Unit> function0, final Function0<Unit> function02, Modifier modifier, Function0<Unit> function03, int selectedIndex, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function04;
        int selectedIndex2;
        Modifier modifier3;
        Function0 onBackPress;
        int selectedIndex3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onSelect");
        Intrinsics.checkNotNullParameter(function02, "onUnSelect");
        Composer $composer2 = $composer.startRestartGroup(1762176178);
        ComposerKt.sourceInformation($composer2, "C(GalleryPreviewHeader)N(onSelect,onUnSelect,modifier,onBackPress,selectedIndex)77@2642L2,80@2683L517:GalleryPreviewHeader.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function04 = function03;
        } else if (($changed & 3072) == 0) {
            function04 = function03;
            $dirty |= $composer2.changedInstance(function04) ? 2048 : 1024;
        } else {
            function04 = function03;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            selectedIndex2 = selectedIndex;
        } else if (($changed & 24576) == 0) {
            selectedIndex2 = selectedIndex;
            $dirty |= $composer2.changed(selectedIndex2) ? 16384 : 8192;
        } else {
            selectedIndex2 = selectedIndex;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onBackPress = function04;
            selectedIndex3 = selectedIndex2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                onBackPress = function04;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer2, 1234197076, "CC(remember):GalleryPreviewHeader.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onBackPress2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onBackPress = onBackPress2;
            }
            if (i4 != 0) {
                selectedIndex2 = -1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1762176178, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeader (GalleryPreviewHeader.kt:79)");
            }
            Modifier modifier$iv = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null));
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -441210979, "C92@3020L174:GalleryPreviewHeader.kt#n54g3c");
            PreviewTopBar(selectedIndex2, onBackPress, function0, function02, $composer2, (($dirty2 >> 12) & 14) | (($dirty2 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 6) & 7168), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selectedIndex3 = selectedIndex2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function0 function05 = onBackPress;
            final int i7 = selectedIndex3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit GalleryPreviewHeader$lambda$2;
                    GalleryPreviewHeader$lambda$2 = GalleryPreviewHeaderKt.GalleryPreviewHeader$lambda$2(function0, function02, modifier4, function05, i7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GalleryPreviewHeader$lambda$2;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0273, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0325, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void PreviewTopBar(final int selectIndex, final Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Composer $composer, final int $changed, final int i) {
        final Function0 onSelect;
        final Function0 onUnSelect;
        Composer $composer2;
        Function0 onUnSelect2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(1499050320);
        ComposerKt.sourceInformation($composer3, "C(PreviewTopBar)N(selectIndex,onBackPress,onSelect,onUnSelect)105@3321L2,106@3354L2,108@3366L1587:GalleryPreviewHeader.kt#n54g3c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectIndex) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            onSelect = function02;
        } else if (($changed & 384) == 0) {
            onSelect = function02;
            $dirty |= $composer3.changedInstance(onSelect) ? 256 : 128;
        } else {
            onSelect = function02;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            onUnSelect = function03;
        } else if (($changed & 3072) == 0) {
            onUnSelect = function03;
            $dirty |= $composer3.changedInstance(onUnSelect) ? 2048 : 1024;
        } else {
            onUnSelect = function03;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            onUnSelect2 = onUnSelect;
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1773316466, "CC(remember):GalleryPreviewHeader.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onSelect2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onSelect = onSelect2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1773317522, "CC(remember):GalleryPreviewHeader.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onUnSelect3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onUnSelect = onUnSelect3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1499050320, $dirty2, -1, "kntr.common.photonic.aphro.ui.preview.PreviewTopBar (GalleryPreviewHeader.kt:107)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44)), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((390 >> 6) & 112) | 6;
            RowScope $this$PreviewTopBar_u24lambda_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -407269468, "C117@3633L24,118@3688L6,125@3940L61,116@3592L420,130@4022L38,139@4299L209,132@4070L877:GalleryPreviewHeader.kt#n54g3c");
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer3, 6);
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU();
            Modifier align = $this$PreviewTopBar_u24lambda_u242.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Alignment.Companion.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart($composer3, -151675215, "CC(remember):GalleryPreviewHeader.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit PreviewTopBar$lambda$2$0$0;
                    PreviewTopBar$lambda$2$0$0 = GalleryPreviewHeaderKt.PreviewTopBar$lambda$2$0$0(function0);
                    return PreviewTopBar$lambda$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), j, $composer3, Painter.$stable | 48, 0);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$PreviewTopBar_u24lambda_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(10), 0.0f, Dp.constructor-impl(12), 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -151663579, "CC(remember):GalleryPreviewHeader.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & 896) == 256) | (($dirty2 & 7168) == 2048);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv4 = new Function0() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit PreviewTopBar$lambda$2$1$0;
                    PreviewTopBar$lambda$2$1$0 = GalleryPreviewHeaderKt.PreviewTopBar$lambda$2$1$0(selectIndex, onSelect, onUnSelect);
                    return PreviewTopBar$lambda$2$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            Function0 onSelect3 = onSelect;
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
            onUnSelect2 = onUnSelect;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -680850508, "C148@4594L81,151@4688L39,153@4769L51,154@4856L9,155@4905L6,152@4740L197:GalleryPreviewHeader.kt#n54g3c");
            ImagePreviewSelectedBox(selectIndex, null, $composer3, $dirty2 & 14, 2);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer3, 6);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_123(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
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
            onSelect = onSelect3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0 function04 = onSelect;
            final Function0 function05 = onUnSelect2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.GalleryPreviewHeaderKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewTopBar$lambda$3;
                    PreviewTopBar$lambda$3 = GalleryPreviewHeaderKt.PreviewTopBar$lambda$3(selectIndex, function0, function04, function05, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewTopBar$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBar$lambda$2$0$0(Function0 $onBackPress) {
        $onBackPress.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBar$lambda$2$1$0(int $selectIndex, Function0 $onSelect, Function0 $onUnSelect) {
        if ($selectIndex < 0) {
            $onSelect.invoke();
        } else {
            $onUnSelect.invoke();
        }
        return Unit.INSTANCE;
    }
}