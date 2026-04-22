package kntr.common.paragraph.input;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextContent;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RichTextContentLens.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"0\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"*\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"6\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"F\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u001d\u001a\u0004\b\f\u0010\u001e\"@\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u000e0\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u0010\u0010\u001e\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00120\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u0014\u0010\u001e\"L\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u0002H\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0001\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u001a\u0010\u001e\"H\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u0010\u0012\u0004\u0012\u0002H\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"\"B\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u000e0\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u0010\u0012\u0004\u0012\u0002H\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\"\"B\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00120\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u0010\u0012\u0004\u0012\u0002H\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\"\"N\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u0002H\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u0010\u0012\u0004\u0012\u0002H\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\"\"F\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010)\u001a\u0004\b\f\u0010*\"@\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u000e0\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010)\u001a\u0004\b\u0010\u0010*\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00120\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010)\u001a\u0004\b\u0014\u0010*\"L\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u0002H\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u001f\"\b\b\u0000\u0010\u001b*\u00020\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00020\u001f8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010)\u001a\u0004\b\u001a\u0010*¨\u0006+"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/paragraph/input/RichTextContent;", "Lkntr/common/paragraph/input/RichTextContent$Companion;", "getLens$annotations", "(Lkntr/common/paragraph/input/RichTextContent$Companion;)V", "getLens", "(Lkntr/common/paragraph/input/RichTextContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "contentList", "", "Lkntr/common/paragraph/input/content/ParagraphContent;", "getContentList$annotations", "getContentList", "currentFocus", "", "getCurrentFocus$annotations", "getCurrentFocus", "focusConsumed", "", "getFocusConsumed$annotations", "getFocusConsumed", "assetMap", "", "Lkntr/common/photonic/Asset;", "Lkntr/common/paragraph/input/content/AssetContent;", "getAssetMap$annotations", "getAssetMap", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "contentListNullable$annotations", "contentListNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "currentFocusNullable$annotations", "currentFocusNullable", "focusConsumedNullable$annotations", "focusConsumedNullable", "assetMapNullable$annotations", "assetMapNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RichTextContentLensKt {
    public static /* synthetic */ void assetMapNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void contentListNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void currentFocusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void focusConsumedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAssetMap$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAssetMap$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAssetMap$annotations(RichTextContent.Companion companion) {
    }

    public static /* synthetic */ void getContentList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContentList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContentList$annotations(RichTextContent.Companion companion) {
    }

    public static /* synthetic */ void getCurrentFocus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCurrentFocus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCurrentFocus$annotations(RichTextContent.Companion companion) {
    }

    public static /* synthetic */ void getFocusConsumed$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFocusConsumed$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFocusConsumed$annotations(RichTextContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(RichTextContent.Companion companion) {
    }

    public static final BSimpleLens<RichTextContent, RichTextContent> getLens(RichTextContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RichTextContent, RichTextContent>() { // from class: kntr.common.paragraph.input.RichTextContentLensKt$special$$inlined$invoke$1
            public RichTextContent get(RichTextContent richTextContent) {
                RichTextContent it = richTextContent;
                return it;
            }

            public RichTextContent set(RichTextContent richTextContent, RichTextContent richTextContent2) {
                RichTextContent it = richTextContent2;
                return it;
            }

            public RichTextContent modify(RichTextContent richTextContent, Function1<? super RichTextContent, ? extends RichTextContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RichTextContent it = richTextContent;
                return (RichTextContent) function1.invoke(it);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<RichTextContent, List<ParagraphContent>> getContentList(RichTextContent.Companion $this$contentList) {
        Intrinsics.checkNotNullParameter($this$contentList, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RichTextContent, List<? extends ParagraphContent>>() { // from class: kntr.common.paragraph.input.RichTextContentLensKt$special$$inlined$invoke$2
            public List<? extends ParagraphContent> get(RichTextContent richTextContent) {
                RichTextContent it = richTextContent;
                return it.getContentList();
            }

            public RichTextContent set(RichTextContent richTextContent, List<? extends ParagraphContent> list) {
                List<? extends ParagraphContent> contentList = list;
                RichTextContent it = richTextContent;
                return RichTextContent.copy$default(it, contentList, 0, false, null, 14, null);
            }

            public RichTextContent modify(RichTextContent richTextContent, Function1<? super List<? extends ParagraphContent>, ? extends List<? extends ParagraphContent>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RichTextContent it = richTextContent;
                List contentList = (List) function1.invoke(it.getContentList());
                RichTextContent it2 = richTextContent;
                return RichTextContent.copy$default(it2, contentList, 0, false, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<RichTextContent, Integer> getCurrentFocus(RichTextContent.Companion $this$currentFocus) {
        Intrinsics.checkNotNullParameter($this$currentFocus, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RichTextContent, Integer>() { // from class: kntr.common.paragraph.input.RichTextContentLensKt$special$$inlined$invoke$3
            public Integer get(RichTextContent richTextContent) {
                RichTextContent it = richTextContent;
                return Integer.valueOf(it.getCurrentFocus());
            }

            public RichTextContent set(RichTextContent richTextContent, Integer num) {
                int currentFocus = num.intValue();
                RichTextContent it = richTextContent;
                return RichTextContent.copy$default(it, null, currentFocus, false, null, 13, null);
            }

            public RichTextContent modify(RichTextContent richTextContent, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RichTextContent it = richTextContent;
                int currentFocus = ((Number) function1.invoke(Integer.valueOf(it.getCurrentFocus()))).intValue();
                RichTextContent it2 = richTextContent;
                return RichTextContent.copy$default(it2, null, currentFocus, false, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<RichTextContent, Boolean> getFocusConsumed(RichTextContent.Companion $this$focusConsumed) {
        Intrinsics.checkNotNullParameter($this$focusConsumed, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RichTextContent, Boolean>() { // from class: kntr.common.paragraph.input.RichTextContentLensKt$special$$inlined$invoke$4
            public Boolean get(RichTextContent richTextContent) {
                RichTextContent it = richTextContent;
                return Boolean.valueOf(it.getFocusConsumed());
            }

            public RichTextContent set(RichTextContent richTextContent, Boolean bool) {
                boolean focusConsumed = bool.booleanValue();
                RichTextContent it = richTextContent;
                return RichTextContent.copy$default(it, null, 0, focusConsumed, null, 11, null);
            }

            public RichTextContent modify(RichTextContent richTextContent, Function1<? super Boolean, ? extends Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RichTextContent it = richTextContent;
                boolean focusConsumed = ((Boolean) function1.invoke(Boolean.valueOf(it.getFocusConsumed()))).booleanValue();
                RichTextContent it2 = richTextContent;
                return RichTextContent.copy$default(it2, null, 0, focusConsumed, null, 11, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<RichTextContent, Map<Asset, AssetContent>> getAssetMap(RichTextContent.Companion $this$assetMap) {
        Intrinsics.checkNotNullParameter($this$assetMap, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RichTextContent, Map<Asset, ? extends AssetContent>>() { // from class: kntr.common.paragraph.input.RichTextContentLensKt$special$$inlined$invoke$5
            public Map<Asset, ? extends AssetContent> get(RichTextContent richTextContent) {
                RichTextContent it = richTextContent;
                return it.getAssetMap$core_debug();
            }

            public RichTextContent set(RichTextContent richTextContent, Map<Asset, ? extends AssetContent> map) {
                Map<Asset, ? extends AssetContent> assetMap = map;
                RichTextContent it = richTextContent;
                return RichTextContent.copy$default(it, null, 0, false, assetMap, 7, null);
            }

            public RichTextContent modify(RichTextContent richTextContent, Function1<? super Map<Asset, ? extends AssetContent>, ? extends Map<Asset, ? extends AssetContent>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RichTextContent it = richTextContent;
                Map assetMap = (Map) function1.invoke(it.getAssetMap$core_debug());
                RichTextContent it2 = richTextContent;
                return RichTextContent.copy$default(it2, null, 0, false, assetMap, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, List<ParagraphContent>> getContentList(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContentList(RichTextContent.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getCurrentFocus(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCurrentFocus(RichTextContent.Companion));
    }

    public static final <T> BSimpleLens<T, Boolean> getFocusConsumed(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFocusConsumed(RichTextContent.Companion));
    }

    public static final <T> BSimpleLens<T, Map<Asset, AssetContent>> getAssetMap(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAssetMap(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, List<ParagraphContent>> contentListNullable(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContentList(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> currentFocusNullable(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCurrentFocus(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> focusConsumedNullable(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFocusConsumed(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, Map<Asset, AssetContent>> assetMapNullable(BSimpleLens<T, RichTextContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAssetMap(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, List<ParagraphContent>> getContentList(BNullableLens<T, RichTextContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContentList(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getCurrentFocus(BNullableLens<T, RichTextContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCurrentFocus(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, Boolean> getFocusConsumed(BNullableLens<T, RichTextContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFocusConsumed(RichTextContent.Companion));
    }

    public static final <T> BNullableLens<T, Map<Asset, AssetContent>> getAssetMap(BNullableLens<T, RichTextContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAssetMap(RichTextContent.Companion));
    }
}