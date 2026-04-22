package kntr.base.upos;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: KUpOS.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0001¨\u0006\n"}, d2 = {"Lkntr/base/upos/KUpOS;", "Lkntr/base/upos/UpOS;", "<init>", "()V", "newTaskBuilder", "Lkntr/base/upos/UpOSTaskBuilder;", "path", "", "newTaskBuilderByID", "taskId", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KUpOS implements UpOS {
    public static final KUpOS INSTANCE = new KUpOS();
    private final /* synthetic */ UpOS $$delegate_0;

    @Override // kntr.base.upos.UpOS
    public UpOSTaskBuilder newTaskBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return this.$$delegate_0.newTaskBuilder(str);
    }

    @Override // kntr.base.upos.UpOS
    public UpOSTaskBuilder newTaskBuilderByID(String str) {
        Intrinsics.checkNotNullParameter(str, "taskId");
        return this.$$delegate_0.newTaskBuilderByID(str);
    }

    private KUpOS() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        this.$$delegate_0 = ((UpOSEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(UpOSEntryPoint.class))).getUpOS();
    }
}