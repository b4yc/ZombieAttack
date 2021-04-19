public class GPActionUp extends GPCommand {
    public void execute(ViewComponentManager viewComponentManager){
        ((Button) viewComponentManager.getViewComponent(ViewComponentTypes.GAME_PLAY_PAUSE_BUTTON)).buttonUp();
		((DoubleViewButton) viewComponentManager.getViewComponent(ViewComponentTypes.GAME_PLAY_MUSIC_BUTTON)).buttonUp();
    }
}