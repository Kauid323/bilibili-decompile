package nl.adaptivity.xmlutil.dom2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NodeType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\n\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/NodeType;", "", "value", "", "<init>", "(Ljava/lang/String;IS)V", "getValue", "()S", "ELEMENT_NODE", "ATTRIBUTE_NODE", "TEXT_NODE", "CDATA_SECTION_NODE", "ENTITY_REFERENCE_NODE", "ENTITY_NODE", "PROCESSING_INSTRUCTION_NODE", "COMMENT_NODE", "DOCUMENT_NODE", "DOCUMENT_TYPE_NODE", "DOCUMENT_FRAGMENT_NODE", "NOTATION_NODE", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum NodeType {
    ELEMENT_NODE(1),
    ATTRIBUTE_NODE(2),
    TEXT_NODE(3),
    CDATA_SECTION_NODE(4),
    ENTITY_REFERENCE_NODE(5),
    ENTITY_NODE(6),
    PROCESSING_INSTRUCTION_NODE(7),
    COMMENT_NODE(8),
    DOCUMENT_NODE(9),
    DOCUMENT_TYPE_NODE(10),
    DOCUMENT_FRAGMENT_NODE(11),
    NOTATION_NODE(12);
    
    private final short value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    NodeType(short value) {
        this.value = value;
    }

    public final short getValue() {
        return this.value;
    }

    /* compiled from: NodeType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Lnl/adaptivity/xmlutil/dom2/NodeType$Companion;", "", "<init>", "()V", "invoke", "Lnl/adaptivity/xmlutil/dom2/NodeType;", "v", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NodeType invoke(short v) {
            switch (v) {
                case 1:
                    return NodeType.ELEMENT_NODE;
                case 2:
                    return NodeType.ATTRIBUTE_NODE;
                case 3:
                    return NodeType.TEXT_NODE;
                case 4:
                    return NodeType.CDATA_SECTION_NODE;
                case 5:
                    return NodeType.ENTITY_REFERENCE_NODE;
                case 6:
                    return NodeType.ENTITY_NODE;
                case 7:
                    return NodeType.PROCESSING_INSTRUCTION_NODE;
                case 8:
                    return NodeType.COMMENT_NODE;
                case 9:
                    return NodeType.DOCUMENT_NODE;
                case 10:
                    return NodeType.DOCUMENT_TYPE_NODE;
                case 11:
                    return NodeType.DOCUMENT_FRAGMENT_NODE;
                case additional_type_content_opus_VALUE:
                    return NodeType.NOTATION_NODE;
                default:
                    throw new IllegalArgumentException("Unsupported node type: " + ((int) v));
            }
        }
    }

    public static EnumEntries<NodeType> getEntries() {
        return $ENTRIES;
    }
}