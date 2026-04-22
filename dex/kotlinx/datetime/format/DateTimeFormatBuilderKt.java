package kotlinx.datetime.format;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.ToKotlinCodeKt;
import kotlinx.datetime.internal.format.AlternativesParsingFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.ConcatenatedFormatStructure;
import kotlinx.datetime.internal.format.ConstantFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.OptionalFormatStructure;
import kotlinx.datetime.internal.format.SignedFormatStructure;

/* compiled from: DateTimeFormatBuilder.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001ah\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u000424\u0010\u0006\u001a\u001b\u0012\u0017\b\u0001\u0012\u0013\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\b\t0\u0007\"\u0013\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\b\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\b\t¢\u0006\u0002\u0010\u000b\u001a6\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00100\u000fH\u0000\u001a\u0012\u0010\u0012\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014\u001a<\u0010\u0015\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\b\t¢\u0006\u0002\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"CODE_INDENT", "", "alternativeParsing", "", "T", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "alternativeFormats", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "primaryFormat", "(Lkotlinx/datetime/format/DateTimeFormatBuilder;[Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "builderString", "Lkotlinx/datetime/internal/format/FormatStructure;", "constants", "", "Lkotlin/Pair;", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "char", "value", "", "optional", "ifZero", "format", "(Lkotlinx/datetime/format/DateTimeFormatBuilder;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "secondFractionInternal", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "minLength", "", "maxLength", "grouping", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DateTimeFormatBuilderKt {
    private static final String CODE_INDENT = "    ";

    public static final void secondFractionInternal(DateTimeFormatBuilder.WithTime $this$secondFractionInternal, int minLength, int maxLength, List<Integer> grouping) {
        Intrinsics.checkNotNullParameter($this$secondFractionInternal, "<this>");
        Intrinsics.checkNotNullParameter(grouping, "grouping");
        if ($this$secondFractionInternal instanceof AbstractWithTimeBuilder) {
            ((AbstractWithTimeBuilder) $this$secondFractionInternal).addFormatStructureForTime(new BasicFormatStructure(new FractionalSecondDirective(minLength, maxLength, grouping)));
        }
    }

    public static final <T extends DateTimeFormatBuilder> void alternativeParsing(T t, Function1<? super T, Unit>[] alternativeFormats, Function1<? super T, Unit> primaryFormat) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(alternativeFormats, "alternativeFormats");
        Intrinsics.checkNotNullParameter(primaryFormat, "primaryFormat");
        if (t instanceof AbstractDateTimeFormatBuilder) {
            ((AbstractDateTimeFormatBuilder) t).appendAlternativeParsingImpl((Function1[]) Arrays.copyOf(alternativeFormats, alternativeFormats.length), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(primaryFormat, 1));
            return;
        }
        throw new IllegalStateException("impossible");
    }

    public static final <T extends DateTimeFormatBuilder> void optional(T t, String ifZero, Function1<? super T, Unit> format) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(ifZero, "ifZero");
        Intrinsics.checkNotNullParameter(format, "format");
        if (t instanceof AbstractDateTimeFormatBuilder) {
            ((AbstractDateTimeFormatBuilder) t).appendOptionalImpl(ifZero, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(format, 1));
            return;
        }
        throw new IllegalStateException("impossible");
    }

    public static /* synthetic */ void optional$default(DateTimeFormatBuilder dateTimeFormatBuilder, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        optional(dateTimeFormatBuilder, str, function1);
    }

    /* renamed from: char */
    public static final void m1484char(DateTimeFormatBuilder $this$char, char value) {
        Intrinsics.checkNotNullParameter($this$char, "<this>");
        $this$char.chars(String.valueOf(value));
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x031f, code lost:
        if (r5 != (((kotlinx.datetime.internal.format.ConcatenatedFormatStructure) r17).getFormats().size() - 1)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0332, code lost:
        r2.append(builderString((kotlinx.datetime.internal.format.FormatStructure) kotlin.collections.CollectionsKt.last((java.util.List<? extends java.lang.Object>) ((kotlinx.datetime.internal.format.ConcatenatedFormatStructure) r17).getFormats()), r18));
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0339, code lost:
        r7 = r2.append(builderString(((kotlinx.datetime.internal.format.ConcatenatedFormatStructure) r17).getFormats().get(r5), r18));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "append(...)");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7.append('\n'), "append(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0358, code lost:
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> String builderString(FormatStructure<? super T> formatStructure, List<? extends Pair<String, ? extends CachedFormatStructure<?>>> constants) {
        Intrinsics.checkNotNullParameter(formatStructure, "<this>");
        Intrinsics.checkNotNullParameter(constants, "constants");
        if (formatStructure instanceof BasicFormatStructure) {
            return ((BasicFormatStructure) formatStructure).getDirective().getBuilderRepresentation();
        }
        if (formatStructure instanceof ConstantFormatStructure) {
            if (((ConstantFormatStructure) formatStructure).getString().length() == 1) {
                return "char(" + ToKotlinCodeKt.toKotlinCode(((ConstantFormatStructure) formatStructure).getString().charAt(0)) + ')';
            }
            return "chars(" + ToKotlinCodeKt.toKotlinCode(((ConstantFormatStructure) formatStructure).getString()) + ')';
        } else if (formatStructure instanceof SignedFormatStructure) {
            if ((((SignedFormatStructure) formatStructure).getFormat() instanceof BasicFormatStructure) && (((BasicFormatStructure) ((SignedFormatStructure) formatStructure).getFormat()).getDirective() instanceof UtcOffsetWholeHoursDirective)) {
                return ((BasicFormatStructure) ((SignedFormatStructure) formatStructure).getFormat()).getDirective().getBuilderRepresentation();
            }
            StringBuilder $this$builderString_u24lambda_u240 = new StringBuilder();
            if (((SignedFormatStructure) formatStructure).getWithPlusSign()) {
                StringBuilder append = $this$builderString_u24lambda_u240.append("withSharedSign(outputPlus = true) {");
                Intrinsics.checkNotNullExpressionValue(append, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append(...)");
            } else {
                StringBuilder append2 = $this$builderString_u24lambda_u240.append("withSharedSign {");
                Intrinsics.checkNotNullExpressionValue(append2, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append(...)");
            }
            StringBuilder append3 = $this$builderString_u24lambda_u240.append(StringsKt.prependIndent(builderString(((SignedFormatStructure) formatStructure).getFormat(), constants), CODE_INDENT));
            Intrinsics.checkNotNullExpressionValue(append3, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append(...)");
            $this$builderString_u24lambda_u240.append("}");
            String sb = $this$builderString_u24lambda_u240.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
            return sb;
        } else if (formatStructure instanceof OptionalFormatStructure) {
            StringBuilder $this$builderString_u24lambda_u241 = new StringBuilder();
            if (Intrinsics.areEqual(((OptionalFormatStructure) formatStructure).getOnZero(), "")) {
                StringBuilder append4 = $this$builderString_u24lambda_u241.append("optional {");
                Intrinsics.checkNotNullExpressionValue(append4, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append4.append('\n'), "append(...)");
            } else {
                StringBuilder append5 = $this$builderString_u24lambda_u241.append("optional(" + ToKotlinCodeKt.toKotlinCode(((OptionalFormatStructure) formatStructure).getOnZero()) + ") {");
                Intrinsics.checkNotNullExpressionValue(append5, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append5.append('\n'), "append(...)");
            }
            String subformat = builderString(((OptionalFormatStructure) formatStructure).getFormat(), constants);
            if (subformat.length() > 0) {
                StringBuilder append6 = $this$builderString_u24lambda_u241.append(StringsKt.prependIndent(subformat, CODE_INDENT));
                Intrinsics.checkNotNullExpressionValue(append6, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append6.append('\n'), "append(...)");
            }
            $this$builderString_u24lambda_u241.append("}");
            String sb2 = $this$builderString_u24lambda_u241.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        } else if (formatStructure instanceof AlternativesParsingFormatStructure) {
            StringBuilder $this$builderString_u24lambda_u243 = new StringBuilder();
            $this$builderString_u24lambda_u243.append("alternativeParsing(");
            for (FormatStructure alternative : ((AlternativesParsingFormatStructure) formatStructure).getFormats()) {
                StringBuilder append7 = $this$builderString_u24lambda_u243.append("{");
                Intrinsics.checkNotNullExpressionValue(append7, "append(...)");
                Intrinsics.checkNotNullExpressionValue(append7.append('\n'), "append(...)");
                String subformat2 = builderString(alternative, constants);
                if (subformat2.length() > 0 ? true : r3) {
                    StringBuilder append8 = $this$builderString_u24lambda_u243.append(StringsKt.prependIndent(subformat2, CODE_INDENT));
                    Intrinsics.checkNotNullExpressionValue(append8, "append(...)");
                    Intrinsics.checkNotNullExpressionValue(append8.append('\n'), "append(...)");
                }
                $this$builderString_u24lambda_u243.append("}, ");
                r3 = false;
            }
            if ($this$builderString_u24lambda_u243.charAt($this$builderString_u24lambda_u243.length() - 2) == ',') {
                int i = 0;
                for (int i2 = 2; i < i2; i2 = 2) {
                    Intrinsics.checkNotNullExpressionValue($this$builderString_u24lambda_u243.deleteCharAt($this$builderString_u24lambda_u243.length() - 1), "deleteCharAt(...)");
                    i++;
                }
            }
            StringBuilder append9 = $this$builderString_u24lambda_u243.append(") {");
            Intrinsics.checkNotNullExpressionValue(append9, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append9.append('\n'), "append(...)");
            StringBuilder append10 = $this$builderString_u24lambda_u243.append(StringsKt.prependIndent(builderString(((AlternativesParsingFormatStructure) formatStructure).getMainFormat(), constants), CODE_INDENT));
            Intrinsics.checkNotNullExpressionValue(append10, "append(...)");
            Intrinsics.checkNotNullExpressionValue(append10.append('\n'), "append(...)");
            $this$builderString_u24lambda_u243.append("}");
            String sb3 = $this$builderString_u24lambda_u243.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            return sb3;
        } else if (!(formatStructure instanceof ConcatenatedFormatStructure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            StringBuilder $this$builderString_u24lambda_u244 = new StringBuilder();
            if (!((ConcatenatedFormatStructure) formatStructure).getFormats().isEmpty()) {
                int index = 0;
                while (index < ((ConcatenatedFormatStructure) formatStructure).getFormats().size()) {
                    Iterator<? extends Pair<String, ? extends CachedFormatStructure<?>>> it = constants.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Pair constant = it.next();
                        List constantDirectives = ((CachedFormatStructure) constant.getSecond()).getFormats();
                        if (((ConcatenatedFormatStructure) formatStructure).getFormats().size() - index >= constantDirectives.size()) {
                            int size = constantDirectives.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                if (!Intrinsics.areEqual(((ConcatenatedFormatStructure) formatStructure).getFormats().get(index + i3), constantDirectives.get(i3))) {
                                    break;
                                }
                            }
                            $this$builderString_u24lambda_u244.append((String) constant.getFirst());
                            index += constantDirectives.size();
                            if (index < ((ConcatenatedFormatStructure) formatStructure).getFormats().size()) {
                                Intrinsics.checkNotNullExpressionValue($this$builderString_u24lambda_u244.append('\n'), "append(...)");
                            }
                        }
                    }
                }
            }
            String sb4 = $this$builderString_u24lambda_u244.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
            return sb4;
        }
    }
}