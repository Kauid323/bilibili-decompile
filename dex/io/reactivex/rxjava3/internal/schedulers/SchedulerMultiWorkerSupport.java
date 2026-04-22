package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerMultiWorkerSupport {

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface WorkerCallback {
        void onWorker(int index, Scheduler.Worker worker);
    }

    void createWorkers(int number, WorkerCallback callback);
}