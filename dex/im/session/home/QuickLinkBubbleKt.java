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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.session.IMActionExposureQuickLinkBubble;
import java.util.Map;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.trio.priority.BaselineOffsetCalculator;
import kntr.common.trio.priority.ComposePriorityHorizonKt;
import kntr.common.trio.priority.PriorityHorizonPolicy;
import kntr.common.trio.priority.PriorityHorizontalScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.im.session.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.im.session.ui.generated.resources.Res;

/* compiled from: QuickLinkBubble.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"NotifyBubble", "", "state", "Lim/session/home/QuickLinkState;", "(Lim/session/home/QuickLinkState;Landroidx/compose/runtime/Composer;I)V", "NotifyBubbleContent", "bubble", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;", "(Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;Lim/session/home/QuickLinkState;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class QuickLinkBubbleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubble$lambda$5(QuickLinkState quickLinkState, int i2, Composer composer, int i3) {
        NotifyBubble(quickLinkState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubbleContent$lambda$1(KQuickLinkBubble kQuickLinkBubble, QuickLinkState quickLinkState, int i2, Composer composer, int i3) {
        NotifyBubbleContent(kQuickLinkBubble, quickLinkState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void NotifyBubble(final QuickLinkState state, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(774868181);
        ComposerKt.sourceInformation($composer2, "C(NotifyBubble)N(state)58@2445L24:QuickLinkBubble.kt#kfobb3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(774868181, $dirty, -1, "im.session.home.NotifyBubble (QuickLinkBubble.kt:52)");
            }
            KQuickLinkBubble bubble = state.getBubble();
            $composer2.startReplaceGroup(1618983000);
            ComposerKt.sourceInformation($composer2, "*56@2368L7");
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Rect centerAt = state.centerOfWithPadding((Density) consume, bubble != null ? bubble.getQuickLinkItem() : null);
            $composer2.endReplaceGroup();
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
            if (bubble == null || centerAt == null) {
                $composer2.startReplaceGroup(-1353448979);
            } else {
                $composer2.startReplaceGroup(-1350922665);
                ComposerKt.sourceInformation($composer2, "64@2641L98,66@2750L86,60@2524L889,85@3433L89,85@3422L100");
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1618992983, "CC(remember):QuickLinkBubble.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(centerAt);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            IntOffset NotifyBubble$lambda$1$0;
                            NotifyBubble$lambda$1$0 = QuickLinkBubbleKt.NotifyBubble$lambda$1$0(centerAt, (Density) obj);
                            return NotifyBubble$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier offset = OffsetKt.offset(fillMaxWidth$default, (Function1) it$iv);
                ComposerKt.sourceInformationMarkerStart($composer2, 1618996459, "CC(remember):QuickLinkBubble.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(scope) | (($dirty & 14) == 4);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit NotifyBubble$lambda$2$0;
                            NotifyBubble$lambda$2$0 = QuickLinkBubbleKt.NotifyBubble$lambda$2$0(scope, state);
                            return NotifyBubble$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(offset, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                int bits$iv$iv$iv = (int) (centerAt.getCenter-F1C5BW0() >> 32);
                int width$iv = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv));
                Alignment contentAlignment$iv = new CenterAt(IntSize.constructor-impl((0 & 4294967295L) | (width$iv << 32)), null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
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
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 470607271, "C71@2947L98,77@3092L52,82@3371L6,76@3059L344:QuickLinkBubble.kt#kfobb3");
                NotifyBubbleContent(bubble, state, $composer2, ($dirty << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_auto_reply_arrow_up(Res.drawable.INSTANCE), $composer2, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(14), Dp.constructor-impl(6)), (Alignment) null, (ContentScale) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | 432, 56);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1619018318, "CC(remember):QuickLinkBubble.kt#9igjgp");
                boolean invalid$iv3 = ($dirty & 14) == 4;
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit NotifyBubble$lambda$4$0;
                            NotifyBubble$lambda$4$0 = QuickLinkBubbleKt.NotifyBubble$lambda$4$0(QuickLinkState.this);
                            return NotifyBubble$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.SideEffect((Function0) it$iv3, $composer2, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotifyBubble$lambda$5;
                    NotifyBubble$lambda$5 = QuickLinkBubbleKt.NotifyBubble$lambda$5(QuickLinkState.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return NotifyBubble$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset NotifyBubble$lambda$1$0(Rect $centerAt, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = MathKt.roundToInt($centerAt.getBottom());
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubble$lambda$2$0(CoroutineScope $scope, QuickLinkState $state) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new QuickLinkBubbleKt$NotifyBubble$2$1$1($state, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubble$lambda$4$0(QuickLinkState $state) {
        $state.getEventHandler().getActionHandler().invoke(IMActionExposureQuickLinkBubble.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void NotifyBubbleContent(final KQuickLinkBubble bubble, final QuickLinkState state, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer3 = $composer.startRestartGroup(-914059416);
        ComposerKt.sourceInformation($composer3, "C(NotifyBubbleContent)N(bubble,state)96@3643L3397:QuickLinkBubble.kt#kfobb3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(bubble) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(state) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-914059416, $dirty, -1, "im.session.home.NotifyBubbleContent (QuickLinkBubble.kt:95)");
            }
            Modifier modifier$iv = ShadowKt.shadow-s4CzXII$default(SizeKt.wrapContentSize$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(6), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null), (Alignment) null, false, 3, (Object) null), Dp.constructor-impl(16), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 331712648, "C106@3944L6,103@3841L3193:QuickLinkBubble.kt#kfobb3");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(10), Dp.constructor-impl(6));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 497701883, "C111@4198L269,122@4522L76,129@4820L1829,125@4611L2038,174@6708L20,175@6763L6,178@6875L79,173@6663L361:QuickLinkBubble.kt#kfobb3");
            String $this$asRequest_u24default$iv = bubble.getAvatar();
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), RoundedCornerShapeKt.getCircleShape()), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            ComposerKt.sourceInformationMarkerStart($composer3, 708799178, "CC(remember):QuickLinkBubble.kt#9igjgp");
            Object value$iv = $composer3.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = new BaselineOffsetCalculator(2);
                $composer3.updateRememberedValue(value$iv);
            }
            final BaselineOffsetCalculator baselineCalculator = (BaselineOffsetCalculator) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposePriorityHorizonKt.PriorityHorizon(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(168), 1, (Object) null), PriorityHorizonPolicy.CENTER, Alignment.Companion.getCenterVertically(), ComposableLambdaKt.rememberComposableLambda(1887666195, true, new Function3() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit NotifyBubbleContent$lambda$0$0$1;
                    NotifyBubbleContent$lambda$0$0$1 = QuickLinkBubbleKt.NotifyBubbleContent$lambda$0$0$1(bubble, baselineCalculator, (PriorityHorizontalScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return NotifyBubbleContent$lambda$0$0$1;
                }
            }, $composer3, 54), $composer3, 3510, 0);
            Painter xmark_close_line_900 = BiliIconfont.INSTANCE.getXmark_close_line_900($composer3, 6);
            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_medium-0d7_KjU();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, 708874477, "CC(remember):QuickLinkBubble.kt#9igjgp");
            boolean invalid$iv = ($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit NotifyBubbleContent$lambda$0$0$2$0;
                        NotifyBubbleContent$lambda$0$0$2$0 = QuickLinkBubbleKt.NotifyBubbleContent$lambda$0$0$2$0(QuickLinkState.this);
                        return NotifyBubbleContent$lambda$0$0$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(xmark_close_line_900, (String) null, SizeKt.size-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(12)), j, $composer3, Painter.$stable | 48, 0);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotifyBubbleContent$lambda$1;
                    NotifyBubbleContent$lambda$1 = QuickLinkBubbleKt.NotifyBubbleContent$lambda$1(bubble, state, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return NotifyBubbleContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubbleContent$lambda$0$0$1(final KQuickLinkBubble $bubble, final BaselineOffsetCalculator $baselineCalculator, PriorityHorizontalScope $this$PriorityHorizon, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$PriorityHorizon, "$this$PriorityHorizon");
        ComposerKt.sourceInformation($composer, "C132@4926L6,133@4978L9,139@5225L7,145@5534L218,130@4838L933,154@5875L6,155@5927L9,161@6174L7,167@6482L134,152@5788L847:QuickLinkBubble.kt#kfobb3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1887666195, $changed, -1, "im.session.home.NotifyBubbleContent.<anonymous>.<anonymous>.<anonymous> (QuickLinkBubble.kt:130)");
        }
        String nickName = $bubble.getNickName();
        long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
        TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
        Modifier priority = $this$PriorityHorizon.priority(Modifier.Companion, 0);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$NotifyBubbleContent_u24lambda_u240_u240_u241_u240 = (Density) consume;
        Float f2 = (Float) ((Map) $baselineCalculator.getOffset().getValue()).get($bubble.getNickName());
        Modifier modifier = OffsetKt.offset-VpY3zN4$default(priority, (float) CropImageView.DEFAULT_ASPECT_RATIO, f2 != null ? $this$NotifyBubbleContent_u24lambda_u240_u240_u241_u240.toDp-u2uoSUM(f2.floatValue()) : Dp.constructor-impl(0), 1, (Object) null);
        int i2 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        ComposerKt.sourceInformationMarkerStart($composer, 1571037549, "CC(remember):QuickLinkBubble.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($baselineCalculator) | $composer.changedInstance($bubble);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit NotifyBubbleContent$lambda$0$0$1$1$0;
                    NotifyBubbleContent$lambda$0$0$1$1$0 = QuickLinkBubbleKt.NotifyBubbleContent$lambda$0$0$1$1$0($baselineCalculator, $bubble, (TextLayoutResult) obj);
                    return NotifyBubbleContent$lambda$0$0$1$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        TextKt.Text-Nvy7gAk(nickName, modifier, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i2, false, 1, 0, (Function1) it$iv, t12, $composer, 0, 24960, 45048);
        String content = $bubble.getContent();
        long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
        TextStyle t122 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
        Modifier priority2 = $this$PriorityHorizon.priority(Modifier.Companion, 1);
        CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(this_$iv2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$NotifyBubbleContent_u24lambda_u240_u240_u241_u242 = (Density) consume2;
        Float f3 = (Float) ((Map) $baselineCalculator.getOffset().getValue()).get($bubble.getContent());
        Modifier modifier2 = OffsetKt.offset-VpY3zN4$default(priority2, (float) CropImageView.DEFAULT_ASPECT_RATIO, f3 != null ? $this$NotifyBubbleContent_u24lambda_u240_u240_u241_u242.toDp-u2uoSUM(f3.floatValue()) : Dp.constructor-impl(0), 1, (Object) null);
        int i3 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        ComposerKt.sourceInformationMarkerStart($composer, 1571067801, "CC(remember):QuickLinkBubble.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance($baselineCalculator) | $composer.changedInstance($bubble);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function1() { // from class: im.session.home.QuickLinkBubbleKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit NotifyBubbleContent$lambda$0$0$1$3$0;
                    NotifyBubbleContent$lambda$0$0$1$3$0 = QuickLinkBubbleKt.NotifyBubbleContent$lambda$0$0$1$3$0($baselineCalculator, $bubble, (TextLayoutResult) obj);
                    return NotifyBubbleContent$lambda$0$0$1$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        TextKt.Text-Nvy7gAk(content, modifier2, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i3, false, 1, 0, (Function1) it$iv2, t122, $composer, 0, 24960, 45048);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubbleContent$lambda$0$0$1$1$0(BaselineOffsetCalculator $baselineCalculator, KQuickLinkBubble $bubble, TextLayoutResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        $baselineCalculator.onTextLayout($bubble.getNickName(), result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubbleContent$lambda$0$0$1$3$0(BaselineOffsetCalculator $baselineCalculator, KQuickLinkBubble $bubble, TextLayoutResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        $baselineCalculator.onTextLayout($bubble.getContent(), result);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyBubbleContent$lambda$0$0$2$0(QuickLinkState $state) {
        $state.onBubbleDismiss();
        return Unit.INSTANCE;
    }
}