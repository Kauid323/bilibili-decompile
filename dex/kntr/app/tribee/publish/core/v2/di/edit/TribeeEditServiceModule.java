package kntr.app.tribee.publish.core.v2.di.edit;

import dagger.Module;
import dagger.Provides;
import kntr.app.tribee.publish.core.v2.di.TribeePublishCreateFrom;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishEditContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishEditModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/edit/TribeeEditServiceModule;", "", "<init>", "()V", "provideInitEditState", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "dynId", "", "provideFrom", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class TribeeEditServiceModule {
    public static final TribeeEditServiceModule INSTANCE = new TribeeEditServiceModule();

    private TribeeEditServiceModule() {
    }

    @Provides
    @TribeePublishScope
    public final TribeePublishState provideInitEditState(TribeeInfo tribeeInfo, @TribeeEditContentId String dynId) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(dynId, "dynId");
        return new TribeePublishEditContent(tribeeInfo, dynId);
    }

    @Provides
    @TribeePublishCreateFrom
    @TribeePublishScope
    public final String provideFrom() {
        return "edit.tribee";
    }
}