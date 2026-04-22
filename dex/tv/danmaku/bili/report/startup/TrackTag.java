package tv.danmaku.bili.report.startup;

import android.util.Log;
import com.bilibili.base.Applications;
import com.bilibili.lib.multidex.BiliMultiDex;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.StartChecker;
import tv.danmaku.bili.report.startup.TimeTracer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
public class TrackTag {
    String tag;
    public static final TrackTag APPLICATION = new TrackTag("APPLICATION", 0, "Application");
    public static final TrackTag APPLICATION_FIRST_START = new TrackTag("APPLICATION_FIRST_START", 1, "Application.firstStart");
    public static final TrackTag MULTIDEX = new AnonymousClass1("MULTIDEX", 2, "MultiDex.install");
    private static final /* synthetic */ TrackTag[] $VALUES = $values();

    private static /* synthetic */ TrackTag[] $values() {
        return new TrackTag[]{APPLICATION, APPLICATION_FIRST_START, MULTIDEX};
    }

    public static TrackTag valueOf(String name) {
        return (TrackTag) Enum.valueOf(TrackTag.class, name);
    }

    public static TrackTag[] values() {
        return (TrackTag[]) $VALUES.clone();
    }

    /* renamed from: tv.danmaku.bili.report.startup.TrackTag$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    enum AnonymousClass1 extends TrackTag {
        private AnonymousClass1(String str, int i, String name) {
            super(str, i, name);
        }

        @Override // tv.danmaku.bili.report.startup.TrackTag
        public void interceptRecord(TimeTracer.Record record) {
            if (BiliMultiDex.IS_VM_MULTIDEX_CAPABLE || !StartChecker.isFirstStartInThisVersion(Applications.getCurrent())) {
                if (BuildConfig.DEBUG) {
                    Log.i("TimeTracer", "Skip multidex track!");
                }
                makeNoop(record);
            }
        }
    }

    public String getTag() {
        return this.tag;
    }

    public void interceptRecord(TimeTracer.Record record) {
    }

    void makeNoop(TimeTracer.Record record) {
        record.noop = true;
    }

    private TrackTag(String str, int i, String name) {
        this.tag = name;
    }
}