package mx.edu.utng.divinaphpsql;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by MD on 3/6/2016.
 */
public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity_layout);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        String url = getIntent().getStringExtra("url");

        switch (url) {
            case "PHP":
                Uri uri = Uri.parse("rtsp://r4---sn-q4fl6n7d.googlevideo.com/Cj0LENy73wIaNAkY01pHRgPaPhMYDSANFC3HWyVXMOCoAUIASARgkdn9t5bP4t5WigELZVpsekxuZVBLeGsM/94289C253F903C7564143CC0289CA8D7704435B6.11E9135F2F565CFEA63824D8410546760AE649F3/yt6/1/video.3gp");
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
                break;
            case "MySQL":
                Uri uri1 = Uri.parse("rtsp://r5---sn-q4f7sn76.googlevideo.com/Cj0LENy73wIaNAnuylteqbr7yBMYDSANFC13YSVXMOCoAUIASARgkdn9t5bP4t5WigELZVpsekxuZVBLeGsM/8E93C8ECA37CCE926807DC46578BD00DB396CB62.2CDD8D08B64F219841C56D3B4C91038092441C1E/yt6/1/video.3gp");
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri1);
                videoView.requestFocus();
                videoView.start();
                break;
            case "PHP y MySQL":
                Uri uri2 = Uri.parse("rtsp://r1---sn-q4fl6ne7.googlevideo.com/Cj0LENy73wIaNAnT56RQv7L8jRMYDSANFC0mYSVXMOCoAUIASARgkdn9t5bP4t5WigELZVpsekxuZVBLeGsM/05DE50E03EE5E0C9BB735ABC55E434C2DCD27B51.9DB8FE57EE63BDD2365AFCDFCBC231D7AEE377A0/yt6/1/video.3gp");
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri2);
                videoView.requestFocus();
                videoView.start();
                break;
            case "Promocion":
                Uri uri3 = Uri.parse("rtsp://r6---sn-q4fl6ne7.googlevideo.com/Cj0LENy73wIaNAm_4bY_1gSAFBMYDSANFC3CRShXMOCoAUIASARgkdn9t5bP4t5WigELZVpsekxuZVBLeGsM/34E8D9E942DAA48A3D31F868746C8CDFEE805A2A.30F9463A86D1833B56D7DF5B4622D3A2ED8C6783/yt6/1/video.3gp");
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri3);
                videoView.requestFocus();
                videoView.start();
                break;
        }
    }
}