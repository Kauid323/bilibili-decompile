package nl.adaptivity.xmlutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XmlReaderUtil.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0014¨\u0006\t"}, d2 = {"Lnl/adaptivity/xmlutil/SubstreamFilterReader;", "Lnl/adaptivity/xmlutil/XmlBufferedReader;", "delegate", "Lnl/adaptivity/xmlutil/XmlReader;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader;)V", "doPeek", "", "Lnl/adaptivity/xmlutil/XmlEvent;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubstreamFilterReader extends XmlBufferedReader {

    /* compiled from: XmlReaderUtil.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.START_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[EventType.PROCESSING_INSTRUCTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EventType.DOCDECL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[EventType.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubstreamFilterReader(XmlReader delegate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nl.adaptivity.xmlutil.XmlBufferedReaderBase
    public List<XmlEvent> doPeek() throws XmlException {
        boolean z;
        Iterable $this$filter$iv = super.doPeek();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            XmlEvent it = (XmlEvent) element$iv$iv;
            switch (WhenMappings.$EnumSwitchMapping$0[it.getEventType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    z = false;
                    break;
                default:
                    z = true;
                    break;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}