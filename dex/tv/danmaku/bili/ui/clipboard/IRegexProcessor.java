package tv.danmaku.bili.ui.clipboard;

import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;

/* compiled from: ClipboardProcessor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J&\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/IRegexProcessor;", "", "process", "Ltv/danmaku/bili/ui/clipboard/RecognizeResult;", "content", "", "regexRule", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "environment", "Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "processAsync", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IRegexProcessor {
    RecognizeResult process(String str, RegexRule regexRule, ClipboardChecker.Environment environment);

    RecognizeResult processAsync(String str, RegexRule regexRule, ClipboardChecker.Environment environment);

    /* compiled from: ClipboardProcessor.kt */
    /* renamed from: tv.danmaku.bili.ui.clipboard.IRegexProcessor$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ RecognizeResult process$default(IRegexProcessor iRegexProcessor, String str, RegexRule regexRule, ClipboardChecker.Environment environment, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    regexRule = null;
                }
                return iRegexProcessor.process(str, regexRule, environment);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: process");
        }

        public static /* synthetic */ RecognizeResult processAsync$default(IRegexProcessor iRegexProcessor, String str, RegexRule regexRule, ClipboardChecker.Environment environment, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    regexRule = null;
                }
                return iRegexProcessor.processAsync(str, regexRule, environment);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processAsync");
        }
    }
}