package tv.danmaku.bili.ui.main2.resource;

import tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout;

public class HomeNoLoginAvatar {
    public static final int AVATAR_TYPE_IMG = 0;
    public static final int AVATAR_TYPE_LOTTIE = 1;
    public VerifyAnimationAvatarFrameLayout.VType type;
    public String url;

    public HomeNoLoginAvatar(String url, int type) {
        this.url = url;
        if (type == 1) {
            this.type = VerifyAnimationAvatarFrameLayout.VType.LOTTIE;
        } else {
            this.type = VerifyAnimationAvatarFrameLayout.VType.IMG;
        }
    }
}