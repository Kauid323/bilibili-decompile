package tv.danmaku.bili.downloadeshare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DownloadShare.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001c\u0010+\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012¨\u0006/"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "", "<init>", "()V", "avid", "", "getAvid", "()J", "setAvid", "(J)V", "cid", "getCid", "setCid", FavoritesConstsKt.SPMID, "", "getSpmid", "()Ljava/lang/String;", "setSpmid", "(Ljava/lang/String;)V", "shareId", "getShareId", "setShareId", "shareOrigin", "getShareOrigin", "setShareOrigin", "goto", "getGoto", "setGoto", "showMobileToast", "", "getShowMobileToast", "()Z", "setShowMobileToast", "(Z)V", "panelType", "", "getPanelType", "()I", "setPanelType", "(I)V", "objectExtraFields", "getObjectExtraFields", "setObjectExtraFields", "sid", "getSid", "setSid", "Builder", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShareParameter {
    private long avid;
    private long cid;

    /* renamed from: goto  reason: not valid java name */
    private String f5goto;
    private String objectExtraFields;
    private int panelType;
    private String shareId;
    private String shareOrigin;
    private boolean showMobileToast;
    private String sid;
    private String spmid;

    public /* synthetic */ DownloadShareParameter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DownloadShareParameter() {
        this.panelType = 1;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final void setAvid(long j) {
        this.avid = j;
    }

    public final long getCid() {
        return this.cid;
    }

    public final void setCid(long j) {
        this.cid = j;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final void setSpmid(String str) {
        this.spmid = str;
    }

    public final String getShareId() {
        return this.shareId;
    }

    public final void setShareId(String str) {
        this.shareId = str;
    }

    public final String getShareOrigin() {
        return this.shareOrigin;
    }

    public final void setShareOrigin(String str) {
        this.shareOrigin = str;
    }

    public final String getGoto() {
        return this.f5goto;
    }

    public final void setGoto(String str) {
        this.f5goto = str;
    }

    public final boolean getShowMobileToast() {
        return this.showMobileToast;
    }

    public final void setShowMobileToast(boolean z) {
        this.showMobileToast = z;
    }

    public final int getPanelType() {
        return this.panelType;
    }

    public final void setPanelType(int i) {
        this.panelType = i;
    }

    public final String getObjectExtraFields() {
        return this.objectExtraFields;
    }

    public final void setObjectExtraFields(String str) {
        this.objectExtraFields = str;
    }

    public final String getSid() {
        return this.sid;
    }

    public final void setSid(String str) {
        this.sid = str;
    }

    /* compiled from: DownloadShare.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadShareParameter$Builder;", "", "<init>", "()V", "parameter", "Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "setAvid", "avid", "", "setCid", "cid", "setSpmid", FavoritesConstsKt.SPMID, "", "setShareId", "shareId", "setShareOrigin", "shareOrigin", "panelType", "", "objectExtraFields", InnerPushReceiverKt.KEY_EXTRA, "sid", "build", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Builder {
        private final DownloadShareParameter parameter = new DownloadShareParameter(null);

        public final Builder setAvid(long avid) {
            this.parameter.setAvid(avid);
            return this;
        }

        public final Builder setCid(long cid) {
            this.parameter.setCid(cid);
            return this;
        }

        public final Builder setSpmid(String spmid) {
            this.parameter.setSpmid(spmid);
            return this;
        }

        public final Builder setShareId(String shareId) {
            this.parameter.setShareId(shareId);
            return this;
        }

        public final Builder setShareOrigin(String shareOrigin) {
            this.parameter.setShareOrigin(shareOrigin);
            return this;
        }

        public final Builder panelType(int panelType) {
            this.parameter.setPanelType(panelType);
            return this;
        }

        public final Builder objectExtraFields(String extra) {
            Intrinsics.checkNotNullParameter(extra, InnerPushReceiverKt.KEY_EXTRA);
            this.parameter.setObjectExtraFields(extra);
            return this;
        }

        public final Builder sid(String sid) {
            Intrinsics.checkNotNullParameter(sid, "sid");
            this.parameter.setSid(sid);
            return this;
        }

        public final DownloadShareParameter build() {
            return this.parameter;
        }
    }
}