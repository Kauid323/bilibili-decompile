package tv.danmaku.bili.report.startup;

import android.os.SystemClock;
import android.util.Log;
import androidx.core.os.TraceCompat;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.base.Applications;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.StringFormatter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Callable;
import tv.danmaku.bili.BuildConfig;

public final class TimeTracer {
    public static final int CODE_CRASH = 1;
    public static final int CODE_NORMAL = 0;
    static final String TAG = "TimeTracer";
    static final Map<TrackType, Record> sRecordMap = new HashMap();

    public static void begin(TrackType type) {
        if (!type.isEnabled()) {
            return;
        }
        synchronized (sRecordMap) {
            Record record = sRecordMap.get(type);
            if (record == null) {
                Record record2 = new Record(type.name).begin(0L);
                sRecordMap.put(type, record2);
            } else {
                Log.w(TAG, "You cannot re-launch a tracer before it end.");
            }
        }
    }

    public static void end(TrackType type, int code) {
        Record r;
        if (canNotProcess(type, "end")) {
            return;
        }
        synchronized (sRecordMap) {
            r = sRecordMap.remove(type);
        }
        r.end(code);
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Track over!\n" + r.toString());
        }
        type.doReport(r);
    }

    public static void beginSession(TrackType type, TrackTag tracker) {
        Record record = new Record(tracker.tag);
        tracker.interceptRecord(record);
        beginInner(type, record);
    }

    public static void beginSession(TrackType type, String name) {
        beginInner(type, new Record(name));
    }

    private static void beginInner(TrackType type, Record record) {
        if (BuildConfig.DEBUG) {
            TraceCompat.beginSection(type.name + "-" + record.name);
        }
        if (canNotProcess(type, record.name)) {
            return;
        }
        synchronized (sRecordMap) {
            Record mainRecord = sRecordMap.get(type);
            if (mainRecord != null && !mainRecord.isFinish()) {
                mainRecord.insert(record.begin(mainRecord.begin));
            }
            Log.e(TAG, "You cannot insert a record after mainRecord finished!");
        }
    }

    public static void endSession(TrackType type, String name) {
        endSessionInner(type, name, 0);
    }

    public static void endSession(TrackType type, String name, int code) {
        endSessionInner(type, name, code);
    }

    public static void endSession(TrackType type, TrackTag tag) {
        endSessionInner(type, tag.getTag(), 0);
    }

    public static void endSession(TrackType type, TrackTag tag, int code) {
        endSessionInner(type, tag.getTag(), code);
    }

    private static void endSessionInner(TrackType type, String name, int code) {
        if (BuildConfig.DEBUG) {
            TraceCompat.endSection();
        }
        if (canNotProcess(type, name)) {
            return;
        }
        synchronized (sRecordMap) {
            Record record = sRecordMap.get(type);
            if (record != null) {
                record = record.findActive();
            }
            if (record != null) {
                if (!name.equals(record.name)) {
                    return;
                }
                if (record.noop) {
                    record.parent.childrens.pop();
                } else {
                    record.end(code);
                }
            }
        }
    }

    private static boolean canNotProcess(TrackType type, String name) {
        if (!type.isEnabled()) {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, StringFormatter.format("Not track %s.%s, disabled.", new Object[]{type.name, name}));
            }
            return true;
        } else if (hasBegin(type)) {
            return false;
        } else {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, StringFormatter.format("Not track %s.%s, no TimeTracer.begin()", new Object[]{type.name, name}));
            }
            return true;
        }
    }

    private static boolean hasBegin(TrackType type) {
        boolean z;
        synchronized (sRecordMap) {
            z = sRecordMap.get(type) != null;
        }
        return z;
    }

    public static void reportLastTrace(final TrackType type) {
        readFromFile(type).continueWith(new Continuation() { // from class: tv.danmaku.bili.report.startup.TimeTracer$$ExternalSyntheticLambda0
            public final Object then(Task task) {
                return TimeTracer.lambda$reportLastTrace$0(TrackType.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$reportLastTrace$0(TrackType type, Task task) throws Exception {
        if (task.isCompleted() && !task.isFaulted()) {
            Record mainRecord = (Record) task.getResult();
            type.doReport(mainRecord);
            deleteFile(type);
            return null;
        }
        return null;
    }

    private static void deleteFile(TrackType type) {
        String path = Applications.getCurrent().getFilesDir().getAbsolutePath() + File.separator + type.getFileName();
        File file = new File(path);
        file.delete();
    }

    @Deprecated
    private static void writeToFile(TrackType type) {
        OutputStream stream = null;
        try {
            try {
                stream = Applications.getCurrent().openFileOutput(type.getFileName(), 0);
                IOUtils.write(getTrackJSON(type), stream);
                synchronized (sRecordMap) {
                    sRecordMap.remove(type);
                }
            } catch (IOException e) {
                e.printStackTrace();
                synchronized (sRecordMap) {
                    sRecordMap.remove(type);
                }
            }
            IOUtils.closeQuietly(stream);
        } catch (Throwable th) {
            synchronized (sRecordMap) {
                sRecordMap.remove(type);
                IOUtils.closeQuietly(stream);
                throw th;
            }
        }
    }

    private static Task<Record> readFromFile(final TrackType type) {
        return Task.callInBackground(new Callable<Record>() { // from class: tv.danmaku.bili.report.startup.TimeTracer.1
            @Override // java.util.concurrent.Callable
            public Record call() throws Exception {
                InputStream stream = null;
                try {
                    try {
                        stream = Applications.getCurrent().openFileInput(TrackType.this.getFileName());
                        String string = IOUtils.toString(stream);
                        return (Record) JSON.parseObject(string, Record.class);
                    } catch (IOException e) {
                        throw e;
                    }
                } finally {
                    IOUtils.closeQuietly(stream);
                }
            }
        });
    }

    public static String getTrackString(TrackType type) {
        String record;
        if (!type.isEnabled()) {
            return "";
        }
        synchronized (sRecordMap) {
            Record record2 = sRecordMap.get(type);
            record = record2 != null ? record2.toString() : "";
        }
        return record;
    }

    private static String getTrackJSON(TrackType type) {
        String jSONString;
        if (!type.isEnabled()) {
            return "";
        }
        synchronized (sRecordMap) {
            jSONString = JSON.toJSONString(sRecordMap.get(type));
        }
        return jSONString;
    }

    public static boolean isFinish(TrackType type) {
        boolean z;
        synchronized (sRecordMap) {
            Record mainRecord = sRecordMap.get(type);
            z = mainRecord != null && mainRecord.isFinish();
        }
        return z;
    }

    protected static long time() {
        return SystemClock.elapsedRealtime();
    }

    public static void reset(TrackType type) {
        synchronized (sRecordMap) {
            if (type.isEnabled() && sRecordMap.get(type) != null) {
                Record mainRecord = sRecordMap.get(type);
                if (mainRecord.childrens != null) {
                    mainRecord.childrens.clear();
                    mainRecord.childrens = null;
                }
                sRecordMap.remove(type);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Record implements Iterable<Record> {
        public static final String INDENT = "--";
        @JSONField(name = "D", ordinal = 4)
        public Stack<Record> childrens;
        @JSONField(name = "C", ordinal = 3)
        public int code;
        @JSONField(name = "N")
        public String name;
        private transient Record next;
        transient boolean noop;
        private transient Record parent;
        @JSONField(name = "O", ordinal = 1)
        public long offset = 0;
        @JSONField(name = "T", ordinal = 2)
        public long interval = -1;
        private transient long begin = -1;
        private transient long end = -1;

        public Record() {
        }

        Record(String name) {
            this.name = name;
        }

        Record begin(long rootBeginTime) {
            this.begin = TimeTracer.time();
            if (rootBeginTime > 0) {
                this.offset = this.begin - rootBeginTime;
            }
            return this;
        }

        Record end(int code) {
            this.code = code;
            this.end = TimeTracer.time();
            this.interval = this.end - this.begin;
            return this;
        }

        Record findActive() {
            if (isFinish()) {
                return null;
            }
            if (this.childrens == null || this.childrens.peek().isFinish()) {
                return this;
            }
            return this.childrens.peek().findActive();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isFinish() {
            return this.end != -1;
        }

        void insert(Record record) {
            if (this.childrens == null) {
                this.childrens = new Stack<>();
            }
            if (this.childrens.size() == 0) {
                this.next = record;
                record.parent = this;
                this.childrens.push(record);
                return;
            }
            Record peek = this.childrens.peek();
            if (!peek.isFinish()) {
                peek.insert(record);
                return;
            }
            record.parent = this;
            this.childrens.peek().next = record;
            this.childrens.push(record);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            toStringInner(0, sb);
            return sb.toString();
        }

        private void toStringInner(int level, StringBuilder sb) {
            for (int i = 0; i < level; i++) {
                sb.append(INDENT);
            }
            sb.append("|START|=>[").append(this.name).append("] at:").append(this.begin).append("\n");
            if (this.childrens != null) {
                Iterator<Record> it = this.childrens.iterator();
                while (it.hasNext()) {
                    Record rc = it.next();
                    rc.toStringInner(level + 1, sb);
                }
            }
            for (int i2 = 0; i2 < level; i2++) {
                sb.append(INDENT);
            }
            sb.append("|End|=>[").append(this.name).append("](code:").append(this.code).append(", time:").append(this.interval).append(")").append(this.name).append(" at:").append(this.end).append("\n");
        }

        @Override // java.lang.Iterable
        public Iterator<Record> iterator() {
            return new Iterator<Record>() { // from class: tv.danmaku.bili.report.startup.TimeTracer.Record.1
                Record cursor;

                {
                    this.cursor = Record.this;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.cursor.next != null;
                }

                @Override // java.util.Iterator
                public Record next() {
                    Record next = this.cursor.next;
                    this.cursor = next;
                    return next;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            };
        }
    }
}