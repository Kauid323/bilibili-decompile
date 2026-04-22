package kntr.app.game.gamebind.ui.sheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
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
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.game.base.ui.font.GameFontWeight_androidKt;
import kntr.app.game.base.ui.widget.BiligameRadioButtonKt;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.bean.RoleMenuItem;
import kntr.app.game.gamebind.bean.SectionItem;
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
import srcs.app.game.game.bind.ui.generated.resources.Res;
import srcs.app.game.game.bind.ui.generated.resources.String0_commonMainKt;

/* compiled from: RoleSwitchSheet.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002"}, d2 = {"RoleSwitchSheet", RoomRecommendViewModel.EMPTY_CURSOR, "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "menuItem", "Lkntr/app/game/gamebind/bean/RoleMenuItem;", "onConfirmClick", "Lkotlin/Function1;", "Lkntr/app/game/gamebind/bean/SectionItem;", "onCancelClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/game/gamebind/bean/RoleItem;Lkntr/app/game/gamebind/bean/RoleMenuItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "game-bind-ui_debug", "selectedServer"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RoleSwitchSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSwitchSheet$lambda$4(RoleItem roleItem, RoleMenuItem roleMenuItem, Function1 function1, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RoleSwitchSheet(roleItem, roleMenuItem, function1, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0b9e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0baa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0bb0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0cf6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0cf8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0d00  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0d03  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0deb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0df7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0dfd  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0efb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RoleSwitchSheet(final RoleItem role, final RoleMenuItem menuItem, final Function1<? super SectionItem, Unit> function1, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        int $dirty;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        String str;
        String str2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Object value$iv;
        Function0 factory$iv$iv$iv6;
        boolean invalid$iv;
        Object it$iv;
        Composer $composer4;
        Composer $composer5;
        Composer $composer$iv$iv$iv;
        String str3;
        int $dirty2;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv7;
        Object obj;
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        Intrinsics.checkNotNullParameter(function0, "onCancelClick");
        Composer $composer6 = $composer.startRestartGroup(2138722883);
        ComposerKt.sourceInformation($composer6, "C(RoleSwitchSheet)N(role,menuItem,onConfirmClick,onCancelClick,modifier)58@2378L80,61@2519L6,61@2463L4772:RoleSwitchSheet.kt#lq7tq6");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer6.changedInstance(role) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer6.changedInstance(menuItem) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer6.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer6.changedInstance(function0) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer6.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty4 = $dirty3;
        if ($composer6.shouldExecute(($dirty4 & 9363) != 9362, $dirty4 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2138722883, $dirty4, -1, "kntr.app.game.gamebind.ui.sheet.RoleSwitchSheet (RoleSwitchSheet.kt:57)");
            }
            ComposerKt.sourceInformationMarkerStart($composer6, -1976637485, "CC(remember):RoleSwitchSheet.kt#9igjgp");
            Object it$iv2 = $composer6.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                List<SectionItem> roleList = menuItem.getRoleList();
                Intrinsics.checkNotNull(roleList);
                Iterator<T> it = roleList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    if (((SectionItem) next).getPrimary()) {
                        obj = next;
                        break;
                    }
                }
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(obj, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer6.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState selectedServer$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(modifier4, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            String str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer6.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            Composer $composer7 = $composer6;
            ComposerKt.sourceInformationMarkerStart($composer7, 779708431, "C62@2562L750,80@3413L6,80@3321L112,126@5470L1759:RoleSwitchSheet.kt#lq7tq6");
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer7, modifier$iv2);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
                $composer7.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope $this$RoleSwitchSheet_u24lambda_u243_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer7, -1192226172, "C64@2659L48,65@2743L9,67@2835L6,63@2630L293,76@3169L6,70@2936L366:RoleSwitchSheet.kt#lq7tq6");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_switch_roles(Res.string.INSTANCE), $composer7, 0), $this$RoleSwitchSheet_u24lambda_u243_u240.align(Modifier.Companion, Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer7, BiliTheme.$stable).getT16(), $composer7, 0, 0, 131000);
            BoxKt.Box($this$RoleSwitchSheet_u24lambda_u243_u240.align(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(30), Dp.constructor-impl(3)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getBa0_s-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Alignment.Companion.getTopCenter()), $composer7, 0);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer7, 54, 0);
            Iterable roleList2 = menuItem.getRoleList();
            if (roleList2 == null) {
                $composer7.startReplaceGroup(780517560);
                $composer7.endReplaceGroup();
                $composer3 = $composer7;
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            } else {
                $composer7.startReplaceGroup(780517561);
                ComposerKt.sourceInformation($composer7, "*82@3483L1968");
                Iterable $this$forEach$iv = roleList2;
                boolean z = false;
                Iterator it2 = $this$forEach$iv.iterator();
                while (it2.hasNext()) {
                    Object element$iv = it2.next();
                    final SectionItem it3 = (SectionItem) element$iv;
                    Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(64)), 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(20), 0.0f, 10, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Composer $composer$iv2 = $composer7;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    boolean z2 = z;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv3 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str4);
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                    Iterator it4 = it2;
                    CompositionLocalMap localMap$iv$iv3 = $composer$iv2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv3);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str5);
                    if (!($composer$iv2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv2.startReusableNode();
                    if ($composer$iv2.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv10;
                        $composer$iv2.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv10;
                        $composer$iv2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv2);
                    Composer $composer8 = $composer7;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i8 = ((390 >> 6) & 112) | 6;
                    RowScope $this$RoleSwitchSheet_u24lambda_u243_u241_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 76453645, "C86@3686L786,120@5351L67,118@5246L191:RoleSwitchSheet.kt#lq7tq6");
                    Modifier modifier$iv4 = RowScope.-CC.weight$default($this$RoleSwitchSheet_u24lambda_u243_u241_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer$iv2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                    int $changed$iv$iv4 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str4);
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer$iv2.getCurrentCompositionLocalMap();
                    String str6 = str4;
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv4);
                    Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str5);
                    if (!($composer$iv2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv2.startReusableNode();
                    if ($composer$iv2.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer$iv2.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer$iv2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv2);
                    String str7 = str5;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i10 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 15991397, "C89@3897L9,90@3954L6,87@3805L280,96@4201L9,97@4258L6,94@4106L348:RoleSwitchSheet.kt#lq7tq6");
                    TextKt.Text-Nvy7gAk(it3.getRoleName(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT16(), $composer$iv2, 0, 24960, 110586);
                    TextKt.Text-Nvy7gAk(it3.getSectionName(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT12(), $composer$iv2, 48, 24960, 110584);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    if (it3.getPrimary()) {
                        $composer$iv2.startReplaceGroup(77254839);
                        ComposerKt.sourceInformation($composer$iv2, "105@4564L48,106@4656L9,107@4713L6,114@5074L6,104@4527L684");
                        TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_role_showing(Res.string.INSTANCE), $composer$iv2, 0), PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getPi5-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(3), Dp.constructor-impl(1)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getPi5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT11(), $composer$iv2, 0, 24960, 109560);
                    } else {
                        $composer$iv2.startReplaceGroup(72741859);
                    }
                    $composer$iv2.endReplaceGroup();
                    boolean z3 = RoleSwitchSheet$lambda$1(selectedServer$delegate) == it3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -551671486, "CC(remember):RoleSwitchSheet.kt#9igjgp");
                    boolean invalid$iv2 = $composer$iv2.changedInstance(it3);
                    Object it$iv3 = $composer$iv2.rememberedValue();
                    if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.app.game.gamebind.ui.sheet.RoleSwitchSheetKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit RoleSwitchSheet$lambda$3$1$0$1$0;
                                RoleSwitchSheet$lambda$3$1$0$1$0 = RoleSwitchSheetKt.RoleSwitchSheet$lambda$3$1$0$1$0(SectionItem.this, selectedServer$delegate);
                                return RoleSwitchSheet$lambda$3$1$0$1$0;
                            }
                        };
                        $composer$iv2.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    BiligameRadioButtonKt.m1123BiligameRadioButtonxfWV6H8(z3, (Function0) it$iv3, null, 0.0f, 0.0f, false, null, null, $composer$iv2, 0, 252);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $this$forEach$iv = $this$forEach$iv2;
                    z = z2;
                    it2 = it4;
                    $composer7 = $composer8;
                    str4 = str6;
                    str5 = str7;
                }
                $composer3 = $composer7;
                str = str5;
                str2 = str4;
                $composer3.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            }
            Modifier modifier$iv5 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(60)), 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(8));
            Composer $composer$iv3 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv5 = (6 << 3) & 112;
            String str8 = str2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str8);
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv5);
            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            String str9 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str9);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv12;
                $composer$iv3.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv12;
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i12 = ((6 >> 6) & 112) | 6;
            RowScope $this$RoleSwitchSheet_u24lambda_u243_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 625556817, "C134@5743L39,137@5904L6,137@5957L127,135@5795L557,150@6366L40,152@6438L40,155@6598L6,155@6644L315,153@6491L728:RoleSwitchSheet.kt#lq7tq6");
            final String cancelText = StringResourcesKt.stringResource(srcs.common.compose.res.generated.resources.String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer$iv3, 0);
            Modifier modifier5 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$RoleSwitchSheet_u24lambda_u243_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(44));
            float f = Dp.constructor-impl(1);
            BiliTheme biliTheme = BiliTheme.INSTANCE;
            int $changed$iv = BiliTheme.$stable;
            Modifier modifier6 = BorderKt.border-xT4_qwU(modifier5, f, biliTheme.getColors($composer$iv3, $changed$iv).getLine_light-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2098395260, "CC(remember):RoleSwitchSheet.kt#9igjgp");
            $composer2 = $composer6;
            boolean invalid$iv3 = $composer2.changedInstance(role) | $composer2.changed(cancelText) | (($dirty4 & 7168) == 2048);
            Object it$iv4 = $composer$iv3.rememberedValue();
            if (!invalid$iv3 && it$iv4 != Composer.Companion.getEmpty()) {
                value$iv = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                Modifier modifier$iv6 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv6 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str8);
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv6);
                Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str9);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    factory$iv$iv$iv6 = factory$iv$iv$iv13;
                    $composer$iv3.useNode();
                } else {
                    factory$iv$iv$iv6 = factory$iv$iv$iv13;
                    $composer$iv3.createNode(factory$iv$iv$iv6);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i13 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i14 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1756072583, "C145@6254L9,146@6307L6,143@6171L167:RoleSwitchSheet.kt#lq7tq6");
                TextKt.Text-Nvy7gAk(cancelText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT16(), $composer$iv3, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv3, 6);
                final String confirmText = StringResourcesKt.stringResource(srcs.common.compose.res.generated.resources.String0_commonMainKt.getConfirm(CommonRes.INSTANCE.getString()), $composer$iv3, 0);
                Modifier modifier7 = BackgroundKt.background-bw27NRU(RowScope.-CC.weight$default($this$RoleSwitchSheet_u24lambda_u243_u242, SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getPi5-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 2098417432, "CC(remember):RoleSwitchSheet.kt#9igjgp");
                invalid$iv = $composer2.changedInstance(role) | $composer2.changed(confirmText) | (($dirty4 & 896) != 256) | (($dirty4 & 7168) != 2048);
                it$iv = $composer$iv3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    $composer4 = $composer$iv3;
                    Composer composer = $composer3;
                    $composer5 = $composer$iv3;
                    $composer$iv$iv$iv = composer;
                    $dirty = $dirty4;
                    str3 = str8;
                    $dirty2 = 1042775818;
                    Object value$iv4 = new Function0() { // from class: kntr.app.game.gamebind.ui.sheet.RoleSwitchSheetKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit RoleSwitchSheet$lambda$3$2$2$0;
                            RoleSwitchSheet$lambda$3$2$2$0 = RoleSwitchSheetKt.RoleSwitchSheet$lambda$3$2$2$0(RoleItem.this, confirmText, function1, function0, selectedServer$delegate);
                            return RoleSwitchSheet$lambda$3$2$2$0;
                        }
                    };
                    $composer$iv3.updateRememberedValue(value$iv4);
                    it$iv = value$iv4;
                } else {
                    $composer4 = $composer$iv3;
                    $dirty = $dirty4;
                    str3 = str8;
                    $dirty2 = 1042775818;
                    Composer composer2 = $composer3;
                    $composer5 = $composer$iv3;
                    $composer$iv$iv$iv = composer2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv7 = ClickableKt.clickable-oSLSa3U$default(modifier7, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                $composer$iv = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer$iv, $dirty2, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv7 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str3);
                int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                CompositionLocalMap localMap$iv$iv7 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv7);
                Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str9);
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    factory$iv$iv$iv7 = factory$iv$iv$iv14;
                    $composer$iv.useNode();
                } else {
                    factory$iv$iv$iv7 = factory$iv$iv$iv14;
                    $composer$iv.createNode(factory$iv$iv$iv7);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer$iv);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                int i15 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i16 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 289483754, "C167@7130L9,165@7046L159:RoleSwitchSheet.kt#lq7tq6");
                TextKt.Text-Nvy7gAk(confirmText, (Modifier) null, BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT16(), $composer$iv, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object obj2 = new Function0() { // from class: kntr.app.game.gamebind.ui.sheet.RoleSwitchSheetKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit RoleSwitchSheet$lambda$3$2$0$0;
                    RoleSwitchSheet$lambda$3$2$0$0 = RoleSwitchSheetKt.RoleSwitchSheet$lambda$3$2$0$0(RoleItem.this, cancelText, function0);
                    return RoleSwitchSheet$lambda$3$2$0$0;
                }
            };
            $composer$iv3.updateRememberedValue(obj2);
            value$iv = obj2;
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            Modifier modifier$iv62 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
            Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv62 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
            int $changed$iv$iv62 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str8);
            int compositeKeyHash$iv$iv62 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv62 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv62);
            Function0 factory$iv$iv$iv132 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv62 = (($changed$iv$iv62 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str9);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv62), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
            int i132 = ($changed$iv$iv$iv62 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i142 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1756072583, "C145@6254L9,146@6307L6,143@6171L167:RoleSwitchSheet.kt#lq7tq6");
            TextKt.Text-Nvy7gAk(cancelText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT16(), $composer$iv3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv3, 6);
            final String confirmText2 = StringResourcesKt.stringResource(srcs.common.compose.res.generated.resources.String0_commonMainKt.getConfirm(CommonRes.INSTANCE.getString()), $composer$iv3, 0);
            Modifier modifier72 = BackgroundKt.background-bw27NRU(RowScope.-CC.weight$default($this$RoleSwitchSheet_u24lambda_u243_u242, SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getPi5-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 2098417432, "CC(remember):RoleSwitchSheet.kt#9igjgp");
            invalid$iv = $composer2.changedInstance(role) | $composer2.changed(confirmText2) | (($dirty4 & 896) != 256) | (($dirty4 & 7168) != 2048);
            it$iv = $composer$iv3.rememberedValue();
            if (invalid$iv) {
            }
            $composer4 = $composer$iv3;
            Composer composer3 = $composer3;
            $composer5 = $composer$iv3;
            $composer$iv$iv$iv = composer3;
            $dirty = $dirty4;
            str3 = str8;
            $dirty2 = 1042775818;
            Object value$iv42 = new Function0() { // from class: kntr.app.game.gamebind.ui.sheet.RoleSwitchSheetKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit RoleSwitchSheet$lambda$3$2$2$0;
                    RoleSwitchSheet$lambda$3$2$2$0 = RoleSwitchSheetKt.RoleSwitchSheet$lambda$3$2$2$0(RoleItem.this, confirmText2, function1, function0, selectedServer$delegate);
                    return RoleSwitchSheet$lambda$3$2$2$0;
                }
            };
            $composer$iv3.updateRememberedValue(value$iv42);
            it$iv = value$iv42;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv72 = ClickableKt.clickable-oSLSa3U$default(modifier72, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment contentAlignment$iv32 = Alignment.Companion.getCenter();
            $composer$iv = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv, $dirty2, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv72 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
            int $changed$iv$iv72 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str3);
            int compositeKeyHash$iv$iv72 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv72 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv72 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv72);
            Function0 factory$iv$iv$iv142 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv72 = (($changed$iv$iv72 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str9);
            if (!($composer$iv.getApplier() instanceof Applier)) {
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv72 = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, measurePolicy$iv72, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, localMap$iv$iv72, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv72, Integer.valueOf(compositeKeyHash$iv$iv72), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv72, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, materialized$iv$iv72, ComposeUiNode.Companion.getSetModifier());
            int i152 = ($changed$iv$iv$iv72 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
            int i162 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 289483754, "C167@7130L9,165@7046L159:RoleSwitchSheet.kt#lq7tq6");
            TextKt.Text-Nvy7gAk(confirmText2, (Modifier) null, BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT16(), $composer$iv, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer6;
            $dirty = $dirty4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.gamebind.ui.sheet.RoleSwitchSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj3, Object obj4) {
                    Unit RoleSwitchSheet$lambda$4;
                    RoleSwitchSheet$lambda$4 = RoleSwitchSheetKt.RoleSwitchSheet$lambda$4(RoleItem.this, menuItem, function1, function0, modifier8, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                    return RoleSwitchSheet$lambda$4;
                }
            });
        }
    }

    private static final SectionItem RoleSwitchSheet$lambda$1(MutableState<SectionItem> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (SectionItem) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSwitchSheet$lambda$3$1$0$1$0(SectionItem $it, MutableState $selectedServer$delegate) {
        $selectedServer$delegate.setValue($it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSwitchSheet$lambda$3$2$0$0(RoleItem $role, String $cancelText, Function0 $onCancelClick) {
        ReporterKt.reportSwitchRoleClick($role, $cancelText);
        $onCancelClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleSwitchSheet$lambda$3$2$2$0(RoleItem $role, String $confirmText, Function1 $onConfirmClick, Function0 $onCancelClick, MutableState $selectedServer$delegate) {
        ReporterKt.reportSwitchRoleClick($role, $confirmText);
        SectionItem RoleSwitchSheet$lambda$1 = RoleSwitchSheet$lambda$1($selectedServer$delegate);
        boolean z = false;
        if (RoleSwitchSheet$lambda$1 != null && RoleSwitchSheet$lambda$1.getPrimary()) {
            z = true;
        }
        if (!z) {
            SectionItem RoleSwitchSheet$lambda$12 = RoleSwitchSheet$lambda$1($selectedServer$delegate);
            Intrinsics.checkNotNull(RoleSwitchSheet$lambda$12);
            $onConfirmClick.invoke(RoleSwitchSheet$lambda$12);
        } else {
            $onCancelClick.invoke();
        }
        return Unit.INSTANCE;
    }
}