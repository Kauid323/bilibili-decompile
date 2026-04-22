package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: ContentWithCheckMark.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ap\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"ContentWithCheckMark", "", "isEdit", "", "isChecked", "modifier", "Landroidx/compose/ui/Modifier;", "clickable", "padding", "Landroidx/compose/ui/unit/Dp;", "onclick", "Lkotlin/Function0;", "onLongClick", "content", "Landroidx/compose/runtime/Composable;", "ContentWithCheckMark-GHTll3U", "(ZZLandroidx/compose/ui/Modifier;ZFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ContentWithCheckMarkKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentWithCheckMark_GHTll3U$lambda$3(boolean z, boolean z2, Modifier modifier, boolean z3, float f, Function0 function0, Function0 function02, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2913ContentWithCheckMarkGHTll3U(z, z2, modifier, z3, f, function0, function02, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x037d, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* renamed from: ContentWithCheckMark-GHTll3U  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2913ContentWithCheckMarkGHTll3U(final boolean isEdit, final boolean isChecked, Modifier modifier, boolean clickable, float f, Function0<Unit> function0, Function0<Unit> function02, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        boolean clickable2;
        float f2;
        Function0 onclick;
        Composer $composer2;
        Modifier modifier2;
        Function0 onLongClick;
        boolean clickable3;
        float f3;
        Function0 onclick2;
        Modifier modifier3;
        Function0<Unit> onLongClick2;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer3 = $composer.startRestartGroup(-465403835);
        ComposerKt.sourceInformation($composer3, "C(ContentWithCheckMark)N(isEdit,isChecked,modifier,clickable,padding:c#ui.unit.Dp,onclick,onLongClick,content)28@1052L2,29@1086L2,32@1135L1120:ContentWithCheckMark.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(isEdit) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(isChecked) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(modifier) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            clickable2 = clickable;
        } else if (($changed & 3072) == 0) {
            clickable2 = clickable;
            $dirty |= $composer3.changed(clickable2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            clickable2 = clickable;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty |= $composer3.changed(f2) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            f2 = f;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            onclick = function0;
        } else if ((196608 & $changed) == 0) {
            onclick = function0;
            $dirty |= $composer3.changedInstance(onclick) ? 131072 : 65536;
        } else {
            onclick = function0;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        }
        if (!$composer3.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onLongClick = function02;
            clickable3 = clickable2;
            f3 = f2;
            onclick2 = onclick;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 != 0) {
                clickable2 = true;
            }
            if (i4 != 0) {
                f2 = Dp.constructor-impl(10);
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -576480633, "CC(remember):ContentWithCheckMark.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.ContentWithCheckMarkKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onclick3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onclick = onclick3;
            }
            if (i6 == 0) {
                onLongClick2 = function02;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, -576479545, "CC(remember):ContentWithCheckMark.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.ContentWithCheckMarkKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onLongClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-465403835, $dirty, -1, "video.biz.offline.list.ui.widget.ContentWithCheckMark (ContentWithCheckMark.kt:31)");
            }
            if (clickable2) {
                modifier4 = ClickableKt.combinedClickable-hoGz1lA$default(modifier3, false, (String) null, (Role) null, (String) null, onLongClick2, (Function0) null, false, (MutableInteractionSource) null, onclick, 239, (Object) null);
            } else {
                modifier4 = modifier3;
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(modifier4, f2, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier5 = modifier3;
            Function0 onLongClick3 = onLongClick2;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            clickable3 = clickable2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Function0 onclick4 = onclick;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1623612748, "C65@2240L9:ContentWithCheckMark.kt#uys4uf");
            if (isEdit) {
                $composer3.startReplaceGroup(1623623721);
                ComposerKt.sourceInformation($composer3, "63@2179L42");
                if (isChecked) {
                    $composer3.startReplaceGroup(1623655744);
                    ComposerKt.sourceInformation($composer3, "47@1607L25,48@1671L6,46@1558L249");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_circle_fill_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1623925382);
                    ComposerKt.sourceInformation($composer3, "53@1867L6,56@1987L165,54@1894L258");
                    final long color = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU();
                    Modifier modifier6 = PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Dp.constructor-impl(3));
                    ComposerKt.sourceInformationMarkerStart($composer3, -1748725682, "CC(remember):ContentWithCheckMark.kt#9igjgp");
                    boolean invalid$iv = $composer3.changed(color);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.widget.ContentWithCheckMarkKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit ContentWithCheckMark_GHTll3U$lambda$2$0$0;
                            ContentWithCheckMark_GHTll3U$lambda$2$0$0 = ContentWithCheckMarkKt.ContentWithCheckMark_GHTll3U$lambda$2$0$0(color, (DrawScope) obj);
                            return ContentWithCheckMark_GHTll3U$lambda$2$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    CanvasKt.Canvas(modifier6, (Function1) it$iv3, $composer3, 6);
                    $composer3.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, f2), $composer3, 0);
            } else {
                $composer3.startReplaceGroup(1622101497);
            }
            $composer3.endReplaceGroup();
            function2.invoke($composer3, Integer.valueOf(($dirty >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
            onLongClick = onLongClick3;
            onclick2 = onclick4;
            f3 = f2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            final boolean z = clickable3;
            final float f4 = f3;
            final Function0 function03 = onclick2;
            final Function0 function04 = onLongClick;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.ContentWithCheckMarkKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContentWithCheckMark_GHTll3U$lambda$3;
                    ContentWithCheckMark_GHTll3U$lambda$3 = ContentWithCheckMarkKt.ContentWithCheckMark_GHTll3U$lambda$3(isEdit, isChecked, modifier7, z, f4, function03, function04, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ContentWithCheckMark_GHTll3U$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentWithCheckMark_GHTll3U$lambda$2$0$0(long $color, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, $color, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0L, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, new Stroke($this$Canvas.toPx-0680j_4(Dp.constructor-impl(1)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, (int) IjkMediaMeta.FF_PROFILE_H264_HIGH_10, (Object) null);
        return Unit.INSTANCE;
    }
}