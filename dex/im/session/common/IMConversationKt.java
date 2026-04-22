package im.session.common;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bapis.bilibili.account.service.v1.KNameRender;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnreadStyle;
import com.bapis.bilibili.app.im.v1.KUserLabel;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.base.LiveBadgeKt;
import im.base.model.AvatarHolder;
import im.base.model.NameRenderHolder;
import im.base.model.VipNameColorHolder;
import im.base.namerender.NameRenderPainterKt;
import im.session.IMActionExposureSessionCard;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionInfo;
import im.session.service.Summary;
import im.session.service.SummaryPrefix;
import im.session.service.SummaryPrefixColor;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.compose.avatar.AvatarKt;
import kntr.compose.avatar.AvatarScope;
import kntr.compose.avatar.AvatarSizeConfig;
import kntr.compose.avatar.AvatarState;
import kntr.compose.avatar.internal.AvatarContentKt;
import kntr.compose.avatar.model.AvatarItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMConversation.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001a#\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0017\u001a'\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"TAG", "", "IMConversationLongClick", "", "conversation", "Lim/session/model/IMSessionCard;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "(Lim/session/model/IMSessionCard;Lim/session/common/IMSessionEventHandler;Landroidx/compose/runtime/Composer;I)V", "IMConversationContent", "modifier", "Landroidx/compose/ui/Modifier;", "(Lim/session/model/IMSessionCard;Lim/session/common/IMSessionEventHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ConversationAvatar", "avatar", "Lkntr/compose/avatar/model/AvatarItem;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "ConversationAvatar-rAjV9yQ", "(Lkntr/compose/avatar/model/AvatarItem;FLandroidx/compose/runtime/Composer;II)V", "ConversationName", "card", "timeDescription", "(Lim/session/model/IMSessionCard;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ConversationSummary", SocialConstants.PARAM_SUMMARY, "Lim/session/service/Summary;", "isMuted", "", "unread", "Lcom/bapis/bilibili/app/im/v1/KUnread;", "(Lim/session/service/Summary;ZLcom/bapis/bilibili/app/im/v1/KUnread;Landroidx/compose/runtime/Composer;I)V", "LiveBadge", "(Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMConversationKt {
    private static final String TAG = "IMConversation";

    /* compiled from: IMConversation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SummaryPrefixColor.values().length];
            try {
                iArr[SummaryPrefixColor.Red.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SummaryPrefixColor.Gray.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationAvatar_rAjV9yQ$lambda$0(AvatarItem avatarItem, float f2, int i2, int i3, Composer composer, int i4) {
        m3268ConversationAvatarrAjV9yQ(avatarItem, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationName$lambda$0(IMSessionCard iMSessionCard, String str, int i2, Composer composer, int i3) {
        ConversationName(iMSessionCard, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationName$lambda$3(IMSessionCard iMSessionCard, String str, int i2, Composer composer, int i3) {
        ConversationName(iMSessionCard, str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSummary$lambda$2(Summary summary, boolean z, KUnread kUnread, int i2, Composer composer, int i3) {
        ConversationSummary(summary, z, kUnread, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationContent$lambda$3(IMSessionCard iMSessionCard, IMSessionEventHandler iMSessionEventHandler, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMConversationContent(iMSessionCard, iMSessionEventHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationLongClick$lambda$2(IMSessionCard iMSessionCard, IMSessionEventHandler iMSessionEventHandler, int i2, Composer composer, int i3) {
        IMConversationLongClick(iMSessionCard, iMSessionEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LiveBadge$lambda$1(int i2, Composer composer, int i3) {
        LiveBadge(composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void IMConversationLongClick(final IMSessionCard conversation, final IMSessionEventHandler eventHandler, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer2 = $composer.startRestartGroup(-1219897077);
        ComposerKt.sourceInformation($composer2, "C(IMConversationLongClick)N(conversation,eventHandler)77@3001L24,83@3216L87,86@3331L244,78@3030L567:IMConversation.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(conversation) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(eventHandler) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1219897077, $dirty2, -1, "im.session.common.IMConversationLongClick (IMConversation.kt:76)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 204991714, "CC(remember):IMConversation.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit IMConversationLongClick$lambda$0$0;
                        IMConversationLongClick$lambda$0$0 = IMConversationKt.IMConversationLongClick$lambda$0$0(IMSessionEventHandler.this, conversation);
                        return IMConversationLongClick$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 204995551, "CC(remember):IMConversation.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(scope) | (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        Unit IMConversationLongClick$lambda$1$0;
                        IMConversationLongClick$lambda$1$0 = IMConversationKt.IMConversationLongClick$lambda$1$0(scope, eventHandler, conversation);
                        return IMConversationLongClick$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IMConversationContent(conversation, eventHandler, ClickableKt.combinedClickable-hoGz1lA$default(modifier, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (MutableInteractionSource) null, (Function0) it$iv2, (int) TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, (Object) null), $composer2, ($dirty2 & 14) | ($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMConversationLongClick$lambda$2;
                    IMConversationLongClick$lambda$2 = IMConversationKt.IMConversationLongClick$lambda$2(IMSessionCard.this, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMConversationLongClick$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationLongClick$lambda$0$0(IMSessionEventHandler $eventHandler, IMSessionCard $conversation) {
        $eventHandler.getCardLongClickHandler().invoke($conversation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationLongClick$lambda$1$0(CoroutineScope $scope, IMSessionEventHandler $eventHandler, IMSessionCard $conversation) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMConversationKt$IMConversationLongClick$2$1$1($eventHandler, $conversation, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void IMConversationContent(final IMSessionCard conversation, final IMSessionEventHandler eventHandler, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        Composer $composer2;
        long j;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        AvatarHolder avatar;
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer3 = $composer.startRestartGroup(-967946925);
        ComposerKt.sourceInformation($composer3, "C(IMConversationContent)N(conversation,eventHandler,modifier)102@3792L6,108@4043L365,117@4496L117,103@3816L1490:IMConversation.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(conversation) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 32 : 16;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i3 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-967946925, $dirty2, -1, "im.session.common.IMConversationContent (IMConversation.kt:101)");
            }
            final long lineColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier2, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            if (conversation.isPinned()) {
                $composer3.startReplaceGroup(1810919548);
                ComposerKt.sourceInformation($composer3, "107@3966L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2_float-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(1810920566);
                ComposerKt.sourceInformation($composer3, "107@3998L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            Modifier modifier3 = BackgroundKt.background-bw27NRU$default(fillMaxWidth$default, j, (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1810922144, "CC(remember):IMConversation.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(lineColor);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit IMConversationContent$lambda$0$0;
                        IMConversationContent$lambda$0$0 = IMConversationKt.IMConversationContent$lambda$0$0(lineColor, (ContentDrawScope) obj);
                        return IMConversationContent$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier drawWithContent = DrawModifierKt.drawWithContent(modifier3, (Function1) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer3, 1810936392, "CC(remember):IMConversation.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit IMConversationContent$lambda$1$0;
                        IMConversationContent$lambda$1$0 = IMConversationKt.IMConversationContent$lambda$1$0(IMSessionEventHandler.this, conversation);
                        return IMConversationContent$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(drawWithContent, new SimpleExposureEntry(500L, (Function0) it$iv2)), Dp.constructor-impl(8), Dp.constructor-impl(8), Dp.constructor-impl(16), Dp.constructor-impl(8));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier4 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 765173020, "C124@4828L60,126@4898L402:IMConversation.kt#yqxgzx");
            IMSessionInfo sessionInfo = conversation.getSessionInfo();
            m3268ConversationAvatarrAjV9yQ((sessionInfo == null || (avatar = sessionInfo.getAvatar()) == null) ? null : avatar.getAvatar(), CropImageView.DEFAULT_ASPECT_RATIO, $composer3, 0, 2);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (54 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((54 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 2038218544, "C130@5040L60,132@5114L176:IMConversation.kt#yqxgzx");
            ConversationName(conversation, conversation.getTimeDescription(), $composer3, $dirty2 & 14);
            ConversationSummary(conversation.getSummary(), conversation.isMuted(), conversation.getUnread(), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMConversationContent$lambda$3;
                    IMConversationContent$lambda$3 = IMConversationKt.IMConversationContent$lambda$3(IMSessionCard.this, eventHandler, modifier5, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMConversationContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationContent$lambda$0$0(long $lineColor, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        float x$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(71));
        int bits$iv$iv$iv = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.25d));
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
        float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv2);
        int bits$iv$iv$iv3 = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
        float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.25d));
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        DrawScope.-CC.drawLine-NGM6Ib0$default((DrawScope) $this$drawWithContent, $lineColor, j, Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.5d)), 0, (PathEffect) null, (float) CropImageView.DEFAULT_ASPECT_RATIO, (ColorFilter) null, 0, 496, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationContent$lambda$1$0(IMSessionEventHandler $eventHandler, IMSessionCard $conversation) {
        $eventHandler.getActionHandler().invoke(new IMActionExposureSessionCard($conversation));
        return Unit.INSTANCE;
    }

    /* renamed from: ConversationAvatar-rAjV9yQ  reason: not valid java name */
    public static final void m3268ConversationAvatarrAjV9yQ(final AvatarItem avatar, float f2, Composer $composer, final int $changed, final int i2) {
        float f3;
        final float f4;
        Function0 factory$iv$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1269817906);
        ComposerKt.sourceInformation($composer2, "C(ConversationAvatar)N(avatar,normalSize:c#ui.unit.Dp):IMConversation.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(avatar) ? 4 : 2;
        }
        int i3 = i2 & 2;
        if (i3 != 0) {
            $dirty |= 48;
            f3 = f2;
        } else if (($changed & 48) == 0) {
            f3 = f2;
            $dirty |= $composer2.changed(f3) ? 32 : 16;
        } else {
            f3 = f2;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i3 == 0) {
                f4 = f3;
            } else {
                f4 = Dp.constructor-impl(40);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1269817906, $dirty, -1, "im.session.common.ConversationAvatar (IMConversation.kt:145)");
            }
            if (avatar != null) {
                $composer2.startReplaceGroup(-926596865);
                ComposerKt.sourceInformation($composer2, "148@5474L39,147@5446L129");
                AvatarState state$iv = AvatarKt.rememberAvatarState-ziNgDLE(avatar, f4, $composer2, ($dirty & 14) | ($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                AvatarSizeConfig sizeConfig$iv = AvatarSizeConfig.Largest;
                ComposerKt.sourceInformationMarkerStart($composer2, -1812324423, "CC(Avatar)N(state,modifier,sizeConfig)20@712L229:Avatar.kt#v7x95u");
                Modifier modifier$iv = Modifier.Companion;
                Modifier modifier$iv$iv = modifier$iv.then(SizeKt.size-3ABfNKs(Modifier.Companion, sizeConfig$iv.constraintSize-u2uoSUM(state$iv)));
                Alignment contentAlignment$iv$iv = Alignment.Companion.getTopStart();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv$iv, false);
                int $changed$iv$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
                Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv$iv);
                } else {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -60560984, "C24@868L21:Avatar.kt#v7x95u");
                $composer2.startReplaceGroup(-833237573);
                ComposerKt.sourceInformation($composer2, "*25@905L20");
                AvatarScope $this$Avatar_u24lambda_u240_u240$iv = AvatarKt.rememberAvatarScope($composer2, 0);
                AvatarContentKt.AvatarContent($this$Avatar_u24lambda_u240_u240$iv, state$iv, $composer2, (384 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-926447817);
                ComposerKt.sourceInformation($composer2, "152@5597L105");
                BoxKt.Box(SizeKt.size-3ABfNKs(Modifier.Companion, AvatarSizeConfig.Largest.constraintSize-5rwHm24(f4)), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            f4 = f3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConversationAvatar_rAjV9yQ$lambda$0;
                    ConversationAvatar_rAjV9yQ$lambda$0 = IMConversationKt.ConversationAvatar_rAjV9yQ$lambda$0(avatar, f4, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ConversationAvatar_rAjV9yQ$lambda$0;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x034c, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ConversationName(final IMSessionCard card, final String timeDescription, Composer $composer, final int $changed) {
        Composer $composer2;
        Brush rememberNameRenderBrush;
        Integer valueOf;
        VipNameColorHolder vipNameColor;
        TextStyle textStyle;
        VipNameColorHolder vipNameColor2;
        NameRenderHolder nameRender;
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(timeDescription, "timeDescription");
        Composer $composer3 = $composer.startRestartGroup(-2010425109);
        ComposerKt.sourceInformation($composer3, "C(ConversationName)N(card,timeDescription)168@6021L13,189@6631L3828:IMConversation.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(card) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(timeDescription) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2010425109, $dirty2, -1, "im.session.common.ConversationName (IMConversation.kt:162)");
            }
            final IMSessionInfo sessionInfo = card.getSessionInfo();
            if (sessionInfo == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ConversationName$lambda$0;
                            ConversationName$lambda$0 = IMConversationKt.ConversationName$lambda$0(IMSessionCard.this, timeDescription, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            return ConversationName$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            IMSessionInfo sessionInfo2 = card.getSessionInfo();
            KNameRender it = (sessionInfo2 == null || (nameRender = sessionInfo2.getNameRender()) == null) ? null : nameRender.getNameRender();
            if (it == null) {
                $composer3.startReplaceGroup(744719615);
                $composer3.endReplaceGroup();
                rememberNameRenderBrush = null;
            } else {
                $composer3.startReplaceGroup(744719616);
                ComposerKt.sourceInformation($composer3, "*166@5950L27");
                rememberNameRenderBrush = NameRenderPainterKt.rememberNameRenderBrush(it, $composer3, 0);
                $composer3.endReplaceGroup();
            }
            Brush nameBrush = rememberNameRenderBrush;
            ThemeDayNight currentTheme = BiliTheme.INSTANCE.getDayNightTheme($composer3, BiliTheme.$stable);
            if (currentTheme == ThemeDayNight.Day) {
                IMSessionInfo sessionInfo3 = card.getSessionInfo();
                valueOf = (sessionInfo3 == null || (vipNameColor2 = sessionInfo3.getVipNameColor()) == null) ? null : Integer.valueOf(vipNameColor2.getDayColor());
            } else {
                IMSessionInfo sessionInfo4 = card.getSessionInfo();
                valueOf = (sessionInfo4 == null || (vipNameColor = sessionInfo4.getVipNameColor()) == null) ? null : Integer.valueOf(vipNameColor.getNightColor());
            }
            int vipColor = valueOf != null ? valueOf.intValue() : 0;
            if (nameBrush != null) {
                $composer3.startReplaceGroup(745092360);
                ComposerKt.sourceInformation($composer3, "178@6335L9");
                textStyle = TextStyle.copy-Ns73l9s$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), nameBrush, (float) CropImageView.DEFAULT_ASPECT_RATIO, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (Object) null);
                $composer3.endReplaceGroup();
            } else if (vipColor != 0) {
                $composer3.startReplaceGroup(745201666);
                ComposerKt.sourceInformation($composer3, "182@6445L9");
                textStyle = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), ColorKt.Color(vipColor), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(745308027);
                ComposerKt.sourceInformation($composer3, "186@6552L9,186@6589L6");
                textStyle = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                $composer3.endReplaceGroup();
            }
            final TextStyle style = textStyle;
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$ConversationName_u24lambda_u242 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -2035116536, "C195@6920L3311,195@6857L3374,289@10313L9,290@10358L6,287@10241L212:IMConversation.kt#yqxgzx");
            Modifier weight = $this$ConversationName_u24lambda_u242.weight(Modifier.Companion, 1.0f, false);
            ComposerKt.sourceInformationMarkerStart($composer3, -481289186, "CC(remember):IMConversation.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer3.changedInstance(sessionInfo) | $composer3.changed(style);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    MeasureResult ConversationName$lambda$2$0$0;
                    ConversationName$lambda$2$0$0 = IMConversationKt.ConversationName$lambda$2$0$0(IMSessionInfo.this, card, style, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    return ConversationName$lambda$2$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SubcomposeLayoutKt.SubcomposeLayout(weight, (Function2) it$iv, $composer3, 0, 0);
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(timeDescription, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), $composer3, ($dirty2 >> 3) & 14, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConversationName$lambda$3;
                    ConversationName$lambda$3 = IMConversationKt.ConversationName$lambda$3(IMSessionCard.this, timeDescription, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ConversationName$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ConversationName$lambda$2$0$0(final IMSessionInfo $sessionInfo, final IMSessionCard $card, final TextStyle $style, SubcomposeMeasureScope $this$SubcomposeLayout, Constraints constraints) {
        Integer num;
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        final int spacing = $this$SubcomposeLayout.roundToPx-0680j_4(Dp.constructor-impl(6));
        Iterable subcompose = $this$SubcomposeLayout.subcompose("badges", ComposableLambdaKt.composableLambdaInstance(-142140991, true, new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit ConversationName$lambda$2$0$0$0;
                ConversationName$lambda$2$0$0$0 = IMConversationKt.ConversationName$lambda$2$0$0$0(IMSessionInfo.this, $card, (Composer) obj, ((Integer) obj2).intValue());
                return ConversationName$lambda$2$0$0$0;
            }
        }));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(subcompose, 10));
        Iterable $this$mapTo$iv$iv = subcompose;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Measurable it = (Measurable) item$iv$iv;
            destination$iv$iv.add(it.measure-BRTryo0(constraints.unbox-impl()));
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
        }
        final List<Placeable> badgePlaceables = (List) destination$iv$iv;
        int i2 = 0;
        for (Placeable it2 : badgePlaceables) {
            i2 += it2.getWidth();
        }
        final int badgesWidth = i2;
        int availableForNames = Math.max(0, Constraints.getMaxWidth-impl(constraints.unbox-impl()) - (badgesWidth > 0 ? badgesWidth + spacing : 0));
        Iterable $this$map$iv = $this$SubcomposeLayout.subcompose(ContentDisposition.Parameters.Name, ComposableLambdaKt.composableLambdaInstance(250637439, true, new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit ConversationName$lambda$2$0$0$3;
                ConversationName$lambda$2$0$0$3 = IMConversationKt.ConversationName$lambda$2$0$0$3(IMSessionInfo.this, $style, (Composer) obj, ((Integer) obj2).intValue());
                return ConversationName$lambda$2$0$0$3;
            }
        }));
        boolean z = false;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv2 : $this$map$iv) {
            Measurable it3 = (Measurable) item$iv$iv2;
            destination$iv$iv2.add(it3.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(constraints.unbox-impl(), 0, availableForNames, 0, 0, 12, (Object) null)));
            z = z;
        }
        final List<Placeable> namePlaceables = (List) destination$iv$iv2;
        int i3 = 0;
        for (Placeable it4 : namePlaceables) {
            i3 += it4.getWidth();
        }
        int nameWidth = i3;
        int availableForHandle = Math.max(0, (availableForNames - nameWidth) - spacing);
        Iterable $this$map$iv2 = $this$SubcomposeLayout.subcompose("handle", ComposableLambdaKt.composableLambdaInstance(-150774334, true, new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit ConversationName$lambda$2$0$0$6;
                ConversationName$lambda$2$0$0$6 = IMConversationKt.ConversationName$lambda$2$0$0$6(IMSessionInfo.this, (Composer) obj, ((Integer) obj2).intValue());
                return ConversationName$lambda$2$0$0$6;
            }
        }));
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv3 : $this$map$iv2) {
            Measurable it5 = (Measurable) item$iv$iv3;
            Collection destination$iv$iv4 = destination$iv$iv3;
            destination$iv$iv4.add(it5.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(constraints.unbox-impl(), 0, availableForHandle, 0, 0, 12, (Object) null)));
            destination$iv$iv3 = destination$iv$iv4;
        }
        final List handlePlaceables = (List) destination$iv$iv3;
        final boolean showHandle = availableForHandle > 0;
        Iterator it6 = CollectionsKt.plus(CollectionsKt.plus(badgePlaceables, namePlaceables), showHandle ? handlePlaceables : CollectionsKt.emptyList()).iterator();
        if (it6.hasNext()) {
            Placeable it7 = (Placeable) it6.next();
            Integer valueOf = Integer.valueOf(it7.getHeight());
            while (it6.hasNext()) {
                Placeable it8 = (Placeable) it6.next();
                Integer valueOf2 = Integer.valueOf(it8.getHeight());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        } else {
            num = null;
        }
        Integer num2 = num;
        final int height = num2 != null ? num2.intValue() : 0;
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, Constraints.getMaxWidth-impl(constraints.unbox-impl()), height, (Map) null, new Function1() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit ConversationName$lambda$2$0$0$9;
                ConversationName$lambda$2$0$0$9 = IMConversationKt.ConversationName$lambda$2$0$0$9(namePlaceables, showHandle, spacing, handlePlaceables, badgesWidth, badgePlaceables, height, (Placeable.PlacementScope) obj);
                return ConversationName$lambda$2$0$0$9;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0159, code lost:
        if (r0.isLive() == true) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ConversationName$lambda$2$0$0$0(IMSessionInfo $sessionInfo, IMSessionCard $card, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C202@7117L294:IMConversation.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-142140991, $changed, -1, "im.session.common.ConversationName.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMConversation.kt:202)");
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 812553928, "C:IMConversation.kt#yqxgzx");
            KUserLabel it = $sessionInfo.getUserLabel();
            if (it == null) {
                $composer.startReplaceGroup(812571999);
            } else {
                $composer.startReplaceGroup(812572000);
                ComposerKt.sourceInformation($composer, "*203@7228L29");
                ConversationLabelKt.ConversationLabel(it, $composer, 0);
            }
            $composer.endReplaceGroup();
            IMSessionInfo sessionInfo = $card.getSessionInfo();
            boolean z = sessionInfo != null;
            if (z) {
                $composer.startReplaceGroup(812672130);
                ComposerKt.sourceInformation($composer, "205@7352L11");
                LiveBadge($composer, 0);
            } else {
                $composer.startReplaceGroup(805405637);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationName$lambda$2$0$0$3(IMSessionInfo $sessionInfo, TextStyle $style, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C221@7876L218:IMConversation.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(250637439, $changed, -1, "im.session.common.ConversationName.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMConversation.kt:221)");
            }
            TextKt.Text-Nvy7gAk($sessionInfo.getSessionName(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, $style, $composer, 0, 24960, 110590);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationName$lambda$2$0$0$6(IMSessionInfo $sessionInfo, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:IMConversation.kt#yqxgzx");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-150774334, $changed, -1, "im.session.common.ConversationName.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMConversation.kt:237)");
            }
            if ($sessionInfo.getSessionHandle().length() > 0) {
                $composer.startReplaceGroup(817707833);
                ComposerKt.sourceInformation($composer, "240@8703L9,240@8740L6,238@8589L295");
                TextKt.Text-Nvy7gAk($sessionInfo.getSessionHandle(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer, 0, 24960, 110590);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(809177408);
                $composer.endReplaceGroup();
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
    public static final Unit ConversationName$lambda$2$0$0$9(List $namePlaceables, boolean $showHandle, int $spacing, List $handlePlaceables, int $badgesWidth, List $badgePlaceables, int $height, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        int x = 0;
        List $this$forEach$iv = $namePlaceables;
        for (Object element$iv : $this$forEach$iv) {
            Placeable it = (Placeable) element$iv;
            Placeable.PlacementScope.placeRelative$default($this$layout, it, x, ($height - it.getHeight()) / 2, (float) CropImageView.DEFAULT_ASPECT_RATIO, 4, (Object) null);
            x += it.getWidth();
        }
        if ($showHandle) {
            x += $spacing;
            List $this$forEach$iv2 = $handlePlaceables;
            for (Object element$iv2 : $this$forEach$iv2) {
                Placeable it2 = (Placeable) element$iv2;
                Placeable.PlacementScope.placeRelative$default($this$layout, it2, x, ($height - it2.getHeight()) / 2, (float) CropImageView.DEFAULT_ASPECT_RATIO, 4, (Object) null);
                x += it2.getWidth();
            }
        }
        if ($badgesWidth > 0) {
            int x2 = x + $spacing;
            List $this$forEach$iv3 = $badgePlaceables;
            for (Object element$iv3 : $this$forEach$iv3) {
                Placeable it3 = (Placeable) element$iv3;
                Placeable.PlacementScope.placeRelative$default($this$layout, it3, x2, ($height - it3.getHeight()) / 2, (float) CropImageView.DEFAULT_ASPECT_RATIO, 4, (Object) null);
                x2 += it3.getWidth();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ConversationSummary(final Summary summary, final boolean isMuted, final KUnread unread, Composer $composer, final int $changed) {
        Composer $composer2;
        long color;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer3;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(unread, "unread");
        Composer $composer4 = $composer.startRestartGroup(-1645322207);
        ComposerKt.sourceInformation($composer4, "C(ConversationSummary)N(summary,isMuted,unread)303@10606L6,305@10641L728,323@11374L2612:IMConversation.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(summary) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(isMuted) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(unread) ? 256 : 128;
        }
        if (!$composer4.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1645322207, $dirty, -1, "im.session.common.ConversationSummary (IMConversation.kt:302)");
            }
            BiliColors colors = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable);
            ComposerKt.sourceInformationMarkerStart($composer4, -606670247, "CC(remember):IMConversation.kt#9igjgp");
            boolean invalid$iv = $composer4.changed(summary);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                AnnotatedString.Builder $this$ConversationSummary_u24lambda_u240_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                if (summary != null) {
                    SummaryPrefix prefix = summary.getPrefix();
                    if (!StringsKt.isBlank(prefix.getContent())) {
                        switch (WhenMappings.$EnumSwitchMapping$0[prefix.getPrefixType().getColor().ordinal()]) {
                            case 1:
                                color = colors.getStress_red-0d7_KjU();
                                break;
                            case 2:
                                color = colors.getText3-0d7_KjU();
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        SpanStyle style$iv = new SpanStyle(color, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
                        int index$iv = $this$ConversationSummary_u24lambda_u240_u240.pushStyle(style$iv);
                        try {
                            try {
                                $this$ConversationSummary_u24lambda_u240_u240.append(prefix.getContent());
                                Unit unit = Unit.INSTANCE;
                                $this$ConversationSummary_u24lambda_u240_u240.pop(index$iv);
                            } catch (Throwable th) {
                                th = th;
                                $this$ConversationSummary_u24lambda_u240_u240.pop(index$iv);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    $this$ConversationSummary_u24lambda_u240_u240.append(summary.getContentForDisplay());
                }
                Object value$iv = $this$ConversationSummary_u24lambda_u240_u240.toAnnotatedString();
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AnnotatedString annotated = (AnnotatedString) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (390 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((390 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            RowScope $this$ConversationSummary_u24lambda_u241 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer4, 1912309001, "C329@11561L9,330@11606L6,327@11495L250,335@11754L2226:IMConversation.kt#yqxgzx");
            TextKt.Text-Z58ophY(annotated, RowScope.-CC.weight$default($this$ConversationSummary_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), $composer4, 0, 24960, 241656);
            Modifier modifier$iv2 = SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            $composer2 = $composer4;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i5 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1765236046, "C:IMConversation.kt#yqxgzx");
            if (isMuted) {
                $composer4.startReplaceGroup(1765211648);
                ComposerKt.sourceInformation($composer4, "342@12022L25,343@12086L6,341@11973L249");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getBell_reserve_off_line_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_weak-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
            } else {
                $composer4.startReplaceGroup(1753325721);
            }
            $composer4.endReplaceGroup();
            KUnreadStyle style = unread.getStyle();
            if (style instanceof KUnreadStyle.UNREAD_STYLE_DOT) {
                $composer4.startReplaceGroup(1765563281);
                ComposerKt.sourceInformation($composer4, "355@12565L6,350@12345L352");
                BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getStress_red-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer4, 0);
                $composer4.endReplaceGroup();
                $composer$iv = $composer4;
                $composer3 = $composer4;
            } else if (style instanceof KUnreadStyle.UNREAD_STYLE_NUMBER) {
                $composer4.startReplaceGroup(1766032373);
                ComposerKt.sourceInformation($composer4, "");
                if (StringsKt.isBlank(unread.getNumberShow())) {
                    $composer$iv = $composer4;
                    $composer3 = $composer4;
                    $composer4.startReplaceGroup(1753325721);
                } else {
                    $composer4.startReplaceGroup(1766087553);
                    ComposerKt.sourceInformation($composer4, "367@13048L6,363@12856L1032");
                    Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0(SizeKt.sizeIn-qDBjuR0$default(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getStress_red-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(16), Dp.constructor-impl(16), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 12, (Object) null), Dp.constructor-impl(4), Dp.constructor-impl((float) 0.75d), Dp.constructor-impl(4), Dp.constructor-impl((float) 0.25d));
                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv3 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    $composer$iv = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv6;
                        $composer4.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv6;
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                    $composer3 = $composer4;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i7 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1798164875, "C380@13749L6,381@13818L9,378@13635L227:IMConversation.kt#yqxgzx");
                    TextKt.Text-Nvy7gAk(unread.getNumberShow(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT11(), $composer4, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                }
                $composer4.endReplaceGroup();
                $composer4.endReplaceGroup();
            } else {
                $composer$iv = $composer4;
                $composer3 = $composer4;
                $composer4.startReplaceGroup(1767169143);
                $composer4.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit ConversationSummary$lambda$2;
                    ConversationSummary$lambda$2 = IMConversationKt.ConversationSummary$lambda$2(Summary.this, isMuted, unread, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ConversationSummary$lambda$2;
                }
            });
        }
    }

    public static final void LiveBadge(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1817240995);
        ComposerKt.sourceInformation($composer2, "C(LiveBadge)399@14145L6,395@14033L668:IMConversation.kt#yqxgzx");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1817240995, $changed, -1, "im.session.common.LiveBadge (IMConversation.kt:394)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), Dp.constructor-impl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 469747224, "C406@14487L6,406@14427L78,408@14539L51,409@14622L6,410@14671L9,407@14514L181:IMConversation.kt#yqxgzx");
            LiveBadgeKt.m3094LiveIcon3IgeMak(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), false, $composer2, 6, 4);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_338(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversationKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit LiveBadge$lambda$1;
                    LiveBadge$lambda$1 = IMConversationKt.LiveBadge$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LiveBadge$lambda$1;
                }
            });
        }
    }
}