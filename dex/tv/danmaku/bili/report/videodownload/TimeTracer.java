package tv.danmaku.bili.report.videodownload;

import android.os.Bundle;
import android.os.SystemClock;
import com.bilibili.api.base.util.DebugLog;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;
import tv.danmaku.bili.report.startup.TimeTracer;

public class TimeTracer {
    private static final String BUNDLE_TRACER_IS_END = "bundle_tracer_is_end";
    private static final String BUNDLE_TRACER_SECTION_TYPE = "bundle_tracer_section_type";
    private static final String BUNDLE_TRACER_START_TIME = "bundle_tracer_start_time";
    public static final String TAG = "VideoDownloadTimeTracer";
    public static final String TRACER_TYPE = "video_download_aidl_time";
    private Detail mDetail;
    private String mTracerType;
    private int mSectionType = 0;
    private long mFirstBeginTime = 0;
    private long mBeginTime = 0;
    private boolean isBegin = false;
    private boolean canTrace = true;

    public TimeTracer(String tracerType) {
        this.mDetail = null;
        this.mTracerType = tracerType;
        this.mDetail = new Detail();
    }

    private void reset() {
        this.mBeginTime = 0L;
        this.mFirstBeginTime = 0L;
        this.mSectionType = 0;
        this.mDetail.clear();
        this.isBegin = false;
        this.canTrace = true;
    }

    public void beginTrace(int sectionType) {
        reset();
        this.mSectionType = sectionType;
        this.isBegin = true;
        if (BuildConfig.DEBUG) {
            DebugLog.d(TAG, " TimeTracer begin trace : " + Section.getSectionName(sectionType));
        }
    }

    public void endTrace(int sectionType) {
        endTrace(sectionType, false);
    }

    public void endTrace(int sectionType, boolean needReport) {
        if (this.mSectionType != sectionType) {
            if (BuildConfig.DEBUG) {
                DebugLog.d(TAG, " TimeTracer end trace failed : original: " + Section.getSectionName(this.mSectionType) + " , now: " + Section.getSectionName(sectionType));
                return;
            }
            return;
        }
        if (needReport) {
            ReportTrigger.recordSectionType(this.mSectionType);
            if (BuildConfig.DEBUG) {
                DebugLog.d(TAG, " TimeTracer record count +1 (SectionType " + Section.getSectionName(sectionType) + ")");
            }
            doReport();
        }
        reset();
        if (BuildConfig.DEBUG) {
            DebugLog.d(TAG, " TimeTracer end trace success");
        }
    }

    public void endTrace(Bundle bundle) {
        endTrace(bundle, false);
    }

    public void endTrace(Bundle bundle, boolean needReport) {
        int sectionType = BundleUtil.getInteger(bundle, BUNDLE_TRACER_SECTION_TYPE, new Integer[0]).intValue();
        endTrace(sectionType, needReport);
    }

    public boolean isBegin() {
        return this.isBegin;
    }

    public boolean canTrace(int sectionType) {
        this.canTrace = this.isBegin && sectionType == this.mSectionType && this.mSectionType != 0;
        if (BuildConfig.DEBUG) {
            DebugLog.d(TAG, " TimeTracer can trace : " + this.canTrace + "\n isBegin " + this.isBegin);
        }
        return this.canTrace;
    }

    public boolean canTrace(Bundle bundle) {
        int sectionType = BundleUtil.getInteger(bundle, BUNDLE_TRACER_SECTION_TYPE, new Integer[0]).intValue();
        return canTrace(sectionType);
    }

    public boolean canEnd(Bundle bundle) {
        boolean canEnd = BundleUtil.getBoolean(bundle, BUNDLE_TRACER_IS_END, new boolean[0]);
        if (BuildConfig.DEBUG) {
            DebugLog.d(TAG, " TimeTracer can end : " + canEnd);
        }
        return canEnd;
    }

    public void beginTransmitTime() {
        this.mBeginTime = getSystemTime();
        if (BuildConfig.DEBUG) {
            DebugLog.d(TAG, " TimeTracer beginTransmitTime");
        }
    }

    public static void beginTransmitTime(Bundle bundle, boolean isEnd, int sectionType) {
        bundle.putLong(BUNDLE_TRACER_START_TIME, getSystemTime());
        bundle.putInt(BUNDLE_TRACER_SECTION_TYPE, sectionType);
        bundle.putBoolean(BUNDLE_TRACER_IS_END, isEnd);
        if (BuildConfig.DEBUG) {
            DebugLog.d(TAG, " TimeTracer beginTransmitTime SectionType " + Section.getSectionName(sectionType) + ", is end " + isEnd);
        }
    }

    public void recordTransmitTime() {
        if (this.canTrace) {
            long endTransmitTime = getSystemTime();
            this.mDetail.transmitTime += (int) ((endTransmitTime - this.mBeginTime) / 1000);
            this.mBeginTime = endTransmitTime;
            if (BuildConfig.DEBUG) {
                DebugLog.d(TAG, " TimeTracer recordTransmitTime is " + this.mDetail.transmitTime + " (SectionType " + Section.getSectionName(this.mSectionType) + ")");
            }
        }
    }

    public void recordTransmitTime(Bundle bundle) {
        if (this.canTrace) {
            this.mBeginTime = BundleUtil.getLong(bundle, BUNDLE_TRACER_START_TIME, new long[0]);
            boolean canEnd = BundleUtil.getBoolean(bundle, BUNDLE_TRACER_IS_END, new boolean[0]);
            long endTransmitTime = getSystemTime();
            if (this.mFirstBeginTime == 0) {
                this.mFirstBeginTime = this.mBeginTime;
            }
            if (canEnd) {
                this.mDetail.transmitTime = (int) ((endTransmitTime - this.mFirstBeginTime) / 1000);
                if (BuildConfig.DEBUG) {
                    DebugLog.d(TAG, " TimeTracer recordTransmitTime is " + this.mDetail.transmitTime + " (SectionType " + Section.getSectionName(this.mSectionType) + ")");
                }
            } else if (BuildConfig.DEBUG) {
                DebugLog.d(TAG, " TimeTracer recordTransmitTime is " + ((int) ((endTransmitTime - this.mFirstBeginTime) / 1000)) + " (SectionType " + Section.getSectionName(this.mSectionType) + ")");
            }
            this.mBeginTime = endTransmitTime;
        }
    }

    public void recordDeserializeTime() {
        if (this.canTrace) {
            this.mDetail.deserializeTime += (int) ((getSystemTime() - this.mBeginTime) / 1000);
            if (BuildConfig.DEBUG) {
                DebugLog.d(TAG, " TimeTracer now deserializeTime is " + this.mDetail.deserializeTime + " (SectionType " + Section.getSectionName(this.mSectionType) + ")");
            }
        }
    }

    public void addCount(int count) {
        if (this.canTrace) {
            this.mDetail.totalCount += count;
            if (BuildConfig.DEBUG) {
                DebugLog.d(TAG, " TimeTracer now total count is " + this.mDetail.totalCount + " (SectionType " + Section.getSectionName(this.mSectionType) + ")");
            }
        }
    }

    private void doReport() {
        if (!this.canTrace || this.mSectionType == 0 || !ReportTrigger.isSatisfyTriggerCount(this.mSectionType) || !this.mDetail.isValid()) {
            if (BuildConfig.DEBUG) {
                DebugLog.d(TAG, " TimeTracer do report failed\n can trace " + this.canTrace + "\n section type " + Section.getSectionName(this.mSectionType) + "\n record count is " + ReportTrigger.sSectionRecords[this.mSectionType] + "\n detail is valid " + this.mDetail.isValid());
                return;
            }
            return;
        }
        InfoEyesManager.getInstance().report2(false, TaskIdConst.TABLE_SPAN_TIME, new String[]{this.mTracerType, String.valueOf(System.currentTimeMillis()), Section.getSectionName(this.mSectionType), String.valueOf(this.mDetail.getTotalTime()), "0", this.mDetail.toJsonObject().toString()});
        if (BuildConfig.DEBUG) {
            DebugLog.d(TAG, " TimeTracer do report success " + this.mTracerType + TimeTracer.Record.INDENT + Section.getSectionName(this.mSectionType) + TimeTracer.Record.INDENT + this.mDetail.getTotalTime() + "---" + this.mDetail.toJsonObject().toString() + "\n record count is " + ReportTrigger.sSectionRecords[this.mSectionType]);
        }
    }

    public static long getSystemTime() {
        return SystemClock.elapsedRealtimeNanos();
    }
}