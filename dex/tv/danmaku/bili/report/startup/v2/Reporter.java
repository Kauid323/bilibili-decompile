package tv.danmaku.bili.report.startup.v2;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.gripper.GripperExecute;
import com.bilibili.gripper.GripperExecuteKt;
import com.bilibili.gripper.api.infoeyes.GInfoeyes;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.infoeyes.TimeHelper;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;
import tv.danmaku.bili.report.startup.StartupApm;

/* JADX INFO: Access modifiers changed from: package-private */
public final class Reporter {
    private static final int DURATION_THRESHOLD = 30000;
    private static final int LEVEL_ROOT = 0;
    private static final String TAG = "BootTracer-Reporter";
    private static List<IReportArgsFilter> mFilterList = new ArrayList();
    private static final String SESSION_ID = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IReportArgsFilter {
        void filteReportList(CopyOnWriteArrayList<ReportArgs> copyOnWriteArrayList);
    }

    Reporter() {
    }

    static {
        mFilterList.add(new SplashTimeFilter());
        mFilterList.add(new ApmRecordFilter());
    }

    public static void doReport(final TraceNode node, final int state) {
        if (node == null) {
            StartUpUtilsKt.startUpTrace("condition not match, skip this report!");
        } else {
            HandlerThreads.getHandler(1).post(new Runnable() { // from class: tv.danmaku.bili.report.startup.v2.Reporter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Reporter.lambda$doReport$0(TraceNode.this, state);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$doReport$0(TraceNode node, int state) {
        StartUpUtilsKt.startUpTrace(formatToString(0, node, new StringBuilder().append("Tracer finished \n")));
        CopyOnWriteArrayList<ReportArgs> reportArgs = new CopyOnWriteArrayList<>();
        performNodeTravels(0, node, state, reportArgs);
        filteReportList(reportArgs);
        if (BootTracer.checkEnvironment()) {
            doReport(reportArgs);
        } else {
            StartUpUtilsKt.startUpTrace("condition not match, skip this report!");
        }
        node.reset();
    }

    private static synchronized void performNodeTravels(int level, TraceNode node, int state, List<ReportArgs> reportList) {
        synchronized (Reporter.class) {
            ReportArgs argItem = nodeToReportArg(node, level, state);
            if (argItem.checkArgsValid()) {
                int level2 = level + 1;
                reportList.add(argItem);
                List<TraceNode> subNodes = node.getSubNodes();
                if (subNodes.size() > 0) {
                    for (TraceNode item : subNodes) {
                        performNodeTravels(level2, item, state, reportList);
                    }
                }
            } else {
                StartUpUtilsKt.startUpTrace("report item invalid : " + argItem.toLogString());
            }
        }
    }

    private static void filteReportList(CopyOnWriteArrayList<ReportArgs> reportList) {
        for (IReportArgsFilter filter : mFilterList) {
            filter.filteReportList(reportList);
        }
    }

    private static ReportArgs nodeToReportArg(TraceNode node, int level, int state) {
        ReportArgs param = new ReportArgs();
        param.mDuration = node.getDuration();
        param.mModuleName = node.getTag();
        param.mLevel = level;
        param.mCode = state;
        return param;
    }

    private static boolean checkTraceValid(List<ReportArgs> reportList) {
        for (ReportArgs item : reportList) {
            if (BootTagHolder.TAG_SP_SHOW.equalsIgnoreCase(item.mModuleName)) {
                return true;
            }
        }
        return false;
    }

    private static void doReport(List<ReportArgs> reportArgs) {
        long currTime = System.currentTimeMillis();
        final Pair<String, String[]>[] pairs = new Pair[reportArgs.size()];
        for (int i = 0; i < reportArgs.size(); i++) {
            ReportArgs item = reportArgs.get(i);
            pairs[i] = Pair.create(TimeHelper.getSecondsTimestampString(currTime), item.toReportParam());
        }
        GripperExecuteKt.subscribeReady(GripperExecute.Companion.of(), GInfoeyes.class, new Function0<Unit>() { // from class: tv.danmaku.bili.report.startup.v2.Reporter.1
            public Unit invoke() {
                InfoEyesManager.getInstance().report2(true, TaskIdConst.TABLE_APP_BOOT_TRACER, pairs);
                return null;
            }
        });
        StartupApm.doReport();
        report(reportArgs);
    }

    private static void report(List<ReportArgs> reportArgs) {
        Map<String, String> extra = new HashMap<>();
        for (ReportArgs reportArg : reportArgs) {
            String moduleName = reportArg.toLowerCaseName();
            if (!TextUtils.isEmpty(moduleName)) {
                extra.put(moduleName, String.valueOf(reportArg.mDuration));
            }
        }
        Neurons.trackT(false, "main.start-up.module-duration.track", extra, 1, new Function0() { // from class: tv.danmaku.bili.report.startup.v2.Reporter$$ExternalSyntheticLambda1
            public final Object invoke() {
                return Reporter.lambda$report$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$report$1() {
        return true;
    }

    private static String formatToString(int level, TraceNode node, StringBuilder builder) {
        String format = createLevelFormat(level);
        int level2 = level + 1;
        builder.append(format);
        builder.append("[START] [").append(node.getTag()).append("] begin at [").append(node.getStart()).append("] \n");
        List<TraceNode> subNodes = node.getSubNodes();
        if (subNodes.size() > 0) {
            for (TraceNode item : subNodes) {
                formatToString(level2, item, builder);
            }
        }
        builder.append(format);
        builder.append("[-END-] [").append(node.getTag()).append("] end at [").append(node.getEnd()).append("]").append(" duration [").append(node.getDuration()).append("] \n");
        return builder.toString();
    }

    private static String createLevelFormat(int level) {
        if (level == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            builder.append("==");
        }
        return builder.toString();
    }

    private static void log(String message) {
        Log.d(TAG, message);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ReportArgs {
        long mDuration = -1;
        long mExtraTime = 0;
        String mModuleName = "";
        private int mLevel = -1;
        private int mCode = 0;
        String mExtraField = "";
        int mSelfStart = 0;

        ReportArgs() {
        }

        String[] toReportParam() {
            return new String[]{String.valueOf(this.mDuration), String.valueOf(this.mModuleName), String.valueOf(this.mLevel), String.valueOf(this.mCode), this.mExtraField, String.valueOf(this.mExtraTime), Reporter.SESSION_ID, String.valueOf(this.mSelfStart)};
        }

        boolean checkArgsValid() {
            StartUpUtilsKt.startUpTrace("checkArgsValid checkDuration = " + checkDuration() + " checkLevel = " + checkLevel() + " checkTag = " + checkTag() + " checkCode = " + checkCode());
            return checkDuration() && checkLevel() && checkTag() && checkCode();
        }

        private boolean checkDuration() {
            return this.mDuration > 0;
        }

        private boolean checkLevel() {
            return this.mLevel >= 0;
        }

        private boolean checkTag() {
            return !TextUtils.isEmpty(this.mModuleName) && BootTagHolder.checkExist(this.mModuleName);
        }

        private boolean checkCode() {
            return this.mCode == 1 || this.mCode == 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String toLogString() {
            StringBuilder builder = new StringBuilder();
            builder.append("report params \n").append("[ duration = ").append(this.mDuration).append("] \n").append("[ module_name = ").append(this.mModuleName).append("] \n").append("[ level = ").append(this.mLevel).append("] \n").append("[ code = ").append(this.mCode).append("] \n").append("[ time = ").append(this.mExtraTime).append("] \n").append("[ extra = ").append(this.mExtraField).append("] \n").append("[ session_id = ").append(Reporter.SESSION_ID).append("] \n");
            return builder.toString();
        }

        public String toLowerCaseName() {
            if ("StartUp".equalsIgnoreCase(this.mModuleName)) {
                return "start_up";
            }
            if (BootTagHolder.TAG_START_SHOW.equalsIgnoreCase(this.mModuleName)) {
                return "start_show";
            }
            if (BootTagHolder.TAG_REAL_START_SHOW.equalsIgnoreCase(this.mModuleName)) {
                return "real_start_show";
            }
            if (BootTagHolder.TAG_APP_INIT.equalsIgnoreCase(this.mModuleName)) {
                return "app_init";
            }
            if (BootTagHolder.TAG_MAIN_INIT.equalsIgnoreCase(this.mModuleName)) {
                return "main_init";
            }
            if (BootTagHolder.TAG_MAIN_FRAME_INIT.equalsIgnoreCase(this.mModuleName)) {
                return "main_frame_init";
            }
            if (BootTagHolder.TAG_SP_INIT.equalsIgnoreCase(this.mModuleName)) {
                return "splash_init";
            }
            if (BootTagHolder.TAG_SP_SHOW.equalsIgnoreCase(this.mModuleName)) {
                return "splash_show";
            }
            return "";
        }
    }
}