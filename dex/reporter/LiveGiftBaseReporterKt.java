package reporter;

import android.text.TextUtils;
import com.bilibili.bililive.videoliveplayer.net.beans.gift.BiliLiveReceiveUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LiveGiftBaseReporter.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a#\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"getSourceEvent", "", "from", "", "selectedMicUsersToJsonString", "users", "", "Lcom/bilibili/bililive/videoliveplayer/net/beans/gift/BiliLiveReceiveUser;", "anchorId", "", "(Ljava/util/List;Ljava/lang/Long;)Ljava/lang/String;", "giftCommon_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LiveGiftBaseReporterKt {
    public static final int getSourceEvent(String from) {
        Integer num;
        Integer valueOf;
        if (from != null) {
            switch (from.hashCode()) {
                case 49:
                    if (from.equals("1")) {
                        return 1;
                    }
                    break;
                case 50:
                    if (from.equals("2")) {
                        return 2;
                    }
                    break;
                case 51:
                    if (from.equals("3")) {
                        return 3;
                    }
                    break;
                case 52:
                    if (from.equals("4")) {
                        return 4;
                    }
                    break;
                case 53:
                    if (from.equals("5")) {
                        return 5;
                    }
                    break;
                case 54:
                    if (from.equals("6")) {
                        return 6;
                    }
                    break;
                case 55:
                    if (from.equals("7")) {
                        return 7;
                    }
                    break;
                case 56:
                    if (from.equals("8")) {
                        return 8;
                    }
                    break;
                case 57:
                    if (from.equals("9")) {
                        return 9;
                    }
                    break;
                case 1342707179:
                    if (from.equals("-99998")) {
                        return -99998;
                    }
                    break;
            }
        }
        if (TextUtils.isEmpty(from)) {
            return 0;
        }
        if (from != null) {
            try {
                valueOf = Integer.valueOf(Integer.parseInt(from));
            } catch (Exception e) {
                num = 0;
            }
        } else {
            valueOf = null;
        }
        num = valueOf;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final String selectedMicUsersToJsonString(List<BiliLiveReceiveUser> users, Long anchorId) {
        Intrinsics.checkNotNullParameter(users, "users");
        JSONArray userJsonArray = new JSONArray();
        if (users.isEmpty()) {
            JSONObject $this$selectedMicUsersToJsonString_u24lambda_u240 = new JSONObject();
            $this$selectedMicUsersToJsonString_u24lambda_u240.put("donate_up_id", String.valueOf(anchorId));
            $this$selectedMicUsersToJsonString_u24lambda_u240.put("position", "0");
            userJsonArray.put($this$selectedMicUsersToJsonString_u24lambda_u240);
        } else {
            List<BiliLiveReceiveUser> $this$forEach$iv = users;
            for (Object element$iv : $this$forEach$iv) {
                BiliLiveReceiveUser it = (BiliLiveReceiveUser) element$iv;
                JSONObject $this$selectedMicUsersToJsonString_u24lambda_u241_u240 = new JSONObject();
                $this$selectedMicUsersToJsonString_u24lambda_u241_u240.put("donate_up_id", String.valueOf(it.getUid()));
                $this$selectedMicUsersToJsonString_u24lambda_u241_u240.put("position", String.valueOf(it.getPosition()));
                userJsonArray.put($this$selectedMicUsersToJsonString_u24lambda_u241_u240);
            }
        }
        String jSONArray = userJsonArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
        return jSONArray;
    }
}