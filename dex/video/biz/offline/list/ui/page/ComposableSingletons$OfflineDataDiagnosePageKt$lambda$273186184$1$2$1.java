package video.biz.offline.list.ui.page;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDataDiagnosePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
/* renamed from: video.biz.offline.list.ui.page.ComposableSingletons$OfflineDataDiagnosePageKt$lambda$-273186184$1$2$1  reason: invalid class name */
public final /* synthetic */ class ComposableSingletons$OfflineDataDiagnosePageKt$lambda$273186184$1$2$1 extends FunctionReferenceImpl implements Function1<OfflineDiagnosePageEvent, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposableSingletons$OfflineDataDiagnosePageKt$lambda$273186184$1$2$1(Object obj) {
        super(1, obj, OfflineDiagnosePageStore.class, "dispatch", "dispatch(Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((OfflineDiagnosePageEvent) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(OfflineDiagnosePageEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((OfflineDiagnosePageStore) this.receiver).dispatch(p0);
    }
}