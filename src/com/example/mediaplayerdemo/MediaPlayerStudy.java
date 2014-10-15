package com.example.mediaplayerdemo;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MediaPlayerStudy extends Activity {
	private Button bplay, bpause, bstop;
	private MediaPlayer mp = new MediaPlayer();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bplay = (Button) findViewById(R.id.play);
		bpause = (Button) findViewById(R.id.pause);
		bstop = (Button) findViewById(R.id.stop);
		try {
			mp.setDataSource("/sdcard/test.mp3");
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bplay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					mp.prepare();
					mp.start();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				mp.setOnCompletionListener(new OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						mp.release();
					}
				});
			}
		});

		bpause.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mp != null) {
					mp.pause();
				}
			}
		});

		bstop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mp != null) {
					mp.release();
					try {
						mp.setDataSource("/sdcard/test.mp3");
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		if (mp != null)
			mp.release();
		super.onDestroy();
	}
}
