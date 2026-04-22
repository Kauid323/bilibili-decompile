package im.contact.model;

import im.base.ContentStatus;
import im.base.EmptyContent;
import im.base.ErrorContent;
import im.base.IdleContent;
import im.base.LoadingContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactTabData.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"contentStatus", "Lim/base/ContentStatus;", "Lim/contact/model/IMContactTab;", "getContentStatus$annotations", "(Lim/contact/model/IMContactTab;)V", "getContentStatus", "(Lim/contact/model/IMContactTab;)Lim/base/ContentStatus;", "footStatus", "getFootStatus$annotations", "getFootStatus", "contact_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMContactTabDataKt {
    public static /* synthetic */ void getContentStatus$annotations(IMContactTab iMContactTab) {
    }

    public static /* synthetic */ void getFootStatus$annotations(IMContactTab iMContactTab) {
    }

    public static final ContentStatus getContentStatus(IMContactTab $this$contentStatus) {
        Intrinsics.checkNotNullParameter($this$contentStatus, "<this>");
        if ($this$contentStatus.getShowList().isEmpty() && Intrinsics.areEqual($this$contentStatus.getStatus(), StatusLoading.INSTANCE)) {
            return LoadingContent.INSTANCE;
        }
        if (!$this$contentStatus.getShowList().isEmpty() || !($this$contentStatus.getStatus() instanceof StatusError)) {
            return ($this$contentStatus.getShowList().isEmpty() && ($this$contentStatus.getStatus() instanceof StatusSuccess)) ? EmptyContent.INSTANCE : IdleContent.INSTANCE;
        }
        IMContactPageStatus status = $this$contentStatus.getStatus();
        StatusError statusError = status instanceof StatusError ? (StatusError) status : null;
        return new ErrorContent(statusError != null ? statusError.getMessage() : null);
    }

    public static final ContentStatus contentStatus(IMContactTab $this$contentStatus) {
        Intrinsics.checkNotNullParameter($this$contentStatus, "<this>");
        return getContentStatus($this$contentStatus);
    }

    public static final ContentStatus getFootStatus(IMContactTab $this$footStatus) {
        Intrinsics.checkNotNullParameter($this$footStatus, "<this>");
        if ($this$footStatus.getShowList().isEmpty()) {
            return IdleContent.INSTANCE;
        }
        if ($this$footStatus.getShowList().isEmpty() || !Intrinsics.areEqual($this$footStatus.getStatus(), StatusLoadingMore.INSTANCE)) {
            if ($this$footStatus.getShowList().isEmpty() || !($this$footStatus.getStatus() instanceof StatusError)) {
                return (!$this$footStatus.getShowList().isEmpty() && ($this$footStatus.getStatus() instanceof StatusSuccess) && $this$footStatus.getInSearch()) ? IdleContent.INSTANCE : EmptyContent.INSTANCE;
            }
            IMContactPageStatus status = $this$footStatus.getStatus();
            StatusError statusError = status instanceof StatusError ? (StatusError) status : null;
            return new ErrorContent(statusError != null ? statusError.getMessage() : null);
        }
        return LoadingContent.INSTANCE;
    }

    public static final ContentStatus footStatus(IMContactTab $this$footStatus) {
        Intrinsics.checkNotNullParameter($this$footStatus, "<this>");
        return getFootStatus($this$footStatus);
    }
}