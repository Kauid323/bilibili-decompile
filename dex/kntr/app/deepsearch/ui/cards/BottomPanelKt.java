package kntr.app.deepsearch.ui.cards;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchRetryChatModel;
import kntr.app.deepsearch.ui.key.ListKeyScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomPanel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¨\u0006\u000b"}, d2 = {"bottomPanel", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/ui/key/ListKeyScope;", "data", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "isShowCopyLike", RoomRecommendViewModel.EMPTY_CURSOR, "isShowRetry", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BottomPanelKt {
    public static final void bottomPanel(ListKeyScope $this$bottomPanel, final KChatHistoryItem data, final boolean isShowCopyLike, final boolean isShowRetry, final Function1<? super DeepSearchAction, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$bottomPanel, "<this>");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        if (data == null || data.getContent() == null) {
            return;
        }
        if (isShowCopyLike || isShowRetry) {
            ListKeyScope.item$default($this$bottomPanel, data, null, ComposableLambdaKt.composableLambdaInstance(-1811182986, true, new Function4() { // from class: kntr.app.deepsearch.ui.cards.BottomPanelKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit bottomPanel$lambda$0;
                    bottomPanel$lambda$0 = BottomPanelKt.bottomPanel$lambda$0(isShowCopyLike, isShowRetry, function1, data, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return bottomPanel$lambda$0;
                }
            }), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x040b, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x04e1, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x05fe, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit bottomPanel$lambda$0(boolean $isShowCopyLike, boolean $isShowRetry, final Function1 $dispatcher, final KChatHistoryItem $data, LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv3;
        Painter painter;
        long j2;
        Painter painter2;
        long j3;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it)34@1433L7,35@1453L8814:BottomPanel.kt#pp6rt");
        if ($composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1811182986, $changed, -1, "kntr.app.deepsearch.ui.cards.bottomPanel.<anonymous> (BottomPanel.kt:34)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final FocusManager focusManager = (FocusManager) consume;
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1220369783, "C36@1475L8778:BottomPanel.kt#pp6rt");
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(20)), Dp.constructor-impl(2), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((438 >> 6) & 112) | 6;
            RowScope $this$bottomPanel_u24lambda_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1085459928, "C:BottomPanel.kt#pp6rt");
            if ($isShowCopyLike) {
                $composer.startReplaceGroup(1085435685);
                ComposerKt.sourceInformation($composer, "47@1962L6849");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier$iv3 = Modifier.Companion;
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                int $changed$iv$iv$iv3 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, $changed$iv$iv$iv3);
                int $changed$iv$iv3 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                $composer$iv$iv = $composer;
                $composer$iv$iv$iv = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                $composer$iv = $composer;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 498766330, "C52@2194L13,54@2319L557,64@2927L6,51@2133L896,68@3059L40,81@3719L1493,71@3163L2555,115@5748L40,128@6413L1865,118@5852L2933:BottomPanel.kt#pp6rt");
                Painter copy_line_500 = BiliIconfont.INSTANCE.getCopy_line_500($composer, 6);
                Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20));
                ComposerKt.sourceInformationMarkerStart($composer, 708825754, "CC(remember):BottomPanel.kt#9igjgp");
                boolean invalid$iv = $composer.changed($dispatcher) | $composer.changedInstance($data);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.deepsearch.ui.cards.BottomPanelKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit bottomPanel$lambda$0$0$0$0$0$0;
                        bottomPanel$lambda$0$0$0$0$0$0 = BottomPanelKt.bottomPanel$lambda$0$0$0$0$0$0($dispatcher, $data);
                        return bottomPanel$lambda$0$0$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconKt.Icon-ww6aTOc(copy_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), $composer, Painter.$stable | 48, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
                if (Intrinsics.areEqual($data.getLikeType().getName(), KLikeType.LIKE.INSTANCE.getName())) {
                    $composer.startReplaceGroup(499791778);
                    ComposerKt.sourceInformation($composer, "76@3426L22");
                    Painter hand_thumbsup_fill_500 = BiliIconfont.INSTANCE.getHand_thumbsup_fill_500($composer, 6);
                    $composer.endReplaceGroup();
                    painter = hand_thumbsup_fill_500;
                } else {
                    $composer.startReplaceGroup(499911810);
                    ComposerKt.sourceInformation($composer, "78@3547L22");
                    Painter hand_thumbsup_line_500 = BiliIconfont.INSTANCE.getHand_thumbsup_line_500($composer, 6);
                    $composer.endReplaceGroup();
                    painter = hand_thumbsup_line_500;
                }
                Modifier modifier2 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20));
                ComposerKt.sourceInformationMarkerStart($composer, 708871490, "CC(remember):BottomPanel.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance($data) | $composer.changed($dispatcher);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.deepsearch.ui.cards.BottomPanelKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit bottomPanel$lambda$0$0$0$0$1$0;
                        bottomPanel$lambda$0$0$0$0$1$0 = BottomPanelKt.bottomPanel$lambda$0$0$0$0$1$0($data, $dispatcher);
                        return bottomPanel$lambda$0$0$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                if (Intrinsics.areEqual($data.getLikeType().getName(), KLikeType.LIKE.INSTANCE.getName())) {
                    $composer.startReplaceGroup(501817194);
                    ComposerKt.sourceInformation($composer, "108@5465L6");
                    long j4 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $composer.endReplaceGroup();
                    j2 = j4;
                } else {
                    $composer.startReplaceGroup(501929135);
                    ComposerKt.sourceInformation($composer, "110@5578L6");
                    long j5 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
                    $composer.endReplaceGroup();
                    j2 = j5;
                }
                IconKt.Icon-ww6aTOc(painter, (String) null, modifier3, j2, $composer, Painter.$stable | 48, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
                if (Intrinsics.areEqual($data.getLikeType().getName(), KLikeType.TREAD.INSTANCE.getName())) {
                    $composer.startReplaceGroup(502460320);
                    ComposerKt.sourceInformation($composer, "123@6116L24");
                    Painter hand_thumbsdown_fill_500 = BiliIconfont.INSTANCE.getHand_thumbsdown_fill_500($composer, 6);
                    $composer.endReplaceGroup();
                    painter2 = hand_thumbsdown_fill_500;
                } else {
                    $composer.startReplaceGroup(502582336);
                    ComposerKt.sourceInformation($composer, "125@6239L24");
                    Painter hand_thumbsdown_line_500 = BiliIconfont.INSTANCE.getHand_thumbsdown_line_500($composer, 6);
                    $composer.endReplaceGroup();
                    painter2 = hand_thumbsdown_line_500;
                }
                Modifier modifier4 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20));
                ComposerKt.sourceInformationMarkerStart($composer, 708958070, "CC(remember):BottomPanel.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance($data) | $composer.changedInstance(focusManager) | $composer.changed($dispatcher);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.deepsearch.ui.cards.BottomPanelKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit bottomPanel$lambda$0$0$0$0$2$0;
                        bottomPanel$lambda$0$0$0$0$2$0 = BottomPanelKt.bottomPanel$lambda$0$0$0$0$2$0($data, focusManager, $dispatcher);
                        return bottomPanel$lambda$0$0$0$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier5 = ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                if (Intrinsics.areEqual($data.getLikeType().getName(), KLikeType.TREAD.INSTANCE.getName())) {
                    $composer.startReplaceGroup(504859658);
                    ComposerKt.sourceInformation($composer, "160@8532L6");
                    long j6 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $composer.endReplaceGroup();
                    j3 = j6;
                } else {
                    $composer.startReplaceGroup(504971599);
                    ComposerKt.sourceInformation($composer, "162@8645L6");
                    long j7 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
                    $composer.endReplaceGroup();
                    j3 = j7;
                }
                IconKt.Icon-ww6aTOc(painter2, (String) null, modifier5, j3, $composer, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer$iv$iv = $composer;
                $composer$iv = $composer;
                $composer$iv$iv$iv = $composer;
                $composer.startReplaceGroup(1092072320);
                ComposerKt.sourceInformation($composer, "168@8865L38");
                SpacerKt.Spacer(RowScope.-CC.weight$default($this$bottomPanel_u24lambda_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer, 0);
                $composer.endReplaceGroup();
            }
            if ($isShowRetry) {
                $composer.startReplaceGroup(1092282345);
                ComposerKt.sourceInformation($composer, "174@9073L22,176@9199L873,192@10119L6,173@9016L1197");
                Painter arrow_refresh_line_500 = BiliIconfont.INSTANCE.getArrow_refresh_line_500($composer, 6);
                Modifier modifier6 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20));
                ComposerKt.sourceInformationMarkerStart($composer, -1350232875, "CC(remember):BottomPanel.kt#9igjgp");
                boolean invalid$iv4 = $composer.changedInstance(focusManager) | $composer.changed($dispatcher) | $composer.changedInstance($data);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: kntr.app.deepsearch.ui.cards.BottomPanelKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit bottomPanel$lambda$0$0$0$1$0;
                            bottomPanel$lambda$0$0$0$1$0 = BottomPanelKt.bottomPanel$lambda$0$0$0$1$0(focusManager, $dispatcher, $data);
                            return bottomPanel$lambda$0$0$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconKt.Icon-ww6aTOc(arrow_refresh_line_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), $composer, Painter.$stable | 48, 0);
            } else {
                $composer.startReplaceGroup(1083300374);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Unit bottomPanel$lambda$0$0$0$0$0$0(Function1 $dispatcher, KChatHistoryItem $data) {
        KDeepSearchResponse content = $data.getContent();
        String queryId = content != null ? content.getQueryId() : null;
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (queryId == null) {
            queryId = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $dispatcher.invoke(new DeepSearchAction.CopyAction(queryId));
        KDeepSearchResponse content2 = $data.getContent();
        String queryId2 = content2 != null ? content2.getQueryId() : null;
        if (queryId2 != null) {
            str = queryId2;
        }
        $dispatcher.invoke(new DeepSearchAction.TrackerAction.CopyClick(str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bottomPanel$lambda$0$0$0$0$1$0(KChatHistoryItem $data, Function1 $dispatcher) {
        String queryId;
        boolean areEqual = Intrinsics.areEqual($data.getLikeType().getName(), KLikeType.LIKE.INSTANCE.getName());
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (!areEqual) {
            KDeepSearchResponse content = $data.getContent();
            String queryId2 = content != null ? content.getQueryId() : null;
            if (queryId2 == null) {
                queryId2 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            $dispatcher.invoke(new DeepSearchAction.LikeAction(queryId2, KLikeType.LIKE.INSTANCE));
            KDeepSearchResponse content2 = $data.getContent();
            queryId = content2 != null ? content2.getQueryId() : null;
            if (queryId != null) {
                str = queryId;
            }
            $dispatcher.invoke(new DeepSearchAction.TrackerAction.LikeClick(str, false));
        } else {
            KDeepSearchResponse content3 = $data.getContent();
            String queryId3 = content3 != null ? content3.getQueryId() : null;
            if (queryId3 == null) {
                queryId3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            $dispatcher.invoke(new DeepSearchAction.LikeAction(queryId3, KLikeType.INVALID.INSTANCE));
            KDeepSearchResponse content4 = $data.getContent();
            queryId = content4 != null ? content4.getQueryId() : null;
            if (queryId != null) {
                str = queryId;
            }
            $dispatcher.invoke(new DeepSearchAction.TrackerAction.LikeClick(str, true));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bottomPanel$lambda$0$0$0$0$2$0(KChatHistoryItem $data, FocusManager $focusManager, Function1 $dispatcher) {
        String queryId;
        boolean areEqual = Intrinsics.areEqual($data.getLikeType().getName(), KLikeType.TREAD.INSTANCE.getName());
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (!areEqual) {
            $focusManager.clearFocus(true);
            KDeepSearchResponse content = $data.getContent();
            String queryId2 = content != null ? content.getQueryId() : null;
            if (queryId2 == null) {
                queryId2 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            $dispatcher.invoke(new DeepSearchAction.LikeAction(queryId2, KLikeType.TREAD.INSTANCE));
            KDeepSearchResponse content2 = $data.getContent();
            String queryId3 = content2 != null ? content2.getQueryId() : null;
            if (queryId3 == null) {
                queryId3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            $dispatcher.invoke(new DeepSearchAction.TreadPopViewAction.TreadPopViewShow(queryId3));
            KDeepSearchResponse content3 = $data.getContent();
            queryId = content3 != null ? content3.getQueryId() : null;
            if (queryId != null) {
                str = queryId;
            }
            $dispatcher.invoke(new DeepSearchAction.TrackerAction.DisLikeClick(str, false));
        } else {
            KDeepSearchResponse content4 = $data.getContent();
            String queryId4 = content4 != null ? content4.getQueryId() : null;
            if (queryId4 == null) {
                queryId4 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            $dispatcher.invoke(new DeepSearchAction.LikeAction(queryId4, KLikeType.INVALID.INSTANCE));
            KDeepSearchResponse content5 = $data.getContent();
            queryId = content5 != null ? content5.getQueryId() : null;
            if (queryId != null) {
                str = queryId;
            }
            $dispatcher.invoke(new DeepSearchAction.TrackerAction.DisLikeClick(str, true));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bottomPanel$lambda$0$0$0$1$0(FocusManager $focusManager, Function1 $dispatcher, KChatHistoryItem $data) {
        $focusManager.clearFocus(true);
        String query = $data.getQuery();
        KDeepSearchResponse content = $data.getContent();
        String queryId = content != null ? content.getQueryId() : null;
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        $dispatcher.invoke(new DeepSearchAction.RetryChat(new DeepSearchRetryChatModel(query, queryId == null ? RoomRecommendViewModel.EMPTY_CURSOR : queryId, false, null, 12, null)));
        KDeepSearchResponse content2 = $data.getContent();
        String queryId2 = content2 != null ? content2.getQueryId() : null;
        if (queryId2 != null) {
            str = queryId2;
        }
        $dispatcher.invoke(new DeepSearchAction.TrackerAction.RetryClick(str));
        return Unit.INSTANCE;
    }
}