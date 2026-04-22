package kntr.common.ouro.core.converter;

import com.bapis.bilibili.dynamic.common.KBgStyle;
import com.bapis.bilibili.dynamic.common.KCardParagraph;
import com.bapis.bilibili.dynamic.common.KCodeParagraph;
import com.bapis.bilibili.dynamic.common.KColors;
import com.bapis.bilibili.dynamic.common.KContentLinkCard;
import com.bapis.bilibili.dynamic.common.KEmoteNode;
import com.bapis.bilibili.dynamic.common.KFormulaNode;
import com.bapis.bilibili.dynamic.common.KLineParagraph;
import com.bapis.bilibili.dynamic.common.KLinkNode;
import com.bapis.bilibili.dynamic.common.KOpusBizType;
import com.bapis.bilibili.dynamic.common.KOpusContent;
import com.bapis.bilibili.dynamic.common.KParagraph;
import com.bapis.bilibili.dynamic.common.KPic;
import com.bapis.bilibili.dynamic.common.KPicParagraph;
import com.bapis.bilibili.dynamic.common.KTextNode;
import com.bapis.bilibili.dynamic.common.KTextParagraph;
import com.bapis.bilibili.dynamic.common.KVideoTs;
import com.bapis.bilibili.dynamic.common.KWordNode;
import com.bilibili.emoticon.Emote;
import com.bilibili.emoticon.EmoticonSize;
import com.bilibili.emoticon.UpperEmoteInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksKt;
import kntr.common.ouro.core.model.mark.OuroMediumMark;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignEndMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignStartMark;
import kntr.common.ouro.core.model.mark.OuroTextIndentMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.model.node.AtMentionUser;
import kntr.common.ouro.core.model.node.EmoteParseResult;
import kntr.common.ouro.core.model.node.OfficialVerifyType;
import kntr.common.ouro.core.model.node.OuroAtMentionLink;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroLinkKt;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.OuroUniversalLink;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroDivider;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kntr.common.ouro.core.model.node.renderable.OuroUnrecognizedCard;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kntr.common.ouro.core.plugin.pasteboard.LinkParseService;
import kntr.common.ouro.core.utils.ConverterUtilsKt;
import kntr.common.ouro.core.utils.DistinctRandomGenerator;
import kntr.common.ouro.core.utils.EmoteHelperKt;
import kntr.common.ouro.core.utils.OuroLayoutUtilsKt;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: OpusConverter.kt */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\u0080\b\u001a\u001a\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H\u0002\u001a\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0011H\u0002\u001a&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0016\u0010\u001d\u001a\u00020\u001b*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u001e\u001a\u0016\u0010\u001f\u001a\u00020 *\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u001e\u001a\u0016\u0010!\u001a\u00020\"*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010#\u001a\u00020$\u001a \u0010%\u001a\u00020&*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010'\u001a\u00020(2\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0016\u0010)\u001a\u00020**\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010+\u001a\u00020,\u001a\u0016\u0010-\u001a\u00020**\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010+\u001a\u00020.\u001a.\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u0002002\u0006\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u000204\u001a$\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u0002062\u0006\u00107\u001a\u00020\u0001\u001a$\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0087@¢\u0006\u0002\u0010<\u001a \u0010=\u001a\u0004\u0018\u00010\u001c2\u0006\u0010>\u001a\u00020\u001b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0@H\u0002\u001a&\u0010A\u001a\u0004\u0018\u0001002\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0@H\u0002\u001a&\u0010C\u001a\u0004\u0018\u0001062\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0@H\u0002\u001a \u0010D\u001a\u0004\u0018\u00010\u001c2\u0006\u0010E\u001a\u00020F2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0@H\u0002\u001a$\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010E\u001a\u00020F2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0@H\u0002\u001a\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010I\u001a\u00020\u000fH\u0002\u001a\u000e\u0010J\u001a\u0004\u0018\u00010\u0013*\u00020KH\u0002\u001a\"\u0010L\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\u000b0@2\u0006\u0010E\u001a\u00020F2\u0006\u0010M\u001a\u00020\u001eH\u0002\u001a\u0012\u0010N\u001a\u0004\u0018\u00010\u00012\u0006\u0010O\u001a\u00020\u001bH\u0002\u001aD\u0010P\u001a\u00020Q2\u0006\u0010>\u001a\u00020\u001b2\b\u0010R\u001a\u0004\u0018\u00010\u00012\b\u0010S\u001a\u0004\u0018\u00010\u00012\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020U2\u000e\b\u0002\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"TAG", "", "getMergedMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "MARK", "Lkntr/common/ouro/core/model/mark/OuroMark;", "Lkntr/common/ouro/core/model/NodeStorage;", "node", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "toOpusContent", "Lcom/bapis/bilibili/dynamic/common/KOpusContent;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "localImageState", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "convertTextElementToWordNode", "Lcom/bapis/bilibili/dynamic/common/KWordNode;", "textElement", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "extractForegroundColor", "Lkntr/common/ouro/core/model/mark/OuroColor;", "marks", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "extractBackgroundColorOrNull", "extractFontLevelFromOuroTextElement", "Lkntr/common/ouro/core/converter/OpusFontLevel;", "convertOuroNodeToOpusParagraphs", "", "Lcom/bapis/bilibili/dynamic/common/KParagraph;", "Lkntr/common/ouro/core/model/node/OuroNode;", "convertOuroParagraphToOpusParagraph", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "convertOuroParagraphToTextParagraph", "Lcom/bapis/bilibili/dynamic/common/KTextParagraph;", "convertOuroInlineContentToEmoteNode", "Lcom/bapis/bilibili/dynamic/common/KEmoteNode;", "inlineContent", "Lkntr/common/ouro/core/model/node/drawable/OuroInlineContent;", "convertOuroBoxContainerToPicParagraph", "Lcom/bapis/bilibili/dynamic/common/KPicParagraph;", "boxContainer", "Lkntr/common/ouro/core/model/node/drawable/OuroBoxContainer;", "convertUniversalLinkToLinkNode", "Lcom/bapis/bilibili/dynamic/common/KLinkNode;", "link", "Lkntr/common/ouro/core/model/node/OuroUniversalLink;", "convertAtMentionLinkToLinkNode", "Lkntr/common/ouro/core/model/node/OuroAtMentionLink;", "convertOuroListToOpusParagraphs", "Lkntr/common/ouro/core/model/node/OuroList;", "randomGenerator", "Lkntr/common/ouro/core/utils/DistinctRandomGenerator;", "currentLevel", "", "convertOuroQuoteBlockToOpusParagraphs", "Lkntr/common/ouro/core/model/node/OuroQuoteBlock;", "combineHash", "convertOpusContentToOuroStorage", "opusContent", "linkParseService", "Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;", "(Lcom/bapis/bilibili/dynamic/common/KOpusContent;Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertIndependentParagraphToNode", "paragraph", "builder", "Lkntr/common/ouro/core/model/NodeStorageBuilder;", "convertListParagraphsToNode", "paragraphs", "convertQuoteParagraphsToNode", "convertTextNodeToOuroNode", "textNode", "Lcom/bapis/bilibili/dynamic/common/KTextNode;", "convertTextNodeToOuroNodeStorage", "convertWordNodeStyleToMarks", "wordNode", "toOuroColor", "Lcom/bapis/bilibili/dynamic/common/KColors;", "addTextNodeToOuroParagraph", "textParagraph", "getCombineHashOrNull", "p", "needCommit", "", "prevCombineHash", "currCombineHash", "prevParaType", "Lcom/bapis/bilibili/dynamic/common/KParagraph$KParagraphType;", "currParaType", "listParagraphs", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OpusConverterKt {
    private static final String TAG = "OpusConverter";

    public static final /* synthetic */ <MARK extends OuroMark> OuroMarks<MARK> getMergedMarks(NodeStorage<?> nodeStorage, OuroNode.Markable<MARK> markable) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(markable, "node");
        OuroMarks ouroMarks = new OuroMarks(null, 1, null);
        Intrinsics.needClassReification();
        return (OuroMarks) OuroNodeStorageUtilsKt.reduce(nodeStorage, markable, ouroMarks, OpusConverterKt$getMergedMarks$1.INSTANCE);
    }

    public static final KOpusContent toOpusContent(NodeStorage<OuroDocument> nodeStorage, OuroLocalImageState localImageState) {
        List emptyList;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Iterable children = nodeStorage.getChildren(nodeStorage.getRoot());
        if (children == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            Iterable $this$flatMap$iv = children;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                OuroNode it = (OuroNode) element$iv$iv;
                Iterable list$iv$iv = convertOuroNodeToOpusParagraphs(nodeStorage, it, localImageState);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            emptyList = (List) destination$iv$iv;
        }
        List paras = emptyList;
        return new KOpusContent(paras);
    }

    private static final KWordNode convertTextElementToWordNode(NodeStorage<?> nodeStorage, OuroTextElement textElement) {
        KBgStyle bgStyle;
        OuroTextElement node$iv = textElement;
        boolean z = true;
        OuroMarks marks = (OuroMarks) OuroNodeStorageUtilsKt.reduce(nodeStorage, node$iv, new OuroMarks(null, 1, null), new Function2<OuroMarks<OuroTextMark>, OuroNode, OuroMarks<OuroTextMark>>() { // from class: kntr.common.ouro.core.converter.OpusConverterKt$convertTextElementToWordNode$$inlined$getMergedMarks$1
            public final OuroMarks<OuroTextMark> invoke(OuroMarks<OuroTextMark> ouroMarks, OuroNode node) {
                Intrinsics.checkNotNullParameter(ouroMarks, "acc");
                Intrinsics.checkNotNullParameter(node, "node");
                if (node instanceof OuroNode.Markable) {
                    Iterable $this$filterInstanceOf$iv = ((OuroNode.Markable) node).getMarks();
                    Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
                    Collection destination$iv$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                        if (element$iv$iv$iv instanceof OuroTextMark) {
                            destination$iv$iv$iv.add(element$iv$iv$iv);
                        }
                    }
                    return OuroMarksKt.mergeParent(ouroMarks, new OuroMarks(new OuroMarks((List) destination$iv$iv$iv)));
                }
                return ouroMarks;
            }
        });
        OuroColor foreGroundColor = extractForegroundColor(marks);
        OuroColor bgColor = extractBackgroundColorOrNull(marks);
        if (bgColor == null) {
            bgStyle = null;
        } else {
            bgStyle = new KBgStyle(KBgStyle.KStyle.HALF_BOTTOM.INSTANCE, new KColors(ConverterUtilsKt.toHexColorString(bgColor.getLightColor()), ConverterUtilsKt.toHexColorString(bgColor.getDarkColor()), bgColor.getName()));
        }
        OpusFontLevel fontLevel = extractFontLevelFromOuroTextElement(nodeStorage, textElement);
        String meta = textElement.getMeta();
        if (!marks.contains((Object) OuroSemiBoldMark.INSTANCE) && !marks.contains((Object) OuroMediumMark.INSTANCE)) {
            z = false;
        }
        return new KWordNode(meta, 0.0d, ConverterUtilsKt.toHexColorString(foreGroundColor.getLightColor()), ConverterUtilsKt.toHexColorString(foreGroundColor.getDarkColor()), new KWordNode.KWordNodeStyle(z, marks.contains((OuroMark.Key<?>) OuroItalicMark.Key.INSTANCE), marks.contains((OuroMark.Key<?>) OuroStrikethroughMark.Key.INSTANCE), marks.contains((OuroMark.Key<?>) OuroUnderlineMark.Key.INSTANCE)), fontLevel.getLevel(), (String) null, bgStyle, foreGroundColor.getName(), 66, (DefaultConstructorMarker) null);
    }

    private static final OuroColor extractForegroundColor(OuroMarks<OuroTextMark> ouroMarks) {
        Object element$iv;
        OuroMarks<OuroTextMark> $this$firstOrNull$iv = ouroMarks;
        Iterator<MARK> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                if (((OuroTextMark) element$iv) instanceof OuroForegroundColorMark) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        OuroTextMark it2 = (OuroTextMark) element$iv;
        if (it2 != null) {
            OuroForegroundColorMark mark = (OuroForegroundColorMark) it2;
            OuroColor color = mark.getColor();
            if (color != null) {
                return color;
            }
        }
        return OuroColor.Companion.getGa9();
    }

    private static final OuroColor extractBackgroundColorOrNull(OuroMarks<OuroTextMark> ouroMarks) {
        Object element$iv;
        OuroMarks<OuroTextMark> $this$firstOrNull$iv = ouroMarks;
        Iterator<MARK> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                if (((OuroTextMark) element$iv) instanceof OuroBackgroundColorMark) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        OuroTextMark it2 = (OuroTextMark) element$iv;
        if (it2 != null) {
            return ((OuroBackgroundColorMark) it2).getColor();
        }
        return null;
    }

    private static final OpusFontLevel extractFontLevelFromOuroTextElement(NodeStorage<?> nodeStorage, OuroTextElement node) {
        NodeStorage<?> $this$findFirstAncestorOrNull$iv = nodeStorage;
        OuroTextElement node$iv = node;
        OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.converter.OpusConverterKt$extractFontLevelFromOuroTextElement$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroParagraph);
            }
        }) : null;
        OuroParagraph p = firstAncestorOrNull instanceof OuroParagraph ? firstAncestorOrNull : null;
        if (p instanceof OuroH1) {
            return OpusFontLevel.XXLarge;
        }
        if (p instanceof OuroH2) {
            return OpusFontLevel.XLarge;
        }
        if (p instanceof OuroH3) {
            return OpusFontLevel.Large;
        }
        if (!(p instanceof OuroText) && p != null) {
            throw new NoWhenBranchMatchedException();
        }
        return OpusFontLevel.Regular;
    }

    public static final List<KParagraph> convertOuroNodeToOpusParagraphs(NodeStorage<?> nodeStorage, OuroNode node, OuroLocalImageState localImageState) {
        OuroNode firstChild;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        DistinctRandomGenerator randomGenerator = new DistinctRandomGenerator(0, 0, 3, null);
        if (node instanceof OuroParagraph) {
            return CollectionsKt.listOf(convertOuroParagraphToOpusParagraph(nodeStorage, (OuroParagraph) node));
        }
        if (node instanceof OuroBoxContainer) {
            List<OuroNode> children = nodeStorage.getChildren((OuroNode.Parent) node);
            if (children == null || (firstChild = (OuroNode) CollectionsKt.firstOrNull(children)) == null) {
                return CollectionsKt.emptyList();
            }
            if (firstChild instanceof OuroUnrecognizedCard) {
                BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
                byte[] bytes$iv = ((OuroUnrecognizedCard) firstChild).getMeta();
                $this$decodeFromByteArray$iv.getSerializersModule();
                return CollectionsKt.listOf($this$decodeFromByteArray$iv.decodeFromByteArray(KParagraph.Companion.serializer(), bytes$iv));
            } else if (firstChild instanceof OuroDivider) {
                return CollectionsKt.listOf(new KParagraph(KParagraph.KParagraphType.LINE.INSTANCE, (KParagraph.KParagraphFormat) null, (KTextParagraph) null, (KPicParagraph) null, new KLineParagraph((KPic) null, KLineParagraph.KLineType.HR.INSTANCE, 1, (DefaultConstructorMarker) null), (KCardParagraph) null, (KCodeParagraph) null, 110, (DefaultConstructorMarker) null));
            } else {
                Iterable $this$filterNot$iv = CollectionsKt.listOf(new KParagraph(KParagraph.KParagraphType.PICTURES.INSTANCE, (KParagraph.KParagraphFormat) null, (KTextParagraph) null, convertOuroBoxContainerToPicParagraph(nodeStorage, (OuroBoxContainer) node, localImageState), (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, (int) ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT, (DefaultConstructorMarker) null));
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filterNot$iv) {
                    KParagraph it = (KParagraph) element$iv$iv;
                    KPicParagraph pic = it.getPic();
                    List pics = pic != null ? pic.getPics() : null;
                    if (!(pics == null || pics.isEmpty())) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                return (List) destination$iv$iv;
            }
        } else if (node instanceof OuroQuoteBlock) {
            return convertOuroQuoteBlockToOpusParagraphs(nodeStorage, (OuroQuoteBlock) node, randomGenerator.generate("quote"));
        } else {
            return node instanceof OuroList ? convertOuroListToOpusParagraphs$default(nodeStorage, (OuroList) node, randomGenerator, 0, 4, null) : CollectionsKt.emptyList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final KParagraph convertOuroParagraphToOpusParagraph(NodeStorage<?> nodeStorage, OuroParagraph node) {
        KParagraph.KParagraphType type;
        KParagraph.KHeadingType kHeadingType;
        Object element$iv;
        KParagraph.KParagraphAlign align;
        Object element$iv2;
        Object element$iv3;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        if ((node instanceof OuroH1) || (node instanceof OuroH2) || (node instanceof OuroH3)) {
            type = KParagraph.KParagraphType.HEADING.INSTANCE;
        } else if (!(node instanceof OuroText)) {
            throw new NoWhenBranchMatchedException();
        } else {
            type = (KParagraph.KParagraphType) KParagraph.KParagraphType.TEXT.INSTANCE;
        }
        if (node instanceof OuroH1) {
            kHeadingType = (KParagraph.KHeadingType) KParagraph.KHeadingType.H1.INSTANCE;
        } else if (node instanceof OuroH2) {
            kHeadingType = (KParagraph.KHeadingType) KParagraph.KHeadingType.H2.INSTANCE;
        } else {
            kHeadingType = node instanceof OuroH3 ? (KParagraph.KHeadingType) KParagraph.KHeadingType.H3.INSTANCE : KParagraph.KHeadingType.H_DEFAULT.INSTANCE;
        }
        KParagraph.KHeadingType headingType = kHeadingType;
        Iterable $this$firstOrNull$iv = node.getParagraphMarks();
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                OuroParagraphMark it2 = (OuroParagraphMark) element$iv;
                if (it2 instanceof OuroTextAlignMark) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        OuroParagraphMark alignMark = (OuroParagraphMark) element$iv;
        if (alignMark instanceof OuroTextAlignStartMark) {
            align = (KParagraph.KParagraphAlign) KParagraph.KParagraphAlign.LEFT.INSTANCE;
        } else if (alignMark instanceof OuroTextAlignCenterMark) {
            align = (KParagraph.KParagraphAlign) KParagraph.KParagraphAlign.MIDDLE.INSTANCE;
        } else {
            align = alignMark instanceof OuroTextAlignEndMark ? (KParagraph.KParagraphAlign) KParagraph.KParagraphAlign.RIGHT.INSTANCE : KParagraph.KParagraphAlign.LEFT.INSTANCE;
        }
        Iterable $this$firstOrNull$iv2 = node.getParagraphMarks();
        Iterator it3 = $this$firstOrNull$iv2.iterator();
        while (true) {
            if (it3.hasNext()) {
                element$iv2 = it3.next();
                OuroParagraphMark it4 = (OuroParagraphMark) element$iv2;
                if (it4 instanceof OuroTextIndentMark) {
                    break;
                }
            } else {
                element$iv2 = null;
                break;
            }
        }
        OuroTextIndentMark ouroTextIndentMark = element$iv2 instanceof OuroTextIndentMark ? (OuroTextIndentMark) element$iv2 : null;
        float firstLineIndent = ouroTextIndentMark != null ? ouroTextIndentMark.getFirstLine() : 0.0f;
        Iterable $this$firstOrNull$iv3 = node.getParagraphMarks();
        Iterator it5 = $this$firstOrNull$iv3.iterator();
        while (true) {
            if (it5.hasNext()) {
                element$iv3 = it5.next();
                OuroParagraphMark it6 = (OuroParagraphMark) element$iv3;
                if (it6 instanceof OuroTextIndentMark) {
                    break;
                }
            } else {
                element$iv3 = null;
                break;
            }
        }
        OuroTextIndentMark ouroTextIndentMark2 = element$iv3 instanceof OuroTextIndentMark ? (OuroTextIndentMark) element$iv3 : null;
        float hangingIndent = ouroTextIndentMark2 != null ? ouroTextIndentMark2.getHanging() : 0.0f;
        KParagraph.KIndentFormat indent = new KParagraph.KIndentFormat(RangesKt.coerceIn((int) ((firstLineIndent - hangingIndent) / 22.0f), 0, 3), RangesKt.coerceIn((int) (hangingIndent / 22.0f), 0, 3));
        KParagraph.KParagraphFormat format = new KParagraph.KParagraphFormat(align, (KParagraph.KListFormat) null, indent, (String) null, Intrinsics.areEqual(type, KParagraph.KParagraphType.HEADING.INSTANCE) ? headingType : (KParagraph.KHeadingType) KParagraph.KHeadingType.H_DEFAULT.INSTANCE, 10, (DefaultConstructorMarker) null);
        KTextParagraph textParagraph = convertOuroParagraphToTextParagraph(nodeStorage, node);
        return new KParagraph(type, format, textParagraph, (KPicParagraph) null, (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (DefaultConstructorMarker) null);
    }

    public static final KTextParagraph convertOuroParagraphToTextParagraph(NodeStorage<?> nodeStorage, OuroParagraph node) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        List textNodes = new ArrayList();
        Iterable children = nodeStorage.getChildren(node);
        if (children != null) {
            Iterable $this$forEach$iv = children;
            for (Object element$iv : $this$forEach$iv) {
                OuroNode childNode = (OuroNode) element$iv;
                if (childNode instanceof OuroTextElement) {
                    if (!(childNode instanceof OuroTextElement.HardBreak)) {
                        textNodes.add(new KTextNode(KTextNode.KTextNodeType.WORDS.INSTANCE, convertTextElementToWordNode(nodeStorage, (OuroTextElement) childNode), (KEmoteNode) null, (KLinkNode) null, (KFormulaNode) null, 28, (DefaultConstructorMarker) null));
                    }
                } else if (childNode instanceof OuroUniversalLink) {
                    textNodes.add(new KTextNode(KTextNode.KTextNodeType.BIZ_LINK.INSTANCE, (KWordNode) null, (KEmoteNode) null, convertUniversalLinkToLinkNode(nodeStorage, (OuroUniversalLink) childNode), (KFormulaNode) null, 22, (DefaultConstructorMarker) null));
                } else if (childNode instanceof OuroAtMentionLink) {
                    textNodes.add(new KTextNode(KTextNode.KTextNodeType.AT.INSTANCE, (KWordNode) null, (KEmoteNode) null, convertAtMentionLinkToLinkNode(nodeStorage, (OuroAtMentionLink) childNode), (KFormulaNode) null, 22, (DefaultConstructorMarker) null));
                } else if (childNode instanceof OuroInlineContent) {
                    textNodes.add(new KTextNode(KTextNode.KTextNodeType.EMOTE.INSTANCE, (KWordNode) null, convertOuroInlineContentToEmoteNode(nodeStorage, (OuroInlineContent) childNode), (KLinkNode) null, (KFormulaNode) null, 26, (DefaultConstructorMarker) null));
                }
            }
        }
        return new KTextParagraph(textNodes);
    }

    public static final KEmoteNode convertOuroInlineContentToEmoteNode(NodeStorage<?> nodeStorage, OuroInlineContent inlineContent) {
        OuroNode ouroNode;
        Object element$iv;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(inlineContent, "inlineContent");
        Iterable children = nodeStorage.getChildren(inlineContent);
        if (children == null) {
            ouroNode = null;
        } else {
            Iterable $this$firstOrNull$iv = children;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    OuroNode it2 = (OuroNode) element$iv;
                    if (it2 instanceof OuroRemoteImage) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            ouroNode = (OuroNode) element$iv;
        }
        OuroNode imageChild = ouroNode;
        String rawText = imageChild instanceof OuroRemoteImage.Sticker ? ((OuroRemoteImage.Sticker) imageChild).getRawText() : "[表情]";
        OuroBackgroundColorMark ouroBackgroundColorMark = (OuroBackgroundColorMark) inlineContent.getMarks().get(OuroBackgroundColorMark.Key.INSTANCE);
        OuroColor bgColor = ouroBackgroundColorMark != null ? ouroBackgroundColorMark.getColor() : null;
        if (bgColor != null) {
            KBgStyle bgStyle = new KBgStyle(KBgStyle.KStyle.HALF_BOTTOM.INSTANCE, new KColors(ConverterUtilsKt.toHexColorString(bgColor.getLightColor()), ConverterUtilsKt.toHexColorString(bgColor.getDarkColor()), bgColor.getName()));
            return new KEmoteNode(rawText, bgStyle);
        }
        return new KEmoteNode(rawText, (KBgStyle) null, 2, (DefaultConstructorMarker) null);
    }

    public static final KPicParagraph convertOuroBoxContainerToPicParagraph(NodeStorage<?> nodeStorage, OuroBoxContainer boxContainer, OuroLocalImageState localImageState) {
        KPicParagraph.KPicParagraphStyle style;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(boxContainer, "boxContainer");
        List pics = new ArrayList();
        Iterable children = nodeStorage.getChildren(boxContainer);
        if (children != null) {
            Iterable $this$forEach$iv = children;
            for (Object element$iv : $this$forEach$iv) {
                OuroNode child = (OuroNode) element$iv;
                if (child instanceof OuroRemoteImage.Image) {
                    pics.add(new KPic(((OuroRemoteImage.Image) child).getLightImageURL(), ((OuroRemoteImage.Image) child).getWidth(), ((OuroRemoteImage.Image) child).getHeight(), 0.0d, (String) null, false, 0.0d, 0.0d, (String) null, (String) null, ((OuroRemoteImage.Image) child).getAIGenMark(), 1016, (DefaultConstructorMarker) null));
                } else if (child instanceof OuroRemoteImage.Sticker) {
                    pics.add(new KPic(((OuroRemoteImage.Sticker) child).getLightImageURL(), ((OuroRemoteImage.Sticker) child).getWidth(), ((OuroRemoteImage.Sticker) child).getHeight(), 0.0d, (String) null, false, 0.0d, 0.0d, (String) null, (String) null, 0, 2040, (DefaultConstructorMarker) null));
                } else if (child instanceof OuroLocalImage) {
                    UploadTaskState uploadState = localImageState != null ? localImageState.getTaskState().get(((OuroLocalImage) child).getAsset().getIdentifier()) : null;
                    if (uploadState instanceof UploadTaskState.Success) {
                        pics.add(new KPic(((UploadTaskState.Success) uploadState).getImageUrl(), ((UploadTaskState.Success) uploadState).getImageWidth(), ((UploadTaskState.Success) uploadState).getImageHeight(), ((UploadTaskState.Success) uploadState).getImageSize(), (String) null, false, 0.0d, 0.0d, (String) null, (String) null, ((UploadTaskState.Success) uploadState).getAIGenMark(), 1008, (DefaultConstructorMarker) null));
                    }
                }
            }
        }
        if (pics.size() > 1) {
            style = (KPicParagraph.KPicParagraphStyle) KPicParagraph.KPicParagraphStyle.NINE_CELL.INSTANCE;
        } else {
            style = KPicParagraph.KPicParagraphStyle.DEFAULT.INSTANCE;
        }
        return new KPicParagraph(pics, style);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
        if (r9 == null) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final KLinkNode convertUniversalLinkToLinkNode(NodeStorage<?> nodeStorage, OuroUniversalLink link) {
        OuroNode ouroNode;
        OuroMarks textMarks;
        KLinkNode kLinkNode;
        String displayText;
        OuroColor it;
        OuroColor it2;
        Object element$iv;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(link, "link");
        Iterable children = nodeStorage.getChildren(link);
        if (children != null) {
            Iterable $this$firstOrNull$iv = children;
            Iterator<T> it3 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it3.next();
                if (((OuroNode) element$iv) instanceof OuroTextElement) {
                    break;
                }
            }
            ouroNode = (OuroNode) element$iv;
        } else {
            ouroNode = null;
        }
        OuroNode.Markable styleTarget = ouroNode instanceof OuroTextElement ? (OuroTextElement) ouroNode : null;
        if (styleTarget != null) {
            OuroNode.Markable node$iv = styleTarget;
            textMarks = (OuroMarks) OuroNodeStorageUtilsKt.reduce(nodeStorage, node$iv, new OuroMarks(null, 1, null), new Function2<OuroMarks<OuroTextMark>, OuroNode, OuroMarks<OuroTextMark>>() { // from class: kntr.common.ouro.core.converter.OpusConverterKt$convertUniversalLinkToLinkNode$lambda$1$$inlined$getMergedMarks$1
                public final OuroMarks<OuroTextMark> invoke(OuroMarks<OuroTextMark> ouroMarks, OuroNode node) {
                    Intrinsics.checkNotNullParameter(ouroMarks, "acc");
                    Intrinsics.checkNotNullParameter(node, "node");
                    if (node instanceof OuroNode.Markable) {
                        Iterable $this$filterInstanceOf$iv = ((OuroNode.Markable) node).getMarks();
                        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
                        Collection destination$iv$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                            if (element$iv$iv$iv instanceof OuroTextMark) {
                                destination$iv$iv$iv.add(element$iv$iv$iv);
                            }
                        }
                        return OuroMarksKt.mergeParent(ouroMarks, new OuroMarks(new OuroMarks((List) destination$iv$iv$iv)));
                    }
                    return ouroMarks;
                }
            });
        }
        textMarks = OuroMarks.Empty.INSTANCE.getTextMarks();
        OuroMarks marks = textMarks;
        byte[] it4 = link.getEncodedData();
        if (it4 != null) {
            BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
            $this$decodeFromByteArray$iv.getSerializersModule();
            kLinkNode = (KLinkNode) $this$decodeFromByteArray$iv.decodeFromByteArray(KLinkNode.Companion.serializer(), it4);
        } else {
            kLinkNode = null;
        }
        KLinkNode encodedLinkNode = kLinkNode;
        if (encodedLinkNode != null) {
            KLinkNode.KLinkNodeStyle kLinkNodeStyle = new KLinkNode.KLinkNodeStyle(marks.contains(OuroSemiBoldMark.INSTANCE), marks.contains(OuroItalicMark.INSTANCE), marks.contains(OuroStrikethroughMark.INSTANCE), marks.contains(OuroUnderlineMark.INSTANCE), 0.0d, (String) null, 48, (DefaultConstructorMarker) null);
            OuroBackgroundColorMark ouroBackgroundColorMark = (OuroBackgroundColorMark) marks.get(OuroBackgroundColorMark.Key.INSTANCE);
            return KLinkNode.copy$default(encodedLinkNode, (String) null, (String) null, (String) null, (String) null, (KOpusBizType) null, (String) null, (KVideoTs) null, kLinkNodeStyle, (List) null, (ouroBackgroundColorMark == null || (it2 = ouroBackgroundColorMark.getColor()) == null) ? null : new KBgStyle(KBgStyle.KStyle.HALF_BOTTOM.INSTANCE, new KColors(ConverterUtilsKt.toHexColorString(it2.getLightColor()), ConverterUtilsKt.toHexColorString(it2.getDarkColor()), it2.getName())), (KContentLinkCard) null, (KLinkNode.KHashTagType) null, 3455, (Object) null);
        }
        Iterable children2 = nodeStorage.getChildren(link);
        if (children2 != null) {
            Iterable $this$mapNotNull$iv = children2;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                OuroNode childNode = (OuroNode) element$iv$iv$iv;
                String meta = childNode instanceof OuroTextElement ? ((OuroTextElement) childNode).getMeta() : null;
                if (meta != null) {
                    destination$iv$iv.add(meta);
                }
            }
            String joinToString$default = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (joinToString$default != null) {
                displayText = joinToString$default;
                String meta2 = link.getMeta();
                KOpusBizType kOpusBizType = KOpusBizType.URL.INSTANCE;
                KLinkNode.KLinkNodeStyle kLinkNodeStyle2 = new KLinkNode.KLinkNodeStyle(marks.contains(OuroSemiBoldMark.INSTANCE), marks.contains(OuroItalicMark.INSTANCE), marks.contains(OuroStrikethroughMark.INSTANCE), marks.contains(OuroUnderlineMark.INSTANCE), 0.0d, (String) null, 48, (DefaultConstructorMarker) null);
                OuroBackgroundColorMark ouroBackgroundColorMark2 = (OuroBackgroundColorMark) marks.get(OuroBackgroundColorMark.Key.INSTANCE);
                return new KLinkNode(displayText, meta2, (String) null, (String) null, kOpusBizType, (String) null, (KVideoTs) null, kLinkNodeStyle2, (List) null, (ouroBackgroundColorMark2 != null || (it = ouroBackgroundColorMark2.getColor()) == null) ? null : new KBgStyle(KBgStyle.KStyle.HALF_BOTTOM.INSTANCE, new KColors(ConverterUtilsKt.toHexColorString(it.getLightColor()), ConverterUtilsKt.toHexColorString(it.getDarkColor()), it.getName())), (KContentLinkCard) null, (KLinkNode.KHashTagType) null, 3436, (DefaultConstructorMarker) null);
            }
        }
        displayText = "";
        String meta22 = link.getMeta();
        KOpusBizType kOpusBizType2 = KOpusBizType.URL.INSTANCE;
        KLinkNode.KLinkNodeStyle kLinkNodeStyle22 = new KLinkNode.KLinkNodeStyle(marks.contains(OuroSemiBoldMark.INSTANCE), marks.contains(OuroItalicMark.INSTANCE), marks.contains(OuroStrikethroughMark.INSTANCE), marks.contains(OuroUnderlineMark.INSTANCE), 0.0d, (String) null, 48, (DefaultConstructorMarker) null);
        OuroBackgroundColorMark ouroBackgroundColorMark22 = (OuroBackgroundColorMark) marks.get(OuroBackgroundColorMark.Key.INSTANCE);
        return new KLinkNode(displayText, meta22, (String) null, (String) null, kOpusBizType2, (String) null, (KVideoTs) null, kLinkNodeStyle22, (List) null, (ouroBackgroundColorMark22 != null || (it = ouroBackgroundColorMark22.getColor()) == null) ? null : new KBgStyle(KBgStyle.KStyle.HALF_BOTTOM.INSTANCE, new KColors(ConverterUtilsKt.toHexColorString(it.getLightColor()), ConverterUtilsKt.toHexColorString(it.getDarkColor()), it.getName())), (KContentLinkCard) null, (KLinkNode.KHashTagType) null, 3436, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d0, code lost:
        if (r8 == null) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final KLinkNode convertAtMentionLinkToLinkNode(NodeStorage<?> nodeStorage, OuroAtMentionLink link) {
        String displayText;
        Iterable children;
        OuroNode ouroNode;
        OuroNode.Markable styleTarget;
        KBgStyle kBgStyle;
        OuroMarks textMarks;
        OuroColor it;
        Object element$iv;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(link, "link");
        Iterable children2 = nodeStorage.getChildren(link);
        if (children2 != null) {
            Iterable $this$mapNotNull$iv = children2;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                OuroNode childNode = (OuroNode) element$iv$iv$iv;
                String meta = childNode instanceof OuroTextElement ? ((OuroTextElement) childNode).getMeta() : null;
                if (meta != null) {
                    destination$iv$iv.add(meta);
                }
            }
            String joinToString$default = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (joinToString$default != null) {
                displayText = joinToString$default;
                children = nodeStorage.getChildren(link);
                if (children == null) {
                    Iterable $this$firstOrNull$iv = children;
                    Iterator<T> it2 = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it2.next();
                        if (((OuroNode) element$iv) instanceof OuroTextElement) {
                            break;
                        }
                    }
                    ouroNode = (OuroNode) element$iv;
                } else {
                    ouroNode = null;
                }
                styleTarget = !(ouroNode instanceof OuroTextElement) ? (OuroTextElement) ouroNode : null;
                if (styleTarget == null) {
                    OuroNode.Markable node$iv = styleTarget;
                    kBgStyle = null;
                    textMarks = (OuroMarks) OuroNodeStorageUtilsKt.reduce(nodeStorage, node$iv, new OuroMarks(null, 1, null), new Function2<OuroMarks<OuroTextMark>, OuroNode, OuroMarks<OuroTextMark>>() { // from class: kntr.common.ouro.core.converter.OpusConverterKt$convertAtMentionLinkToLinkNode$lambda$2$$inlined$getMergedMarks$1
                        public final OuroMarks<OuroTextMark> invoke(OuroMarks<OuroTextMark> ouroMarks, OuroNode node) {
                            Intrinsics.checkNotNullParameter(ouroMarks, "acc");
                            Intrinsics.checkNotNullParameter(node, "node");
                            if (node instanceof OuroNode.Markable) {
                                Iterable $this$filterInstanceOf$iv = ((OuroNode.Markable) node).getMarks();
                                Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
                                Collection destination$iv$iv$iv = new ArrayList();
                                for (Object element$iv$iv$iv2 : $this$filterIsInstance$iv$iv) {
                                    if (element$iv$iv$iv2 instanceof OuroTextMark) {
                                        destination$iv$iv$iv.add(element$iv$iv$iv2);
                                    }
                                }
                                return OuroMarksKt.mergeParent(ouroMarks, new OuroMarks(new OuroMarks((List) destination$iv$iv$iv)));
                            }
                            return ouroMarks;
                        }
                    });
                } else {
                    kBgStyle = null;
                }
                textMarks = OuroMarks.Empty.INSTANCE.getTextMarks();
                OuroMarks marks = textMarks;
                String valueOf = String.valueOf(link.getMeta().getId());
                KOpusBizType kOpusBizType = KOpusBizType.AT.INSTANCE;
                KLinkNode.KLinkNodeStyle kLinkNodeStyle = new KLinkNode.KLinkNodeStyle(marks.contains(OuroSemiBoldMark.INSTANCE), marks.contains(OuroItalicMark.INSTANCE), marks.contains(OuroStrikethroughMark.INSTANCE), marks.contains(OuroUnderlineMark.INSTANCE), 0.0d, (String) null, 48, (DefaultConstructorMarker) null);
                OuroBackgroundColorMark ouroBackgroundColorMark = (OuroBackgroundColorMark) marks.get(OuroBackgroundColorMark.Key.INSTANCE);
                return new KLinkNode(displayText, (String) null, (String) null, (String) null, kOpusBizType, valueOf, (KVideoTs) null, kLinkNodeStyle, (List) null, (ouroBackgroundColorMark != null || (it = ouroBackgroundColorMark.getColor()) == null) ? kBgStyle : new KBgStyle(KBgStyle.KStyle.HALF_BOTTOM.INSTANCE, new KColors(ConverterUtilsKt.toHexColorString(it.getLightColor()), ConverterUtilsKt.toHexColorString(it.getDarkColor()), it.getName())), (KContentLinkCard) null, (KLinkNode.KHashTagType) null, 3406, (DefaultConstructorMarker) null);
            }
        }
        displayText = "";
        children = nodeStorage.getChildren(link);
        if (children == null) {
        }
        styleTarget = !(ouroNode instanceof OuroTextElement) ? (OuroTextElement) ouroNode : null;
        if (styleTarget == null) {
        }
        textMarks = OuroMarks.Empty.INSTANCE.getTextMarks();
        OuroMarks marks2 = textMarks;
        String valueOf2 = String.valueOf(link.getMeta().getId());
        KOpusBizType kOpusBizType2 = KOpusBizType.AT.INSTANCE;
        KLinkNode.KLinkNodeStyle kLinkNodeStyle2 = new KLinkNode.KLinkNodeStyle(marks2.contains(OuroSemiBoldMark.INSTANCE), marks2.contains(OuroItalicMark.INSTANCE), marks2.contains(OuroStrikethroughMark.INSTANCE), marks2.contains(OuroUnderlineMark.INSTANCE), 0.0d, (String) null, 48, (DefaultConstructorMarker) null);
        OuroBackgroundColorMark ouroBackgroundColorMark2 = (OuroBackgroundColorMark) marks2.get(OuroBackgroundColorMark.Key.INSTANCE);
        return new KLinkNode(displayText, (String) null, (String) null, (String) null, kOpusBizType2, valueOf2, (KVideoTs) null, kLinkNodeStyle2, (List) null, (ouroBackgroundColorMark2 != null || (it = ouroBackgroundColorMark2.getColor()) == null) ? kBgStyle : new KBgStyle(KBgStyle.KStyle.HALF_BOTTOM.INSTANCE, new KColors(ConverterUtilsKt.toHexColorString(it.getLightColor()), ConverterUtilsKt.toHexColorString(it.getDarkColor()), it.getName())), (KContentLinkCard) null, (KLinkNode.KHashTagType) null, 3406, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ List convertOuroListToOpusParagraphs$default(NodeStorage nodeStorage, OuroList ouroList, DistinctRandomGenerator distinctRandomGenerator, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return convertOuroListToOpusParagraphs(nodeStorage, ouroList, distinctRandomGenerator, i);
    }

    public static final List<KParagraph> convertOuroListToOpusParagraphs(NodeStorage<?> nodeStorage, OuroList node, DistinctRandomGenerator randomGenerator, int currentLevel) {
        Iterable children;
        OuroNode childNode;
        String theme;
        KParagraph.KParagraphType kParagraphType;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        List paragraphs = new ArrayList();
        boolean isOrdered = node instanceof OuroOrderedList;
        String combineHash = randomGenerator.generate("list");
        int startIndex = node.getStartIndex();
        Iterable children2 = nodeStorage.getChildren(node);
        if (children2 != null) {
            Iterable $this$forEachIndexed$iv = children2;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                OuroNode childNode2 = (OuroNode) item$iv;
                int index = index$iv;
                if ((childNode2 instanceof OuroListItem) && (children = nodeStorage.getChildren((OuroNode.Parent) childNode2)) != null) {
                    Iterable $this$forEachIndexed$iv2 = children;
                    int index$iv3 = 0;
                    for (Object item$iv2 : $this$forEachIndexed$iv2) {
                        int index$iv4 = index$iv3 + 1;
                        if (index$iv3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        OuroNode listItemChild = (OuroNode) item$iv2;
                        int idx = index$iv3;
                        if (listItemChild instanceof OuroParagraph) {
                            if (idx == 0) {
                                switch (currentLevel % 3) {
                                    case 0:
                                        theme = isOrdered ? "roman_num" : "circle";
                                        break;
                                    case 1:
                                        if (isOrdered) {
                                            theme = "arabic_num";
                                            break;
                                        } else {
                                            theme = "dot";
                                            break;
                                        }
                                    case 2:
                                        theme = isOrdered ? "lower_letter" : "square";
                                        break;
                                    default:
                                        if (isOrdered) {
                                            theme = "arabic_num";
                                            break;
                                        } else {
                                            theme = "dot";
                                            break;
                                        }
                                }
                                KParagraph.KListFormat listFormat = new KParagraph.KListFormat(currentLevel, startIndex + index + 1, theme, (KParagraph.KListFormat.KOrderStyle) null, 8, (DefaultConstructorMarker) null);
                                childNode = childNode2;
                                KParagraph.KParagraphFormat format = new KParagraph.KParagraphFormat(KParagraph.KParagraphAlign.LEFT.INSTANCE, listFormat, (KParagraph.KIndentFormat) null, combineHash, (KParagraph.KHeadingType) null, 20, (DefaultConstructorMarker) null);
                                KTextParagraph textParagraph = convertOuroParagraphToTextParagraph(nodeStorage, (OuroParagraph) listItemChild);
                                if (isOrdered) {
                                    kParagraphType = (KParagraph.KParagraphType) KParagraph.KParagraphType.SORTED_LIST.INSTANCE;
                                } else {
                                    kParagraphType = KParagraph.KParagraphType.UNSORTED_LIST.INSTANCE;
                                }
                                paragraphs.add(new KParagraph(kParagraphType, format, textParagraph, (KPicParagraph) null, (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (DefaultConstructorMarker) null));
                            } else {
                                childNode = childNode2;
                                KTextParagraph textParagraph2 = convertOuroParagraphToTextParagraph(nodeStorage, (OuroParagraph) listItemChild);
                                KParagraph.KParagraphFormat format2 = new KParagraph.KParagraphFormat(KParagraph.KParagraphAlign.LEFT.INSTANCE, (KParagraph.KListFormat) null, (KParagraph.KIndentFormat) null, combineHash, (KParagraph.KHeadingType) null, 22, (DefaultConstructorMarker) null);
                                paragraphs.add(new KParagraph(KParagraph.KParagraphType.TEXT.INSTANCE, format2, textParagraph2, (KPicParagraph) null, (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (DefaultConstructorMarker) null));
                            }
                        } else {
                            childNode = childNode2;
                            if (listItemChild instanceof OuroList) {
                                List nestedParagraphs = convertOuroListToOpusParagraphs(nodeStorage, (OuroList) listItemChild, randomGenerator, currentLevel + 1);
                                paragraphs.addAll(nestedParagraphs);
                            }
                        }
                        childNode2 = childNode;
                        index$iv3 = index$iv4;
                    }
                }
                index$iv = index$iv2;
            }
        }
        return paragraphs;
    }

    public static final List<KParagraph> convertOuroQuoteBlockToOpusParagraphs(NodeStorage<?> nodeStorage, OuroQuoteBlock node, String combineHash) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(combineHash, "combineHash");
        List paragraphs = new ArrayList();
        Iterable children = nodeStorage.getChildren(node);
        if (children != null) {
            Iterable $this$forEach$iv = children;
            for (Object element$iv : $this$forEach$iv) {
                OuroNode childNode = (OuroNode) element$iv;
                if (childNode instanceof OuroParagraph) {
                    KParagraph.KParagraphFormat format = new KParagraph.KParagraphFormat(KParagraph.KParagraphAlign.LEFT.INSTANCE, (KParagraph.KListFormat) null, (KParagraph.KIndentFormat) null, combineHash, (KParagraph.KHeadingType) null, 22, (DefaultConstructorMarker) null);
                    KTextParagraph textParagraph = convertOuroParagraphToTextParagraph(nodeStorage, (OuroParagraph) childNode);
                    paragraphs.add(new KParagraph(KParagraph.KParagraphType.REFERENCE.INSTANCE, format, textParagraph, (KPicParagraph) null, (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (DefaultConstructorMarker) null));
                }
            }
        }
        return paragraphs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0526  */
    /* JADX WARN: Type inference failed for: r30v1 */
    /* JADX WARN: Type inference failed for: r30v2 */
    /* JADX WARN: Type inference failed for: r30v3, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object convertOpusContentToOuroStorage(KOpusContent opusContent, LinkParseService linkParseService, Continuation<? super NodeStorage<OuroDocument>> continuation) {
        Continuation $continuation;
        NodeStorageBuilder builder;
        NodeStorageBuilder $this$convertOpusContentToOuroStorage_u24lambda_u240;
        List emotes;
        Ref.BooleanRef shouldCommitParagraphs;
        List<String> list;
        Object obj;
        Ref.ObjectRef prevParagraphType;
        Ref.ObjectRef prevCombineHash;
        int i;
        KOpusContent opusContent2;
        OuroNode ouroNode;
        String it;
        ?? r30;
        KParagraph paragraph;
        KOpusContent opusContent3;
        Throwable error;
        Map emoteParseResults;
        boolean z;
        int i2;
        if (continuation instanceof OpusConverterKt$convertOpusContentToOuroStorage$1) {
            $continuation = (OpusConverterKt$convertOpusContentToOuroStorage$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        OuroDocument document = new OuroDocument((OuroMarks) null, 1, (DefaultConstructorMarker) null);
                        builder = new NodeStorageBuilder(document, null, null, 6, null);
                        $this$convertOpusContentToOuroStorage_u24lambda_u240 = builder;
                        List listParagraphs = new ArrayList();
                        List quoteParagraphs = new ArrayList();
                        Ref.BooleanRef shouldCommitParagraphs2 = new Ref.BooleanRef();
                        Ref.ObjectRef prevCombineHash2 = new Ref.ObjectRef();
                        Ref.ObjectRef prevParagraphType2 = new Ref.ObjectRef();
                        prevParagraphType2.element = KParagraph.KParagraphType.DEFAULT.INSTANCE;
                        for (Object element$iv : opusContent.getParagraphs()) {
                            KParagraph paragraph2 = (KParagraph) element$iv;
                            String combineHash = getCombineHashOrNull(paragraph2);
                            Object $result2 = $result;
                            Ref.ObjectRef prevParagraphType3 = prevParagraphType2;
                            Object obj2 = coroutine_suspended;
                            Ref.ObjectRef prevCombineHash3 = prevCombineHash2;
                            shouldCommitParagraphs2.element = needCommit(paragraph2, (String) prevCombineHash2.element, combineHash, (KParagraph.KParagraphType) prevParagraphType2.element, paragraph2.getParaType(), listParagraphs);
                            prevCombineHash3.element = combineHash;
                            prevParagraphType3.element = paragraph2.getParaType();
                            String str = combineHash;
                            if ((str == null || str.length() == 0) || shouldCommitParagraphs2.element) {
                                if (!listParagraphs.isEmpty()) {
                                    OuroList it2 = convertListParagraphsToNode(listParagraphs, builder);
                                    if (it2 != null) {
                                        $this$convertOpusContentToOuroStorage_u24lambda_u240.add((OuroNode.Parent) builder.getRoot(), (OuroNode) it2);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    listParagraphs.clear();
                                } else if (!quoteParagraphs.isEmpty()) {
                                    OuroQuoteBlock it3 = convertQuoteParagraphsToNode(quoteParagraphs, builder);
                                    if (it3 != null) {
                                        $this$convertOpusContentToOuroStorage_u24lambda_u240.add((OuroNode.Parent) builder.getRoot(), (OuroNode) it3);
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    quoteParagraphs.clear();
                                }
                            }
                            KParagraph.KParagraphType paraType = paragraph2.getParaType();
                            if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.SORTED_LIST.INSTANCE)) {
                                paragraph = paragraph2;
                            } else if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.UNSORTED_LIST.INSTANCE)) {
                                paragraph = paragraph2;
                            } else {
                                if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.REFERENCE.INSTANCE)) {
                                    Boxing.boxBoolean(quoteParagraphs.add(paragraph2));
                                } else {
                                    String str2 = combineHash;
                                    if (str2 == null || str2.length() == 0) {
                                        OuroNode it4 = convertIndependentParagraphToNode(paragraph2, builder);
                                        if (it4 != null) {
                                            $this$convertOpusContentToOuroStorage_u24lambda_u240.add((OuroNode.Parent) builder.getRoot(), it4);
                                            Unit unit3 = Unit.INSTANCE;
                                        }
                                    } else {
                                        Boxing.boxBoolean(listParagraphs.add(paragraph2));
                                    }
                                }
                                prevParagraphType2 = prevParagraphType3;
                                prevCombineHash2 = prevCombineHash3;
                                $result = $result2;
                                coroutine_suspended = obj2;
                            }
                            Boxing.boxBoolean(listParagraphs.add(paragraph));
                            prevParagraphType2 = prevParagraphType3;
                            prevCombineHash2 = prevCombineHash3;
                            $result = $result2;
                            coroutine_suspended = obj2;
                        }
                        Object obj3 = coroutine_suspended;
                        Ref.ObjectRef prevParagraphType4 = prevParagraphType2;
                        Ref.ObjectRef prevCombineHash4 = prevCombineHash2;
                        if (!listParagraphs.isEmpty()) {
                            OuroList it5 = convertListParagraphsToNode(listParagraphs, builder);
                            if (it5 != null) {
                                $this$convertOpusContentToOuroStorage_u24lambda_u240.add((OuroNode.Parent) builder.getRoot(), (OuroNode) it5);
                                Unit unit4 = Unit.INSTANCE;
                            }
                            listParagraphs.clear();
                        }
                        if (!quoteParagraphs.isEmpty()) {
                            OuroQuoteBlock it6 = convertQuoteParagraphsToNode(quoteParagraphs, builder);
                            if (it6 != null) {
                                $this$convertOpusContentToOuroStorage_u24lambda_u240.add((OuroNode.Parent) builder.getRoot(), (OuroNode) it6);
                                Unit unit5 = Unit.INSTANCE;
                            }
                            quoteParagraphs.clear();
                        }
                        NodeStorageBuilder $this$collectNodeInParentWithDFS$iv = builder;
                        Object root = builder.getRoot();
                        List nodeList$iv = new ArrayList();
                        OuroNodeStorageUtilsKt.collectNodes($this$collectNodeInParentWithDFS$iv, (OuroNode) root, nodeList$iv);
                        List $this$filterIsInstance$iv$iv = nodeList$iv;
                        Collection destination$iv$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                            OuroNodeStorage $this$collectNodeInParentWithDFS$iv2 = $this$collectNodeInParentWithDFS$iv;
                            Object obj4 = root;
                            if (element$iv$iv$iv instanceof OuroInlineContent) {
                                destination$iv$iv$iv.add(element$iv$iv$iv);
                            }
                            $this$collectNodeInParentWithDFS$iv = $this$collectNodeInParentWithDFS$iv2;
                            root = obj4;
                        }
                        Iterable nodes = (List) destination$iv$iv$iv;
                        Iterable $this$mapNotNull$iv = nodes;
                        boolean z2 = false;
                        Collection destination$iv$iv = new ArrayList();
                        Iterable<OuroInlineContent> $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                        for (OuroInlineContent node : $this$mapNotNullTo$iv$iv) {
                            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            boolean z3 = z2;
                            Iterable children = $this$convertOpusContentToOuroStorage_u24lambda_u240.getChildren(node);
                            if (children != null) {
                                Iterable $this$firstOrNull$iv = children;
                                Iterator it7 = $this$firstOrNull$iv.iterator();
                                while (true) {
                                    if (it7.hasNext()) {
                                        r30 = it7.next();
                                        Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                        if (!(((OuroNode) r30) instanceof OuroRemoteImage.Sticker)) {
                                            $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                        }
                                    } else {
                                        r30 = 0;
                                    }
                                }
                                ouroNode = r30;
                            } else {
                                ouroNode = null;
                            }
                            Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                            OuroRemoteImage.Sticker sticker = ouroNode instanceof OuroRemoteImage.Sticker ? (OuroRemoteImage.Sticker) ouroNode : null;
                            Pair pair = (sticker == null || (it = sticker.getRawText()) == null) ? null : TuplesKt.to(it, node);
                            if (pair != null) {
                                destination$iv$iv.add(pair);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                            z2 = z3;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        }
                        emotes = (List) destination$iv$iv;
                        List $this$map$iv = emotes;
                        int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                        Collection destination$iv$iv2 = new ArrayList($i$f$map);
                        for (Object item$iv$iv : $this$map$iv) {
                            destination$iv$iv2.add((String) ((Pair) item$iv$iv).getFirst());
                            $this$map$iv = $this$map$iv;
                        }
                        List<String> distinct = CollectionsKt.distinct((List) destination$iv$iv2);
                        if (distinct.isEmpty()) {
                            break;
                        } else {
                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(opusContent);
                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(linkParseService);
                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(document);
                            $continuation.L$3 = builder;
                            $continuation.L$4 = $this$convertOpusContentToOuroStorage_u24lambda_u240;
                            $continuation.L$5 = SpillingKt.nullOutSpilledVariable(listParagraphs);
                            $continuation.L$6 = SpillingKt.nullOutSpilledVariable(quoteParagraphs);
                            $continuation.L$7 = SpillingKt.nullOutSpilledVariable(shouldCommitParagraphs2);
                            $continuation.L$8 = SpillingKt.nullOutSpilledVariable(prevCombineHash4);
                            $continuation.L$9 = SpillingKt.nullOutSpilledVariable(prevParagraphType4);
                            $continuation.L$10 = SpillingKt.nullOutSpilledVariable(nodes);
                            $continuation.L$11 = emotes;
                            $continuation.L$12 = SpillingKt.nullOutSpilledVariable(distinct);
                            $continuation.I$0 = 0;
                            $continuation.label = 1;
                            Object mo1885parsegIAlus = linkParseService.mo1885parsegIAlus(distinct, $continuation);
                            if (mo1885parsegIAlus != obj3) {
                                shouldCommitParagraphs = shouldCommitParagraphs2;
                                list = distinct;
                                obj = mo1885parsegIAlus;
                                prevParagraphType = prevParagraphType4;
                                prevCombineHash = prevCombineHash4;
                                i = 0;
                                opusContent2 = opusContent;
                                if (Result.m2643isSuccessimpl(obj)) {
                                    opusContent3 = opusContent2;
                                } else {
                                    List results = (List) obj;
                                    List $this$filterIsInstance$iv = results;
                                    opusContent3 = opusContent2;
                                    Collection destination$iv$iv3 = new ArrayList();
                                    for (Object element$iv$iv : $this$filterIsInstance$iv) {
                                        Continuation $continuation2 = $continuation;
                                        List results2 = results;
                                        if (element$iv$iv instanceof EmoteParseResult) {
                                            destination$iv$iv3.add(element$iv$iv);
                                        }
                                        results = results2;
                                        $continuation = $continuation2;
                                    }
                                    Iterable $this$associateBy$iv = (List) destination$iv$iv3;
                                    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                                    Map linkedHashMap = new LinkedHashMap(capacity$iv);
                                    for (Object element$iv$iv2 : $this$associateBy$iv) {
                                        Iterable $this$associateBy$iv2 = $this$associateBy$iv;
                                        linkedHashMap.put(((EmoteParseResult) element$iv$iv2).getRaw(), element$iv$iv2);
                                        $this$associateBy$iv = $this$associateBy$iv2;
                                        capacity$iv = capacity$iv;
                                    }
                                    Map emoteParseResults2 = linkedHashMap;
                                    if (!emoteParseResults2.isEmpty()) {
                                        List $this$forEach$iv = emotes;
                                        boolean z4 = false;
                                        for (Object element$iv2 : $this$forEach$iv) {
                                            Pair pair2 = (Pair) element$iv2;
                                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                                            String emoteText = (String) pair2.component1();
                                            OuroInlineContent node2 = (OuroInlineContent) pair2.component2();
                                            EmoteParseResult result = (EmoteParseResult) emoteParseResults2.get(emoteText);
                                            if (result == null) {
                                                emoteParseResults = emoteParseResults2;
                                                z = z4;
                                                i2 = i;
                                            } else {
                                                emoteParseResults = emoteParseResults2;
                                                z = z4;
                                                EmoticonSize emoteSize = Intrinsics.areEqual(result.getEmoteSize(), "large") ? EmoticonSize.LARGE : EmoticonSize.SMALL;
                                                OuroInlineContent ouroInlineContent = node2;
                                                Emote emote = new Emote(0L, 0L, 0, 0L, emoteText, 0, result.getUrl(), (String) null, new Emote.EmoteMeta(emoteSize, (String) null, (List) null, (String) null, (String) null, 0L, (String) null, (String) null, 254, (DefaultConstructorMarker) null), (Emote.EmoteFlags) null, (Emote.EmoteActivity) null, (String) null, (String) null, (UpperEmoteInfo) null, 16047, (DefaultConstructorMarker) null);
                                                i2 = i;
                                                OuroBackgroundColorMark ouroBackgroundColorMark = (OuroBackgroundColorMark) node2.getMarks().get(OuroBackgroundColorMark.Key.INSTANCE);
                                                $this$convertOpusContentToOuroStorage_u24lambda_u240.replace((NodeStorageBuilder) ouroInlineContent, (OuroNodeStorage<NodeStorageBuilder>) EmoteHelperKt.nodeStorage(emote, ouroBackgroundColorMark != null ? ouroBackgroundColorMark.getColor() : null));
                                            }
                                            $this$forEach$iv = $this$forEach$iv2;
                                            i = i2;
                                            emoteParseResults2 = emoteParseResults;
                                            z4 = z;
                                        }
                                    }
                                }
                                error = Result.m2639exceptionOrNullimpl(obj);
                                if (error != null) {
                                    KLog_androidKt.getKLog().w(TAG, "Link parse failed: " + error.getMessage());
                                }
                                break;
                            } else {
                                return obj3;
                            }
                        }
                        break;
                    case 1:
                        i = $continuation.I$0;
                        list = (List) $continuation.L$12;
                        emotes = (List) $continuation.L$11;
                        List list2 = (List) $continuation.L$10;
                        prevParagraphType = (Ref.ObjectRef) $continuation.L$9;
                        prevCombineHash = (Ref.ObjectRef) $continuation.L$8;
                        shouldCommitParagraphs = (Ref.BooleanRef) $continuation.L$7;
                        List list3 = (List) $continuation.L$6;
                        List list4 = (List) $continuation.L$5;
                        $this$convertOpusContentToOuroStorage_u24lambda_u240 = (NodeStorageBuilder) $continuation.L$4;
                        builder = (NodeStorageBuilder) $continuation.L$3;
                        OuroDocument ouroDocument = (OuroDocument) $continuation.L$2;
                        LinkParseService linkParseService2 = (LinkParseService) $continuation.L$1;
                        opusContent2 = (KOpusContent) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).m2645unboximpl();
                        if (Result.m2643isSuccessimpl(obj)) {
                        }
                        error = Result.m2639exceptionOrNullimpl(obj);
                        if (error != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return OuroNodeMutableStorage.CC.build$default(builder, false, 1, null);
            }
        }
        $continuation = new OpusConverterKt$convertOpusContentToOuroStorage$1(continuation);
        Object $result3 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
        return OuroNodeMutableStorage.CC.build$default(builder, false, 1, null);
    }

    private static final OuroNode convertIndependentParagraphToNode(KParagraph paragraph, NodeStorageBuilder<OuroDocument> nodeStorageBuilder) {
        List pics;
        KPic pic;
        OuroText headingNode;
        Iterable nodes;
        OuroTextAlignMark alignmentMark;
        Iterable nodes2;
        KParagraph.KIndentFormat indent;
        KParagraph.KIndentFormat indent2;
        KParagraph.KParagraphType paraType = paragraph.getParaType();
        OuroBoxContainer boxContainer = null;
        if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.TEXT.INSTANCE)) {
            KParagraph.KParagraphFormat format = paragraph.getFormat();
            int firstLineIndent = (format == null || (indent2 = format.getIndent()) == null) ? 0 : indent2.getFirstLineIndent();
            KParagraph.KParagraphFormat format2 = paragraph.getFormat();
            int allIndent = (format2 == null || (indent = format2.getIndent()) == null) ? 0 : indent.getIndent();
            OuroTextIndentMark indentMark = new OuroTextIndentMark((firstLineIndent + allIndent) * 22.0f, allIndent * 22.0f);
            KParagraph.KParagraphFormat format3 = paragraph.getFormat();
            KParagraph.KParagraphAlign align = format3 != null ? format3.getAlign() : null;
            if (align instanceof KParagraph.KParagraphAlign.LEFT) {
                alignmentMark = OuroTextAlignStartMark.INSTANCE;
            } else if (Intrinsics.areEqual(align, KParagraph.KParagraphAlign.MIDDLE.INSTANCE)) {
                alignmentMark = OuroTextAlignCenterMark.INSTANCE;
            } else {
                alignmentMark = Intrinsics.areEqual(align, KParagraph.KParagraphAlign.RIGHT.INSTANCE) ? OuroTextAlignEndMark.INSTANCE : OuroTextAlignStartMark.INSTANCE;
            }
            OuroText textParagraph = new OuroText(new OuroMarks(indentMark, alignmentMark));
            KTextParagraph text = paragraph.getText();
            if (text != null && (nodes2 = text.getNodes()) != null) {
                Iterable $this$forEach$iv = nodes2;
                for (Object element$iv : $this$forEach$iv) {
                    KTextNode textNode = (KTextNode) element$iv;
                    addTextNodeToOuroParagraph(nodeStorageBuilder, textNode, textParagraph);
                }
            }
            nodeStorageBuilder.add(textParagraph, new OuroTextElement.HardBreak(new OuroMarks(null, 1, null)));
            return textParagraph;
        } else if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.HEADING.INSTANCE)) {
            KParagraph.KParagraphFormat format4 = paragraph.getFormat();
            KParagraph.KHeadingType headingType = format4 != null ? format4.getHeadingType() : null;
            if (Intrinsics.areEqual(headingType, KParagraph.KHeadingType.H1.INSTANCE)) {
                headingNode = new OuroH1(new OuroMarks(null, 1, null));
            } else if (Intrinsics.areEqual(headingType, KParagraph.KHeadingType.H2.INSTANCE)) {
                headingNode = new OuroH2(new OuroMarks(null, 1, null));
            } else {
                headingNode = Intrinsics.areEqual(headingType, KParagraph.KHeadingType.H3.INSTANCE) ? new OuroH3(new OuroMarks(null, 1, null)) : new OuroText(new OuroMarks(null, 1, null));
            }
            KTextParagraph text2 = paragraph.getText();
            if (text2 != null && (nodes = text2.getNodes()) != null) {
                Iterable $this$forEach$iv2 = nodes;
                for (Object element$iv2 : $this$forEach$iv2) {
                    KTextNode textNode2 = (KTextNode) element$iv2;
                    addTextNodeToOuroParagraph(nodeStorageBuilder, textNode2, headingNode);
                }
            }
            nodeStorageBuilder.add(headingNode, new OuroTextElement.HardBreak(new OuroMarks(null, 1, null)));
            return headingNode;
        } else if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.PICTURES.INSTANCE)) {
            KPicParagraph pic2 = paragraph.getPic();
            if (pic2 != null && (pics = pic2.getPics()) != null && (pic = (KPic) CollectionsKt.firstOrNull(pics)) != null) {
                float aspectRatio = (float) (pic.getWidth() / pic.getHeight());
                boxContainer = new OuroBoxContainer(new OuroMarks(new OuroDrawableMark.Size.AspectRatio(aspectRatio)));
                OuroRemoteImage.Image image = new OuroRemoteImage.Image(pic.getUrl(), (int) pic.getWidth(), (int) pic.getHeight(), pic.getAiGenPic());
                nodeStorageBuilder.add(boxContainer, image);
            }
            return boxContainer;
        } else if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.LINE.INSTANCE)) {
            OuroBoxContainer boxContainer2 = new OuroBoxContainer(OuroLayoutUtilsKt.getDividerDefaultMarks());
            OuroDivider divider = new OuroDivider((String) null, 1, (DefaultConstructorMarker) null);
            nodeStorageBuilder.add(boxContainer2, divider);
            return boxContainer2;
        } else if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.LINK_CARD.INSTANCE)) {
            BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
            $this$encodeToByteArray$iv.getSerializersModule();
            byte[] meta = $this$encodeToByteArray$iv.encodeToByteArray(KParagraph.Companion.serializer(), paragraph);
            OuroBoxContainer boxContainer3 = new OuroBoxContainer(OuroLayoutUtilsKt.getUnrecognizedCardDefaultMarks());
            OuroUnrecognizedCard placeholder = new OuroUnrecognizedCard(meta, (String) null, 2, (DefaultConstructorMarker) null);
            nodeStorageBuilder.add(boxContainer3, placeholder);
            return boxContainer3;
        } else {
            return null;
        }
    }

    private static final OuroList convertListParagraphsToNode(List<KParagraph> $this$forEach$iv, NodeStorageBuilder<OuroDocument> nodeStorageBuilder) {
        boolean isTopLevelOrdered;
        int startIndex;
        Object prevCombineHash;
        Object prevLevel;
        boolean z;
        KParagraph.KListFormat kListFormat;
        Iterable nodes;
        OuroListItem parentItem;
        KParagraph.KListFormat listFormat;
        KParagraph.KListFormat listFormat2;
        int level;
        OuroList ouroUnorderedList;
        KParagraph.KListFormat listFormat3;
        Iterable nodes2;
        KParagraph.KListFormat listFormat4;
        KParagraph.KListFormat kListFormat2 = null;
        if ($this$forEach$iv.isEmpty()) {
            return null;
        }
        boolean isTopLevelOrdered2 = Intrinsics.areEqual(((KParagraph) CollectionsKt.first($this$forEach$iv)).getParaType(), KParagraph.KParagraphType.SORTED_LIST.INSTANCE);
        KParagraph.KParagraphFormat format = ((KParagraph) CollectionsKt.first($this$forEach$iv)).getFormat();
        int startIndex2 = (format == null || (listFormat4 = format.getListFormat()) == null) ? 1 : listFormat4.getOrder();
        OuroList rootList = isTopLevelOrdered2 ? new OuroOrderedList(startIndex2 - 1, (OuroMarks) null, 2, (DefaultConstructorMarker) null) : new OuroUnorderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
        List listStack = new ArrayList();
        listStack.add(new OpusConverterKt$convertListParagraphsToNode$ListLevel(rootList, 1, null));
        List listItems = new ArrayList();
        Object prevCombineHash2 = null;
        Object prevLevel2 = null;
        for (Object element$iv : $this$forEach$iv) {
            KParagraph paragraph = (KParagraph) element$iv;
            KParagraph.KParagraphFormat format2 = paragraph.getFormat();
            Object currCombineHash = (format2 == null || (r20 = format2.getCombineHash()) == null) ? "" : "";
            KParagraph.KParagraphFormat format3 = paragraph.getFormat();
            KParagraph.KListFormat listFormat5 = format3 != null ? format3.getListFormat() : kListFormat2;
            boolean isOrdered = Intrinsics.areEqual(paragraph.getParaType(), KParagraph.KParagraphType.SORTED_LIST.INSTANCE);
            Object valueOf = listFormat5 != null ? Integer.valueOf(listFormat5.getLevel()) : kListFormat2;
            boolean combineHashChanged = !Intrinsics.areEqual(currCombineHash, prevCombineHash2);
            boolean levelChanged = !Intrinsics.areEqual(prevLevel2, valueOf);
            if (valueOf != null) {
                prevLevel2 = valueOf;
            }
            KParagraph.KParagraphType paraType = paragraph.getParaType();
            if (paraType instanceof KParagraph.KParagraphType.TEXT) {
                isTopLevelOrdered = isTopLevelOrdered2;
                startIndex = startIndex2;
                OuroText textParagraph = new OuroText(new OuroMarks(null, 1, null));
                KTextParagraph text = paragraph.getText();
                if (text != null && (nodes2 = text.getNodes()) != null) {
                    Iterable $this$forEach$iv2 = nodes2;
                    boolean z2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Iterable $this$forEach$iv3 = $this$forEach$iv2;
                        KTextNode textNode = (KTextNode) element$iv2;
                        addTextNodeToOuroParagraph(nodeStorageBuilder, textNode, textParagraph);
                        $this$forEach$iv2 = $this$forEach$iv3;
                        z2 = z2;
                    }
                }
                prevCombineHash = currCombineHash;
                nodeStorageBuilder.add(textParagraph, new OuroTextElement.HardBreak(new OuroMarks(null, 1, null)));
                boolean z3 = false;
                Iterator it = CollectionsKt.reversed(listItems).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv3 = it.next();
                    Pair pair = (Pair) element$iv3;
                    OuroListItem listItem = (OuroListItem) pair.component1();
                    boolean z4 = z3;
                    String combineHash = (String) pair.component2();
                    if (Intrinsics.areEqual(combineHash, currCombineHash)) {
                        nodeStorageBuilder.add(listItem, textParagraph);
                        break;
                    }
                    z3 = z4;
                }
                prevLevel = prevLevel2;
                z = true;
                kListFormat = null;
            } else {
                isTopLevelOrdered = isTopLevelOrdered2;
                startIndex = startIndex2;
                prevCombineHash = currCombineHash;
                if ((paraType instanceof KParagraph.KParagraphType.SORTED_LIST) || (paraType instanceof KParagraph.KParagraphType.UNSORTED_LIST)) {
                    int level2 = listFormat5 != null ? listFormat5.getLevel() : 1;
                    boolean shouldBeginNewListInCurrentLevel = combineHashChanged && !levelChanged;
                    while (listStack.size() > level2) {
                        CollectionsKt.removeLastOrNull(listStack);
                    }
                    while (listStack.size() < level2) {
                        OuroListItem parentItem2 = ((OpusConverterKt$convertListParagraphsToNode$ListLevel) CollectionsKt.last(listStack)).getCurrentListItem();
                        if (parentItem2 == null) {
                            return rootList;
                        }
                        KParagraph.KParagraphFormat format4 = paragraph.getFormat();
                        int startIndex3 = (format4 == null || (listFormat3 = format4.getListFormat()) == null) ? 1 : listFormat3.getOrder();
                        if (isOrdered) {
                            level = level2;
                            ouroUnorderedList = new OuroOrderedList(startIndex3 - 1, (OuroMarks) null, 2, (DefaultConstructorMarker) null);
                        } else {
                            level = level2;
                            ouroUnorderedList = new OuroUnorderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                        }
                        OuroList nestedList = ouroUnorderedList;
                        nodeStorageBuilder.add(parentItem2, nestedList);
                        listStack.add(new OpusConverterKt$convertListParagraphsToNode$ListLevel(nestedList, listStack.size() + 1, null));
                        level2 = level;
                    }
                    if (shouldBeginNewListInCurrentLevel) {
                        if (listStack.size() > 1) {
                            OpusConverterKt$convertListParagraphsToNode$ListLevel parentLevel = (OpusConverterKt$convertListParagraphsToNode$ListLevel) listStack.get(listStack.size() - 2);
                            OuroListItem parentItem3 = parentLevel.getCurrentListItem();
                            if (parentItem3 == null) {
                                return rootList;
                            }
                            KParagraph.KParagraphFormat format5 = paragraph.getFormat();
                            OuroList nestedList2 = isOrdered ? new OuroOrderedList(((format5 == null || (listFormat2 = format5.getListFormat()) == null) ? 1 : listFormat2.getOrder()) - 1, (OuroMarks) null, 2, (DefaultConstructorMarker) null) : new OuroUnorderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                            nodeStorageBuilder.add(parentItem3, nestedList2);
                            CollectionsKt.removeLastOrNull(listStack);
                            listStack.add(OpusConverterKt$convertListParagraphsToNode$ListLevel.copy$default(parentLevel, nestedList2, 0, null, 2, null));
                        } else {
                            OpusConverterKt$convertListParagraphsToNode$ListLevel parentLevel2 = (OpusConverterKt$convertListParagraphsToNode$ListLevel) CollectionsKt.lastOrNull(listStack);
                            if (parentLevel2 == null || (parentItem = parentLevel2.getCurrentListItem()) == null) {
                                return rootList;
                            }
                            KParagraph.KParagraphFormat format6 = paragraph.getFormat();
                            OuroList nestedList3 = isOrdered ? new OuroOrderedList(((format6 == null || (listFormat = format6.getListFormat()) == null) ? 1 : listFormat.getOrder()) - 1, (OuroMarks) null, 2, (DefaultConstructorMarker) null) : new OuroUnorderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                            nodeStorageBuilder.add(parentItem, nestedList3);
                            CollectionsKt.removeLastOrNull(listStack);
                            listStack.add(OpusConverterKt$convertListParagraphsToNode$ListLevel.copy$default(parentLevel2, nestedList3, 0, null, 2, null));
                        }
                    }
                    OuroListItem listItem2 = new OuroListItem((OuroMarks) null, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                    OpusConverterKt$convertListParagraphsToNode$ListLevel currentListLevel = (OpusConverterKt$convertListParagraphsToNode$ListLevel) CollectionsKt.last(listStack);
                    nodeStorageBuilder.add(currentListLevel.getList(), listItem2);
                    OuroText textParagraph2 = new OuroText(new OuroMarks(null, 1, null));
                    KTextParagraph text2 = paragraph.getText();
                    if (text2 != null && (nodes = text2.getNodes()) != null) {
                        Iterable $this$forEach$iv4 = nodes;
                        for (Object element$iv4 : $this$forEach$iv4) {
                            Iterable $this$forEach$iv5 = $this$forEach$iv4;
                            KTextNode textNode2 = (KTextNode) element$iv4;
                            addTextNodeToOuroParagraph(nodeStorageBuilder, textNode2, textParagraph2);
                            $this$forEach$iv4 = $this$forEach$iv5;
                            isOrdered = isOrdered;
                        }
                    }
                    prevLevel = prevLevel2;
                    z = true;
                    kListFormat = null;
                    nodeStorageBuilder.add(textParagraph2, new OuroTextElement.HardBreak(new OuroMarks(null, 1, null)));
                    nodeStorageBuilder.add(listItem2, textParagraph2);
                    if (!listStack.isEmpty()) {
                        listStack.set(CollectionsKt.getLastIndex(listStack), OpusConverterKt$convertListParagraphsToNode$ListLevel.copy$default(currentListLevel, null, 0, listItem2, 3, null));
                    }
                    listItems.add(TuplesKt.to(listItem2, currCombineHash));
                } else {
                    KLog_androidKt.getKLog().w(TAG, "convertListParagraphsToNode unhandled paragraph type: " + paragraph.getParaType());
                    prevLevel = prevLevel2;
                    z = true;
                    kListFormat = null;
                }
            }
            kListFormat2 = kListFormat;
            prevLevel2 = prevLevel;
            isTopLevelOrdered2 = isTopLevelOrdered;
            startIndex2 = startIndex;
            prevCombineHash2 = prevCombineHash;
        }
        return rootList;
    }

    private static final OuroQuoteBlock convertQuoteParagraphsToNode(List<KParagraph> list, NodeStorageBuilder<OuroDocument> nodeStorageBuilder) {
        Iterable nodes;
        Map map = null;
        if (list.isEmpty()) {
            return null;
        }
        int i = 1;
        OuroQuoteBlock quoteBlock = new OuroQuoteBlock(new OuroMarks(null, 1, null));
        List<KParagraph> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            KParagraph paragraph = (KParagraph) element$iv;
            OuroText textParagraph = new OuroText(new OuroMarks(map, i, map));
            KTextParagraph text = paragraph.getText();
            if (text != null && (nodes = text.getNodes()) != null) {
                Iterable $this$forEach$iv2 = nodes;
                for (Object element$iv2 : $this$forEach$iv2) {
                    KTextNode textNode = (KTextNode) element$iv2;
                    addTextNodeToOuroParagraph(nodeStorageBuilder, textNode, textParagraph);
                }
            }
            nodeStorageBuilder.add(textParagraph, new OuroTextElement.HardBreak(new OuroMarks(null, 1, null)));
            nodeStorageBuilder.add(quoteBlock, textParagraph);
            i = 1;
            map = null;
        }
        return quoteBlock;
    }

    private static final OuroNode convertTextNodeToOuroNode(KTextNode textNode, NodeStorageBuilder<OuroDocument> nodeStorageBuilder) {
        KWordNode wordNode;
        OuroTextElement.Plain plain = null;
        if (Intrinsics.areEqual(textNode.getNodeType(), KTextNode.KTextNodeType.WORDS.INSTANCE) && (wordNode = textNode.getWord()) != null) {
            OuroMarks marks = convertWordNodeStyleToMarks(wordNode);
            plain = new OuroTextElement.Plain(wordNode.getWords(), marks);
        }
        return plain;
    }

    private static final NodeStorage<?> convertTextNodeToOuroNodeStorage(KTextNode textNode, NodeStorageBuilder<OuroDocument> nodeStorageBuilder) {
        KEmoteNode emoteNode;
        KColors color;
        KColors color2;
        KColors color3;
        KTextNode.KTextNodeType nodeType = textNode.getNodeType();
        OuroColor bgColor = null;
        if (Intrinsics.areEqual(nodeType, KTextNode.KTextNodeType.BIZ_LINK.INSTANCE)) {
            KLinkNode linkNode = textNode.getLink();
            if (linkNode != null) {
                BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
                $this$encodeToByteArray$iv.getSerializersModule();
                byte[] meta = $this$encodeToByteArray$iv.encodeToByteArray(KLinkNode.Companion.serializer(), linkNode);
                String link = linkNode.getLink();
                String showText = linkNode.getShowText();
                OuroColor lb7 = OuroColor.Companion.getLb7();
                KBgStyle bgStyle = linkNode.getBgStyle();
                if (bgStyle != null && (color3 = bgStyle.getColor()) != null) {
                    bgColor = toOuroColor(color3);
                }
                OuroColor ouroColor = bgColor;
                KLinkNode.KLinkNodeStyle style = linkNode.getStyle();
                boolean bold = style != null ? style.getBold() : false;
                KLinkNode.KLinkNodeStyle style2 = linkNode.getStyle();
                boolean italic = style2 != null ? style2.getItalic() : false;
                KLinkNode.KLinkNodeStyle style3 = linkNode.getStyle();
                boolean strikethrough = style3 != null ? style3.getStrikethrough() : false;
                KLinkNode.KLinkNodeStyle style4 = linkNode.getStyle();
                return OuroLinkKt.createLinkStorage$default(link, showText, null, meta, lb7, ouroColor, bold, italic, style4 != null ? style4.getUnderline() : false, strikethrough, 4, null);
            }
            return null;
        } else if (Intrinsics.areEqual(nodeType, KTextNode.KTextNodeType.AT.INSTANCE)) {
            KLinkNode linkNode2 = textNode.getLink();
            if (linkNode2 != null) {
                AtMentionUser atMentionUser = new AtMentionUser(Long.parseLong(linkNode2.getBizId()), StringsKt.removePrefix(linkNode2.getShowText(), "@"), null, OfficialVerifyType.NONE);
                OuroColor lb72 = OuroColor.Companion.getLb7();
                KBgStyle bgStyle2 = linkNode2.getBgStyle();
                if (bgStyle2 != null && (color2 = bgStyle2.getColor()) != null) {
                    bgColor = toOuroColor(color2);
                }
                OuroColor ouroColor2 = bgColor;
                KLinkNode.KLinkNodeStyle style5 = linkNode2.getStyle();
                boolean bold2 = style5 != null ? style5.getBold() : false;
                KLinkNode.KLinkNodeStyle style6 = linkNode2.getStyle();
                boolean italic2 = style6 != null ? style6.getItalic() : false;
                KLinkNode.KLinkNodeStyle style7 = linkNode2.getStyle();
                boolean strikethrough2 = style7 != null ? style7.getStrikethrough() : false;
                KLinkNode.KLinkNodeStyle style8 = linkNode2.getStyle();
                return OuroLinkKt.createStorage(atMentionUser, lb72, ouroColor2, bold2, italic2, style8 != null ? style8.getUnderline() : false, strikethrough2);
            }
            return null;
        } else if (!Intrinsics.areEqual(nodeType, KTextNode.KTextNodeType.EMOTE.INSTANCE) || (emoteNode = textNode.getEmote()) == null) {
            return null;
        } else {
            KBgStyle bgStyle3 = emoteNode.getBgStyle();
            if (bgStyle3 != null && (color = bgStyle3.getColor()) != null) {
                bgColor = toOuroColor(color);
            }
            Emote tempEmote = new Emote(0L, 0L, 0, 0L, emoteNode.getRawText(), 0, "", (String) null, (Emote.EmoteMeta) null, (Emote.EmoteFlags) null, (Emote.EmoteActivity) null, (String) null, (String) null, (UpperEmoteInfo) null, 16303, (DefaultConstructorMarker) null);
            NodeStorage emoteStorage = EmoteHelperKt.nodeStorage(tempEmote, bgColor);
            return emoteStorage;
        }
    }

    private static final OuroMarks<OuroTextMark> convertWordNodeStyleToMarks(KWordNode wordNode) {
        KColors color;
        int darkColor;
        List marks = new ArrayList();
        KWordNode.KWordNodeStyle style = wordNode.getStyle();
        if (style != null) {
            if (style.getBold()) {
                marks.add(OuroSemiBoldMark.INSTANCE);
            }
            if (style.getItalic()) {
                marks.add(OuroItalicMark.INSTANCE);
            }
            if (style.getUnderline()) {
                marks.add(OuroUnderlineMark.INSTANCE);
            }
            if (style.getStrikethrough()) {
                marks.add(OuroStrikethroughMark.INSTANCE);
            }
        }
        if (wordNode.getColor().length() > 0) {
            int lightColor = ConverterUtilsKt.toArgbInt$default(wordNode.getColor(), 0, 1, null);
            if (wordNode.getDarkColor().length() > 0) {
                darkColor = ConverterUtilsKt.toArgbInt$default(wordNode.getDarkColor(), 0, 1, null);
            } else {
                darkColor = lightColor;
            }
            String name = wordNode.getBiliTheme();
            marks.add(new OuroForegroundColorMark(OuroColor.Companion.create(lightColor, darkColor, name)));
        } else {
            marks.add(new OuroForegroundColorMark(OuroColor.Companion.getGa9()));
        }
        KBgStyle bgStyle = wordNode.getBgStyle();
        OuroColor bgColor = (bgStyle == null || (color = bgStyle.getColor()) == null) ? null : toOuroColor(color);
        if (bgColor != null) {
            marks.add(new OuroBackgroundColorMark(bgColor, 0.0f, 2, (DefaultConstructorMarker) null));
        }
        return new OuroMarks<>(marks);
    }

    private static final OuroColor toOuroColor(KColors $this$toOuroColor) {
        int darkColor;
        if ($this$toOuroColor.getColor().length() > 0) {
            int lightColor = ConverterUtilsKt.toArgbInt$default($this$toOuroColor.getColor(), 0, 1, null);
            if ($this$toOuroColor.getDarkColor().length() > 0) {
                darkColor = ConverterUtilsKt.toArgbInt$default($this$toOuroColor.getDarkColor(), 0, 1, null);
            } else {
                darkColor = lightColor;
            }
            return OuroColor.Companion.create(lightColor, darkColor, $this$toOuroColor.getBiliTheme());
        }
        return null;
    }

    private static final OuroParagraph addTextNodeToOuroParagraph(NodeStorageBuilder<OuroDocument> nodeStorageBuilder, KTextNode textNode, OuroParagraph textParagraph) {
        KTextNode.KTextNodeType nodeType = textNode.getNodeType();
        if ((nodeType instanceof KTextNode.KTextNodeType.AT) || (nodeType instanceof KTextNode.KTextNodeType.BIZ_LINK) || (nodeType instanceof KTextNode.KTextNodeType.EMOTE)) {
            NodeStorage nodeStorage = convertTextNodeToOuroNodeStorage(textNode, nodeStorageBuilder);
            if (nodeStorage != null) {
                nodeStorageBuilder.add((NodeStorageBuilder<OuroDocument>) textParagraph, (OuroNodeStorage<?>) nodeStorage);
            }
        } else if (nodeType instanceof KTextNode.KTextNodeType.WORDS) {
            OuroNode ouroNode = convertTextNodeToOuroNode(textNode, nodeStorageBuilder);
            if (ouroNode != null) {
                nodeStorageBuilder.add(textParagraph, ouroNode);
            }
        } else {
            KLog_androidKt.getKLog().w(TAG, "OpusConverter UnhandledTextNode: " + textNode.getNodeType());
        }
        return textParagraph;
    }

    private static final String getCombineHashOrNull(KParagraph p) {
        KParagraph.KParagraphFormat format = p.getFormat();
        if (format != null) {
            return format.getCombineHash();
        }
        return null;
    }

    static /* synthetic */ boolean needCommit$default(KParagraph kParagraph, String str, String str2, KParagraph.KParagraphType kParagraphType, KParagraph.KParagraphType kParagraphType2, List list, int i, Object obj) {
        List list2;
        if ((i & 32) == 0) {
            list2 = list;
        } else {
            list2 = CollectionsKt.emptyList();
        }
        return needCommit(kParagraph, str, str2, kParagraphType, kParagraphType2, list2);
    }

    private static final boolean needCommit(KParagraph paragraph, String prevCombineHash, String currCombineHash, KParagraph.KParagraphType prevParaType, KParagraph.KParagraphType currParaType, List<KParagraph> list) {
        Iterable $this$none$iv;
        KParagraph.KListFormat listFormat;
        boolean combineHashChanged = !Intrinsics.areEqual(currCombineHash, prevCombineHash);
        boolean prevIsRef = Intrinsics.areEqual(prevParaType, KParagraph.KParagraphType.REFERENCE.INSTANCE);
        boolean currIsRef = Intrinsics.areEqual(currParaType, KParagraph.KParagraphType.REFERENCE.INSTANCE);
        if (!prevIsRef || currIsRef) {
            if (prevIsRef && currIsRef && combineHashChanged) {
                return true;
            }
            if (!list.isEmpty()) {
                String str = currCombineHash;
                if ((str == null || str.length() == 0) || currIsRef) {
                    return true;
                }
            }
            KParagraph.KParagraphFormat format = paragraph.getFormat();
            if ((format == null || (listFormat = format.getListFormat()) == null || listFormat.getLevel() != 1) ? false : true) {
                List<KParagraph> $this$none$iv2 = list;
                if (!($this$none$iv2 instanceof Collection) || !$this$none$iv2.isEmpty()) {
                    Iterator<T> it = $this$none$iv2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            KParagraph it2 = (KParagraph) element$iv;
                            KParagraph.KParagraphFormat format2 = it2.getFormat();
                            if (Intrinsics.areEqual(format2 != null ? format2.getCombineHash() : null, currCombineHash)) {
                                $this$none$iv = null;
                                break;
                            }
                        } else {
                            $this$none$iv = 1;
                            break;
                        }
                    }
                } else {
                    $this$none$iv = 1;
                }
                if ($this$none$iv != null) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}