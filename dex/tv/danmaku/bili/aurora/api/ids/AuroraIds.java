package tv.danmaku.bili.aurora.api.ids;

import android.util.Base64;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.Foundation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: AuroraIds.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0003J\b\u0010\t\u001a\u00020\u0005H\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/aurora/api/ids/AuroraIds;", "", "<init>", "()V", "salt", "", "eid", "mid", "getEid", "getMid", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuroraIds {
    public static final AuroraIds INSTANCE = new AuroraIds();
    private static final String salt = "ad1va46a7lza";

    private AuroraIds() {
    }

    public final String eid() {
        try {
            return getEid();
        } catch (Exception e) {
            BLog.e("net.aurora.ids", e);
            return "";
        }
    }

    public final String mid() {
        try {
            return getMid();
        } catch (Exception e) {
            BLog.e("net.aurora.ids", e);
            return "";
        }
    }

    private final String getEid() {
        long mid = BiliAccounts.get(Foundation.Companion.instance().getApp()).mid();
        if (mid > 0) {
            return salt(String.valueOf(mid));
        }
        return "";
    }

    private final String getMid() {
        long mid = BiliAccounts.get(Foundation.Companion.instance().getApp()).mid();
        if (mid > 0) {
            return String.valueOf(mid);
        }
        return "";
    }

    private final String salt(String mid) {
        byte[] buf = new byte[mid.length()];
        int length = mid.length();
        for (int i = 0; i < length; i++) {
            buf[i] = (byte) (((byte) mid.charAt(i)) ^ ((byte) salt.charAt(i % 12)));
        }
        String encodeToString = Base64.encodeToString(buf, 10);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
        return encodeToString;
    }
}