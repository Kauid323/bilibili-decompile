package tv.danmaku.bili.ui.clipboard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.splash.LaunchClipboard;

/* compiled from: ClipboardRecognizer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/LocalOpenRecognizer;", "Ltv/danmaku/bili/ui/clipboard/IRegexRecognizer;", "<init>", "()V", "recognize", "", "content", "", "environment", "Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "getRegexRule", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LocalOpenRecognizer implements IRegexRecognizer {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.ui.clipboard.IRegexRecognizer
    public String recognize(CharSequence content, ClipboardChecker.Environment environment) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(environment, "environment");
        if (!environment.getFirstStart()) {
            return null;
        }
        return LaunchClipboard.INSTANCE.recognizeOpenData(content);
    }

    @Override // tv.danmaku.bili.ui.clipboard.IRegexRecognizer
    public RegexRule getRegexRule() {
        return null;
    }
}