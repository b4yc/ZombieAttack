public class PMActionUp implements PMCommand {
    public void execute(ViewComponentManager viewComponentManager, Event event, PauseMenu pm, GamePlay gp){
       ((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.RETURN_BUTTON))
					.buttonUp();

			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.RETRY_BUTTON))
					.buttonUp();

			((Button) viewComponentManager
					.getViewComponent(ViewComponentTypes.RETURN_MAIN_MENU_BUTTON))
					.buttonUp();
    }
}