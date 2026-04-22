package leakcanary.internal.activity.screen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.squareup.leakcanary.core.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import leakcanary.internal.navigation.ViewsKt;
import shark.HprofHeader;
import shark.HprofRecord;
import shark.OnHprofRecordListener;
import shark.StreamingHprofReader;
import shark.StreamingRecordReaderAdapter;

/* compiled from: HeapDumpRenderer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lleakcanary/internal/activity/screen/HeapDumpRenderer;", "", "()V", "render", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "heapDumpFile", "Ljava/io/File;", "sourceWidth", "", "sourceHeight", "sourceBytesPerPixel", "HasDensity", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapDumpRenderer {
    public static final HeapDumpRenderer INSTANCE = new HeapDumpRenderer();

    private HeapDumpRenderer() {
    }

    /* compiled from: HeapDumpRenderer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\t\u001a\u00020\u0006*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\n\u0010\r¨\u0006\u000e"}, d2 = {"Lleakcanary/internal/activity/screen/HeapDumpRenderer$HasDensity;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "density", "", "getDensity", "()F", "dp", "getDp", "(F)F", "", "(I)F", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static final class HasDensity {
        private final float density;

        public HasDensity(Resources resources) {
            Intrinsics.checkParameterIsNotNull(resources, "resources");
            this.density = resources.getDisplayMetrics().density;
        }

        public final float getDensity() {
            return this.density;
        }

        public final float getDp(int $this$dp) {
            return $this$dp * this.density;
        }

        public final float getDp(float $this$dp) {
            return this.density * $this$dp;
        }
    }

    public final Bitmap render(Context context, File heapDumpFile, int sourceWidth, int sourceHeight, int sourceBytesPerPixel) {
        int height;
        double bytesPerPixel;
        int squareSize;
        float textHeight;
        List recordPositions;
        int i = sourceWidth;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        HasDensity $this$with = new HasDensity(resources);
        final List arrayList = new ArrayList();
        final Ref.ObjectRef currentRecord = new Ref.ObjectRef();
        currentRecord.element = null;
        final int otherColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_other);
        int stackTraceColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_stack_trace);
        int hprofStringColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_hprof_string);
        int loadClassColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_load_class);
        int classDumpColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_class_dump);
        int instanceColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_instance);
        int objectArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_object_array);
        int booleanArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_boolean_array);
        int charArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_char_array);
        int floatArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_float_array);
        int doubleArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_double_array);
        int byteArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_byte_array);
        int shortArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_short_array);
        int intArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_int_array);
        int longArrayColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_long_array);
        final Map colors = MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.StringRecord.class), Integer.valueOf(hprofStringColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.LoadClassRecord.class), Integer.valueOf(loadClassColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.class), Integer.valueOf(classDumpColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord.class), Integer.valueOf(instanceColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord.class), Integer.valueOf(objectArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump.class), Integer.valueOf(booleanArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump.class), Integer.valueOf(charArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump.class), Integer.valueOf(floatArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump.class), Integer.valueOf(doubleArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump.class), Integer.valueOf(byteArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump.class), Integer.valueOf(shortArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump.class), Integer.valueOf(intArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump.class), Integer.valueOf(longArrayColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.StackTraceRecord.class), Integer.valueOf(stackTraceColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpEndRecord.class), Integer.valueOf(otherColor)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.GcRootRecord.class), Integer.valueOf(otherColor)));
        final int appHeapColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_app);
        final int imageHeapColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_image);
        final int zygoteHeapColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_zygote);
        final int stringColor = ViewsKt.getColorCompat(context, R.color.leak_canary_heap_instance_string);
        final Ref.LongRef lastPosition = new Ref.LongRef();
        lastPosition.element = 0L;
        StreamingRecordReaderAdapter reader = StreamingRecordReaderAdapter.Companion.asStreamingRecordReader(StreamingHprofReader.Companion.readerFor$default(StreamingHprofReader.Companion, heapDumpFile, (HprofHeader) null, 2, (Object) null));
        final Map hprofStringCache = new LinkedHashMap();
        final Map classNames = new LinkedHashMap();
        reader.readRecords(SetsKt.setOf(Reflection.getOrCreateKotlinClass(HprofRecord.class)), new OnHprofRecordListener() { // from class: leakcanary.internal.activity.screen.HeapDumpRenderer$render$1$1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Multi-variable type inference failed */
            public final void onHprofRecord(long position, HprofRecord record) {
                int colorForHeapInfo;
                Intrinsics.checkParameterIsNotNull(record, "record");
                Ref.LongRef.this.element = position;
                if (record instanceof HprofRecord.StringRecord) {
                    hprofStringCache.put(Long.valueOf(((HprofRecord.StringRecord) record).getId()), ((HprofRecord.StringRecord) record).getString());
                } else if (record instanceof HprofRecord.LoadClassRecord) {
                    classNames.put(Long.valueOf(((HprofRecord.LoadClassRecord) record).getId()), Long.valueOf(((HprofRecord.LoadClassRecord) record).getClassNameStringId()));
                }
                HprofRecord.HeapDumpRecord.HeapDumpInfoRecord heapDumpInfoRecord = (HprofRecord) currentRecord.element;
                if (heapDumpInfoRecord instanceof HprofRecord.HeapDumpRecord.HeapDumpInfoRecord) {
                    String str = (String) hprofStringCache.get(Long.valueOf(heapDumpInfoRecord.getHeapNameStringId()));
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -687285992:
                                if (str.equals("zygote")) {
                                    colorForHeapInfo = zygoteHeapColor;
                                    break;
                                }
                                break;
                            case 96801:
                                if (str.equals("app")) {
                                    colorForHeapInfo = appHeapColor;
                                    break;
                                }
                                break;
                            case 100313435:
                                if (str.equals("image")) {
                                    colorForHeapInfo = imageHeapColor;
                                    break;
                                }
                                break;
                        }
                        arrayList.add(TuplesKt.to(Integer.valueOf(colorForHeapInfo), Long.valueOf(position)));
                        currentRecord.element = record;
                    }
                    colorForHeapInfo = otherColor;
                    arrayList.add(TuplesKt.to(Integer.valueOf(colorForHeapInfo), Long.valueOf(position)));
                    currentRecord.element = record;
                } else if ((heapDumpInfoRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) && Intrinsics.areEqual((String) hprofStringCache.get(classNames.get(Long.valueOf(((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) heapDumpInfoRecord).getClassId()))), "java.lang.String") && (!(record instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) || !Intrinsics.areEqual((String) hprofStringCache.get(classNames.get(Long.valueOf(((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) record).getClassId()))), "java.lang.String"))) {
                    arrayList.add(TuplesKt.to(Integer.valueOf(stringColor), Long.valueOf(position)));
                    currentRecord.element = record;
                } else if (((HprofRecord) currentRecord.element) == null) {
                    arrayList.add(TuplesKt.to(Integer.valueOf(otherColor), Long.valueOf(position)));
                    currentRecord.element = record;
                } else {
                    HprofRecord hprofRecord = (HprofRecord) currentRecord.element;
                    if (hprofRecord == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(hprofRecord.getClass()), Reflection.getOrCreateKotlinClass(record.getClass()))) {
                        List list = arrayList;
                        Map map = colors;
                        HprofRecord hprofRecord2 = (HprofRecord) currentRecord.element;
                        if (hprofRecord2 == null) {
                            Intrinsics.throwNpe();
                        }
                        list.add(TuplesKt.to(MapsKt.getValue(map, Reflection.getOrCreateKotlinClass(hprofRecord2.getClass())), Long.valueOf(position)));
                        currentRecord.element = record;
                    }
                }
            }
        });
        long heapLength = lastPosition.element;
        if (sourceBytesPerPixel > 0) {
            bytesPerPixel = sourceBytesPerPixel;
            height = (int) Math.ceil((heapLength / bytesPerPixel) / i);
        } else {
            height = sourceHeight;
            bytesPerPixel = (heapLength * 1.0d) / (i * height);
        }
        Bitmap bitmap = Bitmap.createBitmap(i, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(bitmap, "Bitmap.createBitmap(sour…Width, height, ARGB_8888)");
        Canvas canvas = new Canvas(bitmap);
        Map legend = MapsKt.mapOf(TuplesKt.to("Hprof string", Integer.valueOf(hprofStringColor)), TuplesKt.to("Class name", Integer.valueOf(loadClassColor)), TuplesKt.to("App heap", Integer.valueOf(appHeapColor)), TuplesKt.to("Image heap", Integer.valueOf(imageHeapColor)), TuplesKt.to("Zygote heap", Integer.valueOf(zygoteHeapColor)), TuplesKt.to("Other heap", Integer.valueOf(otherColor)), TuplesKt.to("Class content", Integer.valueOf(classDumpColor)), TuplesKt.to("Instance", Integer.valueOf(instanceColor)), TuplesKt.to("String", Integer.valueOf(stringColor)), TuplesKt.to("Object array", Integer.valueOf(objectArrayColor)), TuplesKt.to("Boolean array", Integer.valueOf(booleanArrayColor)), TuplesKt.to("Char array", Integer.valueOf(charArrayColor)), TuplesKt.to("Float array", Integer.valueOf(floatArrayColor)), TuplesKt.to("Double array", Integer.valueOf(doubleArrayColor)), TuplesKt.to("Byte array", Integer.valueOf(byteArrayColor)), TuplesKt.to("Short array", Integer.valueOf(shortArrayColor)), TuplesKt.to("Int array", Integer.valueOf(intArrayColor)), TuplesKt.to("Long array", Integer.valueOf(longArrayColor)), TuplesKt.to("Stack trace", Integer.valueOf(stackTraceColor)), TuplesKt.to("Heap End", Integer.valueOf(otherColor)));
        Paint legendTextPaint = new Paint(1);
        legendTextPaint.setColor(-1);
        legendTextPaint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(legendTextPaint);
        Paint legendSquareFillPaint = new Paint();
        legendSquareFillPaint.setStyle(Paint.Style.FILL);
        Paint legendSquareStrokePaint = new Paint();
        legendSquareStrokePaint.setStyle(Paint.Style.STROKE);
        legendSquareStrokePaint.setStrokeWidth($this$with.getDp(0.8f));
        legendSquareStrokePaint.setColor(-16777216);
        legendTextPaint.setColor(-16777216);
        legendTextPaint.setTextSize($this$with.getDp(16));
        Paint.FontMetrics metrics = legendTextPaint.getFontMetrics();
        float textHeight2 = metrics.descent - metrics.ascent;
        Rect xBounds = new Rect();
        List recordPositions2 = arrayList;
        double bytesPerPixel2 = bytesPerPixel;
        legendTextPaint.getTextBounds("x", 0, 1, xBounds);
        int squareSize2 = xBounds.height();
        float f = 2;
        float squarePaddingTop = (textHeight2 - squareSize2) / f;
        float squareToTextPadding = $this$with.getDp(4);
        float blockToBlockPadding = $this$with.getDp(8);
        float maxTextWidth = 0.0f;
        for (String name : legend.keySet()) {
            Bitmap bitmap2 = bitmap;
            maxTextWidth = Math.max(maxTextWidth, legendTextPaint.measureText(name));
            height = height;
            bitmap = bitmap2;
        }
        int height2 = height;
        Bitmap bitmap3 = bitmap;
        float padding = $this$with.getDp(8);
        float blockLeft = padding;
        float blockTop = padding;
        float legendWidth = i - (f * padding);
        Iterator it = legend.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map legend2 = legend;
            String name2 = (String) entry.getKey();
            int color = ((Number) entry.getValue()).intValue();
            Iterator it2 = it;
            if (squareSize2 + blockLeft + squareToTextPadding + maxTextWidth > legendWidth) {
                blockLeft = padding;
                blockTop += textHeight2;
            }
            legendSquareFillPaint.setColor(color);
            float legendWidth2 = legendWidth;
            float legendWidth3 = squareSize2;
            float f2 = blockLeft;
            canvas.drawRect(f2, blockTop + squarePaddingTop, blockLeft + legendWidth3, blockTop + squarePaddingTop + squareSize2, legendSquareFillPaint);
            canvas.drawRect(f2, blockTop + squarePaddingTop, blockLeft + squareSize2, blockTop + squarePaddingTop + squareSize2, legendSquareStrokePaint);
            float blockLeft2 = blockLeft + squareSize2 + squareToTextPadding;
            canvas.drawText(name2, blockLeft2, blockTop - metrics.ascent, legendTextPaint);
            blockLeft = blockLeft2 + maxTextWidth + blockToBlockPadding;
            it = it2;
            legendWidth = legendWidth2;
            legend = legend2;
        }
        float legendHeight = blockTop + textHeight2 + padding;
        Rect source = new Rect(0, 0, i, (int) legendHeight);
        Rect destination = new Rect(0, (int) (height2 - legendHeight), i, height2);
        canvas.drawBitmap(bitmap3, source, destination, (Paint) null);
        int height3 = height2 - ((int) legendHeight);
        Paint pixelPaint = new Paint(-2);
        pixelPaint.setStyle(Paint.Style.FILL);
        int recordIndex = 0;
        int y = 0;
        while (y < height3) {
            int height4 = height3;
            int height5 = 0;
            while (height5 < i) {
                int bitmapPosition = (y * i) + height5;
                int recordIndex2 = recordIndex;
                Rect source2 = source;
                int heapPosition = (int) (bitmapPosition * bytesPerPixel2);
                int recordIndex3 = recordIndex2;
                while (true) {
                    squareSize = squareSize2;
                    textHeight = textHeight2;
                    int bitmapPosition2 = bitmapPosition;
                    recordPositions = recordPositions2;
                    if (heapPosition > ((Number) ((Pair) recordPositions.get(recordIndex3)).getSecond()).longValue() && recordIndex3 < CollectionsKt.getLastIndex(recordPositions)) {
                        recordIndex3++;
                        recordPositions2 = recordPositions;
                        textHeight2 = textHeight;
                        squareSize2 = squareSize;
                        bitmapPosition = bitmapPosition2;
                    }
                }
                pixelPaint.setColor(((Number) ((Pair) recordPositions.get(recordIndex3)).getFirst()).intValue());
                canvas.drawPoint(height5, y, pixelPaint);
                height5++;
                recordPositions2 = recordPositions;
                recordIndex = recordIndex3;
                source = source2;
                textHeight2 = textHeight;
                squareSize2 = squareSize;
                i = sourceWidth;
            }
            y++;
            height3 = height4;
            i = sourceWidth;
        }
        return bitmap3;
    }
}