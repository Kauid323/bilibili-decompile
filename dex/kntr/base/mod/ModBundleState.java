package kntr.base.mod;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GMod.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/base/mod/ModBundleState;", "", "Installing", "Installed", "Lkntr/base/mod/ModBundleState$Installed;", "Lkntr/base/mod/ModBundleState$Installing;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ModBundleState {

    /* compiled from: GMod.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkntr/base/mod/ModBundleState$Installing;", "Lkntr/base/mod/ModBundleState;", "progress", "", "errorCode", "", "<init>", "(FLjava/lang/Integer;)V", "getProgress", "()F", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(FLjava/lang/Integer;)Lkntr/base/mod/ModBundleState$Installing;", "equals", "", "other", "", "hashCode", "toString", "", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Installing implements ModBundleState {
        private final Integer errorCode;
        private final float progress;

        public static /* synthetic */ Installing copy$default(Installing installing, float f, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                f = installing.progress;
            }
            if ((i & 2) != 0) {
                num = installing.errorCode;
            }
            return installing.copy(f, num);
        }

        public final float component1() {
            return this.progress;
        }

        public final Integer component2() {
            return this.errorCode;
        }

        public final Installing copy(float f, Integer num) {
            return new Installing(f, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Installing) {
                Installing installing = (Installing) obj;
                return Float.compare(this.progress, installing.progress) == 0 && Intrinsics.areEqual(this.errorCode, installing.errorCode);
            }
            return false;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.progress) * 31) + (this.errorCode == null ? 0 : this.errorCode.hashCode());
        }

        public String toString() {
            float f = this.progress;
            return "Installing(progress=" + f + ", errorCode=" + this.errorCode + ")";
        }

        public Installing(float progress, Integer errorCode) {
            this.progress = progress;
            this.errorCode = errorCode;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }
    }

    /* compiled from: GMod.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lkntr/base/mod/ModBundleState$Installed;", "Lkntr/base/mod/ModBundleState;", "bundle", "Lkntr/base/mod/ModBundle;", "isExpired", "", "<init>", "(Lkntr/base/mod/ModBundle;Z)V", "getBundle", "()Lkntr/base/mod/ModBundle;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Installed implements ModBundleState {
        private final ModBundle bundle;
        private final boolean isExpired;

        public static /* synthetic */ Installed copy$default(Installed installed, ModBundle modBundle, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                modBundle = installed.bundle;
            }
            if ((i & 2) != 0) {
                z = installed.isExpired;
            }
            return installed.copy(modBundle, z);
        }

        public final ModBundle component1() {
            return this.bundle;
        }

        public final boolean component2() {
            return this.isExpired;
        }

        public final Installed copy(ModBundle modBundle, boolean z) {
            Intrinsics.checkNotNullParameter(modBundle, "bundle");
            return new Installed(modBundle, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Installed) {
                Installed installed = (Installed) obj;
                return Intrinsics.areEqual(this.bundle, installed.bundle) && this.isExpired == installed.isExpired;
            }
            return false;
        }

        public int hashCode() {
            return (this.bundle.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isExpired);
        }

        public String toString() {
            ModBundle modBundle = this.bundle;
            return "Installed(bundle=" + modBundle + ", isExpired=" + this.isExpired + ")";
        }

        public Installed(ModBundle bundle, boolean isExpired) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.bundle = bundle;
            this.isExpired = isExpired;
        }

        public final ModBundle getBundle() {
            return this.bundle;
        }

        public final boolean isExpired() {
            return this.isExpired;
        }
    }
}