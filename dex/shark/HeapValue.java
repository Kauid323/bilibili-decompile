package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import shark.HeapObject;
import shark.ValueHolder;

/* compiled from: HeapValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00106\u001a\u0004\u0018\u000107R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0013\u0010%\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b*\u0010\"R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b5\u00104¨\u00068"}, d2 = {"Lshark/HeapValue;", "", "graph", "Lshark/HeapGraph;", "holder", "Lshark/ValueHolder;", "(Lshark/HeapGraph;Lshark/ValueHolder;)V", "asBoolean", "", "getAsBoolean", "()Ljava/lang/Boolean;", "asByte", "", "getAsByte", "()Ljava/lang/Byte;", "asChar", "", "getAsChar", "()Ljava/lang/Character;", "asDouble", "", "getAsDouble", "()Ljava/lang/Double;", "asFloat", "", "getAsFloat", "()Ljava/lang/Float;", "asInt", "", "getAsInt", "()Ljava/lang/Integer;", "asLong", "", "getAsLong", "()Ljava/lang/Long;", "asNonNullObjectId", "getAsNonNullObjectId", "asObject", "Lshark/HeapObject;", "getAsObject", "()Lshark/HeapObject;", "asObjectId", "getAsObjectId", "asShort", "", "getAsShort", "()Ljava/lang/Short;", "getGraph", "()Lshark/HeapGraph;", "getHolder", "()Lshark/ValueHolder;", "isNonNullReference", "()Z", "isNullReference", "readAsJavaString", "", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class HeapValue {
    private final HeapGraph graph;
    private final ValueHolder holder;

    public HeapValue(HeapGraph graph, ValueHolder holder) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        this.graph = graph;
        this.holder = holder;
    }

    public final HeapGraph getGraph() {
        return this.graph;
    }

    public final ValueHolder getHolder() {
        return this.holder;
    }

    public final Boolean getAsBoolean() {
        if (this.holder instanceof ValueHolder.BooleanHolder) {
            return Boolean.valueOf(((ValueHolder.BooleanHolder) this.holder).getValue());
        }
        return null;
    }

    public final Character getAsChar() {
        if (this.holder instanceof ValueHolder.CharHolder) {
            return Character.valueOf(((ValueHolder.CharHolder) this.holder).getValue());
        }
        return null;
    }

    public final Float getAsFloat() {
        if (this.holder instanceof ValueHolder.FloatHolder) {
            return Float.valueOf(((ValueHolder.FloatHolder) this.holder).getValue());
        }
        return null;
    }

    public final Double getAsDouble() {
        if (this.holder instanceof ValueHolder.DoubleHolder) {
            return Double.valueOf(((ValueHolder.DoubleHolder) this.holder).getValue());
        }
        return null;
    }

    public final Byte getAsByte() {
        if (this.holder instanceof ValueHolder.ByteHolder) {
            return Byte.valueOf(((ValueHolder.ByteHolder) this.holder).getValue());
        }
        return null;
    }

    public final Short getAsShort() {
        if (this.holder instanceof ValueHolder.ShortHolder) {
            return Short.valueOf(((ValueHolder.ShortHolder) this.holder).getValue());
        }
        return null;
    }

    public final Integer getAsInt() {
        if (this.holder instanceof ValueHolder.IntHolder) {
            return Integer.valueOf(((ValueHolder.IntHolder) this.holder).getValue());
        }
        return null;
    }

    public final Long getAsLong() {
        if (this.holder instanceof ValueHolder.LongHolder) {
            return Long.valueOf(((ValueHolder.LongHolder) this.holder).getValue());
        }
        return null;
    }

    public final Long getAsObjectId() {
        if (this.holder instanceof ValueHolder.ReferenceHolder) {
            return Long.valueOf(((ValueHolder.ReferenceHolder) this.holder).getValue());
        }
        return null;
    }

    public final Long getAsNonNullObjectId() {
        if (!(this.holder instanceof ValueHolder.ReferenceHolder) || ((ValueHolder.ReferenceHolder) this.holder).isNull()) {
            return null;
        }
        return Long.valueOf(((ValueHolder.ReferenceHolder) this.holder).getValue());
    }

    public final boolean isNullReference() {
        return (this.holder instanceof ValueHolder.ReferenceHolder) && ((ValueHolder.ReferenceHolder) this.holder).isNull();
    }

    public final boolean isNonNullReference() {
        return (this.holder instanceof ValueHolder.ReferenceHolder) && !((ValueHolder.ReferenceHolder) this.holder).isNull();
    }

    public final HeapObject getAsObject() {
        if (!(this.holder instanceof ValueHolder.ReferenceHolder) || ((ValueHolder.ReferenceHolder) this.holder).isNull()) {
            return null;
        }
        return this.graph.findObjectById(((ValueHolder.ReferenceHolder) this.holder).getValue());
    }

    public final String readAsJavaString() {
        HeapObject heapObject;
        HeapObject.HeapInstance asInstance;
        if (!(this.holder instanceof ValueHolder.ReferenceHolder) || ((ValueHolder.ReferenceHolder) this.holder).isNull() || (heapObject = this.graph.findObjectByIdOrNull(((ValueHolder.ReferenceHolder) this.holder).getValue())) == null || (asInstance = heapObject.getAsInstance()) == null) {
            return null;
        }
        return asInstance.readAsJavaString();
    }
}