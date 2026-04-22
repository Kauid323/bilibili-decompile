package kntr.app.deepsearch.ui.list;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerText;
import com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchContent;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import java.util.ArrayList;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.CardType;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentList;
import kntr.app.deepsearch.base.model.biz.DeepSearchContentListKt;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageChatState;
import kntr.app.deepsearch.base.model.biz.DeepSearchSessionEndModel;
import kntr.app.deepsearch.ui.cards.BottomPanelKt;
import kntr.app.deepsearch.ui.cards.GreetingsKt;
import kntr.app.deepsearch.ui.cards.LoadingKt;
import kntr.app.deepsearch.ui.cards.QueryKt;
import kntr.app.deepsearch.ui.cards.SessionEndTimeLineKt;
import kntr.app.deepsearch.ui.key.ListKeyScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: ContentList.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"ContentList", RoomRecommendViewModel.EMPTY_CURSOR, "list", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "chatState", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/DeepSearchPageChatState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ContentListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentList$lambda$1(DeepSearchContentList deepSearchContentList, LazyListState lazyListState, Function1 function1, String str, DeepSearchPageChatState deepSearchPageChatState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ContentList(deepSearchContentList, lazyListState, function1, str, deepSearchPageChatState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ContentList(final DeepSearchContentList list, final LazyListState state, final Function1<? super DeepSearchAction, Unit> function1, final String sessionId, final DeepSearchPageChatState chatState, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(chatState, "chatState");
        Composer $composer2 = $composer.startRestartGroup(1779814231);
        ComposerKt.sourceInformation($composer2, "C(ContentList)N(list,state,dispatcher,sessionId,chatState,modifier)50@1977L6568,40@1719L6826:ContentList.kt#4jzcco");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(sessionId) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(chatState) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1779814231, $dirty, -1, "kntr.app.deepsearch.ui.list.ContentList (ContentList.kt:39)");
            }
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(16), Dp.constructor-impl(16), Dp.constructor-impl(36));
            ComposerKt.sourceInformationMarkerStart($composer2, 1004514239, "CC(remember):ContentList.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | (($dirty & 896) == 256) | $composer2.changedInstance(chatState) | (($dirty & 7168) == 2048);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.list.ContentListKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit ContentList$lambda$0$0;
                        ContentList$lambda$0$0 = ContentListKt.ContentList$lambda$0$0(DeepSearchContentList.this, function1, sessionId, chatState, (LazyListScope) obj);
                        return ContentList$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier3, state, paddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, (($dirty >> 15) & 14) | 384 | ($dirty & 112), 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.list.ContentListKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContentList$lambda$1;
                    ContentList$lambda$1 = ContentListKt.ContentList$lambda$1(DeepSearchContentList.this, state, function1, sessionId, chatState, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ContentList$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0219, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4 != null ? r4.getStatus() : null, com.bapis.bilibili.broadcast.message.deepsearch.KChatStatus.STOP.INSTANCE) != false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0248  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ContentList$lambda$0$0(DeepSearchContentList $list, final Function1 $dispatcher, String $sessionId, final DeepSearchPageChatState $chatState, LazyListScope $this$LazyColumn) {
        int $i$f$fastMapIndexed;
        ArrayList arrayList;
        int index;
        KChatHistoryItem historyItem;
        int index2;
        ListKeyScope $this$ContentList_u24lambda_u240_u240_u240_u240;
        boolean z;
        boolean z2;
        KDeepSearchContent deepContent;
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        Ref.IntRef startIndex = new Ref.IntRef();
        List $this$fastMapIndexed$iv = $list.getList();
        int $i$f$fastMapIndexed2 = 0;
        ArrayList target$iv = new ArrayList($this$fastMapIndexed$iv.size());
        int size = $this$fastMapIndexed$iv.size();
        int index$iv$iv = 0;
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastMapIndexed$iv.get(index$iv$iv);
            int index$iv = index$iv$iv;
            ArrayList arrayList2 = target$iv;
            final KChatHistoryItem historyItem2 = (KChatHistoryItem) item$iv$iv;
            int startIndex$iv = startIndex.element;
            ListKeyScope $this$ContentList_u24lambda_u240_u240_u240_u2402 = new ListKeyScope($this$LazyColumn, startIndex$iv);
            KDeepSearchResponse content = historyItem2.getContent();
            final KDeepSearchContent.IContentItem content2 = (content == null || (deepContent = content.getDeepContent()) == null) ? null : deepContent.getContentItem();
            List $this$fastMapIndexed$iv2 = $this$fastMapIndexed$iv;
            if (!(content2 instanceof KDeepSearchContent.KGreetings)) {
                if (!(content2 instanceof KDeepSearchContent.KAnswer)) {
                    $i$f$fastMapIndexed = $i$f$fastMapIndexed2;
                    arrayList = arrayList2;
                    if (content2 != null) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    if (index$iv > 0) {
                        ListKeyScope.item$default($this$ContentList_u24lambda_u240_u240_u240_u2402, historyItem2, null, ComposableSingletons$ContentListKt.INSTANCE.m756getLambda$952260744$compose_debug(), 2, null);
                    }
                    ListKeyScope.item$default($this$ContentList_u24lambda_u240_u240_u240_u2402, historyItem2, null, ComposableLambdaKt.composableLambdaInstance(386836531, true, new Function4() { // from class: kntr.app.deepsearch.ui.list.ContentListKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            Unit ContentList$lambda$0$0$0$0$1;
                            ContentList$lambda$0$0$0$0$1 = ContentListKt.ContentList$lambda$0$0$0$0$1(historyItem2, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            return ContentList$lambda$0$0$0$0$1;
                        }
                    }), 2, null);
                    final KThinking thinking = ((KDeepSearchContent.KAnswer) content2).getValue().getThinking();
                    KAnswerText answer = ((KDeepSearchContent.KAnswer) content2).getValue().getAnswerText();
                    if (thinking == null) {
                        index = index$iv;
                    } else {
                        index = index$iv;
                        $this$ContentList_u24lambda_u240_u240_u240_u2402.item(historyItem2, CardType.ThinkContent, (Function4) ComposableLambdaKt.composableLambdaInstance(702733857, true, new Function4() { // from class: kntr.app.deepsearch.ui.list.ContentListKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                Unit ContentList$lambda$0$0$0$0$2;
                                ContentList$lambda$0$0$0$0$2 = ContentListKt.ContentList$lambda$0$0$0$0$2(historyItem2, $chatState, thinking, $dispatcher, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                                return ContentList$lambda$0$0$0$0$2;
                            }
                        }));
                    }
                    if (answer == null) {
                        historyItem = historyItem2;
                        index2 = index;
                        $this$ContentList_u24lambda_u240_u240_u240_u240 = $this$ContentList_u24lambda_u240_u240_u240_u2402;
                        $i$f$fastMapIndexed = $i$f$fastMapIndexed2;
                        arrayList = arrayList2;
                    } else {
                        ListKeyScope.item$default($this$ContentList_u24lambda_u240_u240_u240_u2402, historyItem2, null, ComposableSingletons$ContentListKt.INSTANCE.m755getLambda$1962267584$compose_debug(), 2, null);
                        KDeepSearchResponse content3 = historyItem2.getContent();
                        String queryId = content3 != null ? content3.getQueryId() : null;
                        if (queryId == null) {
                            queryId = RoomRecommendViewModel.EMPTY_CURSOR;
                        }
                        index2 = index;
                        $this$ContentList_u24lambda_u240_u240_u240_u240 = $this$ContentList_u24lambda_u240_u240_u240_u2402;
                        historyItem = historyItem2;
                        $i$f$fastMapIndexed = $i$f$fastMapIndexed2;
                        arrayList = arrayList2;
                        ContentBodyKt.contentBody($this$ContentList_u24lambda_u240_u240_u240_u2402, historyItem2, answer, $dispatcher, $sessionId, queryId);
                        KDeepSearchResponse content4 = historyItem.getContent();
                        if (Intrinsics.areEqual(content4 != null ? content4.getStatus() : null, KChatStatus.STOP.INSTANCE) && !answer.getParagraphs().isEmpty()) {
                            ListKeyScope.item$default($this$ContentList_u24lambda_u240_u240_u240_u240, historyItem, null, ComposableSingletons$ContentListKt.INSTANCE.getLambda$855862277$compose_debug(), 2, null);
                        }
                    }
                    ListKeyScope $this$ContentList_u24lambda_u240_u240_u240_u2403 = $this$ContentList_u24lambda_u240_u240_u240_u240;
                    KChatHistoryItem historyItem3 = historyItem;
                    LoadingKt.loading($this$ContentList_u24lambda_u240_u240_u240_u2403, historyItem3);
                    final DeepSearchSessionEndModel sessionEndModel = $list.getSessionEndModel();
                    boolean isShowEndModel = sessionEndModel != null && DeepSearchContentListKt.isShowSessionEndTimeLine(sessionEndModel, historyItem3);
                    KDeepSearchResponse content5 = historyItem3.getContent();
                    if (!Intrinsics.areEqual(content5 != null ? content5.getStatus() : null, KChatStatus.STOP.INSTANCE)) {
                        KDeepSearchResponse content6 = historyItem3.getContent();
                        if (!Intrinsics.areEqual(content6 != null ? content6.getStatus() : null, KChatStatus.FINISH.INSTANCE)) {
                            z2 = true;
                            if (isShowEndModel) {
                                ListKeyScope.item$default($this$ContentList_u24lambda_u240_u240_u240_u2403, historyItem3, null, ComposableLambdaKt.composableLambdaInstance(1297664126, z2, new Function4() { // from class: kntr.app.deepsearch.ui.list.ContentListKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                        Unit ContentList$lambda$0$0$0$0$3;
                                        ContentList$lambda$0$0$0$0$3 = ContentListKt.ContentList$lambda$0$0$0$0$3(DeepSearchSessionEndModel.this, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                                        return ContentList$lambda$0$0$0$0$3;
                                    }
                                }), 2, null);
                            }
                        }
                    }
                    if (!isShowEndModel && index2 == $list.getList().size() - 1) {
                        KDeepSearchResponse content7 = historyItem3.getContent();
                        if (!Intrinsics.areEqual(content7 != null ? content7.getStatus() : null, KChatStatus.FINISH.INSTANCE)) {
                            KDeepSearchResponse content8 = historyItem3.getContent();
                        }
                        z = true;
                        z2 = true;
                        BottomPanelKt.bottomPanel($this$ContentList_u24lambda_u240_u240_u240_u2403, historyItem3, true, z, $dispatcher);
                        if (isShowEndModel) {
                        }
                    }
                    z = false;
                    z2 = true;
                    BottomPanelKt.bottomPanel($this$ContentList_u24lambda_u240_u240_u240_u2403, historyItem3, true, z, $dispatcher);
                    if (isShowEndModel) {
                    }
                }
            } else {
                $this$ContentList_u24lambda_u240_u240_u240_u2402.item(historyItem2, CardType.Greet, (Function4) ComposableLambdaKt.composableLambdaInstance(-850413060, true, new Function4() { // from class: kntr.app.deepsearch.ui.list.ContentListKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit ContentList$lambda$0$0$0$0$0;
                        ContentList$lambda$0$0$0$0$0 = ContentListKt.ContentList$lambda$0$0$0$0$0(content2, $dispatcher, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return ContentList$lambda$0$0$0$0$0;
                    }
                }));
                $i$f$fastMapIndexed = $i$f$fastMapIndexed2;
                arrayList = arrayList2;
            }
            startIndex.element = $this$ContentList_u24lambda_u240_u240_u240_u2402.getEndIndex();
            arrayList.add(Unit.INSTANCE);
            index$iv$iv++;
            $this$fastMapIndexed$iv = $this$fastMapIndexed$iv2;
            $i$f$fastMapIndexed2 = $i$f$fastMapIndexed;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentList$lambda$0$0$0$0$0(KDeepSearchContent.IContentItem $content, Function1 $dispatcher, LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it)61@2490L240:ContentList.kt#4jzcco");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850413060, $changed, -1, "kntr.app.deepsearch.ui.list.ContentList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ContentList.kt:61)");
            }
            GreetingsKt.Greetings(((KDeepSearchContent.KGreetings) $content).getValue(), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $dispatcher, $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentList$lambda$0$0$0$0$1(KChatHistoryItem $historyItem, LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it)84@3445L612:ContentList.kt#4jzcco");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(386836531, $changed, -1, "kntr.app.deepsearch.ui.list.ContentList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ContentList.kt:84)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1284430175, "C90@3756L119,93@3912L111:ContentList.kt#4jzcco");
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(70)), $composer, 6);
            QueryKt.Query($historyItem.getQuery(), null, $composer, 0, 2);
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
    public static final Unit ContentList$lambda$0$0$0$0$2(KChatHistoryItem $historyItem, DeepSearchPageChatState $chatState, KThinking $thinking, Function1 $dispatcher, LazyItemScope $this$item, int idx, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(idx)106@4519L633:ContentList.kt#4jzcco");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(702733857, $changed, -1, "kntr.app.deepsearch.ui.list.ContentList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ContentList.kt:106)");
            }
            KDeepSearchResponse content = $historyItem.getContent();
            String queryId = content != null ? content.getQueryId() : null;
            if (queryId == null) {
                queryId = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            ContentHeaderKt.ContentHeader(queryId, $chatState, $thinking, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), $dispatcher, $composer, 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContentList$lambda$0$0$0$0$3(DeepSearchSessionEndModel $sessionEndModel, LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it):ContentList.kt#4jzcco");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1297664126, $changed, -1, "kntr.app.deepsearch.ui.list.ContentList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ContentList.kt:173)");
            }
            if ($sessionEndModel == null) {
                $composer.startReplaceGroup(-288589304);
            } else {
                $composer.startReplaceGroup(-288589303);
                ComposerKt.sourceInformation($composer, "*174@8095L231");
                SessionEndTimeLineKt.SessionEndTimeLine($sessionEndModel, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(70), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), $composer, 48, 0);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}