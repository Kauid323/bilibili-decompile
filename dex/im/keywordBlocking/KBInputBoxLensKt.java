package im.keywordBlocking;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.keywordBlocking.KBInputBox;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBInputBoxLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b¨\u0006\u001c"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/keywordBlocking/KBInputBox;", "Lim/keywordBlocking/KBInputBox$Companion;", "getLens$annotations", "(Lim/keywordBlocking/KBInputBox$Companion;)V", "getLens", "(Lim/keywordBlocking/KBInputBox$Companion;)Lcom/bilibili/blens/BSimpleLens;", "text", "", "getText$annotations", "getText", "charLimit", "", "getCharLimit$annotations", "getCharLimit", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "textNullable$annotations", "textNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "charLimitNullable$annotations", "charLimitNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "keyword-blocking_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KBInputBoxLensKt {
    public static /* synthetic */ void charLimitNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCharLimit$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCharLimit$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCharLimit$annotations(KBInputBox.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(KBInputBox.Companion companion) {
    }

    public static /* synthetic */ void getText$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getText$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getText$annotations(KBInputBox.Companion companion) {
    }

    public static /* synthetic */ void textNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<KBInputBox, KBInputBox> getLens(KBInputBox.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBInputBox, KBInputBox>() { // from class: im.keywordBlocking.KBInputBoxLensKt$special$$inlined$invoke$1
            public KBInputBox get(KBInputBox kBInputBox) {
                KBInputBox it = kBInputBox;
                return it;
            }

            public KBInputBox set(KBInputBox kBInputBox, KBInputBox kBInputBox2) {
                KBInputBox it = kBInputBox2;
                return it;
            }

            public KBInputBox modify(KBInputBox kBInputBox, Function1<? super KBInputBox, ? extends KBInputBox> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                KBInputBox it = kBInputBox;
                return (KBInputBox) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<KBInputBox, String> getText(KBInputBox.Companion $this$text) {
        Intrinsics.checkNotNullParameter($this$text, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBInputBox, String>() { // from class: im.keywordBlocking.KBInputBoxLensKt$special$$inlined$invoke$2
            public String get(KBInputBox kBInputBox) {
                KBInputBox it = kBInputBox;
                return it.getText();
            }

            public KBInputBox set(KBInputBox kBInputBox, String str) {
                String text = str;
                KBInputBox it = kBInputBox;
                return KBInputBox.copy$default(it, text, 0, 2, null);
            }

            public KBInputBox modify(KBInputBox kBInputBox, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                KBInputBox it = kBInputBox;
                String text = (String) function1.invoke(it.getText());
                KBInputBox it2 = kBInputBox;
                return KBInputBox.copy$default(it2, text, 0, 2, null);
            }
        };
    }

    public static final BSimpleLens<KBInputBox, Integer> getCharLimit(KBInputBox.Companion $this$charLimit) {
        Intrinsics.checkNotNullParameter($this$charLimit, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<KBInputBox, Integer>() { // from class: im.keywordBlocking.KBInputBoxLensKt$special$$inlined$invoke$3
            public Integer get(KBInputBox kBInputBox) {
                KBInputBox it = kBInputBox;
                return Integer.valueOf(it.getCharLimit());
            }

            public KBInputBox set(KBInputBox kBInputBox, Integer num) {
                int charLimit = num.intValue();
                KBInputBox it = kBInputBox;
                return KBInputBox.copy$default(it, null, charLimit, 1, null);
            }

            public KBInputBox modify(KBInputBox kBInputBox, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                KBInputBox it = kBInputBox;
                int charLimit = ((Number) function1.invoke(Integer.valueOf(it.getCharLimit()))).intValue();
                KBInputBox it2 = kBInputBox;
                return KBInputBox.copy$default(it2, null, charLimit, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getText(BSimpleLens<T, KBInputBox> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getText(KBInputBox.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getCharLimit(BSimpleLens<T, KBInputBox> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCharLimit(KBInputBox.Companion));
    }

    public static final <T> BNullableLens<T, String> textNullable(BSimpleLens<T, KBInputBox> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getText(KBInputBox.Companion));
    }

    public static final <T> BNullableLens<T, Integer> charLimitNullable(BSimpleLens<T, KBInputBox> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCharLimit(KBInputBox.Companion));
    }

    public static final <T> BNullableLens<T, String> getText(BNullableLens<T, KBInputBox> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getText(KBInputBox.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getCharLimit(BNullableLens<T, KBInputBox> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCharLimit(KBInputBox.Companion));
    }
}