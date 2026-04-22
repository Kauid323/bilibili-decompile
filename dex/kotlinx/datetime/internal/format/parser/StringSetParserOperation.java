package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0015B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ-\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Lkotlinx/datetime/internal/format/parser/StringSetParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "strings", "", "", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "whatThisExpects", "(Ljava/util/Collection;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;)V", "trie", "Lkotlinx/datetime/internal/format/parser/StringSetParserOperation$TrieNode;", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "TrieNode", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StringSetParserOperation<Output> implements ParserOperation<Output> {
    private final AssignableField<Output, String> setter;
    private final TrieNode trie;
    private final String whatThisExpects;

    /* JADX WARN: Multi-variable type inference failed */
    public StringSetParserOperation(Collection<String> strings, AssignableField<? super Output, String> setter, String whatThisExpects) {
        TrieNode it;
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.setter = setter;
        this.whatThisExpects = whatThisExpects;
        int i = 0;
        int i2 = 3;
        this.trie = new TrieNode(null, false, 3, null);
        for (String string : strings) {
            if ((string.length() > 0 ? 1 : i) == 0) {
                throw new IllegalArgumentException(("Found an empty string in " + this.whatThisExpects).toString());
            }
            TrieNode trieNode = this.trie;
            int length = string.length();
            int i3 = i;
            while (i3 < length) {
                char charAt = string.charAt(i3);
                List $this$binarySearchBy_u24default$iv = trieNode.getChildren();
                final Comparable key$iv = String.valueOf(charAt);
                int toIndex$iv = CollectionsKt.binarySearch($this$binarySearchBy_u24default$iv, 0, $this$binarySearchBy_u24default$iv.size(), new Function1<Pair<? extends String, ? extends TrieNode>, Integer>() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$special$$inlined$binarySearchBy$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(Pair<? extends String, ? extends StringSetParserOperation.TrieNode> pair) {
                        Pair<? extends String, ? extends StringSetParserOperation.TrieNode> it2 = pair;
                        return Integer.valueOf(ComparisonsKt.compareValues((String) it2.getFirst(), key$iv));
                    }
                });
                if (toIndex$iv < 0) {
                    it = new TrieNode(null, false, i2, null);
                    trieNode.getChildren().add((-toIndex$iv) - 1, TuplesKt.to(String.valueOf(charAt), it));
                } else {
                    it = (TrieNode) trieNode.getChildren().get(toIndex$iv).getSecond();
                }
                trieNode = it;
                i3++;
                i2 = 3;
            }
            if (trieNode.isTerminal()) {
                throw new IllegalArgumentException(("The string '" + string + "' was passed several times").toString());
            }
            trieNode.setTerminal(true);
            i = 0;
            i2 = 3;
        }
        _init_$reduceTrie(this.trie);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ParserOperation.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/datetime/internal/format/parser/StringSetParserOperation$TrieNode;", "", "children", "", "Lkotlin/Pair;", "", "isTerminal", "", "(Ljava/util/List;Z)V", "getChildren", "()Ljava/util/List;", "()Z", "setTerminal", "(Z)V", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class TrieNode {
        private final List<Pair<String, TrieNode>> children;
        private boolean isTerminal;

        public TrieNode() {
            this(null, false, 3, null);
        }

        public TrieNode(List<Pair<String, TrieNode>> children, boolean isTerminal) {
            Intrinsics.checkNotNullParameter(children, "children");
            this.children = children;
            this.isTerminal = isTerminal;
        }

        public /* synthetic */ TrieNode(ArrayList arrayList, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? false : z);
        }

        public final List<Pair<String, TrieNode>> getChildren() {
            return this.children;
        }

        public final boolean isTerminal() {
            return this.isTerminal;
        }

        public final void setTerminal(boolean z) {
            this.isTerminal = z;
        }
    }

    private static final void _init_$reduceTrie(TrieNode trie) {
        for (Pair<String, TrieNode> pair : trie.getChildren()) {
            _init_$reduceTrie((TrieNode) pair.component2());
        }
        List newChildren = new ArrayList();
        for (Pair<String, TrieNode> pair2 : trie.getChildren()) {
            String key = (String) pair2.component1();
            TrieNode child = (TrieNode) pair2.component2();
            if (!child.isTerminal() && child.getChildren().size() == 1) {
                Pair pair3 = (Pair) CollectionsKt.single((List<? extends Object>) child.getChildren());
                String grandChildKey = (String) pair3.component1();
                TrieNode grandChild = (TrieNode) pair3.component2();
                newChildren.add(TuplesKt.to(key + grandChildKey, grandChild));
            } else {
                newChildren.add(TuplesKt.to(key, child));
            }
        }
        trie.getChildren().clear();
        List $this$sortedBy$iv = newChildren;
        trie.getChildren().addAll(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$_init_$reduceTrie$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Pair it = (Pair) t;
                Pair it2 = (Pair) t2;
                return ComparisonsKt.compareValues((String) it.getFirst(), (String) it2.getFirst());
            }
        }));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
        r0 = r4;
        r1.element += r5.length();
     */
    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1490consumeFANa98k(Output output, final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        TrieNode node = this.trie;
        final Ref.IntRef index = new Ref.IntRef();
        index.element = startIndex;
        Integer lastMatch = null;
        loop0: while (index.element <= input.length()) {
            if (node.isTerminal()) {
                lastMatch = Integer.valueOf(index.element);
            }
            for (Pair<String, TrieNode> pair : node.getChildren()) {
                String key = (String) pair.component1();
                TrieNode child = (TrieNode) pair.component2();
                if (StringsKt.startsWith$default(input, (CharSequence) key, index.element, false, 4, (Object) null)) {
                    break;
                }
            }
        }
        if (lastMatch != null) {
            return ParserOperationKt.access$setWithoutReassigning(this.setter, output, input.subSequence(startIndex, lastMatch.intValue()).toString(), startIndex, lastMatch.intValue());
        }
        return ParseResult.Companion.m1500ErrorRg3Co2E(startIndex, new Function0<String>(this) { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$consume$1
            final /* synthetic */ StringSetParserOperation<Output> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str;
                StringBuilder append = new StringBuilder().append("Expected ");
                str = ((StringSetParserOperation) this.this$0).whatThisExpects;
                return append.append(str).append(" but got ").append(input.subSequence(startIndex, index.element).toString()).toString();
            }
        });
    }
}