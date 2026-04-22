package im.session.home;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.session.IMActionDismissAutoReply;
import im.session.common.IMSessionEventHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.im.session.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.im.session.ui.generated.resources.Res;

/* compiled from: AutoReplyBubble.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"AutoReplyBubble", "", "Landroidx/compose/foundation/layout/BoxScope;", "bubbleContent", "Lcom/bapis/bilibili/app/im/v1/KAutoReplyToast;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/bapis/bilibili/app/im/v1/KAutoReplyToast;Lim/session/common/IMSessionEventHandler;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AutoReplyBubbleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyBubble$lambda$1(BoxScope boxScope, KAutoReplyToast kAutoReplyToast, IMSessionEventHandler iMSessionEventHandler, int i2, Composer composer, int i3) {
        AutoReplyBubble(boxScope, kAutoReplyToast, iMSessionEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0253, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x05b3, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AutoReplyBubble(final BoxScope $this$AutoReplyBubble, final KAutoReplyToast bubbleContent, final IMSessionEventHandler eventHandler, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter($this$AutoReplyBubble, "<this>");
        Intrinsics.checkNotNullParameter(bubbleContent, "bubbleContent");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer3 = $composer.startRestartGroup(-2048940837);
        ComposerKt.sourceInformation($composer3, "C(AutoReplyBubble)N(bubbleContent,eventHandler)49@2152L24,56@2363L10,56@2374L17,50@2181L3041:AutoReplyBubble.kt#kfobb3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed($this$AutoReplyBubble) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(bubbleContent) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 256 : 128;
        }
        if ($composer3.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2048940837, $dirty, -1, "im.session.home.AutoReplyBubble (AutoReplyBubble.kt:47)");
            }
            long bgColor = Color.copy-wmQWz5c$default(BiliColorsSourceKt.getDayColors().getGa9-0d7_KjU(), 0.9f, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = OffsetKt.offset-VpY3zN4($this$AutoReplyBubble.align(Modifier.Companion, Alignment.Companion.getTopEnd()), Dp.constructor-impl(-36), Dp.constructor-impl(WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer3, 6), $composer3, 0).calculateTopPadding-D9Ej5fM() + Dp.constructor-impl(14)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            BoxScope $this$AutoReplyBubble_u24lambda_u240 = boxScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -890403140, "C64@2639L245,59@2458L2503,122@4999L47,121@4970L246:AutoReplyBubble.kt#kfobb3");
            Modifier height = IntrinsicKt.height($this$AutoReplyBubble_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomStart()), IntrinsicSize.Max);
            ComposerKt.sourceInformationMarkerStart($composer3, 1079659254, "CC(remember):AutoReplyBubble.kt#9igjgp");
            boolean invalid$iv = (($dirty & 896) == 256) | $composer3.changedInstance(scope) | $composer3.changedInstance(bubbleContent);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: im.session.home.AutoReplyBubbleKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit AutoReplyBubble$lambda$0$0$0;
                    AutoReplyBubble$lambda$0$0$0 = AutoReplyBubbleKt.AutoReplyBubble$lambda$0$0$0(scope, eventHandler, bubbleContent);
                    return AutoReplyBubble$lambda$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(height, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            int $changed$iv$iv$iv2 = ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, $changed$iv$iv$iv2);
            int $changed$iv$iv2 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i4 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$AutoReplyBubble_u24lambda_u240_u241 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 1774973061, "C71@2910L1515,109@4471L49,108@4438L513:AutoReplyBubble.kt#kfobb3");
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(BackgroundKt.background-bw27NRU(Modifier.Companion, bgColor, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(17), Dp.constructor-impl(0), Dp.constructor-impl(17), Dp.constructor-impl(17))), Dp.constructor-impl(34)), Dp.constructor-impl(10), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv3 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i7 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 33064163, "C90@3744L6,91@3801L9,88@3652L298,98@4017L20,99@4076L6,102@4217L116,97@3968L443:AutoReplyBubble.kt#kfobb3");
            TextKt.Text-Nvy7gAk(bubbleContent.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(40), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 48, 0, 131064);
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer3, 6);
            long j = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0.6f, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 14, (Object) null);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, -1938578627, "CC(remember):AutoReplyBubble.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 896) == 256;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: im.session.home.AutoReplyBubbleKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit AutoReplyBubble$lambda$0$1$0$0$0;
                    AutoReplyBubble$lambda$0$1$0$0$0 = AutoReplyBubbleKt.AutoReplyBubble$lambda$0$1$0$0$0(IMSessionEventHandler.this);
                    return AutoReplyBubble$lambda$0$1$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(xmark_close_line_500, (String) null, SizeKt.size-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Dp.constructor-impl(12)), j, $composer3, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_auto_reply_arrow(Res.drawable.INSTANCE), $composer3, 0), (String) null, $this$AutoReplyBubble_u24lambda_u240_u241.align(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Alignment.Companion.getTop()), Alignment.Companion.getTopCenter(), ContentScale.Companion.getFit(), (float) CropImageView.DEFAULT_ASPECT_RATIO, ColorFilter.Companion.tint-xETnrds(bgColor, BlendMode.Companion.getSrcIn-0nO6VwU()), $composer3, Painter.$stable | 27696, 32);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_auto_reply_img(Res.drawable.INSTANCE), $composer3, 0), (String) null, OffsetKt.offset-VpY3zN4$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(42)), Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, $composer3, Painter.$stable | 432, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.AutoReplyBubbleKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AutoReplyBubble$lambda$1;
                    AutoReplyBubble$lambda$1 = AutoReplyBubbleKt.AutoReplyBubble$lambda$1($this$AutoReplyBubble, bubbleContent, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AutoReplyBubble$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyBubble$lambda$0$0$0(CoroutineScope $scope, IMSessionEventHandler $eventHandler, KAutoReplyToast $bubbleContent) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new AutoReplyBubbleKt$AutoReplyBubble$1$1$1$1($eventHandler, $bubbleContent, null), 3, (Object) null);
        $eventHandler.getActionHandler().invoke(IMActionDismissAutoReply.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyBubble$lambda$0$1$0$0$0(IMSessionEventHandler $eventHandler) {
        $eventHandler.getActionHandler().invoke(IMActionDismissAutoReply.INSTANCE);
        return Unit.INSTANCE;
    }
}