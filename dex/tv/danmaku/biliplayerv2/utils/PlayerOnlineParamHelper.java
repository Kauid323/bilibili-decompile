package tv.danmaku.biliplayerv2.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.media.util.NetworkUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerOnlineParamHelper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0006\u0010\u0011\u001a\u00020\u0005J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerOnlineParamHelper;", "", "<init>", "()V", "getLowestForceLoginQuality", "", "enableForceLoginToast", "", "getAutoSwitchMaxQn", "getMaxQnForAutoQuality", "getDanmakuHintText", "", "getMaxQnForDashAuto", "getConfigInt", "key", "def", "getConfigString", "getMemorableQn", "getFreeDataConfig", "Lcom/alibaba/fastjson/JSONArray;", "getDemiwareConfig", "Lcom/alibaba/fastjson/JSONObject;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerOnlineParamHelper {
    public static final PlayerOnlineParamHelper INSTANCE = new PlayerOnlineParamHelper();

    private PlayerOnlineParamHelper() {
    }

    @JvmStatic
    public static final int getLowestForceLoginQuality() {
        return INSTANCE.getConfigInt("enable_player_force_login_qn", 32);
    }

    public final boolean enableForceLoginToast() {
        return BLRemoteConfig.getInstance().getBoolean("enable_player_force_login_toast", true);
    }

    private final int getAutoSwitchMaxQn() {
        String str = (String) ConfigManager.Companion.config().get("ijkplayer.autoswitch_max_qn", "0");
        String config = str != null ? str : "0";
        try {
            return Integer.parseInt(config);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private final int getMaxQnForAutoQuality() {
        boolean isWIFI = NetworkUtil.getNetworkState(BiliContext.application()) == 1;
        if (isWIFI) {
            int config = getAutoSwitchMaxQn();
            if (config > 0) {
                return config;
            }
            return 80;
        }
        return 64;
    }

    public final String getDanmakuHintText() {
        return DeviceDecision.INSTANCE.dd("dd.danmaku_input_hint", "");
    }

    public final int getMaxQnForDashAuto() {
        boolean isLogin = BiliAccounts.get(BiliContext.application()).isLogin();
        if (isLogin) {
            return getMaxQnForAutoQuality();
        }
        return Math.min(getMaxQnForAutoQuality(), getLowestForceLoginQuality());
    }

    private final int getConfigInt(String key, int def) {
        try {
            return BLRemoteConfig.getInstance().getInt(key, def);
        } catch (Exception e) {
            return def;
        }
    }

    private final String getConfigString(String key) {
        try {
            return BLRemoteConfig.getInstance().getString(key);
        } catch (Exception e) {
            return null;
        }
    }

    public final int getMemorableQn() {
        return getConfigInt("Memorable_qn", 0);
    }

    public final JSONArray getFreeDataConfig() {
        String config = BLRemoteConfig.getInstance().getString("custom_freedata_alert");
        try {
            return JSONObject.parseArray(config);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final JSONObject getDemiwareConfig() {
        String value = getConfigString("freedata_demiware_key");
        if (value == null) {
            return null;
        }
        try {
            return JSON.parseObject(value);
        } catch (JSONException e) {
            return null;
        }
    }
}