package kntr.base.upos.epoch.impl;

import com.bilibili.gripper.upos.GUpOS;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.upos.UpOSCallback;
import kntr.base.upos.UpOSTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KUpOS.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/base/upos/epoch/impl/UpOSTaskImpl;", "Lkntr/base/upos/UpOSTask;", "gTask", "Lcom/bilibili/gripper/upos/GUpOS$Task;", "<init>", "(Lcom/bilibili/gripper/upos/GUpOS$Task;)V", "start", "", "pause", "delete", "addUploadCallback", "callback", "Lkntr/base/upos/UpOSCallback;", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class UpOSTaskImpl implements UpOSTask {
    private final GUpOS.Task gTask;

    public UpOSTaskImpl(GUpOS.Task gTask) {
        Intrinsics.checkNotNullParameter(gTask, "gTask");
        this.gTask = gTask;
    }

    @Override // kntr.base.upos.UpOSTask
    public void start() {
        this.gTask.start();
    }

    @Override // kntr.base.upos.UpOSTask
    public void pause() {
        this.gTask.pause();
    }

    @Override // kntr.base.upos.UpOSTask
    public void delete() {
        this.gTask.delete();
    }

    @Override // kntr.base.upos.UpOSTask
    public void addUploadCallback(final UpOSCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.gTask.addUploadCallback(new GUpOS.UploadCallback() { // from class: kntr.base.upos.epoch.impl.UpOSTaskImpl$addUploadCallback$1
            public void onCancel(GUpOS.UploadTaskInfo taskInfo) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onCancel(new UpOSTaskInfoImpl(taskInfo));
            }

            public void onFail(GUpOS.UploadTaskInfo taskInfo, int error) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onFail(new UpOSTaskInfoImpl(taskInfo), error);
            }

            public void onPause(GUpOS.UploadTaskInfo taskInfo) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onPause(new UpOSTaskInfoImpl(taskInfo));
            }

            public void onProgress(GUpOS.UploadTaskInfo taskInfo, float progress) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onProgress(new UpOSTaskInfoImpl(taskInfo), progress);
            }

            public void onResume(GUpOS.UploadTaskInfo taskInfo) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onResume(new UpOSTaskInfoImpl(taskInfo));
            }

            public void onSpeed(GUpOS.UploadTaskInfo taskInfo, long speed, long remainTime) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onSpeed(new UpOSTaskInfoImpl(taskInfo), String.valueOf(speed), String.valueOf(remainTime));
            }

            public void onStart(GUpOS.UploadTaskInfo taskInfo) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onStart(new UpOSTaskInfoImpl(taskInfo));
            }

            public void onSuccess(GUpOS.UploadTaskInfo taskInfo, String resultFile) {
                Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                UpOSCallback.this.onSuccess(new UpOSTaskInfoImpl(taskInfo), resultFile);
            }
        });
    }
}