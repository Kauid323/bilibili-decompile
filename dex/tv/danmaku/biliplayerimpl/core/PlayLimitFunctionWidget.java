package tv.danmaku.biliplayerimpl.core;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.R;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.service.ControlContainerObserver;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.service.report.NeuronsEvents;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayLimitFunctionWidget.kt */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0013\b\u0000\u0018\u0000 82\u00020\u0001:\u000278B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0015J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0016J\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020 H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020 H\u0003J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u00102\u001a\u00020/H\u0002J\u001a\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\b\b\u0001\u00106\u001a\u00020/H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00069"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/PlayLimitFunctionWidget;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mCover", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mBack", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "mMessage", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "mSubMessage", "mButton", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mPlayLimit", "Lcom/bilibili/lib/media/resource/ExtraInfo$PlayLimit;", "mControlContainerObserver", "tv/danmaku/biliplayerimpl/core/PlayLimitFunctionWidget$mControlContainerObserver$1", "Ltv/danmaku/biliplayerimpl/core/PlayLimitFunctionWidget$mControlContainerObserver$1;", "tag", "", "getTag", "()Ljava/lang/String;", "functionWidgetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getFunctionWidgetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "createContentView", "Landroid/view/View;", "bindPlayerContainer", "", "playerContainer", "onWidgetShow", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "onWidgetDismiss", "onRelease", "ensureItemVisible", "screenType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "updateView", "onClickBack", "onClickButton", "reportButtonClick", "type", "", "parseStringColor", "colorStr", "defaultColor", "getTintDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", "color", "PlayLimitConfiguration", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayLimitFunctionWidget extends AbsFunctionWidget {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PlayLimitFunctionWidget";
    private TintImageView mBack;
    private TintTextView mButton;
    private final PlayLimitFunctionWidget$mControlContainerObserver$1 mControlContainerObserver;
    private BiliImageView mCover;
    private TintTextView mMessage;
    private ExtraInfo.PlayLimit mPlayLimit;
    private PlayerContainer mPlayerContainer;
    private TintTextView mSubMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.biliplayerimpl.core.PlayLimitFunctionWidget$mControlContainerObserver$1] */
    public PlayLimitFunctionWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mControlContainerObserver = new ControlContainerObserver() { // from class: tv.danmaku.biliplayerimpl.core.PlayLimitFunctionWidget$mControlContainerObserver$1
            @Override // tv.danmaku.biliplayerv2.service.ControlContainerObserver
            public void onControlContainerChanged(ControlContainerType state, ScreenModeType screenType) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(screenType, "screenType");
                PlayLimitFunctionWidget.this.ensureItemVisible(screenType);
            }
        };
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public String getTag() {
        return TAG;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public FunctionWidgetConfig getFunctionWidgetConfig() {
        return new FunctionWidgetConfig.Builder().dismissWhenActivityStop(false).dismissWhenScreenModeChange(false).dismissWhenVideoChange(true).dismissWhenVideoCompleted(false).persistent(true).build();
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    protected View createContentView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TintImageView tintImageView = null;
        View root = LayoutInflater.from(context).inflate(R.layout.bili_player_new_play_limit_widget, (ViewGroup) null);
        BiliImageView findViewById = root.findViewById(R.id.cover);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mCover = findViewById;
        TintImageView findViewById2 = root.findViewById(R.id.back);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mBack = findViewById2;
        TintTextView findViewById3 = root.findViewById(R.id.message);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mMessage = findViewById3;
        TintTextView findViewById4 = root.findViewById(R.id.sub_message);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mSubMessage = findViewById4;
        TintTextView findViewById5 = root.findViewById(tv.danmaku.biliplayerimpl.R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mButton = findViewById5;
        TintTextView tintTextView = this.mButton;
        if (tintTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButton");
            tintTextView = null;
        }
        tintTextView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayLimitFunctionWidget$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayLimitFunctionWidget.this.onClickButton();
            }
        });
        TintImageView tintImageView2 = this.mBack;
        if (tintImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBack");
        } else {
            tintImageView = tintImageView2;
        }
        tintImageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.biliplayerimpl.core.PlayLimitFunctionWidget$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PlayLimitFunctionWidget.this.onClickBack();
            }
        });
        Intrinsics.checkNotNull(root);
        return root;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public void onWidgetShow(AbsFunctionWidget.Configuration configuration) {
        super.onWidgetShow(configuration);
        if (configuration instanceof PlayLimitConfiguration) {
            this.mPlayLimit = ((PlayLimitConfiguration) configuration).getPlayLimit();
        }
        PlayerContainer playerContainer = this.mPlayerContainer;
        PlayerContainer playerContainer2 = null;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getControlContainerService().registerState(this.mControlContainerObserver);
        PlayerContainer playerContainer3 = this.mPlayerContainer;
        if (playerContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer3 = null;
        }
        ensureItemVisible(playerContainer3.getControlContainerService().getScreenModeType());
        PlayerContainer playerContainer4 = this.mPlayerContainer;
        if (playerContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainer2 = playerContainer4;
        }
        playerContainer2.getPlayerCoreService().pause();
        updateView();
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetDismiss() {
        super.onWidgetDismiss();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getControlContainerService().unregisterState(this.mControlContainerObserver);
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onRelease() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureItemVisible(ScreenModeType screenType) {
        TintImageView tintImageView = null;
        if (screenType == ScreenModeType.LANDSCAPE_FULLSCREEN || screenType == ScreenModeType.VERTICAL_FULLSCREEN) {
            TintImageView tintImageView2 = this.mBack;
            if (tintImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBack");
            } else {
                tintImageView = tintImageView2;
            }
            tintImageView.setVisibility(0);
            return;
        }
        TintImageView tintImageView3 = this.mBack;
        if (tintImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBack");
        } else {
            tintImageView = tintImageView3;
        }
        tintImageView.setVisibility(8);
    }

    private final void updateView() {
        String bgColor;
        ExtraInfo.PlayLimit playLimit = this.mPlayLimit;
        if (playLimit == null) {
            return;
        }
        PlayerLog.i(TAG, "playLimit, code: " + playLimit.code());
        String message = playLimit.message();
        String bgColor2 = "";
        if (message == null) {
            message = "";
        }
        PlayerContainer playerContainer = null;
        if (message.length() > 0) {
            TintTextView tintTextView = this.mMessage;
            if (tintTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMessage");
                tintTextView = null;
            }
            tintTextView.setText(message);
        } else {
            TintTextView tintTextView2 = this.mMessage;
            if (tintTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMessage");
                tintTextView2 = null;
            }
            PlayerContainer playerContainer2 = this.mPlayerContainer;
            if (playerContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer2 = null;
            }
            tintTextView2.setText(playerContainer2.getContext().getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_744));
        }
        String subMessage = playLimit.subMessage();
        if (subMessage == null) {
            subMessage = "";
        }
        if (subMessage.length() > 0) {
            TintTextView tintTextView3 = this.mSubMessage;
            if (tintTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubMessage");
                tintTextView3 = null;
            }
            if (tintTextView3.getVisibility() != 0) {
                TintTextView tintTextView4 = this.mSubMessage;
                if (tintTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubMessage");
                    tintTextView4 = null;
                }
                tintTextView4.setVisibility(0);
            }
            TintTextView tintTextView5 = this.mSubMessage;
            if (tintTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubMessage");
                tintTextView5 = null;
            }
            tintTextView5.setText(subMessage);
        } else {
            TintTextView tintTextView6 = this.mSubMessage;
            if (tintTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubMessage");
                tintTextView6 = null;
            }
            tintTextView6.setText("");
            TintTextView tintTextView7 = this.mSubMessage;
            if (tintTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubMessage");
                tintTextView7 = null;
            }
            if (tintTextView7.getVisibility() != 8) {
                TintTextView tintTextView8 = this.mSubMessage;
                if (tintTextView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubMessage");
                    tintTextView8 = null;
                }
                tintTextView8.setVisibility(8);
            }
        }
        ExtraInfo.PlayLimit.PlayLimitButton button = playLimit.button();
        String button2 = (button == null || (button2 = button.text()) == null) ? "" : "";
        if (button2.length() > 0) {
            TintTextView tintTextView9 = this.mButton;
            if (tintTextView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButton");
                tintTextView9 = null;
            }
            if (tintTextView9.getVisibility() != 0) {
                TintTextView tintTextView10 = this.mButton;
                if (tintTextView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mButton");
                    tintTextView10 = null;
                }
                tintTextView10.setVisibility(0);
            }
            TintTextView tintTextView11 = this.mButton;
            if (tintTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButton");
                tintTextView11 = null;
            }
            tintTextView11.setText(button2);
            ExtraInfo.PlayLimit.PlayLimitButton button3 = playLimit.button();
            String textColor = (button3 == null || (textColor = button3.textColor()) == null) ? "" : "";
            TintTextView tintTextView12 = this.mButton;
            if (tintTextView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButton");
                tintTextView12 = null;
            }
            PlayerContainer playerContainer3 = this.mPlayerContainer;
            if (playerContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer3 = null;
            }
            tintTextView12.setTextColor(parseStringColor(textColor, playerContainer3.getContext().getResources().getColor(17170443)));
            ExtraInfo.PlayLimit.PlayLimitButton button4 = playLimit.button();
            if (button4 != null && (bgColor = button4.bgColor()) != null) {
                bgColor2 = bgColor;
            }
            PlayerContainer playerContainer4 = this.mPlayerContainer;
            if (playerContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainer4 = null;
            }
            Drawable drawable = playerContainer4.getContext().getResources().getDrawable(tv.danmaku.biliplayer.baseres.R.drawable.shape_roundrect_pink_4);
            TintTextView tintTextView13 = this.mButton;
            if (tintTextView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButton");
                tintTextView13 = null;
            }
            Intrinsics.checkNotNull(drawable);
            PlayerContainer playerContainer5 = this.mPlayerContainer;
            if (playerContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            } else {
                playerContainer = playerContainer5;
            }
            tintTextView13.setBackground(getTintDrawable(drawable, parseStringColor(bgColor2, playerContainer.getContext().getResources().getColor(com.bilibili.app.comm.baseres.R.color.pink))));
            return;
        }
        TintTextView tintTextView14 = this.mButton;
        if (tintTextView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButton");
            tintTextView14 = null;
        }
        tintTextView14.setText("");
        TintTextView tintTextView15 = this.mButton;
        if (tintTextView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButton");
            tintTextView15 = null;
        }
        if (tintTextView15.getVisibility() != 8) {
            PlayerContainer playerContainer6 = this.mButton;
            if (playerContainer6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mButton");
            } else {
                playerContainer = playerContainer6;
            }
            playerContainer.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickBack() {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        FragmentActivity activity = ContextUtilKt.findFragmentActivityOrNull(playerContainer.getContext());
        if (activity == null) {
            return;
        }
        activity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickButton() {
        Application application;
        Context context;
        ExtraInfo.PlayLimit.PlayLimitButton button;
        ExtraInfo.PlayLimit playLimit = this.mPlayLimit;
        int code = playLimit != null ? playLimit.code() : -1;
        reportButtonClick(code);
        ExtraInfo.PlayLimit playLimit2 = this.mPlayLimit;
        String jumpLink = (playLimit2 == null || (button = playLimit2.button()) == null || (jumpLink = button.jumpLink()) == null) ? "" : "";
        if (!(jumpLink.length() > 0) || (application = BiliContext.application()) == null || (context = application.getApplicationContext()) == null) {
            return;
        }
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(jumpLink), context);
    }

    private final void reportButtonClick(int type) {
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getReporterService().report(new NeuronsEvents.NormalEvent(EventId.player_neuron_click_play_limit_button, "type", String.valueOf(type)));
    }

    private final int parseStringColor(String colorStr, int defaultColor) {
        String str = colorStr;
        if (str == null || str.length() == 0) {
            return defaultColor;
        }
        try {
            return Color.parseColor(colorStr);
        } catch (Exception e) {
            return defaultColor;
        }
    }

    private final Drawable getTintDrawable(Drawable drawable, int color) {
        Drawable wrapper = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrapper, color);
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        Intrinsics.checkNotNull(wrapper);
        return wrapper;
    }

    /* compiled from: PlayLimitFunctionWidget.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/PlayLimitFunctionWidget$PlayLimitConfiguration;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "playLimit", "Lcom/bilibili/lib/media/resource/ExtraInfo$PlayLimit;", "<init>", "(Lcom/bilibili/lib/media/resource/ExtraInfo$PlayLimit;)V", "getPlayLimit", "()Lcom/bilibili/lib/media/resource/ExtraInfo$PlayLimit;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class PlayLimitConfiguration extends AbsFunctionWidget.Configuration {
        private final ExtraInfo.PlayLimit playLimit;

        public PlayLimitConfiguration(ExtraInfo.PlayLimit playLimit) {
            Intrinsics.checkNotNullParameter(playLimit, "playLimit");
            this.playLimit = playLimit;
        }

        public final ExtraInfo.PlayLimit getPlayLimit() {
            return this.playLimit;
        }
    }

    /* compiled from: PlayLimitFunctionWidget.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/PlayLimitFunctionWidget$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}