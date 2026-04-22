package tv.danmaku.bili.videopage.common.helper;

import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PatternUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/PatternUtils;", "", "<init>", "()V", "descLinkPattern", "Ljava/util/regex/Pattern;", "getDescLinkPattern", "()Ljava/util/regex/Pattern;", "descLinkPattern$delegate", "Lkotlin/Lazy;", "safeCompilePattern", "reg", "", "defReg", "flag", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PatternUtils {
    public static final PatternUtils INSTANCE = new PatternUtils();
    private static final Lazy descLinkPattern$delegate = ListExtentionsKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.videopage.common.helper.PatternUtils$$ExternalSyntheticLambda0
        public final Object invoke() {
            Pattern descLinkPattern_delegate$lambda$0;
            descLinkPattern_delegate$lambda$0 = PatternUtils.descLinkPattern_delegate$lambda$0();
            return descLinkPattern_delegate$lambda$0;
        }
    });

    private PatternUtils() {
    }

    public final Pattern getDescLinkPattern() {
        return (Pattern) descLinkPattern$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pattern descLinkPattern_delegate$lambda$0() {
        String it = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "base.highlight_link_whitelist", (Object) null, 2, (Object) null);
        if (it != null) {
            return INSTANCE.safeCompilePattern(it, null, 2);
        }
        return null;
    }

    public final Pattern safeCompilePattern(String reg, String defReg, int flag) {
        Intrinsics.checkNotNullParameter(reg, "reg");
        try {
            return Pattern.compile(reg, flag);
        } catch (Exception e) {
            return defReg != null ? Pattern.compile(defReg, flag) : null;
        }
    }
}