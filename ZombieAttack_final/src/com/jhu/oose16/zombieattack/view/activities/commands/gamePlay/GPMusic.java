public class GPMusic extends GPCommand {
    public void execute(ViewComponentManager viewComponentManager, Event event){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
			((DoubleViewButton) viewComponentManager.getViewComponent(ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON)).buttonDown();
			if (MainMenu.music_sound_on) {
				MainMenu.touchSong.start();
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			((DoubleViewButton) viewComponentManager.getViewComponent(ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON)).changeButton();
			MainMenu.music_sound_on = !MainMenu.music_sound_on;
			if(!MainMenu.music_sound_on) {
				backGround_music.pause();
			}
			else {
				backGround_music = MediaPlayer.create(GamePlay.this, R.raw.scare_song);
				backGround_music.setVolume(100, 100);
				backGround_music.start();
			}
		}
    }
}