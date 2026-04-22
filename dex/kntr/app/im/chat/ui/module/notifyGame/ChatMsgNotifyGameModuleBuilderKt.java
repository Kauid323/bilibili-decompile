package kntr.app.im.chat.ui.module.notifyGame;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
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
import com.bapis.bilibili.app.im.v1.KNotifyGameModule;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import im.base.AddBiliImageKt;
import kntr.app.im.chat.game.GameBindingKt;
import kntr.app.im.chat.game.GameGiftData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ChatMsgNotifyGameModuleBuilder.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"NotifyGameModule", RoomRecommendViewModel.EMPTY_CURSOR, "module", "Lcom/bapis/bilibili/app/im/v1/KNotifyGameModule;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bapis/bilibili/app/im/v1/KNotifyGameModule;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "GameGiftRow", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/bapis/bilibili/app/im/v1/KNotifyGameModule;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgNotifyGameModuleBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameGiftRow$lambda$2(ColumnScope columnScope, KNotifyGameModule kNotifyGameModule, int i, Composer composer, int i2) {
        GameGiftRow(columnScope, kNotifyGameModule, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyGameModule$lambda$1(KNotifyGameModule kNotifyGameModule, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NotifyGameModule(kNotifyGameModule, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void NotifyGameModule(KNotifyGameModule module, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final KNotifyGameModule kNotifyGameModule;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer$iv$iv$iv2;
        String str;
        Composer $composer$iv$iv$iv3;
        Composer $composer$iv;
        String str2;
        String str3;
        Composer $composer$iv2;
        Composer $composer3;
        Function0 factory$iv$iv$iv5;
        Composer $composer4;
        Function0 factory$iv$iv$iv6;
        Composer $composer$iv3;
        Composer $composer5;
        Function0 factory$iv$iv$iv7;
        Intrinsics.checkNotNullParameter(module, "module");
        Composer $composer6 = $composer.startRestartGroup(-392760984);
        ComposerKt.sourceInformation($composer6, "C(NotifyGameModule)N(module,modifier)67@2635L5125:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer6.changedInstance(module) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer6.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (!$composer6.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            kNotifyGameModule = module;
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-392760984, $dirty, -1, "kntr.app.im.chat.ui.module.notifyGame.NotifyGameModule (ChatMsgNotifyGameModuleBuilder.kt:64)");
            }
            boolean showDesc = !StringsKt.isBlank(module.getGameDescContent());
            float coverSize = showDesc ? Dp.constructor-impl(56) : Dp.constructor-impl(40);
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default(modifier3, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv$iv);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            $composer2 = $composer6;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$NotifyGameModule_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, -1629277176, "C78@3037L4621:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
            if (StringsKt.isBlank(module.getGameCover())) {
                $composer$iv$iv$iv = $composer6;
                $composer$iv$iv = $composer6;
                $composer6.startReplaceGroup(-1632114204);
            } else {
                $composer6.startReplaceGroup(-1629390048);
                ComposerKt.sourceInformation($composer6, "69@2750L268");
                $composer$iv$iv = $composer6;
                $composer$iv$iv$iv = $composer6;
                AddBiliImageKt.AddBiliImage(module.getGameCover(), ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.7777778f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), $composer6, 0, 0);
            }
            $composer6.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(8), 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            int $dirty2 = $dirty;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
                $composer6.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((438 >> 6) & 112) | 6;
            RowScope $this$NotifyGameModule_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, -565769000, "C83@3287L4207,170@7508L140:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
            Modifier modifier$iv2 = $this$NotifyGameModule_u24lambda_u240_u240.weight(Modifier.Companion, 1.0f, true);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv10;
                $composer6.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv10;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i7 = ((432 >> 6) & 112) | 6;
            RowScope $this$NotifyGameModule_u24lambda_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, 2119989314, "C88@3517L156,92@3690L3790:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
            AddBiliImageKt.AddBiliImage(module.getGameIcon(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, coverSize), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), $composer6, 0, 0);
            Modifier modifier$iv3 = $this$NotifyGameModule_u24lambda_u240_u240_u240.weight(Modifier.Companion, 1.0f, true);
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer6, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv4 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv11;
                $composer6.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv11;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, 1028840002, "C98@3969L9,99@4026L6,96@3873L305,137@5956L1506:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
            TextKt.Text-Nvy7gAk(module.getGameName(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, showDesc ? 1 : 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT14(), $composer6, 0, 384, 110586);
            if (showDesc) {
                $composer6.startReplaceGroup(1029120365);
                ComposerKt.sourceInformation($composer6, "105@4240L1673");
                Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer6, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv5 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer6, modifier$iv4);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                $composer$iv2 = $composer6;
                $composer$iv$iv$iv3 = $composer6;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv6 = factory$iv$iv$iv12;
                    $composer6.createNode(factory$iv$iv$iv6);
                } else {
                    factory$iv$iv$iv6 = factory$iv$iv$iv12;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer6);
                $composer$iv$iv$iv2 = $composer6;
                $composer$iv = $composer6;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i10 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i11 = ((54 >> 6) & 112) | 6;
                RowScope $this$NotifyGameModule_u24lambda_u240_u240_u240_u240_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer6, 517150886, "C130@5667L9,131@5732L6,127@5471L416:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
                if (!StringsKt.isBlank(module.getScore())) {
                    $composer6.startReplaceGroup(517166881);
                    ComposerKt.sourceInformation($composer6, "110@4510L902");
                    Modifier modifier$iv5 = Modifier.Companion;
                    Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
                    Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer6, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    int $changed$iv$iv6 = (438 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer6.getCurrentCompositionLocalMap();
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer6, modifier$iv5);
                    Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                    $composer5 = $composer6;
                    ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer6.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer6.startReusableNode();
                    if ($composer6.getInserting()) {
                        factory$iv$iv$iv7 = factory$iv$iv$iv13;
                        $composer6.createNode(factory$iv$iv$iv7);
                    } else {
                        factory$iv$iv$iv7 = factory$iv$iv$iv13;
                        $composer6.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer6);
                    str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv3 = $composer6;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i13 = ((438 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer6, 61233527, "C116@4875L22,118@5023L6,115@4816L267,122@5245L9,123@5318L6,120@5120L258:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getStar_favorite_fill_500($composer6, 6), (String) null, (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getOperate_orange-0d7_KjU(), $composer6, Painter.$stable | 48, 4);
                    TextKt.Text-Nvy7gAk(module.getScore(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getOperate_orange-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), $composer6, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    $composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                } else {
                    str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                    $composer$iv3 = $composer6;
                    $composer5 = $composer6;
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    $composer6.startReplaceGroup(512695751);
                }
                $composer6.endReplaceGroup();
                TextKt.Text-Nvy7gAk(module.getGameDescContent(), $this$NotifyGameModule_u24lambda_u240_u240_u240_u240_u240.weight(Modifier.Companion, 1.0f, true), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), $composer6, 0, 24960, 110584);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer5.endReplaceGroup();
                $composer3 = $composer5;
            } else {
                $composer$iv$iv$iv2 = $composer6;
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv$iv3 = $composer6;
                $composer$iv = $composer6;
                str2 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv2 = $composer6;
                $composer3 = $composer6;
                $composer3.startReplaceGroup(1024885734);
                $composer3.endReplaceGroup();
            }
            Modifier modifier$iv6 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            Alignment.Vertical verticalAlignment$iv5 = Alignment.Companion.getCenterVertically();
            Composer $composer$iv4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 844473419, str2);
            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer$iv4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv7 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str3);
            int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
            CompositionLocalMap localMap$iv$iv7 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv6);
            Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, str);
            if (!($composer$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv4.startReusableNode();
            if ($composer$iv4.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv14;
                $composer$iv4.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv14;
                $composer$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
            int i14 = ($changed$iv$iv$iv7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i15 = ((438 >> 6) & 112) | 6;
            RowScope $this$NotifyGameModule_u24lambda_u240_u240_u240_u240_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1560121252, "C:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
            if (StringsKt.isBlank(module.getGameTag())) {
                $composer$iv4.startReplaceGroup(-1566327422);
            } else {
                $composer$iv4.startReplaceGroup(-1560077853);
                ComposerKt.sourceInformation($composer$iv4, "148@6544L6,151@6770L9,152@6835L6,143@6280L607");
                String gameTag = module.getGameTag();
                BiliTheme biliTheme = BiliTheme.INSTANCE;
                int $changed$iv = BiliTheme.$stable;
                TextKt.Text-Nvy7gAk(gameTag, PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(Modifier.Companion, biliTheme.getColors($composer$iv4, $changed$iv).getOperate_orange_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getOperate_orange-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT10(), $composer$iv4, 0, 0, 131064);
            }
            $composer$iv4.endReplaceGroup();
            if (StringsKt.isBlank(module.getGameTypes())) {
                $composer$iv4.startReplaceGroup(-1566327422);
            } else {
                $composer$iv4.startReplaceGroup(-1559365752);
                ComposerKt.sourceInformation($composer$iv4, "160@7194L9,161@7259L6,157@7004L410");
                TextKt.Text-Nvy7gAk(module.getGameTypes(), $this$NotifyGameModule_u24lambda_u240_u240_u240_u240_u241.weight(Modifier.Companion, 1.0f, true), BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT12(), $composer$iv4, 0, 24960, 110584);
            }
            $composer$iv4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            GameBindingKt.IMGameButton(module.getGameId(), SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(56), Dp.constructor-impl(24)), null, $composer6, 48, 4);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (module.getGameGiftId() <= 0 || !GameBindingKt.showGiftRow()) {
                kNotifyGameModule = module;
                $composer4 = $composer6;
                $composer4.startReplaceGroup(-1632114204);
            } else {
                $composer4 = $composer6;
                $composer4.startReplaceGroup(-1624462567);
                ComposerKt.sourceInformation($composer4, "176@7725L19");
                kNotifyGameModule = module;
                GameGiftRow($this$NotifyGameModule_u24lambda_u240, kNotifyGameModule, $composer4, ($changed2 & 14) | (($dirty2 << 3) & 112));
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.notifyGame.ChatMsgNotifyGameModuleBuilderKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotifyGameModule$lambda$1;
                    NotifyGameModule$lambda$1 = ChatMsgNotifyGameModuleBuilderKt.NotifyGameModule$lambda$1(kNotifyGameModule, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NotifyGameModule$lambda$1;
                }
            });
        }
    }

    private static final void GameGiftRow(final ColumnScope $this$GameGiftRow, final KNotifyGameModule module, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1597825880);
        ComposerKt.sourceInformation($composer2, "C(GameGiftRow)N(module)183@7864L31:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(module) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 17) != 16, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1597825880, $dirty2, -1, "kntr.app.im.chat.ui.module.notifyGame.GameGiftRow (ChatMsgNotifyGameModuleBuilder.kt:182)");
            }
            final GameGiftData gameGiftData = (GameGiftData) GameBindingKt.gameGiftData(module.getGameGiftId(), $composer2, 0).getValue();
            if (gameGiftData != null) {
                $composer2.startReplaceGroup(291930166);
                ComposerKt.sourceInformation($composer2, "188@8083L6,185@7942L171,194@8242L70,190@8122L864");
                DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 2, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer2, 54, 0);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 2087636014, "CC(remember):ChatMsgNotifyGameModuleBuilder.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(gameGiftData);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.module.notifyGame.ChatMsgNotifyGameModuleBuilderKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit GameGiftRow$lambda$0$0;
                            GameGiftRow$lambda$0$0 = ChatMsgNotifyGameModuleBuilderKt.GameGiftRow$lambda$0$0(GameGiftData.this);
                            return GameGiftRow$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(3), Dp.constructor-impl(12));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i2 = ((384 >> 6) & 112) | 6;
                RowScope $this$GameGiftRow_u24lambda_u241 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, 1246515527, "C202@8579L9,203@8628L6,199@8443L292,209@8794L28,212@8949L6,208@8749L227:ChatMsgNotifyGameModuleBuilder.kt#uw7zdj");
                TextKt.Text-Nvy7gAk(gameGiftData.getText(), $this$GameGiftRow_u24lambda_u241.weight(Modifier.Companion, 1.0f, true), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 24960, 110584);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                $composer2.startReplaceGroup(284027770);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.notifyGame.ChatMsgNotifyGameModuleBuilderKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameGiftRow$lambda$2;
                    GameGiftRow$lambda$2 = ChatMsgNotifyGameModuleBuilderKt.GameGiftRow$lambda$2($this$GameGiftRow, module, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return GameGiftRow$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameGiftRow$lambda$0$0(GameGiftData $gameGiftData) {
        $gameGiftData.getOnClick().invoke();
        return Unit.INSTANCE;
    }
}