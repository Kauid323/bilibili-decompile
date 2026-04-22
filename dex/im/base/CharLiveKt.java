package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: CharLive.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"CharLiveIcon", "", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CharLiveKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CharLiveIcon$lambda$1(Modifier modifier, String str, int i2, int i3, Composer composer, int i4) {
        CharLiveIcon(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void CharLiveIcon(Modifier modifier, String text, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        final String text2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(1431872866);
        ComposerKt.sourceInformation($composer2, "C(CharLiveIcon)N(modifier,text)32@1102L6,28@990L723:CharLive.kt#uu6lp7");
        int $dirty = $changed;
        int i4 = i2 & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i2 & 2) == 0) {
                text2 = text;
                if ($composer2.changed(text2)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                text2 = text;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            text2 = text;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "26@929L51");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    $dirty &= -113;
                    text2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_338(Res.string.INSTANCE), $composer2, 0);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1431872866, $dirty, -1, "im.base.CharLiveIcon (CharLive.kt:27)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(modifier3, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), Dp.constructor-impl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            Modifier modifier4 = modifier3;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$CharLiveIcon_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, 1330984866, "C39@1478L6,39@1384L112,44@1634L6,45@1683L9,41@1506L201:CharLive.kt#uu6lp7");
            LiveBadgeKt.m3094LiveIcon3IgeMak($this$CharLiveIcon_u24lambda_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getCenterVertically()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), false, $composer2, 0, 4);
            TextKt.Text-Nvy7gAk(text2, $this$CharLiveIcon_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, ($dirty >> 3) & 14, 0, 131064);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.CharLiveKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CharLiveIcon$lambda$1;
                    CharLiveIcon$lambda$1 = CharLiveKt.CharLiveIcon$lambda$1(modifier2, text2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return CharLiveIcon$lambda$1;
                }
            });
        }
    }
}