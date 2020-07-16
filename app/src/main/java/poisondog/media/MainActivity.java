/*
 * Copyright (C) 2018 Adam Huang <poisondog@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package poisondog.android.media;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceView;
import java.io.IOException;

/**
 * @author Adam Huang
 * @since 2020-07-16
 */
public class MainActivity extends Activity {
	private DialogInterface.OnClickListener mListener;
	private MediaPlayer mPlayer;
	private SurfaceView mPreview;
	private String mUrl = "https://videos.files.wordpress.com/gDGhZoCH/cv-triangle-trial_spot-official_en_hd.mp4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mPreview = (SurfaceView)findViewById(R.id.surfaceView);

		mPlayer = new MediaPlayer();
		mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			public void onPrepared(MediaPlayer mp) {
				mPlayer.setDisplay(mPreview.getHolder());
				mPlayer.start();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		try {
			mPlayer.setDataSource(mUrl);
			mPlayer.prepareAsync();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mPlayer.isPlaying())
			mPlayer.stop();
	}
}
