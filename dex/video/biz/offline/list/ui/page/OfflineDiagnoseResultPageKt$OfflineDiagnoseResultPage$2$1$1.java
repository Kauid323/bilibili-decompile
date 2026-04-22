package video.biz.offline.list.ui.page;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineResolveDataStore;
import video.biz.offline.list.logic.statemachine.OfflineResolvePageEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnoseResultPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final /* synthetic */ class OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$2$1$1 extends FunctionReferenceImpl implements Function1<OfflineResolvePageEvent, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineDiagnoseResultPageKt$OfflineDiagnoseResultPage$2$1$1(Object obj) {
        super(1, obj, OfflineResolveDataStore.class, "dispatch", "dispatch(Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((OfflineResolvePageEvent) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(OfflineResolvePageEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((OfflineResolveDataStore) this.receiver).dispatch(p0);
    }
}