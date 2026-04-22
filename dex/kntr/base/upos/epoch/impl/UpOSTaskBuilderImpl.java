package kntr.base.upos.epoch.impl;

import com.bilibili.gripper.upos.GUpOS;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.upos.UpOSTask;
import kntr.base.upos.UpOSTaskBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KUpOS.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/base/upos/epoch/impl/UpOSTaskBuilderImpl;", "Lkntr/base/upos/UpOSTaskBuilder;", "gBuilder", "Lcom/bilibili/gripper/upos/GUpOS$Builder;", "<init>", "(Lcom/bilibili/gripper/upos/GUpOS$Builder;)V", "setProfile", "profile", "", "setMetaProfile", "setFrom", "from", "setBiz", "biz", "build", "Lkntr/base/upos/UpOSTask;", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class UpOSTaskBuilderImpl implements UpOSTaskBuilder {
    private final GUpOS.Builder gBuilder;

    public UpOSTaskBuilderImpl(GUpOS.Builder gBuilder) {
        Intrinsics.checkNotNullParameter(gBuilder, "gBuilder");
        this.gBuilder = gBuilder;
    }

    @Override // kntr.base.upos.UpOSTaskBuilder
    public UpOSTaskBuilder setProfile(String profile) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.gBuilder.setProfile(profile);
        return this;
    }

    @Override // kntr.base.upos.UpOSTaskBuilder
    public UpOSTaskBuilder setMetaProfile(String profile) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.gBuilder.setMetaProfile(profile);
        return this;
    }

    @Override // kntr.base.upos.UpOSTaskBuilder
    public UpOSTaskBuilder setFrom(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.gBuilder.setFrom(from);
        return this;
    }

    @Override // kntr.base.upos.UpOSTaskBuilder
    public UpOSTaskBuilder setBiz(String biz) {
        Intrinsics.checkNotNullParameter(biz, "biz");
        this.gBuilder.setBiz(biz);
        return this;
    }

    @Override // kntr.base.upos.UpOSTaskBuilder
    public UpOSTask build() {
        GUpOS.Task it = this.gBuilder.build();
        return it != null ? new UpOSTaskImpl(it) : null;
    }
}