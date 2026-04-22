package kotlinx.datetime.internal.format;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.formatter.FormatterStructure;
import kotlinx.datetime.internal.format.formatter.SignedFormatter;
import kotlinx.datetime.internal.format.parser.ParserKt;
import kotlinx.datetime.internal.format.parser.ParserStructure;
import kotlinx.datetime.internal.format.parser.SignParser;

/* compiled from: FormatStructure.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlinx/datetime/internal/format/SignedFormatStructure;", "T", "Lkotlinx/datetime/internal/format/NonConcatenatedFormatStructure;", "format", "Lkotlinx/datetime/internal/format/FormatStructure;", "withPlusSign", "", "(Lkotlinx/datetime/internal/format/FormatStructure;Z)V", "fieldSigns", "", "Lkotlinx/datetime/internal/format/FieldSign;", "getFormat", "()Lkotlinx/datetime/internal/format/FormatStructure;", "getWithPlusSign", "()Z", "equals", "other", "", "formatter", "Lkotlinx/datetime/internal/format/formatter/FormatterStructure;", "hashCode", "", "parser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SignedFormatStructure<T> implements NonConcatenatedFormatStructure<T> {
    private final Set<FieldSign<T>> fieldSigns;
    private final FormatStructure<T> format;
    private final boolean withPlusSign;

    /* JADX WARN: Multi-variable type inference failed */
    public SignedFormatStructure(FormatStructure<? super T> format, boolean withPlusSign) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.withPlusSign = withPlusSign;
        Iterable $this$mapNotNull$iv = FormatStructureKt.access$basicFormats(this.format);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            FieldFormatDirective it = (FieldFormatDirective) element$iv$iv$iv;
            FieldSign sign = it.getField().getSign();
            if (sign != null) {
                destination$iv$iv.add(sign);
            }
        }
        this.fieldSigns = CollectionsKt.toSet((List) destination$iv$iv);
        if (this.fieldSigns.isEmpty()) {
            throw new IllegalArgumentException("Signed format must contain at least one field with a sign".toString());
        }
    }

    public final FormatStructure<T> getFormat() {
        return this.format;
    }

    public final boolean getWithPlusSign() {
        return this.withPlusSign;
    }

    public String toString() {
        return "SignedFormatStructure(" + this.format + ')';
    }

    public boolean equals(Object other) {
        return (other instanceof SignedFormatStructure) && Intrinsics.areEqual(this.format, ((SignedFormatStructure) other).format) && this.withPlusSign == ((SignedFormatStructure) other).withPlusSign;
    }

    public int hashCode() {
        return (this.format.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.withPlusSign);
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public ParserStructure<T> parser() {
        return ParserKt.concat(CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(new SignParser(new Function2<T, Boolean, Unit>(this) { // from class: kotlinx.datetime.internal.format.SignedFormatStructure$parser$1
            final /* synthetic */ SignedFormatStructure<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object p1, Boolean bool) {
                invoke((SignedFormatStructure$parser$1<T>) p1, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(T t, boolean isNegative) {
                Set<FieldSign> set;
                set = ((SignedFormatStructure) this.this$0).fieldSigns;
                for (FieldSign field : set) {
                    boolean z = true;
                    boolean wasNegative = Intrinsics.areEqual(field.isNegative().getter(t), (Object) true);
                    Accessor isNegative2 = field.isNegative();
                    if (isNegative == wasNegative) {
                        z = false;
                    }
                    isNegative2.trySetWithoutReassigning(t, Boolean.valueOf(z));
                }
            }
        }, this.withPlusSign, "sign for " + this.fieldSigns)), CollectionsKt.emptyList()), this.format.parser()}));
    }

    @Override // kotlinx.datetime.internal.format.FormatStructure
    public FormatterStructure<T> formatter() {
        FormatterStructure innerFormat = this.format.formatter();
        return new SignedFormatter(innerFormat, new SignedFormatStructure$formatter$1(this), this.withPlusSign);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean formatter$checkIfAllNegative(SignedFormatStructure<? super T> signedFormatStructure, T t) {
        boolean seenNonZero = false;
        for (FieldSign check : ((SignedFormatStructure) signedFormatStructure).fieldSigns) {
            if (Intrinsics.areEqual((Object) check.isNegative().getter(t), (Object) true)) {
                seenNonZero = true;
            } else if (!check.isZero(t)) {
                return false;
            }
        }
        return seenNonZero;
    }
}