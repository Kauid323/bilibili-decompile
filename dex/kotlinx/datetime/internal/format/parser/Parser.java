package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.Copyable;

/* compiled from: Parser.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001(B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0017J^\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001b0\u001e2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b0!H\u0082\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\b\u0012\u0004\u0012\u0002H\u00010\u0005¨\u0006)"}, d2 = {"Lkotlinx/datetime/internal/format/parser/Parser;", "Output", "Lkotlinx/datetime/internal/format/parser/Copyable;", "", "commands", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "constructor-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;)Lkotlinx/datetime/internal/format/parser/ParserStructure;", "equals", "", "other", "equals-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;)I", "match", "input", "", "initialContainer", "startIndex", "match-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;Ljava/lang/CharSequence;Lkotlinx/datetime/internal/format/parser/Copyable;I)Lkotlinx/datetime/internal/format/parser/Copyable;", "matchOrNull", "matchOrNull-impl", "parse", "", "allowDanglingInput", "onError", "Lkotlin/Function1;", "Lkotlinx/datetime/internal/format/parser/ParseError;", "onSuccess", "Lkotlin/Function2;", "parse-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;Ljava/lang/CharSequence;ILkotlinx/datetime/internal/format/parser/Copyable;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "toString", "", "toString-impl", "(Lkotlinx/datetime/internal/format/parser/ParserStructure;)Ljava/lang/String;", "ParserState", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class Parser<Output extends Copyable<Output>> {
    private final ParserStructure<Output> commands;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Parser m1502boximpl(ParserStructure parserStructure) {
        return new Parser(parserStructure);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: constructor-impl  reason: not valid java name */
    public static <Output extends Copyable<Output>> ParserStructure<Output> m1503constructorimpl(ParserStructure<? super Output> commands) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        return commands;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1504equalsimpl(ParserStructure<? super Output> parserStructure, Object obj) {
        return (obj instanceof Parser) && Intrinsics.areEqual(parserStructure, ((Parser) obj).m1513unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1505equalsimpl0(ParserStructure<? super Output> parserStructure, ParserStructure<? super Output> parserStructure2) {
        return Intrinsics.areEqual(parserStructure, parserStructure2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1506hashCodeimpl(ParserStructure<? super Output> parserStructure) {
        return parserStructure.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1512toStringimpl(ParserStructure<? super Output> parserStructure) {
        return "Parser(commands=" + parserStructure + ')';
    }

    public boolean equals(Object obj) {
        return m1504equalsimpl(this.commands, obj);
    }

    public int hashCode() {
        return m1506hashCodeimpl(this.commands);
    }

    public String toString() {
        return m1512toStringimpl(this.commands);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ ParserStructure m1513unboximpl() {
        return this.commands;
    }

    private /* synthetic */ Parser(ParserStructure commands) {
        this.commands = commands;
    }

    /* renamed from: parse-impl  reason: not valid java name */
    private static final void m1511parseimpl(ParserStructure<? super Output> parserStructure, CharSequence input, int startIndex, Output output, boolean allowDanglingInput, Function1<? super ParseError, Unit> function1, Function2<? super Integer, ? super Output, Unit> function2) {
        int i;
        int i2 = 0;
        List parseOptions = CollectionsKt.mutableListOf(new ParserState(output, parserStructure, startIndex));
        while (true) {
            ParserState state = (ParserState) CollectionsKt.removeLastOrNull(parseOptions);
            if (state != null) {
                Copyable output2 = (Copyable) ((Copyable) state.getOutput()).copy();
                int inputPosition = state.getInputPosition();
                ParserStructure parserStructure2 = state.getParserStructure();
                int ix = 0;
                int size = parserStructure2.getOperations().size();
                while (true) {
                    if (ix < size) {
                        Object arg0$iv = ((ParserOperation) parserStructure2.getOperations().get(ix)).mo1490consumeFANa98k(output2, input, inputPosition);
                        i = i2;
                        if (arg0$iv instanceof Integer) {
                            int it = ((Number) arg0$iv).intValue();
                            inputPosition = it;
                            ix++;
                            i2 = i;
                        } else if (arg0$iv instanceof ParseError) {
                            ParseError it2 = (ParseError) arg0$iv;
                            function1.invoke(it2);
                        } else {
                            throw new IllegalStateException(("Unexpected parse result: " + arg0$iv).toString());
                        }
                    } else {
                        i = i2;
                        if (!parserStructure2.getFollowedBy().isEmpty()) {
                            int size2 = parserStructure2.getFollowedBy().size() - 1;
                            if (size2 >= 0) {
                                do {
                                    int ix2 = size2;
                                    size2--;
                                    parseOptions.add(new ParserState(output2, (ParserStructure) parserStructure2.getFollowedBy().get(ix2), inputPosition));
                                } while (size2 >= 0);
                            }
                        } else if (allowDanglingInput || inputPosition == input.length()) {
                            function2.invoke(Integer.valueOf(inputPosition), output2);
                        } else {
                            function1.invoke(new ParseError(inputPosition, Parser$parse$1$3.INSTANCE));
                        }
                    }
                }
            } else {
                return;
            }
            i2 = i;
        }
    }

    /* renamed from: match-impl$default  reason: not valid java name */
    public static /* synthetic */ Copyable m1508matchimpl$default(ParserStructure parserStructure, CharSequence charSequence, Copyable copyable, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m1507matchimpl(parserStructure, charSequence, copyable, i);
    }

    /* renamed from: match-impl  reason: not valid java name */
    public static final Output m1507matchimpl(ParserStructure<? super Output> parserStructure, CharSequence input, Output initialContainer, int startIndex) {
        boolean allowDanglingInput$iv;
        CharSequence input2 = input;
        Intrinsics.checkNotNullParameter(input2, "input");
        Intrinsics.checkNotNullParameter(initialContainer, "initialContainer");
        List errors = new ArrayList();
        boolean allowDanglingInput$iv2 = false;
        int i = 1;
        List parseOptions$iv = CollectionsKt.mutableListOf(new ParserState(initialContainer, parserStructure, startIndex));
        while (true) {
            ParserState state$iv = (ParserState) CollectionsKt.removeLastOrNull(parseOptions$iv);
            if (state$iv == null) {
                if (errors.size() > i) {
                    CollectionsKt.sortWith(errors, new Comparator() { // from class: kotlinx.datetime.internal.format.parser.Parser$match-impl$$inlined$sortByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            ParseError it = (ParseError) t2;
                            ParseError it2 = (ParseError) t;
                            return ComparisonsKt.compareValues(Integer.valueOf(it.getPosition()), Integer.valueOf(it2.getPosition()));
                        }
                    });
                }
                throw new ParseException(errors);
            }
            Output output = (Output) ((Copyable) state$iv.getOutput()).copy();
            int inputPosition$iv = state$iv.getInputPosition();
            ParserStructure parserStructure$iv = state$iv.getParserStructure();
            int ix$iv = 0;
            int size = parserStructure$iv.getOperations().size();
            while (true) {
                if (ix$iv < size) {
                    Object arg0$iv$iv = ((ParserOperation) parserStructure$iv.getOperations().get(ix$iv)).mo1490consumeFANa98k(output, input2, inputPosition$iv);
                    if (arg0$iv$iv instanceof Integer) {
                        int it$iv = ((Number) arg0$iv$iv).intValue();
                        inputPosition$iv = it$iv;
                        ix$iv++;
                        input2 = input;
                    } else if (!(arg0$iv$iv instanceof ParseError)) {
                        throw new IllegalStateException(("Unexpected parse result: " + arg0$iv$iv).toString());
                    } else {
                        ParseError it = (ParseError) arg0$iv$iv;
                        errors.add(it);
                        allowDanglingInput$iv = allowDanglingInput$iv2;
                    }
                } else {
                    allowDanglingInput$iv = allowDanglingInput$iv2;
                    if (!parserStructure$iv.getFollowedBy().isEmpty()) {
                        int size2 = parserStructure$iv.getFollowedBy().size() - 1;
                        if (size2 >= 0) {
                            do {
                                int ix$iv2 = size2;
                                size2--;
                                parseOptions$iv.add(new ParserState(output, (ParserStructure) parserStructure$iv.getFollowedBy().get(ix$iv2), inputPosition$iv));
                            } while (size2 >= 0);
                        }
                    } else if (inputPosition$iv == input.length()) {
                        return output;
                    } else {
                        ParseError it2 = new ParseError(inputPosition$iv, Parser$parse$1$3.INSTANCE);
                        errors.add(it2);
                    }
                }
            }
            input2 = input;
            allowDanglingInput$iv2 = allowDanglingInput$iv;
            i = 1;
        }
    }

    /* renamed from: matchOrNull-impl$default  reason: not valid java name */
    public static /* synthetic */ Copyable m1510matchOrNullimpl$default(ParserStructure parserStructure, CharSequence charSequence, Copyable copyable, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m1509matchOrNullimpl(parserStructure, charSequence, copyable, i);
    }

    /* renamed from: matchOrNull-impl  reason: not valid java name */
    public static final Output m1509matchOrNullimpl(ParserStructure<? super Output> parserStructure, CharSequence input, Output initialContainer, int startIndex) {
        CharSequence input2 = input;
        Intrinsics.checkNotNullParameter(input2, "input");
        Intrinsics.checkNotNullParameter(initialContainer, "initialContainer");
        List parseOptions$iv = CollectionsKt.mutableListOf(new ParserState(initialContainer, parserStructure, startIndex));
        while (true) {
            ParserState state$iv = (ParserState) CollectionsKt.removeLastOrNull(parseOptions$iv);
            if (state$iv == null) {
                return null;
            }
            Output output = (Output) ((Copyable) state$iv.getOutput()).copy();
            int inputPosition$iv = state$iv.getInputPosition();
            ParserStructure parserStructure$iv = state$iv.getParserStructure();
            int ix$iv = 0;
            int size = parserStructure$iv.getOperations().size();
            while (true) {
                if (ix$iv < size) {
                    Object arg0$iv$iv = ((ParserOperation) parserStructure$iv.getOperations().get(ix$iv)).mo1490consumeFANa98k(output, input2, inputPosition$iv);
                    if (arg0$iv$iv instanceof Integer) {
                        int it$iv = ((Number) arg0$iv$iv).intValue();
                        inputPosition$iv = it$iv;
                        ix$iv++;
                        input2 = input;
                    } else if (!(arg0$iv$iv instanceof ParseError)) {
                        throw new IllegalStateException(("Unexpected parse result: " + arg0$iv$iv).toString());
                    } else {
                        ParseError parseError = (ParseError) arg0$iv$iv;
                    }
                } else if (parserStructure$iv.getFollowedBy().isEmpty()) {
                    if (inputPosition$iv == input.length()) {
                        return output;
                    }
                    new ParseError(inputPosition$iv, Parser$parse$1$3.INSTANCE);
                } else {
                    int size2 = parserStructure$iv.getFollowedBy().size() - 1;
                    if (size2 >= 0) {
                        do {
                            int ix$iv2 = size2;
                            size2--;
                            parseOptions$iv.add(new ParserState(output, (ParserStructure) parserStructure$iv.getFollowedBy().get(ix$iv2), inputPosition$iv));
                        } while (size2 >= 0);
                    }
                }
            }
            input2 = input;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Parser.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/internal/format/parser/Parser$ParserState;", "Output", "", "output", "parserStructure", "Lkotlinx/datetime/internal/format/parser/ParserStructure;", "inputPosition", "", "(Ljava/lang/Object;Lkotlinx/datetime/internal/format/parser/ParserStructure;I)V", "getInputPosition", "()I", "getOutput", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getParserStructure", "()Lkotlinx/datetime/internal/format/parser/ParserStructure;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ParserState<Output> {
        private final int inputPosition;
        private final Output output;
        private final ParserStructure<Output> parserStructure;

        /* JADX WARN: Multi-variable type inference failed */
        public ParserState(Output output, ParserStructure<? super Output> parserStructure, int inputPosition) {
            Intrinsics.checkNotNullParameter(parserStructure, "parserStructure");
            this.output = output;
            this.parserStructure = parserStructure;
            this.inputPosition = inputPosition;
        }

        public final Output getOutput() {
            return this.output;
        }

        public final ParserStructure<Output> getParserStructure() {
            return this.parserStructure;
        }

        public final int getInputPosition() {
            return this.inputPosition;
        }
    }
}