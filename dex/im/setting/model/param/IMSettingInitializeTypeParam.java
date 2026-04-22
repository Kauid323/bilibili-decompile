package im.setting.model.param;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingInitializeParam.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/setting/model/param/IMSettingInitializeTypeParam;", "Lim/setting/model/param/IMSettingInitializeParam;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KIMSettingType;)V", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KIMSettingType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingInitializeTypeParam implements IMSettingInitializeParam {
    public static final int $stable = 8;
    private final KIMSettingType pageType;

    public static /* synthetic */ IMSettingInitializeTypeParam copy$default(IMSettingInitializeTypeParam iMSettingInitializeTypeParam, KIMSettingType kIMSettingType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kIMSettingType = iMSettingInitializeTypeParam.pageType;
        }
        return iMSettingInitializeTypeParam.copy(kIMSettingType);
    }

    public final KIMSettingType component1() {
        return this.pageType;
    }

    public final IMSettingInitializeTypeParam copy(KIMSettingType kIMSettingType) {
        return new IMSettingInitializeTypeParam(kIMSettingType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMSettingInitializeTypeParam) && Intrinsics.areEqual(this.pageType, ((IMSettingInitializeTypeParam) obj).pageType);
    }

    public int hashCode() {
        if (this.pageType == null) {
            return 0;
        }
        return this.pageType.hashCode();
    }

    public String toString() {
        return "IMSettingInitializeTypeParam(pageType=" + this.pageType + ")";
    }

    public IMSettingInitializeTypeParam(KIMSettingType pageType) {
        this.pageType = pageType;
    }

    @Override // im.setting.model.param.IMSettingInitializeParam
    public KIMSettingType getPageType() {
        return this.pageType;
    }
}