package kntr.common.share.domain.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareMiniProgramContent;
import kntr.common.share.common.ShareMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareClickResult.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0082\u0004¨\u0006\n"}, d2 = {"merge", "Lkntr/common/share/common/ShareContent;", "Lkntr/common/share/domain/model/ShareClickResult;", "sc", "createProgramContent", "Lkntr/common/share/common/ShareMiniProgramContent;", "content", "or", "", "param", "domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareClickResultKt {
    public static final ShareContent merge(ShareClickResult $this$merge, ShareContent sc) {
        Intrinsics.checkNotNullParameter($this$merge, "<this>");
        Intrinsics.checkNotNullParameter(sc, "sc");
        ShareMode shareMode = HelperKt.toShareMode($this$merge.getShareMode());
        if (shareMode == null) {
            shareMode = sc.getMode();
        }
        return new ShareContent(shareMode, or($this$merge.getTitle(), sc.getTitle()), or($this$merge.getContent(), sc.getContent()), or($this$merge.getLink(), sc.getLink()), sc.getImage(), or($this$merge.getPicture(), sc.getImageUrl()), or($this$merge.getAudioLink(), sc.getAudioLink()), or($this$merge.getSchema(), sc.getSchema()), createProgramContent($this$merge, sc.getProgramContent()), sc.getImContent(), sc.getDynamicContent(), sc.getMarkPointContent());
    }

    private static final ShareMiniProgramContent createProgramContent(ShareClickResult $this$createProgramContent, ShareMiniProgramContent content) {
        if (content == null) {
            return null;
        }
        String or = or($this$createProgramContent.getProgramId(), content.getIdentifier());
        if (or == null) {
            or = "";
        }
        String or2 = or($this$createProgramContent.getProgramPath(), content.getPath());
        return new ShareMiniProgramContent(or, or2 != null ? or2 : "", or($this$createProgramContent.getHeader(), content.getHeader()));
    }

    private static final String or(String $this$or, String param) {
        String str = $this$or;
        return str == null || str.length() == 0 ? param : $this$or;
    }
}