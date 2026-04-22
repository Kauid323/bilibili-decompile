package tv.danmaku.bili.ui.garb;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import com.bili.digital.common.NftCardMenuLimitedDialog;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.garb.FromType;
import tv.danmaku.bili.ui.garb.api.CardRight;
import tv.danmaku.bili.ui.garb.api.CardRightShow;
import tv.danmaku.bili.ui.garb.api.NftReporterHelper;

/* compiled from: NftCardMenuButtonList.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J \u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002J\u0006\u0010$\u001a\u00020\u0019J\u0018\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020'2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardMenuButtonList;", "", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mNftCardModel", "Ltv/danmaku/bili/ui/garb/NftCardModel;", "mMid", "", "mDataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ltv/danmaku/bili/ui/garb/NftCardModel;JLjava/util/HashMap;)V", "mFromType", "Ltv/danmaku/bili/ui/garb/FromType;", "mPageType", "Ltv/danmaku/bili/ui/garb/NftCardFromType;", "mIsMe", "", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/garb/MenuButtonCallback;", "mRootView", "Landroid/view/ViewGroup;", "init", "", "menu", "pageType", "cb", "refreshMenu", "initMenuButtons", "root", "initMyMenuButtons", "textColor", "", "type", "refreshButton", "initButtonWithType", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Ltv/danmaku/bili/ui/garb/NftCardButtonType;", "reportMenuButtonClick", "buttonType", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardMenuButtonList {
    private static final String KEY_FROM_TYPE = "from_type";
    private static final String KEY_UPDATE_PENDANT = "card_pendant_url";
    private MenuButtonCallback callback;
    private final FragmentActivity mActivity;
    private final HashMap<String, String> mDataMap;
    private final FromType mFromType;
    private final boolean mIsMe;
    private final long mMid;
    private final NftCardModel mNftCardModel;
    private NftCardFromType mPageType;
    private ViewGroup mRootView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NftCardMenuButtonList.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NftCardButtonType.values().length];
            try {
                iArr[NftCardButtonType.CHANGE_AVATAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NftCardButtonType.CHANGE_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NftCardButtonType.SAVE_PIC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NftCardButtonType.GIVE_OTHERS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NftCardButtonType.SEE_NFT_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[NftCardButtonType.UPDATE_PENDANT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NftCardMenuButtonList(FragmentActivity mActivity, NftCardModel mNftCardModel, long mMid, HashMap<String, String> hashMap) {
        String str;
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.mActivity = mActivity;
        this.mNftCardModel = mNftCardModel;
        this.mMid = mMid;
        this.mDataMap = hashMap;
        FromType.Companion companion = FromType.Companion;
        HashMap<String, String> hashMap2 = this.mDataMap;
        this.mFromType = companion.toType((hashMap2 == null || (str = hashMap2.get(KEY_FROM_TYPE)) == null) ? 0 : Integer.parseInt(str));
        this.mPageType = NftCardFromType.SEE;
        this.mIsMe = this.mMid == BiliAccounts.get(this.mActivity).mid();
    }

    public final void init(ViewGroup menu, NftCardFromType pageType, MenuButtonCallback cb) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(cb, "cb");
        if (menu == null) {
            return;
        }
        this.callback = cb;
        this.mPageType = pageType;
        this.mRootView = menu;
        initMenuButtons(menu);
    }

    public final void refreshMenu(ViewGroup menu) {
        if (menu == null) {
            return;
        }
        menu.removeAllViews();
        initMenuButtons(menu);
    }

    private final void initMenuButtons(ViewGroup root) {
        int type = this.mFromType.getType();
        BLog.i(GarbManagerDelegateKt.TAG, "initMenuButtons " + type + ", isMe " + this.mIsMe);
        int textColor = Color.parseColor("#DAE4FF");
        if (this.mFromType == FromType.AVATAR) {
            if (this.mIsMe) {
                initMyMenuButtons(root, textColor, this.mFromType);
                return;
            }
            LinearLayoutCompat pendantButton = initButtonWithType(NftCardButtonType.UPDATE_PENDANT, textColor);
            root.addView((View) pendantButton);
            root.requestLayout();
        } else if (this.mIsMe) {
            initMyMenuButtons(root, textColor, this.mFromType);
        }
    }

    private final void initMyMenuButtons(ViewGroup root, int textColor, FromType type) {
        MenuButtonCallback menuButtonCallback = this.callback;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        boolean hasNftInfo = menuButtonCallback.hasNftInfo();
        boolean hasNftInfoButton = (this.mPageType == NftCardFromType.DRAW || this.mPageType == NftCardFromType.SCAN || !hasNftInfo) ? false : true;
        LinearLayoutCompat avatarButton = initButtonWithType(NftCardButtonType.CHANGE_AVATAR, textColor);
        LinearLayoutCompat headerButton = initButtonWithType(NftCardButtonType.CHANGE_HEADER, textColor);
        LinearLayoutCompat saveButton = initButtonWithType(NftCardButtonType.SAVE_PIC, textColor);
        LinearLayoutCompat giveButton = initButtonWithType(NftCardButtonType.GIVE_OTHERS, textColor);
        LinearLayoutCompat seeNftInfoButton = initButtonWithType(NftCardButtonType.SEE_NFT_INFO, textColor);
        root.addView((View) avatarButton);
        root.addView((View) headerButton);
        root.addView((View) saveButton);
        if (hasNftInfo) {
            root.addView((View) giveButton);
        }
        if (hasNftInfoButton) {
            root.addView((View) seeNftInfoButton);
        }
        root.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshButton() {
        MenuButtonCallback menuButtonCallback;
        Pair<CardRightShow, CardRight> limitInfo;
        CardRightShow cardRightShow;
        CardRightShow cardRightShow2;
        CardRight cardRight;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        CardRightShow cardRightShow5;
        CardRight cardRight2;
        CardRightShow cardRightShow6;
        CardRightShow cardRightShow7;
        CardRightShow cardRightShow8;
        if (this.mIsMe) {
            int textColor = Color.parseColor("#DAE4FF");
            ViewGroup viewGroup = this.mRootView;
            LinearLayoutCompat setAvatar = viewGroup != null ? (LinearLayoutCompat) viewGroup.findViewWithTag(NftCardButtonType.CHANGE_AVATAR) : null;
            ViewGroup viewGroup2 = this.mRootView;
            LinearLayoutCompat setHeader = viewGroup2 != null ? (LinearLayoutCompat) viewGroup2.findViewWithTag(NftCardButtonType.CHANGE_HEADER) : null;
            TextView setAvatarTitle = setAvatar != null ? (TextView) setAvatar.findViewById(R.id.nft_detail_menu_item_limited_title) : null;
            BiliImageView setAvatarTag = setAvatar != null ? (BiliImageView) setAvatar.findViewById(R.id.nft_detail_menu_item_limited_tag) : null;
            TextView setHeaderTitle = setHeader != null ? (TextView) setHeader.findViewById(R.id.nft_detail_menu_item_limited_title) : null;
            BiliImageView setHeaderTag = setHeader != null ? (BiliImageView) setHeader.findViewById(R.id.nft_detail_menu_item_limited_tag) : null;
            MenuButtonCallback menuButtonCallback2 = this.callback;
            if (menuButtonCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                menuButtonCallback2 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo2 = menuButtonCallback2.getLimitInfo();
            boolean z = true;
            if ((limitInfo2 == null || (cardRightShow8 = (CardRightShow) limitInfo2.getFirst()) == null || cardRightShow8.isHeadPic() != 0) ? false : true) {
                if (setAvatarTitle != null) {
                    setAvatarTitle.setTextColor(this.mActivity.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                }
            } else if (setAvatarTitle != null) {
                setAvatarTitle.setTextColor(textColor);
            }
            MenuButtonCallback menuButtonCallback3 = this.callback;
            if (menuButtonCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                menuButtonCallback3 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo3 = menuButtonCallback3.getLimitInfo();
            if ((limitInfo3 == null || (cardRightShow7 = (CardRightShow) limitInfo3.getFirst()) == null || cardRightShow7.isBannerBg() != 0) ? false : true) {
                if (setHeaderTitle != null) {
                    setHeaderTitle.setTextColor(this.mActivity.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                }
            } else if (setHeaderTitle != null) {
                setHeaderTitle.setTextColor(textColor);
            }
            MenuButtonCallback menuButtonCallback4 = this.callback;
            if (menuButtonCallback4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                menuButtonCallback4 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo4 = menuButtonCallback4.getLimitInfo();
            if ((limitInfo4 == null || (cardRightShow6 = (CardRightShow) limitInfo4.getFirst()) == null || cardRightShow6.isHeadPic() != 1) ? false : true) {
                MenuButtonCallback menuButtonCallback5 = this.callback;
                if (menuButtonCallback5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    menuButtonCallback5 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo5 = menuButtonCallback5.getLimitInfo();
                if (((limitInfo5 == null || (cardRight2 = (CardRight) limitInfo5.getSecond()) == null) ? 0L : cardRight2.getHeadPicExpire()) > 0) {
                    MenuButtonCallback menuButtonCallback6 = this.callback;
                    if (menuButtonCallback6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                        menuButtonCallback6 = null;
                    }
                    Pair<CardRightShow, CardRight> limitInfo6 = menuButtonCallback6.getLimitInfo();
                    if (!TextUtils.isEmpty((limitInfo6 == null || (cardRightShow5 = (CardRightShow) limitInfo6.getFirst()) == null) ? null : cardRightShow5.getHeadTagUrl())) {
                        if (setAvatarTag != null) {
                            BiliImageView it = setAvatarTag;
                            ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(this.mActivity);
                            MenuButtonCallback menuButtonCallback7 = this.callback;
                            if (menuButtonCallback7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                menuButtonCallback7 = null;
                            }
                            Pair<CardRightShow, CardRight> limitInfo7 = menuButtonCallback7.getLimitInfo();
                            with.url((limitInfo7 == null || (cardRightShow4 = (CardRightShow) limitInfo7.getFirst()) == null) ? null : cardRightShow4.getHeadTagUrl()).into(it);
                            it.setVisibility(0);
                        }
                        menuButtonCallback = this.callback;
                        if (menuButtonCallback == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                            menuButtonCallback = null;
                        }
                        limitInfo = menuButtonCallback.getLimitInfo();
                        if (limitInfo != null || (cardRightShow3 = (CardRightShow) limitInfo.getFirst()) == null || cardRightShow3.isBannerBg() != 1) {
                            z = false;
                        }
                        if (z) {
                            MenuButtonCallback menuButtonCallback8 = this.callback;
                            if (menuButtonCallback8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                menuButtonCallback8 = null;
                            }
                            Pair<CardRightShow, CardRight> limitInfo8 = menuButtonCallback8.getLimitInfo();
                            if (((limitInfo8 == null || (cardRight = (CardRight) limitInfo8.getSecond()) == null) ? 0L : cardRight.getBannerBgExpire()) > 0) {
                                MenuButtonCallback menuButtonCallback9 = this.callback;
                                if (menuButtonCallback9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                    menuButtonCallback9 = null;
                                }
                                Pair<CardRightShow, CardRight> limitInfo9 = menuButtonCallback9.getLimitInfo();
                                if (!TextUtils.isEmpty((limitInfo9 == null || (cardRightShow2 = (CardRightShow) limitInfo9.getFirst()) == null) ? null : cardRightShow2.getBannerTagUrl())) {
                                    if (setHeaderTag != null) {
                                        BiliImageView it2 = setHeaderTag;
                                        ImageRequestBuilder with2 = BiliImageLoader.INSTANCE.with(this.mActivity);
                                        MenuButtonCallback menuButtonCallback10 = this.callback;
                                        if (menuButtonCallback10 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                            menuButtonCallback10 = null;
                                        }
                                        Pair<CardRightShow, CardRight> limitInfo10 = menuButtonCallback10.getLimitInfo();
                                        with2.url((limitInfo10 == null || (cardRightShow = (CardRightShow) limitInfo10.getFirst()) == null) ? null : cardRightShow.getBannerTagUrl()).into(it2);
                                        it2.setVisibility(0);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        if (setHeaderTag == null) {
                            setHeaderTag.setVisibility(8);
                            return;
                        }
                        return;
                    }
                }
            }
            if (setAvatarTag != null) {
                setAvatarTag.setVisibility(8);
            }
            menuButtonCallback = this.callback;
            if (menuButtonCallback == null) {
            }
            limitInfo = menuButtonCallback.getLimitInfo();
            if (limitInfo != null) {
            }
            z = false;
            if (z) {
            }
            if (setHeaderTag == null) {
            }
        }
    }

    private final LinearLayoutCompat initButtonWithType(NftCardButtonType type, int textColor) {
        String str;
        CardRightShow cardRightShow;
        CardRightShow cardRightShow2;
        CardRight cardRight;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        CardRightShow cardRightShow5;
        CardRightShow cardRightShow6;
        CardRight cardRight2;
        CardRightShow cardRightShow7;
        CardRightShow cardRightShow8;
        String str2 = null;
        LinearLayoutCompat inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.bili_app_dialog_nft_detail_menu_item, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
        LinearLayoutCompat root = inflate;
        root.setTag(type);
        TextView button = (TextView) root.findViewById(R.id.nft_detail_menu_item_limited_title);
        BiliImageView setTag = root.findViewById(R.id.nft_detail_menu_item_limited_tag);
        button.setTextColor(textColor);
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                MenuButtonCallback menuButtonCallback = this.callback;
                if (menuButtonCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    menuButtonCallback = null;
                }
                Pair<CardRightShow, CardRight> limitInfo = menuButtonCallback.getLimitInfo();
                if ((limitInfo == null || (cardRightShow4 = (CardRightShow) limitInfo.getFirst()) == null || cardRightShow4.isHeadPic() != 0) ? false : true) {
                    button.setTextColor(this.mActivity.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                } else {
                    button.setTextColor(textColor);
                }
                MenuButtonCallback menuButtonCallback2 = this.callback;
                if (menuButtonCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    menuButtonCallback2 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo2 = menuButtonCallback2.getLimitInfo();
                if (limitInfo2 == null || (cardRightShow3 = (CardRightShow) limitInfo2.getFirst()) == null || cardRightShow3.isHeadPic() != 1) {
                    z = false;
                }
                if (z) {
                    MenuButtonCallback menuButtonCallback3 = this.callback;
                    if (menuButtonCallback3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                        menuButtonCallback3 = null;
                    }
                    Pair<CardRightShow, CardRight> limitInfo3 = menuButtonCallback3.getLimitInfo();
                    if (((limitInfo3 == null || (cardRight = (CardRight) limitInfo3.getSecond()) == null) ? 0L : cardRight.getHeadPicExpire()) > 0) {
                        MenuButtonCallback menuButtonCallback4 = this.callback;
                        if (menuButtonCallback4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                            menuButtonCallback4 = null;
                        }
                        Pair<CardRightShow, CardRight> limitInfo4 = menuButtonCallback4.getLimitInfo();
                        if (!TextUtils.isEmpty((limitInfo4 == null || (cardRightShow2 = (CardRightShow) limitInfo4.getFirst()) == null) ? null : cardRightShow2.getHeadTagUrl())) {
                            if (setTag != null) {
                                ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(this.mActivity);
                                MenuButtonCallback menuButtonCallback5 = this.callback;
                                if (menuButtonCallback5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                    menuButtonCallback5 = null;
                                }
                                Pair<CardRightShow, CardRight> limitInfo5 = menuButtonCallback5.getLimitInfo();
                                if (limitInfo5 != null && (cardRightShow = (CardRightShow) limitInfo5.getFirst()) != null) {
                                    str2 = cardRightShow.getHeadTagUrl();
                                }
                                with.url(str2).into(setTag);
                                setTag.setVisibility(0);
                            }
                            button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda2
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    NftCardMenuButtonList.initButtonWithType$lambda$1(NftCardMenuButtonList.this, view);
                                }
                            });
                            str = "设为头像";
                            break;
                        }
                    }
                }
                if (setTag != null) {
                    setTag.setVisibility(8);
                }
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardMenuButtonList.initButtonWithType$lambda$1(NftCardMenuButtonList.this, view);
                    }
                });
                str = "设为头像";
                break;
            case 2:
                MenuButtonCallback menuButtonCallback6 = this.callback;
                if (menuButtonCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    menuButtonCallback6 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo6 = menuButtonCallback6.getLimitInfo();
                if ((limitInfo6 == null || (cardRightShow8 = (CardRightShow) limitInfo6.getFirst()) == null || cardRightShow8.isBannerBg() != 0) ? false : true) {
                    button.setTextColor(this.mActivity.getResources().getColor(R.color.bili_app_nft_limit_time_text_color));
                } else {
                    button.setTextColor(textColor);
                }
                MenuButtonCallback menuButtonCallback7 = this.callback;
                if (menuButtonCallback7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    menuButtonCallback7 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo7 = menuButtonCallback7.getLimitInfo();
                if (limitInfo7 == null || (cardRightShow7 = (CardRightShow) limitInfo7.getFirst()) == null || cardRightShow7.isBannerBg() != 1) {
                    z = false;
                }
                if (z) {
                    MenuButtonCallback menuButtonCallback8 = this.callback;
                    if (menuButtonCallback8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                        menuButtonCallback8 = null;
                    }
                    Pair<CardRightShow, CardRight> limitInfo8 = menuButtonCallback8.getLimitInfo();
                    if (((limitInfo8 == null || (cardRight2 = (CardRight) limitInfo8.getSecond()) == null) ? 0L : cardRight2.getBannerBgExpire()) > 0) {
                        MenuButtonCallback menuButtonCallback9 = this.callback;
                        if (menuButtonCallback9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                            menuButtonCallback9 = null;
                        }
                        Pair<CardRightShow, CardRight> limitInfo9 = menuButtonCallback9.getLimitInfo();
                        if (!TextUtils.isEmpty((limitInfo9 == null || (cardRightShow6 = (CardRightShow) limitInfo9.getFirst()) == null) ? null : cardRightShow6.getBannerTagUrl())) {
                            if (setTag != null) {
                                ImageRequestBuilder with2 = BiliImageLoader.INSTANCE.with(this.mActivity);
                                MenuButtonCallback menuButtonCallback10 = this.callback;
                                if (menuButtonCallback10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                                    menuButtonCallback10 = null;
                                }
                                Pair<CardRightShow, CardRight> limitInfo10 = menuButtonCallback10.getLimitInfo();
                                if (limitInfo10 != null && (cardRightShow5 = (CardRightShow) limitInfo10.getFirst()) != null) {
                                    str2 = cardRightShow5.getBannerTagUrl();
                                }
                                with2.url(str2).into(setTag);
                                setTag.setVisibility(0);
                            }
                            button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda3
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    NftCardMenuButtonList.initButtonWithType$lambda$3(NftCardMenuButtonList.this, view);
                                }
                            });
                            str = "设为头图";
                            break;
                        }
                    }
                }
                if (setTag != null) {
                    setTag.setVisibility(8);
                }
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardMenuButtonList.initButtonWithType$lambda$3(NftCardMenuButtonList.this, view);
                    }
                });
                str = "设为头图";
                break;
            case 3:
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardMenuButtonList.initButtonWithType$lambda$4(NftCardMenuButtonList.this, view);
                    }
                });
                str = "保存图片";
                break;
            case 4:
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardMenuButtonList.initButtonWithType$lambda$5(NftCardMenuButtonList.this, view);
                    }
                });
                str = "转赠";
                break;
            case 5:
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardMenuButtonList.initButtonWithType$lambda$6(NftCardMenuButtonList.this, view);
                    }
                });
                str = "查看区块链信息";
                break;
            case 6:
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NftCardMenuButtonList.initButtonWithType$lambda$7(NftCardMenuButtonList.this, r2, view);
                    }
                });
                str = "查看TA的头像挂件";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        button.setText(str);
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$1(final NftCardMenuButtonList this$0, View it) {
        CardRightShow cardRightShow;
        String it2;
        CardRight cardRight;
        CardRightShow cardRightShow2;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        MenuButtonCallback menuButtonCallback = this$0.callback;
        MenuButtonCallback menuButtonCallback2 = null;
        r2 = null;
        String str = null;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        Pair<CardRightShow, CardRight> limitInfo = menuButtonCallback.getLimitInfo();
        boolean z = false;
        if (((limitInfo == null || (cardRightShow4 = (CardRightShow) limitInfo.getFirst()) == null || cardRightShow4.isHeadPic() != 0) ? null : 1) != null) {
            MenuButtonCallback menuButtonCallback3 = this$0.callback;
            if (menuButtonCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                menuButtonCallback3 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo2 = menuButtonCallback3.getLimitInfo();
            if (limitInfo2 != null && (cardRightShow3 = (CardRightShow) limitInfo2.getFirst()) != null) {
                str = cardRightShow3.getHeadPicToast();
            }
            String toast = str;
            if (!TextUtils.isEmpty(toast)) {
                ToastHelper.showToast(this$0.mActivity, toast, 0);
                return;
            }
            return;
        }
        MenuButtonCallback menuButtonCallback4 = this$0.callback;
        if (menuButtonCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback4 = null;
        }
        Pair<CardRightShow, CardRight> limitInfo3 = menuButtonCallback4.getLimitInfo();
        if (limitInfo3 != null && (cardRightShow2 = (CardRightShow) limitInfo3.getFirst()) != null && cardRightShow2.isHeadPic() == 1) {
            z = true;
        }
        if (z) {
            MenuButtonCallback menuButtonCallback5 = this$0.callback;
            if (menuButtonCallback5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                menuButtonCallback5 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo4 = menuButtonCallback5.getLimitInfo();
            if (((limitInfo4 == null || (cardRight = (CardRight) limitInfo4.getSecond()) == null) ? 0L : cardRight.getHeadPicExpire()) > 0) {
                MenuButtonCallback menuButtonCallback6 = this$0.callback;
                if (menuButtonCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    menuButtonCallback6 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo5 = menuButtonCallback6.getLimitInfo();
                if (limitInfo5 != null && (cardRightShow = (CardRightShow) limitInfo5.getFirst()) != null && (it2 = cardRightShow.getHeadExpireFormat()) != null) {
                    NftCardMenuLimitedDialog.Companion.show(this$0.mActivity, "该数字周边可限时作为头像", it2, new Function0() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit initButtonWithType$lambda$1$0$0;
                            initButtonWithType$lambda$1$0$0 = NftCardMenuButtonList.initButtonWithType$lambda$1$0$0(NftCardMenuButtonList.this);
                            return initButtonWithType$lambda$1$0$0;
                        }
                    });
                    return;
                }
            }
        }
        MenuButtonCallback menuButtonCallback7 = this$0.callback;
        if (menuButtonCallback7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback7 = null;
        }
        menuButtonCallback7.setAvatar();
        MenuButtonCallback menuButtonCallback8 = this$0.callback;
        if (menuButtonCallback8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            menuButtonCallback2 = menuButtonCallback8;
        }
        menuButtonCallback2.dismissMenu();
        this$0.reportMenuButtonClick(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtonWithType$lambda$1$0$0(NftCardMenuButtonList this$0) {
        MenuButtonCallback menuButtonCallback = this$0.callback;
        MenuButtonCallback menuButtonCallback2 = null;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        menuButtonCallback.setAvatar();
        MenuButtonCallback menuButtonCallback3 = this$0.callback;
        if (menuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            menuButtonCallback2 = menuButtonCallback3;
        }
        menuButtonCallback2.dismissMenu();
        this$0.reportMenuButtonClick(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$3(final NftCardMenuButtonList this$0, View it) {
        CardRightShow cardRightShow;
        String it2;
        CardRight cardRight;
        CardRightShow cardRightShow2;
        CardRightShow cardRightShow3;
        CardRightShow cardRightShow4;
        MenuButtonCallback menuButtonCallback = this$0.callback;
        MenuButtonCallback menuButtonCallback2 = null;
        r2 = null;
        String str = null;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        Pair<CardRightShow, CardRight> limitInfo = menuButtonCallback.getLimitInfo();
        boolean z = true;
        if (((limitInfo == null || (cardRightShow4 = (CardRightShow) limitInfo.getFirst()) == null || cardRightShow4.isBannerBg() != 0) ? null : 1) != null) {
            MenuButtonCallback menuButtonCallback3 = this$0.callback;
            if (menuButtonCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                menuButtonCallback3 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo2 = menuButtonCallback3.getLimitInfo();
            if (limitInfo2 != null && (cardRightShow3 = (CardRightShow) limitInfo2.getFirst()) != null) {
                str = cardRightShow3.getBannerBgToast();
            }
            String toast = str;
            if (!TextUtils.isEmpty(toast)) {
                ToastHelper.showToast(this$0.mActivity, toast, 0);
                return;
            }
            return;
        }
        MenuButtonCallback menuButtonCallback4 = this$0.callback;
        if (menuButtonCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback4 = null;
        }
        Pair<CardRightShow, CardRight> limitInfo3 = menuButtonCallback4.getLimitInfo();
        if (limitInfo3 == null || (cardRightShow2 = (CardRightShow) limitInfo3.getFirst()) == null || cardRightShow2.isBannerBg() != 1) {
            z = false;
        }
        if (z) {
            MenuButtonCallback menuButtonCallback5 = this$0.callback;
            if (menuButtonCallback5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                menuButtonCallback5 = null;
            }
            Pair<CardRightShow, CardRight> limitInfo4 = menuButtonCallback5.getLimitInfo();
            if (((limitInfo4 == null || (cardRight = (CardRight) limitInfo4.getSecond()) == null) ? 0L : cardRight.getBannerBgExpire()) > 0) {
                MenuButtonCallback menuButtonCallback6 = this$0.callback;
                if (menuButtonCallback6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
                    menuButtonCallback6 = null;
                }
                Pair<CardRightShow, CardRight> limitInfo5 = menuButtonCallback6.getLimitInfo();
                if (limitInfo5 != null && (cardRightShow = (CardRightShow) limitInfo5.getFirst()) != null && (it2 = cardRightShow.getHeadExpireFormat()) != null) {
                    NftCardMenuLimitedDialog.Companion.show(this$0.mActivity, "该数字周边可限时作为空间头图", it2, new Function0() { // from class: tv.danmaku.bili.ui.garb.NftCardMenuButtonList$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit initButtonWithType$lambda$3$0$0;
                            initButtonWithType$lambda$3$0$0 = NftCardMenuButtonList.initButtonWithType$lambda$3$0$0(NftCardMenuButtonList.this);
                            return initButtonWithType$lambda$3$0$0;
                        }
                    });
                    return;
                }
            }
        }
        MenuButtonCallback menuButtonCallback7 = this$0.callback;
        if (menuButtonCallback7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback7 = null;
        }
        menuButtonCallback7.setHeader();
        MenuButtonCallback menuButtonCallback8 = this$0.callback;
        if (menuButtonCallback8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            menuButtonCallback2 = menuButtonCallback8;
        }
        menuButtonCallback2.dismissMenu();
        this$0.reportMenuButtonClick(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtonWithType$lambda$3$0$0(NftCardMenuButtonList this$0) {
        MenuButtonCallback menuButtonCallback = this$0.callback;
        MenuButtonCallback menuButtonCallback2 = null;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        menuButtonCallback.setHeader();
        MenuButtonCallback menuButtonCallback3 = this$0.callback;
        if (menuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            menuButtonCallback2 = menuButtonCallback3;
        }
        menuButtonCallback2.dismissMenu();
        this$0.reportMenuButtonClick(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$4(NftCardMenuButtonList this$0, View it) {
        MenuButtonCallback menuButtonCallback = this$0.callback;
        MenuButtonCallback menuButtonCallback2 = null;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        menuButtonCallback.dismissDialog();
        MenuButtonCallback menuButtonCallback3 = this$0.callback;
        if (menuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            menuButtonCallback2 = menuButtonCallback3;
        }
        menuButtonCallback2.savePic();
        this$0.reportMenuButtonClick(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$5(NftCardMenuButtonList this$0, View it) {
        MenuButtonCallback menuButtonCallback = this$0.callback;
        MenuButtonCallback menuButtonCallback2 = null;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        menuButtonCallback.dismissDialog();
        MenuButtonCallback menuButtonCallback3 = this$0.callback;
        if (menuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            menuButtonCallback2 = menuButtonCallback3;
        }
        menuButtonCallback2.giveOther();
        this$0.reportMenuButtonClick(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$6(NftCardMenuButtonList this$0, View it) {
        MenuButtonCallback menuButtonCallback = this$0.callback;
        MenuButtonCallback menuButtonCallback2 = null;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        menuButtonCallback.dismissDialog();
        MenuButtonCallback menuButtonCallback3 = this$0.callback;
        if (menuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            menuButtonCallback2 = menuButtonCallback3;
        }
        menuButtonCallback2.seeNftInfo();
        this$0.reportMenuButtonClick(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$7(NftCardMenuButtonList this$0, int $buttonType, View it) {
        MenuButtonCallback menuButtonCallback = this$0.callback;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        menuButtonCallback.dismissDialog();
        SpaceNftUtils spaceNftUtils = SpaceNftUtils.INSTANCE;
        HashMap<String, String> hashMap = this$0.mDataMap;
        SpaceNftUtils.changePendant$default(spaceNftUtils, hashMap != null ? hashMap.get(KEY_UPDATE_PENDANT) : null, (String) null, this$0.mActivity, Long.valueOf(this$0.mMid), (Function0) null, 16, (Object) null);
        this$0.reportMenuButtonClick($buttonType);
    }

    private final void reportMenuButtonClick(int buttonType) {
        NftReporterHelper nftReporterHelper = NftReporterHelper.INSTANCE;
        NftCardModel nftCardModel = this.mNftCardModel;
        int actId = nftCardModel != null ? nftCardModel.getActId() : 0;
        MenuButtonCallback menuButtonCallback = this.callback;
        if (menuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            menuButtonCallback = null;
        }
        long currentCardId = menuButtonCallback.getCurrentCardId();
        NftCardModel nftCardModel2 = this.mNftCardModel;
        String str = (nftCardModel2 == null || (str = nftCardModel2.getFromWhere()) == null) ? "" : "";
        NftCardModel nftCardModel3 = this.mNftCardModel;
        String str2 = (nftCardModel3 == null || (str2 = nftCardModel3.getFromId()) == null) ? "" : "";
        NftCardModel nftCardModel4 = this.mNftCardModel;
        nftReporterHelper.reportNftCardMenuButtonClick(actId, currentCardId, str, str2, (nftCardModel4 == null || (r7 = nftCardModel4.getFSource()) == null) ? "" : "", buttonType, this.mMid);
    }

    /* compiled from: NftCardMenuButtonList.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardMenuButtonList$Companion;", "", "<init>", "()V", "KEY_UPDATE_PENDANT", "", "KEY_FROM_TYPE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}