package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.dynamic.v2.KLinkNodeType;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerParagraph;
import com.bapis.bilibili.broadcast.message.deepsearch.KAnswerText;
import com.bapis.bilibili.broadcast.message.deepsearch.KCardItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchContent;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.Iterator;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DeepSearchCopyHandler.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\u000b"}, d2 = {"bindCopyAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "copyContent", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "list", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchCopyHandlerKt {
    public static final void bindCopyAction(InStateBuilderBlock<DeepSearchPageData, DeepSearchPageData, DeepSearchAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new DeepSearchCopyHandlerKt$bindCopyAction$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(DeepSearchAction.CopyAction.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String copyContent(String queryId, List<KChatHistoryItem> list) {
        List paragraphList;
        List paragraphList2;
        Object prefix;
        KParagraph.KText tempParagraph;
        KParagraph.IContent tempParagraph2;
        boolean z;
        String rawText;
        KParagraph paragraph;
        KParagraph tempParagraph3;
        Integer num;
        KParagraph.KListFormat listFormat;
        KDeepSearchContent deepContent;
        KChatHistoryItem tempItem = null;
        Iterator it = CollectionsKt.reversed(list).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            KChatHistoryItem item = (KChatHistoryItem) it.next();
            KDeepSearchResponse content = item.getContent();
            if (Intrinsics.areEqual(queryId, content != null ? content.getQueryId() : null)) {
                tempItem = item;
                break;
            }
        }
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        if (tempItem != null) {
            KDeepSearchResponse content2 = tempItem.getContent();
            KDeepSearchContent.KAnswer contentItem = (content2 == null || (deepContent = content2.getDeepContent()) == null) ? null : deepContent.getContentItem();
            if (contentItem instanceof KDeepSearchContent.KAnswer) {
                KAnswerText answerText = contentItem.getValue().getAnswerText();
                if (answerText != null && (paragraphList = answerText.getParagraphs()) != null) {
                    List $this$forEach$iv = paragraphList;
                    for (Object element$iv : $this$forEach$iv) {
                        KAnswerParagraph answerParagraph = (KAnswerParagraph) element$iv;
                        if (!answerParagraph.getEmbed() && !answerParagraph.getItems().isEmpty()) {
                            Iterable $this$forEach$iv2 = answerParagraph.getItems();
                            for (Object element$iv2 : $this$forEach$iv2) {
                                KCardItem cardItem = (KCardItem) element$iv2;
                                KCardItem.KText cardItem2 = cardItem.getCardItem();
                                KChatHistoryItem tempItem2 = tempItem;
                                KDeepSearchContent.IContentItem contentItem2 = contentItem;
                                if (cardItem2 instanceof KCardItem.KText) {
                                    KModuleParagraph paragraph2 = cardItem2.getValue().getParagraph();
                                    if (paragraph2 == null || (tempParagraph3 = paragraph2.getParagraph()) == null) {
                                        paragraphList2 = paragraphList;
                                        prefix = RoomRecommendViewModel.EMPTY_CURSOR;
                                    } else {
                                        Object prefix2 = tempParagraph3.getParaType();
                                        paragraphList2 = paragraphList;
                                        if (Intrinsics.areEqual(prefix2, KParagraph.KParagraphType.SORTED_LIST.INSTANCE)) {
                                            KParagraph.KParagraphFormat paraFormat = tempParagraph3.getParaFormat();
                                            if (paraFormat == null || (listFormat = paraFormat.getListFormat()) == null) {
                                                num = null;
                                            } else {
                                                num = Integer.valueOf(listFormat.getOrder());
                                            }
                                            prefix = num + ".";
                                        } else {
                                            Object prefix3 = tempParagraph3.getParaType();
                                            if (!Intrinsics.areEqual(prefix3, KParagraph.KParagraphType.UNSORTED_LIST.INSTANCE)) {
                                                prefix = RoomRecommendViewModel.EMPTY_CURSOR;
                                            } else {
                                                prefix = "·";
                                            }
                                        }
                                    }
                                    KModuleParagraph paragraph3 = cardItem2.getValue().getParagraph();
                                    if (paragraph3 == null || (paragraph = paragraph3.getParagraph()) == null) {
                                        tempParagraph = null;
                                    } else {
                                        tempParagraph = paragraph.getContent();
                                    }
                                    if (tempParagraph instanceof KParagraph.KText) {
                                        if (str.length() > 0) {
                                            str = ((Object) str) + "\n";
                                        }
                                        if (((CharSequence) prefix).length() > 0) {
                                            str = new StringBuilder().append((Object) str).append(prefix).toString();
                                        }
                                        Iterable $this$forEach$iv3 = tempParagraph.getValue().getNodes();
                                        boolean z2 = false;
                                        for (Object element$iv3 : $this$forEach$iv3) {
                                            KTextNode textNode = (KTextNode) element$iv3;
                                            Object prefix4 = prefix;
                                            Object prefix5 = textNode.getText();
                                            Iterable $this$forEach$iv4 = $this$forEach$iv3;
                                            if (prefix5 instanceof KTextNode.KLink) {
                                                tempParagraph2 = tempParagraph;
                                                if (Intrinsics.areEqual(((KTextNode.KLink) prefix5).getValue().getLinkTypeEnum(), KLinkNodeType.NICK_NAME.INSTANCE)) {
                                                    z = z2;
                                                    rawText = "@" + textNode.getRawText();
                                                } else {
                                                    z = z2;
                                                    rawText = textNode.getRawText();
                                                }
                                            } else {
                                                tempParagraph2 = tempParagraph;
                                                z = z2;
                                                if (prefix5 instanceof KTextNode.KEmote) {
                                                    if (((KTextNode.KEmote) prefix5).getValue().isAvatar()) {
                                                        rawText = RoomRecommendViewModel.EMPTY_CURSOR;
                                                    } else {
                                                        rawText = textNode.getRawText();
                                                    }
                                                } else {
                                                    rawText = textNode.getRawText();
                                                }
                                            }
                                            str = ((Object) str) + rawText;
                                            prefix = prefix4;
                                            $this$forEach$iv3 = $this$forEach$iv4;
                                            tempParagraph = tempParagraph2;
                                            z2 = z;
                                        }
                                    }
                                } else {
                                    paragraphList2 = paragraphList;
                                    if (cardItem2 instanceof KCardItem.KVideo) {
                                        if (str.length() > 0) {
                                            str = ((Object) str) + "\n";
                                        }
                                        str = ((Object) str) + ((KCardItem.KVideo) cardItem2).getValue().getRawText();
                                    }
                                }
                                tempItem = tempItem2;
                                contentItem = contentItem2;
                                paragraphList = paragraphList2;
                            }
                        }
                        tempItem = tempItem;
                        contentItem = contentItem;
                        paragraphList = paragraphList;
                    }
                }
            }
        }
        return str;
    }
}