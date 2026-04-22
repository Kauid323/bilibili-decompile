package kntr.app.tribee.publish.di.create;

import dagger.Module;
import dagger.Provides;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishNewContent;
import kntr.app.tribee.publish.TribeePublishState;
import kntr.app.tribee.publish.di.TribeePublishCreateFrom;
import kntr.app.tribee.publish.di.TribeePublishScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishCreateModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/app/tribee/publish/di/create/TribeePublishServiceModule;", "", "<init>", "()V", "initState", "Lkntr/app/tribee/publish/TribeePublishState;", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "provideFrom", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class TribeePublishServiceModule {
    public static final TribeePublishServiceModule INSTANCE = new TribeePublishServiceModule();

    private TribeePublishServiceModule() {
    }

    @Provides
    @TribeePublishScope
    public final TribeePublishState initState(TribeeInfo tribeeInfo) {
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        return new TribeePublishNewContent(tribeeInfo);
    }

    @Provides
    @TribeePublishCreateFrom
    @TribeePublishScope
    public final String provideFrom() {
        return "create.tribee";
    }
}