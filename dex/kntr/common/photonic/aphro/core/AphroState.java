package kntr.common.photonic.aphro.core;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AphroState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState;", "", "Init", "LoadingAlbum", "NotAuthorized", "AphroContent", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum;", "Lkntr/common/photonic/aphro/core/AphroState$NotAuthorized;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AphroState {

    /* compiled from: AphroState.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$Init;", "Lkntr/common/photonic/aphro/core/AphroState;", "preSelected", "Lkntr/common/photonic/aphro/core/AphroSelection;", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "requiredAssetCount", "", "initialAlbumId", "", "<init>", "(Lkntr/common/photonic/aphro/core/AphroSelection;Lkntr/common/photonic/aphro/core/AphroSelectOption;ILjava/lang/String;)V", "getPreSelected", "()Lkntr/common/photonic/aphro/core/AphroSelection;", "getOption", "()Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getRequiredAssetCount", "()I", "getInitialAlbumId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Lens
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Init implements AphroState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String initialAlbumId;
        private final AphroSelectOption option;
        private final AphroSelection preSelected;
        private final int requiredAssetCount;

        public Init() {
            this(null, null, 0, null, 15, null);
        }

        public static /* synthetic */ Init copy$default(Init init, AphroSelection aphroSelection, AphroSelectOption aphroSelectOption, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                aphroSelection = init.preSelected;
            }
            if ((i2 & 2) != 0) {
                aphroSelectOption = init.option;
            }
            if ((i2 & 4) != 0) {
                i = init.requiredAssetCount;
            }
            if ((i2 & 8) != 0) {
                str = init.initialAlbumId;
            }
            return init.copy(aphroSelection, aphroSelectOption, i, str);
        }

        public final AphroSelection component1() {
            return this.preSelected;
        }

        public final AphroSelectOption component2() {
            return this.option;
        }

        public final int component3() {
            return this.requiredAssetCount;
        }

        public final String component4() {
            return this.initialAlbumId;
        }

        public final Init copy(AphroSelection aphroSelection, AphroSelectOption aphroSelectOption, int i, String str) {
            Intrinsics.checkNotNullParameter(aphroSelection, "preSelected");
            Intrinsics.checkNotNullParameter(aphroSelectOption, WatchLaterReporterKt.KEY_OPTION);
            return new Init(aphroSelection, aphroSelectOption, i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Init) {
                Init init = (Init) obj;
                return Intrinsics.areEqual(this.preSelected, init.preSelected) && Intrinsics.areEqual(this.option, init.option) && this.requiredAssetCount == init.requiredAssetCount && Intrinsics.areEqual(this.initialAlbumId, init.initialAlbumId);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.preSelected.hashCode() * 31) + this.option.hashCode()) * 31) + this.requiredAssetCount) * 31) + (this.initialAlbumId == null ? 0 : this.initialAlbumId.hashCode());
        }

        public String toString() {
            AphroSelection aphroSelection = this.preSelected;
            AphroSelectOption aphroSelectOption = this.option;
            int i = this.requiredAssetCount;
            return "Init(preSelected=" + aphroSelection + ", option=" + aphroSelectOption + ", requiredAssetCount=" + i + ", initialAlbumId=" + this.initialAlbumId + ")";
        }

        public Init(AphroSelection preSelected, AphroSelectOption option, int requiredAssetCount, String initialAlbumId) {
            Intrinsics.checkNotNullParameter(preSelected, "preSelected");
            Intrinsics.checkNotNullParameter(option, WatchLaterReporterKt.KEY_OPTION);
            this.preSelected = preSelected;
            this.option = option;
            this.requiredAssetCount = requiredAssetCount;
            this.initialAlbumId = initialAlbumId;
        }

        public /* synthetic */ Init(AphroSelection aphroSelection, AphroSelectOption aphroSelectOption, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? new AphroSelection(CollectionsKt.emptyList(), false) : aphroSelection, (i2 & 2) != 0 ? new AphroSelectOption(0, 0, false, null, null, false, false, false, null, null, 1023, null) : aphroSelectOption, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? null : str);
        }

        public final AphroSelection getPreSelected() {
            return this.preSelected;
        }

        public final AphroSelectOption getOption() {
            return this.option;
        }

        public final int getRequiredAssetCount() {
            return this.requiredAssetCount;
        }

        public final String getInitialAlbumId() {
            return this.initialAlbumId;
        }

        /* compiled from: AphroState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$Init$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: AphroState.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum;", "Lkntr/common/photonic/aphro/core/AphroState;", "preSelected", "Lkntr/common/photonic/aphro/core/AphroSelection;", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "requiredAssetCount", "", "initialAlbumId", "", "<init>", "(Lkntr/common/photonic/aphro/core/AphroSelection;Lkntr/common/photonic/aphro/core/AphroSelectOption;ILjava/lang/String;)V", "getPreSelected", "()Lkntr/common/photonic/aphro/core/AphroSelection;", "getOption", "()Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getRequiredAssetCount", "()I", "getInitialAlbumId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Lens
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadingAlbum implements AphroState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String initialAlbumId;
        private final AphroSelectOption option;
        private final AphroSelection preSelected;
        private final int requiredAssetCount;

        public static /* synthetic */ LoadingAlbum copy$default(LoadingAlbum loadingAlbum, AphroSelection aphroSelection, AphroSelectOption aphroSelectOption, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                aphroSelection = loadingAlbum.preSelected;
            }
            if ((i2 & 2) != 0) {
                aphroSelectOption = loadingAlbum.option;
            }
            if ((i2 & 4) != 0) {
                i = loadingAlbum.requiredAssetCount;
            }
            if ((i2 & 8) != 0) {
                str = loadingAlbum.initialAlbumId;
            }
            return loadingAlbum.copy(aphroSelection, aphroSelectOption, i, str);
        }

        public final AphroSelection component1() {
            return this.preSelected;
        }

        public final AphroSelectOption component2() {
            return this.option;
        }

        public final int component3() {
            return this.requiredAssetCount;
        }

        public final String component4() {
            return this.initialAlbumId;
        }

        public final LoadingAlbum copy(AphroSelection aphroSelection, AphroSelectOption aphroSelectOption, int i, String str) {
            Intrinsics.checkNotNullParameter(aphroSelection, "preSelected");
            Intrinsics.checkNotNullParameter(aphroSelectOption, WatchLaterReporterKt.KEY_OPTION);
            return new LoadingAlbum(aphroSelection, aphroSelectOption, i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadingAlbum) {
                LoadingAlbum loadingAlbum = (LoadingAlbum) obj;
                return Intrinsics.areEqual(this.preSelected, loadingAlbum.preSelected) && Intrinsics.areEqual(this.option, loadingAlbum.option) && this.requiredAssetCount == loadingAlbum.requiredAssetCount && Intrinsics.areEqual(this.initialAlbumId, loadingAlbum.initialAlbumId);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.preSelected.hashCode() * 31) + this.option.hashCode()) * 31) + this.requiredAssetCount) * 31) + (this.initialAlbumId == null ? 0 : this.initialAlbumId.hashCode());
        }

        public String toString() {
            AphroSelection aphroSelection = this.preSelected;
            AphroSelectOption aphroSelectOption = this.option;
            int i = this.requiredAssetCount;
            return "LoadingAlbum(preSelected=" + aphroSelection + ", option=" + aphroSelectOption + ", requiredAssetCount=" + i + ", initialAlbumId=" + this.initialAlbumId + ")";
        }

        public LoadingAlbum(AphroSelection preSelected, AphroSelectOption option, int requiredAssetCount, String initialAlbumId) {
            Intrinsics.checkNotNullParameter(preSelected, "preSelected");
            Intrinsics.checkNotNullParameter(option, WatchLaterReporterKt.KEY_OPTION);
            this.preSelected = preSelected;
            this.option = option;
            this.requiredAssetCount = requiredAssetCount;
            this.initialAlbumId = initialAlbumId;
        }

        public /* synthetic */ LoadingAlbum(AphroSelection aphroSelection, AphroSelectOption aphroSelectOption, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(aphroSelection, aphroSelectOption, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? null : str);
        }

        public final AphroSelection getPreSelected() {
            return this.preSelected;
        }

        public final AphroSelectOption getOption() {
            return this.option;
        }

        public final int getRequiredAssetCount() {
            return this.requiredAssetCount;
        }

        public final String getInitialAlbumId() {
            return this.initialAlbumId;
        }

        /* compiled from: AphroState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: AphroState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$NotAuthorized;", "Lkntr/common/photonic/aphro/core/AphroState;", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "<init>", "(Lkntr/common/photonic/aphro/core/AphroSelectOption;)V", "getOption", "()Lkntr/common/photonic/aphro/core/AphroSelectOption;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Lens
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class NotAuthorized implements AphroState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final AphroSelectOption option;

        public static /* synthetic */ NotAuthorized copy$default(NotAuthorized notAuthorized, AphroSelectOption aphroSelectOption, int i, Object obj) {
            if ((i & 1) != 0) {
                aphroSelectOption = notAuthorized.option;
            }
            return notAuthorized.copy(aphroSelectOption);
        }

        public final AphroSelectOption component1() {
            return this.option;
        }

        public final NotAuthorized copy(AphroSelectOption aphroSelectOption) {
            Intrinsics.checkNotNullParameter(aphroSelectOption, WatchLaterReporterKt.KEY_OPTION);
            return new NotAuthorized(aphroSelectOption);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotAuthorized) && Intrinsics.areEqual(this.option, ((NotAuthorized) obj).option);
        }

        public int hashCode() {
            return this.option.hashCode();
        }

        public String toString() {
            return "NotAuthorized(option=" + this.option + ")";
        }

        public NotAuthorized(AphroSelectOption option) {
            Intrinsics.checkNotNullParameter(option, WatchLaterReporterKt.KEY_OPTION);
            this.option = option;
        }

        public final AphroSelectOption getOption() {
            return this.option;
        }

        /* compiled from: AphroState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$NotAuthorized$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: AphroState.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0001MB{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\u000bHÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007HÆ\u0003J\u000e\u0010A\u001a\u00020\u0012HÀ\u0003¢\u0006\u0002\bBJ\u000e\u0010C\u001a\u00020\u0012HÀ\u0003¢\u0006\u0002\bDJ\u000b\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0087\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u0010G\u001a\u00020\r2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\u0012HÖ\u0001J\t\u0010K\u001a\u00020LHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0013\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078F¢\u0006\u0006\u001a\u0004\b,\u0010\u001dR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078F¢\u0006\u0006\u001a\u0004\b.\u0010\u001dR\u0013\u0010/\u001a\u000200¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0017\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001dR\u0011\u00107\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b8\u0010#¨\u0006N"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "Lkntr/common/photonic/aphro/core/AphroState;", "status", "Lkntr/common/photonic/aphro/core/AphroPageStatus;", "selectedAlbum", "Lkntr/common/photonic/AlbumInfo;", "albumList", "", "assetsState", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "useOriginImage", "", "confirmed", "selected", "Lkntr/common/photonic/Asset;", "albumRefresh", "", "requiredAssetCount", "toast", "Lkntr/common/photonic/aphro/core/ToastData;", "<init>", "(Lkntr/common/photonic/aphro/core/AphroPageStatus;Lkntr/common/photonic/AlbumInfo;Ljava/util/List;Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;Lkntr/common/photonic/aphro/core/AphroSelectOption;ZZLjava/util/List;IILkntr/common/photonic/aphro/core/ToastData;)V", "getStatus", "()Lkntr/common/photonic/aphro/core/AphroPageStatus;", "getSelectedAlbum", "()Lkntr/common/photonic/AlbumInfo;", "getAlbumList", "()Ljava/util/List;", "getAssetsState", "()Lkntr/common/photonic/aphro/core/assets/AphroAssetsState;", "getOption", "()Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getUseOriginImage", "()Z", "getConfirmed", "getSelected", "getAlbumRefresh$core_debug", "()I", "getRequiredAssetCount$core_debug", "getToast", "()Lkntr/common/photonic/aphro/core/ToastData;", "currentSelected", "getCurrentSelected", "currentAssetList", "getCurrentAssetList", "totalSelectedSize", "Lkntr/common/photonic/ContentSize;", "getTotalSelectedSize-QJZHGII", "()D", "D", "assetStateList", "Lkntr/common/photonic/aphro/core/AssetItemState;", "getAssetStateList", "canSelectMore", "getCanSelectMore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component9$core_debug", "component10", "component10$core_debug", "component11", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Lens
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AphroContent implements AphroState {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final List<AlbumInfo> albumList;
        private final int albumRefresh;
        private final List<AssetItemState> assetStateList;
        private final AphroAssetsState assetsState;
        private final boolean confirmed;
        private final AphroSelectOption option;
        private final int requiredAssetCount;
        private final List<Asset> selected;
        private final AlbumInfo selectedAlbum;
        private final AphroPageStatus status;
        private final ToastData toast;
        private final double totalSelectedSize;
        private final boolean useOriginImage;

        public final AphroPageStatus component1() {
            return this.status;
        }

        public final int component10$core_debug() {
            return this.requiredAssetCount;
        }

        public final ToastData component11() {
            return this.toast;
        }

        public final AlbumInfo component2() {
            return this.selectedAlbum;
        }

        public final List<AlbumInfo> component3() {
            return this.albumList;
        }

        public final AphroAssetsState component4() {
            return this.assetsState;
        }

        public final AphroSelectOption component5() {
            return this.option;
        }

        public final boolean component6() {
            return this.useOriginImage;
        }

        public final boolean component7() {
            return this.confirmed;
        }

        public final List<Asset> component8() {
            return this.selected;
        }

        public final int component9$core_debug() {
            return this.albumRefresh;
        }

        public final AphroContent copy(AphroPageStatus aphroPageStatus, AlbumInfo albumInfo, List<? extends AlbumInfo> list, AphroAssetsState aphroAssetsState, AphroSelectOption aphroSelectOption, boolean z, boolean z2, List<? extends Asset> list2, int i, int i2, ToastData toastData) {
            Intrinsics.checkNotNullParameter(aphroPageStatus, "status");
            Intrinsics.checkNotNullParameter(list, "albumList");
            Intrinsics.checkNotNullParameter(aphroAssetsState, "assetsState");
            Intrinsics.checkNotNullParameter(aphroSelectOption, WatchLaterReporterKt.KEY_OPTION);
            Intrinsics.checkNotNullParameter(list2, "selected");
            return new AphroContent(aphroPageStatus, albumInfo, list, aphroAssetsState, aphroSelectOption, z, z2, list2, i, i2, toastData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AphroContent) {
                AphroContent aphroContent = (AphroContent) obj;
                return Intrinsics.areEqual(this.status, aphroContent.status) && Intrinsics.areEqual(this.selectedAlbum, aphroContent.selectedAlbum) && Intrinsics.areEqual(this.albumList, aphroContent.albumList) && Intrinsics.areEqual(this.assetsState, aphroContent.assetsState) && Intrinsics.areEqual(this.option, aphroContent.option) && this.useOriginImage == aphroContent.useOriginImage && this.confirmed == aphroContent.confirmed && Intrinsics.areEqual(this.selected, aphroContent.selected) && this.albumRefresh == aphroContent.albumRefresh && this.requiredAssetCount == aphroContent.requiredAssetCount && Intrinsics.areEqual(this.toast, aphroContent.toast);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((this.status.hashCode() * 31) + (this.selectedAlbum == null ? 0 : this.selectedAlbum.hashCode())) * 31) + this.albumList.hashCode()) * 31) + this.assetsState.hashCode()) * 31) + this.option.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginImage)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.confirmed)) * 31) + this.selected.hashCode()) * 31) + this.albumRefresh) * 31) + this.requiredAssetCount) * 31) + (this.toast != null ? this.toast.hashCode() : 0);
        }

        public String toString() {
            AphroPageStatus aphroPageStatus = this.status;
            AlbumInfo albumInfo = this.selectedAlbum;
            List<AlbumInfo> list = this.albumList;
            AphroAssetsState aphroAssetsState = this.assetsState;
            AphroSelectOption aphroSelectOption = this.option;
            boolean z = this.useOriginImage;
            boolean z2 = this.confirmed;
            List<Asset> list2 = this.selected;
            int i = this.albumRefresh;
            int i2 = this.requiredAssetCount;
            return "AphroContent(status=" + aphroPageStatus + ", selectedAlbum=" + albumInfo + ", albumList=" + list + ", assetsState=" + aphroAssetsState + ", option=" + aphroSelectOption + ", useOriginImage=" + z + ", confirmed=" + z2 + ", selected=" + list2 + ", albumRefresh=" + i + ", requiredAssetCount=" + i2 + ", toast=" + this.toast + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AphroContent(AphroPageStatus status, AlbumInfo selectedAlbum, List<? extends AlbumInfo> list, AphroAssetsState assetsState, AphroSelectOption option, boolean useOriginImage, boolean confirmed, List<? extends Asset> list2, int albumRefresh, int requiredAssetCount, ToastData toast) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(list, "albumList");
            Intrinsics.checkNotNullParameter(assetsState, "assetsState");
            Intrinsics.checkNotNullParameter(option, WatchLaterReporterKt.KEY_OPTION);
            Intrinsics.checkNotNullParameter(list2, "selected");
            this.status = status;
            this.selectedAlbum = selectedAlbum;
            this.albumList = list;
            this.assetsState = assetsState;
            this.option = option;
            this.useOriginImage = useOriginImage;
            this.confirmed = confirmed;
            this.selected = list2;
            this.albumRefresh = albumRefresh;
            this.requiredAssetCount = requiredAssetCount;
            this.toast = toast;
            Iterable $this$fold$iv = getCurrentSelected();
            double initial$iv = ContentSizeKt.bytes((Number) 0L);
            double accumulator$iv = initial$iv;
            for (Object element$iv : $this$fold$iv) {
                Asset item = (Asset) element$iv;
                double acc = accumulator$iv;
                accumulator$iv = ContentSize.m2191plusmcnd5EU(acc, item.mo2158getContentSizeQJZHGII());
            }
            this.totalSelectedSize = accumulator$iv;
            Iterable $this$map$iv = getCurrentAssetList();
            int $i$f$map = 0;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Asset asset = (Asset) item$iv$iv;
                destination$iv$iv.add(new AssetItemState(asset, getCurrentSelected().indexOf(asset)));
                $this$map$iv = $this$map$iv;
                $i$f$map = $i$f$map;
            }
            this.assetStateList = (List) destination$iv$iv;
        }

        public /* synthetic */ AphroContent(AphroPageStatus aphroPageStatus, AlbumInfo albumInfo, List list, AphroAssetsState aphroAssetsState, AphroSelectOption aphroSelectOption, boolean z, boolean z2, List list2, int i, int i2, ToastData toastData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(aphroPageStatus, albumInfo, list, aphroAssetsState, (i3 & 16) != 0 ? new AphroSelectOption(0, 0, false, null, null, false, false, false, null, null, 1023, null) : aphroSelectOption, z, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 256) != 0 ? 0 : i, (i3 & 512) != 0 ? -1 : i2, (i3 & 1024) != 0 ? null : toastData);
        }

        public final AphroPageStatus getStatus() {
            return this.status;
        }

        public final AlbumInfo getSelectedAlbum() {
            return this.selectedAlbum;
        }

        public final List<AlbumInfo> getAlbumList() {
            return this.albumList;
        }

        public final AphroAssetsState getAssetsState() {
            return this.assetsState;
        }

        public final AphroSelectOption getOption() {
            return this.option;
        }

        public final boolean getUseOriginImage() {
            return this.useOriginImage;
        }

        public final boolean getConfirmed() {
            return this.confirmed;
        }

        public final List<Asset> getSelected() {
            return this.selected;
        }

        public final int getAlbumRefresh$core_debug() {
            return this.albumRefresh;
        }

        public final int getRequiredAssetCount$core_debug() {
            return this.requiredAssetCount;
        }

        public final ToastData getToast() {
            return this.toast;
        }

        /* compiled from: AphroState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroState$AphroContent$Companion;", "", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final List<Asset> getCurrentSelected() {
            return this.selected;
        }

        public final List<Asset> getCurrentAssetList() {
            List<Asset> assetList;
            AphroAssetsState aphroAssetsState = this.assetsState;
            AphroAssetsState.AphroContent aphroContent = aphroAssetsState instanceof AphroAssetsState.AphroContent ? (AphroAssetsState.AphroContent) aphroAssetsState : null;
            return (aphroContent == null || (assetList = aphroContent.getAssetList()) == null) ? CollectionsKt.emptyList() : assetList;
        }

        /* renamed from: getTotalSelectedSize-QJZHGII  reason: not valid java name */
        public final double m2202getTotalSelectedSizeQJZHGII() {
            return this.totalSelectedSize;
        }

        public final List<AssetItemState> getAssetStateList() {
            return this.assetStateList;
        }

        public final boolean getCanSelectMore() {
            return getCurrentSelected().size() < this.option.getRemainingSelectCount();
        }
    }
}