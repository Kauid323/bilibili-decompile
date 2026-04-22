package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bilibili.lib.avatar.layers.LayerAvatarView;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView;
import tv.danmaku.bili.ui.main2.mine.widgets.MineAvatarFrameLayout;
import tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView;
import tv.danmaku.bili.ui.main2.mine.widgets.MineRankTextView;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeImageView;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeTextView;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeView;
import tv.danmaku.bili.ui.main2.mine.widgets.NickNameTextView;
import tv.danmaku.bili.widget.AutoNightImageLayout;
import tv.danmaku.bili.widget.PriorityLinearLayout;
import tv.danmaku.bili.widget.swiperefresh.TintSwipeRefreshLayout;

public final class BiliLayoutMainUserCenterBinding implements ViewBinding {
    public final MineRankTextView accountStatus;
    public final ConstraintLayout amountLayout;
    public final ChameleonAnswerView answerEntry;
    public final MultipleThemeTextView attentionCount;
    public final MultipleThemeTextView attentionDec;
    public final View attentionLayout;
    public final FrameLayout avatarContainer;
    public final MineAvatarFrameLayout avatarLayout;
    public final MultipleThemeImageView editInformation;
    public final MultipleThemeTextView fansCount;
    public final MultipleThemeTextView fansDec;
    public final View fansLayout;
    public final MultipleThemeTextView followingCount;
    public final MultipleThemeTextView followingDec;
    public final View followingLayout;
    public final FragmentContainerView fragmentContainer;
    public final Guideline guidelineTwoThird;
    public final ConstraintLayout headLayout;
    public final LayerAvatarView layerAvatar;
    public final ComposeView leftTopCompose;
    public final AutoNightImageLayout levelLabel;
    public final ConstraintLayout levelSeniorEntrance;
    public final MultipleThemeImageView levelSeniorEntranceArrow;
    public final MultipleThemeImageView levelSeniorEntranceBg;
    public final AutoNightImageLayout levelSeniorEntranceLabel;
    public final MultipleThemeTextView levelSeniorEntranceText;
    public final MultipleThemeView line1;
    public final MultipleThemeView line2;
    public final LinearLayout linear02;
    public final ImageView mainTopBgImageview;
    public final TintFrameLayout mainTopLayout;
    public final MultipleThemeImageView mineDayNightSetting;
    public final View mineFansAchievementBadge;
    public final TintImageView mineFansAchievementImage;
    public final TintLinearLayout mineFansAchievementMedal;
    public final TextView mineFansAchievementText;
    public final TextView mineFansBubble;
    public final MineGlobalLinkEntranceView mineGlobalLinkEntrance;
    public final MultipleThemeTextView mineGuideTitle;
    public final MultipleThemeImageView mineGuideTitleArrow;
    public final RecyclerView mineRecycle;
    public final MultipleThemeImageView mineScan;
    public final BiliImageView mineThemeIcon;
    public final FrameLayout mineThemeLayout;
    public final MultipleThemeImageView mineThemeStoreView;
    public final ConstraintLayout mineTopView;
    public final ConstraintLayout mineUserInfo;
    public final MultipleThemeImageView mineUserInfoArrow;
    public final ConstraintLayout mineUserInfoLayout;
    public final BiliLayoutMineVipModuleRefactoringBinding mineVipLayoutRefactoring;
    public final PriorityLinearLayout nameGroup;
    public final NickNameTextView nickName;
    public final ConstraintLayout nickNameLayout;
    public final ConstraintLayout nickViewGuide;
    public final MineRankTextView rankStatus;
    public final TintSwipeRefreshLayout refreshLayout;
    private final TintFrameLayout rootView;
    public final LinearLayout tagContainer;
    public final MultipleThemeTextView tvGoToSpace;
    public final MultipleThemeTextView tvLogin;
    public final MultipleThemeTextView userBpCount;
    public final MultipleThemeTextView userCoinCount;
    public final MultipleThemeTextView userHandle;
    public final TextView vipStatus;
    public final ComposeView vipStatusImage;

    private BiliLayoutMainUserCenterBinding(TintFrameLayout rootView, MineRankTextView accountStatus, ConstraintLayout amountLayout, ChameleonAnswerView answerEntry, MultipleThemeTextView attentionCount, MultipleThemeTextView attentionDec, View attentionLayout, FrameLayout avatarContainer, MineAvatarFrameLayout avatarLayout, MultipleThemeImageView editInformation, MultipleThemeTextView fansCount, MultipleThemeTextView fansDec, View fansLayout, MultipleThemeTextView followingCount, MultipleThemeTextView followingDec, View followingLayout, FragmentContainerView fragmentContainer, Guideline guidelineTwoThird, ConstraintLayout headLayout, LayerAvatarView layerAvatar, ComposeView leftTopCompose, AutoNightImageLayout levelLabel, ConstraintLayout levelSeniorEntrance, MultipleThemeImageView levelSeniorEntranceArrow, MultipleThemeImageView levelSeniorEntranceBg, AutoNightImageLayout levelSeniorEntranceLabel, MultipleThemeTextView levelSeniorEntranceText, MultipleThemeView line1, MultipleThemeView line2, LinearLayout linear02, ImageView mainTopBgImageview, TintFrameLayout mainTopLayout, MultipleThemeImageView mineDayNightSetting, View mineFansAchievementBadge, TintImageView mineFansAchievementImage, TintLinearLayout mineFansAchievementMedal, TextView mineFansAchievementText, TextView mineFansBubble, MineGlobalLinkEntranceView mineGlobalLinkEntrance, MultipleThemeTextView mineGuideTitle, MultipleThemeImageView mineGuideTitleArrow, RecyclerView mineRecycle, MultipleThemeImageView mineScan, BiliImageView mineThemeIcon, FrameLayout mineThemeLayout, MultipleThemeImageView mineThemeStoreView, ConstraintLayout mineTopView, ConstraintLayout mineUserInfo, MultipleThemeImageView mineUserInfoArrow, ConstraintLayout mineUserInfoLayout, BiliLayoutMineVipModuleRefactoringBinding mineVipLayoutRefactoring, PriorityLinearLayout nameGroup, NickNameTextView nickName, ConstraintLayout nickNameLayout, ConstraintLayout nickViewGuide, MineRankTextView rankStatus, TintSwipeRefreshLayout refreshLayout, LinearLayout tagContainer, MultipleThemeTextView tvGoToSpace, MultipleThemeTextView tvLogin, MultipleThemeTextView userBpCount, MultipleThemeTextView userCoinCount, MultipleThemeTextView userHandle, TextView vipStatus, ComposeView vipStatusImage) {
        this.rootView = rootView;
        this.accountStatus = accountStatus;
        this.amountLayout = amountLayout;
        this.answerEntry = answerEntry;
        this.attentionCount = attentionCount;
        this.attentionDec = attentionDec;
        this.attentionLayout = attentionLayout;
        this.avatarContainer = avatarContainer;
        this.avatarLayout = avatarLayout;
        this.editInformation = editInformation;
        this.fansCount = fansCount;
        this.fansDec = fansDec;
        this.fansLayout = fansLayout;
        this.followingCount = followingCount;
        this.followingDec = followingDec;
        this.followingLayout = followingLayout;
        this.fragmentContainer = fragmentContainer;
        this.guidelineTwoThird = guidelineTwoThird;
        this.headLayout = headLayout;
        this.layerAvatar = layerAvatar;
        this.leftTopCompose = leftTopCompose;
        this.levelLabel = levelLabel;
        this.levelSeniorEntrance = levelSeniorEntrance;
        this.levelSeniorEntranceArrow = levelSeniorEntranceArrow;
        this.levelSeniorEntranceBg = levelSeniorEntranceBg;
        this.levelSeniorEntranceLabel = levelSeniorEntranceLabel;
        this.levelSeniorEntranceText = levelSeniorEntranceText;
        this.line1 = line1;
        this.line2 = line2;
        this.linear02 = linear02;
        this.mainTopBgImageview = mainTopBgImageview;
        this.mainTopLayout = mainTopLayout;
        this.mineDayNightSetting = mineDayNightSetting;
        this.mineFansAchievementBadge = mineFansAchievementBadge;
        this.mineFansAchievementImage = mineFansAchievementImage;
        this.mineFansAchievementMedal = mineFansAchievementMedal;
        this.mineFansAchievementText = mineFansAchievementText;
        this.mineFansBubble = mineFansBubble;
        this.mineGlobalLinkEntrance = mineGlobalLinkEntrance;
        this.mineGuideTitle = mineGuideTitle;
        this.mineGuideTitleArrow = mineGuideTitleArrow;
        this.mineRecycle = mineRecycle;
        this.mineScan = mineScan;
        this.mineThemeIcon = mineThemeIcon;
        this.mineThemeLayout = mineThemeLayout;
        this.mineThemeStoreView = mineThemeStoreView;
        this.mineTopView = mineTopView;
        this.mineUserInfo = mineUserInfo;
        this.mineUserInfoArrow = mineUserInfoArrow;
        this.mineUserInfoLayout = mineUserInfoLayout;
        this.mineVipLayoutRefactoring = mineVipLayoutRefactoring;
        this.nameGroup = nameGroup;
        this.nickName = nickName;
        this.nickNameLayout = nickNameLayout;
        this.nickViewGuide = nickViewGuide;
        this.rankStatus = rankStatus;
        this.refreshLayout = refreshLayout;
        this.tagContainer = tagContainer;
        this.tvGoToSpace = tvGoToSpace;
        this.tvLogin = tvLogin;
        this.userBpCount = userBpCount;
        this.userCoinCount = userCoinCount;
        this.userHandle = userHandle;
        this.vipStatus = vipStatus;
        this.vipStatusImage = vipStatusImage;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMainUserCenterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMainUserCenterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_main_user_center, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -128
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static tv.danmaku.bili.databinding.BiliLayoutMainUserCenterBinding bind(android.view.View r134) {
        /*
            Method dump skipped, instructions count: 995
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.databinding.BiliLayoutMainUserCenterBinding.bind(android.view.View):tv.danmaku.bili.databinding.BiliLayoutMainUserCenterBinding");
    }
}