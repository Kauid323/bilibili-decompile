package tv.danmaku.bili.report.startup.v2;

import com.bilibili.base.BiliContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.startup.v2.TraceNode;

public class BootTracer {
    public static final int END_CRASH = 1;
    static final int END_NORMAL = 0;
    private static final String TAG = "BootTracer";
    private static TraceNode mRootNode = null;
    private static AtomicBoolean mInvalid = new AtomicBoolean(false);
    private static List<TraceNode.INodeFilter> mNodeFilters = Collections.synchronizedList(new ArrayList());
    private static boolean mFromLauncher = false;
    private static final AtomicBoolean hasPrivacy = new AtomicBoolean(false);
    private static final AtomicBoolean firstLaunch = new AtomicBoolean(false);

    static {
        mNodeFilters.add(new SplashNodeFilter());
    }

    public static synchronized void begin() {
        synchronized (BootTracer.class) {
            if (mRootNode == null) {
                StartUpUtilsKt.startUpTrace("create tag: StartUp");
                mRootNode = TraceNode.createBeginNode("StartUp");
            } else {
                StartUpUtilsKt.startUpTrace("have you invoke #begin() more than once?");
            }
        }
    }

    public static synchronized void end(int state) {
        synchronized (BootTracer.class) {
            if (mRootNode != null) {
                StartUpUtilsKt.startUpTrace("end tag: StartUp");
                mRootNode.endUpdate(TraceNode.createEndNode("StartUp"));
            } else {
                StartUpUtilsKt.startUpTrace("invoke #begin() first !");
            }
            Reporter.doReport(mRootNode, state);
        }
    }

    public static synchronized void end() {
        synchronized (BootTracer.class) {
            end(0);
        }
    }

    public static synchronized void beginSession(String tag) {
        synchronized (BootTracer.class) {
            if (mRootNode != null) {
                TraceNode node = TraceNode.createBeginNode(tag);
                StartUpUtilsKt.startUpTrace("beginSession current node = " + node);
                if (!dropCurrentNode(node)) {
                    mRootNode.beginInsert(node);
                } else {
                    StartUpUtilsKt.startUpTrace("begin : current node was dropped : " + tag);
                }
            }
        }
    }

    public static synchronized void endSession(String tag) {
        synchronized (BootTracer.class) {
            if (mRootNode != null) {
                TraceNode node = TraceNode.createEndNode(tag);
                StartUpUtilsKt.startUpTrace("endSession current node = " + node);
                BLog.i(TAG, "end tag: " + tag);
                if (!dropCurrentNode(node)) {
                    mRootNode.endUpdate(node);
                } else {
                    StartUpUtilsKt.startUpTrace("end : current node was dropped : " + tag);
                }
            }
        }
    }

    public static synchronized void setSession(String tag, long duration) {
        synchronized (BootTracer.class) {
            if (mRootNode != null) {
                TraceNode node = TraceNode.createDurationNode(tag, duration);
                StartUpUtilsKt.startUpTrace("setSession 1 current node = " + node);
                if (!dropCurrentNode(node)) {
                    mRootNode.insertDirectly(node);
                } else {
                    StartUpUtilsKt.startUpTrace("setSession : current node was dropped : " + tag);
                }
            }
        }
    }

    public static synchronized void setSession(String tag, long start, long duration) {
        synchronized (BootTracer.class) {
            if (mRootNode != null) {
                TraceNode node = TraceNode.createDurationNode(tag, start, duration);
                StartUpUtilsKt.startUpTrace("setSession 2 current node = " + node);
                if (!dropCurrentNode(node)) {
                    mRootNode.insertDirectly(node);
                } else {
                    StartUpUtilsKt.startUpTrace("setSession : current node was dropped : " + tag);
                }
            }
        }
    }

    public static synchronized boolean isFinish() {
        boolean z;
        synchronized (BootTracer.class) {
            if (mRootNode != null) {
                z = mRootNode.isFinish();
            }
        }
        return z;
    }

    public static void dropCurrentTrace() {
        StartUpUtilsKt.startUpTrace("dropCurrentTrace");
        mInvalid.set(true);
    }

    public static void setFirstLaunch() {
        firstLaunch.set(true);
    }

    public static void setHasPrivacy() {
        hasPrivacy.set(true);
    }

    public static AtomicBoolean getFirstLaunch() {
        return firstLaunch;
    }

    public static AtomicBoolean getHasPrivacy() {
        return hasPrivacy;
    }

    public static boolean checkEnvironment() {
        StartUpUtilsKt.startUpTrace("checkEnvironment isMainProc = " + isMainProc() + " !mInvalid = " + (!mInvalid.get()) + " mFromLauncher = " + mFromLauncher);
        return isMainProc() && !mInvalid.get() && mFromLauncher;
    }

    public static void setFromLauncher(boolean fromLauncher) {
        StartUpUtilsKt.startUpTrace("setFromLauncher = " + fromLauncher);
        mFromLauncher = fromLauncher;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean dropCurrentNode(TraceNode node) {
        for (TraceNode.INodeFilter filter : mNodeFilters) {
            if (node == null || filter.dropCurrent(node)) {
                return true;
            }
            while (r0.hasNext()) {
            }
        }
        return false;
    }

    private static boolean isMainProc() {
        return BiliContext.isMainProcess();
    }
}