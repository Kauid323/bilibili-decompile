package im.setting.model.param;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import im.setting.UtilsKt;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingPageType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingInitializeParam.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lim/setting/model/param/IMSettingInitializeDataParam;", "Lim/setting/model/param/IMSettingInitializeParam;", UtilsKt.DATA_KEY, "Lim/setting/model/IMSettingPageData;", "<init>", "(Lim/setting/model/IMSettingPageData;)V", "getData", "()Lim/setting/model/IMSettingPageData;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingInitializeDataParam implements IMSettingInitializeParam {
    public static final int $stable = 0;
    private final IMSettingPageData data;

    public static /* synthetic */ IMSettingInitializeDataParam copy$default(IMSettingInitializeDataParam iMSettingInitializeDataParam, IMSettingPageData iMSettingPageData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMSettingPageData = iMSettingInitializeDataParam.data;
        }
        return iMSettingInitializeDataParam.copy(iMSettingPageData);
    }

    public final IMSettingPageData component1() {
        return this.data;
    }

    public final IMSettingInitializeDataParam copy(IMSettingPageData iMSettingPageData) {
        Intrinsics.checkNotNullParameter(iMSettingPageData, UtilsKt.DATA_KEY);
        return new IMSettingInitializeDataParam(iMSettingPageData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMSettingInitializeDataParam) && Intrinsics.areEqual(this.data, ((IMSettingInitializeDataParam) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "IMSettingInitializeDataParam(data=" + this.data + ")";
    }

    public IMSettingInitializeDataParam(IMSettingPageData data) {
        Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
        this.data = data;
    }

    public final IMSettingPageData getData() {
        return this.data;
    }

    @Override // im.setting.model.param.IMSettingInitializeParam
    public KIMSettingType getPageType() {
        SettingPageType type = this.data.getType();
        if (type instanceof SettingPageType.IMSetting) {
            return ((SettingPageType.IMSetting) this.data.getType()).getType();
        }
        if (type instanceof SettingPageType.ChatSetting) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}