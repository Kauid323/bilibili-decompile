package tv.danmaku.biliplayerv2.service.interact.biz.sender;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosDanmakuInteractiveWrapper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/sender/OnInteractiveCallBack;", "", "onReportDanmakuSuccess", "", "regexFilter", "", "shieldUserId", "nativeId", "", "nativeType", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OnInteractiveCallBack {
    void onReportDanmakuSuccess(String str, String str2, long j, int i);

    /* compiled from: ChronosDanmakuInteractiveWrapper.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.sender.OnInteractiveCallBack$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onReportDanmakuSuccess$default(OnInteractiveCallBack onInteractiveCallBack, String str, String str2, long j, int i, int i2, Object obj) {
            long j2;
            int i3;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReportDanmakuSuccess");
            }
            if ((i2 & 4) == 0) {
                j2 = j;
            } else {
                j2 = 0;
            }
            if ((i2 & 8) == 0) {
                i3 = i;
            } else {
                i3 = 0;
            }
            onInteractiveCallBack.onReportDanmakuSuccess(str, str2, j2, i3);
        }
    }
}