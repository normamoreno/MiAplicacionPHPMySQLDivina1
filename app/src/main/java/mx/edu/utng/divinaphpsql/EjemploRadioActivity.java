package mx.edu.utng.divinaphpsql;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class EjemploRadioActivity extends Activity implements OnPreparedListener, OnErrorListener{

	private String TAG = getClass().getSimpleName();
	private Button stop;
	private ToggleButton playtogglebutton;
	private TextView timeEnd, timeElapsed;
	private ProgressBar progressBar, loading;
	private MyVideoView videoviewer;
	private CountDownTimer timer;
	private int mVideoWidth, mVideoHeight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println(getString(R.string.orientation) +"--------------------------orientation value");
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		setContentView(R.layout.activity_ejemplo_radio);
		
		loading = (ProgressBar) findViewById(R.id.loading);
	     
		stop = (Button) findViewById(R.id.stop);
		playtogglebutton = (ToggleButton) findViewById(R.id.playtogglebutton);
		timeElapsed = (TextView) findViewById(R.id.timeElapsed);
		timeEnd = (TextView) findViewById(R.id.timeEnd);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
			
		
		
		videoviewer = (MyVideoView) findViewById(R.id.videoviewer);
		videoviewer.setVideoURI(Uri.parse("http://www.ooklnet.com/files/381/381489/video.mp4"));
		videoviewer.requestFocus();
		videoviewer.setKeepScreenOn(true);
		videoviewer.setOnErrorListener(this);
		videoviewer.setOnPreparedListener(this);
		//loading.show();
		
		/*stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				stopMedia();
			}
		});*/
	}
	
	private OnClickListener stoplistener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			stopMedia();
		}
	};

	private OnCheckedChangeListener checkedchangelistener =  new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
			// TODO Auto-generated method stub
			/*pause player*/
			if(isChecked){
				System.out.println("player pause");
				playMedia(false);
			}
			/*play player*/
			else{
				System.out.println("player play");
				playMedia(true);
			}
		}};
		
		@Override
		public boolean onError(MediaPlayer mp, int what, int extra) {
			// TODO Auto-generated method stub
			//loading.hide();
			return false;
		}
		
	@Override
	public void onPrepared(MediaPlayer mp) {
		// TODO Auto-generated method stub
		Log.d(TAG, "media player preparing.......");
		mp.setLooping(true);
		//loading.hide();
		playtogglebutton.setOnCheckedChangeListener(checkedchangelistener);
		stop.setOnClickListener(stoplistener);
		loading.setVisibility(View.GONE);

		mVideoWidth = mp.getVideoWidth();
        mVideoHeight = mp.getVideoHeight();
		//onVideoSizeChangedListener declaration
		mp.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
			
			@Override
			public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
				// TODO Auto-generated method stub
				Log.d(TAG, "onVideoSizeChanged called " + width + ":" + height);
				if (width == 0 || height == 0) {
		            Log.e(TAG, "invalid video width(" + width + ") or height(" + height + ")");
		            return;
		        }
		        mVideoWidth = width;
		        mVideoHeight = height;
		        playMedia(true);
			}
		});
		// onSeekCompletionListener declaration
		mp.setOnSeekCompleteListener(new OnSeekCompleteListener() {
			// show current frame after changing the playback position
			@Override
			public void onSeekComplete(MediaPlayer mp) {
				if (!mp.isPlaying()) {
					//playMedia(true);
					System.out.println("inside the setOnSeekCompleteListener");
					playMedia(false);
				}
				System.out.println("inside------ the setOnSeekCompleteListener");
				timeElapsed.setText(countTime(videoviewer.getCurrentPosition()));
			}
		});

		mp.setOnCompletionListener(null);
		// onBufferingUpdateListener declaration
		mp.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {
			// show updated information about the buffering progress
			@Override
			public void onBufferingUpdate(MediaPlayer mp, int percent) {
				Log.d(TAG, "percent: " + percent);
				progressBar.setSecondaryProgress(percent);
			}
		});
		

		int time = videoviewer.getDuration();
		int time_elapsed = videoviewer.getCurrentPosition();
		progressBar.setProgress(time_elapsed);

		// update current playback time every 500ms until stop
		timer = new CountDownTimer(time, 500) {

			@Override
			public void onTick(long millisUntilFinished) {
				timeElapsed.setText(countTime(videoviewer.getCurrentPosition()));
				float a = videoviewer.getCurrentPosition();
				float b = videoviewer.getDuration();
				progressBar.setProgress((int) (a / b * 100));
			}

			@Override
			public void onFinish() {
				stopMedia();
			}
		};

		
		
		timeEnd.setText(countTime(time));
		timeElapsed.setText(countTime(time_elapsed));
		playMedia(true);
	}

	/**
     * Convert time from milliseconds into minutes and seconds, proper to media player
     * 
     * @param miliseconds	media content time in milliseconds
     * @return	time in format minutes:seconds
     */
    public String countTime(int miliseconds) {
    	String timeInMinutes = new String();
    	int minutes = miliseconds / 60000;
    	int seconds = (miliseconds % 60000)/1000;
    	timeInMinutes = minutes + ":" + (seconds<10?"0" + seconds:seconds);
		return timeInMinutes;
    }

	public void playMedia(boolean isplay) {
		System.err.println("height:- "+mVideoHeight);
		System.err.println("width:- "+mVideoWidth);
			if (isplay) {
				videoviewer.changeVideoSize(mVideoWidth, mVideoHeight);
				videoviewer.start();
				timer.start();
			} else {
				videoviewer.pause();
				timer.cancel();
			}
		
    }
	public void stopMedia() {
		if (videoviewer.getCurrentPosition() != 0) {
			
			playtogglebutton.setChecked(true);
			
			videoviewer.pause();
			videoviewer.seekTo(0);
			timer.cancel();

			timeElapsed.setText(countTime(videoviewer.getCurrentPosition()));
			progressBar.setProgress(0);
		}
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		if(videoviewer != null)
			videoviewer.stopPlayback();
		if (timer != null) {
			timer.cancel();
		}
		super.onStop();
	}

	

	

}