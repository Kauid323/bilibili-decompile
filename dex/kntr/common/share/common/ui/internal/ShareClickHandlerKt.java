package kntr.common.share.common.ui.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.MarkPointContent;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.ShareMode;
import kntr.common.share.common.ShareRawResult;
import kntr.common.share.common.ShareResult;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.ShareToTargetState;
import kntr.common.share.domain.ShareDomainApi;
import kntr.common.share.domain.ShareReporter;
import kntr.common.share.domain.model.ShareClickParams;
import kntr.common.share.domain.model.ShareResponse;
import kntr.common.share.domain.model.ShareSession;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ShareClickHandler.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u0017H\u0002¨\u0006\u0018"}, d2 = {"mShareToTargetWithFetch", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/common/share/common/ui/ShareToTargetState;", "target", "Lkntr/common/share/common/ShareTarget;", "session", "Lkntr/common/share/domain/model/ShareSession;", "content", "Lkntr/common/share/common/ShareContent;", "context", "Lkntr/common/share/common/ShareLocalContext;", "domain", "Lkntr/common/share/domain/ShareDomainApi;", CommonProjectType.REPORTER, "Lkntr/common/share/domain/ShareReporter;", "getDefaultMessage", "", "result", "Lkntr/common/share/common/ShareRawResult;", "buildClickParams", "Lkntr/common/share/domain/model/ShareClickParams;", "bizErrorMsg", "T", "Lkntr/common/share/domain/model/ShareResponse;", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareClickHandlerKt {

    /* compiled from: ShareClickHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShareResult.values().length];
            try {
                iArr[ShareResult.Success.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ShareResult.Failure.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ShareResult.Cancel.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Flow<ShareToTargetState> mShareToTargetWithFetch(ShareTarget target, ShareSession session, ShareContent content, ShareLocalContext context, ShareDomainApi domain, ShareReporter reporter) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(context, "context");
        return FlowKt.flow(new ShareClickHandlerKt$mShareToTargetWithFetch$1(target, content, domain, session, reporter, context, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDefaultMessage(ShareTarget target, ShareRawResult result) {
        String errorMessage;
        switch (WhenMappings.$EnumSwitchMapping$0[result.getResult().ordinal()]) {
            case 1:
                return Intrinsics.areEqual(target, ShareTarget.SaveImage.INSTANCE) ? "图片保存成功" : Intrinsics.areEqual(target, ShareTarget.Copy.INSTANCE) ? "复制成功" : "分享成功";
            case 2:
                return Intrinsics.areEqual(target, ShareTarget.SaveImage.INSTANCE) ? "图片保存失败" : Intrinsics.areEqual(target, ShareTarget.Copy.INSTANCE) ? "复制失败" : (!Intrinsics.areEqual(target, ShareTarget.IM.INSTANCE) || (errorMessage = result.getErrorMessage()) == null) ? "分享失败" : errorMessage;
            case 3:
                return "";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareClickParams buildClickParams(ShareContent $this$buildClickParams, ShareTarget target) {
        ShareMode mode = $this$buildClickParams.getMode();
        String title = $this$buildClickParams.getTitle();
        String content = $this$buildClickParams.getContent();
        MarkPointContent markPointContent = $this$buildClickParams.getMarkPointContent();
        return new ShareClickParams(mode, target, title, content, null, markPointContent != null ? markPointContent.getTid() : null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String bizErrorMsg(ShareResponse<? extends T> shareResponse) {
        return shareResponse instanceof ShareResponse.Failure ? ((ShareResponse.Failure) shareResponse).isForbidden() ? ((ShareResponse.Failure) shareResponse).getMessage() : "分享失败，稍后再试试吧..." : shareResponse instanceof ShareResponse.Error ? "分享失败，稍后再试试吧..." : "";
    }
}