package kntr.common.ouro.core.reducer;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroDeleteAction;
import kntr.common.ouro.core.action.OuroDeleteByLengthAction;
import kntr.common.ouro.core.action.OuroIndentAction;
import kntr.common.ouro.core.action.OuroInsertAction;
import kntr.common.ouro.core.action.OuroInsertCompositionTextAction;
import kntr.common.ouro.core.action.OuroInsertStoragesAction;
import kntr.common.ouro.core.action.OuroInsertTextNodeAction;
import kntr.common.ouro.core.action.OuroInsertTextNodesAction;
import kntr.common.ouro.core.action.OuroOutdentAction;
import kntr.common.ouro.core.action.OuroReplaceNodeAction;
import kntr.common.ouro.core.action.OuroReplaceNodeWithStorageAction;
import kntr.common.ouro.core.action.OuroReplacePlainNodesWithStoragesAction;
import kntr.common.ouro.core.action.OuroReplaceStorageAction;
import kntr.common.ouro.core.action.OuroSetMarkedTextAction;
import kntr.common.ouro.core.action.OuroUnmarkTextAction;
import kntr.common.ouro.core.action.OuroUpdateCompositionRangeAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroNodeStorageKt;
import kntr.common.ouro.core.model.OuroPoint;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.OuroSelectionKt;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.OuroTextRangeKt;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroTextIndentMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroDocumentChild;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroParagraphChild;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.drawable.OuroDrawable;
import kntr.common.ouro.core.utils.FlowReduxUtilsKt;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.core.utils.OuroTextUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: OuroEditActionReducer.kt */
@Metadata(d1 = {"\u0000®\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000\u001a$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a8\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0000\u001a$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\u001b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\u001d2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a\"\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u001a$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a&\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\"2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u001a(\u0010#\u001a\u00020\u0007*\u00020\u00072\u0010\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0%2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u001a$\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020(2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020*2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020,2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a.\u0010-\u001a\u00020.*\b\u0012\u0004\u0012\u0002000/2\u0012\u00101\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u0003020&2\u0006\u00103\u001a\u00020.H\u0000\u001a(\u00104\u001a\u00020\u0005*\b\u0012\u0004\u0012\u000200052\n\u00101\u001a\u0006\u0012\u0002\b\u00030&2\b\b\u0002\u00106\u001a\u000207H\u0002\u001a^\u00108\u001a\u00020\u0005*\b\u0012\u0004\u0012\u000200052\f\u00109\u001a\b\u0012\u0004\u0012\u0002000:2\u0006\u0010;\u001a\u00020\u000124\u0010<\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0012\u0013\u0012\u00110>¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00010=j\u0002`C¢\u0006\u0002\bBH\u0000\u001a,\u0010D\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0E*\b\u0012\u0004\u0012\u0002000:2\u0006\u0010F\u001a\u0002072\u0006\u0010G\u001a\u000207H\u0000\u001a>\u0010H\u001a\u00020\u0005*\b\u0012\u0004\u0012\u0002000:2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010F\u001a\u0002072\u0006\u0010G\u001a\u0002072\u0010\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0EH\u0002\u001a*\u0010K\u001a\u000207*\b\u0012\u0004\u0012\u0002000&2\u0006\u0010A\u001a\u00020J2\u0006\u0010F\u001a\u0002072\u0006\u0010G\u001a\u000207H\u0002\u001a&\u0010L\u001a\u0002072\f\u0010M\u001a\b\u0012\u0004\u0012\u00020J0%2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0013H\u0002\u001a&\u0010P\u001a\u000207*\u0006\u0012\u0002\b\u00030/2\u0006\u0010Q\u001a\u00020J2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0%H\u0002\u001a&\u0010T\u001a\u000207*\u0006\u0012\u0002\b\u00030/2\u0006\u0010Q\u001a\u00020J2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0%H\u0002\u001a2\u0010U\u001a\u00020\u0005\"\b\b\u0000\u0010V*\u00020W*\u0006\u0012\u0002\b\u00030/2\b\u0010Q\u001a\u0004\u0018\u00010J2\f\u00101\u001a\b\u0012\u0004\u0012\u0002HV0&H\u0002\u001a&\u0010X\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030/2\u0006\u0010Y\u001a\u00020Z2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020S0%H\u0002\u001a\u0018\u0010\\\u001a\u00020\u0001*\u0006\u0012\u0002\b\u0003052\u0006\u0010Y\u001a\u00020ZH\u0000\u001a\u0016\u0010]\u001a\u0002072\f\u0010^\u001a\b\u0012\u0004\u0012\u00020J0%H\u0002\u001a$\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020`2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020d2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a\u001a\u0010e\u001a\u00020\u0005*\b\u0012\u0004\u0012\u0002000/2\u0006\u0010f\u001a\u00020ZH\u0002\u001a\"\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020h2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u001a\"\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020j2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u001a\u001e\u0010k\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010l\u001a\u00020m\u001a$\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020o2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020q2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002\u001a$\u0010r\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0%\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"INDENT_MAX_LEVEL", "", "INDENT_STEP", "", "onEditAction", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "handleInsertTextAction", "Lcom/freeletics/flowredux/dsl/ChangedState;", "action", "Lkntr/common/ouro/core/action/OuroInsertAction;", "state", "Lcom/freeletics/flowredux/dsl/State;", "handleSetMarkedTextAction", "Lkntr/common/ouro/core/action/OuroSetMarkedTextAction;", "replaceText", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "compositionRange", "text", "", "textMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "handleDeleteAction", "Lkntr/common/ouro/core/action/OuroDeleteAction;", "handleDeleteByLengthAction", "Lkntr/common/ouro/core/action/OuroDeleteByLengthAction;", "handleDeleteImpl", "handleUnmarkTextAction", "Lkntr/common/ouro/core/action/OuroUnmarkTextAction;", "handleInsertStoragesAction", "Lkntr/common/ouro/core/action/OuroInsertStoragesAction;", "insertStorages", "storages", "", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "handleReplaceStorageAction", "Lkntr/common/ouro/core/action/OuroReplaceStorageAction;", "handleIndentAction", "Lkntr/common/ouro/core/action/OuroIndentAction;", "handleOutdentAction", "Lkntr/common/ouro/core/action/OuroOutdentAction;", "insertStorage", "Lkntr/common/ouro/core/model/OuroPoint;", "Lkntr/common/ouro/core/model/NodeStorageBuilder;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "storage", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "point", "insertStorageToRoot", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "insertAtStart", "", "insertDocument", "document", "Lkntr/common/ouro/core/model/NodeStorage;", "offset", "displayLengthTransform", "Lkotlin/Function2;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkotlin/ParameterName;", "name", "node", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/model/DisplayLengthTransform;", "insertableStorages", "", "inList", "inQuote", "dfsTraverse", "currentNode", "Lkntr/common/ouro/core/model/node/OuroNode;", "canInsert", "needDeleteConfirm", "elements", "cursorRange", "deletedRange", "insertTextsAfterElement", "element", "textNodes", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "insertTextsBeforeElement", "insertParagraphAfterElement", "T", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "replaceSelectedElementsWithTexts", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "texts", "removeSelectedElements", "isSingleHarkBreak", "list", "handleReplaceNodeAction", "Lkntr/common/ouro/core/action/OuroReplaceNodeAction;", "handleReplaceNodeWithStorageAction", "Lkntr/common/ouro/core/action/OuroReplaceNodeWithStorageAction;", "handleReplacePlainNodesWithStoragesAction", "Lkntr/common/ouro/core/action/OuroReplacePlainNodesWithStoragesAction;", "moveOutFirstParagraphInQuoteBlock", "cursorSelection", "handleInsertTextNode", "Lkntr/common/ouro/core/action/OuroInsertTextNodeAction;", "handleInsertTextNodes", "Lkntr/common/ouro/core/action/OuroInsertTextNodesAction;", "insertTextNode", "textNode", "Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "handleUpdateCompositionRangeAction", "Lkntr/common/ouro/core/action/OuroUpdateCompositionRangeAction;", "handleInsertCompositionTextAction", "Lkntr/common/ouro/core/action/OuroInsertCompositionTextAction;", "insertTextNodes", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroEditActionReducerKt {
    public static final int INDENT_MAX_LEVEL = 3;
    public static final float INDENT_STEP = 22.0f;

    public static final void onEditAction(InStateBuilderBlock<OuroState, OuroState, OuroAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.ORDERED;
        Function3 handler$iv = OuroEditActionReducerKt$onEditAction$1.INSTANCE;
        this_$iv.on(Reflection.getOrCreateKotlinClass(OuroInsertAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock this_$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.ORDERED;
        Function3 handler$iv2 = OuroEditActionReducerKt$onEditAction$2.INSTANCE;
        this_$iv2.on(Reflection.getOrCreateKotlinClass(OuroSetMarkedTextAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock this_$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.ORDERED;
        Function3 handler$iv3 = OuroEditActionReducerKt$onEditAction$3.INSTANCE;
        this_$iv3.on(Reflection.getOrCreateKotlinClass(OuroDeleteAction.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock this_$iv4 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.ORDERED;
        Function3 handler$iv4 = OuroEditActionReducerKt$onEditAction$4.INSTANCE;
        this_$iv4.on(Reflection.getOrCreateKotlinClass(OuroDeleteByLengthAction.class), executionPolicy$iv4, handler$iv4);
        BaseBuilderBlock this_$iv5 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv5 = ExecutionPolicy.ORDERED;
        Function3 handler$iv5 = OuroEditActionReducerKt$onEditAction$5.INSTANCE;
        this_$iv5.on(Reflection.getOrCreateKotlinClass(OuroUnmarkTextAction.class), executionPolicy$iv5, handler$iv5);
        BaseBuilderBlock this_$iv6 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv6 = ExecutionPolicy.ORDERED;
        Function3 handler$iv6 = OuroEditActionReducerKt$onEditAction$6.INSTANCE;
        this_$iv6.on(Reflection.getOrCreateKotlinClass(OuroInsertStoragesAction.class), executionPolicy$iv6, handler$iv6);
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv7 = OuroEditActionReducerKt$onEditAction$7.INSTANCE;
        ExecutionPolicy executionPolicy$iv7 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroReplaceStorageAction.class), executionPolicy$iv7, handler$iv7);
        BaseBuilderBlock this_$iv7 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv8 = ExecutionPolicy.ORDERED;
        Function3 handler$iv8 = OuroEditActionReducerKt$onEditAction$8.INSTANCE;
        this_$iv7.on(Reflection.getOrCreateKotlinClass(OuroIndentAction.class), executionPolicy$iv8, handler$iv8);
        BaseBuilderBlock this_$iv8 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv9 = ExecutionPolicy.ORDERED;
        Function3 handler$iv9 = OuroEditActionReducerKt$onEditAction$9.INSTANCE;
        this_$iv8.on(Reflection.getOrCreateKotlinClass(OuroOutdentAction.class), executionPolicy$iv9, handler$iv9);
        BaseBuilderBlock this_$iv9 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv10 = ExecutionPolicy.ORDERED;
        Function3 handler$iv10 = OuroEditActionReducerKt$onEditAction$10.INSTANCE;
        this_$iv9.on(Reflection.getOrCreateKotlinClass(OuroReplaceNodeAction.class), executionPolicy$iv10, handler$iv10);
        BaseBuilderBlock this_$iv10 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv11 = ExecutionPolicy.ORDERED;
        Function3 handler$iv11 = OuroEditActionReducerKt$onEditAction$11.INSTANCE;
        this_$iv10.on(Reflection.getOrCreateKotlinClass(OuroReplaceNodeWithStorageAction.class), executionPolicy$iv11, handler$iv11);
        BaseBuilderBlock this_$iv11 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv12 = ExecutionPolicy.ORDERED;
        Function3 handler$iv12 = OuroEditActionReducerKt$onEditAction$12.INSTANCE;
        this_$iv11.on(Reflection.getOrCreateKotlinClass(OuroReplacePlainNodesWithStoragesAction.class), executionPolicy$iv12, handler$iv12);
        BaseBuilderBlock this_$iv12 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv13 = ExecutionPolicy.ORDERED;
        Function3 handler$iv13 = OuroEditActionReducerKt$onEditAction$13.INSTANCE;
        this_$iv12.on(Reflection.getOrCreateKotlinClass(OuroInsertTextNodeAction.class), executionPolicy$iv13, handler$iv13);
        BaseBuilderBlock this_$iv13 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv14 = ExecutionPolicy.ORDERED;
        Function3 handler$iv14 = OuroEditActionReducerKt$onEditAction$14.INSTANCE;
        this_$iv13.on(Reflection.getOrCreateKotlinClass(OuroUpdateCompositionRangeAction.class), executionPolicy$iv14, handler$iv14);
        BaseBuilderBlock this_$iv14 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv15 = ExecutionPolicy.ORDERED;
        Function3 handler$iv15 = OuroEditActionReducerKt$onEditAction$15.INSTANCE;
        this_$iv14.on(Reflection.getOrCreateKotlinClass(OuroInsertCompositionTextAction.class), executionPolicy$iv15, handler$iv15);
        BaseBuilderBlock this_$iv15 = (BaseBuilderBlock) inStateBuilderBlock;
        ExecutionPolicy executionPolicy$iv16 = ExecutionPolicy.ORDERED;
        Function3 handler$iv16 = OuroEditActionReducerKt$onEditAction$16.INSTANCE;
        this_$iv15.on(Reflection.getOrCreateKotlinClass(OuroInsertTextNodesAction.class), executionPolicy$iv16, handler$iv16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleInsertTextAction(final OuroInsertAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                OuroState handleInsertTextAction$lambda$0;
                handleInsertTextAction$lambda$0 = OuroEditActionReducerKt.handleInsertTextAction$lambda$0(OuroInsertAction.this, (OuroState) obj);
                return handleInsertTextAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final OuroState handleInsertTextAction$lambda$0(OuroInsertAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroTextRange range = $this$mutate.getCompositionRange();
        if (range != null) {
            if (!$action.getReplaceComposition()) {
                range = null;
            }
        }
        range = $action.getRange();
        if (range == null) {
            range = $this$mutate.getTextRange();
        }
        return replaceText($this$mutate, range, $action.getCompositionRange(), $action.getText(), $action.getTextMarks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleSetMarkedTextAction(final OuroSetMarkedTextAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                OuroState handleSetMarkedTextAction$lambda$0;
                handleSetMarkedTextAction$lambda$0 = OuroEditActionReducerKt.handleSetMarkedTextAction$lambda$0(OuroSetMarkedTextAction.this, (OuroState) obj);
                return handleSetMarkedTextAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleSetMarkedTextAction$lambda$0(OuroSetMarkedTextAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroTextRange textRange = $this$mutate.getCompositionRange();
        if (textRange == null) {
            textRange = $this$mutate.getTextRange();
        }
        return replaceText($this$mutate, textRange, new OuroTextRange(textRange.getStart(), textRange.getStart() + $action.getText().length()), $action.getText(), $action.getTextMarks());
    }

    public static final OuroState replaceText(OuroState state, final OuroTextRange range, OuroTextRange compositionRange, String text, OuroMarks<OuroTextMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Function2 displayLengthTransform = state.getDisplayLengthTransform();
        final List textList = OuroTextUtilsKt.toOuroTextWithHardBreaks(text, ouroMarks);
        final Ref.IntRef additionalOffset = new Ref.IntRef();
        NodeStorage oldStorage = state.getStorage();
        NodeStorage newStorage = OuroNodeStorageUtilsKt.mutate(oldStorage, range, displayLengthTransform, new Function2() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit replaceText$lambda$0;
                replaceText$lambda$0 = OuroEditActionReducerKt.replaceText$lambda$0(OuroTextRange.this, textList, additionalOffset, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return replaceText$lambda$0;
            }
        });
        List $this$fold$iv = textList;
        int accumulator$iv = 0;
        for (Object element$iv : $this$fold$iv) {
            OuroTextElement textNode = (OuroTextElement) element$iv;
            int acc = accumulator$iv;
            accumulator$iv = acc + ((Number) displayLengthTransform.invoke(newStorage, textNode)).intValue();
        }
        int textLen = accumulator$iv;
        OuroTextRange finalRange = new OuroTextRange(range.getStart() + textLen + additionalOffset.element);
        OuroSelection constrainedSel = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection(newStorage, finalRange, displayLengthTransform), newStorage.getAllSelectables(), false, 4, null);
        OuroTextRange constrainedRange = OuroTextRangeKt.getTextRange(newStorage, constrainedSel, displayLengthTransform);
        return OuroState.copy$default(state, newStorage, constrainedRange, compositionRange, null, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit replaceText$lambda$0(OuroTextRange $range, List $textList, Ref.IntRef $additionalOffset, NodeStorageBuilder $this$mutate, OuroSelection selection) {
        OuroNode.Selectable selectable;
        OuroNode.Selectable selectable2;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (!$range.getCollapsed()) {
            replaceSelectedElementsWithTexts($this$mutate, selection, $textList);
            return Unit.INSTANCE;
        }
        if (isSingleHarkBreak($textList)) {
            if (OuroNodeStorageUtilsKt.isHeadingParagraphEnd($this$mutate, selection.getStart())) {
                OuroNodeStorageUtilsKt.leaveHeading($this$mutate, selection.getStart());
                return Unit.INSTANCE;
            } else if (OuroNodeStorageUtilsKt.willLeaveQuote($this$mutate, selection.getStart())) {
                OuroNodeStorageUtilsKt.leaveQuote($this$mutate, selection.getStart());
                $additionalOffset.element = -1;
                return Unit.INSTANCE;
            } else if (OuroNodeStorageUtilsKt.willLeaveList($this$mutate, selection.getStart())) {
                OuroNodeStorageUtilsKt.outdentList($this$mutate, selection.getStart());
                $additionalOffset.element = -1;
                return Unit.INSTANCE;
            } else if (OuroNodeStorageUtilsKt.isInOuroList($this$mutate, selection.getStart())) {
                OuroNodeStorageUtilsKt.splitListItemAt($this$mutate, selection.getStart());
                return Unit.INSTANCE;
            }
        }
        NodeStorageBuilder $this$getNextSelectableOrNull$iv = $this$mutate;
        OuroPoint point$iv = selection.getStart();
        int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            selectable = (OuroNode.Selectable) orNull;
        } else {
            selectable = null;
        }
        OuroNode.Selectable afterElement = selectable;
        if (afterElement != null && insertTextsBeforeElement($this$mutate, afterElement, $textList)) {
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$getPreviousSelectableOrNull$iv = $this$mutate;
        int prevIndex$iv = selection.getStart().getIndex() - 1;
        if (prevIndex$iv >= 0) {
            Object orNull2 = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
            if (!(orNull2 instanceof OuroNode.Selectable)) {
                orNull2 = null;
            }
            selectable2 = (OuroNode.Selectable) orNull2;
        } else {
            selectable2 = null;
        }
        OuroNode.Selectable beforeElement = selectable2;
        if (beforeElement != null && insertTextsAfterElement($this$mutate, beforeElement, $textList)) {
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$replaceText_u24lambda_u240_u240 = new NodeStorageBuilder(new OuroText(null, 1, null), null, null, 6, null);
        $this$replaceText_u24lambda_u240_u240.addChildren($this$replaceText_u24lambda_u240_u240.getRoot(), $textList);
        insertParagraphAfterElement($this$mutate, beforeElement, $this$replaceText_u24lambda_u240_u240);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleDeleteAction(final OuroDeleteAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                OuroState handleDeleteAction$lambda$0;
                handleDeleteAction$lambda$0 = OuroEditActionReducerKt.handleDeleteAction$lambda$0(OuroDeleteAction.this, (OuroState) obj);
                return handleDeleteAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleDeleteAction$lambda$0(OuroDeleteAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return handleDeleteImpl($this$mutate, $action.getRange(), $action.getCompositionRange());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleDeleteByLengthAction(final OuroDeleteByLengthAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                OuroState handleDeleteByLengthAction$lambda$0;
                handleDeleteByLengthAction$lambda$0 = OuroEditActionReducerKt.handleDeleteByLengthAction$lambda$0(OuroDeleteByLengthAction.this, (OuroState) obj);
                return handleDeleteByLengthAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleDeleteByLengthAction$lambda$0(OuroDeleteByLengthAction $action, OuroState $this$mutate) {
        OuroTextRange range;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        if ($this$mutate.getTextRange().getCollapsed()) {
            range = new OuroTextRange($this$mutate.getTextRange().getStart(), Math.max(0, $this$mutate.getTextRange().getStart() - $action.getLength()));
        } else {
            range = $this$mutate.getTextRange();
        }
        return handleDeleteImpl($this$mutate, range, $action.getCompositionRange());
    }

    public static /* synthetic */ OuroState handleDeleteImpl$default(OuroState ouroState, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, int i, Object obj) {
        if ((i & 4) != 0) {
            ouroTextRange2 = null;
        }
        return handleDeleteImpl(ouroState, ouroTextRange, ouroTextRange2);
    }

    public static final OuroState handleDeleteImpl(final OuroState state, OuroTextRange range, OuroTextRange compositionRange) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(range, "range");
        final Function2 displayLengthTransform = state.getDisplayLengthTransform();
        final Ref.ObjectRef textRange = new Ref.ObjectRef();
        textRange.element = range;
        final OuroSelection cursorSelection = state.getSelection();
        NodeStorage storage = OuroNodeStorageUtilsKt.mutate(state.getStorage(), (OuroTextRange) textRange.element, displayLengthTransform, new Function2() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit handleDeleteImpl$lambda$0;
                handleDeleteImpl$lambda$0 = OuroEditActionReducerKt.handleDeleteImpl$lambda$0(textRange, state, cursorSelection, displayLengthTransform, state, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return handleDeleteImpl$lambda$0;
            }
        });
        return OuroState.copy$default(state, storage, (OuroTextRange) textRange.element, compositionRange, null, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28, types: [java.lang.Object] */
    public static final Unit handleDeleteImpl$lambda$0(Ref.ObjectRef $textRange, OuroState $oldState, OuroSelection $cursorSelection, Function2 $displayLengthTransform, OuroState $state, NodeStorageBuilder $this$mutate, OuroSelection sel) {
        OuroNode ouroNode;
        OuroListItem ouroListItem;
        OuroNode ouroNode2;
        OuroParagraph ouroParagraph;
        OuroNode.Selectable selectable;
        ArrayList arrayList;
        OuroNode ouroNode3;
        OuroNode ouroNode4;
        int insertPos;
        Collection collection;
        List<OuroNode> children;
        Object obj;
        List<OuroNode> children2;
        ?? r15;
        int insertPos2;
        OuroList childList;
        Iterable list$iv;
        OuroNode.Parent<?> parent;
        Integer indexInSiblings;
        OuroNode.Parent<?> parent2;
        Iterable $this$takeWhile$iv;
        Integer indexInSiblings2;
        OuroParagraph paragraph;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Intrinsics.checkNotNullParameter(sel, "sel");
        if (!((OuroTextRange) $textRange.element).getCollapsed()) {
            List selectables = OuroNodeStorageUtilsKt.getSelectables($this$mutate, sel);
            boolean z = true;
            if (needDeleteConfirm(selectables, $oldState.getTextRange(), (OuroTextRange) $textRange.element)) {
                if ((CollectionsKt.firstOrNull(selectables) instanceof OuroBoxContainer) && (paragraph = (OuroParagraph) CollectionsKt.firstOrNull(OuroNodeStorageKt.getSelectedParagraphs$default($this$mutate, $cursorSelection, false, false, 6, null))) != null) {
                    List p0 = $this$mutate.getChildren(paragraph);
                    if (((p0 == null || !isSingleHarkBreak(p0)) ? false : false) && !$this$mutate.isSiblingLast(paragraph)) {
                        $this$mutate.removeFromParent(paragraph);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else if (OuroNodeStorageUtilsKt.isQuoteStart($this$mutate, $cursorSelection)) {
                moveOutFirstParagraphInQuoteBlock($this$mutate, $cursorSelection);
                $textRange.element = OuroTextRangeKt.getTextRange($this$mutate, $cursorSelection, $displayLengthTransform);
                return Unit.INSTANCE;
            } else {
                if (isSingleHarkBreak(selectables) && $cursorSelection.isCollapsed()) {
                    OuroTextRange newTextRange = OuroNodeStorageUtilsKt.getIntoQuoteIfNeeded($this$mutate, selectables, sel, $displayLengthTransform);
                    if (newTextRange != null) {
                        $textRange.element = newTextRange;
                        return Unit.INSTANCE;
                    } else if (OuroNodeStorageUtilsKt.willLeaveList($this$mutate, $state.getSelection().getStart())) {
                        OuroListItem item = OuroNodeStorageUtilsKt.getParentListItemOrNull($this$mutate, $cursorSelection.getStart());
                        if (item != null) {
                            OuroNode.Parent itemParent = $this$mutate.getParent(item);
                            int indexInList = (itemParent == null || (indexInSiblings2 = $this$mutate.getIndexInSiblings(itemParent)) == null) ? 0 : indexInSiblings2.intValue();
                            Iterable<OuroListItem> childrenItems = OuroNodeStorageUtilsKt.getChildrenListItemsOrNull($this$mutate, item);
                            if (childrenItems != null) {
                                for (OuroListItem c : childrenItems) {
                                    $this$mutate.removeFromParent(c);
                                    if (itemParent instanceof OuroList) {
                                        $this$mutate.add(itemParent, indexInList, c);
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                            $this$mutate.removeFromParent(item);
                            List<OuroNode> children3 = itemParent != null ? $this$mutate.getChildren(itemParent) : null;
                            if (children3 != null && !children3.isEmpty()) {
                                z = false;
                            }
                            if (z && itemParent != null) {
                                Boolean.valueOf($this$mutate.removeFromParent(itemParent));
                            }
                            Unit unit3 = Unit.INSTANCE;
                            Unit unit4 = Unit.INSTANCE;
                        }
                    } else if (OuroNodeStorageUtilsKt.getParentListItemOrNull($this$mutate, $state.getSelection().getStart()) != null) {
                        NodeStorageBuilder $this$getNextSelectableOrNull$iv = $this$mutate;
                        OuroPoint point$iv = $cursorSelection.getStart();
                        int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
                        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
                            Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
                            if (!(orNull instanceof OuroNode.Selectable)) {
                                orNull = null;
                            }
                            selectable = (OuroNode.Selectable) orNull;
                        } else {
                            selectable = null;
                        }
                        OuroNode.Selectable afterElement = selectable;
                        if (afterElement == null || (parent2 = $this$mutate.getParent(afterElement)) == null || ($this$takeWhile$iv = $this$mutate.getSiblings(parent2)) == null) {
                            arrayList = null;
                        } else {
                            ArrayList list$iv2 = new ArrayList();
                            for (Object item$iv : $this$takeWhile$iv) {
                                if (!(((OuroNode) item$iv) instanceof OuroParagraph)) {
                                    break;
                                }
                                list$iv2.add(item$iv);
                            }
                            arrayList = list$iv2;
                        }
                        Iterable<OuroNode> paras = arrayList;
                        OuroListItem currentItem = OuroNodeStorageUtilsKt.getParentListItemOrNull($this$mutate, $cursorSelection.getStart());
                        if (currentItem == null) {
                            throw new IllegalStateException("Missing parentListItem");
                        }
                        OuroList currParentList = currentItem.getParentList($this$mutate);
                        Integer indexInSiblings3 = $this$mutate.getIndexInSiblings(currentItem);
                        int indexInParent = indexInSiblings3 != null ? indexInSiblings3.intValue() : 0;
                        int paraIndex = (afterElement == null || (parent = $this$mutate.getParent(afterElement)) == null || (indexInSiblings = $this$mutate.getIndexInSiblings(parent)) == null) ? 0 : indexInSiblings.intValue();
                        List list = (Collection) paras;
                        if (!(list == null || list.isEmpty()) && currParentList != null && paraIndex == 0) {
                            if (indexInParent == 0) {
                                OuroNode.Parent listParent = $this$mutate.getParent(currParentList);
                                if (listParent instanceof OuroListItem) {
                                    for (OuroNode it : paras) {
                                        $this$mutate.removeFromParent(it);
                                        newTextRange = newTextRange;
                                    }
                                    Iterable children4 = $this$mutate.getChildren(listParent);
                                    if (children4 != null) {
                                        Iterable $this$takeWhile$iv2 = children4;
                                        ArrayList list$iv3 = new ArrayList();
                                        Iterator it2 = $this$takeWhile$iv2.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                list$iv = list$iv3;
                                                break;
                                            }
                                            Iterable $this$takeWhile$iv3 = $this$takeWhile$iv2;
                                            Object item$iv2 = it2.next();
                                            OuroNode.Selectable afterElement2 = afterElement;
                                            if (!(((OuroNode) item$iv2) instanceof OuroParagraph)) {
                                                list$iv = list$iv3;
                                                break;
                                            }
                                            list$iv3.add(item$iv2);
                                            $this$takeWhile$iv2 = $this$takeWhile$iv3;
                                            afterElement = afterElement2;
                                        }
                                        insertPos2 = list$iv.size();
                                    } else {
                                        insertPos2 = 0;
                                    }
                                    $this$mutate.add(listParent, insertPos2, (Collection) paras);
                                    List<OuroNode> children5 = $this$mutate.getChildren(currentItem);
                                    if (children5 == null || children5.isEmpty()) {
                                        $this$mutate.removeFromParent(currentItem);
                                    }
                                    List<OuroNode> children6 = $this$mutate.getChildren(currParentList);
                                    if (children6 == null || children6.isEmpty()) {
                                        $this$mutate.removeFromParent(currParentList);
                                    }
                                    List leadingParas = currentItem.getLeadingParagraphs($this$mutate);
                                    List list2 = leadingParas;
                                    if ((list2 == null || list2.isEmpty()) && (childList = currentItem.getChildList($this$mutate)) != null) {
                                        $this$mutate.removeFromParent(childList);
                                        List it3 = $this$mutate.removeAllChildren(childList);
                                        if (it3 != null) {
                                            $this$mutate.add(currParentList, 0, it3);
                                            Unit unit5 = Unit.INSTANCE;
                                            Unit unit6 = Unit.INSTANCE;
                                        }
                                    }
                                } else {
                                    OuroNodeStorageUtilsKt.outdentListItem($this$mutate, currentItem);
                                }
                                $textRange.element = new OuroTextRange(((OuroTextRange) $textRange.element).getMax());
                                return Unit.INSTANCE;
                            }
                            List<OuroNode> siblings = $this$mutate.getSiblings(currentItem);
                            OuroNode ouroNode5 = siblings != null ? (OuroNode) CollectionsKt.getOrNull(siblings, indexInParent - 1) : null;
                            OuroListItem preItem = ouroNode5 instanceof OuroListItem ? (OuroListItem) ouroNode5 : null;
                            if (preItem != null) {
                                Iterable children7 = $this$mutate.getChildren(preItem);
                                if (children7 != null) {
                                    Iterable $this$firstOrNull$iv = children7;
                                    Iterator it4 = $this$firstOrNull$iv.iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            r15 = 0;
                                            break;
                                        }
                                        r15 = it4.next();
                                        Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                        if (((OuroNode) r15) instanceof OuroList) {
                                            break;
                                        }
                                        $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                    }
                                    ouroNode3 = r15;
                                } else {
                                    ouroNode3 = null;
                                }
                                OuroList prevChildrenList = ouroNode3 instanceof OuroList ? (OuroList) ouroNode3 : null;
                                int prevChildrenListSize = (prevChildrenList == null || (children2 = $this$mutate.getChildren(prevChildrenList)) == null) ? 0 : children2.size();
                                if (prevChildrenListSize > 0) {
                                    OuroListItem it5 = OuroNodeStorageUtilsKt.currentListItem($this$mutate, $state.getSelection().getStart());
                                    if (it5 != null) {
                                        OuroNodeStorageUtilsKt.outdentListItem($this$mutate, it5);
                                        Unit unit7 = Unit.INSTANCE;
                                        Unit unit8 = Unit.INSTANCE;
                                    }
                                    $textRange.element = $oldState.getTextRange(OuroNodeStorageUtilsKt.constrainSelection$default($oldState.getSelection(new OuroTextRange(((OuroTextRange) $textRange.element).getMax())), $this$mutate.getAllSelectables(), false, 4, null));
                                    return Unit.INSTANCE;
                                }
                                Iterable $this$firstOrNull$iv3 = $this$mutate.getChildren(currentItem);
                                if ($this$firstOrNull$iv3 != null) {
                                    Iterator it6 = $this$firstOrNull$iv3.iterator();
                                    while (true) {
                                        if (!it6.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        Object element$iv = it6.next();
                                        if (((OuroNode) element$iv) instanceof OuroList) {
                                            obj = element$iv;
                                            break;
                                        }
                                    }
                                    ouroNode4 = (OuroNode) obj;
                                } else {
                                    ouroNode4 = null;
                                }
                                Object element$iv$iv = ouroNode4 instanceof OuroList ? (OuroList) ouroNode4 : null;
                                int childrenListSize = (element$iv$iv == null || (children = $this$mutate.getChildren((OuroNode.Parent) element$iv$iv)) == null) ? 0 : children.size();
                                Iterable<OuroNode> $this$forEach$iv = paras;
                                for (OuroNode it7 : $this$forEach$iv) {
                                    $this$mutate.removeFromParent(it7);
                                    $this$forEach$iv = $this$forEach$iv;
                                }
                                Iterable children8 = $this$mutate.getChildren(preItem);
                                if (children8 != null) {
                                    Iterable $this$takeWhile$iv4 = children8;
                                    boolean z2 = false;
                                    ArrayList list$iv4 = new ArrayList();
                                    for (Object item$iv3 : $this$takeWhile$iv4) {
                                        Iterable $this$takeWhile$iv5 = $this$takeWhile$iv4;
                                        boolean z3 = z2;
                                        if (!(((OuroNode) item$iv3) instanceof OuroParagraph)) {
                                            break;
                                        }
                                        list$iv4.add(item$iv3);
                                        $this$takeWhile$iv4 = $this$takeWhile$iv5;
                                        z2 = z3;
                                    }
                                    insertPos = list$iv4.size();
                                } else {
                                    insertPos = 0;
                                }
                                $this$mutate.add(preItem, insertPos, (Collection) paras);
                                if (element$iv$iv != null && childrenListSize > 0) {
                                    $this$mutate.removeFromParent((OuroNode) element$iv$iv);
                                    $this$mutate.add(preItem, (OuroNode) element$iv$iv);
                                }
                                Iterable children9 = $this$mutate.getChildren(currentItem);
                                if (children9 != null) {
                                    Iterable $this$filterIsInstance$iv = children9;
                                    Collection destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                                        Object childrenList = element$iv$iv;
                                        Iterable paras2 = paras;
                                        if (element$iv$iv2 instanceof OuroList) {
                                            destination$iv$iv.add(element$iv$iv2);
                                        }
                                        element$iv$iv = childrenList;
                                        paras = paras2;
                                    }
                                    collection = (List) destination$iv$iv;
                                } else {
                                    collection = null;
                                }
                                Collection collection2 = collection;
                                if (collection2 == null || collection2.isEmpty()) {
                                    $this$mutate.removeFromParent(currentItem);
                                }
                                $textRange.element = new OuroTextRange(((OuroTextRange) $textRange.element).getMax());
                                return Unit.INSTANCE;
                            }
                        }
                    } else if (OuroNodeStorageUtilsKt.willGetIntoList($this$mutate, sel)) {
                        NodeStorageBuilder $this$getPreviousSelectableOrNull$iv = $this$mutate;
                        int prevIndex$iv = sel.getStart().getIndex() - 1;
                        if (prevIndex$iv >= 0) {
                            Object orNull2 = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
                            if (!(orNull2 instanceof OuroNode.Selectable)) {
                                orNull2 = null;
                            }
                            ouroNode = (OuroNode.Selectable) orNull2;
                        } else {
                            ouroNode = null;
                        }
                        OuroNode beforeElement = ouroNode;
                        if (beforeElement != null) {
                            OuroNode p02 = beforeElement;
                            NodeStorageBuilder $this$findFirstAncestorOrNull$iv = $this$mutate;
                            OuroNode.Parent<?> firstAncestorOrNull = $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(p02, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$handleDeleteImpl$lambda$0$stub_for_inlining$13$$inlined$findFirstAncestorOrNull$1
                                public final Boolean invoke(OuroNode.Parent<?> parent3) {
                                    Intrinsics.checkNotNullParameter(parent3, "it");
                                    return Boolean.valueOf(parent3 instanceof OuroListItem);
                                }
                            });
                            if (!(firstAncestorOrNull instanceof OuroListItem)) {
                                firstAncestorOrNull = null;
                            }
                            ouroListItem = (OuroListItem) firstAncestorOrNull;
                        } else {
                            ouroListItem = null;
                        }
                        OuroListItem targetItem = ouroListItem;
                        NodeStorageBuilder $this$getNextSelectableOrNull$iv2 = $this$mutate;
                        OuroPoint point$iv2 = sel.getStart();
                        int nextIndex$iv2 = point$iv2.isInside() ? point$iv2.getIndex() + 1 : point$iv2.getIndex();
                        if (nextIndex$iv2 < $this$getNextSelectableOrNull$iv2.getAllSelectables().size()) {
                            Object orNull3 = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv2.getAllSelectables(), nextIndex$iv2);
                            if (!(orNull3 instanceof OuroNode.Selectable)) {
                                orNull3 = null;
                            }
                            ouroNode2 = (OuroNode.Selectable) orNull3;
                        } else {
                            ouroNode2 = null;
                        }
                        OuroNode afterElement3 = ouroNode2;
                        if (afterElement3 != null) {
                            OuroNode p03 = afterElement3;
                            NodeStorageBuilder $this$findFirstAncestorOrNull$iv2 = $this$mutate;
                            OuroNode.Parent<?> firstAncestorOrNull2 = $this$findFirstAncestorOrNull$iv2.firstAncestorOrNull(p03, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$handleDeleteImpl$lambda$0$stub_for_inlining$14$$inlined$findFirstAncestorOrNull$1
                                public final Boolean invoke(OuroNode.Parent<?> parent3) {
                                    Intrinsics.checkNotNullParameter(parent3, "it");
                                    return Boolean.valueOf(parent3 instanceof OuroParagraph);
                                }
                            });
                            if (!(firstAncestorOrNull2 instanceof OuroParagraph)) {
                                firstAncestorOrNull2 = null;
                            }
                            ouroParagraph = (OuroParagraph) firstAncestorOrNull2;
                        } else {
                            ouroParagraph = null;
                        }
                        OuroParagraph afterParagraph = ouroParagraph;
                        if (targetItem != null && afterParagraph != null) {
                            $this$mutate.removeFromParent(afterParagraph);
                            $this$mutate.add(targetItem, afterParagraph);
                            $textRange.element = new OuroTextRange(((OuroTextRange) $textRange.element).getMin());
                            return Unit.INSTANCE;
                        }
                    }
                }
                OuroSelection s = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection($this$mutate, (OuroTextRange) $textRange.element, $displayLengthTransform), $this$mutate.getAllSelectables(), false, 4, null);
                $textRange.element = new OuroTextRange(OuroTextRangeKt.getTextRange($this$mutate, s, $displayLengthTransform).getMin());
                Integer.valueOf(removeSelectedElements($this$mutate, s));
            }
            $textRange.element = $oldState.getTextRange(OuroNodeStorageUtilsKt.constrainSelection$default($oldState.getSelection((OuroTextRange) $textRange.element), $this$mutate.getAllSelectables(), false, 4, null));
        } else if (((OuroTextRange) $textRange.element).getStart() == 0) {
            if (OuroNodeStorageUtilsKt.isQuoteStart($this$mutate, $cursorSelection)) {
                moveOutFirstParagraphInQuoteBlock($this$mutate, $cursorSelection);
                $textRange.element = new OuroTextRange(0);
                return Unit.INSTANCE;
            }
            OuroListItem it8 = OuroNodeStorageUtilsKt.getParentListItemOrNull($this$mutate, $state.getSelection().getStart());
            if (it8 != null) {
                OuroNodeStorageUtilsKt.outdentListItem($this$mutate, it8);
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
            $textRange.element = new OuroTextRange(0);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleUnmarkTextAction(OuroUnmarkTextAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                OuroState handleUnmarkTextAction$lambda$0;
                handleUnmarkTextAction$lambda$0 = OuroEditActionReducerKt.handleUnmarkTextAction$lambda$0((OuroState) obj);
                return handleUnmarkTextAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleUnmarkTextAction$lambda$0(OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OuroState.copy$default($this$mutate, null, null, null, null, null, 27, null);
    }

    public static final ChangedState<OuroState> handleInsertStoragesAction(final OuroInsertStoragesAction<?> ouroInsertStoragesAction, State<OuroState> state) {
        Intrinsics.checkNotNullParameter(ouroInsertStoragesAction, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        return FlowReduxUtilsKt.mutate(state, ouroInsertStoragesAction.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                OuroState handleInsertStoragesAction$lambda$0;
                handleInsertStoragesAction$lambda$0 = OuroEditActionReducerKt.handleInsertStoragesAction$lambda$0(OuroInsertStoragesAction.this, (OuroState) obj);
                return handleInsertStoragesAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleInsertStoragesAction$lambda$0(OuroInsertStoragesAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return insertStorages($this$mutate, $action.getStorages(), $action.getRange());
    }

    public static /* synthetic */ OuroState insertStorages$default(OuroState ouroState, List list, OuroTextRange ouroTextRange, int i, Object obj) {
        if ((i & 2) != 0) {
            ouroTextRange = null;
        }
        return insertStorages(ouroState, list, ouroTextRange);
    }

    public static final OuroState insertStorages(OuroState $this$insertStorages, final List<? extends OuroNodeStorage<?>> list, OuroTextRange range) {
        OuroTextRange textRangeAfter;
        Intrinsics.checkNotNullParameter($this$insertStorages, "<this>");
        Intrinsics.checkNotNullParameter(list, "storages");
        OuroTextRange range2 = range == null ? $this$insertStorages.getTextRange() : range;
        final Ref.ObjectRef lastInsertedSelectable = new Ref.ObjectRef();
        NodeStorage newStorage = OuroNodeStorageUtilsKt.mutate($this$insertStorages.getStorage(), range2, $this$insertStorages.getDisplayLengthTransform(), new Function2() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda24
            public final Object invoke(Object obj, Object obj2) {
                Unit insertStorages$lambda$0;
                insertStorages$lambda$0 = OuroEditActionReducerKt.insertStorages$lambda$0(list, lastInsertedSelectable, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return insertStorages$lambda$0;
            }
        });
        OuroNode.Selectable it = (OuroNode.Selectable) lastInsertedSelectable.element;
        OuroTextRange finalRange = (it == null || (textRangeAfter = OuroNodeStorageUtilsKt.getTextRangeAfter(newStorage, it, $this$insertStorages.getDisplayLengthTransform())) == null) ? range2 : textRangeAfter;
        return OuroState.copy$default($this$insertStorages, newStorage, finalRange, null, null, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertStorages$lambda$0(List $storages, Ref.ObjectRef $lastInsertedSelectable, NodeStorageBuilder $this$mutate, OuroSelection sel) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Intrinsics.checkNotNullParameter(sel, "sel");
        removeSelectedElements($this$mutate, sel);
        List $this$fold$iv = $storages;
        OuroPoint start = sel.getStart();
        for (Object element$iv : $this$fold$iv) {
            OuroNodeStorage storage = (OuroNodeStorage) element$iv;
            OuroPoint acc = start;
            OuroNode.Selectable lastSelectable = (OuroNode.Selectable) CollectionsKt.lastOrNull(storage.getAllSelectables());
            if (lastSelectable != null) {
                $lastInsertedSelectable.element = lastSelectable;
            }
            start = insertStorage($this$mutate, storage, acc);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleReplaceStorageAction(final OuroReplaceStorageAction action, State<OuroState> state) {
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda23
            public final Object invoke(Object obj) {
                OuroState handleReplaceStorageAction$lambda$0;
                handleReplaceStorageAction$lambda$0 = OuroEditActionReducerKt.handleReplaceStorageAction$lambda$0(OuroReplaceStorageAction.this, (OuroState) obj);
                return handleReplaceStorageAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleReplaceStorageAction$lambda$0(OuroReplaceStorageAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OuroState.copy$default($this$mutate, $action.getStorage(), OuroTextRange.Companion.getZero(), null, null, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleIndentAction(OuroIndentAction action, final State<OuroState> state) {
        final OuroTextRange textRange = action.getRange();
        if (textRange == null) {
            textRange = ((OuroState) state.getSnapshot()).getTextRange();
        }
        final NodeStorage newStorage = NodeStorage.mutate$core_debug$default(((OuroState) state.getSnapshot()).getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit handleIndentAction$lambda$0;
                handleIndentAction$lambda$0 = OuroEditActionReducerKt.handleIndentAction$lambda$0(OuroTextRange.this, state, (NodeStorageBuilder) obj);
                return handleIndentAction$lambda$0;
            }
        }, 1, null);
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                OuroState handleIndentAction$lambda$1;
                handleIndentAction$lambda$1 = OuroEditActionReducerKt.handleIndentAction$lambda$1(NodeStorage.this, textRange, (OuroState) obj);
                return handleIndentAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit handleIndentAction$lambda$0(OuroTextRange $textRange, State $state, NodeStorageBuilder $this$mutate) {
        OuroSelection selection;
        OuroTextIndentMark newMark;
        List it;
        List paragraphs;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroSelection selection2 = OuroSelectionKt.getSelection($this$mutate, $textRange, ((OuroState) $state.getSnapshot()).getDisplayLengthTransform());
        List paragraphs2 = OuroNodeStorageKt.getSelectedParagraphs$default($this$mutate, selection2, false, false, 6, null);
        List $this$forEach$iv = paragraphs2;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph paragraph = (OuroParagraph) element$iv;
            NodeStorageBuilder $this$findFirstAncestorOrNull$iv = $this$mutate;
            OuroParagraph node$iv = paragraph;
            OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$handleIndentAction$lambda$0$0$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    return Boolean.valueOf(parent instanceof OuroListItem);
                }
            }) : null;
            if (!(firstAncestorOrNull instanceof OuroListItem)) {
                firstAncestorOrNull = null;
            }
            OuroListItem listItem = (OuroListItem) firstAncestorOrNull;
            if (listItem != null) {
                Integer indexInSiblings = $this$mutate.getIndexInSiblings(listItem);
                if (indexInSiblings != null && indexInSiblings.intValue() == 0) {
                    selection = selection2;
                    paragraphs = paragraphs2;
                } else {
                    OuroNodeStorageUtilsKt.indentListItem($this$mutate, listItem);
                    selection = selection2;
                    paragraphs = paragraphs2;
                }
            } else {
                OuroTextIndentMark indentMark = (OuroTextIndentMark) paragraph.getParagraphMarks().get(OuroTextIndentMark.Key.INSTANCE);
                if (indentMark == null) {
                    indentMark = new OuroTextIndentMark(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
                }
                if (!selection2.isCollapsed()) {
                    selection = selection2;
                } else if (selection2.getStart().getOffset() != 0) {
                    selection = selection2;
                } else if (!(indentMark.getFirstLine() == 0.0f)) {
                    selection = selection2;
                } else if (!(indentMark.getHanging() == 0.0f)) {
                    selection = selection2;
                } else {
                    selection = selection2;
                    newMark = OuroTextIndentMark.copy$default(indentMark, 22.0f, 0.0f, 2, null);
                    OuroParagraph newParagraph = paragraph.copyWithMarks(paragraph.getParagraphMarks().plus((OuroMarks<OuroParagraphMark>) newMark));
                    it = $this$mutate.removeAllChildren(paragraph);
                    if (it == null) {
                        paragraphs = paragraphs2;
                        $this$mutate.addChildren(newParagraph, it);
                    } else {
                        paragraphs = paragraphs2;
                    }
                    $this$mutate.replace(paragraph, newParagraph);
                }
                if (indentMark.getFirstLine() < 66.0f && indentMark.getHanging() < 66.0f) {
                    newMark = indentMark.copy(Math.min(indentMark.getFirstLine() + 22.0f, 66.0f), Math.min(indentMark.getHanging() + 22.0f, 66.0f));
                } else {
                    newMark = indentMark;
                }
                OuroParagraph newParagraph2 = paragraph.copyWithMarks(paragraph.getParagraphMarks().plus((OuroMarks<OuroParagraphMark>) newMark));
                it = $this$mutate.removeAllChildren(paragraph);
                if (it == null) {
                }
                $this$mutate.replace(paragraph, newParagraph2);
            }
            selection2 = selection;
            paragraphs2 = paragraphs;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleIndentAction$lambda$1(NodeStorage $newStorage, OuroTextRange $textRange, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OuroState.copy$default($this$mutate, $newStorage, $textRange, null, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleOutdentAction(OuroOutdentAction action, final State<OuroState> state) {
        final OuroTextRange textRange = action.getRange();
        if (textRange == null) {
            textRange = ((OuroState) state.getSnapshot()).getTextRange();
        }
        final NodeStorage newStorage = NodeStorage.mutate$core_debug$default(((OuroState) state.getSnapshot()).getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                Unit handleOutdentAction$lambda$0;
                handleOutdentAction$lambda$0 = OuroEditActionReducerKt.handleOutdentAction$lambda$0(OuroTextRange.this, state, (NodeStorageBuilder) obj);
                return handleOutdentAction$lambda$0;
            }
        }, 1, null);
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                OuroState handleOutdentAction$lambda$1;
                handleOutdentAction$lambda$1 = OuroEditActionReducerKt.handleOutdentAction$lambda$1(NodeStorage.this, textRange, (OuroState) obj);
                return handleOutdentAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleOutdentAction$lambda$0(OuroTextRange $textRange, State $state, NodeStorageBuilder $this$mutate) {
        OuroParagraph newParagraph;
        List paragraphs;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroNode.Parent<?> parent = null;
        OuroSelection selection = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection($this$mutate, $textRange, ((OuroState) $state.getSnapshot()).getDisplayLengthTransform()), $this$mutate.getAllSelectables(), false, 4, null);
        List paragraphs2 = OuroNodeStorageKt.getSelectedParagraphs$default($this$mutate, selection, false, false, 6, null);
        List $this$forEach$iv = paragraphs2;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph paragraph = (OuroParagraph) element$iv;
            NodeStorageBuilder $this$findFirstAncestorOrNull$iv = $this$mutate;
            OuroParagraph node$iv = paragraph;
            OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$handleOutdentAction$lambda$0$0$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent2) {
                    Intrinsics.checkNotNullParameter(parent2, "it");
                    return Boolean.valueOf(parent2 instanceof OuroListItem);
                }
            }) : parent;
            if (!(firstAncestorOrNull instanceof OuroListItem)) {
                firstAncestorOrNull = parent;
            }
            OuroListItem listItem = (OuroListItem) firstAncestorOrNull;
            if (listItem != null) {
                OuroNodeStorageUtilsKt.outdentListItem($this$mutate, listItem);
                paragraphs = paragraphs2;
            } else {
                OuroTextIndentMark mark = (OuroTextIndentMark) paragraph.getParagraphMarks().get(OuroTextIndentMark.Key.INSTANCE);
                if (mark != null && (mark.getFirstLine() > 22.0f || mark.getHanging() > 22.0f)) {
                    OuroTextIndentMark newMark = mark.copy(mark.getFirstLine() - 22.0f, mark.getHanging() - 22.0f);
                    newParagraph = paragraph.copyWithMarks(paragraph.getParagraphMarks().plus((OuroMarks<OuroParagraphMark>) newMark));
                } else {
                    newParagraph = paragraph.copyWithMarks(paragraph.getParagraphMarks().minus(OuroTextIndentMark.Key.INSTANCE));
                }
                List it = $this$mutate.removeAllChildren(paragraph);
                if (it == null) {
                    paragraphs = paragraphs2;
                } else {
                    paragraphs = paragraphs2;
                    $this$mutate.addChildren(newParagraph, it);
                }
                $this$mutate.replace(paragraph, newParagraph);
            }
            paragraphs2 = paragraphs;
            parent = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleOutdentAction$lambda$1(NodeStorage $newStorage, OuroTextRange $textRange, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OuroState.copy$default($this$mutate, $newStorage, $textRange, null, null, null, 28, null);
    }

    public static final OuroPoint insertStorage(NodeStorageBuilder<OuroDocument> nodeStorageBuilder, OuroNodeStorage<? extends OuroNode.Parent<?>> ouroNodeStorage, OuroPoint point) {
        OuroNode.Selectable selectable;
        OuroNode.Selectable selectable2;
        Intrinsics.checkNotNullParameter(nodeStorageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "storage");
        Intrinsics.checkNotNullParameter(point, "point");
        NodeStorageBuilder<OuroDocument> $this$getPreviousSelectableOrNull$iv = nodeStorageBuilder;
        int prevIndex$iv = point.getIndex() - 1;
        if (prevIndex$iv >= 0) {
            Object orNull = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            selectable = (OuroNode.Selectable) orNull;
        } else {
            selectable = null;
        }
        OuroNode.Selectable beforeElement = selectable;
        NodeStorageBuilder<OuroDocument> $this$getNextSelectableOrNull$iv = nodeStorageBuilder;
        int nextIndex$iv = point.isInside() ? point.getIndex() + 1 : point.getIndex();
        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
            Object orNull2 = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
            if (!(orNull2 instanceof OuroNode.Selectable)) {
                orNull2 = null;
            }
            selectable2 = (OuroNode.Selectable) orNull2;
        } else {
            selectable2 = null;
        }
        OuroNode.Selectable afterElement = selectable2;
        if (beforeElement != null && afterElement != null && !nodeStorageBuilder.isSiblingOf(afterElement, beforeElement)) {
            OuroNodeStorageUtilsKt.insertBefore(nodeStorageBuilder, ouroNodeStorage, afterElement);
        } else if (beforeElement != null) {
            OuroNodeStorageUtilsKt.insertAfter(nodeStorageBuilder, ouroNodeStorage, beforeElement);
        } else if (afterElement != null) {
            OuroNodeStorageUtilsKt.insertBefore(nodeStorageBuilder, ouroNodeStorage, afterElement);
        } else {
            insertStorageToRoot$default(nodeStorageBuilder, ouroNodeStorage, false, 2, null);
        }
        return new OuroPoint(point.getIndex() + ouroNodeStorage.getAllSelectables().size(), 0, 2, null);
    }

    static /* synthetic */ void insertStorageToRoot$default(OuroNodeMutableStorage ouroNodeMutableStorage, OuroNodeStorage ouroNodeStorage, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        insertStorageToRoot(ouroNodeMutableStorage, ouroNodeStorage, z);
    }

    private static final void insertStorageToRoot(OuroNodeMutableStorage<OuroDocument> ouroNodeMutableStorage, OuroNodeStorage<?> ouroNodeStorage, boolean insertAtStart) {
        List<OuroNode> children;
        int index = 0;
        if (!insertAtStart && (children = ouroNodeMutableStorage.getChildren(ouroNodeMutableStorage.getRoot())) != null) {
            index = children.size();
        }
        Object root = ouroNodeStorage.getRoot();
        if (root instanceof OuroParagraphChild) {
            OuroText p = new OuroText(null, 1, null);
            ouroNodeMutableStorage.add(ouroNodeMutableStorage.getRoot(), index, p);
            ouroNodeMutableStorage.add((OuroNodeMutableStorage<OuroDocument>) p, ouroNodeStorage);
        } else if (root instanceof OuroDocumentChild) {
            ouroNodeMutableStorage.add((OuroNodeMutableStorage<OuroDocument>) ouroNodeMutableStorage.getRoot(), index, ouroNodeStorage);
        }
    }

    private static final void insertDocument$insert(OuroNodeMutableStorage<OuroDocument> ouroNodeMutableStorage, NodeStorage<OuroDocument> nodeStorage, OuroNode targetNode, boolean insertBefore) {
        boolean z;
        boolean z2 = false;
        if (targetNode != null) {
            OuroNodeMutableStorage<OuroDocument> $this$findFirstAncestorOrNull$iv = ouroNodeMutableStorage;
            OuroNode.Parent<?> firstAncestorOrNull = $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(targetNode, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$insertDocument$insert$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    return Boolean.valueOf(parent instanceof OuroListItem);
                }
            });
            if (!(firstAncestorOrNull instanceof OuroListItem)) {
                firstAncestorOrNull = null;
            }
            OuroListItem targetListItem = (OuroListItem) firstAncestorOrNull;
            OuroNodeMutableStorage<OuroDocument> $this$findFirstAncestorOrNull$iv2 = ouroNodeMutableStorage;
            OuroNode.Parent<?> firstAncestorOrNull2 = $this$findFirstAncestorOrNull$iv2.firstAncestorOrNull(targetNode, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$insertDocument$insert$$inlined$findFirstAncestorOrNull$2
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    return Boolean.valueOf(parent instanceof OuroQuoteBlock);
                }
            });
            OuroQuoteBlock targetQuote = firstAncestorOrNull2 instanceof OuroQuoteBlock ? firstAncestorOrNull2 : null;
            if (targetListItem == null) {
                z = false;
            } else {
                z = true;
            }
            if (targetQuote != null) {
                z2 = true;
            }
            Iterable insertableStorages = insertableStorages(nodeStorage, z, z2);
            Iterable $this$forEach$iv = insertableStorages;
            for (Object element$iv : $this$forEach$iv) {
                OuroNodeStorage storage = (OuroNodeStorage) element$iv;
                if (insertBefore) {
                    OuroNodeStorageUtilsKt.insertBefore(ouroNodeMutableStorage, storage, targetNode);
                } else {
                    OuroNodeStorageUtilsKt.insertAfter(ouroNodeMutableStorage, storage, targetNode);
                }
            }
            return;
        }
        Iterable insertableStorages2 = insertableStorages(nodeStorage, false, false);
        Iterable $this$forEach$iv2 = insertableStorages2;
        for (Object element$iv2 : $this$forEach$iv2) {
            insertStorageToRoot(ouroNodeMutableStorage, (OuroNodeStorage) element$iv2, false);
        }
    }

    public static final void insertDocument(OuroNodeMutableStorage<OuroDocument> ouroNodeMutableStorage, NodeStorage<OuroDocument> nodeStorage, int offset, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        OuroNode.Selectable selectable;
        OuroNode.Selectable selectable2;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(nodeStorage, "document");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        OuroTextRange textRange = new OuroTextRange(offset);
        OuroSelection selection = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection(ouroNodeMutableStorage, textRange, function2), ouroNodeMutableStorage.getAllSelectables(), false, 4, null);
        OuroNodeMutableStorage<OuroDocument> $this$getNextSelectableOrNull$iv = ouroNodeMutableStorage;
        OuroPoint point$iv = selection.getAnchor();
        int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            selectable = (OuroNode.Selectable) orNull;
        } else {
            selectable = null;
        }
        OuroNode.Selectable afterElement = selectable;
        if (afterElement == null) {
            OuroNodeMutableStorage<OuroDocument> $this$getPreviousSelectableOrNull$iv = ouroNodeMutableStorage;
            int prevIndex$iv = selection.getAnchor().getIndex() - 1;
            if (prevIndex$iv >= 0) {
                Object orNull2 = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
                if (!(orNull2 instanceof OuroNode.Selectable)) {
                    orNull2 = null;
                }
                selectable2 = (OuroNode.Selectable) orNull2;
            } else {
                selectable2 = null;
            }
            OuroNode.Selectable beforeElement = selectable2;
            if (beforeElement == null) {
                insertDocument$insert(ouroNodeMutableStorage, nodeStorage, null, false);
                return;
            } else {
                insertDocument$insert(ouroNodeMutableStorage, nodeStorage, beforeElement, false);
                return;
            }
        }
        insertDocument$insert(ouroNodeMutableStorage, nodeStorage, afterElement, true);
    }

    public static final List<OuroNodeStorage<?>> insertableStorages(NodeStorage<OuroDocument> nodeStorage, boolean inList, boolean inQuote) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        List storages = new ArrayList();
        dfsTraverse(nodeStorage, nodeStorage.getRoot(), inList, inQuote, storages);
        return storages;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void dfsTraverse(NodeStorage<OuroDocument> nodeStorage, OuroNode currentNode, boolean inList, boolean inQuote, List<OuroNodeStorage<?>> list) {
        if (currentNode == null) {
            return;
        }
        if (canInsert(nodeStorage, currentNode, inList, inQuote) && (currentNode instanceof OuroNode.Parent)) {
            NodeStorage it = nodeStorage.subStorage((NodeStorage<OuroDocument>) ((OuroNode.Parent) currentNode));
            if (it != null) {
                list.add(it);
            }
            dfsTraverse(nodeStorage, nodeStorage.getSiblingNext(currentNode), inList, inQuote, list);
            return;
        }
        if (currentNode instanceof OuroNode.Parent) {
            List<OuroNode> children = nodeStorage.getChildren((OuroNode.Parent) currentNode);
            dfsTraverse(nodeStorage, children != null ? (OuroNode) CollectionsKt.first(children) : null, inList, inQuote, list);
        }
        dfsTraverse(nodeStorage, nodeStorage.getSiblingNext(currentNode), inList, inQuote, list);
    }

    private static final boolean canInsert(OuroNodeStorage<OuroDocument> ouroNodeStorage, OuroNode node, boolean inList, boolean inQuote) {
        List<OuroNode> children;
        if (node instanceof OuroList) {
            if (inList || inQuote) {
                return false;
            }
            List<OuroNode> children2 = ouroNodeStorage.getChildren((OuroNode.Parent) node);
            OuroNode ouroNode = children2 != null ? (OuroNode) CollectionsKt.first(children2) : null;
            OuroListItem firstItem = ouroNode instanceof OuroListItem ? (OuroListItem) ouroNode : null;
            if (firstItem != null && (children = ouroNodeStorage.getChildren(firstItem)) != null) {
                r1 = (OuroNode) CollectionsKt.single(children);
            }
            return !(r1 instanceof OuroList);
        } else if (!(node instanceof OuroListItem)) {
            return node instanceof OuroQuoteBlock ? (inQuote || inList) ? false : true : node instanceof OuroDrawable ? (inList || inQuote) ? false : true : !(node instanceof OuroDocument);
        } else {
            List<OuroNode> children3 = ouroNodeStorage.getChildren((OuroNode.Parent) node);
            if ((children3 != null ? (OuroNode) CollectionsKt.single(children3) : null) instanceof OuroList) {
                return false;
            }
            return inList && !inQuote;
        }
    }

    private static final boolean needDeleteConfirm(List<? extends OuroNode> list, OuroTextRange cursorRange, OuroTextRange deletedRange) {
        return list.size() == 1 && (CollectionsKt.first(list) instanceof OuroNode.DeleteConfirm) && cursorRange.getCollapsed() && cursorRange.getStart() == deletedRange.getMax();
    }

    private static final boolean insertTextsAfterElement(NodeStorageBuilder<?> nodeStorageBuilder, OuroNode element, List<? extends OuroTextElement> list) {
        Integer indexInSiblings;
        OuroNode.Parent<?> parent = nodeStorageBuilder.getParent(element);
        OuroParagraph paragraph = parent instanceof OuroParagraph ? (OuroParagraph) parent : null;
        if (paragraph == null || (indexInSiblings = nodeStorageBuilder.getIndexInSiblings(element)) == null) {
            return false;
        }
        int indexInParent = indexInSiblings.intValue();
        nodeStorageBuilder.addChildren(paragraph, indexInParent + 1, list);
        return true;
    }

    private static final boolean insertTextsBeforeElement(NodeStorageBuilder<?> nodeStorageBuilder, OuroNode element, List<? extends OuroTextElement> list) {
        Integer indexInSiblings;
        OuroNode.Parent<?> parent = nodeStorageBuilder.getParent(element);
        OuroParagraph paragraph = parent instanceof OuroParagraph ? (OuroParagraph) parent : null;
        if (paragraph == null || (indexInSiblings = nodeStorageBuilder.getIndexInSiblings(element)) == null) {
            return false;
        }
        int indexInParent = indexInSiblings.intValue();
        nodeStorageBuilder.addChildren(paragraph, indexInParent, list);
        return true;
    }

    private static final <T extends OuroParagraph> void insertParagraphAfterElement(NodeStorageBuilder<?> nodeStorageBuilder, OuroNode element, OuroNodeStorage<T> ouroNodeStorage) {
        OuroNode.Parent parent = element != null ? nodeStorageBuilder.getParent(element) : null;
        if (parent == null) {
            nodeStorageBuilder.add((NodeStorageBuilder<?>) nodeStorageBuilder.getRoot(), 0, (OuroNodeStorage<?>) ouroNodeStorage);
        } else if (parent.isValidParentOf(ouroNodeStorage.getRoot())) {
            nodeStorageBuilder.addSiblingNext((NodeStorageBuilder<?>) element, (OuroNodeStorage<?>) ouroNodeStorage);
        } else {
            insertParagraphAfterElement(nodeStorageBuilder, parent, ouroNodeStorage);
        }
    }

    private static final void replaceSelectedElementsWithTexts(NodeStorageBuilder<?> nodeStorageBuilder, OuroSelection selection, List<? extends OuroTextElement> list) {
        OuroNode.Parent<?> parent;
        OuroParagraph newParent;
        Integer indexInSiblings;
        Integer indexInSiblings2;
        List elements = OuroNodeStorageUtilsKt.getSelectables(nodeStorageBuilder, selection);
        OuroNode.Selectable targetElement = (OuroNode.Selectable) CollectionsKt.firstOrNull(elements);
        if (targetElement == null) {
            targetElement = (OuroNode.Selectable) CollectionsKt.lastOrNull(elements);
        }
        if (targetElement != null) {
            parent = nodeStorageBuilder.firstAncestorOrNull(targetElement, new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    boolean replaceSelectedElementsWithTexts$lambda$0;
                    replaceSelectedElementsWithTexts$lambda$0 = OuroEditActionReducerKt.replaceSelectedElementsWithTexts$lambda$0((OuroNode.Parent) obj);
                    return Boolean.valueOf(replaceSelectedElementsWithTexts$lambda$0);
                }
            });
        } else {
            parent = null;
        }
        OuroParagraph parent2 = parent instanceof OuroParagraph ? (OuroParagraph) parent : null;
        if ((targetElement == null || (indexInSiblings2 = nodeStorageBuilder.getIndexInSiblings(targetElement)) == null || indexInSiblings2.intValue() != 0) ? false : true) {
            int indexInParent = (parent2 == null || (indexInSiblings = nodeStorageBuilder.getIndexInSiblings(parent2)) == null) ? 0 : indexInSiblings.intValue();
            if (parent2 != null && (newParent = parent2.copyWithMarks(parent2.getParagraphMarks())) != null) {
                nodeStorageBuilder.add(newParent, list);
                OuroNode.Parent<?> parent3 = nodeStorageBuilder.getParent(parent2);
                if (parent3 != null) {
                    nodeStorageBuilder.add(parent3, indexInParent, newParent);
                }
                List $this$forEach$iv = elements;
                for (Object element$iv : $this$forEach$iv) {
                    OuroNode.Selectable element = (OuroNode.Selectable) element$iv;
                    OuroNode.Parent p = nodeStorageBuilder.getParent(element);
                    nodeStorageBuilder.removeFromParent(element);
                    while (p != null) {
                        List<OuroNode> children = nodeStorageBuilder.getChildren(p);
                        if (children == null || children.isEmpty()) {
                            OuroNode.Parent tmp = nodeStorageBuilder.getParent(p);
                            nodeStorageBuilder.removeFromParent(p);
                            p = tmp;
                        }
                    }
                }
                return;
            }
            return;
        }
        int indexInParent2 = removeSelectedElements(nodeStorageBuilder, selection);
        if (parent2 != null) {
            nodeStorageBuilder.addChildren(parent2, indexInParent2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean replaceSelectedElementsWithTexts$lambda$0(OuroNode.Parent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof OuroParagraph;
    }

    public static final int removeSelectedElements(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroSelection selection) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        List elements = OuroNodeStorageUtilsKt.getSelectables(ouroNodeMutableStorage, selection);
        OuroNode.Selectable targetElement = (OuroNode.Selectable) CollectionsKt.firstOrNull(elements);
        if (targetElement == null) {
            return 0;
        }
        Integer indexInSiblings = ouroNodeMutableStorage.getIndexInSiblings(targetElement);
        int indexInParent = indexInSiblings != null ? indexInSiblings.intValue() : 0;
        List $this$forEach$iv = elements;
        for (Object element$iv : $this$forEach$iv) {
            OuroNode.Selectable element = (OuroNode.Selectable) element$iv;
            OuroNode.Parent p = ouroNodeMutableStorage.getParent(element);
            ouroNodeMutableStorage.removeFromParent(element);
            while (p != null) {
                List<OuroNode> children = ouroNodeMutableStorage.getChildren(p);
                if (children == null || children.isEmpty()) {
                    OuroNode.Parent tmp = ouroNodeMutableStorage.getParent(p);
                    ouroNodeMutableStorage.removeFromParent(p);
                    p = tmp;
                }
            }
        }
        return indexInParent;
    }

    private static final boolean isSingleHarkBreak(List<? extends OuroNode> list) {
        return list.size() == 1 && (CollectionsKt.first(list) instanceof OuroTextElement.HardBreak);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleReplaceNodeAction(OuroReplaceNodeAction action, State<OuroState> state) {
        final OuroNode old = action.getOld();
        final OuroNode replacement = action.getNode();
        final boolean preserveChildren = action.getPreserveChildren();
        final NodeStorage newStorage = NodeStorage.mutate$core_debug$default(((OuroState) state.getSnapshot()).getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                Unit handleReplaceNodeAction$lambda$0;
                handleReplaceNodeAction$lambda$0 = OuroEditActionReducerKt.handleReplaceNodeAction$lambda$0(preserveChildren, old, replacement, (NodeStorageBuilder) obj);
                return handleReplaceNodeAction$lambda$0;
            }
        }, 1, null);
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                OuroState handleReplaceNodeAction$lambda$1;
                handleReplaceNodeAction$lambda$1 = OuroEditActionReducerKt.handleReplaceNodeAction$lambda$1(NodeStorage.this, (OuroState) obj);
                return handleReplaceNodeAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleReplaceNodeAction$lambda$0(boolean $preserveChildren, OuroNode $old, OuroNode $replacement, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        if (!$preserveChildren && ($old instanceof OuroNode.Parent)) {
            $this$mutate.removeAllChildren((OuroNode.Parent) $old);
        }
        $this$mutate.replace($old, $replacement);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleReplaceNodeAction$lambda$1(NodeStorage $newStorage, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OuroState.copy$default($this$mutate, $newStorage, null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleReplaceNodeWithStorageAction(OuroReplaceNodeWithStorageAction action, final State<OuroState> state) {
        final OuroNode old = action.getOld();
        final OuroNodeStorage replacement = action.getStorage();
        final Ref.ObjectRef textRange = new Ref.ObjectRef();
        textRange.element = ((OuroState) state.getSnapshot()).getTextRange();
        final NodeStorage newStorage = NodeStorage.mutate$core_debug$default(((OuroState) state.getSnapshot()).getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit handleReplaceNodeWithStorageAction$lambda$0;
                handleReplaceNodeWithStorageAction$lambda$0 = OuroEditActionReducerKt.handleReplaceNodeWithStorageAction$lambda$0(textRange, state, old, replacement, (NodeStorageBuilder) obj);
                return handleReplaceNodeWithStorageAction$lambda$0;
            }
        }, 1, null);
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                OuroState handleReplaceNodeWithStorageAction$lambda$1;
                handleReplaceNodeWithStorageAction$lambda$1 = OuroEditActionReducerKt.handleReplaceNodeWithStorageAction$lambda$1(NodeStorage.this, textRange, (OuroState) obj);
                return handleReplaceNodeWithStorageAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleReplaceNodeWithStorageAction$lambda$0(Ref.ObjectRef $textRange, State $state, OuroNode $old, OuroNodeStorage $replacement, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroSelection selection = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection($this$mutate, (OuroTextRange) $textRange.element, ((OuroState) $state.getSnapshot()).getDisplayLengthTransform()), $this$mutate.getAllSelectables(), false, 4, null);
        Integer indexInSiblings = $this$mutate.getIndexInSiblings($old);
        if (indexInSiblings == null) {
            return Unit.INSTANCE;
        }
        int index = indexInSiblings.intValue();
        OuroNode.Parent parent = $this$mutate.getParent($old);
        if (parent == null) {
            return Unit.INSTANCE;
        }
        $this$mutate.removeFromParent($old);
        $this$mutate.add((NodeStorageBuilder) parent, index, (OuroNodeStorage<?>) $replacement);
        $textRange.element = OuroTextRangeKt.getTextRange($this$mutate, selection, ((OuroState) $state.getSnapshot()).getDisplayLengthTransform());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleReplaceNodeWithStorageAction$lambda$1(NodeStorage $newStorage, Ref.ObjectRef $textRange, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OuroState.copy$default($this$mutate, $newStorage, (OuroTextRange) $textRange.element, null, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleReplacePlainNodesWithStoragesAction(OuroReplacePlainNodesWithStoragesAction action, final State<OuroState> state) {
        final List list = action.getList();
        final Ref.ObjectRef textRange = new Ref.ObjectRef();
        textRange.element = ((OuroState) state.getSnapshot()).getTextRange();
        final NodeStorage newStorage = NodeStorage.mutate$core_debug$default(((OuroState) state.getSnapshot()).getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit handleReplacePlainNodesWithStoragesAction$lambda$0;
                handleReplacePlainNodesWithStoragesAction$lambda$0 = OuroEditActionReducerKt.handleReplacePlainNodesWithStoragesAction$lambda$0(textRange, state, list, (NodeStorageBuilder) obj);
                return handleReplacePlainNodesWithStoragesAction$lambda$0;
            }
        }, 1, null);
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                OuroState handleReplacePlainNodesWithStoragesAction$lambda$1;
                handleReplacePlainNodesWithStoragesAction$lambda$1 = OuroEditActionReducerKt.handleReplacePlainNodesWithStoragesAction$lambda$1(NodeStorage.this, textRange, (OuroState) obj);
                return handleReplacePlainNodesWithStoragesAction$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleReplacePlainNodesWithStoragesAction$lambda$0(Ref.ObjectRef $textRange, State $state, List $list, NodeStorageBuilder $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroSelection selection = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection($this$mutate, (OuroTextRange) $textRange.element, ((OuroState) $state.getSnapshot()).getDisplayLengthTransform()), $this$mutate.getAllSelectables(), false, 4, null);
        List $this$forEach$iv = $list;
        for (Object element$iv : $this$forEach$iv) {
            Pair it = (Pair) element$iv;
            Integer indexInSiblings = $this$mutate.getIndexInSiblings((OuroNode) it.getFirst());
            if (indexInSiblings != null) {
                int index = indexInSiblings.intValue();
                OuroNode.Parent parent = $this$mutate.getParent((OuroNode) it.getFirst());
                if (parent != null) {
                    $this$mutate.removeFromParent((OuroNode) it.getFirst());
                    $this$mutate.add((NodeStorageBuilder) parent, index, (OuroNodeStorage) it.getSecond());
                }
            }
        }
        $textRange.element = OuroTextRangeKt.getTextRange($this$mutate, selection, ((OuroState) $state.getSnapshot()).getDisplayLengthTransform());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleReplacePlainNodesWithStoragesAction$lambda$1(NodeStorage $newStorage, Ref.ObjectRef $textRange, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return OuroState.copy$default($this$mutate, $newStorage, (OuroTextRange) $textRange.element, null, null, null, 28, null);
    }

    private static final void moveOutFirstParagraphInQuoteBlock(NodeStorageBuilder<OuroDocument> nodeStorageBuilder, OuroSelection cursorSelection) {
        OuroParagraph it = (OuroParagraph) CollectionsKt.firstOrNull(OuroNodeStorageKt.getSelectedParagraphs$default(nodeStorageBuilder, cursorSelection, false, false, 6, null));
        if (it != null) {
            OuroNode.Parent<?> parent = nodeStorageBuilder.getParent(it);
            OuroQuoteBlock quoteBlock = parent instanceof OuroQuoteBlock ? (OuroQuoteBlock) parent : null;
            if (quoteBlock == null) {
                return;
            }
            Integer indexInSiblings = nodeStorageBuilder.getIndexInSiblings(quoteBlock);
            int quoteIdx = indexInSiblings != null ? indexInSiblings.intValue() : 0;
            nodeStorageBuilder.removeFromParent(it);
            nodeStorageBuilder.addChild((OuroNode.Parent<int>) nodeStorageBuilder.getRoot(), quoteIdx, (int) it);
        }
    }

    public static final ChangedState<OuroState> handleInsertTextNode(final OuroInsertTextNodeAction action, State<OuroState> state) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                OuroState handleInsertTextNode$lambda$0;
                handleInsertTextNode$lambda$0 = OuroEditActionReducerKt.handleInsertTextNode$lambda$0(OuroInsertTextNodeAction.this, (OuroState) obj);
                return handleInsertTextNode$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleInsertTextNode$lambda$0(OuroInsertTextNodeAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroTextRange range = $action.getRange();
        if (range == null) {
            range = $this$mutate.getTextRange();
        }
        return insertTextNode($this$mutate, range, $action.getNode());
    }

    public static final ChangedState<OuroState> handleInsertTextNodes(final OuroInsertTextNodesAction action, State<OuroState> state) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                OuroState handleInsertTextNodes$lambda$0;
                handleInsertTextNodes$lambda$0 = OuroEditActionReducerKt.handleInsertTextNodes$lambda$0(OuroInsertTextNodesAction.this, (OuroState) obj);
                return handleInsertTextNodes$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleInsertTextNodes$lambda$0(OuroInsertTextNodesAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroTextRange range = $action.getRange();
        if (range == null) {
            range = $this$mutate.getTextRange();
        }
        return insertTextNodes($this$mutate, range, $action.getNodes());
    }

    public static final OuroState insertTextNode(OuroState state, final OuroTextRange range, OuroTextElement.Plain textNode) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(textNode, "textNode");
        Function2 displayLengthTransform = state.getDisplayLengthTransform();
        final List textList = CollectionsKt.listOf(textNode);
        NodeStorage oldStorage = state.getStorage();
        NodeStorage newStorage = OuroNodeStorageUtilsKt.mutate(oldStorage, range, displayLengthTransform, new Function2() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit insertTextNode$lambda$0;
                insertTextNode$lambda$0 = OuroEditActionReducerKt.insertTextNode$lambda$0(OuroTextRange.this, textList, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return insertTextNode$lambda$0;
            }
        });
        OuroTextRange finalRange = new OuroTextRange(range.getStart() + ((Number) displayLengthTransform.invoke(newStorage, textNode)).intValue());
        OuroSelection constrainedSel = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection(newStorage, finalRange, displayLengthTransform), newStorage.getAllSelectables(), false, 4, null);
        OuroTextRange finalRange2 = OuroTextRangeKt.getTextRange(newStorage, constrainedSel, displayLengthTransform);
        return OuroState.copy$default(state, newStorage, finalRange2, null, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertTextNode$lambda$0(OuroTextRange $range, List $textList, NodeStorageBuilder $this$mutate, OuroSelection selection) {
        OuroNode.Selectable selectable;
        OuroNode.Selectable selectable2;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (!$range.getCollapsed()) {
            replaceSelectedElementsWithTexts($this$mutate, selection, $textList);
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$getNextSelectableOrNull$iv = $this$mutate;
        OuroPoint point$iv = selection.getStart();
        int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            selectable = (OuroNode.Selectable) orNull;
        } else {
            selectable = null;
        }
        OuroNode.Selectable afterElement = selectable;
        if (afterElement != null && insertTextsBeforeElement($this$mutate, afterElement, $textList)) {
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$getPreviousSelectableOrNull$iv = $this$mutate;
        int prevIndex$iv = selection.getStart().getIndex() - 1;
        if (prevIndex$iv >= 0) {
            Object orNull2 = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
            if (!(orNull2 instanceof OuroNode.Selectable)) {
                orNull2 = null;
            }
            selectable2 = (OuroNode.Selectable) orNull2;
        } else {
            selectable2 = null;
        }
        OuroNode.Selectable beforeElement = selectable2;
        if (beforeElement != null && insertTextsAfterElement($this$mutate, beforeElement, $textList)) {
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$insertTextNode_u24lambda_u240_u240 = new NodeStorageBuilder(new OuroText(null, 1, null), null, null, 6, null);
        $this$insertTextNode_u24lambda_u240_u240.addChildren($this$insertTextNode_u24lambda_u240_u240.getRoot(), $textList);
        insertParagraphAfterElement($this$mutate, beforeElement, $this$insertTextNode_u24lambda_u240_u240);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleUpdateCompositionRangeAction(final OuroUpdateCompositionRangeAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                OuroState handleUpdateCompositionRangeAction$lambda$0;
                handleUpdateCompositionRangeAction$lambda$0 = OuroEditActionReducerKt.handleUpdateCompositionRangeAction$lambda$0(OuroUpdateCompositionRangeAction.this, (OuroState) obj);
                return handleUpdateCompositionRangeAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleUpdateCompositionRangeAction$lambda$0(OuroUpdateCompositionRangeAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        return Intrinsics.areEqual($action.getRange(), $this$mutate.getCompositionRange()) ? $this$mutate : OuroState.copy$default($this$mutate, null, null, $action.getRange(), null, null, 27, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleInsertCompositionTextAction(final OuroInsertCompositionTextAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OuroState handleInsertCompositionTextAction$lambda$0;
                handleInsertCompositionTextAction$lambda$0 = OuroEditActionReducerKt.handleInsertCompositionTextAction$lambda$0(OuroInsertCompositionTextAction.this, (OuroState) obj);
                return handleInsertCompositionTextAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleInsertCompositionTextAction$lambda$0(OuroInsertCompositionTextAction $action, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroTextRange range = $this$mutate.getCompositionRange();
        if (range == null) {
            range = $this$mutate.getTextRange();
        }
        OuroTextRange compositionRange = new OuroTextRange(range.getMin(), range.getMin() + $action.getText().length());
        return replaceText($this$mutate, range, compositionRange, $action.getText(), $action.getTextMarks());
    }

    public static final OuroState insertTextNodes(OuroState state, final OuroTextRange range, List<? extends OuroTextElement> list) {
        Iterable listOf;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(list, "textNodes");
        Function2 displayLengthTransform = state.getDisplayLengthTransform();
        List<? extends OuroTextElement> $this$flatMap$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            OuroTextElement node = (OuroTextElement) element$iv$iv;
            Iterable $this$flatMap$iv2 = $this$flatMap$iv;
            if (StringsKt.contains$default(node.getMeta(), '\n', false, 2, (Object) null)) {
                listOf = OuroTextUtilsKt.toOuroTextWithHardBreaks(node.getMeta(), node.getMarks());
            } else {
                listOf = CollectionsKt.listOf(node);
            }
            Iterable list$iv$iv = listOf;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv2;
        }
        final List textList = (List) destination$iv$iv;
        NodeStorage oldStorage = state.getStorage();
        NodeStorage newStorage = OuroNodeStorageUtilsKt.mutate(oldStorage, range, displayLengthTransform, new Function2() { // from class: kntr.common.ouro.core.reducer.OuroEditActionReducerKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj, Object obj2) {
                Unit insertTextNodes$lambda$1;
                insertTextNodes$lambda$1 = OuroEditActionReducerKt.insertTextNodes$lambda$1(OuroTextRange.this, textList, (NodeStorageBuilder) obj, (OuroSelection) obj2);
                return insertTextNodes$lambda$1;
            }
        });
        List $this$fold$iv = textList;
        int accumulator$iv = 0;
        for (Object element$iv : $this$fold$iv) {
            OuroTextElement textNode = (OuroTextElement) element$iv;
            int acc = accumulator$iv;
            accumulator$iv = acc + ((Number) displayLengthTransform.invoke(newStorage, textNode)).intValue();
        }
        int len = accumulator$iv;
        OuroTextRange finalRange = new OuroTextRange(range.getStart() + len);
        OuroSelection constrainedSel = OuroNodeStorageUtilsKt.constrainSelection$default(OuroSelectionKt.getSelection(newStorage, finalRange, displayLengthTransform), newStorage.getAllSelectables(), false, 4, null);
        OuroTextRange constrainedRange = OuroTextRangeKt.getTextRange(newStorage, constrainedSel, displayLengthTransform);
        return OuroState.copy$default(state, newStorage, constrainedRange, null, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertTextNodes$lambda$1(OuroTextRange $range, List $textList, NodeStorageBuilder $this$mutate, OuroSelection selection) {
        OuroNode.Selectable selectable;
        OuroNode.Selectable selectable2;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (!$range.getCollapsed()) {
            replaceSelectedElementsWithTexts($this$mutate, selection, $textList);
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$getNextSelectableOrNull$iv = $this$mutate;
        OuroPoint point$iv = selection.getStart();
        int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
        if (nextIndex$iv < $this$getNextSelectableOrNull$iv.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull($this$getNextSelectableOrNull$iv.getAllSelectables(), nextIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            selectable = (OuroNode.Selectable) orNull;
        } else {
            selectable = null;
        }
        OuroNode.Selectable afterElement = selectable;
        if (afterElement != null && insertTextsBeforeElement($this$mutate, afterElement, $textList)) {
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$getPreviousSelectableOrNull$iv = $this$mutate;
        int prevIndex$iv = selection.getStart().getIndex() - 1;
        if (prevIndex$iv >= 0) {
            Object orNull2 = CollectionsKt.getOrNull($this$getPreviousSelectableOrNull$iv.getAllSelectables(), prevIndex$iv);
            if (!(orNull2 instanceof OuroNode.Selectable)) {
                orNull2 = null;
            }
            selectable2 = (OuroNode.Selectable) orNull2;
        } else {
            selectable2 = null;
        }
        OuroNode.Selectable beforeElement = selectable2;
        if (beforeElement != null && insertTextsAfterElement($this$mutate, beforeElement, $textList)) {
            return Unit.INSTANCE;
        }
        NodeStorageBuilder $this$insertTextNodes_u24lambda_u241_u240 = new NodeStorageBuilder(new OuroText(null, 1, null), null, null, 6, null);
        $this$insertTextNodes_u24lambda_u241_u240.addChildren($this$insertTextNodes_u24lambda_u241_u240.getRoot(), $textList);
        insertParagraphAfterElement($this$mutate, beforeElement, $this$insertTextNodes_u24lambda_u241_u240);
        return Unit.INSTANCE;
    }
}