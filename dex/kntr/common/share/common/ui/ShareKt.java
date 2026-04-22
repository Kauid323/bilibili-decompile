package kntr.common.share.common.ui;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.share.common.GShare;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareLocalContext;
import kntr.common.share.common.ShareTarget;
import kntr.common.share.common.ui.internal.ShareClickHandlerKt;
import kntr.common.share.domain.DomainKt;
import kntr.common.share.domain.ShareDomainApi;
import kntr.common.share.domain.ShareReporter;
import kntr.common.share.domain.model.ShareSession;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Share.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001aJ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¨\u0006\u0011"}, d2 = {"gShare", "Lkntr/common/share/common/GShare;", "shareToTargetWithFetch", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/common/share/common/ui/ShareToTargetState;", "target", "Lkntr/common/share/common/ShareTarget;", "session", "Lkntr/common/share/domain/model/ShareSession;", "content", "Lkntr/common/share/common/ShareContent;", "context", "Lkntr/common/share/common/ShareLocalContext;", "domain", "Lkntr/common/share/domain/ShareDomainApi;", CommonProjectType.REPORTER, "Lkntr/common/share/domain/ShareReporter;", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareKt {
    public static final GShare gShare() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((GShareEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(GShareEntryPoint.class))).gShare();
    }

    public static /* synthetic */ Flow shareToTargetWithFetch$default(GShare gShare, ShareTarget shareTarget, ShareSession shareSession, ShareContent shareContent, ShareLocalContext shareLocalContext, ShareDomainApi shareDomainApi, ShareReporter shareReporter, int i, Object obj) {
        ShareDomainApi shareDomainApi2;
        ShareReporter shareReporter2;
        if ((i & 16) == 0) {
            shareDomainApi2 = shareDomainApi;
        } else {
            shareDomainApi2 = DomainKt.defaultDomain(gShare);
        }
        if ((i & 32) == 0) {
            shareReporter2 = shareReporter;
        } else {
            shareReporter2 = new ShareReporter();
        }
        return shareToTargetWithFetch(gShare, shareTarget, shareSession, shareContent, shareLocalContext, shareDomainApi2, shareReporter2);
    }

    public static final Flow<ShareToTargetState> shareToTargetWithFetch(GShare $this$shareToTargetWithFetch, ShareTarget target, ShareSession session, ShareContent content, ShareLocalContext context, ShareDomainApi domain, ShareReporter reporter) {
        Intrinsics.checkNotNullParameter($this$shareToTargetWithFetch, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(context, "context");
        return ShareClickHandlerKt.mShareToTargetWithFetch(target, session, content, context, domain, reporter);
    }
}