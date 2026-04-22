package kntr.app.tribee.publish.core.v2.di.create;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.tribee.publish.core.v2.di.TribeeOuroInitialState;
import kntr.app.tribee.publish.core.v2.di.TribeePublishComponent;
import kntr.app.tribee.publish.core.v2.di.TribeePublishCoroutineScope;
import kntr.app.tribee.publish.core.v2.di.TribeePublishDataConverterModule;
import kntr.app.tribee.publish.core.v2.di.TribeePublishDraftModule;
import kntr.app.tribee.publish.core.v2.di.TribeePublishFromSpmid;
import kntr.app.tribee.publish.core.v2.di.TribeePublishOuroEditorModule;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishCreateComponent.kt */
@TribeePublishScope
@Subcomponent(modules = {TribeePublishOuroEditorModule.class, TribeePublishDataConverterModule.class, TribeePublishCreateModule.class, TribeePublishDraftModule.class})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/create/TribeePublishV2CreateComponent;", "Lkntr/app/tribee/publish/core/v2/di/TribeePublishComponent;", "Factory", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeePublishV2CreateComponent extends TribeePublishComponent {

    /* compiled from: TribeePublishCreateComponent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/publish/core/v2/di/create/TribeePublishV2CreateComponent$Factory;", "", "build", "Lkntr/app/tribee/publish/core/v2/di/create/TribeePublishV2CreateComponent;", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "resultKey", "", "fromSpmid", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "initialState", "Lkntr/common/ouro/core/OuroState;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Factory {
        TribeePublishV2CreateComponent build(@BindsInstance TribeeInfo tribeeInfo, @BindsInstance @TribeePublishResultKey String str, @BindsInstance @TribeePublishFromSpmid String str2, @BindsInstance @TribeePublishCoroutineScope CoroutineScope coroutineScope, @BindsInstance @TribeeOuroInitialState OuroState ouroState);

        /* compiled from: TribeePublishCreateComponent.kt */
        /* renamed from: kntr.app.tribee.publish.core.v2.di.create.TribeePublishV2CreateComponent$Factory$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ TribeePublishV2CreateComponent build$default(Factory factory, TribeeInfo tribeeInfo, String str, String str2, CoroutineScope coroutineScope, OuroState ouroState, int i, Object obj) {
                String str3;
                if (obj == null) {
                    if ((i & 4) == 0) {
                        str3 = str2;
                    } else {
                        str3 = "";
                    }
                    return factory.build(tribeeInfo, str, str3, coroutineScope, ouroState);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
            }
        }

        /* compiled from: TribeePublishCreateComponent.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
        }
    }
}