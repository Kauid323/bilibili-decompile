package kntr.base.dd.impl.internal.update;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: UpdateInfoModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 !2\u00020\u0001:\u0001!B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateInfoModel;", "", "platform", "", AppKey.VERSION, "", "md5", "curl", "patchV", "patchURL", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getPlatform", "()Ljava/lang/String;", "getVersion", "()J", "getMd5", "getCurl", "getPatchV", "getPatchURL", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpdateInfoModel {
    public static final Companion Companion = new Companion(null);
    private final String curl;
    private final String md5;
    private final String patchURL;
    private final long patchV;
    private final String platform;
    private final long version;

    public final String component1() {
        return this.platform;
    }

    public final long component2() {
        return this.version;
    }

    public final String component3() {
        return this.md5;
    }

    public final String component4() {
        return this.curl;
    }

    public final long component5() {
        return this.patchV;
    }

    public final String component6() {
        return this.patchURL;
    }

    public final UpdateInfoModel copy(String str, long j, String str2, String str3, long j2, String str4) {
        Intrinsics.checkNotNullParameter(str, "platform");
        Intrinsics.checkNotNullParameter(str2, "md5");
        Intrinsics.checkNotNullParameter(str3, "curl");
        return new UpdateInfoModel(str, j, str2, str3, j2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateInfoModel) {
            UpdateInfoModel updateInfoModel = (UpdateInfoModel) obj;
            return Intrinsics.areEqual(this.platform, updateInfoModel.platform) && this.version == updateInfoModel.version && Intrinsics.areEqual(this.md5, updateInfoModel.md5) && Intrinsics.areEqual(this.curl, updateInfoModel.curl) && this.patchV == updateInfoModel.patchV && Intrinsics.areEqual(this.patchURL, updateInfoModel.patchURL);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.platform.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version)) * 31) + this.md5.hashCode()) * 31) + this.curl.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.patchV)) * 31) + (this.patchURL == null ? 0 : this.patchURL.hashCode());
    }

    public String toString() {
        String str = this.platform;
        long j = this.version;
        String str2 = this.md5;
        String str3 = this.curl;
        long j2 = this.patchV;
        return "UpdateInfoModel(platform=" + str + ", version=" + j + ", md5=" + str2 + ", curl=" + str3 + ", patchV=" + j2 + ", patchURL=" + this.patchURL + ")";
    }

    public UpdateInfoModel(String platform, long version, String md5, String curl, long patchV, String patchURL) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(curl, "curl");
        this.platform = platform;
        this.version = version;
        this.md5 = md5;
        this.curl = curl;
        this.patchV = patchV;
        this.patchURL = patchURL;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final long getVersion() {
        return this.version;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getCurl() {
        return this.curl;
    }

    public final long getPatchV() {
        return this.patchV;
    }

    public final String getPatchURL() {
        return this.patchURL;
    }

    /* compiled from: UpdateInfoModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateInfoModel$Companion;", "", "<init>", "()V", "decodeFromString", "Lkntr/base/dd/impl/internal/update/UpdateInfoModel;", "json", "", "localV", "", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdateInfoModel decodeFromString(String json, long localV) {
            Object obj;
            RespItemModel item;
            if (json == null) {
                return null;
            }
            Utils.Companion companion = Utils.Companion;
            try {
                Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                json$iv.getSerializersModule();
                obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(RespModel.Companion.serializer()), json);
            } catch (Exception e$iv) {
                DDConst dDConst = DDConst.INSTANCE;
                String message = e$iv.getMessage();
                if (message == null) {
                    message = "undefined";
                }
                DDConst.logE$default(dDConst, "decodeFromString error ," + message, null, 2, null);
                obj = null;
            }
            RespModel model = (RespModel) obj;
            if (model == null || (item = model.getItems().get("default")) == null) {
                return null;
            }
            Map<String, String> diffs = item.getDiffs();
            String patchURL = diffs != null ? diffs.get(String.valueOf(localV)) : null;
            return new UpdateInfoModel(model.getPlatform(), model.getVersion(), item.getMd5(), item.getCurl(), localV, patchURL);
        }
    }
}