package tv.danmaku.biliplayerv2.utils;

import android.content.Context;
import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.tf.TfResource;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerFreeTypeHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001b\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/utils/PlayerFreeTypeHelper;", "", "<init>", "()V", "getFreeDataTypeToastValue", "", "context", "Landroid/content/Context;", "getDemiwareValue", "", "(Landroid/content/Context;)[Ljava/lang/String;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerFreeTypeHelper {
    public static final PlayerFreeTypeHelper INSTANCE = new PlayerFreeTypeHelper();

    private PlayerFreeTypeHelper() {
    }

    public final String getFreeDataTypeToastValue(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Collection freeDataConfig = PlayerOnlineParamHelper.INSTANCE.getFreeDataConfig();
        String str = null;
        String targetType = FreeDataManager.getInstance().checkConditionMatched(TfResource.RES_VIDEO).getProductTag();
        if (targetType == null) {
            return null;
        }
        if (freeDataConfig != null) {
            int size = freeDataConfig.size();
            for (int i = 0; i < size; i++) {
                JSONObject json = freeDataConfig.getJSONObject(i);
                if (json != null) {
                    String type = json.getString("Type");
                    if (!TextUtils.isEmpty(type) && TextUtils.equals(type, targetType)) {
                        str = json.getString("Value");
                    }
                }
            }
        }
        return str;
    }

    public final String[] getDemiwareValue(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject jsonObject = PlayerOnlineParamHelper.INSTANCE.getDemiwareConfig();
        if (jsonObject != null) {
            String title = jsonObject.getString(RankRouter.BundleKey.ACTION_PARAM_TITLE);
            if (title == null) {
                title = "";
            }
            if (TextUtils.isEmpty(title)) {
                String string = context.getResources().getString(R.string.playerbaseres_global_string_633);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                title = string;
            }
            String subtitle = jsonObject.getString("subtitle");
            if (subtitle == null) {
                subtitle = "";
            }
            if (TextUtils.isEmpty(subtitle)) {
                String string2 = context.getResources().getString(R.string.playerbaseres_global_string_841);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                subtitle = string2;
            }
            String string3 = jsonObject.getString("link");
            String link = string3 != null ? string3 : "";
            if (TextUtils.isEmpty(link)) {
                String string4 = context.getResources().getString(tv.danmaku.biliplayer.baseres.R.string.player_demiware_toast_link);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                link = string4;
            }
            return new String[]{title, subtitle, link};
        }
        return null;
    }
}