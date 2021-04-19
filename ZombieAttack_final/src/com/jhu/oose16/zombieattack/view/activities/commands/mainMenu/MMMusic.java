public class MMMusic implements MMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event, MainMenu mainMenu, GamePlay gamePlay){
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
				((DoubleViewButton) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON))
						.buttonDown();
				music_sound_on = !music_sound_on;
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				((DoubleViewButton) viewComponentManager
						.getViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON))
						.changeButton();
			}
    }
}