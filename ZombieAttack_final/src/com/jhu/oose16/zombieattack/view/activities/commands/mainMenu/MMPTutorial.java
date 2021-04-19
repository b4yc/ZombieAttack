public class MMTutorial implements MMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event, MainMenu mainMenu, GamePlay gamePlay){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((Button) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_TUTORIAL_BUTTON))
						.buttonDown();
				if (music_sound_on) {
					touchSong.start();
				}
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, TutorialMenu.class);
				startActivity(intent);
			}
    }
}