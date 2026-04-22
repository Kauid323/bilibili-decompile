package tv.danmaku.bili.ui.clipboard;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.base.BiliContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;

/* compiled from: ClipboardRecognizer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/RemoteActRecognizer;", "Ltv/danmaku/bili/ui/clipboard/IRegexRecognizer;", "regexRule", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "<init>", "(Ltv/danmaku/bili/ui/clipboard/RegexRule;)V", "recognize", "", "content", "", "environment", "Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "getRegexRule", "recognizeInternal", "skipCheck", "", "isInMutiWindowMode", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class RemoteActRecognizer implements IRegexRecognizer {
    public static final int $stable = 8;
    private final RegexRule regexRule;

    public RemoteActRecognizer(RegexRule regexRule) {
        Intrinsics.checkNotNullParameter(regexRule, "regexRule");
        this.regexRule = regexRule;
    }

    @Override // tv.danmaku.bili.ui.clipboard.IRegexRecognizer
    public String recognize(CharSequence content, ClipboardChecker.Environment environment) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(environment, "environment");
        if (!this.regexRule.check(environment) || skipCheck()) {
            return null;
        }
        if (this.regexRule.getInnerCopy() || !ClipboardChecker.INSTANCE.isInnerCopy(environment.getContext(), content.toString())) {
            return recognizeInternal(content, this.regexRule);
        }
        return null;
    }

    @Override // tv.danmaku.bili.ui.clipboard.IRegexRecognizer
    public RegexRule getRegexRule() {
        return this.regexRule;
    }

    public String recognizeInternal(CharSequence content, RegexRule regexRule) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(regexRule, "regexRule");
        try {
            if (TextUtils.isEmpty(regexRule.getRegex())) {
                return null;
            }
            String regex = regexRule.getRegex();
            Intrinsics.checkNotNull(regex);
            Pattern pattern = Pattern.compile(regex, 2);
            Matcher matcher = pattern.matcher(content);
            if (!matcher.find()) {
                return null;
            }
            if (ClipboardChecker.INSTANCE.shouldReport(regexRule.getBusiness())) {
                return matcher.group();
            }
            return content.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private final boolean skipCheck() {
        return RestrictedMode.isRestrictedMode() || isInMutiWindowMode();
    }

    private final boolean isInMutiWindowMode() {
        Activity it = BiliContext.topActivitiy();
        return it != null && Build.VERSION.SDK_INT >= 24 && it.isInMultiWindowMode();
    }
}