package kntr.app.deepsearch.ui.list;

import ComposableSingletons$CustomBottomSheetKt$;
import android.graphics.Shader;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextPainterKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.deepsearch.ui.cards.FakeThinkingKt;
import kntr.app.deepsearch.ui.colors.DSColorsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.deepsearch.compose.generated.resources.Drawable0_commonMainKt;
import srcs.app.deepsearch.compose.generated.resources.Res;

/* compiled from: ContentHeader.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002"}, d2 = {"ContentHeader", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "chatState", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "thinking", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking;", "modifier", "Landroidx/compose/ui/Modifier;", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AnimatedGradientText", "text", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose_debug", "textWidth", RoomRecommendViewModel.EMPTY_CURSOR, "offset", RoomRecommendViewModel.EMPTY_CURSOR, "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContentHeaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedGradientText$lambda$14(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AnimatedGradientText(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentHeader$lambda$2(String str, DeepSearchPageChatState deepSearchPageChatState, KThinking kThinking, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        ContentHeader(str, deepSearchPageChatState, kThinking, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ContentHeader(final String queryId, final DeepSearchPageChatState chatState, final KThinking thinking, Modifier modifier, final Function1<? super DeepSearchAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(chatState, "chatState");
        Intrinsics.checkNotNullParameter(thinking, "thinking");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Composer $composer4 = $composer.startRestartGroup(-651750798);
        ComposerKt.sourceInformation($composer4, "C(ContentHeader)N(queryId,chatState,thinking,modifier,dispatcher)81@3675L7,82@3717L7,84@3765L162,84@3730L197,91@3933L3781:ContentHeader.kt#4jzcco");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(queryId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(chatState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(thinking) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-651750798, $dirty2, -1, "kntr.app.deepsearch.ui.list.ContentHeader (ContentHeader.kt:80)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final SoftwareKeyboardController soft = (SoftwareKeyboardController) consume;
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final FocusManager focus = (FocusManager) consume2;
            ComposerKt.sourceInformationMarkerStart($composer4, 732718900, "CC(remember):ContentHeader.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer4.changedInstance(chatState);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new ContentHeaderKt$ContentHeader$1$1(queryId, chatState, null);
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(queryId, chatState, (Function2) it$iv, $composer4, ($dirty2 & 14) | ($dirty2 & 112));
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Modifier modifier5 = modifier4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 815162473, "C100@4150L308,96@4030L3265:ContentHeader.kt#4jzcco");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, -1636271952, "CC(remember):ContentHeader.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changedInstance(thinking) | $composer4.changed(soft) | $composer4.changedInstance(focus) | ((57344 & $dirty2) == 16384) | (($dirty2 & 14) == 4);
            Object value$iv2 = $composer4.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                $composer2 = $composer4;
                modifier3 = modifier5;
                value$iv2 = new Function0() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit ContentHeader$lambda$1$0$0;
                        ContentHeader$lambda$1$0$0 = ContentHeaderKt.ContentHeader$lambda$1$0$0(thinking, soft, focus, function1, queryId);
                        return ContentHeader$lambda$1$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
            } else {
                $composer2 = $composer4;
                modifier3 = modifier5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 334331862, "C:ContentHeader.kt#4jzcco");
            boolean animatedAvatar = chatState.avatarAnimated(queryId);
            if (animatedAvatar) {
                $composer$iv.startReplaceGroup(334348663);
                ComposerKt.sourceInformation($composer$iv, "119@5020L77,111@4649L467");
                String $this$asRequest_u24default$iv = Res.INSTANCE.getUri("files/ic_avatar_thinking.gif");
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                ImmutableImageRequest build = imageRequest.build();
                Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(8), 0.0f, 11, (Object) null), Dp.constructor-impl(28)), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1790317851, "CC(remember):ContentHeader.kt#9igjgp");
                Object it$iv2 = $composer$iv.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit unit2;
                            unit2 = Unit.INSTANCE;
                            return unit2;
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer$iv, 0, 508);
                $composer$iv.endReplaceGroup();
            } else {
                $composer$iv.startReplaceGroup(334849158);
                ComposerKt.sourceInformation($composer$iv, "125@5191L39,132@5510L77,124@5154L452");
                Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_avatar(Res.drawable.INSTANCE), $composer$iv, 0);
                Modifier modifier6 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(8), 0.0f, 11, (Object) null), Dp.constructor-impl(28));
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1790302171, "CC(remember):ContentHeader.kt#9igjgp");
                Object it$iv3 = $composer$iv.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit unit2;
                            unit2 = Unit.INSTANCE;
                            return unit2;
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv4);
                    it$iv3 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ImageKt.Image(painterResource, "avatar", ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer$iv, Painter.$stable | 48, 120);
                $composer$iv.endReplaceGroup();
            }
            final String thinkingText = thinking.getThinkingText();
            boolean showThinkingThinkingText = (StringsKt.isBlank(thinkingText) || (thinking.getStatus() instanceof KThinking.KStatus.INVALID)) ? false : true;
            if (showThinkingThinkingText) {
                $composer$iv.startReplaceGroup(335572388);
                ComposerKt.sourceInformation($composer$iv, "146@5985L469,159@6474L235,144@5871L838");
                Boolean valueOf = Boolean.valueOf(showThinkingThinkingText);
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1790286579, "CC(remember):ContentHeader.kt#9igjgp");
                Object it$iv4 = $composer$iv.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            ContentTransform ContentHeader$lambda$1$1$2$0;
                            ContentHeader$lambda$1$1$2$0 = ContentHeaderKt.ContentHeader$lambda$1$1$2$0((AnimatedContentTransitionScope) obj);
                            return ContentHeader$lambda$1$1$2$0;
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv5);
                    it$iv4 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                AnimatedContentKt.AnimatedContent(valueOf, (Modifier) null, (Function1) it$iv4, (Alignment) null, (String) null, (Function1) null, ComposableLambdaKt.rememberComposableLambda(675180131, true, new Function4() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit ContentHeader$lambda$1$1$3;
                        ContentHeader$lambda$1$1$3 = ContentHeaderKt.ContentHeader$lambda$1$1$3(thinkingText, (AnimatedContentScope) obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return ContentHeader$lambda$1$1$3;
                    }
                }, $composer$iv, 54), $composer$iv, 1573248, 58);
                $composer$iv.endReplaceGroup();
            } else {
                if (!StringsKt.isBlank(thinkingText)) {
                    $composer$iv.startReplaceGroup(336450587);
                    ComposerKt.sourceInformation($composer$iv, "167@6778L143");
                    AnimatedGradientText(thinkingText, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer$iv, 48, 0);
                } else {
                    $composer$iv.startReplaceGroup(329738250);
                }
                $composer$iv.endReplaceGroup();
            }
            if (!StringsKt.isBlank(thinking.getThinkingContent())) {
                $composer$iv.startReplaceGroup(336700292);
                ComposerKt.sourceInformation($composer$iv, "174@7058L21,176@7193L6,173@7009L262");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_expand_line_800($composer$iv, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(14)), BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), $composer$iv, Painter.$stable | 432, 0);
            } else {
                $composer$iv.startReplaceGroup(329738250);
            }
            $composer$iv.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            boolean showFakeThinkg = !((thinking.getThinkingText().length() == 0) && Intrinsics.areEqual(thinking.getStatus(), KThinking.KStatus.INVALID.INSTANCE)) && (Intrinsics.areEqual(thinking.getStatus(), KThinking.KStatus.INVALID.INSTANCE) || Intrinsics.areEqual(thinking.getStatus(), KThinking.KStatus.THINKING.INSTANCE));
            if (showFakeThinkg) {
                $composer3 = $composer2;
                $composer3.startReplaceGroup(818564412);
                ComposerKt.sourceInformation($composer3, "187@7584L114");
                FakeThinkingKt.FakeThinking(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(84)), 0.0f, 1, (Object) null), 0.0f, $composer3, 6, 2);
            } else {
                $composer3 = $composer2;
                $composer3.startReplaceGroup(811049702);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContentHeader$lambda$2;
                    ContentHeader$lambda$2 = ContentHeaderKt.ContentHeader$lambda$2(queryId, chatState, thinking, modifier7, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ContentHeader$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentHeader$lambda$1$0$0(KThinking $thinking, SoftwareKeyboardController $soft, FocusManager $focus, Function1 $dispatcher, String $queryId) {
        if (!StringsKt.isBlank($thinking.getThinkingContent())) {
            if ($soft != null) {
                $soft.hide();
            }
            FocusManager.-CC.clearFocus$default($focus, false, 1, (Object) null);
            $dispatcher.invoke(new DeepSearchAction.ThinkPopViewAction.ThinkPopViewShow($queryId));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform ContentHeader$lambda$1$1$2$0(AnimatedContentTransitionScope $this$AnimatedContent) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideIn$default((FiniteAnimationSpec) null, new Function1() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                IntOffset ContentHeader$lambda$1$1$2$0$0;
                ContentHeader$lambda$1$1$2$0$0 = ContentHeaderKt.ContentHeader$lambda$1$1$2$0$0((IntSize) obj);
                return ContentHeader$lambda$1$1$2$0$0;
            }
        }, 1, (Object) null), EnterExitTransitionKt.slideOut$default((FiniteAnimationSpec) null, new Function1() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                IntOffset ContentHeader$lambda$1$1$2$0$1;
                ContentHeader$lambda$1$1$2$0$1 = ContentHeaderKt.ContentHeader$lambda$1$1$2$0$1((IntSize) obj);
                return ContentHeader$lambda$1$1$2$0$1;
            }
        }, 1, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ContentHeader$lambda$1$1$2$0$0(IntSize it) {
        int val2$iv$iv = (int) (it.unbox-impl() & 4294967295L);
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (4294967295L & val2$iv$iv)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ContentHeader$lambda$1$1$2$0$1(IntSize it) {
        int y$iv = -((int) (it.unbox-impl() & 4294967295L));
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (4294967295L & y$iv)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentHeader$lambda$1$1$3(String $thinkingText, AnimatedContentScope $this$AnimatedContent, boolean it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation($composer, "CN(it)162@6589L6,162@6579L32,163@6655L9,160@6496L195:ContentHeader.kt#4jzcco");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(675180131, $changed, -1, "kntr.app.deepsearch.ui.list.ContentHeader.<anonymous>.<anonymous>.<anonymous> (ContentHeader.kt:160)");
        }
        TextKt.Text-Nvy7gAk($thinkingText, (Modifier) null, DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable), DSColorsKt.THINKING_TITLE, $composer, 48), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131066);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x04c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedGradientText(final String text, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        float radius;
        long textColorBlend;
        int $dirty;
        float radius2;
        long textColorStart;
        Paint blendPaint;
        Paint emptyPaint;
        String str;
        Function0 factory$iv$iv;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(1760764624);
        ComposerKt.sourceInformation($composer3, "C(AnimatedGradientText)N(text,modifier)199@7844L7,201@7921L33,203@7985L28,204@8051L317,214@8397L64,214@8374L87,218@8498L6,218@8488L40,219@8562L6,219@8552L38,220@8626L6,220@8616L40,222@8676L22,225@8724L135,232@8899L9,236@8981L64,241@9076L97,247@9203L143,306@11681L1005,254@9352L3334:ContentHeader.kt#4jzcco");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1760764624, $dirty2, -1, "kntr.app.deepsearch.ui.list.AnimatedGradientText (ContentHeader.kt:198)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density = (Density) consume;
            float radius3 = density.toPx-0680j_4(Dp.constructor-impl(50));
            ComposerKt.sourceInformationMarkerStart($composer3, -122304815, "CC(remember):ContentHeader.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableIntState textWidth$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, $composer3, 0, 1);
            final State offset$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, AnimatedGradientText$lambda$2(textWidth$delegate) + (2 * radius3), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(3000, 0, new CubicBezierEasing(0.33f, 0.0f, 0.06f, 1.0f), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null), (String) null, $composer3, InfiniteTransition.$stable | 48 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Float valueOf = Float.valueOf(AnimatedGradientText$lambda$4(offset$delegate));
            ComposerKt.sourceInformationMarkerStart($composer3, -122289552, "CC(remember):ContentHeader.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(offset$delegate);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                radius = radius3;
                Object value$iv2 = (Function2) new ContentHeaderKt$AnimatedGradientText$1$1(offset$delegate, null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                radius = radius3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer3, 0);
            long textColorStart2 = DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_TITLE_P_START, $composer3, 48);
            long textColorEnd = DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_TITLE_P_END, $composer3, 48);
            long textColorBlend2 = DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_TITLE_P_BLEND, $composer3, 48);
            TextMeasurer measure = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, -122279017, "CC(remember):ContentHeader.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                textColorBlend = textColorBlend2;
                Object value$iv3 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(textColorStart2), Color.box-impl(textColorEnd)}), 0.0f, 0.0f, 0, 14, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            } else {
                textColorBlend = textColorBlend2;
            }
            final Brush brush = (Brush) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextStyle textStyle = TextStyle.copy-Ns73l9s$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), brush, 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -122270864, "CC(remember):ContentHeader.kt#9igjgp");
            Object value$iv4 = $composer3.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv4);
            }
            final MutableState layoutResult$delegate = (MutableState) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -122267791, "CC(remember):ContentHeader.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Paint $this$AnimatedGradientText_u24lambda_u2410_u240 = AndroidPaint_androidKt.Paint();
                $this$AnimatedGradientText_u24lambda_u2410_u240.setAntiAlias(true);
                $composer3.updateRememberedValue($this$AnimatedGradientText_u24lambda_u2410_u240);
                it$iv4 = $this$AnimatedGradientText_u24lambda_u2410_u240;
            }
            Paint emptyPaint2 = (Paint) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -122263681, "CC(remember):ContentHeader.kt#9igjgp");
            Object value$iv5 = $composer3.rememberedValue();
            if (value$iv5 == Composer.Companion.getEmpty()) {
                Paint $this$AnimatedGradientText_u24lambda_u2411_u240 = AndroidPaint_androidKt.Paint();
                $this$AnimatedGradientText_u24lambda_u2411_u240.setAntiAlias(true);
                $this$AnimatedGradientText_u24lambda_u2411_u240.setBlendMode-s9anfk8(BlendMode.Companion.getSrcAtop-0nO6VwU());
                value$iv5 = $this$AnimatedGradientText_u24lambda_u2411_u240;
                $composer3.updateRememberedValue(value$iv5);
            }
            Paint blendPaint2 = (Paint) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -122183523, "CC(remember):ContentHeader.kt#9igjgp");
            int $dirty3 = $dirty2;
            boolean invalid$iv2 = $composer3.changed(measure) | (($dirty2 & 14) == 4) | $composer3.changed(textStyle);
            Object value$iv6 = $composer3.rememberedValue();
            if (invalid$iv2 || value$iv6 == Composer.Companion.getEmpty()) {
                $dirty = $dirty3;
                radius2 = radius;
                textColorStart = textColorBlend;
                blendPaint = blendPaint2;
                emptyPaint = emptyPaint2;
                str = "CC(remember):ContentHeader.kt#9igjgp";
                $composer2 = $composer3;
                value$iv6 = new ContentHeaderKt$AnimatedGradientText$2$1(measure, text, textStyle, layoutResult$delegate, textWidth$delegate);
                $composer3.updateRememberedValue(value$iv6);
            } else {
                blendPaint = blendPaint2;
                $composer2 = $composer3;
                str = "CC(remember):ContentHeader.kt#9igjgp";
                $dirty = $dirty3;
                emptyPaint = emptyPaint2;
                radius2 = radius;
                textColorStart = textColorBlend;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = $dirty & 112;
            Modifier modifier$iv = modifier3;
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer$iv.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -868185254, "C259@9494L2169,257@9421L2242:ContentHeader.kt#4jzcco");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1080374944, str);
            final Paint emptyPaint3 = emptyPaint;
            final Paint blendPaint3 = blendPaint;
            boolean invalid$iv3 = $composer$iv.changedInstance(emptyPaint3) | $composer$iv.changedInstance(blendPaint3) | $composer$iv.changed(radius2) | $composer$iv.changed(offset$delegate) | $composer$iv.changed(textColorStart);
            Object it$iv5 = $composer$iv.rememberedValue();
            if (!invalid$iv3 && it$iv5 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                CanvasKt.Canvas(fillMaxSize$default, (Function1) it$iv5, $composer$iv, 6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            final float f = radius2;
            final long j2 = textColorStart;
            Object value$iv7 = new Function1() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit AnimatedGradientText$lambda$13$0$0;
                    AnimatedGradientText$lambda$13$0$0 = ContentHeaderKt.AnimatedGradientText$lambda$13$0$0(layoutResult$delegate, emptyPaint3, brush, blendPaint3, f, j2, offset$delegate, (DrawScope) obj);
                    return AnimatedGradientText$lambda$13$0$0;
                }
            };
            $composer$iv.updateRememberedValue(value$iv7);
            it$iv5 = value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            CanvasKt.Canvas(fillMaxSize$default, (Function1) it$iv5, $composer$iv, 6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.list.ContentHeaderKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AnimatedGradientText$lambda$14;
                    AnimatedGradientText$lambda$14 = ContentHeaderKt.AnimatedGradientText$lambda$14(text, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AnimatedGradientText$lambda$14;
                }
            });
        }
    }

    private static final int AnimatedGradientText$lambda$2(MutableIntState $textWidth$delegate) {
        IntState $this$getValue$iv = (IntState) $textWidth$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float AnimatedGradientText$lambda$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final TextLayoutResult AnimatedGradientText$lambda$8(MutableState<TextLayoutResult> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TextLayoutResult) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedGradientText$lambda$13$0$0(MutableState $layoutResult$delegate, Paint $emptyPaint, Brush $brush, Paint $blendPaint, float $radius, long $textColorBlend, State $offset$delegate, DrawScope $this$Canvas) {
        Canvas $this$withSaveLayer$iv;
        Canvas $this$withSaveLayer$iv2;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        if (AnimatedGradientText$lambda$8($layoutResult$delegate) != null) {
            Canvas it = $this$Canvas.getDrawContext().getCanvas();
            Rect bounds$iv = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), $this$Canvas.getSize-NH-jbRc());
            try {
                it.saveLayer(bounds$iv, $emptyPaint);
                TextLayoutResult AnimatedGradientText$lambda$8 = AnimatedGradientText$lambda$8($layoutResult$delegate);
                Intrinsics.checkNotNull(AnimatedGradientText$lambda$8);
                $this$withSaveLayer$iv = it;
                try {
                    TextPainterKt.drawText-LVfH_YU$default($this$Canvas, AnimatedGradientText$lambda$8, $brush, 0L, 0.0f, (Shadow) null, (TextDecoration) null, (DrawStyle) null, 0, 252, (Object) null);
                    Rect bounds$iv2 = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), $this$Canvas.getSize-NH-jbRc());
                    try {
                        it.saveLayer(bounds$iv2, $blendPaint);
                        float x$iv = (-$radius) + AnimatedGradientText$lambda$4($offset$delegate);
                        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() & 4294967295L);
                        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv) / 2;
                        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
                        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                        long center = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                        Shader radialGradientShader = ShaderKt.RadialGradientShader-8uybcMk$default(center, $radius, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default($textColorBlend, 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default($textColorBlend, 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default($textColorBlend, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.5f), Float.valueOf(1.0f)}), 0, 16, (Object) null);
                        $this$withSaveLayer$iv2 = it;
                        try {
                            DrawScope.-CC.drawCircle-V9BoPsw$default($this$Canvas, BrushKt.ShaderBrush(radialGradientShader), $radius, center, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
                            $this$withSaveLayer$iv2.restore();
                            $this$withSaveLayer$iv.restore();
                        } catch (Throwable th) {
                            th = th;
                            $this$withSaveLayer$iv2.restore();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        $this$withSaveLayer$iv2 = it;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    $this$withSaveLayer$iv.restore();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                $this$withSaveLayer$iv = it;
            }
        }
        return Unit.INSTANCE;
    }
}