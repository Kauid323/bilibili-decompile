package faceverify;

import com.dtf.face.ToygerConfig;
import com.dtf.face.ToygerPresenter;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.Upload;

public class c implements Runnable {
    public final /* synthetic */ ToygerPresenter a;

    public c(ToygerPresenter toygerPresenter) {
        this.a = toygerPresenter;
    }

    @Override // java.lang.Runnable
    public void run() {
        AndroidClientConfig androidClientConfig = ToygerConfig.getInstance().getAndroidClientConfig();
        Upload upload = androidClientConfig != null ? androidClientConfig.getUpload() : null;
        if (upload != null && !upload.photinusPicture) {
            this.a.A.takeNoPhotoAndComplete();
            return;
        }
        ToygerPresenter toygerPresenter = this.a;
        toygerPresenter.A.takePhoto(toygerPresenter.a.getCamera(), ToygerConfig.getInstance().getContext());
    }
}