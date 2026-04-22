package tv.danmaku.bili.ui.pay.recharge.router;

import android.app.Activity;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.pay.recharge.api.WalletInfo;
import com.bilibili.lib.router.Router;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.ui.pay.recharge.helper.RechargeOrderInfo;

public class PayRouterAdapter {
    public static final String MODULE_PAY = "rechargePay";
    public static final String RECHARGE = "activity://pay/recharge";
    public static final String RECHARGE_SWITCH = "activity://pay/recharge_switch";
    public static final int REQUEST_CODE_INVALID = -1;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class Keys {
        public static final String BUNDLE_FROM = "from";
        public static final String BUNDLE_ORDER_INFO = "orderInfo";
        public static final String BUNDLE_PRE_CHARGE = "isPreCharge";
        public static final String BUNDLE_UI_CONFIG = "dialogConfig";
        public static final String BUNDLE_USER_WALLET = "userWallet";
        public static final String RESULT_PAY_METHOD = "payMethod";
        public static final String RESULT_RECHARGE_ORDER_NO = "rechargeOrderNo";
        public static final String RESULT_RECHARGE_VALUE = "rechargeValue";
    }

    public static void rechargeAndPay(Activity activity, RechargeOrderInfo orderInfo, WalletInfo userWallet) {
        rechargeAndPay(activity, orderInfo, userWallet, -1);
    }

    public static void rechargeAndPay(Activity activity, RechargeOrderInfo orderInfo, WalletInfo userWallet, int requestCode) {
        Router.RouterProxy proxy = buildRechargeExtra(orderInfo, userWallet).with(activity);
        if (requestCode != -1) {
            proxy = proxy.forResult(requestCode);
        }
        proxy.open(RECHARGE);
    }

    public static void rechargeAndPay(Fragment fragment, RechargeOrderInfo orderInfo, WalletInfo userWallet) {
        rechargeAndPay(fragment, orderInfo, userWallet, -1);
    }

    public static void rechargeAndPay(Fragment fragment, RechargeOrderInfo orderInfo, WalletInfo userWallet, int requestCode) {
        Router.RouterProxy proxy = buildRechargeExtra(orderInfo, userWallet).with(fragment);
        if (requestCode != -1) {
            proxy = proxy.forResult(requestCode);
        }
        proxy.open(RECHARGE);
    }

    private static Router.RouterProxy buildRechargeExtra(RechargeOrderInfo orderInfo, WalletInfo userWallet) {
        return Router.global().with(Keys.BUNDLE_PRE_CHARGE, "true").with(Keys.BUNDLE_ORDER_INFO, JSON.toJSONString(orderInfo)).with(Keys.BUNDLE_USER_WALLET, JSON.toJSONString(userWallet));
    }

    public static void rechargeAndPay(Activity activity, RechargeOrderInfo orderInfo, RechargeUiConfig switchConfig) {
        rechargeAndPay(activity, orderInfo, switchConfig, -1);
    }

    public static void rechargeAndPay(Activity activity, final RechargeOrderInfo orderInfo, final RechargeUiConfig switchConfig, int requestCode) {
        RouteRequest request = new RouteRequest.Builder(Uri.parse(RECHARGE_SWITCH)).extras(new Function1() { // from class: tv.danmaku.bili.ui.pay.recharge.router.PayRouterAdapter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return PayRouterAdapter.lambda$rechargeAndPay$0(RechargeOrderInfo.this, switchConfig, (MutableBundleLike) obj);
            }
        }).overridePendingTransition(0, 0).requestCode(requestCode).build();
        BLRouter bLRouter = BLRouter.INSTANCE;
        BLRouter.routeTo(request, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$rechargeAndPay$0(RechargeOrderInfo orderInfo, RechargeUiConfig switchConfig, MutableBundleLike b) {
        b.put(Keys.BUNDLE_ORDER_INFO, JSON.toJSONString(orderInfo));
        b.put(Keys.BUNDLE_UI_CONFIG, JSON.toJSONString(switchConfig));
        return null;
    }

    public static void rechargeAndPay(Fragment fragment, RechargeOrderInfo orderInfo, RechargeUiConfig switchConfig) {
        rechargeAndPay(fragment, orderInfo, switchConfig, -1);
    }

    public static void rechargeAndPay(Fragment fragment, final RechargeOrderInfo orderInfo, final RechargeUiConfig switchConfig, int requestCode) {
        RouteRequest request = new RouteRequest.Builder(Uri.parse(RECHARGE_SWITCH)).extras(new Function1() { // from class: tv.danmaku.bili.ui.pay.recharge.router.PayRouterAdapter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return PayRouterAdapter.lambda$rechargeAndPay$1(RechargeOrderInfo.this, switchConfig, (MutableBundleLike) obj);
            }
        }).overridePendingTransition(0, 0).requestCode(requestCode).build();
        BLRouter bLRouter = BLRouter.INSTANCE;
        BLRouter.routeTo(request, fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$rechargeAndPay$1(RechargeOrderInfo orderInfo, RechargeUiConfig switchConfig, MutableBundleLike b) {
        b.put(Keys.BUNDLE_ORDER_INFO, JSON.toJSONString(orderInfo));
        b.put(Keys.BUNDLE_UI_CONFIG, JSON.toJSONString(switchConfig));
        return null;
    }

    private static Router.RouterProxy buildRechargeExtra(RechargeOrderInfo orderInfo, RechargeUiConfig switchConfig) {
        return Router.global().with(Keys.BUNDLE_ORDER_INFO, JSON.toJSONString(orderInfo)).with(Keys.BUNDLE_UI_CONFIG, JSON.toJSONString(switchConfig));
    }

    public static void rechargeOnly(Activity activity, int from) {
        rechargeOnly(activity, from, -1);
    }

    public static void rechargeOnly(Activity activity, int from, int requestCode) {
        Router.RouterProxy proxy = buildRechargeExtra(from).with(activity);
        if (requestCode != -1) {
            proxy = proxy.forResult(requestCode);
        }
        proxy.open(RECHARGE);
    }

    public static void rechargeOnly(Fragment fragment, int from) {
        rechargeOnly(fragment, from, -1);
    }

    public static void rechargeOnly(Fragment fragment, int from, int requestCode) {
        Router.RouterProxy proxy = buildRechargeExtra(from).with(fragment);
        if (requestCode != -1) {
            proxy = proxy.forResult(requestCode);
        }
        proxy.open(RECHARGE);
    }

    private static Router.RouterProxy buildRechargeExtra(int from) {
        return Router.global().with(Keys.BUNDLE_PRE_CHARGE, "false").with("from", String.valueOf(from));
    }
}