package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.datetime.internal.UtilKt;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0002\u0010\u0006J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Lkotlinx/datetime/internal/format/parser/NumberSpanParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "consumers", "", "Lkotlinx/datetime/internal/format/parser/NumberConsumer;", "(Ljava/util/List;)V", "getConsumers", "()Ljava/util/List;", "isFlexible", "", "minLength", "", "whatThisExpects", "", "getWhatThisExpects", "()Ljava/lang/String;", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "toString", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NumberSpanParserOperation<Output> implements ParserOperation<Output> {
    private final List<NumberConsumer<Output>> consumers;
    private final boolean isFlexible;
    private final int minLength;

    /* JADX WARN: Multi-variable type inference failed */
    public NumberSpanParserOperation(List<? extends NumberConsumer<? super Output>> consumers) {
        boolean z;
        NumberConsumer it;
        Iterable $this$all$iv;
        NumberConsumer it2;
        int count$iv;
        Intrinsics.checkNotNullParameter(consumers, "consumers");
        this.consumers = consumers;
        Iterator<T> it3 = this.consumers.iterator();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (!it3.hasNext()) {
                break;
            }
            NumberConsumer it4 = (NumberConsumer) it3.next();
            Integer length = it4.getLength();
            if (length != null) {
                i2 = length.intValue();
            }
            i += i2;
        }
        this.minLength = i;
        Iterable $this$any$iv = this.consumers;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it5 = $this$any$iv.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z = false;
                    break;
                }
                Object element$iv = it5.next();
                NumberConsumer it6 = (NumberConsumer) element$iv;
                if (it6.getLength() == null) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
        }
        this.isFlexible = z;
        Iterable $this$all$iv2 = this.consumers;
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator<T> it7 = $this$all$iv2.iterator();
            while (true) {
                if (!it7.hasNext()) {
                    $this$all$iv = 1;
                    break;
                }
                Object element$iv2 = it7.next();
                NumberConsumer it8 = (NumberConsumer) element$iv2;
                Integer length2 = it8.getLength();
                if ((length2 != null ? length2.intValue() : Integer.MAX_VALUE) > 0) {
                    it2 = 1;
                    continue;
                } else {
                    it2 = null;
                    continue;
                }
                if (it2 == null) {
                    $this$all$iv = null;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        if ($this$all$iv == null) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Iterable $this$count$iv = this.consumers;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            count$iv = 0;
        } else {
            count$iv = 0;
            for (Object element$iv3 : $this$count$iv) {
                NumberConsumer it9 = (NumberConsumer) element$iv3;
                NumberConsumer it10 = it9.getLength() == null ? 1 : null;
                if (it10 != null && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (count$iv <= 1) {
            return;
        }
        Iterable $this$filter$iv = this.consumers;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            NumberConsumer it11 = (NumberConsumer) element$iv$iv;
            NumberConsumer it12 = it11.getLength() == null ? 1 : null;
            if (it12 != null) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            NumberConsumer it13 = (NumberConsumer) item$iv$iv;
            destination$iv$iv2.add(it13.getWhatThisExpects());
        }
        List fieldNames = (List) destination$iv$iv2;
        throw new IllegalArgumentException(("At most one variable-length numeric field in a row is allowed, but got several: " + fieldNames + ". Parsing is undefined: for example, with variable-length month number and variable-length day of month, '111' can be parsed as Jan 11th or Nov 1st.").toString());
    }

    public final List<NumberConsumer<Output>> getConsumers() {
        return this.consumers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getWhatThisExpects() {
        Iterable $this$map$iv = this.consumers;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            NumberConsumer it = (NumberConsumer) item$iv$iv;
            StringBuilder sb = new StringBuilder();
            Integer length = it.getLength();
            destination$iv$iv.add(sb.append(length == null ? "at least one digit" : length + " digits").append(" for ").append(it.getWhatThisExpects()).toString());
        }
        List consumerLengths = (List) destination$iv$iv;
        return this.isFlexible ? "a number with at least " + this.minLength + " digits: " + consumerLengths : "a number with exactly " + this.minLength + " digits: " + consumerLengths;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k  reason: not valid java name */
    public Object mo1490consumeFANa98k(Output output, CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (this.minLength + startIndex > input.length()) {
            return ParseResult.Companion.m1500ErrorRg3Co2E(startIndex, new Function0<String>(this) { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$consume$1
                final /* synthetic */ NumberSpanParserOperation<Output> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String whatThisExpects;
                    StringBuilder append = new StringBuilder().append("Unexpected end of input: yet to parse ");
                    whatThisExpects = this.this$0.getWhatThisExpects();
                    return append.append(whatThisExpects).toString();
                }
            });
        }
        final Ref.IntRef digitsInRow = new Ref.IntRef();
        while (digitsInRow.element + startIndex < input.length() && UtilKt.isAsciiDigit(input.charAt(digitsInRow.element + startIndex))) {
            digitsInRow.element++;
            int i = digitsInRow.element;
        }
        if (digitsInRow.element < this.minLength) {
            return ParseResult.Companion.m1500ErrorRg3Co2E(startIndex, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$consume$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String whatThisExpects;
                    StringBuilder append = new StringBuilder().append("Only found ").append(Ref.IntRef.this.element).append(" digits in a row, but need to parse ");
                    whatThisExpects = this.getWhatThisExpects();
                    return append.append(whatThisExpects).toString();
                }
            });
        }
        int index = startIndex;
        int size = this.consumers.size();
        for (final int i2 = 0; i2 < size; i2++) {
            Integer length = this.consumers.get(i2).getLength();
            int length2 = length != null ? length.intValue() : (digitsInRow.element - this.minLength) + 1;
            final NumberConsumptionError error = this.consumers.get(i2).consume(output, input, index, index + length2);
            if (error != null) {
                final String numberString = input.subSequence(index, index + length2).toString();
                return ParseResult.Companion.m1500ErrorRg3Co2E(index, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.NumberSpanParserOperation$consume$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Can not interpret the string '" + numberString + "' as " + ((NumberConsumer) this.getConsumers().get(i2)).getWhatThisExpects() + ": " + error.errorMessage();
                    }
                });
            }
            index += length2;
        }
        return ParseResult.Companion.m1501OkQi1bsqg(index);
    }

    public String toString() {
        return getWhatThisExpects();
    }
}