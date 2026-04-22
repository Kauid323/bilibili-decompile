package kntr.common.share.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: GShare.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/common/share/common/GShare;", "", "createPanel", "Lkntr/common/share/common/GSharePanel;", "context", "Lkntr/common/share/common/ShareLocalContext;", "params", "Lkntr/common/share/common/ShareParams;", "style", "Lkntr/common/share/common/SharePanelStyle;", "handler", "Lkntr/common/share/common/SharePanelHandler;", "shareToTarget", "Lkntr/common/share/common/ShareRawResult;", "target", "Lkntr/common/share/common/ShareTarget;", "content", "Lkntr/common/share/common/ShareContent;", "(Lkntr/common/share/common/ShareTarget;Lkntr/common/share/common/ShareContent;Lkntr/common/share/common/ShareLocalContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSupport", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface GShare {
    GSharePanel createPanel(ShareLocalContext shareLocalContext, ShareParams shareParams, SharePanelStyle sharePanelStyle, SharePanelHandler sharePanelHandler);

    boolean isSupport(ShareTarget shareTarget);

    Object shareToTarget(ShareTarget shareTarget, ShareContent shareContent, ShareLocalContext shareLocalContext, Continuation<? super ShareRawResult> continuation);

    /* compiled from: GShare.kt */
    /* renamed from: kntr.common.share.common.GShare$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ GSharePanel createPanel$default(GShare gShare, ShareLocalContext shareLocalContext, ShareParams shareParams, SharePanelStyle sharePanelStyle, SharePanelHandler sharePanelHandler, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    sharePanelStyle = new SharePanelStyle(null, false, 3, null);
                }
                if ((i & 8) != 0) {
                    sharePanelHandler = new SharePanelHandler();
                }
                return gShare.createPanel(shareLocalContext, shareParams, sharePanelStyle, sharePanelHandler);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPanel");
        }
    }

    /* compiled from: GShare.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}