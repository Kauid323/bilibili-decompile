package kntr.base.http.params.interceptor;

import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import io.ktor.client.plugins.api.ClientPlugin;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.GNetPublicParamList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonParamsPluginKt_providesCommonParamsPlugin_Lambda.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001BM\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0094@¢\u0006\u0002\u0010\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/base/http/params/interceptor/CommonParamsPluginKt_providesCommonParamsPlugin_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lio/ktor/client/plugins/api/ClientPlugin;", "", "v0", "", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/GNetPublicParam;", "v1", "Lkntr/base/net/GNetPublicParamList;", "v2", "Lkntr/base/net/GInterceptor;", "compatJavaParam", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Lkotlin/Unit;)V", "create", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-params-interceptor_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommonParamsPluginKt_providesCommonParamsPlugin_Lambda extends ProducerBase<ClientPlugin<Unit>> {
    private final Set<SuspendProducer<GNetPublicParam>> v0;
    private final Set<SuspendProducer<GNetPublicParamList>> v1;
    private final Set<SuspendProducer<GInterceptor>> v2;

    public CommonParamsPluginKt_providesCommonParamsPlugin_Lambda(Set<? extends SuspendProducer<GNetPublicParam>> set, Set<? extends SuspendProducer<GNetPublicParamList>> set2, Set<? extends SuspendProducer<GInterceptor>> set3, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(set, "v0");
        Intrinsics.checkNotNullParameter(set2, "v1");
        Intrinsics.checkNotNullParameter(set3, "v2");
        this.v0 = set;
        this.v1 = set2;
        this.v2 = set3;
    }

    public CommonParamsPluginKt_providesCommonParamsPlugin_Lambda create() {
        return new CommonParamsPluginKt_providesCommonParamsPlugin_Lambda(this.v0, this.v1, this.v2, null);
    }

    protected Object invokeProducer(Continuation<? super ClientPlugin<Unit>> continuation) {
        return CommonParamsPluginKt.providesCommonParamsPlugin(this.v0, this.v1, this.v2);
    }
}