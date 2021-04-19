public class CMMainMenuActionDown implements CMCommand {
    public void execute(Button b, MainMenu m) {
        ((Button) viewComponentManager.getViewComponent(ViewComponentTypes.RETURN_MAIN_MENU_BUTTON)).buttonDown();
		if (MainMenu.music_sound_on) {
			MainMenu.touchSong.start();
		}
    }
}