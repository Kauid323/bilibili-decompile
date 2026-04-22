package tv.danmaku.ijk.media.player.misc;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import tv.danmaku.android.log.BLog;

public class MediaCodecInterface {
    private static final int ASYNC_CREATE_TIMEOUT = 4500;
    private static final int MAX_TASK_NUM = 3;
    private static final String TAG = "MediaCodecInterface";
    private static final List<HashMap<String, MediaCodecCreateTask>> mTaskMapList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class MediaCodecCreateTask {
        private MediaCodec mCodec;
        boolean taskFinished;

        private MediaCodecCreateTask() {
            this.mCodec = null;
            this.taskFinished = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MediaCodec GetMediaCodec() {
            return this.mCodec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void SetMediaCodec(MediaCodec codec) {
            this.mCodec = codec;
        }
    }

    private static int GetValueByKeyFromArgs(Bundle args, String key, int defaultValue) {
        if (args == null) {
            return defaultValue;
        }
        int value = args.getInt(key, defaultValue);
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Boolean AsyncCreate(String name, MediaCodecCreateTask createTask) {
        long startTime = SystemClock.elapsedRealtime();
        try {
            MediaCodec codec = MediaCodec.createByCodecName(name);
            createTask.SetMediaCodec(codec);
        } catch (Exception e) {
            BLog.e(TAG, "AsyncCreate name=" + name + ", error=" + e);
        }
        createTask.taskFinished = true;
        long costTime = SystemClock.elapsedRealtime() - startTime;
        BLog.i(TAG, "AsyncCreate finish, name=" + name + ", cost=" + costTime + "ms");
        return true;
    }

    private static MediaCodec GetCodecFromTaskMap(String name) {
        MediaCodec codec = null;
        synchronized (mTaskMapList) {
            Iterator<HashMap<String, MediaCodecCreateTask>> it = mTaskMapList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                HashMap<String, MediaCodecCreateTask> taskMap = it.next();
                MediaCodecCreateTask task = taskMap.get(name);
                if (task != null && task.taskFinished) {
                    codec = task.GetMediaCodec();
                    taskMap.remove(name);
                    break;
                }
            }
        }
        return codec;
    }

    private static int TryInitNewAsyncCreateTask(String name) {
        synchronized (mTaskMapList) {
            for (int i = 0; i < mTaskMapList.size(); i++) {
                HashMap<String, MediaCodecCreateTask> taskMap = mTaskMapList.get(i);
                if (taskMap.get(name) == null) {
                    taskMap.put(name, new MediaCodecCreateTask());
                    return i;
                }
            }
            if (mTaskMapList.size() < 3) {
                HashMap<String, MediaCodecCreateTask> taskMap2 = new HashMap<>();
                taskMap2.put(name, new MediaCodecCreateTask());
                mTaskMapList.add(taskMap2);
                return mTaskMapList.size() - 1;
            }
            return -1;
        }
    }

    public static MediaCodec createByCodecName(final String name, Bundle args) {
        MediaCodec codec = GetCodecFromTaskMap(name);
        if (codec != null) {
            BLog.i(TAG, "createByCodecName: use already created mediacodec, name=" + name);
            return codec;
        }
        final int taskIndex = TryInitNewAsyncCreateTask(name);
        if (taskIndex == -1) {
            BLog.e(TAG, "createByCodecName: too many tasks blocked, create failed, name=" + name);
        } else {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Callable<Boolean> task = new Callable() { // from class: tv.danmaku.ijk.media.player.misc.MediaCodecInterface$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean AsyncCreate;
                    AsyncCreate = MediaCodecInterface.AsyncCreate(r0, MediaCodecInterface.mTaskMapList.get(taskIndex).get(name));
                    return AsyncCreate;
                }
            };
            Future<Boolean> future = executor.submit(task);
            try {
                try {
                    future.get(4500L, TimeUnit.MILLISECONDS);
                    codec = GetCodecFromTaskMap(name);
                } catch (Exception e) {
                    BLog.e(TAG, "createByCodecName: name=" + name + ", error=" + e);
                }
            } finally {
                executor.shutdown();
            }
        }
        return codec;
    }
}