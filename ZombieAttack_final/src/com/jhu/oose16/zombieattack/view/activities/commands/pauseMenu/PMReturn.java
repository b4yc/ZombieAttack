public class PMReturn implements PMCommand {
    public void execute(ViewComponentManager viewComponentManager, Event event, PauseMenu pm, GamePlay gp){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.RETURN_BUTTON))
						.buttonDown();
				if (MainMenu.music_sound_on) {
					MainMenu.touchSong.start();
				}
				
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				sendBroadcast(new Intent("resumeGame"));
				if (MainMenu.music_sound_on) {
					GamePlay.backGround_music.start();
				}
				Intent intent = new Intent();
				intent.setClass(PauseMenu.this, GamePlay.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);

				finish();
			}
    }
}