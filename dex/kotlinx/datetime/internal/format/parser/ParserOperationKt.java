package kotlinx.datetime.internal.format.parser;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.cli.HelpFormatter;
import org.slf4j.Marker;

/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a@\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a]\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0010\u000f\u001a]\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0001\"\u0004\b\u0000\u0010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0010\u0014\u001aI\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u00072\u0006\u0010\u0019\u001a\u0002H\u00172\u0006\u0010\u001a\u001a\u0002H\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"ReducedIntParser", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "Output", "digits", "", "base", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "name", "", "SignedIntParser", "minDigits", "maxDigits", "spacePadding", "plusOnExceedsWidth", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;Ljava/lang/Integer;)Lkotlinx/datetime/internal/format/parser/ParserStructure;", "spaceAndZeroPaddedUnsignedInt", "Target", "withMinus", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;Z)Lkotlinx/datetime/internal/format/parser/ParserStructure;", "setWithoutReassigning", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "Object", "Type", "receiver", "value", "position", "nextIndex", "(Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/Object;Ljava/lang/Object;II)Ljava/lang/Object;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ParserOperationKt {
    public static final /* synthetic */ Object access$setWithoutReassigning(AssignableField $receiver, Object receiver, Object value, int position, int nextIndex) {
        return setWithoutReassigning($receiver, receiver, value, position, nextIndex);
    }

    public static final <Output> ParserStructure<Output> SignedIntParser(Integer minDigits, Integer maxDigits, Integer spacePadding, AssignableField<? super Output, Integer> setter, String name, Integer plusOnExceedsWidth) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        List parsers = CollectionsKt.mutableListOf(spaceAndZeroPaddedUnsignedInt(minDigits, maxDigits, spacePadding, setter, name, true));
        if (plusOnExceedsWidth != null) {
            parsers.add(spaceAndZeroPaddedUnsignedInt$default(minDigits, plusOnExceedsWidth, spacePadding, setter, name, false, 32, null));
            parsers.add(new ParserStructure(CollectionsKt.listOf((Object[]) new ParserOperation[]{new PlainStringParserOperation(Marker.ANY_NON_NULL_MARKER), new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(Integer.valueOf(plusOnExceedsWidth.intValue() + 1), maxDigits, setter, name, false)))}), CollectionsKt.emptyList()));
        } else {
            parsers.add(spaceAndZeroPaddedUnsignedInt$default(minDigits, maxDigits, spacePadding, setter, name, false, 32, null));
        }
        return new ParserStructure<>(CollectionsKt.emptyList(), parsers);
    }

    public static /* synthetic */ ParserStructure spaceAndZeroPaddedUnsignedInt$default(Integer num, Integer num2, Integer num3, AssignableField assignableField, String str, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 32) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return spaceAndZeroPaddedUnsignedInt(num, num2, num3, assignableField, str, z2);
    }

    public static final <Target> ParserStructure<Target> spaceAndZeroPaddedUnsignedInt(Integer minDigits, Integer maxDigits, Integer spacePadding, AssignableField<? super Target, Integer> setter, String name, boolean withMinus) {
        int it;
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        int minNumberLength = (minDigits != null ? minDigits.intValue() : 1) + (withMinus ? 1 : 0);
        if (maxDigits != null) {
            it = maxDigits.intValue();
            if (withMinus) {
                it++;
            }
        } else {
            it = Integer.MAX_VALUE;
        }
        char c = 0;
        int spacePadding2 = spacePadding != null ? spacePadding.intValue() : 0;
        int maxPaddedNumberLength = Math.min(it, spacePadding2);
        if (minNumberLength >= maxPaddedNumberLength) {
            return spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(withMinus, setter, name, minNumberLength, it);
        }
        ParserStructure accumulated = spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(withMinus, setter, name, minNumberLength, minNumberLength);
        int accumulatedWidth = minNumberLength;
        while (accumulatedWidth < maxPaddedNumberLength) {
            List emptyList = CollectionsKt.emptyList();
            ParserStructure[] parserStructureArr = new ParserStructure[2];
            parserStructureArr[c] = spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(withMinus, setter, name, accumulatedWidth + 1, accumulatedWidth + 1);
            parserStructureArr[1] = ParserKt.concat(CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(new PlainStringParserOperation(" ")), CollectionsKt.emptyList()), accumulated}));
            accumulated = new ParserStructure(emptyList, CollectionsKt.listOf((Object[]) parserStructureArr));
            accumulatedWidth++;
            c = 0;
        }
        if (spacePadding2 > it) {
            PlainStringParserOperation prepadding = new PlainStringParserOperation(StringsKt.repeat(" ", spacePadding2 - it));
            ParserStructure r = ParserKt.concat(CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(prepadding), CollectionsKt.emptyList()), accumulated}));
            return r;
        } else if (spacePadding2 == it) {
            ParserStructure r2 = accumulated;
            return r2;
        } else {
            ParserStructure r3 = new ParserStructure(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new ParserStructure[]{spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(withMinus, setter, name, spacePadding2 + 1, it), accumulated}));
            return r3;
        }
    }

    private static final <Target> ParserStructure<Target> spaceAndZeroPaddedUnsignedInt$numberOfRequiredLengths(boolean $withMinus, AssignableField<? super Target, Integer> assignableField, String $name, int minNumberLength, int maxNumberLength) {
        if (!(maxNumberLength >= ($withMinus ? 1 : 0) + 1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        List $this$spaceAndZeroPaddedUnsignedInt_u24numberOfRequiredLengths_u24lambda_u241 = CollectionsKt.createListBuilder();
        if ($withMinus) {
            $this$spaceAndZeroPaddedUnsignedInt_u24numberOfRequiredLengths_u24lambda_u241.add(new PlainStringParserOperation(HelpFormatter.DEFAULT_OPT_PREFIX));
        }
        $this$spaceAndZeroPaddedUnsignedInt_u24numberOfRequiredLengths_u24lambda_u241.add(new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(Integer.valueOf(minNumberLength - ($withMinus ? 1 : 0)), Integer.valueOf(maxNumberLength - ($withMinus ? 1 : 0)), assignableField, $name, $withMinus))));
        return new ParserStructure<>(CollectionsKt.build($this$spaceAndZeroPaddedUnsignedInt_u24numberOfRequiredLengths_u24lambda_u241), CollectionsKt.emptyList());
    }

    public static final <Output> ParserStructure<Output> ReducedIntParser(int digits, int base, AssignableField<? super Output, Integer> setter, String name) {
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ParserStructure<>(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new ParserStructure[]{new ParserStructure(CollectionsKt.listOf(new NumberSpanParserOperation(CollectionsKt.listOf(new ReducedIntConsumer(digits, setter, name, base)))), CollectionsKt.emptyList()), new ParserStructure(CollectionsKt.listOf((Object[]) new ParserOperation[]{new PlainStringParserOperation(Marker.ANY_NON_NULL_MARKER), new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(null, null, setter, name, false)))}), CollectionsKt.emptyList()), new ParserStructure(CollectionsKt.listOf((Object[]) new ParserOperation[]{new PlainStringParserOperation(HelpFormatter.DEFAULT_OPT_PREFIX), new NumberSpanParserOperation(CollectionsKt.listOf(new UnsignedIntConsumer(null, null, setter, name, true)))}), CollectionsKt.emptyList())}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <Object, Type> Object setWithoutReassigning(final AssignableField<? super Object, Type> assignableField, Object object, final Type type, int position, int nextIndex) {
        final Object conflictingValue = assignableField.trySetWithoutReassigning(object, type);
        if (conflictingValue == null) {
            return ParseResult.Companion.m1501OkQi1bsqg(nextIndex);
        }
        return ParseResult.Companion.m1500ErrorRg3Co2E(position, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.ParserOperationKt$setWithoutReassigning$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ String invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final String invoke2() {
                return "Attempting to assign conflicting values '" + conflictingValue + "' and '" + type + "' to field '" + assignableField.getName() + '\'';
            }
        });
    }
}