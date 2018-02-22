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
package poisondog.start.android.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import poisondog.Hello;
import poisondog.start.android.app.R;

/**
 * @author Adam Huang
 * @since 2018-01-10
 */
public class MainActivity extends Activity {
	private DialogInterface.OnClickListener mListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Hello var = new Hello();
		TextView text = (TextView) findViewById(R.id.content);
		text.setText(var.get());
	}
}
