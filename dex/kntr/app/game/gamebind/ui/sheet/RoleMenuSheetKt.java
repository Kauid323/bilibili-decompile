package kntr.app.game.gamebind.ui.sheet;

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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.bean.RoleMenuItem;
import kntr.app.game.gamebind.ui.report.ReporterKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.compose.res.CommonRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.String0_commonMainKt;

/* compiled from: RoleMenuSheet.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"RoleMenuSheet", RoomRecommendViewModel.EMPTY_CURSOR, "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "menuList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/gamebind/bean/RoleMenuItem;", "onMenuClick", "Lkotlin/Function1;", "onCancelClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/game/gamebind/bean/RoleItem;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "game-bind-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RoleMenuSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleMenuSheet$lambda$1(RoleItem roleItem, List list, Function1 function1, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RoleMenuSheet(roleItem, list, function1, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RoleMenuSheet(final RoleItem role, final List<RoleMenuItem> list, final Function1<? super RoleMenuItem, Unit> function1, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        MeasurePolicy measurePolicy$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        final Function1<? super RoleMenuItem, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(list, "menuList");
        Intrinsics.checkNotNullParameter(function12, "onMenuClick");
        Intrinsics.checkNotNullParameter(function0, "onCancelClick");
        Composer $composer2 = $composer.startRestartGroup(1403994777);
        ComposerKt.sourceInformation($composer2, "C(RoleMenuSheet)N(role,menuList,onMenuClick,onCancelClick,modifier)37@1339L6,36@1282L1517:RoleMenuSheet.kt#lq7tq6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(role) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1403994777, $dirty2, -1, "kntr.app.game.gamebind.ui.sheet.RoleMenuSheet (RoleMenuSheet.kt:35)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(modifier4, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            Composer $composer$iv$iv$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv.startReusableNode();
            if ($composer$iv$iv$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer$iv$iv$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer$iv$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv);
            MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv = $composer$iv$iv$iv;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 55583735, "C62@2252L6,60@2173L106,67@2421L107,65@2329L464:RoleMenuSheet.kt#lq7tq6");
            $composer$iv.startReplaceGroup(417434670);
            ComposerKt.sourceInformation($composer$iv, "*43@1595L121,41@1472L517,57@2120L6,55@2002L152");
            List<RoleMenuItem> $this$forEach$iv = list;
            int $i$f$forEach = 0;
            Iterator<T> it = $this$forEach$iv.iterator();
            while (true) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                int $i$f$forEach2 = $i$f$forEach;
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                final RoleMenuItem menu = (RoleMenuItem) element$iv;
                ReporterKt.reportMenuItemExpose(role, menu);
                boolean z3 = z;
                Modifier materialized$iv$iv2 = materialized$iv$iv;
                MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv$iv2;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(48)), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv, 115599855, "CC(remember):RoleMenuSheet.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(role) | $composer2.changedInstance(menu) | (($dirty2 & 896) == 256);
                Object it$iv = $composer$iv.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.gamebind.ui.sheet.RoleMenuSheetKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit RoleMenuSheet$lambda$0$0$0$0;
                            RoleMenuSheet$lambda$0$0$0$0 = RoleMenuSheetKt.RoleMenuSheet$lambda$0$0$0$0(RoleItem.this, menu, function12);
                            return RoleMenuSheet$lambda$0$0$0$0;
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str);
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                boolean z4 = z2;
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                Composer $composer$iv$iv$iv3 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str2);
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer$iv.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv);
                String str3 = str;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1580426868, "C51@1891L9,52@1944L6,49@1808L167:RoleMenuSheet.kt#lq7tq6");
                TextKt.Text-Nvy7gAk(menu.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT15(), $composer$iv, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer$iv, 6, 2);
                function12 = function1;
                $this$forEach$iv = $this$forEach$iv2;
                $i$f$forEach = $i$f$forEach2;
                measurePolicy$iv$iv2 = measurePolicy$iv$iv3;
                z2 = z4;
                $composer$iv = $composer$iv$iv$iv3;
                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                z = z3;
                materialized$iv$iv = materialized$iv$iv2;
                str = str3;
                str2 = str2;
            }
            String str4 = str;
            Composer $composer$iv$iv$iv4 = $composer$iv$iv$iv;
            Composer $composer$iv2 = $composer$iv;
            MeasurePolicy measurePolicy$iv$iv4 = measurePolicy$iv$iv2;
            String str5 = str2;
            $composer$iv.endReplaceGroup();
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl(8), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getBg3_float-0d7_KjU(), $composer$iv, 48, 1);
            ReporterKt.reportMenuItemExpose(role, null);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(56)), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv, 417466778, "CC(remember):RoleMenuSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(role) | (($dirty2 & 7168) == 2048);
            Object it$iv2 = $composer$iv.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                measurePolicy$iv$iv = measurePolicy$iv$iv4;
                Object value$iv2 = new Function0() { // from class: kntr.app.game.gamebind.ui.sheet.RoleMenuSheetKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit RoleMenuSheet$lambda$0$1$0;
                        RoleMenuSheet$lambda$0$1$0 = RoleMenuSheetKt.RoleMenuSheet$lambda$0$1$0(RoleItem.this, function0);
                        return RoleMenuSheet$lambda$0$1$0;
                    }
                };
                $composer$iv.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                measurePolicy$iv$iv = measurePolicy$iv$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str4);
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str5);
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer$iv.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -782965542, "C74@2632L39,75@2707L9,76@2756L6,73@2603L180:RoleMenuSheet.kt#lq7tq6");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer$iv, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT16(), $composer$iv, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.gamebind.ui.sheet.RoleMenuSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RoleMenuSheet$lambda$1;
                    RoleMenuSheet$lambda$1 = RoleMenuSheetKt.RoleMenuSheet$lambda$1(RoleItem.this, list, function1, function0, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RoleMenuSheet$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleMenuSheet$lambda$0$0$0$0(RoleItem $role, RoleMenuItem $menu, Function1 $onMenuClick) {
        ReporterKt.reportMenuItemClick($role, $menu);
        $onMenuClick.invoke($menu);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleMenuSheet$lambda$0$1$0(RoleItem $role, Function0 $onCancelClick) {
        ReporterKt.reportMenuItemClick($role, null);
        $onCancelClick.invoke();
        return Unit.INSTANCE;
    }
}