package kntr.app.digital.preview.card.video;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.web.WebCard;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalVideoCardVolumeService.kt */
@BusinessScope
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u0007H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", RoomRecommendViewModel.EMPTY_CURSOR, "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "<init>", "(Lkntr/app/digital/preview/card/DigitalCardStateService;)V", "cardsVolumeShowing", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getCardsVolumeShowing", "()Ljava/util/List;", "cardsVolumeShowing$delegate", "Landroidx/compose/runtime/State;", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "manuallySetVolumeOn", "getManuallySetVolumeOn", "()Ljava/lang/Boolean;", "setManuallySetVolumeOn", "(Ljava/lang/Boolean;)V", "manuallySetVolumeOn$delegate", "Landroidx/compose/runtime/MutableState;", "volumeOn", "getVolumeOn", "()Z", "volumeOn$delegate", "initCardVolumeKeysShowingList", "cardList", "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "markCardVolumeOn", RoomRecommendViewModel.EMPTY_CURSOR, "on", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalVideoCardVolumeService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final State cardsVolumeShowing$delegate;
    private final MutableState manuallySetVolumeOn$delegate;
    private final State volumeOn$delegate;

    @Inject
    public DigitalVideoCardVolumeService(DigitalCardStateService cardStateService) {
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        this.cardStateService = cardStateService;
        this.cardsVolumeShowing$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.digital.preview.card.video.DigitalVideoCardVolumeService$$ExternalSyntheticLambda0
            public final Object invoke() {
                List cardsVolumeShowing_delegate$lambda$0;
                cardsVolumeShowing_delegate$lambda$0 = DigitalVideoCardVolumeService.cardsVolumeShowing_delegate$lambda$0(DigitalVideoCardVolumeService.this);
                return cardsVolumeShowing_delegate$lambda$0;
            }
        });
        this.manuallySetVolumeOn$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.volumeOn$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.digital.preview.card.video.DigitalVideoCardVolumeService$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean volumeOn_delegate$lambda$0;
                volumeOn_delegate$lambda$0 = DigitalVideoCardVolumeService.volumeOn_delegate$lambda$0(DigitalVideoCardVolumeService.this);
                return Boolean.valueOf(volumeOn_delegate$lambda$0);
            }
        });
    }

    public final List<String> getCardsVolumeShowing() {
        State $this$getValue$iv = this.cardsVolumeShowing$delegate;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List cardsVolumeShowing_delegate$lambda$0(DigitalVideoCardVolumeService this$0) {
        return this$0.initCardVolumeKeysShowingList(this$0.cardStateService.getCardItems());
    }

    private final void setManuallySetVolumeOn(Boolean bool) {
        MutableState $this$setValue$iv = this.manuallySetVolumeOn$delegate;
        $this$setValue$iv.setValue(bool);
    }

    public final Boolean getManuallySetVolumeOn() {
        State $this$getValue$iv = this.manuallySetVolumeOn$delegate;
        return (Boolean) $this$getValue$iv.getValue();
    }

    public final boolean getVolumeOn() {
        State $this$getValue$iv = this.volumeOn$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean volumeOn_delegate$lambda$0(DigitalVideoCardVolumeService this$0) {
        Boolean manuallySetVolumeOn = this$0.getManuallySetVolumeOn();
        if (manuallySetVolumeOn != null) {
            boolean it = manuallySetVolumeOn.booleanValue();
            return it;
        }
        Object currentCard = this$0.cardStateService.getCurrentCardItem().getData();
        if ((currentCard instanceof WithVolume) && ((WithVolume) currentCard).getVolumeKeysShowing()) {
            return ((WithVolume) currentCard).getVolumeOn();
        }
        return true;
    }

    private final List<String> initCardVolumeKeysShowingList(List<? extends CardItem<?>> list) {
        List<? extends CardItem<?>> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            CardItem it = (CardItem) element$iv$iv;
            if (((it.getData() instanceof VideoCard) && ((VideoCard) it.getData()).getVolumeKeysShowing()) || ((it.getData() instanceof WebCard) && ((WebCard) it.getData()).getVolumeKeysShowing())) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv2.add(((CardItem) item$iv$iv).getBasic().getUniqueId());
        }
        return (List) destination$iv$iv2;
    }

    public final void markCardVolumeOn(boolean on) {
        setManuallySetVolumeOn(Boolean.valueOf(on));
    }
}