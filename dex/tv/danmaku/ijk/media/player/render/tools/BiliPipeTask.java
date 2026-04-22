package tv.danmaku.ijk.media.player.render.tools;

import java.util.concurrent.LinkedBlockingDeque;
import tv.danmaku.android.log.BLog;

public class BiliPipeTask {
    private static final String TAG = "BiliPipeTask";
    private LinkedBlockingDeque<Runnable> mLinkedTask = new LinkedBlockingDeque<>();

    public void addTask(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        synchronized (this.mLinkedTask) {
            this.mLinkedTask.add(runnable);
        }
    }

    public int currentTaskSize() {
        return this.mLinkedTask.size();
    }

    public void runPendingOnDrawTasks() {
        while (!this.mLinkedTask.isEmpty()) {
            try {
                this.mLinkedTask.take().run();
            } catch (InterruptedException e) {
                BLog.e(TAG, e.getMessage());
            }
        }
    }

    public void clearTask() {
        if (this.mLinkedTask == null) {
            return;
        }
        synchronized (this.mLinkedTask) {
            this.mLinkedTask.clear();
        }
    }
}