package kotlinx.datetime.internal.format;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.StringFormatterStructure;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

/* compiled from: FieldFormatDirective.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/internal/format/StringFieldFormatDirective;", "Target", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "field", "Lkotlinx/datetime/internal/format/FieldSpec;", "", "acceptedStrings", "", "(Lkotlinx/datetime/internal/format/FieldSpec;Ljava/util/Set;)V", "getField", "()Lkotlinx/datetime/internal/format/FieldSpec;", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class StringFieldFormatDirective<Target> implements FieldFormatDirective<Target> {
    private final Set<String> acceptedStrings;
    private final FieldSpec<Target, String> field;

    /* JADX WARN: Multi-variable type inference failed */
    public StringFieldFormatDirective(FieldSpec<? super Target, String> field, Set<String> acceptedStrings) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(acceptedStrings, "acceptedStrings");
        this.field = field;
        this.acceptedStrings = acceptedStrings;
        if (!this.acceptedStrings.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("The set of accepted strings is empty".toString());
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public final FieldSpec<Target, String> getField() {
        return this.field;
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public FormatterStructure<Target> formatter() {
        return new StringFormatterStructure(new StringFieldFormatDirective$formatter$1(this.field.getAccessor()));
    }

    @Override // kotlinx.datetime.internal.format.FieldFormatDirective
    public ParserStructure<Target> parser() {
        return new ParserStructure<>(CollectionsKt.listOf(new StringSetParserOperation(this.acceptedStrings, this.field.getAccessor(), this.field.getName())), CollectionsKt.emptyList());
    }
}