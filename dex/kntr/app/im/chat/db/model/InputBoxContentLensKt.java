package kntr.app.im.chat.db.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.im.chat.db.model.InputBoxContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputBoxContentLens.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"0\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u0012\u0010\u001b\"F\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0017\u0010\u001b\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001f\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001f\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001f\"H\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001f\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010&\u001a\u0004\b\u000b\u0010'\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010&\u001a\u0004\b\u000f\u0010'\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010&\u001a\u0004\b\u0012\u0010'\"F\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010&\u001a\u0004\b\u0017\u0010'¨\u0006("}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/im/chat/db/model/InputBoxContent;", "Lkntr/app/im/chat/db/model/InputBoxContent$Companion;", "getLens$annotations", "(Lkntr/app/im/chat/db/model/InputBoxContent$Companion;)V", "getLens", "(Lkntr/app/im/chat/db/model/InputBoxContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "text", RoomRecommendViewModel.EMPTY_CURSOR, "getText$annotations", "getText", "cursorStart", RoomRecommendViewModel.EMPTY_CURSOR, "getCursorStart$annotations", "getCursorStart", "cursorEnd", "getCursorEnd$annotations", "getCursorEnd", "inlineContents", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/model/InlineContent;", "getInlineContents$annotations", "getInlineContents", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "textNullable$annotations", "textNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "cursorStartNullable$annotations", "cursorStartNullable", "cursorEndNullable$annotations", "cursorEndNullable", "inlineContentsNullable$annotations", "inlineContentsNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputBoxContentLensKt {
    public static /* synthetic */ void cursorEndNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void cursorStartNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCursorEnd$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCursorEnd$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCursorEnd$annotations(InputBoxContent.Companion companion) {
    }

    public static /* synthetic */ void getCursorStart$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCursorStart$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCursorStart$annotations(InputBoxContent.Companion companion) {
    }

    public static /* synthetic */ void getInlineContents$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInlineContents$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInlineContents$annotations(InputBoxContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(InputBoxContent.Companion companion) {
    }

    public static /* synthetic */ void getText$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getText$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getText$annotations(InputBoxContent.Companion companion) {
    }

    public static /* synthetic */ void inlineContentsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void textNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<InputBoxContent, InputBoxContent> getLens(InputBoxContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxContent, InputBoxContent>() { // from class: kntr.app.im.chat.db.model.InputBoxContentLensKt$special$$inlined$invoke$1
            public InputBoxContent get(InputBoxContent inputBoxContent) {
                InputBoxContent it = inputBoxContent;
                return it;
            }

            public InputBoxContent set(InputBoxContent inputBoxContent, InputBoxContent inputBoxContent2) {
                InputBoxContent it = inputBoxContent2;
                return it;
            }

            public InputBoxContent modify(InputBoxContent inputBoxContent, Function1<? super InputBoxContent, ? extends InputBoxContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxContent it = inputBoxContent;
                return (InputBoxContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<InputBoxContent, String> getText(InputBoxContent.Companion $this$text) {
        Intrinsics.checkNotNullParameter($this$text, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxContent, String>() { // from class: kntr.app.im.chat.db.model.InputBoxContentLensKt$special$$inlined$invoke$2
            public String get(InputBoxContent inputBoxContent) {
                InputBoxContent it = inputBoxContent;
                return it.getText();
            }

            public InputBoxContent set(InputBoxContent inputBoxContent, String str) {
                String text = str;
                InputBoxContent it = inputBoxContent;
                return InputBoxContent.copy$default(it, text, 0, 0, null, 14, null);
            }

            public InputBoxContent modify(InputBoxContent inputBoxContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxContent it = inputBoxContent;
                String text = (String) function1.invoke(it.getText());
                InputBoxContent it2 = inputBoxContent;
                return InputBoxContent.copy$default(it2, text, 0, 0, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<InputBoxContent, Integer> getCursorStart(InputBoxContent.Companion $this$cursorStart) {
        Intrinsics.checkNotNullParameter($this$cursorStart, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxContent, Integer>() { // from class: kntr.app.im.chat.db.model.InputBoxContentLensKt$special$$inlined$invoke$3
            public Integer get(InputBoxContent inputBoxContent) {
                InputBoxContent it = inputBoxContent;
                return Integer.valueOf(it.getCursorStart());
            }

            public InputBoxContent set(InputBoxContent inputBoxContent, Integer num) {
                int cursorStart = num.intValue();
                InputBoxContent it = inputBoxContent;
                return InputBoxContent.copy$default(it, null, cursorStart, 0, null, 13, null);
            }

            public InputBoxContent modify(InputBoxContent inputBoxContent, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxContent it = inputBoxContent;
                int cursorStart = ((Number) function1.invoke(Integer.valueOf(it.getCursorStart()))).intValue();
                InputBoxContent it2 = inputBoxContent;
                return InputBoxContent.copy$default(it2, null, cursorStart, 0, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<InputBoxContent, Integer> getCursorEnd(InputBoxContent.Companion $this$cursorEnd) {
        Intrinsics.checkNotNullParameter($this$cursorEnd, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxContent, Integer>() { // from class: kntr.app.im.chat.db.model.InputBoxContentLensKt$special$$inlined$invoke$4
            public Integer get(InputBoxContent inputBoxContent) {
                InputBoxContent it = inputBoxContent;
                return Integer.valueOf(it.getCursorEnd());
            }

            public InputBoxContent set(InputBoxContent inputBoxContent, Integer num) {
                int cursorEnd = num.intValue();
                InputBoxContent it = inputBoxContent;
                return InputBoxContent.copy$default(it, null, 0, cursorEnd, null, 11, null);
            }

            public InputBoxContent modify(InputBoxContent inputBoxContent, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxContent it = inputBoxContent;
                int cursorEnd = ((Number) function1.invoke(Integer.valueOf(it.getCursorEnd()))).intValue();
                InputBoxContent it2 = inputBoxContent;
                return InputBoxContent.copy$default(it2, null, 0, cursorEnd, null, 11, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<InputBoxContent, List<InlineContent>> getInlineContents(InputBoxContent.Companion $this$inlineContents) {
        Intrinsics.checkNotNullParameter($this$inlineContents, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<InputBoxContent, List<? extends InlineContent>>() { // from class: kntr.app.im.chat.db.model.InputBoxContentLensKt$special$$inlined$invoke$5
            public List<? extends InlineContent> get(InputBoxContent inputBoxContent) {
                InputBoxContent it = inputBoxContent;
                return it.getInlineContents();
            }

            public InputBoxContent set(InputBoxContent inputBoxContent, List<? extends InlineContent> list) {
                List<? extends InlineContent> inlineContents = list;
                InputBoxContent it = inputBoxContent;
                return InputBoxContent.copy$default(it, null, 0, 0, inlineContents, 7, null);
            }

            public InputBoxContent modify(InputBoxContent inputBoxContent, Function1<? super List<? extends InlineContent>, ? extends List<? extends InlineContent>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                InputBoxContent it = inputBoxContent;
                List inlineContents = (List) function1.invoke(it.getInlineContents());
                InputBoxContent it2 = inputBoxContent;
                return InputBoxContent.copy$default(it2, null, 0, 0, inlineContents, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getText(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getText(InputBoxContent.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getCursorStart(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCursorStart(InputBoxContent.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getCursorEnd(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCursorEnd(InputBoxContent.Companion));
    }

    public static final <T> BSimpleLens<T, List<InlineContent>> getInlineContents(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getInlineContents(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, String> textNullable(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getText(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> cursorStartNullable(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCursorStart(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> cursorEndNullable(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCursorEnd(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, List<InlineContent>> inlineContentsNullable(BSimpleLens<T, InputBoxContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getInlineContents(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getText(BNullableLens<T, InputBoxContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getText(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getCursorStart(BNullableLens<T, InputBoxContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCursorStart(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getCursorEnd(BNullableLens<T, InputBoxContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCursorEnd(InputBoxContent.Companion));
    }

    public static final <T> BNullableLens<T, List<InlineContent>> getInlineContents(BNullableLens<T, InputBoxContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getInlineContents(InputBoxContent.Companion));
    }
}