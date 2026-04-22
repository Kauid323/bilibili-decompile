package tv.danmaku.bili.ui.garb;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bili.digital.common.player.DigitalCardVideoPlayParams;
import com.bilibili.adcommon.utils.ADDownloadUtils;
import com.bilibili.app.authorspace.ui.nft.ui.activity.NftType;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.BiliContext;
import com.bilibili.bililive.uam.config.IUAMConfig;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.bililive.uam.view.UAMViewListener;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.okretro.BiliApiDataCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.filechooser.FileUtils;
import tv.danmaku.bili.ui.garb.api.BiliDrawCard;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.CardTypeInfo;
import tv.danmaku.bili.ui.garb.api.NftReporterHelper;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.video.bilicardplayer.BiliCardPlayerManager;
import tv.danmaku.video.bilicardplayer.ICardPlaySateChangedCallback;
import tv.danmaku.video.bilicardplayer.ICardPlayerContext;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: NftCardInfoGroup.kt */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u009c\u00012\u00020\u0001:\u0004\u009b\u0001\u009c\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010+\u001a\u00020\u001aJ\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u0004\u0018\u00010.J\u0006\u0010/\u001a\u00020\u001aJ\u0006\u00100\u001a\u00020\u001aJ\u0006\u00101\u001a\u00020\u0016J\u0018\u00102\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010\"J\u0006\u00103\u001a\u00020\tJ\u0006\u00104\u001a\u00020\u0016J\u000e\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\tJ\b\u0010e\u001a\u00020(H\u0016J\b\u0010f\u001a\u00020(H\u0002J\u0010\u0010g\u001a\u00020(2\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020(2\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010k\u001a\u00020(2\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010l\u001a\u00020(2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010m\u001a\u00020(2\u0006\u0010n\u001a\u00020oH\u0002J\u0010\u0010p\u001a\u00020(2\u0006\u0010n\u001a\u00020qH\u0002J\u001a\u0010r\u001a\u00020(2\u0010\b\u0002\u0010s\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010tH\u0002J\b\u0010u\u001a\u00020(H\u0002J\u0010\u0010v\u001a\u00020(2\u0006\u0010w\u001a\u00020\u0016H\u0002J\b\u0010x\u001a\u00020(H\u0002J\b\u0010y\u001a\u00020(H\u0002J\b\u0010z\u001a\u00020(H\u0002J\u0018\u0010{\u001a\u00020(2\u0006\u0010|\u001a\u00020:2\u0006\u0010}\u001a\u00020\tH\u0002J\u0010\u0010~\u001a\u00020(2\u0006\u0010|\u001a\u00020:H\u0002J\b\u0010\u007f\u001a\u00020(H\u0002J\u0012\u0010\u0080\u0001\u001a\u00020\u00162\u0007\u0010\u0081\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0082\u0001\u001a\u00020(H\u0002J\u0013\u0010\u0083\u0001\u001a\u00020(2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\u0013\u0010\u0086\u0001\u001a\u00020(2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\u0007\u0010\u0087\u0001\u001a\u00020(J\u0007\u0010\u0088\u0001\u001a\u00020(J\u0011\u0010\u0089\u0001\u001a\u00020(2\u0006\u0010n\u001a\u00020\u0007H\u0002J\u001d\u0010\u008a\u0001\u001a\u00020(2\u0007\u0010\u008b\u0001\u001a\u00020\t2\t\b\u0002\u0010\u008c\u0001\u001a\u00020\tH\u0002J\t\u0010\u008d\u0001\u001a\u00020(H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020(2\u0007\u0010\u008f\u0001\u001a\u00020\tH\u0002J\u001d\u0010\u0090\u0001\u001a\u00020(2\b\u0010\u0091\u0001\u001a\u00030\u0085\u00012\b\u0010\u0092\u0001\u001a\u00030\u0085\u0001H\u0002JC\u0010\u0093\u0001\u001a\u00020(2\u0007\u0010\u0094\u0001\u001a\u00020\u001a2\u0010\u0010\u0095\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0096\u00012\t\b\u0002\u0010\u0097\u0001\u001a\u00020\t2\b\u0010\u0091\u0001\u001a\u00030\u0085\u00012\b\u0010\u0092\u0001\u001a\u00030\u0085\u0001H\u0002J\t\u0010\u0098\u0001\u001a\u00020(H\u0002J%\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u001a2\u0010\u0010\u0095\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0096\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015j\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009d\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardInfoGroup;", "Ltv/danmaku/bili/ui/garb/NftCardCallback;", "mFragment", "Landroidx/fragment/app/Fragment;", "root", "Landroid/view/View;", "mFromType", "Ltv/danmaku/bili/ui/garb/NftCardFromType;", "mNeedShowMenu", "", "mOnCardItemChangeListener", "Ltv/danmaku/bili/ui/garb/NftCardInfoGroup$OnCardItemChangeListener;", "mJsbCallback", "Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Ltv/danmaku/bili/ui/garb/NftCardFromType;ZLtv/danmaku/bili/ui/garb/NftCardInfoGroup$OnCardItemChangeListener;Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;)V", "mContext", "Landroid/content/Context;", "mNftCardModel", "Ltv/danmaku/bili/ui/garb/NftCardModel;", "mResourceMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mLoadingAnimPath", "mMid", "", "mCurrentCardTypeId", "mCurrentCardId", "mCurrentAvatarUrl", "mCurrentCardHash", "mCurrentCardType", "Lcom/bilibili/app/authorspace/ui/nft/ui/activity/NftType;", "mCurrentLimitInfo", "Lkotlin/Pair;", "Ltv/danmaku/bili/ui/garb/api/CardRightShow;", "Ltv/danmaku/bili/ui/garb/api/CardRight;", "mNftCardBgLoader", "Ltv/danmaku/bili/ui/garb/NftCardBgLoader;", "init", "", "ctx", "nftCardModel", "mid", "initCardsBg", "getToken", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "getCurrentCardTypeId", "getCurrentCardId", "getCurrentCardAvatarUrl", "getLimitInfo", "isCurrentCardVideoType", "getCurrentCardHash", "showMenu", "visible", "mShowMenu", "mCardLoadSuccess", "mNewDrawCard", "Ltv/danmaku/bili/ui/garb/api/BiliDrawCard;", "mIsAppointPage", "mIsOvertime", "mHasDrawCardInScanPage", "mMenuBtn", "mCloseBtn", "mCardMenuButtonGroup", "mCardCommentTitleGroup", "mExchangeLabel", "mCardIndex", "Landroid/widget/TextView;", "mSoundSwitch", "Landroidx/appcompat/widget/AppCompatImageView;", "mVideoMuteState", "mCardList", "Ltv/danmaku/bili/ui/garb/NftCardRecyclerView;", "mFakeCardList", "mCardBottomGroup", "Landroid/view/ViewGroup;", "mCardBottomDrawButton", "mCardBottomDrawNumber", "mCardBottomShareButton", "mCardName", "mCardNameGroup", "mCardRatioGroup", "mCardRatio", "mCardRatioArrow", "mCardButtonGroup", "mCardVideoGroup", "mVideoTask", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "mVideoToken", "mCurrentPlayVideoUrl", "mNeedResumeVideoAfterAnim", "mCardMp4Player", "Lcom/bilibili/bililive/uam/view/UAMView;", "mCardMp4Player2", "mCardMp4Mask", "mCardMp4Mask2", "mIsPlayingLoadingAnim", "mIsPlayingShowAnim", "mStartLoadAnimTime", "mEndReqApiAnimTime", "onScrollStart", "hideVideo", "onScrollEnd", "cardInfo", "Ltv/danmaku/bili/ui/garb/NftCardData;", "onCardLoadSuccess", "showCardInfo", "showCard", "showCardBg", "type", "Ltv/danmaku/bili/ui/garb/NftCardLayoutType;", "updateUIWithType", "Ltv/danmaku/bili/ui/garb/NftCardPageType;", "playLoadingAnim", "onComplete", "Lkotlin/Function0;", "showMask", "playShowCardAnim", "scarcity", "dealType", "drawCard", "loadDrawCardApi", "delayShowCardAnim", "data", "fromApiCallback", "showCardAnim", "dealAnimResources", "convertKeyToFile", "url", "toShare", "toHolderList", "buttonType", "", "reportButtonClick", "hideMask", "hideAndEndAnim", "registerButtonListener", "loadAnimFailed", "overtime", "animFailed", "registerAnimListener", "switchVideoSound", "mute", "compatVideoLayout", "width", "height", "playVideo", "cardId", "videoList", "", "isMute", "commitVideoTask", "generatePlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "OnCardItemChangeListener", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardInfoGroup implements NftCardCallback {
    public static final long MIN_PLAY_LOADING_ANIM = 3000;
    public static final String RESOURCES_DIR_PATH = "/earn/animation/";
    public static final String TAG = "NftCardDialog";
    public static final float VIDEO_GROUP_DEFAULT_HEIGHT = 393.0f;
    private final TextView mCardBottomDrawButton;
    private final TextView mCardBottomDrawNumber;
    private final ViewGroup mCardBottomGroup;
    private final View mCardBottomShareButton;
    private final ViewGroup mCardButtonGroup;
    private final View mCardCommentTitleGroup;
    private final TextView mCardIndex;
    private final NftCardRecyclerView mCardList;
    private boolean mCardLoadSuccess;
    private final View mCardMenuButtonGroup;
    private final View mCardMp4Mask;
    private final View mCardMp4Mask2;
    private final UAMView mCardMp4Player;
    private final UAMView mCardMp4Player2;
    private final TextView mCardName;
    private final ViewGroup mCardNameGroup;
    private final TextView mCardRatio;
    private final View mCardRatioArrow;
    private final ViewGroup mCardRatioGroup;
    private final ViewGroup mCardVideoGroup;
    private final View mCloseBtn;
    private Context mContext;
    private String mCurrentAvatarUrl;
    private String mCurrentCardHash;
    private long mCurrentCardId;
    private NftType mCurrentCardType;
    private long mCurrentCardTypeId;
    private Pair<CardRightShow, CardRight> mCurrentLimitInfo;
    private String mCurrentPlayVideoUrl;
    private long mEndReqApiAnimTime;
    private final View mExchangeLabel;
    private final View mFakeCardList;
    private final Fragment mFragment;
    private final NftCardFromType mFromType;
    private boolean mHasDrawCardInScanPage;
    private boolean mIsAppointPage;
    private boolean mIsOvertime;
    private boolean mIsPlayingLoadingAnim;
    private boolean mIsPlayingShowAnim;
    private final NftCardJsbCallback mJsbCallback;
    private String mLoadingAnimPath;
    private final View mMenuBtn;
    private long mMid;
    private boolean mNeedResumeVideoAfterAnim;
    private final boolean mNeedShowMenu;
    private BiliDrawCard mNewDrawCard;
    private final NftCardBgLoader mNftCardBgLoader;
    private NftCardModel mNftCardModel;
    private final OnCardItemChangeListener mOnCardItemChangeListener;
    private final HashMap<String, String> mResourceMap;
    private boolean mShowMenu;
    private final AppCompatImageView mSoundSwitch;
    private long mStartLoadAnimTime;
    private boolean mVideoMuteState;
    private BiliCardPlayerScene.CardPlayTask mVideoTask;
    private BiliCardPlayerScene.CardPlayTask.Token mVideoToken;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NftCardInfoGroup.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardInfoGroup$OnCardItemChangeListener;", "", "onItemChanged", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface OnCardItemChangeListener {
        void onItemChanged();
    }

    /* compiled from: NftCardInfoGroup.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NftCardFromType.values().length];
            try {
                iArr[NftCardFromType.EXCHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NftCardFromType.TASK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NftCardFromType.SEE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NftCardFromType.DRAW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NftCardFromType.SCAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NftCardFromType.COMMENT_BG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NftCardPageType.values().length];
            try {
                iArr2[NftCardPageType.APPOINTMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[NftCardPageType.OBTAINED.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[NftCardPageType.EXCHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr2[NftCardPageType.NOT_OBTAINED.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr2[NftCardPageType.DRAW_RESULT.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr2[NftCardPageType.SCAN.ordinal()] = 6;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr2[NftCardPageType.EXCHANGE_RESULT.ordinal()] = 7;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr2[NftCardPageType.DRAGON_OBTAINED.ordinal()] = 8;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr2[NftCardPageType.DRAGON_NOT_OBTAINED.ordinal()] = 9;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr2[NftCardPageType.COMMENT_BG.ordinal()] = 10;
            } catch (NoSuchFieldError e16) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public NftCardInfoGroup(Fragment mFragment, View root, NftCardFromType mFromType, boolean mNeedShowMenu, OnCardItemChangeListener mOnCardItemChangeListener, NftCardJsbCallback mJsbCallback) {
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(mFromType, "mFromType");
        this.mFragment = mFragment;
        this.mFromType = mFromType;
        this.mNeedShowMenu = mNeedShowMenu;
        this.mOnCardItemChangeListener = mOnCardItemChangeListener;
        this.mJsbCallback = mJsbCallback;
        this.mResourceMap = new HashMap<>();
        this.mCurrentAvatarUrl = "";
        this.mCurrentCardHash = "";
        this.mCurrentCardType = NftType.IMAGE;
        this.mNftCardBgLoader = new NftCardBgLoader(root);
        View findViewById = root.findViewById(R.id.nft_card_top_menu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mMenuBtn = findViewById;
        View findViewById2 = root.findViewById(R.id.nft_card_bottom_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mCloseBtn = findViewById2;
        View findViewById3 = root.findViewById(R.id.nft_card_menu_list);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mCardMenuButtonGroup = findViewById3;
        View findViewById4 = root.findViewById(R.id.nft_card_comment_group);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mCardCommentTitleGroup = findViewById4;
        View findViewById5 = root.findViewById(R.id.nft_card_exchange_label);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mExchangeLabel = findViewById5;
        View findViewById6 = root.findViewById(R.id.nft_card_top_index);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.mCardIndex = (TextView) findViewById6;
        AppCompatImageView findViewById7 = root.findViewById(R.id.nft_card_sound_switch);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.mSoundSwitch = findViewById7;
        this.mCardList = new NftCardRecyclerView();
        View findViewById8 = root.findViewById(R.id.nft_card_fake_view);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.mFakeCardList = findViewById8;
        View findViewById9 = root.findViewById(R.id.nft_card_bottom_group);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.mCardBottomGroup = (ViewGroup) findViewById9;
        View findViewById10 = root.findViewById(R.id.nft_card_bottom_draw);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.mCardBottomDrawButton = (TextView) findViewById10;
        View findViewById11 = root.findViewById(R.id.nft_card_bottom_draw_number);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.mCardBottomDrawNumber = (TextView) findViewById11;
        View findViewById12 = root.findViewById(R.id.nft_card_bottom_share);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.mCardBottomShareButton = findViewById12;
        View findViewById13 = root.findViewById(R.id.nft_card_bottom_name);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.mCardName = (TextView) findViewById13;
        View findViewById14 = root.findViewById(R.id.nft_card_name_group);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.mCardNameGroup = (ViewGroup) findViewById14;
        View findViewById15 = root.findViewById(R.id.nft_card_bottom_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.mCardRatioGroup = (ViewGroup) findViewById15;
        View findViewById16 = root.findViewById(R.id.nft_card_bottom_ratio);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.mCardRatio = (TextView) findViewById16;
        View findViewById17 = root.findViewById(R.id.nft_card_bottom_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.mCardRatioArrow = findViewById17;
        View findViewById18 = root.findViewById(R.id.nft_card_bottom_button_group);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        this.mCardButtonGroup = (ViewGroup) findViewById18;
        View findViewById19 = root.findViewById(R.id.nft_card_video);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        this.mCardVideoGroup = (ViewGroup) findViewById19;
        this.mCurrentPlayVideoUrl = "";
        UAMView findViewById20 = root.findViewById(R.id.nft_card_mp4_player);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.mCardMp4Player = findViewById20;
        UAMView findViewById21 = root.findViewById(R.id.nft_card_mp4_player_2);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "findViewById(...)");
        this.mCardMp4Player2 = findViewById21;
        View findViewById22 = root.findViewById(R.id.nft_card_anim_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "findViewById(...)");
        this.mCardMp4Mask = findViewById22;
        View findViewById23 = root.findViewById(R.id.nft_card_anim_mask_2);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "findViewById(...)");
        this.mCardMp4Mask2 = findViewById23;
    }

    public /* synthetic */ NftCardInfoGroup(Fragment fragment, View view, NftCardFromType nftCardFromType, boolean z, OnCardItemChangeListener onCardItemChangeListener, NftCardJsbCallback nftCardJsbCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, view, nftCardFromType, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : onCardItemChangeListener, (i & 32) != 0 ? null : nftCardJsbCallback);
    }

    public static /* synthetic */ void init$default(NftCardInfoGroup nftCardInfoGroup, Context context, View view, NftCardModel nftCardModel, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        nftCardInfoGroup.init(context, view, nftCardModel, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0.getBooked() == true) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void init(Context ctx, View root, NftCardModel nftCardModel, long mid) {
        boolean z;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(root, "root");
        this.mContext = ctx;
        this.mNftCardModel = nftCardModel;
        this.mMid = mid;
        NftCardModel nftCardModel2 = this.mNftCardModel;
        if (nftCardModel2 != null) {
            z = true;
        }
        z = false;
        this.mIsAppointPage = z;
        NftCardModel nftCardModel3 = this.mNftCardModel;
        this.mIsOvertime = nftCardModel3 != null ? nftCardModel3.getOvertime() : false;
        initCardsBg();
        NftCardRecyclerView nftCardRecyclerView = this.mCardList;
        NftCardInfoGroup nftCardInfoGroup = this;
        NftCardFromType nftCardFromType = this.mFromType;
        NftCardModel nftCardModel4 = this.mNftCardModel;
        nftCardRecyclerView.init(root, ctx, nftCardInfoGroup, nftCardFromType, nftCardModel4 != null ? nftCardModel4.getActId() : 0);
        registerButtonListener(this.mFromType);
        dealAnimResources();
        registerAnimListener();
        dealType();
    }

    private final void initCardsBg() {
        NftCardBgLoader nftCardBgLoader = this.mNftCardBgLoader;
        NftCardModel nftCardModel = this.mNftCardModel;
        String hCardLightUrl = nftCardModel != null ? nftCardModel.getHCardLightUrl() : null;
        NftCardModel nftCardModel2 = this.mNftCardModel;
        String hCardShadowUrl = nftCardModel2 != null ? nftCardModel2.getHCardShadowUrl() : null;
        NftCardModel nftCardModel3 = this.mNftCardModel;
        String vCardLightUrl = nftCardModel3 != null ? nftCardModel3.getVCardLightUrl() : null;
        NftCardModel nftCardModel4 = this.mNftCardModel;
        nftCardBgLoader.init(hCardLightUrl, hCardShadowUrl, vCardLightUrl, nftCardModel4 != null ? nftCardModel4.getVCardShadowUrl() : null);
    }

    public final BiliCardPlayerScene.CardPlayTask.Token getToken() {
        return this.mVideoToken;
    }

    public final long getCurrentCardTypeId() {
        return this.mCurrentCardTypeId;
    }

    public final long getCurrentCardId() {
        return this.mCurrentCardId;
    }

    public final String getCurrentCardAvatarUrl() {
        return this.mCurrentAvatarUrl;
    }

    public final Pair<CardRightShow, CardRight> getLimitInfo() {
        return this.mCurrentLimitInfo;
    }

    public final boolean isCurrentCardVideoType() {
        return this.mCurrentCardType == NftType.VIDEO;
    }

    public final String getCurrentCardHash() {
        return this.mCurrentCardHash;
    }

    public final void showMenu(boolean visible) {
        if (!this.mNeedShowMenu) {
            return;
        }
        this.mShowMenu = visible;
        if (visible) {
            ListExtentionsKt.visible(this.mCardMenuButtonGroup);
            ListExtentionsKt.visible(this.mFakeCardList);
            return;
        }
        ListExtentionsKt.gone(this.mFakeCardList);
        ListExtentionsKt.gone(this.mCardMenuButtonGroup);
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardCallback
    public void onScrollStart() {
        hideVideo();
        showMenu(false);
    }

    private final void hideVideo() {
        ListExtentionsKt.invisible(this.mCardVideoGroup);
        BiliCardPlayerScene.CardPlayTask.Token token = this.mVideoToken;
        if (token != null) {
            token.setMute(true);
        }
        this.mSoundSwitch.setVisibility(8);
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardCallback
    public void onScrollEnd(NftCardData cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        BLog.d("NftCardDialog", "onScroll END " + cardInfo.getIndex());
        showCard(cardInfo);
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardCallback
    public void onCardLoadSuccess(NftCardData cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        BLog.d("NftCardDialog", "card img load suc " + cardInfo.getIndex());
    }

    @Override // tv.danmaku.bili.ui.garb.NftCardCallback
    public void showCardInfo(NftCardData cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        String index = cardInfo.getIndex();
        BLog.d("NftCardDialog", "showCardInfo END " + index + ", type " + cardInfo.getType());
        showCard(cardInfo);
    }

    private final void showCard(NftCardData cardInfo) {
        String indexLabel;
        if (!TextUtils.isEmpty(cardInfo.getIndex())) {
            if (this.mIsOvertime) {
                indexLabel = cardInfo.getIndex() + "/" + cardInfo.getTotalCount();
            } else {
                indexLabel = cardInfo.getIndex();
            }
        } else {
            indexLabel = "";
        }
        this.mCardIndex.setText(indexLabel);
        this.mCardName.setText(cardInfo.getName());
        if (cardInfo.getRatio() <= 0.0f) {
            this.mCardRatio.setText("查看持有人");
            if (!cardInfo.getHasGained()) {
                this.mCardRatioGroup.setVisibility(4);
            } else {
                this.mCardRatioGroup.setVisibility(0);
            }
        } else {
            String ratio = "稀有度" + cardInfo.getRatio() + "%";
            this.mCardRatio.setText(ratio);
            this.mCardRatioGroup.setVisibility(0);
        }
        if (cardInfo.getHasExchanged()) {
            this.mExchangeLabel.setVisibility(0);
        } else {
            this.mExchangeLabel.setVisibility(8);
        }
        NftCardLayoutType type = (cardInfo.getWidth() <= 0 || cardInfo.getHeight() <= 0 || cardInfo.getWidth() <= cardInfo.getHeight()) ? NftCardLayoutType.Vertical : NftCardLayoutType.Horizontal;
        showCardBg(type);
        this.mCurrentCardTypeId = cardInfo.getCardTypeId();
        this.mCurrentCardId = cardInfo.getCardId();
        this.mCurrentAvatarUrl = cardInfo.getImgUrl();
        this.mCurrentCardHash = cardInfo.getHashCode();
        this.mCurrentCardType = cardInfo.getType();
        this.mCurrentLimitInfo = new Pair<>(cardInfo.getCardRightShow(), cardInfo.getCardRight());
        OnCardItemChangeListener onCardItemChangeListener = this.mOnCardItemChangeListener;
        if (onCardItemChangeListener != null) {
            onCardItemChangeListener.onItemChanged();
        }
        if (cardInfo.getType() == NftType.VIDEO && cardInfo.getHasGained()) {
            playVideo(cardInfo.getCardId(), cardInfo.getVideoList(), cardInfo.getSilence(), cardInfo.getWidth(), cardInfo.getHeight());
            if (!cardInfo.getSilence()) {
                this.mSoundSwitch.setVisibility(0);
            }
        } else {
            this.mNeedResumeVideoAfterAnim = false;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.mFromType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (this.mIsAppointPage) {
                    updateUIWithType(NftCardPageType.APPOINTMENT);
                    return;
                } else if (cardInfo.getHasGained()) {
                    updateUIWithType(NftCardPageType.OBTAINED);
                    this.mCardRatioArrow.setVisibility(0);
                    return;
                } else {
                    updateUIWithType(NftCardPageType.NOT_OBTAINED);
                    this.mCardRatioArrow.setVisibility(8);
                    return;
                }
            case 4:
                updateUIWithType(NftCardPageType.DRAW_RESULT);
                return;
            case 5:
                if (this.mHasDrawCardInScanPage) {
                    updateUIWithType(NftCardPageType.DRAW_RESULT);
                    return;
                } else {
                    updateUIWithType(NftCardPageType.SCAN);
                    return;
                }
            case 6:
                updateUIWithType(NftCardPageType.COMMENT_BG);
                return;
            default:
                return;
        }
    }

    private final void showCardBg(NftCardLayoutType type) {
        this.mNftCardBgLoader.showBg(type);
    }

    private final void updateUIWithType(NftCardPageType type) {
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
            case 1:
                this.mMenuBtn.setVisibility(8);
                this.mCardBottomGroup.setVisibility(0);
                this.mCardNameGroup.setVisibility(0);
                this.mCardRatioGroup.setVisibility(8);
                this.mCardButtonGroup.setVisibility(8);
                this.mCardCommentTitleGroup.setVisibility(8);
                return;
            case 2:
                if (this.mNeedShowMenu) {
                    this.mMenuBtn.setVisibility(0);
                }
                this.mCardBottomShareButton.setVisibility(8);
                this.mCardBottomDrawButton.setText("立即分享");
                this.mCardBottomDrawButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardInfoGroup.this.toShare();
                    }
                });
                this.mCardBottomGroup.setVisibility(0);
                this.mCardCommentTitleGroup.setVisibility(8);
                return;
            case 3:
                if (this.mNeedShowMenu) {
                    this.mMenuBtn.setVisibility(0);
                }
                this.mCardBottomShareButton.setVisibility(8);
                this.mCardBottomDrawButton.setText("立即分享");
                this.mCardBottomDrawButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardInfoGroup.this.toShare();
                    }
                });
                this.mCardBottomGroup.setVisibility(0);
                this.mCardCommentTitleGroup.setVisibility(8);
                return;
            case 4:
                this.mMenuBtn.setVisibility(8);
                this.mCardBottomDrawButton.setText("查看持有人");
                this.mCardBottomDrawButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardInfoGroup.this.toHolderList(3);
                    }
                });
                this.mCardBottomGroup.setVisibility(0);
                this.mCardBottomShareButton.setVisibility(8);
                this.mCardCommentTitleGroup.setVisibility(8);
                return;
            case 5:
                if (this.mNeedShowMenu) {
                    this.mMenuBtn.setVisibility(0);
                }
                this.mCardBottomGroup.setVisibility(0);
                this.mCardCommentTitleGroup.setVisibility(8);
                NftCardModel nftCardModel = this.mNftCardModel;
                int drawCount = nftCardModel != null ? nftCardModel.getDrawCount() : 0;
                if (drawCount > 0) {
                    this.mCardBottomDrawNumber.setText(String.valueOf(drawCount));
                    this.mCardBottomDrawNumber.setVisibility(0);
                    this.mCardBottomDrawButton.setVisibility(0);
                    this.mCardBottomShareButton.setVisibility(0);
                    this.mCardBottomDrawButton.setText("再开一张");
                    return;
                }
                NftCardModel nftCardModel2 = this.mNftCardModel;
                if (nftCardModel2 == null || nftCardModel2.getNotOnSale() != 1) {
                    z = false;
                }
                if (z) {
                    this.mCardBottomDrawNumber.setVisibility(8);
                    this.mCardBottomDrawButton.setVisibility(0);
                    this.mCardBottomShareButton.setVisibility(8);
                    this.mCardBottomDrawButton.setText("立即分享");
                    this.mCardBottomDrawButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda9
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NftCardInfoGroup.this.toShare();
                        }
                    });
                    return;
                }
                this.mCardBottomDrawNumber.setVisibility(8);
                this.mCardBottomDrawButton.setVisibility(0);
                this.mCardBottomShareButton.setVisibility(0);
                this.mCardBottomDrawButton.setText("增加次数");
                return;
            case 6:
                this.mMenuBtn.setVisibility(8);
                NftCardModel nftCardModel3 = this.mNftCardModel;
                int drawCount2 = nftCardModel3 != null ? nftCardModel3.getDrawCount() : 0;
                this.mCardBottomShareButton.setVisibility(8);
                this.mCardCommentTitleGroup.setVisibility(8);
                if (drawCount2 <= 0) {
                    NftCardModel nftCardModel4 = this.mNftCardModel;
                    if (nftCardModel4 == null || nftCardModel4.getNotOnSale() != 1) {
                        z = false;
                    }
                    if (z) {
                        this.mCardBottomDrawNumber.setVisibility(8);
                        this.mCardBottomDrawButton.setVisibility(8);
                        this.mCardRatioArrow.setVisibility(8);
                        return;
                    }
                }
                this.mCardBottomDrawButton.setText("我也要开");
                this.mCardBottomGroup.setVisibility(0);
                this.mCardRatioArrow.setVisibility(0);
                this.mCardBottomDrawButton.setVisibility(0);
                return;
            case 7:
            case 8:
                if (this.mNeedShowMenu) {
                    this.mMenuBtn.setVisibility(0);
                }
                this.mCardBottomDrawButton.setText("立即分享");
                this.mCardBottomGroup.setVisibility(0);
                this.mCardBottomShareButton.setVisibility(8);
                this.mCardCommentTitleGroup.setVisibility(8);
                return;
            case 9:
                this.mMenuBtn.setVisibility(8);
                this.mCardBottomDrawButton.setText("查看持有人");
                this.mCardBottomGroup.setVisibility(0);
                this.mCardBottomShareButton.setVisibility(8);
                this.mCardRatioGroup.setVisibility(8);
                this.mCardCommentTitleGroup.setVisibility(8);
                return;
            case 10:
                this.mCardCommentTitleGroup.setVisibility(0);
                this.mMenuBtn.setVisibility(8);
                this.mCardBottomDrawButton.setText("选择");
                this.mCardBottomGroup.setVisibility(0);
                this.mCardBottomShareButton.setVisibility(8);
                this.mCardRatioGroup.setVisibility(8);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void playLoadingAnim$default(NftCardInfoGroup nftCardInfoGroup, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        nftCardInfoGroup.playLoadingAnim(function0);
    }

    private final void playLoadingAnim(Function0<Unit> function0) {
        String loadCardAnimPath = this.mLoadingAnimPath;
        if (TextUtils.isEmpty(loadCardAnimPath)) {
            BLog.w("NftCardDialog", "play anim failed, cause res not ready");
            return;
        }
        Intrinsics.checkNotNull(loadCardAnimPath);
        if (!new File(loadCardAnimPath).exists()) {
            BLog.w("NftCardDialog", "anim path not exists");
        }
        if (this.mIsPlayingLoadingAnim) {
            BLog.w("NftCardDialog", "already playing anim");
            return;
        }
        showMask();
        this.mCardMp4Player.setVisibility(0);
        float alpha = this.mCardMp4Mask.getAlpha();
        View $this$isVisible$iv = this.mCardMp4Mask;
        boolean z = $this$isVisible$iv.getVisibility() == 0;
        View $this$isVisible$iv2 = this.mCardMp4Mask2;
        BLog.i("NftCardDialog", "playLoadingAnim path: " + loadCardAnimPath + ", alpha " + alpha + ", visible " + z + " " + ($this$isVisible$iv2.getVisibility() == 0));
        this.mIsPlayingLoadingAnim = true;
        this.mCardMp4Player.startPlay(loadCardAnimPath);
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void showMask() {
        this.mCardMp4Mask.setAlpha(1.0f);
        this.mCardMp4Mask2.setVisibility(0);
    }

    private final void playShowCardAnim(String scarcity) {
        String filePath = this.mResourceMap.get(scarcity);
        if (filePath != null) {
            if (filePath.length() > 0) {
                BLog.i("NftCardDialog", "play show card anim, path " + filePath);
                this.mIsPlayingShowAnim = true;
                this.mCardMp4Player2.setVisibility(0);
                this.mCardMp4Player2.startPlay(filePath);
                return;
            }
        }
        BLog.w("NftCardDialog", "anim file not ready, type " + scarcity);
    }

    private final void dealType() {
        NftCardModel nftCardModel;
        ArrayList it;
        BLog.d("NftCardDialog", "deal Type " + this.mFromType.getType());
        if (this.mFromType != NftCardFromType.DRAW && (nftCardModel = this.mNftCardModel) != null && (it = nftCardModel.getCardList()) != null) {
            NftCardModel nftCardModel2 = this.mNftCardModel;
            int jumpId = nftCardModel2 != null ? nftCardModel2.getJumpId() : 0;
            if (it.size() > jumpId && it.get(jumpId) != null) {
                NftCardDetailModel nftCardDetailModel = it.get(jumpId);
                this.mCurrentCardTypeId = nftCardDetailModel != null ? nftCardDetailModel.getCardTypeId() : 0L;
            }
            this.mCardList.updateCardData(it, jumpId);
            this.mCardList.show();
            ListExtentionsKt.visible(this.mCloseBtn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawCard() {
        playLoadingAnim(new Function0() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda10
            public final Object invoke() {
                Unit drawCard$lambda$0;
                drawCard$lambda$0 = NftCardInfoGroup.drawCard$lambda$0(NftCardInfoGroup.this);
                return drawCard$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawCard$lambda$0(NftCardInfoGroup this$0) {
        this$0.hideVideo();
        this$0.loadDrawCardApi();
        return Unit.INSTANCE;
    }

    private final void loadDrawCardApi() {
        NftCardModel nftCardModel = this.mNftCardModel;
        Integer actionId = nftCardModel != null ? Integer.valueOf(nftCardModel.getActId()) : null;
        if (actionId != null) {
            this.mNewDrawCard = null;
            this.mStartLoadAnimTime = 0L;
            this.mEndReqApiAnimTime = 0L;
            long mid = BiliAccounts.get(BiliContext.application()).mid();
            NftCardModel nftCardModel2 = this.mNftCardModel;
            BLog.i("NftCardDialog", "load draw card api " + mid + ", atcId " + actionId + ", roundId " + (nftCardModel2 != null ? Integer.valueOf(nftCardModel2.getRoundId()) : null));
            this.mCardLoadSuccess = false;
            this.mCardList.scrollToLeft();
            BiliNftApiManager biliNftApiManager = BiliNftApiManager.INSTANCE;
            int intValue = actionId.intValue();
            NftCardModel nftCardModel3 = this.mNftCardModel;
            biliNftApiManager.loadDrawCard(intValue, mid, nftCardModel3 != null ? Integer.valueOf(nftCardModel3.getRoundId()) : null, new BiliApiDataCallback<BiliDrawCard>() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$loadDrawCardApi$1
                public void onError(Throwable t) {
                    View view;
                    View view2;
                    View view3;
                    Context context;
                    NftCardInfoGroup.this.mCardLoadSuccess = false;
                    if (!TextUtils.isEmpty(t != null ? t.getMessage() : null)) {
                        context = NftCardInfoGroup.this.mContext;
                        ToastHelper.showToastShort(context, t != null ? t.getMessage() : null);
                    }
                    view = NftCardInfoGroup.this.mCardMp4Mask;
                    view.setAlpha(0.0f);
                    view2 = NftCardInfoGroup.this.mCardMp4Mask2;
                    view2.setVisibility(8);
                    view3 = NftCardInfoGroup.this.mCloseBtn;
                    view3.setVisibility(0);
                    BLog.w("NftCardDialog", "draw card api failed, hide mask");
                }

                public void onDataSuccess(BiliDrawCard data) {
                    if (data == null || data.getErrCode() != 0) {
                        onError(new Exception(data != null ? data.getErrMessage() : null));
                        return;
                    }
                    CardTypeInfo cardTypeInfo = data.getCardTypeInfo();
                    BLog.i("NftCardDialog", "drawCard api suc " + (cardTypeInfo != null ? Integer.valueOf(cardTypeInfo.getMaterialType()) : null) + " req " + data.getNeedRequest());
                    NftCardInfoGroup.this.mCardLoadSuccess = true;
                    NftCardInfoGroup.this.mNewDrawCard = data;
                    NftCardInfoGroup.this.mEndReqApiAnimTime = System.currentTimeMillis();
                    NftCardInfoGroup.this.delayShowCardAnim(data, true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void delayShowCardAnim(final BiliDrawCard data, boolean fromApiCallback) {
        if (fromApiCallback) {
            BLog.i("NftCardDialog", "load api suc, hhh, " + this.mEndReqApiAnimTime);
            if (this.mStartLoadAnimTime != 0) {
                if (this.mEndReqApiAnimTime - this.mStartLoadAnimTime > 3000) {
                    showCardAnim(data);
                    return;
                } else {
                    HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda11
                        @Override // java.lang.Runnable
                        public final void run() {
                            NftCardInfoGroup.this.showCardAnim(data);
                        }
                    }, 3000 - (this.mEndReqApiAnimTime - this.mStartLoadAnimTime));
                    return;
                }
            }
            return;
        }
        BLog.i("NftCardDialog", "start play loading anim, hhh, " + this.mStartLoadAnimTime);
        if (this.mEndReqApiAnimTime != 0) {
            if (this.mStartLoadAnimTime - this.mEndReqApiAnimTime > 3000) {
                showCardAnim(data);
            } else {
                HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        NftCardInfoGroup.this.showCardAnim(data);
                    }
                }, 3000 - (this.mStartLoadAnimTime - this.mEndReqApiAnimTime));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCardAnim(BiliDrawCard data) {
        this.mCurrentCardTypeId = data.getCardTypeId();
        NftCardModel nftCardModel = this.mNftCardModel;
        if (nftCardModel != null) {
            nftCardModel.setDrawCount(data.getLeftChance());
        }
        CardTypeInfo cardTypeInfo = data.getCardTypeInfo();
        String scarcity = (cardTypeInfo == null || (scarcity = String.valueOf(cardTypeInfo.getScarcity())) == null) ? "" : "";
        playShowCardAnim(scarcity);
        this.mCardList.updateData(new NftCardData(data));
        this.mCardList.show();
        ListExtentionsKt.visible(this.mCloseBtn);
    }

    private final void dealAnimResources() {
        HashMap<String, String> animationResultUrl;
        Iterable keySet;
        HashMap<String, String> animationResultUrl2;
        NftCardModel nftCardModel = this.mNftCardModel;
        String loadingAnimUrl = nftCardModel != null ? nftCardModel.getAnimationDrawUrl() : null;
        if (loadingAnimUrl != null) {
            if (loadingAnimUrl.length() > 0) {
                this.mLoadingAnimPath = convertKeyToFile(loadingAnimUrl);
                BLog.i("NftCardDialog", "draw card local path: " + this.mLoadingAnimPath);
            }
        }
        NftCardModel nftCardModel2 = this.mNftCardModel;
        if (nftCardModel2 == null || (animationResultUrl = nftCardModel2.getAnimationResultUrl()) == null || (keySet = animationResultUrl.keySet()) == null) {
            return;
        }
        Iterable $this$forEach$iv = keySet;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            NftCardModel nftCardModel3 = this.mNftCardModel;
            String value = (nftCardModel3 == null || (animationResultUrl2 = nftCardModel3.getAnimationResultUrl()) == null) ? null : animationResultUrl2.get(it);
            if (value != null) {
                if (value.length() > 0) {
                    this.mResourceMap.put(it, convertKeyToFile(value));
                }
            }
        }
    }

    private final String convertKeyToFile(String url) {
        File filesDir;
        Application application = BiliContext.application();
        String finalDir = ((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + "/earn/animation/";
        String suffix = (String) CollectionsKt.last(StringsKt.split$default(url, new String[]{FileUtils.HIDDEN_PREFIX}, false, 0, 6, (Object) null));
        String fileName = DigestUtils.md5(url) + FileUtils.HIDDEN_PREFIX + suffix;
        return finalDir + fileName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toShare() {
        String fSource;
        String fromWhere;
        String fromId;
        NftCardJsbCallback nftCardJsbCallback = this.mJsbCallback;
        if (nftCardJsbCallback != null) {
            long j = this.mCurrentCardTypeId;
            long j2 = this.mCurrentCardId;
            NftCardModel nftCardModel = this.mNftCardModel;
            nftCardJsbCallback.toShare(j, j2, nftCardModel != null ? nftCardModel.getActId() : 0);
        }
        NftReporterHelper nftReporterHelper = NftReporterHelper.INSTANCE;
        NftCardModel nftCardModel2 = this.mNftCardModel;
        int actId = nftCardModel2 != null ? nftCardModel2.getActId() : 0;
        long j3 = this.mCurrentCardTypeId;
        NftCardModel nftCardModel3 = this.mNftCardModel;
        String str = (nftCardModel3 == null || (fromId = nftCardModel3.getFromId()) == null) ? "" : fromId;
        NftCardModel nftCardModel4 = this.mNftCardModel;
        String str2 = (nftCardModel4 == null || (fromWhere = nftCardModel4.getFromWhere()) == null) ? "" : fromWhere;
        NftCardModel nftCardModel5 = this.mNftCardModel;
        String str3 = (nftCardModel5 == null || (fSource = nftCardModel5.getFSource()) == null) ? "" : fSource;
        NftCardModel nftCardModel6 = this.mNftCardModel;
        nftReporterHelper.reportNftCardShareButtonClick(actId, j3, str, str2, str3, nftCardModel6 != null ? nftCardModel6.getSourceType() : 0, this.mMid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toHolderList(int buttonType) {
        NftCardJsbCallback nftCardJsbCallback = this.mJsbCallback;
        if (nftCardJsbCallback != null) {
            long j = this.mCurrentCardTypeId;
            long j2 = this.mCurrentCardId;
            NftCardModel nftCardModel = this.mNftCardModel;
            nftCardJsbCallback.toHolderList(j, j2, nftCardModel != null ? nftCardModel.getActId() : 0);
        }
        reportButtonClick(buttonType);
    }

    private final void reportButtonClick(int buttonType) {
        String fSource;
        NftReporterHelper nftReporterHelper = NftReporterHelper.INSTANCE;
        NftCardModel nftCardModel = this.mNftCardModel;
        int actId = nftCardModel != null ? nftCardModel.getActId() : 0;
        long j = this.mCurrentCardTypeId;
        NftCardModel nftCardModel2 = this.mNftCardModel;
        String str = "";
        String str2 = (nftCardModel2 == null || (str2 = nftCardModel2.getFromWhere()) == null) ? "" : "";
        NftCardModel nftCardModel3 = this.mNftCardModel;
        String str3 = (nftCardModel3 == null || (str3 = nftCardModel3.getFromId()) == null) ? "" : "";
        NftCardModel nftCardModel4 = this.mNftCardModel;
        if (nftCardModel4 != null && (fSource = nftCardModel4.getFSource()) != null) {
            str = fSource;
        }
        long j2 = this.mMid;
        NftCardModel nftCardModel5 = this.mNftCardModel;
        nftReporterHelper.reportNftCardBottomButtonClick(actId, j, str2, str3, str, buttonType, j2, nftCardModel5 != null ? nftCardModel5.getSourceType() : 0);
    }

    public final void hideMask() {
        this.mCardMp4Mask2.setVisibility(8);
    }

    public final void hideAndEndAnim() {
        this.mCardMp4Player.setVisibility(8);
        this.mCardMp4Player2.setVisibility(8);
        if (this.mIsPlayingLoadingAnim) {
            this.mCardMp4Player.finishPlay(true);
        }
        if (this.mIsPlayingShowAnim) {
            this.mCardMp4Player2.finishPlay(true);
        }
    }

    private final void registerButtonListener(NftCardFromType type) {
        this.mCardMp4Mask2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BLog.e("mCardMp4Mask2 click");
            }
        });
        this.mMenuBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NftCardInfoGroup.registerButtonListener$lambda$1(NftCardInfoGroup.this, view);
            }
        });
        this.mCardRatioGroup.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NftCardInfoGroup.this.toHolderList(2);
            }
        });
        this.mCardBottomShareButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NftCardInfoGroup.this.toShare();
            }
        });
        this.mSoundSwitch.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NftCardInfoGroup.registerButtonListener$lambda$4(NftCardInfoGroup.this, view);
            }
        });
        this.mFakeCardList.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NftCardInfoGroup.this.showMenu(false);
            }
        });
        hideMask();
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 4:
                this.mCardBottomDrawButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardInfoGroup.registerButtonListener$lambda$6(NftCardInfoGroup.this, view);
                    }
                });
                return;
            case 5:
                this.mCardBottomDrawButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardInfoGroup.registerButtonListener$lambda$8(NftCardInfoGroup.this, view);
                    }
                });
                return;
            case 6:
                this.mCardBottomDrawButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardInfoGroup.registerButtonListener$lambda$7(NftCardInfoGroup.this, view);
                    }
                });
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$1(NftCardInfoGroup this$0, View it) {
        this$0.showMenu(!this$0.mShowMenu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$4(NftCardInfoGroup this$0, View it) {
        this$0.switchVideoSound(!this$0.mVideoMuteState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$6(NftCardInfoGroup this$0, View it) {
        if (ADDownloadUtils.INSTANCE.isFastClick() || this$0.mIsPlayingLoadingAnim || this$0.mIsPlayingShowAnim) {
            return;
        }
        NftCardModel nftCardModel = this$0.mNftCardModel;
        int drawCount = nftCardModel != null ? nftCardModel.getDrawCount() : 0;
        if (drawCount > 0) {
            this$0.drawCard();
            return;
        }
        NftCardJsbCallback nftCardJsbCallback = this$0.mJsbCallback;
        if (nftCardJsbCallback != null) {
            nftCardJsbCallback.toDrawAgain();
        }
        this$0.reportButtonClick(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$7(final NftCardInfoGroup this$0, View it) {
        BiliNftApiManager biliNftApiManager = BiliNftApiManager.INSTANCE;
        long j = this$0.mMid;
        long j2 = this$0.mCurrentCardTypeId;
        long j3 = this$0.mCurrentCardId;
        NftCardModel nftCardModel = this$0.mNftCardModel;
        biliNftApiManager.bgEdit(j, j2, j3, nftCardModel != null ? nftCardModel.getActId() : 0, new Callback<JSONObject>() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$registerButtonListener$8$1
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Context context;
                NftCardJsbCallback nftCardJsbCallback;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                context = NftCardInfoGroup.this.mContext;
                ToastHelper.showToastShort(context, "佩戴背景卡成功");
                BLog.d("NftCardDialog", "load bg edit api success");
                nftCardJsbCallback = NftCardInfoGroup.this.mJsbCallback;
                if (nftCardJsbCallback != null) {
                    nftCardJsbCallback.toDismissDialog();
                }
            }

            public void onFailure(Call<JSONObject> call, Throwable t) {
                Context context;
                NftCardJsbCallback nftCardJsbCallback;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                context = NftCardInfoGroup.this.mContext;
                ToastHelper.showToastShort(context, "佩戴背景卡失败");
                BLog.d("NftCardDialog", "load bg edi api failed, " + t.getMessage());
                nftCardJsbCallback = NftCardInfoGroup.this.mJsbCallback;
                if (nftCardJsbCallback != null) {
                    nftCardJsbCallback.toDismissDialog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerButtonListener$lambda$8(NftCardInfoGroup this$0, View it) {
        if (ADDownloadUtils.INSTANCE.isFastClick() || this$0.mIsPlayingLoadingAnim || this$0.mIsPlayingShowAnim) {
            return;
        }
        NftCardModel nftCardModel = this$0.mNftCardModel;
        int drawCount = nftCardModel != null ? nftCardModel.getDrawCount() : 0;
        if (drawCount > 0) {
            if (!this$0.mHasDrawCardInScanPage) {
                this$0.hideVideo();
                this$0.mCardList.clearData();
                NftReporterHelper nftReporterHelper = NftReporterHelper.INSTANCE;
                NftCardModel nftCardModel2 = this$0.mNftCardModel;
                int actId = nftCardModel2 != null ? nftCardModel2.getActId() : 0;
                long j = this$0.mCurrentCardTypeId;
                NftCardModel nftCardModel3 = this$0.mNftCardModel;
                nftReporterHelper.reportNftCardScanPageButtonClick(actId, j, nftCardModel3 != null ? nftCardModel3.getSourceType() : 0, this$0.mMid);
            }
            this$0.mHasDrawCardInScanPage = true;
            this$0.drawCard();
            return;
        }
        NftCardJsbCallback nftCardJsbCallback = this$0.mJsbCallback;
        if (nftCardJsbCallback != null) {
            nftCardJsbCallback.toDrawAgain();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void loadAnimFailed$default(NftCardInfoGroup nftCardInfoGroup, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        nftCardInfoGroup.loadAnimFailed(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadAnimFailed(boolean overtime, boolean animFailed) {
        String tip;
        if (!this.mCardLoadSuccess) {
            this.mCardMp4Player2.setVisibility(8);
            this.mCardMp4Player.setVisibility(8);
            if (overtime) {
                tip = "超时";
            } else {
                tip = "失败";
            }
            ToastHelper.showToastShort(this.mContext, "抽卡" + tip + ",请重新进入");
        }
        if (animFailed || !this.mCardLoadSuccess) {
            this.mCardMp4Mask.setAlpha(0.0f);
            this.mCardMp4Mask.setVisibility(8);
            this.mCardMp4Mask2.setVisibility(8);
            this.mCloseBtn.setVisibility(0);
        }
    }

    private final void registerAnimListener() {
        this.mCardMp4Player.setPlayListener(new UAMViewListener() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$registerAnimListener$1
            public void onInnerSurfaceStatusChanged(boolean isAvailable) {
                NftCardFromType nftCardFromType;
                BLog.d("NftCardDialog", "load card anim onInnerSurfaceStatusChanged " + isAvailable);
                if (isAvailable) {
                    nftCardFromType = NftCardInfoGroup.this.mFromType;
                    if (nftCardFromType == NftCardFromType.DRAW) {
                        NftCardInfoGroup.this.drawCard();
                    }
                }
            }

            public void onConfigParseFinish(IUAMConfig config) {
                BLog.d("NftCardDialog", "load card anim onConfigParseFinish");
            }

            public void onVideoFormatReadFinish(String mime) {
                BLog.d("NftCardDialog", "load card anim onVideoFormatReadFinish");
            }

            public void onPlayStart() {
                BiliDrawCard it;
                BLog.d("NftCardDialog", "load card anim onPlayStart");
                NftCardInfoGroup.this.mStartLoadAnimTime = System.currentTimeMillis();
                it = NftCardInfoGroup.this.mNewDrawCard;
                if (it != null) {
                    NftCardInfoGroup.this.delayShowCardAnim(it, false);
                }
            }

            public void onPlayFinish() {
                NftCardInfoGroup.this.mIsPlayingLoadingAnim = false;
                BLog.i("NftCardDialog", "load card anim onPlayFinish");
                NftCardInfoGroup.loadAnimFailed$default(NftCardInfoGroup.this, true, false, 2, null);
            }

            public void onBeforeRenderFailed(int code, String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                NftCardInfoGroup.this.mIsPlayingLoadingAnim = false;
                BLog.w("NftCardDialog", "load card anim onBeforeRenderFailed");
                NftCardInfoGroup.this.loadAnimFailed(false, true);
            }

            public void onPlayFailed(int code, String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                NftCardInfoGroup.this.mIsPlayingLoadingAnim = false;
                BLog.w("NftCardDialog", "load card anim onPlayFailed, " + code + ", msg: " + message);
                NftCardInfoGroup.this.loadAnimFailed(false, true);
            }
        });
        this.mCardMp4Player2.setPlayListener(new NftCardInfoGroup$registerAnimListener$2(this));
    }

    private final void switchVideoSound(boolean mute) {
        this.mVideoMuteState = mute;
        if (mute) {
            this.mSoundSwitch.setImageResource(com.bilibili.app.authorspace.R.drawable.ic_sound_off);
        } else {
            this.mSoundSwitch.setImageResource(com.bilibili.app.authorspace.R.drawable.ic_sound_on);
        }
        BiliCardPlayerScene.CardPlayTask.Token token = this.mVideoToken;
        if (token != null) {
            token.setMute(mute);
        }
    }

    private final void compatVideoLayout(int width, int height) {
        Context ctx;
        if (width > 0 && height > 0 && width > height) {
            ViewGroup.LayoutParams it = this.mCardVideoGroup.getLayoutParams();
            if (it != null) {
                int expectedHeight = (int) (it.width * ((height * 1.0f) / width));
                it.height = expectedHeight;
                BLog.d("NftCardDialog", "compatVideoLayout expectedHeight " + expectedHeight);
                this.mCardVideoGroup.setLayoutParams(it);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams it2 = this.mCardVideoGroup.getLayoutParams();
        if (it2 != null && (ctx = this.mContext) != null) {
            int defaultHeight = ScreenUtil.dip2px(ctx, 393.0f);
            it2.height = defaultHeight;
            BLog.d("NftCardDialog", "compatVideoLayout defaultHeight " + defaultHeight);
            this.mCardVideoGroup.setLayoutParams(it2);
        }
    }

    static /* synthetic */ void playVideo$default(NftCardInfoGroup nftCardInfoGroup, long j, List list, boolean z, int i, int i2, int i3, Object obj) {
        boolean z2;
        if ((i3 & 4) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        nftCardInfoGroup.playVideo(j, list, z2, i, i2);
    }

    private final void playVideo(long cardId, List<String> list, boolean isMute, int width, int height) {
        if (list != null && (list.isEmpty() ^ true)) {
            String playUrl = list.get(0);
            compatVideoLayout(width, height);
            ListExtentionsKt.visible(this.mCardVideoGroup);
            if (this.mVideoToken != null && Intrinsics.areEqual(this.mCurrentPlayVideoUrl, playUrl)) {
                if (this.mFromType == NftCardFromType.DRAW && this.mIsPlayingShowAnim) {
                    BLog.d("NftCardDialog", "pause play when doing show anim, " + (this.mVideoToken == null));
                    this.mNeedResumeVideoAfterAnim = true;
                    return;
                }
                BiliCardPlayerScene.CardPlayTask.Token token = this.mVideoToken;
                if (token != null) {
                    token.setMute(this.mVideoMuteState);
                }
                BiliCardPlayerScene.CardPlayTask.Token token2 = this.mVideoToken;
                if (token2 != null) {
                    token2.replay();
                }
                BLog.d("NftCardDialog", "has video res, just replay " + this.mCurrentPlayVideoUrl);
                return;
            }
            this.mCurrentPlayVideoUrl = playUrl;
            BLog.d("NftCardDialog", "play video " + playUrl + ", isMute " + isMute);
            final Video.PlayableParams playParams = generatePlayableParams(cardId, list);
            this.mVideoTask = BiliCardPlayerScene.CardPlayTask.Companion.obtain().setMute(isMute || this.mVideoMuteState).setContainer(this.mCardVideoGroup).addPlayableParams(playParams).setShowWhenFirstRender(true).forbiddenInnerTouchEvent(true).addPlayerStateChangedCallback(new ICardPlaySateChangedCallback() { // from class: tv.danmaku.bili.ui.garb.NftCardInfoGroup$playVideo$1
                public /* synthetic */ void onPause(ICardPlayerContext iCardPlayerContext) {
                    ICardPlaySateChangedCallback.-CC.$default$onPause(this, iCardPlayerContext);
                }

                public /* synthetic */ void onPrepared(ICardPlayerContext iCardPlayerContext) {
                    ICardPlaySateChangedCallback.-CC.$default$onPrepared(this, iCardPlayerContext);
                }

                public /* synthetic */ void onPreparing(ICardPlayerContext iCardPlayerContext) {
                    ICardPlaySateChangedCallback.-CC.$default$onPreparing(this, iCardPlayerContext);
                }

                public /* synthetic */ void onResume(ICardPlayerContext iCardPlayerContext) {
                    ICardPlaySateChangedCallback.-CC.$default$onResume(this, iCardPlayerContext);
                }

                public /* synthetic */ boolean onSourcePlayable(ICardPlayerContext iCardPlayerContext, MediaResource mediaResource) {
                    return ICardPlaySateChangedCallback.-CC.$default$onSourcePlayable(this, iCardPlayerContext, mediaResource);
                }

                public /* synthetic */ void onStop(ICardPlayerContext iCardPlayerContext) {
                    ICardPlaySateChangedCallback.-CC.$default$onStop(this, iCardPlayerContext);
                }

                public void onStart(ICardPlayerContext context) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(context, "context");
                    String id = playParams.id();
                    z = this.mIsPlayingLoadingAnim;
                    BLog.d("NftCardDialog", "onStart " + id + ", showing " + z);
                }

                public void onCompleted(ICardPlayerContext context) {
                    BiliCardPlayerScene.CardPlayTask.Token token3;
                    Intrinsics.checkNotNullParameter(context, "context");
                    BLog.d("NftCardDialog", "onCompleted " + playParams.id());
                    token3 = this.mVideoToken;
                    if (token3 != null) {
                        token3.replay();
                    }
                }

                public void onError(ICardPlayerContext context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    BLog.d("NftCardDialog", "onError " + playParams.id());
                }
            });
            if (this.mFromType == NftCardFromType.DRAW && this.mIsPlayingShowAnim) {
                BLog.d("NftCardDialog", "pause play when doing show anim, " + (this.mVideoToken == null));
                this.mNeedResumeVideoAfterAnim = true;
                return;
            }
            BiliCardPlayerScene.CardPlayTask.Token token3 = this.mVideoToken;
            if (token3 != null) {
                token3.setMute(this.mVideoMuteState);
            }
            commitVideoTask();
            return;
        }
        BLog.w("NftCardDialog", "play video failed, " + cardId + ", cause video list empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitVideoTask() {
        BiliCardPlayerScene.CardPlayTask it = this.mVideoTask;
        if (it != null) {
            BiliCardPlayerScene.CardPlayTask.Token $this$commitVideoTask_u24lambda_u240_u240 = BiliCardPlayerManager.INSTANCE.with(this.mFragment).commit(it);
            $this$commitVideoTask_u24lambda_u240_u240.hideBufferingView();
            this.mVideoToken = $this$commitVideoTask_u24lambda_u240_u240;
        }
    }

    private final Video.PlayableParams generatePlayableParams(long cardId, List<String> list) {
        return new DigitalCardVideoPlayParams(cardId, list, (Video.DisplayParams) null, 4, (DefaultConstructorMarker) null);
    }

    /* compiled from: NftCardInfoGroup.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardInfoGroup$Companion;", "", "<init>", "()V", "TAG", "", "RESOURCES_DIR_PATH", "MIN_PLAY_LOADING_ANIM", "", "VIDEO_GROUP_DEFAULT_HEIGHT", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}