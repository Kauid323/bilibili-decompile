package kntr.app.digital.preview.lock;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import javax.inject.Inject;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.api.CardData;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.digital.preview.generated.resources.Drawable0_commonMainKt;
import srcs.app.digital.preview.generated.resources.Res;

/* compiled from: LockUIService.kt */
@BusinessScope
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/lock/LockUIService;", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "unlockCardDialogService", "Lkntr/app/digital/preview/lock/UnlockCardDialogService;", "lockStateService", "Lkntr/app/digital/preview/lock/LockStateService;", "cardStateService", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkntr/app/digital/preview/lock/UnlockCardDialogService;Lkntr/app/digital/preview/lock/LockStateService;Lkntr/app/digital/preview/card/DigitalCardStateService;)V", "UnlockUI", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Content", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LockUIService {
    public static final int $stable = 8;
    private final DigitalCardStateService cardStateService;
    private final CoroutineScope coroutineScope;
    private final LockStateService lockStateService;
    private final UnlockCardDialogService unlockCardDialogService;

    /* compiled from: LockUIService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardData.Data.CardLockStatus.values().length];
            try {
                iArr[CardData.Data.CardLockStatus.LOCKED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CardData.Data.CardLockStatus.UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CardData.Data.CardLockStatus.PERMANENTLY_LOCKED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(LockUIService lockUIService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        lockUIService.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnlockUI$lambda$0(LockUIService lockUIService, Modifier modifier, int i, int i2, Composer composer, int i3) {
        lockUIService.UnlockUI(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Inject
    public LockUIService(@BusinessCoroutineScope CoroutineScope coroutineScope, UnlockCardDialogService unlockCardDialogService, LockStateService lockStateService, DigitalCardStateService cardStateService) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(unlockCardDialogService, "unlockCardDialogService");
        Intrinsics.checkNotNullParameter(lockStateService, "lockStateService");
        Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
        this.coroutineScope = coroutineScope;
        this.unlockCardDialogService = unlockCardDialogService;
        this.lockStateService = lockStateService;
        this.cardStateService = cardStateService;
    }

    private final void UnlockUI(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(1546075226);
        ComposerKt.sourceInformation($composer2, "C(UnlockUI)N(modifier)34@1470L20,37@1605L6,33@1425L213:LockUIService.kt#v8bmo1");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1546075226, $dirty2, -1, "kntr.app.digital.preview.lock.LockUIService.UnlockUI (LockUIService.kt:32)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getLock_unlock_line_500($composer2, 6), (String) null, modifier, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), $composer2, Painter.$stable | 48 | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.lock.LockUIService$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnlockUI$lambda$0;
                    UnlockUI$lambda$0 = LockUIService.UnlockUI$lambda$0(LockUIService.this, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UnlockUI$lambda$0;
                }
            });
        }
    }

    public final void Content(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(467293343);
        ComposerKt.sourceInformation($composer2, "C(Content)N(modifier):LockUIService.kt#v8bmo1");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(467293343, $dirty2, -1, "kntr.app.digital.preview.lock.LockUIService.Content (LockUIService.kt:42)");
            }
            final CardItem currentCard = this.cardStateService.getCurrentCardItem();
            CardData.Data.CardLockStatus lockStatus = this.lockStateService.lockStatus(currentCard);
            switch (lockStatus != null ? WhenMappings.$EnumSwitchMapping$0[lockStatus.ordinal()] : -1) {
                case 1:
                    Modifier modifier4 = modifier3;
                    $composer2.startReplaceGroup(1147204317);
                    ComposerKt.sourceInformation($composer2, "47@1952L60,50@2147L347,46@1911L606");
                    Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getDlc_card_lock_image(Res.drawable.INSTANCE), $composer2, 0);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1902648102, "CC(remember):LockUIService.kt#9igjgp");
                    boolean invalid$iv = $composer2.changedInstance(this) | $composer2.changedInstance(currentCard);
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.digital.preview.lock.LockUIService$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit Content$lambda$0$0;
                                Content$lambda$0$0 = LockUIService.Content$lambda$0$0(LockUIService.this, currentCard);
                                return Content$lambda$0$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ImageKt.Image(painterResource, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, 120);
                    $composer2.endReplaceGroup();
                    modifier2 = modifier4;
                    break;
                case 2:
                    Modifier modifier5 = modifier3;
                    $composer2.startReplaceGroup(1147878598);
                    ComposerKt.sourceInformation($composer2, "63@2694L130,61@2602L245");
                    ComposerKt.sourceInformationMarkerStart($composer2, -1902630815, "CC(remember):LockUIService.kt#9igjgp");
                    boolean invalid$iv2 = $composer2.changedInstance(this) | $composer2.changedInstance(currentCard);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.digital.preview.lock.LockUIService$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit Content$lambda$1$0;
                                Content$lambda$1$0 = LockUIService.Content$lambda$1$0(LockUIService.this, currentCard);
                                return Content$lambda$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    UnlockUI(ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), $composer2, $dirty2 & 112, 0);
                    $composer2.endReplaceGroup();
                    modifier2 = modifier5;
                    break;
                case 3:
                    $composer2.startReplaceGroup(1148215475);
                    ComposerKt.sourceInformation($composer2, "71@2983L72,70@2942L232");
                    ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getDlc_card_permanently_lock_image(Res.drawable.INSTANCE), $composer2, 0), (String) null, modifier3, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48 | (($dirty2 << 6) & 896), 120);
                    $composer2.endReplaceGroup();
                    modifier2 = modifier3;
                    break;
                default:
                    $composer2.startReplaceGroup(1148504302);
                    ComposerKt.sourceInformation($composer2, "78@3240L13");
                    modifier2 = modifier3;
                    BoxKt.Box(modifier2, $composer2, $dirty2 & 14);
                    $composer2.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.lock.LockUIService$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$2;
                    Content$lambda$2 = LockUIService.Content$lambda$2(LockUIService.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0(LockUIService this$0, CardItem $currentCard) {
        BuildersKt.launch$default(this$0.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LockUIService$Content$1$1$1(this$0, $currentCard, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$0(LockUIService this$0, CardItem $currentCard) {
        this$0.lockStateService.toggleDlcLockCard($currentCard, true);
        return Unit.INSTANCE;
    }
}