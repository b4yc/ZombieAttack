public class MMHighScores implements MMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event, MainMenu mainMenu, GamePlay gamePlay){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_HIGH_SCORES_BUTTON))
						.buttonDown();
				if (music_sound_on) {
					touchSong.start();
				}
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, HighScoresMenu.class);
				startActivity(intent);
			}
    }
}