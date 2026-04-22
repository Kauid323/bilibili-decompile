package tv.danmaku.bili.ui.clipboard;

import android.text.TextUtils;
import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.ClipboardChecker;
import tv.danmaku.bili.ui.main.usergrow.UserGrowApiHelper;
import tv.danmaku.bili.ui.main.usergrow.WatchWordResult;

/* compiled from: ClipboardProcessor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/RemoteFissionUrlProcessor;", "Ltv/danmaku/bili/ui/clipboard/IRegexProcessor;", "<init>", "()V", "process", "Ltv/danmaku/bili/ui/clipboard/RecognizeResult;", "content", "", "regexRule", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "environment", "Ltv/danmaku/bili/ui/clipboard/ClipboardChecker$Environment;", "processAsync", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RemoteFissionUrlProcessor implements IRegexProcessor {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.ui.clipboard.IRegexProcessor
    public RecognizeResult process(String content, RegexRule regexRule, ClipboardChecker.Environment environment) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(environment, "environment");
        return null;
    }

    @Override // tv.danmaku.bili.ui.clipboard.IRegexProcessor
    public RecognizeResult processAsync(String content, RegexRule regexRule, ClipboardChecker.Environment environment) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(environment, "environment");
        if (TextUtils.isEmpty(content) || regexRule == null) {
            return null;
        }
        try {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String data = Base64.encodeToString(bytes, 0);
            WatchWordResult result = UserGrowApiHelper.Companion.fetchWatchWordResult(data);
            if (result == null) {
                return null;
            }
            RemoteResult $this$processAsync_u24lambda_u240 = new RemoteResult();
            ClipboardResult $this$processAsync_u24lambda_u240_u240 = new ClipboardResult();
            $this$processAsync_u24lambda_u240_u240.setMode(result.getType() == 0 ? 2 : 1);
            $this$processAsync_u24lambda_u240_u240.setUrl(result.getUrl());
            $this$processAsync_u24lambda_u240_u240.setFissionUrl(true);
            $this$processAsync_u24lambda_u240_u240.setRule(regexRule.getStartType() == 1 ? 3 : 4);
            $this$processAsync_u24lambda_u240.setClipData($this$processAsync_u24lambda_u240_u240);
            return $this$processAsync_u24lambda_u240;
        } catch (Exception e) {
            return null;
        }
    }
}