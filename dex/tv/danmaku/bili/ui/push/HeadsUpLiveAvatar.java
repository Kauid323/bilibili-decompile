package tv.danmaku.bili.ui.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HeadsUpLiveAvatar.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/push/HeadsUpLiveAvatar;", "", "stub", "Landroid/view/ViewStub;", "<init>", "(Landroid/view/ViewStub;)V", "rootView", "Landroid/view/View;", "animations", "", "Ltv/danmaku/bili/widget/avatar/LivingAvatarAnimationView;", "[Ltv/danmaku/bili/widget/avatar/LivingAvatarAnimationView;", "waveGroup", "Landroidx/constraintlayout/widget/Group;", "tagGroup", "avatar", "Lcom/bilibili/lib/image2/view/BiliImageView;", "avatarContainer", "tagBackground", "setVisible", "", "value", "", "setup", "context", "Landroid/content/Context;", "url", "", "liveBorderEnable", "liveMarkerEnable", "onThemeChanged", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class HeadsUpLiveAvatar {
    public static final int $stable = 8;
    private final LivingAvatarAnimationView[] animations;
    private final BiliImageView avatar;
    private final View avatarContainer;
    private final View rootView;
    private final View tagBackground;
    private final Group tagGroup;
    private final Group waveGroup;

    /* JADX WARN: Multi-variable type inference failed */
    public HeadsUpLiveAvatar(ViewStub stub) {
        LivingAvatarAnimationView[] livingAvatarAnimationViewArr;
        Intrinsics.checkNotNullParameter(stub, "stub");
        View inflate = stub.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.rootView = inflate;
        View findViewById = this.rootView.findViewById(R.id.inner_push_live_animation1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = this.rootView.findViewById(R.id.inner_push_live_animation2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.animations = new LivingAvatarAnimationView[]{findViewById, findViewById2};
        Group findViewById3 = this.rootView.findViewById(R.id.inner_push_live_wave_group);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.waveGroup = findViewById3;
        Group findViewById4 = this.rootView.findViewById(R.id.inner_push_live_tag_group);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.tagGroup = findViewById4;
        BiliImageView findViewById5 = this.rootView.findViewById(R.id.inner_push_live_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.avatar = findViewById5;
        View findViewById6 = this.rootView.findViewById(R.id.inner_push_live_avatar_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.avatarContainer = findViewById6;
        View findViewById7 = this.rootView.findViewById(R.id.inner_push_live_tag_background);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.tagBackground = findViewById7;
        Resources resources = this.rootView.getResources();
        for (LivingAvatarAnimationView anim : this.animations) {
            anim.update(resources.getDimensionPixelSize(R.dimen.bili_inner_push_live_avatar_border_width), resources.getDimensionPixelSize(R.dimen.bili_inner_push_live_avatar_anim_begin) / 2, resources.getDimensionPixelSize(R.dimen.bili_inner_push_live_avatar_anim_end) / 2);
            anim.setRepeat(true);
        }
        this.animations[0].setOnAnimationStartListener(new LivingAvatarAnimationView.OnAnimationStartListener() { // from class: tv.danmaku.bili.ui.push.HeadsUpLiveAvatar$$ExternalSyntheticLambda0
            @Override // tv.danmaku.bili.widget.avatar.LivingAvatarAnimationView.OnAnimationStartListener
            public final void onStart() {
                HeadsUpLiveAvatar._init_$lambda$0(HeadsUpLiveAvatar.this);
            }
        });
        this.waveGroup.setReferencedIds(new int[]{R.id.inner_push_live_animation1, R.id.inner_push_live_animation2});
        this.tagGroup.setReferencedIds(new int[]{R.id.inner_push_live_tag_text, R.id.inner_push_live_tag_animation, R.id.inner_push_live_tag_background});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(HeadsUpLiveAvatar this$0) {
        this$0.animations[1].startAnimation(500L);
    }

    public final void setVisible(boolean value) {
        this.rootView.setVisibility(value ? 0 : 8);
    }

    public final void setup(Context context, String url, boolean liveBorderEnable, boolean liveMarkerEnable) {
        LivingAvatarAnimationView[] livingAvatarAnimationViewArr;
        Intrinsics.checkNotNullParameter(context, "context");
        if (liveBorderEnable) {
            this.waveGroup.setVisibility(0);
            this.animations[0].startAnimation();
            this.avatarContainer.setBackground(ContextCompat.getDrawable(this.rootView.getContext(), R.drawable.bili_shape_inner_push_live_avatar_background));
        } else {
            this.waveGroup.setVisibility(8);
            for (LivingAvatarAnimationView anim : this.animations) {
                anim.stopAnimation();
            }
            this.avatarContainer.setBackground(null);
        }
        ImageRequestBuilder.enableAutoPlayAnimation$default(BiliImageLoader.INSTANCE.with(context).url(url), true, false, 2, (Object) null).into(this.avatar);
        this.tagGroup.setVisibility(liveMarkerEnable ? 0 : 8);
    }

    public final void onThemeChanged() {
        this.tagBackground.setBackground(ContextCompat.getDrawable(this.rootView.getContext(), R.drawable.bili_shape_inner_push_live_tag_background));
        if (this.avatarContainer.getBackground() != null) {
            this.avatarContainer.setBackground(ContextCompat.getDrawable(this.rootView.getContext(), R.drawable.bili_shape_inner_push_live_avatar_background));
        }
        BiliImageView.setImageTint$default(this.avatar, com.bilibili.lib.widget.R.color.auto_night_shade, (PorterDuff.Mode) null, 2, (Object) null);
    }
}