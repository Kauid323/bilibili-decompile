package tv.danmaku.bili.ui.clipboard;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.splash.LaunchClipboard;

/* compiled from: ClipboardRecognizer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/LocalBvRecognizer;", "Ltv/danmaku/bili/ui/clipboard/IRegexRecognizer;", "regexInfo", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "<init>", "(Ltv/danmaku/bili/ui/clipboard/RegexRule;)V", "recognize", "", "content", "", "environment", "Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "getRegexRule", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LocalBvRecognizer implements IRegexRecognizer {
    public static final int $stable = 8;
    private final RegexRule regexInfo;

    public LocalBvRecognizer(RegexRule regexInfo) {
        Intrinsics.checkNotNullParameter(regexInfo, "regexInfo");
        this.regexInfo = regexInfo;
    }

    @Override // tv.danmaku.bili.ui.clipboard.IRegexRecognizer
    public String recognize(CharSequence content, ClipboardChecker.Environment environment) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(environment, "environment");
        if (TextUtils.isEmpty(this.regexInfo.getRegex()) || !this.regexInfo.check(environment) || ClipboardChecker.INSTANCE.isInnerCopy(environment.getContext(), content.toString())) {
            return null;
        }
        LaunchClipboard launchClipboard = LaunchClipboard.INSTANCE;
        String regex = this.regexInfo.getRegex();
        Intrinsics.checkNotNull(regex);
        return launchClipboard.recognizeBvData(content, regex);
    }

    @Override // tv.danmaku.bili.ui.clipboard.IRegexRecognizer
    public RegexRule getRegexRule() {
        return this.regexInfo;
    }
}