package tv.danmaku.bili.report.biz.api.consume;

import android.content.Context;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

public interface IReporter {
    void report(Context context, ReportEvent reportEvent);
}