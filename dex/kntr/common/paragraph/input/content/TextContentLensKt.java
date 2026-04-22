package kntr.common.paragraph.input.content;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.content.TextContent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextContentLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\",\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016\"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\t0\u0017\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001a\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\r0\u0017\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001a\"D\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0016\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\t0\u0017\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001f\u001a\u0004\b\u000b\u0010 \"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\r0\u0017\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001f\u001a\u0004\b\u000f\u0010 \"B\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u001f\u001a\u0004\b\u0012\u0010!¨\u0006\""}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/paragraph/input/content/TextContent;", "Lkntr/common/paragraph/input/content/TextContent$Companion;", "getLens$annotations", "(Lkntr/common/paragraph/input/content/TextContent$Companion;)V", "getLens", "(Lkntr/common/paragraph/input/content/TextContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "content", "", "getContent$annotations", "getContent", "selection", "Lkntr/common/paragraph/input/content/TextRange;", "getSelection$annotations", "getSelection", "composition", "getComposition$annotations", "getComposition", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "contentNullable$annotations", "contentNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "selectionNullable$annotations", "selectionNullable", "compositionNullable$annotations", "compositionNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TextContentLensKt {
    public static /* synthetic */ void compositionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getComposition$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getComposition$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getComposition$annotations(TextContent.Companion companion) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(TextContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(TextContent.Companion companion) {
    }

    public static /* synthetic */ void getSelection$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSelection$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSelection$annotations(TextContent.Companion companion) {
    }

    public static /* synthetic */ void selectionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<TextContent, TextContent> getLens(TextContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextContent, TextContent>() { // from class: kntr.common.paragraph.input.content.TextContentLensKt$special$$inlined$invoke$1
            public TextContent get(TextContent textContent) {
                TextContent it = textContent;
                return it;
            }

            public TextContent set(TextContent textContent, TextContent textContent2) {
                TextContent it = textContent2;
                return it;
            }

            public TextContent modify(TextContent textContent, Function1<? super TextContent, ? extends TextContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TextContent it = textContent;
                return (TextContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TextContent, String> getContent(TextContent.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextContent, String>() { // from class: kntr.common.paragraph.input.content.TextContentLensKt$special$$inlined$invoke$2
            public String get(TextContent textContent) {
                TextContent it = textContent;
                return it.getContent();
            }

            public TextContent set(TextContent textContent, String str) {
                String content = str;
                TextContent it = textContent;
                return TextContent.copy$default(it, content, null, null, 6, null);
            }

            public TextContent modify(TextContent textContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TextContent it = textContent;
                String content = (String) function1.invoke(it.getContent());
                TextContent it2 = textContent;
                return TextContent.copy$default(it2, content, null, null, 6, null);
            }
        };
    }

    public static final BSimpleLens<TextContent, TextRange> getSelection(TextContent.Companion $this$selection) {
        Intrinsics.checkNotNullParameter($this$selection, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextContent, TextRange>() { // from class: kntr.common.paragraph.input.content.TextContentLensKt$special$$inlined$invoke$3
            public TextRange get(TextContent textContent) {
                TextContent it = textContent;
                return it.getSelection();
            }

            public TextContent set(TextContent textContent, TextRange textRange) {
                TextRange selection = textRange;
                TextContent it = textContent;
                return TextContent.copy$default(it, null, selection, null, 5, null);
            }

            public TextContent modify(TextContent textContent, Function1<? super TextRange, ? extends TextRange> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TextContent it = textContent;
                TextRange selection = (TextRange) function1.invoke(it.getSelection());
                TextContent it2 = textContent;
                return TextContent.copy$default(it2, null, selection, null, 5, null);
            }
        };
    }

    public static final BSimpleLens<TextContent, TextRange> getComposition(TextContent.Companion $this$composition) {
        Intrinsics.checkNotNullParameter($this$composition, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TextContent, TextRange>() { // from class: kntr.common.paragraph.input.content.TextContentLensKt$special$$inlined$invoke$4
            public TextRange get(TextContent textContent) {
                TextContent it = textContent;
                return it.getComposition();
            }

            public TextContent set(TextContent textContent, TextRange textRange) {
                TextRange composition = textRange;
                TextContent it = textContent;
                return TextContent.copy$default(it, null, null, composition, 3, null);
            }

            public TextContent modify(TextContent textContent, Function1<? super TextRange, ? extends TextRange> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TextContent it = textContent;
                TextRange composition = (TextRange) function1.invoke(it.getComposition());
                TextContent it2 = textContent;
                return TextContent.copy$default(it2, null, null, composition, 3, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getContent(BSimpleLens<T, TextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(TextContent.Companion));
    }

    public static final <T> BSimpleLens<T, TextRange> getSelection(BSimpleLens<T, TextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSelection(TextContent.Companion));
    }

    public static final <T> BSimpleLens<T, TextRange> getComposition(BSimpleLens<T, TextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getComposition(TextContent.Companion));
    }

    public static final <T> BNullableLens<T, String> contentNullable(BSimpleLens<T, TextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(TextContent.Companion));
    }

    public static final <T> BNullableLens<T, TextRange> selectionNullable(BSimpleLens<T, TextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSelection(TextContent.Companion));
    }

    public static final <T> BSimpleLens<T, TextRange> compositionNullable(BSimpleLens<T, TextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getComposition(TextContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getContent(BNullableLens<T, TextContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(TextContent.Companion));
    }

    public static final <T> BNullableLens<T, TextRange> getSelection(BNullableLens<T, TextContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSelection(TextContent.Companion));
    }

    public static final <T> BSimpleLens<T, TextRange> getComposition(BNullableLens<T, TextContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getComposition(TextContent.Companion));
    }
}