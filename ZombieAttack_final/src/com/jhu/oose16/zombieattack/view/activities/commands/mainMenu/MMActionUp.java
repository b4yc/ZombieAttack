public class MMActionUp implements MMCommand {
    public void execute (ViewComponentManager viewComponentManager, Event event, MainMenu mainMenu, GamePlay gamePlay){
        ((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_HIGH_SCORES_BUTTON))
					.buttonUp();
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_INFO_BUTTON))
					.buttonUp();
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_PLAY_BUTTON))
					.buttonUp();
			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_TUTORIAL_BUTTON))
					.buttonUp();
			((DoubleViewButton) viewComponentManager
					.getViewComponent(ViewComponentTypes.MAIN_MENU_MUSIC_BUTTON))
					.buttonUp();
    }
}