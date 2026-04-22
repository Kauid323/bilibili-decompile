package kntr.common.paragraph.input;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.paragraph.input.content.TextContent;
import kntr.common.paragraph.input.content.TextRange;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: RichTextContent.kt */
@Lens
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010 \u001a\u00020\u0000J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nHÀ\u0003¢\u0006\u0002\b%JC\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nHÆ\u0001J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014¨\u0006-"}, d2 = {"Lkntr/common/paragraph/input/RichTextContent;", "", "contentList", "", "Lkntr/common/paragraph/input/content/ParagraphContent;", "currentFocus", "", "focusConsumed", "", "assetMap", "", "Lkntr/common/photonic/Asset;", "Lkntr/common/paragraph/input/content/AssetContent;", "<init>", "(Ljava/util/List;IZLjava/util/Map;)V", "getContentList", "()Ljava/util/List;", "getCurrentFocus", "()I", "getFocusConsumed", "()Z", "getAssetMap$core_debug", "()Ljava/util/Map;", "textCount", "getTextCount", "assetCount", "getAssetCount", "splitToPublish", "anyUploading", "getAnyUploading", "anyUploadFailed", "getAnyUploadFailed", "mergeContinuousTextContent", "component1", "component2", "component3", "component4", "component4$core_debug", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RichTextContent {
    public static final Companion Companion = new Companion(null);
    private static final RichTextContent Empty = new RichTextContent(CollectionsKt.listOf(new TextContent("", new TextRange(0, 0), null, 4, null)), -1, false, null, 12, null);
    private final int assetCount;
    private final Map<Asset, AssetContent> assetMap;
    private final List<ParagraphContent> contentList;
    private final int currentFocus;
    private final boolean focusConsumed;
    private final int textCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RichTextContent copy$default(RichTextContent richTextContent, List list, int i, boolean z, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = richTextContent.contentList;
        }
        if ((i2 & 2) != 0) {
            i = richTextContent.currentFocus;
        }
        if ((i2 & 4) != 0) {
            z = richTextContent.focusConsumed;
        }
        if ((i2 & 8) != 0) {
            map = richTextContent.assetMap;
        }
        return richTextContent.copy(list, i, z, map);
    }

    public final List<ParagraphContent> component1() {
        return this.contentList;
    }

    public final int component2() {
        return this.currentFocus;
    }

    public final boolean component3() {
        return this.focusConsumed;
    }

    public final Map<Asset, AssetContent> component4$core_debug() {
        return this.assetMap;
    }

    public final RichTextContent copy(List<? extends ParagraphContent> list, int i, boolean z, Map<Asset, AssetContent> map) {
        Intrinsics.checkNotNullParameter(list, "contentList");
        Intrinsics.checkNotNullParameter(map, "assetMap");
        return new RichTextContent(list, i, z, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RichTextContent) {
            RichTextContent richTextContent = (RichTextContent) obj;
            return Intrinsics.areEqual(this.contentList, richTextContent.contentList) && this.currentFocus == richTextContent.currentFocus && this.focusConsumed == richTextContent.focusConsumed && Intrinsics.areEqual(this.assetMap, richTextContent.assetMap);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.contentList.hashCode() * 31) + this.currentFocus) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.focusConsumed)) * 31) + this.assetMap.hashCode();
    }

    public String toString() {
        List<ParagraphContent> list = this.contentList;
        int i = this.currentFocus;
        boolean z = this.focusConsumed;
        return "RichTextContent(contentList=" + list + ", currentFocus=" + i + ", focusConsumed=" + z + ", assetMap=" + this.assetMap + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RichTextContent(List<? extends ParagraphContent> list, int currentFocus, boolean focusConsumed, Map<Asset, AssetContent> map) {
        Intrinsics.checkNotNullParameter(list, "contentList");
        Intrinsics.checkNotNullParameter(map, "assetMap");
        this.contentList = list;
        this.currentFocus = currentFocus;
        this.focusConsumed = focusConsumed;
        this.assetMap = map;
        int i = 0;
        for (ParagraphContent it : this.contentList) {
            i += it.getTextCount();
        }
        this.textCount = i;
        Iterable $this$filterIsInstance$iv = this.contentList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof AssetContent) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        this.assetCount = ((List) destination$iv$iv).size();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RichTextContent(List list, int i, boolean z, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, r1, r2, r3);
        Map map2;
        Map $this$mapNotNull$iv;
        boolean z2;
        Pair pair;
        int i3 = (i2 & 2) != 0 ? -1 : i;
        boolean z3 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            List<ParagraphContent> $this$mapNotNull$iv2 = list;
            Collection destination$iv$iv = new ArrayList();
            for (ParagraphContent it : $this$mapNotNull$iv2) {
                AssetContent assetContent = it instanceof AssetContent ? (AssetContent) it : null;
                if (assetContent != null) {
                    destination$iv$iv.add(assetContent);
                }
            }
            Iterable $this$associateBy$iv = (List) destination$iv$iv;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
            Map linkedHashMap = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associateBy$iv) {
                linkedHashMap.put(((AssetContent) element$iv$iv).getAsset(), element$iv$iv);
            }
            Map it$iv$iv = linkedHashMap;
            boolean z4 = false;
            Collection destination$iv$iv2 = new ArrayList();
            for (Map.Entry element$iv$iv$iv : linkedHashMap.entrySet()) {
                Asset key = (Asset) element$iv$iv$iv.getKey();
                if (key != null) {
                    $this$mapNotNull$iv = it$iv$iv;
                    z2 = z4;
                    pair = TuplesKt.to(key, element$iv$iv$iv.getValue());
                } else {
                    $this$mapNotNull$iv = it$iv$iv;
                    z2 = z4;
                    pair = null;
                }
                if (pair != null) {
                    destination$iv$iv2.add(pair);
                }
                it$iv$iv = $this$mapNotNull$iv;
                z4 = z2;
            }
            map2 = MapsKt.toMap((List) destination$iv$iv2);
        } else {
            map2 = map;
        }
    }

    public final List<ParagraphContent> getContentList() {
        return this.contentList;
    }

    public final int getCurrentFocus() {
        return this.currentFocus;
    }

    public final boolean getFocusConsumed() {
        return this.focusConsumed;
    }

    public final Map<Asset, AssetContent> getAssetMap$core_debug() {
        return this.assetMap;
    }

    /* compiled from: RichTextContent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/common/paragraph/input/RichTextContent$Companion;", "", "<init>", "()V", "Empty", "Lkntr/common/paragraph/input/RichTextContent;", "getEmpty", "()Lkntr/common/paragraph/input/RichTextContent;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RichTextContent getEmpty() {
            return RichTextContent.Empty;
        }
    }

    public final int getTextCount() {
        return this.textCount;
    }

    public final int getAssetCount() {
        return this.assetCount;
    }

    public final List<ParagraphContent> splitToPublish() {
        Iterable listOf;
        Iterable $this$flatMap$iv = this.contentList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            ParagraphContent it = (ParagraphContent) element$iv$iv;
            if (it instanceof TextContent) {
                listOf = ((TextContent) it).splitByParagraph();
            } else {
                listOf = CollectionsKt.listOf(it);
            }
            Iterable list$iv$iv = listOf;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }

    public final boolean getAnyUploading() {
        ParagraphContent it;
        Iterable $this$any$iv = this.contentList;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            ParagraphContent it2 = (ParagraphContent) element$iv;
            if (!(it2 instanceof AssetContent) || ((AssetContent) it2).getUploadState().getUploadFinished()) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean getAnyUploadFailed() {
        ParagraphContent it;
        Iterable $this$any$iv = this.contentList;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            ParagraphContent it2 = (ParagraphContent) element$iv;
            if (!(it2 instanceof AssetContent) || ((AssetContent) it2).getUploadState().getUploadSucceed()) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    public final RichTextContent mergeContinuousTextContent() {
        TextContent textContent;
        List newContentList = new ArrayList();
        TextContent lastTextContent = null;
        for (ParagraphContent content : this.contentList) {
            if (content instanceof TextContent) {
                if (lastTextContent == null || (textContent = lastTextContent.merge((TextContent) content)) == null) {
                    textContent = (TextContent) content;
                }
                lastTextContent = textContent;
            } else {
                if (lastTextContent != null) {
                    newContentList.add(lastTextContent);
                    lastTextContent = null;
                }
                newContentList.add(content);
            }
        }
        if (lastTextContent != null) {
            newContentList.add(lastTextContent);
        }
        return copy$default(this, newContentList, 0, false, null, 14, null);
    }
}