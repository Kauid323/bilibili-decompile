package tv.danmaku.bili.ui.personinfo.event;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PersonInfoModifyViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\b¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/event/PersonInfoModifyViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "modifyType", "Landroidx/lifecycle/MutableLiveData;", "Ltv/danmaku/bili/ui/personinfo/event/ModifyType;", "getModifyType", "()Landroidx/lifecycle/MutableLiveData;", "uploadingEvent", "Ljava/lang/Void;", "getUploadingEvent", "modifyPersonInfoEvent", "Ltv/danmaku/bili/ui/personinfo/event/ModifyPersonInfoEvent;", "getModifyPersonInfoEvent", "modifyUrl", "", "getModifyUrl", "hasNft", "", "getHasNft", "()Z", "setHasNft", "(Z)V", "showCampusHint", "getShowCampusHint", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PersonInfoModifyViewModel extends ViewModel {
    public static final int $stable = 8;
    private boolean hasNft;
    private final MutableLiveData<ModifyType> modifyType = new MutableLiveData<>();
    private final MutableLiveData<Void> uploadingEvent = new MutableLiveData<>();
    private final MutableLiveData<ModifyPersonInfoEvent> modifyPersonInfoEvent = new MutableLiveData<>();
    private final MutableLiveData<String> modifyUrl = new MutableLiveData<>();
    private final MutableLiveData<Boolean> showCampusHint = new MutableLiveData<>();

    public final MutableLiveData<ModifyType> getModifyType() {
        return this.modifyType;
    }

    public final MutableLiveData<Void> getUploadingEvent() {
        return this.uploadingEvent;
    }

    public final MutableLiveData<ModifyPersonInfoEvent> getModifyPersonInfoEvent() {
        return this.modifyPersonInfoEvent;
    }

    public final MutableLiveData<String> getModifyUrl() {
        return this.modifyUrl;
    }

    public final boolean getHasNft() {
        return this.hasNft;
    }

    public final void setHasNft(boolean z) {
        this.hasNft = z;
    }

    public final MutableLiveData<Boolean> getShowCampusHint() {
        return this.showCampusHint;
    }
}