package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OpenUrlScheme.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0005"}, d2 = {"isNative", "", "", "isWeb", "isHttp", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OpenUrlSchemeKt {
    public static final boolean isNative(String $this$isNative) {
        return Intrinsics.areEqual($this$isNative, "na");
    }

    public static final boolean isWeb(String $this$isWeb) {
        return Intrinsics.areEqual($this$isWeb, "web");
    }

    public static final boolean isHttp(String $this$isHttp) {
        String str = $this$isHttp;
        if (str == null || str.length() == 0) {
            return false;
        }
        int startIndex$iv$iv = 0;
        int endIndex$iv$iv = $this$trim$iv$iv.length() - 1;
        boolean startFound$iv$iv = false;
        while (startIndex$iv$iv <= endIndex$iv$iv) {
            int index$iv$iv = !startFound$iv$iv ? startIndex$iv$iv : endIndex$iv$iv;
            char it = Intrinsics.compare($this$trim$iv$iv.charAt(index$iv$iv), 32) <= 0 ? (char) 1 : (char) 0;
            if (!startFound$iv$iv) {
                if (it == 0) {
                    startFound$iv$iv = true;
                } else {
                    startIndex$iv$iv++;
                }
            } else if (it == 0) {
                break;
            } else {
                endIndex$iv$iv--;
            }
        }
        String $this$trim$iv = $this$trim$iv$iv.subSequence(startIndex$iv$iv, endIndex$iv$iv + 1).toString();
        Pattern pat = Pattern.compile($this$trim$iv);
        String $this$trim$iv$iv = $this$isHttp;
        int startIndex$iv$iv2 = 0;
        int endIndex$iv$iv2 = $this$trim$iv$iv.length() - 1;
        boolean startFound$iv$iv2 = false;
        while (startIndex$iv$iv2 <= endIndex$iv$iv2) {
            int index$iv$iv2 = !startFound$iv$iv2 ? startIndex$iv$iv2 : endIndex$iv$iv2;
            char it2 = Intrinsics.compare($this$trim$iv$iv.charAt(index$iv$iv2), 32) <= 0 ? (char) 1 : (char) 0;
            if (!startFound$iv$iv2) {
                if (it2 == 0) {
                    startFound$iv$iv2 = true;
                } else {
                    startIndex$iv$iv2++;
                }
            } else if (it2 == 0) {
                break;
            } else {
                endIndex$iv$iv2--;
            }
        }
        Matcher mat = pat.matcher($this$trim$iv$iv.subSequence(startIndex$iv$iv2, endIndex$iv$iv2 + 1).toString());
        return mat.matches();
    }
}