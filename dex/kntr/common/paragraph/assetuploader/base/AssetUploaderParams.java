package kntr.common.paragraph.assetuploader.base;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.common.paragraph.watermark.AssetUploaderWaterMark;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUploaderParams.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "", "waterMark", "Lkntr/common/paragraph/watermark/AssetUploaderWaterMark;", "accountName", "", "<init>", "(Lkntr/common/paragraph/watermark/AssetUploaderWaterMark;Ljava/lang/String;)V", "getWaterMark", "()Lkntr/common/paragraph/watermark/AssetUploaderWaterMark;", "getAccountName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderParams {
    public static final Companion Companion = new Companion(null);
    private static final AssetUploaderParams Default = new AssetUploaderParams(null, Companion.getDisplayWatermarkName());
    private final String accountName;
    private final AssetUploaderWaterMark waterMark;

    public static /* synthetic */ AssetUploaderParams copy$default(AssetUploaderParams assetUploaderParams, AssetUploaderWaterMark assetUploaderWaterMark, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            assetUploaderWaterMark = assetUploaderParams.waterMark;
        }
        if ((i & 2) != 0) {
            str = assetUploaderParams.accountName;
        }
        return assetUploaderParams.copy(assetUploaderWaterMark, str);
    }

    public final AssetUploaderWaterMark component1() {
        return this.waterMark;
    }

    public final String component2() {
        return this.accountName;
    }

    public final AssetUploaderParams copy(AssetUploaderWaterMark assetUploaderWaterMark, String str) {
        Intrinsics.checkNotNullParameter(str, "accountName");
        return new AssetUploaderParams(assetUploaderWaterMark, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AssetUploaderParams) {
            AssetUploaderParams assetUploaderParams = (AssetUploaderParams) obj;
            return Intrinsics.areEqual(this.waterMark, assetUploaderParams.waterMark) && Intrinsics.areEqual(this.accountName, assetUploaderParams.accountName);
        }
        return false;
    }

    public int hashCode() {
        return ((this.waterMark == null ? 0 : this.waterMark.hashCode()) * 31) + this.accountName.hashCode();
    }

    public String toString() {
        AssetUploaderWaterMark assetUploaderWaterMark = this.waterMark;
        return "AssetUploaderParams(waterMark=" + assetUploaderWaterMark + ", accountName=" + this.accountName + ")";
    }

    public AssetUploaderParams(AssetUploaderWaterMark waterMark, String accountName) {
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        this.waterMark = waterMark;
        this.accountName = accountName;
    }

    public final AssetUploaderWaterMark getWaterMark() {
        return this.waterMark;
    }

    public final String getAccountName() {
        return this.accountName;
    }

    /* compiled from: AssetUploaderParams.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams$Companion;", "", "<init>", "()V", "Default", "Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "getDefault", "()Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "getDisplayWatermarkName", "", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AssetUploaderParams getDefault() {
            return AssetUploaderParams.Default;
        }

        public final String getDisplayWatermarkName() {
            AccountState info = (AccountState) KAccountStoreKt.getAccountHolder().getState().getValue();
            if (Intrinsics.areEqual(info, AccountState.Idle.INSTANCE)) {
                return "";
            }
            if (info instanceof AccountState.Logged) {
                return ((AccountState.Logged) info).getUserInfo().getName();
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}