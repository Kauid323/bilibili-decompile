package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IResource.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\n¨\u0006!"}, d2 = {"Lkntr/compose/avatar/model/common/UrlResource;", "Lkntr/compose/avatar/model/common/IResource;", "url", "", "style", "placeHolder", "Lkntr/compose/avatar/model/common/LocalSourceEnum;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/compose/avatar/model/common/LocalSourceEnum;)V", "getUrl", "()Ljava/lang/String;", "getStyle", "getPlaceHolder", "()Lkntr/compose/avatar/model/common/LocalSourceEnum;", "type", "Lkntr/compose/avatar/model/common/SourceType;", "getType", "()Lkntr/compose/avatar/model/common/SourceType;", "isValidResource", "", "()Z", "descStr", "getDescStr", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UrlResource implements IResource {
    private final LocalSourceEnum placeHolder;
    private final String style;
    private final String url;

    public UrlResource() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UrlResource copy$default(UrlResource urlResource, String str, String str2, LocalSourceEnum localSourceEnum, int i, Object obj) {
        if ((i & 1) != 0) {
            str = urlResource.url;
        }
        if ((i & 2) != 0) {
            str2 = urlResource.style;
        }
        if ((i & 4) != 0) {
            localSourceEnum = urlResource.placeHolder;
        }
        return urlResource.copy(str, str2, localSourceEnum);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.style;
    }

    public final LocalSourceEnum component3() {
        return this.placeHolder;
    }

    public final UrlResource copy(String str, String str2, LocalSourceEnum localSourceEnum) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "style");
        Intrinsics.checkNotNullParameter(localSourceEnum, "placeHolder");
        return new UrlResource(str, str2, localSourceEnum);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UrlResource) {
            UrlResource urlResource = (UrlResource) obj;
            return Intrinsics.areEqual(this.url, urlResource.url) && Intrinsics.areEqual(this.style, urlResource.style) && this.placeHolder == urlResource.placeHolder;
        }
        return false;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.style.hashCode()) * 31) + this.placeHolder.hashCode();
    }

    public String toString() {
        String str = this.url;
        String str2 = this.style;
        return "UrlResource(url=" + str + ", style=" + str2 + ", placeHolder=" + this.placeHolder + ")";
    }

    public UrlResource(String url, String style, LocalSourceEnum placeHolder) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeHolder, "placeHolder");
        this.url = url;
        this.style = style;
        this.placeHolder = placeHolder;
    }

    public /* synthetic */ UrlResource(String str, String str2, LocalSourceEnum localSourceEnum, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? LocalSourceEnum.Invalid : localSourceEnum);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getStyle() {
        return this.style;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public LocalSourceEnum getPlaceHolder() {
        return this.placeHolder;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public SourceType getType() {
        return SourceType.URLSource;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public boolean isValidResource() {
        return (StringsKt.isBlank(this.url) && getPlaceHolder() == LocalSourceEnum.Invalid) ? false : true;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public String getDescStr() {
        return "Url: " + this.url;
    }
}