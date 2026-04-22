package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.net.GInterceptor;
import kntr.base.net.MutableRequest;
import kntr.base.net.PHASE;
import kntr.base.net.Request;
import kntr.base.net.RequestHook;
import kntr.base.net.UrlProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InitHttpsWorld.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"provideHttpsRequest", "Lkntr/base/net/GInterceptor;", "forceHttps", "", "isInWhiteList", "host", "", "HOST_WWW_IM9_COM", "HOST_MSG_BILIBILI_COM", "HOST_ELEC_BILIBILI_COM", "HOST_APP_BILIBILI_COM", "HOST_API_BILIBILI_COM", "HOST_SPACE_BILIG_COM", "HOST_MEMBER_BILIBILI_COM", "HOST_COMMENT_BILIBILI_COM", "HOST_VIP_BILIBILI_COM", "https_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitHttpsWorldKt {
    public static final String HOST_API_BILIBILI_COM = "api.bilibili.com";
    public static final String HOST_APP_BILIBILI_COM = "app.bilibili.com";
    public static final String HOST_COMMENT_BILIBILI_COM = "comment.bilibili.com";
    public static final String HOST_ELEC_BILIBILI_COM = "elec.bilibili.com";
    public static final String HOST_MEMBER_BILIBILI_COM = "member.bilibili.com";
    public static final String HOST_MSG_BILIBILI_COM = "message.bilibili.com";
    public static final String HOST_SPACE_BILIG_COM = "space.bilibili.com";
    public static final String HOST_VIP_BILIBILI_COM = "vip.bilibili.com";
    public static final String HOST_WWW_IM9_COM = "www.im9.com";

    public static final GInterceptor provideHttpsRequest() {
        return new RequestHook("WorldHttps", PHASE.COMM, new Function1() { // from class: kntr.base.net.comm.imp.InitHttpsWorldKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Request provideHttpsRequest$lambda$0;
                provideHttpsRequest$lambda$0 = InitHttpsWorldKt.provideHttpsRequest$lambda$0((Request) obj);
                return provideHttpsRequest$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideHttpsRequest$lambda$0(Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        if (!forceHttps() || !isInWhiteList(req.getHost()) || !Intrinsics.areEqual(req.getProtocol(), UrlProtocol.Companion.getHTTP())) {
            return req;
        }
        MutableRequest request = req.copy();
        request.setProtocol(UrlProtocol.Companion.getHTTPS());
        return request;
    }

    public static final boolean forceHttps() {
        return KConfig.INSTANCE.ff("dd.use_https_api", true);
    }

    private static final boolean isInWhiteList(String host) {
        if (StringsKt.endsWith$default(host, ".hdslb.com", false, 2, (Object) null)) {
            return true;
        }
        switch (host.hashCode()) {
            case -1937917112:
                if (!host.equals(HOST_APP_BILIBILI_COM)) {
                    return false;
                }
                break;
            case -1737161012:
                if (!host.equals(HOST_VIP_BILIBILI_COM)) {
                    return false;
                }
                break;
            case -1318282294:
                if (!host.equals(HOST_COMMENT_BILIBILI_COM)) {
                    return false;
                }
                break;
            case -1139405724:
                if (!host.equals(HOST_ELEC_BILIBILI_COM)) {
                    return false;
                }
                break;
            case -899643823:
                if (!host.equals(HOST_WWW_IM9_COM)) {
                    return false;
                }
                break;
            case -859113617:
                if (!host.equals(HOST_MEMBER_BILIBILI_COM)) {
                    return false;
                }
                break;
            case -542416765:
                if (!host.equals(HOST_SPACE_BILIG_COM)) {
                    return false;
                }
                break;
            case -46695646:
                if (!host.equals(HOST_MSG_BILIBILI_COM)) {
                    return false;
                }
                break;
            case 1600993263:
                if (!host.equals(HOST_API_BILIBILI_COM)) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }
}