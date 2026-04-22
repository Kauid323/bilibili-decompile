package kntr.app.deepsearch.ui.list;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerParagraph;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerText;
import com.bapis.bilibili.broadcast.message.deepsearch.KCardItem;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.ui.cards.CardKt;
import kntr.app.deepsearch.ui.key.ListKeyScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentBody.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"contentBody", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/ui/key/ListKeyScope;", "item", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "answer", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KAnswerText;", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContentBodyKt {
    public static final void contentBody(ListKeyScope $this$contentBody, KChatHistoryItem item, KAnswerText answer, final Function1<? super DeepSearchAction, Unit> function1, final String sessionId, final String queryId) {
        List $this$fastFold$iv;
        boolean z;
        int i;
        List $this$fastForEach$iv$iv;
        int index$iv$iv;
        Intrinsics.checkNotNullParameter($this$contentBody, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        List $this$fastFold$iv2 = answer.getParagraphs();
        List $this$fastForEach$iv$iv2 = $this$fastFold$iv2;
        int size = $this$fastForEach$iv$iv2.size();
        KAnswerParagraph kAnswerParagraph = null;
        int index$iv$iv2 = 0;
        while (index$iv$iv2 < size) {
            Object item$iv$iv = $this$fastForEach$iv$iv2.get(index$iv$iv2);
            final KAnswerParagraph self = (KAnswerParagraph) item$iv$iv;
            final KAnswerParagraph up = kAnswerParagraph;
            boolean z2 = false;
            if (up != null && !up.getEmbed()) {
                z2 = true;
            }
            if (!z2) {
                $this$fastFold$iv = $this$fastFold$iv2;
                z = true;
            } else {
                $this$fastFold$iv = $this$fastFold$iv2;
                z = true;
                ListKeyScope.item$default($this$contentBody, item, null, ComposableSingletons$ContentBodyKt.INSTANCE.getLambda$929561101$compose_debug(), 2, null);
            }
            if (self.getEmbed()) {
                ListKeyScope.item$default($this$contentBody, item, null, ComposableLambdaKt.composableLambdaInstance(1120523908, z, new Function4() { // from class: kntr.app.deepsearch.ui.list.ContentBodyKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit contentBody$lambda$0$0;
                        contentBody$lambda$0$0 = ContentBodyKt.contentBody$lambda$0$0(up, self, function1, sessionId, queryId, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return contentBody$lambda$0$0;
                    }
                }), 2, null);
                i = size;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                index$iv$iv = index$iv$iv2;
            } else {
                List $this$fastForEach$iv$iv3 = self.getItems();
                int size2 = $this$fastForEach$iv$iv3.size();
                KCardItem kCardItem = null;
                int index$iv$iv3 = 0;
                while (index$iv$iv3 < size2) {
                    Object item$iv$iv2 = $this$fastForEach$iv$iv3.get(index$iv$iv3);
                    final KCardItem current = (KCardItem) item$iv$iv2;
                    final KCardItem last = kCardItem;
                    ListKeyScope.item$default($this$contentBody, item, null, ComposableLambdaKt.composableLambdaInstance(-1859219648, z, new Function4() { // from class: kntr.app.deepsearch.ui.list.ContentBodyKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            Unit contentBody$lambda$0$1$0;
                            contentBody$lambda$0$1$0 = ContentBodyKt.contentBody$lambda$0$1$0(current, last, function1, sessionId, queryId, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            return contentBody$lambda$0$1$0;
                        }
                    }), 2, null);
                    kCardItem = current;
                    index$iv$iv3++;
                    size2 = size2;
                    $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv3;
                    index$iv$iv2 = index$iv$iv2;
                    size = size;
                    $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                }
                i = size;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                index$iv$iv = index$iv$iv2;
            }
            kAnswerParagraph = self;
            index$iv$iv2 = index$iv$iv + 1;
            $this$fastFold$iv2 = $this$fastFold$iv;
            size = i;
            $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contentBody$lambda$0$0(KAnswerParagraph $up, KAnswerParagraph $self, Function1 $dispatcher, String $sessionId, String $queryId, LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        int i;
        boolean z;
        CompositionLocalMap localMap$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it)53@1999L6,46@1675L1275:ContentBody.kt#4jzcco");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1120523908, $changed, -1, "kntr.app.deepsearch.ui.list.contentBody.<anonymous>.<anonymous> (ContentBody.kt:46)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, $up != null && $up.getEmbed() ? Dp.constructor-impl(12) : Dp.constructor-impl(0), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), 0.0f, Dp.constructor-impl(12), 1, (Object) null);
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1318046774, "C:ContentBody.kt#4jzcco");
            $composer.startReplaceGroup(-788766014);
            ComposerKt.sourceInformation($composer, "*62@2489L389");
            List $this$fastForEach$iv$iv = $self.getItems();
            int size = $this$fastForEach$iv$iv.size();
            KCardItem kCardItem = null;
            int index$iv$iv = 0;
            while (index$iv$iv < size) {
                Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                KCardItem current = (KCardItem) item$iv$iv;
                KCardItem last = kCardItem;
                if ((last != null ? last.getCardType() : null) != null) {
                    i = size;
                    z = z2;
                    if (Intrinsics.areEqual(current.getCardType(), KCardItem.KCardType.AUTHOR.INSTANCE)) {
                        $composer.startReplaceGroup(-134469775);
                        ComposerKt.sourceInformation($composer, "59@2407L30");
                        localMap$iv$iv = localMap$iv$iv2;
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer, 6);
                        $composer.endReplaceGroup();
                        CardKt.Card(current, last, $dispatcher, $sessionId, $queryId, CardKt.embedPaddingStart(Modifier.Companion, current), true, $composer, 1572864, 0);
                        kCardItem = current;
                        index$iv$iv++;
                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                        size = i;
                        z2 = z;
                        localMap$iv$iv2 = localMap$iv$iv;
                    } else {
                        localMap$iv$iv = localMap$iv$iv2;
                    }
                } else {
                    i = size;
                    z = z2;
                    localMap$iv$iv = localMap$iv$iv2;
                }
                $composer.startReplaceGroup(-136831417);
                $composer.endReplaceGroup();
                CardKt.Card(current, last, $dispatcher, $sessionId, $queryId, CardKt.embedPaddingStart(Modifier.Companion, current), true, $composer, 1572864, 0);
                kCardItem = current;
                index$iv$iv++;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                size = i;
                z2 = z;
                localMap$iv$iv2 = localMap$iv$iv;
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contentBody$lambda$0$1$0(KCardItem $current, KCardItem $last, Function1 $dispatcher, String $sessionId, String $queryId, LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it)80@3167L292:ContentBody.kt#4jzcco");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1859219648, $changed, -1, "kntr.app.deepsearch.ui.list.contentBody.<anonymous>.<anonymous>.<anonymous> (ContentBody.kt:80)");
            }
            CardKt.Card($current, $last, $dispatcher, $sessionId, $queryId, Modifier.Companion, false, $composer, 196608, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}