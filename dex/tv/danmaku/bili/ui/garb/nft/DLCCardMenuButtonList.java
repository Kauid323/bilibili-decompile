package tv.danmaku.bili.ui.garb.nft;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bilibili.lib.accounts.BiliAccounts;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.garb.GarbManagerDelegateKt;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalFromType;

/* compiled from: DLCCardMenuButtonList.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCCardMenuButtonList;", "", "mContext", "Landroid/content/Context;", "mMid", "", "<init>", "(Landroid/content/Context;J)V", "mPageType", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalFromType;", "mIsMe", "", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/garb/nft/TopMenuButtonCallback;", "mRootView", "Landroid/view/ViewGroup;", "init", "", "menu", "pageType", "cb", "refreshMenu", "open", "close", "initMenuButtons", "root", "initMyMenuButtons", "textColor", "", "initButtonWithType", "Landroidx/appcompat/widget/LinearLayoutCompat;", "type", "Ltv/danmaku/bili/ui/garb/nft/DLCCardButtonType;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCCardMenuButtonList {
    private static final String KEY_FROM_TYPE = "from_type";
    private TopMenuButtonCallback callback;
    private final Context mContext;
    private final boolean mIsMe;
    private final long mMid;
    private DigitalFromType mPageType;
    private ViewGroup mRootView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DLCCardMenuButtonList.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DLCCardButtonType.values().length];
            try {
                iArr[DLCCardButtonType.SAVE_PIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DLCCardButtonType.GIVE_OTHERS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DLCCardButtonType.SEE_NFT_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DLCCardMenuButtonList(Context mContext, long mMid) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mMid = mMid;
        this.mPageType = DigitalFromType.SEE;
        this.mIsMe = this.mMid == BiliAccounts.get(this.mContext).mid();
    }

    public final void init(ViewGroup menu, DigitalFromType pageType, TopMenuButtonCallback cb) {
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

    public final void open() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void close() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private final void initMenuButtons(ViewGroup root) {
        BLog.i(GarbManagerDelegateKt.TAG, "initMenuButtons isMe " + this.mIsMe);
        int textColor = Color.parseColor("#FFFFFF");
        if (this.mIsMe) {
            initMyMenuButtons(root, textColor);
        }
    }

    private final void initMyMenuButtons(ViewGroup root, int textColor) {
        TopMenuButtonCallback topMenuButtonCallback = this.callback;
        TopMenuButtonCallback topMenuButtonCallback2 = null;
        if (topMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            topMenuButtonCallback = null;
        }
        boolean hasNftInfo = topMenuButtonCallback.hasNftInfo();
        TopMenuButtonCallback topMenuButtonCallback3 = this.callback;
        if (topMenuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            topMenuButtonCallback3 = null;
        }
        boolean canDonate = topMenuButtonCallback3.canDonate();
        TopMenuButtonCallback topMenuButtonCallback4 = this.callback;
        if (topMenuButtonCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            topMenuButtonCallback2 = topMenuButtonCallback4;
        }
        boolean canSaveImage = topMenuButtonCallback2.canSaveImage();
        boolean hasNftInfoButton = (this.mPageType == DigitalFromType.DRAW || this.mPageType == DigitalFromType.SCAN || !hasNftInfo) ? false : true;
        LinearLayoutCompat saveButton = initButtonWithType(DLCCardButtonType.SAVE_PIC, textColor);
        LinearLayoutCompat giveButton = initButtonWithType(DLCCardButtonType.GIVE_OTHERS, textColor);
        LinearLayoutCompat seeNftInfoButton = initButtonWithType(DLCCardButtonType.SEE_NFT_INFO, textColor);
        if (canSaveImage) {
            root.addView((View) saveButton);
        }
        if (canDonate) {
            root.addView((View) giveButton);
        }
        if (hasNftInfoButton) {
            root.addView((View) seeNftInfoButton);
        }
        root.requestLayout();
    }

    private final LinearLayoutCompat initButtonWithType(DLCCardButtonType type, int textColor) {
        String str;
        LinearLayoutCompat inflate = LayoutInflater.from(this.mContext).inflate(R.layout.bili_app_dialog_nft_detail_menu_item, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
        LinearLayoutCompat root = inflate;
        root.setTag(type);
        TextView button = (TextView) root.findViewById(R.id.nft_detail_menu_item_limited_title);
        button.setTextColor(textColor);
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardMenuButtonList$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DLCCardMenuButtonList.initButtonWithType$lambda$0(DLCCardMenuButtonList.this, view);
                    }
                });
                str = "保存图片";
                break;
            case 2:
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardMenuButtonList$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DLCCardMenuButtonList.initButtonWithType$lambda$1(DLCCardMenuButtonList.this, view);
                    }
                });
                str = "转赠";
                break;
            case 3:
                button.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.nft.DLCCardMenuButtonList$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DLCCardMenuButtonList.initButtonWithType$lambda$2(DLCCardMenuButtonList.this, view);
                    }
                });
                str = "查看区块链信息";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        button.setText(str);
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$0(DLCCardMenuButtonList this$0, View it) {
        TopMenuButtonCallback topMenuButtonCallback = this$0.callback;
        TopMenuButtonCallback topMenuButtonCallback2 = null;
        if (topMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            topMenuButtonCallback = null;
        }
        topMenuButtonCallback.dismissDialog();
        TopMenuButtonCallback topMenuButtonCallback3 = this$0.callback;
        if (topMenuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            topMenuButtonCallback2 = topMenuButtonCallback3;
        }
        topMenuButtonCallback2.savePic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$1(DLCCardMenuButtonList this$0, View it) {
        TopMenuButtonCallback topMenuButtonCallback = this$0.callback;
        TopMenuButtonCallback topMenuButtonCallback2 = null;
        if (topMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            topMenuButtonCallback = null;
        }
        topMenuButtonCallback.dismissDialog();
        TopMenuButtonCallback topMenuButtonCallback3 = this$0.callback;
        if (topMenuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            topMenuButtonCallback2 = topMenuButtonCallback3;
        }
        topMenuButtonCallback2.giveOther();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtonWithType$lambda$2(DLCCardMenuButtonList this$0, View it) {
        TopMenuButtonCallback topMenuButtonCallback = this$0.callback;
        TopMenuButtonCallback topMenuButtonCallback2 = null;
        if (topMenuButtonCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
            topMenuButtonCallback = null;
        }
        topMenuButtonCallback.dismissDialog();
        TopMenuButtonCallback topMenuButtonCallback3 = this$0.callback;
        if (topMenuButtonCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AuthResultCbHelper.ARGS_CALLBACK);
        } else {
            topMenuButtonCallback2 = topMenuButtonCallback3;
        }
        topMenuButtonCallback2.seeNftInfo();
    }

    /* compiled from: DLCCardMenuButtonList.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCCardMenuButtonList$Companion;", "", "<init>", "()V", "KEY_FROM_TYPE", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}