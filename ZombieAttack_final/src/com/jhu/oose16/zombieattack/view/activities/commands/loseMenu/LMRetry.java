public class LMRetry implements LMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.RETRY_BUTTON))
						.buttonDown();
				if (MainMenu.music_sound_on) {
					MainMenu.touchSong.start();
				}
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				sendBroadcast(new Intent("retryGame"));

				Intent intent = new Intent();
				intent.setClass(LoseMenu.this, GamePlay.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				
				GamePlay.backGround_music = MediaPlayer.create(LoseMenu.this, R.raw.scare_song);
				GamePlay.backGround_music.setVolume(100, 100);
				GamePlay.backGround_music.start();
				
				finish();
			}
    }
}