package kntr.watch.later.watchlater.compose;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.favorites.FavoritesRes;
import bili.resource.favorites.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.watch.later.watchlater.data.Owner;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: WatchLaterCard.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001ap\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0011\u001a!\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"WatchLaterCard", "", "isChecked", "", "item", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "onCardClick", "Lkotlin/Function0;", "onCardLongClick", "onThreePointClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "aid", "modifier", "Landroidx/compose/ui/Modifier;", "isCheckMode", "(ZLkntr/watch/later/watchlater/data/WatchLaterItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "WatchLaterDividerCard", "dividerText", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$2(boolean z, WatchLaterItem watchLaterItem, Function0 function0, Function0 function02, Function1 function1, Modifier modifier, boolean z2, int i, int i2, Composer composer, int i3) {
        WatchLaterCard(z, watchLaterItem, function0, function02, function1, modifier, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterDividerCard$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        WatchLaterDividerCard(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x0a17, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L123;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x09e9  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0ab0  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0b48  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0b54  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0b5a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0bd8  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0d11  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0d4c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0e17  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0e5e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WatchLaterCard(final boolean isChecked, final WatchLaterItem item, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super WatchLaterItem, Unit> function1, Modifier modifier, boolean isCheckMode, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        boolean isCheckMode2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer3;
        Composer $composer$iv;
        String str;
        Arrangement.Horizontal horizontalArrangement$iv;
        String str2;
        Function0 factory$iv$iv$iv2;
        String pic;
        Painter painter;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Object value$iv;
        String str3;
        Function0 factory$iv$iv$iv5;
        Composer $composer4;
        String name;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(function0, "onCardClick");
        Intrinsics.checkNotNullParameter(function02, "onCardLongClick");
        Intrinsics.checkNotNullParameter(function1, "onThreePointClick");
        Composer $composer5 = $composer.startRestartGroup(-128328779);
        ComposerKt.sourceInformation($composer5, "C(WatchLaterCard)N(isChecked,item,onCardClick,onCardLongClick,onThreePointClick,modifier,isCheckMode)53@2264L209,53@2218L255,61@2478L7090:WatchLaterCard.kt#b3vx81");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer5.changed(isChecked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer5.changedInstance(item) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer5.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer5.changedInstance(function02) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer5.changedInstance(function1) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer5.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty2 |= 1572864;
        } else if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer5.changed(isCheckMode) ? 1048576 : 524288;
        }
        if (!$composer5.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            isCheckMode2 = isCheckMode;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                isCheckMode2 = isCheckMode;
            } else {
                isCheckMode2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-128328779, $dirty2, -1, "kntr.watch.later.watchlater.compose.WatchLaterCard (WatchLaterCard.kt:51)");
            }
            String displayTitle = item.getDisplayTitle();
            if (displayTitle == null) {
                displayTitle = "";
            }
            ComposerKt.sourceInformationMarkerStart($composer5, 1230105926, "CC(remember):WatchLaterCard.kt#9igjgp");
            boolean invalid$iv = $composer5.changedInstance(item);
            WatchLaterCardKt$WatchLaterCard$displayTitle$1$1 value$iv2 = $composer5.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new WatchLaterCardKt$WatchLaterCard$displayTitle$1$1(item, null);
                $composer5.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            State displayTitle2 = SnapshotStateKt.produceState(displayTitle, (Function2) value$iv2, $composer5, 0);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.combinedClickable-hoGz1lA$default(IntrinsicKt.height(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), IntrinsicSize.Max), false, (String) null, (Role) null, (String) null, function02, (Function0) null, false, (MutableInteractionSource) null, function0, 239, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            RowScope $this$WatchLaterCard_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, 1064301073, "C85@3211L2488,145@5708L40,147@5758L3804:WatchLaterCard.kt#b3vx81");
            if (isCheckMode2) {
                $composer5.startReplaceGroup(1064120249);
                ComposerKt.sourceInformation($composer5, "72@2840L223,79@3076L116");
                $composer$iv$iv = $composer5;
                horizontalArrangement$iv = horizontalArrangement$iv2;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv = $composer5;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                WatchLaterWidgetKt.m2599WatchLaterCheckBoxX34t5lA(isChecked, $this$WatchLaterCard_u24lambda_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), Alignment.Companion.getCenterVertically()), 0L, 0L, null, 0L, $composer5, $dirty2 & 14, 60);
                $composer3 = $composer5;
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            } else {
                $composer$iv$iv = $composer5;
                $composer3 = $composer5;
                $composer$iv = $composer5;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                horizontalArrangement$iv = horizontalArrangement$iv2;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer3.startReplaceGroup(1061304209);
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv2 = ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(128), Dp.constructor-impl(72)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
            Composer $composer$iv2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            String str4 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str4);
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            String str5 = str2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str5);
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv2);
            $dirty = $dirty2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            BoxScope $this$WatchLaterCard_u24lambda_u241_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 623172669, "C91@3390L276,105@3982L9,99@3680L755:WatchLaterCard.kt#b3vx81");
            if (item.isInvalid() || (pic = item.getPic()) == null) {
                pic = "";
            }
            BiliImageKt.BiliImage(new ImageRequest(pic).build(), ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), null, null, null, null, null, null, null, $composer$iv2, 0, 508);
            String coverText = item.getCoverText();
            String str6 = coverText == null ? "" : coverText;
            if (item.isInvalid()) {
                $composer$iv2.startReplaceGroup(2098322889);
                ComposerKt.sourceInformation($composer$iv2, "101@3791L30");
                Painter warning_report_circle_line_500 = BiliIconfont.INSTANCE.getWarning_report_circle_line_500($composer$iv2, 6);
                $composer$iv2.endReplaceGroup();
                painter = warning_report_circle_line_500;
            } else {
                $composer$iv2.startReplaceGroup(623535026);
                $composer$iv2.endReplaceGroup();
                painter = null;
            }
            WatchLaterWidgetKt.m2598IconTextH8uBujs(str6, PaddingKt.padding-VpY3zN4($this$WatchLaterCard_u24lambda_u241_u240.align(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Alignment.Companion.getBottomEnd()), Dp.constructor-impl(3), Dp.constructor-impl(1)), painter, 0, Dp.constructor-impl(2), Dp.constructor-impl(11), Color.Companion.getWhite-0d7_KjU(), Color.Companion.getWhite-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT10(), false, false, 0.0f, null, $composer$iv2, (Painter.$stable << 6) | 14376960, 0, 7688);
            String pgcLabel = item.getPgcLabel();
            if (!(pgcLabel == null || StringsKt.isBlank(pgcLabel))) {
                $composer$iv2.startReplaceGroup(624222669);
                ComposerKt.sourceInformation($composer$iv2, "119@4588L9,120@4641L6,125@4858L6,117@4502L586");
                TextKt.Text-Nvy7gAk(item.getPgcLabel(), $this$WatchLaterCard_u24lambda_u241_u240.align(PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), Dp.constructor-impl(1)), Alignment.Companion.getTopEnd()), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT10(), $composer$iv2, 0, 0, 131064);
            } else {
                $composer$iv2.startReplaceGroup(619737527);
            }
            $composer$iv2.endReplaceGroup();
            if (item.isInvalid() || item.getProgress() <= 0) {
                $composer$iv2.startReplaceGroup(619737527);
            } else {
                $composer$iv2.startReplaceGroup(624871716);
                ComposerKt.sourceInformation($composer$iv2, "140@5580L6,134@5272L403");
                float fraction = ((float) item.getProgress()) / ((float) item.getDuration());
                BoxKt.Box($this$WatchLaterCard_u24lambda_u241_u240.align(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), fraction), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(0.0f, Dp.constructor-impl(3), Dp.constructor-impl(3), 0.0f, 9, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null), Alignment.Companion.getBottomStart()), $composer$iv2, 0);
            }
            $composer$iv2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer3, 6);
            Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Composer $composer$iv3 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str4);
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str5);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i9 = ((6 >> 6) & 112) | 6;
            BoxScope $this$WatchLaterCard_u24lambda_u241_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 723278994, "C148@5811L2929:WatchLaterCard.kt#b3vx81");
            Modifier modifier$iv4 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Composer $composer6 = $composer3;
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str4);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str5);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer$iv3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i11 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$WatchLaterCard_u24lambda_u241_u241_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1967708354, "C151@5955L96,155@6227L9,156@6280L6,149@5871L528,160@6416L130,184@7390L1336:WatchLaterCard.kt#b3vx81");
            Modifier modifier5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 75072798, "CC(remember):WatchLaterCard.kt#9igjgp");
            boolean invalid$iv2 = $composer5.changedInstance(item);
            Object it$iv = $composer$iv3.rememberedValue();
            if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) value$iv);
                if (!item.isInvalid()) {
                    $composer$iv3.startReplaceGroup(75077405);
                    ComposerKt.sourceInformation($composer$iv3, "154@6100L63");
                    str3 = StringResourcesKt.stringResource(String0_commonMainKt.getFavorites_global_string_227(FavoritesRes.INSTANCE.getString()), $composer$iv3, 0);
                    $composer$iv3.endReplaceGroup();
                } else {
                    $composer$iv3.startReplaceGroup(75079971);
                    $composer$iv3.endReplaceGroup();
                    str3 = (String) displayTitle2.getValue();
                }
                TextKt.Text-Nvy7gAk(str3, graphicsLayer, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14(), $composer$iv3, 0, 24960, 110584);
                SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$WatchLaterCard_u24lambda_u241_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv3, 0);
                if (!item.getShowUp()) {
                    $composer$iv3.startReplaceGroup(-1967068949);
                    ComposerKt.sourceInformation($composer$iv3, "168@6698L104,172@6903L29,173@6980L9,175@7085L6,176@7144L6,166@6602L584,178@7207L148");
                    Modifier modifier6 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 75096582, "CC(remember):WatchLaterCard.kt#9igjgp");
                    boolean invalid$iv3 = $composer5.changedInstance(item);
                    Object it$iv2 = $composer$iv3.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv3 = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit WatchLaterCard$lambda$1$1$0$1$0;
                            WatchLaterCard$lambda$1$1$0$1$0 = WatchLaterCardKt.WatchLaterCard$lambda$1$1$0$1$0(WatchLaterItem.this, (GraphicsLayerScope) obj);
                            return WatchLaterCard$lambda$1$1$0$1$0;
                        }
                    };
                    $composer$iv3.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    Modifier graphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifier6, (Function1) it$iv2);
                    Owner owner = item.getOwner();
                    WatchLaterWidgetKt.m2598IconTextH8uBujs((owner == null || (name = owner.getName()) == null) ? "" : name, graphicsLayer2, BiliIconfont.INSTANCE.getUploader_name_square_line_500($composer$iv3, 6), 0, Dp.constructor-impl(2), 0.0f, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText3-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getGraph_medium-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT12(), false, false, 0.0f, null, $composer$iv3, (Painter.$stable << 6) | 24576, 0, 7720);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer$iv3, 6);
                } else {
                    $composer$iv3.startReplaceGroup(-1973621884);
                }
                $composer$iv3.endReplaceGroup();
                Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv2, $composer$iv3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv5 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str4);
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str5);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if (!$composer$iv3.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer$iv3.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i13 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -602459775, "C:WatchLaterCard.kt#b3vx81");
                if (item.isInvalid()) {
                    $composer$iv3.startReplaceGroup(-602439595);
                    ComposerKt.sourceInformation($composer$iv3, "207@8646L40");
                    String leftText = item.getLeftText();
                    if (!(leftText == null || StringsKt.isBlank(leftText))) {
                        $composer$iv3.startReplaceGroup(-602371364);
                        ComposerKt.sourceInformation($composer$iv3, "191@7819L9,193@7940L6,194@8007L6,187@7565L492");
                        WatchLaterWidgetKt.m2598IconTextH8uBujs(item.getLeftText(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(10), 0.0f, 11, (Object) null), null, item.getLeftIconType(), Dp.constructor-impl(2), 0.0f, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText3-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getGraph_medium-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT12(), false, false, 0.0f, null, $composer$iv3, 24624, 0, 7716);
                    } else {
                        $composer$iv3.startReplaceGroup(-609892088);
                    }
                    $composer$iv3.endReplaceGroup();
                    String rightText = item.getRightText();
                    if (!(rightText == null || StringsKt.isBlank(rightText))) {
                        $composer$iv3.startReplaceGroup(-601768476);
                        ComposerKt.sourceInformation($composer$iv3, "201@8357L9,203@8478L6,204@8545L6,198@8175L420");
                        WatchLaterWidgetKt.m2598IconTextH8uBujs(item.getRightText(), null, null, item.getRightIconType(), Dp.constructor-impl(2), 0.0f, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText3-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getGraph_medium-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT12(), false, false, 0.0f, null, $composer$iv3, 24576, 0, 7718);
                    } else {
                        $composer$iv3.startReplaceGroup(-609892088);
                    }
                    $composer$iv3.endReplaceGroup();
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv3, 6);
                } else {
                    $composer$iv3.startReplaceGroup(-609892088);
                }
                $composer$iv3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                if (isCheckMode2) {
                    $composer4 = $composer$iv3;
                    $composer4.startReplaceGroup(726123553);
                    ComposerKt.sourceInformation($composer4, "213@8838L22,221@9200L115,225@9410L27,227@9507L6,212@8789L749");
                    Painter more_vertical_fill_500 = BiliIconfont.INSTANCE.getMore_vertical_fill_500($composer4, 6);
                    Modifier align = $this$WatchLaterCard_u24lambda_u241_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), Alignment.Companion.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart($composer4, 716173063, "CC(remember):WatchLaterCard.kt#9igjgp");
                    Object it$iv3 = $composer4.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                        $composer4.updateRememberedValue(value$iv4);
                        it$iv3 = value$iv4;
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerStart($composer4, 716179695, "CC(remember):WatchLaterCard.kt#9igjgp");
                    $composer2 = $composer5;
                    boolean invalid$iv4 = (($dirty & 57344) == 16384) | $composer2.changedInstance(item);
                    Object it$iv4 = $composer4.rememberedValue();
                    if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit WatchLaterCard$lambda$1$1$2$0;
                                WatchLaterCard$lambda$1$1$2$0 = WatchLaterCardKt.WatchLaterCard$lambda$1$1$2$0(function1, item);
                                return WatchLaterCard$lambda$1$1$2$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    IconKt.Icon-ww6aTOc(more_vertical_fill_500, "more", ClickableKt.clickable-O2vRcR0$default(align, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText4-0d7_KjU(), $composer4, Painter.$stable | 48, 0);
                } else {
                    $composer2 = $composer5;
                    $composer4 = $composer$iv3;
                    $composer4.startReplaceGroup(717397518);
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            value$iv = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit WatchLaterCard$lambda$1$1$0$0$0;
                    WatchLaterCard$lambda$1$1$0$0$0 = WatchLaterCardKt.WatchLaterCard$lambda$1$1$0$0$0(WatchLaterItem.this, (GraphicsLayerScope) obj);
                    return WatchLaterCard$lambda$1$1$0$0$0;
                }
            };
            $composer$iv3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            Modifier graphicsLayer3 = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) value$iv);
            if (!item.isInvalid()) {
            }
            TextKt.Text-Nvy7gAk(str3, graphicsLayer3, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT14(), $composer$iv3, 0, 24960, 110584);
            SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$WatchLaterCard_u24lambda_u241_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv3, 0);
            if (!item.getShowUp()) {
            }
            $composer$iv3.endReplaceGroup();
            Modifier modifier$iv52 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv52 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv22, $composer$iv3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv52 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str4);
            int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv52 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv52);
            Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str5);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
            }
            $composer$iv3.startReusableNode();
            if (!$composer$iv3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
            int i122 = ($changed$iv$iv$iv52 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i132 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -602459775, "C:WatchLaterCard.kt#b3vx81");
            if (item.isInvalid()) {
            }
            $composer$iv3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if (isCheckMode2) {
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            final boolean z = isCheckMode2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterCard$lambda$2;
                    WatchLaterCard$lambda$2 = WatchLaterCardKt.WatchLaterCard$lambda$2(isChecked, item, function0, function02, function1, modifier7, z, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterCard$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$1$1$0$0$0(WatchLaterItem $item, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($item.isInvalid() ? 0.4f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$1$1$0$1$0(WatchLaterItem $item, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($item.isInvalid() ? 0.4f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$1$1$2$0(Function1 $onThreePointClick, WatchLaterItem $item) {
        $onThreePointClick.invoke($item);
        return Unit.INSTANCE;
    }

    public static final void WatchLaterDividerCard(final String dividerText, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-216819900);
        ComposerKt.sourceInformation($composer2, "C(WatchLaterDividerCard)N(dividerText,modifier)239@9689L904:WatchLaterCard.kt#b3vx81");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(dividerText) ? 4 : 2;
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
                ComposerKt.traceEventStart(-216819900, $dirty, -1, "kntr.watch.later.watchlater.compose.WatchLaterDividerCard (WatchLaterCard.kt:238)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$WatchLaterDividerCard_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833514300, "C251@10050L6,246@9884L196,256@10242L9,257@10287L6,253@10089L293,266@10557L6,261@10391L196:WatchLaterCard.kt#b3vx81");
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$WatchLaterDividerCard_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl((float) 0.5d)), 0.0f, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer2, 0, 2);
            TextKt.Text-Nvy7gAk(dividerText == null ? "" : dividerText, PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl((float) 7.5d), Dp.constructor-impl(6)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 24960, 110584);
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$WatchLaterDividerCard_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl((float) 0.5d)), 0.0f, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer2, 0, 2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterDividerCard$lambda$1;
                    WatchLaterDividerCard$lambda$1 = WatchLaterCardKt.WatchLaterDividerCard$lambda$1(dividerText, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterDividerCard$lambda$1;
                }
            });
        }
    }
}