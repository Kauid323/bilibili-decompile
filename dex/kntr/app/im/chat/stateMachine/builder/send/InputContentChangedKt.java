package kntr.app.im.chat.stateMachine.builder.send;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.db.model.InlineContent;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.im.chat.utils.SizeTransformerKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputContentChanged.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0011"}, d2 = {"insertInlineContentAtCursor", "Lkntr/app/im/chat/db/model/InputBoxContent;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "size", "Landroidx/compose/ui/geometry/Size;", "url", "rawText", "isGif", RoomRecommendViewModel.EMPTY_CURSOR, "replaceChar", RoomRecommendViewModel.EMPTY_CURSOR, "insertInlineContentAtCursor-YelfcfQ", "(Lkntr/app/im/chat/db/model/InputBoxContent;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZC)Lkntr/app/im/chat/db/model/InputBoxContent;", "insertTextAtCursor", "insertText", "backSpaceAtCursor", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputContentChangedKt {
    /* renamed from: insertInlineContentAtCursor-YelfcfQ$default  reason: not valid java name */
    public static /* synthetic */ InputBoxContent m1631insertInlineContentAtCursorYelfcfQ$default(InputBoxContent inputBoxContent, String str, long j2, String str2, String str3, boolean z, char c, int i, Object obj) {
        String str4;
        boolean z2;
        if ((i & 8) == 0) {
            str4 = str3;
        } else {
            str4 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        if ((i & 16) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return m1630insertInlineContentAtCursorYelfcfQ(inputBoxContent, str, j2, str2, str4, z2, c);
    }

    /* renamed from: insertInlineContentAtCursor-YelfcfQ  reason: not valid java name */
    public static final InputBoxContent m1630insertInlineContentAtCursorYelfcfQ(InputBoxContent $this$insertInlineContentAtCursor_u2dYelfcfQ, String id, long j2, String url, String rawText, boolean isGif, char replaceChar) {
        String newText;
        boolean isHasDelete;
        int inlineContentOffset;
        long newTextRange;
        InlineContent inlineContent;
        Iterable $this$filterNot$iv;
        boolean z;
        Intrinsics.checkNotNullParameter($this$insertInlineContentAtCursor_u2dYelfcfQ, "$this$insertInlineContentAtCursor");
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(rawText, "rawText");
        long selection = TextRangeKt.TextRange($this$insertInlineContentAtCursor_u2dYelfcfQ.getCursorStart(), $this$insertInlineContentAtCursor_u2dYelfcfQ.getCursorEnd());
        if (TextRange.getCollapsed-impl(selection)) {
            int inlineContentOffset2 = TextRange.getStart-impl(selection);
            String substring = $this$insertInlineContentAtCursor_u2dYelfcfQ.getText().substring(0, TextRange.getStart-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = $this$insertInlineContentAtCursor_u2dYelfcfQ.getText().substring(TextRange.getStart-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            newText = substring + replaceChar + substring2;
            isHasDelete = false;
            inlineContentOffset = inlineContentOffset2;
        } else {
            int inlineContentOffset3 = TextRange.getMin-impl(selection);
            String substring3 = $this$insertInlineContentAtCursor_u2dYelfcfQ.getText().substring(0, TextRange.getMin-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            String substring4 = $this$insertInlineContentAtCursor_u2dYelfcfQ.getText().substring(TextRange.getMax-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            newText = substring3 + replaceChar + substring4;
            isHasDelete = true;
            inlineContentOffset = inlineContentOffset3;
        }
        InlineContent inlineContent2 = new InlineContent(id, SizeTransformerKt.m1996toBSizeuvyYCjk(j2), url, inlineContentOffset, isGif, rawText);
        Iterable $this$filterNot$iv2 = $this$insertInlineContentAtCursor_u2dYelfcfQ.getInlineContents();
        boolean z2 = false;
        Collection destination$iv$iv = new ArrayList();
        Iterator<T> it = $this$filterNot$iv2.iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            InlineContent it2 = (InlineContent) element$iv$iv;
            if (isHasDelete) {
                int i = TextRange.getMin-impl(selection);
                $this$filterNot$iv = $this$filterNot$iv2;
                int i2 = TextRange.getMax-impl(selection);
                z = z2;
                int $i$f$filterNot = it2.getOffset();
                if (i > $i$f$filterNot || $i$f$filterNot >= i2) {
                    z3 = false;
                }
            } else {
                $this$filterNot$iv = $this$filterNot$iv2;
                z = z2;
                z3 = false;
            }
            if (!z3) {
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filterNot$iv2 = $this$filterNot$iv;
            z2 = z;
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        boolean z4 = false;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            InlineContent it3 = (InlineContent) item$iv$iv;
            Iterable $this$map$iv2 = $this$map$iv;
            int offset = it3.getOffset();
            boolean z5 = z4;
            int $i$f$map = inlineContent2.getOffset();
            if (offset >= $i$f$map) {
                inlineContent = InlineContent.copy$default(it3, null, null, null, it3.getOffset() + (newText.length() - $this$insertInlineContentAtCursor_u2dYelfcfQ.getText().length()), false, null, 55, null);
            } else {
                inlineContent = it3;
            }
            destination$iv$iv2.add(inlineContent);
            $this$map$iv = $this$map$iv2;
            z4 = z5;
        }
        List newInlineContents = CollectionsKt.toMutableList((List) destination$iv$iv2);
        newInlineContents.add(inlineContent2);
        if (isHasDelete) {
            newTextRange = TextRangeKt.TextRange(TextRange.getMin-impl(selection) + 1, TextRange.getMin-impl(selection) + 1);
        } else {
            newTextRange = TextRangeKt.TextRange(TextRange.getStart-impl(selection) + 1, TextRange.getStart-impl(selection) + 1);
        }
        return $this$insertInlineContentAtCursor_u2dYelfcfQ.copy(newText, TextRange.getStart-impl(newTextRange), TextRange.getEnd-impl(newTextRange), newInlineContents);
    }

    public static final InputBoxContent insertTextAtCursor(InputBoxContent $this$insertTextAtCursor, String insertText) {
        boolean isHasDelete;
        String newText;
        long TextRange;
        Intrinsics.checkNotNullParameter($this$insertTextAtCursor, "<this>");
        Intrinsics.checkNotNullParameter(insertText, "insertText");
        String oldText = $this$insertTextAtCursor.getText();
        long selection = TextRangeKt.TextRange($this$insertTextAtCursor.getCursorStart(), $this$insertTextAtCursor.getCursorEnd());
        if (TextRange.getCollapsed-impl(selection)) {
            isHasDelete = false;
            String substring = oldText.substring(0, TextRange.getStart-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = oldText.substring(TextRange.getStart-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            newText = substring + insertText + substring2;
        } else {
            isHasDelete = true;
            String substring3 = oldText.substring(0, TextRange.getMin-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            String substring4 = oldText.substring(TextRange.getMax-impl(selection));
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            newText = substring3 + insertText + substring4;
        }
        if (isHasDelete) {
            TextRange = TextRangeKt.TextRange(TextRange.getMin-impl(selection) + insertText.length(), TextRange.getMin-impl(selection) + insertText.length());
        } else {
            TextRange = TextRangeKt.TextRange(TextRange.getStart-impl(selection) + insertText.length(), TextRange.getStart-impl(selection) + insertText.length());
        }
        long newTextRange = TextRange;
        IMLog.Companion.d("InputBoxContent", "insertTextAtCursor: oldText=" + oldText + ", newText=" + newText + ", selection=" + TextRange.toString-impl(selection) + ", newTextRange=" + TextRange.toString-impl(newTextRange));
        return InputBoxContent.copy$default($this$insertTextAtCursor, newText, TextRange.getStart-impl(newTextRange), TextRange.getEnd-impl(newTextRange), null, 8, null);
    }

    public static final InputBoxContent backSpaceAtCursor(InputBoxContent $this$backSpaceAtCursor) {
        int deleteStart;
        int deleteStart2;
        InlineContent inlineContent;
        Intrinsics.checkNotNullParameter($this$backSpaceAtCursor, "<this>");
        long selection = TextRangeKt.TextRange($this$backSpaceAtCursor.getCursorStart(), $this$backSpaceAtCursor.getCursorEnd());
        if (TextRange.getCollapsed-impl(selection)) {
            deleteStart = TextRange.getStart-impl(selection) - 1;
            deleteStart2 = TextRange.getStart-impl(selection);
        } else {
            deleteStart = TextRange.getMin-impl(selection);
            deleteStart2 = TextRange.getMax-impl(selection);
        }
        if (deleteStart < 0) {
            return new InputBoxContent(null, 0, 0, null, 15, null);
        }
        Iterable $this$filterNot$iv = $this$backSpaceAtCursor.getInlineContents();
        Collection destination$iv$iv = new ArrayList();
        Iterator<T> it = $this$filterNot$iv.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            int offset = ((InlineContent) element$iv$iv).getOffset();
            if (deleteStart <= offset && offset < deleteStart2) {
                z = true;
            }
            if (!z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            InlineContent it2 = (InlineContent) item$iv$iv;
            if (it2.getOffset() >= deleteStart) {
                inlineContent = InlineContent.copy$default(it2, null, null, null, it2.getOffset() - (deleteStart2 - deleteStart), false, null, 55, null);
            } else {
                inlineContent = it2;
            }
            destination$iv$iv2.add(inlineContent);
        }
        List newInlineContents = (List) destination$iv$iv2;
        String substring = $this$backSpaceAtCursor.getText().substring(0, deleteStart);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String substring2 = $this$backSpaceAtCursor.getText().substring(deleteStart2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        String newText = substring + substring2;
        long newSelection = TextRangeKt.TextRange(deleteStart, deleteStart);
        return new InputBoxContent(newText, TextRange.getStart-impl(newSelection), TextRange.getEnd-impl(newSelection), newInlineContents);
    }
}