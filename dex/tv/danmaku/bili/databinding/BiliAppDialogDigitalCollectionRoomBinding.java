package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.lib.avatar.widget.RoundBorderImageView;
import tv.danmaku.bili.R;

public final class BiliAppDialogDigitalCollectionRoomBinding implements ViewBinding {
    public final RecyclerView collectionAllRecycleview;
    public final AppCompatImageView collectionAllSettings;
    public final ConstraintLayout collectionAllSettingsContainer;
    public final AppCompatImageView collectionAllSettingsRightArrow;
    public final AppCompatImageView collectionAppWidget;
    public final AppCompatTextView collectionAppWidgetBadge;
    public final ConstraintLayout collectionAppWidgetContainer;
    public final AppCompatImageView collectionAppWidgetRightArrow;
    public final AppCompatTextView collectionAppWidgetText;
    public final AppCompatImageView collectionAvatarPendant;
    public final ConstraintLayout collectionAvatarPendantContainer;
    public final AppCompatImageView collectionAvatarPendantRightArrow;
    public final AppCompatTextView collectionAvatarPendantText;
    public final AppCompatImageView collectionBack;
    public final AppCompatImageView collectionComb;
    public final ConstraintLayout collectionCombContainer;
    public final AppCompatImageView collectionCombRightArrow;
    public final AppCompatTextView collectionCombText;
    public final AppCompatImageView collectionCommentBackground;
    public final ConstraintLayout collectionCommentBackgroundContainer;
    public final AppCompatImageView collectionCommentBackgroundRightArrow;
    public final AppCompatTextView collectionCommentBackgroundText;
    public final DrawerLayout collectionDrawerlayout;
    public final AppCompatImageView collectionDynamicCard;
    public final ConstraintLayout collectionDynamicCardContainer;
    public final AppCompatImageView collectionDynamicCardRightArrow;
    public final AppCompatTextView collectionDynamicCardText;
    public final AppCompatImageView collectionEmoticon;
    public final ConstraintLayout collectionEmoticonContainer;
    public final AppCompatImageView collectionEmoticonRightArrow;
    public final AppCompatTextView collectionEmoticonText;
    public final LinearLayout collectionEmptyContainer;
    public final AppCompatTextView collectionEmptyText;
    public final AppCompatTextView collectionEmptyTime;
    public final LinearLayout collectionEmptyView;
    public final AppCompatImageView collectionEye;
    public final AppCompatTextView collectionGoStore;
    public final AppCompatImageView collectionLoading;
    public final ConstraintLayout collectionLoadingContainer;
    public final AppCompatImageView collectionLoadingRightArrow;
    public final AppCompatTextView collectionLoadingText;
    public final AppCompatTextView collectionMenuButton;
    public final AppCompatTextView collectionMyDress;
    public final AppCompatTextView collectionMyDressAll;
    public final AppCompatImageView collectionMyDressAllRightArrow;
    public final RoundBorderImageView collectionMySetting;
    public final NestedScrollView collectionNestScroollView;
    public final ComposeView collectionNftContainer;
    public final ComposeView collectionNoticeBar;
    public final AppCompatImageView collectionProgressBar;
    public final ConstraintLayout collectionProgressBarContainer;
    public final AppCompatImageView collectionProgressBarRightArrow;
    public final AppCompatTextView collectionProgressBarText;
    public final AppCompatImageView collectionRealGift;
    public final AppCompatTextView collectionRealGiftBadge;
    public final ConstraintLayout collectionRealGiftContainer;
    public final AppCompatImageView collectionRealGiftRightArrow;
    public final AppCompatTextView collectionRealGiftText;
    public final FrameLayout collectionRoomMainContainer;
    public final LinearLayout collectionRoomSideContainer;
    public final AppCompatTextView collectionSetMyCollection;
    public final NestedScrollView collectionSideNestScrollView;
    public final AppCompatImageView collectionSpaceBackground;
    public final ConstraintLayout collectionSpaceBackgroundContainer;
    public final AppCompatImageView collectionSpaceBackgroundRightArrow;
    public final AppCompatTextView collectionSpaceBackgroundText;
    public final AppCompatImageView collectionStartup;
    public final AppCompatTextView collectionStartupBadge;
    public final ConstraintLayout collectionStartupContainer;
    public final AppCompatImageView collectionStartupRightArrow;
    public final AppCompatTextView collectionStartupText;
    public final AppCompatImageView collectionTheme;
    public final ConstraintLayout collectionThemeContainer;
    public final AppCompatImageView collectionThemeRightArrow;
    public final AppCompatTextView collectionThemeText;
    public final AppCompatTextView collectionTitle;
    public final FrameLayout collectionTitleContainer;
    public final AppCompatImageView collectionTop;
    public final FrameLayout collectionTopContainer;
    public final AppCompatImageView collectionTopRightArrow;
    public final ConstraintLayout collectionTopSettingContainer;
    public final UAMView collectionUamAnim;
    public final RecyclerView nftCardListBackend;
    public final RecyclerView nftCardListFront;
    private final DrawerLayout rootView;

    private BiliAppDialogDigitalCollectionRoomBinding(DrawerLayout rootView, RecyclerView collectionAllRecycleview, AppCompatImageView collectionAllSettings, ConstraintLayout collectionAllSettingsContainer, AppCompatImageView collectionAllSettingsRightArrow, AppCompatImageView collectionAppWidget, AppCompatTextView collectionAppWidgetBadge, ConstraintLayout collectionAppWidgetContainer, AppCompatImageView collectionAppWidgetRightArrow, AppCompatTextView collectionAppWidgetText, AppCompatImageView collectionAvatarPendant, ConstraintLayout collectionAvatarPendantContainer, AppCompatImageView collectionAvatarPendantRightArrow, AppCompatTextView collectionAvatarPendantText, AppCompatImageView collectionBack, AppCompatImageView collectionComb, ConstraintLayout collectionCombContainer, AppCompatImageView collectionCombRightArrow, AppCompatTextView collectionCombText, AppCompatImageView collectionCommentBackground, ConstraintLayout collectionCommentBackgroundContainer, AppCompatImageView collectionCommentBackgroundRightArrow, AppCompatTextView collectionCommentBackgroundText, DrawerLayout collectionDrawerlayout, AppCompatImageView collectionDynamicCard, ConstraintLayout collectionDynamicCardContainer, AppCompatImageView collectionDynamicCardRightArrow, AppCompatTextView collectionDynamicCardText, AppCompatImageView collectionEmoticon, ConstraintLayout collectionEmoticonContainer, AppCompatImageView collectionEmoticonRightArrow, AppCompatTextView collectionEmoticonText, LinearLayout collectionEmptyContainer, AppCompatTextView collectionEmptyText, AppCompatTextView collectionEmptyTime, LinearLayout collectionEmptyView, AppCompatImageView collectionEye, AppCompatTextView collectionGoStore, AppCompatImageView collectionLoading, ConstraintLayout collectionLoadingContainer, AppCompatImageView collectionLoadingRightArrow, AppCompatTextView collectionLoadingText, AppCompatTextView collectionMenuButton, AppCompatTextView collectionMyDress, AppCompatTextView collectionMyDressAll, AppCompatImageView collectionMyDressAllRightArrow, RoundBorderImageView collectionMySetting, NestedScrollView collectionNestScroollView, ComposeView collectionNftContainer, ComposeView collectionNoticeBar, AppCompatImageView collectionProgressBar, ConstraintLayout collectionProgressBarContainer, AppCompatImageView collectionProgressBarRightArrow, AppCompatTextView collectionProgressBarText, AppCompatImageView collectionRealGift, AppCompatTextView collectionRealGiftBadge, ConstraintLayout collectionRealGiftContainer, AppCompatImageView collectionRealGiftRightArrow, AppCompatTextView collectionRealGiftText, FrameLayout collectionRoomMainContainer, LinearLayout collectionRoomSideContainer, AppCompatTextView collectionSetMyCollection, NestedScrollView collectionSideNestScrollView, AppCompatImageView collectionSpaceBackground, ConstraintLayout collectionSpaceBackgroundContainer, AppCompatImageView collectionSpaceBackgroundRightArrow, AppCompatTextView collectionSpaceBackgroundText, AppCompatImageView collectionStartup, AppCompatTextView collectionStartupBadge, ConstraintLayout collectionStartupContainer, AppCompatImageView collectionStartupRightArrow, AppCompatTextView collectionStartupText, AppCompatImageView collectionTheme, ConstraintLayout collectionThemeContainer, AppCompatImageView collectionThemeRightArrow, AppCompatTextView collectionThemeText, AppCompatTextView collectionTitle, FrameLayout collectionTitleContainer, AppCompatImageView collectionTop, FrameLayout collectionTopContainer, AppCompatImageView collectionTopRightArrow, ConstraintLayout collectionTopSettingContainer, UAMView collectionUamAnim, RecyclerView nftCardListBackend, RecyclerView nftCardListFront) {
        this.rootView = rootView;
        this.collectionAllRecycleview = collectionAllRecycleview;
        this.collectionAllSettings = collectionAllSettings;
        this.collectionAllSettingsContainer = collectionAllSettingsContainer;
        this.collectionAllSettingsRightArrow = collectionAllSettingsRightArrow;
        this.collectionAppWidget = collectionAppWidget;
        this.collectionAppWidgetBadge = collectionAppWidgetBadge;
        this.collectionAppWidgetContainer = collectionAppWidgetContainer;
        this.collectionAppWidgetRightArrow = collectionAppWidgetRightArrow;
        this.collectionAppWidgetText = collectionAppWidgetText;
        this.collectionAvatarPendant = collectionAvatarPendant;
        this.collectionAvatarPendantContainer = collectionAvatarPendantContainer;
        this.collectionAvatarPendantRightArrow = collectionAvatarPendantRightArrow;
        this.collectionAvatarPendantText = collectionAvatarPendantText;
        this.collectionBack = collectionBack;
        this.collectionComb = collectionComb;
        this.collectionCombContainer = collectionCombContainer;
        this.collectionCombRightArrow = collectionCombRightArrow;
        this.collectionCombText = collectionCombText;
        this.collectionCommentBackground = collectionCommentBackground;
        this.collectionCommentBackgroundContainer = collectionCommentBackgroundContainer;
        this.collectionCommentBackgroundRightArrow = collectionCommentBackgroundRightArrow;
        this.collectionCommentBackgroundText = collectionCommentBackgroundText;
        this.collectionDrawerlayout = collectionDrawerlayout;
        this.collectionDynamicCard = collectionDynamicCard;
        this.collectionDynamicCardContainer = collectionDynamicCardContainer;
        this.collectionDynamicCardRightArrow = collectionDynamicCardRightArrow;
        this.collectionDynamicCardText = collectionDynamicCardText;
        this.collectionEmoticon = collectionEmoticon;
        this.collectionEmoticonContainer = collectionEmoticonContainer;
        this.collectionEmoticonRightArrow = collectionEmoticonRightArrow;
        this.collectionEmoticonText = collectionEmoticonText;
        this.collectionEmptyContainer = collectionEmptyContainer;
        this.collectionEmptyText = collectionEmptyText;
        this.collectionEmptyTime = collectionEmptyTime;
        this.collectionEmptyView = collectionEmptyView;
        this.collectionEye = collectionEye;
        this.collectionGoStore = collectionGoStore;
        this.collectionLoading = collectionLoading;
        this.collectionLoadingContainer = collectionLoadingContainer;
        this.collectionLoadingRightArrow = collectionLoadingRightArrow;
        this.collectionLoadingText = collectionLoadingText;
        this.collectionMenuButton = collectionMenuButton;
        this.collectionMyDress = collectionMyDress;
        this.collectionMyDressAll = collectionMyDressAll;
        this.collectionMyDressAllRightArrow = collectionMyDressAllRightArrow;
        this.collectionMySetting = collectionMySetting;
        this.collectionNestScroollView = collectionNestScroollView;
        this.collectionNftContainer = collectionNftContainer;
        this.collectionNoticeBar = collectionNoticeBar;
        this.collectionProgressBar = collectionProgressBar;
        this.collectionProgressBarContainer = collectionProgressBarContainer;
        this.collectionProgressBarRightArrow = collectionProgressBarRightArrow;
        this.collectionProgressBarText = collectionProgressBarText;
        this.collectionRealGift = collectionRealGift;
        this.collectionRealGiftBadge = collectionRealGiftBadge;
        this.collectionRealGiftContainer = collectionRealGiftContainer;
        this.collectionRealGiftRightArrow = collectionRealGiftRightArrow;
        this.collectionRealGiftText = collectionRealGiftText;
        this.collectionRoomMainContainer = collectionRoomMainContainer;
        this.collectionRoomSideContainer = collectionRoomSideContainer;
        this.collectionSetMyCollection = collectionSetMyCollection;
        this.collectionSideNestScrollView = collectionSideNestScrollView;
        this.collectionSpaceBackground = collectionSpaceBackground;
        this.collectionSpaceBackgroundContainer = collectionSpaceBackgroundContainer;
        this.collectionSpaceBackgroundRightArrow = collectionSpaceBackgroundRightArrow;
        this.collectionSpaceBackgroundText = collectionSpaceBackgroundText;
        this.collectionStartup = collectionStartup;
        this.collectionStartupBadge = collectionStartupBadge;
        this.collectionStartupContainer = collectionStartupContainer;
        this.collectionStartupRightArrow = collectionStartupRightArrow;
        this.collectionStartupText = collectionStartupText;
        this.collectionTheme = collectionTheme;
        this.collectionThemeContainer = collectionThemeContainer;
        this.collectionThemeRightArrow = collectionThemeRightArrow;
        this.collectionThemeText = collectionThemeText;
        this.collectionTitle = collectionTitle;
        this.collectionTitleContainer = collectionTitleContainer;
        this.collectionTop = collectionTop;
        this.collectionTopContainer = collectionTopContainer;
        this.collectionTopRightArrow = collectionTopRightArrow;
        this.collectionTopSettingContainer = collectionTopSettingContainer;
        this.collectionUamAnim = collectionUamAnim;
        this.nftCardListBackend = nftCardListBackend;
        this.nftCardListFront = nftCardListFront;
    }

    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDigitalCollectionRoomBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDigitalCollectionRoomBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_digital_collection_room, parent, false);
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
    public static tv.danmaku.bili.databinding.BiliAppDialogDigitalCollectionRoomBinding bind(android.view.View r173) {
        /*
            Method dump skipped, instructions count: 1321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.databinding.BiliAppDialogDigitalCollectionRoomBinding.bind(android.view.View):tv.danmaku.bili.databinding.BiliAppDialogDigitalCollectionRoomBinding");
    }
}