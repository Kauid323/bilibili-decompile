package kntr.common.photonic.permission;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPermissionType.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\r"}, d2 = {"Lkntr/common/photonic/permission/AndroidPermissionType;", "", "<init>", "(Ljava/lang/String;I)V", "GALLERY", "CAMERA", "SAVE_IMAGE_INTO_COMMON_PHOTO_ALBUM", "value", "", "", "getValue", "()Ljava/util/List;", "Companion", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum AndroidPermissionType {
    GALLERY { // from class: kntr.common.photonic.permission.AndroidPermissionType.GALLERY
        private final List<String> value;

        @Override // kntr.common.photonic.permission.AndroidPermissionType
        public List<String> getValue() {
            return this.value;
        }
    },
    CAMERA { // from class: kntr.common.photonic.permission.AndroidPermissionType.CAMERA
        private final List<String> value;

        @Override // kntr.common.photonic.permission.AndroidPermissionType
        public List<String> getValue() {
            return this.value;
        }
    },
    SAVE_IMAGE_INTO_COMMON_PHOTO_ALBUM { // from class: kntr.common.photonic.permission.AndroidPermissionType.SAVE_IMAGE_INTO_COMMON_PHOTO_ALBUM
        private final List<String> value;

        @Override // kntr.common.photonic.permission.AndroidPermissionType
        public List<String> getValue() {
            return this.value;
        }
    };
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    /* synthetic */ AndroidPermissionType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static EnumEntries<AndroidPermissionType> getEntries() {
        return $ENTRIES;
    }

    public abstract List<String> getValue();

    /* compiled from: AndroidPermissionType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkntr/common/photonic/permission/AndroidPermissionType$Companion;", "", "<init>", "()V", "fromBPermission", "Lkntr/common/photonic/permission/AndroidPermissionType;", "permission", "Lkntr/common/photonic/permission/BPermissionType;", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {

        /* compiled from: AndroidPermissionType.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[BPermissionType.values().length];
                try {
                    iArr[BPermissionType.GALLERY.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[BPermissionType.CAMERA.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[BPermissionType.SAVE_IMAGE_INTO_COMMON_PHOTO_ALBUM.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AndroidPermissionType fromBPermission(BPermissionType permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            switch (WhenMappings.$EnumSwitchMapping$0[permission.ordinal()]) {
                case 1:
                    return AndroidPermissionType.GALLERY;
                case 2:
                    return AndroidPermissionType.CAMERA;
                case 3:
                    return AndroidPermissionType.SAVE_IMAGE_INTO_COMMON_PHOTO_ALBUM;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }
}