package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;

/* compiled from: FieldFormatDirective.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/internal/format/FieldFormatDirective;", "Target", "", "builderRepresentation", "", "getBuilderRepresentation", "()Ljava/lang/String;", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface FieldFormatDirective<Target> {
    FormatterStructure<Target> formatter();

    String getBuilderRepresentation();

    FieldSpec<Target, ?> getField();

    ParserStructure<Target> parser();
}