package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Parser.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0003H\u0000¨\u0006\b"}, d2 = {"formatError", "", "errors", "", "Lkotlinx/datetime/internal/format/parser/ParseError;", "concat", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "T", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ParserKt {
    private static final <T> ParserStructure<T> concat$append(ParserStructure<? super T> parserStructure, ParserStructure<? super T> parserStructure2) {
        if (parserStructure.getFollowedBy().isEmpty()) {
            return new ParserStructure<>(CollectionsKt.plus((Collection) parserStructure.getOperations(), (Iterable) parserStructure2.getOperations()), parserStructure2.getFollowedBy());
        }
        List<ParserOperation<? super T>> operations = parserStructure.getOperations();
        Iterable $this$map$iv = parserStructure.getFollowedBy();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ParserStructure it = (ParserStructure) item$iv$iv;
            destination$iv$iv.add(concat$append(it, parserStructure2));
        }
        return new ParserStructure<>(operations, (List) destination$iv$iv);
    }

    private static final <T> ParserStructure<T> concat$simplify(ParserStructure<? super T> parserStructure, List<UnconditionalModification<T>> list) {
        boolean z;
        ParserStructure it;
        List unconditionalModificationsForTails;
        List mergedTails;
        ParserStructure parserStructure2;
        List listOf;
        List newOperations = new ArrayList();
        List unconditionalModificationsForTails2 = null;
        List unconditionalModificationsForTails3 = CollectionsKt.toMutableList((Collection) list);
        for (ParserOperation op : parserStructure.getOperations()) {
            if (op instanceof NumberSpanParserOperation) {
                if (unconditionalModificationsForTails2 != null) {
                    unconditionalModificationsForTails2.addAll(((NumberSpanParserOperation) op).getConsumers());
                } else {
                    unconditionalModificationsForTails2 = CollectionsKt.toMutableList((Collection) ((NumberSpanParserOperation) op).getConsumers());
                }
            } else if (op instanceof UnconditionalModification) {
                unconditionalModificationsForTails3.add(op);
            } else {
                if (unconditionalModificationsForTails2 != null) {
                    newOperations.add(new NumberSpanParserOperation(unconditionalModificationsForTails2));
                    unconditionalModificationsForTails2 = null;
                }
                newOperations.add(op);
            }
        }
        Iterable $this$flatMap$iv = parserStructure.getFollowedBy();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            ParserStructure simplified = concat$simplify((ParserStructure) element$iv$iv, unconditionalModificationsForTails3);
            if (simplified.getOperations().isEmpty()) {
                List followedBy = simplified.getFollowedBy();
                if (followedBy.isEmpty()) {
                    followedBy = CollectionsKt.listOf(simplified);
                }
                listOf = followedBy;
            } else {
                listOf = CollectionsKt.listOf(simplified);
            }
            Iterable list$iv$iv = listOf;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Collection collection = (List) destination$iv$iv;
        if (collection.isEmpty()) {
            collection = CollectionsKt.listOf(new ParserStructure(unconditionalModificationsForTails3, CollectionsKt.emptyList()));
        }
        List mergedTails2 = collection;
        if (unconditionalModificationsForTails2 == null) {
            return new ParserStructure<>(newOperations, mergedTails2);
        }
        List $this$none$iv = mergedTails2;
        if (!($this$none$iv instanceof Collection) || !$this$none$iv.isEmpty()) {
            Iterator<T> it2 = $this$none$iv.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object element$iv = it2.next();
                    ParserOperation it3 = (ParserOperation) CollectionsKt.firstOrNull((List<? extends Object>) ((ParserStructure) element$iv).getOperations());
                    z = false;
                    if (it3 == null || !(it3 instanceof NumberSpanParserOperation)) {
                        it = null;
                        continue;
                    } else {
                        it = 1;
                        continue;
                    }
                    if (it != null) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            newOperations.add(new NumberSpanParserOperation(unconditionalModificationsForTails2));
            return new ParserStructure<>(newOperations, mergedTails2);
        }
        List $this$map$iv = mergedTails2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ParserStructure it4 = (ParserStructure) item$iv$iv;
            ParserOperation firstOperation = (ParserOperation) CollectionsKt.firstOrNull((List<? extends Object>) it4.getOperations());
            if (firstOperation instanceof NumberSpanParserOperation) {
                unconditionalModificationsForTails = unconditionalModificationsForTails3;
                mergedTails = mergedTails2;
                parserStructure2 = new ParserStructure(CollectionsKt.plus((Collection) CollectionsKt.listOf(new NumberSpanParserOperation(CollectionsKt.plus((Collection) unconditionalModificationsForTails2, (Iterable) ((NumberSpanParserOperation) firstOperation).getConsumers()))), (Iterable) CollectionsKt.drop(it4.getOperations(), 1)), it4.getFollowedBy());
            } else {
                unconditionalModificationsForTails = unconditionalModificationsForTails3;
                mergedTails = mergedTails2;
                if (firstOperation == null) {
                    parserStructure2 = new ParserStructure(CollectionsKt.listOf(new NumberSpanParserOperation(unconditionalModificationsForTails2)), it4.getFollowedBy());
                } else {
                    parserStructure2 = new ParserStructure(CollectionsKt.plus((Collection) CollectionsKt.listOf(new NumberSpanParserOperation(unconditionalModificationsForTails2)), (Iterable) it4.getOperations()), it4.getFollowedBy());
                }
            }
            destination$iv$iv2.add(parserStructure2);
            unconditionalModificationsForTails3 = unconditionalModificationsForTails;
            mergedTails2 = mergedTails;
        }
        List newTails = (List) destination$iv$iv2;
        return new ParserStructure<>(newOperations, newTails);
    }

    public static final <T> ParserStructure<T> concat(List<? extends ParserStructure<? super T>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ParserStructure parserStructure = new ParserStructure(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        if (!list.isEmpty()) {
            ListIterator iterator$iv = list.listIterator(list.size());
            while (iterator$iv.hasPrevious()) {
                ParserStructure<? super T> parser = iterator$iv.previous();
                ParserStructure acc = parserStructure;
                parserStructure = concat$append(parser, acc);
            }
        }
        ParserStructure naiveParser = parserStructure;
        return concat$simplify(naiveParser, CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatError(List<ParseError> list) {
        Appendable joinTo;
        if (list.size() == 1) {
            return "Position " + list.get(0).getPosition() + ": " + list.get(0).getMessage().invoke();
        }
        joinTo = CollectionsKt.joinTo(list, new StringBuilder(list.size() * 33), (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "Errors: ", (r14 & 8) != 0 ? "" : null, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1<ParseError, CharSequence>() { // from class: kotlinx.datetime.internal.format.parser.ParserKt$formatError$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(ParseError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "position " + it.getPosition() + ": '" + it.getMessage().invoke() + '\'';
            }
        });
        String sb = ((StringBuilder) joinTo).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}