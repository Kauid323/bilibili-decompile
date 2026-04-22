package kntr.app.im.chat.db.model;

import com.bapis.bilibili.app.dynamic.v2.KBgStyle;
import com.bapis.bilibili.app.dynamic.v2.KColors;
import com.bapis.bilibili.app.dynamic.v2.KEmoteClickAction;
import com.bapis.bilibili.app.dynamic.v2.KEmoteNode;
import com.bapis.bilibili.app.dynamic.v2.KEmoteSize;
import com.bapis.bilibili.app.dynamic.v2.KImgInlineCfg;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KTextParagraph;
import com.bapis.bilibili.app.dynamic.v2.KWordNode;
import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: InputBoxContent.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000256B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\n\u0010\u0011J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u0003*\u00020\u001bH\u0002J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\b*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\f\u0010\"\u001a\u00020!*\u00020\tH\u0002J\f\u0010#\u001a\u00020!*\u00020\u0003H\u0002J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019¨\u00067"}, d2 = {"Lkntr/app/im/chat/db/model/InputBoxContent;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "cursorStart", RoomRecommendViewModel.EMPTY_CURSOR, "cursorEnd", "inlineContents", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/model/InlineContent;", "<init>", "(Ljava/lang/String;IILjava/util/List;)V", "seen0", "isBlank", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getCursorStart", "()I", "getCursorEnd", "getInlineContents", "()Ljava/util/List;", "()Z", "toParagraph", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph;", "getContentOfSelection", "toSummaryString", "getSummaryString", "getSelectedSummaryString", "replaceByInlineContents", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode;", "toEmoteNode", "toTextNode", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$db_debug", "Companion", "$serializer", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
@Lens
public final class InputBoxContent {
    private final int cursorEnd;
    private final int cursorStart;
    private final List<InlineContent> inlineContents;
    private final boolean isBlank;
    private final String text;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.db.model.InputBoxContent$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = InputBoxContent._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    public InputBoxContent() {
        this(null, 0, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputBoxContent copy$default(InputBoxContent inputBoxContent, String str, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = inputBoxContent.text;
        }
        if ((i3 & 2) != 0) {
            i = inputBoxContent.cursorStart;
        }
        if ((i3 & 4) != 0) {
            i2 = inputBoxContent.cursorEnd;
        }
        if ((i3 & 8) != 0) {
            list = inputBoxContent.inlineContents;
        }
        return inputBoxContent.copy(str, i, i2, list);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.cursorStart;
    }

    public final int component3() {
        return this.cursorEnd;
    }

    public final List<InlineContent> component4() {
        return this.inlineContents;
    }

    public final InputBoxContent copy(String str, int i, int i2, List<InlineContent> list) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, "inlineContents");
        return new InputBoxContent(str, i, i2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InputBoxContent) {
            InputBoxContent inputBoxContent = (InputBoxContent) obj;
            return Intrinsics.areEqual(this.text, inputBoxContent.text) && this.cursorStart == inputBoxContent.cursorStart && this.cursorEnd == inputBoxContent.cursorEnd && Intrinsics.areEqual(this.inlineContents, inputBoxContent.inlineContents);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.cursorStart) * 31) + this.cursorEnd) * 31) + this.inlineContents.hashCode();
    }

    public String toString() {
        String str = this.text;
        int i = this.cursorStart;
        int i2 = this.cursorEnd;
        return "InputBoxContent(text=" + str + ", cursorStart=" + i + ", cursorEnd=" + i2 + ", inlineContents=" + this.inlineContents + ")";
    }

    public /* synthetic */ InputBoxContent(int seen0, String text, int cursorStart, int cursorEnd, List inlineContents, boolean isBlank, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.text = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.text = text;
        }
        if ((seen0 & 2) == 0) {
            this.cursorStart = 0;
        } else {
            this.cursorStart = cursorStart;
        }
        if ((seen0 & 4) == 0) {
            this.cursorEnd = 0;
        } else {
            this.cursorEnd = cursorEnd;
        }
        if ((seen0 & 8) == 0) {
            this.inlineContents = CollectionsKt.emptyList();
        } else {
            this.inlineContents = inlineContents;
        }
        if ((seen0 & 16) == 0) {
            this.isBlank = StringsKt.isBlank(this.text);
        } else {
            this.isBlank = isBlank;
        }
    }

    public InputBoxContent(String text, int cursorStart, int cursorEnd, List<InlineContent> list) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(list, "inlineContents");
        this.text = text;
        this.cursorStart = cursorStart;
        this.cursorEnd = cursorEnd;
        this.inlineContents = list;
        this.isBlank = StringsKt.isBlank(this.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(InlineContent$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$db_debug(InputBoxContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.text, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.cursorStart != 0) {
            output.encodeIntElement(serialDesc, 1, self.cursorStart);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.cursorEnd != 0) {
            output.encodeIntElement(serialDesc, 2, self.cursorEnd);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.inlineContents, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.inlineContents);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isBlank != StringsKt.isBlank(self.text)) {
            output.encodeBooleanElement(serialDesc, 4, self.isBlank);
        }
    }

    public /* synthetic */ InputBoxContent(String str, int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getText() {
        return this.text;
    }

    public final int getCursorStart() {
        return this.cursorStart;
    }

    public final int getCursorEnd() {
        return this.cursorEnd;
    }

    public final List<InlineContent> getInlineContents() {
        return this.inlineContents;
    }

    public final boolean isBlank() {
        return this.isBlank;
    }

    public final KParagraph toParagraph() {
        List textNodes = replaceByInlineContents(this.text, this.inlineContents);
        return new KParagraph(KParagraph.KParagraphType.TEXT.INSTANCE, (KParagraph.KParagraphFormat) null, new KParagraph.KText(new KTextParagraph(textNodes)), 2, (DefaultConstructorMarker) null);
    }

    public final KParagraph getContentOfSelection() {
        int start = RangesKt.coerceIn(this.cursorStart, 0, this.text.length());
        int end = RangesKt.coerceIn(this.cursorEnd, start, this.text.length());
        String selected = this.text.substring(start, end);
        Intrinsics.checkNotNullExpressionValue(selected, "substring(...)");
        if (selected.length() > 0) {
            Iterable $this$filter$iv = this.inlineContents;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                int offset = ((InlineContent) element$iv$iv).getOffset();
                if (((start > offset || offset >= end) ? null : 1) != null) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                InlineContent it = (InlineContent) item$iv$iv;
                destination$iv$iv2.add(InlineContent.copy$default(it, null, null, null, it.getOffset() - start, false, null, 55, null));
            }
            List inlineContentOfSelection = (List) destination$iv$iv2;
            return new KParagraph(KParagraph.KParagraphType.TEXT.INSTANCE, (KParagraph.KParagraphFormat) null, new KParagraph.KText(new KTextParagraph(replaceByInlineContents(selected, inlineContentOfSelection))), 2, (DefaultConstructorMarker) null);
        }
        return null;
    }

    private final String toSummaryString(KParagraph $this$toSummaryString) {
        KTextParagraph value;
        List nodes;
        KParagraph.KText content = $this$toSummaryString.getContent();
        KParagraph.KText kText = content instanceof KParagraph.KText ? content : null;
        if (kText == null || (value = kText.getValue()) == null || (nodes = value.getNodes()) == null) {
            return null;
        }
        return CollectionsKt.joinToString$default(nodes, RoomRecommendViewModel.EMPTY_CURSOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.im.chat.db.model.InputBoxContent$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                CharSequence summaryString$lambda$1;
                summaryString$lambda$1 = InputBoxContent.toSummaryString$lambda$1((KTextNode) obj);
                return summaryString$lambda$1;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toSummaryString$lambda$1(KTextNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRawText();
    }

    public final String getSummaryString() {
        String summaryString = toSummaryString(toParagraph());
        return summaryString == null ? this.text : summaryString;
    }

    public final String getSelectedSummaryString() {
        String summaryString;
        KParagraph contentOfSelection = getContentOfSelection();
        return (contentOfSelection == null || (summaryString = toSummaryString(contentOfSelection)) == null) ? RoomRecommendViewModel.EMPTY_CURSOR : summaryString;
    }

    private final List<KTextNode> replaceByInlineContents(String $this$replaceByInlineContents, List<InlineContent> list) {
        List<InlineContent> $this$sortedBy$iv = list;
        List sorted = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.db.model.InputBoxContent$replaceByInlineContents$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                InlineContent it = (InlineContent) t;
                InlineContent it2 = (InlineContent) t2;
                return ComparisonsKt.compareValues(Integer.valueOf(it.getOffset()), Integer.valueOf(it2.getOffset()));
            }
        });
        List nodes = new ArrayList();
        int last = 0;
        Iterator it = sorted.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            InlineContent inlineContent = (InlineContent) it.next();
            String partString = $this$replaceByInlineContents.substring(last, inlineContent.getOffset());
            Intrinsics.checkNotNullExpressionValue(partString, "substring(...)");
            if (partString.length() > 0) {
                nodes.add(toTextNode(partString));
            }
            nodes.add(toEmoteNode(inlineContent));
            last = inlineContent.getOffset() + 1;
        }
        String lastString = $this$replaceByInlineContents.substring(last);
        Intrinsics.checkNotNullExpressionValue(lastString, "substring(...)");
        if (lastString.length() > 0) {
            nodes.add(toTextNode(lastString));
        }
        return nodes;
    }

    private final KTextNode toEmoteNode(InlineContent $this$toEmoteNode) {
        KTextNode.KTextNodeType kTextNodeType = KTextNode.KTextNodeType.EMOTE.INSTANCE;
        String url = $this$toEmoteNode.getUrl();
        boolean animated = $this$toEmoteNode.getAnimated();
        return new KTextNode(kTextNodeType, $this$toEmoteNode.getRawText(), new KTextNode.KEmote(new KEmoteNode(new KWordNode($this$toEmoteNode.getRawText(), 16.0d, new KColors("#18191C", "#E7E9EB"), (KWordNode.KWordNodeStyle) null, (KWordNode.KUnderlineStyle) null, (String) null, 0, (KBgStyle) null, 248, (DefaultConstructorMarker) null), url, new KEmoteSize($this$toEmoteNode.getSize().getWidth(), (int) $this$toEmoteNode.getSize().getWidth()), false, (KImgInlineCfg) null, animated, (KEmoteClickAction) null, $this$toEmoteNode.getId(), (String) null, (String) null, false, 1880, (DefaultConstructorMarker) null)));
    }

    private final KTextNode toTextNode(String $this$toTextNode) {
        return new KTextNode(KTextNode.KTextNodeType.WORDS.INSTANCE, $this$toTextNode, new KTextNode.KWord(new KWordNode($this$toTextNode, 16.0d, new KColors("#18191C", "#E7E9EB"), (KWordNode.KWordNodeStyle) null, (KWordNode.KUnderlineStyle) null, (String) null, 0, (KBgStyle) null, 248, (DefaultConstructorMarker) null)));
    }

    /* compiled from: InputBoxContent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/model/InputBoxContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/db/model/InputBoxContent;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<InputBoxContent> serializer() {
            return new GeneratedSerializer<InputBoxContent>() { // from class: kntr.app.im.chat.db.model.InputBoxContent$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.im.chat.db.model.InputBoxContent", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.im.chat.db.model.InputBoxContent> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.im.chat.db.model.InputBoxContent> A[REMOVE]) =  kntr.app.im.chat.db.model.InputBoxContent$$serializer.INSTANCE kntr.app.im.chat.db.model.InputBoxContent$$serializer)
                         in method: kntr.app.im.chat.db.model.InputBoxContent.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.im.chat.db.model.InputBoxContent>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1257)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.im.chat.db.model.InputBoxContent")
                          (wrap: kntr.app.im.chat.db.model.InputBoxContent$$serializer : 0x0009: SGET  (r1v0 kntr.app.im.chat.db.model.InputBoxContent$$serializer A[REMOVE]) =  kntr.app.im.chat.db.model.InputBoxContent$$serializer.INSTANCE kntr.app.im.chat.db.model.InputBoxContent$$serializer)
                          (5 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.im.chat.db.model.InputBoxContent$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	... 5 more
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.im.chat.db.model.InputBoxContent$$serializer
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                        	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        kntr.app.im.chat.db.model.InputBoxContent$$serializer r0 = kntr.app.im.chat.db.model.InputBoxContent$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.im.chat.db.model.InputBoxContent.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }
        }