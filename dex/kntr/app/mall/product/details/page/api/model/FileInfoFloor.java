package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FileInfoFloor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0004+,-.BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "fileInfoVOs", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getFileInfoVOs", "()Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "FileInfo", "FileInfoItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class FileInfoFloor implements FloorModel {
    private final String bgImgUrl;
    private final FileInfo fileInfoVOs;
    private final String floorIcon;
    private final String floorKey;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FileInfoFloor() {
        this((String) null, (String) null, (String) null, (FileInfo) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FileInfoFloor copy$default(FileInfoFloor fileInfoFloor, String str, String str2, String str3, FileInfo fileInfo, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileInfoFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = fileInfoFloor.floorIcon;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = fileInfoFloor.bgImgUrl;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            fileInfo = fileInfoFloor.fileInfoVOs;
        }
        FileInfo fileInfo2 = fileInfo;
        if ((i & 16) != 0) {
            str4 = fileInfoFloor.title;
        }
        return fileInfoFloor.copy(str, str5, str6, fileInfo2, str4);
    }

    public final String component1() {
        return this.floorKey;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final FileInfo component4() {
        return this.fileInfoVOs;
    }

    public final String component5() {
        return this.title;
    }

    public final FileInfoFloor copy(String str, String str2, String str3, FileInfo fileInfo, String str4) {
        return new FileInfoFloor(str, str2, str3, fileInfo, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileInfoFloor) {
            FileInfoFloor fileInfoFloor = (FileInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, fileInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, fileInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, fileInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.fileInfoVOs, fileInfoFloor.fileInfoVOs) && Intrinsics.areEqual(this.title, fileInfoFloor.title);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.fileInfoVOs == null ? 0 : this.fileInfoVOs.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        FileInfo fileInfo = this.fileInfoVOs;
        return "FileInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", fileInfoVOs=" + fileInfo + ", title=" + this.title + ")";
    }

    /* compiled from: FileInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FileInfoFloor> serializer() {
            return FileInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ FileInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, FileInfo fileInfoVOs, String title, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.floorKey = null;
        } else {
            this.floorKey = floorKey;
        }
        if ((seen0 & 2) == 0) {
            this.floorIcon = null;
        } else {
            this.floorIcon = floorIcon;
        }
        if ((seen0 & 4) == 0) {
            this.bgImgUrl = null;
        } else {
            this.bgImgUrl = bgImgUrl;
        }
        if ((seen0 & 8) == 0) {
            this.fileInfoVOs = null;
        } else {
            this.fileInfoVOs = fileInfoVOs;
        }
        if ((seen0 & 16) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
    }

    public FileInfoFloor(String floorKey, String floorIcon, String bgImgUrl, FileInfo fileInfoVOs, String title) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.fileInfoVOs = fileInfoVOs;
        this.title = title;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(FileInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fileInfoVOs != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, FileInfoFloor$FileInfo$$serializer.INSTANCE, self.fileInfoVOs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.title);
        }
    }

    public /* synthetic */ FileInfoFloor(String str, String str2, String str3, FileInfo fileInfo, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : fileInfo, (i & 16) != 0 ? null : str4);
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorKey() {
        return this.floorKey;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorIcon() {
        return this.floorIcon;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final FileInfo getFileInfoVOs() {
        return this.fileInfoVOs;
    }

    /* compiled from: FileInfoFloor.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 X2\u00020\u0001:\u0002WXBë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aBÛ\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001eJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 Jò\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\rHÖ\u0001J\t\u0010M\u001a\u00020NHÖ\u0001J%\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0001¢\u0006\u0002\bVR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\u0007\u0010#R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\b\u0010#R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b+\u0010)R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b,\u0010)R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b.\u0010)R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b/\u0010)R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b0\u0010)R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b1\u0010)R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b2\u0010)R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010*\u001a\u0004\b3\u0010)R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b4\u0010 R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b5\u0010 ¨\u0006Y"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "", "endRow", "", "hasNextPage", "", "hasPreviousPage", "isFirstPage", "isLastPage", "list", "", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfoItem;", "navigateFirstPage", "", "navigateLastPage", "navigatePages", "navigatepageNums", "nextPage", "pageNum", "pageSize", "pages", "prePage", "size", "startRow", "total", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEndRow", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHasNextPage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasPreviousPage", "getList", "()Ljava/util/List;", "getNavigateFirstPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNavigateLastPage", "getNavigatePages", "getNavigatepageNums", "getNextPage", "getPageNum", "getPageSize", "getPages", "getPrePage", "getSize", "getStartRow", "getTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FileInfo {
        private final Long endRow;
        private final Boolean hasNextPage;
        private final Boolean hasPreviousPage;
        private final Boolean isFirstPage;
        private final Boolean isLastPage;
        private final List<FileInfoItem> list;
        private final Integer navigateFirstPage;
        private final Integer navigateLastPage;
        private final Integer navigatePages;
        private final List<Integer> navigatepageNums;
        private final Integer nextPage;
        private final Integer pageNum;
        private final Integer pageSize;
        private final Integer pages;
        private final Integer prePage;
        private final Integer size;
        private final Long startRow;
        private final Long total;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FileInfoFloor$FileInfo$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = FileInfoFloor.FileInfo._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FileInfoFloor$FileInfo$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = FileInfoFloor.FileInfo._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null, null, null, null, null, null, null, null};

        public FileInfo() {
            this((Long) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (List) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Long) null, (Long) null, 262143, (DefaultConstructorMarker) null);
        }

        public final Long component1() {
            return this.endRow;
        }

        public final List<Integer> component10() {
            return this.navigatepageNums;
        }

        public final Integer component11() {
            return this.nextPage;
        }

        public final Integer component12() {
            return this.pageNum;
        }

        public final Integer component13() {
            return this.pageSize;
        }

        public final Integer component14() {
            return this.pages;
        }

        public final Integer component15() {
            return this.prePage;
        }

        public final Integer component16() {
            return this.size;
        }

        public final Long component17() {
            return this.startRow;
        }

        public final Long component18() {
            return this.total;
        }

        public final Boolean component2() {
            return this.hasNextPage;
        }

        public final Boolean component3() {
            return this.hasPreviousPage;
        }

        public final Boolean component4() {
            return this.isFirstPage;
        }

        public final Boolean component5() {
            return this.isLastPage;
        }

        public final List<FileInfoItem> component6() {
            return this.list;
        }

        public final Integer component7() {
            return this.navigateFirstPage;
        }

        public final Integer component8() {
            return this.navigateLastPage;
        }

        public final Integer component9() {
            return this.navigatePages;
        }

        public final FileInfo copy(Long l, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List<FileInfoItem> list, Integer num, Integer num2, Integer num3, List<Integer> list2, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Long l2, Long l3) {
            return new FileInfo(l, bool, bool2, bool3, bool4, list, num, num2, num3, list2, num4, num5, num6, num7, num8, num9, l2, l3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FileInfo) {
                FileInfo fileInfo = (FileInfo) obj;
                return Intrinsics.areEqual(this.endRow, fileInfo.endRow) && Intrinsics.areEqual(this.hasNextPage, fileInfo.hasNextPage) && Intrinsics.areEqual(this.hasPreviousPage, fileInfo.hasPreviousPage) && Intrinsics.areEqual(this.isFirstPage, fileInfo.isFirstPage) && Intrinsics.areEqual(this.isLastPage, fileInfo.isLastPage) && Intrinsics.areEqual(this.list, fileInfo.list) && Intrinsics.areEqual(this.navigateFirstPage, fileInfo.navigateFirstPage) && Intrinsics.areEqual(this.navigateLastPage, fileInfo.navigateLastPage) && Intrinsics.areEqual(this.navigatePages, fileInfo.navigatePages) && Intrinsics.areEqual(this.navigatepageNums, fileInfo.navigatepageNums) && Intrinsics.areEqual(this.nextPage, fileInfo.nextPage) && Intrinsics.areEqual(this.pageNum, fileInfo.pageNum) && Intrinsics.areEqual(this.pageSize, fileInfo.pageSize) && Intrinsics.areEqual(this.pages, fileInfo.pages) && Intrinsics.areEqual(this.prePage, fileInfo.prePage) && Intrinsics.areEqual(this.size, fileInfo.size) && Intrinsics.areEqual(this.startRow, fileInfo.startRow) && Intrinsics.areEqual(this.total, fileInfo.total);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((this.endRow == null ? 0 : this.endRow.hashCode()) * 31) + (this.hasNextPage == null ? 0 : this.hasNextPage.hashCode())) * 31) + (this.hasPreviousPage == null ? 0 : this.hasPreviousPage.hashCode())) * 31) + (this.isFirstPage == null ? 0 : this.isFirstPage.hashCode())) * 31) + (this.isLastPage == null ? 0 : this.isLastPage.hashCode())) * 31) + (this.list == null ? 0 : this.list.hashCode())) * 31) + (this.navigateFirstPage == null ? 0 : this.navigateFirstPage.hashCode())) * 31) + (this.navigateLastPage == null ? 0 : this.navigateLastPage.hashCode())) * 31) + (this.navigatePages == null ? 0 : this.navigatePages.hashCode())) * 31) + (this.navigatepageNums == null ? 0 : this.navigatepageNums.hashCode())) * 31) + (this.nextPage == null ? 0 : this.nextPage.hashCode())) * 31) + (this.pageNum == null ? 0 : this.pageNum.hashCode())) * 31) + (this.pageSize == null ? 0 : this.pageSize.hashCode())) * 31) + (this.pages == null ? 0 : this.pages.hashCode())) * 31) + (this.prePage == null ? 0 : this.prePage.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.startRow == null ? 0 : this.startRow.hashCode())) * 31) + (this.total != null ? this.total.hashCode() : 0);
        }

        public String toString() {
            Long l = this.endRow;
            Boolean bool = this.hasNextPage;
            Boolean bool2 = this.hasPreviousPage;
            Boolean bool3 = this.isFirstPage;
            Boolean bool4 = this.isLastPage;
            List<FileInfoItem> list = this.list;
            Integer num = this.navigateFirstPage;
            Integer num2 = this.navigateLastPage;
            Integer num3 = this.navigatePages;
            List<Integer> list2 = this.navigatepageNums;
            Integer num4 = this.nextPage;
            Integer num5 = this.pageNum;
            Integer num6 = this.pageSize;
            Integer num7 = this.pages;
            Integer num8 = this.prePage;
            Integer num9 = this.size;
            Long l2 = this.startRow;
            return "FileInfo(endRow=" + l + ", hasNextPage=" + bool + ", hasPreviousPage=" + bool2 + ", isFirstPage=" + bool3 + ", isLastPage=" + bool4 + ", list=" + list + ", navigateFirstPage=" + num + ", navigateLastPage=" + num2 + ", navigatePages=" + num3 + ", navigatepageNums=" + list2 + ", nextPage=" + num4 + ", pageNum=" + num5 + ", pageSize=" + num6 + ", pages=" + num7 + ", prePage=" + num8 + ", size=" + num9 + ", startRow=" + l2 + ", total=" + this.total + ")";
        }

        /* compiled from: FileInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<FileInfo> serializer() {
                return FileInfoFloor$FileInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ FileInfo(int seen0, Long endRow, Boolean hasNextPage, Boolean hasPreviousPage, Boolean isFirstPage, Boolean isLastPage, List list, Integer navigateFirstPage, Integer navigateLastPage, Integer navigatePages, List navigatepageNums, Integer nextPage, Integer pageNum, Integer pageSize, Integer pages, Integer prePage, Integer size, Long startRow, Long total, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.endRow = null;
            } else {
                this.endRow = endRow;
            }
            if ((seen0 & 2) == 0) {
                this.hasNextPage = null;
            } else {
                this.hasNextPage = hasNextPage;
            }
            if ((seen0 & 4) == 0) {
                this.hasPreviousPage = null;
            } else {
                this.hasPreviousPage = hasPreviousPage;
            }
            if ((seen0 & 8) == 0) {
                this.isFirstPage = null;
            } else {
                this.isFirstPage = isFirstPage;
            }
            if ((seen0 & 16) == 0) {
                this.isLastPage = null;
            } else {
                this.isLastPage = isLastPage;
            }
            if ((seen0 & 32) == 0) {
                this.list = null;
            } else {
                this.list = list;
            }
            if ((seen0 & 64) == 0) {
                this.navigateFirstPage = null;
            } else {
                this.navigateFirstPage = navigateFirstPage;
            }
            if ((seen0 & 128) == 0) {
                this.navigateLastPage = null;
            } else {
                this.navigateLastPage = navigateLastPage;
            }
            if ((seen0 & 256) == 0) {
                this.navigatePages = null;
            } else {
                this.navigatePages = navigatePages;
            }
            if ((seen0 & 512) == 0) {
                this.navigatepageNums = null;
            } else {
                this.navigatepageNums = navigatepageNums;
            }
            if ((seen0 & 1024) == 0) {
                this.nextPage = null;
            } else {
                this.nextPage = nextPage;
            }
            if ((seen0 & 2048) == 0) {
                this.pageNum = null;
            } else {
                this.pageNum = pageNum;
            }
            if ((seen0 & 4096) == 0) {
                this.pageSize = null;
            } else {
                this.pageSize = pageSize;
            }
            if ((seen0 & 8192) == 0) {
                this.pages = null;
            } else {
                this.pages = pages;
            }
            if ((seen0 & 16384) == 0) {
                this.prePage = null;
            } else {
                this.prePage = prePage;
            }
            if ((seen0 & 32768) == 0) {
                this.size = null;
            } else {
                this.size = size;
            }
            if ((seen0 & 65536) == 0) {
                this.startRow = null;
            } else {
                this.startRow = startRow;
            }
            if ((seen0 & 131072) == 0) {
                this.total = null;
            } else {
                this.total = total;
            }
        }

        public FileInfo(Long endRow, Boolean hasNextPage, Boolean hasPreviousPage, Boolean isFirstPage, Boolean isLastPage, List<FileInfoItem> list, Integer navigateFirstPage, Integer navigateLastPage, Integer navigatePages, List<Integer> list2, Integer nextPage, Integer pageNum, Integer pageSize, Integer pages, Integer prePage, Integer size, Long startRow, Long total) {
            this.endRow = endRow;
            this.hasNextPage = hasNextPage;
            this.hasPreviousPage = hasPreviousPage;
            this.isFirstPage = isFirstPage;
            this.isLastPage = isLastPage;
            this.list = list;
            this.navigateFirstPage = navigateFirstPage;
            this.navigateLastPage = navigateLastPage;
            this.navigatePages = navigatePages;
            this.navigatepageNums = list2;
            this.nextPage = nextPage;
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.pages = pages;
            this.prePage = prePage;
            this.size = size;
            this.startRow = startRow;
            this.total = total;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(FileInfoFloor$FileInfoItem$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(IntSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(FileInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.endRow != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.endRow);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasNextPage != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.hasNextPage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.hasPreviousPage != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.hasPreviousPage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isFirstPage != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.isFirstPage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isLastPage != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.isLastPage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.list != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.list);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.navigateFirstPage != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.navigateFirstPage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.navigateLastPage != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.navigateLastPage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.navigatePages != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.navigatePages);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.navigatepageNums != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.navigatepageNums);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.nextPage != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.nextPage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.pageNum != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.pageNum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.pageSize != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.pageSize);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.pages != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.pages);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.prePage != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.prePage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.size != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.size);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.startRow != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, LongSerializer.INSTANCE, self.startRow);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.total != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, LongSerializer.INSTANCE, self.total);
            }
        }

        public /* synthetic */ FileInfo(Long l, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, List list, Integer num, Integer num2, Integer num3, List list2, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : list2, (i & 1024) != 0 ? null : num4, (i & 2048) != 0 ? null : num5, (i & 4096) != 0 ? null : num6, (i & 8192) != 0 ? null : num7, (i & 16384) != 0 ? null : num8, (i & 32768) != 0 ? null : num9, (i & 65536) != 0 ? null : l2, (i & 131072) != 0 ? null : l3);
        }

        public final Long getEndRow() {
            return this.endRow;
        }

        public final Boolean getHasNextPage() {
            return this.hasNextPage;
        }

        public final Boolean getHasPreviousPage() {
            return this.hasPreviousPage;
        }

        public final Boolean isFirstPage() {
            return this.isFirstPage;
        }

        public final Boolean isLastPage() {
            return this.isLastPage;
        }

        public final List<FileInfoItem> getList() {
            return this.list;
        }

        public final Integer getNavigateFirstPage() {
            return this.navigateFirstPage;
        }

        public final Integer getNavigateLastPage() {
            return this.navigateLastPage;
        }

        public final Integer getNavigatePages() {
            return this.navigatePages;
        }

        public final List<Integer> getNavigatepageNums() {
            return this.navigatepageNums;
        }

        public final Integer getNextPage() {
            return this.nextPage;
        }

        public final Integer getPageNum() {
            return this.pageNum;
        }

        public final Integer getPageSize() {
            return this.pageSize;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final Integer getPrePage() {
            return this.prePage;
        }

        public final Integer getSize() {
            return this.size;
        }

        public final Long getStartRow() {
            return this.startRow;
        }

        public final Long getTotal() {
            return this.total;
        }
    }

    public final String getTitle() {
        return this.title;
    }

    /* compiled from: FileInfoFloor.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fB\u007f\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0086\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019¨\u0006<"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfoItem;", "", "downloadStatus", "", "duration", "fileBucket", "", "fileContentType", "fileId", "fileName", "fileSize", "fileSourceType", "fileIcon", "rawFileSize", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDownloadStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDuration", "getFileBucket", "()Ljava/lang/String;", "getFileContentType", "getFileId", "getFileName", "getFileSize", "getFileSourceType", "getFileIcon", "getRawFileSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfoItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FileInfoItem {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Integer downloadStatus;
        private final Integer duration;
        private final String fileBucket;
        private final String fileContentType;
        private final String fileIcon;
        private final String fileId;
        private final String fileName;
        private final String fileSize;
        private final String fileSourceType;
        private final String rawFileSize;

        public FileInfoItem() {
            this((Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
        }

        public final Integer component1() {
            return this.downloadStatus;
        }

        public final String component10() {
            return this.rawFileSize;
        }

        public final Integer component2() {
            return this.duration;
        }

        public final String component3() {
            return this.fileBucket;
        }

        public final String component4() {
            return this.fileContentType;
        }

        public final String component5() {
            return this.fileId;
        }

        public final String component6() {
            return this.fileName;
        }

        public final String component7() {
            return this.fileSize;
        }

        public final String component8() {
            return this.fileSourceType;
        }

        public final String component9() {
            return this.fileIcon;
        }

        public final FileInfoItem copy(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            return new FileInfoItem(num, num2, str, str2, str3, str4, str5, str6, str7, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FileInfoItem) {
                FileInfoItem fileInfoItem = (FileInfoItem) obj;
                return Intrinsics.areEqual(this.downloadStatus, fileInfoItem.downloadStatus) && Intrinsics.areEqual(this.duration, fileInfoItem.duration) && Intrinsics.areEqual(this.fileBucket, fileInfoItem.fileBucket) && Intrinsics.areEqual(this.fileContentType, fileInfoItem.fileContentType) && Intrinsics.areEqual(this.fileId, fileInfoItem.fileId) && Intrinsics.areEqual(this.fileName, fileInfoItem.fileName) && Intrinsics.areEqual(this.fileSize, fileInfoItem.fileSize) && Intrinsics.areEqual(this.fileSourceType, fileInfoItem.fileSourceType) && Intrinsics.areEqual(this.fileIcon, fileInfoItem.fileIcon) && Intrinsics.areEqual(this.rawFileSize, fileInfoItem.rawFileSize);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((this.downloadStatus == null ? 0 : this.downloadStatus.hashCode()) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.fileBucket == null ? 0 : this.fileBucket.hashCode())) * 31) + (this.fileContentType == null ? 0 : this.fileContentType.hashCode())) * 31) + (this.fileId == null ? 0 : this.fileId.hashCode())) * 31) + (this.fileName == null ? 0 : this.fileName.hashCode())) * 31) + (this.fileSize == null ? 0 : this.fileSize.hashCode())) * 31) + (this.fileSourceType == null ? 0 : this.fileSourceType.hashCode())) * 31) + (this.fileIcon == null ? 0 : this.fileIcon.hashCode())) * 31) + (this.rawFileSize != null ? this.rawFileSize.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.downloadStatus;
            Integer num2 = this.duration;
            String str = this.fileBucket;
            String str2 = this.fileContentType;
            String str3 = this.fileId;
            String str4 = this.fileName;
            String str5 = this.fileSize;
            String str6 = this.fileSourceType;
            String str7 = this.fileIcon;
            return "FileInfoItem(downloadStatus=" + num + ", duration=" + num2 + ", fileBucket=" + str + ", fileContentType=" + str2 + ", fileId=" + str3 + ", fileName=" + str4 + ", fileSize=" + str5 + ", fileSourceType=" + str6 + ", fileIcon=" + str7 + ", rawFileSize=" + this.rawFileSize + ")";
        }

        /* compiled from: FileInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfoItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfoItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<FileInfoItem> serializer() {
                return FileInfoFloor$FileInfoItem$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ FileInfoItem(int seen0, Integer downloadStatus, Integer duration, String fileBucket, String fileContentType, String fileId, String fileName, String fileSize, String fileSourceType, String fileIcon, String rawFileSize, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.downloadStatus = null;
            } else {
                this.downloadStatus = downloadStatus;
            }
            if ((seen0 & 2) == 0) {
                this.duration = null;
            } else {
                this.duration = duration;
            }
            if ((seen0 & 4) == 0) {
                this.fileBucket = null;
            } else {
                this.fileBucket = fileBucket;
            }
            if ((seen0 & 8) == 0) {
                this.fileContentType = null;
            } else {
                this.fileContentType = fileContentType;
            }
            if ((seen0 & 16) == 0) {
                this.fileId = null;
            } else {
                this.fileId = fileId;
            }
            if ((seen0 & 32) == 0) {
                this.fileName = null;
            } else {
                this.fileName = fileName;
            }
            if ((seen0 & 64) == 0) {
                this.fileSize = null;
            } else {
                this.fileSize = fileSize;
            }
            if ((seen0 & 128) == 0) {
                this.fileSourceType = null;
            } else {
                this.fileSourceType = fileSourceType;
            }
            if ((seen0 & 256) == 0) {
                this.fileIcon = null;
            } else {
                this.fileIcon = fileIcon;
            }
            if ((seen0 & 512) == 0) {
                this.rawFileSize = null;
            } else {
                this.rawFileSize = rawFileSize;
            }
        }

        public FileInfoItem(Integer downloadStatus, Integer duration, String fileBucket, String fileContentType, String fileId, String fileName, String fileSize, String fileSourceType, String fileIcon, String rawFileSize) {
            this.downloadStatus = downloadStatus;
            this.duration = duration;
            this.fileBucket = fileBucket;
            this.fileContentType = fileContentType;
            this.fileId = fileId;
            this.fileName = fileName;
            this.fileSize = fileSize;
            this.fileSourceType = fileSourceType;
            this.fileIcon = fileIcon;
            this.rawFileSize = rawFileSize;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(FileInfoItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.downloadStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.downloadStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.duration != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.duration);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.fileBucket != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.fileBucket);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fileContentType != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.fileContentType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fileId != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.fileId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.fileName != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.fileName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.fileSize != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.fileSize);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.fileSourceType != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.fileSourceType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.fileIcon != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.fileIcon);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.rawFileSize != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.rawFileSize);
            }
        }

        public /* synthetic */ FileInfoItem(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) == 0 ? str8 : null);
        }

        public final Integer getDownloadStatus() {
            return this.downloadStatus;
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final String getFileBucket() {
            return this.fileBucket;
        }

        public final String getFileContentType() {
            return this.fileContentType;
        }

        public final String getFileId() {
            return this.fileId;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getFileSize() {
            return this.fileSize;
        }

        public final String getFileSourceType() {
            return this.fileSourceType;
        }

        public final String getFileIcon() {
            return this.fileIcon;
        }

        public final String getRawFileSize() {
            return this.rawFileSize;
        }
    }
}