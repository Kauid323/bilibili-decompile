package video.biz.offline.list.ui.widget;

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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.AbsoluteCommentItem;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: OfflineCommonDialog.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\f\u001aQ\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"OfflineCommonDialog", "", "titleString", "", "dismissOnClickOutside", "", "contentString", "confirmString", "cancelString", "onConfirm", "Lkotlin/Function0;", "onCancel", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OfflineDialog", "actionButtons", "", "Lvideo/biz/offline/list/ui/widget/DialogBtn;", "modifier", "Landroidx/compose/ui/Modifier;", "onDismiss", "(Ljava/lang/String;Ljava/util/List;Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineCommonDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCommonDialog$lambda$4(String str, boolean z, String str2, String str3, String str4, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        OfflineCommonDialog(str, z, str2, str3, str4, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDialog$lambda$2(String str, List list, Modifier modifier, String str2, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        OfflineDialog(str, list, modifier, str2, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v21 */
    public static final void OfflineCommonDialog(final String titleString, boolean dismissOnClickOutside, String contentString, String confirmString, String cancelString, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        String cancelString2;
        final Function0 onConfirm;
        final Function0 onCancel;
        boolean dismissOnClickOutside2;
        String contentString2;
        String confirmString2;
        String cancelString3;
        Intrinsics.checkNotNullParameter(titleString, "titleString");
        Composer $composer2 = $composer.startRestartGroup(-1665860011);
        ComposerKt.sourceInformation($composer2, "C(OfflineCommonDialog)N(titleString,dismissOnClickOutside,contentString,confirmString,cancelString,onConfirm,onCancel)39@1452L2,40@1483L2,58@1899L209:OfflineCommonDialog.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(titleString) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(dismissOnClickOutside) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            str = contentString;
        } else if (($changed & 384) == 0) {
            str = contentString;
            $dirty |= $composer2.changed(str) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            str = contentString;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            str2 = confirmString;
        } else if (($changed & 3072) == 0) {
            str2 = confirmString;
            $dirty |= $composer2.changed(str2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            str2 = confirmString;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            cancelString2 = cancelString;
        } else if (($changed & 24576) == 0) {
            cancelString2 = cancelString;
            $dirty |= $composer2.changed(cancelString2) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            cancelString2 = cancelString;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            onConfirm = function0;
        } else if ((196608 & $changed) == 0) {
            onConfirm = function0;
            $dirty |= $composer2.changedInstance(onConfirm) ? 131072 : 65536;
        } else {
            onConfirm = function0;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
            onCancel = function02;
        } else if (($changed & 1572864) == 0) {
            onCancel = function02;
            $dirty |= $composer2.changedInstance(onCancel) ? 1048576 : 524288;
        } else {
            onCancel = function02;
        }
        if ($composer2.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            if (i2 != 0) {
                dismissOnClickOutside2 = true;
            } else {
                dismissOnClickOutside2 = dismissOnClickOutside;
            }
            if (i3 == 0) {
                contentString2 = str;
            } else {
                contentString2 = "";
            }
            if (i4 == 0) {
                confirmString2 = str2;
            } else {
                confirmString2 = null;
            }
            if (i5 != 0) {
                cancelString2 = null;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1131337943, "CC(remember):OfflineCommonDialog.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onConfirm2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onConfirm = onConfirm2;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1131338935, "CC(remember):OfflineCommonDialog.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onCancel2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onCancel = onCancel2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1665860011, $dirty, -1, "video.biz.offline.list.ui.widget.OfflineCommonDialog (OfflineCommonDialog.kt:41)");
            }
            List btns = new ArrayList();
            if (cancelString2 != null) {
                $composer2.startReplaceGroup(711865122);
                ComposerKt.sourceInformation($composer2, "45@1642L6,45@1656L42");
                long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
                ComposerKt.sourceInformationMarkerStart($composer2, 1131344511, "CC(remember):OfflineCommonDialog.kt#9igjgp");
                boolean invalid$iv = (3670016 & $dirty) == 1048576;
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit OfflineCommonDialog$lambda$2$0;
                            OfflineCommonDialog$lambda$2$0 = OfflineCommonDialogKt.OfflineCommonDialog$lambda$2$0(onCancel);
                            return OfflineCommonDialog$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                btns.add(new DialogBtn(cancelString2, j, (Function0) it$iv3, null));
            } else {
                $composer2.startReplaceGroup(710296429);
            }
            $composer2.endReplaceGroup();
            if (confirmString2 != null) {
                $composer2.startReplaceGroup(712034971);
                ComposerKt.sourceInformation($composer2, "52@1814L6,52@1833L43");
                long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                ComposerKt.sourceInformationMarkerStart($composer2, 1131350176, "CC(remember):OfflineCommonDialog.kt#9igjgp");
                boolean invalid$iv2 = ($dirty & 458752) == 131072;
                Object it$iv4 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit OfflineCommonDialog$lambda$3$0;
                            OfflineCommonDialog$lambda$3$0 = OfflineCommonDialogKt.OfflineCommonDialog$lambda$3$0(onConfirm);
                            return OfflineCommonDialog$lambda$3$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                btns.add(new DialogBtn(confirmString2, j2, (Function0) it$iv4, null));
            } else {
                $composer2.startReplaceGroup(710296429);
            }
            $composer2.endReplaceGroup();
            OfflineDialog(titleString, btns, null, contentString2, dismissOnClickOutside2, onCancel, $composer2, ($dirty & 14) | (($dirty << 3) & 7168) | (($dirty << 9) & 57344) | (($dirty >> 3) & 458752), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cancelString3 = cancelString2;
        } else {
            $composer2.skipToGroupEnd();
            dismissOnClickOutside2 = dismissOnClickOutside;
            contentString2 = str;
            confirmString2 = str2;
            cancelString3 = cancelString2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z = dismissOnClickOutside2;
            final String str3 = contentString2;
            final String str4 = confirmString2;
            final String str5 = cancelString3;
            final Function0 function03 = onConfirm;
            final Function0 function04 = onCancel;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCommonDialog$lambda$4;
                    OfflineCommonDialog$lambda$4 = OfflineCommonDialogKt.OfflineCommonDialog$lambda$4(titleString, z, str3, str4, str5, function03, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCommonDialog$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCommonDialog$lambda$2$0(Function0 $onCancel) {
        $onCancel.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCommonDialog$lambda$3$0(Function0 $onConfirm) {
        $onConfirm.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final void OfflineDialog(final String titleString, final List<DialogBtn> list, Modifier modifier, String contentString, boolean dismissOnClickOutside, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final String contentString2;
        boolean dismissOnClickOutside2;
        Function0 onDismiss;
        final Modifier modifier3;
        boolean dismissOnClickOutside3;
        Function0 onDismiss2;
        String contentString3;
        Intrinsics.checkNotNullParameter(titleString, "titleString");
        Intrinsics.checkNotNullParameter(list, "actionButtons");
        Composer $composer2 = $composer.startRestartGroup(-282253251);
        ComposerKt.sourceInformation($composer2, "C(OfflineDialog)N(titleString,actionButtons,modifier,contentString,dismissOnClickOutside,onDismiss)74@2342L2,79@2492L3448,76@2354L3586:OfflineCommonDialog.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(titleString) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            contentString2 = contentString;
        } else if (($changed & 3072) == 0) {
            contentString2 = contentString;
            $dirty |= $composer2.changed(contentString2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            contentString2 = contentString;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            dismissOnClickOutside2 = dismissOnClickOutside;
        } else if (($changed & 24576) == 0) {
            dismissOnClickOutside2 = dismissOnClickOutside;
            $dirty |= $composer2.changed(dismissOnClickOutside2) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            dismissOnClickOutside2 = dismissOnClickOutside;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            onDismiss = function0;
        } else if ((196608 & $changed) == 0) {
            onDismiss = function0;
            $dirty |= $composer2.changedInstance(onDismiss) ? 131072 : 65536;
        } else {
            onDismiss = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            dismissOnClickOutside3 = dismissOnClickOutside2;
            onDismiss2 = onDismiss;
            contentString3 = contentString2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 != 0) {
                contentString2 = "";
            }
            if (i4 != 0) {
                dismissOnClickOutside2 = true;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -662427585, "CC(remember):OfflineCommonDialog.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onDismiss3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onDismiss = onDismiss3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-282253251, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineDialog (OfflineCommonDialog.kt:75)");
            }
            String contentString4 = contentString2;
            AndroidDialog_androidKt.Dialog(onDismiss, new DialogProperties(false, dismissOnClickOutside2, false, 5, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(1795700692, true, new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDialog$lambda$1;
                    OfflineDialog$lambda$1 = OfflineCommonDialogKt.OfflineDialog$lambda$1(modifier3, list, titleString, contentString2, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDialog$lambda$1;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 15) & 14) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dismissOnClickOutside3 = dismissOnClickOutside2;
            onDismiss2 = onDismiss;
            contentString3 = contentString4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str = contentString3;
            final boolean z = dismissOnClickOutside3;
            final Function0 function02 = onDismiss2;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDialog$lambda$2;
                    OfflineDialog$lambda$2 = OfflineCommonDialogKt.OfflineDialog$lambda$2(titleString, list, modifier4, str, z, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDialog$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x052e, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0888, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineDialog$lambda$1(Modifier $modifier, List $actionButtons, String $titleString, String $contentString, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        ComposerKt.sourceInformation($composer, "C83@2622L6,80@2502L3432:OfflineCommonDialog.kt#uys4uf");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1795700692, $changed, -1, "video.biz.offline.list.ui.widget.OfflineDialog.<anonymous> (OfflineCommonDialog.kt:80)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.width-3ABfNKs($modifier, Dp.constructor-impl(280)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
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
            int i2 = ((0 >> 6) & 112) | 6;
            Composer $composer3 = $composer;
            ComposerKt.sourceInformationMarkerStart($composer3, -1392025178, "C87@2737L949,113@3756L6,113@3700L76:OfflineCommonDialog.kt#uys4uf");
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(18), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(24), 5, (Object) null);
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 14) | ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 112));
            int $changed$iv$iv2 = (AbsoluteCommentItem.BILI_PLAYER_HEIGHT << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i4 = ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1325096322, "C98@3207L6,99@3259L9,96@3123L219:OfflineCommonDialog.kt#uys4uf");
            TextKt.Text-Nvy7gAk($titleString, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), $composer3, 0, 0, 130042);
            if (StringsKt.isBlank($contentString)) {
                $composer3.startReplaceGroup(-1328212350);
            } else {
                $composer3.startReplaceGroup(-1324817230);
                ComposerKt.sourceInformation($composer3, "106@3508L6,107@3564L9,104@3414L240");
                TextKt.Text-Nvy7gAk($contentString, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 130042);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer3, 48, 1);
            String str3 = "CC(remember):OfflineCommonDialog.kt#9igjgp";
            if ($actionButtons.size() <= 2) {
                $composer3.startReplaceGroup(-1391004659);
                ComposerKt.sourceInformation($composer3, "116@3837L907");
                Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(44));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
                Composer $composer$iv2 = $composer3;
                int $changed$iv = 438;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv2, ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 14) | ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 112));
                int $changed$iv$iv3 = (AbsoluteCommentItem.BILI_PLAYER_HEIGHT << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv3);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv2.startReusableNode();
                if ($composer$iv2.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv9;
                    $composer$iv2.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv9;
                    $composer$iv2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv2);
                $composer$iv = $composer;
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                boolean z = false;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 6) & 112) | 6;
                RowScope $this$OfflineDialog_u24lambda_u241_u240_u241 = rowScope;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -419255359, "C:OfflineCommonDialog.kt#uys4uf");
                $composer$iv2.startReplaceGroup(540665396);
                ComposerKt.sourceInformation($composer$iv2, "*124@4270L84,122@4148L556");
                List $this$forEach$iv = $actionButtons;
                boolean z2 = false;
                for (Object element$iv : $this$forEach$iv) {
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    final DialogBtn btn = (DialogBtn) element$iv;
                    int compositeKeyHash$iv$iv4 = compositeKeyHash$iv$iv3;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    boolean z3 = z2;
                    Modifier materialized$iv$iv4 = materialized$iv$iv3;
                    Modifier weight$default = RowScope.-CC.weight$default($this$OfflineDialog_u24lambda_u241_u240_u241, SizeKt.fillMaxHeight$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), 1.0f, false, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1666021338, str3);
                    boolean invalid$iv = $composer$iv2.changed(btn);
                    Object it$iv = $composer$iv2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit OfflineDialog$lambda$1$0$1$0$0$0;
                            OfflineDialog$lambda$1$0$1$0$0$0 = OfflineCommonDialogKt.OfflineDialog$lambda$1$0$1$0$0$0(DialogBtn.this);
                            return OfflineDialog$lambda$1$0$1$0$0$0;
                        }
                    };
                    $composer$iv2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(weight$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                    int $changed$iv2 = $changed$iv;
                    boolean z4 = z;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv4 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer$iv2.getCurrentCompositionLocalMap();
                    String str4 = str3;
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv4);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    String str5 = str;
                    Composer $composer$iv$iv$iv = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str2);
                    if (!($composer$iv2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv2.startReusableNode();
                    if ($composer$iv2.getInserting()) {
                        factory$iv$iv$iv6 = factory$iv$iv$iv10;
                        $composer$iv2.createNode(factory$iv$iv$iv6);
                    } else {
                        factory$iv$iv$iv6 = factory$iv$iv$iv10;
                        $composer$iv2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i8 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -1985882130, "C132@4634L9,129@4477L201:OfflineCommonDialog.kt#uys4uf");
                    TextKt.Text-Nvy7gAk(btn.getTitle(), (Modifier) null, btn.m2918getColor0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT16(), $composer$iv2, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $changed$iv = $changed$iv2;
                    z = z4;
                    $this$forEach$iv = $this$forEach$iv2;
                    compositeKeyHash$iv$iv3 = compositeKeyHash$iv$iv4;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    z2 = z3;
                    materialized$iv$iv3 = materialized$iv$iv4;
                    str3 = str4;
                    $composer3 = $composer$iv$iv$iv;
                    str = str5;
                    $composer$iv2 = $composer$iv2;
                    str2 = str2;
                }
                Composer $composer4 = $composer3;
                $composer$iv2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer4.endReplaceGroup();
                $composer2 = $composer4;
            } else {
                $composer$iv = $composer;
                String str6 = "CC(remember):OfflineCommonDialog.kt#9igjgp";
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-1390077232);
                ComposerKt.sourceInformation($composer2, "138@4782L1128");
                Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getCenterHorizontally();
                int $changed$iv3 = 390;
                ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv5 = (390 << 3) & 112;
                MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv5;
                String str7 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, str7);
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
                Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                String str8 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, str8);
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv11;
                    $composer2.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv11;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                boolean z5 = false;
                ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                int i10 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1836264071, "C:OfflineCommonDialog.kt#uys4uf");
                $composer2.startReplaceGroup(-1167612548);
                ComposerKt.sourceInformation($composer2, "*145@5149L84,143@5025L558");
                List $this$forEachIndexed$iv = $actionButtons;
                boolean z6 = false;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    final DialogBtn btn2 = (DialogBtn) item$iv;
                    int idx = index$iv;
                    CompositionLocalMap localMap$iv$iv6 = localMap$iv$iv5;
                    int $changed$iv4 = $changed$iv3;
                    Modifier materialized$iv$iv7 = materialized$iv$iv6;
                    boolean z7 = z6;
                    Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(44));
                    String str9 = str6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 26722955, str9);
                    boolean invalid$iv2 = $composer2.changed(btn2);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCommonDialogKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit OfflineDialog$lambda$1$0$2$0$0$0;
                            OfflineDialog$lambda$1$0$2$0$0$0 = OfflineCommonDialogKt.OfflineDialog$lambda$1$0$2$0$0$0(DialogBtn.this);
                            return OfflineDialog$lambda$1$0$2$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier$iv6 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    int $changed$iv$iv$iv6 = $changed$iv$iv$iv5;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv6 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, str7);
                    int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv7 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer2, modifier$iv6);
                    Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                    MeasurePolicy measurePolicy$iv$iv4 = measurePolicy$iv$iv3;
                    boolean z8 = z5;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, str8);
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv12;
                        $composer2.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv12;
                        $composer2.useNode();
                    }
                    String str10 = str8;
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer2);
                    String str11 = str7;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i12 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1413375881, "C153@5513L9,150@5356L201:OfflineCommonDialog.kt#uys4uf");
                    TextKt.Text-Nvy7gAk(btn2.getTitle(), (Modifier) null, btn2.m2918getColor0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (idx != $actionButtons.size() - 1) {
                        $composer2.startReplaceGroup(828906088);
                        ComposerKt.sourceInformation($composer2, "159@5794L6,157@5673L171");
                        DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer2, 48, 1);
                    } else {
                        $composer2.startReplaceGroup(823300203);
                    }
                    $composer2.endReplaceGroup();
                    z5 = z8;
                    materialized$iv$iv6 = materialized$iv$iv7;
                    z6 = z7;
                    index$iv = index$iv2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    localMap$iv$iv5 = localMap$iv$iv6;
                    $changed$iv3 = $changed$iv4;
                    str6 = str9;
                    $changed$iv$iv$iv5 = $changed$iv$iv$iv6;
                    measurePolicy$iv$iv3 = measurePolicy$iv$iv4;
                    str8 = str10;
                    str7 = str11;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDialog$lambda$1$0$1$0$0$0(DialogBtn $btn) {
        $btn.getAction().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDialog$lambda$1$0$2$0$0$0(DialogBtn $btn) {
        $btn.getAction().invoke();
        return Unit.INSTANCE;
    }
}