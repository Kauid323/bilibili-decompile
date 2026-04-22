package kntr.app.im.chat.ui.module.notifyTitle;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import com.bapis.bilibili.app.im.v1.KNotifyCosmoThreeDotItem;
import com.bapis.bilibili.app.im.v1.KNotifyDetailAddition;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.NotifyTitleMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.module.notifyDetail.ChatMsgNotifyDetailModuleBuilderKt;
import kntr.app.im.chat.ui.utils.ChatPageController;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ChatMsgNotifyTitleModuleBuilder.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"NotifyTitleModule", RoomRecommendViewModel.EMPTY_CURSOR, "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "module", "Lkntr/app/im/chat/module/NotifyTitleMsgModule;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "pageController", "Lkntr/app/im/chat/ui/utils/ChatPageController;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/module/NotifyTitleMsgModule;Lkntr/app/im/chat/ui/ChatActionHandler;Lkntr/app/im/chat/ui/utils/ChatPageController;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NotifyTitleModuleMenu", "Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;", "(Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/module/NotifyTitleMsgModule;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgNotifyTitleModuleBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyTitleModule$lambda$1(EntityMessage entityMessage, NotifyTitleMsgModule notifyTitleMsgModule, ChatActionHandler chatActionHandler, ChatPageController chatPageController, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NotifyTitleModule(entityMessage, notifyTitleMsgModule, chatActionHandler, chatPageController, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyTitleModuleMenu$lambda$1(BottomSheetScope bottomSheetScope, EntityMessage entityMessage, NotifyTitleMsgModule notifyTitleMsgModule, ChatActionHandler chatActionHandler, int i, Composer composer, int i2) {
        NotifyTitleModuleMenu(bottomSheetScope, entityMessage, notifyTitleMsgModule, chatActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0408, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NotifyTitleModule(final EntityMessage message, final NotifyTitleMsgModule module, final ChatActionHandler actionHandler, final ChatPageController pageController, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(pageController, "pageController");
        Composer $composer3 = $composer.startRestartGroup(1713551865);
        ComposerKt.sourceInformation($composer3, "C(NotifyTitleModule)N(message,module,actionHandler,pageController,modifier)63@2564L2339:ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(message) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(module) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(actionHandler) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(pageController) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1713551865, $dirty2, -1, "kntr.app.im.chat.ui.module.notifyTitle.NotifyTitleModule (ChatMsgNotifyTitleModuleBuilder.kt:62)");
            }
            int $changed$iv = ($dirty2 >> 12) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 131514249, "C64@2602L1592,106@4204L693:ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
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
            int i6 = ((6 >> 6) & 112) | 6;
            RowScope $this$NotifyTitleModule_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -159418537, "C73@2948L6,74@2996L9,67@2699L404:ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
            TextKt.Text-Nvy7gAk(module.getValue().getTitle(), PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$NotifyTitleModule_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(4), Dp.constructor-impl(6), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getH2(), $composer3, 0, 24960, 110584);
            if (module.getValue().getThreeDotItem() != null) {
                $composer3.startReplaceGroup(-158958219);
                ComposerKt.sourceInformation($composer3, "86@3394L414,81@3196L974");
                Modifier modifier5 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(7), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(32));
                ComposerKt.sourceInformationMarkerStart($composer3, 1657446621, "CC(remember):ChatMsgNotifyTitleModuleBuilder.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 7168) == 2048) | (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32) | (($dirty2 & 896) == 256);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.module.notifyTitle.ChatMsgNotifyTitleModuleBuilderKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit NotifyTitleModule$lambda$0$0$0$0;
                        NotifyTitleModule$lambda$0$0$0$0 = ChatMsgNotifyTitleModuleBuilderKt.NotifyTitleModule$lambda$0$0$0$0(ChatPageController.this, message, module, actionHandler);
                        return NotifyTitleModule$lambda$0$0$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i8 = ((0 >> 6) & 112) | 6;
                BoxScope $this$NotifyTitleModule_u24lambda_u240_u240_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 1667022391, "C97@3903L21,100@4099L6,96@3850L302:ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMore_vertical_fill_16($composer3, 6), (String) null, $this$NotifyTitleModule_u24lambda_u240_u240_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer3.startReplaceGroup(-162142973);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str);
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv7);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i10 = ((6 >> 6) & 112) | 6;
            RowScope $this$NotifyTitleModule_u24lambda_u240_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1667989786, "C:ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
            if (module.getValue().getContent().length() > 0) {
                $composer3.startReplaceGroup(-1667956617);
                ComposerKt.sourceInformation($composer3, "115@4650L6,116@4702L9,108@4315L419");
                TextKt.Text-Nvy7gAk(module.getValue().getContent(), PaddingKt.padding-qDBjuR0($this$NotifyTitleModule_u24lambda_u240_u241.weight(Modifier.Companion, 1.0f, true), Dp.constructor-impl(12), Dp.constructor-impl(4), Dp.constructor-impl(12), Dp.constructor-impl(8)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 131064);
            } else {
                $composer3.startReplaceGroup(-1672234214);
            }
            $composer3.endReplaceGroup();
            KNotifyDetailAddition it = module.getValue().getAddition();
            if (it == null) {
                $composer3.startReplaceGroup(-1667484302);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1667484301);
                ComposerKt.sourceInformation($composer3, "*120@4806L67");
                ChatMsgNotifyDetailModuleBuilderKt.NotifyAdditionCover(it, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null), $composer3, 48, 0);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
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
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.notifyTitle.ChatMsgNotifyTitleModuleBuilderKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotifyTitleModule$lambda$1;
                    NotifyTitleModule$lambda$1 = ChatMsgNotifyTitleModuleBuilderKt.NotifyTitleModule$lambda$1(EntityMessage.this, module, actionHandler, pageController, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NotifyTitleModule$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyTitleModule$lambda$0$0$0$0(ChatPageController $pageController, final EntityMessage $message, final NotifyTitleMsgModule $module, final ChatActionHandler $actionHandler) {
        $pageController.showBottomSheet((Function3) ComposableLambdaKt.composableLambdaInstance(-228726922, true, new Function3() { // from class: kntr.app.im.chat.ui.module.notifyTitle.ChatMsgNotifyTitleModuleBuilderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit NotifyTitleModule$lambda$0$0$0$0$0;
                NotifyTitleModule$lambda$0$0$0$0$0 = ChatMsgNotifyTitleModuleBuilderKt.NotifyTitleModule$lambda$0$0$0$0$0(EntityMessage.this, $module, $actionHandler, (BottomSheetScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return NotifyTitleModule$lambda$0$0$0$0$0;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyTitleModule$lambda$0$0$0$0$0(EntityMessage $message, NotifyTitleMsgModule $module, ChatActionHandler $actionHandler, BottomSheetScope $this$showBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$showBottomSheet, "$this$showBottomSheet");
        ComposerKt.sourceInformation($composer, "C88@3497L247:ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$showBottomSheet) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-228726922, $dirty, -1, "kntr.app.im.chat.ui.module.notifyTitle.NotifyTitleModule.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChatMsgNotifyTitleModuleBuilder.kt:88)");
            }
            NotifyTitleModuleMenu($this$showBottomSheet, $message, $module, $actionHandler, $composer, $dirty & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void NotifyTitleModuleMenu(final BottomSheetScope $this$NotifyTitleModuleMenu, final EntityMessage message, final NotifyTitleMsgModule module, final ChatActionHandler actionHandler, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-2078327144);
        ComposerKt.sourceInformation($composer2, "C(NotifyTitleModuleMenu)N(message,module,actionHandler):ChatMsgNotifyTitleModuleBuilder.kt#y545xb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$NotifyTitleModuleMenu) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(message) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(module) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(actionHandler) ? 2048 : 1024;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2078327144, $dirty, -1, "kntr.app.im.chat.ui.module.notifyTitle.NotifyTitleModuleMenu (ChatMsgNotifyTitleModuleBuilder.kt:131)");
            }
            final KNotifyCosmoThreeDotItem item = module.getValue().getThreeDotItem();
            if (item == null) {
                $composer2.startReplaceGroup(804783100);
            } else {
                $composer2.startReplaceGroup(804783101);
                ComposerKt.sourceInformation($composer2, "*133@5140L24,138@5311L207,134@5173L356");
                ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object it$iv$iv = $composer2.rememberedValue();
                if (it$iv$iv == Composer.Companion.getEmpty()) {
                    Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                    $composer2.updateRememberedValue(value$iv$iv);
                    it$iv$iv = value$iv$iv;
                }
                final CoroutineScope scope = (CoroutineScope) it$iv$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                String title = item.getTitle();
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, -1824153077, "CC(remember):ChatMsgNotifyTitleModuleBuilder.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty & 7168) == 2048) | (($dirty & 112) == 32) | $composer2.changedInstance(item) | (($dirty & 14) == 4);
                Object value$iv = $composer2.rememberedValue();
                if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    value$iv = new Function0() { // from class: kntr.app.im.chat.ui.module.notifyTitle.ChatMsgNotifyTitleModuleBuilderKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit NotifyTitleModuleMenu$lambda$0$0$0;
                            NotifyTitleModuleMenu$lambda$0$0$0 = ChatMsgNotifyTitleModuleBuilderKt.NotifyTitleModuleMenu$lambda$0$0$0(scope, actionHandler, message, item, $this$NotifyTitleModuleMenu);
                            return NotifyTitleModuleMenu$lambda$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposeBottomsheetKt.BottomSheetColumnItem(title, (Painter) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null), $composer2, 48, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.notifyTitle.ChatMsgNotifyTitleModuleBuilderKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotifyTitleModuleMenu$lambda$1;
                    NotifyTitleModuleMenu$lambda$1 = ChatMsgNotifyTitleModuleBuilderKt.NotifyTitleModuleMenu$lambda$1($this$NotifyTitleModuleMenu, message, module, actionHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return NotifyTitleModuleMenu$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyTitleModuleMenu$lambda$0$0$0(CoroutineScope $scope, ChatActionHandler $actionHandler, EntityMessage $message, KNotifyCosmoThreeDotItem $item, BottomSheetScope $this_NotifyTitleModuleMenu) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatMsgNotifyTitleModuleBuilderKt$NotifyTitleModuleMenu$1$1$1$1($actionHandler, $message, $item, $this_NotifyTitleModuleMenu, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}