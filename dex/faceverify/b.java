package faceverify;

import com.dtf.face.ToygerPresenter;
import com.tencent.smtt.sdk.TbsMediaPlayer;

public class b implements j {
    public final /* synthetic */ ToygerPresenter a;

    public b(ToygerPresenter toygerPresenter) {
        this.a = toygerPresenter;
    }

    @Override // faceverify.j
    public void a(String str, String str2) {
        this.a.d();
        ToygerPresenter toygerPresenter = this.a;
        toygerPresenter.e.f1939i = str;
        toygerPresenter.d((int) TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT);
    }

    @Override // faceverify.j
    public void a() {
        ToygerPresenter toygerPresenter = this.a;
        toygerPresenter.e.f1939i = null;
        toygerPresenter.d((int) TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_SUBTITLE_TIMED_OUT);
    }
}