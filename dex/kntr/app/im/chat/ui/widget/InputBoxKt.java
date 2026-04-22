package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.im.chat.core.model.InputBoxConfig;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.utils.TextStyleExt_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: InputBox.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"InputBox", RoomRecommendViewModel.EMPTY_CURSOR, "inputBoxState", "Lkntr/app/im/chat/ui/widget/InputBoxState;", "hasSelectedAsset", RoomRecommendViewModel.EMPTY_CURSOR, "inputBoxSelectState", "Lkntr/app/im/chat/core/model/InputBoxSelectState;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/widget/InputBoxState;ZLkntr/app/im/chat/core/model/InputBoxSelectState;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "KeyboardIcon", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "GalleryButtonTip", "imageSelectedCount", RoomRecommendViewModel.EMPTY_CURSOR, "color", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "GalleryButtonTip-cf5BqRc", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputBoxKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GalleryButtonTip_cf5BqRc$lambda$1(int i, Modifier modifier, long j2, TextStyle textStyle, int i2, int i3, Composer composer, int i4) {
        m1954GalleryButtonTipcf5BqRc(i, modifier, j2, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$0(InputBoxState inputBoxState, boolean z, InputBoxSelectState inputBoxSelectState, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InputBox(inputBoxState, z, inputBoxSelectState, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$1(InputBoxState inputBoxState, boolean z, InputBoxSelectState inputBoxSelectState, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InputBox(inputBoxState, z, inputBoxSelectState, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$3(InputBoxState inputBoxState, boolean z, InputBoxSelectState inputBoxSelectState, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InputBox(inputBoxState, z, inputBoxSelectState, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardIcon$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        KeyboardIcon(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x057d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InputBox(final InputBoxState inputBoxState, final boolean hasSelectedAsset, final InputBoxSelectState inputBoxSelectState, final ChatActionHandler actionHandler, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier$iv$iv;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        int $changed2;
        InputBoxConfig inputBoxConfig;
        RowScope $this$InputBox_u24lambda_u242;
        Composer $composer3;
        Function0 factory$iv$iv$iv2;
        String str;
        String str2;
        CoroutineScope scope;
        int $dirty;
        Function0 factory$iv$iv$iv3;
        String str3;
        Composer $composer4;
        final InputContent inputBox;
        final ChatActionHandler chatActionHandler;
        RowScope $this$InputBox_u24lambda_u2422;
        Function0 factory$iv$iv$iv4;
        Intrinsics.checkNotNullParameter(inputBoxState, "inputBoxState");
        Intrinsics.checkNotNullParameter(inputBoxSelectState, "inputBoxSelectState");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer5 = $composer.startRestartGroup(1755424801);
        ComposerKt.sourceInformation($composer5, "C(InputBox)N(inputBoxState,hasSelectedAsset,inputBoxSelectState,actionHandler,modifier)77@3242L24,80@3290L7354:InputBox.kt#92mklk");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer5.changed(inputBoxState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer5.changed(hasSelectedAsset) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer5.changedInstance(inputBoxSelectState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer5.changed(actionHandler) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer5.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if ($composer5.shouldExecute(($dirty3 & 9363) != 9362, $dirty3 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1755424801, $dirty3, -1, "kntr.app.im.chat.ui.widget.InputBox (InputBox.kt:74)");
            }
            InputContent inputBox2 = inputBoxState.getInputBoxContent();
            if (inputBox2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer5.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit InputBox$lambda$0;
                            InputBox$lambda$0 = InputBoxKt.InputBox$lambda$0(InputBoxState.this, hasSelectedAsset, inputBoxSelectState, actionHandler, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return InputBox$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            InputBoxConfig inputBoxConfig2 = inputBoxState.getInputBoxConfig();
            if (inputBoxConfig2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer5.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier3;
                    endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj, Object obj2) {
                            Unit InputBox$lambda$1;
                            InputBox$lambda$1 = InputBoxKt.InputBox$lambda$1(InputBoxState.this, hasSelectedAsset, inputBoxSelectState, actionHandler, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return InputBox$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer5, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer5.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5);
                $composer5.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope2 = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-VpY3zN4$default(modifier3, 0.0f, Dp.constructor-impl(8), 1, (Object) null), Dp.constructor-impl(6), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int $changed3 = ((432 >> 6) & 112) | 6;
            RowScope $this$InputBox_u24lambda_u2423 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, -702936464, "C147@6179L6,154@6501L396,165@7007L6,166@7057L6,168@7126L9,169@7184L6,175@7381L236,140@5869L1759,233@9442L1196,216@8849L1789:InputBox.kt#92mklk");
            if (inputBoxConfig2.getEnablePic() || inputBoxConfig2.getEnableVideo()) {
                $composer5.startReplaceGroup(-703027481);
                ComposerKt.sourceInformation($composer5, "89@3618L2214");
                $composer$iv$iv$iv = $composer5;
                Modifier modifier$iv2 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(36));
                $composer$iv = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                $changed2 = $changed3;
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
                inputBoxConfig = inputBoxConfig2;
                $this$InputBox_u24lambda_u242 = $this$InputBox_u24lambda_u2423;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer3 = $composer5;
                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer5.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer5.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, -917038882, "C93@3790L690,91@3697L2121:InputBox.kt#92mklk");
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer5, 524608974, "CC(remember):InputBox.kt#9igjgp");
                boolean invalid$iv = $composer5.changedInstance(scope2) | $composer5.changedInstance(inputBoxSelectState) | (($dirty3 & 7168) == 2048);
                Object it$iv = $composer5.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv3 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                    str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                    Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    scope = scope2;
                    $dirty = $dirty3;
                    ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer5.startReusableNode();
                    if ($composer5.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer5.useNode();
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv7;
                        $composer5.createNode(factory$iv$iv$iv3);
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                    str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer4 = $composer5;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i7 = ((48 >> 6) & 112) | 6;
                    BoxScope $this$InputBox_u24lambda_u242_u240_u241 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer5, 1927566056, "C:InputBox.kt#92mklk");
                    if (inputBoxSelectState instanceof InputBoxSelectState.Gallery) {
                        $composer5.startReplaceGroup(1927727503);
                        ComposerKt.sourceInformation($composer5, "114@4830L14,116@4946L6,113@4773L273,128@5556L222,119@5098L680");
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getImage_line_500($composer5, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText2-0d7_KjU(), $composer5, Painter.$stable | 432, 0);
                        inputBox = inputBox2;
                        AnimatedVisibilityKt.AnimatedVisibility(!inputBox2.getSelectedAssets().isEmpty(), PaddingKt.padding-qDBjuR0$default($this$InputBox_u24lambda_u242_u240_u241.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, Dp.constructor-impl(4), Dp.constructor-impl(2), 0.0f, 9, (Object) null), EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(441545338, true, new Function3() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda9
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit InputBox$lambda$2$0$1$0;
                                InputBox$lambda$2$0$1$0 = InputBoxKt.InputBox$lambda$2$0$1$0(InputContent.this, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return InputBox$lambda$2$0$1$0;
                            }
                        }, $composer5, 54), $composer5, 200064, 16);
                        $composer5.endReplaceGroup();
                    } else {
                        $composer5.startReplaceGroup(1927587042);
                        ComposerKt.sourceInformation($composer5, "111@4705L14");
                        KeyboardIcon(null, $composer5, 0, 1);
                        $composer5.endReplaceGroup();
                        inputBox = inputBox2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer3.endReplaceGroup();
                }
                Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit InputBox$lambda$2$0$0$0;
                        InputBox$lambda$2$0$0$0 = InputBoxKt.InputBox$lambda$2$0$0$0(scope2, inputBoxSelectState, actionHandler);
                        return InputBox$lambda$2$0$0$0;
                    }
                };
                $composer5.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Modifier modifier$iv32 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv32 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                int $changed$iv$iv32 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                CompositionLocalMap localMap$iv$iv32 = $composer5.getCurrentCompositionLocalMap();
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer5, modifier$iv32);
                Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                scope = scope2;
                $dirty = $dirty3;
                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer5.getApplier() instanceof Applier)) {
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer5);
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer4 = $composer5;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                int i62 = ($changed$iv$iv$iv32 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i72 = ((48 >> 6) & 112) | 6;
                BoxScope $this$InputBox_u24lambda_u242_u240_u2412 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer5, 1927566056, "C:InputBox.kt#92mklk");
                if (inputBoxSelectState instanceof InputBoxSelectState.Gallery) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer3.endReplaceGroup();
            } else {
                $composer5.startReplaceGroup(-706673019);
                $composer5.endReplaceGroup();
                inputBoxConfig = inputBoxConfig2;
                scope = scope2;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv$iv$iv = $composer5;
                $this$InputBox_u24lambda_u242 = $this$InputBox_u24lambda_u2423;
                $changed2 = $changed3;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv = $composer5;
                str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                $composer3 = $composer5;
                $composer4 = $composer5;
                $dirty = $dirty3;
                inputBox = inputBox2;
            }
            RowScope $this$InputBox_u24lambda_u2424 = $this$InputBox_u24lambda_u242;
            Composer $composer6 = $composer3;
            Modifier animateContentSize$default = AnimationModifierKt.animateContentSize$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.heightIn-VpY3zN4$default(SizeKt.defaultMinSize-VpY3zN4$default($this$InputBox_u24lambda_u2424.weight(Modifier.Companion, 1.0f, true), 0.0f, Dp.constructor-impl(36), 1, (Object) null), 0.0f, Dp.constructor-impl(95), 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(17))), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getGraph_bg_regular-0d7_KjU(), (Shape) null, 2, (Object) null), AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Function2) null, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, 947243881, "CC(remember):InputBox.kt#9igjgp");
            final CoroutineScope scope3 = scope;
            Composer $composer7 = $composer4;
            int $dirty4 = $dirty;
            boolean invalid$iv2 = $composer7.changedInstance(scope3) | (($dirty4 & 7168) == 2048);
            Object it$iv2 = $composer6.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                chatActionHandler = actionHandler;
                Object value$iv2 = (PointerInputEventHandler) new InputBoxKt$InputBox$1$2$1(scope3, chatActionHandler);
                $composer6.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                chatActionHandler = actionHandler;
            }
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(animateContentSize$default, unit, (PointerInputEventHandler) it$iv2);
            int contentVersion = inputBox.getContentVersion();
            long j2 = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText3-0d7_KjU();
            long j3 = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT14(), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
            InputBoxContent inputBoxContent = inputBox.getInputBoxContent();
            String hintText = inputBoxConfig.getHintText();
            ComposerKt.sourceInformationMarkerStart($composer6, 947271881, "CC(remember):InputBox.kt#9igjgp");
            boolean invalid$iv3 = $composer7.changedInstance(scope3) | (($dirty4 & 7168) == 2048);
            Object it$iv3 = $composer6.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit InputBox$lambda$2$2$0;
                        InputBox$lambda$2$2$0 = InputBoxKt.InputBox$lambda$2$2$0(scope3, chatActionHandler, (InputBoxContent) obj);
                        return InputBox$lambda$2$2$0;
                    }
                };
                $composer6.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer6);
            RichInputFieldKt.m1986RichInputField1esR5Hs(inputBoxContent, (Function1) it$iv3, Integer.valueOf(contentVersion), j3, textStyle, j2, hintText, pointerInput, null, $composer6, 0, 256);
            if (inputBoxConfig.getEnableSticker()) {
                $composer6.startReplaceGroup(-699026187);
                ComposerKt.sourceInformation($composer6, "190@7789L454,188@7706L1092");
                Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(36));
                ComposerKt.sourceInformationMarkerStart($composer6, 947285155, "CC(remember):InputBox.kt#9igjgp");
                boolean invalid$iv4 = $composer7.changedInstance(scope3) | $composer7.changedInstance(inputBoxSelectState) | (($dirty4 & 7168) == 2048);
                Object it$iv4 = $composer6.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit InputBox$lambda$2$3$0;
                            InputBox$lambda$2$3$0 = InputBoxKt.InputBox$lambda$2$3$0(scope3, inputBoxSelectState, chatActionHandler);
                            return InputBox$lambda$2$3$0;
                        }
                    };
                    $composer6.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null);
                Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, str2);
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                int $changed$iv$iv4 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, str);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                $composer2 = $composer7;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, str3);
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer6.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer6);
                $this$InputBox_u24lambda_u2422 = $this$InputBox_u24lambda_u2424;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i9 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -290599880, "C:InputBox.kt#92mklk");
                if (Intrinsics.areEqual(inputBoxSelectState, InputBoxSelectState.EMOJI.INSTANCE)) {
                    $composer6.startReplaceGroup(-290557473);
                    ComposerKt.sourceInformation($composer6, "203@8446L14");
                    KeyboardIcon(null, $composer6, 0, 1);
                    $composer6.endReplaceGroup();
                } else {
                    $composer6.startReplaceGroup(-290431303);
                    ComposerKt.sourceInformation($composer6, "206@8559L21,208@8674L6,205@8506L260");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getEmoji_circle_line_300($composer6, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText2-0d7_KjU(), $composer6, Painter.$stable | 432, 0);
                    $composer6.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
            } else {
                $this$InputBox_u24lambda_u2422 = $this$InputBox_u24lambda_u2424;
                $composer2 = $composer7;
                $composer6.startReplaceGroup(-706673019);
            }
            $composer6.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility($this$InputBox_u24lambda_u2422, !StringsKt.isBlank(inputBox.getInputBoxContent().getText()) || hasSelectedAsset, (Modifier) null, EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null).plus(EnterExitTransitionKt.expandHorizontally$default((FiniteAnimationSpec) null, (Alignment.Horizontal) null, false, (Function1) null, 15, (Object) null)), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null).plus(EnterExitTransitionKt.shrinkHorizontally$default(AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearEasing(), 2, (Object) null), (Alignment.Horizontal) null, false, (Function1) null, 14, (Object) null)), (String) null, ComposableLambdaKt.rememberComposableLambda(2072153701, true, new Function3() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InputBox$lambda$2$5;
                    InputBox$lambda$2$5 = InputBoxKt.InputBox$lambda$2$5(scope3, chatActionHandler, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InputBox$lambda$2$5;
                }
            }, $composer6, 54), $composer6, ($changed2 & 14) | 1575936, 18);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            final Modifier modifier7 = modifier$iv$iv;
            endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputBox$lambda$3;
                    InputBox$lambda$3 = InputBoxKt.InputBox$lambda$3(InputBoxState.this, hasSelectedAsset, inputBoxSelectState, actionHandler, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InputBox$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$2$0$0$0(CoroutineScope $scope, InputBoxSelectState $inputBoxSelectState, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new InputBoxKt$InputBox$1$1$1$1$1($inputBoxSelectState, $actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$2$0$1$0(InputContent $inputBox, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C129@5586L166:InputBox.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441545338, $changed, -1, "kntr.app.im.chat.ui.widget.InputBox.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InputBox.kt:129)");
        }
        m1954GalleryButtonTipcf5BqRc($inputBox.getSelectedAssets().size(), null, 0L, null, $composer, 0, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$2$2$0(CoroutineScope $scope, ChatActionHandler $actionHandler, InputBoxContent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new InputBoxKt$InputBox$1$3$1$1($actionHandler, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$2$3$0(CoroutineScope $scope, InputBoxSelectState $inputBoxSelectState, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new InputBoxKt$InputBox$1$4$1$1($inputBoxSelectState, $actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x01bf, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit InputBox$lambda$2$5(final CoroutineScope $scope, final ChatActionHandler $actionHandler, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C234@9456L1172:InputBox.kt#92mklk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2072153701, $changed, -1, "kntr.app.im.chat.ui.widget.InputBox.<anonymous>.<anonymous> (InputBox.kt:234)");
        }
        Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), Dp.constructor-impl(36));
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (54 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
        int i = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((54 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1055537186, "C255@10274L6,256@10346L6,254@10205L185,242@9718L154,241@9680L934:InputBox.kt#92mklk");
        Modifier modifier = SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Dp.constructor-impl(48));
        PaddingValues paddingValues = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
        Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
        ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, 0L, $composer, ButtonDefaults.$stable << 12, 12);
        ComposerKt.sourceInformationMarkerStart($composer, -311143815, "CC(remember):InputBox.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($actionHandler);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit InputBox$lambda$2$5$0$0$0;
                InputBox$lambda$2$5$0$0$0 = InputBoxKt.InputBox$lambda$2$5$0$0$0($scope, $actionHandler);
                return InputBox$lambda$2$5$0$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv);
        it$iv = value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ButtonKt.Button((Function0) it$iv, modifier, false, shape, buttonColors, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableSingletons$InputBoxKt.INSTANCE.getLambda$1040893103$ui_debug(), $composer, 817889328, 356);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputBox$lambda$2$5$0$0$0(CoroutineScope $scope, ChatActionHandler $actionHandler) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new InputBoxKt$InputBox$1$6$1$1$1$1($actionHandler, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void KeyboardIcon(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(953082888);
        ComposerKt.sourceInformation($composer2, "C(KeyboardIcon)N(modifier)272@10759L17,274@10838L6,271@10722L181:InputBox.kt#92mklk");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(953082888, $dirty2, -1, "kntr.app.im.chat.ui.widget.KeyboardIcon (InputBox.kt:270)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getKeyboard_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(modifier, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit KeyboardIcon$lambda$0;
                    KeyboardIcon$lambda$0 = InputBoxKt.KeyboardIcon$lambda$0(modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return KeyboardIcon$lambda$0;
                }
            });
        }
    }

    /* renamed from: GalleryButtonTip-cf5BqRc  reason: not valid java name */
    private static final void m1954GalleryButtonTipcf5BqRc(final int imageSelectedCount, Modifier modifier, long j2, TextStyle textStyle, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j3;
        TextStyle textStyle2;
        Modifier modifier3;
        long j4;
        TextStyle textStyle3;
        Modifier modifier4;
        long j5;
        Function0 factory$iv$iv$iv;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(1433456851);
        ComposerKt.sourceInformation($composer2, "C(GalleryButtonTip)N(imageSelectedCount,modifier,color:c#ui.graphics.Color,textStyle)290@11242L419:InputBox.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(imageSelectedCount) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j3 = j2;
                if ($composer2.changed(j3)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                j3 = j2;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            j3 = j2;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                textStyle2 = textStyle;
                if ($composer2.changed(textStyle2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                textStyle2 = textStyle;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            textStyle2 = textStyle;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j4 = j3;
            textStyle3 = textStyle2;
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "283@11042L6,285@11106L9,287@11173L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier4 = modifier2;
                j5 = j3;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) == 0) {
                    j5 = j3;
                } else {
                    j5 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    textStyle2 = TextStyleExt_androidKt.includeFontPadding(TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), false);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1433456851, $dirty, -1, "kntr.app.im.chat.ui.widget.GalleryButtonTip (InputBox.kt:289)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(modifier4, Dp.constructor-impl(12)), RoundedCornerShapeKt.getCircleShape()), j5, (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            modifier3 = modifier4;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            j4 = j5;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -12778804, "C301@11517L138:InputBox.kt#92mklk");
            TextKt.Text-Nvy7gAk(String.valueOf(imageSelectedCount), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, textStyle2, $composer2, 0, ($dirty << 12) & 29360128, 130046);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean propagateMinConstraints$iv = ComposerKt.isTraceInProgress();
            if (propagateMinConstraints$iv) {
                ComposerKt.traceEventEnd();
            }
            textStyle3 = textStyle2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j6 = j4;
            final TextStyle textStyle4 = textStyle3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.InputBoxKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit GalleryButtonTip_cf5BqRc$lambda$1;
                    GalleryButtonTip_cf5BqRc$lambda$1 = InputBoxKt.GalleryButtonTip_cf5BqRc$lambda$1(imageSelectedCount, modifier5, j6, textStyle4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GalleryButtonTip_cf5BqRc$lambda$1;
                }
            });
        }
    }
}