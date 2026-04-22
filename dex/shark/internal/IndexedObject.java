package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.PrimitiveType;

/* compiled from: IndexedObject.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lshark/internal/IndexedObject;", "", "()V", "position", "", "getPosition", "()J", "recordSize", "getRecordSize", "IndexedClass", "IndexedInstance", "IndexedObjectArray", "IndexedPrimitiveArray", "Lshark/internal/IndexedObject$IndexedClass;", "Lshark/internal/IndexedObject$IndexedInstance;", "Lshark/internal/IndexedObject$IndexedObjectArray;", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "shark-graph"}, k = 1, mv = {1, 4, 1})
public abstract class IndexedObject {
    public abstract long getPosition();

    public abstract long getRecordSize();

    private IndexedObject() {
    }

    public /* synthetic */ IndexedObject(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    /* compiled from: IndexedObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lshark/internal/IndexedObject$IndexedClass;", "Lshark/internal/IndexedObject;", "position", "", "superclassId", "instanceSize", "", "recordSize", "fieldsIndex", "(JJIJI)V", "getFieldsIndex", "()I", "getInstanceSize", "getPosition", "()J", "getRecordSize", "getSuperclassId", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class IndexedClass extends IndexedObject {
        private final int fieldsIndex;
        private final int instanceSize;
        private final long position;
        private final long recordSize;
        private final long superclassId;

        public IndexedClass(long position, long superclassId, int instanceSize, long recordSize, int fieldsIndex) {
            super(null);
            this.position = position;
            this.superclassId = superclassId;
            this.instanceSize = instanceSize;
            this.recordSize = recordSize;
            this.fieldsIndex = fieldsIndex;
        }

        @Override // shark.internal.IndexedObject
        public long getPosition() {
            return this.position;
        }

        public final long getSuperclassId() {
            return this.superclassId;
        }

        public final int getInstanceSize() {
            return this.instanceSize;
        }

        @Override // shark.internal.IndexedObject
        public long getRecordSize() {
            return this.recordSize;
        }

        public final int getFieldsIndex() {
            return this.fieldsIndex;
        }
    }

    /* compiled from: IndexedObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lshark/internal/IndexedObject$IndexedInstance;", "Lshark/internal/IndexedObject;", "position", "", "classId", "recordSize", "(JJJ)V", "getClassId", "()J", "getPosition", "getRecordSize", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class IndexedInstance extends IndexedObject {
        private final long classId;
        private final long position;
        private final long recordSize;

        public IndexedInstance(long position, long classId, long recordSize) {
            super(null);
            this.position = position;
            this.classId = classId;
            this.recordSize = recordSize;
        }

        @Override // shark.internal.IndexedObject
        public long getPosition() {
            return this.position;
        }

        public final long getClassId() {
            return this.classId;
        }

        @Override // shark.internal.IndexedObject
        public long getRecordSize() {
            return this.recordSize;
        }
    }

    /* compiled from: IndexedObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lshark/internal/IndexedObject$IndexedObjectArray;", "Lshark/internal/IndexedObject;", "position", "", "arrayClassId", "recordSize", "(JJJ)V", "getArrayClassId", "()J", "getPosition", "getRecordSize", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class IndexedObjectArray extends IndexedObject {
        private final long arrayClassId;
        private final long position;
        private final long recordSize;

        public IndexedObjectArray(long position, long arrayClassId, long recordSize) {
            super(null);
            this.position = position;
            this.arrayClassId = arrayClassId;
            this.recordSize = recordSize;
        }

        @Override // shark.internal.IndexedObject
        public long getPosition() {
            return this.position;
        }

        public final long getArrayClassId() {
            return this.arrayClassId;
        }

        @Override // shark.internal.IndexedObject
        public long getRecordSize() {
            return this.recordSize;
        }
    }

    /* compiled from: IndexedObject.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "Lshark/internal/IndexedObject;", "position", "", "primitiveType", "Lshark/PrimitiveType;", "recordSize", "(JLshark/PrimitiveType;J)V", "getPosition", "()J", "getPrimitiveType", "()Lshark/PrimitiveType;", "primitiveTypeOrdinal", "", "getRecordSize", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class IndexedPrimitiveArray extends IndexedObject {
        private final long position;
        private final byte primitiveTypeOrdinal;
        private final long recordSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IndexedPrimitiveArray(long position, PrimitiveType primitiveType, long recordSize) {
            super(null);
            Intrinsics.checkParameterIsNotNull(primitiveType, "primitiveType");
            this.position = position;
            this.recordSize = recordSize;
            this.primitiveTypeOrdinal = (byte) primitiveType.ordinal();
        }

        @Override // shark.internal.IndexedObject
        public long getPosition() {
            return this.position;
        }

        @Override // shark.internal.IndexedObject
        public long getRecordSize() {
            return this.recordSize;
        }

        public final PrimitiveType getPrimitiveType() {
            return PrimitiveType.values()[this.primitiveTypeOrdinal];
        }
    }
}