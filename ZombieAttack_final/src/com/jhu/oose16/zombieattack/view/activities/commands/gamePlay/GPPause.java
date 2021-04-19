public class GPPause implements GPCommand {
    public void execute (ViewComponentManager viewComponentManager, MotionEvent event, MainMenu){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
			((Button) viewComponentManager.getViewComponent(ViewComponentTypes.GAME_PLAY_PAUSE_BUTTON)).buttonDown();
			if (MainMenu.music_sound_on) {
				MainMenu.touchSong.start();
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			backGround_music.pause();
			Intent intent = new Intent();
			intent.setClass(GamePlay.this, PauseMenu.class);
			startActivity(intent);
			gameModel.pauseGame();
        }
    }
}