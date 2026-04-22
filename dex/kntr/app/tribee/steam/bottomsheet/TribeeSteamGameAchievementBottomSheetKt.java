package kntr.app.tribee.steam.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementItem;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.tribee.consume.generated.resources.Drawable0_commonMainKt;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeSteamGameAchievementBottomSheet.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TribeeSteamGameAchievementBottomSheet", "", "achievement", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;", "modifier", "Landroidx/compose/ui/Modifier;", "onDismiss", "Lkotlin/Function0;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamGameAchievementBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameAchievementBottomSheet$lambda$3(KTribeeSteamHomeAchievementItem kTribeeSteamHomeAchievementItem, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeSteamGameAchievementBottomSheet(kTribeeSteamHomeAchievementItem, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v9 */
    public static final void TribeeSteamGameAchievementBottomSheet(final KTribeeSteamHomeAchievementItem achievement, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Function0 onDismiss;
        Modifier modifier3;
        final Modifier modifier4;
        Function0 onDismiss2;
        Intrinsics.checkNotNullParameter(achievement, "achievement");
        Composer $composer2 = $composer.startRestartGroup(-852812449);
        ComposerKt.sourceInformation($composer2, "C(TribeeSteamGameAchievementBottomSheet)N(achievement,modifier,onDismiss)52@2318L2,54@2358L43,54@2330L71,59@2494L6,60@2512L8496,57@2406L8602:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(achievement) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            onDismiss = function02;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 785995041, "CC(remember):TribeeSteamGameAchievementBottomSheet.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onDismiss2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onDismiss2 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-852812449, $dirty, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheet (TribeeSteamGameAchievementBottomSheet.kt:53)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 785996362, "CC(remember):TribeeSteamGameAchievementBottomSheet.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new TribeeSteamGameAchievementBottomSheetKt$TribeeSteamGameAchievementBottomSheet$2$1(null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(achievement, (Function2) it$iv2, $composer2, $dirty & 14);
            ComposeBottomsheetKt.m1831BottomSheetContainerlVb_Clg(onDismiss2, null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1277400622, true, new Function3() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeSteamGameAchievementBottomSheet$lambda$2;
                    TribeeSteamGameAchievementBottomSheet$lambda$2 = TribeeSteamGameAchievementBottomSheetKt.TribeeSteamGameAchievementBottomSheet$lambda$2(modifier4, achievement, (BottomSheetScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeSteamGameAchievementBottomSheet$lambda$2;
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onDismiss = onDismiss2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onDismiss;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamGameAchievementBottomSheet$lambda$3;
                    TribeeSteamGameAchievementBottomSheet$lambda$3 = TribeeSteamGameAchievementBottomSheetKt.TribeeSteamGameAchievementBottomSheet$lambda$3(achievement, modifier5, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamGameAchievementBottomSheet$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameAchievementBottomSheet$lambda$2(Modifier $modifier, KTribeeSteamHomeAchievementItem $achievement, BottomSheetScope $this$BottomSheetContainer, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        DrawableResource tribee_game_wing_dark;
        Function0 factory$iv$iv$iv3;
        DrawableResource tribee_game_wing_dark2;
        Composer $composer2;
        Function0 factory$iv$iv$iv4;
        Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
        ComposerKt.sourceInformation($composer, "C61@2522L8480:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1277400622, $changed, -1, "kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheet.<anonymous> (TribeeSteamGameAchievementBottomSheet.kt:61)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default($modifier, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(47), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(50), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1186007813, "C69@2794L4428,256@10875L117:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((54 >> 6) & 112) | 6;
            RowScope $this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1026395738, "C76@3072L7,75@3004L328,73@2943L606,88@3566L2899,150@6611L7,149@6543L328,160@7064L76,147@6482L726:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
            CompositionLocal this_$iv = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (consume == ThemeDayNight.Day) {
                tribee_game_wing_dark = Drawable0_commonMainKt.getTribee_game_wing_light(Res.drawable.INSTANCE);
            } else {
                tribee_game_wing_dark = Drawable0_commonMainKt.getTribee_game_wing_dark(Res.drawable.INSTANCE);
            }
            ImageKt.Image(ImageResourcesKt.painterResource(tribee_game_wing_dark, $composer, 0), "wing", SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(110)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            Modifier modifier$iv3 = BorderKt.border-ziNgDLE(ClipKt.clip(SizeKt.size-3ABfNKs(ShadowKt.shadow-s4CzXII$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(32), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(23), 7, (Object) null), Dp.constructor-impl(15), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), false, 0L, 0L, 28, (Object) null), Dp.constructor-impl(96)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16))), Dp.constructor-impl(6), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, TribeeExtensionsKt.getBorderColorList($achievement), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2098253128, "C114@4829L161,105@4386L2061:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
            String $this$asRequest$iv = $achievement.getAchievePicUrl();
            ImageRequest $this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u240_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u240_u240_u240.contentScale(ContentScale.Companion.getCrop());
            ImmutableImageRequest build = $this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u240_u240_u240.build();
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(96)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)));
            ComposerKt.sourceInformationMarkerStart($composer, -1733417457, "CC(remember):TribeeSteamGameAchievementBottomSheet.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$0$1$0;
                        TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$0$1$0 = TribeeSteamGameAchievementBottomSheetKt.TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$0$1$0((GraphicsLayerScope) obj);
                        return TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliImageKt.BiliImage(build, GraphicsLayerModifierKt.graphicsLayer(clip, (Function1) it$iv), "steam game cover", null, null, null, null, ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.INSTANCE.getLambda$1815285321$consume_debug(), ComposableSingletons$TribeeSteamGameAchievementBottomSheetKt.INSTANCE.getLambda$349045567$consume_debug(), $composer, 113246592, BackoffConfigKt.MAX_DELAY_SECONDS);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            CompositionLocal this_$iv2 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (consume2 == ThemeDayNight.Day) {
                tribee_game_wing_dark2 = Drawable0_commonMainKt.getTribee_game_wing_light(Res.drawable.INSTANCE);
            } else {
                tribee_game_wing_dark2 = Drawable0_commonMainKt.getTribee_game_wing_dark(Res.drawable.INSTANCE);
            }
            Painter painterResource = ImageResourcesKt.painterResource(tribee_game_wing_dark2, $composer, 0);
            Modifier modifier = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(110));
            ComposerKt.sourceInformationMarkerStart($composer, 1075396800, "CC(remember):TribeeSteamGameAchievementBottomSheet.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.bottomsheet.TribeeSteamGameAchievementBottomSheetKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$1$0;
                        TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$1$0 = TribeeSteamGameAchievementBottomSheetKt.TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$1$0((GraphicsLayerScope) obj);
                        return TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ImageKt.Image(painterResource, "wing", GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) it$iv2), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (!StringsKt.isBlank($achievement.getAchieveName())) {
                $composer2 = $composer;
                $composer2.startReplaceGroup(1190229051);
                ComposerKt.sourceInformation($composer2, "171@7430L6,168@7296L303");
                TextKt.Text-Nvy7gAk($achievement.getAchieveName(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 1597440, 24960, 241578);
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(1182981034);
            }
            $composer2.endReplaceGroup();
            if (StringsKt.isBlank($achievement.getAchieveDesc())) {
                $composer2.startReplaceGroup(1182981034);
            } else {
                $composer2.startReplaceGroup(1190618969);
                ComposerKt.sourceInformation($composer2, "182@7821L6,179@7687L369");
                TextKt.Text-Nvy7gAk($achievement.getAchieveDesc(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 24960, 240616);
            }
            $composer2.endReplaceGroup();
            if (StringsKt.isBlank($achievement.getAchieveTime())) {
                $composer2.startReplaceGroup(1182981034);
            } else {
                $composer2.startReplaceGroup(1191072747);
                ComposerKt.sourceInformation($composer2, "194@8278L6,191@8144L383");
                TextKt.Text-Nvy7gAk($achievement.getAchieveTime(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(12), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 24960, 241640);
            }
            $composer2.endReplaceGroup();
            if (StringsKt.isBlank($achievement.getAchievePerc())) {
                $composer2.startReplaceGroup(1182981034);
            } else {
                $composer2.startReplaceGroup(1191580434);
                ComposerKt.sourceInformation($composer2, "204@8615L2232");
                Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                Composer $composer$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv4 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer$iv.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i8 = ((54 >> 6) & 112) | 6;
                RowScope $this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u241 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -540402654, "C220@9410L6,208@8780L801,230@9803L6,226@9603L403,247@10587L6,236@10028L801:TribeeSteamGameAchievementBottomSheet.kt#vmcmav");
                SpacerKt.Spacer(BackgroundKt.background$default($this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u241.align(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(1)), Alignment.Companion.getCenterVertically()), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getLine_regular-0d7_KjU())}), 0L, 0L, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer$iv, 0);
                TextKt.Text-Nvy7gAk($achievement.getAchievePerc(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer$iv, 1597488, 24960, 241576);
                SpacerKt.Spacer(BackgroundKt.background$default($this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u241.align(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$TribeeSteamGameAchievementBottomSheet_u24lambda_u242_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(1)), Alignment.Companion.getCenterVertically()), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getLine_regular-0d7_KjU()), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0L, 0L, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer$iv, 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
            }
            $composer2.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(31)), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$0$1$0(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationX($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        $this$graphicsLayer.setTranslationY($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameAchievementBottomSheet$lambda$2$0$0$1$0(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(-1.0f);
        return Unit.INSTANCE;
    }
}