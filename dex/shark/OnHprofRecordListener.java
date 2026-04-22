package shark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnHprofRecordListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lshark/OnHprofRecordListener;", "", "onHprofRecord", "", "position", "", "record", "Lshark/HprofRecord;", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public interface OnHprofRecordListener {
    public static final Companion Companion = Companion.$$INSTANCE;

    void onHprofRecord(long j, HprofRecord hprofRecord);

    /* compiled from: OnHprofRecordListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u001a\b\u0004\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006H\u0086\n¨\u0006\n"}, d2 = {"Lshark/OnHprofRecordListener$Companion;", "", "()V", "invoke", "Lshark/OnHprofRecordListener;", "block", "Lkotlin/Function2;", "", "Lshark/HprofRecord;", "", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final OnHprofRecordListener invoke(final Function2<? super Long, ? super HprofRecord, Unit> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "block");
            return new OnHprofRecordListener() { // from class: shark.OnHprofRecordListener$Companion$invoke$1
                @Override // shark.OnHprofRecordListener
                public final void onHprofRecord(long position, HprofRecord record) {
                    Intrinsics.checkParameterIsNotNull(record, "record");
                    function2.invoke(Long.valueOf(position), record);
                }
            };
        }
    }
}