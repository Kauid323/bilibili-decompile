package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.reachability.KReachabilityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;

/* compiled from: OfflineCompletedCard.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"OfflineCompletedCard", "", "cardModel", "Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;", "modifier", "Landroidx/compose/ui/Modifier;", "showDivider", "", "(Lvideo/biz/offline/list/logic/model/OfflineCachedCardModel;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineCompletedCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedCard$lambda$2(OfflineCachedCardModel offlineCachedCardModel, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        OfflineCompletedCard(offlineCachedCardModel, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x0654, code lost:
        if (r8.changedInstance(r6) != false) goto L131;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x06e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OfflineCompletedCard(final OfflineCachedCardModel cardModel, Modifier modifier, boolean showDivider, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean showDivider2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        boolean showDivider3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ImmutableImageRequest build;
        Function0 factory$iv$iv$iv3;
        BoxScope $this$OfflineCompletedCard_u24lambda_u241_u240;
        Function0 factory$iv$iv$iv4;
        Composer $composer3;
        Composer $composer$iv;
        String text;
        long j;
        Function0 factory$iv$iv$iv5;
        final OfflineCachedCardModel offlineCachedCardModel;
        boolean invalid$iv;
        Object it$iv;
        Object it$iv2;
        Intrinsics.checkNotNullParameter(cardModel, "cardModel");
        Composer $composer4 = $composer.startRestartGroup(1813257226);
        ComposerKt.sourceInformation($composer4, "C(OfflineCompletedCard)N(cardModel,modifier,showDivider)44@1769L6,48@1876L82,45@1793L5497:OfflineCompletedCard.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer4.changed(cardModel) : $composer4.changedInstance(cardModel) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            showDivider2 = showDivider;
        } else if (($changed & 384) == 0) {
            showDivider2 = showDivider;
            $dirty |= $composer4.changed(showDivider2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            showDivider2 = showDivider;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                showDivider3 = showDivider2;
            } else {
                showDivider3 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1813257226, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineCompletedCard (OfflineCompletedCard.kt:43)");
            }
            final long dividerColor = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer4, -1216519012, "CC(remember):OfflineCompletedCard.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changed(dividerColor);
            Object it$iv3 = $composer4.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineCompletedCardKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Modifier OfflineCompletedCard$lambda$0$0;
                        OfflineCompletedCard$lambda$0$0 = OfflineCompletedCardKt.OfflineCompletedCard$lambda$0$0(dividerColor, (Modifier) obj);
                        return OfflineCompletedCard$lambda$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
                it$iv3 = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(PaddingKt.padding-3ABfNKs(OfflineComposeExtKt.ifMatch(modifier4, showDivider3, (Function1) it$iv3), Dp.constructor-impl(10)), Dp.constructor-impl(78));
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            modifier3 = modifier4;
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            boolean showDivider4 = showDivider3;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            RowScope $this$OfflineCompletedCard_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1282822248, "C54@2039L2912,124@4960L39,126@5024L2260:OfflineCompletedCard.kt#uys4uf");
            Modifier modifier$iv2 = ClipKt.clip($this$OfflineCompletedCard_u24lambda_u241.align(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(139)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Alignment.Companion.getCenterVertically()), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)));
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            BoxScope $this$OfflineCompletedCard_u24lambda_u241_u2402 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1492331366, "C62@2296L342,72@2682L1498,121@4912L14,119@4759L182:OfflineCompletedCard.kt#uys4uf");
            if (KReachabilityKt.getKReachability().isReachable()) {
                String $this$asRequest_u24default$iv = cardModel.getCoverUrl();
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                build = imageRequest.build();
            } else {
                String $this$asRequest_u24default$iv2 = ImagePlaceHolderKt.fileToUri(cardModel.getCoverPath());
                ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                Unit unit2 = Unit.INSTANCE;
                build = imageRequest2.build();
            }
            ImagePlaceHolderKt.ImageWithPlaceHolder(build, SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), $composer4, 48, 0);
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-3ABfNKs($this$OfflineCompletedCard_u24lambda_u241_u2402.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), Dp.constructor-impl(4)), Dp.constructor-impl(15)), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int $i$f$Row = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, $i$f$Row);
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i9 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -433843173, "C:OfflineCompletedCard.kt#uys4uf");
            if (cardModel.getChildCount() > 1) {
                $composer4.startReplaceGroup(-433824016);
                ComposerKt.sourceInformation($composer4, "86@3295L22,87@3360L6,85@3242L266,91@3529L39,94@3701L9,95@3758L6,92@3589L247");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getVideo_archive_fill_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_white-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer4, 6);
                TextKt.Text-Nvy7gAk(String.valueOf(cardModel.getChildCount()), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10(), $composer4, 0, 24576, 114682);
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(-433151812);
                ComposerKt.sourceInformation($composer4, "102@4013L9,103@4070L6,100@3910L238");
                TextKt.Text-Nvy7gAk(cardModel.getProgressDesc(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10(), $composer4, 0, 24576, 114682);
                $composer4.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (cardModel.getChildCount() != 1 || cardModel.getProgressPercent() <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                $this$OfflineCompletedCard_u24lambda_u241_u240 = $this$OfflineCompletedCard_u24lambda_u241_u2402;
                $composer4.startReplaceGroup(-1494691986);
            } else {
                $composer4.startReplaceGroup(-1490430788);
                ComposerKt.sourceInformation($composer4, "111@4354L55,113@4548L6,116@4711L2,110@4298L434");
                ComposerKt.sourceInformationMarkerStart($composer4, -1572097109, "CC(remember):OfflineCompletedCard.kt#9igjgp");
                if (($dirty2 & 14) != 4) {
                    if (($dirty2 & 8) != 0) {
                        offlineCachedCardModel = cardModel;
                    } else {
                        offlineCachedCardModel = cardModel;
                    }
                    invalid$iv = false;
                    it$iv = $composer4.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCompletedCardKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                float OfflineCompletedCard$lambda$1$0$1$0;
                                OfflineCompletedCard$lambda$1$0$1$0 = OfflineCompletedCardKt.OfflineCompletedCard$lambda$1$0$1$0(OfflineCachedCardModel.this);
                                return Float.valueOf(OfflineCompletedCard$lambda$1$0$1$0);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv2);
                        it$iv = value$iv2;
                    }
                    Function0 function0 = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $this$OfflineCompletedCard_u24lambda_u241_u240 = $this$OfflineCompletedCard_u24lambda_u241_u2402;
                    Modifier align = $this$OfflineCompletedCard_u24lambda_u241_u240.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(2)), Alignment.Companion.getBottomCenter());
                    long j2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    long j3 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null);
                    float f = Dp.constructor-impl(-1);
                    ComposerKt.sourceInformationMarkerStart($composer4, -1572085738, "CC(remember):OfflineCompletedCard.kt#9igjgp");
                    it$iv2 = $composer4.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineCompletedCardKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                Unit OfflineCompletedCard$lambda$1$0$2$0;
                                OfflineCompletedCard$lambda$1$0$2$0 = OfflineCompletedCardKt.OfflineCompletedCard$lambda$1$0$2$0((DrawScope) obj);
                                return OfflineCompletedCard$lambda$1$0$2$0;
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                        it$iv2 = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(function0, align, j2, j3, 0, f, (Function1) it$iv2, $composer4, 1772544, 16);
                } else {
                    offlineCachedCardModel = cardModel;
                }
                invalid$iv = true;
                it$iv = $composer4.rememberedValue();
                if (!invalid$iv) {
                }
                Object value$iv22 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineCompletedCardKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        float OfflineCompletedCard$lambda$1$0$1$0;
                        OfflineCompletedCard$lambda$1$0$1$0 = OfflineCompletedCardKt.OfflineCompletedCard$lambda$1$0$1$0(OfflineCachedCardModel.this);
                        return Float.valueOf(OfflineCompletedCard$lambda$1$0$1$0);
                    }
                };
                $composer4.updateRememberedValue(value$iv22);
                it$iv = value$iv22;
                Function0 function02 = (Function0) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $this$OfflineCompletedCard_u24lambda_u241_u240 = $this$OfflineCompletedCard_u24lambda_u241_u2402;
                Modifier align2 = $this$OfflineCompletedCard_u24lambda_u241_u240.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(2)), Alignment.Companion.getBottomCenter());
                long j22 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                long j32 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null);
                float f2 = Dp.constructor-impl(-1);
                ComposerKt.sourceInformationMarkerStart($composer4, -1572085738, "CC(remember):OfflineCompletedCard.kt#9igjgp");
                it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ProgressIndicatorKt.LinearProgressIndicator-GJbTh5U(function02, align2, j22, j32, 0, f2, (Function1) it$iv2, $composer4, 1772544, 16);
            }
            $composer4.endReplaceGroup();
            OfflineBadgeKt.OfflineBadgeView(OfflineBadgeKt.toBadgeModel(cardModel.getCardTag(), $composer4, 0), PaddingKt.padding-qDBjuR0$default($this$OfflineCompletedCard_u24lambda_u241_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd()), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(4), Dp.constructor-impl(4), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 9, (Object) null), $composer4, 0, 0);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer4, 6);
            Modifier modifier$iv4 = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer4.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i11 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$OfflineCompletedCard_u24lambda_u241_u241 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1497118945, "C131@5237L9,132@5286L6,128@5098L377,149@5943L51,177@7121L9,175@7052L222:OfflineCompletedCard.kt#uys4uf");
            String title = cardModel.getTitle();
            Modifier modifier5 = SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14();
            long j4 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa10-0d7_KjU();
            String subTitle = cardModel.getSubTitle();
            TextKt.Text-Nvy7gAk(title, modifier5, j4, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, subTitle == null || StringsKt.isBlank(subTitle) ? 2 : 1, 0, (Function1) null, t14, $composer4, 48, 432, 108536);
            String subTitle2 = cardModel.getSubTitle();
            String str = subTitle2;
            if (!(str == null || StringsKt.isBlank(str))) {
                $composer4.startReplaceGroup(-1496676700);
                ComposerKt.sourceInformation($composer4, "143@5746L9,144@5799L6,140@5602L314");
                $composer2 = $composer4;
                TextKt.Text-Nvy7gAk(subTitle2, SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(17), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 48, 24960, 110584);
            } else {
                $composer2 = $composer4;
                $composer4.startReplaceGroup(-1502244610);
            }
            $composer4.endReplaceGroup();
            SpacerKt.Spacer($this$OfflineCompletedCard_u24lambda_u241_u241.weight(Modifier.Companion, 1.0f, true), $composer4, 0);
            if (!StringsKt.isBlank(cardModel.getAuthor())) {
                $composer4.startReplaceGroup(-1496209530);
                ComposerKt.sourceInformation($composer4, "152@6079L664");
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier$iv5 = Modifier.Companion;
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv5 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                $composer3 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer4.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
                $composer$iv = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i13 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -1859578067, "C154@6206L29,155@6278L6,153@6153L266,159@6440L39,162@6597L9,163@6654L6,160@6500L225:OfflineCompletedCard.kt#uys4uf");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getUploader_name_square_line_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa5-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer4, 6);
                TextKt.Text-Nvy7gAk(cardModel.getAuthor(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer3 = $composer4;
                $composer$iv = $composer4;
                $composer4.startReplaceGroup(-1502244610);
            }
            $composer4.endReplaceGroup();
            if (cardModel.getVipOnly()) {
                text = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2215(PlayerbaseresRes.INSTANCE.getString())) + cardModel.getSize();
            } else {
                text = cardModel.getSize();
            }
            TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12();
            if (cardModel.getVipOnly()) {
                $composer4.startReplaceGroup(-463871065);
                ComposerKt.sourceInformation($composer4, "178@7193L6");
                j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getPi5-0d7_KjU();
            } else {
                $composer4.startReplaceGroup(-463870233);
                ComposerKt.sourceInformation($composer4, "178@7219L6");
                j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa5-0d7_KjU();
            }
            $composer4.endReplaceGroup();
            TextKt.Text-Nvy7gAk(text, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, t12, $composer4, 0, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            showDivider2 = showDivider4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z = showDivider2;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineCompletedCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineCompletedCard$lambda$2;
                    OfflineCompletedCard$lambda$2 = OfflineCompletedCardKt.OfflineCompletedCard$lambda$2(OfflineCachedCardModel.this, modifier6, z, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineCompletedCard$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier OfflineCompletedCard$lambda$0$0(long $dividerColor, Modifier it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BottomDividerKt.m2901drawBottomDividermxwnekA$default(it, false, $dividerColor, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float OfflineCompletedCard$lambda$1$0$1$0(OfflineCachedCardModel $cardModel) {
        return (float) Duration.div-LRDsOJo($cardModel.m2796getProgressUwyO8pc(), $cardModel.m2795getDurationUwyO8pc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineCompletedCard$lambda$1$0$2$0(DrawScope $this$LinearProgressIndicator) {
        Intrinsics.checkNotNullParameter($this$LinearProgressIndicator, "$this$LinearProgressIndicator");
        return Unit.INSTANCE;
    }
}