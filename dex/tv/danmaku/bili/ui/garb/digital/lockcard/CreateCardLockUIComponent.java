package tv.danmaku.bili.ui.garb.digital.lockcard;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.ogv.infra.compose.DrawableResourceKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;

/* compiled from: CreateCardLockUIComponent.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0010JO\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/lockcard/CreateCardLockUIComponent;", "", "createLockModel", "Ltv/danmaku/bili/ui/garb/digital/lockcard/CreateLockModel;", "dialogService", "Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService;", "<init>", "(Ltv/danmaku/bili/ui/garb/digital/lockcard/CreateLockModel;Ltv/danmaku/bili/ui/garb/digital/lockcard/UnlockCardDialogService;)V", "LockUI", "", "resId", "", "modifier", "Landroidx/compose/ui/Modifier;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "UnLockUI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "invoke", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "cardLockStatus", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "actId", "", "cardId", "cardTypeId", "cardNo", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Ltv/danmaku/bili/ui/garb/api/CardLockStatus;JJJLjava/lang/String;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/jvm/functions/Function3;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CreateCardLockUIComponent {
    public static final int $stable = 8;
    private final CreateLockModel createLockModel;
    private final UnlockCardDialogService dialogService;

    /* compiled from: CreateCardLockUIComponent.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardLockStatus.values().length];
            try {
                iArr[CardLockStatus.LOCKED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CardLockStatus.UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CardLockStatus.PERMANENTLY_LOCKED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LockUI$lambda$0(CreateCardLockUIComponent createCardLockUIComponent, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        createCardLockUIComponent.LockUI(i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnLockUI$lambda$0(CreateCardLockUIComponent createCardLockUIComponent, Modifier modifier, int i, Composer composer, int i2) {
        createCardLockUIComponent.UnLockUI(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public CreateCardLockUIComponent(CreateLockModel createLockModel, UnlockCardDialogService dialogService) {
        Intrinsics.checkNotNullParameter(createLockModel, "createLockModel");
        Intrinsics.checkNotNullParameter(dialogService, "dialogService");
        this.createLockModel = createLockModel;
        this.dialogService = dialogService;
    }

    private final void LockUI(final int resId, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-47850907);
        ComposerKt.sourceInformation($composer2, "C(LockUI)N(resId,modifier)24@892L38,23@864L147:CreateCardLockUIComponent.kt#fsh0na");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(resId) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-47850907, $dirty2, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent.LockUI (CreateCardLockUIComponent.kt:22)");
            }
            ImageKt.Image(DrawableResourceKt.rememberDrawableResourcePainter(resId, $composer2, $dirty2 & 14), "", modifier4, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48 | (($dirty2 << 3) & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit LockUI$lambda$0;
                    LockUI$lambda$0 = CreateCardLockUIComponent.LockUI$lambda$0(CreateCardLockUIComponent.this, resId, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LockUI$lambda$0;
                }
            });
        }
    }

    private final void UnLockUI(final Modifier modifier, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1299437233);
        ComposerKt.sourceInformation($composer2, "C(UnLockUI)N(modifier)33@1131L20,36@1254L6,32@1090L193:CreateCardLockUIComponent.kt#fsh0na");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1299437233, $dirty2, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent.UnLockUI (CreateCardLockUIComponent.kt:31)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getLock_unlock_line_500($composer2, 6), (String) null, modifier, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), $composer2, Painter.$stable | 48 | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnLockUI$lambda$0;
                    UnLockUI$lambda$0 = CreateCardLockUIComponent.UnLockUI$lambda$0(CreateCardLockUIComponent.this, modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UnLockUI$lambda$0;
                }
            });
        }
    }

    public final Function3<Modifier, Composer, Integer, Unit> invoke(CardLockStatus cardLockStatus, final long actId, final long cardId, final long cardTypeId, final String cardNo, final CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(cardLockStatus, "cardLockStatus");
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final LockModel lockModel = this.createLockModel.invoke(cardLockStatus);
        return ComposableLambdaKt.composableLambdaInstance(-1129809400, true, new Function3() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = CreateCardLockUIComponent.invoke$lambda$0(LockModel.this, this, scope, actId, cardId, cardTypeId, cardNo, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return invoke$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(final LockModel $lockModel, final CreateCardLockUIComponent this$0, final CoroutineScope $scope, final long $actId, final long $cardId, final long $cardTypeId, final String $cardNo, Modifier modifier, Composer $composer, int $changed) {
        Composer composer;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier):CreateCardLockUIComponent.kt#fsh0na");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1129809400, $dirty2, -1, "tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent.invoke.<anonymous> (CreateCardLockUIComponent.kt:51)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[$lockModel.getLockStatus().ordinal()]) {
                case 1:
                    $composer.startReplaceGroup(1506984719);
                    ComposerKt.sourceInformation($composer, "55@1850L600,53@1724L727,68@2486L9");
                    int i = R.drawable.dlc_card_lock_image;
                    ComposerKt.sourceInformationMarkerStart($composer, 879900928, "CC(remember):CreateCardLockUIComponent.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance(this$0) | $composer.changedInstance($lockModel) | $composer.changed($actId) | $composer.changed($cardId) | $composer.changed($cardTypeId) | $composer.changed($cardNo);
                    Object value$iv = $composer.rememberedValue();
                    if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                        composer = $composer;
                        value$iv = new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit invoke$lambda$0$0$0;
                                invoke$lambda$0$0$0 = CreateCardLockUIComponent.invoke$lambda$0$0$0($scope, this$0, $lockModel, $actId, $cardId, $cardTypeId, $cardNo);
                                return invoke$lambda$0$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        composer = $composer;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    this$0.LockUI(i, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null), $composer, 0, 0);
                    this$0.dialogService.Content(composer, 0);
                    $composer.endReplaceGroup();
                    break;
                case 2:
                    $composer.startReplaceGroup(1507822649);
                    ComposerKt.sourceInformation($composer, "72@2619L369,72@2580L409");
                    ComposerKt.sourceInformationMarkerStart($composer, 879925305, "CC(remember):CreateCardLockUIComponent.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changedInstance($lockModel) | $composer.changed($actId) | $composer.changed($cardId) | $composer.changed($cardTypeId) | $composer.changed($cardNo);
                    Object value$iv2 = $composer.rememberedValue();
                    if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                        value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit invoke$lambda$0$1$0;
                                invoke$lambda$0$1$0 = CreateCardLockUIComponent.invoke$lambda$0$1$0(LockModel.this, $actId, $cardId, $cardTypeId, $cardNo);
                                return invoke$lambda$0$1$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    this$0.UnLockUI(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null), $composer, 0);
                    $composer.endReplaceGroup();
                    break;
                case 3:
                    $composer.startReplaceGroup(1508315518);
                    ComposerKt.sourceInformation($composer, "87@3239L2,85@3084L180");
                    int i2 = R.drawable.dlc_card_permanently_lock_image;
                    ComposerKt.sourceInformationMarkerStart($composer, 879944778, "CC(remember):CreateCardLockUIComponent.kt#9igjgp");
                    Object it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer.updateRememberedValue(value$iv3);
                        it$iv = value$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    this$0.LockUI(i2, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), $composer, 0, 0);
                    $composer.endReplaceGroup();
                    break;
                default:
                    $composer.startReplaceGroup(879894985);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$0$0(CoroutineScope $scope, CreateCardLockUIComponent this$0, LockModel $lockModel, long $actId, long $cardId, long $cardTypeId, String $cardNo) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new CreateCardLockUIComponent$invoke$1$1$1$1(this$0, $lockModel, $actId, $cardId, $cardTypeId, $cardNo, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0$1$0(LockModel $lockModel, long $actId, long $cardId, long $cardTypeId, String $cardNo) {
        $lockModel.toggleLockCard(true, $actId, $cardId, $cardTypeId, $cardNo);
        return Unit.INSTANCE;
    }
}