package kntr.base.net.comm.lbs;

import com.bilibili.lib.gripper.api.PreTrigger;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.GLbs;
import kntr.base.net.comm.GMultiDomain;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

/* compiled from: LbsProducer.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "producerLbs", "Lkntr/base/net/comm/GLbs;", "multDomain", "Lkntr/base/net/comm/GMultiDomain;", "lbs_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LbsProducerKt {
    private static final String TAG = "http.lb";

    @PreTrigger(trigger = "OnAttach")
    public static final GLbs producerLbs(GMultiDomain multDomain) {
        Intrinsics.checkNotNullParameter(multDomain, "multDomain");
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new LbsProducerKt$producerLbs$1(multDomain, null), 3, (Object) null);
        return new GLbs() { // from class: kntr.base.net.comm.lbs.LbsProducerKt$producerLbs$2
            @Override // kntr.base.net.comm.GLbs
            public String lbs(String host) {
                Intrinsics.checkNotNullParameter(host, "host");
                String newHost = Lbs.INSTANCE.maybeChangeHost(host);
                if (Intrinsics.areEqual(newHost, host)) {
                    return null;
                }
                KLog_androidKt.getKLog().i("http.lb", "Replace " + host + " with " + newHost + " for load balance");
                return newHost;
            }
        };
    }
}