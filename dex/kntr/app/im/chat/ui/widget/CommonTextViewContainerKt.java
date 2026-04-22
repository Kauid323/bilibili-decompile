package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
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
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonTextViewContainer.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"CommonTextViewContainer", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "cursorColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "hintTextColor", "modifier", "Landroidx/compose/ui/Modifier;", "hintText", RoomRecommendViewModel.EMPTY_CURSOR, "CommonTextViewContainer-Weun_BU", "(Landroidx/compose/foundation/text/input/TextFieldState;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CommonTextViewContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTextViewContainer_Weun_BU$lambda$1(TextFieldState textFieldState, long j2, TextStyle textStyle, long j3, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        m1935CommonTextViewContainerWeun_BU(textFieldState, j2, textStyle, j3, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: CommonTextViewContainer-Weun_BU  reason: not valid java name */
    public static final void m1935CommonTextViewContainerWeun_BU(final TextFieldState state, final long j2, final TextStyle textStyle, final long j3, Modifier modifier, String hintText, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Composer $composer2;
        Modifier modifier3;
        String hintText2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Composer $composer3 = $composer.startRestartGroup(1237533286);
        ComposerKt.sourceInformation($composer3, "C(CommonTextViewContainer)N(state,cursorColor:c#ui.graphics.Color,textStyle,hintTextColor:c#ui.graphics.Color,modifier,hintText)26@906L1138:CommonTextViewContainer.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(j2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(textStyle) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(j3) ? 2048 : 1024;
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
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            str = hintText;
        } else if ((196608 & $changed) == 0) {
            str = hintText;
            $dirty |= $composer3.changed(str) ? 131072 : 65536;
        } else {
            str = hintText;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                hintText2 = str;
            } else {
                hintText2 = "发个消息聊聊吧";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1237533286, $dirty2, -1, "kntr.app.im.chat.ui.widget.CommonTextViewContainer (CommonTextViewContainer.kt:25)");
            }
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            int $changed$iv = (($dirty2 >> 12) & 14) | 48;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2074388810, "C30@1001L1037:CommonTextViewContainer.kt#92mklk");
            $composer2 = $composer3;
            BasicTextFieldKt.BasicTextField(state, (Modifier) null, false, false, (InputTransformation) null, textStyle, (KeyboardOptions) null, (KeyboardActionHandler) null, (TextFieldLineLimits) null, (Function2) null, (MutableInteractionSource) null, new SolidColor(j2, (DefaultConstructorMarker) null), (OutputTransformation) null, new CommonTextViewContainerKt$CommonTextViewContainer$1$1(state, hintText2, textStyle, j3), (ScrollState) null, $composer3, ($dirty2 & 14) | (($dirty2 << 9) & 458752), 0, 22494);
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
            hintText2 = str;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str2 = hintText2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.CommonTextViewContainerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonTextViewContainer_Weun_BU$lambda$1;
                    CommonTextViewContainer_Weun_BU$lambda$1 = CommonTextViewContainerKt.CommonTextViewContainer_Weun_BU$lambda$1(state, j2, textStyle, j3, modifier4, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonTextViewContainer_Weun_BU$lambda$1;
                }
            });
        }
    }
}