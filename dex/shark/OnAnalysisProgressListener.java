package shark;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import shark.OnAnalysisProgressListener;

/* compiled from: OnAnalysisProgressListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lshark/OnAnalysisProgressListener;", "", "onAnalysisProgress", "", "step", "Lshark/OnAnalysisProgressListener$Step;", "Companion", "Step", "shark"}, k = 1, mv = {1, 4, 1})
public interface OnAnalysisProgressListener {
    public static final Companion Companion = Companion.$$INSTANCE;

    void onAnalysisProgress(Step step);

    /* compiled from: OnAnalysisProgressListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lshark/OnAnalysisProgressListener$Step;", "", "(Ljava/lang/String;I)V", "humanReadableName", "", "getHumanReadableName", "()Ljava/lang/String;", "PARSING_HEAP_DUMP", "EXTRACTING_METADATA", "FINDING_RETAINED_OBJECTS", "FINDING_PATHS_TO_RETAINED_OBJECTS", "FINDING_DOMINATORS", "INSPECTING_OBJECTS", "COMPUTING_NATIVE_RETAINED_SIZE", "COMPUTING_RETAINED_SIZE", "BUILDING_LEAK_TRACES", "REPORTING_HEAP_ANALYSIS", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum Step {
        PARSING_HEAP_DUMP,
        EXTRACTING_METADATA,
        FINDING_RETAINED_OBJECTS,
        FINDING_PATHS_TO_RETAINED_OBJECTS,
        FINDING_DOMINATORS,
        INSPECTING_OBJECTS,
        COMPUTING_NATIVE_RETAINED_SIZE,
        COMPUTING_RETAINED_SIZE,
        BUILDING_LEAK_TRACES,
        REPORTING_HEAP_ANALYSIS;
        
        private final String humanReadableName;

        Step() {
            String replace$default = StringsKt.replace$default(name(), "_", " ", false, 4, (Object) null);
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (replace$default == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowercaseName = replace$default.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowercaseName, "(this as java.lang.String).toLowerCase(locale)");
            StringBuilder sb = new StringBuilder();
            if (lowercaseName == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = lowercaseName.substring(0, 1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Locale locale2 = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
            if (substring == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = substring.toUpperCase(locale2);
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            StringBuilder append = sb.append(upperCase);
            if (lowercaseName == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring2 = lowercaseName.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
            this.humanReadableName = append.append(substring2).toString();
        }

        public final String getHumanReadableName() {
            return this.humanReadableName;
        }
    }

    /* compiled from: OnAnalysisProgressListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0007\u001a\u00020\u00042\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0086\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lshark/OnAnalysisProgressListener$Companion;", "", "()V", "NO_OP", "Lshark/OnAnalysisProgressListener;", "getNO_OP", "()Lshark/OnAnalysisProgressListener;", "invoke", "block", "Lkotlin/Function1;", "Lshark/OnAnalysisProgressListener$Step;", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final OnAnalysisProgressListener NO_OP = new OnAnalysisProgressListener() { // from class: shark.OnAnalysisProgressListener$Companion$NO_OP$1
            @Override // shark.OnAnalysisProgressListener
            public final void onAnalysisProgress(OnAnalysisProgressListener.Step it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
            }
        };

        private Companion() {
        }

        public final OnAnalysisProgressListener getNO_OP() {
            return NO_OP;
        }

        public final OnAnalysisProgressListener invoke(final Function1<? super Step, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "block");
            return new OnAnalysisProgressListener() { // from class: shark.OnAnalysisProgressListener$Companion$invoke$1
                @Override // shark.OnAnalysisProgressListener
                public final void onAnalysisProgress(OnAnalysisProgressListener.Step step) {
                    Intrinsics.checkParameterIsNotNull(step, "step");
                    function1.invoke(step);
                }
            };
        }
    }
}