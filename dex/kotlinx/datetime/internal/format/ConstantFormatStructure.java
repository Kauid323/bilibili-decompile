package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.internal.format.formatter.ConstantStringFormatterStructure;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ConstantNumberConsumer;
import kotlinx.datetime.internal.format.parser.NumberSpanParserOperation;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.PlainStringParserOperation;

/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/internal/format/ConstantFormatStructure;", "T", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "string", "", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "equals", "", "other", "", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "hashCode", "", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "toString", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConstantFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final String string;

    public ConstantFormatStructure(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
    }

    public final String getString() {
        return this.string;
    }

    public String toString() {
        return "ConstantFormatStructure(" + this.string + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof ConstantFormatStructure) && Intrinsics.areEqual(this.string, ((ConstantFormatStructure) other).string);
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        String str;
        List build;
        if (this.string.length() == 0) {
            build = CollectionsKt.emptyList();
        } else {
            List $this$parser_u24lambda_u244 = CollectionsKt.createListBuilder();
            String str2 = "";
            if (UtilKt.isAsciiDigit(this.string.charAt(0))) {
                String $this$takeWhile$iv = this.string;
                int index$iv = 0;
                int length = $this$takeWhile$iv.length();
                while (true) {
                    if (index$iv >= length) {
                        break;
                    }
                    char it = $this$takeWhile$iv.charAt(index$iv);
                    if (UtilKt.isAsciiDigit(it)) {
                        index$iv++;
                    } else {
                        String substring = $this$takeWhile$iv.substring(0, index$iv);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        $this$takeWhile$iv = substring;
                        break;
                    }
                }
                $this$parser_u24lambda_u244.add(new NumberSpanParserOperation(CollectionsKt.listOf(new ConstantNumberConsumer($this$takeWhile$iv))));
                String $this$dropWhile$iv = this.string;
                int index$iv2 = 0;
                int length2 = $this$dropWhile$iv.length();
                while (true) {
                    if (index$iv2 < length2) {
                        char it2 = $this$dropWhile$iv.charAt(index$iv2);
                        if (UtilKt.isAsciiDigit(it2)) {
                            index$iv2++;
                        } else {
                            str = $this$dropWhile$iv.substring(index$iv2);
                            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                            break;
                        }
                    } else {
                        str = "";
                        break;
                    }
                }
            } else {
                str = this.string;
            }
            String suffix = str;
            if (suffix.length() > 0) {
                if (!UtilKt.isAsciiDigit(suffix.charAt(suffix.length() - 1))) {
                    $this$parser_u24lambda_u244.add(new PlainStringParserOperation(suffix));
                } else {
                    int index$iv3 = StringsKt.getLastIndex(suffix);
                    while (true) {
                        if (-1 >= index$iv3) {
                            break;
                        }
                        char it3 = suffix.charAt(index$iv3);
                        if (!UtilKt.isAsciiDigit(it3)) {
                            str2 = suffix.substring(0, index$iv3 + 1);
                            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                            break;
                        }
                        index$iv3--;
                    }
                    $this$parser_u24lambda_u244.add(new PlainStringParserOperation(str2));
                    String $this$takeLastWhile$iv = suffix;
                    int index$iv4 = StringsKt.getLastIndex($this$takeLastWhile$iv);
                    while (true) {
                        if (-1 >= index$iv4) {
                            break;
                        }
                        char it4 = $this$takeLastWhile$iv.charAt(index$iv4);
                        if (UtilKt.isAsciiDigit(it4)) {
                            index$iv4--;
                        } else {
                            String substring2 = $this$takeLastWhile$iv.substring(index$iv4 + 1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                            $this$takeLastWhile$iv = substring2;
                            break;
                        }
                    }
                    $this$parser_u24lambda_u244.add(new NumberSpanParserOperation(CollectionsKt.listOf(new ConstantNumberConsumer($this$takeLastWhile$iv))));
                }
            }
            build = CollectionsKt.build($this$parser_u24lambda_u244);
        }
        return new ParserStructure<>(build, CollectionsKt.emptyList());
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        return new ConstantStringFormatterStructure(this.string);
    }
}