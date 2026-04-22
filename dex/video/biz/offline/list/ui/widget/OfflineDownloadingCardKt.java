package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.video.biz.offline.list.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.video.biz.offline.list.ui.generated.resources.Res;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.list.logic.model.OfflineDownloadingCardModel;

/* compiled from: OfflineDownloadingCard.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"OfflineDownloadingCard", "", "cardModel", "Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;", "isEdit", "", "modifier", "Landroidx/compose/ui/Modifier;", "showDivider", "onClickCover", "Lkotlin/Function0;", "(Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;ZLandroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DownloadingContent", "(Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "progressIndicatorColor", "Landroidx/compose/ui/graphics/Color;", "(Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;Landroidx/compose/runtime/Composer;I)J", "stateTextColor", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDownloadingCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadingContent$lambda$1(OfflineDownloadingCardModel offlineDownloadingCardModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DownloadingContent(offlineDownloadingCardModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingCard$lambda$3(OfflineDownloadingCardModel offlineDownloadingCardModel, boolean z, Modifier modifier, boolean z2, Function0 function0, int i, int i2, Composer composer, int i3) {
        OfflineDownloadingCard(offlineDownloadingCardModel, z, modifier, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v11 */
    public static final void OfflineDownloadingCard(final OfflineDownloadingCardModel cardModel, final boolean isEdit, Modifier modifier, boolean showDivider, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        final Function0 onClickCover;
        Composer $composer2;
        Modifier modifier3;
        boolean showDivider2;
        Function0 onClickCover2;
        Modifier modifier4;
        boolean showDivider3;
        Function0 factory$iv$iv$iv;
        Modifier modifier$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(cardModel, "cardModel");
        Composer $composer3 = $composer.startRestartGroup(390705124);
        ComposerKt.sourceInformation($composer3, "C(OfflineDownloadingCard)N(cardModel,isEdit,modifier,showDivider,onClickCover)43@1920L2,45@1961L6,49@2068L129,46@1985L1905:OfflineDownloadingCard.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(cardModel) : $composer3.changedInstance(cardModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(isEdit) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = showDivider;
        } else if (($changed & 3072) == 0) {
            z = showDivider;
            $dirty |= $composer3.changed(z) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            z = showDivider;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            onClickCover = function0;
        } else if (($changed & 24576) == 0) {
            onClickCover = function0;
            $dirty |= $composer3.changedInstance(onClickCover) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            onClickCover = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            showDivider2 = z;
            onClickCover2 = onClickCover;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                showDivider3 = z;
            } else {
                showDivider3 = false;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1805475590, "CC(remember):OfflineDownloadingCard.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineDownloadingCardKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClickCover3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onClickCover = onClickCover3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(390705124, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineDownloadingCard (OfflineDownloadingCard.kt:44)");
            }
            final long dividerColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer3, 1805480453, "CC(remember):OfflineDownloadingCard.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(dividerColor);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineDownloadingCardKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Modifier OfflineDownloadingCard$lambda$1$0;
                        OfflineDownloadingCard$lambda$1$0 = OfflineDownloadingCardKt.OfflineDownloadingCard$lambda$1$0(dividerColor, (Modifier) obj);
                        return OfflineDownloadingCard$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(PaddingKt.padding-3ABfNKs(OfflineComposeExtKt.ifMatch(modifier4, showDivider3, (Function1) it$iv2), Dp.constructor-impl(10)), Dp.constructor-impl(78));
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            boolean showDivider4 = showDivider3;
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            RowScope $this$OfflineDownloadingCard_u24lambda_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1157886796, "C56@2261L1502,95@3772L39,96@3820L64:OfflineDownloadingCard.kt#uys4uf");
            $composer3.startReplaceGroup(175903696);
            ComposerKt.sourceInformation($composer3, "");
            Modifier it = $this$OfflineDownloadingCard_u24lambda_u242.align(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(139)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Alignment.Companion.getCenterVertically());
            if (cardModel.getCanPlay()) {
                $composer3.startReplaceGroup(-781093172);
                ComposerKt.sourceInformation($composer3, "66@2640L78");
                boolean z2 = !isEdit;
                ComposerKt.sourceInformationMarkerStart($composer3, -25192705, "CC(remember):OfflineDownloadingCard.kt#9igjgp");
                boolean invalid$iv2 = (57344 & $dirty2) == 16384;
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineDownloadingCardKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit OfflineDownloadingCard$lambda$2$0$0$0;
                            OfflineDownloadingCard$lambda$2$0$0$0 = OfflineDownloadingCardKt.OfflineDownloadingCard$lambda$2$0$0$0(onClickCover);
                            return OfflineDownloadingCard$lambda$2$0$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                modifier$iv = ClickableKt.clickable-oSLSa3U$default(it, z2, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 14, (Object) null);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-780865353);
                $composer3.endReplaceGroup();
                modifier$iv = it;
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            Modifier modifier$iv$iv = modifier$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            onClickCover2 = onClickCover;
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
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i8 = ((0 >> 6) & 112) | 6;
            BoxScope $this$OfflineDownloadingCard_u24lambda_u242_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 76514408, "C74@2856L175,92@3724L14,90@3571L182:OfflineDownloadingCard.kt#uys4uf");
            String $this$asRequest_u24default$iv = cardModel.getCoverUrl();
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            ImagePlaceHolderKt.ImageWithPlaceHolder(imageRequest.build(), ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), $composer3, 0, 0);
            if (cardModel.getCanPlay()) {
                $composer3.startReplaceGroup(76727997);
                ComposerKt.sourceInformation($composer3, "80@3122L43,79@3085L459");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getDownload_play(Res.drawable.INSTANCE), $composer3, 0), "placeholder", SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default($this$OfflineDownloadingCard_u24lambda_u242_u241.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(6), Dp.constructor-impl(4), 3, (Object) null), Dp.constructor-impl(42), Dp.constructor-impl(38)), (Alignment) null, ContentScale.Companion.getCrop(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer3, Painter.$stable | 24624, 104);
            } else {
                $composer3.startReplaceGroup(73652456);
            }
            $composer3.endReplaceGroup();
            OfflineBadgeKt.OfflineBadgeView(OfflineBadgeKt.toBadgeModel(cardModel.getCardTag(), $composer3, 0), PaddingKt.padding-qDBjuR0$default($this$OfflineDownloadingCard_u24lambda_u242_u241.align(Modifier.Companion, Alignment.Companion.getTopEnd()), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(4), Dp.constructor-impl(4), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 9, (Object) null), $composer3, 0, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            DownloadingContent(cardModel, SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), $composer3, OfflineDownloadingCardModel.$stable | 48 | ($dirty2 & 14), 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            showDivider2 = showDivider4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z3 = showDivider2;
            final Function0 function02 = onClickCover2;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineDownloadingCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineDownloadingCard$lambda$3;
                    OfflineDownloadingCard$lambda$3 = OfflineDownloadingCardKt.OfflineDownloadingCard$lambda$3(OfflineDownloadingCardModel.this, isEdit, modifier5, z3, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineDownloadingCard$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier OfflineDownloadingCard$lambda$1$0(long $dividerColor, Modifier it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BottomDividerKt.m2901drawBottomDividermxwnekA$default(it, false, $dividerColor, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineDownloadingCard$lambda$2$0$0$0(Function0 $onClickCover) {
        $onClickCover.invoke();
        return Unit.INSTANCE;
    }

    public static final void DownloadingContent(final OfflineDownloadingCardModel cardModel, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(cardModel, "cardModel");
        Composer $composer2 = $composer.startRestartGroup(1518258696);
        ComposerKt.sourceInformation($composer2, "C(DownloadingContent)N(cardModel,modifier)105@4026L1600:OfflineDownloadingCard.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(cardModel) : $composer2.changedInstance(cardModel) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1518258696, $dirty, -1, "video.biz.offline.list.ui.widget.DownloadingContent (OfflineDownloadingCard.kt:104)");
            }
            int $changed$iv = ($dirty >> 3) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            Modifier modifier4 = modifier3;
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ColumnScope $this$DownloadingContent_u24lambda_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1114839267, "C108@4136L9,109@4181L6,106@4064L346,115@4419L40,128@4865L44,129@4918L365,141@5340L30,143@5453L33,144@5523L6,146@5607L2,140@5292L328:OfflineDownloadingCard.kt#uys4uf");
            String title = cardModel.getTitle();
            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU();
            int i5 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            String pageTitle = cardModel.getPageTitle();
            TextKt.Text-Nvy7gAk(title, SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), i5, false, pageTitle == null || StringsKt.isBlank(pageTitle) ? 2 : 1, 0, (Function1) null, t14, $composer2, 48, 432, 108536);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), $composer2, 6);
            String pageTitle2 = cardModel.getPageTitle();
            String str = pageTitle2;
            if (!(str == null || StringsKt.isBlank(str))) {
                $composer2.startReplaceGroup(-1114388559);
                ComposerKt.sourceInformation($composer2, "120@4632L9,121@4681L6,118@4558L287");
                $composer$iv = $composer2;
                TextKt.Text-Nvy7gAk(pageTitle2, SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(17), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 24960, 110584);
            } else {
                $composer$iv = $composer2;
                $composer2.startReplaceGroup(-1118919984);
            }
            $composer2.endReplaceGroup();
            SpacerKt.Spacer($this$DownloadingContent_u24lambda_u240.weight(Modifier.Companion, 1.0f, true), $composer2, 0);
            Modifier modifier$iv$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(6), 7, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -387833612, "C135@5164L9,136@5203L25,133@5080L193:OfflineDownloadingCard.kt#uys4uf");
            TextKt.Text-Nvy7gAk(cardModel.getStateDesc(), (Modifier) null, stateTextColor(cardModel, $composer2, OfflineDownloadingCardModel.$stable | ($dirty & 14)), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 0, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1005754576, "CC(remember):OfflineDownloadingCard.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changedInstance(cardModel));
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineDownloadingCardKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        float downloadProgress;
                        downloadProgress = OfflineDownloadingCardModel.this.getDownloadProgress();
                        return Float.valueOf(downloadProgress);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(2));
            long progressIndicatorColor = progressIndicatorColor(cardModel, $composer2, OfflineDownloadingCardModel.$stable | ($dirty & 14));
            long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU();
            float f = Dp.constructor-impl(-1);
            ComposerKt.sourceInformationMarkerStart($composer2, -1005746060, "CC(remember):OfflineDownloadingCard.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineDownloadingCardKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit DownloadingContent$lambda$0$2$0;
                        DownloadingContent$lambda$0$2$0 = OfflineDownloadingCardKt.DownloadingContent$lambda$0$2$0((DrawScope) obj);
                        return DownloadingContent$lambda$0$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(function0, modifier5, progressIndicatorColor, j2, 0, f, (Function1) it$iv2, $composer2, 1769520, 16);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineDownloadingCardKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit DownloadingContent$lambda$1;
                    DownloadingContent$lambda$1 = OfflineDownloadingCardKt.DownloadingContent$lambda$1(OfflineDownloadingCardModel.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DownloadingContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloadingContent$lambda$0$2$0(DrawScope $this$LinearProgressIndicator) {
        Intrinsics.checkNotNullParameter($this$LinearProgressIndicator, "$this$LinearProgressIndicator");
        return Unit.INSTANCE;
    }

    private static final long progressIndicatorColor(OfflineDownloadingCardModel cardModel, Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, -1489691014, "C(progressIndicatorColor)N(cardModel):OfflineDownloadingCard.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1489691014, $changed, -1, "video.biz.offline.list.ui.widget.progressIndicatorColor (OfflineDownloadingCard.kt:153)");
        }
        if (cardModel.getState() instanceof OfflineVideoEntity.State.DOWNLOADING) {
            $composer.startReplaceGroup(512212701);
            ComposerKt.sourceInformation($composer, "154@5811L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(512261371);
            ComposerKt.sourceInformation($composer, "156@5860L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_medium-0d7_KjU();
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }

    private static final long stateTextColor(OfflineDownloadingCardModel cardModel, Composer $composer, int $changed) {
        long j;
        ComposerKt.sourceInformationMarkerStart($composer, -727197698, "C(stateTextColor)N(cardModel):OfflineDownloadingCard.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-727197698, $changed, -1, "video.biz.offline.list.ui.widget.stateTextColor (OfflineDownloadingCard.kt:161)");
        }
        if (cardModel.getState() instanceof OfflineVideoEntity.State.ERROR) {
            $composer.startReplaceGroup(-131452775);
            ComposerKt.sourceInformation($composer, "162@6054L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getStress_red-0d7_KjU();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-131404384);
            ComposerKt.sourceInformation($composer, "164@6103L6");
            j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa5-0d7_KjU();
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }
}