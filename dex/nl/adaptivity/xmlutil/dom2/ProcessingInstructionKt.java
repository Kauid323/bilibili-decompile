package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessingInstruction.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"*\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"target", "", "Lnl/adaptivity/xmlutil/dom2/ProcessingInstruction;", "getTarget", "(Lnl/adaptivity/xmlutil/dom2/ProcessingInstruction;)Ljava/lang/String;", "value", "data", "getData", "setData", "(Lnl/adaptivity/xmlutil/dom2/ProcessingInstruction;Ljava/lang/String;)V", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ProcessingInstructionKt {
    public static final String getTarget(ProcessingInstruction $this$target) {
        Intrinsics.checkNotNullParameter($this$target, "<this>");
        return $this$target.getTarget();
    }

    public static final String getData(ProcessingInstruction $this$data) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        return $this$data.getData();
    }

    public static final void setData(ProcessingInstruction $this$data, String value) {
        Intrinsics.checkNotNullParameter($this$data, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$data.setData(value);
    }
}