package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.playerbizcommon.widget.control.HighEnergySeekWidget;
import com.bilibili.playerbizcommon.widget.control.PlayerBackWidget;
import com.bilibili.playerbizcommon.widget.control.PlayerPlayPauseWidget;
import com.bilibili.playerbizcommon.widget.control.PlayerProgressTextWidget;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.videospace.AuthorFullscreenWidget;
import tv.danmaku.bili.ui.videospace.NormalPlayerInsetControllerWidget;

public final class BiliPlayerControllerHalfScreenBinding implements ViewBinding {
    public final PlayerBackWidget bbplayerFullscreenBack;
    public final PlayerPlayPauseWidget bbplayerFullscreenPlay;
    public final AuthorFullscreenWidget bbplayerHalfscreenExpand;
    public final NormalPlayerInsetControllerWidget playerConstraintLayout;
    public final LinearLayout playerContainerProgressbar;
    public final RelativeLayout playerContainerTop;
    public final HighEnergySeekWidget playerWidgetProgressbar;
    public final PlayerProgressTextWidget playerWidgetTimer;
    private final NormalPlayerInsetControllerWidget rootView;

    private BiliPlayerControllerHalfScreenBinding(NormalPlayerInsetControllerWidget rootView, PlayerBackWidget bbplayerFullscreenBack, PlayerPlayPauseWidget bbplayerFullscreenPlay, AuthorFullscreenWidget bbplayerHalfscreenExpand, NormalPlayerInsetControllerWidget playerConstraintLayout, LinearLayout playerContainerProgressbar, RelativeLayout playerContainerTop, HighEnergySeekWidget playerWidgetProgressbar, PlayerProgressTextWidget playerWidgetTimer) {
        this.rootView = rootView;
        this.bbplayerFullscreenBack = bbplayerFullscreenBack;
        this.bbplayerFullscreenPlay = bbplayerFullscreenPlay;
        this.bbplayerHalfscreenExpand = bbplayerHalfscreenExpand;
        this.playerConstraintLayout = playerConstraintLayout;
        this.playerContainerProgressbar = playerContainerProgressbar;
        this.playerContainerTop = playerContainerTop;
        this.playerWidgetProgressbar = playerWidgetProgressbar;
        this.playerWidgetTimer = playerWidgetTimer;
    }

    public NormalPlayerInsetControllerWidget getRoot() {
        return this.rootView;
    }

    public static BiliPlayerControllerHalfScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliPlayerControllerHalfScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_player_controller_half_screen, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliPlayerControllerHalfScreenBinding bind(View rootView) {
        PlayerPlayPauseWidget bbplayerFullscreenPlay;
        AuthorFullscreenWidget bbplayerHalfscreenExpand;
        HighEnergySeekWidget playerWidgetProgressbar;
        PlayerProgressTextWidget playerWidgetTimer;
        int id = R.id.bbplayer_fullscreen_back;
        PlayerBackWidget bbplayerFullscreenBack = ViewBindings.findChildViewById(rootView, id);
        if (bbplayerFullscreenBack != null && (bbplayerFullscreenPlay = ViewBindings.findChildViewById(rootView, (id = R.id.bbplayer_fullscreen_play))) != null && (bbplayerHalfscreenExpand = ViewBindings.findChildViewById(rootView, (id = R.id.bbplayer_halfscreen_expand))) != null) {
            NormalPlayerInsetControllerWidget playerConstraintLayout = (NormalPlayerInsetControllerWidget) rootView;
            id = R.id.player_container_progressbar;
            LinearLayout playerContainerProgressbar = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
            if (playerContainerProgressbar != null) {
                id = R.id.player_container_top;
                RelativeLayout playerContainerTop = (RelativeLayout) ViewBindings.findChildViewById(rootView, id);
                if (playerContainerTop != null && (playerWidgetProgressbar = ViewBindings.findChildViewById(rootView, (id = R.id.player_widget_progressbar))) != null && (playerWidgetTimer = ViewBindings.findChildViewById(rootView, (id = R.id.player_widget_timer))) != null) {
                    return new BiliPlayerControllerHalfScreenBinding((NormalPlayerInsetControllerWidget) rootView, bbplayerFullscreenBack, bbplayerFullscreenPlay, bbplayerHalfscreenExpand, playerConstraintLayout, playerContainerProgressbar, playerContainerTop, playerWidgetProgressbar, playerWidgetTimer);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}