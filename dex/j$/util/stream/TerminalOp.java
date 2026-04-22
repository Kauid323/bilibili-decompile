package j$.util.stream;

import j$.util.Spliterator;

interface TerminalOp<E_IN, R> {
    <P_IN> R evaluateParallel(PipelineHelper<E_IN> pipelineHelper, Spliterator<P_IN> spliterator);

    <P_IN> R evaluateSequential(PipelineHelper<E_IN> pipelineHelper, Spliterator<P_IN> spliterator);

    int getOpFlags();

    StreamShape inputShape();

    /* renamed from: j$.util.stream.TerminalOp$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static int $default$getOpFlags(TerminalOp _this) {
            return 0;
        }

        /* JADX WARN: Generic types in debug info not equals: j$.util.Spliterator != java.util.Spliterator<P_IN> */
        /* JADX WARN: Generic types in debug info not equals: j$.util.stream.PipelineHelper != java.util.stream.PipelineHelper<E_IN> */
        public static Object $default$evaluateParallel(TerminalOp _this, PipelineHelper pipelineHelper, Spliterator spliterator) {
            if (Tripwire.ENABLED) {
                Tripwire.trip(_this.getClass(), "{0} triggering TerminalOp.evaluateParallel serial default");
            }
            return _this.evaluateSequential(pipelineHelper, spliterator);
        }
    }
}