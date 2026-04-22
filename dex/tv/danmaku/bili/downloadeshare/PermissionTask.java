package tv.danmaku.bili.downloadeshare;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.ui.PermissionsChecker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: PermissionTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/downloadeshare/PermissionTask;", "Ltv/danmaku/bili/downloadeshare/AbstractDownloadShareTask;", "<init>", "()V", "run", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "context", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PermissionTask extends AbstractDownloadShareTask {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "PermissionTask";

    /* compiled from: PermissionTask.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/downloadeshare/PermissionTask$Companion;", "", "<init>", "()V", "TAG", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask
    public void run(final FragmentActivity activity, final DownloadShareContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (activity == null) {
            return;
        }
        BLog.i(TAG, "Run.");
        PermissionsChecker.grantPermission((Activity) activity, PermissionsChecker.getLifecycle((Activity) activity), PermissionsChecker.STORAGE_PERMISSIONS, 16, activity.getString(R.string.permission_default_msg_storage)).continueWith(new Continuation() { // from class: tv.danmaku.bili.downloadeshare.PermissionTask$$ExternalSyntheticLambda0
            public final Object then(Task task) {
                Void run$lambda$0;
                run$lambda$0 = PermissionTask.run$lambda$0(activity, context, this, task);
                return run$lambda$0;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void run$lambda$0(FragmentActivity $activity, DownloadShareContext $context, PermissionTask this$0, Task it) {
        if (it.isFaulted() || it.isCancelled()) {
            BLog.i(TAG, "Not Pass, Check Show Storage Permission Alert.");
            PermissionsChecker.checkShowStoragePermissionAlert((Activity) $activity, $context.getParameter().getSpmid());
            Context context = (Context) $activity;
            Application application = BiliContext.application();
            ToastHelper.showToast(context, application != null ? application.getString(bili.resource.share.R.string.share_global_string_50) : null, 0, 17);
        } else {
            BLog.i(TAG, "Pass.");
            this$0.toNext($activity, $context);
        }
        return null;
    }
}