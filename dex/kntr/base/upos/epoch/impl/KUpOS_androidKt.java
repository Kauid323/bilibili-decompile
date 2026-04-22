package kntr.base.upos.epoch.impl;

import com.bilibili.gripper.upos.GUpOS;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.upos.UpOS;
import kntr.base.upos.UpOSTaskBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KUpOS.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"platformUpOS", "Lkntr/base/upos/UpOS;", "getPlatformUpOS", "()Lkntr/base/upos/UpOS;", "upos_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KUpOS_androidKt {
    private static final UpOS platformUpOS = new UpOS() { // from class: kntr.base.upos.epoch.impl.KUpOS_androidKt$platformUpOS$1
        private final GUpOS gUpOS;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer(), GUpOS.class, (String) null, 2, (Object) null);
            Intrinsics.checkNotNull(suspendProducer);
            this.gUpOS = (GUpOS) suspendProducer.get();
        }

        @Override // kntr.base.upos.UpOS
        public UpOSTaskBuilder newTaskBuilder(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            GUpOS.Builder gBuilder = this.gUpOS.newTaskBuilder(path);
            return new UpOSTaskBuilderImpl(gBuilder);
        }

        @Override // kntr.base.upos.UpOS
        public UpOSTaskBuilder newTaskBuilderByID(String taskId) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            GUpOS.Builder gBuilder = this.gUpOS.newTaskBuilderByID(taskId);
            return new UpOSTaskBuilderImpl(gBuilder);
        }
    };

    public static final UpOS getPlatformUpOS() {
        return platformUpOS;
    }
}