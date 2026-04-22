package kntr.common.paragraph.input.content;

import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: TextContent.kt */
@Lens
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u000fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lkntr/common/paragraph/input/content/TextContent;", "Lkntr/common/paragraph/input/content/ParagraphContent;", "content", "", "selection", "Lkntr/common/paragraph/input/content/TextRange;", "composition", "<init>", "(Ljava/lang/String;Lkntr/common/paragraph/input/content/TextRange;Lkntr/common/paragraph/input/content/TextRange;)V", "getContent", "()Ljava/lang/String;", "getSelection", "()Lkntr/common/paragraph/input/content/TextRange;", "getComposition", "textCount", "", "getTextCount", "()I", "splitForInsertingAsset", "Lkotlin/Pair;", "splitByParagraph", "", "merge", "other", "component1", "component2", "component3", "copy", "equals", "", "", "hashCode", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TextContent implements ParagraphContent {
    private final TextRange composition;
    private final String content;
    private final TextRange selection;
    private final int textCount;
    public static final Companion Companion = new Companion(null);
    private static final Regex zeroWidthReg = new Regex("\\x{200b}+");
    private static final Regex nonBreakingReg = new Regex("\\x{00a0}+");

    public static /* synthetic */ TextContent copy$default(TextContent textContent, String str, TextRange textRange, TextRange textRange2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textContent.content;
        }
        if ((i & 2) != 0) {
            textRange = textContent.selection;
        }
        if ((i & 4) != 0) {
            textRange2 = textContent.composition;
        }
        return textContent.copy(str, textRange, textRange2);
    }

    public final String component1() {
        return this.content;
    }

    public final TextRange component2() {
        return this.selection;
    }

    public final TextRange component3() {
        return this.composition;
    }

    public final TextContent copy(String str, TextRange textRange, TextRange textRange2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(textRange, "selection");
        return new TextContent(str, textRange, textRange2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextContent) {
            TextContent textContent = (TextContent) obj;
            return Intrinsics.areEqual(this.content, textContent.content) && Intrinsics.areEqual(this.selection, textContent.selection) && Intrinsics.areEqual(this.composition, textContent.composition);
        }
        return false;
    }

    public int hashCode() {
        return (((this.content.hashCode() * 31) + this.selection.hashCode()) * 31) + (this.composition == null ? 0 : this.composition.hashCode());
    }

    public String toString() {
        String str = this.content;
        TextRange textRange = this.selection;
        return "TextContent(content=" + str + ", selection=" + textRange + ", composition=" + this.composition + ")";
    }

    public TextContent(String content, TextRange selection, TextRange composition) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(selection, "selection");
        this.content = content;
        this.selection = selection;
        this.composition = composition;
        Regex regex = zeroWidthReg;
        this.textCount = nonBreakingReg.replace(regex.replace(StringsKt.trim(this.content).toString(), ""), "").length();
    }

    public /* synthetic */ TextContent(String str, TextRange textRange, TextRange textRange2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new TextRange(str.length(), str.length()) : textRange, (i & 4) != 0 ? null : textRange2);
    }

    public final String getContent() {
        return this.content;
    }

    public final TextRange getSelection() {
        return this.selection;
    }

    public final TextRange getComposition() {
        return this.composition;
    }

    /* compiled from: TextContent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkntr/common/paragraph/input/content/TextContent$Companion;", "", "<init>", "()V", "zeroWidthReg", "Lkotlin/text/Regex;", "nonBreakingReg", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.common.paragraph.input.content.ParagraphContent
    public int getTextCount() {
        return this.textCount;
    }

    public final Pair<TextContent, TextContent> splitForInsertingAsset() {
        String removePrefix;
        String start = this.content.substring(0, this.selection.getStart());
        Intrinsics.checkNotNullExpressionValue(start, "substring(...)");
        boolean startEndWithNewLine = StringsKt.endsWith$default(start, "\n", false, 2, (Object) null);
        String it = this.content.substring(this.selection.getEnd());
        Intrinsics.checkNotNullExpressionValue(it, "substring(...)");
        if (startEndWithNewLine) {
            removePrefix = it;
        } else {
            removePrefix = StringsKt.removePrefix(it, "\n");
        }
        String end = removePrefix;
        String it2 = StringsKt.removeSuffix(start, "\n");
        String it3 = it2.length() > 0 ? it2 : null;
        TextContent textContent = it3 != null ? new TextContent(it3, new TextRange(it3.length(), it3.length()), null, 4, null) : null;
        String it4 = end.length() > 0 ? end : null;
        return TuplesKt.to(textContent, it4 != null ? new TextContent(it4, new TextRange(0, 0), null, 4, null) : null);
    }

    public final List<TextContent> splitByParagraph() {
        boolean z = false;
        Iterable $this$map$iv = new Regex("\n").split(this.content, 0);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(new TextContent(it.length() == 0 ? true : z ? "\n" : it, new TextRange(it.length(), it.length()), null));
            z = false;
        }
        return (List) destination$iv$iv;
    }

    public final TextContent merge(TextContent other) {
        Intrinsics.checkNotNullParameter(other, "other");
        StringBuilder $this$merge_u24lambda_u240 = new StringBuilder();
        $this$merge_u24lambda_u240.append(this.content).append('\n');
        $this$merge_u24lambda_u240.append(StringsKt.removePrefix(other.content, "\n"));
        return new TextContent($this$merge_u24lambda_u240.toString(), this.selection, this.composition);
    }
}