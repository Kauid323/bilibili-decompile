package kntr.common.photonic.aphro.core;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.gallery.GalleryLoadConfig;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroState.kt */
@Lens
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00015Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0012HÆ\u0003Ju\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroSelectOption;", "", "remainingSelectCount", "", "maxSelectCount", "autoDismiss", "", "galleryLoadConfig", "Lkntr/common/photonic/gallery/GalleryLoadConfig;", "selectableMediaTypes", "", "Lkntr/common/photonic/MimeType;", "showSelections", "confirmedOnDismissed", "dismissOnConfirm", "contentSizeLimit", "Lkntr/common/photonic/aphro/core/ContentSizeLimit;", "aspectRadioLimit", "Lkntr/common/photonic/aphro/core/AspectRadioLimit;", "<init>", "(IIZLkntr/common/photonic/gallery/GalleryLoadConfig;Ljava/util/List;ZZZLkntr/common/photonic/aphro/core/ContentSizeLimit;Lkntr/common/photonic/aphro/core/AspectRadioLimit;)V", "getRemainingSelectCount", "()I", "getMaxSelectCount", "getAutoDismiss", "()Z", "getGalleryLoadConfig", "()Lkntr/common/photonic/gallery/GalleryLoadConfig;", "getSelectableMediaTypes", "()Ljava/util/List;", "getShowSelections", "getConfirmedOnDismissed", "getDismissOnConfirm", "getContentSizeLimit", "()Lkntr/common/photonic/aphro/core/ContentSizeLimit;", "getAspectRadioLimit", "()Lkntr/common/photonic/aphro/core/AspectRadioLimit;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroSelectOption {
    private final AspectRadioLimit aspectRadioLimit;
    private final boolean autoDismiss;
    private final boolean confirmedOnDismissed;
    private final ContentSizeLimit contentSizeLimit;
    private final boolean dismissOnConfirm;
    private final GalleryLoadConfig galleryLoadConfig;
    private final int maxSelectCount;
    private final int remainingSelectCount;
    private final List<MimeType> selectableMediaTypes;
    private final boolean showSelections;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AphroSelectOption() {
        this(0, 0, false, null, null, false, false, false, null, null, 1023, null);
    }

    public final int component1() {
        return this.remainingSelectCount;
    }

    public final AspectRadioLimit component10() {
        return this.aspectRadioLimit;
    }

    public final int component2() {
        return this.maxSelectCount;
    }

    public final boolean component3() {
        return this.autoDismiss;
    }

    public final GalleryLoadConfig component4() {
        return this.galleryLoadConfig;
    }

    public final List<MimeType> component5() {
        return this.selectableMediaTypes;
    }

    public final boolean component6() {
        return this.showSelections;
    }

    public final boolean component7() {
        return this.confirmedOnDismissed;
    }

    public final boolean component8() {
        return this.dismissOnConfirm;
    }

    public final ContentSizeLimit component9() {
        return this.contentSizeLimit;
    }

    public final AphroSelectOption copy(int i, int i2, boolean z, GalleryLoadConfig galleryLoadConfig, List<MimeType> list, boolean z2, boolean z3, boolean z4, ContentSizeLimit contentSizeLimit, AspectRadioLimit aspectRadioLimit) {
        Intrinsics.checkNotNullParameter(galleryLoadConfig, "galleryLoadConfig");
        Intrinsics.checkNotNullParameter(list, "selectableMediaTypes");
        Intrinsics.checkNotNullParameter(aspectRadioLimit, "aspectRadioLimit");
        return new AphroSelectOption(i, i2, z, galleryLoadConfig, list, z2, z3, z4, contentSizeLimit, aspectRadioLimit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AphroSelectOption) {
            AphroSelectOption aphroSelectOption = (AphroSelectOption) obj;
            return this.remainingSelectCount == aphroSelectOption.remainingSelectCount && this.maxSelectCount == aphroSelectOption.maxSelectCount && this.autoDismiss == aphroSelectOption.autoDismiss && Intrinsics.areEqual(this.galleryLoadConfig, aphroSelectOption.galleryLoadConfig) && Intrinsics.areEqual(this.selectableMediaTypes, aphroSelectOption.selectableMediaTypes) && this.showSelections == aphroSelectOption.showSelections && this.confirmedOnDismissed == aphroSelectOption.confirmedOnDismissed && this.dismissOnConfirm == aphroSelectOption.dismissOnConfirm && Intrinsics.areEqual(this.contentSizeLimit, aphroSelectOption.contentSizeLimit) && Intrinsics.areEqual(this.aspectRadioLimit, aphroSelectOption.aspectRadioLimit);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.remainingSelectCount * 31) + this.maxSelectCount) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.autoDismiss)) * 31) + this.galleryLoadConfig.hashCode()) * 31) + this.selectableMediaTypes.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showSelections)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.confirmedOnDismissed)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.dismissOnConfirm)) * 31) + (this.contentSizeLimit == null ? 0 : this.contentSizeLimit.hashCode())) * 31) + this.aspectRadioLimit.hashCode();
    }

    public String toString() {
        int i = this.remainingSelectCount;
        int i2 = this.maxSelectCount;
        boolean z = this.autoDismiss;
        GalleryLoadConfig galleryLoadConfig = this.galleryLoadConfig;
        List<MimeType> list = this.selectableMediaTypes;
        boolean z2 = this.showSelections;
        boolean z3 = this.confirmedOnDismissed;
        boolean z4 = this.dismissOnConfirm;
        ContentSizeLimit contentSizeLimit = this.contentSizeLimit;
        return "AphroSelectOption(remainingSelectCount=" + i + ", maxSelectCount=" + i2 + ", autoDismiss=" + z + ", galleryLoadConfig=" + galleryLoadConfig + ", selectableMediaTypes=" + list + ", showSelections=" + z2 + ", confirmedOnDismissed=" + z3 + ", dismissOnConfirm=" + z4 + ", contentSizeLimit=" + contentSizeLimit + ", aspectRadioLimit=" + this.aspectRadioLimit + ")";
    }

    public AphroSelectOption(int remainingSelectCount, int maxSelectCount, boolean autoDismiss, GalleryLoadConfig galleryLoadConfig, List<MimeType> list, boolean showSelections, boolean confirmedOnDismissed, boolean dismissOnConfirm, ContentSizeLimit contentSizeLimit, AspectRadioLimit aspectRadioLimit) {
        Intrinsics.checkNotNullParameter(galleryLoadConfig, "galleryLoadConfig");
        Intrinsics.checkNotNullParameter(list, "selectableMediaTypes");
        Intrinsics.checkNotNullParameter(aspectRadioLimit, "aspectRadioLimit");
        this.remainingSelectCount = remainingSelectCount;
        this.maxSelectCount = maxSelectCount;
        this.autoDismiss = autoDismiss;
        this.galleryLoadConfig = galleryLoadConfig;
        this.selectableMediaTypes = list;
        this.showSelections = showSelections;
        this.confirmedOnDismissed = confirmedOnDismissed;
        this.dismissOnConfirm = dismissOnConfirm;
        this.contentSizeLimit = contentSizeLimit;
        this.aspectRadioLimit = aspectRadioLimit;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AphroSelectOption(int i, int i2, boolean z, GalleryLoadConfig galleryLoadConfig, List list, boolean z2, boolean z3, boolean z4, ContentSizeLimit contentSizeLimit, AspectRadioLimit aspectRadioLimit, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, (i3 & 4) != 0 ? r3 == 1 : z, (i3 & 8) != 0 ? new GalleryLoadConfig(GalleryLoadConfig.MediaType.IMAGE, SetsKt.setOf(GalleryLoadConfig.TransformOption.LIVE_PHOTO_AS_IMAGE), null, 4, null) : galleryLoadConfig, (i3 & 16) != 0 ? MimeType.Companion.getIMAGES() : list, (i3 & 32) != 0 ? true : z2, (i3 & 64) != 0 ? true : z3, (i3 & 128) == 0 ? z4 : true, (i3 & 256) != 0 ? null : contentSizeLimit, (i3 & 512) != 0 ? new AspectRadioLimit(0.0f, 0.0f, null, null, 15, null) : aspectRadioLimit);
        int i4 = (i3 & 1) != 0 ? 1 : i;
        int i5 = (i3 & 2) != 0 ? i4 : i2;
    }

    public final int getRemainingSelectCount() {
        return this.remainingSelectCount;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final boolean getAutoDismiss() {
        return this.autoDismiss;
    }

    public final GalleryLoadConfig getGalleryLoadConfig() {
        return this.galleryLoadConfig;
    }

    public final List<MimeType> getSelectableMediaTypes() {
        return this.selectableMediaTypes;
    }

    public final boolean getShowSelections() {
        return this.showSelections;
    }

    public final boolean getConfirmedOnDismissed() {
        return this.confirmedOnDismissed;
    }

    public final boolean getDismissOnConfirm() {
        return this.dismissOnConfirm;
    }

    public final ContentSizeLimit getContentSizeLimit() {
        return this.contentSizeLimit;
    }

    public final AspectRadioLimit getAspectRadioLimit() {
        return this.aspectRadioLimit;
    }

    /* compiled from: AphroState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroSelectOption$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}