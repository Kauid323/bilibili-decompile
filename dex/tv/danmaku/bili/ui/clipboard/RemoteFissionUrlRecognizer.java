package tv.danmaku.bili.ui.clipboard;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main.usergrow.UserGrowManager;

/* compiled from: ClipboardRecognizer.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/RemoteFissionUrlRecognizer;", "Ltv/danmaku/bili/ui/clipboard/RemoteActRecognizer;", "regexInfo", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "<init>", "(Ltv/danmaku/bili/ui/clipboard/RegexRule;)V", "recognizeInternal", "", "content", "", "regexRule", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RemoteFissionUrlRecognizer extends RemoteActRecognizer {
    public static final int $stable = 8;
    private final RegexRule regexInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteFissionUrlRecognizer(RegexRule regexInfo) {
        super(regexInfo);
        Intrinsics.checkNotNullParameter(regexInfo, "regexInfo");
        this.regexInfo = regexInfo;
    }

    @Override // tv.danmaku.bili.ui.clipboard.RemoteActRecognizer
    public String recognizeInternal(CharSequence content, RegexRule regexRule) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(regexRule, "regexRule");
        try {
            if (TextUtils.isEmpty(regexRule.getRegex())) {
                return null;
            }
            String regex = this.regexInfo.getRegex();
            Intrinsics.checkNotNull(regex);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            if (!matcher.find()) {
                return null;
            }
            String url = matcher.group(2);
            if (!TextUtils.isEmpty(url)) {
                UserGrowManager.INSTANCE.reportParseUrl(url);
            }
            return url;
        } catch (Exception e) {
            return null;
        }
    }
}