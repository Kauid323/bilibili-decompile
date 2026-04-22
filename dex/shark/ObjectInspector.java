package shark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObjectInspector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lshark/ObjectInspector;", "", "inspect", "", "reporter", "Lshark/ObjectReporter;", "Companion", "shark"}, k = 1, mv = {1, 4, 1})
public interface ObjectInspector {
    public static final Companion Companion = Companion.$$INSTANCE;

    void inspect(ObjectReporter objectReporter);

    /* compiled from: ObjectInspector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\n¨\u0006\t"}, d2 = {"Lshark/ObjectInspector$Companion;", "", "()V", "invoke", "Lshark/ObjectInspector;", "block", "Lkotlin/Function1;", "Lshark/ObjectReporter;", "", "shark"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final ObjectInspector invoke(final Function1<? super ObjectReporter, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "block");
            return new ObjectInspector() { // from class: shark.ObjectInspector$Companion$invoke$1
                @Override // shark.ObjectInspector
                public final void inspect(ObjectReporter reporter) {
                    Intrinsics.checkParameterIsNotNull(reporter, "reporter");
                    function1.invoke(reporter);
                }
            };
        }
    }
}