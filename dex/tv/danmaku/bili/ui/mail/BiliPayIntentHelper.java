package tv.danmaku.bili.ui.mail;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.router.Router;

public class BiliPayIntentHelper {
    private static final String ARGS_ACCESSKEY = "accessKey";
    private static final String BILIPAY_WALLET = "activity://bilipay/mine_wallet";

    public static void toWallet(Context context) {
        Router.global().with(context).with(ARGS_ACCESSKEY, BiliAccounts.get(context).getAccessKey()).open(BILIPAY_WALLET);
    }
}