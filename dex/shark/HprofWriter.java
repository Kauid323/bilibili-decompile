package shark;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import shark.GcRoot;
import shark.Hprof;
import shark.HprofRecord;
import shark.ValueHolder;
import tv.danmaku.app.AppConfig;

/* compiled from: HprofWriter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u0019\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\f\u0010 \u001a\u00020\u0017*\u00020\u0003H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020#H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020$H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020%H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020&H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020'H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020(H\u0002J\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0014\u0010)\u001a\u00020\u0017*\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0002J\u0014\u0010,\u001a\u00020\u0017*\u00020\u00032\u0006\u0010*\u001a\u00020-H\u0002J\u0014\u0010.\u001a\u00020\u0017*\u00020\u00032\u0006\u0010*\u001a\u00020/H\u0002J\u0014\u00100\u001a\u00020\u0017*\u00020\u00032\u0006\u00101\u001a\u000202H\u0002J\u0014\u00103\u001a\u00020\u0017*\u00020\u00032\u0006\u0010!\u001a\u00020'H\u0002J-\u00104\u001a\u00020\u0017*\u00020\u00032\u0006\u00105\u001a\u00020\u00102\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001707¢\u0006\u0002\b8H\u0002J\u001c\u00109\u001a\u00020\u0017*\u00020\u00032\u0006\u00105\u001a\u00020\u00102\u0006\u0010:\u001a\u000202H\u0002J\u0014\u0010;\u001a\u00020\u0017*\u00020\u00032\u0006\u0010<\u001a\u00020\u001cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lshark/HprofWriter;", "Ljava/io/Closeable;", "sink", "Lokio/BufferedSink;", "hprofHeader", "Lshark/HprofHeader;", "(Lokio/BufferedSink;Lshark/HprofHeader;)V", "getHprofHeader", "()Lshark/HprofHeader;", "hprofVersion", "Lshark/Hprof$HprofVersion;", "getHprofVersion$annotations", "()V", "getHprofVersion", "()Lshark/Hprof$HprofVersion;", "identifierByteSize", "", "getIdentifierByteSize$annotations", "getIdentifierByteSize", "()I", "workBuffer", "Lokio/Buffer;", "close", "", "valuesToBytes", "", "values", "", "Lshark/ValueHolder;", "write", "record", "Lshark/HprofRecord;", "flushHeapBuffer", "array", "", "", "", "", "", "", "", "writeBoolean", "value", "", "writeDouble", "", "writeFloat", "", "writeId", "id", "", "writeIdArray", "writeNonHeapRecord", AppConfig.HOST_TAG, "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "writeTagHeader", "length", "writeValue", "wrapper", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class HprofWriter implements Closeable {
    public static final Companion Companion = new Companion(null);
    private final HprofHeader hprofHeader;
    private final BufferedSink sink;
    private final Buffer workBuffer;

    @Deprecated(message = "Replaced by HprofWriter.hprofHeader.version", replaceWith = @ReplaceWith(expression = "hprofHeader.version", imports = {}))
    public static /* synthetic */ void getHprofVersion$annotations() {
    }

    @Deprecated(message = "Replaced by HprofWriter.hprofHeader.identifierByteSize", replaceWith = @ReplaceWith(expression = "hprofHeader.identifierByteSize", imports = {}))
    public static /* synthetic */ void getIdentifierByteSize$annotations() {
    }

    private HprofWriter(BufferedSink sink, HprofHeader hprofHeader) {
        this.sink = sink;
        this.hprofHeader = hprofHeader;
        this.workBuffer = new Buffer();
    }

    public /* synthetic */ HprofWriter(BufferedSink sink, HprofHeader hprofHeader, DefaultConstructorMarker $constructor_marker) {
        this(sink, hprofHeader);
    }

    public final HprofHeader getHprofHeader() {
        return this.hprofHeader;
    }

    public final int getIdentifierByteSize() {
        return this.hprofHeader.getIdentifierByteSize();
    }

    public final Hprof.HprofVersion getHprofVersion() {
        return Hprof.HprofVersion.valueOf(this.hprofHeader.getVersion().name());
    }

    public final void write(HprofRecord record) {
        Intrinsics.checkParameterIsNotNull(record, "record");
        write(this.sink, record);
    }

    public final byte[] valuesToBytes(List<? extends ValueHolder> list) {
        Intrinsics.checkParameterIsNotNull(list, "values");
        Buffer valuesBuffer = new Buffer();
        List<? extends ValueHolder> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            ValueHolder value = (ValueHolder) element$iv;
            writeValue((BufferedSink) valuesBuffer, value);
        }
        byte[] readByteArray = valuesBuffer.readByteArray();
        Intrinsics.checkExpressionValueIsNotNull(readByteArray, "valuesBuffer.readByteArray()");
        return readByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushHeapBuffer(this.sink);
        this.sink.close();
    }

    private final void writeValue(BufferedSink $this$writeValue, ValueHolder wrapper) {
        if (!(wrapper instanceof ValueHolder.ReferenceHolder)) {
            if (!(wrapper instanceof ValueHolder.BooleanHolder)) {
                if (!(wrapper instanceof ValueHolder.CharHolder)) {
                    if (!(wrapper instanceof ValueHolder.FloatHolder)) {
                        if (!(wrapper instanceof ValueHolder.DoubleHolder)) {
                            if (!(wrapper instanceof ValueHolder.ByteHolder)) {
                                if (!(wrapper instanceof ValueHolder.ShortHolder)) {
                                    if (!(wrapper instanceof ValueHolder.IntHolder)) {
                                        if (wrapper instanceof ValueHolder.LongHolder) {
                                            $this$writeValue.writeLong(((ValueHolder.LongHolder) wrapper).getValue());
                                            return;
                                        }
                                        return;
                                    }
                                    $this$writeValue.writeInt(((ValueHolder.IntHolder) wrapper).getValue());
                                    return;
                                }
                                $this$writeValue.writeShort(((ValueHolder.ShortHolder) wrapper).getValue());
                                return;
                            }
                            $this$writeValue.writeByte(((ValueHolder.ByteHolder) wrapper).getValue());
                            return;
                        }
                        writeDouble($this$writeValue, ((ValueHolder.DoubleHolder) wrapper).getValue());
                        return;
                    }
                    writeFloat($this$writeValue, ((ValueHolder.FloatHolder) wrapper).getValue());
                    return;
                }
                write($this$writeValue, new char[]{((ValueHolder.CharHolder) wrapper).getValue()});
                return;
            }
            writeBoolean($this$writeValue, ((ValueHolder.BooleanHolder) wrapper).getValue());
            return;
        }
        writeId($this$writeValue, ((ValueHolder.ReferenceHolder) wrapper).getValue());
    }

    private final void write(BufferedSink $this$write, final HprofRecord record) {
        if (record instanceof HprofRecord.StringRecord) {
            writeNonHeapRecord($this$write, HprofRecordTag.STRING_IN_UTF8.getTag(), new Function1<BufferedSink, Unit>() { // from class: shark.HprofWriter$write$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((BufferedSink) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(BufferedSink $this$writeNonHeapRecord) {
                    Intrinsics.checkParameterIsNotNull($this$writeNonHeapRecord, "$receiver");
                    HprofWriter.this.writeId($this$writeNonHeapRecord, ((HprofRecord.StringRecord) record).getId());
                    $this$writeNonHeapRecord.writeUtf8(((HprofRecord.StringRecord) record).getString());
                }
            });
        } else if (record instanceof HprofRecord.LoadClassRecord) {
            writeNonHeapRecord($this$write, HprofRecordTag.LOAD_CLASS.getTag(), new Function1<BufferedSink, Unit>() { // from class: shark.HprofWriter$write$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((BufferedSink) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(BufferedSink $this$writeNonHeapRecord) {
                    Intrinsics.checkParameterIsNotNull($this$writeNonHeapRecord, "$receiver");
                    $this$writeNonHeapRecord.writeInt(((HprofRecord.LoadClassRecord) record).getClassSerialNumber());
                    HprofWriter.this.writeId($this$writeNonHeapRecord, ((HprofRecord.LoadClassRecord) record).getId());
                    $this$writeNonHeapRecord.writeInt(((HprofRecord.LoadClassRecord) record).getStackTraceSerialNumber());
                    HprofWriter.this.writeId($this$writeNonHeapRecord, ((HprofRecord.LoadClassRecord) record).getClassNameStringId());
                }
            });
        } else if (record instanceof HprofRecord.StackTraceRecord) {
            writeNonHeapRecord($this$write, HprofRecordTag.STACK_TRACE.getTag(), new Function1<BufferedSink, Unit>() { // from class: shark.HprofWriter$write$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((BufferedSink) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(BufferedSink $this$writeNonHeapRecord) {
                    Intrinsics.checkParameterIsNotNull($this$writeNonHeapRecord, "$receiver");
                    $this$writeNonHeapRecord.writeInt(((HprofRecord.StackTraceRecord) record).getStackTraceSerialNumber());
                    $this$writeNonHeapRecord.writeInt(((HprofRecord.StackTraceRecord) record).getThreadSerialNumber());
                    $this$writeNonHeapRecord.writeInt(((HprofRecord.StackTraceRecord) record).getStackFrameIds().length);
                    HprofWriter.this.writeIdArray($this$writeNonHeapRecord, ((HprofRecord.StackTraceRecord) record).getStackFrameIds());
                }
            });
        } else if (record instanceof HprofRecord.HeapDumpRecord.GcRootRecord) {
            Buffer $this$with = this.workBuffer;
            GcRoot gcRoot = ((HprofRecord.HeapDumpRecord.GcRootRecord) record).getGcRoot();
            if (gcRoot instanceof GcRoot.Unknown) {
                $this$with.writeByte(HprofRecordTag.ROOT_UNKNOWN.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.JniGlobal) {
                $this$with.writeByte(HprofRecordTag.ROOT_JNI_GLOBAL.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
                writeId((BufferedSink) $this$with, ((GcRoot.JniGlobal) gcRoot).getJniGlobalRefId());
            } else if (gcRoot instanceof GcRoot.JniLocal) {
                $this$with.writeByte(HprofRecordTag.ROOT_JNI_LOCAL.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
                $this$with.writeInt(((GcRoot.JniLocal) gcRoot).getThreadSerialNumber());
                $this$with.writeInt(((GcRoot.JniLocal) gcRoot).getFrameNumber());
            } else if (gcRoot instanceof GcRoot.JavaFrame) {
                $this$with.writeByte(HprofRecordTag.ROOT_JAVA_FRAME.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
                $this$with.writeInt(((GcRoot.JavaFrame) gcRoot).getThreadSerialNumber());
                $this$with.writeInt(((GcRoot.JavaFrame) gcRoot).getFrameNumber());
            } else if (gcRoot instanceof GcRoot.NativeStack) {
                $this$with.writeByte(HprofRecordTag.ROOT_NATIVE_STACK.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
                $this$with.writeInt(((GcRoot.NativeStack) gcRoot).getThreadSerialNumber());
            } else if (gcRoot instanceof GcRoot.StickyClass) {
                $this$with.writeByte(HprofRecordTag.ROOT_STICKY_CLASS.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.ThreadBlock) {
                $this$with.writeByte(HprofRecordTag.ROOT_THREAD_BLOCK.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
                $this$with.writeInt(((GcRoot.ThreadBlock) gcRoot).getThreadSerialNumber());
            } else if (gcRoot instanceof GcRoot.MonitorUsed) {
                $this$with.writeByte(HprofRecordTag.ROOT_MONITOR_USED.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.ThreadObject) {
                $this$with.writeByte(HprofRecordTag.ROOT_THREAD_OBJECT.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
                $this$with.writeInt(((GcRoot.ThreadObject) gcRoot).getThreadSerialNumber());
                $this$with.writeInt(((GcRoot.ThreadObject) gcRoot).getStackTraceSerialNumber());
            } else if (gcRoot instanceof GcRoot.ReferenceCleanup) {
                $this$with.writeByte(HprofRecordTag.ROOT_REFERENCE_CLEANUP.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.VmInternal) {
                $this$with.writeByte(HprofRecordTag.ROOT_VM_INTERNAL.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.JniMonitor) {
                $this$with.writeByte(HprofRecordTag.ROOT_JNI_MONITOR.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
                $this$with.writeInt(((GcRoot.JniMonitor) gcRoot).getStackTraceSerialNumber());
                $this$with.writeInt(((GcRoot.JniMonitor) gcRoot).getStackDepth());
            } else if (gcRoot instanceof GcRoot.InternedString) {
                $this$with.writeByte(HprofRecordTag.ROOT_INTERNED_STRING.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.Finalizing) {
                $this$with.writeByte(HprofRecordTag.ROOT_FINALIZING.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.Debugger) {
                $this$with.writeByte(HprofRecordTag.ROOT_DEBUGGER.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.Unreachable) {
                $this$with.writeByte(HprofRecordTag.ROOT_UNREACHABLE.getTag());
                writeId((BufferedSink) $this$with, gcRoot.getId());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) {
            Buffer $this$with2 = this.workBuffer;
            $this$with2.writeByte(HprofRecordTag.CLASS_DUMP.getTag());
            writeId((BufferedSink) $this$with2, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getId());
            $this$with2.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getStackTraceSerialNumber());
            writeId((BufferedSink) $this$with2, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getSuperclassId());
            writeId((BufferedSink) $this$with2, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getClassLoaderId());
            writeId((BufferedSink) $this$with2, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getSignersId());
            writeId((BufferedSink) $this$with2, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getProtectionDomainId());
            writeId((BufferedSink) $this$with2, 0L);
            writeId((BufferedSink) $this$with2, 0L);
            $this$with2.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getInstanceSize());
            $this$with2.writeShort(0);
            $this$with2.writeShort(((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getStaticFields().size());
            Iterable $this$forEach$iv = ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getStaticFields();
            for (Object element$iv : $this$forEach$iv) {
                HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord field = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord) element$iv;
                writeId((BufferedSink) $this$with2, field.getNameStringId());
                $this$with2.writeByte(field.getType());
                writeValue((BufferedSink) $this$with2, field.getValue());
            }
            $this$with2.writeShort(((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getFields().size());
            Iterable $this$forEach$iv2 = ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) record).getFields();
            for (Object element$iv2 : $this$forEach$iv2) {
                HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord field2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord) element$iv2;
                writeId((BufferedSink) $this$with2, field2.getNameStringId());
                $this$with2.writeByte(field2.getType());
            }
        } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) {
            Buffer $this$with3 = this.workBuffer;
            $this$with3.writeByte(HprofRecordTag.INSTANCE_DUMP.getTag());
            writeId((BufferedSink) $this$with3, ((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getId());
            $this$with3.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getStackTraceSerialNumber());
            writeId((BufferedSink) $this$with3, ((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getClassId());
            $this$with3.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getFieldValues().length);
            $this$with3.write(((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getFieldValues());
        } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) {
            Buffer $this$with4 = this.workBuffer;
            $this$with4.writeByte(HprofRecordTag.OBJECT_ARRAY_DUMP.getTag());
            writeId((BufferedSink) $this$with4, ((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) record).getId());
            $this$with4.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) record).getStackTraceSerialNumber());
            $this$with4.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) record).getElementIds().length);
            writeId((BufferedSink) $this$with4, ((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) record).getArrayClassId());
            writeIdArray((BufferedSink) $this$with4, ((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) record).getElementIds());
        } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) {
            Buffer $this$with5 = this.workBuffer;
            $this$with5.writeByte(HprofRecordTag.PRIMITIVE_ARRAY_DUMP.getTag());
            writeId((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) record).getId());
            $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) record).getStackTraceSerialNumber());
            if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.BOOLEAN.getHprofType());
                write((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) record).getArray());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.CHAR.getHprofType());
                write((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) record).getArray());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.FLOAT.getHprofType());
                write((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) record).getArray());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.DOUBLE.getHprofType());
                write((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) record).getArray());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.BYTE.getHprofType());
                $this$with5.write(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) record).getArray());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.SHORT.getHprofType());
                write((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) record).getArray());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.INT.getHprofType());
                write((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) record).getArray());
            } else if (record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) {
                $this$with5.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) record).getArray().length);
                $this$with5.writeByte(PrimitiveType.LONG.getHprofType());
                write((BufferedSink) $this$with5, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) record).getArray());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (record instanceof HprofRecord.HeapDumpRecord.HeapDumpInfoRecord) {
            Buffer $this$with6 = this.workBuffer;
            $this$with6.writeByte(HprofRecordTag.HEAP_DUMP_INFO.getTag());
            $this$with6.writeInt(((HprofRecord.HeapDumpRecord.HeapDumpInfoRecord) record).getHeapId());
            writeId((BufferedSink) $this$with6, ((HprofRecord.HeapDumpRecord.HeapDumpInfoRecord) record).getHeapNameStringId());
        } else if (record instanceof HprofRecord.HeapDumpEndRecord) {
            throw new IllegalArgumentException("HprofWriter automatically emits HeapDumpEndRecord");
        }
    }

    private final void writeDouble(BufferedSink $this$writeDouble, double value) {
        $this$writeDouble.writeLong(Double.doubleToLongBits(value));
    }

    private final void writeFloat(BufferedSink $this$writeFloat, float value) {
        $this$writeFloat.writeInt(Float.floatToIntBits(value));
    }

    private final void writeBoolean(BufferedSink $this$writeBoolean, boolean value) {
        $this$writeBoolean.writeByte(value ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeIdArray(BufferedSink $this$writeIdArray, long[] array) {
        for (long element$iv : array) {
            writeId($this$writeIdArray, element$iv);
        }
    }

    private final void write(BufferedSink $this$write, boolean[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            boolean element$iv = array[i];
            $this$write.writeByte(element$iv ? 1 : 0);
        }
    }

    private final void write(BufferedSink $this$write, char[] array) {
        $this$write.writeString(new String(array), Charsets.UTF_16BE);
    }

    private final void write(BufferedSink $this$write, float[] array) {
        for (float element$iv : array) {
            writeFloat($this$write, element$iv);
        }
    }

    private final void write(BufferedSink $this$write, double[] array) {
        for (double element$iv : array) {
            writeDouble($this$write, element$iv);
        }
    }

    private final void write(BufferedSink $this$write, short[] array) {
        for (short element$iv : array) {
            $this$write.writeShort(element$iv);
        }
    }

    private final void write(BufferedSink $this$write, int[] array) {
        for (int element$iv : array) {
            $this$write.writeInt(element$iv);
        }
    }

    private final void write(BufferedSink $this$write, long[] array) {
        for (long element$iv : array) {
            $this$write.writeLong(element$iv);
        }
    }

    private final void writeNonHeapRecord(BufferedSink $this$writeNonHeapRecord, int tag, Function1<? super BufferedSink, Unit> function1) {
        flushHeapBuffer($this$writeNonHeapRecord);
        function1.invoke(this.workBuffer);
        writeTagHeader($this$writeNonHeapRecord, tag, this.workBuffer.size());
        $this$writeNonHeapRecord.writeAll(this.workBuffer);
    }

    private final void flushHeapBuffer(BufferedSink $this$flushHeapBuffer) {
        if (this.workBuffer.size() > 0) {
            writeTagHeader($this$flushHeapBuffer, HprofRecordTag.HEAP_DUMP.getTag(), this.workBuffer.size());
            $this$flushHeapBuffer.writeAll(this.workBuffer);
            writeTagHeader($this$flushHeapBuffer, HprofRecordTag.HEAP_DUMP_END.getTag(), 0L);
        }
    }

    private final void writeTagHeader(BufferedSink $this$writeTagHeader, int tag, long length) {
        $this$writeTagHeader.writeByte(tag);
        $this$writeTagHeader.writeInt(0);
        $this$writeTagHeader.writeInt((int) length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeId(BufferedSink $this$writeId, long id) {
        switch (this.hprofHeader.getIdentifierByteSize()) {
            case 1:
                $this$writeId.writeByte((int) id);
                return;
            case 2:
                $this$writeId.writeShort((int) id);
                return;
            case 4:
                $this$writeId.writeInt((int) id);
                return;
            case 8:
                $this$writeId.writeLong(id);
                return;
            default:
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
        }
    }

    /* compiled from: HprofWriter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\rJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0010"}, d2 = {"Lshark/HprofWriter$Companion;", "", "()V", "open", "Lshark/HprofWriter;", "hprofFile", "Ljava/io/File;", "identifierByteSize", "", "hprofVersion", "Lshark/Hprof$HprofVersion;", "openWriterFor", "hprofHeader", "Lshark/HprofHeader;", "hprofSink", "Lokio/BufferedSink;", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static /* synthetic */ HprofWriter openWriterFor$default(Companion companion, File file, HprofHeader hprofHeader, int i, Object obj) {
            if ((i & 2) != 0) {
                hprofHeader = new HprofHeader(0L, null, 0, 7, null);
            }
            return companion.openWriterFor(file, hprofHeader);
        }

        public final HprofWriter openWriterFor(File hprofFile, HprofHeader hprofHeader) {
            Intrinsics.checkParameterIsNotNull(hprofFile, "hprofFile");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            BufferedSink buffer = Okio.buffer(Okio.sink(new FileOutputStream(hprofFile)));
            Intrinsics.checkExpressionValueIsNotNull(buffer, "Okio.buffer(Okio.sink(hprofFile.outputStream()))");
            return openWriterFor(buffer, hprofHeader);
        }

        public static /* synthetic */ HprofWriter openWriterFor$default(Companion companion, BufferedSink bufferedSink, HprofHeader hprofHeader, int i, Object obj) {
            if ((i & 2) != 0) {
                hprofHeader = new HprofHeader(0L, null, 0, 7, null);
            }
            return companion.openWriterFor(bufferedSink, hprofHeader);
        }

        public final HprofWriter openWriterFor(BufferedSink hprofSink, HprofHeader hprofHeader) {
            Intrinsics.checkParameterIsNotNull(hprofSink, "hprofSink");
            Intrinsics.checkParameterIsNotNull(hprofHeader, "hprofHeader");
            hprofSink.writeUtf8(hprofHeader.getVersion().getVersionString());
            hprofSink.writeByte(0);
            hprofSink.writeInt(hprofHeader.getIdentifierByteSize());
            hprofSink.writeLong(hprofHeader.getHeapDumpTimestamp());
            return new HprofWriter(hprofSink, hprofHeader, null);
        }

        public static /* synthetic */ HprofWriter open$default(Companion companion, File file, int i, Hprof.HprofVersion hprofVersion, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 4;
            }
            if ((i2 & 4) != 0) {
                hprofVersion = Hprof.HprofVersion.ANDROID;
            }
            return companion.open(file, i, hprofVersion);
        }

        @Deprecated(message = "Replaced by HprofWriter.openWriterFor()", replaceWith = @ReplaceWith(expression = "shark.HprofWriter.openWriterFor(hprofFile)", imports = {}))
        public final HprofWriter open(File hprofFile, int identifierByteSize, Hprof.HprofVersion hprofVersion) {
            Intrinsics.checkParameterIsNotNull(hprofFile, "hprofFile");
            Intrinsics.checkParameterIsNotNull(hprofVersion, "hprofVersion");
            return openWriterFor(hprofFile, new HprofHeader(0L, HprofVersion.valueOf(hprofVersion.name()), identifierByteSize, 1, null));
        }
    }
}