package tv.danmaku.bili.report.startup;

import android.util.Pair;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.infoeyes.TimeHelper;
import java.util.Stack;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;
import tv.danmaku.bili.report.startup.TimeTracer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
public abstract class TrackType {
    String name;
    @Deprecated
    public static final TrackType STARTUP = new AnonymousClass1("STARTUP", 0, "StartUp");
    public static final TrackType VIDEODETAIL = new AnonymousClass2("VIDEODETAIL", 1, "VideoDetails");
    private static final /* synthetic */ TrackType[] $VALUES = $values();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isEnabled();

    private static /* synthetic */ TrackType[] $values() {
        return new TrackType[]{STARTUP, VIDEODETAIL};
    }

    public static TrackType valueOf(String name) {
        return (TrackType) Enum.valueOf(TrackType.class, name);
    }

    public static TrackType[] values() {
        return (TrackType[]) $VALUES.clone();
    }

    /* renamed from: tv.danmaku.bili.report.startup.TrackType$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    enum AnonymousClass1 extends TrackType {
        private AnonymousClass1(String str, int i, String name) {
            super(str, i, name);
        }

        @Override // tv.danmaku.bili.report.startup.TrackType
        boolean isEnabled() {
            return false;
        }
    }

    /* renamed from: tv.danmaku.bili.report.startup.TrackType$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    enum AnonymousClass2 extends TrackType {
        private AnonymousClass2(String str, int i, String name) {
            super(str, i, name);
        }

        @Override // tv.danmaku.bili.report.startup.TrackType
        boolean isEnabled() {
            return BiliContext.isMainProcess();
        }
    }

    private TrackType(String str, int i, String name) {
        this.name = name;
    }

    public String getFileName() {
        return "TimeLog-" + this.name + ".trace";
    }

    public void doReport(TimeTracer.Record record) {
        TimeTracer.Record record2 = record;
        long currTime = System.currentTimeMillis();
        String seqId = String.valueOf(currTime);
        Pair<String, String[]>[] pairs = new Pair[record2.childrens.size()];
        Stack<TimeTracer.Record> childrens = record2.childrens;
        int size = childrens.size();
        int i = 0;
        while (i < size) {
            TimeTracer.Record r = childrens.get(i);
            int i2 = i;
            Pair<String, String[]>[] pairs2 = pairs;
            String[] args = {"type", this.name, "session_id", seqId, "section", r.name, "time", String.valueOf(r.interval), "crash", String.valueOf(record2.code), "detail", JSON.toJSONString(r.childrens)};
            pairs2[i2] = Pair.create(TimeHelper.getSecondsTimestampString(currTime), args);
            i = i2 + 1;
            pairs = pairs2;
            childrens = childrens;
            size = size;
            record2 = record;
        }
        InfoEyesManager.getInstance().report2(true, TaskIdConst.TABLE_SPAN_TIME, pairs);
    }
}