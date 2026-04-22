package tv.danmaku.bili.wauth.service;

import kotlin.Metadata;
import tv.danmaku.bili.wauth.BusinessType;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WAuthInvokeService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/wauth/service/WAuthInvokeService;", "", "getAuthFromIntent", "", "type", "Ltv/danmaku/bili/wauth/BusinessType;", "miniProgram", "getVersion", "", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface WAuthInvokeService {
    boolean getAuthFromIntent(BusinessType businessType, boolean z);

    String getVersion();

    /* compiled from: WAuthInvokeService.kt */
    /* renamed from: tv.danmaku.bili.wauth.service.WAuthInvokeService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean getAuthFromIntent$default(WAuthInvokeService wAuthInvokeService, BusinessType businessType, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    businessType = BusinessType.PASSWORD;
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                return wAuthInvokeService.getAuthFromIntent(businessType, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAuthFromIntent");
        }
    }
}