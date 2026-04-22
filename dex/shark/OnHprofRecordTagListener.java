package shark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;

/* compiled from: OnHprofRecordTagListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \n2\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lshark/OnHprofRecordTagListener;", "", "onHprofRecord", "", AppConfig.HOST_TAG, "Lshark/HprofRecordTag;", "length", "", "reader", "Lshark/HprofRecordReader;", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public interface OnHprofRecordTagListener {
    public static final Companion Companion = Companion.$$INSTANCE;

    void onHprofRecord(HprofRecordTag hprofRecordTag, long j, HprofRecordReader hprofRecordReader);

    /* compiled from: OnHprofRecordTagListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042 \b\u0004\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006H\u0086\n¨\u0006\u000b"}, d2 = {"Lshark/OnHprofRecordTagListener$Companion;", "", "()V", "invoke", "Lshark/OnHprofRecordTagListener;", "block", "Lkotlin/Function3;", "Lshark/HprofRecordTag;", "", "Lshark/HprofRecordReader;", "", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final OnHprofRecordTagListener invoke(final Function3<? super HprofRecordTag, ? super Long, ? super HprofRecordReader, Unit> function3) {
            Intrinsics.checkParameterIsNotNull(function3, "block");
            return new OnHprofRecordTagListener() { // from class: shark.OnHprofRecordTagListener$Companion$invoke$1
                @Override // shark.OnHprofRecordTagListener
                public final void onHprofRecord(HprofRecordTag tag, long length, HprofRecordReader reader) {
                    Intrinsics.checkParameterIsNotNull(tag, AppConfig.HOST_TAG);
                    Intrinsics.checkParameterIsNotNull(reader, "reader");
                    function3.invoke(tag, Long.valueOf(length), reader);
                }
            };
        }
    }
}