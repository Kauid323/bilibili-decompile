package kntr.app.im.chat.module.localPicture;

import BottomSheetItemData$;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.service.sender.image.LocalImageAsset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.Resolution$;
import kntr.common.photonic.finder.AssetFinder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: LocalPictureModule.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFBW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011B]\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000e\u0010,\u001a\u00020\u0001H\u0096@¢\u0006\u0002\u0010-J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\u000e\u00105\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b6J[\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u00108\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0013HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J%\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0001¢\u0006\u0002\bDR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u001c\u0010'\u001a\u00020(8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010+¨\u0006G"}, d2 = {"Lkntr/app/im/chat/module/localPicture/LocalPictureModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "asset", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "assetId", RoomRecommendViewModel.EMPTY_CURSOR, "uploadProgress", RoomRecommendViewModel.EMPTY_CURSOR, "assetFqn", "resolution", "Lkntr/common/photonic/Resolution;", "orientation", "Lkntr/common/photonic/Orientation;", "useOriginImage", RoomRecommendViewModel.EMPTY_CURSOR, "mimeTypeStr", "<init>", "(Lkntr/app/im/chat/service/sender/image/LocalImageAsset;Ljava/lang/String;FLjava/lang/String;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;ZLjava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;FLjava/lang/String;Lkntr/common/photonic/Resolution;Lkntr/common/photonic/Orientation;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAsset$annotations", "()V", "getAsset", "()Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "getAssetId", "()Ljava/lang/String;", "getUploadProgress", "()F", "getAssetFqn", "getResolution", "()Lkntr/common/photonic/Resolution;", "getOrientation", "()Lkntr/common/photonic/Orientation;", "getUseOriginImage", "()Z", "getMimeTypeStr$biz_debug", "mimeType", "Lkntr/common/photonic/MimeType;", "getMimeType$annotations", "getMimeType", "()Lkntr/common/photonic/MimeType;", "rebuildModule", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component8$biz_debug", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$biz_debug", "$serializer", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class LocalPictureModule implements MsgModule {
    public static final int $stable = 0;
    private final LocalImageAsset asset;
    private final String assetFqn;
    private final String assetId;
    private final MimeType mimeType;
    private final String mimeTypeStr;
    private final Orientation orientation;
    private final Resolution resolution;
    private final float uploadProgress;
    private final boolean useOriginImage;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.module.localPicture.LocalPictureModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = LocalPictureModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    public static /* synthetic */ LocalPictureModule copy$default(LocalPictureModule localPictureModule, LocalImageAsset localImageAsset, String str, float f, String str2, Resolution resolution, Orientation orientation, boolean z, String str3, int i, Object obj) {
        return localPictureModule.copy((i & 1) != 0 ? localPictureModule.asset : localImageAsset, (i & 2) != 0 ? localPictureModule.assetId : str, (i & 4) != 0 ? localPictureModule.uploadProgress : f, (i & 8) != 0 ? localPictureModule.assetFqn : str2, (i & 16) != 0 ? localPictureModule.resolution : resolution, (i & 32) != 0 ? localPictureModule.orientation : orientation, (i & 64) != 0 ? localPictureModule.useOriginImage : z, (i & 128) != 0 ? localPictureModule.mimeTypeStr : str3);
    }

    @Transient
    public static /* synthetic */ void getAsset$annotations() {
    }

    @Transient
    public static /* synthetic */ void getMimeType$annotations() {
    }

    public final LocalImageAsset component1() {
        return this.asset;
    }

    public final String component2() {
        return this.assetId;
    }

    public final float component3() {
        return this.uploadProgress;
    }

    public final String component4() {
        return this.assetFqn;
    }

    public final Resolution component5() {
        return this.resolution;
    }

    public final Orientation component6() {
        return this.orientation;
    }

    public final boolean component7() {
        return this.useOriginImage;
    }

    public final String component8$biz_debug() {
        return this.mimeTypeStr;
    }

    public final LocalPictureModule copy(LocalImageAsset localImageAsset, String str, float f, String str2, Resolution resolution, Orientation orientation, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "assetId");
        Intrinsics.checkNotNullParameter(str2, "assetFqn");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(str3, "mimeTypeStr");
        return new LocalPictureModule(localImageAsset, str, f, str2, resolution, orientation, z, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalPictureModule) {
            LocalPictureModule localPictureModule = (LocalPictureModule) obj;
            return Intrinsics.areEqual(this.asset, localPictureModule.asset) && Intrinsics.areEqual(this.assetId, localPictureModule.assetId) && Float.compare(this.uploadProgress, localPictureModule.uploadProgress) == 0 && Intrinsics.areEqual(this.assetFqn, localPictureModule.assetFqn) && Intrinsics.areEqual(this.resolution, localPictureModule.resolution) && this.orientation == localPictureModule.orientation && this.useOriginImage == localPictureModule.useOriginImage && Intrinsics.areEqual(this.mimeTypeStr, localPictureModule.mimeTypeStr);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.asset == null ? 0 : this.asset.hashCode()) * 31) + this.assetId.hashCode()) * 31) + Float.floatToIntBits(this.uploadProgress)) * 31) + this.assetFqn.hashCode()) * 31) + this.resolution.hashCode()) * 31) + this.orientation.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useOriginImage)) * 31) + this.mimeTypeStr.hashCode();
    }

    public String toString() {
        LocalImageAsset localImageAsset = this.asset;
        String str = this.assetId;
        float f = this.uploadProgress;
        String str2 = this.assetFqn;
        Resolution resolution = this.resolution;
        Orientation orientation = this.orientation;
        boolean z = this.useOriginImage;
        return "LocalPictureModule(asset=" + localImageAsset + ", assetId=" + str + ", uploadProgress=" + f + ", assetFqn=" + str2 + ", resolution=" + resolution + ", orientation=" + orientation + ", useOriginImage=" + z + ", mimeTypeStr=" + this.mimeTypeStr + ")";
    }

    /* compiled from: LocalPictureModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/module/localPicture/LocalPictureModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/module/localPicture/LocalPictureModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalPictureModule> serializer() {
            return LocalPictureModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LocalPictureModule(int seen0, String assetId, float uploadProgress, String assetFqn, Resolution resolution, Orientation orientation, boolean useOriginImage, String mimeTypeStr, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, LocalPictureModule$$serializer.INSTANCE.getDescriptor());
        }
        this.asset = null;
        this.assetId = assetId;
        if ((seen0 & 2) == 0) {
            this.uploadProgress = 0.0f;
        } else {
            this.uploadProgress = uploadProgress;
        }
        if ((seen0 & 4) == 0) {
            this.assetFqn = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.assetFqn = assetFqn;
        }
        if ((seen0 & 8) == 0) {
            this.resolution = Resolution.Companion.getZero();
        } else {
            this.resolution = resolution;
        }
        if ((seen0 & 16) == 0) {
            this.orientation = Orientation.Normal;
        } else {
            this.orientation = orientation;
        }
        if ((seen0 & 32) == 0) {
            this.useOriginImage = false;
        } else {
            this.useOriginImage = useOriginImage;
        }
        if ((seen0 & 64) == 0) {
            this.mimeTypeStr = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.mimeTypeStr = mimeTypeStr;
        }
        this.mimeType = MimeType.Companion.fromString(this.mimeTypeStr);
    }

    public LocalPictureModule(LocalImageAsset asset, String assetId, float uploadProgress, String assetFqn, Resolution resolution, Orientation orientation, boolean useOriginImage, String mimeTypeStr) {
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetFqn, "assetFqn");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(mimeTypeStr, "mimeTypeStr");
        this.asset = asset;
        this.assetId = assetId;
        this.uploadProgress = uploadProgress;
        this.assetFqn = assetFqn;
        this.resolution = resolution;
        this.orientation = orientation;
        this.useOriginImage = useOriginImage;
        this.mimeTypeStr = mimeTypeStr;
        this.mimeType = MimeType.Companion.fromString(this.mimeTypeStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("kntr.common.photonic.Orientation", Orientation.values());
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$biz_debug(LocalPictureModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.assetId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Float.compare(self.uploadProgress, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 1, self.uploadProgress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.assetFqn, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.assetFqn);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.resolution, Resolution.Companion.getZero())) {
            output.encodeSerializableElement(serialDesc, 3, Resolution$.serializer.INSTANCE, self.resolution);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.orientation != Orientation.Normal) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.orientation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.useOriginImage) {
            output.encodeBooleanElement(serialDesc, 5, self.useOriginImage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.mimeTypeStr, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 6, self.mimeTypeStr);
        }
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ boolean getRequireUpdate() {
        return MsgModule.CC.$default$getRequireUpdate(this);
    }

    public /* synthetic */ LocalPictureModule(LocalImageAsset localImageAsset, String str, float f, String str2, Resolution resolution, Orientation orientation, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : localImageAsset, str, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 16) != 0 ? Resolution.Companion.getZero() : resolution, (i & 32) != 0 ? Orientation.Normal : orientation, (i & 64) != 0 ? false : z, (i & 128) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3);
    }

    public final LocalImageAsset getAsset() {
        return this.asset;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final float getUploadProgress() {
        return this.uploadProgress;
    }

    public final String getAssetFqn() {
        return this.assetFqn;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getUseOriginImage() {
        return this.useOriginImage;
    }

    public final String getMimeTypeStr$biz_debug() {
        return this.mimeTypeStr;
    }

    public final MimeType getMimeType() {
        return this.mimeType;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    @Override // kntr.app.im.chat.core.model.MsgModule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object rebuildModule(Continuation<? super MsgModule> continuation) {
        LocalPictureModule$rebuildModule$1 localPictureModule$rebuildModule$1;
        LocalPictureModule$rebuildModule$1 localPictureModule$rebuildModule$12;
        Result result;
        Object obj;
        Result asset;
        Asset asset2;
        if (continuation instanceof LocalPictureModule$rebuildModule$1) {
            localPictureModule$rebuildModule$1 = (LocalPictureModule$rebuildModule$1) continuation;
            if ((localPictureModule$rebuildModule$1.label & Integer.MIN_VALUE) != 0) {
                localPictureModule$rebuildModule$1.label -= Integer.MIN_VALUE;
                localPictureModule$rebuildModule$12 = localPictureModule$rebuildModule$1;
                Object $result = localPictureModule$rebuildModule$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (localPictureModule$rebuildModule$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        AssetFinder finderForAssetType = AssetEntry.INSTANCE.getFinder().getFinderForAssetType(this.assetFqn);
                        if (finderForAssetType == null) {
                            result = null;
                            break;
                        } else {
                            String str = this.assetId;
                            localPictureModule$rebuildModule$12.label = 1;
                            Object obj2 = finderForAssetType.findAssetByIdentifier-gIAlu-s(str, localPictureModule$rebuildModule$12);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = obj2;
                            result = Result.box-impl(obj);
                            break;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        obj = ((Result) $result).unbox-impl();
                        result = Result.box-impl(obj);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                asset = result;
                if (asset == null) {
                    Object obj3 = asset.unbox-impl();
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = null;
                    }
                    asset2 = (Asset) obj3;
                } else {
                    asset2 = null;
                }
                return copy$default(this, !(asset2 instanceof LocalImageAsset) ? (LocalImageAsset) asset2 : null, null, 0.0f, null, null, null, false, null, 254, null);
            }
        }
        localPictureModule$rebuildModule$1 = new LocalPictureModule$rebuildModule$1(this, continuation);
        localPictureModule$rebuildModule$12 = localPictureModule$rebuildModule$1;
        Object $result2 = localPictureModule$rebuildModule$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (localPictureModule$rebuildModule$12.label) {
        }
        asset = result;
        if (asset == null) {
        }
        return copy$default(this, !(asset2 instanceof LocalImageAsset) ? (LocalImageAsset) asset2 : null, null, 0.0f, null, null, null, false, null, 254, null);
    }
}