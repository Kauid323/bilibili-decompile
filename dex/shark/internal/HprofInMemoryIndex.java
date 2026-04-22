package shark.internal;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import shark.GcRoot;
import shark.HprofHeader;
import shark.HprofRecordReader;
import shark.HprofRecordTag;
import shark.HprofVersion;
import shark.OnHprofRecordTagListener;
import shark.PrimitiveType;
import shark.ProguardMapping;
import shark.StreamingHprofReader;
import shark.internal.IndexedObject;
import shark.internal.UnsortedByteEntries;
import shark.internal.hppc.IntObjectPair;
import shark.internal.hppc.LongLongPair;
import shark.internal.hppc.LongLongScatterMap;
import shark.internal.hppc.LongObjectPair;
import shark.internal.hppc.LongObjectScatterMap;
import shark.internal.hppc.LongScatterSet;
import shark.internal.hppc.TuplesKt;
import tv.danmaku.app.AppConfig;

/* compiled from: HprofInMemoryIndex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 F2\u00020\u0001:\u0002EFB\u009d\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0015\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0002\u0010-J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+J\u0016\u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020+J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0010\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020+H\u0002J\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040302J\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060302J\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080302J\u0016\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:2\u0006\u0010<\u001a\u00020+J\u0012\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0302J\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0302J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020;032\u0006\u0010A\u001a\u00020\u0003J\u000e\u0010B\u001a\u00020\u00182\u0006\u0010<\u001a\u00020+J\f\u0010C\u001a\u000204*\u00020DH\u0002R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010!R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b)\u0010!R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lshark/internal/HprofInMemoryIndex;", "", "positionSize", "", "hprofStringCache", "Lshark/internal/hppc/LongObjectScatterMap;", "", "classNames", "Lshark/internal/hppc/LongLongScatterMap;", "classIndex", "Lshark/internal/SortedBytesMap;", "instanceIndex", "objectArrayIndex", "primitiveArrayIndex", "gcRoots", "", "Lshark/GcRoot;", "proguardMapping", "Lshark/ProguardMapping;", "bytesForClassSize", "bytesForInstanceSize", "bytesForObjectArraySize", "bytesForPrimitiveArraySize", "useForwardSlashClassPackageSeparator", "", "classFieldsReader", "Lshark/internal/ClassFieldsReader;", "classFieldsIndexSize", "stickyClassGcRootIds", "Lshark/internal/hppc/LongScatterSet;", "(ILshark/internal/hppc/LongObjectScatterMap;Lshark/internal/hppc/LongLongScatterMap;Lshark/internal/SortedBytesMap;Lshark/internal/SortedBytesMap;Lshark/internal/SortedBytesMap;Lshark/internal/SortedBytesMap;Ljava/util/List;Lshark/ProguardMapping;IIIIZLshark/internal/ClassFieldsReader;ILshark/internal/hppc/LongScatterSet;)V", "classCount", "getClassCount", "()I", "getClassFieldsReader", "()Lshark/internal/ClassFieldsReader;", "instanceCount", "getInstanceCount", "objectArrayCount", "getObjectArrayCount", "primitiveArrayCount", "getPrimitiveArrayCount", "classId", "", "className", "(Ljava/lang/String;)Ljava/lang/Long;", "fieldName", "id", "hprofStringById", "indexedClassSequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/IndexedObject$IndexedClass;", "indexedInstanceSequence", "Lshark/internal/IndexedObject$IndexedInstance;", "indexedObjectArraySequence", "Lshark/internal/IndexedObject$IndexedObjectArray;", "indexedObjectOrNull", "Lshark/internal/hppc/IntObjectPair;", "Lshark/internal/IndexedObject;", "objectId", "indexedObjectSequence", "indexedPrimitiveArraySequence", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "objectAtIndex", "index", "objectIdIsIndexed", "readClass", "Lshark/internal/ByteSubArray;", "Builder", "Companion", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class HprofInMemoryIndex {
    public static final Companion Companion = new Companion(null);
    private final int bytesForClassSize;
    private final int bytesForInstanceSize;
    private final int bytesForObjectArraySize;
    private final int bytesForPrimitiveArraySize;
    private final int classFieldsIndexSize;
    private final ClassFieldsReader classFieldsReader;
    private final SortedBytesMap classIndex;
    private final LongLongScatterMap classNames;
    private final List<GcRoot> gcRoots;
    private final LongObjectScatterMap<String> hprofStringCache;
    private final SortedBytesMap instanceIndex;
    private final SortedBytesMap objectArrayIndex;
    private final int positionSize;
    private final SortedBytesMap primitiveArrayIndex;
    private final ProguardMapping proguardMapping;
    private final LongScatterSet stickyClassGcRootIds;
    private final boolean useForwardSlashClassPackageSeparator;

    /* JADX WARN: Multi-variable type inference failed */
    private HprofInMemoryIndex(int positionSize, LongObjectScatterMap<String> longObjectScatterMap, LongLongScatterMap classNames, SortedBytesMap classIndex, SortedBytesMap instanceIndex, SortedBytesMap objectArrayIndex, SortedBytesMap primitiveArrayIndex, List<? extends GcRoot> list, ProguardMapping proguardMapping, int bytesForClassSize, int bytesForInstanceSize, int bytesForObjectArraySize, int bytesForPrimitiveArraySize, boolean useForwardSlashClassPackageSeparator, ClassFieldsReader classFieldsReader, int classFieldsIndexSize, LongScatterSet stickyClassGcRootIds) {
        this.positionSize = positionSize;
        this.hprofStringCache = longObjectScatterMap;
        this.classNames = classNames;
        this.classIndex = classIndex;
        this.instanceIndex = instanceIndex;
        this.objectArrayIndex = objectArrayIndex;
        this.primitiveArrayIndex = primitiveArrayIndex;
        this.gcRoots = list;
        this.proguardMapping = proguardMapping;
        this.bytesForClassSize = bytesForClassSize;
        this.bytesForInstanceSize = bytesForInstanceSize;
        this.bytesForObjectArraySize = bytesForObjectArraySize;
        this.bytesForPrimitiveArraySize = bytesForPrimitiveArraySize;
        this.useForwardSlashClassPackageSeparator = useForwardSlashClassPackageSeparator;
        this.classFieldsReader = classFieldsReader;
        this.classFieldsIndexSize = classFieldsIndexSize;
        this.stickyClassGcRootIds = stickyClassGcRootIds;
    }

    public /* synthetic */ HprofInMemoryIndex(int positionSize, LongObjectScatterMap hprofStringCache, LongLongScatterMap classNames, SortedBytesMap classIndex, SortedBytesMap instanceIndex, SortedBytesMap objectArrayIndex, SortedBytesMap primitiveArrayIndex, List gcRoots, ProguardMapping proguardMapping, int bytesForClassSize, int bytesForInstanceSize, int bytesForObjectArraySize, int bytesForPrimitiveArraySize, boolean useForwardSlashClassPackageSeparator, ClassFieldsReader classFieldsReader, int classFieldsIndexSize, LongScatterSet stickyClassGcRootIds, DefaultConstructorMarker $constructor_marker) {
        this(positionSize, hprofStringCache, classNames, classIndex, instanceIndex, objectArrayIndex, primitiveArrayIndex, gcRoots, proguardMapping, bytesForClassSize, bytesForInstanceSize, bytesForObjectArraySize, bytesForPrimitiveArraySize, useForwardSlashClassPackageSeparator, classFieldsReader, classFieldsIndexSize, stickyClassGcRootIds);
    }

    public final ClassFieldsReader getClassFieldsReader() {
        return this.classFieldsReader;
    }

    public final int getClassCount() {
        return this.classIndex.getSize();
    }

    public final int getInstanceCount() {
        return this.instanceIndex.getSize();
    }

    public final int getObjectArrayCount() {
        return this.objectArrayIndex.getSize();
    }

    public final int getPrimitiveArrayCount() {
        return this.primitiveArrayIndex.getSize();
    }

    public final String fieldName(long classId, long id) {
        String fieldNameString = hprofStringById(id);
        if (this.proguardMapping != null) {
            long classNameStringId = this.classNames.get(classId);
            String classNameString = hprofStringById(classNameStringId);
            String deobfuscateFieldName = this.proguardMapping.deobfuscateFieldName(classNameString, fieldNameString);
            if (deobfuscateFieldName != null) {
                return deobfuscateFieldName;
            }
        }
        return fieldNameString;
    }

    public final String className(long classId) {
        String deobfuscateClassName;
        long classNameStringId = this.classNames.get(classId);
        String classNameString = hprofStringById(classNameStringId);
        ProguardMapping proguardMapping = this.proguardMapping;
        String $this$run = (proguardMapping == null || (deobfuscateClassName = proguardMapping.deobfuscateClassName(classNameString)) == null) ? classNameString : deobfuscateClassName;
        if (!this.useForwardSlashClassPackageSeparator) {
            return $this$run;
        }
        return kotlin.text.StringsKt.replace$default($this$run, '/', '.', false, 4, (Object) null);
    }

    public final Long classId(String className) {
        String internalClassName;
        Object element$iv;
        Intrinsics.checkParameterIsNotNull(className, "className");
        if (this.useForwardSlashClassPackageSeparator) {
            internalClassName = kotlin.text.StringsKt.replace$default(className, '.', '/', false, 4, (Object) null);
        } else {
            internalClassName = className;
        }
        Sequence $this$firstOrNull$iv = this.hprofStringCache.entrySequence();
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                LongObjectPair it2 = (LongObjectPair) element$iv;
                if (Intrinsics.areEqual((String) it2.getSecond(), internalClassName)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        LongObjectPair longObjectPair = (LongObjectPair) element$iv;
        if (longObjectPair != null) {
            long hprofStringId = longObjectPair.getFirst();
            Long firstNonStickyMatchingClass = null;
            for (LongLongPair longLongPair : this.classNames.entrySequence()) {
                long classId = longLongPair.component1();
                long classNameStringId = longLongPair.component2();
                if (hprofStringId == classNameStringId) {
                    if (this.stickyClassGcRootIds.contains(classId)) {
                        return Long.valueOf(classId);
                    }
                    firstNonStickyMatchingClass = Long.valueOf(classId);
                }
            }
            return firstNonStickyMatchingClass;
        }
        return null;
    }

    public final Sequence<LongObjectPair<IndexedObject.IndexedClass>> indexedClassSequence() {
        return SequencesKt.map(this.classIndex.entrySequence(), new Function1<LongObjectPair<? extends ByteSubArray>, LongObjectPair<? extends IndexedObject.IndexedClass>>() { // from class: shark.internal.HprofInMemoryIndex$indexedClassSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final LongObjectPair<IndexedObject.IndexedClass> invoke(LongObjectPair<ByteSubArray> longObjectPair) {
                IndexedObject.IndexedClass readClass;
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long id = longObjectPair.getFirst();
                ByteSubArray array = longObjectPair.getSecond();
                readClass = HprofInMemoryIndex.this.readClass(array);
                return TuplesKt.to(id, readClass);
            }
        });
    }

    public final Sequence<LongObjectPair<IndexedObject.IndexedInstance>> indexedInstanceSequence() {
        return SequencesKt.map(this.instanceIndex.entrySequence(), new Function1<LongObjectPair<? extends ByteSubArray>, LongObjectPair<? extends IndexedObject.IndexedInstance>>() { // from class: shark.internal.HprofInMemoryIndex$indexedInstanceSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final LongObjectPair<IndexedObject.IndexedInstance> invoke(LongObjectPair<ByteSubArray> longObjectPair) {
                int i;
                int i2;
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long id = longObjectPair.getFirst();
                ByteSubArray array = longObjectPair.getSecond();
                i = HprofInMemoryIndex.this.positionSize;
                long readTruncatedLong = array.readTruncatedLong(i);
                long readId = array.readId();
                i2 = HprofInMemoryIndex.this.bytesForInstanceSize;
                IndexedObject.IndexedInstance instance = new IndexedObject.IndexedInstance(readTruncatedLong, readId, array.readTruncatedLong(i2));
                return TuplesKt.to(id, instance);
            }
        });
    }

    public final Sequence<LongObjectPair<IndexedObject.IndexedObjectArray>> indexedObjectArraySequence() {
        return SequencesKt.map(this.objectArrayIndex.entrySequence(), new Function1<LongObjectPair<? extends ByteSubArray>, LongObjectPair<? extends IndexedObject.IndexedObjectArray>>() { // from class: shark.internal.HprofInMemoryIndex$indexedObjectArraySequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final LongObjectPair<IndexedObject.IndexedObjectArray> invoke(LongObjectPair<ByteSubArray> longObjectPair) {
                int i;
                int i2;
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long id = longObjectPair.getFirst();
                ByteSubArray array = longObjectPair.getSecond();
                i = HprofInMemoryIndex.this.positionSize;
                long readTruncatedLong = array.readTruncatedLong(i);
                long readId = array.readId();
                i2 = HprofInMemoryIndex.this.bytesForObjectArraySize;
                IndexedObject.IndexedObjectArray objectArray = new IndexedObject.IndexedObjectArray(readTruncatedLong, readId, array.readTruncatedLong(i2));
                return TuplesKt.to(id, objectArray);
            }
        });
    }

    public final Sequence<LongObjectPair<IndexedObject.IndexedPrimitiveArray>> indexedPrimitiveArraySequence() {
        return SequencesKt.map(this.primitiveArrayIndex.entrySequence(), new Function1<LongObjectPair<? extends ByteSubArray>, LongObjectPair<? extends IndexedObject.IndexedPrimitiveArray>>() { // from class: shark.internal.HprofInMemoryIndex$indexedPrimitiveArraySequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final LongObjectPair<IndexedObject.IndexedPrimitiveArray> invoke(LongObjectPair<ByteSubArray> longObjectPair) {
                int i;
                int i2;
                Intrinsics.checkParameterIsNotNull(longObjectPair, "it");
                long id = longObjectPair.getFirst();
                ByteSubArray array = longObjectPair.getSecond();
                i = HprofInMemoryIndex.this.positionSize;
                long readTruncatedLong = array.readTruncatedLong(i);
                PrimitiveType primitiveType = PrimitiveType.values()[array.readByte()];
                i2 = HprofInMemoryIndex.this.bytesForPrimitiveArraySize;
                IndexedObject.IndexedPrimitiveArray primitiveArray = new IndexedObject.IndexedPrimitiveArray(readTruncatedLong, primitiveType, array.readTruncatedLong(i2));
                return TuplesKt.to(id, primitiveArray);
            }
        });
    }

    public final Sequence<LongObjectPair<IndexedObject>> indexedObjectSequence() {
        return SequencesKt.plus(SequencesKt.plus(SequencesKt.plus(indexedClassSequence(), indexedInstanceSequence()), indexedObjectArraySequence()), indexedPrimitiveArraySequence());
    }

    public final List<GcRoot> gcRoots() {
        return this.gcRoots;
    }

    public final LongObjectPair<IndexedObject> objectAtIndex(int index) {
        if (!(index > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (index < this.classIndex.getSize()) {
            long objectId = this.classIndex.keyAt(index);
            return TuplesKt.to(objectId, readClass(this.classIndex.getAtIndex(index)));
        }
        int shiftedIndex = index - this.classIndex.getSize();
        if (shiftedIndex < this.instanceIndex.getSize()) {
            long objectId2 = this.instanceIndex.keyAt(shiftedIndex);
            ByteSubArray array = this.instanceIndex.getAtIndex(shiftedIndex);
            return TuplesKt.to(objectId2, new IndexedObject.IndexedInstance(array.readTruncatedLong(this.positionSize), array.readId(), array.readTruncatedLong(this.bytesForInstanceSize)));
        }
        int shiftedIndex2 = shiftedIndex - this.instanceIndex.getSize();
        if (shiftedIndex2 < this.objectArrayIndex.getSize()) {
            long objectId3 = this.objectArrayIndex.keyAt(shiftedIndex2);
            ByteSubArray array2 = this.objectArrayIndex.getAtIndex(shiftedIndex2);
            return TuplesKt.to(objectId3, new IndexedObject.IndexedObjectArray(array2.readTruncatedLong(this.positionSize), array2.readId(), array2.readTruncatedLong(this.bytesForObjectArraySize)));
        }
        int shiftedIndex3 = shiftedIndex2 - this.objectArrayIndex.getSize();
        if (!(index < this.primitiveArrayIndex.getSize())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long objectId4 = this.primitiveArrayIndex.keyAt(shiftedIndex3);
        ByteSubArray array3 = this.primitiveArrayIndex.getAtIndex(shiftedIndex3);
        return TuplesKt.to(objectId4, new IndexedObject.IndexedPrimitiveArray(array3.readTruncatedLong(this.positionSize), PrimitiveType.values()[array3.readByte()], array3.readTruncatedLong(this.bytesForPrimitiveArraySize)));
    }

    public final IntObjectPair<IndexedObject> indexedObjectOrNull(long objectId) {
        int index = this.classIndex.indexOf(objectId);
        if (index >= 0) {
            return TuplesKt.to(index, readClass(this.classIndex.getAtIndex(index)));
        }
        int index2 = this.instanceIndex.indexOf(objectId);
        if (index2 >= 0) {
            ByteSubArray array = this.instanceIndex.getAtIndex(index2);
            return TuplesKt.to(this.classIndex.getSize() + index2, new IndexedObject.IndexedInstance(array.readTruncatedLong(this.positionSize), array.readId(), array.readTruncatedLong(this.bytesForInstanceSize)));
        }
        int index3 = this.objectArrayIndex.indexOf(objectId);
        if (index3 >= 0) {
            ByteSubArray array2 = this.objectArrayIndex.getAtIndex(index3);
            return TuplesKt.to(this.classIndex.getSize() + this.instanceIndex.getSize() + index3, new IndexedObject.IndexedObjectArray(array2.readTruncatedLong(this.positionSize), array2.readId(), array2.readTruncatedLong(this.bytesForObjectArraySize)));
        }
        int index4 = this.primitiveArrayIndex.indexOf(objectId);
        if (index4 >= 0) {
            ByteSubArray array3 = this.primitiveArrayIndex.getAtIndex(index4);
            return TuplesKt.to(this.classIndex.getSize() + this.instanceIndex.getSize() + index4 + this.primitiveArrayIndex.getSize(), new IndexedObject.IndexedPrimitiveArray(array3.readTruncatedLong(this.positionSize), PrimitiveType.values()[array3.readByte()], array3.readTruncatedLong(this.bytesForPrimitiveArraySize)));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexedObject.IndexedClass readClass(ByteSubArray $this$readClass) {
        long position = $this$readClass.readTruncatedLong(this.positionSize);
        long superclassId = $this$readClass.readId();
        int instanceSize = $this$readClass.readInt();
        long recordSize = $this$readClass.readTruncatedLong(this.bytesForClassSize);
        int fieldsIndex = (int) $this$readClass.readTruncatedLong(this.classFieldsIndexSize);
        return new IndexedObject.IndexedClass(position, superclassId, instanceSize, recordSize, fieldsIndex);
    }

    public final boolean objectIdIsIndexed(long objectId) {
        return (this.classIndex.get(objectId) == null && this.instanceIndex.get(objectId) == null && this.objectArrayIndex.get(objectId) == null && this.primitiveArrayIndex.get(objectId) == null) ? false : true;
    }

    private final String hprofStringById(long id) {
        String str = this.hprofStringCache.get(id);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Hprof string " + id + " not in cache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HprofInMemoryIndex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0018\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203J\b\u00104\u001a\u000205H\u0002J \u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<H\u0016J\u0014\u0010=\u001a\u000207*\u00020<2\u0006\u0010>\u001a\u00020\u0007H\u0002R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006?"}, d2 = {"Lshark/internal/HprofInMemoryIndex$Builder;", "Lshark/OnHprofRecordTagListener;", "longIdentifiers", "", "maxPosition", "", "classCount", "", "instanceCount", "objectArrayCount", "primitiveArrayCount", "bytesForClassSize", "bytesForInstanceSize", "bytesForObjectArraySize", "bytesForPrimitiveArraySize", "classFieldsTotalBytes", "stickyClassGcRootIds", "Lshark/internal/hppc/LongScatterSet;", "(ZJIIIIIIIIILshark/internal/hppc/LongScatterSet;)V", "getBytesForClassSize", "()I", "getBytesForInstanceSize", "getBytesForObjectArraySize", "getBytesForPrimitiveArraySize", "classFieldBytes", "", "classFieldsIndex", "classFieldsIndexSize", "getClassFieldsTotalBytes", "classIndex", "Lshark/internal/UnsortedByteEntries;", "classNames", "Lshark/internal/hppc/LongLongScatterMap;", "gcRoots", "", "Lshark/GcRoot;", "hprofStringCache", "Lshark/internal/hppc/LongObjectScatterMap;", "", "identifierSize", "instanceIndex", "objectArrayIndex", "positionSize", "primitiveArrayIndex", "getStickyClassGcRootIds", "()Lshark/internal/hppc/LongScatterSet;", "buildIndex", "Lshark/internal/HprofInMemoryIndex;", "proguardMapping", "Lshark/ProguardMapping;", "hprofHeader", "Lshark/HprofHeader;", "lastClassFieldsShort", "", "onHprofRecord", "", AppConfig.HOST_TAG, "Lshark/HprofRecordTag;", "length", "reader", "Lshark/HprofRecordReader;", "copyToClassFields", "byteCount", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Builder implements OnHprofRecordTagListener {
        private final int bytesForClassSize;
        private final int bytesForInstanceSize;
        private final int bytesForObjectArraySize;
        private final int bytesForPrimitiveArraySize;
        private final byte[] classFieldBytes;
        private int classFieldsIndex;
        private final int classFieldsIndexSize;
        private final int classFieldsTotalBytes;
        private final UnsortedByteEntries classIndex;
        private final LongLongScatterMap classNames;
        private final List<GcRoot> gcRoots;
        private final LongObjectScatterMap<String> hprofStringCache;
        private final int identifierSize;
        private final UnsortedByteEntries instanceIndex;
        private final UnsortedByteEntries objectArrayIndex;
        private final int positionSize;
        private final UnsortedByteEntries primitiveArrayIndex;
        private final LongScatterSet stickyClassGcRootIds;

        public Builder(boolean longIdentifiers, long maxPosition, int classCount, int instanceCount, int objectArrayCount, int primitiveArrayCount, int bytesForClassSize, int bytesForInstanceSize, int bytesForObjectArraySize, int bytesForPrimitiveArraySize, int classFieldsTotalBytes, LongScatterSet stickyClassGcRootIds) {
            Intrinsics.checkParameterIsNotNull(stickyClassGcRootIds, "stickyClassGcRootIds");
            this.bytesForClassSize = bytesForClassSize;
            this.bytesForInstanceSize = bytesForInstanceSize;
            this.bytesForObjectArraySize = bytesForObjectArraySize;
            this.bytesForPrimitiveArraySize = bytesForPrimitiveArraySize;
            this.classFieldsTotalBytes = classFieldsTotalBytes;
            this.stickyClassGcRootIds = stickyClassGcRootIds;
            this.identifierSize = longIdentifiers ? 8 : 4;
            this.positionSize = HprofInMemoryIndex.Companion.byteSizeForUnsigned(maxPosition);
            this.classFieldsIndexSize = HprofInMemoryIndex.Companion.byteSizeForUnsigned(this.classFieldsTotalBytes);
            this.hprofStringCache = new LongObjectScatterMap<>();
            this.classNames = new LongLongScatterMap(classCount);
            this.classFieldBytes = new byte[this.classFieldsTotalBytes];
            this.classIndex = new UnsortedByteEntries(this.positionSize + this.identifierSize + 4 + this.bytesForClassSize + this.classFieldsIndexSize, longIdentifiers, classCount, 0.0d, 8, null);
            this.instanceIndex = new UnsortedByteEntries(this.bytesForInstanceSize + this.positionSize + this.identifierSize, longIdentifiers, instanceCount, 0.0d, 8, null);
            this.objectArrayIndex = new UnsortedByteEntries(this.bytesForObjectArraySize + this.positionSize + this.identifierSize, longIdentifiers, objectArrayCount, 0.0d, 8, null);
            this.primitiveArrayIndex = new UnsortedByteEntries(this.bytesForPrimitiveArraySize + this.positionSize + 1, longIdentifiers, primitiveArrayCount, 0.0d, 8, null);
            ArrayList $this$apply = new ArrayList(this.stickyClassGcRootIds.size());
            Sequence $this$forEach$iv = this.stickyClassGcRootIds.elementSequence();
            for (Object element$iv : $this$forEach$iv) {
                long classId = ((Number) element$iv).longValue();
                $this$apply.add(new GcRoot.StickyClass(classId));
            }
            Unit unit = Unit.INSTANCE;
            this.gcRoots = $this$apply;
        }

        public final int getBytesForClassSize() {
            return this.bytesForClassSize;
        }

        public final int getBytesForInstanceSize() {
            return this.bytesForInstanceSize;
        }

        public final int getBytesForObjectArraySize() {
            return this.bytesForObjectArraySize;
        }

        public final int getBytesForPrimitiveArraySize() {
            return this.bytesForPrimitiveArraySize;
        }

        public final int getClassFieldsTotalBytes() {
            return this.classFieldsTotalBytes;
        }

        public final LongScatterSet getStickyClassGcRootIds() {
            return this.stickyClassGcRootIds;
        }

        private final void copyToClassFields(HprofRecordReader $this$copyToClassFields, int byteCount) {
            int i = 1;
            if (1 > byteCount) {
                return;
            }
            while (true) {
                byte[] bArr = this.classFieldBytes;
                int i2 = this.classFieldsIndex;
                this.classFieldsIndex = i2 + 1;
                bArr[i2] = $this$copyToClassFields.readByte();
                if (i == byteCount) {
                    return;
                }
                i++;
            }
        }

        private final short lastClassFieldsShort() {
            return (short) (((this.classFieldBytes[this.classFieldsIndex - 2] & 255) << 8) | (this.classFieldBytes[this.classFieldsIndex - 1] & 255));
        }

        @Override // shark.OnHprofRecordTagListener
        public void onHprofRecord(HprofRecordTag tag, long length, HprofRecordReader reader) {
            Intrinsics.checkParameterIsNotNull(tag, AppConfig.HOST_TAG);
            Intrinsics.checkParameterIsNotNull(reader, "reader");
            switch (tag) {
                case STRING_IN_UTF8:
                    this.hprofStringCache.set(reader.readId(), reader.readUtf8(length - this.identifierSize));
                    return;
                case LOAD_CLASS:
                    reader.skip(PrimitiveType.INT.getByteSize());
                    long id = reader.readId();
                    reader.skip(PrimitiveType.INT.getByteSize());
                    long classNameStringId = reader.readId();
                    this.classNames.set(id, classNameStringId);
                    return;
                case ROOT_UNKNOWN:
                    GcRoot.Unknown $this$apply = reader.readUnknownGcRootRecord();
                    if ($this$apply.getId() != 0) {
                        this.gcRoots.add($this$apply);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                case ROOT_JNI_GLOBAL:
                    GcRoot.JniGlobal $this$apply2 = reader.readJniGlobalGcRootRecord();
                    if ($this$apply2.getId() != 0) {
                        this.gcRoots.add($this$apply2);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return;
                case ROOT_JNI_LOCAL:
                    GcRoot.JniLocal $this$apply3 = reader.readJniLocalGcRootRecord();
                    if ($this$apply3.getId() != 0) {
                        this.gcRoots.add($this$apply3);
                    }
                    Unit unit3 = Unit.INSTANCE;
                    return;
                case ROOT_JAVA_FRAME:
                    GcRoot.JavaFrame $this$apply4 = reader.readJavaFrameGcRootRecord();
                    if ($this$apply4.getId() != 0) {
                        this.gcRoots.add($this$apply4);
                    }
                    Unit unit4 = Unit.INSTANCE;
                    return;
                case ROOT_NATIVE_STACK:
                    GcRoot.NativeStack $this$apply5 = reader.readNativeStackGcRootRecord();
                    if ($this$apply5.getId() != 0) {
                        this.gcRoots.add($this$apply5);
                    }
                    Unit unit5 = Unit.INSTANCE;
                    return;
                case ROOT_STICKY_CLASS:
                    reader.skipId();
                    return;
                case ROOT_THREAD_BLOCK:
                    GcRoot.ThreadBlock $this$apply6 = reader.readThreadBlockGcRootRecord();
                    if ($this$apply6.getId() != 0) {
                        this.gcRoots.add($this$apply6);
                    }
                    Unit unit6 = Unit.INSTANCE;
                    return;
                case ROOT_MONITOR_USED:
                    GcRoot.MonitorUsed $this$apply7 = reader.readMonitorUsedGcRootRecord();
                    if ($this$apply7.getId() != 0) {
                        this.gcRoots.add($this$apply7);
                    }
                    Unit unit7 = Unit.INSTANCE;
                    return;
                case ROOT_THREAD_OBJECT:
                    GcRoot.ThreadObject $this$apply8 = reader.readThreadObjectGcRootRecord();
                    if ($this$apply8.getId() != 0) {
                        this.gcRoots.add($this$apply8);
                    }
                    Unit unit8 = Unit.INSTANCE;
                    return;
                case ROOT_INTERNED_STRING:
                    GcRoot.InternedString $this$apply9 = reader.readInternedStringGcRootRecord();
                    if ($this$apply9.getId() != 0) {
                        this.gcRoots.add($this$apply9);
                    }
                    Unit unit9 = Unit.INSTANCE;
                    return;
                case ROOT_FINALIZING:
                    GcRoot.Finalizing $this$apply10 = reader.readFinalizingGcRootRecord();
                    if ($this$apply10.getId() != 0) {
                        this.gcRoots.add($this$apply10);
                    }
                    Unit unit10 = Unit.INSTANCE;
                    return;
                case ROOT_DEBUGGER:
                    GcRoot.Debugger $this$apply11 = reader.readDebuggerGcRootRecord();
                    if ($this$apply11.getId() != 0) {
                        this.gcRoots.add($this$apply11);
                    }
                    Unit unit11 = Unit.INSTANCE;
                    return;
                case ROOT_REFERENCE_CLEANUP:
                    GcRoot.ReferenceCleanup $this$apply12 = reader.readReferenceCleanupGcRootRecord();
                    if ($this$apply12.getId() != 0) {
                        this.gcRoots.add($this$apply12);
                    }
                    Unit unit12 = Unit.INSTANCE;
                    return;
                case ROOT_VM_INTERNAL:
                    GcRoot.VmInternal $this$apply13 = reader.readVmInternalGcRootRecord();
                    if ($this$apply13.getId() != 0) {
                        this.gcRoots.add($this$apply13);
                    }
                    Unit unit13 = Unit.INSTANCE;
                    return;
                case ROOT_JNI_MONITOR:
                    GcRoot.JniMonitor $this$apply14 = reader.readJniMonitorGcRootRecord();
                    if ($this$apply14.getId() != 0) {
                        this.gcRoots.add($this$apply14);
                    }
                    Unit unit14 = Unit.INSTANCE;
                    return;
                case ROOT_UNREACHABLE:
                    GcRoot.Unreachable $this$apply15 = reader.readUnreachableGcRootRecord();
                    if ($this$apply15.getId() != 0) {
                        this.gcRoots.add($this$apply15);
                    }
                    Unit unit15 = Unit.INSTANCE;
                    return;
                case CLASS_DUMP:
                    long bytesReadStart = reader.getBytesRead();
                    long id2 = reader.readId();
                    reader.skip(PrimitiveType.INT.getByteSize());
                    long superclassId = reader.readId();
                    reader.skip(this.identifierSize * 5);
                    int instanceSize = reader.readInt();
                    reader.skipClassDumpConstantPool();
                    int startPosition = this.classFieldsIndex;
                    long bytesReadFieldStart = reader.getBytesRead();
                    copyToClassFields(reader, 2);
                    int staticFieldCount = lastClassFieldsShort() & 65535;
                    int i = 0;
                    while (i < staticFieldCount) {
                        copyToClassFields(reader, this.identifierSize);
                        copyToClassFields(reader, 1);
                        byte[] bArr = this.classFieldBytes;
                        int staticFieldCount2 = staticFieldCount;
                        int staticFieldCount3 = this.classFieldsIndex;
                        int type = bArr[staticFieldCount3 - 1] & 255;
                        if (type == 2) {
                            copyToClassFields(reader, this.identifierSize);
                        } else {
                            copyToClassFields(reader, ((Number) MapsKt.getValue(PrimitiveType.Companion.getByteSizeByHprofType(), Integer.valueOf(type))).intValue());
                        }
                        i++;
                        staticFieldCount = staticFieldCount2;
                    }
                    copyToClassFields(reader, 2);
                    int fieldCount = lastClassFieldsShort() & 65535;
                    for (int i2 = 0; i2 < fieldCount; i2++) {
                        copyToClassFields(reader, this.identifierSize);
                        copyToClassFields(reader, 1);
                    }
                    int fieldsSize = (int) (reader.getBytesRead() - bytesReadFieldStart);
                    long recordSize = reader.getBytesRead() - bytesReadStart;
                    UnsortedByteEntries.MutableByteSubArray $this$apply16 = this.classIndex.append(id2);
                    $this$apply16.writeTruncatedLong(bytesReadStart, this.positionSize);
                    $this$apply16.writeId(superclassId);
                    $this$apply16.writeInt(instanceSize);
                    $this$apply16.writeTruncatedLong(recordSize, this.bytesForClassSize);
                    int instanceSize2 = this.classFieldsIndexSize;
                    $this$apply16.writeTruncatedLong(startPosition, instanceSize2);
                    Unit unit16 = Unit.INSTANCE;
                    if (!(startPosition + fieldsSize == this.classFieldsIndex)) {
                        throw new IllegalArgumentException(("Expected " + this.classFieldsIndex + " to have moved by " + fieldsSize + " and be equal to " + (startPosition + fieldsSize)).toString());
                    }
                    return;
                case INSTANCE_DUMP:
                    long bytesReadStart2 = reader.getBytesRead();
                    long id3 = reader.readId();
                    reader.skip(PrimitiveType.INT.getByteSize());
                    long classId = reader.readId();
                    int remainingBytesInInstance = reader.readInt();
                    reader.skip(remainingBytesInInstance);
                    long recordSize2 = reader.getBytesRead() - bytesReadStart2;
                    UnsortedByteEntries.MutableByteSubArray $this$apply17 = this.instanceIndex.append(id3);
                    $this$apply17.writeTruncatedLong(bytesReadStart2, this.positionSize);
                    $this$apply17.writeId(classId);
                    $this$apply17.writeTruncatedLong(recordSize2, this.bytesForInstanceSize);
                    Unit unit17 = Unit.INSTANCE;
                    return;
                case OBJECT_ARRAY_DUMP:
                    long bytesReadStart3 = reader.getBytesRead();
                    long id4 = reader.readId();
                    reader.skip(PrimitiveType.INT.getByteSize());
                    int size = reader.readInt();
                    long arrayClassId = reader.readId();
                    reader.skip(this.identifierSize * size);
                    long recordSize3 = reader.getBytesRead() - bytesReadStart3;
                    UnsortedByteEntries.MutableByteSubArray $this$apply18 = this.objectArrayIndex.append(id4);
                    $this$apply18.writeTruncatedLong(bytesReadStart3, this.positionSize);
                    $this$apply18.writeId(arrayClassId);
                    $this$apply18.writeTruncatedLong(recordSize3, this.bytesForObjectArraySize);
                    Unit unit18 = Unit.INSTANCE;
                    return;
                case PRIMITIVE_ARRAY_DUMP:
                    long bytesReadStart4 = reader.getBytesRead();
                    long id5 = reader.readId();
                    reader.skip(PrimitiveType.INT.getByteSize());
                    int size2 = reader.readInt();
                    PrimitiveType type2 = (PrimitiveType) MapsKt.getValue(PrimitiveType.Companion.getPrimitiveTypeByHprofType(), Integer.valueOf(reader.readUnsignedByte()));
                    reader.skip(type2.getByteSize() * size2);
                    long recordSize4 = reader.getBytesRead() - bytesReadStart4;
                    UnsortedByteEntries.MutableByteSubArray $this$apply19 = this.primitiveArrayIndex.append(id5);
                    $this$apply19.writeTruncatedLong(bytesReadStart4, this.positionSize);
                    $this$apply19.writeByte((byte) type2.ordinal());
                    $this$apply19.writeTruncatedLong(recordSize4, this.bytesForPrimitiveArraySize);
                    Unit unit19 = Unit.INSTANCE;
                    return;
                default:
                    return;
            }
        }

        public final HprofInMemoryIndex buildIndex(ProguardMapping proguardMapping, HprofHeader hprofHeader) {
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            if (!(this.classFieldsIndex == this.classFieldBytes.length)) {
                throw new IllegalArgumentException(("Read " + this.classFieldsIndex + " into fields bytes instead of expected " + this.classFieldBytes.length).toString());
            }
            SortedBytesMap sortedInstanceIndex = this.instanceIndex.moveToSortedMap();
            SortedBytesMap sortedObjectArrayIndex = this.objectArrayIndex.moveToSortedMap();
            SortedBytesMap sortedPrimitiveArrayIndex = this.primitiveArrayIndex.moveToSortedMap();
            SortedBytesMap sortedClassIndex = this.classIndex.moveToSortedMap();
            return new HprofInMemoryIndex(this.positionSize, this.hprofStringCache, this.classNames, sortedClassIndex, sortedInstanceIndex, sortedObjectArrayIndex, sortedPrimitiveArrayIndex, this.gcRoots, proguardMapping, this.bytesForClassSize, this.bytesForInstanceSize, this.bytesForObjectArraySize, this.bytesForPrimitiveArraySize, hprofHeader.getVersion() != HprofVersion.ANDROID, new ClassFieldsReader(this.identifierSize, this.classFieldBytes), this.classFieldsIndexSize, this.stickyClassGcRootIds, null);
        }
    }

    /* compiled from: HprofInMemoryIndex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¨\u0006\u0012"}, d2 = {"Lshark/internal/HprofInMemoryIndex$Companion;", "", "()V", "byteSizeForUnsigned", "", "maxValue", "", "indexHprof", "Lshark/internal/HprofInMemoryIndex;", "reader", "Lshark/StreamingHprofReader;", "hprofHeader", "Lshark/HprofHeader;", "proguardMapping", "Lshark/ProguardMapping;", "indexedGcRootTags", "", "Lshark/HprofRecordTag;", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int byteSizeForUnsigned(long maxValue) {
            long value = maxValue;
            int byteCount = 0;
            while (value != 0) {
                value >>= 8;
                byteCount++;
            }
            return byteCount;
        }

        public final HprofInMemoryIndex indexHprof(StreamingHprofReader reader, HprofHeader hprofHeader, ProguardMapping proguardMapping, Set<? extends HprofRecordTag> set) {
            Intrinsics.checkParameterIsNotNull(reader, "reader");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            Intrinsics.checkParameterIsNotNull(set, "indexedGcRootTags");
            final Ref.LongRef maxClassSize = new Ref.LongRef();
            maxClassSize.element = 0L;
            final Ref.LongRef maxInstanceSize = new Ref.LongRef();
            maxInstanceSize.element = 0L;
            final Ref.LongRef maxObjectArraySize = new Ref.LongRef();
            maxObjectArraySize.element = 0L;
            final Ref.LongRef maxPrimitiveArraySize = new Ref.LongRef();
            maxPrimitiveArraySize.element = 0L;
            final Ref.IntRef classCount = new Ref.IntRef();
            classCount.element = 0;
            final Ref.IntRef instanceCount = new Ref.IntRef();
            instanceCount.element = 0;
            final Ref.IntRef objectArrayCount = new Ref.IntRef();
            objectArrayCount.element = 0;
            final Ref.IntRef primitiveArrayCount = new Ref.IntRef();
            primitiveArrayCount.element = 0;
            final Ref.IntRef classFieldsTotalBytes = new Ref.IntRef();
            classFieldsTotalBytes.element = 0;
            final LongScatterSet stickyClassGcRootIds = new LongScatterSet(0, 1, null);
            EnumSet of = EnumSet.of(HprofRecordTag.CLASS_DUMP, HprofRecordTag.INSTANCE_DUMP, HprofRecordTag.OBJECT_ARRAY_DUMP, HprofRecordTag.PRIMITIVE_ARRAY_DUMP, HprofRecordTag.ROOT_STICKY_CLASS);
            Intrinsics.checkExpressionValueIsNotNull(of, "EnumSet.of(\n          CL…OT_STICKY_CLASS\n        )");
            long bytesRead = reader.readRecords(of, new OnHprofRecordTagListener() { // from class: shark.internal.HprofInMemoryIndex$Companion$indexHprof$bytesRead$1
                @Override // shark.OnHprofRecordTagListener
                public final void onHprofRecord(HprofRecordTag tag, long $noName_1, HprofRecordReader reader2) {
                    Intrinsics.checkParameterIsNotNull(tag, AppConfig.HOST_TAG);
                    Intrinsics.checkParameterIsNotNull(reader2, "reader");
                    long bytesReadStart = reader2.getBytesRead();
                    switch (tag) {
                        case CLASS_DUMP:
                            classCount.element++;
                            reader2.skipClassDumpHeader();
                            long bytesReadStaticFieldStart = reader2.getBytesRead();
                            reader2.skipClassDumpStaticFields();
                            reader2.skipClassDumpFields();
                            maxClassSize.element = Math.max(maxClassSize.element, reader2.getBytesRead() - bytesReadStart);
                            classFieldsTotalBytes.element += (int) (reader2.getBytesRead() - bytesReadStaticFieldStart);
                            return;
                        case INSTANCE_DUMP:
                            instanceCount.element++;
                            reader2.skipInstanceDumpRecord();
                            maxInstanceSize.element = Math.max(maxInstanceSize.element, reader2.getBytesRead() - bytesReadStart);
                            return;
                        case OBJECT_ARRAY_DUMP:
                            objectArrayCount.element++;
                            reader2.skipObjectArrayDumpRecord();
                            maxObjectArraySize.element = Math.max(maxObjectArraySize.element, reader2.getBytesRead() - bytesReadStart);
                            return;
                        case PRIMITIVE_ARRAY_DUMP:
                            primitiveArrayCount.element++;
                            reader2.skipPrimitiveArrayDumpRecord();
                            maxPrimitiveArraySize.element = Math.max(maxPrimitiveArraySize.element, reader2.getBytesRead() - bytesReadStart);
                            return;
                        case ROOT_STICKY_CLASS:
                            long id = reader2.readStickyClassGcRootRecord().getId();
                            if (id != 0) {
                                stickyClassGcRootIds.plusAssign(id);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
            int bytesForClassSize = byteSizeForUnsigned(maxClassSize.element);
            int bytesForInstanceSize = byteSizeForUnsigned(maxInstanceSize.element);
            int bytesForObjectArraySize = byteSizeForUnsigned(maxObjectArraySize.element);
            int bytesForPrimitiveArraySize = byteSizeForUnsigned(maxPrimitiveArraySize.element);
            Builder indexBuilderListener = new Builder(hprofHeader.getIdentifierByteSize() == 8, bytesRead, classCount.element, instanceCount.element, objectArrayCount.element, primitiveArrayCount.element, bytesForClassSize, bytesForInstanceSize, bytesForObjectArraySize, bytesForPrimitiveArraySize, classFieldsTotalBytes.element, stickyClassGcRootIds);
            EnumSet of2 = EnumSet.of(HprofRecordTag.STRING_IN_UTF8, HprofRecordTag.LOAD_CLASS, HprofRecordTag.CLASS_DUMP, HprofRecordTag.INSTANCE_DUMP, HprofRecordTag.OBJECT_ARRAY_DUMP, HprofRecordTag.PRIMITIVE_ARRAY_DUMP);
            Intrinsics.checkExpressionValueIsNotNull(of2, "EnumSet.of(\n        STRI…MITIVE_ARRAY_DUMP\n      )");
            Set recordTypes = SetsKt.plus(of2, CollectionsKt.intersect(HprofRecordTag.Companion.getRootTags(), set));
            reader.readRecords(recordTypes, indexBuilderListener);
            return indexBuilderListener.buildIndex(proguardMapping, hprofHeader);
        }
    }
}