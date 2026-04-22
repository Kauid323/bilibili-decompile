package kntr.app.im.chat.ui.widget;

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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import bili.resource.common.CommonRes;
import bili.resource.im.ImRes;
import bili.resource.im.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.dialog.DialogContent_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: DeleteMessageConfirmDialog.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"DeleteMessageConfirmDialog", RoomRecommendViewModel.EMPTY_CURSOR, "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeleteMessageConfirmDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteMessageConfirmDialog$lambda$2(EntityMessage entityMessage, ChatActionHandler chatActionHandler, int i, Composer composer, int i2) {
        DeleteMessageConfirmDialog(entityMessage, chatActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DeleteMessageConfirmDialog(final EntityMessage message, final ChatActionHandler actionHandler, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer2 = $composer.startRestartGroup(-1330193912);
        ComposerKt.sourceInformation($composer2, "C(DeleteMessageConfirmDialog)N(message,actionHandler)22@792L24,23@847L105,28@992L560,28@957L595:DeleteMessageConfirmDialog.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(message) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(actionHandler) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1330193912, $dirty2, -1, "kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialog (DeleteMessageConfirmDialog.kt:21)");
            }
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1583910417, "CC(remember):DeleteMessageConfirmDialog.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit DeleteMessageConfirmDialog$lambda$0$0;
                        DeleteMessageConfirmDialog$lambda$0$0 = DeleteMessageConfirmDialogKt.DeleteMessageConfirmDialog$lambda$0$0(scope, actionHandler);
                        return DeleteMessageConfirmDialog$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 dismiss = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidDialog_androidKt.Dialog(dismiss, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(747760031, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeleteMessageConfirmDialog$lambda$1;
                    DeleteMessageConfirmDialog$lambda$1 = DeleteMessageConfirmDialogKt.DeleteMessageConfirmDialog$lambda$1(dismiss, scope, actionHandler, message, (Composer) obj, ((Integer) obj2).intValue());
                    return DeleteMessageConfirmDialog$lambda$1;
                }
            }, $composer2, 54), $composer2, 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeleteMessageConfirmDialog$lambda$2;
                    DeleteMessageConfirmDialog$lambda$2 = DeleteMessageConfirmDialogKt.DeleteMessageConfirmDialog$lambda$2(EntityMessage.this, actionHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DeleteMessageConfirmDialog$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteMessageConfirmDialog$lambda$0$0(CoroutineScope $scope, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new DeleteMessageConfirmDialogKt$DeleteMessageConfirmDialog$dismiss$1$1$1($actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteMessageConfirmDialog$lambda$1(final Function0 $dismiss, final CoroutineScope $scope, final ChatActionHandler $actionHandler, final EntityMessage $message, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C30@1043L48,32@1154L49,33@1234L57,29@1002L544:DeleteMessageConfirmDialog.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747760031, $changed, -1, "kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialog.<anonymous> (DeleteMessageConfirmDialog.kt:29)");
            }
            final String titleString$iv = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_54(ImRes.INSTANCE.getString()), $composer, 0);
            final String negativeString$iv = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_414(ImRes.INSTANCE.getString()), $composer, 0);
            final String positiveString$iv = StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_194(CommonRes.INSTANCE.getString()), $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -1894279827, "CC(DialogContent)N(titleString,contentString,onNegativeClick,onPositiveClick,modifier,negativeString,positiveString)150@4902L39,151@4973L40,154@5059L1495,194@6591L873,153@5023L2441:DialogContent.kt#j1m0ki");
            Modifier modifier$iv = Modifier.Companion;
            DialogContent_androidKt.DialogContent(ComposableLambdaKt.rememberComposableLambda(93781831, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt$DeleteMessageConfirmDialog$lambda$1$$inlined$DialogContent$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    Composer $composer$iv$iv;
                    String str;
                    String str2;
                    String str3;
                    Composer $composer$iv;
                    Function0 factory$iv$iv$iv2;
                    Function0 factory$iv$iv$iv3;
                    ComposerKt.sourceInformation($composer2, "C155@5073L1471:DialogContent.kt#j1m0ki");
                    if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(93781831, $changed2, -1, "kntr.common.dialog.DialogContent.<anonymous> (DialogContent.kt:155)");
                    }
                    Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
                    String str4 = negativeString$iv;
                    String str5 = positiveString$iv;
                    final Function0 function0 = $dismiss;
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    int $changed$iv$iv = (438 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer2.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
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
                    int i2 = ((438 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, 145669907, "C:DialogContent.kt#j1m0ki");
                    if (str4 == null) {
                        $composer$iv$iv = $composer2;
                        str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str3 = str5;
                        $composer$iv = $composer2;
                        $composer2.startReplaceGroup(140364535);
                    } else {
                        $composer2.startReplaceGroup(145677532);
                        ComposerKt.sourceInformation($composer2, "161@5359L531");
                        Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt$DeleteMessageConfirmDialog$lambda$1$$inlined$DialogContent$1.1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1949invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1949invoke() {
                                function0.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer2.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i4 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1099396812, "C170@5768L6,171@5828L9,168@5665L203:DialogContent.kt#j1m0ki");
                        long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
                        $composer$iv$iv = $composer2;
                        BiliTheme biliTheme = BiliTheme.INSTANCE;
                        int $changed$iv$iv$iv3 = BiliTheme.$stable;
                        TextStyle t16 = biliTheme.getTextStyle($composer2, $changed$iv$iv$iv3).getT16();
                        $composer$iv = $composer2;
                        str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str3 = str5;
                        str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        TextKt.Text-Nvy7gAk(str4, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16, $composer2, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    }
                    $composer2.endReplaceGroup();
                    if (str3 != null) {
                        $composer2.startReplaceGroup(146289751);
                        ComposerKt.sourceInformation($composer2, "177@5976L536");
                        Modifier weight$default = RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
                        final CoroutineScope coroutineScope = $scope;
                        final Function0 function02 = $dismiss;
                        final ChatActionHandler chatActionHandler = $actionHandler;
                        final EntityMessage entityMessage = $message;
                        Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(weight$default, false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt$DeleteMessageConfirmDialog$lambda$1$$inlined$DialogContent$1.2
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1950invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m1950invoke() {
                                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DeleteMessageConfirmDialogKt$DeleteMessageConfirmDialog$1$1$1(chatActionHandler, entityMessage, null), 3, (Object) null);
                                function02.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, str2);
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, str);
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv6;
                            $composer2.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv6;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i5 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i6 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1196457072, "C186@6385L6,187@6450L9,184@6282L208:DialogContent.kt#j1m0ki");
                        TextKt.Text-Nvy7gAk(str3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    } else {
                        $composer2.startReplaceGroup(140364535);
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), modifier$iv, ComposableLambdaKt.rememberComposableLambda(1990761289, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.widget.DeleteMessageConfirmDialogKt$DeleteMessageConfirmDialog$lambda$1$$inlined$DialogContent$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    Composer $composer3;
                    ComposerKt.sourceInformation($composer2, "C195@6601L857:DialogContent.kt#j1m0ki");
                    if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1990761289, $changed2, -1, "kntr.common.dialog.DialogContent.<anonymous> (DialogContent.kt:195)");
                    }
                    Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(20), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(18), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                    String str = titleString$iv;
                    String str2 = r2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                    int $changed$iv$iv = (438 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        $composer2.createNode(factory$iv$iv$iv);
                    } else {
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i2 = ((438 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -81923373, "C206@7027L6,207@7075L9,204@6951L199:DialogContent.kt#j1m0ki");
                    TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16b(), $composer2, 0, 0, 130042);
                    if (StringsKt.isBlank(str2)) {
                        $composer3 = $composer2;
                        $composer3.startReplaceGroup(-88835165);
                    } else {
                        $composer2.startReplaceGroup(-81671065);
                        ComposerKt.sourceInformation($composer2, "214@7300L6,215@7352L9,212@7214L220");
                        $composer3 = $composer2;
                        TextKt.Text-Nvy7gAk(str2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer3, 0, 0, 130042);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), $composer, ((48 >> 9) & 112) | 390, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}