package tv.danmaku.bili.ui.garb.nft.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bili.digital.common.CardNumberColorUtilKt;
import com.bili.digital.common.CardNumberGradientColor;
import com.bili.digital.common.player.DigitalCardVideoPlayParams;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.common.gyroscope.view.GyroRoundedView;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.bson.dsl.JsonObjectBuilder;
import com.bilibili.digital.card.page.card.cardmodule.web.WebCard;
import com.bilibili.droid.DimenUtilsKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.TypeFaceHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.neuron.api.Neurons;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplay;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplayFrame;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardDisplayMark;
import tv.danmaku.bili.ui.garb.api.BiliDLCCardItem;
import tv.danmaku.bili.ui.garb.api.BillDLCRespInfo;
import tv.danmaku.bili.ui.garb.api.CardInfo;
import tv.danmaku.bili.ui.garb.api.CardLockStatus;
import tv.danmaku.bili.ui.garb.api.CardTypeInfo;
import tv.danmaku.bili.ui.garb.api.DLCItem;
import tv.danmaku.bili.ui.garb.api.DLCReporterHelper;
import tv.danmaku.bili.ui.garb.digital.lockcard.DLCCardLockService;
import tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager;
import tv.danmaku.bili.ui.garb.nft.helper.DLCCardModelHelper;
import tv.danmaku.bili.ui.garb.nft.helper.SimpleUAMListener;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;
import tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader;
import tv.danmaku.bili.ui.garb.nft.util.ResVideoUtil;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.video.bilicardplayer.BiliCardPlayerManager;
import tv.danmaku.video.bilicardplayer.ICardPlaySateChangedCallback;
import tv.danmaku.video.bilicardplayer.ICardPlayerContext;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: DLCDrawCardView.kt */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u0086\u00012\u00020\u0001:\u0004\u0086\u0001\u0087\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010N\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010O\u001a\u00020@Jm\u0010P\u001a\u00020@2\b\u0010Q\u001a\u0004\u0018\u00010\u00112\b\u00108\u001a\u0004\u0018\u0001092\b\u0010R\u001a\u0004\u0018\u00010S2-\b\u0002\u0010:\u001a'\u0012\u0004\u0012\u000202\u0012\u0015\u0012\u0013\u0018\u00010<¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020@\u0018\u00010;2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010B2\u0006\u0010T\u001a\u00020\rJ\u0012\u0010U\u001a\u00020@2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\b\u0010V\u001a\u00020@H\u0002J\b\u0010W\u001a\u00020@H\u0002J\b\u0010X\u001a\u00020@H\u0002J\u0014\u0010Y\u001a\u00020@2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\b\u0010\\\u001a\u00020@H\u0002J\b\u0010]\u001a\u00020@H\u0002J\b\u0010^\u001a\u00020@H\u0002J\u0010\u0010_\u001a\u00020@2\u0006\u0010`\u001a\u000200H\u0002J\b\u0010a\u001a\u00020@H\u0002J\b\u0010b\u001a\u00020@H\u0002J\b\u0010c\u001a\u00020@H\u0002J\b\u0010d\u001a\u00020@H\u0002J\u001c\u0010e\u001a\u00020@2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\u0010\u0010j\u001a\u00020@2\u0006\u0010k\u001a\u00020lH\u0002JD\u0010m\u001a\u00020@2\b\u0010n\u001a\u0004\u0018\u00010\"2\u0006\u0010o\u001a\u00020[2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010B2\u0016\b\u0002\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020@\u0018\u00010rH\u0002J$\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0t2\u0006\u0010u\u001a\u00020\u001f2\u0006\u0010v\u001a\u00020\u001fH\u0002J$\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0t2\u0006\u0010u\u001a\u00020\u001f2\u0006\u0010v\u001a\u00020\u001fH\u0002Jh\u0010x\u001a\u00020@2\u0006\u0010y\u001a\u00020l2\u0012\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0t2\u000e\u0010{\u001a\n\u0012\u0004\u0012\u00020[\u0018\u0001042\b\b\u0002\u0010|\u001a\u00020\r2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010B2\u0016\b\u0002\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020@\u0018\u00010rH\u0002J \u0010}\u001a\u00020~2\u0006\u0010y\u001a\u00020l2\u000e\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020[\u0018\u000104H\u0002J\t\u0010\u0080\u0001\u001a\u00020@H\u0002J=\u0010\u0081\u0001\u001a\u00020@2\b\u0010n\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010B2\u0016\b\u0002\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020@\u0018\u00010rH\u0002J\u0007\u0010\u0082\u0001\u001a\u00020@J\u0007\u0010\u0083\u0001\u001a\u00020@J\t\u0010\u0084\u0001\u001a\u00020@H\u0002J\u0007\u0010\u0085\u0001\u001a\u00020@R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R3\u0010:\u001a'\u0012\u0004\u0012\u000202\u0012\u0015\u0012\u0013\u0018\u00010<¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020@\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardView;", "", "context", "Landroid/content/Context;", "dlcCardLockService", "Ltv/danmaku/bili/ui/garb/digital/lockcard/DLCCardLockService;", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/garb/digital/lockcard/DLCCardLockService;)V", "getContext", "()Landroid/content/Context;", "getDlcCardLockService", "()Ltv/danmaku/bili/ui/garb/digital/lockcard/DLCCardLockService;", "fromResultView", "", "view", "Landroid/view/View;", "loadingCl", "Landroid/view/ViewGroup;", "animCl", "animMask", "Lcom/bilibili/lib/image2/view/BiliImageView;", "skipAllAnims", "Landroidx/appcompat/widget/AppCompatTextView;", "loadingIv", "Landroidx/appcompat/widget/AppCompatImageView;", "smeltingTutorialBtn", "gyroView", "Lcom/bilibili/app/common/gyroscope/view/GyroRoundedView;", "loadingAnim", "Landroid/graphics/drawable/Animatable;", "mContainerWidth", "", "mContainerHeight", "mPreLoadUAMView", "Lcom/bilibili/bililive/uam/view/UAMView;", "mEntryUAMView", "mCardIndex", "mCardVideoGroup", "mVideoTask", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "mVideoToken", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "needResumeVideo", "viewData", "Ltv/danmaku/bili/ui/garb/nft/DLCDrawCardDataManager;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "animState", "Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardView$AnimState;", "respInfo", "Ltv/danmaku/bili/ui/garb/api/BillDLCRespInfo;", "dlcItems", "", "Ltv/danmaku/bili/ui/garb/api/DLCItem;", "getDlcItems", "()Ljava/util/List;", "drawCardModel", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;", "goDrawResult", "Lkotlin/Function2;", "Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "cardLockStatus", "", "goBack", "Lkotlin/Function0;", "loadGyroResult", "tvCardIndex", "Landroid/widget/TextView;", "cardLockComposeView", "Landroidx/compose/ui/platform/ComposeView;", "linInfoWrapper", "Landroid/widget/LinearLayout;", "tvCardName", "tvAction", "bivFrameBolder", "bivBadge", "getRootView", "initView", "initData", "viewGroup", "lifeCycle", "Landroidx/lifecycle/Lifecycle;", "fromResult", "doLifeCycle", "initViewData", "showLoadingView", "showResDownFailed", "showApiFailedView", "apiFailedMsg", "", "showPlayFailedView", "startHalfScreenFlow", "startFullScreenFlow", "showAnimView", AuthResultCbHelper.ARGS_STATE, "startDrawAnim", "startEntryAnim", "preloadShowCardView", "startShowCardView", "renderCardLock", "currentCardInfo", "Ltv/danmaku/bili/ui/garb/api/CardInfo;", "currentCardTypeInfo", "Ltv/danmaku/bili/ui/garb/api/CardTypeInfo;", "showCardAnimMask", "totalDuration", "", "playUAMVideo", "uamPlayer", "filePath", "playStartAction", "completeAction", "Lkotlin/Function1;", "compatCardSize", "Lkotlin/Pair;", "width", "height", "compatCardSizeHalfScreen", "playVideo", "cardId", "size", "playUrl", "isMute", "generatePlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "videoList", "commitVideoTask", "registerAnimListener", "resume", "pause", "gotoDrawCardResult", "destroy", "Companion", "AnimState", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCDrawCardView {
    private static final float CARD_GROUP_HEIGHT = 390.0f;
    private static final float CARD_GROUP_WIDTH = 260.0f;
    private ViewGroup animCl;
    private BiliImageView animMask;
    private AnimState animState;
    private BiliImageView bivBadge;
    private BiliImageView bivFrameBolder;
    private ComposeView cardLockComposeView;
    private final Context context;
    private final DLCCardLockService dlcCardLockService;
    private DLCCardDrawModel drawCardModel;
    private boolean fromResultView;
    private Function0<Unit> goBack;
    private Function2<? super BillDLCRespInfo, ? super CardLockStatus, Unit> goDrawResult;
    private GyroRoundedView gyroView;
    private LinearLayout linInfoWrapper;
    private boolean loadGyroResult;
    private Animatable loadingAnim;
    private ViewGroup loadingCl;
    private AppCompatImageView loadingIv;
    private int mCardIndex;
    private ViewGroup mCardVideoGroup;
    private int mContainerHeight;
    private int mContainerWidth;
    private UAMView mEntryUAMView;
    private UAMView mPreLoadUAMView;
    private BiliCardPlayerScene.CardPlayTask mVideoTask;
    private BiliCardPlayerScene.CardPlayTask.Token mVideoToken;
    private CoroutineScope mainScope;
    private boolean needResumeVideo;
    private BillDLCRespInfo respInfo;
    private AppCompatTextView skipAllAnims;
    private AppCompatImageView smeltingTutorialBtn;
    private TextView tvAction;
    private TextView tvCardIndex;
    private TextView tvCardName;
    private View view;
    private DLCDrawCardDataManager viewData;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = Reflection.getOrCreateKotlinClass(DLCDrawCardView.class).getSimpleName();

    /* compiled from: DLCDrawCardView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardView$AnimState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "DRAW", "ENTRY", "SHOW_CARD", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum AnimState {
        LOADING,
        DRAW,
        ENTRY,
        SHOW_CARD;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<AnimState> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: DLCDrawCardView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimState.values().length];
            try {
                iArr[AnimState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AnimState.DRAW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AnimState.ENTRY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AnimState.SHOW_CARD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DLCDrawCardView(Context context, DLCCardLockService dlcCardLockService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dlcCardLockService, "dlcCardLockService");
        this.context = context;
        this.dlcCardLockService = dlcCardLockService;
        this.mainScope = CoroutineScopeKt.MainScope();
    }

    public final Context getContext() {
        return this.context;
    }

    public final DLCCardLockService getDlcCardLockService() {
        return this.dlcCardLockService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DLCItem> getDlcItems() {
        BillDLCRespInfo billDLCRespInfo = this.respInfo;
        if (billDLCRespInfo != null) {
            return billDLCRespInfo.getItemList();
        }
        return null;
    }

    public final View getRootView() {
        return this.view;
    }

    public final void initView() {
        this.view = LayoutInflater.from(this.context).inflate(R.layout.bili_app_dlc_dialog_draw_card, (ViewGroup) null, false);
        View view = this.view;
        Intrinsics.checkNotNull(view);
        this.loadingCl = (ViewGroup) view.findViewById(R.id.cl_dlc_draw_card_loading);
        View view2 = this.view;
        Intrinsics.checkNotNull(view2);
        this.animCl = (ViewGroup) view2.findViewById(R.id.cl_dlc_draw_card_video_anim);
        View view3 = this.view;
        Intrinsics.checkNotNull(view3);
        this.skipAllAnims = view3.findViewById(R.id.tv_dlc_draw_card_skip);
        View view4 = this.view;
        Intrinsics.checkNotNull(view4);
        this.smeltingTutorialBtn = view4.findViewById(R.id.iv_dlc_card_smelt_tutorial);
        View view5 = this.view;
        Intrinsics.checkNotNull(view5);
        this.animMask = view5.findViewById(R.id.view_dlc_draw_card_video_mask);
        View view6 = this.view;
        Intrinsics.checkNotNull(view6);
        this.mPreLoadUAMView = view6.findViewById(R.id.uam_dlc_draw_card_preload);
        View view7 = this.view;
        Intrinsics.checkNotNull(view7);
        this.mEntryUAMView = view7.findViewById(R.id.uam_dlc_draw_card_entry);
        View view8 = this.view;
        Intrinsics.checkNotNull(view8);
        this.mCardVideoGroup = (ViewGroup) view8.findViewById(R.id.fl_dlc_draw_card_video);
        View view9 = this.view;
        Intrinsics.checkNotNull(view9);
        this.loadingIv = view9.findViewById(R.id.iv_dlc_draw_card_loading);
        View view10 = this.view;
        Intrinsics.checkNotNull(view10);
        this.gyroView = view10.findViewById(R.id.view_dlc_draw_card_gyro);
        View wrapper = this.view;
        if (wrapper != null) {
            View findViewById = wrapper.findViewById(R.id.nft_card_top_index);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.tvCardIndex = (TextView) findViewById;
            this.linInfoWrapper = (LinearLayout) wrapper.findViewById(R.id.linNameWrapper);
            this.tvCardName = (TextView) wrapper.findViewById(R.id.nft_card_bottom_name);
            this.tvAction = (TextView) wrapper.findViewById(R.id.tvNextAction);
            this.bivFrameBolder = wrapper.findViewById(R.id.bivFrameBolder);
            this.bivBadge = wrapper.findViewById(R.id.bivBadge);
            ComposeView findViewById2 = wrapper.findViewById(R.id.nft_card_lock_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.cardLockComposeView = findViewById2;
        }
    }

    public static /* synthetic */ void initData$default(DLCDrawCardView dLCDrawCardView, ViewGroup viewGroup, DLCCardDrawModel dLCCardDrawModel, Lifecycle lifecycle, Function2 function2, Function0 function0, boolean z, int i, Object obj) {
        Function2 function22;
        Function0 function02;
        if ((i & 8) == 0) {
            function22 = function2;
        } else {
            function22 = null;
        }
        if ((i & 16) == 0) {
            function02 = function0;
        } else {
            function02 = null;
        }
        dLCDrawCardView.initData(viewGroup, dLCCardDrawModel, lifecycle, function22, function02, z);
    }

    public final void initData(ViewGroup viewGroup, DLCCardDrawModel drawCardModel, Lifecycle lifeCycle, Function2<? super BillDLCRespInfo, ? super CardLockStatus, Unit> function2, Function0<Unit> function0, boolean fromResult) {
        if (viewGroup != null) {
            viewGroup.addView(this.view);
        }
        this.goDrawResult = function2;
        this.goBack = function0;
        this.drawCardModel = drawCardModel;
        this.fromResultView = fromResult;
        doLifeCycle(lifeCycle);
        initViewData();
        boolean z = false;
        if (drawCardModel != null && drawCardModel.getScreenType() == 0) {
            z = true;
        }
        if (!z) {
            AppCompatTextView appCompatTextView = this.skipAllAnims;
            ConstraintLayout.LayoutParams layoutParams = appCompatTextView != null ? appCompatTextView.getLayoutParams() : null;
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.topMargin = DimenUtilsKt.dpToPx(17);
            }
        }
    }

    private final void doLifeCycle(Lifecycle lifeCycle) {
        if (lifeCycle != null) {
            lifeCycle.addObserver(new LifecycleObserver() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$doLifeCycle$1
                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                public final void onResume(LifecycleOwner source) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    DLCDrawCardView.this.resume();
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
                public final void onPause(LifecycleOwner source) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    DLCDrawCardView.this.pause();
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy(LifecycleOwner source) {
                    String str;
                    Intrinsics.checkNotNullParameter(source, "source");
                    str = DLCDrawCardView.TAG;
                    BLog.d(str, "onDestroy");
                    DLCDrawCardView.this.destroy();
                }
            });
        }
    }

    private final void initViewData() {
        showAnimView(AnimState.LOADING);
        this.viewData = new DLCDrawCardDataManager(this.fromResultView);
        BuildersKt.launch$default(this.mainScope, (CoroutineContext) null, (CoroutineStart) null, new DLCDrawCardView$initViewData$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r0.isRunning() == true) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showLoadingView() {
        boolean z;
        Animatable animatable = this.loadingAnim;
        if (animatable != null) {
            z = true;
        }
        z = false;
        if (z) {
            return;
        }
        ViewGroup viewGroup = this.loadingCl;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.animCl;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(4);
        }
        AppCompatImageView appCompatImageView = this.loadingIv;
        Drawable drawable = appCompatImageView != null ? appCompatImageView.getDrawable() : null;
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.Animatable");
        this.loadingAnim = (Animatable) drawable;
        Animatable animatable2 = this.loadingAnim;
        if (animatable2 != null) {
            animatable2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showResDownFailed() {
        Animatable animatable = this.loadingAnim;
        if (animatable != null) {
            animatable.stop();
        }
        ToastHelper.showToastShort(this.context, bili.resource.homepage.R.string.homepage_global_string_179);
        gotoDrawCardResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showApiFailedView$default(DLCDrawCardView dLCDrawCardView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dLCDrawCardView.showApiFailedView(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showApiFailedView(String apiFailedMsg) {
        Animatable animatable = this.loadingAnim;
        if (animatable != null) {
            animatable.stop();
        }
        if (!TextUtils.isEmpty(apiFailedMsg)) {
            ToastHelper.showToastShort(this.context, apiFailedMsg);
        } else {
            ToastHelper.showToastShort(this.context, bili.resource.homepage.R.string.homepage_global_string_267);
        }
        Function0<Unit> function0 = this.goBack;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void showPlayFailedView() {
        showResDownFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startHalfScreenFlow() {
        gotoDrawCardResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startFullScreenFlow() {
        Animatable animatable = this.loadingAnim;
        if (animatable != null) {
            animatable.stop();
        }
        Animatable animatable2 = this.loadingAnim;
        if (animatable2 != null) {
            animatable2.stop();
        }
        ViewGroup viewGroup = this.loadingCl;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        ViewGroup viewGroup2 = this.animCl;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        AppCompatTextView appCompatTextView = this.skipAllAnims;
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DLCDrawCardView.startFullScreenFlow$lambda$0(DLCDrawCardView.this, view);
                }
            });
        }
        AppCompatImageView appCompatImageView = this.smeltingTutorialBtn;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DLCDrawCardView.startFullScreenFlow$lambda$1(DLCDrawCardView.this, view);
                }
            });
        }
        showAnimView(AnimState.DRAW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFullScreenFlow$lambda$0(DLCDrawCardView this$0, View it) {
        String fSource;
        String fromId;
        String fromWhere;
        DLCReporterHelper dLCReporterHelper = DLCReporterHelper.INSTANCE;
        DLCCardDrawModel dLCCardDrawModel = this$0.drawCardModel;
        long actId = dLCCardDrawModel != null ? dLCCardDrawModel.getActId() : 0L;
        DLCCardDrawModel dLCCardDrawModel2 = this$0.drawCardModel;
        long lotteryId = dLCCardDrawModel2 != null ? dLCCardDrawModel2.getLotteryId() : 0L;
        DLCCardDrawModel dLCCardDrawModel3 = this$0.drawCardModel;
        int activityStatus = dLCCardDrawModel3 != null ? dLCCardDrawModel3.getActivityStatus() : 0;
        DLCCardDrawModel dLCCardDrawModel4 = this$0.drawCardModel;
        int lotteryNum = dLCCardDrawModel4 != null ? dLCCardDrawModel4.getLotteryNum() : 0;
        DLCCardDrawModel dLCCardDrawModel5 = this$0.drawCardModel;
        String str = (dLCCardDrawModel5 == null || (fromWhere = dLCCardDrawModel5.getFromWhere()) == null) ? "" : fromWhere;
        DLCCardDrawModel dLCCardDrawModel6 = this$0.drawCardModel;
        String str2 = (dLCCardDrawModel6 == null || (fromId = dLCCardDrawModel6.getFromId()) == null) ? "" : fromId;
        DLCCardDrawModel dLCCardDrawModel7 = this$0.drawCardModel;
        String str3 = (dLCCardDrawModel7 == null || (fSource = dLCCardDrawModel7.getFSource()) == null) ? "" : fSource;
        DLCCardDrawModel dLCCardDrawModel8 = this$0.drawCardModel;
        dLCReporterHelper.reportCardSkipAnim(actId, lotteryId, activityStatus, lotteryNum, str, str2, str3, dLCCardDrawModel8 != null ? dLCCardDrawModel8.getPageType() : 0);
        this$0.gotoDrawCardResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFullScreenFlow$lambda$1(DLCDrawCardView this$0, View it) {
        String fromId;
        Map $this$startFullScreenFlow_u24lambda_u241_u240 = MapsKt.createMapBuilder();
        DLCCardDrawModel dLCCardDrawModel = this$0.drawCardModel;
        $this$startFullScreenFlow_u24lambda_u241_u240.put("activity_id", String.valueOf(dLCCardDrawModel != null ? dLCCardDrawModel.getActId() : 0L));
        DLCCardDrawModel dLCCardDrawModel2 = this$0.drawCardModel;
        $this$startFullScreenFlow_u24lambda_u241_u240.put("activity_status", String.valueOf(dLCCardDrawModel2 != null ? dLCCardDrawModel2.getActivityStatus() : 0));
        DLCCardDrawModel dLCCardDrawModel3 = this$0.drawCardModel;
        $this$startFullScreenFlow_u24lambda_u241_u240.put("lottery_id", String.valueOf(dLCCardDrawModel3 != null ? dLCCardDrawModel3.getLotteryId() : 0L));
        DLCCardDrawModel dLCCardDrawModel4 = this$0.drawCardModel;
        String str = "";
        $this$startFullScreenFlow_u24lambda_u241_u240.put("f_source", (dLCCardDrawModel4 == null || (r3 = dLCCardDrawModel4.getFSource()) == null) ? "" : "");
        DLCCardDrawModel dLCCardDrawModel5 = this$0.drawCardModel;
        $this$startFullScreenFlow_u24lambda_u241_u240.put("from", (dLCCardDrawModel5 == null || (r3 = dLCCardDrawModel5.getFromWhere()) == null) ? "" : "");
        DLCCardDrawModel dLCCardDrawModel6 = this$0.drawCardModel;
        $this$startFullScreenFlow_u24lambda_u241_u240.put("from_id", (dLCCardDrawModel6 == null || (r3 = dLCCardDrawModel6.getFromId()) == null) ? "" : "");
        DLCCardDrawModel dLCCardDrawModel7 = this$0.drawCardModel;
        $this$startFullScreenFlow_u24lambda_u241_u240.put("page_type", String.valueOf(dLCCardDrawModel7 != null ? dLCCardDrawModel7.getPageType() : 0));
        $this$startFullScreenFlow_u24lambda_u241_u240.put("arrive", "3");
        $this$startFullScreenFlow_u24lambda_u241_u240.put("is_huixingka", "1");
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "sqzz.dressing.rebuild.guide.click", MapsKt.build($this$startFullScreenFlow_u24lambda_u241_u240));
        Uri.Builder buildUpon = Uri.parse("bilibili://digital/smelting_tutorial").buildUpon();
        JsonObject jsonObject$iv$iv = new JsonObject();
        JsonObject builder$iv$iv = JsonObjectBuilder.constructor-impl(jsonObject$iv$iv);
        DLCCardDrawModel dLCCardDrawModel8 = this$0.drawCardModel;
        JsonObjectBuilder.kv-impl(builder$iv$iv, "f_source", (dLCCardDrawModel8 == null || (r13 = dLCCardDrawModel8.getFSource()) == null) ? "" : "");
        DLCCardDrawModel dLCCardDrawModel9 = this$0.drawCardModel;
        JsonObjectBuilder.kv-impl(builder$iv$iv, "from", (dLCCardDrawModel9 == null || (r5 = dLCCardDrawModel9.getFromWhere()) == null) ? "" : "");
        DLCCardDrawModel dLCCardDrawModel10 = this$0.drawCardModel;
        if (dLCCardDrawModel10 != null && (fromId = dLCCardDrawModel10.getFromId()) != null) {
            str = fromId;
        }
        JsonObjectBuilder.kv-impl(builder$iv$iv, "from_id", str);
        JsonObjectBuilder.kv-impl(builder$iv$iv, "is_huixingka", "1");
        Unit unit2 = Unit.INSTANCE;
        String uri = buildUpon.appendQueryParameter("report_params", GsonKt.toJsonString(builder$iv$iv)).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        BLRouter.routeTo(new RouteRequest.Builder(uri).build(), this$0.context);
    }

    private final void showAnimView(AnimState state) {
        BLog.d(TAG, "showAnimView curCardIndex:" + this.mCardIndex + " " + state.name());
        this.animState = state;
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                showLoadingView();
                return;
            case 2:
                startDrawAnim();
                return;
            case 3:
                startEntryAnim();
                return;
            case 4:
                startShowCardView();
                this.mCardIndex++;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void startDrawAnim() {
        int scarcity;
        final String preloadUrl;
        HashMap<Integer, String> animDrawMap;
        Integer num;
        List<DLCItem> dlcItems = getDlcItems();
        if (dlcItems != null) {
            Iterator<T> it = dlcItems.iterator();
            if (it.hasNext()) {
                DLCItem it2 = (DLCItem) it.next();
                Integer valueOf = Integer.valueOf(it2.getItemScarcity());
                while (it.hasNext()) {
                    DLCItem it3 = (DLCItem) it.next();
                    Integer valueOf2 = Integer.valueOf(it3.getItemScarcity());
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                num = valueOf;
            } else {
                num = null;
            }
            Integer num2 = num;
            if (num2 != null) {
                scarcity = num2.intValue();
                DLCCardDrawModel dLCCardDrawModel = this.drawCardModel;
                preloadUrl = (dLCCardDrawModel != null || (animDrawMap = dLCCardDrawModel.getAnimDrawMap()) == null || (preloadUrl = animDrawMap.get(Integer.valueOf(scarcity))) == null) ? "" : "";
                if (!TextUtils.isEmpty(preloadUrl)) {
                    BLog.i(TAG, "startDrawAnim preloadUrl is empty");
                    showPlayFailedView();
                    return;
                }
                UAMView uAMView = this.mPreLoadUAMView;
                if (uAMView != null) {
                    uAMView.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DLCDrawCardView.startDrawAnim$lambda$1(DLCDrawCardView.this, preloadUrl);
                        }
                    });
                    return;
                }
                return;
            }
        }
        scarcity = 0;
        DLCCardDrawModel dLCCardDrawModel2 = this.drawCardModel;
        if (dLCCardDrawModel2 != null) {
        }
        if (!TextUtils.isEmpty(preloadUrl)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDrawAnim$lambda$1(final DLCDrawCardView this$0, String $preloadUrl) {
        String str = TAG;
        UAMView uAMView = this$0.mPreLoadUAMView;
        boolean z = false;
        if (uAMView != null && uAMView.getVisibility() == 0) {
            z = true;
        }
        UAMView uAMView2 = this$0.mPreLoadUAMView;
        Integer valueOf = uAMView2 != null ? Integer.valueOf(uAMView2.getWidth()) : null;
        UAMView uAMView3 = this$0.mPreLoadUAMView;
        BLog.i(str, "startDrawAnim mPreLoadUAMView visiable:" + z + " " + valueOf + " " + (uAMView3 != null ? Integer.valueOf(uAMView3.getHeight()) : null));
        this$0.playUAMVideo(this$0.mPreLoadUAMView, DLCResDownloader.Companion.getResPathByUrl($preloadUrl), null, new Function1() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit startDrawAnim$lambda$1$0;
                startDrawAnim$lambda$1$0 = DLCDrawCardView.startDrawAnim$lambda$1$0(DLCDrawCardView.this, ((Boolean) obj).booleanValue());
                return startDrawAnim$lambda$1$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDrawAnim$lambda$1$0(final DLCDrawCardView this$0, boolean it) {
        if (!it) {
            this$0.showPlayFailedView();
            return Unit.INSTANCE;
        }
        UAMView uAMView = this$0.mPreLoadUAMView;
        if (uAMView != null) {
            uAMView.setVisibility(4);
        }
        UAMView uAMView2 = this$0.mPreLoadUAMView;
        if (uAMView2 != null) {
            uAMView2.destroy();
        }
        this$0.mPreLoadUAMView = null;
        ViewGroup viewGroup = this$0.animCl;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DLCDrawCardView.startDrawAnim$lambda$1$0$0(DLCDrawCardView.this, view);
                }
            });
        }
        this$0.showAnimView(AnimState.ENTRY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDrawAnim$lambda$1$0$0(DLCDrawCardView this$0, View it) {
        this$0.showAnimView(AnimState.ENTRY);
    }

    private final void startEntryAnim() {
        HashMap<Integer, String> animEntryMap;
        String str;
        HashMap<Integer, String> animEntryMap2;
        DLCItem dLCItem;
        ViewGroup viewGroup;
        BiliCardPlayerScene.CardPlayTask.Token token = this.mVideoToken;
        if (token != null) {
            token.pause();
        }
        int i = this.mCardIndex;
        List<DLCItem> dlcItems = getDlcItems();
        int i2 = 0;
        if (i >= (dlcItems != null ? dlcItems.size() : 0)) {
            gotoDrawCardResult();
            return;
        }
        ViewGroup $this$startEntryAnim_u24lambda_u240 = this.animCl;
        View view = null;
        if ($this$startEntryAnim_u24lambda_u240 != null) {
            $this$startEntryAnim_u24lambda_u240.setClickable(false);
            BLog.i(TAG, "startEntryAnim clickable " + (this.animCl != null ? Boolean.valueOf(viewGroup.isClickable()) : null));
        }
        LinearLayout linearLayout = this.linInfoWrapper;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.tvCardIndex;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.tvAction;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        BiliImageView biliImageView = this.bivBadge;
        if (biliImageView != null) {
            biliImageView.setVisibility(8);
        }
        BiliImageView biliImageView2 = this.bivFrameBolder;
        if (biliImageView2 != null) {
            biliImageView2.setVisibility(8);
        }
        BiliImageView biliImageView3 = this.animMask;
        if (biliImageView3 != null) {
            biliImageView3.setVisibility(4);
        }
        UAMView uAMView = this.mEntryUAMView;
        if (uAMView != null) {
            uAMView.setVisibility(0);
        }
        View view2 = this.cardLockComposeView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardLockComposeView");
        } else {
            view = view2;
        }
        View $this$isVisible$iv = view;
        $this$isVisible$iv.setVisibility(8);
        List<DLCItem> dlcItems2 = getDlcItems();
        if (dlcItems2 != null && (dLCItem = dlcItems2.get(this.mCardIndex)) != null) {
            i2 = dLCItem.getItemScarcity();
        }
        int scarcity = i2;
        DLCResDownloader.Companion companion = DLCResDownloader.Companion;
        DLCCardDrawModel dLCCardDrawModel = this.drawCardModel;
        String str2 = "";
        String entryFilePath = companion.getResPathByUrl((dLCCardDrawModel == null || (animEntryMap2 = dLCCardDrawModel.getAnimEntryMap()) == null || (r2 = animEntryMap2.get(Integer.valueOf(scarcity))) == null) ? "" : "");
        playUAMVideo(this.mEntryUAMView, entryFilePath, new Function0() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit startEntryAnim$lambda$2;
                startEntryAnim$lambda$2 = DLCDrawCardView.startEntryAnim$lambda$2(DLCDrawCardView.this, ((Boolean) obj).booleanValue());
                return startEntryAnim$lambda$2;
            }
        });
        preloadShowCardView();
        DLCResDownloader.Companion companion2 = DLCResDownloader.Companion;
        DLCCardDrawModel dLCCardDrawModel2 = this.drawCardModel;
        if (dLCCardDrawModel2 != null && (animEntryMap = dLCCardDrawModel2.getAnimEntryMap()) != null && (str = animEntryMap.get(Integer.valueOf(scarcity))) != null) {
            str2 = str;
        }
        int delayTime = companion2.getDelayQueryParam(str2, "delay");
        long totalDuration = ResVideoUtil.Companion.getVideoDuration(entryFilePath);
        final long duration = RangesKt.coerceAtLeast(200L, totalDuration - delayTime);
        ViewGroup viewGroup2 = this.animCl;
        if (viewGroup2 != null) {
            viewGroup2.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    DLCDrawCardView.this.showCardAnimMask(duration);
                }
            }, delayTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startEntryAnim$lambda$2(DLCDrawCardView this$0, boolean it) {
        if (!it) {
            this$0.showPlayFailedView();
            return Unit.INSTANCE;
        }
        UAMView uAMView = this$0.mEntryUAMView;
        if (uAMView != null) {
            uAMView.setVisibility(4);
        }
        ViewGroup viewGroup = this$0.animCl;
        if (viewGroup != null) {
            viewGroup.setClickable(true);
        }
        String str = TAG;
        ViewGroup viewGroup2 = this$0.animCl;
        BLog.i(str, "startEntryAnim complete clickable " + (viewGroup2 != null ? Boolean.valueOf(viewGroup2.isClickable()) : null));
        this$0.showAnimView(AnimState.SHOW_CARD);
        return Unit.INSTANCE;
    }

    private final void preloadShowCardView() {
        DLCItem dLCItem;
        DLCItem dLCItem2;
        BiliDLCCardItem cardItem;
        ViewGroup viewGroup = this.mCardVideoGroup;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        GyroRoundedView gyroRoundedView = this.gyroView;
        if (gyroRoundedView != null) {
            gyroRoundedView.setVisibility(4);
        }
        List<DLCItem> dlcItems = getDlcItems();
        BiliDLCCardItem biliDLCCardItem = null;
        CardTypeInfo currentCardTypeInfo = (dlcItems == null || (dLCItem2 = dlcItems.get(this.mCardIndex)) == null || (cardItem = dLCItem2.getCardItem()) == null) ? null : cardItem.getCardTypeInfo();
        final Integer materialType = currentCardTypeInfo != null ? Integer.valueOf(currentCardTypeInfo.getMaterialType()) : null;
        DLCCardModelHelper dLCCardModelHelper = DLCCardModelHelper.INSTANCE;
        List<DLCItem> dlcItems2 = getDlcItems();
        if (dlcItems2 != null && (dLCItem = dlcItems2.get(this.mCardIndex)) != null) {
            biliDLCCardItem = dLCItem.getCardItem();
        }
        final String defaultVideoImageUrl = dLCCardModelHelper.getDefaultImageUrl(biliDLCCardItem);
        final int cardWidth = currentCardTypeInfo != null ? currentCardTypeInfo.getWidth() : 0;
        final int cardHeight = currentCardTypeInfo != null ? currentCardTypeInfo.getHeight() : 0;
        View view = this.view;
        if (view != null) {
            final CardTypeInfo cardTypeInfo = currentCardTypeInfo;
            view.post(new Runnable() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DLCDrawCardView.preloadShowCardView$lambda$0(DLCDrawCardView.this, cardWidth, cardHeight, materialType, cardTypeInfo, defaultVideoImageUrl);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadShowCardView$lambda$0(final DLCDrawCardView this$0, int $cardWidth, int $cardHeight, Integer $materialType, CardTypeInfo $currentCardTypeInfo, String $defaultVideoImageUrl) {
        Pair size;
        DLCItem dLCItem;
        BiliDLCCardItem cardItem;
        CardInfo cardInfo;
        View view = this$0.view;
        boolean z = false;
        this$0.mContainerHeight = view != null ? view.getMeasuredHeight() : 0;
        View view2 = this$0.view;
        this$0.mContainerWidth = view2 != null ? view2.getMeasuredWidth() : 0;
        DLCCardDrawModel dLCCardDrawModel = this$0.drawCardModel;
        if (dLCCardDrawModel != null && dLCCardDrawModel.getScreenType() == 0) {
            size = this$0.compatCardSize($cardWidth, $cardHeight);
        } else {
            size = this$0.compatCardSizeHalfScreen($cardWidth, $cardHeight);
        }
        BiliImageView it = this$0.animMask;
        if (it != null) {
            BiliImageView biliImageView = this$0.animMask;
            if (biliImageView != null) {
                BiliImageView biliImageView2 = this$0.animMask;
                Intrinsics.checkNotNull(biliImageView2);
                ViewGroup.LayoutParams $this$preloadShowCardView_u24lambda_u240_u240_u240 = biliImageView2.getLayoutParams();
                $this$preloadShowCardView_u24lambda_u240_u240_u240.width = ((Number) size.getFirst()).intValue();
                $this$preloadShowCardView_u24lambda_u240_u240_u240.height = ((Number) size.getSecond()).intValue();
                biliImageView.setLayoutParams($this$preloadShowCardView_u24lambda_u240_u240_u240);
            }
            BiliImageLoader.INSTANCE.with(ListExtentionsKt.lifecycle(this$0.context)).overrideWidth(((Number) size.getFirst()).intValue()).overrideHeight(((Number) size.getSecond()).intValue()).url($defaultVideoImageUrl).into(it);
        }
        BiliCardPlayerManager.INSTANCE.remove(this$0.context);
        int type = NftType.VIDEO.getType();
        if ($materialType != null && $materialType.intValue() == type) {
            List videoList = $currentCardTypeInfo.getContent().getAnimation().getAnimationVideoUrls();
            List<DLCItem> dlcItems = this$0.getDlcItems();
            long cardId = (dlcItems == null || (dLCItem = dlcItems.get(this$0.mCardIndex)) == null || (cardItem = dLCItem.getCardItem()) == null || (cardInfo = cardItem.getCardInfo()) == null) ? 0L : cardInfo.getId();
            playVideo$default(this$0, cardId, size, videoList, false, new Function0() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit preloadShowCardView$lambda$0$1;
                    preloadShowCardView$lambda$0$1 = DLCDrawCardView.preloadShowCardView$lambda$0$1(DLCDrawCardView.this);
                    return preloadShowCardView$lambda$0$1;
                }
            }, new Function1() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    Unit preloadShowCardView$lambda$0$2;
                    preloadShowCardView$lambda$0$2 = DLCDrawCardView.preloadShowCardView$lambda$0$2(DLCDrawCardView.this, ((Boolean) obj).booleanValue());
                    return preloadShowCardView$lambda$0$2;
                }
            }, 8, null);
            return;
        }
        int type2 = NftType.IMAGE.getType();
        if ($materialType != null && $materialType.intValue() == type2) {
            this$0.loadGyroResult = false;
            List data = $currentCardTypeInfo.getContent().getImage().getGyroscope();
            List list = data;
            if (list == null || list.isEmpty()) {
                z = true;
            }
            if (!z) {
                GyroRoundedView gyroRoundedView = this$0.gyroView;
                Boolean result = gyroRoundedView != null ? Boolean.valueOf(gyroRoundedView.configWithGyro(((Number) size.getFirst()).intValue(), ((Number) size.getSecond()).intValue(), data, new GyroRoundedView.GyroViewCallBack() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$preloadShowCardView$1$result$1
                    public void notifyImgLoadSuc(boolean suc) {
                        String str;
                        DLCDrawCardView.this.loadGyroResult = true;
                        str = DLCDrawCardView.TAG;
                        BLog.d(str, "load success ? " + suc);
                    }

                    public void notifyGyroReport(float roll, float pitch, float yaw) {
                    }
                })) : null;
                BLog.d(TAG, "config gyro success ?" + result);
                return;
            }
            BLog.d(TAG, "config gyro failed data empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadShowCardView$lambda$0$1(DLCDrawCardView this$0) {
        BiliCardPlayerScene.CardPlayTask.Token token = this$0.mVideoToken;
        if (token != null) {
            token.pause();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadShowCardView$lambda$0$2(DLCDrawCardView this$0, boolean it) {
        if (!it) {
            this$0.showPlayFailedView();
        } else {
            BiliCardPlayerScene.CardPlayTask.Token token = this$0.mVideoToken;
            if (token != null) {
                token.resume();
            }
        }
        return Unit.INSTANCE;
    }

    private final void startShowCardView() {
        String actionContent;
        String badge;
        BiliDLCCardDisplayMark cornerMark;
        DLCItem dLCItem;
        BiliDLCCardItem cardItem;
        CardInfo cardInfo;
        WebCard webCard;
        DLCItem dLCItem2;
        BiliDLCCardItem cardItem2;
        CardInfo cardInfo2;
        WebCard webCard2;
        BiliDLCCardDisplayFrame frame;
        DLCItem dLCItem3;
        DLCItem dLCItem4;
        BiliDLCCardItem cardItem3;
        CardInfo cardInfo3;
        DLCItem dLCItem5;
        BiliDLCCardItem cardItem4;
        String name;
        GyroRoundedView gyroRoundedView;
        DLCItem dLCItem6;
        BiliDLCCardItem cardItem5;
        DLCItem dLCItem7;
        BiliDLCCardItem cardItem6;
        List<DLCItem> dlcItems = getDlcItems();
        CardTypeInfo currentCardTypeInfo = (dlcItems == null || (dLCItem7 = dlcItems.get(this.mCardIndex)) == null || (cardItem6 = dLCItem7.getCardItem()) == null) ? null : cardItem6.getCardTypeInfo();
        List<DLCItem> dlcItems2 = getDlcItems();
        CardInfo currentCardInfo = (dlcItems2 == null || (dLCItem6 = dlcItems2.get(this.mCardIndex)) == null || (cardItem5 = dLCItem6.getCardItem()) == null) ? null : cardItem5.getCardInfo();
        Integer materialType = currentCardTypeInfo != null ? Integer.valueOf(currentCardTypeInfo.getMaterialType()) : null;
        int type = NftType.IMAGE.getType();
        if (materialType != null && materialType.intValue() == type) {
            ViewGroup viewGroup = this.mCardVideoGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(4);
            }
            if (this.loadGyroResult && (gyroRoundedView = this.gyroView) != null) {
                gyroRoundedView.setVisibility(0);
            }
        } else {
            int type2 = NftType.VIDEO.getType();
            if (materialType != null && materialType.intValue() == type2) {
                GyroRoundedView gyroRoundedView2 = this.gyroView;
                if (gyroRoundedView2 != null) {
                    gyroRoundedView2.setVisibility(4);
                }
                ViewGroup viewGroup2 = this.mCardVideoGroup;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                }
                BLog.d(TAG, "startShowCardView view resume show");
                BiliCardPlayerScene.CardPlayTask.Token token = this.mVideoToken;
                if (token != null) {
                    token.resume();
                }
            }
        }
        renderCardLock(currentCardInfo, currentCardTypeInfo);
        DLCCardDrawModel dLCCardDrawModel = this.drawCardModel;
        boolean z = true;
        String indexLabel = "";
        if (dLCCardDrawModel != null && dLCCardDrawModel.getScreenType() == 0) {
            String name2 = currentCardTypeInfo != null ? currentCardTypeInfo.getName() : null;
            if (!(name2 == null || StringsKt.isBlank(name2))) {
                LinearLayout linearLayout = this.linInfoWrapper;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                TextView textView = this.tvCardName;
                if (textView != null) {
                    textView.setText((currentCardTypeInfo == null || (name = currentCardTypeInfo.getName()) == null) ? "" : name);
                }
            } else {
                LinearLayout linearLayout2 = this.linInfoWrapper;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
            }
        } else {
            LinearLayout linearLayout3 = this.linInfoWrapper;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        }
        List<DLCItem> dlcItems3 = getDlcItems();
        String cardCntShow = (dlcItems3 == null || (dLCItem5 = dlcItems3.get(this.mCardIndex)) == null || (cardItem4 = dLCItem5.getCardItem()) == null) ? null : cardItem4.getCardTypeCntShow();
        String cardNo = currentCardInfo != null ? currentCardInfo.getCardNo() : null;
        if (!(cardNo == null || StringsKt.isBlank(cardNo))) {
            String str = cardCntShow;
            if (str == null || StringsKt.isBlank(str)) {
                indexLabel = currentCardInfo != null ? currentCardInfo.getCardNo() : null;
            } else {
                indexLabel = (currentCardInfo != null ? currentCardInfo.getCardNo() : null) + "/" + cardCntShow;
            }
        }
        String str2 = indexLabel;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            TextView textView2 = this.tvCardIndex;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
                textView2 = null;
            }
            Typeface typeface = TypeFaceHelper.createFromAsset(textView2.getContext(), "digital_id_num.ttf");
            TextView textView3 = this.tvCardIndex;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
                textView3 = null;
            }
            textView3.setTypeface(typeface);
            TextView textView4 = this.tvCardIndex;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
                textView4 = null;
            }
            textView4.setVisibility(0);
            TextView textView5 = this.tvCardIndex;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
                textView5 = null;
            }
            textView5.setText(indexLabel);
            List<DLCItem> dlcItems4 = getDlcItems();
            CardNumberGradientColor cardIndexTextGradientColor = (dlcItems4 == null || (dLCItem4 = dlcItems4.get(this.mCardIndex)) == null || (cardItem3 = dLCItem4.getCardItem()) == null || (cardInfo3 = cardItem3.getCardInfo()) == null) ? null : cardInfo3.getCardNumberGradientColor();
            if (cardIndexTextGradientColor != null) {
                TextView textView6 = this.tvCardIndex;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
                    textView6 = null;
                }
                CardNumberColorUtilKt.setCardNumberGradientColor(textView6, cardIndexTextGradientColor);
            } else {
                TextView textView7 = this.tvCardIndex;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
                    textView7 = null;
                }
                textView7.setTextColor(-1);
            }
        } else {
            TextView textView8 = this.tvCardIndex;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvCardIndex");
                textView8 = null;
            }
            textView8.setVisibility(8);
        }
        List<DLCItem> dlcItems5 = getDlcItems();
        int totalCount = dlcItems5 != null ? dlcItems5.size() : 0;
        if (this.mCardIndex < totalCount - 1) {
            actionContent = "下一张 " + (this.mCardIndex + 1) + "/" + totalCount;
        } else {
            actionContent = "确认";
        }
        TextView textView9 = this.tvAction;
        if (textView9 != null) {
            textView9.setText(actionContent);
        }
        TextView textView10 = this.tvAction;
        if (textView10 != null) {
            textView10.setVisibility(0);
        }
        List<DLCItem> dlcItems6 = getDlcItems();
        BiliDLCCardDisplay disPlay = (dlcItems6 == null || (dLCItem3 = dlcItems6.get(this.mCardIndex)) == null) ? null : dLCItem3.getDisplay();
        String border = (disPlay == null || (frame = disPlay.getFrame()) == null) ? null : frame.getImg();
        String str3 = border;
        if (!(str3 == null || StringsKt.isBlank(str3)) && this.bivFrameBolder != null) {
            BiliImageView biliImageView = this.bivFrameBolder;
            Intrinsics.checkNotNull(biliImageView);
            biliImageView.setVisibility(0);
            ImageRequestBuilder url = BiliImageLoader.INSTANCE.with(ListExtentionsKt.lifecycle(this.context)).url(border);
            BiliImageView biliImageView2 = this.bivFrameBolder;
            Intrinsics.checkNotNull(biliImageView2);
            url.into(biliImageView2);
        } else {
            BiliImageView biliImageView3 = this.bivFrameBolder;
            if (biliImageView3 != null) {
                biliImageView3.setVisibility(8);
            }
        }
        List<DLCItem> dlcItems7 = getDlcItems();
        boolean hasSmeltingTutorialBtn = (dlcItems7 == null || (dLCItem2 = dlcItems7.get(this.mCardIndex)) == null || (cardItem2 = dLCItem2.getCardItem()) == null || (cardInfo2 = cardItem2.getCardInfo()) == null || (webCard2 = cardInfo2.getWebCard()) == null || !webCard2.isSmeltCard()) ? false : true;
        AppCompatImageView appCompatImageView = this.smeltingTutorialBtn;
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(hasSmeltingTutorialBtn ? 0 : 8);
        }
        List<DLCItem> dlcItems8 = getDlcItems();
        String smeltTagImage = (dlcItems8 == null || (dLCItem = dlcItems8.get(this.mCardIndex)) == null || (cardItem = dLCItem.getCardItem()) == null || (cardInfo = cardItem.getCardInfo()) == null || (webCard = cardInfo.getWebCard()) == null) ? null : webCard.getSmeltTag();
        if (smeltTagImage != null) {
            String str4 = smeltTagImage;
            if (StringsKt.isBlank(str4)) {
                str4 = (disPlay == null || (cornerMark = disPlay.getCornerMark()) == null) ? null : cornerMark.getImg();
            }
            badge = str4;
        } else {
            badge = null;
        }
        String str5 = badge;
        if (str5 != null && !StringsKt.isBlank(str5)) {
            z = false;
        }
        if (!z && this.bivBadge != null) {
            BiliImageView biliImageView4 = this.bivBadge;
            Intrinsics.checkNotNull(biliImageView4);
            biliImageView4.setVisibility(0);
            ImageRequestBuilder url2 = BiliImageLoader.INSTANCE.with(ListExtentionsKt.lifecycle(this.context)).useOrigin().url(badge);
            ScaleType scaleType = ScaleType.FIT_START;
            Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_START");
            ImageRequestBuilder actualImageScaleType = url2.actualImageScaleType(scaleType);
            BiliImageView biliImageView5 = this.bivBadge;
            Intrinsics.checkNotNull(biliImageView5);
            actualImageScaleType.into(biliImageView5);
            return;
        }
        BiliImageView biliImageView6 = this.bivBadge;
        if (biliImageView6 != null) {
            biliImageView6.setVisibility(8);
        }
    }

    private final void renderCardLock(CardInfo currentCardInfo, CardTypeInfo currentCardTypeInfo) {
        CardLockStatus it;
        View view = null;
        if (currentCardInfo != null && (it = currentCardInfo.getCardLockStatus()) != null) {
            DLCCardLockService dLCCardLockService = this.dlcCardLockService;
            ComposeView composeView = this.cardLockComposeView;
            if (composeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardLockComposeView");
                composeView = null;
            }
            DLCCardDrawModel dLCCardDrawModel = this.drawCardModel;
            DLCCardLockService.renderCardLock$default(dLCCardLockService, composeView, dLCCardDrawModel != null ? dLCCardDrawModel.getActId() : 0L, it, currentCardInfo.getId(), currentCardTypeInfo != null ? currentCardTypeInfo.getId() : 0L, currentCardInfo.getCardNo(), null, 64, null);
            return;
        }
        DLCDrawCardView $this$renderCardLock_u24lambda_u241 = this;
        View view2 = $this$renderCardLock_u24lambda_u241.cardLockComposeView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardLockComposeView");
        } else {
            view = view2;
        }
        View $this$isVisible$iv = view;
        $this$isVisible$iv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCardAnimMask(long totalDuration) {
        BiliImageView biliImageView = this.animMask;
        if (biliImageView != null) {
            biliImageView.setVisibility(0);
        }
        BiliImageView biliImageView2 = this.animMask;
        if (biliImageView2 != null) {
            biliImageView2.setAlpha(0.0f);
        }
        ValueAnimator $this$showCardAnimMask_u24lambda_u240 = ValueAnimator.ofFloat(0.0f, 1.0f);
        $this$showCardAnimMask_u24lambda_u240.setDuration(totalDuration);
        $this$showCardAnimMask_u24lambda_u240.setInterpolator(new DecelerateInterpolator());
        $this$showCardAnimMask_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DLCDrawCardView.showCardAnimMask$lambda$0$0(DLCDrawCardView.this, valueAnimator);
            }
        });
        $this$showCardAnimMask_u24lambda_u240.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCardAnimMask$lambda$0$0(DLCDrawCardView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BiliImageView biliImageView = this$0.animMask;
        if (biliImageView != null) {
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            biliImageView.setAlpha(((Float) animatedValue).floatValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void playUAMVideo$default(DLCDrawCardView dLCDrawCardView, UAMView uAMView, String str, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        dLCDrawCardView.playUAMVideo(uAMView, str, function0, function1);
    }

    private final void playUAMVideo(UAMView uamPlayer, String filePath, Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
        Context context = this.context;
        registerAnimListener(uamPlayer, function0, function1);
        if (uamPlayer != null) {
            uamPlayer.disableMusic();
        }
        if (uamPlayer != null) {
            uamPlayer.startPlay(filePath);
        }
    }

    private final Pair<Integer, Integer> compatCardSize(int width, int height) {
        if (width > 0 && height > 0) {
            double holderHeight = (this.mContainerHeight * 393.0d) / 812.0d;
            int holderWidth = (int) ((2 * holderHeight) / 3);
            int expectedHeight = (int) (holderWidth * ((height * 1.0f) / width));
            return new Pair<>(Integer.valueOf(holderWidth), Integer.valueOf(expectedHeight));
        }
        return new Pair<>(0, 0);
    }

    private final Pair<Integer, Integer> compatCardSizeHalfScreen(int width, int height) {
        if (width > 0 && height > 0) {
            double holderHeight = (this.mContainerHeight * 390.0d) / 568.0d;
            int holderWidth = (int) ((2 * holderHeight) / 3);
            int expectedHeight = (int) (holderWidth * ((height * 1.0f) / width));
            return new Pair<>(Integer.valueOf(holderWidth), Integer.valueOf(expectedHeight));
        }
        return new Pair<>(0, 0);
    }

    static /* synthetic */ void playVideo$default(DLCDrawCardView dLCDrawCardView, long j, Pair pair, List list, boolean z, Function0 function0, Function1 function1, int i, Object obj) {
        dLCDrawCardView.playVideo(j, pair, list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? null : function1);
    }

    private final void playVideo(long cardId, Pair<Integer, Integer> pair, List<String> list, boolean isMute, final Function0<Unit> function0, final Function1<? super Boolean, Unit> function1) {
        boolean z = false;
        if (list != null && list.isEmpty()) {
            z = true;
        }
        if (z) {
            return;
        }
        BLog.d(TAG, "play video " + list + ", isMute " + isMute);
        final Video.PlayableParams playParams = generatePlayableParams(cardId, list);
        ViewGroup videoContainer = this.mCardVideoGroup;
        if (videoContainer == null) {
            return;
        }
        ViewGroup.LayoutParams $this$playVideo_u24lambda_u240 = videoContainer.getLayoutParams();
        $this$playVideo_u24lambda_u240.width = ((Number) pair.getFirst()).intValue();
        $this$playVideo_u24lambda_u240.height = ((Number) pair.getSecond()).intValue();
        videoContainer.setLayoutParams($this$playVideo_u24lambda_u240);
        final Ref.BooleanRef firstResume = new Ref.BooleanRef();
        firstResume.element = true;
        this.mVideoTask = BiliCardPlayerScene.CardPlayTask.Companion.obtain().setMute(isMute).setContainer(videoContainer).addPlayableParams(playParams).setShowWhenFirstRender(true).forbiddenInnerTouchEvent(true).addPlayerStateChangedCallback(new ICardPlaySateChangedCallback() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$playVideo$2
            public /* synthetic */ void onPause(ICardPlayerContext iCardPlayerContext) {
                ICardPlaySateChangedCallback.-CC.$default$onPause(this, iCardPlayerContext);
            }

            public /* synthetic */ void onPrepared(ICardPlayerContext iCardPlayerContext) {
                ICardPlaySateChangedCallback.-CC.$default$onPrepared(this, iCardPlayerContext);
            }

            public /* synthetic */ void onPreparing(ICardPlayerContext iCardPlayerContext) {
                ICardPlaySateChangedCallback.-CC.$default$onPreparing(this, iCardPlayerContext);
            }

            public /* synthetic */ boolean onSourcePlayable(ICardPlayerContext iCardPlayerContext, MediaResource mediaResource) {
                return ICardPlaySateChangedCallback.-CC.$default$onSourcePlayable(this, iCardPlayerContext, mediaResource);
            }

            public /* synthetic */ void onStart(ICardPlayerContext iCardPlayerContext) {
                ICardPlaySateChangedCallback.-CC.$default$onStart(this, iCardPlayerContext);
            }

            public /* synthetic */ void onStop(ICardPlayerContext iCardPlayerContext) {
                ICardPlaySateChangedCallback.-CC.$default$onStop(this, iCardPlayerContext);
            }

            public void onResume(ICardPlayerContext context) {
                String str;
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onResume(this, context);
                str = DLCDrawCardView.TAG;
                BLog.d(str, "onResume " + playParams.id());
                if (firstResume.element) {
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    firstResume.element = false;
                }
            }

            public void onCompleted(ICardPlayerContext context) {
                String str;
                Intrinsics.checkNotNullParameter(context, "context");
                str = DLCDrawCardView.TAG;
                BLog.d(str, "onCompleted " + playParams.id());
                Function1<Boolean, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(true);
                }
            }

            public void onError(ICardPlayerContext context) {
                String str;
                Intrinsics.checkNotNullParameter(context, "context");
                str = DLCDrawCardView.TAG;
                BLog.d(str, "onError " + playParams.id());
                Function1<Boolean, Unit> function12 = function1;
                if (function12 != null) {
                    function12.invoke(false);
                }
            }
        });
        commitVideoTask();
    }

    private final Video.PlayableParams generatePlayableParams(long cardId, List<String> list) {
        return new DigitalCardVideoPlayParams(cardId, list, (Video.DisplayParams) null, 4, (DefaultConstructorMarker) null);
    }

    private final void commitVideoTask() {
        BiliCardPlayerScene.CardPlayTask it = this.mVideoTask;
        if (it != null) {
            BiliCardPlayerScene.CardPlayTask.Token $this$commitVideoTask_u24lambda_u240_u240 = BiliCardPlayerManager.INSTANCE.with(this.context).commit(it);
            $this$commitVideoTask_u24lambda_u240_u240.hideBufferingView();
            this.mVideoToken = $this$commitVideoTask_u24lambda_u240_u240;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void registerAnimListener$default(DLCDrawCardView dLCDrawCardView, UAMView uAMView, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        dLCDrawCardView.registerAnimListener(uAMView, function0, function1);
    }

    private final void registerAnimListener(UAMView uamPlayer, final Function0<Unit> function0, final Function1<? super Boolean, Unit> function1) {
        if (uamPlayer != null) {
            uamPlayer.setPlayListener(new SimpleUAMListener() { // from class: tv.danmaku.bili.ui.garb.nft.view.DLCDrawCardView$registerAnimListener$1
                @Override // tv.danmaku.bili.ui.garb.nft.helper.SimpleUAMListener
                public void onPlayStart() {
                    super.onPlayStart();
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }

                @Override // tv.danmaku.bili.ui.garb.nft.helper.SimpleUAMListener
                public void onPlayFinish() {
                    super.onPlayFinish();
                    Function1<Boolean, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(true);
                    }
                }

                @Override // tv.danmaku.bili.ui.garb.nft.helper.SimpleUAMListener
                public void onPlayFailed(int code, String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    super.onPlayFailed(code, message);
                    Function1<Boolean, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(false);
                    }
                }

                @Override // tv.danmaku.bili.ui.garb.nft.helper.SimpleUAMListener
                public void onBeforeRenderFailed(int code, String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    super.onBeforeRenderFailed(code, message);
                    Function1<Boolean, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(false);
                    }
                }
            });
        }
    }

    public final void resume() {
        UAMView uAMView;
        UAMView uAMView2;
        UAMView uAMView3 = this.mPreLoadUAMView;
        boolean z = true;
        if ((uAMView3 != null && uAMView3.getVisibility() == 0) && (uAMView2 = this.mPreLoadUAMView) != null) {
            uAMView2.onResume();
        }
        UAMView uAMView4 = this.mEntryUAMView;
        if (uAMView4 == null || uAMView4.getVisibility() != 0) {
            z = false;
        }
        if (z && (uAMView = this.mEntryUAMView) != null) {
            uAMView.onResume();
        }
        if (this.needResumeVideo) {
            BLog.i(TAG, "resume needResumeVideo");
            BiliCardPlayerScene.CardPlayTask.Token token = this.mVideoToken;
            if (token != null) {
                token.replay();
            }
            this.needResumeVideo = false;
        }
    }

    public final void pause() {
        BiliCardPlayerScene.CardPlayTask.Token token;
        UAMView uAMView;
        UAMView uAMView2;
        UAMView uAMView3 = this.mPreLoadUAMView;
        boolean z = false;
        if ((uAMView3 != null && uAMView3.getVisibility() == 0) && (uAMView2 = this.mPreLoadUAMView) != null) {
            uAMView2.onPause();
        }
        UAMView uAMView4 = this.mEntryUAMView;
        if ((uAMView4 != null && uAMView4.getVisibility() == 0) && (uAMView = this.mEntryUAMView) != null) {
            uAMView.onPause();
        }
        BLog.i(TAG, "pause " + (this.mVideoToken != null ? Integer.valueOf(token.getPlayerState()) : null));
        BiliCardPlayerScene.CardPlayTask.Token token2 = this.mVideoToken;
        if (token2 != null && token2.getPlayerState() == 4) {
            z = true;
        }
        if (z) {
            this.needResumeVideo = true;
            BiliCardPlayerScene.CardPlayTask.Token token3 = this.mVideoToken;
            if (token3 != null) {
                token3.pause();
            }
        }
    }

    private final void gotoDrawCardResult() {
        Function2<? super BillDLCRespInfo, ? super CardLockStatus, Unit> function2;
        BillDLCRespInfo it = this.respInfo;
        if (it == null || (function2 = this.goDrawResult) == null) {
            return;
        }
        function2.invoke(it, this.dlcCardLockService.getCardLockStatus());
    }

    public final void destroy() {
        CoroutineScopeKt.cancel$default(this.mainScope, (CancellationException) null, 1, (Object) null);
        GyroRoundedView gyroRoundedView = this.gyroView;
        if (gyroRoundedView != null) {
            gyroRoundedView.onDestroy();
        }
        BiliCardPlayerManager.INSTANCE.remove(this.context);
        SimpleUAMListener emptyListener = new SimpleUAMListener();
        UAMView uAMView = this.mEntryUAMView;
        if (uAMView != null) {
            uAMView.setPlayListener(emptyListener);
        }
        UAMView uAMView2 = this.mPreLoadUAMView;
        if (uAMView2 != null) {
            uAMView2.setPlayListener(emptyListener);
        }
        UAMView uAMView3 = this.mEntryUAMView;
        if (uAMView3 != null) {
            uAMView3.destroy();
        }
        UAMView uAMView4 = this.mPreLoadUAMView;
        if (uAMView4 != null) {
            uAMView4.destroy();
        }
        this.mPreLoadUAMView = null;
        this.mEntryUAMView = null;
    }

    /* compiled from: DLCDrawCardView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/view/DLCDrawCardView$Companion;", "", "<init>", "()V", "TAG", "", "CARD_GROUP_WIDTH", "", "CARD_GROUP_HEIGHT", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}