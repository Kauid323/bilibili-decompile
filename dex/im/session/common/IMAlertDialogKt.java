package im.session.common;

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
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import faceverify.q;
import io.grpc.internal.GrpcUtil;
import kntr.common.dialog.DialogContent_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMAlertDialog.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\n\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"IMAlertDialog", "", "title", "", "message", "onCancel", "Lkotlin/Function0;", "onConfirm", "cancelString", "confirmString", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", q.KEY_RES_9_CONTENT, "Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;", "(Lcom/bapis/bilibili/app/im/v1/KBehaviorAlertToast;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMAlertDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMAlertDialog$lambda$1(String str, String str2, Function0 function0, Function0 function02, String str3, String str4, int i2, int i3, Composer composer, int i4) {
        IMAlertDialog(str, str2, function0, function02, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMAlertDialog$lambda$2(KBehaviorAlertToast kBehaviorAlertToast, Function0 function0, Function0 function02, String str, String str2, int i2, int i3, Composer composer, int i4) {
        IMAlertDialog(kBehaviorAlertToast, function0, function02, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void IMAlertDialog(final String title, final String message, final Function0<Unit> function0, final Function0<Unit> function02, String cancelString, String confirmString, Composer $composer, final int $changed, final int i2) {
        String cancelString2;
        String str;
        String cancelString3;
        String confirmString2;
        int $dirty;
        String cancelString4;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(function0, "onCancel");
        Intrinsics.checkNotNullParameter(function02, "onConfirm");
        Composer $composer2 = $composer.startRestartGroup(-1289807499);
        ComposerKt.sourceInformation($composer2, "C(IMAlertDialog)N(title,message,onCancel,onConfirm,cancelString,confirmString)29@1008L278,26@887L399:IMAlertDialog.kt#yqxgzx");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(message) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function02) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            if ((i2 & 16) == 0) {
                cancelString2 = cancelString;
                if ($composer2.changed(cancelString2)) {
                    i4 = 16384;
                    $dirty2 |= i4;
                }
            } else {
                cancelString2 = cancelString;
            }
            i4 = GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE;
            $dirty2 |= i4;
        } else {
            cancelString2 = cancelString;
        }
        if ((196608 & $changed) == 0) {
            if ((i2 & 32) == 0) {
                str = confirmString;
                if ($composer2.changed(str)) {
                    i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    $dirty2 |= i3;
                }
            } else {
                str = confirmString;
            }
            i3 = WXMediaMessage.THUMB_LENGTH_LIMIT;
            $dirty2 |= i3;
        } else {
            str = confirmString;
        }
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "23@732L57,24@820L57");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i2 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                cancelString4 = cancelString2;
                confirmString2 = str;
            } else {
                if ((i2 & 16) != 0) {
                    cancelString2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_238(Res.string.INSTANCE), $composer2, 0);
                    $dirty2 &= -57345;
                }
                if ((i2 & 32) == 0) {
                    $dirty = $dirty2;
                    cancelString4 = cancelString2;
                    confirmString2 = str;
                } else {
                    $dirty = $dirty2 & (-458753);
                    cancelString4 = cancelString2;
                    confirmString2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_194(Res.string.INSTANCE), $composer2, 0);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1289807499, $dirty, -1, "im.session.common.IMAlertDialog (IMAlertDialog.kt:25)");
            }
            final String str2 = cancelString4;
            int $dirty3 = $dirty;
            final String str3 = confirmString2;
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(false, false, false, 5, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(1881652030, true, new Function2() { // from class: im.session.common.IMAlertDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMAlertDialog$lambda$0;
                    IMAlertDialog$lambda$0 = IMAlertDialogKt.IMAlertDialog$lambda$0(title, message, function0, function02, str2, str3, (Composer) obj, ((Integer) obj2).intValue());
                    return IMAlertDialog$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty3 >> 6) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cancelString3 = cancelString4;
        } else {
            $composer2.skipToGroupEnd();
            cancelString3 = cancelString2;
            confirmString2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str4 = cancelString3;
            final String str5 = confirmString2;
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMAlertDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMAlertDialog$lambda$1;
                    IMAlertDialog$lambda$1 = IMAlertDialogKt.IMAlertDialog$lambda$1(title, message, function0, function02, str4, str5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMAlertDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMAlertDialog$lambda$0(final String $title, final String $message, final Function0 $onCancel, final Function0 $onConfirm, final String $cancelString, final String $confirmString, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C30@1018L262:IMAlertDialog.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1881652030, $changed, -1, "im.session.common.IMAlertDialog.<anonymous> (IMAlertDialog.kt:30)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1894279827, "CC(DialogContent)N(titleString,contentString,onNegativeClick,onPositiveClick,modifier,negativeString,positiveString)150@4902L39,151@4973L40,154@5059L1495,194@6591L873,153@5023L2441:DialogContent.kt#j1m0ki");
            Modifier modifier$iv = Modifier.Companion;
            DialogContent_androidKt.DialogContent(ComposableLambdaKt.rememberComposableLambda(93781831, true, new Function2<Composer, Integer, Unit>() { // from class: im.session.common.IMAlertDialogKt$IMAlertDialog$lambda$0$$inlined$DialogContent$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    Composer $composer$iv$iv$iv;
                    Composer $composer$iv;
                    String str;
                    String str2;
                    String str3;
                    Function0 function0;
                    Composer $composer$iv$iv;
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
                    Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(44));
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
                    String str4 = $cancelString;
                    String str5 = $confirmString;
                    final Function0 function02 = $onCancel;
                    Function0 function03 = $onConfirm;
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                    int $changed$iv$iv = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i3 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                    RowScope $this$invoke_u24lambda_u240 = rowScope;
                    ComposerKt.sourceInformationMarkerStart($composer2, 145669907, "C:DialogContent.kt#j1m0ki");
                    if (str4 != null) {
                        $composer2.startReplaceGroup(145677532);
                        ComposerKt.sourceInformation($composer2, "161@5359L531");
                        Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f, false, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: im.session.common.IMAlertDialogKt$IMAlertDialog$lambda$0$$inlined$DialogContent$1.1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m3260invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m3260invoke() {
                                function02.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
                        $composer$iv$iv$iv = $composer2;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i5 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1099396812, "C170@5768L6,171@5828L9,168@5665L203:DialogContent.kt#j1m0ki");
                        $composer$iv = $composer2;
                        function0 = function03;
                        $composer$iv$iv = $composer2;
                        str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str3 = str5;
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        TextKt.Text-Nvy7gAk(str4, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                    } else {
                        $composer$iv$iv$iv = $composer2;
                        $composer$iv = $composer2;
                        str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str3 = str5;
                        function0 = function03;
                        $composer$iv$iv = $composer2;
                        $composer2.startReplaceGroup(140364535);
                    }
                    $composer2.endReplaceGroup();
                    if (str3 != null) {
                        $composer2.startReplaceGroup(146289751);
                        ComposerKt.sourceInformation($composer2, "177@5976L536");
                        final Function0 function04 = function0;
                        Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f, false, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: im.session.common.IMAlertDialogKt$IMAlertDialog$lambda$0$$inlined$DialogContent$1.2
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m3261invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m3261invoke() {
                                function04.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, str);
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, str2);
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $i$f$Box = $changed$iv$iv3 << 6;
                        int $changed$iv$iv$iv3 = ($i$f$Box & 896) | 6;
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
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i7 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
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
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), modifier$iv, ComposableLambdaKt.rememberComposableLambda(1990761289, true, new Function2<Composer, Integer, Unit>() { // from class: im.session.common.IMAlertDialogKt$IMAlertDialog$lambda$0$$inlined$DialogContent$2
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
                    Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(20), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(18), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(24), 5, (Object) null);
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                    String str = $title;
                    String str2 = $message;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                    int $changed$iv$iv = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i3 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
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
            }, $composer, 54), $composer, ((0 >> 9) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 390, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void IMAlertDialog(final KBehaviorAlertToast content, final Function0<Unit> function0, final Function0<Unit> function02, String cancelString, String confirmString, Composer $composer, final int $changed, final int i2) {
        String cancelString2;
        String confirmString2;
        String cancelString3;
        String confirmString3;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(function0, "onCancel");
        Intrinsics.checkNotNullParameter(function02, "onConfirm");
        Composer $composer2 = $composer.startRestartGroup(-2066708551);
        ComposerKt.sourceInformation($composer2, "C(IMAlertDialog)N(content,onCancel,onConfirm,cancelString,confirmString)49@1600L222:IMAlertDialog.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cancelString2 = cancelString;
                if ($composer2.changed(cancelString2)) {
                    i4 = 2048;
                    $dirty |= i4;
                }
            } else {
                cancelString2 = cancelString;
            }
            i4 = 1024;
            $dirty |= i4;
        } else {
            cancelString2 = cancelString;
        }
        if (($changed & 24576) == 0) {
            if ((i2 & 16) == 0) {
                confirmString2 = confirmString;
                if ($composer2.changed(confirmString2)) {
                    i3 = 16384;
                    $dirty |= i3;
                }
            } else {
                confirmString2 = confirmString;
            }
            i3 = GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE;
            $dirty |= i3;
        } else {
            confirmString2 = confirmString;
        }
        if ($composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "46@1445L57,47@1533L57");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i2 & 16) != 0) {
                    $dirty &= -57345;
                }
            } else {
                if ((i2 & 8) != 0) {
                    cancelString2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_238(Res.string.INSTANCE), $composer2, 0);
                    $dirty &= -7169;
                }
                if ((i2 & 16) != 0) {
                    confirmString2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_313(Res.string.INSTANCE), $composer2, 0);
                    $dirty &= -57345;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2066708551, $dirty, -1, "im.session.common.IMAlertDialog (IMAlertDialog.kt:48)");
            }
            IMAlertDialog(content.getTitle(), content.getContent(), function0, function02, cancelString2, confirmString2, $composer2, (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (458752 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cancelString3 = cancelString2;
            confirmString3 = confirmString2;
        } else {
            $composer2.skipToGroupEnd();
            cancelString3 = cancelString2;
            confirmString3 = confirmString2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str = cancelString3;
            final String str2 = confirmString3;
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMAlertDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMAlertDialog$lambda$2;
                    IMAlertDialog$lambda$2 = IMAlertDialogKt.IMAlertDialog$lambda$2(content, function0, function02, str, str2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMAlertDialog$lambda$2;
                }
            });
        }
    }
}