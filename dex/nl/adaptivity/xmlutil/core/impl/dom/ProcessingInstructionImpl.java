package nl.adaptivity.xmlutil.core.impl.dom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.core.impl.idom.IProcessingInstruction;
import org.w3c.dom.ProcessingInstruction;

/* compiled from: ProcessingInstructionImpl.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\r"}, d2 = {"Lnl/adaptivity/xmlutil/core/impl/dom/ProcessingInstructionImpl;", "Lnl/adaptivity/xmlutil/core/impl/dom/NodeImpl;", "Lorg/w3c/dom/ProcessingInstruction;", "Lnl/adaptivity/xmlutil/core/impl/idom/IProcessingInstruction;", "delegate", "<init>", "(Lorg/w3c/dom/ProcessingInstruction;)V", "getTarget", "", "getData", "setData", "", "data", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProcessingInstructionImpl extends NodeImpl<ProcessingInstruction> implements IProcessingInstruction {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessingInstructionImpl(ProcessingInstruction delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    @Override // org.w3c.dom.ProcessingInstruction, nl.adaptivity.xmlutil.dom2.ProcessingInstruction
    public String getTarget() {
        String target = getDelegate().getTarget();
        Intrinsics.checkNotNullExpressionValue(target, "getTarget(...)");
        return target;
    }

    @Override // org.w3c.dom.ProcessingInstruction, nl.adaptivity.xmlutil.dom2.ProcessingInstruction
    public String getData() {
        String data = getDelegate().getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        return data;
    }

    @Override // org.w3c.dom.ProcessingInstruction, nl.adaptivity.xmlutil.dom2.ProcessingInstruction
    public void setData(String data) {
        getDelegate().setData(data);
    }
}