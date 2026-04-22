package tv.danmaku.bili.ui.garb;

import com.bilibili.app.comm.bh.BiliWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: DigitalWebProxy.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/garb/DigitalWebProxy;", "Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "<init>", "()V", "webview", "Lcom/bilibili/app/comm/bh/BiliWebView;", "getWebview", "()Lcom/bilibili/app/comm/bh/BiliWebView;", "setWebview", "(Lcom/bilibili/app/comm/bh/BiliWebView;)V", "toDrawAgain", "", "toShare", "cardTypeId", "", "cardId", "actId", "", "toHolderList", "toDismissDialog", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalWebProxy implements NftCardJsbCallback {
    public static final String TAG = "DigitalWebProxy";
    private BiliWebView webview;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DigitalWebProxy.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/garb/DigitalWebProxy$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final BiliWebView getWebview() {
        return this.webview;
    }

    public final void setWebview(BiliWebView biliWebView) {
        this.webview = biliWebView;
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toDrawAgain() {
        BLog.i(TAG, "to draw again webview " + this.webview);
        BiliWebView it = this.webview;
        if (it != null) {
            it.loadUrl("javascript:toDrawAgain()");
        }
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toShare(long cardTypeId, long cardId, int actId) {
        JSONObject setJson = new JSONObject();
        setJson.put("card_type_id", cardTypeId);
        setJson.put("card_id", cardId);
        setJson.put("act_id", actId);
        BLog.i(TAG, "to share " + cardTypeId + ", actId " + actId + " webview " + this.webview);
        BiliWebView it = this.webview;
        if (it != null) {
            it.loadUrl("javascript:toShare(" + setJson + ")");
        }
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toHolderList(long cardTypeId, long cardId, int actId) {
        JSONObject setJson = new JSONObject();
        setJson.put("card_type_id", cardTypeId);
        setJson.put("act_id", actId);
        setJson.put("card_id", cardId);
        BLog.i(TAG, "to holder list " + cardTypeId + ", actId " + actId + "  webview " + this.webview);
        BiliWebView it = this.webview;
        if (it != null) {
            it.loadUrl("javascript:toHolderList(" + setJson + ")");
        }
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toDismissDialog() {
        BLog.i(TAG, "to reload webview " + this.webview);
        BiliWebView it = this.webview;
        if (it != null) {
            it.loadUrl("javascript:toReload()");
        }
    }
}