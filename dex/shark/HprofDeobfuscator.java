package shark;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import shark.HprofRecord;
import shark.StreamingHprofReader;

/* compiled from: HprofDeobfuscator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JZ\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J,\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rH\u0002J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014J:\u0010\u0017\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0002JP\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¨\u0006\u001b"}, d2 = {"Lshark/HprofDeobfuscator;", "", "()V", "createDeobfuscatedClassDumpRecord", "Lkotlin/Pair;", "", "Lshark/HprofRecord;", "", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "proguardMapping", "Lshark/ProguardMapping;", "hprofStringCache", "", "", "classNames", "maxId", "createDeobfuscatedStringRecord", "Lshark/HprofRecord$StringRecord;", "deobfuscate", "Ljava/io/File;", "inputHprofFile", "outputHprofFile", "readHprofRecords", "Lkotlin/Triple;", "writeHprofRecords", "firstId", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class HprofDeobfuscator {
    public static /* synthetic */ File deobfuscate$default(HprofDeobfuscator hprofDeobfuscator, ProguardMapping proguardMapping, File file, File file2, int i, Object obj) {
        if ((i & 4) != 0) {
            String parent = file.getParent();
            String name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "inputHprofFile.name");
            String it = StringsKt.replace$default(name, ".hprof", "-deobfuscated.hprof", false, 4, (Object) null);
            if (Intrinsics.areEqual(it, file.getName())) {
                it = file.getName() + "-deobfuscated";
            }
            file2 = new File(parent, it);
        }
        return hprofDeobfuscator.deobfuscate(proguardMapping, file, file2);
    }

    public final File deobfuscate(ProguardMapping proguardMapping, File inputHprofFile, File outputHprofFile) {
        Intrinsics.checkParameterIsNotNull(proguardMapping, "proguardMapping");
        Intrinsics.checkParameterIsNotNull(inputHprofFile, "inputHprofFile");
        Intrinsics.checkParameterIsNotNull(outputHprofFile, "outputHprofFile");
        Triple<Map<Long, String>, Map<Long, Long>, Long> readHprofRecords = readHprofRecords(inputHprofFile);
        Map hprofStringCache = (Map) readHprofRecords.component1();
        Map classNames = (Map) readHprofRecords.component2();
        long maxId = ((Number) readHprofRecords.component3()).longValue();
        return writeHprofRecords(inputHprofFile, outputHprofFile, proguardMapping, hprofStringCache, classNames, maxId + 1);
    }

    private final Triple<Map<Long, String>, Map<Long, Long>, Long> readHprofRecords(File inputHprofFile) {
        final Map hprofStringCache = new LinkedHashMap();
        final Map classNames = new LinkedHashMap();
        final Ref.LongRef maxId = new Ref.LongRef();
        maxId.element = 0L;
        StreamingRecordReaderAdapter reader = StreamingRecordReaderAdapter.Companion.asStreamingRecordReader(StreamingHprofReader.Companion.readerFor$default(StreamingHprofReader.Companion, inputHprofFile, (HprofHeader) null, 2, (Object) null));
        reader.readRecords(SetsKt.setOf(Reflection.getOrCreateKotlinClass(HprofRecord.class)), new OnHprofRecordListener() { // from class: shark.HprofDeobfuscator$readHprofRecords$1
            @Override // shark.OnHprofRecordListener
            public final void onHprofRecord(long $noName_0, HprofRecord record) {
                long coerceAtLeast;
                Intrinsics.checkParameterIsNotNull(record, "record");
                if (record instanceof HprofRecord.StringRecord) {
                    maxId.element = RangesKt.coerceAtLeast(maxId.element, ((HprofRecord.StringRecord) record).getId());
                    hprofStringCache.put(Long.valueOf(((HprofRecord.StringRecord) record).getId()), ((HprofRecord.StringRecord) record).getString());
                } else if (record instanceof HprofRecord.LoadClassRecord) {
                    maxId.element = RangesKt.coerceAtLeast(maxId.element, ((HprofRecord.LoadClassRecord) record).getId());
                    classNames.put(Long.valueOf(((HprofRecord.LoadClassRecord) record).getId()), Long.valueOf(((HprofRecord.LoadClassRecord) record).getClassNameStringId()));
                } else if (!(record instanceof HprofRecord.StackFrameRecord)) {
                    if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord) {
                        Ref.LongRef longRef = maxId;
                        if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) {
                            coerceAtLeast = RangesKt.coerceAtLeast(maxId.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getId());
                        } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) {
                            coerceAtLeast = RangesKt.coerceAtLeast(maxId.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getId());
                        } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) {
                            coerceAtLeast = RangesKt.coerceAtLeast(maxId.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) record).getId());
                        } else if (!(record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            coerceAtLeast = RangesKt.coerceAtLeast(maxId.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) record).getId());
                        }
                        longRef.element = coerceAtLeast;
                    }
                } else {
                    maxId.element = RangesKt.coerceAtLeast(maxId.element, ((HprofRecord.StackFrameRecord) record).getId());
                }
            }
        });
        return new Triple<>(hprofStringCache, classNames, Long.valueOf(maxId.element));
    }

    private final File writeHprofRecords(File inputHprofFile, File outputHprofFile, final ProguardMapping proguardMapping, final Map<Long, String> map, final Map<Long, Long> map2, long firstId) {
        final Ref.LongRef id = new Ref.LongRef();
        id.element = firstId;
        HprofHeader hprofHeader = HprofHeader.Companion.parseHeaderOf(inputHprofFile);
        final StreamingRecordReaderAdapter reader = StreamingRecordReaderAdapter.Companion.asStreamingRecordReader(StreamingHprofReader.Companion.readerFor(inputHprofFile, hprofHeader));
        HprofWriter openWriterFor = HprofWriter.Companion.openWriterFor(outputHprofFile, hprofHeader);
        try {
            final HprofWriter writer = openWriterFor;
            reader.readRecords(SetsKt.setOf(Reflection.getOrCreateKotlinClass(HprofRecord.class)), new OnHprofRecordListener() { // from class: shark.HprofDeobfuscator$writeHprofRecords$$inlined$use$lambda$1
                @Override // shark.OnHprofRecordListener
                public final void onHprofRecord(long $noName_0, HprofRecord record) {
                    Pair createDeobfuscatedClassDumpRecord;
                    HprofRecord.StringRecord createDeobfuscatedStringRecord;
                    Intrinsics.checkParameterIsNotNull(record, "record");
                    if (record instanceof HprofRecord.HeapDumpEndRecord) {
                        return;
                    }
                    if (record instanceof HprofRecord.StringRecord) {
                        HprofWriter hprofWriter = HprofWriter.this;
                        createDeobfuscatedStringRecord = this.createDeobfuscatedStringRecord((HprofRecord.StringRecord) record, proguardMapping, map);
                        hprofWriter.write(createDeobfuscatedStringRecord);
                    } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) {
                        createDeobfuscatedClassDumpRecord = this.createDeobfuscatedClassDumpRecord((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record, proguardMapping, map, map2, id.element);
                        Iterable recordsToWrite = (List) createDeobfuscatedClassDumpRecord.component1();
                        long maxId = ((Number) createDeobfuscatedClassDumpRecord.component2()).longValue();
                        id.element = maxId;
                        Iterable $this$forEach$iv = recordsToWrite;
                        for (Object element$iv : $this$forEach$iv) {
                            HprofRecord it = (HprofRecord) element$iv;
                            HprofWriter.this.write(it);
                        }
                    } else {
                        HprofWriter.this.write(record);
                    }
                }
            });
            CloseableKt.closeFinally(openWriterFor, (Throwable) null);
            return outputHprofFile;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HprofRecord.StringRecord createDeobfuscatedStringRecord(HprofRecord.StringRecord record, ProguardMapping proguardMapping, Map<Long, String> map) {
        String str = map.get(Long.valueOf(record.getId()));
        if (str == null) {
            Intrinsics.throwNpe();
        }
        String obfuscatedName = str;
        return new HprofRecord.StringRecord(record.getId(), proguardMapping.deobfuscateClassName(obfuscatedName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<HprofRecord>, Long> createDeobfuscatedClassDumpRecord(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord record, ProguardMapping proguardMapping, Map<Long, String> map, Map<Long, Long> map2, long maxId) {
        ProguardMapping proguardMapping2 = proguardMapping;
        Map<Long, String> map3 = map;
        Map<Long, Long> map4 = map2;
        List recordsToWrite = new ArrayList();
        long id = maxId;
        Iterable $this$map$iv = record.getFields();
        boolean z = false;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord field = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) item$iv$iv;
            String str = map3.get(map4.get(Long.valueOf(record.getId())));
            if (str == null) {
                Intrinsics.throwNpe();
            }
            String className = str;
            String str2 = map3.get(Long.valueOf(field.getNameStringId()));
            if (str2 == null) {
                Intrinsics.throwNpe();
            }
            String fieldName = str2;
            String deobfuscatedName = proguardMapping2.deobfuscateFieldName(className, fieldName);
            Iterable $this$map$iv2 = $this$map$iv;
            HprofRecord.StringRecord newStringRecord = new HprofRecord.StringRecord(id, deobfuscatedName);
            recordsToWrite.add(newStringRecord);
            destination$iv$iv.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord(newStringRecord.getId(), field.getType()));
            $this$map$iv = $this$map$iv2;
            z = z;
            id++;
        }
        List newFields = (List) destination$iv$iv;
        Iterable $this$map$iv3 = record.getStaticFields();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv2 : $this$map$iv3) {
            HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord field2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord) item$iv$iv2;
            String str3 = map3.get(map4.get(Long.valueOf(record.getId())));
            if (str3 == null) {
                Intrinsics.throwNpe();
            }
            String className2 = str3;
            String str4 = map3.get(Long.valueOf(field2.getNameStringId()));
            if (str4 == null) {
                Intrinsics.throwNpe();
            }
            String fieldName2 = str4;
            String deobfuscatedName2 = proguardMapping2.deobfuscateFieldName(className2, fieldName2);
            HprofRecord.StringRecord newStringRecord2 = new HprofRecord.StringRecord(id, deobfuscatedName2);
            recordsToWrite.add(newStringRecord2);
            destination$iv$iv2.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord(newStringRecord2.getId(), field2.getType(), field2.getValue()));
            proguardMapping2 = proguardMapping;
            map3 = map;
            map4 = map2;
            id++;
        }
        List newStaticFields = (List) destination$iv$iv2;
        recordsToWrite.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord(record.getId(), record.getStackTraceSerialNumber(), record.getSuperclassId(), record.getClassLoaderId(), record.getSignersId(), record.getProtectionDomainId(), record.getInstanceSize(), newStaticFields, newFields));
        return new Pair<>(recordsToWrite, Long.valueOf(id));
    }
}