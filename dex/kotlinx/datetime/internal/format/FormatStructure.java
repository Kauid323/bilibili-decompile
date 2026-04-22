package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lkotlinx/datetime/internal/format/FormatStructure;", "T", "", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "Lkotlinx/datetime/internal/format/ConcatenatedFormatStructure;", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FormatStructure<T> {
    FormatterStructure<T> formatter();

    ParserStructure<T> parser();
}