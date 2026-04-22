package kntr.base.net.comm.imp;

import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.GnetKt;
import kntr.base.net.MutableRequest;
import kntr.base.net.PHASE;
import kntr.base.net.Request;
import kntr.base.net.RequestHook;
import kntr.base.net.freedata.GFreeData;
import kntr.base.net.freedata.Result;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FreeDataImp.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"ISP_HEADER_TF_ISP", "", "USER_AGENT", "ISP_FLAG_CU", "ISP_FLAG_CM", "ISP_FLAG_CT", "provideFreeDataRequest", "Lkntr/base/net/GInterceptor;", "freeDataProducer", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/freedata/GFreeData;", "toIpsStr", "provider", "free_data_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FreeDataImpKt {
    public static final String ISP_FLAG_CM = "cm";
    public static final String ISP_FLAG_CT = "ct";
    public static final String ISP_FLAG_CU = "cu";
    public static final String ISP_HEADER_TF_ISP = "X-Tf-Isp";
    public static final String USER_AGENT = "User-Agent";

    public static final GInterceptor provideFreeDataRequest(final SuspendProducer<GFreeData> suspendProducer) {
        Intrinsics.checkNotNullParameter(suspendProducer, "freeDataProducer");
        return new RequestHook("free_data", PHASE.FREE_DATA, new Function1() { // from class: kntr.base.net.comm.imp.FreeDataImpKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideFreeDataRequest$lambda$0;
                provideFreeDataRequest$lambda$0 = FreeDataImpKt.provideFreeDataRequest$lambda$0(suspendProducer, (Request) obj);
                return provideFreeDataRequest$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideFreeDataRequest$lambda$0(SuspendProducer $freeDataProducer, Request req) {
        MutableRequest request;
        Intrinsics.checkNotNullParameter(req, "req");
        GFreeData freeData = (GFreeData) $freeDataProducer.getOrNull();
        if (freeData == null) {
            GnetKt.log(req, "freeData", "GFreeData not init");
        }
        boolean z = false;
        if (freeData != null && freeData.getEnabled()) {
            z = true;
        }
        if (z) {
            Result it = freeData.transform(req.getUrl());
            if (it.getTf()) {
                request = req.copy();
                GnetKt.log(request, "freeData", request.getUrl() + " -> " + it.getUrl());
                request.setUrl(it.getUrl());
                String isp = toIpsStr(it.getProvider());
                request.header(ISP_HEADER_TF_ISP, isp);
                String ua = request.header("User-Agent");
                String newUa = ua + ";tf:" + isp;
                request.header("User-Agent", newUa);
            } else {
                request = req.copy();
                String isp2 = toIpsStr(it.getProvider());
                request.header(ISP_HEADER_TF_ISP, isp2);
                String ua2 = request.header("User-Agent");
                String newUa2 = ua2 + ";tf:" + isp2;
                request.header("User-Agent", newUa2);
            }
            return request;
        }
        return req;
    }

    public static final String toIpsStr(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        switch (provider.hashCode()) {
            case -2015525726:
                if (provider.equals("MOBILE")) {
                    return ISP_FLAG_CM;
                }
                break;
            case -1787213167:
                if (provider.equals("UNICOM")) {
                    return ISP_FLAG_CU;
                }
                break;
            case -711380617:
                if (provider.equals("TELECOM")) {
                    return ISP_FLAG_CT;
                }
                break;
        }
        return "";
    }
}