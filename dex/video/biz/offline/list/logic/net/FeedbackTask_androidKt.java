package video.biz.offline.list.logic.net;

import com.bilibili.gripper.laser.GLaser;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import com.common.bili.laser.api.Laser;
import java.util.List;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;

/* compiled from: FeedbackTask.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00032\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0007"}, d2 = {"summitFeedback", "", "onSuccess", "Lkotlin/Function2;", "", "", "onFailed", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FeedbackTask_androidKt {
    public static final void summitFeedback(final Function2<? super Integer, ? super String, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Intrinsics.checkNotNullParameter(function22, "onFailed");
        LogKt.getVBLog().debug("summitFeedback.");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        GLaser gLaser = ((GLaser.Fetcher) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(GLaser.Fetcher.class))).getGLaser();
        if (gLaser != null) {
            gLaser.upload(new Laser.Request("PlayerFeedback", (String) null, (List) null, 6, (DefaultConstructorMarker) null), new Laser.Callback() { // from class: video.biz.offline.list.logic.net.FeedbackTask_androidKt$summitFeedback$1
                public void onSuccess(int code, String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    LogKt.getVBLog().debug("Log uploading successfully by Laser.");
                    function2.invoke(Integer.valueOf(code), url);
                }

                public void onFailed(int errorCode, String msg) {
                    LogKt.getVBLog().debug("Log uploading failed by Laser.");
                    onFailed(errorCode, msg);
                }
            });
        }
    }
}