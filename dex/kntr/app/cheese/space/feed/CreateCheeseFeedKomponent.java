package kntr.app.cheese.space.feed;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.bilibili.ogv.operation3.module.operable.OperableModelKt;
import javax.inject.Inject;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.cheese.space.aggregate.UpId;
import kntr.app.cheese.space.api.SeasonModel;
import kntr.app.cheese.space.operable.CreateOperableModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: CreateCheeseFeedKomponent.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/cheese/space/feed/CreateCheeseFeedKomponent;", RoomRecommendViewModel.EMPTY_CURSOR, "createOperableModel", "Lkntr/app/cheese/space/operable/CreateOperableModel;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/cheese/space/operable/CreateOperableModel;J)V", "invoke", "Lkntr/common/komponent/Komponent;", "Lkntr/app/cheese/space/api/SeasonModel;", "item", "index", RoomRecommendViewModel.EMPTY_CURSOR, "tabName", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCheeseFeedKomponent {
    public static final int $stable = 8;
    private final CreateOperableModel createOperableModel;
    private final long upId;

    @Inject
    public CreateCheeseFeedKomponent(CreateOperableModel createOperableModel, @UpId long upId) {
        Intrinsics.checkNotNullParameter(createOperableModel, "createOperableModel");
        this.createOperableModel = createOperableModel;
        this.upId = upId;
    }

    public final Komponent<SeasonModel> invoke(final SeasonModel item, final int index, final String tabName) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.cheese.space.feed.CreateCheeseFeedKomponent$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult invoke$lambda$0;
                invoke$lambda$0 = CreateCheeseFeedKomponent.invoke$lambda$0(SeasonModel.this, index, tabName, this, (KomponentScope) obj);
                return invoke$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult invoke$lambda$0(final SeasonModel $item, int $index, String $tabName, CreateCheeseFeedKomponent this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $item.getReport().put("index", String.valueOf($index + 1));
        $item.getReport().put("tab", $tabName);
        $item.getReport().put(ReportBuildInParam.UP_MID, String.valueOf(this$0.upId));
        final CreateCheeseFeedKomponent$invoke$1$card$1 card = new CreateCheeseFeedKomponent$invoke$1$card$1($item, this$0, $this$Komponent);
        UiComposableLike content$iv$iv = new UiComposableLike<SeasonModel>($item, $this$Komponent, card) { // from class: kntr.app.cheese.space.feed.CreateCheeseFeedKomponent$invoke$lambda$0$$inlined$setContent$1
            final /* synthetic */ CreateCheeseFeedKomponent$invoke$1$card$1 $card$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final SeasonModel state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$card$inlined = card;
                this.state = $item;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int i = $changed & 14;
                $composer.startReplaceGroup(1666724185);
                ComposerKt.sourceInformation($composer, "CN(modifier)*33@1181L335:CreateCheeseFeedKomponent.kt#co2v8d");
                CheeseFeedItemUiKt.CourseFeedItemUi(this.$card$inlined.getData(), OperableModelKt.applyOperableModel(PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(4), Dp.constructor-impl(12), Dp.constructor-impl(8)), this.$card$inlined.getOperableModel()), $composer, 0, 0);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public SeasonModel getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv);
    }
}