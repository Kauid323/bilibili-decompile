package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import com.bili.digital.common.web.container.IDigitalCommonWebBridge;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: NftWebContainer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aH\u0016J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aH\u0016J\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftWebContainer;", "Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "Lcom/bili/digital/common/web/container/IDigitalCommonWebBridge;", "mActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "mWebProxy", "Ltv/danmaku/bili/ui/garb/DigitalWebProxy;", "injectWebView", "", "webView", "Lcom/bilibili/app/comm/bh/BiliWebView;", "toDrawAgain", "toHolderList", "cardTypeId", "", "cardId", "actId", "", "toShare", "toDismissDialog", "injectDigitalBridges", "", "", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "injectGarbBridges", "allBuildInBridges", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftWebContainer implements NftCardJsbCallback, IDigitalCommonWebBridge {
    public static final int $stable = 8;
    private Activity mActivity;
    private DigitalWebProxy mWebProxy = new DigitalWebProxy();

    public NftWebContainer(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final void setMActivity(Activity activity) {
        this.mActivity = activity;
    }

    public final void injectWebView(BiliWebView webView) {
        DigitalWebProxy digitalWebProxy = this.mWebProxy;
        if (digitalWebProxy != null) {
            digitalWebProxy.setWebview(webView);
        }
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toDrawAgain() {
        DigitalWebProxy digitalWebProxy = this.mWebProxy;
        if (digitalWebProxy != null) {
            digitalWebProxy.toDrawAgain();
        }
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toHolderList(long cardTypeId, long cardId, int actId) {
        DigitalWebProxy digitalWebProxy = this.mWebProxy;
        if (digitalWebProxy != null) {
            digitalWebProxy.toHolderList(cardTypeId, cardId, actId);
        }
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toShare(long cardTypeId, long cardId, int actId) {
        DigitalWebProxy digitalWebProxy = this.mWebProxy;
        if (digitalWebProxy != null) {
            digitalWebProxy.toShare(cardTypeId, cardId, actId);
        }
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardJsbCallback
    public void toDismissDialog() {
        DigitalWebProxy digitalWebProxy = this.mWebProxy;
        if (digitalWebProxy != null) {
            digitalWebProxy.toDismissDialog();
        }
    }

    public Map<String, JsBridgeCallHandlerFactoryV2> injectDigitalBridges() {
        Map map = new LinkedHashMap();
        final Activity it = this.mActivity;
        if (it != null) {
            JsBridgeCallHandlerFactoryV2 jsBridgeCallHandlerFactoryV2 = (JsBridgeCallHandlerFactoryV2) map.put("card", new JsBridgeCallHandlerFactoryV2() { // from class: tv.danmaku.bili.ui.garb.NftWebContainer$$ExternalSyntheticLambda0
                public final JsBridgeCallHandlerV2 create() {
                    JsBridgeCallHandlerV2 injectDigitalBridges$lambda$0$0;
                    injectDigitalBridges$lambda$0$0 = NftWebContainer.injectDigitalBridges$lambda$0$0(it, this);
                    return injectDigitalBridges$lambda$0$0;
                }
            });
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsBridgeCallHandlerV2 injectDigitalBridges$lambda$0$0(Activity $it, NftWebContainer this$0) {
        NftCardJsBridgeCallHandlerFactory factory = new NftCardJsBridgeCallHandlerFactory($it, this$0);
        return factory.create();
    }

    public Map<String, JsBridgeCallHandlerFactoryV2> injectGarbBridges() {
        Map map = new LinkedHashMap();
        return map;
    }

    public final Map<String, JsBridgeCallHandlerFactoryV2> allBuildInBridges() {
        Map map = new LinkedHashMap();
        Map it = injectGarbBridges();
        if (it != null) {
            map.putAll(it);
        }
        Map it2 = injectDigitalBridges();
        if (it2 != null) {
            map.putAll(it2);
        }
        return map;
    }
}