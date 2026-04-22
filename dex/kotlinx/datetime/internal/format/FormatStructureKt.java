package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0002¨\u0006\u0006"}, d2 = {"basicFormats", "", "Lkotlinx/datetime/internal/format/FieldFormatDirective;", "T", "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class FormatStructureKt {
    public static final /* synthetic */ List access$basicFormats(FormatStructure format) {
        return basicFormats(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<FieldFormatDirective<T>> basicFormats(FormatStructure<? super T> formatStructure) {
        List $this$basicFormats_u24lambda_u242 = CollectionsKt.createListBuilder();
        basicFormats$lambda$2$rec($this$basicFormats_u24lambda_u242, formatStructure);
        return CollectionsKt.build($this$basicFormats_u24lambda_u242);
    }

    private static final <T> void basicFormats$lambda$2$rec(List<FieldFormatDirective<T>> list, FormatStructure<? super T> formatStructure) {
        if (!(formatStructure instanceof BasicFormatStructure)) {
            if (!(formatStructure instanceof ConcatenatedFormatStructure)) {
                if (!(formatStructure instanceof ConstantFormatStructure)) {
                    if (!(formatStructure instanceof SignedFormatStructure)) {
                        if (formatStructure instanceof AlternativesParsingFormatStructure) {
                            basicFormats$lambda$2$rec(list, ((AlternativesParsingFormatStructure) formatStructure).getMainFormat());
                            Iterable $this$forEach$iv = ((AlternativesParsingFormatStructure) formatStructure).getFormats();
                            for (Object element$iv : $this$forEach$iv) {
                                FormatStructure it = (FormatStructure) element$iv;
                                basicFormats$lambda$2$rec(list, it);
                            }
                            return;
                        } else if (formatStructure instanceof OptionalFormatStructure) {
                            basicFormats$lambda$2$rec(list, ((OptionalFormatStructure) formatStructure).getFormat());
                            return;
                        } else {
                            return;
                        }
                    }
                    basicFormats$lambda$2$rec(list, ((SignedFormatStructure) formatStructure).getFormat());
                    return;
                }
                return;
            }
            Iterable $this$forEach$iv2 = ((ConcatenatedFormatStructure) formatStructure).getFormats();
            for (Object element$iv2 : $this$forEach$iv2) {
                NonConcatenatedFormatStructure it2 = (NonConcatenatedFormatStructure) element$iv2;
                basicFormats$lambda$2$rec(list, it2);
            }
            return;
        }
        list.add(((BasicFormatStructure) formatStructure).getDirective());
    }
}